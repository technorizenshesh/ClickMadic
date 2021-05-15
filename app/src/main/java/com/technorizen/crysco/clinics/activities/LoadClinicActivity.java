package com.technorizen.crysco.clinics.activities;

import android.content.Context;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.technorizen.crysco.R;
import com.technorizen.crysco.clinics.fragments.ClinicProfileFragment;
import com.technorizen.crysco.clinics.fragments.MoreClinicsFragment;

public class LoadClinicActivity extends AppCompatActivity {

    Context mContext = LoadClinicActivity.this;
    String whichpage = "abc";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_load_clinic);

        whichpage = getIntent().getStringExtra("which_type");

        if(getIntent().getExtras() != null) {
            if(whichpage.equalsIgnoreCase("clinicprofile")){
                FragTras(new ClinicProfileFragment());
            } else {
                FragTras(new MoreClinicsFragment());
            }
        } else {
            FragTras(new MoreClinicsFragment());
        }

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
