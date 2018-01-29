package com.m.taskman.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.m.taskman.R;
import com.m.taskman.models.com.m.models.Todo;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by kadan on 1/26/18.
 */

public class TaskDisplayAdapterold extends RecyclerView.Adapter<TaskDisplayAdapterold.TasksViewHolder> {
    private ArrayList<Todo> mTasks = new ArrayList<>();
    private Context mContext;

    public TaskDisplayAdapterold(Context context, ArrayList<Todo> Tasks) {
        mContext = context;
        mTasks = Tasks;
    }

    @Override
    public TaskDisplayAdapterold.TasksViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.tasklistitem, parent, false);
        TasksViewHolder viewHolder = new TasksViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(TaskDisplayAdapterold.TasksViewHolder holder, int position) {
        holder.bindTask(mTasks.get(position));
    }

    @Override
    public int getItemCount() {
        return mTasks.size();
    }

    public class TasksViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        @BindView(R.id.task)
        TextView mtask;
        @BindView(R.id.desc)
        TextView mDesc;
        @BindView(R.id.date)
        TextView mDate;

        private Context mContext;

        public TasksViewHolder(View itemView) {
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
//            intent.putExtra("restaurants", Parcels.wrap(mRestaurants));
//            mContext.startActivity(intent);
        }

        public void bindTask(Todo task) {
            String taska = task.getDescription();
            String note = task.getNote();

            mtask.setText(task.getDescription());
            mDesc.setText(task.getNote());
            mDate.setText("Date: " + task.getDateCreated());
        }

    }
}
