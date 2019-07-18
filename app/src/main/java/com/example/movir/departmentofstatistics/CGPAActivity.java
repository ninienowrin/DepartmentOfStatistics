package com.example.movir.departmentofstatistics;


import android.content.Context;
import android.content.SharedPreferences;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class CGPAActivity extends AppCompatActivity  {

    final String[] courseTitles = {"Probability","Principles Of Statsitics","Principles Of Statistics Lab","Algebra","English Language-1","Theory Of Statistics","Theory Of Statistics Lab","Sampling Techniques -1","Sampling Techniques -1 Lab","Calculus","Linear Algebra","Viva Voce","Regression Analysis-1","Regression Analysis-1 Lab","Advanced Calculus And Differential Equations","Principles Of Microeconomics","Advanced English","Advanced English Viva-Voce","Design And Analysis Of Experiments-1","Design And Analysis Of Experiments-1 Lab","Numerical Methods And Complex Variable","Real Analysis","Principles Of Macroeconomics","Viva Voce","Statistical Computing-1","Statistical Computing-1 Lab","Linear Programming","Linear Pogramming Lab","Statistical Inference","Statistical Inference Lab","Database Management And Programming","Database Management And Programming Lab","Demography","Demography Lab","Statistical Programming-2","Statistical Programming-2 Lab","Regression Analysis-2","Regression Analysis-2 Lab","Stochastic Processes","Viva Voce","Economic Statistics","Economic Statistics Lab","Applied Statistics","Applied Statistics Lab","Design And Analysis Of Experiments-2","Design And Analysis Of Experiments-2 Lab","Sampling Techniques-2","Sampling Techniques-2 Lab","Multivariate Analysis","Multivariate Analysis Lab","Biostatistics and Epidemiology","Biostatistics and Epidemiology  Lab","Applied Data Analysis","Applied Data Analysis Lab","Generalized Linear Models","Comprehensive (Optional)","Viva Voce"
    };

    Integer[] textVieID = {R.id.courseTitle1,R.id.courseTitle2,R.id.courseTitle3,R.id.courseTitle4,R.id.courseTitle5,R.id.courseTitle6,R.id.courseTitle7,R.id.courseTitle8,R.id.courseTitle9,R.id.courseTitle10,R.id.courseTitle11,R.id.courseTitle12,R.id.courseTitle13,R.id.courseTitle14,R.id.courseTitle15,R.id.courseTitle16,R.id.courseTitle17,R.id.courseTitle18,R.id.courseTitle19,R.id.courseTitle20,R.id.courseTitle21,R.id.courseTitle22,R.id.courseTitle23,R.id.courseTitle24,R.id.courseTitle25,R.id.courseTitle26,R.id.courseTitle27,R.id.courseTitle28,R.id.courseTitle29,R.id.courseTitle30,R.id.courseTitle31,R.id.courseTitle32,R.id.courseTitle33,R.id.courseTitle34,R.id.courseTitle35,R.id.courseTitle36,R.id.courseTitle37,R.id.courseTitle38,R.id.courseTitle39,R.id.courseTitle40,R.id.courseTitle41,R.id.courseTitle42,R.id.courseTitle43,R.id.courseTitle44,R.id.courseTitle45,R.id.courseTitle46,R.id.courseTitle47,R.id.courseTitle48,R.id.courseTitle49,R.id.courseTitle50,R.id.courseTitle51,R.id.courseTitle52,R.id.courseTitle53,R.id.courseTitle54,R.id.courseTitle55,R.id.courseTitle56,R.id.courseTitle57};

    Integer[] spinnerID = {R.id.spinner1,R.id.spinner2,R.id.spinner3,R.id.spinner4,R.id.spinner5,R.id.spinner6,R.id.spinner7,R.id.spinner8,R.id.spinner9,R.id.spinner10,R.id.spinner11,R.id.spinner12,R.id.spinner13,R.id.spinner14,R.id.spinner15,R.id.spinner16,R.id.spinner17,R.id.spinner18,R.id.spinner19,R.id.spinner20,R.id.spinner21,R.id.spinner22,R.id.spinner23,R.id.spinner24,R.id.spinner25,R.id.spinner26,R.id.spinner27,R.id.spinner28,R.id.spinner29,R.id.spinner30,R.id.spinner31,R.id.spinner32,R.id.spinner33,R.id.spinner34,R.id.spinner35,R.id.spinner36,R.id.spinner37,R.id.spinner38,R.id.spinner39,R.id.spinner40,R.id.spinner41,R.id.spinner42,R.id.spinner43,R.id.spinner44,R.id.spinner45,R.id.spinner46,R.id.spinner47,R.id.spinner48,R.id.spinner49,R.id.spinner50,R.id.spinner51,R.id.spinner52,R.id.spinner53,R.id.spinner54,R.id.spinner55,R.id.spinner56,R.id.spinner57};

    final Integer[] courseCredit = {4,3,2,2,2,3,2,3,2,3,3,2,3,2,3,3,2,1,3,2,3,3,3,2,2,2,3,2,3,2,2,3,3,2,3,2,3,2,4,2,3,2,3,2,3,2,3,1,3,2,3,2,2,3,3,4,2
    };

    //shared preference to remember spinner selection
    SharedPreferences spinnerSharedPref;

    Integer[] spinnerPosition = new Integer[58];

    String[] mSpinnerData = {"0","2.00","2.25","2.50","2.75","3.00","3.25","3.50","3.75","4.00"};

//    private static DecimalFormat df2 = new DecimalFormat(".##");

    ArrayList<Spinner> spinnerArray = new ArrayList<Spinner>();
    ArrayList<TextView> textViewArray = new ArrayList<TextView>();

    Integer totalCredit = 0;
    double cgpa = 0,sum = 0;

    TextView sumText,totalText;
    String[] spinnerValue = new String[58];



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cgpa);

        //set toolbar and back button
        Toolbar toolbar = findViewById(R.id.cgpaToolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);


        for (int i = 0;i<57;i++){
            textViewArray.add((TextView) findViewById(textVieID[i]));
        }
        for (int i = 0;i<57;i++){
            textViewArray.get(i).setText(courseTitles[i] + " ("+Integer.toString(courseCredit[i])+")");
        }
        for (int i = 0;i<57;i++){
            spinnerArray.add((Spinner) findViewById(spinnerID[i]));
        }

        sumText = (TextView)findViewById(R.id.sum);
        totalText = (TextView)findViewById(R.id.total);
        spinnerSharedPref = getSharedPreferences("com.example.movir.departmentofstatistics",Context.MODE_PRIVATE);

        //set Adapter for all spinners
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line,mSpinnerData);
        for (int i = 0;i<57;i++){
            spinnerArray.get(i).setAdapter(arrayAdapter);
        }

        arrayAdapter.notifyDataSetChanged();
