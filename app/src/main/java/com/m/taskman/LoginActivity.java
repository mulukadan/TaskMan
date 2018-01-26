package com.m.taskman;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.m.taskman.models.com.m.models.DorisService;

import java.io.IOException;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

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
//            String url = "http://"+user+":"+Pw+"@beta.dorisapp.com/api/1_0/auth/get_key.json";
            //getting the API KEY
            final DorisService dorisService = new DorisService();

            dorisService.authenticateUser(user, Pw, new Callback() {

                @Override
                public void onFailure(Call call, IOException e) {
                    e.printStackTrace();
                }

                @Override
                public void onResponse(Call call, Response response) {
                    final String APIKey = dorisService.getAPIKey(response);

                    LoginActivity.this.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            if (APIKey != null) {
                                Intent intent = new Intent(LoginActivity.this, AllTasksViewActivity.class);
                                intent.putExtra("APIKEY", APIKey);
                                startActivity(intent);
                            }else {
                                //display in long period of time
                                Toast.makeText(getApplicationContext(), "Wrong UserName or Password",
                                        Toast.LENGTH_LONG).show();
                            }
                        }
                    });
                }
            });


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
