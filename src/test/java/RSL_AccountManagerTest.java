import com.lessonplanet.pages.*;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import util.TestData;

public class RSL_AccountManagerTest extends BaseTest {
    private LoginPage loginPage;
    private SchoolPage schoolPage;
    private DistrictPage districtPage;
    private EditDistrictModal editDistrictModal;
    private EditSchoolModal editSchoolModal;
    private EditTeacherModal editTeacherModal;
    private ManageDistrictAdminsPage manageDistrictAdminsPage;
    private ManageSchoolAdminsPage manageSchoolAdminsPage;
    private AddADistrictAdminModal addADistrictAdminModal;
    private AddASchoolAdminModal addASchoolAdminModal;
    private AddSchoolsModal addSchoolsModal;
    private AddTeachersModal addTeachersModal;
    private RemoveSchoolAdminModal removeSchoolAdminModal;
    private RemoveSchoolModal removeSchoolModal;
    private RemoveDistrictAdminModal removeDistrictAdminModal;
    private RemoveTeacherModal removeTeacherModal;

    @BeforeMethod
    public void beforeMethod() {
        loginPage = new LoginPage(webDriver);
        schoolPage = new SchoolPage(webDriver);
        districtPage = new DistrictPage(webDriver);
        editDistrictModal = new EditDistrictModal(webDriver);
        editSchoolModal = new EditSchoolModal(webDriver);
        editTeacherModal = new EditTeacherModal(webDriver);
        manageDistrictAdminsPage = new ManageDistrictAdminsPage(webDriver);
        manageSchoolAdminsPage = new ManageSchoolAdminsPage(webDriver);
        addADistrictAdminModal = new AddADistrictAdminModal(webDriver);
        addASchoolAdminModal = new AddASchoolAdminModal(webDriver);
        addSchoolsModal = new AddSchoolsModal(webDriver);
        addTeachersModal = new AddTeachersModal(webDriver);
        removeSchoolModal = new RemoveSchoolModal(webDriver);
        removeDistrictAdminModal = new RemoveDistrictAdminModal(webDriver);
        removeSchoolAdminModal = new RemoveSchoolAdminModal(webDriver);
        removeTeacherModal = new RemoveTeacherModal(webDriver);
    }

    @Test(description = "Regular SL - Account Manager - lessonp-918: District Page, Add School, Remove School")
    public void testLessonp_918() {
        reachAccountManagerPage(TestData.VALID_EMAIL_RSL_SBCEO, TestData.VALID_PASSWORD);
        testDistrictPage(false);
        testAddSchoolFromAddButton(TestData.GET_NEW_SCHOOL_NAME(), TestData.RSL_SBCEO_EXISTING_SCHOOL_NAME);
        testRemoveSchool();
        testAddSchoolFromAddLink(TestData.GET_NEW_SCHOOL_NAME(), TestData.RSL_SBCEO_EXISTING_SCHOOL_NAME);
        testRemoveSchool();
    }

    @Test(description = "Regular SL - Account Manager - lessonp-901: Edit District, Search in district")
    //TODO: try to remove static account
    public void testLessonp_901() {
        reachAccountManagerPage(TestData.VALID_EMAIL_RSL_SBCEO, TestData.VALID_PASSWORD);
        testEditDistrict(TestData.RSL_SBCEO_DISTRICT_NAME, false);
        testSearchButtonFromDistrictPage(TestData.RSL_SBCEO_EXISTING_TEACHER_EMAIL, false, false);
        testSearchButtonFromDistrictPage(TestData.INVALID_EMAIL, false, false);
        testSearchButtonFromDistrictPage(TestData.RSL_SBCEO_TEACHER_LAST_NAME, false, false);
        testSearchButtonFromDistrictPage(TestData.RSL_SBCEO_OWNER_FIRST_NAME + " " + TestData.RSL_SBCEO_OWNER_LAST_NAME, false, false);
    }

    @Test(description = "Regular SL - Account Manager - lessonp-904: Manage District Admins Page, Add District Admin, Remove District Admin")
    public void testLessonp_904() {
        //TODO: try to remove static account
        reachAccountManagerPage(TestData.VALID_EMAIL_RSL_SBCEO, TestData.VALID_PASSWORD);
        testManageDistrictAdminsPage(TestData.VALID_EMAIL_RSL_SBCEO, false, false);
        testAddDistrictAdmin(TestData.VALID_EMAIL_STARTER);
        testRemoveDistrictAdmin(TestData.RSL_SBCEO_DISTRICT_NAME);
    }

    @Test(description = "Regular SL - Account Manager - lessonp-920: School Page, Add Teacher, Edit Teacher, Remove Teacher")
    public void testLessonp_920() {
        reachAccountManagerPage(TestData.VALID_EMAIL_RSL_SBCEO, TestData.VALID_PASSWORD);
        testAddSchoolFromAddButton(TestData.GET_NEW_SCHOOL_NAME(), TestData.RSL_SBCEO_EXISTING_SCHOOL_NAME);
        districtPage.clickOnSchool(0);
        testSchoolPage(false, false);
        Assert.assertTrue(schoolPage.getFlashNotificationText().contains(TestData.NO_TEACHER_ADDED_NOTIFICATION_TEXT));
        testAddTeacherFromAddButton();
        testSchoolPage(false, false);
        Assert.assertTrue(schoolPage.getFlashNotificationText().contains(TestData.NO_SCHOOL_ADMIN_ADDED_NOTIFICATION_TEXT));
        testEditTeacher(false);
        testRemoveTeacher();
        testAddTeacherFromAddLink(TestData.GET_NEW_EMAIL());
        testRemoveTeacher();
        schoolPage.clickOnDistrictBreadcrumbs();
        testRemoveSchool();
    }

