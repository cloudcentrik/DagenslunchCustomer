package net.cloudcentrik.dagenslunchcustomer;

import java.util.ArrayList;

/**
 * Created by ismail on 13/02/17.
 */

public class RestAPI {

    public static ArrayList<Restaurant> getListOfRestaurant(){
        ArrayList<Restaurant> restaurants=new ArrayList<Restaurant>();

        Restaurant restaurant1=new Restaurant(1,"pizza hurt","pizza",58.7189,11.9746);
        Restaurant restaurant2=new Restaurant(2,"pizza hurt","pizza",58.7289,11.9756);
        Restaurant restaurant3=new Restaurant(3,"pizza hurt","pizza",58.7389,11.9766);

        restaurants.add(restaurant1);
        restaurants.add(restaurant2);
        restaurants.add(restaurant3);

        return restaurants;
    }
}
