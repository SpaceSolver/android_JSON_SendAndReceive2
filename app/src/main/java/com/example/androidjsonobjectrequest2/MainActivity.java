package com.example.androidjsonobjectrequest2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.bumptech.glide.Glide;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private RequestQueue mQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void onClickGetInfo(View view)
    {
        try
        {
            // URL
            String url = "http://10.0.2.2:8088";

            // リクエストパラメータ
//            Map<String, String> params = new HashMap();
//            params.put("num", "1");
//            params.put("name", "2");
//
//            JSONObject parameters = new JSONObject(params);

            mQueue = Volley.newRequestQueue(this);
            //mQueue.add(new JsonObjectRequest(Request.Method.POST, url, parameters,
            mQueue.add(new JsonObjectRequest(Request.Method.GET, url, null,
                    new Response.Listener<JSONObject>()
                    {
                        @Override
                        public void onResponse(JSONObject response)
                        {
                            // JSONObjectのパース、List、Viewへの追加等
                            ParseJSON(response);
                        }
                    },
                    new Response.ErrorListener()
                    {
                        @Override public void onErrorResponse(VolleyError error)
                        {
                            Log.e("Error", "レスポンスエラー\n");
                            DispWetherInfoErr(error);
                        }
                    }));
        }
        catch(Exception e)
        {
            Log.e("Error", "例外発生\n" + e);
        }
    }

    public void ParseJSON(JSONObject response)
    {
        try
        {
            Log.d("Debug", "Response is: OK\n");

            // タイトル（地点）
            TextView textview = findViewById(R.id.WetherInfoText);
            String title = response.getString("num");
            //textview.setText(title);

        }
        catch (JSONException e)
        {
            e.printStackTrace();
        }
    }

    public void DispWetherInfoErr(VolleyError error)
    {
        TextView textview = findViewById(R.id.WetherInfoText);
        textview.setText("Response is: NG\n" + error);
    }
}