    @Test(description = "Regular SL - Account Manager - lessonp-895: Edit School, Search in School")
    public void testLessonp_895() {
        //TODO: try to remove static account
        reachAccountManagerPage(TestData.VALID_EMAIL_RSL_SBCEO, TestData.VALID_PASSWORD);
        testAddSchoolFromAddLink(TestData.GET_NEW_SCHOOL_NAME(), TestData.RSL_SBCEO_EXISTING_SCHOOL_NAME);
        testEditSchoolFromActionsButton(TestData.GET_NEW_SCHOOL_NAME(), TestData.RSL_SBCEO_EXISTING_SCHOOL_NAME, false, false);
        testEditSchoolFromEditOrganizationButton(TestData.GET_NEW_SCHOOL_NAME(), TestData.RSL_SBCEO_EXISTING_SCHOOL_NAME, false, false);
        schoolPage.clickOnDistrictBreadcrumbs();
        testRemoveSchool();

        districtPage.clickOnExistingSchool(TestData.RSL_SBCEO_EXISTING_SCHOOL_NAME);
        testSearchButtonFromSchoolPage(TestData.RSL_SBCEO_EXISTING_TEACHER_EMAIL, false, false);
        testSearchButtonFromSchoolPage(TestData.INVALID_EMAIL, false, false);
        testSearchButtonFromSchoolPage(TestData.RSL_SBCEO_TEACHER_LAST_NAME, false, false);
        testSearchButtonFromSchoolPage(TestData.RSL_SBCEO_TEACHER_FIRST_NAME + " " + TestData.RSL_SBCEO_TEACHER_LAST_NAME, false, false);
    }

    @Test(description = "Regular SL - Account Manager - lessonp-924: Manage School Admins Page, Add School Admin, Remove School Admin")
    public void testLessonp_924() {
        //TODO: try to remove static account
        reachAccountManagerPage(TestData.VALID_EMAIL_RSL_SBCEO, TestData.VALID_PASSWORD);
        testAddSchoolFromAddButton(TestData.GET_NEW_SCHOOL_NAME(), TestData.RSL_SBCEO_EXISTING_SCHOOL_NAME);
        districtPage.clickOnSchool(0);
        schoolPage.clickOnManageAdminsButton();
        testManageSchoolAdminPage(false);
        testAddSchoolAdmin(TestData.VALID_EMAIL_STARTER);
        testManageSchoolAdminPage(false);
        schoolPage.clickOnManageAdminsButton();
        testSchoolPage(false, false);
        schoolPage.clickOnManageAdminsButton();
        testRemoveSchoolAdmin();
        schoolPage.clickOnDistrictBreadcrumbs();
        testRemoveSchool();
    }

    public void reachAccountManagerPage(String email, String password) {
        loginPage.performLogin(email, password);
        districtPage.loadPage();
    }

    public void initAndReachRSLAccountManagerTest(WebDriver webDriver) {
        this.webDriver = webDriver;
        beforeMethod();
    }

    public void testDistrictPage(boolean roster) {
        Assert.assertTrue(districtPage.isOrganizationNameDisplayed());
        Assert.assertTrue(districtPage.isEditOrganizationButtonDisplayed());
        districtPage.hoverOverEditOrganizationButton();
        Assert.assertEquals(districtPage.getEditOrganizationButtonPopoverText(), TestData.EDIT_DISTRICT_BUTTON_POPOVER_TEXT);
        Assert.assertTrue(districtPage.isManageAdminsButtonDisplayed());
        districtPage.hoverOverManageAdminsButton();
        Assert.assertEquals(districtPage.getManageAdminsPopoverText(), TestData.MANAGE_DISTRICT_ADMINS_POPOVER_TEXT);
        Assert.assertTrue(districtPage.isSearchButtonDisplayed());
        districtPage.hoverOverSearchButton();
        Assert.assertEquals(districtPage.getSearchButtonPopoverText(), TestData.SEARCH_BUTTON_POPOVER_TEXT);
        Assert.assertTrue(districtPage.isAddButtonDisplayed());
        if (districtPage.isSchoolListDisplayed()) {
            for (int i = 0; i < districtPage.getSchoolsNumber() - 1; i++) {
                Assert.assertTrue(districtPage.isSchoolNameDisplayed());
                Assert.assertTrue(districtPage.isNrOfTeachersDisplayed());
                Assert.assertTrue(districtPage.isNrOfResourcesUploadedDisplayed());
                Assert.assertTrue(districtPage.isSeeSchoolReportingActionButtonDisplayed(i));
                Assert.assertTrue(districtPage.isEditActionButtonDisplayed(i));
                if (!roster) {
                    Assert.assertTrue(districtPage.isRemoveActionButtonDisplayed(i));
                }
            }
            if (!roster) {
                Assert.assertEquals(districtPage.getAddLinkNumber(), 1);
                Assert.assertTrue(districtPage.isAddLinkSeeSchoolReportingButtonDisplayed(0));
                Assert.assertTrue(districtPage.isAddLinkEditButtonDisplayed(0));
                Assert.assertTrue(districtPage.isAddLinkRemoveButtonDisplayed(0));
            } else {
                Assert.assertFalse(schoolPage.isAddLinkDisplayed());
            }
        } else {
            if (!roster) {
                Assert.assertEquals(districtPage.getAddLinkNumber(), 3);
                for (int i = 0; i < 3; i++) {
                    Assert.assertTrue(districtPage.isAddLinkSeeSchoolReportingButtonDisplayed(i));
                    Assert.assertTrue(districtPage.isAddLinkEditButtonDisplayed(i));
                    Assert.assertTrue(districtPage.isAddLinkRemoveButtonDisplayed(i));
                }
            } else {
                Assert.assertFalse(schoolPage.isAddLinkDisplayed());
            }
        }
    }

