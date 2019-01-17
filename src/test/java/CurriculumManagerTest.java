import com.lessonplanet.pages.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import util.TestData;
import java.io.File;

public class CurriculumManagerTest extends BaseTest {

    private LpHomePage lpHomePage;
    private HeaderPage headerPage;
    private CurriculumManagerPage curriculumManagerPage;
    private CreateNewCollectionModal createNewCollectionModal;
    private EditCollectionModal editCollectionModal;
    private EditResourceModal editResourceModal;
    private DiscoverResourcesPage discoverResourcesPage;
    private CollectionBuilderPage collectionBuilderPage;
    private CopyCollectionModal copyCollectionModal;
    private UpgradeMaxCollectionModal upgradeMaxCollectionModal;
    private UpgradeAssignModal upgradeAssignModal;
    private UpgradeUploadModal upgradeUploadModal;
    private RrpModal rrpModal;
    private RrpPage rrpPage;
    private RemoveModal removeModal;
    private PublishResourceModal publishResourceModal;
    private PublishCollectionModal publishCollectionModal;
    private UploadFileModal uploadFileModal;
    private AssignModal assignModal;
    private ShareEmailModal shareEmailModal;
    private ShareLinkModal shareLinkModal;
    private BecomeALessonPlanetFreeMemberModal becomeALessonPlanetFreeMemberModal;
    private StepOnePage stepOnePage;
    private StepTwoModal stepTwoModal;
    private StepTwoPage stepTwoPage;
    private MyAccountPage myAccountPage;
    private ManageMembershipPage manageMembershipPage;

    @BeforeMethod
    public void beforeMethod() {
        lpHomePage = new LpHomePage(webDriver);
        stepOnePage = new StepOnePage(webDriver);
        stepTwoModal = new StepTwoModal(webDriver);
        stepTwoPage = new StepTwoPage(webDriver);
        myAccountPage = new MyAccountPage(webDriver);
        manageMembershipPage = new ManageMembershipPage(webDriver);
        headerPage = new HeaderPage(webDriver);
        discoverResourcesPage = new DiscoverResourcesPage(webDriver);
        rrpModal = new RrpModal(webDriver);
        rrpPage = new RrpPage(webDriver);
        collectionBuilderPage = new CollectionBuilderPage(webDriver);
        curriculumManagerPage = new CurriculumManagerPage(webDriver);
        becomeALessonPlanetFreeMemberModal = new BecomeALessonPlanetFreeMemberModal(webDriver);
        createNewCollectionModal = new CreateNewCollectionModal(webDriver);
        upgradeMaxCollectionModal = new UpgradeMaxCollectionModal(webDriver);
        upgradeAssignModal = new UpgradeAssignModal(webDriver);
        upgradeUploadModal = new UpgradeUploadModal(webDriver);
        editCollectionModal = new EditCollectionModal(webDriver);
        editResourceModal = new EditResourceModal(webDriver);
        copyCollectionModal = new CopyCollectionModal(webDriver);
        removeModal = new RemoveModal(webDriver);
        publishResourceModal = new PublishResourceModal(webDriver);
        publishCollectionModal = new PublishCollectionModal(webDriver);
        uploadFileModal = new UploadFileModal(webDriver);
        assignModal = new AssignModal(webDriver);
        shareEmailModal = new ShareEmailModal(webDriver);
        shareLinkModal = new ShareLinkModal(webDriver);
    }

    public void reachCurriculumManagerPage(WebDriver webDriver){
        this.webDriver = webDriver;
        beforeMethod();
    }

    @Test(description = "Visitor - Curriculum Manager - lessonp-3258: Access Curriculum Manager Page")
    public void testLessonp_3258() {
        lpHomePage.loadPage();
        testAccessCurriculumManagerPageFromHeader(false);
        testAccessCurriculumManagerPageFromSearchPage(false);
        testAccessCurriculumManagerPageFromEditCollectionModal(false);
    }

    @Test(description = "Freemium - Curriculum Manager - lessonp-3270: Access Curriculum Manager Page")
    public void testLessonp_3270() {
        createAFreeMemberAccount();
        testAccessCurriculumManagerPageFromHeader(true);
        testAccessCurriculumManagerPageFromSearchPage(true);
        testAccessCurriculumManagerPageFromEditCollectionModal(true);
    }

    @Test(description = "All Active Users - Curriculum Manager - lessonp-3283: Access Curriculum Manager Page")
    public void testLessonp_3283() {
        createAnActiveAccount(TestData.PRIME_OPTION_TEXT);
        testAccessCurriculumManagerPageFromHeader(true);
        testAccessCurriculumManagerPageFromSearchPage(true);
        testAccessCurriculumManagerPageFromEditCollectionModal(true);
    }

    @Test(description = "Freemium - Curriculum Manager - lessonp-3250: Create Collections")
    public void testLessonp_3250() {
        createAFreeMemberAccount();
        testMaxLimitOfCollectionsCreated();
    }

    @Test(description = "All Active Users - Curriculum Manager - lessonp-3259: Create Collections")
    public void testLessonp_3259() {
        createAnActiveAccount(TestData.STARTER_OPTION_TEXT);
        testMaxLimitOfCollectionsCreated();
    }

