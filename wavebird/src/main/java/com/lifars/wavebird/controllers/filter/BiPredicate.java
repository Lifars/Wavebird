package com.lifars.wavebird.controllers.filter;

public interface BiPredicate<T, U> {
    boolean test(T t, U u);
}