package com.technorizen.doctorgo.insurance.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.Context;
import android.os.Bundle;

import com.technorizen.doctorgo.R;
import com.technorizen.doctorgo.databinding.ActivityLoadInsuranceBinding;
import com.technorizen.doctorgo.insurance.fragments.InusranceHomeFragment;

public class LoadInsuranceActivity extends AppCompatActivity {

    Context mContext = LoadInsuranceActivity.this;
    ActivityLoadInsuranceBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_load_insurance);

        init();

        FragTras(new InusranceHomeFragment());

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
