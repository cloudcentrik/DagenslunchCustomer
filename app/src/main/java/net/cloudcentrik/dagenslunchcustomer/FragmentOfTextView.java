package net.cloudcentrik.dagenslunchcustomer;

/**
 * Created by Johir on 2/7/2017.
 * Developed by Shohidul

 */

import android.graphics.Color;
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
import java.util.List;
//import com.android.volley.RequestQueue;





public class FragmentOfTextView extends Fragment {

    private ListView listView ;
    private ArrayAdapter<String> adapter;
    private ArrayAdapter<String> arrayAdapter;

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

        //ArrayList<double> distanceOfRestaurants = new ArrayList<double>();
        List<Double> distanceOfRestaurants = new ArrayList<Double>();

        LatLng currentLocation = new LatLng(0,0);
        currentLocation = GeoLocationCalculator.getUserLocation();

        LatLng restaurantLocation = new LatLng(0,0);

        for (int i = 0; i < restaurantsObj.size(); i++) {
            LatLng resLatLngs = new LatLng(restaurantsObj.get(i).getLatitude(),restaurantsObj.get(i).getLongitude());
            distanceOfRestaurants.add(Filter.getDistance(currentLocation, resLatLngs));
            int dists = distanceOfRestaurants.get(i).intValue();
            restauratNames.add(restaurantsObj.get(i).getName() + "     " + dists + " meters");

        }

        // Create an ArrayAdapter from List
        final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>
                (getActivity(), android.R.layout.simple_list_item_1, restauratNames){
            @Override
            public View getView(int position, View convertView, ViewGroup parent){
                // Get the current item from ListView
                View view = super.getView(position,convertView,parent);
                if(position %2 == 1)
                {
                    // Set a background color for ListView regular row/item
                    view.setBackgroundColor(Color.parseColor("#FFB6B546"));
                }
                else
                {
                    // Set the background color for alternate row/item
                    view.setBackgroundColor(Color.parseColor("#FFCCCB4C"));
                }
                return view;
            }
        };



        // Get ListView object from xml
        listView = (ListView) rootView.findViewById(R.id.list2);

       /* adapter = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_list_item_1, restauratNames);*/

        // Assign adapter to ListView
        listView.setAdapter(arrayAdapter);


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

