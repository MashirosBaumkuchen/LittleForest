package com.jascal.clare.main.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.jascal.clare.R;
import com.jascal.clare.bean.HistoryEvent;
import java.util.List;

/**
 * @author No.47 create at 2017/9/4.
 */
public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {
    private List<HistoryEvent> data;

    public RecyclerAdapter(List<HistoryEvent> data) {
        this.data = data;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_main, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.title.setText(data.get(position).getTitle());
        holder.lunar.setText(data.get(position).getLunar());
        holder.date.setText(data.get(position).getYear() + "/" + data.get(position).getMonth() + "/" + data.get(position).getDay());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView title;
        public TextView lunar;
        public TextView date;

        public ViewHolder(View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.item_title);
            lunar = itemView.findViewById(R.id.item_lunar);
            date = itemView.findViewById(R.id.item_date);
        }
    }
}
