import com.lessonplanet.pages.SchoolPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import util.TestData;

public class RSL_AccountManager_School_SL extends BaseTest {
    private SchoolPage schoolPage;
    private RSL_AccountManagerTest rsl_accountManagerTest;

    @BeforeMethod(alwaysRun = true)
    public void beforeMethod() {
        schoolPage = new SchoolPage(webDriver);
        rsl_accountManagerTest = new RSL_AccountManagerTest();
    }

    @Test(description = "Regular School SL - Account Manager - C2334: School Page, Add Teacher, Edit Teacher, Remove Teacher", groups = {"rsl"})
    public void testC2334() {
        rsl_accountManagerTest.initAndReachRSLAccountManagerTest(webDriver);
        rsl_accountManagerTest.reachAccountManagerPage(TestData.VALID_EMAIL_RSL_LAGUNA_SCHOOL, TestData.VALID_PASSWORD);
        rsl_accountManagerTest.testSchoolPage(false, false);
        rsl_accountManagerTest.testAddTeacherFromAddButton();
        rsl_accountManagerTest.testEditTeacher();
        rsl_accountManagerTest.testRemoveTeacher(false);
        rsl_accountManagerTest.testAddTeacherFromAddLink(TestData.GET_NEW_EMAIL());
        rsl_accountManagerTest.testRemoveTeacher(false);
    }

    @Test(description = "Regular School SL - Account Manager - C2335: Edit School, Search in School", groups = {"rsl"})
    public void testC2335() {
        rsl_accountManagerTest.initAndReachRSLAccountManagerTest(webDriver);
        rsl_accountManagerTest.reachAccountManagerPage(TestData.VALID_EMAIL_RSL_LAGUNA_SCHOOL, TestData.VALID_PASSWORD);
        rsl_accountManagerTest.testEditDistrict(TestData.RSL_LAGUNA_SCHOOL_NAME, false, false);
        rsl_accountManagerTest.testSearchButtonFromSchoolPage(TestData.RSL_LAGUNA_SCHOOL_EXISTING_TEACHER_EMAIL, false);
        rsl_accountManagerTest.testSearchButtonFromSchoolPage(TestData.INVALID_EMAIL, false);
        rsl_accountManagerTest.testSearchButtonFromSchoolPage(TestData.RSL_LAGUNA_SCHOOL_OWNER_FIRST_NAME, false);
        rsl_accountManagerTest.testSearchButtonFromSchoolPage(TestData.RSL_LAGUNA_SCHOOL_TEACHER_FIRST_NAME + " " + TestData.RSL_LAGUNA_SCHOOL_TEACHER_LAST_NAME, false);
    }

    @Test(description = "Regular School SL - Account Manager - C2336: Manage School Admins Page, Add School Admin, Remove School Admin", groups = {"rsl"})
    public void testC2336() {
        rsl_accountManagerTest.initAndReachRSLAccountManagerTest(webDriver);
        rsl_accountManagerTest.reachAccountManagerPage(TestData.VALID_EMAIL_RSL_LAGUNA_SCHOOL, TestData.VALID_PASSWORD);
        schoolPage.clickOnManageAdminsButton();
        rsl_accountManagerTest.testManageSchoolAdminPage(false, false);
        rsl_accountManagerTest.testAddDistrictAdmin(TestData.VALID_EMAIL_PRO, false);
        rsl_accountManagerTest.testRemoveSchoolAdmin(1);
    }
}
