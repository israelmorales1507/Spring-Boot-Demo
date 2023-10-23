package com.example.springdemo.mvc.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class CourseCodeConstrainValidator implements ConstraintValidator<CourseCode, String> {
    private String coursePreFix;

    @Override
    public void initialize(CourseCode constraintAnnotation) {
        coursePreFix = constraintAnnotation.value();
    }

    @Override
    public boolean isValid(String code, ConstraintValidatorContext constraintValidatorContext) {
        if (code != null)
            return code.startsWith(this.coursePreFix);
        else
            return false;
    }
}
