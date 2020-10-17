package com.technorizen.doctorgo.medicalpsecialities.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.Context;
import android.os.Bundle;

import com.technorizen.doctorgo.R;
import com.technorizen.doctorgo.databinding.ActivityLoadMedicalBinding;
import com.technorizen.doctorgo.medicalpsecialities.fragments.MedicalHomeFragment;

public class LoadMedicalActivity extends AppCompatActivity {

    Context mContext = LoadMedicalActivity.this;
    ActivityLoadMedicalBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_load_medical);

        init();

        FragTras(new MedicalHomeFragment());

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
