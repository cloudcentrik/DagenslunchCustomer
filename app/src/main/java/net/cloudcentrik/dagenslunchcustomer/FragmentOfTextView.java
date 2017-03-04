package net.cloudcentrik.dagenslunchcustomer;

/**
 * Created by Johir on 2/7/2017.
 */

import android.os.Bundle;
import android.support.v4.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.gms.maps.model.LatLng;

import java.util.ArrayList;
//import com.android.volley.RequestQueue;





public class FragmentOfTextView extends Fragment {

    private ListView listView ;
    private ArrayAdapter<String> adapter;

    String uRL_json_array = "http://dagens-lunch-v1.herokuapp.com/people"; // your URL
    ArrayList<String> restauratNames = new ArrayList<>();
  //  RequestQueue requestQueue;


    public FragmentOfTextView() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.activity_fragment_textview, container, false);


        ArrayList<Restaurant> restaurantsObj = new ArrayList<Restaurant>();
        restaurantsObj = Filter.getRestaurants();

        double [] distanceOfRestaurants = new double[100];

        LatLng currentLocation = new LatLng(0,0);
        currentLocation = Filter.getCurrentLocation();

        LatLng restaurantLocation = new LatLng(0,0);

        for (int i = 0; i < restaurantsObj.size(); i++) {
            distanceOfRestaurants[i] = Filter.getDistance(currentLocation, restaurantLocation);
            restauratNames.add(restaurantsObj.get(i).getName() + "     " + distanceOfRestaurants[i] + " meters");

        }

        // Get ListView object from xml
        listView = (ListView) rootView.findViewById(R.id.list2);

        adapter = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_list_item_1, restauratNames);

        // Assign adapter to ListView
        listView.setAdapter(adapter);

        // ListView Item Click Listener
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

                // ListView Clicked item index
                int itemPosition     = position;

                // ListView Clicked item value
                String  itemValue    = (String) listView.getItemAtPosition(position);

                // Show Alert

                Toast.makeText(getActivity(),"Position :"+itemPosition+" Test Msg: " +itemValue,
                        Toast.LENGTH_SHORT).show();

            }

        });


        return rootView;
    }

}

