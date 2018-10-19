package com.example.liban.rxjavatest.adaptor;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.liban.rxjavatest.R;
import com.example.liban.rxjavatest.model.Users;

import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {

    private List<Users> users;
    private Context mContext;

    public RecyclerAdapter(List<Users> users, Context mContext) {
        this.users = users;
        this.mContext = mContext;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater
                .from(mContext)
                .inflate(R.layout.item_layout, viewGroup,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.mTextViewId.setText(users.get(i).getId());
        viewHolder.mTextViewTitle.setText(users.get(i).getTitle());
        viewHolder.mTextViewBody.setText(users.get(i).getBody());

    }

    @Override
    public int getItemCount() {
        if (users != null) {
            return users.size();
        } else {
            return 0;
        }
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView mTextViewId;
        private TextView mTextViewTitle;
        private TextView mTextViewBody;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mTextViewId = itemView.findViewById(R.id.id_text);
            mTextViewTitle = itemView.findViewById(R.id.title_id);
            mTextViewBody = itemView.findViewById(R.id.body_id);
        }
    }
}
