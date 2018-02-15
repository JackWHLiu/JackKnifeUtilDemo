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

package com.lwh.jackknife.demo.letterview;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import com.lwh.jackknife.demo.R;
import com.lwh.jackknife.util.ToastUtils;
import com.lwh.jackknife.widget.LetterView;

public class LetterViewActivity extends Activity {

    private LetterView letterview;
    private TextView textview_dialog;
    private ListView listview;
    private ContactAdapter mAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_letter_view);
        letterview = (LetterView) findViewById(R.id.letterview);
        textview_dialog = (TextView) findViewById(R.id.textview_dialog);
        listview = (ListView) findViewById(R.id.listview);
        listview.setAdapter(mAdapter = new ContactAdapter(this));
        listview.addHeaderView(LayoutInflater.from(this).inflate(R.layout.item_head, null));
        letterview.setOnLetterChangeListener(new LetterView.OnLetterChangeListener() {

            @Override
            public void onChanged(String s) {
                textview_dialog.setText(s);
                int position = mAdapter.getPositionForSection(s.charAt(0));
                ToastUtils.showShort(LetterViewActivity.this, "导航到字母"+s+",position="+position);
                listview.setSelection(position);
            }
        });
        letterview.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_UP:
                        textview_dialog.setVisibility(View.GONE);
                        break;
                    case MotionEvent.ACTION_DOWN:
                        textview_dialog.setVisibility(View.VISIBLE);
                        break;
                }
                return false;
            }
        });
    }
}
