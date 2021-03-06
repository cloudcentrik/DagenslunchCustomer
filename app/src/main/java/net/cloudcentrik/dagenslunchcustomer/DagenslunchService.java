package net.cloudcentrik.dagenslunchcustomer;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by ismail on 23/01/17.
 */

public interface DagenslunchService {

    @GET("basic")
    Call<List<Restaurant>> getRestaurantList();

    public static final Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("http://dagens-lunch-v1.herokuapp.com/restaurant/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();
}
