package com.lessonplanet.pages;

import org.openqa.selenium.WebDriver;

public class EditOwnerModal extends EditSlUserModal {

    public EditOwnerModal(WebDriver driver) {
        super(driver);
    }

    public boolean isTeacherRoleDisabled() {
        return getElementAttribute(TEACHER_ROLE, "disabled", 0).equals("true");
    }

    public boolean isSchoolAdminRoleDisabled() {
        return getElementAttribute(SCHOOL_ADMIN_ROLE, "disabled", 0).equals("true");
    }

    public boolean isDistrictAdminRoleDisabled() {
        return getElementAttribute(DISTRICT_ADMIN_ROLE, "disabled", 0).equals("true");
    }
}
