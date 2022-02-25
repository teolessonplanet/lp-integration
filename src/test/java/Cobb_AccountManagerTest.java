import com.lessonplanet.pages.AddADistrictAdminModal;
import com.lessonplanet.pages.DistrictPage;
import com.lessonplanet.pages.ManageDistrictAdminsPage;
import com.lessonplanet.pages.SchoolPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import util.TestData;

public class Cobb_AccountManagerTest extends BaseTest {
    private SchoolPage schoolPage;
    private DistrictPage districtPage;
    private ManageDistrictAdminsPage manageDistrictAdminsPage;
    private RSL_AccountManagerTest rsl_accountManagerTest;
    private AddADistrictAdminModal addADistrictAdminModal;
    private CSL_AccountManagerSsoOnTest csl_accountManagerSsoOnTest;

    @BeforeMethod(alwaysRun = true)
    public void beforeMethod() {
        schoolPage = new SchoolPage(webDriver);
        districtPage = new DistrictPage(webDriver);
        manageDistrictAdminsPage = new ManageDistrictAdminsPage(webDriver);
        rsl_accountManagerTest = new RSL_AccountManagerTest();
        csl_accountManagerSsoOnTest = new CSL_AccountManagerSsoOnTest();
        addADistrictAdminModal = new AddADistrictAdminModal(webDriver);
    }

    @Test(description = "Cobb SL - Account Manager - C2603:District Page", groups = {"cobb"})
    public void testC2603() {
        rsl_accountManagerTest.initAndReachRSLAccountManagerTest(webDriver);
        rsl_accountManagerTest.reachAccountManagerPage(TestData.VALID_EMAIL_CSL_COBB, TestData.VALID_PASSWORD);
        rsl_accountManagerTest.testDistrictPage(true);
        districtPage.hoverOverAddButton();
        Assert.assertEquals(districtPage.getAddButtonPopoverText(), TestData.ADD_SCHOOLS_ROSTER_ON_BUTTON_POPOVER_TEXT);
    }

    @Test(description = "Cobb SL - Account Manager - C2604:Edit District, Search in District", groups = {"cobb"})
    public void testC2604() {
        rsl_accountManagerTest.initAndReachRSLAccountManagerTest(webDriver);
        rsl_accountManagerTest.reachAccountManagerPage(TestData.VALID_EMAIL_CSL_COBB, TestData.VALID_PASSWORD);
        rsl_accountManagerTest.testEditDistrict(TestData.CSL_COBB_SCHOOL_DISTRICT_NAME, true, true);
        rsl_accountManagerTest.testSearchButtonFromDistrictPage(TestData.VALID_EMAIL_CSL_COBB, true);
        rsl_accountManagerTest.testSearchButtonFromDistrictPage(TestData.PLAN_VISITOR, true);
        rsl_accountManagerTest.testSearchButtonFromDistrictPage(TestData.CSL_COBB_TEACHER_LAST_NAME, true);
        rsl_accountManagerTest.testSearchButtonFromDistrictPage(TestData.CSL_COBB_OWNER_FIRST_NAME + " " + TestData.CSL_COBB_OWNER_LAST_NAME, true);
    }

    @Test(description = "Cobb SL - Account Manager - C2606:Manage District Admins Page: Add District Admins, Edit District Admin, Remove District Admins", groups = {"cobb"})
    public void testC2606() {
        rsl_accountManagerTest.initAndReachRSLAccountManagerTest(webDriver);
        rsl_accountManagerTest.reachAccountManagerPage(TestData.VALID_EMAIL_CSL_COBB, TestData.VALID_PASSWORD);
        rsl_accountManagerTest.testManageDistrictAdminsPage(TestData.VALID_EMAIL_CSL_COBB, true, true);
        manageDistrictAdminsPage.clickOnAddAdminLink();
        addADistrictAdminModal.typeEmail(TestData.GET_NEW_EMAIL());
        addADistrictAdminModal.clickOnAddButton();
        Assert.assertTrue(manageDistrictAdminsPage.getNotificationText().contains(TestData.ADD_DISTRICT_ADMIN_ROSTER_ON_NOTIFICATION_TEXT));
        districtPage.dismissNotification();
        rsl_accountManagerTest.testAddDistrictAdmin(TestData.CSL_COBB_EXISTING_TEACHER_EMAIL, true);
        csl_accountManagerSsoOnTest.initAndReachCSLAccountManagerSsoOnTest(webDriver);
        csl_accountManagerSsoOnTest.testEditDistrictAdmin();
        csl_accountManagerSsoOnTest.testEditOwner();
        rsl_accountManagerTest.testRemoveDistrictAdmin(TestData.CSL_COBB_SCHOOL_DISTRICT_NAME);
    }

