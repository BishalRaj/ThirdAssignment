package com.example.thirdassignment;


import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;

public class RegisterFragment extends Fragment {

    private EditText firstname,lastname,email,password;
    private Button btnregister;
    private String fn,ln,em,pwd;
    SharedPreferences preferences;
    SharedPreferences.Editor editor;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_register, container, false);

        firstname=view.findViewById(R.id.firstname);
        lastname=view.findViewById(R.id.lastname);
        email=view.findViewById(R.id.password);
        password=view.findViewById(R.id.email);
        btnregister=view.findViewById(R.id.btnregister);

        preferences=this.getActivity().getSharedPreferences("APP_PRED", Context.MODE_PRIVATE);
        editor=preferences.edit();


        btnregister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fn=firstname.getText().toString();
                ln=lastname.getText().toString();
                em=email.getText().toString();
                pwd=password.getText().toString();

                if (fn.isEmpty()){
                    Toast.makeText(getActivity(), "First Name cannot be empty", Toast.LENGTH_SHORT).show();
                }else if (ln.isEmpty()){
                    Toast.makeText(getActivity(), "Last Name cannot be empty", Toast.LENGTH_SHORT).show();
                }else if (em.isEmpty()){
                    Toast.makeText(getActivity(), "Email cannot be empty", Toast.LENGTH_SHORT).show();
                }else if (pwd.isEmpty()){
                    Toast.makeText(getActivity(), "Password cannot be empty", Toast.LENGTH_SHORT).show();
                }else{
                    editor.putString("firstName",fn);
                    editor.putString("lastName",ln);
                    editor.putString("email",em);
                    editor.putString("password",pwd);
                    editor.commit();

//                    Toast.makeText(getActivity(), preferences.getString("email",""), Toast.LENGTH_SHORT).show();
                    Toast.makeText(getActivity(), "You are successfully registered.", Toast.LENGTH_SHORT).show();
                }


            }
        });



        return view;
    }

}
