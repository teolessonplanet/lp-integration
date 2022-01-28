package com.lessonplanet.pages;

import org.openqa.selenium.WebDriver;

public class EditTeacherModal extends EditSlUserModal {

    public EditTeacherModal(WebDriver driver) {
        super(driver);
    }

    public boolean isTeacherRoleChecked() {
        return getElementAttribute(TEACHER_ROLE, "checked").equals("true");
    }
}
