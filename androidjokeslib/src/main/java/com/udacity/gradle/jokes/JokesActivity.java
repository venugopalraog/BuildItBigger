package com.udacity.gradle.jokes;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBarActivity;
import android.widget.TextView;

/**
 * Created by venugopalraog on 1/19/17.
 */

public class JokesActivity extends ActionBarActivity {

    public static String JOKES_TEXT_INTENT_EXTRA = "jokesTextIntentExtra";
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jokes);

        TextView jokesTextView = (TextView) findViewById(R.id.jokes_text);
        jokesTextView.setText(getIntent().getStringExtra(JOKES_TEXT_INTENT_EXTRA));
    }
}
