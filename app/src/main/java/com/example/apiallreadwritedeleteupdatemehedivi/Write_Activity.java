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

public class Write_Activity extends AppCompatActivity {
    EditText ename,emobile;
    Button add;
    RequestQueue queue;
    //private static final String url="http://192.168.42.122/api/add_m.php";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_write);
        queue= Volley.newRequestQueue(Write_Activity.this);
        ename=findViewById(R.id.name_e_id);
        emobile=findViewById(R.id.mobile_e_id);
        add=findViewById(R.id.add_id);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               String gEname=ename.getText().toString().trim();
              String gEmobile=emobile.getText().toString().trim();
                
                initData(gEname,gEmobile);
            }
        });
    }

    private void initData(String gEname, String gEmobile) {

        StringRequest request=new StringRequest(Request.Method.POST,
                conUrl.write,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Toast.makeText(Write_Activity.this, "inserted", Toast.LENGTH_SHORT).show();
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                })
        {
            @Nullable
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> map=new HashMap<>();
                map.put("name",gEname);
                map.put("mobile",gEmobile);

                return map;
            }
        };
        queue.add(request);
    }


}