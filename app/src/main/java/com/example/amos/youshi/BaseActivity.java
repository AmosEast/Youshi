package com.example.amos.youshi;

/**
 * Created by amos on 17-4-5.
 * 该类左右所有activity的基类，即所有类都需要继承该类
 */
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

public class BaseActivity extends AppCompatActivity {

    protected Handler handler = new Handler() {

        public void handleMessage(android.os.Message msg) {

            if (msg.what == 1) {
                success_1(msg);
            }else if(msg.what == 2) {
                success_2(msg);
            }else {
                error_what(msg);
            }


        }

    };


    //当what为1时的执行函数
    protected void success_1(android.os.Message msg) {

    }
    //当what为2时的执行函数
    protected void success_2(android.os.Message msg) {

    }
    //当what为其他时的执行函数
    protected void error_what(android.os.Message msg) {

    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    protected void ret_clicked(final BaseActivity baseActivity) {
        ImageButton ret_btn = (ImageButton) findViewById(R.id.ret_btn);
        final Intent intent = new Intent();
        ret_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                baseActivity.finish();
            }
        });
    }

    protected void post_test(final String http_url,final String req, final int what_code) {


        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    URL url = new URL(http_url);
                    HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                    conn.setRequestMethod("POST");
                    conn.setDoOutput(true);
                    conn.setConnectTimeout(5000);
                    conn.setReadTimeout(5000);
                    OutputStream os = conn.getOutputStream();

                    //发送请求
                    os.write(req.getBytes());
                    //反馈信息
                    if (conn.getResponseCode() == 200) {

                        InputStream is = conn.getInputStream();

                        BufferedReader br = new BufferedReader(new InputStreamReader(is));

                        String result = br.readLine();

                        Message msg = new Message();
                        msg.what = what_code;
                        msg.obj = result;
                        handler.sendMessage(msg);

                        is.close();

                        os.close();

                        conn.disconnect();

                    }

                } catch (Exception e) {

                    // TODO Auto-generated catch block

                    e.printStackTrace();

                }
            }
        }).start();


    }
}
