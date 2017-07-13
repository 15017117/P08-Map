package com.myapplicationdev.android.p08_map;

import android.Manifest;
import android.app.Activity;
import android.support.v4.app.FragmentManager;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.PermissionChecker;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.UiSettings;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class MainActivity extends AppCompatActivity {
    Button btnNorth,btnCentral,btnEast;

    Spinner spinner;
    private GoogleMap map;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        FragmentManager fm = getSupportFragmentManager();
        SupportMapFragment mapFragment = (SupportMapFragment) fm.findFragmentById(R.id.map);


        mapFragment.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(GoogleMap googleMap) {
                map = googleMap;
                UiSettings ui = map.getUiSettings();
                ui.setZoomControlsEnabled(true);
                ui.setCompassEnabled(true);


                LatLng poi_SingaporeMap = new LatLng(1.355379, 103.867744);
                map.moveCamera(CameraUpdateFactory.newLatLngZoom(poi_SingaporeMap, 11));

                int permissionCheck = ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.ACCESS_FINE_LOCATION);

                if (permissionCheck == PermissionChecker.PERMISSION_GRANTED) {
                    map.setMyLocationEnabled(true);
                } else {
                    Log.e("GMAP - Permission", "GPS access has not been granted");
                }


            }
        });
        spinner = (Spinner) findViewById(R.id.spinner);



        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(spinner.getSelectedItemPosition()== 0){
                    LatLng poi_north   = new LatLng(1.441073, 103.77207);
                    Marker north = map.addMarker(new MarkerOptions().position(poi_north).title("North - HQ:").snippet("Block 333, Admiralty Ave 3, 765654\nOperating hours: 10am-5pm\n" +
                            "Tel:65433456\n").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)));
                    map.moveCamera(CameraUpdateFactory.newLatLngZoom(poi_north,15));

                    Toast.makeText(getApplicationContext(),north.getSnippet().toString(),Toast.LENGTH_LONG).show();
                } else if(spinner.getSelectedItemPosition() == 1){
                    LatLng poi_central   = new LatLng(1.297802, 103.847441);
                    Marker central = map.addMarker(new MarkerOptions().position(poi_central).title("Central:").snippet("Block 3A, Orchard Ave 3, 134542\nOperating hours: 11am-8pm\n" +
                            "Tel:67788652\n").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)));
                    map.moveCamera(CameraUpdateFactory.newLatLngZoom(poi_central,15));

                    Toast.makeText(getApplicationContext(),central.getSnippet().toString(),Toast.LENGTH_LONG).show();
                } else if (spinner.getSelectedItemPosition() == 2){
                    LatLng poi_East   = new LatLng(1.367149, 103.928021);
                    Marker east = map.addMarker(new MarkerOptions().position(poi_East).title("East:").snippet("Block 555, Tampines Ave 3, 287788\nOperating hours: 9am-5pm\n"+
                            "Tel:66776677\n").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW)));
                    map.moveCamera(CameraUpdateFactory.newLatLngZoom(poi_East,15));

                    Toast.makeText(getApplicationContext(),east.getSnippet().toString(),Toast.LENGTH_LONG).show();
                }


            }


            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


//        btnNorth = (Button)findViewById(R.id.btnNorth);
//        btnCentral =(Button)findViewById(R.id.btnCentral);
//        btnEast = (Button)findViewById(R.id.btnEast);
//
//        btnNorth.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                LatLng poi_north   = new LatLng(1.441073, 103.77207);
//                Marker north = map.addMarker(new MarkerOptions().position(poi_north).title("North - HQ:").snippet("Block 333, Admiralty Ave 3, 765654\nOperating hours: 10am-5pm\n" +
//                        "Tel:65433456\n").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)));
//                map.moveCamera(CameraUpdateFactory.newLatLngZoom(poi_north,15));
//
//                Toast.makeText(getApplicationContext(),north.getSnippet().toString(),Toast.LENGTH_LONG).show();
//
//
//
//            }
//        });
//
//        btnCentral.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                LatLng poi_central   = new LatLng(1.297802, 103.847441);
//                Marker central = map.addMarker(new MarkerOptions().position(poi_central).title("Central:").snippet("Block 3A, Orchard Ave 3, 134542\nOperating hours: 11am-8pm\n" +
//                        "Tel:67788652\n").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)));
//                map.moveCamera(CameraUpdateFactory.newLatLngZoom(poi_central,15));
//
//                Toast.makeText(getApplicationContext(),central.getSnippet().toString(),Toast.LENGTH_LONG).show();
//
//
//            }
//        });
//
//        btnEast.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                LatLng poi_East   = new LatLng(1.367149, 103.928021);
//                Marker east = map.addMarker(new MarkerOptions().position(poi_East).title("East:").snippet("Block 555, Tampines Ave 3, 287788\nOperating hours: 9am-5pm\n"+
//                "Tel:66776677\n").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW)));
//                map.moveCamera(CameraUpdateFactory.newLatLngZoom(poi_East,15));
//
//                Toast.makeText(getApplicationContext(),east.getSnippet().toString(),Toast.LENGTH_LONG).show();
//
//
//            }
//        });

    }
}
