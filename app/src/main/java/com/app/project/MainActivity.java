package com.app.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.toolbox.Volley;
import com.android.volley.RequestQueue;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

public class MainActivity extends AppCompatActivity {
    private Button mButton;
    private EditText mobilenumber;

    String url ="http://34.107.236.207/api/users/user_exists?contact=+91";
//    RequestQueue requestQueue = Volley.newRequestQueue(this);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mobilenumber = findViewById(R.id.editText5);

        mButton = findViewById(R.id.button_send);

        mButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                Toast.makeText(getApplicationContext(), mobilenumber.getText() , Toast.LENGTH_SHORT).show();

                RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());


                StringRequest stringRequest = new StringRequest(Request.Method.GET, url + mobilenumber.getText(),
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {
                               Toast.makeText(getApplicationContext(), response, Toast.LENGTH_LONG).show();
                            }
                        },
                        new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {
                                Toast.makeText(getApplicationContext(), error.toString(), Toast.LENGTH_LONG).show();
                            }
                        }
                );
                requestQueue.add(stringRequest);
                Toast.makeText(getApplicationContext(), url + mobilenumber.getText(), Toast.LENGTH_LONG).show();

                Intent  intent = new Intent(getApplicationContext(), otppage.class );
                startActivity(intent);
            }
        });

    }


}
