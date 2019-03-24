package com.example.gsonjiexijson;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.gsonjiexijson.domain.Person;
import com.example.gsonjiexijson.gson.GsonTools;
import com.example.gsonjiexijson.http.HttpUtils;

import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
private Button button1, button2;
private static final String TAG = "MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button1 = (Button)findViewById(R.id.button1);
        button2 = (Button)findViewById(R.id.button2);
        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
    }

    @Override
    public void onClick(final View v) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                switch (v.getId()){
                    case R.id.button1:
                        String path = "http://";
                        String jsonString = HttpUtils.getJsonContent(path);
                        Person person = GsonTools.getPerson(jsonString, Person.class);
                        Log.i(TAG, person.toString());
                        break;
                    case R.id.button2:
                        String path2 = "http://";
                        String jsonString2 = HttpUtils.getJsonContent(path2);
                        List<Person> list = GsonTools.getPersons(jsonString2, Person.class);
                        Log.i(TAG, list.toString());
                        break;
                }
            }
        });
        thread.start();
    }
}
