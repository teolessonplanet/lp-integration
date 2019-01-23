package com.lessonplanet.pages;

import org.openqa.selenium.WebDriver;

public class RemoveModal extends CopyCollectionModal {

    public RemoveModal(WebDriver driver) {
        super(driver);
    }

    public void waitForModal() {
        waitForReactModalToBeVisible();
    }

    public void clickOnRemoveButton() {
        clickElement(CREATE_COPY_BUTTON);
    }
}
