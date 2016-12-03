package org.elisha.faslelisha.activities;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.google.zxing.Result;

import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.elisha.faslelisha.R;

import me.dm7.barcodescanner.zxing.ZXingScannerView;

@EActivity(R.layout.activity_attendance)
public class Attendance extends AppCompatActivity implements ZXingScannerView.ResultHandler {
    private ZXingScannerView mScannerView;

    private String name;

    public void QrScanner(View view) {
        mScannerView = new ZXingScannerView(this);   // Programmatically initialize the scanner view
        setContentView(mScannerView);
        mScannerView.setResultHandler(this); // Register ourselves as a handler for scan results.
        mScannerView.startCamera();         // Start camera

    }

    @Override
    public void onPause() {
        super.onPause();
        //mScannerView.stopCamera();           // Stop camera on pause
    }

    @Override
    public void handleResult(Result rawResult) {
        // Do something with the result here

        Log.e("Name1", rawResult.getText()); // Prints scan results --> here
        Log.e("Name2", rawResult.getBarcodeFormat().toString()); // Prints the scan format (qrcode)
        name = rawResult.getText();

        // show the scanner result into dialog box.
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Scan Result");
        builder.setMessage(rawResult.getText());
        builder.setCancelable(true);
        AlertDialog alert1 = builder.create();

        alert1.show();
        PointsHomeActivity_.intent(this).start();

        // If you would like to resume scanning, call this method below:
        //mScannerView.resumeCameraPreview(this);
    }

    @Click(R.id.manualButtonAA)
    public void manualAttendanceBtnClicked() {
        ManualAttendance_.intent(this).start();
    }
}