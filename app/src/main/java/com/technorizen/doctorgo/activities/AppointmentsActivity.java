package com.technorizen.doctorgo.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Context;
import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;
import com.technorizen.doctorgo.R;
import com.technorizen.doctorgo.fragments.BookedAppointmentFragment;
import com.technorizen.doctorgo.fragments.NewAppointmentFragment;
import com.technorizen.doctorgo.databinding.ActivityAppointmentsBinding;

public class AppointmentsActivity extends AppCompatActivity {

    Context mContext = AppointmentsActivity.this;
    ActivityAppointmentsBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_appointments);

        init();

    }

    private void init() {

        binding.ivBack.setOnClickListener(v -> {
           finish();
        });

        getSupportFragmentManager().beginTransaction().replace(R.id.frame_container,new NewAppointmentFragment()).commit();

        TabLayout.Tab newAppoint = binding.tabLayout.newTab();
        newAppoint.setText("New Appointment");
        binding.tabLayout.addTab(newAppoint);

        TabLayout.Tab bookedAppoint = binding.tabLayout.newTab();
        bookedAppoint.setText("Appointments Made");
        binding.tabLayout.addTab(bookedAppoint);

        binding.tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                switch (tab.getPosition()) {

                    case 0:
                        getSupportFragmentManager().beginTransaction().replace(R.id.frame_container,new NewAppointmentFragment()).commit();
                        break;

                    case 1:
                        getSupportFragmentManager().beginTransaction().replace(R.id.frame_container,new BookedAppointmentFragment()).commit();
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
