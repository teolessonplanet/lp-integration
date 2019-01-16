package com.lessonplanet.pages;
import org.openqa.selenium.WebDriver;

public class UpgradeAssignModal extends LpUiBasePage {
    private static final String UPGRADE_MODAL_FROM_ASSIGN_BUTTON = "#popup-modal";
    private static final String UPGRADE_MODAL_TEXT_FROM_ASSIGN_BUTTON = "#popup-modal [class='modal-body']";
    private static final String UPGRADE_ME_BUTTON_FROM_ASSIGN_MODAL = "#popup-modal [class='get-now-btn']";

    public UpgradeAssignModal(WebDriver driver) {
        super(driver);
    }

    public void waitForUpgradeModalFromAssignButton() {
        waitForBootstrapModalToBeVisible(UPGRADE_MODAL_FROM_ASSIGN_BUTTON);
    }

    public String getTextFromUpgradeModalFromAssignButton() {
        return getTextForElement(UPGRADE_MODAL_TEXT_FROM_ASSIGN_BUTTON);
    }

    public void clickOnUpgradeMeButtonFromAssignModal(){
        clickElement(UPGRADE_ME_BUTTON_FROM_ASSIGN_MODAL);
    }
}
