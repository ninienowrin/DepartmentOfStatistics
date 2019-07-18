package com.example.movir.departmentofstatistics;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

public class InfoActivity extends AppCompatActivity {

    TextView infoText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        //set toolbar and back button
        Toolbar toolbar = findViewById(R.id.infoToolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        infoText = (TextView) findViewById(R.id.infoText);

        infoText.setText(info);
    }


    //on back button clicked
    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }


    String info = "Welcome to the Department of Statistics at Shahjalal University of Science and Technology. The department has started its academic journey in 1991. It is one of the largest concentrations of statistical research in the region with 25 faculty members and over 350 undergraduate and postgraduate students. The department possesses a dynamic research environment and offers a full range of undergraduate and postgraduate degrees (MS, M.Phil, and Ph.D) in statistics. We familiarize students with the probabilistic and statistical ideas and methods and their role in many fields of science, technology, business and social science. We provide instruction in the theory and commonly useful applications of techniques and offer advanced training through workshops and graduate programs. We have two well-equipped computer laboratories with complete network facility and a well-organized seminar library with sufficient books and journals. The department has an association, named ‘Parishankhan Paribar’, which organizes various cultural programs, sports, picnic, etc.";
}

