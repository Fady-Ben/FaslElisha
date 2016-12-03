package org.elisha.faslelisha.activities;

import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;

import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;
import org.elisha.faslelisha.R;
import org.elisha.faslelisha.models.Boy;

@EActivity(R.layout.activity_manual_attendance)
public class ManualAttendance extends AppCompatActivity {

    @ViewById(R.id.idEditTextAMA)
    EditText idEditText;

    private int boyId;

    @Click(R.id.manualAttendanceSubmitButtonAMA)
    void manualAttendanceSubmitBtnPressed() {

        if (idEditText != null) {
            boyId=Integer.parseInt(idEditText.getText().toString());
            org.elisha.faslelisha.activities.PointsHomeActivity_.intent(this).boyId(boyId).start();

        }
    }
}
