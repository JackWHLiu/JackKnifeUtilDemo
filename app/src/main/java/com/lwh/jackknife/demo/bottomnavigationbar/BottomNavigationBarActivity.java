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

package com.lwh.jackknife.demo.bottomnavigationbar;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.widget.RadioGroup;

import com.lwh.jackknife.demo.R;
import com.lwh.jackknife.demo.shadeview.TabFragment;
import com.lwh.jackknife.widget.BottomNavigationBar;

import java.util.ArrayList;
import java.util.List;

public class BottomNavigationBarActivity extends FragmentActivity {

    private BottomNavigationBar mBottomNavigationBar;//底部导航栏，可点击切换 或 点击切换+滑动颜色渐变
    private ViewPager mViewPager;//滑动页，可以换成单纯的Fragment集合
    private List<TabFragment> mTabs;
    private FragmentPagerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mTabs = new ArrayList<>();
        setContentView(R.layout.activity_bottom_navigation_bar);
        mBottomNavigationBar = (BottomNavigationBar) findViewById(R.id.bnb);
        mViewPager = (ViewPager) findViewById(R.id.vp);
        mBottomNavigationBar.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                switch (checkedId) {
                    case R.id.shadeview_weixin:
                        mViewPager.setCurrentItem(0, false);
                        break;
                    case R.id.shadeview_contacts:
                        mViewPager.setCurrentItem(1, false);
                        break;
                    case R.id.shadeview_discover:
                        mViewPager.setCurrentItem(2, false);
                        break;
                    case R.id.shadeview_me:
                        mViewPager.setCurrentItem(3, false);
                        break;
                }
            }
        });
        String[] titles = new String[]{"微信", "通讯录", "发现", "我"};
        for (String title : titles) {
            TabFragment fragment = new TabFragment();
            Bundle bundle = new Bundle();
            bundle.putString("title", title);
            fragment.setArguments(bundle);
            mTabs.add(fragment);
        }
        adapter = new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public int getCount() {
                return mTabs.size();
            }

            @Override
            public Fragment getItem(int arg0) {
                return mTabs.get(arg0);
            }
        };
        mViewPager.setAdapter(adapter);
        mViewPager.setOnPageChangeListener(new ShadeAdapter(mBottomNavigationBar));
    }
}
