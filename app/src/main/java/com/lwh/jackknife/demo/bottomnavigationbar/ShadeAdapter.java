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

package com.lwh.jackknife.demo.bottomnavigationbar;

import android.support.v4.view.ViewPager;

import com.lwh.jackknife.widget.OnShadeChangeListener;

/**
 * 把OnShadeChangeListener接口适配成OnPageChangeListener接口。
 *
 * @author lwh
 */
public class ShadeAdapter implements ViewPager.OnPageChangeListener {

    private OnShadeChangeListener mAdaptee;//被适配的对象

    public ShadeAdapter(OnShadeChangeListener adaptee) {
        this.mAdaptee = adaptee;
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        //TODO 此处还可以增加一些新接口所拥有的特有的新功能
        mAdaptee.onShadeChanged(position, positionOffset);
    }

    @Override
    public void onPageSelected(int position) {
    }

    @Override
    public void onPageScrollStateChanged(int state) {
    }
}
