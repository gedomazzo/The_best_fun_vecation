package com.example.the_best_fun_vecation;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

/**
 * The main activity for the Fun Vacation Planner application.
 * This screen allows the user to plan their evening by making several choices
 * through interactive dialogs.
 * @author benjamin rogachevsky
 * @version 1.0
 * @since 1/7/26
 */
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

    /**
     * Initializes and links the UI components from the XML layout.
     * <p>
     * This method finds each UI element by its ID and assigns it to the corresponding class variable.
     *
     */
    public void marriage() {
        type = findViewById(R.id.type);
        gear = findViewById(R.id.gear);
        name = findViewById(R.id.name);
        sure = findViewById(R.id.sure);
        txt = findViewById(R.id.txt);
    }

    /**
     * Called when the activity is first created.
     * <p>
     *  This is where the layout is set and the UI components are initialized.
     * @param savedInstanceState If the activity is being re-initialized after previously being shut down then this Bundle contains the data it most recently supplied in onSaveInstanceState(Bundle).
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        marriage();
    }

    /**
     * Initializes the contents of the Activity's options menu.
     * <p>
     * This is only called once, the first time the options menu is displayed.
     * @param menu The options menu in which you place your items.
     * @return You must return true for the menu to be displayed; if you return false it will not be shown.
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    /**
     * Handles clicks on the options menu items.
     * <p>
     * This method is called whenever an item in the options menu is selected.
     * @param item The menu item that was selected.
     * @return boolean Return false to allow normal menu processing to proceed, true to consume it here.
     */
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        String temp = item.getTitle().toString();
        if (temp.equals("Credits")) {
            Intent shaw = new Intent(this, MyActivityName.class);
            startActivity(shaw);
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * Displays a dialog to select the type of vacation.
     * <p>
     * When a button is clicked, this method shows a single-choice dialog with predefined vacation types.
     * @param view The button view that was clicked.
     */
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

    /**
     * Displays a dialog for selecting gear.
     * <p>
     * This method shows a multi-choice dialog, allowing the user to select multiple items.
     * @param view The button view that was clicked.
     */
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

    /**
     * Displays a dialog for the user to enter their name.
     * <p>
     * Shows a dialog containing an EditText field for text input.
     * @param view The button view that was clicked.
     */
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

    /**
     * Displays a confirmation dialog to finalize or reset the plan.
     * <p>
     * This dialog gives the user three options: confirm and generate the plan, reset all choices, or cancel.
     * @param view The button view that was clicked.
     */
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

        dsure.setNeutralButton("reset", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which){
                //txt.setText(t + "\n" + g + "\n" + n);
                txt.setText("");
                t = "";
                g = "";
                n = "";

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