    @Test(description = "Freemium - Curriculum Manager - lessonp-3249: Delete Collection")
    public void testLessonp_3249() {
        createAFreeMemberAccount();
        curriculumManagerPage.loadPage();
        testCreateCollectionFromCurriculumManager(TestData.NEW_COLLECTION_NAME);
        testDeleteCollection();
    }

    @Test(description = "All Active Users - Curriculum Manager - lessonp-3272: Delete Collection")
    public void testLessonp_3272() {
        createAnActiveAccount(TestData.STARTER_OPTION_TEXT);
        curriculumManagerPage.loadPage();
        testCreateCollectionFromCurriculumManager(TestData.NEW_COLLECTION_NAME);
        testDeleteCollection();
    }

    @Test(description = "Freemium - Curriculum Manager - lessonp-3251: Upload Resource")
    public void testLessonp_3251()  {
        createAFreeMemberAccount();
        testUploadResourceUsingTextInput(TestData.FREE_MEMBERSHIP_TEXT);
    }

    @Test(description = "All Active Users - Curriculum Manager - lessonp-3261: Upload Resource")
    public void testLessonp_3261() {
        createAnActiveAccount(TestData.PRO_OPTION_TEXT);
        testUploadResourceUsingTextInput(TestData.PRO_OPTION_TEXT);
    }

    @Test(description = "Freemium - Curriculum Manager - lessonp-3969: Default Folders: My Uploads - Actions Dropdown")
    public void testLessonp_3969(){
        createAFreeMemberAccount();
        testMyUploadsFolderActions(TestData.FREE_MEMBERSHIP_TEXT) ;
    }

    @Test(description = "Starter - Curriculum Manager - lessonp- 3972: Default folders: My Uploads - Actions Dropdown")
    public void testLessonp_3972(){
        createAnActiveAccount(TestData.STARTER_OPTION_TEXT);
        testMyUploadsFolderActions(TestData.STARTER_OPTION_TEXT);
    }

    @Test(description = "Prime - Curriculum Manager - lessonp- 3973: Default folders: My Uploads - Actions Dropdown")
    public void testLessonp_3973(){
        createAnActiveAccount(TestData.PRIME_OPTION_TEXT);
        testMyUploadsFolderActions(TestData.PRIME_OPTION_TEXT);
    }

    @Test(description = "Pro - Curriculum Manager - lessonp- 3974: Default folders:  My Uploads - Actions Dropdown")
    public void testLessonp_3974(){
        createAnActiveAccount(TestData.PRO_OPTION_TEXT);
        testMyUploadsFolderActions(TestData.PRO_OPTION_TEXT);
    }

    @Test(description = "Freemium - Curriculum Manager - lessonp-3939: Default Folders: My Favorites - Actions Dropdown")
    public void testLessonp_3939(){
        createAFreeMemberAccount();
        testMyFavoritesFolderActions(TestData.FREE_MEMBERSHIP_TEXT);
    }

    @Test(description = "Starter - Curriculum Manager - lessonp- 3933: Default folders: My Favorites - Actions Dropdown")
    public void testLessonp_3933(){
        createAnActiveAccount(TestData.STARTER_OPTION_TEXT);
        testMyFavoritesFolderActions(TestData.STARTER_OPTION_TEXT);;
    }

    @Test(description = "Prime - Curriculum Manager - lessonp- 3934: Default folders: My Favorites - Actions Dropdown")
    public void testLessonp_3934(){
        createAnActiveAccount(TestData.PRIME_OPTION_TEXT);
        testMyFavoritesFolderActions(TestData.PRIME_OPTION_TEXT);
    }

    @Test(description = "Pro - Curriculum Manager - lessonp- 3935: Default folders: My Favorites - Actions Dropdown")
    public void testLessonp_3935(){
        createAnActiveAccount(TestData.PRO_OPTION_TEXT);
        testMyFavoritesFolderActions(TestData.PRO_OPTION_TEXT);
    }

    @Test(description = "Freemium - Curriculum Manager - lessonp-3254: Collection: Actions Dropdown")
    public void testLessonp_3254(){
        createAFreeMemberAccount();
        testCollectionFolderActions(TestData.FREE_MEMBERSHIP_TEXT);
    }

    @Test(description = "Starter - Curriculum Manager - lessonp-3869: Collection: Actions Dropdown")
    public void testLessonp_3869(){
        createAnActiveAccount(TestData.STARTER_OPTION_TEXT);
        testCollectionFolderActions(TestData.STARTER_OPTION_TEXT);
    }

    @Test(description = "Prime - Curriculum Manager - lessonp-3871: Collection: Actions Dropdown")
    public void testLessonp_3871(){
        createAnActiveAccount(TestData.PRIME_OPTION_TEXT);
        testCollectionFolderActions(TestData.PRIME_OPTION_TEXT);
    }

    @Test(description = "Pro - Curriculum Manager - lessonp-3270: Collection: Actions Dropdown")
    public void testLessonp_3870(){
        createAnActiveAccount(TestData.PRO_OPTION_TEXT);
        testCollectionFolderActions(TestData.PRO_OPTION_TEXT);
    }

