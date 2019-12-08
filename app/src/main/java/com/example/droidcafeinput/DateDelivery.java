package com.example.droidcafeinput;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.Toast;

import java.util.Calendar;


public class DateDelivery extends DialogFragment
        implements DatePickerDialog.OnDateSetListener {


    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        final Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DAY_OF_MONTH);


        return new DatePickerDialog(getActivity(), this, year, month, day);
    }
    public void processDatePickerResult(int year, int month, int day) {

        String month_string = Integer.toString(month+1);
        String day_string = Integer.toString(day);
        String year_string = Integer.toString(year);

        String dateMessage = (month_string +
                getString(R.string.slash) + day_string + getString(R.string.slash) + year_string);
        Toast.makeText(getContext(), getString(R.string.date_delivery) + dateMessage,
                Toast.LENGTH_SHORT).show();
    }


    @Override
    public void onDateSet(DatePicker datePicker, int year, int month, int day) {
        processDatePickerResult(year, month, day);
    }
}