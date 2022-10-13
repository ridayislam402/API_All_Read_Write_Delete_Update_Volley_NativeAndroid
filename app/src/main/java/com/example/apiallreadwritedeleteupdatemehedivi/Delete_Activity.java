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

public class Delete_Activity extends AppCompatActivity {
    EditText eid_d;
    Button delete_btn;
    RequestQueue queue;
  //  private static final String url="http://192.168.0.109/api/deldata_m.php";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete);
        queue= Volley.newRequestQueue(Delete_Activity.this);
        eid_d=findViewById(R.id.id_d_id);
        delete_btn=findViewById(R.id.delete_btn_id);
        delete_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String idds=eid_d.getText().toString().trim();

                deleteData(idds);

            }
        });
    }

    private void deleteData(String idds) {
        StringRequest request=new StringRequest(Request.Method.POST,
                conUrl.delete,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Toast.makeText(Delete_Activity.this, "Deleted", Toast.LENGTH_SHORT).show();
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                }
                )
        {
            @Nullable
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> mapdel=new HashMap<>();
                mapdel.put("id",idds);
                return mapdel;
            }
        };

        queue.add(request);
    }
}