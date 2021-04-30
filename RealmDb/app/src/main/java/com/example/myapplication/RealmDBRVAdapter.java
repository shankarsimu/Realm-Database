package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RealmDBRVAdapter extends RecyclerView.Adapter<RealmDBRVAdapter.ViewHolder> {

    private List<RealmDataModel> dataModalArrayList;
    private Context context;

    public RealmDBRVAdapter(List<RealmDataModel> dataModalArrayList, Context context) {
        this.dataModalArrayList = dataModalArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public RealmDBRVAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

         View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.rv_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RealmDBRVAdapter.ViewHolder holder, int position) {
        RealmDataModel modal = dataModalArrayList.get(position);
        holder.UserName.setText(modal.getUserName());
        holder.UserPosition.setText(modal.getUserPosition());
    }

    @Override
    public int getItemCount() {
        return dataModalArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView UserName, UserPosition;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            UserName = itemView.findViewById(R.id.userName);
            UserPosition = itemView.findViewById(R.id.userPosition);
        }
    }
}