/*
 * Copyright (C) 2018. The JackKnife Open Source Project
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

package com.lwh.jackknife.demo.utils;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.lwh.jackknife.demo.R;
import com.lwh.jackknife.util.Logger;

public class LoggerActivity extends Activity implements View.OnClickListener{

    TextView textview_logger_tips;
    Button button_logger_case;
    Button button_logger_print;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logger);
        initViews();
        initListeners();
    }

    private void initViews() {
        textview_logger_tips = (TextView) findViewById(R.id.textview_logger_tips);
        button_logger_case = (Button) findViewById(R.id.button_logger_case);
        button_logger_print = (Button) findViewById(R.id.button_logger_print);
    }

    private void initListeners() {
        button_logger_case.setOnClickListener(this);
        button_logger_print.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button_logger_case:
                if (Logger.isClosed()) {//改变日志开关
                    Logger.open();
                } else {
                    Logger.close();
                }
                refreshCase();
                break;
            case R.id.button_logger_print:
                Logger.info("logger print log.");
                break;
        }
    }

    private void refreshCase() {
        if (Logger.isOpened()) {
            textview_logger_tips.setText("日志开关:开");
            button_logger_case.setText("关闭日志");
        } else {
            textview_logger_tips.setText("日志开关:关");
            button_logger_case.setText("打开日志");
        }
    }
}
