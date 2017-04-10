package com.example.amos.youshi;

/**
 * Created by amos on 17-4-5.
 * 该类左右所有activity的基类，即所有类都需要继承该类
 */
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class BaseActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
}
