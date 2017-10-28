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

package com.lwh.jackknife.demo;

import com.lwh.jackknife.mvp.BaseModel;

import java.util.ArrayList;
import java.util.List;

public class MobileModel extends BaseModel<Mobile> {

    public MobileModel(Class<Mobile> mobileClass) {
        super(mobileClass);
    }

    @Override
    protected List<Mobile> initBeans() {
        List<Mobile> mobiles = new ArrayList<>();
        mobiles.add(new Mobile("MI", "2S", 399));
        mobiles.add(new Mobile("魅族", "MX6", 1799));
        mobiles.add(new Mobile("oppo", "r11", 2999));
        mobiles.add(new Mobile("MI", "6", 2899));
        mobiles.add(new Mobile("魅族", "MX4", 700));
        mobiles.add(new Mobile("MI", "MIX2", 4399));
        mobiles.add(new Mobile("苹果", "6s", 3600));
        return mobiles;
    }

    public List<Mobile> findByCondition() {
        Selector selector = Selector.create()
                .addWhereEqualTo("brand", "MI")
                .addWhereGreatorThanOrEqualTo("price", 1000)
                .addWhereLessThan("price", 3000);
        try {
            return findObjects(selector);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
        return null;
    }
}
