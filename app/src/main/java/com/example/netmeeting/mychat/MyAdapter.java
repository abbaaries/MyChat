package com.example.netmeeting.mychat;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder>{
    List<User> users;
    public MyAdapter(List<User> users){
        this.users = users;
    }
    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView tv_name;
        TextView tv_team;
        TextView tv_msg;
        TextView tv_time;
        TextView tv_great1;
        TextView tv_great2;
        TextView tv_mName;
        TextView tv_mTeam;
        TextView tv_mMsg;
        TextView tv_mTime;
        TextView tv_mGreat1;
        TextView tv_mGreat2;

        public ViewHolder(View itemView) {
            super(itemView);

            tv_name = (TextView)itemView.findViewById(R.id.tv_name);
            tv_team = (TextView)itemView.findViewById(R.id.tv_team);
            tv_msg = (TextView)itemView.findViewById(R.id.tv_msg);
            tv_time = (TextView)itemView.findViewById(R.id.tv_time);
            tv_great1 = (TextView)itemView.findViewById(R.id.tv_great1);
            tv_great2 = (TextView)itemView.findViewById(R.id.tv_great2);


            tv_mName = (TextView)itemView.findViewById(R.id.tv_mName);
            tv_mTeam = (TextView)itemView.findViewById(R.id.tv_mTeam);
            tv_mMsg = (TextView)itemView.findViewById(R.id.tv_mMsg);
            tv_mTime = (TextView)itemView.findViewById(R.id.tv_mTime);
            tv_mGreat1 = (TextView)itemView.findViewById(R.id.tv_mGreat1);
            tv_mGreat2 = (TextView)itemView.findViewById(R.id.tv_mGreat2);
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        View view = LayoutInflater.from(context).inflate(R.layout.item,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }


    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        User user = users.get(position);
        if(user.getStfn().equals("180317")){
            holder.tv_mName.setText(user.getStfn()+"  "+user.getName());
            holder.tv_mTeam.setText(user.getTag()+"");
            holder.tv_mMsg.setText(user.getText());
            holder.tv_mTime.setText(new SimpleDateFormat("hh:mm").
                    format(user.getTimestamp()));
            holder.tv_mGreat1.setText(user.getLike()+"");
//            holder.tv_mGreat2.setText(user.getLikes().size()+"");
            holder.tv_mName.setVisibility(View.VISIBLE);
            holder.tv_mTeam.setVisibility(View.VISIBLE);
            holder.tv_mMsg.setVisibility(View.VISIBLE);
            holder.tv_mTime.setVisibility(View.VISIBLE);
            holder.tv_mGreat1.setVisibility(View.VISIBLE);
//            holder.tv_mGreat2.setVisibility(View.GONE);
            holder.tv_name.setVisibility(View.GONE);
            holder.tv_team.setVisibility(View.GONE);
            holder.tv_msg.setVisibility(View.GONE);
            holder.tv_time.setVisibility(View.GONE);
            holder.tv_great1.setVisibility(View.GONE);
//            holder.tv_great2.setVisibility(View.GONE);
        }else {
            holder.tv_name.setText(user.getStfn()+"  "+user.getName());
            holder.tv_team.setText(user.getTag()+"");
            holder.tv_msg.setText(user.getText());
            holder.tv_time.setText(new SimpleDateFormat("hh:mm").
                    format(user.getTimestamp()));
            holder.tv_great1.setText(user.getLike()+"");
//            holder.tv_great2.setText(user.getLikes().size()+"");
            holder.tv_name.setVisibility(View.VISIBLE);
            holder.tv_team.setVisibility(View.VISIBLE);
            holder.tv_msg.setVisibility(View.VISIBLE);
            holder.tv_time.setVisibility(View.VISIBLE);
            holder.tv_great1.setVisibility(View.VISIBLE);
//            holder.tv_great2.setVisibility(View.GONE);
            holder.tv_mName.setVisibility(View.GONE);
            holder.tv_mTeam.setVisibility(View.GONE);
            holder.tv_mMsg.setVisibility(View.GONE);
            holder.tv_mTime.setVisibility(View.GONE);
            holder.tv_mGreat1.setVisibility(View.GONE);
//            holder.tv_mGreat2.setVisibility(View.GONE);
        }
    }



    @Override
    public int getItemCount() {
        return users.size();
    }


}
