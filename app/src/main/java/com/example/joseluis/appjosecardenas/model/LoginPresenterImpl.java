package com.example.joseluis.appjosecardenas.model;

import android.text.TextUtils;

import com.example.joseluis.appjosecardenas.interfaces.LoginInterface;
import com.example.joseluis.appjosecardenas.presenter.LoginPresenter;

public class LoginPresenterImpl implements LoginPresenter{
    LoginInterface nLoginInterface;
    public LoginPresenterImpl(LoginInterface LoginInterface ){
        this.nLoginInterface= LoginInterface;
    }
    @Override
    public void performLogin(String user, String password) {
        if (nLoginInterface != null) {
            nLoginInterface.hideProgress();
        }
        if (TextUtils.isEmpty(user) || TextUtils.isEmpty(password))
        {
            nLoginInterface.loginValidation();
        }
        else{
            if(user.equals("jose") && password.equals("123"))
            {
                nLoginInterface.loginSuccess();
                nLoginInterface.showProgress();
            }else{
                nLoginInterface.loginError();
                nLoginInterface.hideProgress();
            }
        }

    }
}