    @Test(description = "Freemium - Curriculum Manager - lessonp-3252: List View")
    public void testLessonp_3252() {
        createAFreeMemberAccount();
        testListView();
    }

    @Test(description = "All Active Users - Curriculum Manager -  lessonp-3262: List View")
    public void testLessonp_3262() {
        createAnActiveAccount(TestData.PRIME_OPTION_TEXT);
        testListView();
    }

    @Test(description = "Freemium - Curriculum Manager - lessonp-3255: Sort By Options")
    public void testLessonp_3255() {
        createAFreeMemberAccount();
        testSortByDropdown();
    }

    @Test(description = "All Active Users - Curriculum Manager - lessonp-3264: Sort By Options")
    public void testLessonp_3264() {
        createAnActiveAccount(TestData.STARTER_OPTION_TEXT);
        testSortByDropdown();
    }

    @Test(description = "Freemium - Curriculum Manager - lessonp-3256: Items Status")
    public void testLessonp_3256(){
        createAFreeMemberAccount();
        testItemsStatus(TestData.FREE_MEMBERSHIP_TEXT);
    }

    @Test(description = "Starter - Curriculum Manager - lessonp-3873: Items Status")
    public void testLessonp_3873(){
        createAnActiveAccount(TestData.STARTER_OPTION_TEXT);
        testItemsStatus(TestData.STARTER_OPTION_TEXT);
    }

    @Test(description = "Prime - Curriculum Manager - lessonp-3874: Items Status")
    public void testLessonp_3874(){
        createAnActiveAccount(TestData.PRIME_OPTION_TEXT);
        testItemsStatus(TestData.PRIME_OPTION_TEXT);
    }

    @Test(description = "Pro - Curriculum Manager - lessonp-3872: Items Status")
    public void testLessonp_3872(){
        createAnActiveAccount(TestData.PRO_OPTION_TEXT);
        testItemsStatus(TestData.PRO_OPTION_TEXT);
    }

    public void createAFreeMemberAccount(){
        lpHomePage.loadPage();
        stepOnePage.completeStepOne(TestData.GET_NEW_EMAIL(), TestData.VALID_PASSWORD);
        getAccountPlan();
    }

    private void createAnActiveAccount(String accountPlanText){
        StepTwoTest stepTwoTest = new StepTwoTest();
        stepTwoTest.initAndReachStepTwoModal(webDriver);
        stepTwoModal.completeStepTwoModalWith(accountPlanText);
        getAccountPlan();
    }

    private void getAccountPlan(){
        myAccountPage.loadPage();
        myAccountPage.getPlan();
    }

    private void testAccessCurriculumManagerPageFromHeader(boolean loggedIn) {
        headerPage.hoverOverResourcesButton();
        headerPage.clickOnCurriculumManagerButton();
        if (!loggedIn) {
            Assert.assertTrue(headerPage.isSignInPopupLinkDisplayed());
            Assert.assertTrue(headerPage.isSignUpPopupLinkDisplyed());
        } else {
            Assert.assertEquals(headerPage.getPath(), TestData.CURRICULUM_MANAGER_PATH);
        }
    }

    private void testAccessCurriculumManagerPageFromSearchPage(boolean loggedIn) {
        discoverResourcesPage.loadPage();
        collectionBuilderPage.clickOnMyResources();
        if (!loggedIn) {
            Assert.assertTrue(collectionBuilderPage.isSignInPopupLinkDisplayed());
            Assert.assertTrue(collectionBuilderPage.isSignUpPopupLinkDisplayed());
        } else {
            Assert.assertEquals(discoverResourcesPage.getPath(), TestData.CURRICULUM_MANAGER_PATH);
        }
    }

    private void testAccessCurriculumManagerPageFromEditCollectionModal(boolean loggedIn){
        if (!loggedIn) {
            discoverResourcesPage.loadSearchPageInListView();
            discoverResourcesPage.selectFacetFilter(TestData.FACET_CATEGORY_RESOURCES_TYPES, TestData.FACET_CATEGORY_RESOURCES_TYPE_ARTICLES);
            final WebElement resource = discoverResourcesPage.getFreeAccessResource();
            discoverResourcesPage.dragAndDrop(resource, collectionBuilderPage.getCollectionDroppableZone());
            becomeALessonPlanetFreeMemberModal.waitForModal();
            becomeALessonPlanetFreeMemberModal.clickOnCloseModalButton();
            discoverResourcesPage.waitForLoad();
            collectionBuilderPage.clickOnEditCollection();
            Assert.assertTrue(collectionBuilderPage.isSignInPopupLinkDisplayed());
            Assert.assertTrue(collectionBuilderPage.isSignUpPopupLinkDisplayed());
        } else{
            testCreateCollectionFromCollectionBuilder();
            collectionBuilderPage.clickOnEditCollection();
            editCollectionModal.waitForModal();
            editCollectionModal.clickOnMyResourceButton();
            Assert.assertEquals(discoverResourcesPage.getPath(), TestData.CURRICULUM_MANAGER_PATH);
        }
    }

