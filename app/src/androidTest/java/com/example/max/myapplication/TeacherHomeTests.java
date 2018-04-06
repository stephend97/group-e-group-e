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

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class TeacherHomeTests extends ActivityInstrumentationTestCase2<teacher_home> {

    public TeacherHomeTests() {
        super(teacher_home.class);
    }

    @Rule
    public ActivityTestRule<teacher_home> rule = new ActivityTestRule<>(teacher_home.class);
    teacher_home myActivity;

    @Before
    public void setUp() throws Exception{
        super.setUp();
        myActivity = rule.getActivity();
        injectInstrumentation(InstrumentationRegistry.getInstrumentation());
    }

    @Test
    public void teacherHomeCreateQuizTest() {
        Instrumentation.ActivityMonitor activityMonitor = getInstrumentation().addMonitor(make_quiz.class.getName(), null, false);
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
        make_quiz nextActivity = (make_quiz) getInstrumentation().waitForMonitorWithTimeout(activityMonitor, 5000);
        // next activity is opened and captured.
        assertNotNull(nextActivity);
        nextActivity.finish();
    }

    @Test
    public void teacherHomeManageRosterTest() {
        Instrumentation.ActivityMonitor activityMonitor = getInstrumentation().addMonitor(manage_roster.class.getName(), null, false);
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
        manage_roster nextActivity = (manage_roster) getInstrumentation().waitForMonitorWithTimeout(activityMonitor, 5000);
        // next activity is opened and captured.
        assertNotNull(nextActivity);
        nextActivity.finish();
    }
}