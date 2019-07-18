package com.example.movir.departmentofstatistics;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;



public class CourseActivity extends AppCompatActivity {

    private ListView mListView1, mListView2,mListView3,mListView4,mListView5,mListView6,mListView7,mListView8;


    static final String[] courseTitles = {"Probability","Principles Of Statsitics","Principles Of Statistics Lab","Algebra","English Language-1","Theory Of Statistics","Theory Of Statistics Lab","Sampling Techniques -1","Sampling Techniques -1 Lab","Calculus","Linear Algebra","Viva Voce","Regression Analysis-1","Regression Analysis-1 Lab","Advanced Calculus And Differential Equations","Principles Of Microeconomics","Advanced English","Advanced English Viva-Voce","Design And Analysis Of Experiments-1","Design And Analysis Of Experiments-1 Lab","Numerical Methods And Complex Variable","Real Analysis","Principles Of Macroeconomics","Viva Voce","Statistical Computing-1","Statistical Computing-1 Lab","Linear Programming","Linear Pogramming Lab","Statistical Inference","Statistical Inference Lab","Database Management And Programming","Database Management And Programming Lab","Demography","Demography Lab","Statistical Programming-2","Statistical Programming-2 Lab","Regression Analysis-2","Regression Analysis-2 Lab","Stochastic Processes","Viva Voce","Economic Statistics","Economic Statistics Lab","Applied Statistics","Applied Statistics Lab","Design And Analysis Of Experiments-2","Design And Analysis Of Experiments-2 Lab","Sampling Techniques-2","Sampling Techniques-2 Lab","Multivariate Analysis","Multivariate Analysis Lab","Biostatistics and Epidemiology","Biostatistics and Epidemiology  Lab","Applied Data Analysis","Applied Data Analysis Lab","Generalized Linear Models","Comprehensive (Optional)","Viva Voce"
    };

    static final String[] courseCode = {"STA 131","STA 132","STA 132L","MAT 101O","ENG 101","STA 133","STA 133L","STA 134","STA 134L","MAT 103O","MAT 109","STA 100","STA 241","STA 241L","MAT 207O","ECO 201","ENG 103","ENG 104","STA 232","STA 232L","MAT 208","MAT 209","ECO 202","STA 200","STA 332","STA 332L","STA 337","STA 337L","STA 341","STA 341L","CSE 205","CSE205L","STA 333","STA 333L","STA 334","STA 334L","STA 335","STA 335L","STA 336","STA 300","STA 431","STA 431L","STA 432","STA 432L","STA 433","STA 433L","STA 437","STA 437L","STA 435","STA 435L","STA 436","STA 436L","STA 451","STA 451L","STA 452","STA 453","STA 400"
    };
    static final Integer[] courseCredit = {4,3,2,2,2,3,2,3,2,3,3,2,3,2,3,3,2,1,3,2,3,3,3,2,2,2,3,2,3,2,2,3,3,2,3,2,3,2,4,2,3,2,3,2,3,2,3,1,3,2,3,2,2,3,3,4,2
    };

