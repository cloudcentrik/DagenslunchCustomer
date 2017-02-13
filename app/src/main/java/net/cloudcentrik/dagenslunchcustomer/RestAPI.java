package net.cloudcentrik.dagenslunchcustomer;

import java.util.ArrayList;

/**
 * Created by ismail on 13/02/17.
 */

public class RestAPI {

    public static ArrayList<Restaurant> getListOfRestaurant(){
        ArrayList<Restaurant> restaurants=new ArrayList<Restaurant>();

        Restaurant restaurant1=new Restaurant(1,"pizza hurt","pizza",58.7089,11.9746);

        restaurants.add(restaurant1);

        return restaurants;
    }
}
