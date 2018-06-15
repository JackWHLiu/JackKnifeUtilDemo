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

package com.lwh.jackknife.demo.ioc2;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import com.lwh.jackknife.demo.R;
import com.lwh.jackknife.ioc2.ViewInjector;
import com.lwh.jackknife.ioc2.annotation.ContentView;
import com.lwh.jackknife.ioc2.annotation.ViewInject;

@ContentView(R.layout.activity_ioc2)
public class Ioc2Activity extends Activity {

    @ViewInject(R.id.tv_ioc2_text1)
    TextView mTextViewOne;

    @ViewInject(R.id.tv_ioc2_text2)
    TextView mTextViewTwo;

    @ViewInject(R.id.tv_ioc2_text3)
    TextView mTextViewThree;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ViewInjector.inject(this);
        mTextViewOne.setText("ioc2使用的是编译期注解");
        mTextViewTwo.setText("效率高但有局限性，只支持对Activity的注入");
        mTextViewThree.setText("老版ioc的功能更全");
    }
}