//        value1 = listSpinner.get(0).getSelectedItem().toString();
//        value2 = listSpinner.get(1).getSelectedItem().toString();
//        sum.setText(Integer.toString(Integer.valueOf(value1)+Integer.valueOf(value2)));

        setSpinnerValue();
        setCGPA();

        sumText.setText(new DecimalFormat("##.##").format(cgpa));
        totalText.setText(totalCredit.toString());
//        sumText.setText(totalCredit.toString());



        for(int i = 0;i<57;i++){
            spinnerArray.get(i).setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//                    setSpinnerValue();
                    setCGPA();
                    getSpinnerValue();
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }
            });
        }



    }

    private void setCGPA() {
        cgpa = 0;
        totalCredit =0;
        sum = 0;
        for (int i = 0;i<57;i++){
            spinnerValue[i] = spinnerArray.get(i).getSelectedItem().toString();
        }
        for (int i=0;i<57;i++){
            if(Double.valueOf(spinnerValue[i]) !=0){
                totalCredit = totalCredit+courseCredit[i];
            }
        }

        for (int i = 0;i<57;i++) {
            sum = sum + ((Double.valueOf(spinnerValue[i])) * courseCredit[i]);
        }
        if(totalCredit!=0)
            cgpa = sum/totalCredit;
        else
            cgpa = 0;

        sumText.setText(new DecimalFormat("##.##").format(cgpa));
        totalText.setText(totalCredit.toString());
    }

    private void getSpinnerValue(){

        for (int i = 0;i<57;i++){
            spinnerSharedPref.edit().putInt("spinnerPosition"+i, spinnerArray.get(i).getSelectedItemPosition()).apply();
            Log.i("selected spinner pos: ", Integer.toString(spinnerSharedPref.getInt("spinnerPosition"+i,-1)));
        }

    }

    private void setSpinnerValue(){
        for (int i = 0;i<57;i++){
            spinnerPosition[i] = spinnerSharedPref.getInt("spinnerPosition"+i,-1);
        }
        for (int i = 0;i<57;i++){
            if(spinnerPosition[i] >= 0 ){
                spinnerArray.get(i).setSelection(spinnerPosition[i]);
            }
        }

    }

    public void resetSelection(View view){
//        for (int i = 0;i<57;i++){
//            spinnerPosition[i] = 0;
//        }
        for (int i = 0;i<57;i++){
            spinnerArray.get(i).setSelection(0);

        }
        cgpa = 0;
        totalCredit =0;
        sumText.setText(new DecimalFormat("##.##").format(cgpa));
        totalText.setText(totalCredit.toString());
    }

    //on back button clicked
    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

}

