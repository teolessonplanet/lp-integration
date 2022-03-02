import com.lessonplanet.pages.AddADistrictAdminModal;
import com.lessonplanet.pages.DistrictPage;
import com.lessonplanet.pages.ManageDistrictAdminsPage;
import com.lessonplanet.pages.SchoolPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import util.TestData;

public class CSL_AdminManager_AccountsRosterOnTest extends BaseTest {
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

    @Test(description = "Custom SL - Roster On - Admin Manager - Accounts - C2528: District Page", groups = {"csl"})
    public void testC2528() {
        rsl_adminManagerAccountsTest.initAndReachRSLAccountManagerTest(webDriver);
        rsl_adminManagerAccountsTest.reachAccountManagerPage(TestData.VALID_EMAIL_CSL_QA_CUSTOM, TestData.VALID_PASSWORD);
        rsl_adminManagerAccountsTest.testDistrictPage(true);
        districtPage.hoverOverAddButton();
        Assert.assertEquals(districtPage.getAddButtonPopoverText(), TestData.ADD_SCHOOLS_ROSTER_ON_BUTTON_POPOVER_TEXT);

    }

    @Test(description = "Custom SL - Roster On - Admin Manager - Accounts - C2529: Edit District, Search in district", groups = {"csl"})
    public void testC2529() {
        rsl_adminManagerAccountsTest.initAndReachRSLAccountManagerTest(webDriver);
        rsl_adminManagerAccountsTest.reachAccountManagerPage(TestData.VALID_EMAIL_CSL_QA_CUSTOM, TestData.VALID_PASSWORD);
        rsl_adminManagerAccountsTest.testEditDistrict(TestData.CSL_QA_CUSTOM_DISTRICT_NAME, true, true);
        rsl_adminManagerAccountsTest.testSearchButtonFromDistrictPage(TestData.CSL_QA_CUSTOM_EXISTING_TEACHER_EMAIL, true);
        rsl_adminManagerAccountsTest.testSearchButtonFromDistrictPage(TestData.PLAN_VISITOR, true);
        rsl_adminManagerAccountsTest.testSearchButtonFromDistrictPage(TestData.CSL_QA_CUSTOM_OWNER_FIRST_NAME, true);
        rsl_adminManagerAccountsTest.testSearchButtonFromDistrictPage(TestData.CSL_QA_CUSTOM_OWNER_FIRST_NAME + " " + TestData.CSL_QA_CUSTOM_OWNER_LAST_NAME, true);
    }

    @Test(description = "Custom SL - Roster On - Admin Manager - Accounts - C2530: Manage District Admins Page, Add District Admin, Edit Owner/District Admin, Remove District Admin", groups = {"csl"})
    public void testC2530() {
        rsl_adminManagerAccountsTest.initAndReachRSLAccountManagerTest(webDriver);
        rsl_adminManagerAccountsTest.reachAccountManagerPage(TestData.VALID_EMAIL_CSL_QA_CUSTOM, TestData.VALID_PASSWORD);
        rsl_adminManagerAccountsTest.testManageDistrictAdminsPage(TestData.VALID_EMAIL_CSL_QA_CUSTOM, true, true);
        manageDistrictAdminsPage.clickOnAddAdminLink();
        addADistrictAdminModal.typeEmail(TestData.GET_NEW_EMAIL());
        addADistrictAdminModal.clickOnAddButton();
        Assert.assertTrue(manageDistrictAdminsPage.getNotificationText().contains(TestData.ADD_DISTRICT_ADMIN_ROSTER_ON_NOTIFICATION_TEXT));
        districtPage.dismissNotification();
        rsl_adminManagerAccountsTest.testAddDistrictAdmin(TestData.CSL_QA_CUSTOM_EXISTING_TEACHER_EMAIL, true);
        csl_adminManagerAccountsSsoOnTest.initAndReachCSLAccountManagerSsoOnTest(webDriver);
        csl_adminManagerAccountsSsoOnTest.testEditDistrictAdmin();
        csl_adminManagerAccountsSsoOnTest.testEditOwner();
        rsl_adminManagerAccountsTest.testRemoveDistrictAdmin(TestData.CSL_QA_CUSTOM_DISTRICT_NAME);
    }

