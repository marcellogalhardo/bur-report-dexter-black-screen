package br.com.marcellogalhardo.dexterblackscreenbug;

import android.Manifest;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.karumi.dexter.Dexter;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionDeniedResponse;
import com.karumi.dexter.listener.PermissionGrantedResponse;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.single.PermissionListener;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (!Dexter.isRequestOngoing()) {
            Dexter.checkPermission(new PermissionListener() {
                @Override
                public void onPermissionGranted(PermissionGrantedResponse response) {
                    Toast.makeText(MainActivity.this, "onPermissionGranted", Toast.LENGTH_SHORT).show();
                }

                @Override
                public void onPermissionDenied(PermissionDeniedResponse response) {
                    Toast.makeText(MainActivity.this, "onPermissionDenied", Toast.LENGTH_SHORT).show();
                }

                @Override
                public void onPermissionRationaleShouldBeShown(PermissionRequest permission, final PermissionToken token) {
                    Toast.makeText(MainActivity.this, "onPermissionRationaleShouldBeShown", Toast.LENGTH_SHORT).show();
                }
            }, Manifest.permission.READ_PHONE_STATE);
        }
    }
}
