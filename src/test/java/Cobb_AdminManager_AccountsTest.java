import com.lessonplanet.pages.AddADistrictAdminModal;
import com.lessonplanet.pages.DistrictPage;
import com.lessonplanet.pages.ManageDistrictAdminsPage;
import com.lessonplanet.pages.SchoolPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import util.TestData;

public class Cobb_AdminManager_AccountsTest extends BaseTest {
    private SchoolPage schoolPage;
    private DistrictPage districtPage;
    private ManageDistrictAdminsPage manageDistrictAdminsPage;
    private RSL_AdminManager_AccountsTest rsl_adminManagerAccountsTest;
    private AddADistrictAdminModal addADistrictAdminModal;
    private CSL_AdminManager_AccountsSsoOnTest csl_adminManagerAccountsSsoOnTest;

    @BeforeMethod(alwaysRun = true)
    public void beforeMethod() {
        schoolPage = new SchoolPage(webDriver);
        districtPage = new DistrictPage(webDriver);
        manageDistrictAdminsPage = new ManageDistrictAdminsPage(webDriver);
        rsl_adminManagerAccountsTest = new RSL_AdminManager_AccountsTest();
        csl_adminManagerAccountsSsoOnTest = new CSL_AdminManager_AccountsSsoOnTest();
        addADistrictAdminModal = new AddADistrictAdminModal(webDriver);
    }

    @Test(description = "Cobb SL - Admin Manager - Accounts - C2603: District Page", groups = {"cobb"})
    public void testC2603() {
        rsl_adminManagerAccountsTest.initAndReachRSLAccountManagerTest(webDriver);
        rsl_adminManagerAccountsTest.reachAccountManagerPage(TestData.VALID_EMAIL_CSL_COBB, TestData.VALID_PASSWORD);
        rsl_adminManagerAccountsTest.testDistrictPage(true);
        districtPage.hoverOverAddButton();
        Assert.assertEquals(districtPage.getAddButtonPopoverText(), TestData.ADD_SCHOOLS_ROSTER_ON_BUTTON_POPOVER_TEXT);
    }

    @Test(description = "Cobb SL - Admin Manager - Accounts - C2604: Edit District, Search in District", groups = {"cobb"})
    public void testC2604() {
        rsl_adminManagerAccountsTest.initAndReachRSLAccountManagerTest(webDriver);
        rsl_adminManagerAccountsTest.reachAccountManagerPage(TestData.VALID_EMAIL_CSL_COBB, TestData.VALID_PASSWORD);
        rsl_adminManagerAccountsTest.testEditDistrict(TestData.CSL_COBB_SCHOOL_DISTRICT_NAME, true, true);
        rsl_adminManagerAccountsTest.testSearchButtonFromDistrictPage(TestData.VALID_EMAIL_CSL_COBB, true);
        rsl_adminManagerAccountsTest.testSearchButtonFromDistrictPage(TestData.PLAN_VISITOR, true);
        rsl_adminManagerAccountsTest.testSearchButtonFromDistrictPage(TestData.CSL_COBB_TEACHER_LAST_NAME, true);
        rsl_adminManagerAccountsTest.testSearchButtonFromDistrictPage(TestData.CSL_COBB_OWNER_FIRST_NAME + " " + TestData.CSL_COBB_OWNER_LAST_NAME, true);
    }

    @Test(description = "Cobb SL - Admin Manager - Accounts - C2606: Manage District Admins Page: Add District Admins, Edit District Admin, Remove District Admins", groups = {"cobb"})
    public void testC2606() {
        rsl_adminManagerAccountsTest.initAndReachRSLAccountManagerTest(webDriver);
        rsl_adminManagerAccountsTest.reachAccountManagerPage(TestData.VALID_EMAIL_CSL_COBB, TestData.VALID_PASSWORD);
        rsl_adminManagerAccountsTest.testManageDistrictAdminsPage(TestData.VALID_EMAIL_CSL_COBB, true, true);
        manageDistrictAdminsPage.clickOnAddAdminLink();
        addADistrictAdminModal.typeEmail(TestData.GET_NEW_EMAIL());
        addADistrictAdminModal.clickOnAddButton();
        Assert.assertTrue(manageDistrictAdminsPage.getNotificationText().contains(TestData.ADD_DISTRICT_ADMIN_ROSTER_ON_NOTIFICATION_TEXT));
        districtPage.dismissNotification();
        rsl_adminManagerAccountsTest.testAddDistrictAdmin(TestData.CSL_COBB_EXISTING_TEACHER_EMAIL, true);
        csl_adminManagerAccountsSsoOnTest.initAndReachCSLAccountManagerSsoOnTest(webDriver);
        csl_adminManagerAccountsSsoOnTest.testEditDistrictAdmin();
        csl_adminManagerAccountsSsoOnTest.testEditOwner();
        rsl_adminManagerAccountsTest.testRemoveDistrictAdmin(TestData.CSL_COBB_SCHOOL_DISTRICT_NAME);
    }