    public void testEditDistrict(String districtName, boolean sso) {
        districtPage.clickOnEditOrganizationButton();
        Assert.assertEquals(editDistrictModal.getDistrictName(), districtName);
        editDistrictModal.hoverOverDistrictNameInfoIcon();
        Assert.assertEquals(editDistrictModal.getDistrictNameInfoIconPopoverText(), TestData.DISTRICT_NAME_POPOVER_TEXT);
        editDistrictModal.typeOrganizationShortName(TestData.CONCEPT);
        editDistrictModal.hoverOverOrganizationShortNameInfoIcon();
        Assert.assertEquals(editDistrictModal.getOrganizationShortNameInfoIconPopoverText(), TestData.DISTRICT_SHORT_NAME_POPOVER_TEXT);
        if (sso) {
            editDistrictModal.hoverOverSharingPrivilegesInfoIcon();
            Assert.assertTrue(editDistrictModal.getSharingPrivilegesInfoIconPopoverText().contains(TestData.SHARING_PRIVILEGES_DISTRICT_POPOVER_TEXT));
            Assert.assertTrue(editDistrictModal.isAdminPublishCheckboxDisplayed());
            Assert.assertEquals(editDistrictModal.getAdminPublishOptionText(), TestData.ADMIN_PUBLISH_DISTRICT_OPTION_TEXT);
            Assert.assertTrue(editDistrictModal.isTeacherPublishCheckboxDisplayed());
            Assert.assertEquals(editDistrictModal.getTeacherPublishOptionText(), TestData.TEACHER_PUBLISH_DISTRICT_OPTION_TEXT);
        }
        editDistrictModal.clickOnSaveButton();
        districtPage.clickOnEditOrganizationButton();
        Assert.assertEquals(editDistrictModal.getDistrictShortName(), TestData.CONCEPT);
        editDistrictModal.clickXButton();
        Assert.assertEquals(districtPage.getOrganizationName(), districtName);
    }

    public void testManageDistrictAdminsPage(String adminEmail, boolean sso, boolean roster) {
        districtPage.clickOnManageAdminsButton();
        Assert.assertTrue(manageDistrictAdminsPage.isOrganizationNameDisplayed());
        Assert.assertTrue(manageDistrictAdminsPage.isEditOrganizationButtonDisplayed());
        Assert.assertTrue(manageDistrictAdminsPage.isManageAdminsButtonDisplayed());
        Assert.assertTrue(manageDistrictAdminsPage.isSearchButtonDisplayed());
        Assert.assertEquals(manageDistrictAdminsPage.getTitleText(), TestData.MANAGE_DISTRICT_ADMINS_TITLE);
        Assert.assertEquals(manageDistrictAdminsPage.getAdminEmail(0), adminEmail);
        if (!roster) {
            manageDistrictAdminsPage.hoverOverRemoveButton(0);
            Assert.assertEquals(manageDistrictAdminsPage.getRemoveButtonPopoverText(), TestData.REMOVE_OWNER_POPOVER_TEXT);
        } else {
            manageDistrictAdminsPage.hoverOverRemoveButton(0);
            Assert.assertEquals(manageDistrictAdminsPage.getRemoveButtonPopoverText(), TestData.REMOVE_OWNER_ROSTER_ON_POPOVER_TEXT);
        }
        if (sso) {
            Assert.assertTrue(manageDistrictAdminsPage.isEditButtonDisplayed(0));
            manageDistrictAdminsPage.hoverOverEditButton(0);
            Assert.assertEquals(manageDistrictAdminsPage.getEditButtonPopoverText(), TestData.ENABLED_EDIT_OWNER_POPOVER_TEXT);
        }
        if (manageDistrictAdminsPage.getAdminsNumber() > 1) {
            for (int i = 1; i < manageDistrictAdminsPage.getAdminsNumber(); i++) {
                Assert.assertTrue(manageDistrictAdminsPage.isAdminEmailDisplayed(i));
                Assert.assertTrue(manageDistrictAdminsPage.isRemoveButtonDisplayed(i));
                manageDistrictAdminsPage.hoverOverRemoveButton(i);
                Assert.assertEquals(manageDistrictAdminsPage.getRemoveButtonPopoverText(), TestData.REMOVE_DISTRICT_ADMIN_POPOVER_TEXT);
                if (sso) {
                    Assert.assertTrue(manageDistrictAdminsPage.isEditButtonDisplayed(i));
                    manageDistrictAdminsPage.hoverOverEditButton(i);
                    Assert.assertEquals(manageDistrictAdminsPage.getEditButtonPopoverText(), TestData.ENABLED_EDIT_DISTRICT_ADMIN_POPOVER_TEXT);
                }
            }
        }
        Assert.assertEquals(manageSchoolAdminsPage.getAddAdminLinkNumber(), 1);
        Assert.assertTrue(manageDistrictAdminsPage.isAddAdminLinkRemoveButtonDisplayed(0));
    }

    public void testAddDistrictAdmin(String adminEmail) {
        manageDistrictAdminsPage.clickOnAddAdminLink();
        addADistrictAdminModal.typeEmail(TestData.INVALID_EMAIL);
        addADistrictAdminModal.clearEmail();
        addADistrictAdminModal.waitForNotificationToBeDisplayed(TestData.REQUIRED_FIELD_ERROR_TEXT);
        addADistrictAdminModal.typeEmail(TestData.VALID_EMAIL_RSL_SBCEO);
        addADistrictAdminModal.clickOnAddButton();
        addADistrictAdminModal.waitForNotificationToBeDisplayed(TestData.EXISTING_EMAIL_ERROR_TEXT);
        addADistrictAdminModal.clearEmail();
        addADistrictAdminModal.typeEmail(TestData.NEW_COLLECTION_NAME);
        addADistrictAdminModal.waitForNotificationToBeDisplayed(TestData.VALID_EMAIL_FORMAT_ERROR_TEXT);
        addADistrictAdminModal.clearEmail();
        addADistrictAdminModal.typeEmail(adminEmail);
        addADistrictAdminModal.clickOnAddButton();
        Assert.assertEquals(manageDistrictAdminsPage.getAdminEmail(1), adminEmail);
        Assert.assertTrue(districtPage.getNotificationText().contains(TestData.CREATED_DISTRICT_ADMIN_NOTIFICATION_TEXT));
        districtPage.dismissNotification();
    }

