package org.javaspringcourse.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import jakarta.validation.constraints.NotBlank;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@NotBlank
@Constraint(validatedBy = RussianFullNameConstraintValidator.class)
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface RussianFullName {
    String message() default "Введённое ФИО не соответствует формату: \"Фамилия Имя Отчество\" (допускаются двойные фамилии).";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
