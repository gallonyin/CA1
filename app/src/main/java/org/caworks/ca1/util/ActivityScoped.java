package org.caworks.ca1.util;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;

/**
 * Created by Gallon on 2017/4/10.
 */

@Scope
@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface ActivityScoped {
}
