package com.example.better_life;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class adapterforadminhistory extends RecyclerView.Adapter<myadapter.myviewholder>{
    ArrayList<model> datalist;
   // FirebaseAuth fAuth= FirebaseAuth.getInstance();
//    public String userID = fAuth.getCurrentUser().getUid();

    public adapterforadminhistory(ArrayList<model> datalist) {
        this.datalist = datalist;
    }

    public void myadapter(ArrayList<model> datalist) {
        this.datalist = datalist;
    }

    @NonNull
    @Override
    public myadapter.myviewholder onCreateViewHolder (@NonNull ViewGroup parent, int viewType){
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.singlerow, parent, false);
        return new myadapter.myviewholder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull myadapter.myviewholder holder, int position) {
        holder.tname.setText(datalist.get(position).getName());
        holder.ttype.setText(datalist.get(position).getType());
        holder.tdescription.setText(datalist.get(position).getDescription());
    }

    @Override
    public int getItemCount() {
        return datalist.size();
    }



    class myviewholder extends RecyclerView.ViewHolder
    {
        TextView tname,ttype,tdescription;
        public myviewholder(@NonNull View itemView) {
            super(itemView);
            tname = itemView.findViewById(R.id.nameadhis);
            ttype = itemView.findViewById(R.id.typeadhis);
            tdescription = itemView.findViewById(R.id.descriptionadhis);
        }
    }
}
