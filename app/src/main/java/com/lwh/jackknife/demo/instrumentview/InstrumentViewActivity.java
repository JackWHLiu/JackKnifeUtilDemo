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

package com.lwh.jackknife.demo.instrumentview;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;

import com.lwh.jackknife.demo.R;
import com.lwh.jackknife.util.NumberUtils;
import com.lwh.jackknife.widget.InstrumentView;

import java.util.Random;

public class InstrumentViewActivity extends Activity {

    private InstrumentView instrumentView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instrument_view);
        instrumentView = (InstrumentView) findViewById(R.id.instrumentview);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                instrumentView.setRatio(0.1f);
                instrumentView.setBody("10万吨");
            }
        }, 1000);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                instrumentView.setRatio(0.3f);
                instrumentView.setBody("30万吨");
            }
        }, 2000);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                instrumentView.setRatio(0.2f);
                instrumentView.setBody("20万吨");
            }
        }, 3000);
    }
}
