package com.m.taskman;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    @BindView(R.id.username) EditText username;
    @BindView(R.id.password) EditText password;
    @BindView(R.id.button)   Button LoginBtn;
    @BindView(R.id.forgotpassword) TextView forgotPswd;
    @BindView(R.id.createAccount) TextView createAcc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        ButterKnife.bind(this);

        LoginBtn.setOnClickListener(this);
        forgotPswd.setOnClickListener(this);
        createAcc.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v == LoginBtn) {
            String user = username.getText().toString();
            String Pw = password.getText().toString();

            Intent intent = new Intent(LoginActivity.this, AllTasksViewActivity.class);
//            intent.putExtra("location", location);
            startActivity(intent);
        }
        else if(v == forgotPswd) {
            String ForgotPassURL = "http://beta.dorisapp.com/en/user/password/";

            Intent webIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(ForgotPassURL));
            startActivity(webIntent);

        } else if(v == createAcc) {
            String CreateAccURL = "http://beta.dorisapp.com/en/user/register/";

            Intent webIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(CreateAccURL));
            startActivity(webIntent);
        }
    }
}
