package com22yards.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class DatabaseSqlite extends AppCompatActivity {

    EditText editTextUsername, editTextPassword;
    TextView textView;
    MyDBHelper myDBHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_database_sqlite);


        editTextUsername = (EditText) findViewById(R.id.username);
        editTextPassword = (EditText) findViewById(R.id.password);
        textView = (TextView) findViewById(R.id.textView);
        myDBHelper = new MyDBHelper(this,null,null,1);
        printDatabase();
    }

    public void insertData(View view){
        String u = editTextUsername.getText().toString();
        String p = editTextPassword.getText().toString();

        if(u.length()>0 && p.length()>0) {
            myDBHelper.insertdata(u, p);
            Toast.makeText(this,"Inserted Successfully",Toast.LENGTH_LONG).show();
        }
        else{
            Toast.makeText(this,"Please don't leave any field blank",Toast.LENGTH_LONG).show();
        }
        printDatabase();
    }

    public void updateData(View view){
        String u = editTextUsername.getText().toString();
        String p = editTextPassword.getText().toString();

        if(u.length()>0 && p.length()>0) {
            myDBHelper.updatedata(u, p);
            Toast.makeText(this,"Inserted Successfully",Toast.LENGTH_LONG).show();
        }
        else{
            Toast.makeText(this,"Please don't leave any field blank",Toast.LENGTH_LONG).show();
        }
        printDatabase();
    }


    public void printDatabase(){
        String dbase = myDBHelper.databaseString();
        textView.setText(dbase);
        editTextUsername.setText("");
        editTextPassword.setText("");
    }
}
