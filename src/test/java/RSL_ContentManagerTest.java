import com.lessonplanet.pages.LoginPage;
import com.lessonplanet.pages.RSL_ContentManagerPage;
import com.lessonplanet.pages.RrpPage;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import util.TestData;

import java.util.ArrayList;
import java.util.List;

public class RSL_ContentManagerTest extends BaseTest {

    private LoginPage loginPage;
    private RSL_ContentManagerPage rsl_contentManagerPage;
    private RrpPage rrpPage;

    @BeforeMethod
    public void beforeMethod() {
        loginPage = new LoginPage(webDriver);
        rsl_contentManagerPage = new RSL_ContentManagerPage(webDriver);
        rrpPage = new RrpPage(webDriver);
    }

    @Test(description = "LP - Regression Tests - Admin Manager - Search Page - lessonp-4016:Cards details - LP resource")
    public void testLessonp_4016() {
        loginPage.performLogin(TestData.VALID_EMAIL_REGULAR_SITE_LICENCE, TestData.VALID_PASSWORD);
        rsl_contentManagerPage.loadPage();
        rsl_contentManagerPage.selectPrimarySourcesFromResourceTypes();

        Assert.assertEquals(rsl_contentManagerPage.getTitleText(), TestData.CONTENT_MANAGER_PAGE_TITLE_TEXT);
        Assert.assertEquals(rsl_contentManagerPage.getPageSubtitleText(), TestData.CONTENT_MANAGER_PAGE_SUBTITLE_TEXT);
        Assert.assertTrue(rsl_contentManagerPage.isSearchTextFieldTextDisplayed());
        Assert.assertTrue(rsl_contentManagerPage.getTotalResourcesFound() > TestData.ZERO_RESOURCES_FOUND);
        Assert.assertEquals(rsl_contentManagerPage.getSortByOptionDropdownText(), TestData.CONTENT_MANAGER_SORT_BY_DEFAULT_TEXT);
        Assert.assertTrue(rsl_contentManagerPage.isResourceCardDisplayed());
        Assert.assertTrue(rsl_contentManagerPage.isFacetSidebarDisplayed());

        WebElement firstResource = rsl_contentManagerPage.getResourceCards().get(0);
        Assert.assertTrue(rsl_contentManagerPage.isResourceProviderDisplayed(firstResource));
        Assert.assertTrue(rsl_contentManagerPage.isResourceHideFromViewDisplayed(firstResource));
        Assert.assertTrue(rsl_contentManagerPage.isResourceTitleDisplayed(firstResource));
        Assert.assertTrue(rsl_contentManagerPage.isResourceThumbnailDisplayed(firstResource));
        Assert.assertTrue(rsl_contentManagerPage.isResourceTypeDisplayed(firstResource));
        Assert.assertTrue(rsl_contentManagerPage.isResourceGradesDisplayed(firstResource));
        Assert.assertTrue(rsl_contentManagerPage.isResourceRatingDisplayed(firstResource));
        Assert.assertTrue(rsl_contentManagerPage.isResourceViewsDisplayed(firstResource));
        Assert.assertTrue(rsl_contentManagerPage.isResourceDescriptionDisplayed(firstResource));
        Assert.assertTrue(rsl_contentManagerPage.isResourceConceptDisplayed(firstResource));
        Assert.assertTrue(rsl_contentManagerPage.isResourceStandardDisplayed(firstResource));
    }

    @Test(description = "LP - Regression Tests - Admin Manager - Search Page - lessonp-1271:Cards list")
    public void testLessonp_1271() {
        loginPage.performLogin(TestData.VALID_EMAIL_REGULAR_SITE_LICENCE, TestData.VALID_PASSWORD);
        rsl_contentManagerPage.loadPage();
        rsl_contentManagerPage.selectPrimarySourcesFromResourceTypes();

        WebElement firstResource = rsl_contentManagerPage.getResourceCards().get(0);

        rsl_contentManagerPage.clickOnResourceTitle(firstResource);
        rsl_contentManagerPage.focusDriverToLastTab();
        Assert.assertTrue(rrpPage.isFullReviewDisplayed());
        Assert.assertTrue(rsl_contentManagerPage.getUrl().contains(TestData.SERVER_URL + TestData.CONTENT_MANAGER_RESOURCE_REDIRECT_PATH));
        rsl_contentManagerPage.closeTab();

        rsl_contentManagerPage.clickOnConceptLink(firstResource, 0);
        Assert.assertTrue(rsl_contentManagerPage.getPath().contains(TestData.ACCOUNT_MANAGER_PAGE_PATH) && rsl_contentManagerPage.getPath().contains(TestData.CONTENT_MANAGER_CONCEPT_REDIRECT_PATH));

        rsl_contentManagerPage.loadPage();
        rsl_contentManagerPage.selectPrimarySourcesFromResourceTypes();
        firstResource = rsl_contentManagerPage.getResourceCards().get(0);

        rsl_contentManagerPage.clickOnStandardLink(firstResource, 0);
        rsl_contentManagerPage.focusDriverToLastTab();
        rsl_contentManagerPage.waitForLoad();
        Assert.assertTrue(rsl_contentManagerPage.getPath().contains(TestData.CONTENT_MANAGER_STANDARD_REDIRECT_PATH));
        rsl_contentManagerPage.closeTab();

        rsl_contentManagerPage.clickOnQuickViewButton(firstResource);
        rsl_contentManagerPage.focusDriverToLastTab();

        Assert.assertTrue(rrpPage.isTitleDisplayed());
    }

