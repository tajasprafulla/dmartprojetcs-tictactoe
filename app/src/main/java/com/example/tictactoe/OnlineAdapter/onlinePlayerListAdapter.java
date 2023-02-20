package com.example.tictactoe.OnlineAdapter;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tictactoe.R;

import java.util.List;

public class onlinePlayerListAdapter extends RecyclerView.Adapter<onlinePlayerListAdapter.ViewHolder>
{

    private final List<String> playerList;

    private String apid;

    private final ClickListener clickListener;

    public onlinePlayerListAdapter(List<String> playerList, String apid, ClickListener clickListener) {
        this.playerList = playerList;
        this.apid = apid;
        this.clickListener = clickListener;
    }


    @NonNull
    @Override
    public onlinePlayerListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem= layoutInflater.inflate(R.layout.newonlinelp, parent, false);
        ViewHolder viewHolder = new ViewHolder(listItem);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull onlinePlayerListAdapter.ViewHolder holder, int position) {
        String playerName = playerList.get(position);
        holder.textView.setText(playerName);



    }

    @Override
    public int getItemCount() {
        return playerList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView textView;
        public ConstraintLayout cL;



        public ViewHolder(View itemView) {
            super(itemView);
            this.textView = (TextView) itemView.findViewById(R.id.newonlinelptextView);
            cL = (ConstraintLayout) itemView.findViewById(R.id.newonlinelpid);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            int position = getAdapterPosition();
            clickListener.onItemClick(position,view);
        }
    }
    public interface ClickListener {
        void onItemClick(int position, View v);
        void onItemLongClick(int position, View v);
    }



}

