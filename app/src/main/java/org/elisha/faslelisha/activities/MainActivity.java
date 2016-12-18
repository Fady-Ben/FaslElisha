package org.elisha.faslelisha.activities;

import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.elisha.faslelisha.R;
import org.elisha.faslelisha.models.Boy;

import java.util.ArrayList;
import java.util.List;

@EActivity(R.layout.activity_main)
public class MainActivity extends AppCompatActivity {

    private static final String TAG = "DatabaseMainActivity";

    @AfterViews
    public void init() {
        try {

            /*FirebaseDatabase.getInstance().setPersistenceEnabled(true);
            DatabaseReference database = FirebaseDatabase.getInstance().getReference();
            database.keepSynced(true);

            database.child("Boys").addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    List boys = new ArrayList<>();
                    for (DataSnapshot noteDataSnapshot : dataSnapshot.getChildren()) {
                        Boy boy = noteDataSnapshot.getValue(Boy.class);
                        boys.add(boy);
                        Log.i(TAG, "Boy Name: " + boy.getName());
                        Log.i(TAG, "Boy id: " + boy.getId());
                        Log.i(TAG, "Boy totalPoints: " + boy.getTotalPoints());
                    }
                }

                @Override
                public void onCancelled(DatabaseError error) {
                    // Failed to read value
                    Log.w(TAG, "Failed to read value.", error.toException());
                }
            });*/

        } catch (Exception e) {

        }
    }

    @Click(R.id.attendanceButtonAM)
    void attendanceButtonClicked() {
        /*Intent intent = new Intent(this, Attendance.class);
        startActivity(intent);*/
        Attendance_.intent(this).start();
    }

    @Click(R.id.tayoButtonAM)
    void tayoButtonClicked() {
        updateBoyData();
        Log.i(TAG, "Data updated");
    }

    private void updateBoyData() {
        try {
/*            DatabaseReference database;
            database = FirebaseDatabase.getInstance().getReference();
            database.child("Boys").child("Fady").child("id").setValue(1);*/
        } catch (Exception e) {

        }
    }
}
