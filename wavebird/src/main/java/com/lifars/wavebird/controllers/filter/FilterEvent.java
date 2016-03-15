package com.lifars.wavebird.controllers.filter;

public class FilterEvent<T, U> {
    public final Filter<T, U> filter;
    public final String filterTag;

    public FilterEvent(String filterTag, BiPredicate<T, U> biPredicate, U filterElement) {
        this.filterTag = filterTag;
        this.filter = new Filter<>(biPredicate, filterElement);
    }
}
