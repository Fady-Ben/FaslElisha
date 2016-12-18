package org.elisha.faslelisha.activities;

import android.content.Intent;
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

import static android.content.Intent.FLAG_ACTIVITY_CLEAR_TOP;

@EActivity(R.layout.activity_points_home)
public class PointsHomeActivity extends AppCompatActivity {

    private static final String TAG = "DatabaseMainActivity";

    @Extra
    protected int boyId;

    @Extra
    protected Class referrerActivityClass;

    protected List<Boy> boysList = new ArrayList<>();

    @ViewById(R.id.boyNameTextViewAPH)
    protected TextView boyNameTextView;

    @ViewById(R.id.totalPointsAPH)
    protected TextView totalPointTextView;
    private Boy boy;


    @AfterExtras
    public void initView() {

        try {
            FirebaseDatabase.getInstance().setPersistenceEnabled(true);
            DatabaseReference database = FirebaseDatabase.getInstance().getReference();
            database.keepSynced(true);

            database.child("Boys").child(String.valueOf(boyId)).addValueEventListener(new ValueEventListener() {

                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    Boy boy = dataSnapshot.getValue(Boy.class);
                    Log.i(TAG, "Boys data = " + dataSnapshot.getValue(Boy.class));
                    boyNameTextView.setText("Name = " + boy.getName());
                    totalPointTextView.setText("Total Points = " + boy.getTotalPoints());

/*                    for (DataSnapshot noteDataSnapshot : dataSnapshot.getChildren()) {
                        Boy boy = noteDataSnapshot.getValue(Boy.class);
                        boysList.add(boy);
                        if (boy.getId() == boyId) {
                            boyNameTextView.setText("Name = " + boy.getName());
                            Log.i(TAG, "Boy Name: " + boy.getName());
                            totalPointTextView.setText("Total Points = " + boy.getTotalPoints());
                        }
                    }*/
                }

                @Override
                public void onCancelled(DatabaseError error) {
                    // Failed to read value
                    Log.w(TAG, "Failed to read value.", error.toException());
                    Toast.makeText(getApplicationContext(), "Failed to read value", Toast.LENGTH_SHORT).show();
                }
            });


            Toast.makeText(getApplicationContext(), "Boys List size = " + boysList.size(), Toast.LENGTH_SHORT).show();

/*         //for (Boy boyTemp : boys)
           for (int i = 0; i < boys.size(); i++) {
                temp = boys.get(i);
                Toast.makeText(getApplicationContext(), "Boy Name: " + temp.getName(), Toast.LENGTH_SHORT).show();
                Log.i(TAG, "Boy Name: " + temp.getName());

            }*/

        } catch (Exception e) {

        }
    }

    @Click(R.id.submitButtonAPH)
    void submitButtonPressed() {
        referrerActivityClass = org.elisha.faslelisha.activities.MainActivity_.class;
        Intent intent = new Intent(this, referrerActivityClass);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK | FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);

//        MainActivity_.intent(this).start();
    }

}
