package com.example.apiallreadwritedeleteupdatemehedivi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

public class MainActivity extends AppCompatActivity {
    Button read,write,delete,update;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        read=findViewById(R.id.read_id);
        read.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),Read_Activity.class);
                startActivity(intent);
            }
        });
        write=findViewById(R.id.write_id);
        write.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),Write_Activity.class);
                startActivity(intent);
            }
        });
        update=findViewById(R.id.update_id);
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),Update_Activity.class);
                startActivity(intent);
            }
        });
        delete=findViewById(R.id.delete_id);
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),Delete_Activity.class);
                startActivity(intent);
            }
        });
    }
}