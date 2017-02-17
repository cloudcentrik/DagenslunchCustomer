package net.cloudcentrik.dagenslunchcustomer;

import android.os.AsyncTask;
import android.util.Log;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;

/**
 * Created by ismail on 14/02/17.
 */

public class DagenlunchRestAPIClient {

    private ArrayList<Restaurant> restaurantList;

    //get list of Restaurant from server
    public ArrayList<Restaurant> getListOfRestaurant(){

        restaurantList=new ArrayList<Restaurant>();

        try{
            List<Restaurant> apiTask=new DagenslunchAPICallTask().execute("").get();
            restaurantList=convertListToArrayList(apiTask);
        }catch (Exception e){

        }

        return restaurantList;
    }

    private class DagenslunchAPICallTask extends AsyncTask<String, Void, List<Restaurant>> {

        private List<Restaurant> restaurants=new ArrayList<Restaurant>();
        @Override
        protected List<Restaurant> doInBackground(String... params) {
            DagenslunchService dagenslunchService = DagenslunchService.retrofit.create(DagenslunchService.class);
            Call<List<Restaurant>> call = dagenslunchService.getRestaurantList();

            try {
                List<Restaurant> result = call.execute().body();

                restaurants=result;

            }
            catch (IOException ex){

            }
            return restaurants;
        }

        @Override
        protected void onPostExecute(List<Restaurant> result) {

        }

    }

    private ArrayList<Restaurant> convertListToArrayList(List<Restaurant> result){
        ArrayList<Restaurant> restaurants=new ArrayList<Restaurant>();
        for (int i=0;i<result.size();i++){
            restaurants.add(i,result.get(i));
        }
        return restaurants;
    }

}
