package com.quhaofeng.broadcastbestpractice;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by Quhaofeng on 2016-3-4-0004.
 */
public class LoginActivity extends BaseActivity{

    private SharedPreferences mPreferences;

    private SharedPreferences.Editor mEditor;

    private EditText accountEdit;
    private EditText passwordEdit;
    private Button login;

    private CheckBox remeberPass;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        mPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        accountEdit = (EditText)findViewById(R.id.account);
        passwordEdit = (EditText)findViewById(R.id.password);
        remeberPass = (CheckBox)findViewById(R.id.remember_pass);
        login = (Button)findViewById(R.id.login);
        boolean isRemember = mPreferences.getBoolean("remember_password", false);
        if(isRemember){
            String account = mPreferences.getString("account", "");
            String password = mPreferences.getString("password", "");
            accountEdit.setText(account);
            passwordEdit.setText(password);
            remeberPass.setChecked(true);
        }
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String account = accountEdit.getText().toString();
                String password = passwordEdit.getText().toString();
                if (account.equals("admin") && password.equals("123456")){
                    mEditor = mPreferences.edit();
                    if(remeberPass.isChecked()){
                        mEditor.putBoolean("remember_password", true);
                        mEditor.putString("account", account);
                        mEditor.putString("password", password);
                    }else{
                        mEditor.clear();
                    }
                    mEditor.apply();//可以用apply
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                }else{
                    Toast.makeText(LoginActivity.this, "account or password is invalid", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
