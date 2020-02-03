package com.example.movir.departmentofstatistics;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {


    private static final int REQUEST_CALL_PHONE = 1;
    //     private ArrayList<Integer> imageList = new ArrayList<Integer>();
//    private ArrayList<String> designationList = new ArrayList<String>();
//     private ArrayList<String> nameList = new ArrayList<>();
//    private ArrayList<String> emailList = new ArrayList<>();
//    private ArrayList<String> phoneList = new ArrayList<>();
    ArrayList<Teacher> teachersArrayList = new ArrayList<Teacher>();
//    private Context mContext;

    public RecyclerViewAdapter(Context mContext, ArrayList<Teacher> teachersArrayList) {
        this.teachersArrayList = teachersArrayList;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_layout, parent, false);
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

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        CircleImageView imageView;
        TextView nameText;
        TextView designationText;
        TextView emailText;
        TextView phoneText;
        RelativeLayout parentLayout;
        ImageView phoneIcon;
        ImageView emailIcon;

        public ViewHolder(@NonNull final View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.image);
            nameText = itemView.findViewById(R.id.name);
            emailText = itemView.findViewById(R.id.email);
            phoneText = itemView.findViewById(R.id.phone);
            designationText = itemView.findViewById(R.id.designation);
            parentLayout = itemView.findViewById(R.id.parentLayout);
            phoneIcon = itemView.findViewById(R.id.phoneIcon);
            emailIcon = itemView.findViewById(R.id.emailIcon);


            phoneIcon.setOnClickListener(this);
            emailIcon.setOnClickListener(this);

        }


        @Override
        public void onClick(View v) {

            int itemPos = this.getLayoutPosition();

            if (v.getId() == emailIcon.getId()) {
                Log.i("faculty type", "onClick: emaill");
                Log.i("faculty Email", teachersArrayList.get(itemPos).getEmails());
                FacultyActivity.sendEmail(teachersArrayList.get(itemPos).getEmails());
            }

            if (v.getId() == phoneIcon.getId()) {
                Log.i("faculty phone", teachersArrayList.get(itemPos).getPhones());

                FacultyActivity.makeCall(teachersArrayList.get(itemPos).getPhones());


            }


        }
    }



}
