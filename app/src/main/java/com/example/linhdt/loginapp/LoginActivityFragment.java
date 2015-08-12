package com.example.linhdt.loginapp;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * A placeholder fragment containing a simple view.
 */
public class LoginActivityFragment extends Fragment {
    public static final  String USERNAME= "helix";
    public static final String PASSWORD= "cakiem";
    private EditText etUsername;
    private EditText etPassword;
    private Button btnLogin;

    public LoginActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View fragmentView=  inflater.inflate(R.layout.fragment_login, container, false);

        initUI(fragmentView);
        return fragmentView;
    }
    private void initUI(View parent){
        etUsername = (EditText) parent.findViewById(R.id.etUsername);
        etPassword= (EditText) parent.findViewById(R.id.etPassword);
        btnLogin= (Button) parent.findViewById(R.id.btnLogin);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = etUsername.getText().toString();
                String password = etPassword.getText().toString();
                validateCredentials(username,password);
            }
        });
    }
    private void validateCredentials(String username, String password){

        if ( username.equals(USERNAME) && password.equals(PASSWORD)){
            showToastMessage("login sucessfully");
            Intent intent = new Intent(getActivity(),MainActivity.class);
            startActivity(intent);
            getActivity().finish();
        }
        else
            showToastMessage("wrong name or password");
    }
    private void showToastMessage (String msg){
        Toast.makeText(getView().getContext(),msg,Toast.LENGTH_SHORT).show();

    }
}
