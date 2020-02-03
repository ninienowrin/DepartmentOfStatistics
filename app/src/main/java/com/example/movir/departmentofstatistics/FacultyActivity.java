package com.example.movir.departmentofstatistics;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;

public class FacultyActivity extends AppCompatActivity {

    static final Integer[] imageArray = {R.drawable.p1,R.drawable.p2,R.drawable.p3,R.drawable.p4,R.drawable.p5,R.drawable.p6,R.drawable.p7,R.drawable.p8,R.drawable.p9,R.drawable.p10,R.drawable.p11,R.drawable.p12,R.drawable.p13,R.drawable.p14,R.drawable.p15,R.drawable.p16,R.drawable.p17,R.drawable.p18,R.drawable.p19,R.drawable.p20,R.drawable.p21,R.drawable.p22,R.drawable.p23,R.drawable.p24,R.drawable.p25};
    static final String[] nameArray = {"Dr. Md. Kabir Hossain" , "Dr Md Zakir Hossain" , "Dr Sabina Islam" , "Dr Ahmad Kabir" , "Md. Ahmed Kabir Chowdhury" , "Dr Rahmat Ali" , "Dr Md. Azizul Baten" , "Dr. Mohammed Taj Uddin" , "Dr Mohammad Shahidul Islam" , "Dr Md Nazrul Islam" , "Dr S M Khurshid Alam" , "Dr. Mohammad Ohid Ullah" , "Dr. Khalidur Rahman" , "Dr. Md. Jamal Uddin" , "Dr. Luthful Alahi Kawsar" , "Md Ziaul Islam Chowdhury" , "Mohammad Romel Bhuia" , "Sumonkanti Das, PhD" , "Dr. Md. Atiqul Islam" , "Mossamet Kamrun Nesa" , "Mirza Nazmul Hasan" , "Mirajul Islam" , "Dr Kanis Fatama Ferdushi" , "Sabbir Tahmidur Rahman" , "Nahid Sultana" };
    static final String[] designationArray = {"Professor" , "Professor" , "Professor" , "Professor" , "Professor & Head" , "Professor" , "Professor" , "Professor" , "Professor" , "Professor" , "Professor" , "Professor" , "Professor" , "Associate Professor" , "Associate Professor" , "Associate Professor" , "Associate Professor" , "Associate Professor" , "Associate Professor" , "Assistant Professor" , "Assistant Professor" , "Assistant Professor" , "Assistant Professor" , "Assistant Professor" , "Assistant Professor"};
    static final String[] emailArray = {"khossain.sust@gmail.com" , "mzhossain.bds@gmail.com" , "drsabinaus@yahoo.com" , "akabir_sta@yahoo.com" , "makc@sust.edu; makc-sust@live.com" , " ralistat@sust.edu" , "baten-sta@sust.edu, baten_math@yahoo.com" , "mtajstat@yahoo.com" , " shahed.stat@gmail.com" , "nazrul330@yahoo.com" , "smka_bbstat@yahoo.com" , "ohidullah@gmail.com, ohid-sta@sust.edu" , " khalid_sust@yahoo.com; khalid-sta@sust.edu" , "jamal-sta@sust.edu, jamalsust@gmail.com" , "lakawsar@yahoo.com, lakawsar-sta@sust.edu" , "zia082000@yahoo.com" , " romel_stat@yahoo.com" , "sumonkanti-sta@sust.edu" , "atique-sta@sust.edu, atique.sta@gmail.com" , "nesa1912@yahoo.com" , "hasan_sust_stat@yahoo.com" , " miraj.isrt10@gmail.com" , "kanisusm@gmail.com" , "str-sta@sust.edu, sabbi_01@yahoo.com " , "nahids@rocketmail.com"};
    static final String[] phoneArray = {"+8801711184818", " 01711140801", "01911720525", "01711116908", "419, 257", " 01552438862", "8801716262947", "088-01716348194", "01777827876 ", "01711466280", "Phone", "01818101435", " 01712068785", "8801716972846", " 88-0821-714479, 717850", "01711476958", "01675372000", "8801818824282", "8801716466720", "01717018642 ", "01716148317", "01675018522", "01818824338", "0821-714479", "88-01728707307"};

    Teacher[] teachers = new Teacher[26];
    ArrayList<Teacher> teachersArrayList = new ArrayList<Teacher>();
    static RecyclerView recyclerView;
    public static Context mContext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faculty);

        //set toolbar and back button
        Toolbar toolbar = findViewById(R.id.facultyToolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        mContext = FacultyActivity.this;
        for(int i=0;i<25;i++){
            teachers[i] = new Teacher(imageArray[i], nameArray[i],designationArray[i],emailArray[i],phoneArray[i]);
        }
        for(int i=0;i<25;i++){
            teachersArrayList.add(teachers[i]);
        }

        initRecyclerView();
    }

    private void initRecyclerView(){
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(this, teachersArrayList);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
    //on back button clicked
    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }


    static void makeCall(String phone) {
        Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + phone));
        if (ContextCompat.checkSelfPermission(mContext, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions((Activity)mContext, new String[]{Manifest.permission.CALL_PHONE}, 10);
        } else {
            mContext.startActivity(intent);
//                }
        }
    }

    static void sendEmail(String addresses){
        Log.i("email", "sendEmail: "+addresses);
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("*/*");
        String[] to = {addresses};
        intent.putExtra(Intent.EXTRA_EMAIL, to);
//        intent.putExtra(Intent.EXTRA_SUBJECT, "");
//        intent.putExtra(Intent.EXTRA_STREAM, "");
        if (intent.resolveActivity(mContext.getPackageManager()) != null) {
            mContext.startActivity(intent);
        }
    }


}
