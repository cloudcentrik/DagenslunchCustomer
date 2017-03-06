package net.cloudcentrik.dagenslunchcustomer;

/**
 * Created by Johir on 2/7/2017.
 */

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import java.util.ArrayList;
import java.util.HashMap;
import com.google.android.gms.maps.CameraUpdateFactory;


public  class MapActivity extends FragmentActivity implements OnMapReadyCallback {

    // Google Map
    private GoogleMap googleMap;
    // Latitude & Longitude
    private Double Latitude = 0.00;
    private Double Longitude = 0.00;
    ArrayList<HashMap<String, String>> location = new ArrayList<HashMap<String, String>>();
    HashMap<String, String> map;
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_mapview);

        // Location 0
        map = new HashMap<String, String>();
       // map.put("LocationID", "0");
        map.put("Latitude", "13.863903");
        map.put("Longitude", "40.614343");
        map.put("LocationName", "Moiz");
        location.add(map);

// Location 1

        map = new HashMap<String, String>();
       // map.put("LocationID", "1");
        map.put("Latitude", "33.860633");
        map.put("Longitude", "80.612155");
        map.put("LocationName", "Jahirul haq");
        location.add(map);
// Location 2
        map = new HashMap<String, String>();
        //map.put("LocationID", "2");
        map.put("Latitude", "23.858747");
        map.put("Longitude", "120.610996");
        map.put("LocationName", "Shohidul");
        location.add(map);
// Location 3
        map = new HashMap<String, String>();
       // map.put("LocationID", "3");
        map.put("Latitude", "13.863903");
        map.put("Longitude", "160.614343");
        map.put("LocationName", "Ismail");
        location.add(map);

        // Location 4
        map = new HashMap<String, String>();
       // map.put("LocationID", "4");
        map.put("Latitude", "13.863903");
        map.put("Longitude", "180.614343");
        map.put("LocationName", "Jobayer");
        location.add(map);


// *** Display Google Map

        SupportMapFragment googleMap = ((SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map));
        googleMap.getMapAsync(this);

// *** Focus & Zoom
        Latitude = Double.parseDouble(location.get(0).get("Latitude").toString());
        Longitude = Double.parseDouble(location.get(0).get("Longitude").toString());
        LatLng coordinate = new LatLng(Latitude, Longitude);

        //googleMap.setMapType(com.google.android.gms.maps.GoogleMap.MAP_TYPE_HYBRID);
       // googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(coordinate, 17));

    }

    public void onMapReady(GoogleMap map) {
        this.googleMap = map;
        if(this.googleMap != null) {
            // *** Marker (Loop)

            for (int i = 0; i < location.size(); i++) {
                Latitude = Double.parseDouble(location.get(i).get("Latitude").toString());
                Longitude = Double.parseDouble(location.get(i).get("Longitude").toString());
                String name = location.get(i).get("LocationName").toString();

                MarkerOptions marker = new MarkerOptions().position(new LatLng(Latitude, Longitude)).title(name);

                // marker.icon(BitmapDescriptorFactory.fromResource(R.drawable.Marker));
                marker.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE));
                //googleMap.addmarker(marker);
                this.googleMap.addMarker(marker);
            }
        }
    }
}

