package com.a7hills.fbtools;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.HurlStack;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;


public class MainActivity extends AppCompatActivity {

    private static final String SECURE_URL = "https://begen.ca";
    public static final String PUBLIC_KEY = "30820122300d0609...........";
    public static final String TAG = "MainActivity";
    private RequestQueue requestQueue;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);

        requestQueue = Volley.newRequestQueue(this, new HurlStack(null, pinnedSSLSocketFactory()));



        StringRequest postRequest = new StringRequest(Request.Method.POST, "https://begen.ca/app.php",
                new Response.Listener<String>()
                {
                    @Override
                    public void onResponse(String response) {
                        // response
                        Log.d("Response", response);
                    }
                },
                new Response.ErrorListener()
                {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // error
                        Log.d("Error.Response", error.getMessage());
                    }
                }
        ) {
            @Override
            protected Map<String, String> getParams()
            {
                Map<String, String>  params = new HashMap<String, String>();
                params.put("name", "Alif");

                return params;
            }
        };
        requestQueue.add(postRequest);






    }




    private void sendRequest(){
        StringRequest request = new StringRequest(Request.Method.GET, SECURE_URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Toast.makeText(MainActivity.this, "Response: " + response, Toast.LENGTH_SHORT).show();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(MainActivity.this, "Failed!", Toast.LENGTH_SHORT).show();
                Log.e(TAG, "Request failed: " + error.toString());
            }
        });
        requestQueue.add(request);
    }

    private SSLSocketFactory pinnedSSLSocketFactory() {
        TrustManager tm[] = {new PubKeyManager(PUBLIC_KEY)};
        SSLContext context;
        try {
            context = SSLContext.getInstance("TLS");
            context.init(null, tm, null);
            return context.getSocketFactory();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (KeyManagementException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void buttonClick(View view) {
        sendRequest();
    }

}
