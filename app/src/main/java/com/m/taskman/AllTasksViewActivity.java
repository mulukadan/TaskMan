package com.m.taskman;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;
import android.widget.Toast;

import com.m.taskman.Adapters.TaskDisplayAdapter;
import com.m.taskman.models.com.m.models.DorisService;
import com.m.taskman.models.com.m.models.Group;
import com.m.taskman.models.com.m.models.Todo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.HttpUrl;
import okhttp3.Response;

public class AllTasksViewActivity extends AppCompatActivity {
    @BindView(R.id.recyclerView)  RecyclerView mRecyclerView;
    private TaskDisplayAdapter mAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_tasks_view);

        ButterKnife.bind(this);

        Intent intent = getIntent();
        String api = intent.getStringExtra("APIKEY");

        getTasks(api);

    }

    public void getTasks(String apiKey){
        HttpUrl.Builder urlBuilder = HttpUrl.parse(Constants.VIEW_ALL_URL).newBuilder();
        urlBuilder.addQueryParameter("apikey", apiKey);
        String url = urlBuilder.build().toString();

        final DorisService dorisService = new DorisService();

        dorisService.getConnection(url, new Callback() {

            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(Call call, Response response) {
                final List<Group> AllGroups = dorisService.getAllTasks(response);

                AllTasksViewActivity.this.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        if (AllGroups != null) {
//                            Toast.makeText(getApplicationContext(), "Tasks: " +AllTasks.size(),
//                                    Toast.LENGTH_LONG).show();
                            mAdapter = new TaskDisplayAdapter(getApplicationContext(), (ArrayList<Group>) AllGroups);
                            mRecyclerView.setAdapter(mAdapter);
                            RecyclerView.LayoutManager layoutManager =
                                    new LinearLayoutManager(AllTasksViewActivity.this);
                            mRecyclerView.setLayoutManager(layoutManager);
                            mRecyclerView.setHasFixedSize(true);

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
}
