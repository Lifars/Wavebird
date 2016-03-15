package com.lifars.wavebird;

import android.view.View;

/**
 * A {@code BindStrategy} is an interface for defining how and what a {@link android.view.View} will report to the
 * controller.
 *
 * <br><br>
 *
 * For example, consider how to make a controlled {@link android.widget.EditText} that
 * will function as a search bar.
 *
 * <br><br>
 *
 * In {@code bindListeners()}, the {@link android.widget.EditText} will call {@code addTextChangedListener()}
 * and post a {@link com.lifars.wavebird.controllers.filter.FilterEvent} to the {@link com.lifars.wavebird.controllers.FilterController}
 * defined in {@code handler()} from {@code onTextChanged()}. Here is how that would look:
 *
 * <br><br>
 *
 * <pre>
 * <code>
    public class SearchBindStrategy implements BindStrategy&lt;FilterController&lt;String, String>> {
        private FilterController<String, String> handler;

        &#64;Override
        public void handler(FilterController&lt;String, String> handler) {
            this.handler = handler;
        }

        &#64;Override
        public void bindListeners(View view) {
            EditText searchBar = (EditText) findViewById(view, R.id.search_bar);
            searchBar.addTextChangedListener(new TextWatcher() {
                &#64;Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

                &#64;Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {}

                &#64;Override
                public void afterTextChanged(Editable s) {
                    handler.post(new FilterEvent<>(
                        "SEARCH_TAG",
                        SEARCH_PREDICATE,
                        s.toString()
                    ));
                }
            });
        }

        private final BiPredicate&lt;String, String> SEARCH_PREDICATE = new BiPredicate<>() {
            public boolean test(String left, String right) {
                if(left == null ^ right == null {
                    return false;
                } else if(left == null && right == null) {
                    return true;
                }

                return left.equals(right);
            }
        }
    }
 * </code>
 * </pre>
 *
 * @param <T> The {@link Controller} that will handle events posted
 */
public interface BindStrategy<T> {
    /**
     * This defines who to pass events created by UI elements back to.
     *
     * @param handler The {@link Controller} that will handle events posted
     */
    void handler(T handler);

    /**
     * This defines how and what the UI will send events to the {@link Controller}.
     *
     * @param view The {@link android.view.View} which will be interacted with
     */
    void bindListeners(View view);
}
