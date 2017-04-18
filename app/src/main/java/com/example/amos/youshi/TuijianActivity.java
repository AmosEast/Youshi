package com.example.amos.youshi;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.ActionBar;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * 此界面为饮食推荐界面
 */

public class TuijianActivity extends BaseActivity {

    RemoteImageHelper lazyImageHelper = new RemoteImageHelper();
    private List<Shiwu> shiwuList=new ArrayList<>();
    private int canshi_pos;
    private int mode_pos;
    private ShiwuAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tuijian);

        //initShiwus();
        adapter =new ShiwuAdapter(TuijianActivity.this,R.layout.shiwu,shiwuList);
        ListView listView = (ListView) findViewById(R.id.shiwu);
        listView.setAdapter(adapter);

        //设置返回点击监听事件
        super.ret_clicked(this);

        //餐时
        final Spinner canshi_spinner = (Spinner)findViewById(R.id.canshi);
        final Spinner mode_spinner = (Spinner)findViewById(R.id.mode);
        canshi_pos = canshi_spinner.getSelectedItemPosition();
        mode_pos = mode_spinner.getSelectedItemPosition();
        canshi_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {

//                String[] canshi = getResources().getStringArray(R.array.canshi);
                canshi_pos = pos;
//                String[] mode = getResources().getStringArray(R.array.changes);
                //Toast.makeText(TuijianActivity.this, "你点击的是:" + canshi[pos] + mode[mode_pos], Toast.LENGTH_SHORT).show();
                String req = "canshi_pos=" + canshi_pos + "&mode_pos=" + mode_pos;
                String url = base_url + "/youshi/GetMenuController.php";
                post_test(url, req, 1);
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // Another interface callback
            }
        });

        mode_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
//                String[] canshi = getResources().getStringArray(R.array.canshi);
//                String[] mode = getResources().getStringArray(R.array.changes);
                mode_pos = pos;
                //Toast.makeText(TuijianActivity.this, "你点击的是:" + canshi[canshi_pos] + mode[pos], Toast.LENGTH_SHORT).show();
                String req = "canshi_pos=" + canshi_pos + "&mode_pos=" + mode_pos;
                String url = base_url + "/youshi/GetMenuController.php";
                post_test(url, req, 1);
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // Another interface callback
            }
        });

    }

//    private void initShiwus(){
//        for(int i=0;i<3;i++){
//            Shiwu apple=new Shiwu("Apple", R.drawable.apple,"water");
//            shiwuList.add(apple);
//            Shiwu banana=new Shiwu("Banana",R.drawable.apple_pic,"water");
//            shiwuList.add(banana);
//            Shiwu orange=new Shiwu("Orange",R.drawable.logo,"water");
//            shiwuList.add(orange);
//        }
//    }

    protected void success_1(android.os.Message msg) {
        try {
//            Toast.makeText(TuijianActivity.this, msg.obj.toString(), Toast.LENGTH_SHORT).show();

            adapter.clear();
            JSONArray jsonArray = new JSONArray(msg.obj.toString());
            shiwuList.clear();
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                String name = jsonObject.getString("name");
                String src = jsonObject.getString("src");
                String calorie = jsonObject.getString("calorie");
                Shiwu shiwu = new Shiwu(name, src, calorie);
                shiwuList.add(shiwu);

//                initXItems(data);
                adapter.notifyDataSetChanged();
            }

        }catch (JSONException e) {
            Toast.makeText(TuijianActivity.this, e.toString(), Toast.LENGTH_SHORT).show();
        }
    }

}
