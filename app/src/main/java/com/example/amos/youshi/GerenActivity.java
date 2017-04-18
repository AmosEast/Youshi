package com.example.amos.youshi;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * 此界面为个人信息界面
 */

public class GerenActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_geren);

        final Intent intent = getIntent();
        final String user_name = intent.getStringExtra("user_name");
        final String user_passwd = intent.getStringExtra("user_passwd");
        EditText user_name_text = (EditText)findViewById(R.id.geren_user_name);
        user_name_text.setText(user_name);

        Button enter = (Button) findViewById(R.id.geren_enter);
        enter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //intent.setClass(GerenActivity.this, ZhuyeActivity.class);
                //startActivity(intent);


                String url = base_url + "/youshi/SignUpController.php" ;

                EditText user_weight_text = (EditText)findViewById(R.id.geren_user_weight);
                EditText user_height_text = (EditText)findViewById(R.id.geren_user_height);
                RadioGroup user_sex_radio = (RadioGroup)findViewById(R.id.geren_user_sex);
                RadioGroup user_mode_radio = (RadioGroup)findViewById(R.id.geren_user_mode);
                EditText user_age_text = (EditText)findViewById(R.id.geren_user_age);
                RadioButton user_sex_checked = (RadioButton)findViewById(user_sex_radio.getCheckedRadioButtonId());
                RadioButton user_mode_checked = (RadioButton)findViewById(user_mode_radio.getCheckedRadioButtonId());

                String user_weight_str = user_weight_text.getText().toString();
                String user_height_str = user_height_text.getText().toString();
                String user_age_str = user_age_text.getText().toString();
                String user_sex_str = user_sex_checked.getText().toString();
                String user_mode_str = user_mode_checked.getText().toString();

                String req = "user_name=" + user_name + "&user_passwd=" + user_passwd + "&user_weight=" + user_weight_str + "&user_height=" + user_height_str + "&user_age=" + user_age_str + "&user_sex=" + user_sex_str + "&user_mode=" + user_mode_str;
                post_test(url, req, 1);
            }
        });

        //设置返回点击监听事件
//        super.ret_clicked(this);
    }

    protected void success_1(android.os.Message msg) {
        try {
            JSONObject jsonObject = new JSONObject(msg.obj.toString());
            int a = Integer.parseInt(jsonObject.getString("res"));
            if(a == 1) {
                SharedPreferences.Editor editor = getSharedPreferences("data", MODE_PRIVATE).edit();
                editor.putFloat("Calorie", Float.parseFloat(jsonObject.getString("calorie"))) ;
                editor.apply();
                final Intent intent = new Intent();
                intent.setClass(GerenActivity.this, ZhuyeActivity.class);
                startActivity(intent);
            } else {
                //登录失败
                Toast.makeText(GerenActivity.this, "注册失败，请重试", Toast.LENGTH_SHORT).show();
            }
        }catch (JSONException e) {
            Toast.makeText(GerenActivity.this, e.toString(), Toast.LENGTH_SHORT).show();
        }
    }

}
