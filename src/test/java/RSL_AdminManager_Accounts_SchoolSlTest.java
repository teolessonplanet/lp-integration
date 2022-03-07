import com.lessonplanet.pages.SchoolPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import util.TestData;

public class RSL_AdminManager_Accounts_SchoolSlTest extends BaseTest {
    private SchoolPage schoolPage;
    private RSL_AdminManager_AccountsTest rsl_adminManagerAccountsTest;

    @BeforeMethod(alwaysRun = true)
    public void beforeMethod() {
        schoolPage = new SchoolPage(webDriver);
        rsl_adminManagerAccountsTest = new RSL_AdminManager_AccountsTest();
    }

    @Test(description = "Regular School SL - Admin Manager - Accounts - C2334: School Page, Add Teacher, Edit Teacher, Remove Teacher", groups = {"rsl"})
    public void testC2334() {
        rsl_adminManagerAccountsTest.initAndReachRSLAccountManagerTest(webDriver);
        rsl_adminManagerAccountsTest.reachAccountManagerPage(TestData.VALID_EMAIL_RSL_LAGUNA_SCHOOL, TestData.VALID_PASSWORD);
        rsl_adminManagerAccountsTest.testSchoolPage(false, false);
        rsl_adminManagerAccountsTest.testAddTeacherFromAddButton();
        rsl_adminManagerAccountsTest.testEditTeacher();
        rsl_adminManagerAccountsTest.testRemoveTeacher(false);
        rsl_adminManagerAccountsTest.testAddTeacherFromAddLink(TestData.GET_NEW_EMAIL());
        rsl_adminManagerAccountsTest.testRemoveTeacher(false);
    }

    @Test(description = "Regular School SL - Admin Manager - Accounts - C2335: Edit School, Search in School", groups = {"rsl"})
    public void testC2335() {
        rsl_adminManagerAccountsTest.initAndReachRSLAccountManagerTest(webDriver);
        rsl_adminManagerAccountsTest.reachAccountManagerPage(TestData.VALID_EMAIL_RSL_LAGUNA_SCHOOL, TestData.VALID_PASSWORD);
        rsl_adminManagerAccountsTest.testEditDistrict(TestData.RSL_LAGUNA_SCHOOL_NAME, false, false);
        rsl_adminManagerAccountsTest.testSearchButtonFromSchoolPage(TestData.RSL_LAGUNA_SCHOOL_EXISTING_TEACHER_EMAIL, false);
        rsl_adminManagerAccountsTest.testSearchButtonFromSchoolPage(TestData.INVALID_EMAIL, false);
        rsl_adminManagerAccountsTest.testSearchButtonFromSchoolPage(TestData.RSL_LAGUNA_SCHOOL_OWNER_FIRST_NAME, false);
        rsl_adminManagerAccountsTest.testSearchButtonFromSchoolPage(TestData.RSL_LAGUNA_SCHOOL_TEACHER_FIRST_NAME + " " + TestData.RSL_LAGUNA_SCHOOL_TEACHER_LAST_NAME, false);
    }

    @Test(description = "Regular School SL - Admin Manager - Accounts - C2336: Manage School Admins Page, Add School Admin, Remove School Admin", groups = {"rsl"})
    public void testC2336() {
        rsl_adminManagerAccountsTest.initAndReachRSLAccountManagerTest(webDriver);
        rsl_adminManagerAccountsTest.reachAccountManagerPage(TestData.VALID_EMAIL_RSL_LAGUNA_SCHOOL, TestData.VALID_PASSWORD);
        schoolPage.clickOnManageAdminsButton();
        rsl_adminManagerAccountsTest.testManageSchoolAdminPage(false, false);
        rsl_adminManagerAccountsTest.testAddDistrictAdmin(TestData.VALID_EMAIL_PRO, false);
        rsl_adminManagerAccountsTest.testRemoveSchoolAdmin(1);
    }
}