    public void testRemoveDistrictAdmin(String organizationName) {
        int adminsNumber = manageDistrictAdminsPage.getAdminsNumber();
        manageDistrictAdminsPage.clickOnRemoveButton(1);
        Assert.assertEquals(removeDistrictAdminModal.getModalText(), TestData.REMOVE_DISTRICT_ADMIN_MODAL_TEXT);
        removeDistrictAdminModal.clickOnRemoveButton();
        Assert.assertTrue(manageDistrictAdminsPage.getNotificationText().contains(TestData.REMOVED_DISTRICT_ADMIN_NOTIFICATION_TEXT));
        districtPage.dismissNotification();
        Assert.assertEquals(manageDistrictAdminsPage.getAdminsNumber(), adminsNumber - 1);
        manageDistrictAdminsPage.clickXButton();
        Assert.assertEquals(districtPage.getOrganizationName(), organizationName);
    }

    public void testSearchButtonFromDistrictPage(String text, boolean sso, boolean roster) {
        districtPage.clickOnSearchButton();
        districtPage.typeText(text);
        districtPage.clickOnSearchButton();
        if (districtPage.isTeachersListDisplayed()) {
            Assert.assertTrue(districtPage.getSearchResultsText().contains(districtPage.getTeachersNumber() + " " + TestData.SEARCH_RESULTS_TEXT) && districtPage.getSearchResultsText().contains(text));
            for (int i = 0; i < districtPage.getTeachersNumber(); i++) {
                Assert.assertTrue(districtPage.getTeacherFirstName(i).contains(text) || districtPage.getTeacherLastName(i).contains(text) || districtPage.getTeacherEmail(i).contains(text));
                Assert.assertTrue(districtPage.getTeacherRole(i).contains(TestData.TEACHER_ROLE) || districtPage.getTeacherRole(i).contains(TestData.ADMIN_ROLE) || districtPage.getTeacherRole(i).contains(TestData.OWNER_ROLE));
                Assert.assertTrue(districtPage.isTeacherSchoolDisplayed(i));
                if(!districtPage.getTeacherSchoolName(i).equals(TestData.CSL_PARENTS_SCHOOL_NAME)){
                    districtPage.hoverOverEditButton(i);
                    if (!sso) {
                        if (!districtPage.getTeacherJoinedDate(i).equals(TestData.UNREGISTERED_TEACHER_STATUS)) {
                            Assert.assertTrue(districtPage.getEditButtonPopoverText().contains(TestData.DISABLED_EDIT_TEACHER_POPOVER_TEXT) || districtPage.getEditButtonPopoverText().contains(TestData.DISABLED_EDIT_SCHOOL_ADMIN_POPOVER_TEXT) || districtPage.getEditButtonPopoverText().contains(TestData.DISABLED_EDIT_DISTRICT_ADMIN_POPOVER_TEXT) || districtPage.getEditButtonPopoverText().contains(TestData.DISABLED_EDIT_OWNER_POPOVER_TEXT));
                        } else {
                            Assert.assertTrue(districtPage.getEditButtonPopoverText().contains(TestData.ENABLED_EDIT_TEACHER_POPOVER_TEXT) || districtPage.getEditButtonPopoverText().contains(TestData.ENABLED_EDIT_SCHOOL_ADMIN_POPOVER_TEXT) || districtPage.getEditButtonPopoverText().contains(TestData.ENABLED_EDIT_DISTRICT_ADMIN_POPOVER_TEXT));
                        }
                    } else {
                        Assert.assertTrue(districtPage.getEditButtonPopoverText().contains(TestData.ENABLED_EDIT_TEACHER_POPOVER_TEXT) || districtPage.getEditButtonPopoverText().contains(TestData.ENABLED_EDIT_SCHOOL_ADMIN_POPOVER_TEXT) || districtPage.getEditButtonPopoverText().contains(TestData.ENABLED_EDIT_DISTRICT_ADMIN_POPOVER_TEXT) || districtPage.getEditButtonPopoverText().contains(TestData.ENABLED_EDIT_OWNER_POPOVER_TEXT));
                    }
                }
            }
            for (int j = 0; j < districtPage.getTeachersNumber(); j++) {
                if (!roster) {
                    districtPage.hoverOverRemoveButton(j);
                    Assert.assertTrue(districtPage.getRemoveButtonPopoverText().contains(TestData.REMOVE_TEACHER_POPOVER_TEXT) || districtPage.getRemoveButtonPopoverText().contains(TestData.REMOVE_OWNER_POPOVER_TEXT) || districtPage.getRemoveButtonPopoverText().contains(TestData.REMOVE_SCHOOL_ADMIN_POPOVER_TEXT) || districtPage.getRemoveButtonPopoverText().contains(TestData.REMOVE_DISTRICT_ADMIN_POPOVER_TEXT));
                } else {
                    districtPage.hoverOverRemoveButton(j);
                    Assert.assertTrue(districtPage.getRemoveButtonPopoverText().contains(TestData.REMOVE_DISTRICT_ADMIN_POPOVER_TEXT) || districtPage.getRemoveButtonPopoverText().contains(TestData.REMOVE_OWNER_ROSTER_ON_POPOVER_TEXT) || districtPage.getRemoveButtonPopoverText().contains(TestData.REMOVE_TEACHER_ROSTER_ON_POPOVER_TEXT) || districtPage.getRemoveButtonPopoverText().contains(TestData.REMOVE_SCHOOL_ADMIN_POPOVER_TEXT));
                }
            }
        } else {
            Assert.assertTrue(districtPage.getNoSearchResultsText().contains(TestData.NO_SEARCH_RESULTS_TEXT) && districtPage.getNoSearchResultsText().contains(text));
        }
        districtPage.clickClearSearchButton();
    }

