package com22yards.myapplication;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class DialerNumber extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialer_number);

        String number = "7679683220";
        Uri call = Uri.parse("tel:" + number);
        Intent surf = new Intent(Intent.ACTION_DIAL, call);
        startActivity(surf);
    }
}
