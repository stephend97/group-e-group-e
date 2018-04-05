package com.example.max.myapplication;

import android.app.Instrumentation;
import android.support.test.rule.ActivityTestRule;
import android.test.ActivityInstrumentationTestCase2;
import android.widget.Button;

import org.junit.Test;

/**
 * Created by sarahpomeroy on 4/3/18.
 */

public class MakeQuizTests extends ActivityInstrumentationTestCase2<make_quiz> {

    public ActivityTestRule<make_quiz> rule = new ActivityTestRule<>(make_quiz.class);

    @Test
    public void makeQuizAddQuestionsTest() {
        Instrumentation.ActivityMonitor activityMonitor = getInstrumentation().addMonitor(add_question.class.getName(), null, false);
        make_quiz myActivity = getActivity();
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
        make_quiz nextActivity = getInstrumentation().waitForMonitorWithTimeout(activityMonitor, 5000);
        // next activity is opened and captured.
        assertNotNull(nextActivity);
        nextActivity.finish();
    }

    @Test
    public void makeQuizCompleteTest() {
        Instrumentation.ActivityMonitor activityMonitor = getInstrumentation().addMonitor(teacher_home.class.getName(), null, false);
        make_quiz myActivity = getActivity();
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
        make_quiz nextActivity = getInstrumentation().waitForMonitorWithTimeout(activityMonitor, 5000);
        // next activity is opened and captured.
        assertNotNull(nextActivity);
        nextActivity.finish();
    }
}
}
