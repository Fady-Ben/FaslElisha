package org.elisha.faslelisha.activities;

import android.support.v7.app.AppCompatActivity;

import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.elisha.faslelisha.R;

@EActivity(R.layout.activity_points_home)
public class PointsHomeActivity extends AppCompatActivity {

    @Click (R.id.submitButtonAPH)
    void submitButtonPressed (){
        MainActivity_.intent(this).start();
    }

}
