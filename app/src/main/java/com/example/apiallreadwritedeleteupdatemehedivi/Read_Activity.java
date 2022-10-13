package com.example.apiallreadwritedeleteupdatemehedivi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.apiallreadwritedeleteupdatemehedivi.Adapters.Read_Adapter;
import com.example.apiallreadwritedeleteupdatemehedivi.Adapters.conUrl;
import com.example.apiallreadwritedeleteupdatemehedivi.Model.read_model;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Read_Activity extends AppCompatActivity {
    RequestQueue queue;
   // private static final String url="http://192.168.42.122/api/getdata_m.php";
    //String url="http://192.168.42.122/api/getdata_m.php";
    RecyclerView recycler_read;
    List<read_model> arraydata;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read);
        arraydata=new ArrayList<>();
        recycler_read=findViewById(R.id.recy_red);
        queue= Volley.newRequestQueue(Read_Activity.this);

        JsonArrayRequest request=new JsonArrayRequest(
                Request.Method.GET,
                conUrl.read,
                null,
                new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                Log.i("TAG","onResponse before :");
                Toast.makeText(Read_Activity.this, "Read", Toast.LENGTH_LONG).show();
            for (int i=0;i<response.length();i++){
                try {
                    JSONObject object=response.getJSONObject(i);

                    int id=object.getInt("id");
                    String name=object.getString("name");
                    String phone=object.getString("mobile");
                    Log.i("TAG","onResponse before :"+phone);
                    read_model read=new read_model(id,name,phone);
                    arraydata.add(read);


                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
                Read_Adapter adapter=new Read_Adapter(Read_Activity.this,arraydata);
                recycler_read.setAdapter(adapter);
                recycler_read.setLayoutManager(new LinearLayoutManager(Read_Activity.this));

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(Read_Activity.this, error.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    queue.add(request);
    }
}