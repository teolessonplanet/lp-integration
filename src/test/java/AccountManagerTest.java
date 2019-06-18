import com.lessonplanet.pages.*;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import util.TestData;

public class AccountManagerTest extends BaseTest {
    private HeaderPage headerPage;
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
        headerPage = new HeaderPage(webDriver);
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

    @Test(description = "District Page - lessonp-918: District Page: Add School, Remove School")
    public void testLessonp_918() {
        reachAccountManagerPage();
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
            for (int i = 0; i < districtPage.getSchoolsNumber(); i++) {
                Assert.assertTrue(districtPage.isSchoolNameDisplayed());
                Assert.assertTrue(districtPage.isNrOfTeachersDisplayed());
                Assert.assertTrue(districtPage.isNrOfResourcesUploadedDisplayed());
                Assert.assertTrue(districtPage.isSeeSchoolReportingActionButtonDisplayed(i));
                Assert.assertTrue(districtPage.isEditActionButtonDisplayed(i));
                Assert.assertTrue(districtPage.isRemoveActionButtonDisplayed(i));
            }
            Assert.assertEquals(districtPage.getAddLinkNumber(), 1);
            Assert.assertTrue(districtPage.isAddLinkSeeSchoolReportingButtonDisplayed(0));
            Assert.assertTrue(districtPage.isAddLinkEditButtonDisplayed(0));
            Assert.assertTrue(districtPage.isAddLinkRemoveButtonDisplayed(0));
        } else {
            Assert.assertEquals(districtPage.getAddLinkNumber(), 3);
            for (int i = 0; i < 3; i++) {
                Assert.assertTrue(districtPage.isAddLinkSeeSchoolReportingButtonDisplayed(i));
                Assert.assertTrue(districtPage.isAddLinkEditButtonDisplayed(i));
                Assert.assertTrue(districtPage.isAddLinkRemoveButtonDisplayed(i));
            }
        }
        testAddSchoolFromAddButton(TestData.GET_NEW_SCHOOL_NAME());
        testRemoveSchool();
        testAddSchoolFromAddLink(TestData.GET_NEW_SCHOOL_NAME());
        testRemoveSchool();
    }

    @Test(description = "District Page - lessonp-901: Edit District")
    public void testLessonp_901() {
        reachAccountManagerPage();
        districtPage.clickOnEditOrganizationButton();
        Assert.assertEquals(editDistrictModal.getDistrictName(), TestData.DISTRICT_NAME);
        editDistrictModal.hoverOverDistrictNameInfoIcon();
        Assert.assertEquals(editDistrictModal.getDistrictNameInfoIconPopoverText(), TestData.DISTRICT_NAME_POPOVER_TEXT);
        editDistrictModal.typeOrganizationShortName(TestData.CONCEPT);
        editDistrictModal.hoverOverOrganizationShortNameInfoIcon();
        Assert.assertEquals(editDistrictModal.getOrganizationShortNameInfoIconPopoverText(), TestData.DISTRICT_SHORT_NAME_POPOVER_TEXT);
        editDistrictModal.clickOnSaveButton();
        districtPage.clickOnEditOrganizationButton();
        Assert.assertEquals(editDistrictModal.getDistrictShortName(), TestData.CONCEPT);
        editDistrictModal.clickXButton();
        Assert.assertEquals(districtPage.getOrganizationName(), TestData.DISTRICT_NAME);
    }

    @Test(description = "District Page - lessonp-904: Manage District Admins Page: Add District Admin, Remove District Admin")
    public void testLessonp_904() {
        reachAccountManagerPage();
        districtPage.clickOnManageAdminsButton();
        testManageDistrictAdminsPage();
        testAddDistrictAdmin();
        testRemoveDistrictAdmin();
        manageDistrictAdminsPage.clickXButton();
        Assert.assertEquals(districtPage.getOrganizationName(), TestData.DISTRICT_NAME);
    }

    @Test(description = "District Page - lessonp-4165: Search by name and email from District Page")
    public void testLessonp_4165() {
        reachAccountManagerPage();
        testSearchButtonFromDistrictPage(TestData.VALID_EMAIL_REGULAR_SITE_LICENCE);
        testSearchButtonFromDistrictPage(TestData.INVALID_EMAIL);
        testSearchButtonFromDistrictPage(TestData.OWNER_FIRST_NAME);
        testSearchButtonFromDistrictPage(TestData.OWNER_FIRST_NAME + " " + TestData.OWNER_LAST_NAME);
    }

    @Test(description = "School Page - lessonp-920: School Page: Add Teacher, Edit Teacher, Remove Teacher")
    public void testLessonp_920() {
        reachAccountManagerPage();
        testAddSchoolFromAddButton(TestData.GET_NEW_SCHOOL_NAME());
        districtPage.clickOnSchool(0);
        testSchoolPage();
        Assert.assertTrue(schoolPage.getFlashNotificationText().contains(TestData.NO_TEACHER_ADDED_NOTIFICATION_TEXT));
        testAddTeacherFromAddButton();
        testSchoolPage();
        Assert.assertTrue(schoolPage.getFlashNotificationText().contains(TestData.NO_SCHOOL_ADMIN_ADDED_NOTIFICATION_TEXT));
        testEditTeacher(TestData.GET_NEW_EMAIL(), TestData.CONCEPT, TestData.PRO_OPTION_TEXT);
        testRemoveTeacher();
        testAddTeacherFromAddLink();
        testEditTeacher(TestData.GET_NEW_EMAIL(), TestData.OWNER_FIRST_NAME, TestData.OWNER_LAST_NAME);
        testRemoveTeacher();
        testSchoolPage();
        schoolPage.clickOnDistrictBreadcrumbs();
        testRemoveSchool();
    }

    @Test(description = "School Page - lessonp-895: Edit School")
    public void testLessonp_895() {
        reachAccountManagerPage();
        testAddSchoolFromAddLink(TestData.GET_NEW_SCHOOL_NAME());
        testEditSchoolFromActionsButton(TestData.GET_NEW_SCHOOL_NAME());
        testEditSchoolFromEditOrganizationButton(TestData.GET_NEW_SCHOOL_NAME());
        schoolPage.clickOnDistrictBreadcrumbs();
        testRemoveSchool();
    }

    @Test(description = "School Page - lessonp-924: Manage School Admins Page: Add School Admin, Remove School Admin")
    public void testLessonp_924() {
        reachAccountManagerPage();
        testAddSchoolFromAddButton(TestData.GET_NEW_SCHOOL_NAME());
        districtPage.clickOnSchool(0);
        schoolPage.clickOnManageAdminsButton();
        testManageSchoolAdminPage();
        testAddSchoolAdmin();
        testManageSchoolAdminPage();
        schoolPage.clickOnManageAdminsButton();
        testSchoolPage();
        schoolPage.clickOnManageAdminsButton();
        testRemoveSchoolAdmin();
        schoolPage.clickOnManageAdminsButton();
        Assert.assertEquals(schoolPage.getTeacherRole(0), TestData.TEACHER_ROLE);
        schoolPage.clickOnDistrictBreadcrumbs();
        testRemoveSchool();
    }

    @Test(description = "School Page - lessonp-4166: Search by name or email from School Page")
    public void testLessonp_4166() {
        reachAccountManagerPage();
        districtPage.clickOnExistingSchool();
        testSearchButtonFromSchoolPage(TestData.EXISTING_TEACHER_EMAIL);
        testSearchButtonFromSchoolPage(TestData.INVALID_EMAIL);
        testSearchButtonFromSchoolPage(TestData.TEACHER_LAST_NAME);
        testSearchButtonFromSchoolPage(TestData.TEACHER_FIRST_NAME + " " + TestData.TEACHER_LAST_NAME);
    }

    public void reachAccountManagerPage() {
        loginPage.performLogin(TestData.VALID_EMAIL_REGULAR_SITE_LICENCE, TestData.VALID_PASSWORD);
        headerPage.hoverOverUserDropDownButton();
        headerPage.clickOnAdminManagerButton();
        Assert.assertEquals(headerPage.getPath(), TestData.ACCOUNT_MANAGER_PAGE_PATH);
    }

    private void testManageDistrictAdminsPage() {
        Assert.assertTrue(manageDistrictAdminsPage.isOrganizationNameDisplayed());
        Assert.assertTrue(manageDistrictAdminsPage.isEditOrganizationButtonDisplayed());
        Assert.assertTrue(manageDistrictAdminsPage.isManageAdminsButtonDisplayed());
        Assert.assertTrue(manageDistrictAdminsPage.isSearchButtonDisplayed());
        Assert.assertEquals(manageDistrictAdminsPage.getTitleText(), TestData.MANAGE_DISTRICT_ADMINS_TITLE);
        Assert.assertEquals(manageDistrictAdminsPage.getAdminEmail(0), TestData.VALID_EMAIL_REGULAR_SITE_LICENCE);
        manageDistrictAdminsPage.hoverOverRemoveButton(0);
        Assert.assertEquals(manageDistrictAdminsPage.getRemoveButtonPopoverText(), TestData.REMOVE_OWNER_POPOVER_TEXT);
        if (manageDistrictAdminsPage.getAdminsNumber() > 1) {
            for (int i = 1; i < manageDistrictAdminsPage.getAdminsNumber(); i++) {
                Assert.assertTrue(manageDistrictAdminsPage.isAdminEmailDisplayed(i));
                Assert.assertTrue(manageDistrictAdminsPage.isRemoveButtonDisplayed(i));
                manageDistrictAdminsPage.hoverOverRemoveButton(i);
                Assert.assertEquals(manageDistrictAdminsPage.getRemoveButtonPopoverText(), TestData.REMOVE_DISTRICT_ADMIN_POPOVER_TEXT);
            }
        }
        Assert.assertEquals(manageSchoolAdminsPage.getAddAdminLinkNumber(), 1);
        Assert.assertTrue(manageDistrictAdminsPage.isAddAdminLinkRemoveButtonDisplayed(0));
    }

    private void testAddDistrictAdmin() {
        manageDistrictAdminsPage.clickOnAddAdminLink();
        addADistrictAdminModal.typeEmail(TestData.INVALID_EMAIL);
        addADistrictAdminModal.clearEmail();
        addADistrictAdminModal.waitForNotificationToBeDisplayed(TestData.REQUIRED_FIELD_ERROR_TEXT);
        addADistrictAdminModal.typeEmail(TestData.VALID_EMAIL_REGULAR_SITE_LICENCE);
        addADistrictAdminModal.clickOnAddButton();
        addADistrictAdminModal.waitForNotificationToBeDisplayed(TestData.EXISTING_EMAIL_ERROR_TEXT);
        addADistrictAdminModal.clearEmail();
        addADistrictAdminModal.typeEmail(TestData.NEW_COLLECTION_NAME);
        addADistrictAdminModal.waitForNotificationToBeDisplayed(TestData.VALID_EMAIL_FORMAT_ERROR_TEXT);
        addADistrictAdminModal.clearEmail();
        addADistrictAdminModal.typeEmail(TestData.VALID_EMAIL_FREEMIUM);
        addADistrictAdminModal.clickOnAddButton();
        Assert.assertEquals(manageDistrictAdminsPage.getAdminEmail(1), TestData.VALID_EMAIL_FREEMIUM);
        Assert.assertTrue(districtPage.getNotificationText().contains(TestData.CREATED_DISTRICT_ADMIN_NOTIFICATION_TEXT));
        districtPage.dismissNotification();
    }

    private void testRemoveDistrictAdmin() {
        int adminsNumber = manageDistrictAdminsPage.getAdminsNumber();
        manageDistrictAdminsPage.clickOnRemoveButton(1);
        Assert.assertEquals(removeDistrictAdminModal.getModalText(), TestData.REMOVE_DISTRICT_ADMIN_MODAL_TEXT);
        removeDistrictAdminModal.clickOnRemoveButton();
        Assert.assertTrue(manageDistrictAdminsPage.getNotificationText().contains(TestData.REMOVED_DISTRICT_ADMIN_NOTIFICATION_TEXT));
        districtPage.dismissNotification();
        Assert.assertEquals(manageDistrictAdminsPage.getAdminsNumber(), adminsNumber - 1);
    }

    private void testSearchButtonFromDistrictPage(String text) {
        districtPage.clickOnSearchButton();
        districtPage.typeText(text);
        districtPage.clickOnSearchButton();
        if (districtPage.isTeachersListDisplayed()) {
            Assert.assertTrue(districtPage.getSearchResultsText().contains(districtPage.getTeachersNumber() + " " + TestData.SEARCH_RESULTS_TEXT) && districtPage.getSearchResultsText().contains(text));
            for (int i = 0; i < districtPage.getTeachersNumber(); i++) {
                Assert.assertTrue(districtPage.getTeacherFirstName(i).contains(text) || districtPage.getTeacherLastName(i).contains(text) || districtPage.getTeacherEmail(i).contains(text));
                Assert.assertTrue(districtPage.getTeacherRole(i).contains(TestData.TEACHER_ROLE) || districtPage.getTeacherRole(i).contains(TestData.ADMIN_ROLE) || districtPage.getTeacherRole(i).contains(TestData.OWNER_ROLE));
                Assert.assertTrue(districtPage.isTeacherSchoolDisplayed(i));
                districtPage.hoverOverEditButton(i);
                if (!districtPage.getTeacherJoinedDate(i).equals(TestData.UNREGISTERED_TEACHER_STATUS)) {
                    Assert.assertTrue(districtPage.getEditButtonPopoverText().contains(TestData.EDIT_REGISTERED_TEACHER_POPOVER_TEXT) || districtPage.getEditButtonPopoverText().contains(TestData.EDIT_REGISTERED_SCHOOL_ADMIN_POPOVER_TEXT) || districtPage.getEditButtonPopoverText().contains(TestData.EDIT_REGISTERED_DISTRICT_ADMIN_POPOVER_TEXT) || districtPage.getEditButtonPopoverText().contains(TestData.EDIT_OWNER_POPOVER_TEXT));
                } else {
                    Assert.assertTrue(districtPage.getEditButtonPopoverText().contains(TestData.EDIT_UNREGISTERED_TEACHER_POPOVER_TEXT) || districtPage.getEditButtonPopoverText().contains(TestData.EDIT_UNREGISTERED_SCHOOL_ADMIN_POPOVER_TEXT) || districtPage.getEditButtonPopoverText().contains(TestData.EDIT_UNREGISTERED_DISTRICT_ADMIN_POPOVER_TEXT));
                }
                districtPage.hoverOverRemoveButton(i);
                if (districtPage.getTeacherRole(i).equals(TestData.OWNER_ROLE)) {
                    Assert.assertEquals(districtPage.getRemoveButtonPopoverText(), TestData.REMOVE_OWNER_POPOVER_TEXT);
                }
                if (districtPage.getTeacherRole(i).equals(TestData.ADMIN_ROLE)) {
                    Assert.assertTrue(districtPage.getRemoveButtonPopoverText().contains(TestData.REMOVE_SCHOOL_ADMIN_POPOVER_TEXT) || districtPage.getRemoveButtonPopoverText().contains(TestData.REMOVE_DISTRICT_ADMIN_POPOVER_TEXT));
                }
                if (districtPage.getTeacherRole(i).equals(TestData.TEACHER_ROLE)) {
                    Assert.assertEquals(districtPage.getRemoveButtonPopoverText(), TestData.REMOVE_TEACHER_POPOVER_TEXT);
                }
            }
        } else {
            Assert.assertTrue(districtPage.getNoSearchResultsText().contains(TestData.NO_SEARCH_RESULTS_TEXT) && districtPage.getNoSearchResultsText().contains(text));
        }
        districtPage.clickClearSearchButton();
    }

    private void testAddSchoolsModal(String name) {
        addSchoolsModal.typeSchoolName(TestData.NEW_COLLECTION_NAME);
        addSchoolsModal.clearSchoolName();
        addSchoolsModal.waitForNotificationToBeDisplayed(TestData.REQUIRED_FIELD_ERROR_TEXT);
        addSchoolsModal.typeSchoolName(TestData.EXISTING_SCHOOL_NAME);
        addSchoolsModal.clickOnAddButton();
        addSchoolsModal.waitForNotificationToBeDisplayed(TestData.EXISTING_SCHOOL_ERROR_TEXT);
        addSchoolsModal.clearSchoolName();
        addSchoolsModal.typeSchoolName(name);
        addSchoolsModal.hoverOverBulkUploadInfoIcon();
        Assert.assertEquals(addSchoolsModal.getBulkUploadInfoIconPopoverText(), TestData.BULK_UPLOAD_SCHOOLS_POPOVER_TEXT);
        Assert.assertTrue(addSchoolsModal.isUploadCsvButtonDisplayed());
        Assert.assertTrue(addSchoolsModal.isDownloadExampleCsvLinkDisplayed());
        addSchoolsModal.clickOnAddButton();
        Assert.assertTrue(districtPage.getNotificationText().contains(TestData.CREATED_SCHOOL_NOTIFICATION_TEXT));
        districtPage.dismissNotification();
        addSchoolsModal.waitForPageLoad();
        Assert.assertEquals(districtPage.getSchoolName(0), name);
    }

    private void testAddSchoolFromAddButton(String name) {
        districtPage.clickOnAddButton();
        testAddSchoolsModal(name);
    }

    private void testAddSchoolFromAddLink(String name) {
        districtPage.clickOnAddLink();
        testAddSchoolsModal(name);
    }

    private void testRemoveSchool() {
        int schoolNumbers = districtPage.getSchoolsNumber();
        districtPage.clickRemoveActionButton(0);
        Assert.assertEquals(removeSchoolModal.getModalText(), TestData.REMOVE_SCHOOL_MODAL_TEXT);
        removeSchoolModal.clickOnRemoveButton();
        Assert.assertEquals(districtPage.getSchoolsNumber(), schoolNumbers - 1);
        Assert.assertTrue(districtPage.getNotificationText().contains(TestData.REMOVED_SCHOOL_NOTIFICATION_TEXT));
        districtPage.dismissNotification();
    }

    private void testSchoolPage() {
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
                if (!schoolPage.getTeacherJoinedDate(i).equals(TestData.UNREGISTERED_TEACHER_STATUS)) {
                    Assert.assertTrue(schoolPage.getEditButtonPopoverText().contains(TestData.EDIT_REGISTERED_TEACHER_POPOVER_TEXT) || schoolPage.getEditButtonPopoverText().contains(TestData.EDIT_REGISTERED_SCHOOL_ADMIN_POPOVER_TEXT));
                } else {
                    Assert.assertTrue(schoolPage.getEditButtonPopoverText().contains(TestData.EDIT_UNREGISTERED_TEACHER_POPOVER_TEXT) || schoolPage.getEditButtonPopoverText().contains(TestData.EDIT_UNREGISTERED_SCHOOL_ADMIN_POPOVER_TEXT));
                }
                Assert.assertTrue(schoolPage.isRemoveActionButtonDisplayed(i));
            }
            Assert.assertEquals(schoolPage.getAddLinkNumber(), 1);
            Assert.assertTrue(schoolPage.isAddLinkEditButtonDisplayed(0));
            Assert.assertTrue(schoolPage.isAddLinkRemoveButtonDisplayed(0));
        } else {
            Assert.assertEquals(schoolPage.getAddLinkNumber(), 3);
            for (int i = 0; i < 3; i++) {
                Assert.assertTrue(schoolPage.isAddLinkEditButtonDisplayed(i));
                Assert.assertTrue(schoolPage.isAddLinkRemoveButtonDisplayed(i));
            }
        }
    }

    private void testEditSchoolModal(String name) {
        editSchoolModal.hoverOverOrganizationShortNameInfoIcon();
        Assert.assertEquals(editSchoolModal.getOrganizationShortNameInfoIconPopoverText(), TestData.SCHOOL_SHORT_NAME_POPOVER_TEXT);
        editSchoolModal.clearSchoolName();
        editSchoolModal.clickOnSaveButton();
        editSchoolModal.waitForNotificationToBeDisplayed(TestData.REQUIRED_FIELD_ERROR_TEXT);
        editSchoolModal.typeSchoolName(TestData.EXISTING_SCHOOL_NAME);
        editSchoolModal.clickOnSaveButton();
        editSchoolModal.waitForNotificationToBeDisplayed(TestData.EXISTING_SCHOOL_ERROR_TEXT);
        editSchoolModal.clearSchoolName();
        editSchoolModal.typeSchoolName(name);
        editSchoolModal.typeOrganizationShortName(TestData.CONCEPT);
        editSchoolModal.clickOnSaveButton();
    }

    private void testEditSchoolFromActionsButton(String name) {
        districtPage.clickEditActionButton(0);
        testEditSchoolModal(name);
        Assert.assertEquals(districtPage.getSchoolName(0), name);
    }

    private void testEditSchoolFromEditOrganizationButton(String name) {
        districtPage.clickOnSchool(0);
        schoolPage.dismissFlashNotification();
        schoolPage.clickOnEditOrganizationButton();
        testEditSchoolModal(name);
        Assert.assertEquals(schoolPage.getOrganizationName(), name);
    }

    private void testAddTeacher(String email) {
        addTeachersModal.typeEmail(TestData.INVALID_EMAIL);
        addTeachersModal.clearEmail();
        addTeachersModal.waitForNotificationToBeDisplayed(TestData.REQUIRED_FIELD_ERROR_TEXT);
        addTeachersModal.typeEmail(TestData.NEW_COLLECTION_NAME);
        addTeachersModal.waitForNotificationToBeDisplayed(TestData.VALID_EMAIL_FORMAT_ERROR_TEXT);
        addTeachersModal.clearEmail();
        addTeachersModal.typeEmail(email);
        addTeachersModal.hoverOverBulkUploadInfoIcon();
        Assert.assertEquals(addTeachersModal.getBulkUploadInfoIconPopoverText(), TestData.BULK_UPLOAD_TEACHERS_POPOVER_TEXT);
        Assert.assertTrue(addTeachersModal.isUploadCsvButtonDisplayed());
        Assert.assertTrue(addTeachersModal.isDownloadExampleCsvLinkDisplayed());
        addTeachersModal.clickOnAddButton();
        Assert.assertTrue(schoolPage.getNotificationText().contains(TestData.CREATED_TEACHER_NOTIFICATION_TEXT));
        schoolPage.dismissNotification();
        Assert.assertEquals(schoolPage.getTeacherEmail(0), email);
        Assert.assertTrue(schoolPage.getTeacherRole(0).contains(TestData.TEACHER_ROLE));
    }

    private void testAddTeacherFromAddButton() {
        schoolPage.clickOnAddButton();
        testAddTeacher(TestData.GET_NEW_EMAIL());
    }

    private void testAddTeacherFromAddLink() {
        schoolPage.clickOnAddLink();
        testAddTeacher(TestData.VALID_EMAIL_ACTIVE);
    }

    private void testRemoveTeacher() {
        int teachersNumber = schoolPage.getTeachersNumber();
        schoolPage.clickRemoveActionButton(0);
        Assert.assertEquals(removeTeacherModal.getModalText(), TestData.REMOVE_TEACHER_MODAL_TEXT);
        removeTeacherModal.clickOnRemoveButton();
        Assert.assertTrue(schoolPage.getNotificationText().contains(TestData.REMOVED_TEACHER_NOTIFICATION_TEXT));
        schoolPage.dismissNotification();
        Assert.assertEquals(schoolPage.getTeachersNumber(), teachersNumber - 1);
    }

    private void testEditTeacher(String email, String firstName, String lastName) {
        if (!schoolPage.getTeacherJoinedDate(0).equals(TestData.UNREGISTERED_TEACHER_STATUS)) {
            schoolPage.hoverOverEditButton(0);
            Assert.assertTrue(schoolPage.getEditButtonPopoverText().contains(TestData.EDIT_REGISTERED_SCHOOL_ADMIN_POPOVER_TEXT) || schoolPage.getEditButtonPopoverText().contains(TestData.EDIT_REGISTERED_TEACHER_POPOVER_TEXT));
        } else {
            schoolPage.clickEditActionButton(0);
            editTeacherModal.clearEmail();
            Assert.assertEquals(editTeacherModal.getErrorText(), TestData.REQUIRED_FIELD_ERROR_TEXT);
            editTeacherModal.typeEmail(email);
            editTeacherModal.typeFirstName(firstName);
            editTeacherModal.typeLastName(lastName);
            editTeacherModal.clickOnSaveButton();
            Assert.assertEquals(schoolPage.getTeacherEmail(0), email);
            Assert.assertEquals(schoolPage.getTeacherFirstName(0), firstName);
            Assert.assertEquals(schoolPage.getTeacherLastName(0), lastName);
        }
    }

    private void testManageSchoolAdminPage() {
        Assert.assertTrue(manageSchoolAdminsPage.isOrganizationNameDisplayed());
        Assert.assertTrue(manageSchoolAdminsPage.isEditOrganizationButtonDisplayed());
        Assert.assertTrue(manageSchoolAdminsPage.isManageAdminsButtonDisplayed());
        Assert.assertTrue(manageSchoolAdminsPage.isSearchButtonDisplayed());
        Assert.assertEquals(manageSchoolAdminsPage.getTitleText(), TestData.MANAGE_SCHOOL_ADMINS_TITLE);
        if (manageSchoolAdminsPage.isAdminsListDisplayed()) {
            for (int i = 0; i < manageSchoolAdminsPage.getAdminsNumber(); i++) {
                Assert.assertTrue(manageSchoolAdminsPage.isAdminEmailDisplayed(i));
                Assert.assertTrue(manageSchoolAdminsPage.isRemoveButtonDisplayed(i));
            }
            Assert.assertEquals(manageSchoolAdminsPage.getAddAdminLinkNumber(), 1);
            Assert.assertTrue(manageSchoolAdminsPage.isAddAdminLinkRemoveButtonDisplayed(0));
        } else {
            Assert.assertEquals(manageSchoolAdminsPage.getAddAdminLinkNumber(), 3);
            for (int i = 0; i < 3; i++) {
                Assert.assertTrue(manageSchoolAdminsPage.isAddAdminLinkRemoveButtonDisplayed(i));
            }
        }
    }

    private void testAddSchoolAdmin() {
        manageSchoolAdminsPage.clickOnAddAdminLink();
        addASchoolAdminModal.typeEmail(TestData.INVALID_EMAIL);
        addASchoolAdminModal.clearEmail();
        addASchoolAdminModal.waitForNotificationToBeDisplayed(TestData.REQUIRED_FIELD_ERROR_TEXT);
        addASchoolAdminModal.typeEmail(TestData.NEW_COLLECTION_NAME);
        addASchoolAdminModal.waitForNotificationToBeDisplayed(TestData.VALID_EMAIL_FORMAT_ERROR_TEXT);
        addASchoolAdminModal.clearEmail();
        addASchoolAdminModal.typeEmail(TestData.VALID_EMAIL_FREEMIUM);
        addASchoolAdminModal.clickOnAddButton();
        Assert.assertTrue(schoolPage.getNotificationText().contains(TestData.CREATED_SCHOOL_ADMIN_NOTIFICATION_TEXT));
        districtPage.dismissNotification();
        Assert.assertEquals(manageSchoolAdminsPage.getAdminEmail(0), TestData.VALID_EMAIL_FREEMIUM);
    }

    private void testRemoveSchoolAdmin() {
        int adminsNumber = manageSchoolAdminsPage.getAdminsNumber();
        manageSchoolAdminsPage.clickOnRemoveButton(0);
        Assert.assertEquals(removeSchoolAdminModal.getModalText(), TestData.REMOVE_SCHOOL_ADMIN_MODAL_TEXT);
        removeSchoolAdminModal.clickOnRemoveButton();
        Assert.assertTrue(schoolPage.getNotificationText().contains(TestData.REMOVED_SCHOOL_ADMIN_NOTIFICATION_TEXT));
        districtPage.dismissNotification();
        Assert.assertEquals(manageSchoolAdminsPage.getAdminsNumber(), adminsNumber - 1);
    }

    private void testSearchButtonFromSchoolPage(String text) {
        schoolPage.clickOnSearchButton();
        schoolPage.typeText(text);
        schoolPage.clickOnSearchButton();
        if (schoolPage.isTeachersListDisplayed()) {
            Assert.assertTrue(schoolPage.getSearchResultsText().contains(schoolPage.getTeachersNumber() + " " + TestData.SEARCH_RESULTS_TEXT) && schoolPage.getSearchResultsText().contains(text));
            for (int i = 0; i < schoolPage.getTeachersNumber(); i++) {
                Assert.assertTrue(schoolPage.getTeacherFirstName(i).contains(text) || schoolPage.getTeacherLastName(i).contains(text) || schoolPage.getTeacherEmail(i).contains(text));
                Assert.assertTrue(schoolPage.getTeacherRole(i).contains(TestData.TEACHER_ROLE) || schoolPage.getTeacherRole(i).contains(TestData.ADMIN_ROLE));
                schoolPage.hoverOverEditButton(i);
                if (!schoolPage.getTeacherJoinedDate(i).equals(TestData.UNREGISTERED_TEACHER_STATUS)) {
                    Assert.assertTrue(schoolPage.getEditButtonPopoverText().contains(TestData.EDIT_REGISTERED_TEACHER_POPOVER_TEXT) || schoolPage.getEditButtonPopoverText().contains(TestData.EDIT_REGISTERED_SCHOOL_ADMIN_POPOVER_TEXT));
                } else {
                    Assert.assertTrue(schoolPage.getEditButtonPopoverText().contains(TestData.EDIT_UNREGISTERED_TEACHER_POPOVER_TEXT) || schoolPage.getEditButtonPopoverText().contains(TestData.EDIT_UNREGISTERED_SCHOOL_ADMIN_POPOVER_TEXT));
                }
                Assert.assertTrue(schoolPage.isRemoveActionButtonDisplayed(i));
            }

        } else {
            Assert.assertTrue(schoolPage.getNoSearchResultsText().contains(TestData.NO_SEARCH_RESULTS_TEXT) && schoolPage.getNoSearchResultsText().contains(text));
        }
        schoolPage.clickClearSearchButton();
    }
}
