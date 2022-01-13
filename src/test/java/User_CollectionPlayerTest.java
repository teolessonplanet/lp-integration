import com.lessonplanet.pages.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import util.TestData;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class User_CollectionPlayerTest extends BaseTest {
    private LoginPage loginPage;
    private StepTwoPage stepTwoPage;
    private DiscoverResourcesPage discoverResourcesPage;
    private CollectionBuilderPage collectionBuilderPage;
    private User_CurriculumManagerPageTest user_curriculumManagerPageTest;
    private EditCollectionModal editCollectionModal;
    private CollectionPlayerPage collectionPlayerPage;
    private CurriculumManagerPage curriculumManagerPage;
    private User_AssignFolderModalTest user_assignFolderModalTest;
    private AssignModal assignModal;
    private StudentViewPage studentViewPage;
    private LpHomePage lpHomePage;
    private PublishedFolderModal publishedFolderModal;

    @BeforeMethod(alwaysRun = true)
    public void beforeMethod() {
        loginPage = new LoginPage(webDriver);
        stepTwoPage = new StepTwoPage(webDriver);
        discoverResourcesPage = new DiscoverResourcesPage(webDriver);
        collectionBuilderPage = new CollectionBuilderPage(webDriver);
        user_curriculumManagerPageTest = new User_CurriculumManagerPageTest();
        editCollectionModal = new EditCollectionModal(webDriver);
        collectionPlayerPage = new CollectionPlayerPage(webDriver);
        curriculumManagerPage = new CurriculumManagerPage(webDriver);
        assignModal = new AssignModal(webDriver);
        user_assignFolderModalTest = new User_AssignFolderModalTest();
        publishedFolderModal = new PublishedFolderModal(webDriver);
    }

    public void initTest(WebDriver webDriver) {
        this.webDriver = webDriver;
        beforeMethod();
    }

    @Test(description = "Free Member - Collection player - lessonp-554:Appearance", groups = {"freemium"})
    public void testLessonp_554() {
        testCollectionPlayerAppearance(TestData.PLAN_FREEMIUM);
    }

    @Test(description = "Active user - Collection player - lessonp-626:Appearance", groups = {"activeUser"})
    public void testLessonp_626() {
        testCollectionPlayerAppearance(TestData.PLAN_STARTER);
    }

    @Test(description = "Free Member - Collection player - lessonp-556:Collection Navigator", groups = {"freemium"})
    public void testLessonp_556() {
        testCollectionNavigator(TestData.PLAN_FREEMIUM);
    }

    @Test(description = "Active user - Collection player - lessonp-624:Collection Navigator", groups = {"activeUser"})
    public void testLessonp_624() {
        testCollectionNavigator(TestData.PLAN_STARTER);
    }

    @Test(description = "Free Member - Collection player - lessonp-555:Resource Viewer", groups = {"freemium"})
    public void testLessonp_555() {
        testResourceViewer(TestData.PLAN_FREEMIUM);
    }

    @Test(description = "Active user - Collection player - lessonp-625:Resource Viewer", groups = {"activeUser"})
    public void testLessonp_625() {
        testResourceViewer(TestData.PLAN_PRO);
    }

    @Test(description = "Active user - Collection player - lessonp-629:Teacher View", groups = {"activeUser"})
    public void testLessonp_629() {
        testTeacherView(TestData.PLAN_PRO);
    }

    @Test(description = "Active user - Collection player - lessonp-557:Student View", groups = {"activeUser"})
    public void testLessonp_557() {
        testStudentView(TestData.PLAN_PRO);
    }

    protected void testCollectionPlayerAppearance(String accountType) {
        createRequirementForCollectionPlayer(accountType);

        checkCollectionPlayerTab();
        curriculumManagerPage.loadPage();

        Assert.assertEquals(curriculumManagerPage.getFolderStatus(), TestData.PRIVATE_STATUS);
        curriculumManagerPage.clickActionsDropdown(curriculumManagerPage.getFolder(0));
        curriculumManagerPage.clickOnPlayFolderButton(curriculumManagerPage.getFolder(0));
        checkCollectionPlayerTab();

        // publish is available only for Active & SLs
        if (!accountType.equals(TestData.PLAN_FREEMIUM)) {
            collectionBuilderPage.clickOnEditFolder(false);
            editCollectionModal.publishCollection(accountType, TestData.GET_CURRENT_TIME(), TestData.EDIT_COLLECTION_GRADE_HIGHER_ED, TestData.EDIT_COLLECTION_SUBJECT_SPECIAL_EDUCATION_AND_PROGRAM_SPECIAL_EDUCATION, TestData.NEW_COLLECTION_DESCRIPTION);
            //generate method to publish fast

            if (!accountType.equals(TestData.VALID_EMAIL_CSL_HENRY) && !accountType.equals(TestData.VALID_EMAIL_CSL_COBB)) {
                //publishedFolderModal.clickOnCloseButton(); -> this should be deleted
            } else {
                //  Assert.assertTrue(editCollectionModal.getAlertNotificationText().contains(TestData.CSL_PUBLISHED_COLLECTION_NOTIFICATION_TEXT));
            }
            //TODO: refactor above!
            switch (accountType) {
                case TestData.PLAN_STARTER:
                case TestData.PLAN_PRO:
                    publishedFolderModal.clickOnCloseButton();
                    break;
            }

            editCollectionModal.clickOnCloseButton();
            Assert.assertEquals(curriculumManagerPage.getFolderStatus(), TestData.PRIVATE_AND_PUBLISHED_STATUS);
            curriculumManagerPage.clickActionsDropdown(curriculumManagerPage.getFolder(0));
            curriculumManagerPage.clickOnPlayFolderButton(curriculumManagerPage.getFolder(0));
            checkCollectionPlayerTab();
        }
    }

    private void createRequirementForCollectionPlayer(String accountType) {
        if (accountType.equals(TestData.VALID_EMAIL_CSL_HENRY) || accountType.equals(TestData.VALID_EMAIL_RSL_SBCEO)) {
            loginPage.performLogin(accountType, TestData.VALID_PASSWORD);
        } else {
            stepTwoPage.createNewAccount(accountType);
        }
        discoverResourcesPage.loadPage();

        discoverResourcesPage.loadSearchPageInListView();
        discoverResourcesPage.selectFacetViaShortcut(new ArrayList<>(Arrays.asList(TestData.FACET_PROVIDERS_LESSONPLANET, TestData.FACET_CATEGORY_RESOURCES_TYPE_LESSON_PLANS)));

        user_curriculumManagerPageTest.initTest(webDriver);
        user_curriculumManagerPageTest.testCreateCollectionFromCollectionBuilder(TestData.NEW_COLLECTION_NAME);

        List<WebElement> resources;
        if (accountType.equals(TestData.PLAN_FREEMIUM)) {
            resources = discoverResourcesPage.getAllFreeAccessButtons();
        } else {
            resources = discoverResourcesPage.getAllSeeFullReviewButtons();
        }
        for (int i = 0; i <= 3; i++) {
            discoverResourcesPage.dragAndDrop(resources.get(i), collectionBuilderPage.getCollectionDroppableZone());
        }

        collectionBuilderPage.clickOnEditFolder(false);
        editCollectionModal.clickPlayOption();
    }

    private void checkCollectionPlayerTab() {
        collectionPlayerPage.focusDriverToLastTab();
        Assert.assertTrue(collectionBuilderPage.getPath().startsWith(TestData.COLLECTION_PLAYER_PAGE_PATH_1));
        Assert.assertTrue(collectionBuilderPage.getPath().contains(TestData.COLLECTION_PLAYER_PAGE_PATH_2));
        Assert.assertTrue(collectionBuilderPage.getPath().endsWith(TestData.COLLECTION_PLAYER_PAGE_PATH_3));
        collectionPlayerPage.closeTab();
    }

    protected void testCollectionNavigator(String accountType) {
        createRequirementForCollectionPlayer(accountType);
        collectionPlayerPage.focusDriverToLastTab();

        collectionPlayerPage.waitUntilNavigatorItemSliderIsHidden();
        Assert.assertTrue(collectionPlayerPage.isUpArrowButtonDisplayed());
        collectionPlayerPage.clickOnUpArrowButton();
        Assert.assertTrue(collectionPlayerPage.isCurrentPositionInListDisplayed());
        Assert.assertEquals(collectionPlayerPage.getPositionOfSelectedItem(), 0);
        collectionPlayerPage.clickOnNextItemButton();
        Assert.assertEquals(collectionPlayerPage.getPositionOfSelectedItem(), 1);
        collectionPlayerPage.clickOnPreviousButton();
        Assert.assertEquals(collectionPlayerPage.getPositionOfSelectedItem(), 0);
    }

    protected void testResourceViewer(String accountType) {
        if (accountType.equals(TestData.VALID_EMAIL_CSL_HENRY) || accountType.equals(TestData.VALID_EMAIL_RSL_SBCEO)) {
            loginPage.performLogin(accountType, TestData.VALID_PASSWORD);
        } else {
            stepTwoPage.createNewAccount(accountType);
        }

        discoverResourcesPage.loadPage();
        discoverResourcesPage.loadSearchPageInListView();
        discoverResourcesPage.checkLessonPlanetProvider();

        user_curriculumManagerPageTest.initTest(webDriver);
        user_curriculumManagerPageTest.testCreateCollectionFromCollectionBuilder(TestData.GET_CURRENT_TIME());

        addResourceOfType(accountType, TestData.FACET_CATEGORY_RESOURCES_TYPE_WEBSITES);
        addResourceOfType(accountType, TestData.FACET_CATEGORY_RESOURCES_TYPE_GRAPHICS_AND_IMAGES);
        addResourceOfType(accountType, TestData.FACET_CATEGORY_RESOURCES_TYPE_VIDEOS);
        addResourceOfType(accountType, TestData.FACET_CATEGORY_RESOURCES_TYPE_PRESENTATIONS);

        collectionBuilderPage.clickOnEditFolder(false);
        editCollectionModal.waitForModal();
        editCollectionModal.clickPlayOption();
        editCollectionModal.focusDriverToLastTab();

        collectionPlayerPage.waitUntilNavigatorItemSliderIsHidden();
        collectionPlayerPage.clickOnUpArrowButton();
        List<WebElement> collectionItems = collectionPlayerPage.getCollectionItemsList();
        ArrayList<String> expectedTypes = new ArrayList<>();
        ArrayList<String> actualTypes = new ArrayList<>();
        actualTypes.add(TestData.RESOURCE_TYPE_PRESENTATION);
        actualTypes.add(TestData.RESOURCE_TYPE_VIDEO);
        actualTypes.add(TestData.RESOURCE_TYPE_GRAPHICS_AND_IMAGE);
        actualTypes.add(TestData.RESOURCE_TYPE_WEBSITE);
        for (WebElement element : collectionItems) {
            expectedTypes.add(collectionPlayerPage.getCollectionItemType(element));
        }
        Assert.assertTrue(actualTypes.containsAll(expectedTypes));

        Assert.assertEquals(collectionPlayerPage.getPositionOfSelectedItem(), 0);
        checkButtons(accountType, TestData.RESOURCE_TYPE_PRESENTATION);

        collectionPlayerPage.clickOnNextItemButton();
        Assert.assertEquals(collectionPlayerPage.getPositionOfSelectedItem(), 1);
        checkButtons(accountType, TestData.RESOURCE_TYPE_VIDEO);

        collectionPlayerPage.clickOnNextItemButton();
        Assert.assertEquals(collectionPlayerPage.getPositionOfSelectedItem(), 2);
        checkButtons(accountType, TestData.RESOURCE_TYPE_GRAPHICS_AND_IMAGE);

        collectionPlayerPage.clickOnNextItemButton();
        Assert.assertEquals(collectionPlayerPage.getPositionOfSelectedItem(), 3);
        checkButtons(accountType, TestData.RESOURCE_TYPE_WEBSITE);
        if (accountType.equals(TestData.VALID_EMAIL_CSL_HENRY)) {
            Assert.assertTrue(collectionPlayerPage.isHenryLogoDisplayed());
            collectionPlayerPage.clickOnHenryLogo();
            collectionPlayerPage.focusDriverToLastTab();
            Assert.assertTrue(collectionBuilderPage.getPath().contains(TestData.SEARCH_PAGE_PATH));
            collectionPlayerPage.closeTab();
        } else {
            if (accountType.equals(TestData.VALID_EMAIL_RSL_SBCEO)) {
                collectionPlayerPage.clickOnLearningExplorerLogo();
                collectionPlayerPage.focusDriverToLastTab();
                Assert.assertEquals(collectionPlayerPage.getPath(), TestData.DISCOVER_RESOURCES_PAGE_PATH);
            } else {
                collectionPlayerPage.clickOnLessonPlanetLogo();
                collectionPlayerPage.focusDriverToLastTab();
                Assert.assertEquals(collectionPlayerPage.getPath(), TestData.LP_HOME_PAGE_PATH);
            }
        }
    }

    private void addResourceOfType(String accountType, String resourceCategory) {
        discoverResourcesPage.loadPage();
        discoverResourcesPage.loadSearchPageInListView();

        switch (resourceCategory) {
            case TestData.FACET_CATEGORY_RESOURCES_TYPE_WEBSITES:
                //WebPage
                discoverResourcesPage.selectFacetViaShortcut(new ArrayList<>(Arrays.asList(TestData.FACET_PROVIDERS_LESSONPLANET, TestData.FACET_CATEGORY_RESOURCES_TYPE_WEBSITES)));
                break;
            case TestData.FACET_CATEGORY_RESOURCES_TYPE_GRAPHICS_AND_IMAGES:
                //Images
                if (!accountType.equals(TestData.PLAN_FREEMIUM)) {
                    discoverResourcesPage.selectFacetViaShortcut(new ArrayList<>(Arrays.asList(TestData.FACET_PROVIDERS_LESSONPLANET, TestData.FACET_CATEGORY_SUBJECTS_TYPE_MATH)));
                }
                discoverResourcesPage.selectFacetViaShortcut(new ArrayList<>(Arrays.asList(TestData.FACET_PROVIDERS_LESSONPLANET, TestData.FACET_CATEGORY_RESOURCES_TYPE_GRAPHICS_AND_IMAGES)));
                break;
            case TestData.FACET_CATEGORY_RESOURCES_TYPE_VIDEOS:
                //VIDEO
                discoverResourcesPage.selectFacetViaShortcut(new ArrayList<>(Arrays.asList(TestData.FACET_PROVIDERS_LESSONPLANET, TestData.FACET_CATEGORY_SUBJECTS_TYPE_SPECIAL_EDUCATION_AND_PROGRAMS, TestData.FACET_CATEGORY_RESOURCES_TYPE_VIDEOS)));
                break;
            case TestData.FACET_CATEGORY_RESOURCES_TYPE_PRESENTATIONS:
                //PDF - PPT
                discoverResourcesPage.selectFacetViaShortcut(new ArrayList<>(Arrays.asList(TestData.FACET_PROVIDERS_LESSONPLANET, TestData.FACET_CATEGORY_SUBJECTS_CLASSROOM_SUPPORT, TestData.FACET_CATEGORY_RESOURCES_TYPE_PRESENTATIONS)));
                break;
        }

        List<WebElement> resources;
        if (accountType.equals(TestData.PLAN_FREEMIUM)) {
            resources = discoverResourcesPage.getAllFreeAccessButtonsForResourceType(resourceCategory, true);
        } else {
            resources = discoverResourcesPage.getAllSeeFullReviewButtonsForResourceType(resourceCategory, true);
        }
        discoverResourcesPage.dragAndDrop(resources.get(0), collectionBuilderPage.getCollectionDroppableZone());
    }

    private void checkButtons(String accountPlan, String resourceType) {
        if (accountPlan.equals(TestData.PLAN_FREEMIUM)) {
            Assert.assertTrue(collectionPlayerPage.isDownloadButtonHidden());
            Assert.assertTrue(collectionPlayerPage.isFullScreenButtonHidden());
            Assert.assertTrue(collectionPlayerPage.isPopOutButtonHidden());
        } else {
            switch (resourceType) {
                case TestData.RESOURCE_TYPE_VIDEO:
                case TestData.RESOURCE_TYPE_WEBSITE:
                    Assert.assertTrue(collectionPlayerPage.isDownloadButtonHidden());
                    break;
            }
            Assert.assertTrue(collectionPlayerPage.isFullScreenButtonDisplayed());
            Assert.assertTrue(collectionPlayerPage.isPopOutButtonDisplayed());
        }
    }

    protected void testTeacherView(String accountType) {
        createRequirementForCollectionPlayer(accountType);

        collectionPlayerPage.focusDriverToLastTab();
        collectionPlayerPage.clickAssignFolderButton();

        user_assignFolderModalTest.initTest(webDriver);
        user_assignFolderModalTest.testAssignModal(TestData.VALID_PASSWORD);
    }

    protected void testStudentView(String accountType) {
        createRequirementForCollectionPlayer(accountType);

        collectionPlayerPage.focusDriverToLastTab();
        collectionPlayerPage.clickAssignFolderButton();
        assignModal.typeAccessKey(TestData.VALID_PASSWORD);
        assignModal.clickOnSaveButton();
        String shareLink = assignModal.getShareLinkText();

        tearDown();
        init();
        lpHomePage = new LpHomePage(webDriver);
        studentViewPage = new StudentViewPage(webDriver);
        lpHomePage.loadPage();
        webDriver.get(shareLink);
        studentViewPage.typePassword(TestData.INVALID_PASSWORD);
        studentViewPage.clickOnSubmitButton();
        Assert.assertEquals(studentViewPage.getIncorrectAccessKeyText(), TestData.INCORRECT_ACCESS_KEY_MESSAGE_TEXT);
        studentViewPage.clearPasswordField();
        studentViewPage.typePassword(TestData.VALID_PASSWORD);
        studentViewPage.clickOnSubmitButton();

        String expectedUrl = TestData.SERVER_URL + TestData.COLLECTION_PLAYER_PAGE_PATH_2.replace("/", "") + TestData.COLLECTION_PLAYER_PAGE_PATH_3;
        Assert.assertTrue(studentViewPage.getUrl().startsWith(expectedUrl));
        tearDown();
    }
}
