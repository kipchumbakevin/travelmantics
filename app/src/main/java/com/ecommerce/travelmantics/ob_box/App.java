package com.ecommerce.travelmantics.ob_box;

import android.app.Application;

public class App extends Application {

    public static final String TAG = "ObjectBoxExample";



    @Override

    public void onCreate() {
        super.onCreate();

        ObjectBox.init(this);

    }



}


