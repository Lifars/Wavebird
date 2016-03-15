package com.lifars.wavebird.controllers.sort;

import java.util.Comparator;

public class SortEvent<T> {
    public final Comparator<T> comparator;

    public SortEvent(Comparator<T> comparator) {
        this.comparator = comparator;
    }
}
