package sourcebrain.com.sscfans.activity;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.AsyncTask;
import android.os.Bundle;

import sourcebrain.com.sscfans.R;
import sourcebrain.com.sscfans.activity.SSCHomeActivity;


public class SplashActivity extends Activity {

    private static final int SPLASH_SHOW_TIME = 3000;
    /* This is to test GIT */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_screen);

        new BackgroundSplashTask().execute();

    }

    /**
     * Async Task: can be used to load DB, images during which the splash screen
     * is shown to user
     */
    private class BackgroundSplashTask extends AsyncTask<Void, Void, Void> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected void onPostExecute(Void result) {
            super.onPostExecute(result);
            Intent i = new Intent(SplashActivity.this, SSCHomeActivity.class);

            startActivity(i);
            finish();
        }

        @Override
        protected Void doInBackground(Void... params) {

            try {
                Thread.sleep(SPLASH_SHOW_TIME);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            return null;
        }

    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        //reload your ScrollBars by checking the newConfig
    }

}