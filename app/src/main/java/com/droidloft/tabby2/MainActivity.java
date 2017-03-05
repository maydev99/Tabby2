package com.droidloft.tabby2;

import android.media.Image;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private SectionPagerAdapter mSectionPagerAdapter;
    private ViewPager mViewPager;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        mSectionPagerAdapter = new SectionPagerAdapter(getSupportFragmentManager());

        mViewPager = (ViewPager)findViewById(R.id.container);
        mViewPager.setAdapter(mSectionPagerAdapter);


    }

    public static class PlaceHolderFragment extends Fragment {
        private static final String ARG_SECTION_NUMBER = "section number";

        public  PlaceHolderFragment() {

        }


        public static PlaceHolderFragment newInstance(int sectionNumber){
            PlaceHolderFragment fragment = new PlaceHolderFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }

        @Nullable
        @Override
        public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

            View rootView = null;

            switch (getArguments().getInt(ARG_SECTION_NUMBER)) {
                case 1: {
                    rootView = inflater.inflate(R.layout.fragment_main, container, false);
                    break;
                }

                case 2: {
                    rootView = inflater.inflate(R.layout.fragment2, container, false);
                    break;

                }

                case 3: {
                    rootView = inflater.inflate(R.layout.fragment3, container, false);
                    break;
                }

                case  4: {
                    rootView = inflater.inflate(R.layout.fragment4, container, false);
                    break;
                }
            }

            int[] pics= {R.drawable.mike, R.drawable.cate, R.drawable.steve, R.drawable.gwen};
            TextView textView = (TextView) rootView.findViewById(R.id.section_number);
            ImageView imageView = (ImageView)rootView.findViewById(R.id.imageView);
            imageView.setImageResource(pics[getArguments().getInt(ARG_SECTION_NUMBER)-1]);
            textView.setText("" + getArguments().getInt(ARG_SECTION_NUMBER));
            return rootView;
        }

    }


    public class SectionPagerAdapter extends FragmentPagerAdapter {

        public SectionPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return PlaceHolderFragment.newInstance(position + 1);
        }

        @Override
        public int getCount() {
            return 4;
        }

        public  CharSequence getPageTitle(int position){
            switch (position){
                case 0:
                    return "SECTION 1";
                case  1:
                    return "SECTION 2";
                case  2:
                    return "SECTION 3";
                case  3:
                    return "SECTION 4";
            }

            return null;
        }
    }
}