    public void testCreateCollectionFromCollectionBuilder(){
        discoverResourcesPage.loadPage();
        collectionBuilderPage.clickOnDropdown();
        collectionBuilderPage.clickOnCreateNewCollection();
        createNewCollectionModal.waitForModal();
        createNewCollectionModal.typeName(TestData.NEW_COLLECTION_NAME);
        createNewCollectionModal.clickOnCreateCollection();
    }

    public void testCreateCollectionFromCurriculumManager (String collectionName) {
        curriculumManagerPage.clickOnCreateACollectionButton();
        createNewCollectionModal.waitForModal();
        createNewCollectionModal.typeName(collectionName);
        createNewCollectionModal.typeDescription(TestData.NEW_COLLECTION_DESCRIPTION);
        createNewCollectionModal.clickOnCreateCollection();
        Assert.assertTrue(curriculumManagerPage.getUrl().contains(TestData.CURRICULUM_MANAGER_PATH));
        Assert.assertTrue(curriculumManagerPage.getNotificationText().contains(TestData.CREATED_MESSAGE));
        curriculumManagerPage.waitForNotificationToDisappear();
        Assert.assertEquals(curriculumManagerPage.getCollectionFolderTitle(), collectionName);
        Assert.assertEquals(curriculumManagerPage.getCollectionFolderStatus(), TestData.PRIVATE_STATUS);
    }

    public void testMaxLimitOfCollectionsCreated() {
        testCreateThreeCollections();
        curriculumManagerPage.clickOnCreateACollectionButton();
        if (upgradeMaxCollectionModal.isModalDisplayed()) {
            testUpgradeModalFromMaxCollectionLimit();
        } else {
            testCreateCollectionFromCurriculumManager(TestData.collectionName[3]);
        }
    }

    public void testCreateThreeCollections(){
        curriculumManagerPage.loadPage();
        for(int i=0; i<=2; i++) {
            testCreateCollectionFromCurriculumManager(TestData.collectionName[i]);
        }
    }

    public void testUpgradeModalFromMaxCollectionLimit(){
        upgradeMaxCollectionModal.waitForModal();
        Assert.assertEquals(upgradeMaxCollectionModal.getUpgradeModalText(), TestData.UPGRADE_MODAL_TEXT_FROM_MAX_COLLECTION_LIMIT);
        upgradeMaxCollectionModal.clickOnUpgradeMeButton();
        Assert.assertTrue(lpHomePage.getUrl().contains(TestData.STEP_ONE_PAGE_PATH));
        Assert.assertEquals(TestData.STEP_TWO_TITLE_MESSAGE, stepTwoPage.getTitleText());
        stepTwoPage.goBackOnePage();
    }

    private void testDeleteCollection() {
        curriculumManagerPage.hoverOverActionsDropdown();
        curriculumManagerPage.clickOnDeleteButton();
        removeModal.waitForModal();
        removeModal.clickOnRemoveButton();
        Assert.assertTrue(curriculumManagerPage.getNotificationText().contains(TestData.DELETED_MESSAGE ));
        curriculumManagerPage.waitForNotificationToDisappear();
    }

    public void testUploadResourceUsingTextInput(String accountPlanText) {
        curriculumManagerPage.loadPage();
        curriculumManagerPage.clickOnUploadResourceButton();
        if (accountPlanText.equals(TestData.FREE_MEMBERSHIP_TEXT)) {
            testUpgradeModalFromUploadButton();
        } else {
            uploadFileModal.waitForModal();
            File file = new File(System.getProperty("user.dir")+File.separator +"src"+File.separator+"main"+File.separator+"resources"+File.separator+"images"+File.separator+"test-upload-file.png");
            uploadFileModal.uploadUsingTextInput(file.getPath());
            uploadFileModal.selectGrade(TestData.UPLOAD_YOUR_FILE_GRADE);
            uploadFileModal.selectSubject(TestData.UPLOAD_YOUR_FILE_SUBJECT);
            uploadFileModal.selectResourceType(TestData.UPLOAD_YOUR_FILE_RESOURCE_TYPE);
            uploadFileModal.typeDescription(TestData.NEW_COLLECTION_DESCRIPTION);
            uploadFileModal.clickOnUploadButton();
            uploadFileModal.clickOnDoneButton();
            curriculumManagerPage.waitForRefreshIconToDisappear();
            Assert.assertTrue(curriculumManagerPage.getUrl().contains(TestData.CURRICULUM_MANAGER_PATH));
            testIsUploadResourceDisplayed();
        }
    }

    private void testIsUploadResourceDisplayed(){
        curriculumManagerPage.clickOnMyUploadsFolder();
        curriculumManagerPage.waitForRefreshIconToDisappear();
        Assert.assertTrue(curriculumManagerPage.isUploadResourceDisplayed());
        Assert.assertEquals(curriculumManagerPage.getUploadResourceTitle(), TestData.UPLOAD_RESOURCE_TITLE);
        Assert.assertEquals(curriculumManagerPage.getUploadResourceStatus(), TestData.PRIVATE_STATUS);
    }

