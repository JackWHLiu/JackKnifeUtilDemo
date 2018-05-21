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

package com.lwh.jackknife.demo.toast;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.lwh.jackknife.demo.R;
import com.lwh.jackknife.util.ToastUtils;

public class ToastActivity extends Activity implements View.OnClickListener {

    Button button_toast_show;
    Button button_toast_showinsubthread;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toast);
        initViews();
        initListeners();
    }

    private void initViews() {
        button_toast_show = (Button) findViewById(R.id.button_toast_show);
        button_toast_showinsubthread = (Button) findViewById(R.id.button_toast_showinsubthread);
    }

    private void initListeners() {
        button_toast_show.setOnClickListener(this);
        button_toast_showinsubthread.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button_toast_show:
                ToastUtils.showShort(this, "主线程的Toast");
                break;
            case R.id.button_toast_showinsubthread:
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        ToastUtils.showShort(ToastActivity.this, "子线程的Toast");
                    }
                }).start();
                break;
        }
    }
}
