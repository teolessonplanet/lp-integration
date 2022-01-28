package com.lessonplanet.pages;

import org.openqa.selenium.WebDriver;

public class EditSchoolAdminModal extends EditSlUserModal {

    public EditSchoolAdminModal(WebDriver driver) {
        super(driver);
    }

    public boolean isSchoolAdminRoleChecked() {
        return getElementAttribute(SCHOOL_ADMIN_ROLE, "checked").equals("true");
    }
}
