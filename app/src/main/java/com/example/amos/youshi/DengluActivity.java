package com.example.amos.youshi;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import static android.icu.text.DateTimePatternGenerator.PatternInfo.OK;

/**
 * 该界面作为登录界面
 */

public class DengluActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_denglu);

        final Intent intent = new Intent();

        //监听登录按钮
        Button sign_in =(Button) findViewById(R.id.sign_in_denglu);
        sign_in.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                String url = base_url + "/youshi/SignInController.php" ;
                //获得登录的用户名和密码
                EditText denglu_account = (EditText) findViewById(R.id.denglu_account);
                EditText denglu_passwd = (EditText) findViewById(R.id.denglu_passwd);
                String username = denglu_account.getText().toString();
                String password = denglu_passwd.getText().toString();
                //组织请求信息
                String req = "user_name=" + username + "&passwd=" + password;
                denglu_account.getText().clear();
                denglu_passwd.getText().clear();
                post_test(url, req, 1);
            }
        });

        Button sign_up = (Button) findViewById(R.id.sign_up_denglu);
        sign_up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.setClass(DengluActivity.this, ZhuceActivity.class);
                startActivity(intent);
            }
        });
    }

    protected void success_1(android.os.Message msg) {
        try {
            JSONObject jsonObject = new JSONObject(msg.obj.toString());
            int a = Integer.parseInt(jsonObject.getString("res"));
            if(a == 1) {
                //登录成功
                SharedPreferences.Editor editor = getSharedPreferences("data", MODE_PRIVATE).edit();
                editor.putBoolean("denglu", true);
                editor.apply();
                final Intent intent = new Intent();
                intent.setClass(DengluActivity.this, ZhuyeActivity.class);
                startActivity(intent);
            } else {
                //登录失败
                Toast.makeText(DengluActivity.this, "登录失败，请检查用户名和密码", Toast.LENGTH_SHORT).show();
            }
        }catch (JSONException e) {
            Toast.makeText(DengluActivity.this, e.toString(), Toast.LENGTH_SHORT).show();
        }
    }

}
