package edisontkp.com.justpark;

import android.app.ProgressDialog;
import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import cn.pedant.SweetAlert.SweetAlertDialog;
import edisontkp.com.justpark.model.PayParkResponseModel;

public class HistoryActivity extends AppCompatActivity {
//
//    private ProgressDialog pDialog;
//
//
//    ListView lv;
//    Context context;
//
//    ArrayList prgmName;
//    public static String [] prgmNameList={"Let Us C","c++","JAVA","Jsp","Microsoft .Net","Android","PHP","Jquery","JavaScript"};
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_history);
//        if (getSupportActionBar() != null) {
//            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//            getSupportActionBar().setTitle("History");
//        }
//        getHistory();
//        context=this;
//
//        lv=(ListView) findViewById(R.id.listView);
//        lv.setAdapter(new HistoryListAdapter(this, prgmNameList));
//    }
//
//    public void getHistory(){
//
//        String url = "http://justpark.azurewebsites.net/api/transactionsapi";
//
//        ProgressDialog pDialog = new ProgressDialog(this);
//        pDialog.setMessage("Loading...");
//        pDialog.show();
//
//        StringRequest strReq = new StringRequest(Request.Method.GET,
//                url, new Response.Listener<String>() {
//
//            @Override
//            public void onResponse(String response) {
//                Toast.makeText(HistoryActivity.this,response,Toast.LENGTH_LONG).show();
//
//            }
//        }, new Response.ErrorListener() {
//
//            @Override
//            public void onErrorResponse(VolleyError error) {
//
//            }
//        });
//
//// Adding request to request queue
//        RequestQueue requestQueue = Volley.newRequestQueue(this);
//        requestQueue.add(strReq);
//
//    }
//
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        switch (item.getItemId()) {
//            // Respond to the action bar's Up/Home button
//            case android.R.id.home:
//                finish();
//                break;
//        }
//        return super.onOptionsItemSelected(item);
//    }

}
