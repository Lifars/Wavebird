package com.lifars.wavebird;

import java.util.Collections;
import java.util.List;

public final class Wavebird {
    private List<Controller<?>> controllers;

    public Wavebird(Controller<?>... controller) {
        Collections.addAll(controllers, controller);
    }

    public void saveAll() {
        for(Controller<?> controller : controllers) {
            controller.save();
        }
    }

    public void loadAll() {
        for(Controller<?> controller : controllers) {
            controller.load();
        }
    }
}
