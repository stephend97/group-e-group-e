package com.example.max.myapplication;

import android.app.Instrumentation.ActivityMonitor;
import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;
import android.support.test.rule.ActivityTestRule;
import android.test.ActivityInstrumentationTestCase2;
import android.widget.Button;
import android.test.*;

import org.junit.Rule;
import org.junit.Test;
import org.junit.Before;
import org.junit.runner.RunWith;
import static android.support.test.espresso.action.ViewActions.click;
import static org.junit.Assert.*;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */

@RunWith(AndroidJUnit4.class)
public class MainActivityTests extends ActivityInstrumentationTestCase2<MainActivity>{

    @Before
    public void setUp() throws Exception {
        super.setUp();
        injectInstrumentation(InstrumentationRegistry.getInstrumentation());
    }
    /*@Test
    public void useAppContext() throws Exception {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();

        assertEquals("com.example.max.myapplication", appContext.getPackageName());
    }*/

    @Rule
    public ActivityTestRule<MainActivity> rule  = new  ActivityTestRule<>(MainActivity.class);
    public ActivityTestRule<sign_up> rule2 = new ActivityTestRule<>(sign_up.class);

    @Test
    public void mainActivitySignInTest() {
        ActivityMonitor activityMonitor = getInstrumentation().addMonitor(sign_up.class.getName(), null, false);
        MainActivity myActivity = getActivity();
        final Button button = (Button) myActivity.findViewById(R.id.Bsignin);
        myActivity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                // click button and open next activity.
                button.performClick();
            }
        });

        //Watch for the timeout
        //example values 5000 if in ms, or 5 if it's in seconds.
        sign_in nextActivity = getInstrumentation().waitForMonitorWithTimeout(activityMonitor, 5000);
        
        // next activity is opened and captured.
        assertNotNull(nextActivity);
        nextActivity.finish();
    }

    @Test
    public void mainActivitySignUpTest() {
        ActivityMonitor activityMonitor = getInstrumentation().addMonitor(sign_up.class.getName(), null, false);
        MainActivity myActivity = getActivity();
        final Button button = (Button) myActivity.findViewById(R.id.Bsignup);
        myActivity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                // click button and open next activity.
                button.performClick();
            }
        });

        //Watch for the timeout
        //example values 5000 if in ms, or 5 if it's in seconds.
        sign_up nextActivity = getInstrumentation().waitForMonitorWithTimeout(activityMonitor, 5000);
        // next activity is opened and captured.
        assertNotNull(nextActivity);
        nextActivity.finish();
    }

}
