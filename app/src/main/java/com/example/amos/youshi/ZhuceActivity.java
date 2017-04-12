package com.example.amos.youshi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * 该界面为注册界面
 */

public class ZhuceActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zhuce);

        final Intent intent = new Intent();

        final Button sign_up = (Button) findViewById(R.id.sign_up_zhuce);
        sign_up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.setClass(ZhuceActivity.this, GerenActivity.class);
                startActivity(intent);
            }
        });
    }
}
