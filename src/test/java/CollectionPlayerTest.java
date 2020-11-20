import com.lessonplanet.pages.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import util.TestData;

import java.util.List;

public class CollectionPlayerTest extends BaseTest {
    private LoginPage loginPage;
    private StepTwoPage stepTwoPage;
    private DiscoverResourcesPage discoverResourcesPage;
    private CollectionBuilderPage collectionBuilderPage;
    private CollectionBuilderTest collectionBuilderTest;
    private CurriculumManagerPageTest curriculumManagerPageTest;
    private EditCollectionModal editCollectionModal;
    private CollectionPlayerPage collectionPlayerPage;
    private CurriculumManagerPage curriculumManagerPage;
    private PublishCollectionModal publishCollectionModal;

    @BeforeMethod
    public void beforeMethod() {
        loginPage = new LoginPage(webDriver);
        stepTwoPage = new StepTwoPage(webDriver);
        discoverResourcesPage = new DiscoverResourcesPage(webDriver);
        collectionBuilderPage = new CollectionBuilderPage(webDriver);
        collectionBuilderTest = new CollectionBuilderTest();
        curriculumManagerPageTest = new CurriculumManagerPageTest();
        editCollectionModal = new EditCollectionModal(webDriver);
        collectionPlayerPage = new CollectionPlayerPage(webDriver);
        curriculumManagerPage = new CurriculumManagerPage(webDriver);
        publishCollectionModal = new PublishCollectionModal(webDriver);
    }

    public void initTest(WebDriver webDriver) {
        this.webDriver = webDriver;
        beforeMethod();
    }

    @Test(description = "Freemium - Collection player - lessonp-554:Appearance")
    public void testLessonp_554() {
        testCollectionPlayerAppearance(TestData.PLAN_FREEMIUM);
    }

    @Test(description = "Active user - Collection player - lessonp-626:Appearance")
    public void testLessonp_626() {
        testCollectionPlayerAppearance(TestData.PLAN_PRIME);
    }

    @Test(description = "Freemium - Collection player - lessonp-556:Collection Navigator")
    public void testLessonp_556() {
        testCollectionNavigator(TestData.PLAN_FREEMIUM);
    }

    @Test(description = "Active user - Collection player - lessonp-624:Collection Navigator")
    public void testLessonp_624() {
        testCollectionNavigator(TestData.PLAN_STARTER);
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
            editCollectionModal.publishCollection(TestData.GET_CURRENT_TIME(), TestData.EDIT_COLLECTION_GRADE_HIGHER_ED, TestData.EDIT_COLLECTION_SUBJECT_SPECIAL_EDUCATION_AND_PROGRAM_SPECIAL_EDUCATION, TestData.NEW_COLLECTION_DESCRIPTION);

            publishCollectionModal.publishCollection();
            //generate method to publish fast

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
        discoverResourcesPage.checkLessonPlanetProvider();
        discoverResourcesPage.selectFacetFilter(TestData.FACET_CATEGORY_RESOURCES_TYPES, TestData.FACET_CATEGORY_RESOURCES_TYPE_LESSON_PLANS);
        curriculumManagerPageTest.initTest(webDriver);
        curriculumManagerPageTest.testCreateCollectionFromCollectionBuilder();

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
        editCollectionModal.clickActionsDropdown();
        editCollectionModal.clickPlayFolderOption();
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
}
