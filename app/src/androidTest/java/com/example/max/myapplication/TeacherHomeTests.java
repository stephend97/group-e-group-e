package com.example.max.myapplication;

/**
 * Created by sarahpomeroy on 4/3/18.
 */

import android.app.Instrumentation;
import android.support.test.rule.ActivityTestRule;
import android.test.ActivityInstrumentationTestCase2;
import android.widget.Button;
import org.junit.Test;

public class TeacherHomeTests extends ActivityInstrumentationTestCase2<teacher_home> {

    public ActivityTestRule<teacher_home> rule = new ActivityTestRule<>(teacher_home.class);

    @Test
    public void teacherHomeCreateQuizTest() {
        Instrumentation.ActivityMonitor activityMonitor = getInstrumentation().addMonitor(make_quiz.class.getName(), null, false);
        teacher_home myActivity = getActivity();
        final Button button = (Button) myActivity.findViewById(R.id.Btester);
        myActivity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                // click button and open next activity.
                button.performClick();
            }
        });

        //Watch for the timeout
        //example values 5000 if in ms, or 5 if it's in seconds.
        teacher_home nextActivity = getInstrumentation().waitForMonitorWithTimeout(activityMonitor, 5000);
        // next activity is opened and captured.
        assertNotNull(nextActivity);
        nextActivity.finish();
    }

    @Test
    public void teacherHomeManageRosterTest() {
        Instrumentation.ActivityMonitor activityMonitor = getInstrumentation().addMonitor(manage_roster.class.getName(), null, false);
        teacher_home myActivity = getActivity();
        final Button button = (Button) myActivity.findViewById(R.id.Broster);
        myActivity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                // click button and open next activity.
                button.performClick();
            }
        });

        //Watch for the timeout
        //example values 5000 if in ms, or 5 if it's in seconds.
        teacher_home nextActivity = getInstrumentation().waitForMonitorWithTimeout(activityMonitor, 5000);
        // next activity is opened and captured.
        assertNotNull(nextActivity);
        nextActivity.finish();
    }
}