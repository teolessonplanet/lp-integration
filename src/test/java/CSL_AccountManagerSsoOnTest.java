import com.lessonplanet.pages.*;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import util.TestData;

public class CSL_AccountManagerSsoOnTest extends BaseTest {
    private SchoolPage schoolPage;
    private DistrictPage districtPage;
    private EditDistrictAdminModal editDistrictAdminModal;
    private ManageDistrictAdminsPage manageDistrictAdminsPage;
    private RSL_AccountManagerTest rsl_accountManagerTest;
    private ManageSchoolAdminsPage manageSchoolAdminsPage;
    private EditSchoolAdminModal editSchoolAdminModal;
    private EditOwnerModal editOwnerModal;
    private EditDistrictModal editDistrictModal;
    private CurriculumManagerPage curriculumManagerPage;
    private EditSchoolModal editSchoolModal;
    private EditTeacherModal editTeacherModal;
    private HeaderPage headerPage;
    private ManageDistrictPage manageDistrictPage;

    @BeforeMethod(alwaysRun = true)
    public void beforeMethod() {
        schoolPage = new SchoolPage(webDriver);
        districtPage = new DistrictPage(webDriver);
        manageDistrictAdminsPage = new ManageDistrictAdminsPage(webDriver);
        rsl_accountManagerTest = new RSL_AccountManagerTest();
        manageSchoolAdminsPage = new ManageSchoolAdminsPage(webDriver);
        editSchoolAdminModal = new EditSchoolAdminModal(webDriver);
        editOwnerModal = new EditOwnerModal(webDriver);
        editDistrictAdminModal = new EditDistrictAdminModal(webDriver);
        editDistrictModal = new EditDistrictModal(webDriver);
        curriculumManagerPage = new CurriculumManagerPage(webDriver);
        editSchoolModal = new EditSchoolModal(webDriver);
        editTeacherModal = new EditTeacherModal(webDriver);
        headerPage = new HeaderPage(webDriver);
        manageDistrictPage = new ManageDistrictPage(webDriver);
    }

    @Test(description = "Custom SL - Account Manager - C2535: District Page, Add School, Remove School", groups = {"csl"})
    public void testC2535() {
        rsl_accountManagerTest.initAndReachRSLAccountManagerTest(webDriver);
        rsl_accountManagerTest.reachAccountManagerPage(TestData.VALID_EMAIL_CSL_HENRY, TestData.VALID_PASSWORD);
        rsl_accountManagerTest.testDistrictPage(false);
        rsl_accountManagerTest.testAddSchoolFromAddButton(TestData.GET_NEW_SCHOOL_NAME(), TestData.CSL_HENRY_EXISTING_SCHOOL_NAME);
        rsl_accountManagerTest.testRemoveSchool();
        rsl_accountManagerTest.testAddSchoolFromAddLink(TestData.GET_NEW_SCHOOL_NAME(), TestData.CSL_HENRY_EXISTING_SCHOOL_NAME);
        rsl_accountManagerTest.testRemoveSchool();
    }

    @Test(description = "Custom SL - Account Manager - C2536: Edit District, Search in district", groups = {"csl"})
    public void testC2536() {
        rsl_accountManagerTest.initAndReachRSLAccountManagerTest(webDriver);
        rsl_accountManagerTest.reachAccountManagerPage(TestData.VALID_EMAIL_CSL_HENRY, TestData.VALID_PASSWORD);
        rsl_accountManagerTest.testEditDistrict(TestData.CSL_HENRY_DISTRICT_NAME, true, true);
        rsl_accountManagerTest.testSearchButtonFromDistrictPage(TestData.VALID_EMAIL_CSL_HENRY, true);
        rsl_accountManagerTest.testSearchButtonFromDistrictPage(TestData.PLAN_VISITOR, true);
        rsl_accountManagerTest.testSearchButtonFromDistrictPage(TestData.CSL_HENRY_TEACHER_FIRST_NAME, true);
        rsl_accountManagerTest.testSearchButtonFromDistrictPage(TestData.CSL_HENRY_OWNER_FIRST_NAME + " " + TestData.CSL_HENRY_OWNER_LAST_NAME, true);
    }

