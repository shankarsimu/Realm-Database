package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import io.realm.Realm;

public class MainActivity extends AppCompatActivity {

    private EditText userNameEdt,  userPositionEdt;
    private Realm realm;

    private String userName,userPosition;
    Button submitBtn,readBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        realm= Realm.getDefaultInstance();
        setContentView(R.layout.activity_main);

//        Realm.init(this);
        userNameEdt = findViewById(R.id.userName);
        userPositionEdt = findViewById(R.id.userPosition);

          submitBtn = findViewById(R.id.saveUser);
        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                userName = userNameEdt.getText().toString();
                userPosition = userPositionEdt.getText().toString();

                if (TextUtils.isEmpty(userName)) {
                    userNameEdt.setError("Please enter User Name");
                } else if (TextUtils.isEmpty(userPosition)) {
                    userPositionEdt.setError("Please enter User Position");
                }  else {
                    // calling method to add data to Realm database..
                    addDataToDatabase(userName, userPosition);
                    Toast.makeText(MainActivity.this, "Details added to database..", Toast.LENGTH_SHORT).show();
                    userNameEdt.setText("");
                    userPositionEdt.setText("");
                }
            }
        });
        readBtn=findViewById(R.id.readUser);
        readBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    Intent intent=new Intent(MainActivity.this,UserDetails.class);
                    startActivity(intent);
            }
        });

    }

    private void addDataToDatabase(String userName, String userPosition) {


         RealmDataModel modal = new RealmDataModel();

         Number id = realm.where(RealmDataModel.class).max("id");

         long nextId;

         if (id == null) {
             nextId = 1;
        } else {
            nextId = id.intValue() + 1;
        }
        modal.setId(nextId);
        modal.setUserName(userName);
        modal.setUserPosition(userPosition);

        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                 realm.copyToRealm(modal);
            }
        });
    }
}
