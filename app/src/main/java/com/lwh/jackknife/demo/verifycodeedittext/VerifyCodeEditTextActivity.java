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

package com.lwh.jackknife.demo.verifycodeedittext;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.util.Log;

import com.lwh.jackknife.demo.R;
import com.lwh.jackknife.widget.SerialNumberEditTextGroup;
import com.lwh.jackknife.widget.VerifyCodeEditText;
import com.lwh.jackknife.widget.VerifyCodeEditTextGroup;

public class VerifyCodeEditTextActivity extends Activity {

    VerifyCodeEditTextGroup verifyCodeView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verify_code_edit_text);
        verifyCodeView = (VerifyCodeEditTextGroup) findViewById(R.id.verifyCodeView);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                String verifyCode = "123456";
                verifyCodeView.setText(splitText(verifyCode));
            }
        }, 2000);
    }

    private String[] splitText(String input) {
        StringBuffer sb = new StringBuffer(input);
        for (int i=0;i<input.length()*2;i+=2) {
            if (i != (input.length()-1)*2) {
                sb.insert(i+1, "_");
            }
        }
        String str = sb.toString();
        Log.i("Jack", "拆分前：" + str);
        String[] text = str.split("_");
        return text;
    }
}
