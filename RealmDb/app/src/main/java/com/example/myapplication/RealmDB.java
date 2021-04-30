package com.example.myapplication;

import android.app.Application;

import io.realm.Realm;
import io.realm.RealmConfiguration;

public class RealmDB  extends Application {
    public void onCreate(){
        super.onCreate();

        Realm.init(this);
        RealmConfiguration configuration= new RealmConfiguration.Builder()
                .allowWritesOnUiThread(true)
                .deleteRealmIfMigrationNeeded()
                .build();

        Realm.setDefaultConfiguration(configuration);


    }
}
