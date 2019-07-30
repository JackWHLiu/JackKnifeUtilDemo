/*
 * Copyright (C) 2018 The JackKnife Open Source Project
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
import android.view.View;
import android.widget.TextView;

import com.lwh.jackknife.demo.R;
import com.lwh.jackknife.ioc.annotation.OnClick;
import com.lwh.jackknife.ioc2.Ioc2EventSupport;
import com.lwh.jackknife.ioc2.ViewInjector;
import com.lwh.jackknife.ioc2.annotation.ContentView;
import com.lwh.jackknife.ioc2.annotation.ViewInject;

@ContentView(R.layout.activity_ioc2)
public class Ioc2Activity extends Activity implements Ioc2EventSupport {

    @ViewInject(R.id.tv_ioc2_text1)
    TextView mTextViewOne;

    @ViewInject(R.id.tv_ioc2_text2)
    TextView mTextViewTwo;

    @ViewInject(R.id.tv_ioc2_text3)
    TextView mTextViewThree;

    @OnClick(R.id.tv_ioc2_text3)
    public void onClick2(View view) {
        mTextViewThree.setText("----------------------------");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ioc2);
        mTextViewOne = (TextView) findViewById(R.id.tv_ioc2_text1);
        mTextViewTwo = (TextView) findViewById(R.id.tv_ioc2_text2);
        mTextViewThree = (TextView) findViewById(R.id.tv_ioc2_text3);
        ViewInjector.injectEvents(this);
        mTextViewOne.setText("ioc2使用的是编译期注解");
        mTextViewTwo.setText("ioc2避免了反射，性能比老版本ioc好");
        mTextViewThree.setText("ioc2支持Activity和Fragment");
    }

    @Override
    public Object getView(int id) {
        return findViewById(id);
    }
}
