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

package com.lwh.jackknife.demo.ioc;

import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.lwh.jackknife.app.Activity;
import com.lwh.jackknife.demo.R;
import com.lwh.jackknife.ioc.annotation.ContentView;
import com.lwh.jackknife.ioc.annotation.OnClick;
import com.lwh.jackknife.ioc.annotation.ViewIgnore;
import com.lwh.jackknife.ioc.annotation.ViewInject;

/**
 * 测试jackknife-ioc的自动设置布局、绑定控件和注入事件。
 */
@ContentView(R.layout.activity_ioc)//此注解可以配置，也可以不配置，参考ViewInjector#generateLayoutName()
public class IocActivity extends Activity {

    LinearLayout linearlayout_ioc_root;//可以使用默认的id

    @ViewInject(R.id.textview_ioc_count)//也可以自己指定id
    TextView mCountTextView;

    @ViewIgnore//此注解用在使用代码new出来的View
    TextView mTipsTextView;

    private int mCurrent;

    @OnClick(R.id.button_ioc_plus)
    public void plus(View view) {
        mCountTextView.setText(++mCurrent+"");
        mTipsTextView = new TextView(this);
        mTipsTextView.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT));
        mTipsTextView.setText("继续点击，直到点不到我为止");
        linearlayout_ioc_root.addView(mTipsTextView, 1);
    }
}
