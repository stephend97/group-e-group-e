package com.example.max.myapplication;

/**
 * Created by sarahpomeroy on 4/3/18.
 */

import android.app.Instrumentation;
import android.support.test.rule.ActivityTestRule;
import android.test.ActivityInstrumentationTestCase2;
import android.widget.Button;
import android.widget.EditText;
import org.junit.Test;

public class AddQuestionTests extends ActivityInstrumentationTestCase2<add_question> {

    public ActivityTestRule<add_question> rule = new ActivityTestRule<>(add_question.class);

    @Test
    public void addQuestionSaveTest() {
        Instrumentation.ActivityMonitor activityMonitor = getInstrumentation().addMonitor(add_question.class.getName(), null, false);
        add_question myActivity = getActivity();
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
        add_question nextActivity = getInstrumentation().waitForMonitorWithTimeout(activityMonitor, 5000);
        // next activity is opened and captured.
        assertNotNull(nextActivity);
        nextActivity.finish();
    }

    @Test
    public void addQuestionDoneTest() {
        Instrumentation.ActivityMonitor activityMonitor = getInstrumentation().addMonitor(teacher_home.class.getName(), null, false);
        add_question myActivity = getActivity();
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
        add_question nextActivity = getInstrumentation().waitForMonitorWithTimeout(activityMonitor, 5000);
        // next activity is opened and captured.
        assertNotNull(nextActivity);
        nextActivity.finish();
    }

    public void testText() {
        // simulate user action to input some value into EditText:
        final EditText mUsername = (EditText) mActivity.findViewById(R.id.username);
        final EditText mPassword = (EditText) mActivity.findViewById(R.id.password);
        mActivity.runOnUiThread(new Runnable() {
            public void run() {
                mUsername.setText("hello");
                mPassword.setText("hello123");
            }
        });

        // Check if the EditText is properly set:
        assertEquals("hello", mUsername.getText());
        assertEquals("hello123", mPassword.getText());
    }
}