package net.cloudcentrik.dagenslunchcustomer;

import com.google.android.gms.maps.model.LatLng;

import java.util.ArrayList;

/**
 * Created by zubayer on 19/02/17.
 */

public class Filter {
    public ArrayList<Restaurant> filterRestaurants(ArrayList<Restaurant> restaurants, int howFar){
        ArrayList<Restaurant>  filteredRestaurants = new ArrayList<Restaurant>();

        LatLng currentLocation = getCurrentLocation();
        for (int i = 0; i< restaurants.size(); i++){
            LatLng restaurantLocation = new LatLng(restaurants.get(i).getLatitude(), restaurants.get(i).getLongitude());
            double distanceFromCurrentLocation = getDistance(currentLocation, restaurantLocation);
            if(distanceFromCurrentLocation < howFar){
                restaurants.get(i).setDistance(distanceFromCurrentLocation);
                filteredRestaurants.add(restaurants.get(i));
            }
        }
        return filteredRestaurants;
    }





    public LatLng getCurrentLocation() {
        LatLng currentLocation = new LatLng(1.22, 2.33);
        return currentLocation;
    }

    public double getDistance(LatLng location1, LatLng location2){
        double distance = 1.00;
        return distance;

    }
}




