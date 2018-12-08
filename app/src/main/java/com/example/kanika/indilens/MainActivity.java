package com.example.kanika.indilens;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {


    private SectionsPagerAdapter mSectionsPagerAdapter;

    public ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());


        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);

        tabLayout.getTabAt(0).setIcon(R.drawable.photograph2);
        tabLayout.getTabAt(1).setIcon(R.drawable.icon);
        tabLayout.getTabAt(2).setIcon(R.drawable.home);
        tabLayout.getTabAt(3).setIcon(R.drawable.nav);
        tabLayout.getTabAt(4).setIcon(R.drawable.check);


        mViewPager.setCurrentItem(2);

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

    /**
     * A placeholder fragment containing a simple view.
     */


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

            switch(position){

                case 0:
                    tab_ocr tab1 = new tab_ocr();
                    return tab1;

                case 1:
                    tab_translate tab2 = new tab_translate();
                    return tab2;

                case 2:
                    tab_home tab3 = new tab_home();
                    return tab3;

                case 3:
                    tab_locator tab4 = new tab_locator();
                    return tab4;

                case 4:
                    tab_checklist tab5 = new tab_checklist();
                    return tab5;

                default:
                    return null;

            }

        }

        @Override
        public int getCount() {

            return 5;
        }



        /*@Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "OCR";
                case 1:
                    return "Translator";
                case 2:
                    return "Home";
                case 3:
                    return "Locator";
                case 4:
                    return "Checklist";
            }
            return null;
        }*/


    }
}
