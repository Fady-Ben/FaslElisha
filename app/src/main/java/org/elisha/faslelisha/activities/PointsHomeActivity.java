package org.elisha.faslelisha.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.androidannotations.annotations.AfterExtras;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.Extra;
import org.androidannotations.annotations.ViewById;
import org.elisha.faslelisha.R;
import org.elisha.faslelisha.models.Boy;

import static android.content.Intent.FLAG_ACTIVITY_CLEAR_TOP;

@EActivity(R.layout.activity_points_home)
public class PointsHomeActivity extends AppCompatActivity {

    private static final String TAG = "DatabaseMainActivity";

    @Extra
    protected int boyId;

    @Extra
    protected Class referrerActivityClass;

    @ViewById(R.id.boyNameTextViewAPH)
    protected TextView boyNameTextView;

    @ViewById(R.id.totalPointsAPH)
    protected TextView totalPointTextView;

    @ViewById(R.id.attendanceTextViewAPH)
    protected TextView attendanceTextView;

    @ViewById(R.id.alkodasCheckBoxAPH)
    protected CheckBox alkodasCheckBox;

    @ViewById(R.id.shamasCheckBoxAPH)
    protected CheckBox shamasCheckBox;

    @ViewById(R.id.asmElKdisCheckBoxAPH)
    protected CheckBox asmElKdisCheckBox;

    @ViewById(R.id.sertElKdisCheckBoxAPH)
    protected CheckBox sertElKdisCheckBox;

    @ViewById(R.id.alEngilCheckBoxAPH)
    protected CheckBox alEngilCheckBox;

    @ViewById(R.id.mawdo3AlEngilCheckBoxAPH)
    protected CheckBox mawdo3AlEngilCheckBox;

    @ViewById(R.id.hdorElFaslCheckBoxAPH)
    protected CheckBox hdorElFaslCheckBox;

    @ViewById(R.id.eltzamCheckBoxAPH)
    protected CheckBox eltzamCheckBox;

    @ViewById(R.id.hdo2FelFaslAPH)
    protected CheckBox hdo2FelFasl;

    @ViewById(R.id.submitButtonAPH)
    protected TextView submitButton;

    private int currentDayPoint = 1;
    private int pastPoints ;
    private int attendance ;

    @AfterExtras
    public void initView() {

        try {
            FirebaseDatabase.getInstance().getReference().child("Boys").child(String.valueOf(boyId))
                    .addListenerForSingleValueEvent(new ValueEventListener() {


                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {

                            Boy boy = dataSnapshot.getValue(Boy.class);
                            Log.i(TAG, "Boys data = " + dataSnapshot.getValue(Boy.class));
                            boyNameTextView.setText("Name = " + boy.getName());
                            totalPointTextView.setText("Total Tayo = " + boy.getTotalPoints()+ " Tayo");
                            attendanceTextView.setText("Attendance = " + boy.getAttendance()+" Times");
                            pastPoints = boy.getTotalPoints();
                            attendance = boy.getAttendance();

                        }

                        @Override
                        public void onCancelled(DatabaseError error) {
                            // Failed to read value
                            Log.w(TAG, "Failed to read value.", error.toException());
                            Toast.makeText(getApplicationContext(), "Failed to read value", Toast.LENGTH_SHORT).show();
                        }
                    });

        } catch (Exception e) {

        }
    }

    protected int calcualtePoints() {
        try {
            if (alkodasCheckBox.isChecked()) {
                currentDayPoint++;
            }
            if (shamasCheckBox.isChecked()) {
                currentDayPoint++;
            }
            if (asmElKdisCheckBox.isChecked()) {
                currentDayPoint++;
            }
            if (sertElKdisCheckBox.isChecked()) {
                currentDayPoint += 2;
            }
            if (alEngilCheckBox.isChecked()) {
                currentDayPoint++;
            }
            if (mawdo3AlEngilCheckBox.isChecked()) {
                currentDayPoint += 2;
            }
            if (hdorElFaslCheckBox.isChecked()) {
                currentDayPoint++;
            }
            if (eltzamCheckBox.isChecked()) {
                currentDayPoint++;
            }
            if (hdo2FelFasl.isChecked()) {
                currentDayPoint++;
            }
            if (hdo2FelFasl.isChecked()) {
                currentDayPoint++;
            }

            return currentDayPoint;
        } catch (Exception e) {
            return 0;
        }
    }

    @Click(R.id.submitButtonAPH)
    void submitButtonPressed() {

        DatabaseReference database;
        database = FirebaseDatabase.getInstance().getReference();
        database.child("Boys").child(String.valueOf(boyId)).child("totalPoints").setValue(pastPoints + calcualtePoints());

        database.child("Boys").child(String.valueOf(boyId)).child("attendance").setValue(++attendance);

        referrerActivityClass = org.elisha.faslelisha.activities.MainActivity_.class;
        Intent intent = new Intent(this, referrerActivityClass);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK | FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }

}
