package net.cloudcentrik.dagenslunchcustomer;

import android.os.AsyncTask;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.IOException;
import java.util.List;

import retrofit2.Call;

public class MainActivity extends AppCompatActivity {

    private TextView txtTest;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         txtTest= (TextView) findViewById(R.id.txtServerResponse);

        final Button button = (Button) findViewById(R.id.getRequest);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click
                new DagenslunchAPICallTask().execute("");
            }
        });

    }

    private class DagenslunchAPICallTask extends AsyncTask<String, Void, String> {

        List<People> persons;
        @Override
        protected String doInBackground(String... params) {
            DagenslunchService dagenslunchService = DagenslunchService.retrofit.create(DagenslunchService.class);
            Call<List<People>> call = dagenslunchService.getPeopleList();
            try {
                List<People> result = call.execute().body();
                Log.d("test",result.get(0).toString());
                persons=(List<People>)result;

            }
            catch (IOException ex){

            }
            return "Executed";
        }

        @Override
        protected void onPostExecute(String result) {

            for(int i=0;i<persons.size();i++){

                txtTest.append("\n");
                txtTest.append(persons.get(i).getFullName()+"  "+persons.get(i).getJobTitle());

            }


        }

    }
}