    @Test(description = "Cobb SL - Admin Manager - Accounts - C2607: School Page: Add teacher, Edit Teacher, Remove Teacher", groups = {"cobb"})
    public void testC2607() {
        rsl_adminManagerAccountsTest.initAndReachRSLAccountManagerTest(webDriver);
        rsl_adminManagerAccountsTest.reachAccountManagerPage(TestData.VALID_EMAIL_CSL_COBB, TestData.VALID_PASSWORD);
        districtPage.clickOnSchool(0);
        rsl_adminManagerAccountsTest.testSchoolPage(true, true);
        schoolPage.hoverOverAddButton();
        Assert.assertEquals(schoolPage.getAddButtonPopoverText(), TestData.ADD_TEACHERS_BUTTON_ROSTER_ON_POPOVER_TEXT);
        rsl_adminManagerAccountsTest.testEditTeacher();
    }

    @Test(description = "Cobb SL - Admin Manager - Accounts - C2608: Edit School, Search in school", groups = {"cobb"})
    public void testC2608() {
        rsl_adminManagerAccountsTest.initAndReachRSLAccountManagerTest(webDriver);
        rsl_adminManagerAccountsTest.reachAccountManagerPage(TestData.VALID_EMAIL_CSL_COBB, TestData.VALID_PASSWORD);
        rsl_adminManagerAccountsTest.testEditSchoolFromActionsButton(TestData.GET_NEW_SCHOOL_NAME(), TestData.CSL_COBB_SCHOOL_DISTRICT_EXISTING_SCHOOL_NAME, true, true);
        rsl_adminManagerAccountsTest.testEditSchoolFromEditOrganizationButton(TestData.GET_NEW_SCHOOL_NAME(), TestData.CSL_COBB_SCHOOL_DISTRICT_EXISTING_SCHOOL_NAME, true, true);
        rsl_adminManagerAccountsTest.testSearchButtonFromSchoolPage(TestData.CSL_COBB_EXISTING_TEACHER_EMAIL, true);
        rsl_adminManagerAccountsTest.testSearchButtonFromSchoolPage(TestData.PLAN_VISITOR, true);
        rsl_adminManagerAccountsTest.testSearchButtonFromSchoolPage(TestData.CSL_COBB_TEACHER_FIRST_NAME, true);
        rsl_adminManagerAccountsTest.testSearchButtonFromSchoolPage(TestData.CSL_COBB_TEACHER_FIRST_NAME + " " + TestData.CSL_COBB_TEACHER_LAST_NAME, true);
    }

    @Test(description = "Cobb SL - Admin Manager - Accounts - C2609: Manage School Admins Page: Add School Admins, Edit School Admin Remove School Admins", groups = {"cobb"})
    public void testC2609() {
        rsl_adminManagerAccountsTest.initAndReachRSLAccountManagerTest(webDriver);
        rsl_adminManagerAccountsTest.reachAccountManagerPage(TestData.VALID_EMAIL_CSL_COBB, TestData.VALID_PASSWORD);
        districtPage.clickOnSchool(0);
        schoolPage.clickOnManageDistrictButton();
        rsl_adminManagerAccountsTest.testManageSchoolAdminPage(true, true);
    }

    @Test(description = "Cobb SL - Admin Manager - Accounts - C2605: Manage District Page", groups = {"cobb"})
    public void testC2605() {
        rsl_adminManagerAccountsTest.initAndReachRSLAccountManagerTest(webDriver);
        rsl_adminManagerAccountsTest.reachAccountManagerPage(TestData.VALID_EMAIL_CSL_COBB, TestData.VALID_PASSWORD);
        rsl_adminManagerAccountsTest.testManageDistrictPage(true);
    }
}