    private Course[] allCourses = new Course[58];
    Intent intent;
    String message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course);

        //set toolbar and back button
        Toolbar toolbar = findViewById(R.id.courseToolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        mListView1 = (ListView)findViewById(R.id.list1);
        mListView2 = (ListView)findViewById(R.id.list2);
        mListView3 = (ListView)findViewById(R.id.list3);
        mListView4 = (ListView)findViewById(R.id.list4);
        mListView5 = (ListView)findViewById(R.id.list5);
        mListView6 = (ListView)findViewById(R.id.list6);
        mListView7 = (ListView)findViewById(R.id.list7);
        mListView8 = (ListView)findViewById(R.id.list8);

        //input courses
//        Course STA131 = new Course(courseCode[0],courseTitles[0] , Integer.toString(courseCredit[0]));
//        Course STA132 = new Course(courseCode[1],courseTitles[1],Integer.toString(courseCredit[1]));
//        Course STA132L = new Course(courseCode[2],courseTitles[2],Integer.toString(courseCredit[2]));
//        Course MAT101O = new Course(courseCode[3],courseTitles[3],Integer.toString(courseCredit[3]));
//        Course ENG101O = new Course(courseCode[4],courseTitles[4],Integer.toString(courseCredit[4]));
//        Course STA133 = new Course(courseCode[5],courseTitles[5],Integer.toString(courseCredit[5]));
//        Course STA133L = new Course(courseCode[6],courseTitles[6],Integer.toString(courseCredit[6]));
//        Course STA134 = new Course(courseCode[7],courseTitles[7],Integer.toString(courseCredit[7]));
//        Course STA134L = new Course(courseCode[8],courseTitles[8],Integer.toString(courseCredit[8]));

        for(int i =0;i<57;i++){
            allCourses[i] = new Course(courseCode[i],courseTitles[i] , Integer.toString(courseCredit[i]));
        }


        //arraylist for each semester
        final ArrayList<Course> oneOne = new ArrayList<Course>();
        ArrayList<Course> oneTwo = new ArrayList<Course>();
        ArrayList<Course> twoOne = new ArrayList<Course>();
        ArrayList<Course> twoTwo = new ArrayList<Course>();
        ArrayList<Course> threeOne = new ArrayList<Course>();
        ArrayList<Course> threeTwo = new ArrayList<Course>();
        ArrayList<Course> fourOne = new ArrayList<Course>();
        ArrayList<Course> fourTwo = new ArrayList<Course>();

        for(int i= 0; i<5;i++){
            oneOne.add(allCourses[i]);
        }
        for(int i=5;i<12;i++){
            oneTwo.add(allCourses[i]);
        }
        for(int i=12;i<18;i++){
            twoOne.add(allCourses[i]);
        }
        for(int i=18;i<24;i++){
            twoTwo.add(allCourses[i]);
        }
        for(int i=24;i<32;i++){
            threeOne.add(allCourses[i]);
        }
        for(int i=32;i<40;i++){
            threeTwo.add(allCourses[i]);
        }
        for(int i=40;i<48;i++){
            fourOne.add(allCourses[i]);
        }
        for(int i=48;i<57;i++){
            fourTwo.add(allCourses[i]);
        }




//        oneOne.add(STA131);
//        oneOne.add(STA132);
//        oneOne.add(STA132L);
//        oneOne.add(MAT101O);
//        oneOne.add(ENG101O);
//        oneTwo.add(STA133);
//        oneTwo.add(STA133L);
//        oneTwo.add(STA134);
//        oneTwo.add(STA134L);

        CourseListAdapter adapterOne = new CourseListAdapter(this, R.layout.adapter_view_layout, oneOne);
        mListView1.setAdapter(adapterOne);
        CourseListAdapter adapterTwo = new CourseListAdapter(this, R.layout.adapter_view_layout, oneTwo);
        mListView2.setAdapter(adapterTwo);
        CourseListAdapter adapterThree = new CourseListAdapter(this, R.layout.adapter_view_layout, twoOne);
        mListView3.setAdapter(adapterThree);
        CourseListAdapter adapterFour = new CourseListAdapter(this, R.layout.adapter_view_layout, twoTwo);
        mListView4.setAdapter(adapterFour);
        CourseListAdapter adapterFive = new CourseListAdapter(this, R.layout.adapter_view_layout, threeOne);
        mListView5.setAdapter(adapterFive);
        CourseListAdapter adapterSix = new CourseListAdapter(this, R.layout.adapter_view_layout, threeTwo);
        mListView6.setAdapter(adapterSix);
        CourseListAdapter adapterSeven = new CourseListAdapter(this, R.layout.adapter_view_layout, fourOne);
        mListView7.setAdapter(adapterSeven);
        CourseListAdapter adapterEight = new CourseListAdapter(this, R.layout.adapter_view_layout, fourTwo);
        mListView8.setAdapter(adapterEight);

        //mListView1.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, data1));
        //mListView2.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, data2));

        ListUtils.setDynamicHeight(mListView1);
        ListUtils.setDynamicHeight(mListView2);
        ListUtils.setDynamicHeight(mListView3);
        ListUtils.setDynamicHeight(mListView4);
        ListUtils.setDynamicHeight(mListView5);
        ListUtils.setDynamicHeight(mListView6);
        ListUtils.setDynamicHeight(mListView7);
        ListUtils.setDynamicHeight(mListView8);


        //----make listViews ineractive----

        mListView1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.i("clicked on: ",courseTitles[position]);
                changeActivity(position);

            }
        });

        mListView2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.i("clicked on: ",courseTitles[position+5]);
                changeActivity(position+5);
            }
        });
        mListView3.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.i("clicked on: ",courseTitles[position+12]);
                changeActivity(position+12);
            }
        });
        mListView4.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.i("clicked on: ",courseTitles[position+18]);
                changeActivity(position+18);
            }
        });
        mListView5.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.i("clicked on: ",courseTitles[position+24]);
                changeActivity(position+24);
            }
        });
        mListView6.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.i("clicked on: ",courseTitles[position+32]);
                changeActivity(position+32);
            }
        });
        mListView7.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.i("clicked on: ",courseTitles[position+40]);
                changeActivity(position+40);
            }
        });
        mListView8.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.i("clicked on: ",courseTitles[position+48]);
                changeActivity(position+48);
            }
        });



    }//end of onCreate()

    //method for changing activity
    public void changeActivity(int pos){
        intent = new Intent(CourseActivity.this, CourseDetailActivity.class);
        message = courseTitles[pos];
        intent.putExtra("MESSAGE",message);
        intent.putExtra("POSITION" ,pos);
        startActivity(intent);
    }


    //on back button clicked
    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
