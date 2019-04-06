package com.gyk.bursa162;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.gyk.bursa162.models.malzemeler.LoginModel;

import java.util.ArrayList;
import java.util.List;

public class LoginActivity extends Activity {

    private LoginModel mLoginModel;

    private List<LoginModel> mUserList = new ArrayList<>();

    private EditText mEdtUserName;
    private EditText mEdtPassword;
    private TextView mTvError;

    private String mError;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        LoginModel mLoginModel1 = new LoginModel(
                "ugur@gyk.com",
                "12345",
                "Uğur Yaşar Kazdal",
                "Rize",
                "www.uguryasarkazdal.com",
                "Bottom navigation bars make it easy for users to explore and switch between top-level views in a single tap. It should be used when application has three to five top-level destinations.\n" +
                        "\n" +
                        "The bar contents can be populated by specifying a menu resource file. Each menu item title, icon and enabled state will be used for displaying bottom navigation bar items. Menu items can also be used for programmatically selecting which destination is currently active. It can be done using MenuItem#setChecked(true)");

        LoginModel mLoginModel2 = new LoginModel(
                "ayse@gyk.com",
                "123456",
                "Ayşe Bursalı",
                "Bursa",
                "www.ayse.com",
                "Bottom navigation bars make it easy for users to explore and switch between top-level views in a single tap. It should be used when application has three to five top-level destinations.\n");

        //üstte olusturulan iki adet kullanıcıyı listeye alıyoruz
        mUserList.add(mLoginModel1);
        mUserList.add(mLoginModel2);

        mEdtPassword = findViewById(R.id.edt_login_pass);
        mEdtUserName = findViewById(R.id.edt_login_user);
        mTvError = findViewById(R.id.tv_login_hata);

        findViewById(R.id.btn_login_giris).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkLoginData()) {
                    Intent intent = new Intent(LoginActivity.this, ProfileActivity.class);
                    intent.putExtra("isim", mLoginModel.getFullName());
                    intent.putExtra("city", mLoginModel.getCity());
                    intent.putExtra("web", mLoginModel.getWeb());
                    intent.putExtra("cv", mLoginModel.getCv());
                    startActivity(intent);
                } else {
                    mTvError.setText(mError);
                }
            }
        });

    }

    // kullanıcı adında @ karakterini arıcaz
    // şifre'nin 4 karakterden uzun olmasını isticez
    private boolean checkLoginData() { // true yada false
        String userName = mEdtUserName.getText().toString().trim();
        String password = mEdtPassword.getText().toString().trim();

        if (userName.equals("")) {
            mError = "Kullanıcı adı boş";
            return false;
        }

        if (password.equals("")) {
            mError = "Parola boş.";
            return false;
        }

        if (!userName.contains("@")) {
            mError = "Kullanıcı adı geçersiz.";
            return false;
        }

        if (password.length() < 5) {
            mError = "Şifrenizi geçersiz.";
            return false;
        }

        boolean checkUserName = false;
        boolean checkPass = false;

        for (LoginModel item : mUserList) {
            if (!checkUserName && !checkPass) {
                checkUserName = userName.equals(item.getUserName());
                checkPass = password.equals(item.getPassword());
                mLoginModel = item;
            }
        }

/*        if (!checkUserName) {
            mError = "Kullanıcı adı yanlış.";
        } else {
            if (!checkPass) {
                mError = "Parola yanlış.";
            } else {
                mError = "";
            }
        }*/

        mError = !checkUserName ? "Kullanıcı adı yanlış" : !checkPass ? "Parola Yanlış" : "";

        return checkUserName && checkPass;
    }
}
