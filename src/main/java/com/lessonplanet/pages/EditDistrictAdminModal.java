package com.lessonplanet.pages;

import org.openqa.selenium.WebDriver;

public class EditDistrictAdminModal extends EditSlUserModal {

    public EditDistrictAdminModal(WebDriver driver) {
        super(driver);
    }

    public boolean isDistrictAdminRoleChecked() {
        return getElementAttribute(DISTRICT_ADMIN_ROLE, "checked").equals("true");
    }
}
