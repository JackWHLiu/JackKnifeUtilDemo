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

package com.lwh.jackknife.demo.commonadapter;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.lwh.jackknife.demo.R;
import com.lwh.jackknife.widget.CommonAdapter;
import com.lwh.jackknife.widget.ViewHolder;

import java.util.ArrayList;
import java.util.List;

public class CommonAdapterActivity extends Activity {

    ListView listview_commonadapter;
    CommonAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_common_adapter);
        listview_commonadapter = (ListView) findViewById(R.id.listview_commonadapter);
        listview_commonadapter.setAdapter(mAdapter = new CommonAdapter<User>(this) {
            @Override
            protected int getItemLayoutId() {
                return R.layout.item_common_adapter;
            }

            @Override
            protected int[] getItemViewIds() {
                return new int[] {R.id.textview_item, R.id.imageview_item};
            }

            @Override
            protected List<User> initDatas() {
                List<User> users = new ArrayList<>();
                users.add(new User(getResources().getDrawable(R.drawable.pikaqiu), "Jack"));
                users.add(new User(getResources().getDrawable(R.drawable.pikaqiu), "Rose"));
                return users;
            }

            @Override
            protected <VIEW extends View> void onBindViewHolder(int position, User user,
                                                                ViewHolder<VIEW> holder) {
                TextView textview_item = (TextView) holder.findViewById(R.id.textview_item);
                ImageView imageview_item = (ImageView) holder.findViewById(R.id.imageview_item);
                textview_item.setText(user.getNickname());
                imageview_item.setImageDrawable(user.getAvator());
            }
        });
    }
}