    @Test(description = "Custom SL - Account Manager - C2537: Manage District Admins Page, Add District Admin, Edit Owner/District Admin, Remove District Admin", groups = {"csl"})
    public void testC2537() {
        rsl_accountManagerTest.initAndReachRSLAccountManagerTest(webDriver);
        rsl_accountManagerTest.reachAccountManagerPage(TestData.VALID_EMAIL_CSL_HENRY, TestData.VALID_PASSWORD);
        rsl_accountManagerTest.testManageDistrictAdminsPage(TestData.VALID_EMAIL_CSL_HENRY, true, false);
        rsl_accountManagerTest.testAddDistrictAdmin(TestData.CSL_HENRY_EXISTING_TEACHER_EMAIL, false);
        testEditDistrictAdmin();
        testEditOwner();
        rsl_accountManagerTest.testRemoveDistrictAdmin(TestData.CSL_HENRY_DISTRICT_NAME);
    }

    @Test(description = "Custom SL - Account Manager - C2538: School Page, Add Teacher, Edit Teacher, Remove Teacher", groups = {"csl"})
    public void testC2538() {
        rsl_accountManagerTest.initAndReachRSLAccountManagerTest(webDriver);
        rsl_accountManagerTest.reachAccountManagerPage(TestData.VALID_EMAIL_CSL_HENRY, TestData.VALID_PASSWORD);
        rsl_accountManagerTest.testAddSchool();
        districtPage.clickOnSchool(0);
        rsl_accountManagerTest.testSchoolPage(false, true);
        Assert.assertTrue(schoolPage.getFlashNotificationText().contains(TestData.NO_TEACHER_ADDED_NOTIFICATION_TEXT));
        rsl_accountManagerTest.testAddTeacherFromAddLink(TestData.GET_NEW_EMAIL());
        rsl_accountManagerTest.testSchoolPage(false, true);
        Assert.assertTrue(schoolPage.getFlashNotificationText().contains(TestData.NO_SCHOOL_ADMIN_ADDED_NOTIFICATION_TEXT));
        rsl_accountManagerTest.testEditTeacher();
        rsl_accountManagerTest.testRemoveTeacher(true);
        schoolPage.clickOnAccountManagerBreadcrumbs();
        rsl_accountManagerTest.testRemoveSchool();
    }

    @Test(description = "Custom SL - Account Manager - C2539: Edit School, Search in School", groups = {"csl"})
    public void testC2539() {
        rsl_accountManagerTest.initAndReachRSLAccountManagerTest(webDriver);
        rsl_accountManagerTest.reachAccountManagerPage(TestData.VALID_EMAIL_CSL_HENRY, TestData.VALID_PASSWORD);
        rsl_accountManagerTest.testAddSchool();
        rsl_accountManagerTest.testEditSchoolFromActionsButton(TestData.GET_NEW_SCHOOL_NAME(), TestData.CSL_HENRY_EXISTING_SCHOOL_NAME, true, false);
        rsl_accountManagerTest.testEditSchoolFromEditOrganizationButton(TestData.GET_NEW_SCHOOL_NAME(), TestData.CSL_HENRY_EXISTING_SCHOOL_NAME, true, false);
        schoolPage.clickOnAccountManagerBreadcrumbs();
        rsl_accountManagerTest.testRemoveSchool();
        districtPage.clickOnExistingSchool(TestData.CSL_HENRY_EXISTING_SCHOOL_NAME);
        rsl_accountManagerTest.testSearchButtonFromSchoolPage(TestData.CSL_HENRY_EXISTING_TEACHER_EMAIL, true);
        rsl_accountManagerTest.testSearchButtonFromSchoolPage(TestData.PLAN_VISITOR, true);
        rsl_accountManagerTest.testSearchButtonFromSchoolPage(TestData.CSL_HENRY_TEACHER_FIRST_NAME, true);
        rsl_accountManagerTest.testSearchButtonFromSchoolPage(TestData.CSL_HENRY_TEACHER_FIRST_NAME + " " + TestData.CSL_HENRY_TEACHER_LAST_NAME, true);
    }

