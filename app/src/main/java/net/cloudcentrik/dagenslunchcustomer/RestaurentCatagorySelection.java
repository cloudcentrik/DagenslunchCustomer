package net.cloudcentrik.dagenslunchcustomer;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.guna.libmultispinner.MultiSelectionSpinner;

import java.util.List;

/**
 * Created by Johir on 2/9/2017.
 */

public class RestaurentCatagorySelection extends AppCompatActivity implements MultiSelectionSpinner.OnMultipleItemsSelectedListener{


    /**
     * The {@link ViewPager} that will host the section contents.
     */
    private ViewPager mViewPager;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Multi spinner
        String[] array = {"1 KM", "5 KM", "Buffet", "Traditional", "Pizzaria", "Indiska", "Mexican", "Vegeterian", "Italian", "LowPrice"};
        MultiSelectionSpinner multiSelectionSpinner = (MultiSelectionSpinner) findViewById(R.id.mySpinner);
        multiSelectionSpinner.setItems(array);
        multiSelectionSpinner.setSelection(new int[]{0, });
        multiSelectionSpinner.setListener(this);

;
        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.



    }

    @Override
    public void selectedIndices(List<Integer> indices) {

    }

    @Override
    public void selectedStrings(List<String> strings) {
        Toast.makeText(this, strings.toString(), Toast.LENGTH_LONG).show();
    }


}
