package com.lifars.wavebird.controllers;

import android.view.View;

import com.lifars.wavebird.BindStrategy;
import com.lifars.wavebird.Controller;
import com.lifars.wavebird.StateStrategy;
import com.lifars.wavebird.controllers.sort.SortEvent;
import com.lifars.wavebird.controllers.sort.Sortable;

public class SortController<T, S> implements Controller<SortEvent<T>> {
    private final View view;
    private final Sortable<T> adapter;
    private final StateStrategy<S> stateStrategy;

    private S state;

    public SortController(Sortable<T> adapter, View view,
                          BindStrategy bindStrategy, StateStrategy<S> stateStrategy) {
        bindStrategy.handler(this);
        bindStrategy.bindListeners(view);

        this.view = view;
        this.adapter = adapter;
        this.stateStrategy = stateStrategy;
    }

    @Override
    public void save() {
        this.state = stateStrategy.save(view);
    }

    @Override
    public void load() {
        if(state != null) {
            stateStrategy.load(view, state);
        }
    }

    @Override
    public void post(SortEvent<T> event) {
        adapter.sort(event.comparator);
    }
}
