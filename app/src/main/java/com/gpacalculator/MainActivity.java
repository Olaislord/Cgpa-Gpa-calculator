package com.gpacalculator;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    final Context context = this;

    private Button btnSubmit,btn_list_course,btn_list_course2;

    // grades
    private Spinner grade1,grade2,grade3,grade4,grade5,grade6,grade7,grade8,grade9,grade10,grade11,grade12,grade13,grade14,grade15,grade16,grade17,grade18,grade19,grade20;
    private double vgrade1=0.0,vgrade2=0.0,vgrade3=0.0,vgrade4=0.0,vgrade5=0.0,vgrade6=0.0,vgrade7=0.0,vgrade8=0.0,vgrade9=0.0,vgrade10=0.0,vgrade11=0.0,vgrade12=0.0,vgrade13=0.0,vgrade14=0.0,vgrade15=0.0,vgrade16=0.0,vgrade17=0.0,vgrade18=0.0,vgrade19=0.0,vgrade20=0.0;

    // store Credit value of credit Hours
    private Spinner hour1,hour2,hour3,hour4,hour5,hour6,hour7,hour8,hour9,hour10,hour11,hour12,hour13,hour14,hour15,hour16,hour17,hour18,hour19,hour20;
    private double vhour1=0.0,vhour2=0.0,vhour3=0.0,vhour4=0.0,vhour5=0.0,vhour6=0.0,vhour7=0.0,vhour8=0.0,vhour9=0.0,vhour10=0.0,vhour11=0.0,vhour12=0.0,vhour13=0.0,vhour14=0.0,vhour15=0.0,vhour16=0.0,vhour17=0.0,vhour18=0.0,vhour19=0.0,vhour20=0.0;

    // stands for Grade Point (Pointer x Credit Hour)
    private double gpoint1=0.0,gpoint2=0.0,gpoint3=0.0,gpoint4=0.0,gpoint5=0.0,gpoint6=0.0,gpoint7=0.0,gpoint8=0.0,gpoint9=0.0,gpoint10=0.0,gpoint11=0.0,gpoint12=0.0,gpoint13=0.0,gpoint14=0.0,gpoint15=0.0,gpoint16=0.0,gpoint17=0.0,gpoint18=0.0,gpoint19=0.0,gpoint20=0.0;


    // store last semester CGPA , Total Credit Hours & Grade Points
    public EditText lastCGPA,lastchour;
    private double lastgpoint = 0.0;


    private double currentpoint = 0.0;
    private double currentHour = 0.0;

    // store final grades/points etc.
    private double finalgpoint = 0.0;
    private double finalGPA = 0.0;
    private double finalCGPA = 0.0;
    private double finalchour = 0.0;

    private static final int DIALOG_ALERT = 10;
    private String info;

    AutoCompleteTextView edittext_course1,edittext_course2,edittext_course3,edittext_course4,edittext_course5,edittext_course6,edittext_course7,edittext_course8,edittext_course9,edittext_course10,edittext_course11;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addListenerOnButton();
        gpa ();


    }

    public void gpa () {
        String[] course = getResources().getStringArray(R.array.course);

        edittext_course1 = (AutoCompleteTextView) findViewById(R.id.act_1);
        ArrayAdapter<String> adapter_course1 = new ArrayAdapter<String>(this,
                R.layout.gpa_list_item, R.id.gpa_list_item, course);
        edittext_course1.setAdapter(adapter_course1);

        edittext_course2 = (AutoCompleteTextView) findViewById(R.id.act_2);
        ArrayAdapter<String> adapter_course2 = new ArrayAdapter<String>(this,
                R.layout.gpa_list_item, R.id.gpa_list_item, course);
        edittext_course2.setAdapter(adapter_course2);

        edittext_course3 = (AutoCompleteTextView) findViewById(R.id.act_3);
        ArrayAdapter<String> adapter_course3 = new ArrayAdapter<String>(this,
                R.layout.gpa_list_item, R.id.gpa_list_item, course);
        edittext_course3.setAdapter(adapter_course3);

        edittext_course4 = (AutoCompleteTextView) findViewById(R.id.act_4);
        ArrayAdapter<String> adapter_course4 = new ArrayAdapter<String>(this,
                R.layout.gpa_list_item, R.id.gpa_list_item, course);
        edittext_course4.setAdapter(adapter_course4);

        edittext_course5 = (AutoCompleteTextView) findViewById(R.id.act_5);
        ArrayAdapter<String> adapter_course5 = new ArrayAdapter<String>(this,
                R.layout.gpa_list_item, R.id.gpa_list_item, course);
        edittext_course5.setAdapter(adapter_course5);

        edittext_course6 = (AutoCompleteTextView) findViewById(R.id.act_6);
        ArrayAdapter<String> adapter_course6 = new ArrayAdapter<String>(this,
                R.layout.gpa_list_item, R.id.gpa_list_item, course);
        edittext_course6.setAdapter(adapter_course6);

        edittext_course7 = (AutoCompleteTextView) findViewById(R.id.act_7);
        ArrayAdapter<String> adapter_course7 = new ArrayAdapter<String>(this,
                R.layout.gpa_list_item, R.id.gpa_list_item, course);
        edittext_course7.setAdapter(adapter_course7);

        edittext_course8 = (AutoCompleteTextView) findViewById(R.id.act_8);
        ArrayAdapter<String> adapter_course8 = new ArrayAdapter<String>(this,
                R.layout.gpa_list_item, R.id.gpa_list_item, course);
        edittext_course8.setAdapter(adapter_course8);

        edittext_course9 = (AutoCompleteTextView) findViewById(R.id.act_9);
        ArrayAdapter<String> adapter_course9 = new ArrayAdapter<String>(this,
                R.layout.gpa_list_item, R.id.gpa_list_item, course);
        edittext_course9.setAdapter(adapter_course9);

        edittext_course10 = (AutoCompleteTextView) findViewById(R.id.act_10);
        ArrayAdapter<String> adapter_course10 = new ArrayAdapter<String>(this,
                R.layout.gpa_list_item, R.id.gpa_list_item, course);
        edittext_course10.setAdapter(adapter_course10);

        edittext_course11 = (AutoCompleteTextView) findViewById(R.id.act_11);
        ArrayAdapter<String> adapter_course11 = new ArrayAdapter<String>(this,
                R.layout.gpa_list_item, R.id.gpa_list_item, course);
        edittext_course11.setAdapter(adapter_course11);

    }

    public void addListenerOnButton() {

        btnSubmit = (Button) findViewById(R.id.calculate);

        btnSubmit.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                // retrieve all required Value
                retrieve();

                // calculate all values needed
                Calculate();

                // make Pop up using Builder
                showDialog(DIALOG_ALERT);

            }

        });

    }

    public void retrieve(){

        //retrieve Grades
        grade1 = (Spinner) findViewById(R.id.spinner1);
        grade2 = (Spinner) findViewById(R.id.spinner2);
        grade3 = (Spinner) findViewById(R.id.spinner3);
        grade4 = (Spinner) findViewById(R.id.spinner4);
        grade5 = (Spinner) findViewById(R.id.spinner5);
        grade6 = (Spinner) findViewById(R.id.spinner6);
        grade7 = (Spinner) findViewById(R.id.spinner7);
        grade8 = (Spinner) findViewById(R.id.spinner8);
        grade9 = (Spinner) findViewById(R.id.spinner9);
        grade10 = (Spinner) findViewById(R.id.spinner10);
        grade11 = (Spinner) findViewById(R.id.spinner11);
    
        // retrieve Credit Hours
        hour1 = (Spinner) findViewById(R.id.chour1);
        hour2 = (Spinner) findViewById(R.id.chour2);
        hour3 = (Spinner) findViewById(R.id.chour3);
        hour4 = (Spinner) findViewById(R.id.chour4);
        hour5 = (Spinner) findViewById(R.id.chour5);
        hour6 = (Spinner) findViewById(R.id.chour6);
        hour7 = (Spinner) findViewById(R.id.chour7);
        hour8 = (Spinner) findViewById(R.id.chour8);
        hour9 = (Spinner) findViewById(R.id.chour9);
        hour10 = (Spinner) findViewById(R.id.chour10);
        hour11 = (Spinner) findViewById(R.id.chour11);


        // retrieve the selected value of the grade & convert it to equivalent pointer
        vgrade1 = convertGrade(String.valueOf(grade1.getSelectedItem()));
        vgrade2 = convertGrade(String.valueOf(grade2.getSelectedItem()));
        vgrade3 = convertGrade(String.valueOf(grade3.getSelectedItem()));
        vgrade4 = convertGrade(String.valueOf(grade4.getSelectedItem()));
        vgrade5 = convertGrade(String.valueOf(grade5.getSelectedItem()));
        vgrade6 = convertGrade(String.valueOf(grade6.getSelectedItem()));
        vgrade7 = convertGrade(String.valueOf(grade7.getSelectedItem()));
        vgrade8 = convertGrade(String.valueOf(grade8.getSelectedItem()));
        vgrade9 = convertGrade(String.valueOf(grade9.getSelectedItem()));
        vgrade10 = convertGrade(String.valueOf(grade10.getSelectedItem()));
        vgrade11 = convertGrade(String.valueOf(grade11.getSelectedItem()));


        // retrieve the selected value of Credit hour & convert it to number(Double)
        vhour1 = convertDouble(String.valueOf(hour1.getSelectedItem()));
        vhour2 = convertDouble(String.valueOf(hour2.getSelectedItem()));
        vhour3 = convertDouble(String.valueOf(hour3.getSelectedItem()));
        vhour4 = convertDouble(String.valueOf(hour4.getSelectedItem()));
        vhour5 = convertDouble(String.valueOf(hour5.getSelectedItem()));
        vhour6 = convertDouble(String.valueOf(hour6.getSelectedItem()));
        vhour7 = convertDouble(String.valueOf(hour7.getSelectedItem()));
        vhour8 = convertDouble(String.valueOf(hour8.getSelectedItem()));
        vhour9 = convertDouble(String.valueOf(hour9.getSelectedItem()));
        vhour10 = convertDouble(String.valueOf(hour10.getSelectedItem()));
        vhour11 = convertDouble(String.valueOf(hour11.getSelectedItem()));


    }

    public void Calculate(){

        // Calculate value of Grade Point for each subject
        gpoint1 = vgrade1*vhour1;
        gpoint2 = vgrade2*vhour2;
        gpoint3 = vgrade3*vhour3;
        gpoint4 = vgrade4*vhour4;
        gpoint5 = vgrade5*vhour5;
        gpoint6 = vgrade6*vhour6;
        gpoint7 = vgrade7*vhour7;
        gpoint8 = vgrade8*vhour8;
        gpoint9 = vgrade9*vhour9;
        gpoint10 = vgrade10*vhour10;
        gpoint11 = vgrade11*vhour11;


        // retrieve Last semester CGPA and Total Credit Hours
        lastCGPA = (EditText) findViewById(R.id.currentCGPA);
        lastchour = (EditText) findViewById(R.id.currentCredit);


        // To find Grade Points for last semester
        // CGPA = lastgpoint/lastchour
        lastgpoint = convertDouble((lastCGPA.getText().toString())) * convertDouble((lastchour.getText().toString())) ;


        // To find Grade Points for current semester
        currentpoint =  gpoint1 + gpoint2 + gpoint3 + gpoint4 + gpoint5 + gpoint6 + gpoint7 + gpoint8 + gpoint9 + gpoint10 + gpoint11 ;
        // To find Credit Hours for this semester
        currentHour = vhour1 + vhour2 + vhour3 + vhour4 + vhour5 + vhour6 + vhour7 + vhour8 + vhour9 + vhour10 + vhour11 ;


        // To find Accumulated Grade Points (Current Points + Previous Points)
        finalgpoint += currentpoint + lastgpoint;
        // To find Accumulated Credit Hours (Current cHours + Previous cHours)
        finalchour +=  currentHour + convertDouble((lastchour.getText().toString()));

        // To find final GPA
        finalGPA = currentpoint /  currentHour;

        // To find final CGPA
        // CGPA = Total Accumulated Points / Total Accumulated Credit Hours
        finalCGPA= finalgpoint/finalchour;

    }


    // function for converting Grade to equivalent pointer
    public double convertGrade(String grade){
        double cgrade = 0.0;

        if(grade.equals("A")){
            cgrade = 5.0;
        } else if(grade.equals("B")) {
            cgrade = 4.0;
        } else if(grade.equals("C")){
            cgrade = 3.0;
        } else if(grade.equals("D")){
            cgrade = 2.0;
        } else if(grade.equals("E")) {
            cgrade = 1.0;
        } else if(grade.equals("F")) {
            cgrade = 0.0;
        } else {
            cgrade = 0.0;
        }

        return cgrade;
    }


    // function for converting string to Double.
    // bcoz Double.parseDouble seems to crashing the system, thus need to make own function
    public double convertDouble(String hour){
        double chour = 0.0;

        try {
            String eAm = hour;
            DecimalFormat dF = new DecimalFormat("0.00");
            Number num = dF.parse(eAm);
            chour = num.doubleValue();
        } catch (Exception e) {
            chour = 0.0;
        }

        return chour;
    }


    // Pop Up Starts Here

   // AutoCompleteTextView edit_cos = findViewById(R.id.act_1);

    // Handling all the Pop Up Dialog Elements
    @Override
    protected Dialog onCreateDialog(int id) {
        switch (id) {
            case DIALOG_ALERT:
                // Create out AlterDialog
                AlertDialog.Builder builder = new AlertDialog.Builder(this);

                final Dialog dialog = new Dialog(this);
                dialog.setContentView(R.layout.gpa_dialog);

                DecimalFormat df = new DecimalFormat("0.00");
                DecimalFormat nf = new DecimalFormat("0");

                // set the custom dialog components - text, image and button
                TextView pre_cgpa = (TextView) dialog.findViewById(R.id.pre_cgpa);

                TextView pre_cgpa_score = (TextView) dialog.findViewById(R.id.pre_cgpa_score);
                pre_cgpa_score.setText((lastCGPA.getText().toString()));

                TextView total_cu = (TextView) dialog.findViewById(R.id.total_cu);

                TextView total_cu_score = (TextView) dialog.findViewById(R.id.total_cu_score);
                total_cu_score.setText(nf.format(finalchour));

                TextView total_gp = (TextView) dialog.findViewById(R.id.total_gp);

                TextView total_gp_score = (TextView) dialog.findViewById(R.id.total_gp_score);
                total_gp_score.setText(df.format(finalgpoint));

                TextView gpa = (TextView) dialog.findViewById(R.id.gpa);

                TextView gpa_score = (TextView) dialog.findViewById(R.id.gpa_score);
                gpa_score.setText(df.format(finalGPA));

                TextView cgpa = (TextView) dialog.findViewById(R.id.cgpa);

                TextView cgpa_score = (TextView) dialog.findViewById(R.id.cgpa_score);
                cgpa_score.setText(df.format(finalCGPA));

                TextView text_title = (TextView) dialog.findViewById(R.id.custom_title);

                //GPA List Course
                TextView cos1 = dialog.findViewById(R.id.cos1);
                TextView cos2 = dialog.findViewById(R.id.cos2);
                TextView cos3 = dialog.findViewById(R.id.cos3);
                TextView cos4 = dialog.findViewById(R.id.cos4);
                TextView cos5 = dialog.findViewById(R.id.cos5);
                TextView cos6 = dialog.findViewById(R.id.cos6);
                TextView cos7 = dialog.findViewById(R.id.cos7);
                TextView cos8 = dialog.findViewById(R.id.cos8);
                TextView cos9 = dialog.findViewById(R.id.cos9);
                TextView cos10 = dialog.findViewById(R.id.cos10);
                TextView cos11 = dialog.findViewById(R.id.cos11);
                cos1.setText(edittext_course1.getText().toString());
                cos2.setText(edittext_course2.getText().toString());
                cos3.setText(edittext_course3.getText().toString());
                cos4.setText(edittext_course4.getText().toString());
                cos5.setText(edittext_course5.getText().toString());
                cos6.setText(edittext_course6.getText().toString());
                cos7.setText(edittext_course7.getText().toString());
                cos8.setText(edittext_course8.getText().toString());
                cos9.setText(edittext_course9.getText().toString());
                cos10.setText(edittext_course10.getText().toString());
                cos11.setText(edittext_course11.getText().toString());

                //GPA List Grade
                TextView gra1 = dialog.findViewById(R.id.gra1);
                TextView gra2 = dialog.findViewById(R.id.gra2);
                TextView gra3 = dialog.findViewById(R.id.gra3);
                TextView gra4 = dialog.findViewById(R.id.gra4);
                TextView gra5 = dialog.findViewById(R.id.gra5);
                TextView gra6 = dialog.findViewById(R.id.gra6);
                TextView gra7 = dialog.findViewById(R.id.gra7);
                TextView gra8 = dialog.findViewById(R.id.gra8);
                TextView gra9 = dialog.findViewById(R.id.gra9);
                TextView gra10 = dialog.findViewById(R.id.gra10);
                TextView gra11= dialog.findViewById(R.id.gra11);
                gra1.setText(grade1.getSelectedItem().toString());
                gra2.setText(grade2.getSelectedItem().toString());
                gra3.setText(grade3.getSelectedItem().toString());
                gra4.setText(grade4.getSelectedItem().toString());
                gra5.setText(grade5.getSelectedItem().toString());
                gra6.setText(grade6.getSelectedItem().toString());
                gra7.setText(grade7.getSelectedItem().toString());
                gra8.setText(grade8.getSelectedItem().toString());
                gra9.setText(grade9.getSelectedItem().toString());
                gra10.setText(grade10.getSelectedItem().toString());
                gra11.setText(grade11.getSelectedItem().toString());

                // GPA list Unit
                TextView uni1 = dialog.findViewById(R.id.uni1);
                TextView uni2 = dialog.findViewById(R.id.uni2);
                TextView uni3 = dialog.findViewById(R.id.uni3);
                TextView uni4 = dialog.findViewById(R.id.uni4);
                TextView uni5 = dialog.findViewById(R.id.uni5);
                TextView uni6 = dialog.findViewById(R.id.uni6);
                TextView uni7 = dialog.findViewById(R.id.uni7);
                TextView uni8 = dialog.findViewById(R.id.uni8);
                TextView uni9 = dialog.findViewById(R.id.uni9);
                TextView uni10 = dialog.findViewById(R.id.uni10);
                TextView uni11 = dialog.findViewById(R.id.uni11);
                uni1.setText(hour1.getSelectedItem().toString());
                uni2.setText(hour2.getSelectedItem().toString());
                uni3.setText(hour3.getSelectedItem().toString());
                uni4.setText(hour4.getSelectedItem().toString());
                uni5.setText(hour5.getSelectedItem().toString());
                uni6.setText(hour6.getSelectedItem().toString());
                uni7.setText(hour7.getSelectedItem().toString());
                uni8.setText(hour8.getSelectedItem().toString());
                uni9.setText(hour9.getSelectedItem().toString());
                uni10.setText(hour10.getSelectedItem().toString());
                uni11.setText(hour11.getSelectedItem().toString());

                btn_list_course = dialog.findViewById(R.id.btn_list_course);
                btn_list_course.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        LinearLayout lin_gpa = dialog.findViewById(R.id.lin_gpa_result);
                        lin_gpa.setVisibility(View.VISIBLE);
                        btn_list_course.setVisibility(View.GONE);
                        btn_list_course2.setVisibility(View.VISIBLE);

                    }
                });

                btn_list_course2 = dialog.findViewById(R.id.btn_list_course2);
                btn_list_course2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        LinearLayout lin_gpa = dialog.findViewById(R.id.lin_gpa_result);
                        lin_gpa.setVisibility(View.GONE);
                        btn_list_course.setVisibility(View.VISIBLE);
                        btn_list_course2.setVisibility(View.GONE);

                    }
                });

                Button btn_check_again = (Button) dialog.findViewById(R.id.btn_check_again);
                // if button is clicked, close the custom dialog
                btn_check_again.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                        reset();

                        Toast.makeText(getApplicationContext(), "Calculate Another CGPA :)",
                                Toast.LENGTH_SHORT).show();
                    }
                });

                Button btn_exit = (Button) dialog.findViewById(R.id.btn_exit);
                // if button is clicked, close the custom dialog
                btn_exit.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                        finish();
                    }
                });

                dialog.show();

        }
        return super.onCreateDialog(id);
    }

    private final class backListener implements
            DialogInterface.OnClickListener {
        public void onClick(DialogInterface dialog, int which) {
            reset();

            Toast.makeText(getApplicationContext(), "Calculate Another CGPA :)",
                    Toast.LENGTH_SHORT).show();
        }
    }

    private final class exitListener implements
            DialogInterface.OnClickListener {
        public void onClick(DialogInterface dialog, int which) {
            MainActivity.this.finish();
        }
    }

    // Pop Up Stops Here
    // function to reset all the value if the user choose to Go Back
    private void reset(){
        vgrade1=0.0;vgrade2=0.0;vgrade3=0.0;vgrade4=0.0;vgrade5=0.0;vgrade6=0.0;vgrade7=0.0;vgrade8=0.0;vgrade9=0.0;vgrade10=0.0;vgrade11=0.0;vgrade12=0.0;vgrade13=0.0;vgrade14=0.0;vgrade15=0.0;vgrade16=0.0;vgrade17=0.0;vgrade18=0.0;vgrade19=0.0;vgrade20=0.0;

        vhour1=0.0;vhour2=0.0;vhour3=0.0;vhour4=0.0;vhour5=0.0;vhour6=0.0;vhour7=0.0;vhour8=0.0;vhour9=0.0;vhour10=0.0;vhour11=0.0;vhour12=0.0;vhour13=0.0;vhour14=0.0;vhour15=0.0;vhour16=0.0;vhour17=0.0;vhour18=0.0;vhour19=0.0;vhour20=0.0;

        gpoint1=0.0;gpoint2=0.0;gpoint3=0.0;gpoint4=0.0;gpoint5=0.0;gpoint6=0.0;gpoint7=0.0;gpoint8=0.0;gpoint9=0.0;gpoint10=0.0;gpoint11=0.0;gpoint12=0.0;gpoint13=0.0;gpoint14=0.0;gpoint15=0.0;gpoint16=0.0;gpoint17=0.0;gpoint18=0.0;gpoint19=0.0;gpoint20=0.0;

        lastgpoint = 0.0;

        currentpoint = 0.0;
        currentHour = 0.0;

        finalgpoint = 0.0;
        finalGPA = 0.0;
        finalCGPA = 0.0;
        finalchour = 0.0;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.help){
           // custom dialog
            final Dialog dialog = new Dialog(context);
            dialog.setContentView(R.layout.gpa_htu);
            dialog.show();

        }

        return super.onOptionsItemSelected(item);
    }

}
