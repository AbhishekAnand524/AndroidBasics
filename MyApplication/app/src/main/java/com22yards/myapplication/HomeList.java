package com22yards.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class HomeList extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_list);

        String [] listArray = {"Calculator","SMS","Camera","Tab","SQLite","Check Internet","Dialer"};
        ListView listView = (ListView) findViewById(R.id.list_view);
        ArrayAdapter adapter = new ArrayAdapter<String>(this,R.layout.list,listArray);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(position == 0){
                    Toast.makeText(HomeList.this,"You clicked on calculator", Toast.LENGTH_LONG).show();
                }
                switch (position){
                    case 1:
                        Intent intent1 = new Intent(HomeList.this, Sms.class);
                        startActivity(intent1);
                        break;
                    case 2:
                        Intent intent2 = new Intent(HomeList.this, Camera.class);
                        startActivity(intent2);
                        break;
                    case 3:
                        Intent intent3 = new Intent(HomeList.this, Tab.class);
                        startActivity(intent3);
                        break;
                    case 4:
                        Intent intent4 = new Intent(HomeList.this, DatabaseSqlite.class);
                        startActivity(intent4);
                        break;
                    case 5:
                        Intent intent5 = new Intent(HomeList.this, CheckInternet.class);
                        startActivity(intent5);
                        break;
                    case 6:
                        Intent intent6 = new Intent(HomeList.this, DialerNumber.class);
                        startActivity(intent6);
                        break;
                }
            }
        });
    }
}
