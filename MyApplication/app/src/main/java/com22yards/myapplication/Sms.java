package com22yards.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Sms extends AppCompatActivity {

    EditText number, message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sms);

        number = (EditText) findViewById(R.id.editTextNumber);
        message = (EditText) findViewById(R.id.editTextMessage);
    }

    public void send_message(View view){

        String num = number.getText().toString();
        String body = message.getText().toString();

        try {
            SmsManager smsManager = SmsManager.getDefault();
            smsManager.sendTextMessage(num, null, body, null, null);
            Toast.makeText(this, "Message Sent", Toast.LENGTH_LONG).show();
        }
        catch (Exception e){
            Toast.makeText(this, "Failed", Toast.LENGTH_LONG).show();
            e.printStackTrace();
        }
    }
}
