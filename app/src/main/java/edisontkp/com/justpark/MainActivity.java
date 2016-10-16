package edisontkp.com.justpark;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import cz.msebera.android.httpclient.entity.StringEntity;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private SeekBar seekBar;
    private TextView tv_car_park_duration_lbl;
    private TextView tv_car_park_fee;
    private TextView tvClock2;
    private Button pay_button;
    private int duration;
    Gson gson;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initializeVariables();
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        gson = new Gson();


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        fab.setVisibility(View.GONE);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        //content main
        Spinner staticSpinner = (Spinner) findViewById(R.id.static_spinner);

        String[] items = new String[] { "MPSA", "JPJ" };


// Create an ArrayAdapter using the string array and a default spinner
//        ArrayAdapter<CharSequence> staticAdapter = ArrayAdapter
//                .createFromResource(this, items,
//                        android.R.layout.simple_spinner_item);

        ArrayAdapter<String> staticAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, items);
        // Specify the layout to use when the list of choices appears
        staticAdapter
                .setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // Apply the adapter to the spinner
        staticSpinner.setAdapter(staticAdapter);


        //time
//        Calendar c = Calendar.getInstance();
//        System.out.println("Current time => "+c.getTime());
//
//        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        String formattedDate = df.format(c.getTime());
//        // formattedDate have current date/time
//        Toast.makeText(this, formattedDate, Toast.LENGTH_SHORT).show();

        final TextView tvClock = (TextView)findViewById(R.id.tvClock);
        final Handler someHandler = new Handler(getMainLooper());
        someHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                tvClock.setText(new SimpleDateFormat("yyyy/MM/dd HH:mm:ss", Locale.US).format(new Date()));
                someHandler.postDelayed(this, 1000);
            }
        }, 10);

//        final TextView tvClock2 = (TextView)findViewById(R.id.tvClock2);
//        final Handler someHandler2 = new Handler(getMainLooper());
//        someHandler.postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                tvClock2.setText(new SimpleDateFormat("yyyy/MM/dd HH:mm:ss", Locale.US).format(new Date()));
//                someHandler2.postDelayed(this, 1000);
//            }
//        }, 10);


        tv_car_park_duration_lbl.setText("Car Park Duration: " + seekBar.getProgress() + " Hour");

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int progress = 0;

            @Override
            public void onProgressChanged(SeekBar seekBar, int progresValue, boolean fromUser) {
                progress = progresValue;
//                Toast.makeText(getApplicationContext(), "Changing seekbar's progress", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
//                Toast.makeText(getApplicationContext(), "Started tracking seekbar", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                tv_car_park_duration_lbl.setText("Car Park Duration: " + progress + " Hour");
                tv_car_park_fee.setText("RM "+ progress * 2);
                Calendar cal = Calendar.getInstance();
                cal.add(Calendar.HOUR_OF_DAY, progress);
                tvClock2.setText(new SimpleDateFormat("yyyy/MM/dd HH:mm:ss", Locale.US).format(cal.getTime()));
                duration = progress;
//                Toast.makeText(getApplicationContext(), "Stopped tracking seekbar", Toast.LENGTH_SHORT).show();
            }
        });

        pay_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                paynow();

            }
        });

    }

    // A private method to help us initialize our variables.
    private void initializeVariables() {
        seekBar = (SeekBar) findViewById(R.id.seekBar1);
        tv_car_park_duration_lbl = (TextView) findViewById(R.id.tv_car_park_duration_lbl);
        tv_car_park_fee = (TextView)findViewById(R.id.tv_car_park_fee);
        tvClock2 = (TextView)findViewById(R.id.tvClock2);
        pay_button = (Button)findViewById(R.id.pay_button);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
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

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


    public void paynow(){

    }




//      example json object

//    JSONObject jsonParams = new JSONObject();
//    jsonParams.put("notes", "Test api support");
//    StringEntity entity = new StringEntity(jsonParams.toString());
//    client.post(context, restApiUrl, entity, "application/json",
//    responseHandler);

//    public void paynow (){
//
//        final AsyncHttpClient client = new AsyncHttpClient();
//        JSONObject jsonParams = new JSONObject();
//        jsonParams.put("amount", );
//        jsonParams.put("payee", );
//        jsonParams.put("payer", );
//        jsonParams.put("duration",duration);
//        jsonParams.put("status","request");
//
//        StringEntity entity = new StringEntity(jsonParams.toString());
//        client.setTimeout(10000);
//
//        client.post("http://justpark.azurewebsites.net/api/transactionsapi", entity, new AsyncHttpResponseHandler() {
//
//                    @Override
//                    public void onSuccess(int statusCode, cz.msebera.android.httpclient.Header[] headers, byte[] responseBody) {
//
//                        accessModel =  gson.fromJson(new String(responseBody), AccessModel.class);
//
//
////                        pd.dismiss();
//                    }
//
//                    @Override
//                    public void onStart() {
//
////                        pd = new ProgressDialog(Login.this);
////                        pd.setProgressStyle(ProgressDialog.STYLE_SPINNER);
////                        //pd.setIcon(R.drawable.newalert); // you can set your own icon here
////                        pd.setTitle(R.string.title_please_wait);
////                        pd.setMessage(getString(R.string.message_loading));
////                        pd.setIndeterminate(false);
////                        pd.setCancelable(false); // this will disable the back button
////                        pd.show();
//
//                    }
//
//                    @Override
//                    public void onFailure(int statusCode, cz.msebera.android.httpclient.Header[] headers, byte[] responseBody, Throwable error) {
//                        // time out
////                        pd.dismiss();
//
//                    }
//                }
//
//        );
//
//    }
}
