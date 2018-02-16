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

package com.lwh.jackknife.demo.ioc;

import android.content.Intent;
import android.view.View;

import com.lwh.jackknife.demo.R;
import com.lwh.jackknife.demo.animatorscrollview.AnimatorScrollViewActivity;
import com.lwh.jackknife.demo.basemodel.BaseModelActivity;
import com.lwh.jackknife.demo.bottomnavigationbar.BottomNavigationBarActivity;
import com.lwh.jackknife.demo.clearedittext.ClearEditTextActivity;
import com.lwh.jackknife.demo.commonadapter.CommonAdapterActivity;
import com.lwh.jackknife.demo.flowlayout.FlowLayoutActivity;
import com.lwh.jackknife.demo.highlighttextview.HighlightTextViewActivity;
import com.lwh.jackknife.demo.horizontaltabbar.HorizontalTabBarActivity;
import com.lwh.jackknife.demo.letterview.LetterViewActivity;
import com.lwh.jackknife.demo.macedittext.MacEditTextActivity;
import com.lwh.jackknife.demo.multiradiogroup.MultiRadioGroupActivity;
import com.lwh.jackknife.demo.mvp.ArticleActivity;
import com.lwh.jackknife.demo.nestedscrollinglistview.NestedScrollingListViewActivity;
import com.lwh.jackknife.demo.orm.OrmActivity;
import com.lwh.jackknife.demo.radarview.RadarViewActivity;
import com.lwh.jackknife.demo.shadeview.ShadeViewActivity;
import com.lwh.jackknife.demo.utils.LoggerActivity;
import com.lwh.jackknife.demo.utils.ToastActivity;

public class MenuActivity extends com.lwh.jackknife.app.Activity {

    @OnClick({
            R.id.relativelayout_logger,
            R.id.relativelayout_toastutils,
            R.id.relativelayout_basemodel,
            R.id.relativelayout_ioc,
            R.id.relativelayout_commonadapter,
            R.id.relativelayout_mvp,
            R.id.relativelayout_orm,
            R.id.relativelayout_shadeview,
            R.id.relativelayout_horizontaltabbar,
            R.id.relativelayout_multiradiogroup,
            R.id.relativelayout_letterview,
            R.id.relativelayout_nestedscrollinglistview,
            R.id.relativelayout_radarview,
            R.id.relativelayout_flowlayout,
            R.id.relativelayout_clearedittext,
            R.id.relativelayout_highlighttextview,
            R.id.relativelayout_macedittext,
            R.id.relativelayout_animatorscrollview,
            R.id.relativelayout_bottomnavigationbar
    })
    public void onMenuItemClick(View view) {
        Intent intent = new Intent();
        switch (view.getId()) {
            case R.id.relativelayout_logger:
                intent.setClass(this, LoggerActivity.class);
                break;
            case R.id.relativelayout_toastutils:
                intent.setClass(this, ToastActivity.class);
                break;
            case R.id.relativelayout_basemodel:
                intent.setClass(this, BaseModelActivity.class);
                break;
            case R.id.relativelayout_ioc:
                intent.setClass(this, IocActivity.class);
                break;
            case R.id.relativelayout_commonadapter:
                intent.setClass(this, CommonAdapterActivity.class);
                break;
            case R.id.relativelayout_mvp:
                intent.setClass(this, ArticleActivity.class);
                break;
            case R.id.relativelayout_orm:
                intent.setClass(this, OrmActivity.class);
                break;
            case R.id.relativelayout_shadeview:
                intent.setClass(this, ShadeViewActivity.class);
                break;
            case R.id.relativelayout_horizontaltabbar:
                intent.setClass(this, HorizontalTabBarActivity.class);
                break;
            case R.id.relativelayout_multiradiogroup:
                intent.setClass(this, MultiRadioGroupActivity.class);
                break;
            case R.id.relativelayout_letterview:
                intent.setClass(this, LetterViewActivity.class);
                break;
            case R.id.relativelayout_nestedscrollinglistview:
                intent.setClass(this, NestedScrollingListViewActivity.class);
                break;
            case R.id.relativelayout_radarview:
                intent.setClass(this, RadarViewActivity.class);
                break;
            case R.id.relativelayout_flowlayout:
                intent.setClass(this, FlowLayoutActivity.class);
                break;
            case R.id.relativelayout_clearedittext:
                intent.setClass(this, ClearEditTextActivity.class);
                break;
            case R.id.relativelayout_highlighttextview:
                intent.setClass(this, HighlightTextViewActivity.class);
                break;
            case R.id.relativelayout_macedittext:
                intent.setClass(this, MacEditTextActivity.class);
                break;
            case R.id.relativelayout_animatorscrollview:
                intent.setClass(this, AnimatorScrollViewActivity.class);
                break;
            case R.id.relativelayout_bottomnavigationbar:
                intent.setClass(this, BottomNavigationBarActivity.class);
                break;
        }
        startActivity(intent);
    }
}
