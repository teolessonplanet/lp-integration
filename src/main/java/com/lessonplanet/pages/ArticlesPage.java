package com.lessonplanet.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import util.TestData;

import java.util.List;

public class ArticlesPage extends LpUiBasePage {
    private static final String LESSON_PLANNING_ARTICLES_TITLE = "#content-main h1";
    private static final String LESSON_PLANNING_ARTICLES_DESCRIPTION = "#content-main p";
    private static final String ARTICLE_TOPICS_SECTION_TEXT = "[class*='col-lg-3 col-lg-pull-6 col-md-4 col-md-pull-8']";
    private static final String ART_AND_MUSIC_TOPIC_LINK = "[class='side-widget'] a[href='/articles/art-and-music']";

    private static final String ARTICLES_CARD_SECTION = "[class*='panel-default']";
    private static final String ARTICLE_CARD_TITLE = "[class*='panel-default'] [class='media-heading title']";
    private static final String ARTICLE_CARD_PHOTO = "[class*='panel-default'] [class='media-object img-responsive']";
    private static final String ARTICLE_CARD_DESCRIPTION = "[class*='panel-default'] [class='article-body mt5']";

    private static final String ARTICLE_PAGE_TITLE = "[class='article'] [itemprop='name']";
    private static final String ARTICLE_PAGE_DESCRIPTION = "[class='article'] [itemprop='description']";
    private static final String ARTICLE_PAGE_AUTHOR = "[class='article'] [class='mt10 mb10'] p";
    private static final String FACEBOOK_SHARE_BUTTON = "[class*='fa-facebook-square']";
    private static final String TWITTER_SHARE_BUTTON = "[class*='fa-twitter-square']";
    private static final String PINTEREST_SHARE_BUTTON = "[class*='fa-pinterest-square']";
    private static final String LINK_SHARE_BUTTON = "[class*='fa-link']";

    private static final String RECENT_ARTICLES_SECTION = "#recent-articles-block";
    private static final String RECENT_ARTICLE = "#recent-articles-block ul[class='arrow-bullet fa-ul'] a";

    private static final String GUIDE_SECTION = "#contributor-block";
    private static final String GUIDE_SECTION_TITLE = "#contributor-block [class='widget-title']";
    private static final String GUIDE_SECTION_CONTRIBUTOR_PHOTO = "#contributor-block [class='media-object pull-left']";
    private static final String GUIDE_SECTION_CONTRIBUTOR_NAME = "#contributor-block [class='media-body']";

    public ArticlesPage(WebDriver driver) {
        super(driver);
    }

    public void loadPage() {
        loadUrl(TestData.LESSON_PLANNING_ARTICLES_PAGE_PATH);
    }

    public String getLessonPlanningArticlesPageTitle() {
        return getTextForElement(LESSON_PLANNING_ARTICLES_TITLE);
    }

    public boolean isLessonPlanningArticlesDescriptionDisplayed() {
        return isElementDisplayed(LESSON_PLANNING_ARTICLES_DESCRIPTION);
    }

    public String getArticleTopicPageTitle() {
        return getTextForElement(LESSON_PLANNING_ARTICLES_TITLE);
    }

    public String getArticleTopics() {
        return getTextForElement(ARTICLE_TOPICS_SECTION_TEXT);
    }

    public void clickOnArticleTopicLink() {
        clickElement(ART_AND_MUSIC_TOPIC_LINK);
    }

    public String getArticlePageTitle() {
        return getTextForElement(ARTICLE_PAGE_TITLE);
    }

    public boolean isArticlePageDescriptionDisplayed() {
        return isElementDisplayed(ARTICLE_PAGE_DESCRIPTION);
    }

    public boolean isArticlePageAuthorDisplayed() {
        return isElementDisplayed(ARTICLE_PAGE_AUTHOR);
    }

    public int getArticlesCardNumber() {
        final List<WebElement> relatedArticles = findElements(ARTICLES_CARD_SECTION);
        return relatedArticles.size();
    }

    public void clickOnArticleCard(int position) {
        clickElement(ARTICLE_CARD_TITLE, position);
    }

    public String getArticleCardTitle(int position) {
        return getTextForElement(ARTICLE_CARD_TITLE, position);
    }

    public boolean isArticleCardTitleDisplayed() {
        return isElementDisplayed(ARTICLE_CARD_TITLE);
    }

    public boolean isArticleCardPhotoDisplayed() {
        return isElementDisplayed(ARTICLE_CARD_PHOTO);
    }

    public boolean isArticleCardDescriptionDisplayed() {
        return isElementDisplayed(ARTICLE_CARD_DESCRIPTION);
    }

    public int getRecentArticlesNumber() {
        final List<WebElement> recentArticles = findElements(RECENT_ARTICLE);
        return recentArticles.size();
    }

    public boolean isRecentArticlesSectionDisplayed() {
        return isElementDisplayed(RECENT_ARTICLES_SECTION);
    }

    public void clickOnRecentArticle(int position) {
        clickElement(RECENT_ARTICLE, position);
    }

    public String getRecentArticleTitle(int position) {
        return getTextForElement(RECENT_ARTICLE, position);
    }

    public boolean isFacebookShareButtonDisplayed() {
        return isElementDisplayed(FACEBOOK_SHARE_BUTTON);
    }

    public boolean isTwitterShareButtonDisplayed() {
        return isElementDisplayed(TWITTER_SHARE_BUTTON);
    }

    public boolean isPinterestShareButtonDisplayed() {
        return isElementDisplayed(PINTEREST_SHARE_BUTTON);
    }

    public boolean isLinkShareButtonDisplayed() {
        return isElementDisplayed(LINK_SHARE_BUTTON);
    }

    public boolean isGuideSectionDisplayed() {
        return isElementDisplayed(GUIDE_SECTION);
    }

    public String getGuideSectionTitle() {
        return getTextForElement(GUIDE_SECTION_TITLE);
    }

    public boolean isGuideSectionContributorPhotoDisplayed() {
        return isElementDisplayed(GUIDE_SECTION_CONTRIBUTOR_PHOTO);
    }

    public boolean isGuideSectionContributorNameDisplayed() {
        return isElementDisplayed(GUIDE_SECTION_CONTRIBUTOR_NAME);
    }
}
