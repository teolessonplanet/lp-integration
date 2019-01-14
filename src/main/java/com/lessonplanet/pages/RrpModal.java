package com.lessonplanet.pages;

import org.openqa.selenium.WebDriver;
import util.TestData;

import java.text.NumberFormat;
import java.text.ParseException;


public class RrpModal extends Rrp {
    private static final String RRP_MODAL = "#resource-modal";
    private static final String CLOSE_MODAL_BUTTON = "[class*='resource-modal-close']";

    public RrpModal(WebDriver driver) {
        super(driver);
    }

    public void waitForModal() {
        waitForBootstrapModalToBeVisible(RRP_MODAL);
    }

    public void clickCloseModal() {
        clickElement(CLOSE_MODAL_BUTTON);
    }

    public boolean isTitleDisplayed() {
        waitForModal();
        return super.isTitleDisplayed();
    }
}

