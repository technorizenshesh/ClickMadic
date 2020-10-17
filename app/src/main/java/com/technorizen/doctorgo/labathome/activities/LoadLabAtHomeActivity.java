package com.technorizen.doctorgo.labathome.activities;

import android.content.Context;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.technorizen.doctorgo.R;
import com.technorizen.doctorgo.databinding.ActivityLoadLabAtHomeBinding;
import com.technorizen.doctorgo.labathome.fragments.AddLabTimeSlotFragment;
import com.technorizen.doctorgo.labathome.fragments.LabDetailFragment;
import com.technorizen.doctorgo.labathome.fragments.LabHomeFragment;

public class LoadLabAtHomeActivity extends AppCompatActivity {

    Context mContext = LoadLabAtHomeActivity.this;
    ActivityLoadLabAtHomeBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_load_lab_at_home);

        init();

        if("profile".equals(getIntent().getStringExtra("profile"))) {
            FragTras(new LabDetailFragment());
        } else if("time".equals(getIntent().getStringExtra("time"))) {
            FragTras(new AddLabTimeSlotFragment());
        } else {
            FragTras(new LabHomeFragment());
        }

    }

    private void init() {

    }

    public void FragTras(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frameLayout, fragment);
        transaction.addToBackStack("fragment");
        transaction.commit();
    }


    @Override
    public void onBackPressed() {
        if (getSupportFragmentManager().getBackStackEntryCount()>1){
            getSupportFragmentManager().popBackStack();
        } else {
            finish();
        }
    }


}
