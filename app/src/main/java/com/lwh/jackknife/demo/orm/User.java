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

package com.lwh.jackknife.demo.orm;

import com.lwh.jackknife.orm.OrmTable;
import com.lwh.jackknife.orm.PrimaryKeyEntity;
import com.lwh.jackknife.orm.constraint.AssignType;
import com.lwh.jackknife.orm.constraint.Check;
import com.lwh.jackknife.orm.constraint.Default;
import com.lwh.jackknife.orm.constraint.NotNull;
import com.lwh.jackknife.orm.constraint.PrimaryKey;
import com.lwh.jackknife.orm.constraint.Unique;
import com.lwh.jackknife.orm.table.Column;
import com.lwh.jackknife.orm.table.Table;

@Table("user")
public class User implements OrmTable {

    @PrimaryKey(AssignType.AUTO_INCREMENT)  //从1开始自增长
    @Column("_id")
    private int id;

    @Unique
    @NotNull
    @Column("name")
    @Default("张三")
    private String name;

    @NotNull
    @Column("age")
    @Check("age>=0 and age<=100") //age为列名，不要写属性名
    private int age;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public PrimaryKeyEntity getPrimaryKey() {
        return new PrimaryKeyEntity("_id", id);
    }

    @Override
    public boolean isUpgradeRecreated() {
        return false;
    }
}
