package com.example.droidcafeinput;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

public class OrderActivity extends AppCompatActivity implements
        View.OnClickListener, AdapterView.OnItemSelectedListener {
    private RadioButton samedayRadioButton;
    private RadioButton nextRadioButton;
    private RadioButton pickupRadioButton;
    private String spinerLabel;
    private Button date;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
        Intent intent = getIntent();
        String message = "Order: " + intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        TextView textView = findViewById(R.id.order_textview);
        textView.setText(message);
        samedayRadioButton = findViewById(R.id.sameday);
        samedayRadioButton.setOnClickListener(this);
        nextRadioButton = findViewById(R.id.nextday);
        nextRadioButton.setOnClickListener(this);
        pickupRadioButton = findViewById(R.id.pickup);
        pickupRadioButton.setOnClickListener(this);
        date = findViewById(R.id.button_date);
        date.setOnClickListener(this);
        Spinner spinner = findViewById(R.id.spinner);
        if (spinner != null) {
            spinner.setOnItemSelectedListener(this);
        }
        ArrayAdapter<CharSequence>adapter = ArrayAdapter.createFromResource(this,
                R.array.labels_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        if (spinner != null) {
            spinner.setAdapter(adapter);
        }
    }

    public void displayToast(String message) {
        Toast.makeText(getApplicationContext(), message,
                Toast.LENGTH_SHORT).show();

    }
    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
         spinerLabel = adapterView.getItemAtPosition(i).toString();
        displayToast(spinerLabel);
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.sameday:
                displayToast(getString(R.string.same_day_messenger_service));
                break;
            case R.id.nextday:
                displayToast(getString(R.string.next_day_ground_delivery));
                break;
            case R.id.pickup:
                displayToast(getString(R.string.pick_up));
                break;
            case R.id.button_date:
                showDatePicker();
            default:
                break;
        }
    }
    public void showDatePicker() {
        DialogFragment newFragment = new DateDelivery();
        newFragment.show(getSupportFragmentManager(),getString(R.string.date_delivery));
    }



}

