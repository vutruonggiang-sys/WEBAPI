package com.example.webapidemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.view.View;

import com.example.webapidemo.databinding.ActivityMainBinding;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
    String strJson="{\"id\":\"144\",\"publisher_id\":\"3\",\"content_type\":\"3\",\"tab\":\"0\",\"title\":\"Chinese Series\",\"avatar\":null}";
    String strJson1="[{\"id\":\"144\",\"publisher_id\":\"3\",\"content_type\":\"3\",\"tab\":\"0\",\"title\":\"Chinese Series\",\"avatar\":null},{\"id\":\"111\",\"publisher_id\":\"113\",\"content_type\":\"113\",\"tab\":\"110\",\"title\":\"Series Phim\",\"avatar\":\"----------\"}]";
    List<Product> productList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= DataBindingUtil.setContentView(this,R.layout.activity_main);
        binding.butDisplay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getJson1();
            }
        });
    }

    private void getJson(){
        try {
            JSONObject jsonObject=new JSONObject(strJson);
            int id=jsonObject.getInt("id");
            String title=jsonObject.getString("title");
            //int status=jsonObject.getInt("status");

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
    private void getJson1(){
        productList=new ArrayList<>();
        try {
            JSONArray jsonArray=new JSONArray(strJson1);
            for(int i=0;i<jsonArray.length();i++){
                JSONObject jsonObject=jsonArray.getJSONObject(i);
                int id=jsonObject.getInt("id");
                String title=jsonObject.getString("title");
                Product product=new Product(id,title);
                productList.add(product);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        AdapterProduct adapterProduct=new AdapterProduct(productList);
        binding.lvData.setAdapter(adapterProduct);
    }
}