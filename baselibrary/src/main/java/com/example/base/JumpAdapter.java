package com.example.base;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.library.R;

import java.util.ArrayList;
import java.util.List;

public class JumpAdapter extends RecyclerView.Adapter<JumpAdapter.MainViewHolder> {

    private List<String> mTitles = new ArrayList<>();


    public JumpAdapter(List<String> titles) {
        mTitles = titles;
    }

    @Override
    public MainViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View rootView = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_news_item, parent, false);
        JumpAdapter.MainViewHolder mainViewHolder = new MainViewHolder(rootView);
        return mainViewHolder ;
    }

    @Override
    public void onBindViewHolder(final MainViewHolder holder, int position) {
        final String title = mTitles.get(position);
        TextView titleView = holder.mTvTitle;
        titleView.setText(title);

    }

    public void setOnItemClickListener(onItemClickListener onItemClickListener) {
        mOnItemClickListener = onItemClickListener;
    }

    public onItemClickListener mOnItemClickListener;
    public interface onItemClickListener{
        void onItemClick(int position);
    }

    @Override
    public int getItemCount() {
        return mTitles.size();
    }

    public  class MainViewHolder extends RecyclerView.ViewHolder {

        public TextView mTvTitle;

        public MainViewHolder(View rootView) {
            super(rootView);
            mTvTitle = (TextView) rootView.findViewById(R.id.tv_title);
            mTvTitle.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    if(mOnItemClickListener!=null){
                        mOnItemClickListener.onItemClick(position);
                    }
                }
            });
        }
    }
}