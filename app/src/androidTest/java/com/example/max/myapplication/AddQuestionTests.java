package com.example.max.myapplication;

/**
 * Created by sarahpomeroy on 4/3/18.
 */

import android.app.Instrumentation;
import android.support.test.InstrumentationRegistry;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.ActivityInstrumentationTestCase2;
import android.widget.Button;
import android.widget.EditText;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class AddQuestionTests extends ActivityInstrumentationTestCase2<add_question> {

    public AddQuestionTests() {
        super(add_question.class);
    }

    @Rule
    public ActivityTestRule<add_question> rule = new ActivityTestRule<>(add_question.class);
    add_question myActivity;

    @Before
    public void setUp() throws Exception{
        super.setUp();
        myActivity = rule.getActivity();
        injectInstrumentation(InstrumentationRegistry.getInstrumentation());
    }
    @Test
    public void addQuestionSaveTest() {
        Instrumentation.ActivityMonitor activityMonitor = getInstrumentation().addMonitor(add_question.class.getName(), null, false);
        final Button button = (Button) myActivity.findViewById(R.id.Bsave);
        myActivity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                // click button and open next activity.
                button.performClick();
            }
        });

        //Watch for the timeout
        //example values 5000 if in ms, or 5 if it's in seconds.
        add_question nextActivity = (add_question)getInstrumentation().waitForMonitorWithTimeout(activityMonitor, 5000);
        // next activity is opened and captured.
        assertNotNull(nextActivity);
        nextActivity.finish();
    }

    @Test
    public void addQuestionDoneTest() {
        Instrumentation.ActivityMonitor activityMonitor = getInstrumentation().addMonitor(teacher_home.class.getName(), null, false);
        final Button button = (Button) myActivity.findViewById(R.id.Bdone);
        myActivity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                // click button and open next activity.
                button.performClick();
            }
        });

        //Watch for the timeout
        //example values 5000 if in ms, or 5 if it's in seconds.
        teacher_home nextActivity = (teacher_home)getInstrumentation().waitForMonitorWithTimeout(activityMonitor, 5000);
        // next activity is opened and captured.
        assertNotNull(nextActivity);
        nextActivity.finish();
    }
}