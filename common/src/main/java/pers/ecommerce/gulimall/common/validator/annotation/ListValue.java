package pers.ecommerce.gulimall.common.validator.annotation;

import pers.ecommerce.gulimall.common.validator.ListValueConstraintValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.ElementType.TYPE_USE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * <p>被校验数据只能是 values 内指定的值</p>
 * <p>@Constraint：指定校验器</p>
 * <p>@Documented：是否在 javadoc 中显示该注解的注释信息</p>
 * <p>@Constraint：指定校验器</p>
 *
 * @author AzraelZJ
 * @date 2022/8/26 19:53
 */
@Documented
@Constraint(validatedBy = ListValueConstraintValidator.class)
@Target({METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER, TYPE_USE})
@Retention(RUNTIME)
public @interface ListValue {

    String message() default "{pers.ecommerce.gulimall.common.validator.annotation.ListValue.message}";

    Class<?>[] groups() default {};

    // 自定义负载信息
    Class<? extends Payload>[] payload() default {};

    // 数据中允许的值
    int[] values() default {};
}
