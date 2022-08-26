package pers.ecommerce.gulimall.common.validator;

import pers.ecommerce.gulimall.common.validator.annotation.ListValue;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.HashSet;
import java.util.Set;

/**
 * ListValue 校验器
 *
 * @author AzraelZJ
 * @date 2022/8/26 22:49
 */
public class ListValueConstraintValidator implements ConstraintValidator<ListValue, Integer> {

    private Set<Integer> set = new HashSet<>();

    /**
     * 初始化
     *
     * @param constraintAnnotation annotation instance for a given constraint declaration
     */
    @Override
    public void initialize(ListValue constraintAnnotation) {

        for (int value : constraintAnnotation.values()) {
            set.add(value);
        }
    }

    /**
     * 判断是否校验成功
     *
     * @param value   object to validate
     * @param context context in which the constraint is evaluated
     * @return
     */
    @Override
    public boolean isValid(Integer value, ConstraintValidatorContext context) {

        return set.contains(value);
    }
}
