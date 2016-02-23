package br.com.marcellogalhardo.dexterblackscreenbug;

import android.app.Application;

import com.karumi.dexter.Dexter;

public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Dexter.initialize(this);
    }
}