    public void testUpgradeModalFromUploadButton(){
        upgradeUploadModal.waitForModal();
        Assert.assertEquals(upgradeUploadModal.getUpgradeModalText(), TestData.UPGRADE_MODAL_TEXT_FROM_UPLOAD_BUTTON);
        upgradeUploadModal.clickOnGetFullAccessNowButton();
        Assert.assertTrue(lpHomePage.getUrl().contains(TestData.STEP_ONE_PAGE_PATH));
        Assert.assertEquals(TestData.STEP_TWO_TITLE_MESSAGE, stepTwoPage.getTitleText());
        stepTwoPage.goBackOnePage();
    }

    private void testRemoveUploadResource(String accountPlanText){
        if(!accountPlanText.equals(TestData.PRO_OPTION_TEXT)) {
            curriculumManagerPage.clickOnMyUploadsFolder();
        }
        curriculumManagerPage.hoverOverActionsDropdown();
        curriculumManagerPage.clickOnDeleteButton();
        removeModal.clickOnRemoveButton();
        Assert.assertTrue(curriculumManagerPage.getNotificationText().contains(TestData.DELETED_MESSAGE) );
        curriculumManagerPage.waitForNotificationToDisappear();
        Assert.assertFalse(curriculumManagerPage.isUploadResourceDisplayed());
    }

    private void testMyFavoritesFolderActions(String accountPlanText){
        testFavoriteRegularResource(accountPlanText);
        testPlayResource(accountPlanText);
        testShareResource();
        testAssignResource(accountPlanText, TestData.ASSIGN_RESOURCE_MODAL_TEXT);
        testGoToResource(accountPlanText);
        testRemoveFavoriteResource();
    }

    public void testFavoriteRegularResource(String accountPlanText){
        discoverResourcesPage.loadSearchPageInListView();
        if (accountPlanText.equals(TestData.FREE_MEMBERSHIP_TEXT)) {
            discoverResourcesPage.clickSeeReview(false);
        } else {
            discoverResourcesPage.clickSeeFullReview(false);
        }
        testFavoriteResource(TestData.REGULAR_RESOURCE_STATUS);
    }

    private void testFavoriteResource(String resourceStatus){
        rrpModal.waitForModal();
        rrpModal.clickOnFavoriteButton();
        rrpModal.clickOnViewFavoritesLink();
        curriculumManagerPage.waitForLinkToLoad();
        curriculumManagerPage.clickOnMyFavoritesFolder();
        curriculumManagerPage.waitForRefreshIconToDisappear();
        Assert.assertTrue(curriculumManagerPage.isFavoriteResourceDisplayed());
        Assert.assertEquals(curriculumManagerPage.getFavoriteResourceStatus(), resourceStatus);
    }

    private void testPlayResource(String accountPlanText) {
        curriculumManagerPage.clickOnPlayButton();
        if(accountPlanText.equals(TestData.FREE_MEMBERSHIP_TEXT)) {
            testUpgradeModalFromAssignButton(accountPlanText, TestData.UPGRADE_MODAL_TEXT_FROM_PLAY_BUTTON);
            curriculumManagerPage.clickOnMyFavoritesFolder();
        } else {
            testNewTabURL(TestData.CURRICULUM_PLAYER_PATH);
        }
    }

    private void testUpgradeModalFromAssignButton(String accountPlanText, String bodyText){
        upgradeAssignModal.waitForModal();
        Assert.assertEquals(upgradeAssignModal.getUpgradeModalText(), bodyText);
        upgradeAssignModal.clickOnUpgradeMeButton();
        if(accountPlanText.equals(TestData.FREE_MEMBERSHIP_TEXT)){
            testStepTwoPageUrlAndTitle();
            stepTwoPage.goBackOnePage();
        } else{
            testManageMembershipPageUrlAndTitle();
            manageMembershipPage.goBackOnePage();
        }
    }

    private void testStepTwoPageUrlAndTitle(){
        Assert.assertTrue(lpHomePage.getUrl().contains(TestData.STEP_ONE_PAGE_PATH));
        Assert.assertEquals(TestData.STEP_TWO_TITLE_MESSAGE, stepTwoPage.getTitleText());
    }

    private void testManageMembershipPageUrlAndTitle(){
        Assert.assertTrue(lpHomePage.getUrl().contains(TestData.MANAGE_MEMBERSHIP_PAGE_PATH));
        Assert.assertEquals(TestData.MANAGE_MEMBERSHIP_TITLE_MESSAGE, manageMembershipPage.getTitleText());
    }

    private void testNewTabURL(String url){
        curriculumManagerPage.focusDriverToLastTab();
        curriculumManagerPage.waitForLinkToLoad();
        Assert.assertTrue(curriculumManagerPage.getUrl().contains(url));
        curriculumManagerPage.closeTab();
        curriculumManagerPage.waitForLoad();
        Assert.assertTrue(curriculumManagerPage.getUrl().contains(TestData.CURRICULUM_MANAGER_PATH));
    }

