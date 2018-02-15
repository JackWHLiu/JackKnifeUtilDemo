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

import com.lwh.jackknife.mvp.BaseModel;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class MobileModel extends BaseModel<Mobile> {

    public MobileModel() {
        super(Mobile.class);
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
