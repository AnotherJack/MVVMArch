package io.github.anotherjack.mvvmarch.di.scope;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;

import javax.inject.Scope;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Created by zhengj on 2018-2-2.
 */

@Scope
@Documented
@Retention(RUNTIME)
public @interface FragmentScope {
}
