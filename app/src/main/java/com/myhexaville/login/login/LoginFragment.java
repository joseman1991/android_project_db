package com.myhexaville.login.login;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.myhexaville.login.MenuActivity;
import com.myhexaville.login.R;

public class LoginFragment extends Fragment implements OnLoginListener{
    private static final String TAG = "LoginFragment";

    public LoginFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.fragment_login, container, false);
        inflate.findViewById(R.id.forgot_password).setOnClickListener(v ->
                Toast.makeText(getContext(), "Forgot password clicked", Toast.LENGTH_SHORT).show());
        return inflate;
    }

    @Override
    public void login() {
        try {
            Intent i = new Intent(getActivity(), MenuActivity.class);
            startActivity(i);
            //Toast.makeText(getContext(), "Login", Toast.LENGTH_SHORT).show();
        }catch (Exception ex){
            Toast.makeText(getContext(),ex.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }
}
