package com.lifars.wavebird;

/**
 * The interface Controller.
 *
 * @param <E> the type parameter
 */
public interface Controller<E> {
    /**
     * Save.
     */
    void save();

    /**
     * Load.
     */
    void load();

    /**
     * Post.
     *
     * @param event the event
     */
    void post(E event);
}