    public void testAddSchoolsModal(String newName, String existingName) {
        addSchoolsModal.typeSchoolName(TestData.NEW_COLLECTION_NAME);
        addSchoolsModal.clearSchoolName();
        addSchoolsModal.waitForNotificationToBeDisplayed(TestData.REQUIRED_FIELD_ERROR_TEXT);
        addSchoolsModal.typeSchoolName(existingName);
        addSchoolsModal.clickOnAddButton();
        addSchoolsModal.waitForNotificationToBeDisplayed(TestData.EXISTING_SCHOOL_ERROR_TEXT);
        addSchoolsModal.clearSchoolName();
        addSchoolsModal.typeSchoolName(newName);
        addSchoolsModal.hoverOverBulkUploadInfoIcon();
        Assert.assertEquals(addSchoolsModal.getBulkUploadInfoIconPopoverText(), TestData.BULK_UPLOAD_SCHOOLS_POPOVER_TEXT);
        Assert.assertTrue(addSchoolsModal.isUploadCsvButtonDisplayed());
        Assert.assertTrue(addSchoolsModal.isDownloadExampleCsvLinkDisplayed());
        addSchoolsModal.clickOnAddButton();
        Assert.assertTrue(districtPage.getNotificationText().contains(TestData.CREATED_SCHOOL_NOTIFICATION_TEXT));
        districtPage.dismissNotification();
        addSchoolsModal.waitForPageLoad();
        Assert.assertEquals(districtPage.getSchoolName(0), newName);
    }

    public void testAddSchoolFromAddButton(String newName, String existingName) {
        districtPage.clickOnAddButton();
        testAddSchoolsModal(newName, existingName);
    }

    public void testAddSchoolFromAddLink(String newName, String existingName) {
        districtPage.clickOnAddLink();
        testAddSchoolsModal(newName, existingName);
    }

    public void testRemoveSchool() {
        int schoolNumbers = districtPage.getSchoolsNumber();
        districtPage.clickRemoveActionButton(0);
        Assert.assertEquals(removeSchoolModal.getModalText(), TestData.REMOVE_SCHOOL_MODAL_TEXT);
        removeSchoolModal.clickOnRemoveButton();
        Assert.assertEquals(districtPage.getSchoolsNumber(), schoolNumbers - 1);
        Assert.assertTrue(districtPage.getNotificationText().contains(TestData.REMOVED_SCHOOL_NOTIFICATION_TEXT));
        districtPage.dismissNotification();
    }

    public void testSchoolPage(boolean sso, boolean roster) {
        Assert.assertTrue(schoolPage.isDistrictBreadcrumbsDisplayed());
        Assert.assertTrue(schoolPage.isOrganizationNameDisplayed());
        Assert.assertTrue(schoolPage.isEditOrganizationButtonDisplayed());
        schoolPage.hoverOverEditOrganizationButton();
        Assert.assertEquals(schoolPage.getEditOrganizationButtonPopoverText(), TestData.EDIT_SCHOOL_BUTTON_POPOVER_TEXT);
        Assert.assertTrue(schoolPage.isManageAdminsButtonDisplayed());
        schoolPage.hoverOverManageAdminsButton();
        Assert.assertEquals(schoolPage.getManageAdminsPopoverText(), TestData.MANAGE_SCHOOL_ADMINS_POPOVER_TEXT);
        Assert.assertTrue(schoolPage.isSearchButtonDisplayed());
        schoolPage.hoverOverSearchButton();
        Assert.assertEquals(schoolPage.getSearchButtonPopoverText(), TestData.SEARCH_BUTTON_POPOVER_TEXT);
        Assert.assertTrue(schoolPage.isAddButtonDisplayed());
        if (schoolPage.isTeachersListDisplayed()) {
            for (int i = 0; i < schoolPage.getTeachersNumber(); i++) {
                Assert.assertTrue(schoolPage.isTeacherEmailDisplayed(i));
                Assert.assertTrue(schoolPage.getTeacherRole(i).contains(TestData.ADMIN_ROLE) || schoolPage.getTeacherRole(i).contains(TestData.TEACHER_ROLE));
                schoolPage.hoverOverEditButton(i);
                if (!sso) {
                    if (!schoolPage.getTeacherJoinedDate(i).equals(TestData.UNREGISTERED_TEACHER_STATUS)) {
                        Assert.assertTrue(schoolPage.getEditButtonPopoverText().contains(TestData.DISABLED_EDIT_TEACHER_POPOVER_TEXT) || schoolPage.getEditButtonPopoverText().contains(TestData.DISABLED_EDIT_SCHOOL_ADMIN_POPOVER_TEXT));
                    } else {
                        Assert.assertTrue(schoolPage.getEditButtonPopoverText().contains(TestData.ENABLED_EDIT_TEACHER_POPOVER_TEXT) || schoolPage.getEditButtonPopoverText().contains(TestData.ENABLED_EDIT_SCHOOL_ADMIN_POPOVER_TEXT));
                    }
                } else {
                    if (!roster) {
                        Assert.assertFalse(schoolPage.getTeacherJoinedDate(i).contains(TestData.UNREGISTERED_TEACHER_STATUS));
                    }
                    Assert.assertTrue(schoolPage.getEditButtonPopoverText().contains(TestData.ENABLED_EDIT_TEACHER_POPOVER_TEXT) || schoolPage.getEditButtonPopoverText().contains(TestData.ENABLED_EDIT_SCHOOL_ADMIN_POPOVER_TEXT));
                }
                schoolPage.hoverOverRemoveButton(i);
                if (!roster) {
                    Assert.assertTrue(schoolPage.getRemoveButtonPopoverText().contains(TestData.REMOVE_TEACHER_POPOVER_TEXT) || schoolPage.getRemoveButtonPopoverText().contains(TestData.REMOVE_SCHOOL_ADMIN_POPOVER_TEXT));
                } else {
                    Assert.assertTrue(schoolPage.getRemoveButtonPopoverText().contains(TestData.REMOVE_TEACHER_ROSTER_ON_POPOVER_TEXT) || schoolPage.getRemoveButtonPopoverText().contains(TestData.REMOVE_SCHOOL_ADMIN_POPOVER_TEXT));
                }
            }
            if (!roster) {
                Assert.assertEquals(schoolPage.getAddLinkNumber(), 1);
                Assert.assertTrue(schoolPage.isAddLinkEditButtonDisplayed(0));
                Assert.assertTrue(schoolPage.isAddLinkRemoveButtonDisplayed(0));
            } else {
                Assert.assertFalse(schoolPage.isAddLinkDisplayed());
            }
        } else {
            if (!roster) {
                Assert.assertEquals(schoolPage.getAddLinkNumber(), 3);
                for (int i = 0; i < 3; i++) {
                    Assert.assertTrue(schoolPage.isAddLinkEditButtonDisplayed(i));
                    Assert.assertTrue(schoolPage.isAddLinkRemoveButtonDisplayed(i));
                }
            } else {
                Assert.assertFalse(schoolPage.isAddLinkDisplayed());
            }
        }
    }

