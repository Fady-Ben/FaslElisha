package org.elisha.faslelisha.activities;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.elisha.faslelisha.R;

@EActivity(R.layout.activity_manual_attendance)
public class ManualAttendance extends AppCompatActivity {

    private String name;

    private boolean dialogFlag=false;

    @AfterViews
    public void init(){

    }



    @Click(R.id.manualAttendanceSubmitButtonAMA)
    void manualAttendanceSubmitBtnPressed() {

        // 1. Instantiate an AlertDialog.Builder with its constructor
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        // 2. Chain together various setter methods to set the dialog characteristics
        builder.setMessage("Correct Name ?").setTitle("Boy Name");
        // 3. Get the AlertDialog from create()

        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                // User clicked OK button
                /*Intent intent = new Intent(this, Attendance.class);
                startActivity(intent);*/
            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                // User cancelled the dialog
            }
        });
        AlertDialog dialog = builder.create();
        dialog.show();

        if (dialogFlag){
            PointsHomeActivity_.intent(this).start();
        }
    }
}
