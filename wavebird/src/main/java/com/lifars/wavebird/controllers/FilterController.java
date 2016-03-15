package com.lifars.wavebird.controllers;

import android.view.View;

import java.util.HashMap;
import java.util.Map;

import com.lifars.wavebird.BindStrategy;
import com.lifars.wavebird.Controller;
import com.lifars.wavebird.StateStrategy;
import com.lifars.wavebird.controllers.filter.Filter;
import com.lifars.wavebird.controllers.filter.FilterEvent;
import com.lifars.wavebird.controllers.filter.Filterable;

public class FilterController<T, S> implements Controller<FilterEvent<T, ?>> {
    private final Map<String, Filter<T, ?>> filterMap;

    private final View view;
    private final Filterable<T> adapter;
    private final StateStrategy<S> stateStrategy;

    private S state;

    public FilterController(Filterable<T> adapter, View view,
                            BindStrategy bindStrategy, StateStrategy<S> stateStrategy) {
        this.filterMap = new HashMap<>();

        bindStrategy.handler(this);
        bindStrategy.bindListeners(view);

        this.view = view;
        this.adapter = adapter;
        this.stateStrategy = stateStrategy;
    }

    public void save() {
        this.state = stateStrategy.save(view);
    }

    public void load() {
        if(state != null) {
            stateStrategy.load(view, state);
        }
    }

    public void post(FilterEvent<T, ?> event) {
        String type = event.filterTag;
        if(filterMap.containsKey(type)) {
            filterMap.remove(type);
        }

        filterMap.put(type, event.filter);

        adapter.filter(filterMap.values());
    }
}
