package com.example.the_best_fun_vecation;

import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

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
}