package com.example.apep_2223_group_3.Adapters;


import static androidx.core.content.ContextCompat.startActivity;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.apep_2223_group_3.Activities.newtaskandOverview.TaskDetailActivity;
import com.example.apep_2223_group_3.Models.Task;
import com.example.apep_2223_group_3.R;

import java.util.List;

public class TaskAdapter extends RecyclerView.Adapter<TaskAdapter.ViewHolder>{

    private List<Task> data;
    public TaskAdapter(List<Task> data) {
        this.data = data;
    }

    public int getItemCount() {
        return data.size();
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Task task = data.get(position);
        holder.taskNameTf.setText(task.getName());
        holder.taskDescription.setText(task.getDescription());
        holder.taskButton.setId(task.getId());
    }


    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.show_row, parent, false);
        return new ViewHolder(view);
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView taskNameTf;
        private TextView taskDescription;
        private Button taskButton;

        public ViewHolder(View itemView) {
            super(itemView);
            taskNameTf = itemView.findViewById(R.id.taskRow_taskName_tf);
            taskDescription = itemView.findViewById(R.id.showrow_description_id);
            taskButton = itemView.findViewById(R.id.show_row_btn);
        }
    }
}

