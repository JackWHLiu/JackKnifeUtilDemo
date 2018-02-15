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

package com.lwh.jackknife.demo.basemodel;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import com.lwh.jackknife.demo.R;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class BaseModelActivity extends Activity {

    TextView textview_basemodel_resultone;
    TextView textview_basemodel_resulttwo;
    TextView textview_basemodel_resultthree;
    TextView textview_basemodel_resultfour;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base_model);
        initViews();
        done();
    }

    private void initViews() {
        textview_basemodel_resultone = (TextView) findViewById(R.id.textview_basemodel_resultone);
        textview_basemodel_resulttwo = (TextView) findViewById(R.id.textview_basemodel_resulttwo);
        textview_basemodel_resultthree = (TextView) findViewById(R.id.textview_basemodel_resultthree);
        textview_basemodel_resultfour = (TextView) findViewById(R.id.textview_basemodel_resultfour);
    }

    public String randomSerialNumber() {
        return UUID.randomUUID().toString().substring(0, 12).toUpperCase().replace("-", "");
    }

    private void done() {
        MobileModel model = new MobileModel();
        List<Mobile> mobiles = new ArrayList<>();
        mobiles.add(new Mobile(randomSerialNumber(), "MI", "2S", 399));
        mobiles.add(new Mobile(randomSerialNumber(), "魅族", "MX6", 1799));
        mobiles.add(new Mobile(randomSerialNumber(), "oppo", "r11", 2999));
        mobiles.add(new Mobile(randomSerialNumber(), "MI", "6", 2899));
        mobiles.add(new Mobile(randomSerialNumber(), "魅族", "MX4", 700));
        mobiles.add(new Mobile(randomSerialNumber(), "MI", "MIX2", 4399));
        mobiles.add(new Mobile(randomSerialNumber(), "苹果", "6s", 3600));
        model.add(mobiles);
        List<Mobile> mobiles2 = model.findAll();
        textview_basemodel_resultone.setText("查询全部结果:\n----------\n"+printResult(mobiles2));
        mobiles2 = model.findWhereBrandEqualToApple();
        textview_basemodel_resulttwo.setText("查询所有苹果手机:\n----------\n"+formatResult(mobiles2));
        mobiles2 = model.findWhereBrandEqualToMiAndPriceIn1000To3000();
        textview_basemodel_resultthree.setText("查询价格在[1000,3000)的小米手机:\n----------\n"+formatResult(mobiles2));
        mobiles2 = model.findWhereModelNumberContainsXAndPriceGreatorThanOrEqualTo1799();
        textview_basemodel_resultfour.setText("价格大于1799.0元型号包含X的手机:\n----------\n"+formatResult(mobiles2));
    }

    private String printResult(List<Mobile> mobiles) {
        StringBuilder sb = new StringBuilder();
        for (Mobile mobile : mobiles) {
            sb.append(mobile.toString()+"\n");
        }
        return sb.toString();
    }

    private String formatResult(List<Mobile> mobiles) {
        StringBuilder sb = new StringBuilder();
        for (Mobile mobile : mobiles) {
            sb.append("手机:"+mobile.getBrand()+" "+mobile.getModelNumber()+"\n")
                    .append("售价:"+mobile.getPrice()+"\n");
        }
        return sb.toString();
    }
}
