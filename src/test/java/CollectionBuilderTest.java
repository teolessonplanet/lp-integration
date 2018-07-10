import com.lessonplanet.pages.*;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import util.TestData;

import java.util.List;

public class CollectionBuilderTest extends BaseTest {

    private LoginPage loginPage;
    private DiscoverResourcesPage discoverResourcesPage;
    private CollectionBuilderPage collectionBuilderPage;
    private CreateNewCollectionModal createNewCollectionModal;
    private EditCollectionModal editCollectionModal;
    private CollectionCreatedModal collectionCreatedModal;

    @BeforeMethod
    public void beforeMethod() {
        loginPage = new LoginPage(webDriver);
        discoverResourcesPage = new DiscoverResourcesPage(webDriver);
        collectionBuilderPage = new CollectionBuilderPage(webDriver);
        createNewCollectionModal = new CreateNewCollectionModal(webDriver);
        editCollectionModal = new EditCollectionModal(webDriver);
        collectionCreatedModal = new CollectionCreatedModal(webDriver);
    }

    @Test(description = " Steps:" +
            "1. Login" +
            "2. Go to Search Page" +
            "3. Click Create New Collection from CB->Dropdown" +
            "4. Drag&drop all resources from 1st page in the CB" +
            "5. Click Edit Collection" +
            "6. Type title, grade, subject & description" +
            "7. Click Publish Collection button" +
            "8. Verify the title when the modal is displayed"+
            "9. Click on Submit button.")
    public void testCreateNewCollectionAndPublish() {
        discoverResourcesPage.loadPage();
        loginPage.performLogin(TestData.VALID_EMAIL_ADMIN, TestData.VALID_PASSWORD);
        collectionBuilderPage.clickOnDropdown();
        collectionBuilderPage.clickOnCreateNewCollection();
        createNewCollectionModal.typeName(TestData.NEW_COLLECTION_NAME);
        createNewCollectionModal.typeDescription(TestData.NEW_COLLECTION_DESCRIPTION);
        createNewCollectionModal.clickOnCreateCollection();

        discoverResourcesPage.loadPage();
        discoverResourcesPage.clickOnListViewButton();

        discoverResourcesPage.selectFacetFilter(TestData.FACET_CATEGORY_RESOURCES_TYPES, TestData.FACET_CATEGORY_RESOURCES_TYPE_PRESENTATIONS);
        //put all 24 resources in the created collection
        final List<WebElement> allResources = discoverResourcesPage.getAllResources();
        for (WebElement resource : allResources) {
            discoverResourcesPage.dragAndDrop(resource, collectionBuilderPage.getCollectionDroppableZone());
        }

        collectionBuilderPage.clickOnEditCollection();
        editCollectionModal.selectGrade(TestData.EDIT_COLLECTION_GRADE_HIGHER_ED);
        editCollectionModal.selectSubject(TestData.EDIT_COLLECTION_SUBJECT_SPECIAL_EDUCATION_AND_PROGRAM_SPECIAL_EDUCATION);
        editCollectionModal.typeDescription(TestData.NEW_COLLECTION_DESCRIPTION);
        editCollectionModal.clickOnPublishCollection();

        Assert.assertEquals(TestData.COLLECTION_CREATED_MESSAGE, collectionCreatedModal.getTitle());
        collectionCreatedModal.clickOnSubmitButton();
    }
}