    private void testShareResource(){
        curriculumManagerPage.hoverOverShareButton();
        curriculumManagerPage.clickOnFacebookOption();
        testNewTabURL(TestData.FACEBOOK_URL);

        curriculumManagerPage.hoverOverShareButton();
        curriculumManagerPage.clickOnTwitterOption();
        testNewTabURL(TestData.TWITTER_URL);

        curriculumManagerPage.hoverOverShareButton();
        curriculumManagerPage.clickOnGoogleOption();
        testNewTabURL(TestData.GOOGLE_URL);

        curriculumManagerPage.hoverOverShareButton();
        curriculumManagerPage.clickOnEmailOption();
        shareEmailModal.waitForModal();
        shareEmailModal.typeEmail(TestData.VALID_EMAIL_ADMIN);
        shareEmailModal.clickOnShareResourceButton();
        curriculumManagerPage.waitForLoad();
        Assert.assertTrue(curriculumManagerPage.getNotificationText().contains(TestData.EMAIL_SENT_MESSAGE));
        curriculumManagerPage.waitForNotificationToDisappear();
        Assert.assertTrue(curriculumManagerPage.getUrl().contains(TestData.CURRICULUM_MANAGER_PATH));

        curriculumManagerPage.hoverOverShareButton();
        curriculumManagerPage.clickOnLinkOption();
        shareLinkModal.waitForModal();
        Assert.assertTrue(shareLinkModal.getTitleText().contains(TestData.SHARE_LINK_MODAL_TITLE));
        shareLinkModal.clickOnCloseButton();
        Assert.assertTrue(curriculumManagerPage.getUrl().contains(TestData.CURRICULUM_MANAGER_PATH));
    }

    public void testAssignResource(String accountPlanText, String assignBodyText) {
        curriculumManagerPage.hoverOverActionsDropdown();
        curriculumManagerPage.clickOnAssignButton();
        if(accountPlanText.equals(TestData.PRO_OPTION_TEXT)){
            assignModal.waitForModal();
            Assert.assertTrue(assignModal.getAssignModalText().contains(assignBodyText));
            assignModal.typeAccessKey(TestData.VALID_PASSWORD);
            assignModal.clickOnSaveButton();
            assignModal.clickOnCopyButton();
            Assert.assertTrue(assignModal.getCopiedLinkPopoverText().contains(TestData.COPIED_POPOVER_TEXT));
            assignModal.clickOnResetAccessKeyLink();
            Assert.assertTrue(assignModal.isAccessKeyFieldDisplayed());
            assignModal.clickOnCloseButton();
            Assert.assertTrue(curriculumManagerPage.getUrl().contains(TestData.CURRICULUM_MANAGER_PATH));
        } else {
            testUpgradeModalFromAssignButton(accountPlanText, TestData.UPGRADE_MODAL_TEXT_FROM_ASSIGN_BUTTON);
        }
    }

    private void testGoToResource(String accountPlanText){
        if(!accountPlanText.equals(TestData.PRO_OPTION_TEXT)){
            curriculumManagerPage.clickOnMyFavoritesFolder();
        }
        curriculumManagerPage.hoverOverActionsDropdown();
        curriculumManagerPage.clickOnGoToResourceButton();
        rrpModal.waitForModal();
        Assert.assertTrue(rrpPage.isTitleDisplayed());
        rrpModal.clickCloseModal();
        Assert.assertTrue(curriculumManagerPage.getUrl().contains(TestData.CURRICULUM_MANAGER_PATH));
    }

    private void testRemoveFavoriteResource() {
        curriculumManagerPage.hoverOverActionsDropdown();
        curriculumManagerPage.clickOnDeleteButton();
        removeModal.clickOnRemoveButton();
        Assert.assertTrue(curriculumManagerPage.getNotificationText().contains(TestData.REMOVED_FAVORITE_RESOURCE_MESSAGE));
        curriculumManagerPage.waitForNotificationToDisappear();
    }

    private void testMyUploadsFolderActions(String accountPlanText) {
        if (accountPlanText.equals(TestData.FREE_MEMBERSHIP_TEXT )) {
            curriculumManagerPage.loadPage();
            Assert.assertEquals(curriculumManagerPage.getMyUploadsFolderItemNumber(), TestData.ZERO_RESOURCES);
            curriculumManagerPage.clickOnMyUploadsFolder();
            Assert.assertFalse(curriculumManagerPage.isActionsDropdownDisplayed());
        } else {
            testUploadResourceUsingTextInput(accountPlanText);
            testEditResource();
            testPlayResource(accountPlanText);
            testPublishUploadResource();
            testAssignResource(accountPlanText, TestData.ASSIGN_RESOURCE_MODAL_TEXT);
            testRemoveUploadResource(accountPlanText);
        }
    }

    private void testEditResource(){
        curriculumManagerPage.clickOnEditButton();
        editResourceModal.waitForModal();
        editResourceModal.typeTitle(TestData.EDIT_TITLE);
        editResourceModal.clickOnUpdateButton();
        curriculumManagerPage.waitForRefreshIconToDisappear();
        Assert.assertEquals(curriculumManagerPage.getUploadResourceTitle(), TestData.UPLOAD_RESOURCE_EDIT_TITLE);
    }

