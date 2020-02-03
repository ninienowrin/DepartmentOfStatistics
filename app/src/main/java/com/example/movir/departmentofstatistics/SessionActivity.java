package com.example.movir.departmentofstatistics;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

public class SessionActivity extends AppCompatActivity {

    Intent intent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_session);

        //set toolbar and back button
        Toolbar toolbar = findViewById(R.id.sessionToolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);



    }


    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    public void changeActivity(View view) {
        TextView tappedSessionTextView = (TextView) view;
        String tag = tappedSessionTextView.getTag().toString();

//        intent = new Intent(this,CourseActivity.class);
//        intent.putExtra("MESSAGE",tag.toString());
//        startActivity(intent);

        if (tag.equals("session15")||tag.equals("session14")||tag.equals("session18")||tag.equals("session16")){
            intent = new Intent(this,CourseActivity.class);
            intent.putExtra("MESSAGE",tag.toString());
            startActivity(intent);

        }


    }
}
