package com.example.instagramclone;

import android.app.Application;

import com.parse.Parse;

public class ParseApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        Parse.initialize(new Parse.Configuration.Builder(this)
                .applicationId("ken-parstagram") // should correspond to APP_ID env variable
                .clientKey("CodepathMasterInstagramParse")  // set explicitly unless clientKey is explicitly configured on Parse server
                .server("https://ken-parstagram.herokuapp.com/parse").build());
    }
}

