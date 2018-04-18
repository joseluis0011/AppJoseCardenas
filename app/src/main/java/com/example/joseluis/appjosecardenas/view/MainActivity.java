package com.example.joseluis.appjosecardenas.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.joseluis.appjosecardenas.Activity_home;
import com.example.joseluis.appjosecardenas.R;
import com.example.joseluis.appjosecardenas.interfaces.LoginInterface;
import com.example.joseluis.appjosecardenas.model.LoginPresenterImpl;
import com.example.joseluis.appjosecardenas.presenter.LoginPresenter;

public class MainActivity extends AppCompatActivity implements View.OnClickListener,LoginInterface {
    EditText EDusuario;
    EditText EDpassword;
    private ProgressBar progressBar;
    LoginPresenter nLoginPresenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EDusuario=(EditText)findViewById(R.id.ETusuario);
        EDpassword=(EditText)findViewById(R.id.ETpassword);
        progressBar = (ProgressBar) findViewById(R.id.progress);
        findViewById(R.id.btnEntrar).setOnClickListener(this);
        nLoginPresenter=new LoginPresenterImpl(MainActivity.this);

    }


    @Override
    public void onClick(View v) {
        String user =EDusuario.getText().toString();
        String password=EDpassword.getText().toString();
        nLoginPresenter.performLogin(user,password);

    }

    @Override
    public void loginValidation() {
        Toast.makeText(getApplicationContext(),"Ingrese su usuario y su contraseña",Toast.LENGTH_LONG).show();
    }

    @Override
    public void loginSuccess() {
        startActivity(new Intent(this, Activity_home.class));
        finish();
    }

    @Override
    public void loginError() {
        Toast.makeText(getApplicationContext(),"Error",Toast.LENGTH_LONG).show();
    }


    @Override
    public void showProgress() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        progressBar.setVisibility(View.GONE);
    }
}
