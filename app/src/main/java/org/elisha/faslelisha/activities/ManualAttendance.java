package org.elisha.faslelisha.activities;

import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.EditText;
import android.widget.Toast;

import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;
import org.elisha.faslelisha.R;

@EActivity(R.layout.activity_manual_attendance)
public class ManualAttendance extends AppCompatActivity {

    private static final String TAG = "FaslElisha";


    @ViewById(R.id.idEditTextAMA)
    EditText idEditText;

    private int boyId;

    @Click(R.id.manualAttendanceSubmitButtonAMA)
    void manualAttendanceSubmitBtnPressed() {
        try {
            if (idEditText != null) {
                boyId = Integer.parseInt(idEditText.getText().toString());
                org.elisha.faslelisha.activities.PointsHomeActivity_.intent(this).boyId(boyId).start();
            }else {
                Toast.makeText(this, "Please Enter an ID", Toast.LENGTH_SHORT).show();
            }
        } catch (Exception e) {
            Log.e(TAG,getClass().getName() + "=>bind", e);
        }
    }
}
