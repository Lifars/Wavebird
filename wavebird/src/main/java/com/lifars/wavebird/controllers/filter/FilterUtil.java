package com.lifars.wavebird.controllers.filter;

import java.util.ArrayList;
import java.util.List;

public class FilterUtil {
    @SuppressWarnings("unchecked")
    public static <T> List<T> filter(List<T> unfilteredList, Filter<T, ?> filter) {
        List<T> filteredList = new ArrayList<>();

        for(T element : unfilteredList) {
            if (filter.test(element)) {
                filteredList.add(element);
            }
        }

        return filteredList;
    }

    public static <T, U> BiPredicate<T, U> and(final BiPredicate<T, U> first, final BiPredicate<T, U> second) {
        return new BiPredicate<T, U>() {
            @Override
            public boolean test(T t, U u) {
                return first.test(t, u) && second.test(t, u);
            }
        };
    }

    public static <T, U> BiPredicate<T, U> or(final BiPredicate<T, U> first, final BiPredicate<T, U> second) {
        return new BiPredicate<T, U>() {
            @Override
            public boolean test(T t, U u) {
                return first.test(t, u) || second.test(t, u);
            }
        };
    }

    public static <T, U> BiPredicate<T, U> xor(final BiPredicate<T, U> first, final BiPredicate<T, U> second) {
        return new BiPredicate<T, U>() {
            @Override
            public boolean test(T t, U u) {
                return first.test(t, u) ^ second.test(t, u);
            }
        };
    }
}
