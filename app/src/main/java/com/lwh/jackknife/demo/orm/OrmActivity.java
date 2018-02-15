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

package com.lwh.jackknife.demo.orm;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import com.lwh.jackknife.demo.R;
import com.lwh.jackknife.orm.Orm;
import com.lwh.jackknife.orm.OrmConfig;
import com.lwh.jackknife.orm.TableManager;
import com.lwh.jackknife.orm.builder.QueryBuilder;
import com.lwh.jackknife.orm.builder.WhereBuilder;
import com.lwh.jackknife.orm.dao.Dao;
import com.lwh.jackknife.orm.dao.DaoFactory;
import com.lwh.jackknife.orm.dao.OrmDao;
import com.lwh.jackknife.util.Logger;
import com.lwh.jackknife.util.TextUtils;
import com.lwh.jackknife.util.TimeUtils;

import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

public class OrmActivity extends Activity {

    TextView textview_orm_user;
    OrmDao<User> mUserDao;
    OrmDao<Order> mOrderDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_orm);
        initViews();
        done();
    }

    private void initViews() {
        textview_orm_user = (TextView) findViewById(R.id.textview_orm_user);
    }

    private void done() {
        //---------- 强烈建议这段代码写在Application（开始） ----------
        OrmConfig config = new OrmConfig.Builder()
                .database("ormdemo")//数据库名称
                .version(1)//数据库版本号，默认1，只能升不能降
                .build();
        Orm.init(this, config);
        TableManager.getInstance().createTable(User.class);//创表
        TableManager.getInstance().createTable(Order.class);
        //---------- 强烈建议这段代码写在Application（结束）----------
        mUserDao = DaoFactory.getDao(User.class);
        mOrderDao = DaoFactory.getDao(Order.class);
        User celica = new User("Celica", 16);
        mUserDao.insert(celica);//单个数据保存
        List<User> users = new ArrayList<>();
        User alm = new User("Alm", 17);
        User mycen = new User("Mycen", 54);
        users.add(alm);
        users.add(mycen);
        mUserDao.insert(users);//集合数据保存
        int celicaId = mUserDao.selectOne(QueryBuilder.create().where(WhereBuilder.create().addWhereEqualTo("name", "Celica"))).getId();
        int almId = mUserDao.selectOne(QueryBuilder.create().where(WhereBuilder.create().addWhereEqualTo("name", "Alm"))).getId();
        int mycenId = mUserDao.selectOne(QueryBuilder.create().where(WhereBuilder.create().addWhereEqualTo("name", "Mycen"))).getId();
        mOrderDao.insert(new Order(TimeUtils.long2str(System.currentTimeMillis(), "yyyyMMddHHmmssSSS")
                + TextUtils.getUUID().substring(0, 4), celicaId, 100.3));
        mOrderDao.insert(new Order(TimeUtils.long2str(System.currentTimeMillis(), "yyyyMMddHHmmssSSS")
                + TextUtils.getUUID().substring(0, 4), almId, 39.2));
        mOrderDao.insert(new Order(TimeUtils.long2str(System.currentTimeMillis(), "yyyyMMddHHmmssSSS")
                + TextUtils.getUUID().substring(0, 4), mycenId, 298.9));
        mOrderDao.insert(new Order(TimeUtils.long2str(System.currentTimeMillis(), "yyyyMMddHHmmssSSS")
                + TextUtils.getUUID().substring(0, 4), mycenId, 101.7));
        List<Order> orders = mOrderDao.selectAll();
        long orderCount = mOrderDao.selectCount();
        Order firstOrder = mOrderDao.selectOne();
        Logger.error(firstOrder.toString());
        Logger.error("orderCount="+orderCount);
        List<User> result = mUserDao.select(QueryBuilder.create()
                .groupBy("name")//按name分组，并排序，字母或数字升序
                .having("age < 20")//条件，必须在分组之后使用。在SQL中增加HAVING子句原因是，WHERE关键字无法与合计函数一起使用。
                .orderBy("age DESC")//排序，最终的排序，在groupby排序之后，默认的ASC可省略，sql的关键字大小写不敏感，即也可以age asc
                .limit(0, 2)//截取下标为0和1的2条数据，limit传一个参数表示个数，传两个参数表示截取
                .where(WhereBuilder.create()
                        .parenthesesLeft()// (
                        .addWhereGreaterThan("age", 15) //age > 15
                        .and()  // and
                        .addWhereLessThanOrEqualTo("age", 17) // age <= 17
                        .parenthesesRight()  // )
                        .orWhereEqualTo("name", "Alm")  //or name = alm
                )

        );
        if (orders.size() > 0) {
            for (Order order : orders) {
                Logger.error(order.toString());
            }
        }
        for (User user : result) {
            Logger.error(user.toString());
        }
    }
}
