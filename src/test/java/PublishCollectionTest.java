import com.lessonplanet.pages.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import util.TestData;

public class PublishCollectionTest extends BaseTest {
    private StepTwoPage stepTwoPage;
    private RSL_PublishCollection rsl_publishCollectionTest;
    private CurriculumManagerPageTest curriculumManagerPageTest;
    private CollectionBuilderTest collectionBuilderTest;
    private DiscoverResourcesPage discoverResourcesPage;

    @BeforeMethod
    public void beforeMethod() {
        stepTwoPage = new StepTwoPage(webDriver);
        rsl_publishCollectionTest = new RSL_PublishCollection();
        initRslPublishCollectionTest();
        curriculumManagerPageTest = new CurriculumManagerPageTest();
        collectionBuilderTest = new CollectionBuilderTest();
        discoverResourcesPage = new DiscoverResourcesPage(webDriver);
    }

    public void initRslPublishCollectionTest() {
        rsl_publishCollectionTest.initTest(webDriver);
    }

    @Test(description = "Active User - Publish Collection - lessonp-5826: With LP Resources")
    public void testLessonp_5826() {
        stepTwoPage.createNewAccount(TestData.PLAN_PRO);
        rsl_publishCollectionTest.testAddResourcesToPublishCollection(false, false, TestData.PLAN_PRO, false);
    }

    @Test(description = "Active User- Publish Collection - lessonp-986: With LP Resources & Uploaded Resources - include file")
    public void testLessonp_986() {
        stepTwoPage.createNewAccount(TestData.PLAN_PRIME);
        rsl_publishCollectionTest.testAddResourcesToPublishCollection(false, true, TestData.PLAN_PRIME, true);
    }

    @Test(description = "Active User - Publish Collection - lessonp-987: With LP Resources & Uploaded Resources - do not include file")
    public void testLessonp_987() {
        stepTwoPage.createNewAccount(TestData.PLAN_STARTER);
        rsl_publishCollectionTest.testAddResourcesToPublishCollection(false, true, TestData.PLAN_STARTER, false);
    }

    @Test(description = "Active User - Publish Collection - lessonp-5827: With LP Resources & Folders")
    public void testLessonp_5827() {
        stepTwoPage.createNewAccount(TestData.PLAN_PRO);
        rsl_publishCollectionTest.testAddResourcesToPublishCollection(true, false, TestData.PLAN_PRO, false);
    }

    @Test(description = "Active User - Publish Collection - lessonp-5794: With LP Resources & Folders & Uploaded Resources - include file")
    public void testLessonp_5794() {
        stepTwoPage.createNewAccount(TestData.PLAN_PRIME);
        rsl_publishCollectionTest.testAddResourcesToPublishCollection(true, true, TestData.PLAN_PRIME, true);
    }

    @Test(description = "Active User - Publish Collection - lessonp-5795: With LP Resources & Folders & Uploaded Resources - do not include file")
    public void testLessonp_5795() {
        stepTwoPage.createNewAccount(TestData.PLAN_STARTER);
        rsl_publishCollectionTest.testAddResourcesToPublishCollection(true, true, TestData.PLAN_STARTER, false);
    }

    @Test(description = "Active User - Publish Collection - lessonp-5828: Collection not published modal")
    public void testLessonp_5828() {
        stepTwoPage.createNewAccount(TestData.PLAN_PRO);
        rsl_publishCollectionTest.testCollectionNotPublishedModal(TestData.PLAN_PRO);
    }

    @Test(description = "Active User - Publish Resource - lessonp-995: Publish Uploaded File - from My Resources")
    public void testLessonp_995() {
        stepTwoPage.createNewAccount(TestData.PLAN_PRO);
        curriculumManagerPageTest.reachCurriculumManagerPage(webDriver);
        curriculumManagerPageTest.testUploadResourceFromMyResources(TestData.PLAN_PRO, true);
    }

    @Test(description = "Active User - Publish Resource - lessonp-5616: Publish Uploaded FIle - from Collection Builder")
    public void testLessonp_5616() {
        stepTwoPage.createNewAccount(TestData.PLAN_PRO);
        discoverResourcesPage.loadSearchPageInListView();
        curriculumManagerPageTest.reachCurriculumManagerPage(webDriver);
        curriculumManagerPageTest.testCreateCollectionFromCollectionBuilder();
        collectionBuilderTest.initTest(webDriver);
        collectionBuilderTest.testUploadResourceFromCollectionBuilder(TestData.PLAN_PRO, true, TestData.PUBLISH_RESOURCE_TITLE);
    }
}
