import com.lessonplanet.pages.AddADistrictAdminModal;
import com.lessonplanet.pages.DistrictPage;
import com.lessonplanet.pages.ManageDistrictAdminsPage;
import com.lessonplanet.pages.SchoolPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import util.TestData;

public class CSL_AccountManagerRosterOnTest extends BaseTest {
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

    @Test(description = "Custom SL - Account Manager - lessonp-5107: District Page", groups = {"csl"})
    public void testLessonp_5107() {
        rsl_accountManagerTest.initAndReachRSLAccountManagerTest(webDriver);
        rsl_accountManagerTest.reachAccountManagerPage(TestData.VALID_EMAIL_CSL_QA_CUSTOM, TestData.VALID_PASSWORD);
        rsl_accountManagerTest.testDistrictPage(true);
        districtPage.hoverOverAddButton();
        Assert.assertEquals(districtPage.getAddButtonPopoverText(), TestData.ADD_SCHOOLS_ROSTER_ON_BUTTON_POPOVER_TEXT);

    }

    @Test(description = "Custom SL - Account Manager - lessonp-5108: Edit District, Search in district", groups = {"csl"})
    public void testLessonp_5108() {
        rsl_accountManagerTest.initAndReachRSLAccountManagerTest(webDriver);
        rsl_accountManagerTest.reachAccountManagerPage(TestData.VALID_EMAIL_CSL_QA_CUSTOM, TestData.VALID_PASSWORD);
        rsl_accountManagerTest.testEditDistrict(TestData.CSL_QA_CUSTOM_DISTRICT_NAME, true, true);
        rsl_accountManagerTest.testSearchButtonFromDistrictPage(TestData.CSL_QA_CUSTOM_EXISTING_TEACHER_EMAIL, true);
        rsl_accountManagerTest.testSearchButtonFromDistrictPage(TestData.PLAN_VISITOR, true);
        rsl_accountManagerTest.testSearchButtonFromDistrictPage(TestData.CSL_QA_CUSTOM_OWNER_FIRST_NAME, true);
        rsl_accountManagerTest.testSearchButtonFromDistrictPage(TestData.CSL_QA_CUSTOM_OWNER_FIRST_NAME + " " + TestData.CSL_QA_CUSTOM_OWNER_LAST_NAME, true);
    }

    @Test(description = "Custom SL - Account Manager - lessonp-5109: Manage District Admins Page, Add District Admin, Edit Owner/District Admin, Remove District Admin", groups = {"csl"})
    public void testLessonp_5109() {
        rsl_accountManagerTest.initAndReachRSLAccountManagerTest(webDriver);
        rsl_accountManagerTest.reachAccountManagerPage(TestData.VALID_EMAIL_CSL_QA_CUSTOM, TestData.VALID_PASSWORD);
        rsl_accountManagerTest.testManageDistrictAdminsPage(TestData.VALID_EMAIL_CSL_QA_CUSTOM, true, true);
        manageDistrictAdminsPage.clickOnAddAdminLink();
        addADistrictAdminModal.typeEmail(TestData.GET_NEW_EMAIL());
        addADistrictAdminModal.clickOnAddButton();
        Assert.assertTrue(manageDistrictAdminsPage.getNotificationText().contains(TestData.ADD_DISTRICT_ADMIN_ROSTER_ON_NOTIFICATION_TEXT));
        districtPage.dismissNotification();
        rsl_accountManagerTest.testAddDistrictAdmin(TestData.CSL_QA_CUSTOM_EXISTING_TEACHER_EMAIL, true);
        csl_accountManagerSsoOnTest.initAndReachCSLAccountManagerSsoOnTest(webDriver);
        csl_accountManagerSsoOnTest.testEditDistrictAdmin();
        csl_accountManagerSsoOnTest.testEditOwner();
        rsl_accountManagerTest.testRemoveDistrictAdmin(TestData.CSL_QA_CUSTOM_DISTRICT_NAME);
    }

    @Test(description = "Custom SL - Account Manager - lessonp-5103: School Page, Add Teacher, Edit Teacher", groups = {"csl"})
    public void testLessonp_5103() {
        rsl_accountManagerTest.initAndReachRSLAccountManagerTest(webDriver);
        rsl_accountManagerTest.reachAccountManagerPage(TestData.VALID_EMAIL_CSL_QA_CUSTOM, TestData.VALID_PASSWORD);
        districtPage.clickOnSchool(0);
        rsl_accountManagerTest.testSchoolPage(true, true);
        schoolPage.hoverOverAddButton();
        Assert.assertEquals(schoolPage.getAddButtonPopoverText(), TestData.ADD_TEACHERS_BUTTON_ROSTER_ON_POPOVER_TEXT);
        rsl_accountManagerTest.testEditTeacher();
    }
 
    @Test(description = "Custom SL - Account Manager - lessonp-5104: Edit School, Search in School", groups = {"csl"})
    public void testLessonp_5104() {
        rsl_accountManagerTest.initAndReachRSLAccountManagerTest(webDriver);
        rsl_accountManagerTest.reachAccountManagerPage(TestData.VALID_EMAIL_CSL_QA_CUSTOM, TestData.VALID_PASSWORD);
        rsl_accountManagerTest.testEditSchoolFromActionsButton(TestData.GET_NEW_SCHOOL_NAME(), TestData.CSL_QA_CUSTOM_EXISTING_SCHOOL_NAME, true, true);
        rsl_accountManagerTest.testEditSchoolFromEditOrganizationButton(TestData.GET_NEW_SCHOOL_NAME(), TestData.CSL_QA_CUSTOM_EXISTING_SCHOOL_NAME, true, true);
        rsl_accountManagerTest.testSearchButtonFromSchoolPage(TestData.CSL_QA_CUSTOM_EXISTING_TEACHER_EMAIL, true);
        rsl_accountManagerTest.testSearchButtonFromSchoolPage(TestData.PLAN_VISITOR, true);
        rsl_accountManagerTest.testSearchButtonFromSchoolPage(TestData.CSL_QA_CUSTOM_TEACHER_FIRST_NAME, true);
        rsl_accountManagerTest.testSearchButtonFromSchoolPage(TestData.CSL_QA_CUSTOM_TEACHER_FIRST_NAME + " " + TestData.CSL_QA_CUSTOM_TEACHER_LAST_NAME, true);
    }

    @Test(description = "Custom SL - Account Manager - lessonp-5105: Manage School Admins Page, Add School Admin, Edit School Admin, Remove School Admin", groups = {"csl"})
    public void testLessonp_5105() {
        rsl_accountManagerTest.initAndReachRSLAccountManagerTest(webDriver);
        rsl_accountManagerTest.reachAccountManagerPage(TestData.VALID_EMAIL_CSL_QA_CUSTOM, TestData.VALID_PASSWORD);
        districtPage.clickOnSchool(0);
        schoolPage.clickOnManageDistrictButton();
        rsl_accountManagerTest.testManageSchoolAdminPage(true, true);
    }

    @Test(description = "Custom SL - Account Manager - lessonp-5871: Manage District Page", groups = {"csl"})
    public void testLessonp_5871() {
        rsl_accountManagerTest.initAndReachRSLAccountManagerTest(webDriver);
        rsl_accountManagerTest.reachAccountManagerPage(TestData.VALID_EMAIL_CSL_QA_CUSTOM, TestData.VALID_PASSWORD);
        rsl_accountManagerTest.testManageDistrictPage(true);
    }
}
