package com.m.taskman;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AllTasksViewActivity extends AppCompatActivity {
    @BindView(R.id.ApiKey) TextView APIKEY;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_tasks_view);

        ButterKnife.bind(this);

        Intent intent = getIntent();
        String api = intent.getStringExtra("APIKEY");
        APIKEY.setText(api);

    }
}