    public void testEditSchoolModal(String newName, String existingName, boolean sso, boolean roster) {
        editSchoolModal.hoverOverOrganizationShortNameInfoIcon();
        Assert.assertEquals(editSchoolModal.getOrganizationShortNameInfoIconPopoverText(), TestData.SCHOOL_SHORT_NAME_POPOVER_TEXT);
        if (!roster) {
            editSchoolModal.clearSchoolName();
            editSchoolModal.clickOnSaveButton();
            editSchoolModal.waitForNotificationToBeDisplayed(TestData.REQUIRED_FIELD_ERROR_TEXT);
            editSchoolModal.typeSchoolName(existingName);
            editSchoolModal.clickOnSaveButton();
            editSchoolModal.waitForNotificationToBeDisplayed(TestData.EXISTING_SCHOOL_ERROR_TEXT);
            editSchoolModal.clearSchoolName();
            editSchoolModal.typeSchoolName(newName);
            editSchoolModal.typeOrganizationShortName(TestData.CONCEPT);
        } else {
            Assert.assertEquals(editSchoolModal.getSchoolName(), TestData.CSL_QA_CUSTOM_EXISTING_SCHOOL_NAME);
        }
        if (sso) {
            editSchoolModal.hoverOverSharingPrivilegesInfoIcon();
            Assert.assertTrue(editDistrictModal.getSharingPrivilegesInfoIconPopoverText().contains(TestData.SHARING_PRIVILEGES_SCHOOL_POPOVER_TEXT));
            editSchoolModal.isAdminPublishCheckboxDisplayed();
            editSchoolModal.isTeacherPublishCheckboxDisplayed();
            Assert.assertEquals(editSchoolModal.getAdminPublishOptionText(), TestData.ADMIN_PUBLISH_SCHOOL_OPTION_TEXT);
            Assert.assertEquals(editSchoolModal.getTeacherPublishOptionText(), TestData.TEACHER_PUBLISH_SCHOOL_OPTION_TEXT);
        }
    }

    public void testEditSchoolFromActionsButton(String newName, String existingName, boolean sso, boolean roster) {
        districtPage.clickEditActionButton(0);
        testEditSchoolModal(newName, existingName, sso, roster);
        editSchoolModal.clickOnSaveButton();
        if (!roster) {
            Assert.assertEquals(districtPage.getSchoolName(0), newName);
        } else {
            Assert.assertEquals(districtPage.getSchoolName(0), existingName);
        }
    }

    public void testEditSchoolFromEditOrganizationButton(String newName, String existingName, boolean sso, boolean roster) {
        districtPage.clickOnSchool(0);
        if (!roster) {
            schoolPage.dismissFlashNotification();
        }
        schoolPage.clickOnEditOrganizationButton();
        testEditSchoolModal(newName, existingName, sso, roster);
        editSchoolModal.clickOnSaveButton();
        if (!roster) {
            Assert.assertEquals(schoolPage.getOrganizationName(), newName);
        } else {
            Assert.assertEquals(schoolPage.getOrganizationName(), existingName);
        }
    }

    public void testAddTeacher(String teacherEmail) {
        addTeachersModal.typeEmail(TestData.INVALID_EMAIL);
        addTeachersModal.clearEmail();
        addTeachersModal.waitForNotificationToBeDisplayed(TestData.REQUIRED_FIELD_ERROR_TEXT);
        addTeachersModal.typeEmail(TestData.NEW_COLLECTION_NAME);
        addTeachersModal.waitForNotificationToBeDisplayed(TestData.VALID_EMAIL_FORMAT_ERROR_TEXT);
        addTeachersModal.clearEmail();
        addTeachersModal.typeEmail(teacherEmail);
        addTeachersModal.hoverOverBulkUploadInfoIcon();
        Assert.assertEquals(addTeachersModal.getBulkUploadInfoIconPopoverText(), TestData.BULK_UPLOAD_TEACHERS_POPOVER_TEXT);
        Assert.assertTrue(addTeachersModal.isUploadCsvButtonDisplayed());
        Assert.assertTrue(addTeachersModal.isDownloadExampleCsvLinkDisplayed());
        addTeachersModal.clickOnAddButton();
        Assert.assertTrue(schoolPage.getNotificationText().contains(TestData.CREATED_TEACHER_NOTIFICATION_TEXT));
        schoolPage.dismissNotification();
        Assert.assertEquals(schoolPage.getTeacherEmail(0), teacherEmail);
        Assert.assertTrue(schoolPage.getTeacherRole(0).contains(TestData.TEACHER_ROLE));
    }

