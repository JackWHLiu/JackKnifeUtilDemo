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

package com.lwh.jackknife.demo.shadeview;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.lwh.jackknife.demo.R;
import com.lwh.jackknife.widget.ShadeView;

public class ShadeViewActivity extends FragmentActivity implements ViewPager.OnPageChangeListener,
		View.OnClickListener {


	private List<TabFragment> tabFragments;
	private List<ShadeView> tabIndicators;

	private ViewPager viewPager;

	private FragmentPagerAdapter adapter;

	private ShadeView shadeview_weixin;

	private ShadeView shadeview_contacts;

	private ShadeView shadeview_discover;

	private ShadeView shadeview_me;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_shade_view);
		initData();
		viewPager = (ViewPager) findViewById(R.id.viewpager);
		viewPager.setAdapter(adapter);
		viewPager.setOnPageChangeListener(this);
	}

	private void initData() {
		tabFragments = new ArrayList<>();
		tabIndicators = new ArrayList<>();
		String[] titles = new String[]{"微信", "通讯录", "发现", "我"};
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
			public Fragment getItem(int arg0) {
				return tabFragments.get(arg0);
			}
		};
		initTabIndicators();
	}

	private void initTabIndicators() {
		shadeview_weixin = (ShadeView) findViewById(R.id.shadeview_weixin);
		shadeview_contacts = (ShadeView) findViewById(R.id.shadeview_contacts);
		shadeview_discover = (ShadeView) findViewById(R.id.shadeview_discover);
		shadeview_me = (ShadeView) findViewById(R.id.shadeview_me);
		tabIndicators.add(shadeview_weixin);
		tabIndicators.add(shadeview_contacts);
		tabIndicators.add(shadeview_discover);
		tabIndicators.add(shadeview_me);
		shadeview_weixin.setOnClickListener(this);
		shadeview_contacts.setOnClickListener(this);
		shadeview_discover.setOnClickListener(this);
		shadeview_me.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		resetTabsStatus();
		switch (v.getId()) {
			case R.id.shadeview_weixin:
				tabIndicators.get(0).setShade(1.0f);
				viewPager.setCurrentItem(0, false);
				break;
			case R.id.shadeview_contacts:
				tabIndicators.get(1).setShade(1.0f);
				viewPager.setCurrentItem(1, false);
				break;
			case R.id.shadeview_discover:
				tabIndicators.get(2).setShade(1.0f);
				viewPager.setCurrentItem(2, false);
				break;
			case R.id.shadeview_me:
				tabIndicators.get(3).setShade(1.0f);
				viewPager.setCurrentItem(3, false);
				break;
		}
	}

	private void resetTabsStatus() {
		for (int i = 0; i < tabIndicators.size(); i++) {
			tabIndicators.get(i).setShade(0.0f);
		}
	}

	@Override
	public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
		if (positionOffset > 0) {
			ShadeView leftTab = tabIndicators.get(position);
			ShadeView rightTab = tabIndicators.get(position + 1);
			leftTab.setShade(1 - positionOffset);
			rightTab.setShade(positionOffset);
		}
	}

	@Override
	public void onPageSelected(int position) {
		if (position == 2) {
			tabIndicators.get(position).setIconResource(R.drawable.discover_green);
		} else {
			tabIndicators.get(2).setIconResource(R.drawable.discover);
		}
	}

	@Override
	public void onPageScrollStateChanged(int state) {
	}
}
