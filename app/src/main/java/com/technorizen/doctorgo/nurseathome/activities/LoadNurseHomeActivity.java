package com.technorizen.doctorgo.nurseathome.activities;

import android.content.Context;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.technorizen.doctorgo.R;
import com.technorizen.doctorgo.databinding.ActivityLoadNurseHomeBinding;
import com.technorizen.doctorgo.nurseathome.fragments.NurseHomeFragment;

public class LoadNurseHomeActivity extends AppCompatActivity {

    Context mContext = LoadNurseHomeActivity.this;
    ActivityLoadNurseHomeBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_load_nurse_home);

        init();

    }

    private void init()
    {
        loadFragment(new NurseHomeFragment());
    }

    public void loadFragment(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frameContainer, fragment);
        transaction.addToBackStack("fragment");
        transaction.commit();
    }

    @Override
    public void onBackPressed() {

        if(getSupportFragmentManager().getBackStackEntryCount() > 1) {
            getSupportFragmentManager().popBackStack();
        } else {
            finish();
        }

    }


}
