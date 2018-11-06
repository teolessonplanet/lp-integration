package com.lessonplanet.pages;

import org.openqa.selenium.WebDriver;

public class ShareEmailModal extends LpUiBasePage {
    
    private static final String SHARE_RESOURCE_VIA_EMAIL_MODAL = "#js-email-share-modal";
    private static final String EMAIL_INPUT = "#email_recipients";
    private static final String SHARE_RESOURCE_BUTTON = "#submit-share-btn";
    
    public ShareEmailModal(WebDriver driver) {
        super(driver);
    }
    
    public void waitForModal() {
        waitForBootstrapModalToBeVisible(SHARE_RESOURCE_VIA_EMAIL_MODAL);
    }
    
    public void typeEmail(String email) {
        sendKeys(EMAIL_INPUT, email);
    }
    
    public void clickOnShareResourceButton() {
        clickElement(SHARE_RESOURCE_BUTTON);
    }
}
