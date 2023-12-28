package com.zino.membership.common;


import org.springframework.core.annotation.AliasFor;
import org.springframework.stereotype.Component;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Component
public @interface PersistenceAdapter {
    /**
     * 주로 dao에서 사용
     */
    @AliasFor(annotation = Component.class)
    String value() default "";
}
