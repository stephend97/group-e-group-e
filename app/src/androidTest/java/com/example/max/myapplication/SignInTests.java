package com.example.max.myapplication;

import android.app.Instrumentation;
import android.support.test.InstrumentationRegistry;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.ActivityInstrumentationTestCase2;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;

import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class SignInTests extends ActivityInstrumentationTestCase2<sign_in> {

    public SignInTests() {
        super(sign_in.class);
    }

    @Rule
    public ActivityTestRule<sign_in> rule = new ActivityTestRule<>(sign_in.class);
    sign_in myActivity;
     EditText mUsername;
     EditText mPassword;

    @Before
    public void setUp() throws Exception {
        super.setUp();
        myActivity = rule.getActivity();
        mUsername = myActivity.findViewById(R.id.ETusername);
        mPassword = myActivity.findViewById(R.id.ETpassword);
        injectInstrumentation(InstrumentationRegistry.getInstrumentation());
    }

    @Test
    public void testText() {

        // Type text and then press the button.
        onView(withId(R.id.ETusername))
                .perform(typeText("username"), closeSoftKeyboard());
        onView(withId(R.id.BSubmit)).perform(click());

        // Check that the text was changed.
        onView(withId(R.id.ETusername)).check(matches(withText("username")));

        //Type text and then press the button
        onView(withId(R.id.ETpassword))
                .perform(typeText("password"), closeSoftKeyboard());
        onView(withId(R.id.BSubmit)).perform(click());

        //Check that the text was changed
        onView(withId(R.id.ETpassword)).check(matches(withText("password")));
    }
}
