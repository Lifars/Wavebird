package com.lifars.wavebird;

import android.view.View;

/**
 * A StateStrategy defines how a {@link android.view.View} has it's state saved and loaded into a custom
 * state object.
 *
 * <br><br>
 *
 * For example, consider saving state from and restoring state to a search bar:
 *
 * <br><br>
 *
 * <pre>
 * <code>
    public SearchStateStrategy implements StateStrategy&lt;SearchState> {
        &#64;Override
        public SearchState save(View view) {
            EditText searchbar = (EditText) view.findViewById(R.id.search_bar);
            String searchTerm = searchBar.getText().toString();

            return new SearchState(searchTerm);
        }

        &#64;Override
        public void load(View view, SearchState state) {
            EditText searchbar = (EditText) view.findViewById(R.id.search_bar);
            searchBar.setText(state.searchTerm);
        }
    }
 * </code>
 * </pre>
 *
 * @param <S> The object that can store the state of the {@link android.view.View}
 */
public interface StateStrategy<S> {
    /**
     * This defines how state is saved from a {@link android.view.View}.
     *
     * @param view The {@link android.view.View} which will have it's state saved
     * @return The resulting custom state object
     */
    S save(View view);

    /**
     * This defines how state will be loaded into a {@link android.view.View}.
     *
     * @param view  The {@link android.view.View} which will have it's state updated
     * @param state The object that contains state for the {@link android.view.View}
     */
    void load(View view, S state);
}