    @Test(description = "LP - Regression Tests - Admin Manager - Search Page - lessonp-5076:Search")
    public void testLessonp_5076() {

        loginPage.performLogin(TestData.VALID_EMAIL_REGULAR_SITE_LICENCE, TestData.VALID_PASSWORD);
        rsl_contentManagerPage.loadPage();

        rsl_contentManagerPage.typeSearchText(TestData.INVALID_SEARCH_WORD);
        rsl_contentManagerPage.clickOnSearchButton();

        Assert.assertEquals(rsl_contentManagerPage.getSearchTextFieldText(), TestData.ZERO_RESOURCES_FOUND + TestData.CONTENT_MANAGER_RESOURCES_FOR_TEXT + TestData.INVALID_SEARCH_WORD);
        Assert.assertEquals(rsl_contentManagerPage.getSearchInputText(), TestData.INVALID_SEARCH_WORD);
        Assert.assertTrue(rsl_contentManagerPage.isAlertWarningDisplayed());

        rsl_contentManagerPage.clickOnSearchCloseButton();
        Assert.assertTrue(rsl_contentManagerPage.getSearchInputText().isEmpty());
        Assert.assertTrue(rsl_contentManagerPage.getTotalResourcesFound() > TestData.ZERO_RESOURCES_FOUND);
    }

    @Test(description = "LP - Regression Tests - Admin Manager - Search Page - lessonp-5078:Sort By")
    public void testLessonp_5078() {

        loginPage.performLogin(TestData.VALID_EMAIL_REGULAR_SITE_LICENCE, TestData.VALID_PASSWORD);
        rsl_contentManagerPage.loadPage();

        rsl_contentManagerPage.clickOnSortByDropdown();
        rsl_contentManagerPage.clickOnDropdownAzOption();
        rsl_contentManagerPage.waitForLoad();
        List<WebElement> sortA_Z = rsl_contentManagerPage.getResourceCards();

        ArrayList sortA_Z_Texts = new ArrayList(sortA_Z.size());
        for (WebElement resource : sortA_Z) {
            sortA_Z_Texts.add(resource.getText());
        }

        rsl_contentManagerPage.clickOnSortByDropdown();
        rsl_contentManagerPage.clickOnDropdownZaOption();
        rsl_contentManagerPage.waitForLoad();

        List<WebElement> sortZ_A = rsl_contentManagerPage.getResourceCards();
        ArrayList sortZ_A_Texts = new ArrayList(sortZ_A.size());
        for (WebElement resource : sortZ_A) {
            sortZ_A_Texts.add(resource.getText());
        }
        Assert.assertFalse(listsAreTheSame(sortA_Z_Texts, sortZ_A_Texts));


        rsl_contentManagerPage.clickOnSortByDropdown();
        rsl_contentManagerPage.clickOnDropdownNewestOption();
        List<WebElement> allResourcesNewest = rsl_contentManagerPage.getResourceCards();
        ArrayList allResourcesNewestTexts = new ArrayList(sortA_Z.size());
        for (WebElement resource : allResourcesNewest) {
            allResourcesNewestTexts.add(resource.getText());
        }
        Assert.assertFalse(listsAreTheSame(sortA_Z_Texts, allResourcesNewestTexts));
        Assert.assertFalse(listsAreTheSame(sortZ_A_Texts, allResourcesNewestTexts));

        rsl_contentManagerPage.clickOnSortByDropdown();
        rsl_contentManagerPage.clickOnDropdownOldestOption();
        List<WebElement> allResourcesOldest = rsl_contentManagerPage.getResourceCards();
        ArrayList allResourcesOldestTexts = new ArrayList(sortA_Z.size());
        for (WebElement resource : allResourcesOldest) {
            allResourcesOldestTexts.add(resource.getText());
        }
        Assert.assertFalse(listsAreTheSame(sortA_Z_Texts, allResourcesOldestTexts));
        Assert.assertFalse(listsAreTheSame(sortA_Z_Texts, allResourcesOldestTexts));
        Assert.assertFalse(listsAreTheSame(allResourcesOldestTexts, allResourcesNewestTexts));
        rsl_contentManagerPage.loadPage();
    }

    private boolean listsAreTheSame(List<String> cards1, List<String> cards2) {
        if (cards1.size() == cards2.size()) {
            cards1.removeAll(cards2);
            if (cards1.size() == 0) {
                return true;
            }
        }
        return false;
    }
}
