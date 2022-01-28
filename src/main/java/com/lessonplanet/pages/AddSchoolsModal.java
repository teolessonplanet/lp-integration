package com.lessonplanet.pages;

import org.openqa.selenium.WebDriver;

public class AddSchoolsModal extends AddUserSlModal {

    private static final String BULK_UPLOAD_INFO_ICON = "div.form-group:nth-child(2) [class*='fa-info-circle']";
    private static final String BULK_UPLOAD_INFO_ICON_POPOVER_TEXT = "div.form-group:nth-child(2) [class='popuptext show']";
    private static final String UPLOAD_CSV_BUTTON = "[class='upload-area'] [class*='btn-primary']";
    private static final String DOWNLOAD_EXAMPLE_CSV_LINK = "[class='upload-area'] [class='download-example-csv']";
    private static final String SCHOOL_INPUT = "[class='form-control']";

    public AddSchoolsModal(WebDriver driver) {
        super(driver);
    }

    public void typeSchoolName(String name) {
        sendKeys(SCHOOL_INPUT, name);
    }

    public void clearSchoolName() {
        clearTextUsingActions(SCHOOL_INPUT);
    }

    public void hoverOverBulkUploadInfoIcon() {
        hoverOverElement(BULK_UPLOAD_INFO_ICON, true);
    }

    public String getBulkUploadInfoIconPopoverText() {
        return getTextForElement(BULK_UPLOAD_INFO_ICON_POPOVER_TEXT);
    }

    public boolean isUploadCsvButtonDisplayed() {
        return isElementDisplayed(UPLOAD_CSV_BUTTON);
    }

    public boolean isDownloadExampleCsvLinkDisplayed() {
        return isElementDisplayed(DOWNLOAD_EXAMPLE_CSV_LINK);
    }
}
