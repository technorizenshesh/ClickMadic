package com.technorizen.doctorgo.medicalpsecialities.fragments;


import android.content.Context;
import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.technorizen.doctorgo.R;
import com.technorizen.doctorgo.databinding.FragmentMedicalDoctorProfileBinding;

/**
 * A simple {@link Fragment} subclass.
 */
public class MedicalDoctorProfileFragment extends Fragment {

    Context mContext;
    FragmentMedicalDoctorProfileBinding binding;
    FragmentPagerAdapter fragmentPagerAdapter;

    public MedicalDoctorProfileFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        mContext = getActivity();
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_medical_doctor_profile, container, false);

        init();

        // Inflate the layout for this fragment
        return binding.getRoot();

    }

    private void init() {

        fragmentPagerAdapter = new MyPagerAdapter(getChildFragmentManager());
        binding.viewPager.setAdapter(fragmentPagerAdapter);

        binding.viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if(position == 0) {
                    binding.leftView.setBackgroundResource(R.drawable.black_round_back);
                    binding.rightView.setBackgroundResource(R.drawable.semi_black_back);
                } else {
                    binding.rightView.setBackgroundResource(R.drawable.black_round_back);
                    binding.leftView.setBackgroundResource(R.drawable.semi_black_back);
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        binding.ivBack.setOnClickListener(v -> {
            getFragmentManager().popBackStack();
        });

        binding.btBook.setOnClickListener(v -> {

        });

    }

    public static class MyPagerAdapter extends FragmentPagerAdapter {

        private static int NUM_ITEMS = 2;

        public MyPagerAdapter(FragmentManager fragmentManager) {
            super(fragmentManager);
        }

        // Returns total number of pages.
        @Override
        public int getCount() {
            return NUM_ITEMS;
        }

        // Returns the fragment to display for a particular page.
        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    return new profile_part2_fragment();
                case 1:
                    return new profile_part1_fragment();
                default:
                    return null;
            }
        }

        // Returns the page title for the top indicator
        @Override
        public CharSequence getPageTitle(int position) {
            return "Tab " + position;
        }

    }


}