    public void testAddTeacherFromAddButton() {
        schoolPage.clickOnAddButton();
        testAddTeacher(TestData.GET_NEW_EMAIL());
    }

    public void testAddTeacherFromAddLink(String teacherEmail) {
        schoolPage.clickOnAddLink();
        testAddTeacher(teacherEmail);
    }

    public void testRemoveTeacher() {
        int teachersNumber = schoolPage.getTeachersNumber();
        schoolPage.clickRemoveActionButton(0);
        Assert.assertEquals(removeTeacherModal.getModalText(), TestData.REMOVE_TEACHER_MODAL_TEXT);
        removeTeacherModal.clickOnRemoveButton();
        Assert.assertTrue(schoolPage.getNotificationText().contains(TestData.REMOVED_TEACHER_NOTIFICATION_TEXT));
        schoolPage.dismissNotification();
        Assert.assertEquals(schoolPage.getTeachersNumber(), teachersNumber - 1);
    }

    public void testEditTeacher(boolean sso) {
        if (sso) {
            schoolPage.clickEditActionButton(0);
            Assert.assertTrue(editTeacherModal.isEmailFieldDisabled());
            Assert.assertTrue(editTeacherModal.isFirstNameFieldDisabled());
            Assert.assertTrue(editTeacherModal.isLastNameFieldDisabled());
            editTeacherModal.isPublishCheckboxDisplayed();
            editTeacherModal.hoverOverPublishingOptionInfoIcon();
            Assert.assertEquals(editTeacherModal.getPublishingOptionInfoIconPopoverText(), TestData.PUBLISHING_PRIVILEGES_POPOVER_TEXT);
            editTeacherModal.clickOnSaveButton();
        } else {
            if (!schoolPage.getTeacherJoinedDate(0).equals(TestData.UNREGISTERED_TEACHER_STATUS)) {
                schoolPage.hoverOverEditButton(0);
                Assert.assertTrue(schoolPage.getEditButtonPopoverText().contains(TestData.DISABLED_EDIT_SCHOOL_ADMIN_POPOVER_TEXT) || schoolPage.getEditButtonPopoverText().contains(TestData.DISABLED_EDIT_TEACHER_POPOVER_TEXT));
            } else {
                schoolPage.clickEditActionButton(0);
                editTeacherModal.clearEmail();
                Assert.assertEquals(editTeacherModal.getErrorText(), TestData.REQUIRED_FIELD_ERROR_TEXT);
                editTeacherModal.typeEmail(TestData.INVALID_EMAIL);
                editTeacherModal.typeFirstName(TestData.CONCEPT);
                editTeacherModal.typeLastName(TestData.REGULAR_RESOURCE_TYPE);
                editTeacherModal.clickOnSaveButton();
                Assert.assertEquals(schoolPage.getTeacherEmail(0), TestData.INVALID_EMAIL);
                Assert.assertEquals(schoolPage.getTeacherFirstName(0), TestData.CONCEPT);
                Assert.assertEquals(schoolPage.getTeacherLastName(0), TestData.REGULAR_RESOURCE_TYPE);
            }
        }
    }

    public void testManageSchoolAdminPage(boolean sso) {
        Assert.assertTrue(manageSchoolAdminsPage.isOrganizationNameDisplayed());
        Assert.assertTrue(manageSchoolAdminsPage.isEditOrganizationButtonDisplayed());
        Assert.assertTrue(manageSchoolAdminsPage.isManageAdminsButtonDisplayed());
        Assert.assertTrue(manageSchoolAdminsPage.isSearchButtonDisplayed());
        Assert.assertEquals(manageSchoolAdminsPage.getTitleText(), TestData.MANAGE_SCHOOL_ADMINS_TITLE);
        if (manageSchoolAdminsPage.isAdminsListDisplayed()) {
            for (int i = 0; i < manageSchoolAdminsPage.getAdminsNumber(); i++) {
                Assert.assertTrue(manageSchoolAdminsPage.isAdminEmailDisplayed(i));
                Assert.assertTrue(manageSchoolAdminsPage.isRemoveButtonDisplayed(i));
                manageSchoolAdminsPage.hoverOverRemoveButton(i);
                Assert.assertTrue(manageSchoolAdminsPage.getRemoveButtonPopoverText().contains(TestData.REMOVE_SCHOOL_ADMIN_POPOVER_TEXT));
                if (sso) {
                    Assert.assertTrue(manageSchoolAdminsPage.isEditButtonDisplayed(i));
                    manageSchoolAdminsPage.hoverOverEditButton(i);
                    Assert.assertTrue(manageSchoolAdminsPage.getEditButtonPopoverText().contains(TestData.ENABLED_EDIT_SCHOOL_ADMIN_POPOVER_TEXT));
                }
            }
            Assert.assertEquals(manageSchoolAdminsPage.getAddAdminLinkNumber(), 1);
            Assert.assertTrue(manageSchoolAdminsPage.isAddAdminLinkRemoveButtonDisplayed(0));
            if (sso) {
                Assert.assertTrue(manageSchoolAdminsPage.isAddAdminLinkEditButtonDisplayed(0));
            }
        } else {
            Assert.assertEquals(manageSchoolAdminsPage.getAddAdminLinkNumber(), 3);
            for (int i = 0; i < 3; i++) {
                Assert.assertTrue(manageSchoolAdminsPage.isAddAdminLinkRemoveButtonDisplayed(i));
                if (sso) {
                    Assert.assertTrue(manageSchoolAdminsPage.isAddAdminLinkEditButtonDisplayed(i));
                }
            }
        }
    }

