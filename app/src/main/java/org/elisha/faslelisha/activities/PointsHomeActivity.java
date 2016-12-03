package org.elisha.faslelisha.activities;

import android.support.v7.app.AppCompatActivity;
import android.util.Log;
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

import java.util.ArrayList;
import java.util.List;

@EActivity(R.layout.activity_points_home)
public class PointsHomeActivity extends AppCompatActivity {

    private static final String TAG = "DatabaseMainActivity";

    @Extra
    protected int boyId;

    @ViewById(R.id.boyNameTextViewAPH)
    TextView boyNameTextView;

    @ViewById(R.id.totalPointsAPH)
    TextView totalPointTextView;

    private List boys = new ArrayList<>();

    @AfterExtras
    public void initView() {
        Log.i(TAG, "Boyid from extras: " + boyId);

        try {
            FirebaseDatabase.getInstance().setPersistenceEnabled(true);
            DatabaseReference database = FirebaseDatabase.getInstance().getReference();
            database.keepSynced(true);

            database.child("Boys").addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {

                    for (DataSnapshot noteDataSnapshot : dataSnapshot.getChildren()) {
                        Boy boy = noteDataSnapshot.getValue(Boy.class);
                        if (boy.getId() == boyId) {
                            boyNameTextView.setText("Name = " + boy.getName());
                            Log.i(TAG, "Boy Name: " + boy.getName());
                            totalPointTextView.setText("Total Points = " + boy.getTotalPoints());
                        }
                        boys.add(boy);
                    }
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

    @Click(R.id.submitButtonAPH)
    void submitButtonPressed() {
        MainActivity_.intent(this).start();
    }

}
