package com.ecommerce.travelmantics.ob_box;

import android.content.Context;
import android.util.Log;

import  com.ecommerce.travelmantics.BuildConfig;
import  com.ecommerce.travelmantics.MyObjectBox;

import io.objectbox.BoxStore;
import io.objectbox.android.AndroidObjectBrowser;

public class ObjectBox {





    private static BoxStore boxStore;



    static void init(Context context) {

        boxStore = MyObjectBox.builder()

                .androidContext(context.getApplicationContext())

                .build();



        if (BuildConfig.DEBUG) {

            Log.d(App.TAG, String.format("Using ObjectBox %s (%s)",

                    BoxStore.getVersion(), BoxStore.getVersionNative()));

            new AndroidObjectBrowser(boxStore).start(context.getApplicationContext());

        }

    }



    public static BoxStore get() {

        return boxStore;

    }


}
