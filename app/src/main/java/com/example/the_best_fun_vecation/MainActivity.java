package com.example.the_best_fun_vecation;

import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    final String[] colors = {"red", "green", "blue"};

    Button type;
    String t;

    AlertDialog.Builder dtype;
    Button gear;
    String g;

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
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        marriage();
    }


    public void What_type(View view) {
        int [] color = new int[]{0, 0, 0};

        dtype = new AlertDialog.Builder(this);
        dtype.setTitle("type of vacation");


        dtype.setItems(colors, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                color[which] = 255;
                getWindow().getDecorView().setBackgroundColor(Color.rgb(color[0], color[1], color[2]));
            }
        });


        dtype.show();
    }

    public void What_gear(View view) {
        dgear = new AlertDialog.Builder(this);
        dgear.setTitle("gear");

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
    }


}