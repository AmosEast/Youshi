package com.example.amos.youshi;

/**
 * Created by amos on 17-4-5.
 * 该类左右所有activity的基类，即所有类都需要继承该类
 */
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import java.util.List;

public class BaseActivity extends AppCompatActivity {

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
}
