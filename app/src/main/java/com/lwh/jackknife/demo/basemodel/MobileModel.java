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

package com.lwh.jackknife.demo.basemodel;

import com.lwh.jackknife.mvp.BaseModel;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class MobileModel extends BaseModel<Mobile> {

    public MobileModel(Class<Mobile> mobileClass) {
        super(mobileClass);
    }

    @Override
    protected List<Mobile> initBeans() {
        List<Mobile> mobiles = new ArrayList<>();
        mobiles.add(new Mobile(randomSerialNumber(), "MI", "2S", 399));
        mobiles.add(new Mobile(randomSerialNumber(), "魅族", "MX6", 1799));
        mobiles.add(new Mobile(randomSerialNumber(), "oppo", "r11", 2999));
        mobiles.add(new Mobile(randomSerialNumber(), "MI", "6", 2899));
        mobiles.add(new Mobile(randomSerialNumber(), "魅族", "MX4", 700));
        mobiles.add(new Mobile(randomSerialNumber(), "MI", "MIX2", 4399));
        mobiles.add(new Mobile(randomSerialNumber(), "苹果", "6s", 3600));
        return mobiles;
    }

    public String randomSerialNumber() {
        return UUID.randomUUID().toString().substring(0, 12).toUpperCase().replace("-", "");
    }

    public List<Mobile> findAll() {
        return findObjects(null);
    }

    public List<Mobile> findWhereBrandEqualToApple() {
        Selector selector = Selector.create().addWhereEqualTo("brand", "苹果");
        return findObjects(selector);
    }

    public List<Mobile> findWhereBrandEqualToMiAndPriceIn1000To3000() {
        Selector selector = Selector.create()
                .addWhereEqualTo("brand", "MI")
                .addWhereGreatorThanOrEqualTo("price", 1000)
                .addWhereLessThan("price", 3000.0f);
        return findObjects(selector);
    }

    public List<Mobile> findWhereModelNumberContainsXAndPriceGreatorThanOrEqualTo1799() {
        Selector selector = Selector.create()
                .addWhereContains("modelNumber", "X")
                .addWhereGreatorThanOrEqualTo("price", 1799.0f);
        return findObjects(selector);
    }
}