    @Test(description = "Custom SL - Account Manager - C2540: Manage School Admins Page, Add School Admin, Edit School Admin, Remove School Admin", groups = {"csl"})
    public void testC2540() {
        rsl_accountManagerTest.initAndReachRSLAccountManagerTest(webDriver);
        rsl_accountManagerTest.reachAccountManagerPage(TestData.VALID_EMAIL_CSL_HENRY, TestData.VALID_PASSWORD);
        rsl_accountManagerTest.testAddSchool();
        districtPage.clickOnSchool(0);
        schoolPage.clickOnManageAdminsButton();
        rsl_accountManagerTest.testManageSchoolAdminPage(true, false);
        rsl_accountManagerTest.testAddSchoolAdmin(TestData.GET_NEW_EMAIL());
        rsl_accountManagerTest.testManageSchoolAdminPage(true, false);
        testEditSchoolAdmin();
        rsl_accountManagerTest.testRemoveSchoolAdmin(0);
        schoolPage.clickOnAccountManagerBreadcrumbs();
        rsl_accountManagerTest.testRemoveSchool();
    }

    @Test(description = "Custom SL - Account Manager - C2542: Manage District Page", groups = {"csl"})
    public void testC2542() {
        rsl_accountManagerTest.initAndReachRSLAccountManagerTest(webDriver);
        rsl_accountManagerTest.reachAccountManagerPage(TestData.VALID_EMAIL_CSL_HENRY, TestData.VALID_PASSWORD);
        rsl_accountManagerTest.testManageDistrictPage(false);
    }

    @Test(description = "Custom SL - Account Manager - C2541: Ability to Publish", groups = {"csl"})
    public void testC2541() {
        rsl_accountManagerTest.initAndReachRSLAccountManagerTest(webDriver);
        rsl_accountManagerTest.reachAccountManagerPage(TestData.VALID_EMAIL_CSL_HENRY, TestData.VALID_PASSWORD);
        testOwnerPublisherRole();
        testSchoolAdminPublisherRole();
        testTeacherPublisherRole();
    }

    public void initAndReachCSLAccountManagerSsoOnTest(WebDriver webDriver) {
        this.webDriver = webDriver;
        beforeMethod();
    }

    public void testEditDistrictAdmin() {
        manageDistrictAdminsPage.clickOnEditButton(1);
        Assert.assertTrue(editDistrictAdminModal.isEmailFieldDisabled());
        Assert.assertTrue(editDistrictAdminModal.isFirstNameFieldDisabled());
        Assert.assertTrue(editDistrictAdminModal.isLastNameFieldDisabled());
        Assert.assertTrue(editDistrictAdminModal.isDistrictAdminRoleChecked());
        editDistrictAdminModal.clickOnSaveButton();
    }

    public void testEditOwner() {
        manageDistrictAdminsPage.clickOnEditButton(0);
        Assert.assertTrue(editOwnerModal.isEmailFieldDisabled());
        Assert.assertTrue(editOwnerModal.isFirstNameFieldDisabled());
        Assert.assertTrue(editOwnerModal.isLastNameFieldDisabled());
        Assert.assertTrue(editOwnerModal.isTeacherRoleDisabled());
        Assert.assertTrue(editOwnerModal.isDistrictAdminRoleDisabled());
        Assert.assertTrue(editOwnerModal.isSchoolAdminRoleDisabled());
        editOwnerModal.clickOnSaveButton();
    }

    public void testEditSchoolAdmin() {
        manageSchoolAdminsPage.clickOnEditButton(0);
        Assert.assertTrue(editSchoolAdminModal.isEmailFieldDisabled());
        Assert.assertTrue(editSchoolAdminModal.isFirstNameFieldDisabled());
        Assert.assertTrue(editSchoolAdminModal.isLastNameFieldDisabled());
        Assert.assertTrue(editSchoolAdminModal.isSchoolAdminRoleChecked());
        editSchoolAdminModal.clickOnSaveButton();
    }

    public void testOwnerPublisherRole() {
        districtPage.clickOnManageDistrictButton();
        manageDistrictPage.clickOnManageDistrictButton();
        manageDistrictAdminsPage.clickOnEditButton(0);
        Assert.assertTrue(editOwnerModal.isPublishCheckboxChecked());
        editOwnerModal.clickOnPublishCheckbox();
        editOwnerModal.clickOnSaveButton();
        curriculumManagerPage.loadPage();
        curriculumManagerPage.clickOnActionsDropdown();
        Assert.assertFalse(curriculumManagerPage.isPublishButtonDisplayed());
        headerPage.hoverOverUserDropDownButton();
        headerPage.clickOnAdminManagerButton();
        districtPage.clickOnManageDistrictButton();
        manageDistrictPage.clickOnManageDistrictButton();
        manageDistrictAdminsPage.clickOnEditButton(0);
        editOwnerModal.clickOnPublishCheckbox();
        editOwnerModal.clickOnSaveButton();
        curriculumManagerPage.loadPage();
        curriculumManagerPage.clickOnActionsDropdown();
        Assert.assertTrue(curriculumManagerPage.isPublishButtonDisplayed());
    }

