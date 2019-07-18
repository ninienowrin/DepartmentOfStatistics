package com.example.movir.departmentofstatistics;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>{



    //     private ArrayList<Integer> imageList = new ArrayList<Integer>();
//    private ArrayList<String> designationList = new ArrayList<String>();
//     private ArrayList<String> nameList = new ArrayList<>();
//    private ArrayList<String> emailList = new ArrayList<>();
//    private ArrayList<String> phoneList = new ArrayList<>();
    ArrayList<Teacher> teachersArrayList = new ArrayList<Teacher>();
    private Context mContext;

    public RecyclerViewAdapter(Context mContext, ArrayList<Teacher> teachersArrayList) {
        this.teachersArrayList = teachersArrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_layout,parent,false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.nameText.setText(teachersArrayList.get(position).getNames());
        holder.imageView.setImageResource(teachersArrayList.get(position).getImages());
        holder.designationText.setText(teachersArrayList.get(position).getDesignations());
        holder.emailText.setText(teachersArrayList.get(position).getEmails());
        holder.phoneText.setText(teachersArrayList.get(position).getPhones());


    }

    @Override
    public int getItemCount() {
        return teachersArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        CircleImageView imageView;
        TextView nameText;
        TextView designationText;
        TextView emailText;
        TextView phoneText;
        RelativeLayout parentLayout;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.image);
            nameText = itemView.findViewById(R.id.name);
            emailText = itemView.findViewById(R.id.email);
            phoneText = itemView.findViewById(R.id.phone);
            designationText = itemView.findViewById(R.id.designation);
            parentLayout = itemView.findViewById(R.id.parentLayout);
        }
    }
}
