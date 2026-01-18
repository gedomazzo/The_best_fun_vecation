package com.example.the_best_fun_vecation;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    TextView txt;

    Button type;
    String t = "";

    AlertDialog.Builder dtype;
    Button gear;
    String g = "";

    AlertDialog.Builder dgear;
    Button name;
    String n = "";

    AlertDialog.Builder dname;
    Button sure;
    AlertDialog.Builder dsure;





    AlertDialog test;
    LinearLayout test_dialog;
    EditText eTName;

    public void marriage() {
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


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        String temp = item.getTitle().toString();
        if (temp.equals("Credits")) {
            Intent shaw = new Intent(this, MyActivityName.class);
            startActivity(shaw);
        }

        return super.onOptionsItemSelected(item);
    }

    public void What_type(View view) {

        test_dialog = (LinearLayout) getLayoutInflater().inflate(R.layout.test_dialog, null);
        eTName = (EditText) test_dialog.findViewById(R.id.eTName);


        dtype = new AlertDialog.Builder(this);

        dtype.setView(test_dialog);
        dtype.setTitle("Choose type");
        dtype.show();

    }

    public void What_gear(View view) {

    }


    public void What_name(View view) {

    }


    public void Are_sure(View view) {

    }
}
