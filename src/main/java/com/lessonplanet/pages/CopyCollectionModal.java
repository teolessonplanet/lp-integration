package com.lessonplanet.pages;

import org.openqa.selenium.WebDriver;

public class CopyCollectionModal extends Rrp {

    public static final String CREATE_COPY_BUTTON = "[class*='btn-primary mr5']";
    private static final String NAME_INPUT = "[name='collectionTitle']";
    
    public CopyCollectionModal(WebDriver driver) {
        super(driver);
    }

    public void waitForModal() {
        waitForReactModalToBeVisible();
    }

    public void typeName(String name) {
        clearText(NAME_INPUT);
        sendKeys(NAME_INPUT, name);
    }

    public void clickOnCreateCopyButton() {
        waitForModal();
        clickElement(CREATE_COPY_BUTTON);
    }
}