    @Test(description = "Cobb SL - Account Manager - C2607:School Page: Add teacher, Edit Teacher, Remove Teacher", groups = {"cobb"})
    public void testC2607() {
        rsl_accountManagerTest.initAndReachRSLAccountManagerTest(webDriver);
        rsl_accountManagerTest.reachAccountManagerPage(TestData.VALID_EMAIL_CSL_COBB, TestData.VALID_PASSWORD);
        districtPage.clickOnSchool(0);
        rsl_accountManagerTest.testSchoolPage(true, true);
        schoolPage.hoverOverAddButton();
        Assert.assertEquals(schoolPage.getAddButtonPopoverText(), TestData.ADD_TEACHERS_BUTTON_ROSTER_ON_POPOVER_TEXT);
        rsl_accountManagerTest.testEditTeacher();
    }

    @Test(description = "Cobb SL - Account Manager - C2608:Edit School, Search in school", groups = {"cobb"})
    public void testC2608() {
        rsl_accountManagerTest.initAndReachRSLAccountManagerTest(webDriver);
        rsl_accountManagerTest.reachAccountManagerPage(TestData.VALID_EMAIL_CSL_COBB, TestData.VALID_PASSWORD);
        rsl_accountManagerTest.testEditSchoolFromActionsButton(TestData.GET_NEW_SCHOOL_NAME(), TestData.CSL_COBB_SCHOOL_DISTRICT_EXISTING_SCHOOL_NAME, true, true);
        rsl_accountManagerTest.testEditSchoolFromEditOrganizationButton(TestData.GET_NEW_SCHOOL_NAME(), TestData.CSL_COBB_SCHOOL_DISTRICT_EXISTING_SCHOOL_NAME, true, true);
        rsl_accountManagerTest.testSearchButtonFromSchoolPage(TestData.CSL_COBB_EXISTING_TEACHER_EMAIL, true);
        rsl_accountManagerTest.testSearchButtonFromSchoolPage(TestData.PLAN_VISITOR, true);
        rsl_accountManagerTest.testSearchButtonFromSchoolPage(TestData.CSL_COBB_TEACHER_FIRST_NAME, true);
        rsl_accountManagerTest.testSearchButtonFromSchoolPage(TestData.CSL_COBB_TEACHER_FIRST_NAME + " " + TestData.CSL_COBB_TEACHER_LAST_NAME, true);
    }

    @Test(description = "Cobb SL - Account Manager - C2609:Manage School Admins Page: Add School Admins, Edit School Admin Remove School Admins", groups = {"cobb"})
    public void testC2609() {
        rsl_accountManagerTest.initAndReachRSLAccountManagerTest(webDriver);
        rsl_accountManagerTest.reachAccountManagerPage(TestData.VALID_EMAIL_CSL_COBB, TestData.VALID_PASSWORD);
        districtPage.clickOnSchool(0);
        schoolPage.clickOnManageDistrictButton();
        rsl_accountManagerTest.testManageSchoolAdminPage(true, true);
    }

    @Test(description = "Cobb SL - Account Manager - C2605: Manage District Page", groups = {"cobb"})
    public void testC2605() {
        rsl_accountManagerTest.initAndReachRSLAccountManagerTest(webDriver);
        rsl_accountManagerTest.reachAccountManagerPage(TestData.VALID_EMAIL_CSL_COBB, TestData.VALID_PASSWORD);
        rsl_accountManagerTest.testManageDistrictPage(true);
    }
}
