package net.cloudcentrik.dagenslunchcustomer;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Johir on 1/17/2017.
 */

public class RestaurantCatagorySelection extends AppCompatActivity {
    private Spinner spinner;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addItemsOnSpinner();

        addListenerOnSpinnerItemSelection();
    }

    // add items into spinner dynamically
    public void addItemsOnSpinner() {

        spinner = (Spinner) findViewById(R.id.spinner);
        List<String> list = new ArrayList<String>();
        list.add("list");
        //list.add("list 2");

        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, list);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(dataAdapter);
    }

    public void addListenerOnSpinnerItemSelection() {
        spinner = (Spinner) findViewById(R.id.spinner);
        spinner.setOnItemSelectedListener(new RestaurantCatagorySelectionListener());
    }

    // get the selected dropdown list value

    }

