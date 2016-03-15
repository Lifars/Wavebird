package com.lifars.wavebird.controllers.filter;

public class Filter<T, U> {
    private BiPredicate<T, U> biPredicate;
    private U filterElement;

    public Filter(BiPredicate<T, U> biPredicate, U filterElement) {
        this.biPredicate = biPredicate;
        this.filterElement = filterElement;
    }

    public boolean test(T element) {
        return biPredicate.test(element, filterElement);
    }
}
