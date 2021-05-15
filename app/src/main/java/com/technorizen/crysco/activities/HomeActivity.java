package com.technorizen.crysco.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.squareup.picasso.Picasso;
import com.technorizen.crysco.R;
import com.technorizen.crysco.databinding.ActivityHomeBinding;
import com.technorizen.crysco.fragments.FragmentFavorite;
import com.technorizen.crysco.fragments.FragmentHistory;
import com.technorizen.crysco.fragments.HomeFragment;
import com.technorizen.crysco.profile.ProfileHomeFragment;
import com.utils.Session.SessionKey;
import com.utils.Session.SessionManager;

public class HomeActivity extends AppCompatActivity {
    Context mContext = HomeActivity.this;
    ActivityHomeBinding binding;
    private SessionManager session;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_home);
        init();
    }

    private void init() {
        session = SessionManager.get(this);
        binding.navView.setOnNavigationItemSelectedListener(this::onNavigationItemSelected);
        binding.navView.setSelectedItemId(R.id.nav_home);
        binding.tvUserName.setText(session.getValue(SessionKey.first_name));
        if (session.getValue(SessionKey.image).length()>3){
            Picasso.get().load(session.getValue(SessionKey.image)).placeholder(R.drawable.profile).into(binding.ivProfile);
        }
    }

    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case R.id.nav_home:
                loadFrag(new HomeFragment());
               return true;
            case R.id.nav_history:
                loadFrag(new FragmentHistory());
                return true;
            case R.id.nav_fav:
                loadFrag(new FragmentFavorite());
                return true;
            case R.id.nav_profile:
                loadFrag(new ProfileHomeFragment());
                return true;
        }

        return true;

    }

    public void loadFrag(Fragment fragment) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.content_frame, fragment);
        fragmentTransaction.addToBackStack("fragment");
        fragmentTransaction.commit();
    }

    @Override
    public void onBackPressed() {
        if (getSupportFragmentManager().getBackStackEntryCount() > 1) {
            getSupportFragmentManager().popBackStack();
        } else {
            exitAppDialog();
        }

    }

    private void exitAppDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(mContext);
        builder.setMessage("Are you sure you want to exit?")
                .setCancelable(false)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = new Intent(Intent.ACTION_MAIN);
                        intent.addCategory(Intent.CATEGORY_HOME);
                        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        startActivity(intent);
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }

}
