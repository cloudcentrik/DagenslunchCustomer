package net.cloudcentrik.dagenslunchcustomer;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by ismail on 17/02/17.
 */

public class JsonClientTestActivity extends AppCompatActivity {
    private TextView serverResponseText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_json_client_test);

        serverResponseText=(TextView)findViewById(R.id.serverResponseText);

        final Button getJsonDataButton=(Button) findViewById(R.id.testJsonClientButton);
        getJsonDataButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click
                displayRestaurantList();
            }
        });
}
    private void displayRestaurantList(){
        DagenlunchRestAPIClient client=new DagenlunchRestAPIClient();
        ArrayList<Restaurant> restaurants=client.getListOfRestaurant();

        for (int i=0;i<restaurants.size();i++){
            Log.d("id "+i, "Name "+restaurants.get(i).getName());

            serverResponseText.append(restaurants.get(i).getName()+"\n");
        }

    }
}
