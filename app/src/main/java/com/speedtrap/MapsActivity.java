package com.speedtrap;

import android.os.Handler;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends AppCompatActivity {

    protected static final long TIME_DELAY = 1000;
    int count =0;
    Handler handler=new Handler();
    TextView latLongTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        changeTextboxValue();
        handler.post(updateTextLatLongRunnable);
    }

    private void changeTextboxValue(){
        latLongTextView = (TextView) findViewById(R.id.latlong);
        Button updateButton = (Button) findViewById(R.id.update);
        updateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                latLongTextView.setText(getLatLong());
            }
        });
    }

    // on button click it will trigger
    private String getLatLong(){
        Double latitude = Math.random();
        Double longitude = Math.random();
        String latlong = "Latitude: "+latitude + "Longitude: "+longitude;
        return latlong;
    }

    Runnable updateTextLatLongRunnable=new Runnable(){
        public void run() {
            count++;
            latLongTextView.setText(getLatLong() +count);
            handler.postDelayed(this, TIME_DELAY);
        }
    };
}
