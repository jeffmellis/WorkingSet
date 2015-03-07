package jeffdev.workingset;

import java.util.ArrayList;
import java.util.Locale;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.FragmentPagerAdapter;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;


public class StartWorkout extends ActionBarActivity {

    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * {@link android.support.v4.app.FragmentStatePagerAdapter}.
     */
    SectionsPagerAdapter mSectionsPagerAdapter;

    /**
     * The {@link ViewPager} that will host the section contents.
     */
    ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_workout);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();

        String workoutname = bundle.getString("name");
        ArrayList<exerciseStorage> exercises = (ArrayList<exerciseStorage>) bundle.getSerializable("exercises");
        //int numExercises = exercises.size();

        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager(),exercises);

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.pager);
        mViewPager.setAdapter(mSectionsPagerAdapter);

    }

//    public void repsup(View view){
//        EditText editText = (EditText) findViewById(R.id.reps);
//        if(!editText.getText().toString().equals("")) {
//            Integer upone = Integer.parseInt(editText.getText().toString());
//            if (upone >= 0) {
//                upone += 1;
//                editText.setText(upone.toString());
//            } else {
//                editText.setText("0");
//            }
//        }
//        else{
//            editText.setText("0");
//        }
//    }
//
//    public void repsdown(View view){
//        EditText editText = (EditText) findViewById(R.id.reps);
//        if(!editText.getText().toString().equals("")) {
//            Integer downone = Integer.parseInt(editText.getText().toString());
//            if (downone >= 1) {
//                downone -= 1;
//                editText.setText(downone.toString());
//            } else {
//                editText.setText("0");
//            }
//        }
//        else{
//            editText.setText("0");
//        }
//    }
//
//    public void weightup(View view){
//        EditText editText = (EditText) findViewById(R.id.weight);
//        if(!editText.getText().toString().equals("")) {
//            Integer upone = Integer.parseInt(editText.getText().toString());
//            if (upone >= 0) {
//                upone += 1;
//                editText.setText(upone.toString());
//            } else {
//                editText.setText("0");
//            }
//        }
//        else{
//            editText.setText("0");
//        }
//    }
//
//    public void weightdown(View view){
//        EditText editText = (EditText) findViewById(R.id.weight);
//        if(!editText.getText().toString().equals("")) {
//            Integer downone = Integer.parseInt(editText.getText().toString());
//            if (downone >= 1) {
//                downone -= 1;
//                editText.setText(downone.toString());
//            } else {
//                editText.setText("0");
//            }
//        }
//        else{
//            editText.setText("0");
//        }
//    }
//
//    public void weightdoubleup(View view){
//        EditText editText = (EditText) findViewById(R.id.weight);
//        if(!editText.getText().toString().equals("")) {
//            Integer upone = Integer.parseInt(editText.getText().toString());
//            if (upone >= 0) {
//                upone += 10;
//                editText.setText(upone.toString());
//            } else {
//                editText.setText("0");
//            }
//        }
//        else{
//            editText.setText("0");
//        }
//    }
//
//    public void weightdoubledown(View view){
//        EditText editText = (EditText) findViewById(R.id.weight);
//        if(!editText.getText().toString().equals("")) {
//            Integer downone = Integer.parseInt(editText.getText().toString());
//            if (downone >= 11) {
//                downone -= 10;
//                editText.setText(downone.toString());
//            } else {
//                editText.setText("0");
//            }
//        }
//        else{
//            editText.setText("0");
//        }
//
//    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_start_workout, menu);
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


    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        ArrayList<exerciseStorage> exercises;

        public SectionsPagerAdapter(FragmentManager fm, ArrayList<exerciseStorage> exercises) {
            super(fm);
            this.exercises = exercises;
        }

        @Override
        public Fragment getItem(int position) {
            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).
            return PlaceholderFragment.newInstance(position + 1);
        }

        @Override
        public int getCount() {
            // Show 3 total pages.
            return exercises.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            //Locale l = Locale.getDefault();
            return exercises.get(position).name;
        }
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private static final String ARG_SECTION_NUMBER = "section_number";

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static PlaceholderFragment newInstance(int sectionNumber) {
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            final View rootView = inflater.inflate(R.layout.fragment_start_workout, container, false);
            //need to do this for the remaining 5 other buttons
            ImageButton repsup = (ImageButton) rootView.findViewById(R.id.repsup);
            repsup.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    EditText editText = (EditText) rootView.findViewById(R.id.reps);
                    if(!editText.getText().toString().equals("")) {
                        Integer upone = Integer.parseInt(editText.getText().toString());
                        if (upone >= 0) {
                            upone += 1;
                            editText.setText(upone.toString());
                        } else {
                            editText.setText("0");
                        }
                        }
                        else{
                            editText.setText("0");
                        }
                }
            });
            return rootView;
        }

    }

}
