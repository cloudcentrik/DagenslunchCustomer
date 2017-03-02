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

        // Defined Array values to show in ListView
        /*restauratNames.add("Restaurant ABC");
        restauratNames.add("Restaurant XYZ");
        restauratNames.add("ABC");
        restauratNames.add("PQR");
        restauratNames.add("PIZZA");
        restauratNames.add("PIZZA Campus");
        restauratNames.add("GBG BEST PIZZA");*/


        /*

        requestQueue = Volley.newRequestQueue(getActivity());

        JsonArrayRequest jsArrRequest = new JsonArrayRequest(com.android.volley.Request.Method.GET, uRL_json_array, (String) null, new com.android.volley.Response.Listener<JSONArray>()
        {

            @Override
            public void onResponse(JSONArray response) {
                //output_Json_Arr.setText("Response: " + response.toString());
                //String str_json_array = response.toString();
                //output_Json_Arr.setText(str_json_array);

                String strJA = response.toString();
                try {
                    JSONArray jsonarray = new JSONArray(strJA);
                    Gson gson2 = new Gson(); // Or use new GsonBuilder().create();
                    PeopleJsonData targetJArr = new PeopleJsonData();

                    for (int i = 0; i < jsonarray.length(); i++) {
                        JSONObject jsonobject = jsonarray.getJSONObject(i);
                        String str_JObj_of_Arr = jsonobject.toString();
                        targetJArr = gson2.fromJson(str_JObj_of_Arr, PeopleJsonData.class); // deserializes json into target
                        restauratNames.add(targetJArr.fullName);
                        //output_Json_Arr.setText(targetJArr.fullName +" "+ targetJArr.jobTitle);
                        System.out.println(targetJArr.fullName);

                    }
                } catch (Exception e)
                {
                    e.getStackTrace();
                }

            }
        }, new com.android.volley.Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                // TODO Auto-generated method stub
                Toast.makeText(getActivity(), "Error in JSON", Toast.LENGTH_SHORT).show();
                Log.e("Volley","Error");

            }
        });
        requestQueue.add(jsArrRequest);

*/



        ArrayList<Restaurant> restaurantsObj = new ArrayList<Restaurant>();
        restaurantsObj = Filter.getRestaurants();


        for (int i = 0; i < restaurantsObj.size(); i++) {
            restauratNames.add(restaurantsObj.get(i).getName() + "         " + "Type: " + restaurantsObj.get(i).getCategory() );

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



















/*
package net.cloudcentrik.dagenslunchcustomer;

*/
/**
 * Created by Johir on 2/7/2017.
 *//*

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class FragmentOfTextView extends Fragment {

    public FragmentOfTextView() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.activity_fragment_textview, container, false);
    }

}
*/
