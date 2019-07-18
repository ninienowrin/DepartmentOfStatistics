package com.example.movir.departmentofstatistics;


import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class CourseListAdapter extends ArrayAdapter<Course> {

    private Context mContext;
    int mResource;

    public CourseListAdapter(@NonNull Context context, int resource, @NonNull ArrayList<Course> objects) {
        super(context, resource, objects);
        this.mContext = context;
        mResource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        String code = getItem(position).getCode();
        String title = getItem(position).getTitle();
        String credit = getItem(position).getCredit();
        Course course = new Course(code,title,credit);
        LayoutInflater inflater = LayoutInflater.from(mContext);
        convertView = inflater.inflate(mResource,parent,false);

        TextView tvCode = (TextView)convertView.findViewById(R.id.code);
        TextView tvTitle = (TextView)convertView.findViewById(R.id.title);
        TextView tvCredit = (TextView)convertView.findViewById(R.id.credit);

        tvCode.setText(code);
        tvTitle.setText(title);
        tvCredit.setText(credit);

        return convertView;

    }
}

