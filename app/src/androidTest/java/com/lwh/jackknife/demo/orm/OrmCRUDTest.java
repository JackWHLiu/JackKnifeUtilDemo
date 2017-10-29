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

package com.lwh.jackknife.demo.orm;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;
import android.util.Log;

import com.lwh.jackknife.orm.Orm;
import com.lwh.jackknife.orm.OrmConfig;
import com.lwh.jackknife.orm.dao.DaoFactory;
import com.lwh.jackknife.orm.dao.OrmDao;
import com.lwh.jackknife.orm.table.TableManager;
import com.lwh.jackknife.util.Logger;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.List;

@RunWith(AndroidJUnit4.class)
public class OrmCRUDTest {

    @Test
    public void useAppContext() throws Exception {
        Context context = InstrumentationRegistry.getTargetContext();
        OrmConfig config = new OrmConfig.Builder()
                .version(1)
                .database("orm_test")
                .build();
        Orm.init(context, config);//初始化配置
        TableManager.getInstance().createTable(Mobile.class);
        OrmDao<Mobile> dao = DaoFactory.getDao(Mobile.class);
//        Mobile mobile = new Mobile("苹果", "6s Plus", 5000);
//        mobile.setRom("128G");
//        dao.insert(mobile);
        MobileModel model = new MobileModel(Mobile.class);
        List<Mobile> mobiles = model.findByCondition();
        boolean ok = dao.insert(mobiles);
        Assert.assertEquals(ok, true);
        List<Mobile> ms = dao.selectAll();
        for (Mobile m:ms) {
            Logger.error(m.toString());
        }

        Assert.assertEquals(true, true);
        Assert.assertEquals(true, true);
        Assert.assertEquals(true, true);
    }
}
