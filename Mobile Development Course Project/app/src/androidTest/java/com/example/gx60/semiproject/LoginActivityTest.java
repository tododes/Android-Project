package com.example.gx60.semiproject;

import android.support.test.rule.ActivityTestRule;
import android.view.View;
import android.widget.Button;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.matcher.ViewMatchers.isClickable;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.junit.Assert.*;

/**
 * Created by GX60 on 31/05/2017.
 */
public class LoginActivityTest {

    @Rule
    public ActivityTestRule<LoginActivity> loginActivityRule = new ActivityTestRule<LoginActivity>(LoginActivity.class);

    private LoginActivity activity = null;

    @Before
    public void setUp() throws Exception {
        activity = loginActivityRule.getActivity();
    }

    @Test
    public void testLaunch(){
        Button view = (Button)activity.findViewById(R.id.button_login);
        assertNotNull(activity);
        assertNotNull(view);
        assertEquals(activity.getDB(), Database.getDB(activity));
        onView(withText("Say hello")).perform(click());
    }

    @After
    public void tearDown() throws Exception {

    }

}