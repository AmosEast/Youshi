package com.example.amos.youshi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

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

                EditText user_name_text = (EditText)findViewById(R.id.zhuce_user_name);
                EditText user_passwd_text = (EditText)findViewById(R.id.zhuce_user_passwd);
                EditText user_passwd_re_text = (EditText)findViewById(R.id.zhuce_user_passwd_re);

                if(user_passwd_text.getText().toString().equals(user_passwd_re_text.getText().toString())) {
                    intent.putExtra("user_name", user_name_text.getText().toString());
                    intent.putExtra("user_passwd", user_passwd_text.getText().toString());
                    intent.setClass(ZhuceActivity.this, GerenActivity.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(ZhuceActivity.this, "密码不一致", Toast.LENGTH_SHORT).show();
                    user_passwd_text.getText().clear();
                    user_passwd_re_text.getText().clear();
                }
            }
        });
    }
}
