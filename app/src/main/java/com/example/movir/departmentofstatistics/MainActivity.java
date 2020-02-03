package com.example.movir.departmentofstatistics;

import android.content.Intent;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mToggle;
    private android.support.v7.widget.Toolbar toolbar;
    Intent myIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mDrawerLayout = (DrawerLayout)findViewById(R.id.drawerlayout);
        mToggle = new ActionBarDrawerToggle(this,mDrawerLayout,R.string.open,R.string.close);
        toolbar = (android.support.v7.widget.Toolbar) findViewById(R.id.toolbarid);
        setSupportActionBar(toolbar);
        mDrawerLayout.addDrawerListener(mToggle);
        mToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        //Navigation drawer Item click listener

        NavigationView navigationView = (NavigationView) findViewById(R.id.navigationView);
        navigationView.setNavigationItemSelectedListener(this);


        //change color of drawer toggle
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            mToggle.getDrawerArrowDrawable().setColor(getColor(R.color.drawer_toggle_color));
        } else {
            mToggle.getDrawerArrowDrawable().setColor(getResources().getColor(R.color.drawer_toggle_color));
        }

    }


    public void changeActivity(View view){
        LinearLayout tappedView  = (LinearLayout) view;
        String tag = tappedView.getTag().toString();
        Log.i("clicked on", tag);

        if(tag.equals("info")){
            myIntent = new Intent(this, InfoActivity.class);
            startActivity(myIntent);
        }

        if(tag.equals("faculty")){
            myIntent = new Intent(this, FacultyActivity.class);
            startActivity(myIntent);
        }
        if(tag.equals("course")){
            myIntent = new Intent(this, SessionActivity.class);
            startActivity(myIntent);
        }
        if(tag.equals("web")){
            myIntent = new Intent(this, WebActivity.class);
            startActivity(myIntent);
        }
        if(tag.equals("cgpa")){
            myIntent = new Intent(this, CGPAActivity.class);
            startActivity(myIntent);
        }


    }

    //drawer toggle click
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(mToggle.onOptionsItemSelected(item)){
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu,menu);
        return true;
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        // Handle navigation view item clicks.
        switch (item.getItemId()) {

            case R.id.departmentMenu:{

                myIntent = new Intent(this, InfoActivity.class);
                startActivity(myIntent);
                break;
            }

            case R.id.facultyMenu: {
                myIntent = new Intent(this, FacultyActivity.class);
                startActivity(myIntent);
                break;
            }
            case R.id.courseMenu: {
                myIntent = new Intent(this, SessionActivity.class);
                startActivity(myIntent);
                break;
            }
            case R.id.cgpaMenu: {
                myIntent = new Intent(this, CGPAActivity.class);
                startActivity(myIntent);
                break;
            }
            case R.id.webMenu: {
                myIntent = new Intent(this, WebActivity.class);
                startActivity(myIntent);
                break;
            }
        }
        //close navigation drawer
        mDrawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }
}
