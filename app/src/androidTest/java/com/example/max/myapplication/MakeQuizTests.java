package com.example.max.myapplication;

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

/**
 * Created by sarahpomeroy on 4/3/18.
 */
@RunWith(AndroidJUnit4.class)
public class MakeQuizTests extends ActivityInstrumentationTestCase2<make_quiz> {

    make_quiz myActivity;

    public MakeQuizTests() {
        super(make_quiz.class);
    }

    @Rule
    public ActivityTestRule<make_quiz> rule = new ActivityTestRule<>(make_quiz.class);

    @Before
    public void setUp() throws Exception{
        super.setUp();
        myActivity = rule.getActivity();
        injectInstrumentation(InstrumentationRegistry.getInstrumentation());
    }

    @Test
    public void makeQuizAddQuestionsTest() {
        Instrumentation.ActivityMonitor activityMonitor = getInstrumentation().addMonitor(add_question.class.getName(), null, false);
        final Button button = (Button) myActivity.findViewById(R.id.Baddqs);
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
    public void makeQuizCompleteTest() {
        Instrumentation.ActivityMonitor activityMonitor = getInstrumentation().addMonitor(teacher_home.class.getName(), null, false);
        final Button button = (Button) myActivity.findViewById(R.id.Bcomplete);
        myActivity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                // click button and open next activity.
                button.performClick();
            }
        });

        //Watch for the timeout
        //example values 5000 if in ms, or 5 if it's in seconds.
        teacher_home nextActivity = (teacher_home) getInstrumentation().waitForMonitorWithTimeout(activityMonitor, 5000);
        // next activity is opened and captured.
        assertNotNull(nextActivity);
        nextActivity.finish();
    }
}
