package com.example.amos.youshi;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * 该界面作为登录界面
 */

public class DengluActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_denglu);

        final Intent intent = new Intent();

        Button sign_in =(Button) findViewById(R.id.sign_in_denglu);
        sign_in.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                intent.setClass(DengluActivity.this, ZhuyeActivity.class);
                startActivity(intent);
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
}
