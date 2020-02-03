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



    private Course[] allCourses = new Course[75];
    Intent intent;
    String message;
    String tappedSession;
    Integer[] semesterCutPoint = new Integer[8]; //how many courses per semester.

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course);

        //set toolbar and back button
        Toolbar toolbar = findViewById(R.id.courseToolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        Intent prevIntent = getIntent();
        tappedSession = prevIntent.getStringExtra("MESSAGE");
        Log.i("tapped session", tappedSession);

        if(tappedSession.equals("session15")){
            toolbar.setTitle("2015-16");
            for(int i =0;i<Syllabus.Session15.courseTitles.length;i++){
                allCourses[i] = new Course(Syllabus.Session15.courseCode[i],Syllabus.Session15.courseTitles[i] , Integer.toString(Syllabus.Session15.courseCredit[i]));
                semesterCutPoint = makeCumul(Syllabus.Session15.coursePerSem);
            }
        }
        if(tappedSession.equals("session14")){
            toolbar.setTitle("2014-15");
            for(int i =0;i<Syllabus.Session14.courseTitles.length;i++){
                allCourses[i] = new Course(Syllabus.Session14.courseCode[i],Syllabus.Session14.courseTitles[i] , Integer.toString(Syllabus.Session14.courseCredit[i]));
                semesterCutPoint = makeCumul(Syllabus.Session14.coursePerSem);
            }
        }

        if(tappedSession.equals("session18")){
            toolbar.setTitle("2018-19");
            Log.i("session18", "onCreate: ");
            for(int i =0;i<Syllabus.Session18.courseTitles.length;i++){
                allCourses[i] = new Course(Syllabus.Session18.courseCode[i],Syllabus.Session18.courseTitles[i] , Integer.toString(Syllabus.Session18.courseCredit[i]));
                semesterCutPoint = makeCumul(Syllabus.Session18.coursePerSem);
            }
        }

        if(tappedSession.equals("session16")){
            toolbar.setTitle("2016-17");

            for(int i =0;i<Syllabus.Session16.courseTitles.length;i++){
                allCourses[i] = new Course(Syllabus.Session16.courseCode[i],Syllabus.Session16.courseTitles[i] , Integer.toString(Syllabus.Session16.courseCredit[i]));
                semesterCutPoint = makeCumul(Syllabus.Session16.coursePerSem);
            }
        }






        mListView1 = (ListView)findViewById(R.id.list1);
        mListView2 = (ListView)findViewById(R.id.list2);
        mListView3 = (ListView)findViewById(R.id.list3);
        mListView4 = (ListView)findViewById(R.id.list4);
        mListView5 = (ListView)findViewById(R.id.list5);
        mListView6 = (ListView)findViewById(R.id.list6);
        mListView7 = (ListView)findViewById(R.id.list7);
        mListView8 = (ListView)findViewById(R.id.list8);







        //arraylist for each semester
        ArrayList<Course> oneOne = new ArrayList<Course>();
        ArrayList<Course> oneTwo = new ArrayList<Course>();
        ArrayList<Course> twoOne = new ArrayList<Course>();
        ArrayList<Course> twoTwo = new ArrayList<Course>();
        ArrayList<Course> threeOne = new ArrayList<Course>();
        ArrayList<Course> threeTwo = new ArrayList<Course>();
        ArrayList<Course> fourOne = new ArrayList<Course>();
        ArrayList<Course> fourTwo = new ArrayList<Course>();


        for(int i= 0; i<semesterCutPoint[0];i++){
            oneOne.add(allCourses[i]);
        }

        for(int i=semesterCutPoint[0];i<semesterCutPoint[1];i++){
            oneTwo.add(allCourses[i]);
        }
        for(int i=semesterCutPoint[1];i<semesterCutPoint[2];i++){
            twoOne.add(allCourses[i]);
        }
        for(int i=semesterCutPoint[2];i<semesterCutPoint[3];i++){
            twoTwo.add(allCourses[i]);
        }
        for(int i=semesterCutPoint[3];i<semesterCutPoint[4];i++){
            threeOne.add(allCourses[i]);
        }
        for(int i=semesterCutPoint[4];i<semesterCutPoint[5];i++){
            threeTwo.add(allCourses[i]);
        }
        for(int i=semesterCutPoint[5];i<semesterCutPoint[6];i++){
            fourOne.add(allCourses[i]);
        }
        for(int i=semesterCutPoint[6];i<semesterCutPoint[7];i++){
            fourTwo.add(allCourses[i]);
        }





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
                Log.i("clicked on: ",allCourses[position].getTitle());
                changeActivity(position);

            }
        });

        mListView2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.i("clicked on: ",allCourses[position+semesterCutPoint[0]].getTitle());
                changeActivity(position+semesterCutPoint[0]);
            }
        });
        mListView3.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.i("clicked on: ",allCourses[position+semesterCutPoint[1]].getTitle());
                changeActivity(position+semesterCutPoint[1]);
            }
        });
        mListView4.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                Log.i("clicked on: ",courseTitles[position+18]);
                changeActivity(position+semesterCutPoint[2]);
            }
        });
        mListView5.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                Log.i("clicked on: ",courseTitles[position+24]);
                changeActivity(position+semesterCutPoint[3]);
            }
        });
        mListView6.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                Log.i("clicked on: ",courseTitles[position+32]);
                changeActivity(position+semesterCutPoint[4]);
            }
        });
        mListView7.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                Log.i("clicked on: ",courseTitles[position+40]);
                changeActivity(position+semesterCutPoint[5]);
            }
        });
        mListView8.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                Log.i("clicked on: ",courseTitles[position+48]);
                changeActivity(position+semesterCutPoint[6]);
            }
        });



    }//end of onCreate()

    //method for changing activity
    public void changeActivity(int pos){
        intent = new Intent(CourseActivity.this, CourseDetailActivity.class);
        message = allCourses[pos].getTitle();
        intent.putExtra("MESSAGE",message);
        intent.putExtra("SESSION", tappedSession);
        intent.putExtra("POSITION" ,pos);
        startActivity(intent);
    }

    //on back button clicked
    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }


    public Integer[] makeCumul(Integer[] in) {
        Integer[] out = new Integer[in.length];
        int total = 0;
        for (int i = 0; i < in.length; i++) {
            total += in[i];
            out[i] = total;
        }
        return out;
    }
}
