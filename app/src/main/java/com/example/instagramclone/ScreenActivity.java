package com.example.instagramclone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.parse.LogInCallback;
import com.parse.ParseException;
import com.parse.ParseUser;

import java.util.ArrayList;
import java.util.List;

public class ScreenActivity extends AppCompatActivity {
    public static final String TAG = "ScreenActivity";
    private Button btnLog;
    private Spinner spCountry;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen);

        if (ParseUser.getCurrentUser() != null)  {
            goMainActivity();
        }

        btnLog = findViewById(R.id.btnLog);
        spCountry = findViewById(R.id.spCountry);

        btnLog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 goMainActivity();
            }
        });
        screenSpinner();
    }

    public void screenSpinner(){
        // Spinner element
        Spinner spinner = (Spinner) spCountry;
        // Spinner Drop down elements
        List<String> categories = new ArrayList<String>();
        categories.add("Creole (Haiti)");
        categories.add("English (United Stated)");
        categories.add("French (France)");
        categories.add("Spanish (Dominican Republic)");
        categories.add("Portuguese (Brazil)");

        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, categories);

        // Drop down layout style - list view with radio button
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        spinner.setAdapter(dataAdapter);
    }
    private void goMainActivity() {
        Intent i = new Intent(this, LoginActivity.class);
        startActivity(i);
        finish();
    }
}
