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

package com.lwh.jackknife.demo.horizontaltabbar;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.lwh.jackknife.demo.R;
import com.lwh.jackknife.widget.HorizontalTabBar;

import java.util.ArrayList;
import java.util.List;

public class HorizontalTabBarActivity extends FragmentActivity implements ViewPager.OnPageChangeListener {

    HorizontalTabBar horizontaltabbar;
    ViewPager viewpager;
    private FragmentPagerAdapter adapter;
    private List<TabFragment> tabFragments;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_horizontal_tab_bar);
        horizontaltabbar = (HorizontalTabBar) findViewById(R.id.horizontaltabbar);
        viewpager = (ViewPager) findViewById(R.id.viewpager);
        tabFragments = new ArrayList<>();
        String[] titles = new String[]{"精选表情", "更多表情"};
        for (String title : titles) {
            TabFragment tabFragment = new TabFragment();
            Bundle bundle = new Bundle();
            bundle.putString("title", title);
            tabFragment.setArguments(bundle);
            tabFragments.add(tabFragment);
        }
        adapter = new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public int getCount() {
                return tabFragments.size();
            }

            @Override
            public Fragment getItem(int position) {
                return tabFragments.get(position);
            }
        };
        viewpager.setAdapter(adapter);
        horizontaltabbar.setTitles(titles);
        horizontaltabbar.setAverage(true);//平分Tab
        horizontaltabbar.setIndicatorColorResource(R.color.green);//资源id直接设置
        horizontaltabbar.setSelectedTextColor(getResources().getColor(R.color.green));//颜色要通过resource拿
        horizontaltabbar.setTabTextColor(Color.GRAY);
        horizontaltabbar.setTabTextSize(20);
        viewpager.setOnPageChangeListener(this);
        horizontaltabbar.setOnTabClickListener(new HorizontalTabBar.OnTabClickListener() {

            @Override
            public boolean onTabClick(View view, int position) {
                viewpager.setCurrentItem(position);
                //true 表示吞没事件，不会执行horizontaltabbar的颜色切换，会由viewpager的回调方法
                //改变当前的选中。
                //false 用在和fragment结合使用，没有滑动事件的，就要自己改变当前选中的tab的颜色。
                return true;
            }
        });
    }
    @Override
    public void onPageScrollStateChanged(int state) {
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        horizontaltabbar.setPositionOffset(position, positionOffset);
    }

    @Override
    public void onPageSelected(int position) {
        horizontaltabbar.setSelectedPosition(position);
    }
}
