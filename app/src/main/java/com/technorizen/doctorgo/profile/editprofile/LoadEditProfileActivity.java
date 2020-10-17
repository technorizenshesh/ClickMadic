package com.technorizen.doctorgo.profile.editprofile;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Context;
import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;
import com.technorizen.doctorgo.R;
import com.technorizen.doctorgo.databinding.ActivityLoadEditProfileBinding;
import com.technorizen.doctorgo.profile.editprofile.tabfragments.LifeStyleFragment;
import com.technorizen.doctorgo.profile.editprofile.tabfragments.MedicalEditFragment;
import com.technorizen.doctorgo.profile.editprofile.tabfragments.PersonalDetailFragment;

public class LoadEditProfileActivity extends AppCompatActivity {

    Context mContext = LoadEditProfileActivity.this;
    ActivityLoadEditProfileBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_load_edit_profile);

        init();

    }

    private void init() {

        TabLayout.Tab personalTab = binding.tabLayout.newTab();
        personalTab.setText("Personal");
        binding.tabLayout.addTab(personalTab);

        TabLayout.Tab medicaltab = binding.tabLayout.newTab();
        medicaltab.setText("Medical");
        binding.tabLayout.addTab(medicaltab);

        TabLayout.Tab lifestyle = binding.tabLayout.newTab();
        lifestyle.setText("Lifestyle");
        binding.tabLayout.addTab(lifestyle);

        getSupportFragmentManager().beginTransaction().replace(R.id.frameContainer,new PersonalDetailFragment()).commit();

        binding.tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                switch (tab.getPosition()) {
                    case 0:
                        getSupportFragmentManager().beginTransaction().replace(R.id.frameContainer,new PersonalDetailFragment()).commit();
                        break;

                    case 1:
                        getSupportFragmentManager().beginTransaction().replace(R.id.frameContainer,new MedicalEditFragment()).commit();
                        break;

                    case 2:
                        getSupportFragmentManager().beginTransaction().replace(R.id.frameContainer,new LifeStyleFragment()).commit();
                        break;
                }

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });


    }

}
