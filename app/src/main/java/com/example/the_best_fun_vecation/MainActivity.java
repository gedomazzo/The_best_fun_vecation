package com.example.the_best_fun_vecation;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

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
        if (temp.equals("Credints")) {
            Intent shaw = new Intent(this, MyActivityName.class);
            startActivity(shaw);
        }

        return super.onOptionsItemSelected(item);
    }



    public void What_type(View view) {
        final String[] fun_activities = {"museum", "ballet", "restaurant", "pub"};
        dtype = new AlertDialog.Builder(this);
        dtype.setTitle("type of vacation");
        dtype.setCancelable(false);


        dtype.setItems(fun_activities, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                t = fun_activities[which];
            }
        });


        dtype.show();
    }

    public void What_gear(View view) {
        final String[] fun_activities = {"drinks", "pillow", "snack", "fancy cloths"};

        dgear = new AlertDialog.Builder(this);
        dgear.setTitle("gear");
        dgear.setCancelable(false);
        dgear.setPositiveButton("ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });

        dgear.setNegativeButton("cansel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        dgear.setMultiChoiceItems(fun_activities, null, new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                if ((isChecked) && (!g.contains(fun_activities[which])))
                    g = g +fun_activities[which] + " ";
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
        dname.setCancelable(false);
        final EditText et = new EditText(this);
        et.setHint("type your name please");
        dname.setView(et);

        dname.setPositiveButton("ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which){
                n = et.getText().toString();
            }
        });

        dname.setNegativeButton("cansel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        dname.show();
    }



    public void Are_sure(View view) {
        dsure = new AlertDialog.Builder(this);
        dsure.setTitle("sure");
        dsure.setMessage("are you sure you want me to generate the vacation?");
        dsure.setCancelable(false);
        dsure.setPositiveButton("sure", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which){
                //txt.setText(t + "\n" + g + "\n" + n);
                txt.setText("you will go to the " + t + "\n" +
                         "you will take with you " + g + "\n" +
                        "congratulations " +n);
                dialog.dismiss();
            }
        });

        dsure.setNegativeButton("no no no", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which){
                dialog.cancel();
            }
        });

        dsure.show();



    }


}