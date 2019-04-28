package com.liyao.authentication.exception;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD,ElementType.FIELD})//表示这个注解可以标注在哪里
@Retention(RetentionPolicy.RUNTIME)//运行时注解
@Constraint(validatedBy = MyConstarintValidator.class)//表明这是一个校验类，这个说明要用那个类的逻辑进行处理
public @interface MyConstraint {
    /**
     * 下面三个方法在每一个注解里面都存在，我们就照葫芦画瓢也加上
     * @return
     */
    String message() default "{org.hibernate.validator.constraints.NotBlank.message}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
