package com.example.movir.departmentofstatistics;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

public class CourseDetailActivity extends AppCompatActivity {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_detail);

        //set toolbar and back button
        Toolbar toolbar = findViewById(R.id.courseDetailToolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        TextView messageText = (TextView) findViewById(R.id.messageText);
        TextView codeText = (TextView) findViewById(R.id.codeText);
        TextView crediText = (TextView) findViewById(R.id.creditText);
        TextView contentText = (TextView) findViewById(R.id.contentText);
        TextView booksRecommended= (TextView) findViewById(R.id.booksRecommended);
//        TextView referenceBooks = (TextView) findViewById(R.id.referenceBooks);

        Intent intent = getIntent();
        String message = intent.getStringExtra("MESSAGE");
        int position = intent.getIntExtra("POSITION",58);
        codeText.setText(CourseActivity.courseCode[position]);
        crediText.setText(CourseActivity.courseCredit[position].toString());

        contentText.setText(DetailsText.contents[position]);
        booksRecommended.setText(DetailsText.booksRecommended[position]);
//        referenceBooks.setText(DetailsText.referenceBooks[position]);
        messageText.setText(message);


    }


    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
