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

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import com.lwh.jackknife.demo.R;
import com.lwh.jackknife.orm.builder.QueryBuilder;
import com.lwh.jackknife.orm.builder.WhereBuilder;
import com.lwh.jackknife.orm.dao.DaoFactory;
import com.lwh.jackknife.orm.dao.OrmDao;
import com.lwh.jackknife.util.Logger;

import java.util.ArrayList;
import java.util.List;

public class OrmActivity extends Activity {

    TextView textview_orm_user;

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
        OrmDao<User> dao = DaoFactory.getDao(User.class);
        dao.insert(new User("Celica", 16));
        List<User> users = new ArrayList<>();
        users.add(new User("Alm", 17));
        users.add(new User("Mycen", 54));
        dao.insert(users);
//        dao.delete(WhereBuilder.create().addWhereEqualTo("age", 54));//删除Mycen
        User user = dao.selectOne();
        textview_orm_user.setText(user.toString());
        for (User u:dao.select(QueryBuilder.create().limit(1,2))) {//limit传一个参数表示个数，传两个参数表示截取
            Logger.error(u.toString());
        }
    }
}
