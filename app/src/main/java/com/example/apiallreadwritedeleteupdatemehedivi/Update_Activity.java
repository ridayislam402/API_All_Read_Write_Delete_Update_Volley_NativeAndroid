package com.example.apiallreadwritedeleteupdatemehedivi;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.apiallreadwritedeleteupdatemehedivi.Adapters.conUrl;

import java.util.HashMap;
import java.util.Map;

public class Update_Activity extends AppCompatActivity {
    EditText uname,umobile,uid;
    Button uupdate;
    RequestQueue queue;
   // private static final String url="http://192.168.0.105/api/editdata_m.php";
    //editdata_m.php
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);
        queue= Volley.newRequestQueue(Update_Activity.this);

        uid=findViewById(R.id.id_u_id);
        uname=findViewById(R.id.name_u_id);
        umobile=findViewById(R.id.mobile_u_id);
        uupdate=findViewById(R.id.update_btn_id);
        uupdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String usid=uid.getText().toString().trim();
                String usname=uname.getText().toString().trim();
                String usmobile=umobile.getText().toString().trim();

                uadateData(usid,usname,usmobile);
            }
        });


    }

    private void uadateData(String usid, String usname, String usmobile) {
        StringRequest request=new StringRequest(Request.Method.POST,
                conUrl.update,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Toast.makeText(Update_Activity.this, "Update", Toast.LENGTH_SHORT).show();
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }
        )
        {
            @Nullable
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> mapu=new HashMap<>();
                mapu.put("id",usid);
                mapu.put("name",usname);
                mapu.put("mobile",usmobile);
                return mapu;
            }
        };

    queue.add(request);
    }
}