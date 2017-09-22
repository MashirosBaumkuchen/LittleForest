package com.jascal.clare.main.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.jascal.clare.R;
import com.jascal.clare.bean.HistoryEvent;
import com.squareup.picasso.Picasso;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

/**
 * @author No.47 create at 2017/9/4.
 */
public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {
    private final String TAG = "RecyclerAdapter";
    private Context context;
    private List<HistoryEvent.Event> data;

    public RecyclerAdapter(Context context, List<HistoryEvent.Event> data) {
        this.data = data;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_main, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        HistoryEvent.Event event = data.get(position);
        holder.title.setText(event.getTitle());
        holder.lunar.setText(event.getLunar());
        holder.date.setText(event.getYear() + "." + event.getMonth() + "." + event.getDay());
        if (event.getPic() != null & event.getPic() != "") {
            Picasso.with(context).load(event.getPic()).into(holder.pic);
            holder.pic.setVisibility(View.VISIBLE);
        } else {
            Picasso.with(context).load(R.mipmap.ic_launcher).into(holder.pic);
            holder.pic.setVisibility(View.GONE);
        }
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView title;
        public TextView lunar;
        public TextView date;
        public ImageView pic;

        public ViewHolder(View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.item_title);
            lunar = itemView.findViewById(R.id.item_lunar);
            date = itemView.findViewById(R.id.item_date);
            pic = itemView.findViewById(R.id.item_pic);
        }
    }
}
