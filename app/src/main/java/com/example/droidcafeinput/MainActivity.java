package com.example.droidcafeinput;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.DialogFragment;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    public static final String EXTRA_MESSAGE = "com.example.vitaliy.droidcafeinput.extra.MESSAGE";
    private ImageView donut;
    private ImageView iceCream;
    private ImageView froyo;
    FloatingActionButton fab;
    private  String mOrderMessage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        fab = findViewById(R.id.fab);
        fab.setOnClickListener(this);
        donut = findViewById(R.id.donut);
        iceCream = findViewById(R.id.ice_cream);
        froyo = findViewById(R.id.froyo);
        donut.setOnClickListener(this);
        iceCream.setOnClickListener(this);
        froyo.setOnClickListener(this);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
       switch (item.getItemId()){
           case R.id.action_order :
               displayToast(getString(R.string.action_order_message));
               Intent intent = new Intent(MainActivity.this, OrderActivity.class);
               intent.putExtra(EXTRA_MESSAGE, mOrderMessage);
               startActivity(intent);
               return true;
           case R.id.  action_status :
               displayToast(getString(R.string.action_status_message));
               return true;
           case R.id. action_favorites  :
               displayToast(getString(R.string.action_favorites_message));
               return true;
           case R.id. action_contact  :
               displayToast(getString(R.string.action_contact_message));
               return true;
               default:
       }

        return super.onOptionsItemSelected(item);
    }

    public void displayToast(String message) {
        Toast.makeText(getApplicationContext(), message,
                Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.donut:
                mOrderMessage = getString(R.string.donut_order_message);
                displayToast(mOrderMessage);
                break;
            case R.id.ice_cream:
                mOrderMessage = getString(R.string.ice_cream_order_message);
                displayToast(mOrderMessage);
                break;
            case R.id.froyo:
                mOrderMessage = getString(R.string.froyo_order_message);
                displayToast(mOrderMessage);
                break;
            case R.id.fab:
                Intent intent = new Intent(MainActivity.this, OrderActivity.class);
                intent.putExtra(EXTRA_MESSAGE, mOrderMessage);
                startActivity(intent);
                break;

        }

    }
}