    @Test(description = "Custom SL - Roster On - Admin Manager - Accounts - C2531: School Page, Add Teacher, Edit Teacher", groups = {"csl"})
    public void testC2531() {
        rsl_adminManagerAccountsTest.initAndReachRSLAccountManagerTest(webDriver);
        rsl_adminManagerAccountsTest.reachAccountManagerPage(TestData.VALID_EMAIL_CSL_QA_CUSTOM, TestData.VALID_PASSWORD);
        districtPage.clickOnSchool(0);
        rsl_adminManagerAccountsTest.testSchoolPage(true, true);
        schoolPage.hoverOverAddButton();
        Assert.assertEquals(schoolPage.getAddButtonPopoverText(), TestData.ADD_TEACHERS_BUTTON_ROSTER_ON_POPOVER_TEXT);
        rsl_adminManagerAccountsTest.testEditTeacher();
    }

    @Test(description = "Custom SL - Roster On - Admin Manager - Accounts - C2532: Edit School, Search in School", groups = {"csl"})
    public void testC2532() {
        rsl_adminManagerAccountsTest.initAndReachRSLAccountManagerTest(webDriver);
        rsl_adminManagerAccountsTest.reachAccountManagerPage(TestData.VALID_EMAIL_CSL_QA_CUSTOM, TestData.VALID_PASSWORD);
        rsl_adminManagerAccountsTest.testEditSchoolFromActionsButton(TestData.GET_NEW_SCHOOL_NAME(), TestData.CSL_QA_CUSTOM_EXISTING_SCHOOL_NAME, true, true);
        rsl_adminManagerAccountsTest.testEditSchoolFromEditOrganizationButton(TestData.GET_NEW_SCHOOL_NAME(), TestData.CSL_QA_CUSTOM_EXISTING_SCHOOL_NAME, true, true);
        rsl_adminManagerAccountsTest.testSearchButtonFromSchoolPage(TestData.CSL_QA_CUSTOM_EXISTING_TEACHER_EMAIL, true);
        rsl_adminManagerAccountsTest.testSearchButtonFromSchoolPage(TestData.PLAN_VISITOR, true);
        rsl_adminManagerAccountsTest.testSearchButtonFromSchoolPage(TestData.CSL_QA_CUSTOM_TEACHER_FIRST_NAME, true);
        rsl_adminManagerAccountsTest.testSearchButtonFromSchoolPage(TestData.CSL_QA_CUSTOM_TEACHER_FIRST_NAME + " " + TestData.CSL_QA_CUSTOM_TEACHER_LAST_NAME, true);
    }

    @Test(description = "Custom SL - Roster On - Admin Manager - Accounts - C2533: Manage School Admins Page, Add School Admin, Edit School Admin, Remove School Admin", groups = {"csl"})
    public void testC2533() {
        rsl_adminManagerAccountsTest.initAndReachRSLAccountManagerTest(webDriver);
        rsl_adminManagerAccountsTest.reachAccountManagerPage(TestData.VALID_EMAIL_CSL_QA_CUSTOM, TestData.VALID_PASSWORD);
        districtPage.clickOnSchool(0);
        schoolPage.clickOnManageDistrictButton();
        rsl_adminManagerAccountsTest.testManageSchoolAdminPage(true, true);
    }

    @Test(description = "Custom SL - Roster On - Admin Manager - Accounts - C2534: Manage District Page", groups = {"csl"})
    public void testC2534() {
        rsl_adminManagerAccountsTest.initAndReachRSLAccountManagerTest(webDriver);
        rsl_adminManagerAccountsTest.reachAccountManagerPage(TestData.VALID_EMAIL_CSL_QA_CUSTOM, TestData.VALID_PASSWORD);
        rsl_adminManagerAccountsTest.testManageDistrictPage(true);
    }
}
