package com.example.thirdassignment;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginFragment extends Fragment {
    private EditText loginemail;
    private EditText loginpassword;
    private Button btnlogin;
    private String un, pw;

    SharedPreferences preferences;
    SharedPreferences.Editor editor;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_login, container, false);

        loginemail = view.findViewById(R.id.loginemail);
        loginpassword = view.findViewById(R.id.loginpassword);
        btnlogin = view.findViewById(R.id.btnlogin);
        //add if remember me is checked or not..if checked do direct login...else need to login
        preferences = getContext().getSharedPreferences("APP_PREF", Context.MODE_PRIVATE);
        editor = preferences.edit();


        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                un = preferences.getString("EMAIL", "");
                pw = preferences.getString("PASSWORD", "");


                if (TextUtils.isEmpty(loginemail.getText().toString())) {
                    Toast.makeText(getActivity(), "Email cannot be empty", Toast.LENGTH_SHORT).show();
                    loginemail.setText("");
                    loginpassword.setText("");
                } else if (TextUtils.isEmpty(loginpassword.getText().toString())) {
                    Toast.makeText(getActivity(), "Password cannot be empty", Toast.LENGTH_SHORT).show();
                    loginpassword.setText("");
                } else {

                    if (un.equals(loginemail.getText().toString())
                            && pw.equals(loginpassword.getText().toString())) {
                        Toast.makeText(getActivity(), "Login Successful", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getActivity(), Items.class);
                        startActivity(intent);
                    } else {
                        Toast.makeText(getActivity(), "Authentication Error", Toast.LENGTH_SHORT).show();
                        loginemail.setText("");
                        loginpassword.setText("");
                    }


                }

            }
        });


        return view;
    }
}
