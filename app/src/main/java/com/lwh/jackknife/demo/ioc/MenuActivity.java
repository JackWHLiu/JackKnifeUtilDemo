/*
 * Copyright (C) 2017. The JackKnife Open Source Project
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
import com.lwh.jackknife.demo.commonadapter.CommonAdapterActivity;
import com.lwh.jackknife.demo.mvp.MvpActivity;
import com.lwh.jackknife.demo.orm.OrmActivity;

public class MenuActivity extends com.lwh.jackknife.app.Activity {

    @OnClick({R.id.relativelayout_ioc,
            R.id.relativelayout_commonadapter,
            R.id.relativelayout_mvp,
            R.id.relativelayout_orm})
    public void onMenuItemClick(View view) {
        Intent intent = new Intent();
        switch (view.getId()) {
            case R.id.relativelayout_ioc:
                intent.setClass(this, IocActivity.class);
                break;
            case R.id.relativelayout_commonadapter:
                intent.setClass(this, CommonAdapterActivity.class);
                break;
            case R.id.relativelayout_mvp:
                intent.setClass(this, MvpActivity.class);
                break;
            case R.id.relativelayout_orm:
                intent.setClass(this, OrmActivity.class);
                break;
        }
       startActivity(intent);
    }
}