    public void testSchoolAdminPublisherRole() {
        headerPage.hoverOverUserDropDownButton();
        headerPage.clickOnAdminManagerButton();
        rsl_accountManagerTest.testAddSchool();
        districtPage.clickEditActionButton(0);
        Assert.assertTrue(editSchoolModal.isAdminPublishCheckboxChecked());
        Assert.assertTrue(editSchoolModal.isAdminPublishCheckboxDisabled());
        editSchoolModal.clickOnCancelButton();
        districtPage.clickOnSchool(0);
        schoolPage.clickOnManageAdminsButton();
        rsl_accountManagerTest.testAddSchoolAdmin(TestData.GET_NEW_EMAIL());
        manageSchoolAdminsPage.clickOnEditButton(0);
        Assert.assertTrue(editSchoolAdminModal.isPublishCheckboxChecked());
        editSchoolAdminModal.clickOnCancelButton();
        manageSchoolAdminsPage.clickXButton();
        Assert.assertTrue(schoolPage.getTeacherRole(0).contains(TestData.PUBLISHER_ROLE) && schoolPage.getTeacherRole(0).contains(TestData.SCHOOL_ADMIN_ROLE));
        schoolPage.clickOnManageAdminsButton();
        manageSchoolAdminsPage.clickOnEditButton(0);
        editSchoolAdminModal.clickOnPublishCheckbox();
        editSchoolAdminModal.clickOnSaveButton();
        manageSchoolAdminsPage.clickXButton();
        Assert.assertEquals(schoolPage.getTeacherRole(0), TestData.SCHOOL_ADMIN_ROLE);
        schoolPage.clickOnAccountManagerBreadcrumbs();
        rsl_accountManagerTest.testRemoveSchool();
    }

    public void testTeacherPublisherRole() {
        districtPage.clickOnManageDistrictButton();
        manageDistrictPage.clickOnEditOrganizationButton();
        editDistrictModal.clickOnTeacherPublishCheckbox();
        editDistrictModal.clickOnSaveButton();
        manageDistrictPage.clickOnAccountManagerBreadcrumbs();
        rsl_accountManagerTest.testAddSchool();
        districtPage.clickEditActionButton(0);
        Assert.assertTrue(editSchoolModal.isTeacherPublishCheckboxDisabled());
        Assert.assertTrue(editSchoolModal.isTeacherPublishCheckboxChecked());
        editSchoolModal.clickOnCancelButton();
        districtPage.clickOnSchool(0);
        rsl_accountManagerTest. testAddTeacher();
        schoolPage.clickEditActionButton(0);
        Assert.assertTrue(editTeacherModal.isPublishCheckboxChecked());
        editDistrictModal.clickOnCancelButton();
        Assert.assertTrue(schoolPage.getTeacherRole(0).contains(TestData.PUBLISHER_ROLE) && schoolPage.getTeacherRole(0).contains(TestData.TEACHER_ROLE));
        schoolPage.clickEditActionButton(0);
        editTeacherModal.clickOnPublishCheckbox();
        editTeacherModal.clickOnSaveButton();
        Assert.assertEquals(schoolPage.getTeacherRole(0), TestData.TEACHER_ROLE);
        Assert.assertFalse(schoolPage.getTeacherRole(0).contains(TestData.PUBLISHER_ROLE));
        schoolPage.clickOnAccountManagerBreadcrumbs();
        districtPage.clickOnManageDistrictButton();
        manageDistrictPage.clickOnEditOrganizationButton();
        Assert.assertTrue(editDistrictModal.isTeacherPublishCheckboxChecked());
        editDistrictModal.clickOnTeacherPublishCheckbox();
        editDistrictModal.clickOnSaveButton();

        schoolPage.clickOnAccountManagerBreadcrumbs();
        rsl_accountManagerTest.testRemoveSchool();
    }
}
