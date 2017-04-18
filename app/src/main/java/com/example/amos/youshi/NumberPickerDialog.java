package com.example.amos.youshi;

/**
 * Created by amos on 17-4-11.
 */

/*
 * Copyright (C) cuiweiyou.com/崔维友
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
        import android.app.AlertDialog;
        import android.content.Context;
        import android.content.DialogInterface;
        import android.content.DialogInterface.OnClickListener;
        import android.content.SharedPreferences;
        import android.os.Bundle;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.widget.NumberPicker;
        import android.widget.Toast;

        import static android.content.Context.MODE_PRIVATE;

/**
 * A dialog that prompts the user for the number using a NumberPicker.<br/>
 * 使用NumberPicker获取数值的对话框
 */
public class NumberPickerDialog extends AlertDialog implements OnClickListener, NumberPicker.OnValueChangeListener {

    private final String maxValue = "最大值";
    private final String minValue = "最小值";
    private final String currentValue = "当前值";

    private final NumberPicker mNumberPicker;
    private final NumberPicker.OnValueChangeListener mCallback;

    private int newVal;
    private int oldVal;
    private float cur_shiwu_cal;

    Context a;

    /**
     * @param context 上下文
     * @param callBack 回调器
     * @param maxValueNumber 最大值
     * @param minValueNumber 最小值
     * @param currentValueNumber 当前值
     */
    public NumberPickerDialog(Context context, NumberPicker.OnValueChangeListener callBack, int maxValueNumber, int minValueNumber, int currentValueNumber, float cur_cal) {
        super(context, 0);
        a = context;

        cur_shiwu_cal = cur_cal;

        mCallback = callBack;

        setIcon(0);
        setTitle("设置数字");

        Context themeContext = getContext();
        setButton(BUTTON_POSITIVE, "设置", this);
        setButton(BUTTON_NEGATIVE, "取消", this);

        LayoutInflater inflater = (LayoutInflater) themeContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.quality_picker, null);
        setView(view);
        mNumberPicker = (NumberPicker) view.findViewById(R.id.np);

        mNumberPicker.setMaxValue(maxValueNumber);
        mNumberPicker.setMinValue(minValueNumber);
        mNumberPicker.setValue(currentValueNumber);
        mNumberPicker.setOnValueChangedListener(this);
    }

    @Override
    public Bundle onSaveInstanceState() {
        Bundle state = super.onSaveInstanceState();
        state.putInt(maxValue, mNumberPicker.getMaxValue());
        state.putInt(minValue, mNumberPicker.getMinValue());
        state.putInt(currentValue, mNumberPicker.getValue());
        return state;
    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        int max = savedInstanceState.getInt(maxValue);
        int min = savedInstanceState.getInt(minValue);
        int cur = savedInstanceState.getInt(currentValue);
        mNumberPicker.setMaxValue(max);
        mNumberPicker.setMinValue(min);
        mNumberPicker.setValue(cur);
    }

    @Override
    public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
        this.oldVal = oldVal;
        this.newVal = newVal;

        //将更新后的已吃了的卡路里数写入 used 里面
        SharedPreferences editor = a.getSharedPreferences("data", MODE_PRIVATE);
        float used = editor.getFloat("used", 0);
        float temp = newVal * cur_shiwu_cal / 100 + used;
        SharedPreferences.Editor editor_w;
        editor_w = a.getSharedPreferences("data", MODE_PRIVATE).edit();
        editor_w.putFloat("used", temp);
        editor_w.apply();

    }

    @Override
    public void onClick(DialogInterface dialog, int which) {
        switch (which) {
            case BUTTON_POSITIVE:
                mCallback.onValueChange(mNumberPicker, oldVal, newVal);
                break;
        }
    }

    /**
     * <b>功能</b>: setCurrentValue，设置NumberPicker的当前值<br/>
     * @author : weiyou.com <br/>
     * @return
     */
    public NumberPickerDialog setCurrentValue(int value){

        mNumberPicker.setValue(value);
        return this;
    }

    public int getNewVal() {
        return newVal;
    }
}
