package com.example.kanika.indilens;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;




public class tab_home extends Fragment {


    private Items[] items = {
            new Items("Image Translator", R.drawable.ocr_small),
            new Items("Text Translator", R.drawable.translator_small),
            new Items("Navigator", R.drawable.locator_small),
            new Items("To-Do List", R.drawable.check1small),

    };

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.tab_home, container, false);

        GridView gridView = (GridView) rootView.findViewById(R.id.gridView);

        ImageAdapter imageAdapter = new ImageAdapter(getActivity(),items);


        gridView.setAdapter(imageAdapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                ViewPager mViewPager = (ViewPager) getActivity().findViewById(R.id.container);
                TabLayout tabs = (TabLayout) getActivity().findViewById(R.id.tabs);

                if (position == 0) {
                    Log.d("onItemClick", String.valueOf(position));
                    mViewPager.setCurrentItem(0);

                } else if (position == 1) {
                    Log.d("onItemClick", String.valueOf(position));
                    mViewPager.setCurrentItem(1);
                } else if (position == 2) {
                    Log.d("onItemClick", String.valueOf(position));

                    mViewPager.setCurrentItem(3);
                } else {
                    Log.d("onItemClick", String.valueOf(position));
                    mViewPager.setCurrentItem(4);
                }

            }

        });



        return rootView;
    }

}

