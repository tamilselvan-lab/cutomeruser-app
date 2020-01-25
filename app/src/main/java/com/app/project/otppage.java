package com.app.project;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

public class otppage extends AppCompatActivity {

    private Button mButton;
    private String url = "http://34.107.236.207/api/users/";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otppage);

        mButton = findViewById(R.id.button_btn);

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(getApplicationContext(), "click paniten", Toast.LENGTH_SHORT).show();
                RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());


                StringRequest stringRequest = new StringRequest(Request.Method.POST, url ,
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
                ) {
                    @Override
                    protected String getParamsEncoding() {
                        return "{ \"user\": {\"contact\" : \"12345623\", \"user_type\": \"CustomerUser\", \"name\": \"796\", \"requested_action\": \"LoginRequest\"  }}";
                    };
                };
                requestQueue.add(stringRequest);
            }
        });
//        mButton.setOnClickListener({
//                Toast.makeText(getApplicationContext(), "click paniten", Toast.LENGTH_SHORT).show();
//        });
    }

}