    private void testPublishUploadResource() {
        curriculumManagerPage.hoverOverActionsDropdown();
        curriculumManagerPage.clickOnPublishButton();
        publishResourceModal.waitForModal();
        publishResourceModal.typeTitle(TestData.PUBLISH_RESOURCE_TITLE);
        publishResourceModal.clickAgreementOption();
        publishResourceModal.clickOnPublishResourceButton();
        curriculumManagerPage.waitForRefreshIconToDisappear();
        Assert.assertEquals(curriculumManagerPage.getUploadResourceStatus(), TestData.PUBLISHED_RESOURCE_STATUS);
        Assert.assertEquals(curriculumManagerPage.getUploadResourceTitle(), TestData.PUBLISH_RESOURCE_TITLE);
    }

    private void testCollectionFolderActions(String accountPlanText){
        curriculumManagerPage.loadPage();
        testCreateCollectionFromCurriculumManager(TestData.NEW_COLLECTION_NAME);
        testPlayCollection();
      //testPublishCollection();
        testAddRequiredInformationToCollection(accountPlanText);
        testPlayCollection();
      //testPublishCollection();
        testAssignResource(accountPlanText, TestData.ASSIGN_COLLECTION_MODAL_TEXT);
        testMaxLimitOfCollectionsCopied();
        testDeleteCollection();
    }

    public void testAddRequiredInformationToCollection(String accountPlanText)  {
        testAddRegularResourceToCollection(accountPlanText);
        testAddSharedResourceToCollection();
        testEditCollection();
    }

    public void testAddRegularResourceToCollection(String accountPlanText){
        discoverResourcesPage.loadSearchPageInListView();
        if (accountPlanText.equals(TestData.FREE_MEMBERSHIP_TEXT)) {
            discoverResourcesPage.clickSeeReview(false);
        } else {
            discoverResourcesPage.clickSeeFullReview(false);
        }
        testAddResourceToCollection(TestData.ONE_RESOURCES);
    }

    public void testAddSharedResourceToCollection() {
        discoverResourcesPage.loadSearchPageInListView();
        discoverResourcesPage.clickSeePreview(false);
        testAddResourceToCollection(TestData.TWO_RESOURCES);
    }

    private void testAddResourceToCollection(String itemNumber){
        rrpModal.waitForModal();
        rrpModal.clickOnAddToCollectionDropdown();
        rrpModal.clickCollectionFromAddToCollectionDropdown();
        Assert.assertTrue(rrpModal.getNotificationText().contains(TestData.RESOURCE_ADDED_TO_COLLECTION_MESSAGE));
        curriculumManagerPage.loadPage();
        Assert.assertTrue(curriculumManagerPage.getCollectionFolderItemNumber().contains(itemNumber));
        curriculumManagerPage.clickOnACollectionFolder();
        Assert.assertTrue(curriculumManagerPage.isResourceInCollectionDisplayed());
    }

    private void testEditCollection() {
        curriculumManagerPage.clickOnACollectionFolder();
        curriculumManagerPage.clickOnEditButton();
        editCollectionModal.waitForModal();
        editCollectionModal.typeTitle(TestData.EDIT_TITLE);
        editCollectionModal.selectGrade(TestData.EDIT_COLLECTION_GRADE_HIGHER_ED);
        editCollectionModal.selectSubject(TestData.EDIT_COLLECTION_SUBJECT_SPECIAL_EDUCATION_AND_PROGRAM_SPECIAL_EDUCATION);
        editCollectionModal.typeDescription(TestData.NEW_COLLECTION_DESCRIPTION);
        editCollectionModal.clickOnCloseButton();
        curriculumManagerPage.waitForRefreshIconToDisappear();
        //sometimes the collection name is not updated; the edit name process is done until the name is updated
        while(curriculumManagerPage.getCollectionFolderTitle().equals(TestData.NEW_COLLECTION_NAME)) {
            curriculumManagerPage.clickOnEditButton();
            editCollectionModal.waitForModal();
            editCollectionModal.typeTitle(TestData.EDIT_TITLE);
            editCollectionModal.clickOnCloseButton();
            curriculumManagerPage.waitForRefreshIconToDisappear();
        }
        Assert.assertEquals(curriculumManagerPage.getCollectionFolderTitle(), TestData.EDIT_COLLECTION_NAME);
    }

    private void testPlayCollection(){
        curriculumManagerPage.hoverOverPlayButton();
        if(curriculumManagerPage.getPopoverText().equals(TestData.PLAY_COLLECTION_WITH_ITEMS_POPOVER_TEXT)){
            curriculumManagerPage.clickOnPlayButton();
            testNewTabURL(TestData.CURRICULUM_PLAYER_PATH);
        } else {
            Assert.assertEquals(curriculumManagerPage.getPopoverText(), TestData.PLAY_COLLECTION_WITH_NO_ITEMS_POPOVER_TEXT);
        }
    }

