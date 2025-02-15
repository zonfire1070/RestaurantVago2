package com.example.restaurantvago;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity  {




    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * {@link android.support.v4.app.FragmentStatePagerAdapter}.
     */
    private SectionsPagerAdapter mSectionsPagerAdapter;

    /**
     * The {@link ViewPager} that will host the section contents.
     */
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);

        mViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.addOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(mViewPager));
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main2, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        switch(id) {
            case R.id.action_map: {
                //https://developers.google.com/maps/documentation/urls/android-intents
                Uri mapsIntentUri = Uri.parse("geo:43.0751,-87.8811?z=16");
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, mapsIntentUri);
                mapIntent.setPackage("com.google.android.apps.maps");
                startActivity(mapIntent);

                Toast toast = Toast.makeText(getApplicationContext(), "Showing Google Maps view of Restaurant Vago" , Toast.LENGTH_LONG);
                toast.show();
                return true;
            }
            case R.id.action_about_us: {
                Intent intent = new Intent(this, AboutUsActivity.class);
                startActivity(intent);
                return true;
            }
            default:
                return super.onOptionsItemSelected(item);
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

        public PlaceholderFragment() {
        }

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

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {

         if (getArguments().getInt(ARG_SECTION_NUMBER) == 1)
         {
             View rootView = inflater.inflate(R.layout.fragment_blank_fragment_tab1, container, false);

             Button rBtn = rootView.findViewById(R.id.rBtn);
             rBtn.setOnClickListener(new View.OnClickListener(){
                 @Override
                 public void onClick(View view){

                 }

             });

             return rootView;
         }
         else if (getArguments().getInt(ARG_SECTION_NUMBER) == 2)
         {
             View rootView = inflater.inflate(R.layout.fragment_blank_fragment_tab2, container, false);

             ImageButton aBtn = rootView.findViewById(R.id.aBtn);
             aBtn.setOnClickListener(new View.OnClickListener(){
                 @Override
                 public void onClick(View view){
                     Intent j = new Intent(getActivity(), aptzrMenu.class);
                     startActivity(j);
                 }
             });

             ImageButton bBtn = rootView.findViewById(R.id.bBtn);
             bBtn.setOnClickListener(new View.OnClickListener(){
                 @Override
                 public void onClick(View view){
                     Intent i = new Intent(getActivity(), burgerMenu.class);
                     startActivity(i);
                 }
             });
             return rootView;


         } else if (getArguments().getInt(ARG_SECTION_NUMBER) == 3) {
             View rootView = inflater.inflate(R.layout.fragment_blank_fragment_tab3, container, false);

             Button button1 = rootView.findViewById(R.id.button1);
             button1.setOnClickListener(new View.OnClickListener(){
                 @Override
                 public void onClick(View view){
                     Intent j = new Intent(getActivity(), thankYou.class);
                     startActivity(j);
                 }
             });

             return rootView;
         } else {
             View rootView = inflater.inflate(R.layout.fragment_main2, container, false);
             TextView textView = (TextView) rootView.findViewById(R.id.main_content);
             textView.setText(getString(R.string.section_format, getArguments().getInt(ARG_SECTION_NUMBER)));
             return rootView;
         }




        }
    }

    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
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
            return 3;
        }
    }
}


