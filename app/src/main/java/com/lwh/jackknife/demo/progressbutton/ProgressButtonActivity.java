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

package com.lwh.jackknife.demo.progressbutton;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;

import com.lwh.jackknife.demo.R;
import com.lwh.jackknife.util.ToastUtils;
import com.lwh.jackknife.widget.ProgressButton;

public class ProgressButtonActivity extends Activity {

    private ProgressButton mProgressButton;
    private Button mResetButton;
    private static final int MSG_BUTTON_REFRESH = 0;
    private static final int MSG_BUTTON_PAUSE = 1;
    private static final int MSG_BUTTON_FINISH = 2;
    private static final int MSG_BUTTON_RESET = 3;
    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case MSG_BUTTON_REFRESH:
                    float progress = mProgressButton.getProgress() + 0.1f;
                        if (progress <= 99.9f) {
                        mProgressButton.setProgressText("下载中", progress);
                        Message message = mHandler.obtainMessage(MSG_BUTTON_REFRESH);
                        mHandler.sendMessageDelayed(message, 40);
                    } else {
                        mHandler.sendEmptyMessage(MSG_BUTTON_FINISH);
                    }
                    break;
                case MSG_BUTTON_PAUSE:
                    mProgressButton.setText("继续");
                    break;
                case MSG_BUTTON_FINISH:
                    mProgressButton.setState(mProgressButton.STATE_FINISH);
                    mProgressButton.setText("安装中");
                    mHandler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            mProgressButton.setText("打开");
                            mProgressButton.setState(ProgressButton.STATE_NORMAL);
                        }
                    }, 2000);
                    break;
                case MSG_BUTTON_RESET:
                    mHandler.removeMessages(MSG_BUTTON_REFRESH);
                    mProgressButton.reset();
                    mProgressButton.setText("安装");
                    break;
            }
        }
    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress_button);
        mProgressButton = (ProgressButton) findViewById(R.id.mProgressButton);
        mResetButton = (Button) findViewById(R.id.mResetButton);
        mProgressButton.setShowBorder(true);
        mProgressButton.setText("安装");
        mProgressButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onButtonClick();
            }
        });
        mResetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mHandler.obtainMessage(MSG_BUTTON_RESET).sendToTarget();
            }
        });
    }

    private void onButtonClick() {
        if (mProgressButton.getState() == ProgressButton.STATE_NORMAL
                || mProgressButton.getState() == ProgressButton.STATE_PAUSE) {
            mProgressButton.setState(ProgressButton.STATE_PENDING);
            mHandler.obtainMessage(MSG_BUTTON_REFRESH).sendToTarget();
            return;
        }
        if (mProgressButton.getState() == ProgressButton.STATE_PENDING) {
            mProgressButton.setState(ProgressButton.STATE_PAUSE);
            mHandler.removeMessages(MSG_BUTTON_REFRESH);
            mHandler.obtainMessage(MSG_BUTTON_PAUSE).sendToTarget();
            return;
        }
    }
}
