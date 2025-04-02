package org.javaspringcourse.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@NotNull
@Size(min = 5, max = 40)
@Constraint(validatedBy = {})
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface Title {
    String message() default "Длина названия должна находиться в диапазоне от 5 до 40.";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
