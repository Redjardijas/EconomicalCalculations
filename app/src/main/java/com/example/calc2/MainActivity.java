package com.example.calc2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TableLayout;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    Spinner spinner;
    Button butZakaz, butAdd, butPercent;
    TableLayout tableLayout1, tableLayout2, tableLayout3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Калькулятор для Лены");
        // Spinner element
        tableLayout1 = findViewById(R.id.tabZakaz);
        tableLayout2 = findViewById(R.id.tabPescentage);
        tableLayout3 = findViewById(R.id.tabAddition);
        spinner = (Spinner) findViewById(R.id.spinner);
        butZakaz = findViewById(R.id.btnzakaz);
        butAdd = findViewById(R.id.btndetails);
        butPercent = findViewById(R.id.btnpercent);
        // Spinner click listener
        // spinner.setOnItemSelectedListener((AdapterView.OnItemSelectedListener) this);
        // Spinner Drop down elements
      /*  List<String> categories = new ArrayList<String>();
        categories.add("Item 1");
        categories.add("Item 2");
        categories.add("Item 3");
        categories.add("Item 4");
        categories.add("Item 5");
        categories.add("Item 6");*/

/*butZakaz./*setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        tableLayout1.setVisibility(View.VISIBLE);
    }
});*/

        // Creating adapter for spinner
        ArrayAdapter<?> adapter = ArrayAdapter.createFromResource(this, R.array.animals, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        //  ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, categories);

        // attaching data adapter to spinner
        spinner.setAdapter(adapter);


        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent,
                                       View itemSelected, int selectedItemPosition, long selectedId) {

                String[] choose = getResources().getStringArray(R.array.animals);
                Toast toast = Toast.makeText(getApplicationContext(),
                        "Ваш выбор: " + choose[selectedItemPosition], Toast.LENGTH_SHORT);
                toast.show();
            }

            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
        butZakaz.setOnClickListener(showTabZ);
        butAdd.setOnClickListener(showTabD);
        butPercent.setOnClickListener(showTabP);
    }

    View.OnClickListener showTabZ = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (tableLayout1.getVisibility() == View.VISIBLE) {
                tableLayout1.setVisibility(View.INVISIBLE);
            } else {
                tableLayout1.setVisibility(View.VISIBLE);
            }
        }
    };
    View.OnClickListener showTabP = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (tableLayout2.getVisibility() == View.VISIBLE) {
                tableLayout2.setVisibility(View.INVISIBLE);
            } else {
                tableLayout2.setVisibility(View.VISIBLE);
            }
        }
    };
    View.OnClickListener showTabD = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (tableLayout3.getVisibility() == View.VISIBLE) {
                tableLayout3.setVisibility(View.INVISIBLE);
            } else {
                tableLayout3.setVisibility(View.VISIBLE);
            }
        }
    };
}

   /* public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        // On selecting a spinner item
        String item = parent.getItemAtPosition(position).toString();

        // Showing selected spinner item
        Toast.makeText(parent.getContext(), "Selected: " + item, Toast.LENGTH_LONG).show();

    }*/
/*
    public void onNothingSelected(AdapterView<?> arg0) {
        // TODO Auto-generated method stub

    }
    }*/

