package com.lessonplanet.pages;

import org.openqa.selenium.WebDriver;

public class ManageSchoolAdminsPage extends ManageDistrictAdminsPage {
    private static final String ADD_LINK_POPOVER_TEXT = "[class='group-table admins'] [class*='placeholder'] a [class*='popuptext']";

    public ManageSchoolAdminsPage(WebDriver driver) {
        super(driver);
    }

    public void hoverOverAddAdminLink() {
        hoverOverElement(ADD_ADMIN_LINK);
    }

    public String getAddLinkPopoverText() {
        return getTextForElement(ADD_LINK_POPOVER_TEXT);
    }
}
