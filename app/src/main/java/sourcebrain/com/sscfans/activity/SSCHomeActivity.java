package sourcebrain.com.sscfans.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.purplebrain.adbuddiz.sdk.AdBuddiz;

import java.util.ArrayList;

import sourcebrain.com.sscfans.R;
import sourcebrain.com.sscfans.model.Fixture;
import sourcebrain.com.sscfans.model.Result;

/**
 * Created by USER on 12/25/2015.
 */
public class SSCHomeActivity extends AppCompatActivity implements FragmentDrawer.FragmentDrawerListener {

    private static String TAG = SSCHomeActivity.class.getSimpleName();

    private Toolbar mToolbar;
    private FragmentDrawer drawerFragment;

    public static ArrayList<Fixture> mArrayFixtures;
    public static ArrayList<Result> mArrayResults;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mToolbar = (Toolbar) findViewById(R.id.toolbar);

        AdBuddiz.setPublisherKey("2c31cbf8-d85c-49ce-9355-558a96ed6ce7"); // See 3.
        AdBuddiz.cacheAds(this); // this = current Activity
        AdBuddiz.showAd(this); // this = current Activity


        mArrayFixtures = new ArrayList<Fixture>();
        mArrayResults = new ArrayList<Result>();

        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        drawerFragment = (FragmentDrawer)
                getSupportFragmentManager().findFragmentById(R.id.fragment_navigation_drawer);
        drawerFragment.setUp(R.id.fragment_navigation_drawer, (DrawerLayout) findViewById(R.id.drawer_layout), mToolbar);
        drawerFragment.setDrawerListener(this);

        // display the first navigation drawer view on app launch
        displayView(0);
    }

    @Override
    public void onDrawerItemSelected(View view, int position) {
        displayView(position);
    }

    private void displayView(int position) {
        Fragment fragment = null;
        String title = getString(R.string.app_name);
        switch (position) {
            case 0:
                fragment = new FixturesFragment();
                title = getString(R.string.title_fixtures);
                break;
           case 1:
                fragment = new ResultsFragment();
                title = getString(R.string.title_results);
                break;

            default:
                break;
        }

        if (fragment != null) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.container_body, fragment);
            fragmentTransaction.commit();

            // set the toolbar title
            getSupportActionBar().setTitle(title);
        }
    }

}