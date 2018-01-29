package com.m.taskman.Adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.m.taskman.R;
import com.m.taskman.models.com.m.models.Todo;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by kadan on 1/27/18.
 */

public class TaskListAdapter extends RecyclerView.Adapter<TaskListAdapter.TaskViewHolder> {
    private List<Todo> mTasks = new ArrayList<>();
    private Context mContext;

    public TaskListAdapter(Context context, List<Todo> tasks) {
        mContext = context;
        mTasks = tasks;
    }

    @Override
    public void onBindViewHolder(TaskViewHolder holder, int position) {
        holder.bindRestaurant(mTasks.get(position));
    }

    @Override
    public TaskViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.tasklistitem, parent, false);
        TaskViewHolder viewHolder = new TaskViewHolder(view);
        return viewHolder;
    }

    @Override
    public int getItemCount() {
        return mTasks.size();
    }

    public class TaskViewHolder extends RecyclerView.ViewHolder
            implements View.OnClickListener {

        @BindView(R.id.task)
        TextView mtask;
        @BindView(R.id.desc)
        TextView mDesc;
        @BindView(R.id.date)
        TextView mDate;


        private Context mContext;

        public TaskViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            mContext = itemView.getContext();
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
//            int itemPosition = getLayoutPosition();
//            Intent intent = new Intent(mContext, RestaurantDetailActivity.class);
//            intent.putExtra("position", itemPosition);
//            intent.putExtra("restaurants", Parcels.wrap(mTasks));
//            mContext.startActivity(intent);
        }

        public void bindRestaurant(Todo task) {
            String taska = task.getDescription();
            String note = task.getNote();

            mtask.setText(task.getDescription());
            mDesc.setText(task.getNote());
            mDate.setText("Date: " + task.getDateCreated());
        }
    }
}