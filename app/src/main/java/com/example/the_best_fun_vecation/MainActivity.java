package com.example.the_best_fun_vecation;

import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    TextView txt;

    Button type;
    String t;

    AlertDialog.Builder dtype;
    Button gear;
    String g = "";

    AlertDialog.Builder dgear;
    Button name;
    String n;

    AlertDialog.Builder dname;
    Button sure;
    String s;
    AlertDialog.Builder dsure;



    public void marriage(){
        type = findViewById(R.id.type);
        gear = findViewById(R.id.gear);
        name = findViewById(R.id.name);
        sure = findViewById(R.id.sure);
        txt = findViewById(R.id.txt);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        marriage();
    }


    public void What_type(View view) {
        final String[] fun_activities = {"museum", "ballet", "restaurant", "pub"};

        dtype = new AlertDialog.Builder(this);
        dtype.setTitle("type of vacation");


        dtype.setItems(fun_activities, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                t = fun_activities[which];
            }
        });


        dtype.show();
    }

    public void What_gear(View view) {
        final String[] fun_activities = {"museum", "ballet", "restaurant", "pub"};

        dgear = new AlertDialog.Builder(this);
        dgear.setTitle("gear");
        //dgear.setPositiveButton()

        dgear.setMultiChoiceItems(fun_activities, null, new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                if (isChecked)
                    g = g + " " + fun_activities[which];
                else {
                    g = g.replace(fun_activities[which], "");
                }
            }
        });

        dgear.show();
    }


    public void What_name(View view) {
        dname = new AlertDialog.Builder(this);
        dname.setTitle("name");

        dname.show();
    }

    public void Are_sure(View view) {
        dsure = new AlertDialog.Builder(this);
        dsure.setTitle("sure");

        dsure.show();

        txt.setText(t + "\n" + g + "\n" + n + "\n" + s);


    }


}