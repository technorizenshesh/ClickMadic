package com.technorizen.crysco.profile;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.technorizen.crysco.R;
import com.technorizen.crysco.databinding.FragmentProfileHomeBinding;
import com.technorizen.crysco.profile.editprofile.LoadEditProfileActivity;
import com.utils.Session.SessionKey;
import com.utils.Session.SessionManager;

public class ProfileHomeFragment extends Fragment {
    Context mContext;
    FragmentProfileHomeBinding binding;
    private SessionManager session;

    public ProfileHomeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mContext = getActivity();
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_profile_home, container, false);
        init();
        return binding.getRoot();
    }
    private void init() {
     session= SessionManager.get(getContext());
     binding.name.setText(session.getValue(SessionKey.first_name));
     binding.email.setText(session.getValue(SessionKey.email));
     binding.password.setText(session.getValue(SessionKey.password));
     binding.age.setText(session.getValue(SessionKey.age));
     binding.height.setText(session.getValue(SessionKey.height));
     binding.male.setChecked(session.getValue(SessionKey.gender).equals("Male"));
     binding.female.setChecked(session.getValue(SessionKey.gender).equals("Female"));
     binding.other.setChecked(session.getValue(SessionKey.gender).equals("Other"));
    }

}
