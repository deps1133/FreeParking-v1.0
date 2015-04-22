package com.example.stef.freeparking;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class sju extends ActionBarActivity {
    private Spinner spinner;
    private Button b;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sju);

        spinner = (Spinner) findViewById(R.id.spinner);
        List<String> list = new ArrayList<String>();
        list.add("Saint Joseph's University");
        list.add("Mandeville Parking Lot A");
        list.add("Mandeville Parking Lot B");

        ArrayAdapter<String> data = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,list);
        data.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(data);

        addListenerOnSpinnerItemSelection();
        addListenerOnButton();

    }

    public void addListenerOnSpinnerItemSelection(){
        spinner.setOnItemSelectedListener(new CustomOnItemSelectedListener());
    }

    public void addListenerOnButton(){
        spinner = (Spinner) findViewById(R.id.spinner);
        b = (Button) findViewById(R.id.button5);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(String.valueOf(spinner.getSelectedItem()).equals("Mandeville Parking Lot A"))
                    getOpenSJUSpots(v);
                else
                    Toast.makeText(getApplicationContext(), "No Parking Spots Available",Toast.LENGTH_SHORT).show();
            }
        });

    }

    public void getOpenSJUSpots( View view ){
        String y = "";
        for( int x = 0; x < Login.spots.length; x++ ){
            y += "Spot " + x + ": Latitude=" + Login.spots[x].latitude + "\t Longitude=" + Login.spots[x].longitude + "\n";
        }
        Toast.makeText(getApplicationContext(), y,Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_sju, menu);
        return true;
    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
