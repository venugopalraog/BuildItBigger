package com.udacity.gradle.builditbigger;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;

import com.udacity.gradle.jokes.JokesActivity;


public class MainActivity extends ActionBarActivity {

    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressBar = (ProgressBar) findViewById(R.id.progress_bar);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void tellJoke(View view){
        EndpointsAsyncTask asyncTask = new EndpointsAsyncTask(this);

        asyncTask.setProgressBar(progressBar);
        asyncTask.execute(this);
        asyncTask.setListener(new EndpointsAsyncTask.JokeListener() {
            @Override
            public void onJokeReceived(String jokeString) {
                //Launch JokesActivity
                Intent intent = new Intent(MainActivity.this, JokesActivity.class);
                intent.putExtra(JokesActivity.JOKES_TEXT_INTENT_EXTRA, jokeString);
                startActivity(intent);
            }
        });

/*
        JavaJokes jokes = new JavaJokes();
        Intent intent = new Intent(this, JokesActivity.class);
        intent.putExtra(JokesActivity.JOKES_TEXT_INTENT_EXTRA, jokes.getJokes());
        startActivity(intent);
*/

/*
        JavaJokes jokes = new JavaJokes();
        Toast.makeText(this, "derp " + jokes.getJokes(), Toast.LENGTH_SHORT).show();
*/
    }


}
