package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;
import android.text.TextUtils;

import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.concurrent.CountDownLatch;

import static org.junit.Assert.assertFalse;


/**
 * Instrumentation test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class GetJokesAndroidJUnitTest {

    private String jokeString;
    private CountDownLatch signal;


    @Test
    public void testGetJokeTask() throws InterruptedException {
        Context appContext = InstrumentationRegistry.getTargetContext();
        signal = new CountDownLatch(1);


        EndpointsAsyncTask task = new EndpointsAsyncTask(appContext);
        task.setListener(new EndpointsAsyncTask.JokeListener() {
            @Override
            public void onJokeReceived(String joke) {
                jokeString = joke;
                signal.countDown();
            }
        });

        task.execute(appContext);
        signal.await();

        assertFalse(TextUtils.isEmpty(jokeString));
    }
}
