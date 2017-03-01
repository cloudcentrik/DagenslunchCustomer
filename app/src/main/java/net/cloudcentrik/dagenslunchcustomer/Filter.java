package net.cloudcentrik.dagenslunchcustomer;

import android.util.Log;

import com.google.android.gms.maps.model.LatLng;

import java.util.ArrayList;

/**
 * Created by zubayer on 19/02/17.
 */

public class Filter {



    static ArrayList<Restaurant> getRestaurants(){
        Restaurant res1 = new Restaurant(1, "Bee bar Göteborg", "X", 57.703540, 11.967894);
        Restaurant res2 = new Restaurant(2, "Bee bar Malmö", "X", 58.508393, 13.135094);
        Restaurant res3 = new Restaurant(3, "Hard rock cafe", "Y", 57.701381, 11.974537);
        Restaurant res4 = new Restaurant(4, "Göteborg wok", "Y", 57.709316, 11.966394);
        Restaurant res5 = new Restaurant(5, "Göteborg wok", "Z", 57.722906, 11.954941);
        Restaurant res6 = new Restaurant(6, "Restaurang Saray", "Z", 57.741848, 12.008720);
        Restaurant res7 = new Restaurant(7, "Fiskekrogen", "A", 57.705526, 11.961373);
        Restaurant res8 = new Restaurant(8, "Hello Monkey", "A", 57.693591, 11.953009);
        ArrayList<Restaurant> restaurants = new ArrayList<Restaurant>();
        restaurants.add(res1);
        restaurants.add(res2);
        restaurants.add(res3);
        restaurants.add(res4);
        restaurants.add(res5);
        restaurants.add(res6);
        restaurants.add(res7);
        restaurants.add(res8);
        return restaurants;
    }




    public static ArrayList<Restaurant> filterRestaurants(ArrayList<Restaurant> restaurants, int howFar){
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
        //Log.d("hi", "hello");
        return filteredRestaurants;
    }





    public static LatLng getCurrentLocation() {
        LatLng currentLocation = new LatLng(1.22, 2.33);
        return currentLocation;
    }

    public static double getDistance(LatLng location1, LatLng location2){
        double distance = 1.00;
        return distance;

    }

    public static void main(String[] args){
        ArrayList<Restaurant> a = new ArrayList<Restaurant>();
        Restaurant r = new Restaurant(1, "hi","hello", 4.336, 6.778);
        a.add(r);
        filterRestaurants(a, 10);

    }
}




