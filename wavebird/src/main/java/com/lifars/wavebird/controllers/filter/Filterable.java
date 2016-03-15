package com.lifars.wavebird.controllers.filter;

import java.util.Collection;

public interface Filterable<T> {
    void filter(Collection<Filter<T, ?>> filters);
}