    private void testPublishCollection(){
        curriculumManagerPage.hoverOverActionsDropdown();
        curriculumManagerPage.hoverOverPublishButton();
        if(curriculumManagerPage.getPopoverText().equals(TestData.PUBLISH_COLLECTION_WITH_ITEMS_POPOVER_TEXT)) {
            testClickOnPublishButton();
            //sometimes after publishing, the resource appears as published, but it acts like it's private, so the publish process is done once again
            if (curriculumManagerPage.getCollectionFolderStatus().equals(TestData.PRIVATE_STATUS))
                testClickOnPublishButton();
            Assert.assertEquals(curriculumManagerPage.getCollectionFolderStatus(), TestData.PUBLISHED_STATUS);
        } else {
            Assert.assertEquals(curriculumManagerPage.getPopoverText(), TestData.PUBLISH_COLLECTION_WITH_NO_ITEMS_POPOVER_TEXT);
        }
    }

    private void testClickOnPublishButton(){
        curriculumManagerPage.hoverOverActionsDropdown();
        curriculumManagerPage.clickOnPublishButton();
        publishCollectionModal.waitForModal();
        publishCollectionModal.clickOnPublishNowButton();
        publishCollectionModal.clickOnCloseButton();
        curriculumManagerPage.waitForRefreshIconToDisappear();
    }

    private void testMaxLimitOfCollectionsCopied(){
        for (int i=0; i<2; i++){
            testClickOnCopyCollectionButton();
            testCloneCollection();
        }
        testClickOnCopyCollectionButton();
        if(!upgradeMaxCollectionModal.isModalDisplayed()) {
            testCloneCollection();
        } else{
            testUpgradeModalFromMaxCollectionLimit();
        }
    }

    private void testClickOnCopyCollectionButton(){
        curriculumManagerPage.hoverOverActionsDropdown();
        curriculumManagerPage.clickOnCopyCollectionButton();
    }
    private void testCloneCollection() {
        copyCollectionModal.waitForModal();
        copyCollectionModal.typeName(TestData.COPIED_COLLECTION_NAME);
        copyCollectionModal.clickOnCreateCopyButton();
        Assert.assertTrue(curriculumManagerPage.getNotificationText().contains(TestData.CREATED_MESSAGE));
        curriculumManagerPage.waitForNotificationToDisappear();
        Assert.assertEquals(curriculumManagerPage.getCollectionFolderTitle(), TestData.COPIED_COLLECTION_NAME);
    }

    private void testListView(){
        curriculumManagerPage.loadPage();
        curriculumManagerPage.clickOnShowMoreAndLessButton();
        Assert.assertFalse(curriculumManagerPage.isDateColumnDisplayed());
        Assert.assertFalse(curriculumManagerPage.isStatusColumnDisplayed());
        curriculumManagerPage.clickOnShowMoreAndLessButton();
        Assert.assertTrue(curriculumManagerPage.isStatusColumnDisplayed());
        Assert.assertTrue(curriculumManagerPage.isDateColumnDisplayed());
    }

    private void testSortByDropdown(){
        curriculumManagerPage.loadPage();
        curriculumManagerPage.clickOnSortByDropdown();
        Assert.assertTrue(curriculumManagerPage.isResourceTitleOptionDisplayed());
        Assert.assertTrue(curriculumManagerPage.isStatusOptionDisplayed());
        Assert.assertTrue(curriculumManagerPage.isDateOptionDisplayed());
        Assert.assertTrue(curriculumManagerPage.isMyOrderOptionDisplayed());
    }

    private void testItemsStatus(String accountPlanText){
        testDefaultFoldersStatus();
        testCollectionFolderStatus(accountPlanText);
        testUploadResourceStatus(accountPlanText);
        testFavoriteResourceStatus(accountPlanText);
    }

    private void testDefaultFoldersStatus(){
        curriculumManagerPage.loadPage();
        Assert.assertEquals(curriculumManagerPage.getMyFavoritesFolderStatus(), TestData.PRIVATE_STATUS);
        Assert.assertEquals(curriculumManagerPage.getMyUploadsFolderStatus(), TestData.PRIVATE_STATUS);
    }

    private void testUploadResourceStatus(String accountPlanText){
        if (!accountPlanText.equals(TestData.FREE_MEMBERSHIP_TEXT)) {
            testUploadResourceUsingTextInput(accountPlanText);
            testPublishUploadResource();
        }
    }

    private void testCollectionFolderStatus(String accountPlanText){
        testCreateCollectionFromCurriculumManager(TestData.NEW_COLLECTION_NAME);
        testAddRequiredInformationToCollection(accountPlanText);
        testPublishCollection();
    }

    private void testFavoriteResourceStatus(String accountPlanText){
        testFavoriteRegularResource(accountPlanText);
        testFavoriteSharedResource();
        if (accountPlanText.equals(TestData.FREE_MEMBERSHIP_TEXT)) {
            testFavoriteFreeSampleResource();
        }
    }

    private void testFavoriteSharedResource(){
        discoverResourcesPage.loadSearchPageInListView();
        discoverResourcesPage.clickSeePreview(false);
        testFavoriteResource(TestData.SHARED_RESOURCE_STATUS);
    }

    private void testFavoriteFreeSampleResource(){
        discoverResourcesPage.loadSearchPageInListView();
        discoverResourcesPage.clickFreeFullAccessReview(false);
        testFavoriteResource(TestData.FREE_SAMPLE_RESOURCE_STATUS);
    }

}
