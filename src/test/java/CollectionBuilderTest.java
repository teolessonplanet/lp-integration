import com.lessonplanet.pages.*;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import util.TestData;

import java.util.List;

public class CollectionBuilderTest extends BaseTest {

    private DiscoverResourcesPage discoverResourcesPage;
    private CollectionBuilderPage collectionBuilderPage;
    private DeleteCollectionBuilderResourceModal deleteCollectionBuilderResourceModal;
    private CollectionBuilderVideoModal collectionBuilderVideoModal;
    private BecomeALessonPlanetFreeMemberModal becomeALessonPlanetFreeMemberModal;
    private RrpModal rrpModal;
    private RrpPage rrpPage;
    private BrowseBySubjectPage browseBySubjectPage;

    @BeforeMethod
    public void beforeMethod() {
        discoverResourcesPage = new DiscoverResourcesPage(webDriver);
        collectionBuilderPage = new CollectionBuilderPage(webDriver);
        rrpModal = new RrpModal(webDriver);
        rrpPage = new RrpPage(webDriver);
        deleteCollectionBuilderResourceModal = new DeleteCollectionBuilderResourceModal(webDriver);
        collectionBuilderVideoModal = new CollectionBuilderVideoModal(webDriver);
        becomeALessonPlanetFreeMemberModal = new BecomeALessonPlanetFreeMemberModal(webDriver);
        browseBySubjectPage = new BrowseBySubjectPage(webDriver);
    }

    @Test(description = "Visitor - Collection Builder - lessonp-431: Collection Builder Buttons")
    public void testLessonp_431() {
        discoverResourcesPage.loadPage();
        testCollectionBuilderButtons();
        browseBySubjectPage.loadPage(TestData.HEALTH_PAGE_PATH);
        testCollectionBuilderButtons();
    }

    @Test(description = "Visitor - Collection Builder - lessonp-4378: Collection Builder Items")
    public void testLessonp_4378() {
        discoverResourcesPage.loadSearchPageInListView();
        discoverResourcesPage.selectFacetFilter(TestData.FACET_CATEGORY_RESOURCES_TYPES, TestData.FACET_CATEGORY_RESOURCES_TYPE_LESSON_PLANS);
        testDragAndDropMaxItemsInsideCollection();
        browseBySubjectPage.loadPage(TestData.HEALTH_PAGE_PATH);
        Assert.assertEquals(collectionBuilderPage.getCollectionBuilderItemsNumber(), 3);
        testDragAndDropItem();
        dismissBecomeALessonPlanetFreeMemberModal();
        Assert.assertEquals(collectionBuilderPage.getCollectionBuilderItemsNumber(), 3);
        testCollectionBuilderItem();
    }

    private void testDragAndDropItem() {
        List<WebElement> getFreeAccessResources = browseBySubjectPage.getAllFreeAccessButtons();
        browseBySubjectPage.dragAndDrop(getFreeAccessResources.get(0), collectionBuilderPage.getCollectionDroppableZone());
    }

    private void testDragAndDropMaxItemsInsideCollection() {
        List<WebElement> getFreeAccessResources = discoverResourcesPage.getAllFreeAccessButtons();
        discoverResourcesPage.dragAndDrop(getFreeAccessResources.get(0), collectionBuilderPage.getCollectionDroppableZone());
        dismissBecomeALessonPlanetFreeMemberModal();
        discoverResourcesPage.dragAndDrop(getFreeAccessResources.get(0), collectionBuilderPage.getCollectionDroppableZone());
        Assert.assertEquals(collectionBuilderPage.getCollectionBuilderAlertText(), TestData.ALERT_TEXT);
        for (int i = 1; i <= 3; i++) {
            discoverResourcesPage.dragAndDrop(getFreeAccessResources.get(i), collectionBuilderPage.getCollectionDroppableZone());
            if (becomeALessonPlanetFreeMemberModal.isModalDisplayed()) {
                dismissBecomeALessonPlanetFreeMemberModal();
            }
        }
        Assert.assertEquals(collectionBuilderPage.getCollectionBuilderItemsNumber(), 3);
    }

    private void dismissBecomeALessonPlanetFreeMemberModal() {
        becomeALessonPlanetFreeMemberModal.waitForModal();
        becomeALessonPlanetFreeMemberModal.clickOnCloseModalButton();
    }

    private void testCollectionBuilderButtons() {
        collectionBuilderPage.isMyResourcesButtonDisplayed();
        collectionBuilderPage.isMyCollectionDropdownDisplayed();
        collectionBuilderPage.isEditCollectionButtonDisplayed();
        collectionBuilderPage.isUploadButtonDisplayed();
        collectionBuilderPage.isAddALinkButtonDisplayed();
        collectionBuilderPage.isCollectionVideoBannerDisplayed();
        collectionBuilderPage.clickOnMyResources();
        testSignInOrJoinNowModal();
        collectionBuilderPage.clickOnDropdown();
        testSignInOrJoinNowModal();
        collectionBuilderPage.clickOnEditCollection();
        testSignInOrJoinNowModal();
        collectionBuilderPage.clickUploadButton();
        testSignInOrJoinNowModal();
        collectionBuilderPage.clickAddALinkButton();
        testSignInOrJoinNowModal();
        collectionBuilderPage.clickOnCollectionBuilderVideoBanner();
        collectionBuilderVideoModal.waitForModal();
        collectionBuilderVideoModal.clickOnXButton();
    }

    private void testCollectionBuilderItem() {
        String collectionBuilderItemTitle = collectionBuilderPage.getCollectionBuilderItemTitle(0);
        int collectionBuilderItemsNumber = collectionBuilderPage.getCollectionBuilderItemsNumber();
        collectionBuilderPage.clickOnCollectionBuilderItem(0);
        rrpModal.waitForModal();
        Assert.assertEquals(rrpModal.getTitleText(), collectionBuilderItemTitle);
        rrpModal.clickCloseModal();
        collectionBuilderPage.openResourceInANewTab(0);
        browseBySubjectPage.waitForNewTab();
        browseBySubjectPage.focusDriverToLastTab();
        browseBySubjectPage.waitForLinkToLoad();
        Assert.assertEquals(rrpPage.getTitleText(), collectionBuilderItemTitle);
        browseBySubjectPage.closeTab();
        collectionBuilderPage.hoverOverCollectionBuilderItem(0);
        collectionBuilderPage.clickOnXButton(0);
        deleteCollectionBuilderResourceModal.clickOnDeleteResourceButton();
        Assert.assertEquals(collectionBuilderPage.getCollectionBuilderItemsNumber(), collectionBuilderItemsNumber - 1);
    }

    private void testSignInOrJoinNowModal() {
        Assert.assertTrue(collectionBuilderPage.isSignInPopupLinkDisplayed());
        Assert.assertTrue(collectionBuilderPage.isSignUpPopupLinkDisplayed());
    }
}
