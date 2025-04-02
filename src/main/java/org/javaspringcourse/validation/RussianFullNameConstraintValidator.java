package org.javaspringcourse.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.Arrays;
import java.util.regex.Pattern;

/**Проверяет, соответствует ли введённая строка Фамилии-Имени-Отчеству в русском алфавите.*/
public class RussianFullNameConstraintValidator implements ConstraintValidator<RussianFullName, String> {
    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        var name = s.split(" ");
        if (name.length != 3) return false;
        return Arrays.stream(name).allMatch(n -> Pattern.matches("^[А-Яа-я]+(-?[А-Яа-я]+)?$", n));
    }
}
