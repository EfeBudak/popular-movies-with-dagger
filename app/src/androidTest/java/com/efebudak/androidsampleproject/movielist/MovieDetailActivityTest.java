package com.efebudak.androidsampleproject.movielist;


import android.support.test.espresso.ViewInteraction;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import com.efebudak.androidsampleproject.R;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.hamcrest.core.IsInstanceOf;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class MovieDetailActivityTest {

    @Rule
    public ActivityTestRule<MovieListActivity> mActivityTestRule = new ActivityTestRule<>(MovieListActivity.class);

    @Test
    public void movieDetailActivityTest() {
        ViewInteraction recyclerView = onView(
                allOf(withId(R.id.fragment_movie_list_recycler_view),
                        childAtPosition(
                                allOf(withId(R.id.fragment_movie_list_swipe_refresh_layout),
                                        childAtPosition(
                                                withId(R.id.activity_main_frame_layout),
                                                0)),
                                0),
                        isDisplayed()));
        recyclerView.perform(actionOnItemAtPosition(1, click()));

        ViewInteraction textView = onView(
                allOf(withId(R.id.fragment_movie_detail_text_view_popularity), withText("Popularity: 79"),
                        childAtPosition(
                                childAtPosition(
                                        IsInstanceOf.<View>instanceOf(android.widget.ScrollView.class),
                                        0),
                                3),
                        isDisplayed()));
        textView.check(matches(withText("Popularity:")));

    }

    private static Matcher<View> childAtPosition(
            final Matcher<View> parentMatcher, final int position) {

        return new TypeSafeMatcher<View>() {
            @Override
            public void describeTo(Description description) {
                description.appendText("Child at position " + position + " in parent ");
                parentMatcher.describeTo(description);
            }

            @Override
            public boolean matchesSafely(View view) {
                ViewParent parent = view.getParent();
                return parent instanceof ViewGroup && parentMatcher.matches(parent)
                        && view.equals(((ViewGroup) parent).getChildAt(position));
            }
        };
    }
}
