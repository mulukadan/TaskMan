package com.m.taskman;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    @BindView(R.id.findRestaurantsButton)
    Button mLoginButton;
    EditText mLocationEditText;
    @BindView(R.id.appNameTextView)
    TextView mAppNameTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        Typeface ostrichFont = Typeface.createFromAsset(getAssets(), "fonts/Capture_it_2.ttf");
        mAppNameTextView.setTypeface(ostrichFont);
        mLoginButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v == mLoginButton) {

            Intent intent = new Intent(MainActivity.this, LoginActivity.class);

            startActivity(intent);
        }
    }
}
