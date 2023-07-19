package com.example.apep_2223_group_3.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.apep_2223_group_3.Models.RoomEntity;
import com.example.apep_2223_group_3.R;
import java.util.List;

public class RoomOverviewAdapter extends RecyclerView.Adapter<RoomOverviewAdapter.ViewHolder> {

    private final List<RoomEntity> data;

    @Override
    public int getItemCount() {
        return data.size();
    }

    public RoomOverviewAdapter(List<RoomEntity> data) {
        this.data = data;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private final TextView roomNameTf;
        public ViewHolder(View itemView) {
            super(itemView);
            roomNameTf = itemView.findViewById(R.id.showRow_showRoom_overview_tf);
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.show_row_room_overview, parent, false);
        return new ViewHolder(view);
    }

    public void onBindViewHolder(ViewHolder holder, int position) {
        RoomEntity item = data.get(position);
        holder.roomNameTf.setText(item.getName());
    }
}
