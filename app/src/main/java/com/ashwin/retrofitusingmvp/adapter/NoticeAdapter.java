package com.ashwin.retrofitusingmvp.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ashwin.retrofitusingmvp.R;
import com.ashwin.retrofitusingmvp.retrofit.NoticeModel.Notice;
import com.ashwin.retrofitusingmvp.utility.RecyclerViewClickListener;

import java.util.ArrayList;

public class NoticeAdapter extends RecyclerView.Adapter<NoticeAdapter.NoticeViewHolder> {
    private ArrayList<Notice> mNoticeList;
    private RecyclerViewClickListener mRecyclerViewClickListener;

    public NoticeAdapter(ArrayList<Notice> noticeList, RecyclerViewClickListener recyclerViewClickListener) {
        mNoticeList = noticeList;
        mRecyclerViewClickListener = recyclerViewClickListener;
    }

    @NonNull
    @Override
    public NoticeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_notice, parent, false);
        return new NoticeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NoticeViewHolder holder, final int position) {

        holder.txtViewTitle.setText(mNoticeList.get(position).getTitle());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mRecyclerViewClickListener.onItemClick(mNoticeList.get(position));
            }
        });
    }

    @Override
    public int getItemCount() {
        return mNoticeList.size();
    }

    class NoticeViewHolder extends RecyclerView.ViewHolder {
        private TextView txtViewTitle;

        public NoticeViewHolder(View itemView) {
            super(itemView);

            txtViewTitle = itemView.findViewById(R.id.txtViewTitle);
        }
    }
}
