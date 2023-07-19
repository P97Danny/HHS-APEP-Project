package com.example.apep_2223_group_3.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.apep_2223_group_3.Models.TaskHistory;
import com.example.apep_2223_group_3.R;

import java.util.List;

public class TaskHistoryAdapter extends RecyclerView.Adapter<TaskHistoryAdapter.ViewHolder>{
    private List<TaskHistory> showHistroy;

    public TaskHistoryAdapter(List<TaskHistory> showHistroy) {
        this.showHistroy = showHistroy;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.task_history_row, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        TaskHistory taskHistory = showHistroy.get(position);
        holder.taskHistoryDateTf.setText((CharSequence) taskHistory.getDateChecked());
    }

    @Override
    public int getItemCount() {
        return showHistroy.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView taskHistoryDateTf;

        public ViewHolder(View itemView) {
            super(itemView);
            taskHistoryDateTf = itemView.findViewById(R.id.taskHistroy_tv);
        }
    }
}