    public void testAddSchoolAdmin(String adminEmail) {
        manageSchoolAdminsPage.clickOnAddAdminLink();
        addASchoolAdminModal.typeEmail(TestData.INVALID_EMAIL);
        addASchoolAdminModal.clearEmail();
        addASchoolAdminModal.waitForNotificationToBeDisplayed(TestData.REQUIRED_FIELD_ERROR_TEXT);
        addASchoolAdminModal.typeEmail(TestData.NEW_COLLECTION_NAME);
        addASchoolAdminModal.waitForNotificationToBeDisplayed(TestData.VALID_EMAIL_FORMAT_ERROR_TEXT);
        addASchoolAdminModal.clearEmail();
        addASchoolAdminModal.typeEmail(adminEmail);
        addASchoolAdminModal.clickOnAddButton();
        Assert.assertTrue(schoolPage.getNotificationText().contains(TestData.CREATED_SCHOOL_ADMIN_NOTIFICATION_TEXT));
        districtPage.dismissNotification();
        Assert.assertEquals(manageSchoolAdminsPage.getAdminEmail(0), adminEmail);
    }

    public void testRemoveSchoolAdmin() {
        int adminsNumber = manageSchoolAdminsPage.getAdminsNumber();
        manageSchoolAdminsPage.clickOnRemoveButton(0);
        Assert.assertEquals(removeSchoolAdminModal.getModalText(), TestData.REMOVE_SCHOOL_ADMIN_MODAL_TEXT);
        removeSchoolAdminModal.clickOnRemoveButton();
        Assert.assertTrue(schoolPage.getNotificationText().contains(TestData.REMOVED_SCHOOL_ADMIN_NOTIFICATION_TEXT));
        districtPage.dismissNotification();
        Assert.assertEquals(manageSchoolAdminsPage.getAdminsNumber(), adminsNumber - 1);
        schoolPage.clickOnManageAdminsButton();
        Assert.assertTrue(schoolPage.getTeacherRole(0).contains(TestData.TEACHER_ROLE));
    }

    public void testSearchButtonFromSchoolPage(String text, boolean sso, boolean roster) {
        schoolPage.clickOnSearchButton();
        schoolPage.typeText(text);
        schoolPage.clickOnSearchButton();
        if (schoolPage.isTeachersListDisplayed()) {
            Assert.assertTrue(schoolPage.getSearchResultsText().contains(schoolPage.getTeachersNumber() + " " + TestData.SEARCH_RESULTS_TEXT) && schoolPage.getSearchResultsText().contains(text));
            for (int i = 0; i < schoolPage.getTeachersNumber(); i++) {
                Assert.assertTrue(schoolPage.getTeacherFirstName(i).contains(text) || schoolPage.getTeacherLastName(i).contains(text) || schoolPage.getTeacherEmail(i).contains(text));
                Assert.assertTrue(schoolPage.getTeacherRole(i).contains(TestData.TEACHER_ROLE) || schoolPage.getTeacherRole(i).contains(TestData.ADMIN_ROLE));
                schoolPage.hoverOverEditButton(i);
                if (sso) {
                    Assert.assertTrue(schoolPage.getEditButtonPopoverText().contains(TestData.ENABLED_EDIT_TEACHER_POPOVER_TEXT) || schoolPage.getEditButtonPopoverText().contains(TestData.ENABLED_EDIT_SCHOOL_ADMIN_POPOVER_TEXT));
                } else {
                    if (!schoolPage.getTeacherJoinedDate(i).equals(TestData.UNREGISTERED_TEACHER_STATUS)) {
                        Assert.assertTrue(schoolPage.getEditButtonPopoverText().contains(TestData.DISABLED_EDIT_TEACHER_POPOVER_TEXT) || schoolPage.getEditButtonPopoverText().contains(TestData.DISABLED_EDIT_SCHOOL_ADMIN_POPOVER_TEXT));
                    } else {
                        Assert.assertTrue(schoolPage.getEditButtonPopoverText().contains(TestData.ENABLED_EDIT_TEACHER_POPOVER_TEXT) || schoolPage.getEditButtonPopoverText().contains(TestData.ENABLED_EDIT_SCHOOL_ADMIN_POPOVER_TEXT));
                    }
                }
            }

            for (int j = 0; j < schoolPage.getTeachersNumber(); j++) {
                if (!roster) {
                    schoolPage.hoverOverRemoveButton(j);
                    Assert.assertTrue(schoolPage.getRemoveButtonPopoverText().contains(TestData.REMOVE_TEACHER_POPOVER_TEXT) || schoolPage.getRemoveButtonPopoverText().contains(TestData.REMOVE_SCHOOL_ADMIN_POPOVER_TEXT));
                } else {
                    schoolPage.hoverOverRemoveButton(j);
                    Assert.assertTrue(schoolPage.getRemoveButtonPopoverText().contains(TestData.REMOVE_TEACHER_ROSTER_ON_POPOVER_TEXT) || schoolPage.getRemoveButtonPopoverText().contains(TestData.REMOVE_SCHOOL_ADMIN_POPOVER_TEXT));
                }
            }

        } else {
            Assert.assertTrue(schoolPage.getNoSearchResultsText().contains(TestData.NO_SEARCH_RESULTS_TEXT) && schoolPage.getNoSearchResultsText().contains(text));
        }
        schoolPage.clickClearSearchButton();
    }
}
