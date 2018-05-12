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

import com.lwh.jackknife.orm.OrmTable;
import com.lwh.jackknife.orm.constraint.AssignType;
import com.lwh.jackknife.orm.constraint.Default;
import com.lwh.jackknife.orm.constraint.PrimaryKey;
import com.lwh.jackknife.orm.table.Column;
import com.lwh.jackknife.orm.table.Table;

/**
 * 订单表。
 *
 * @author lwh
 */
@Table("my_order")//order这个表名不能用，不信拉倒，sql的关键字
public class Order implements OrmTable {

    /**
     * 订单编号。
     */
    @Column("order_id")
    @PrimaryKey(AssignType.BY_MYSELF)   // 自己指定其值
    private String orderId;

    @Column("user_id")
    private int userId;

    /**
     * 结算清单。
     */
    @Column("money")
    private double money;

    public Order(String orderId, int userId, double money) {
        this.orderId = orderId;
        this.userId = userId;
        this.money = money;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId='" + orderId + '\'' +
                ", userId=" + userId +
                ", money=" + money +
                '}';
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getOrderId() {
        return orderId;
    }

    public int getUserId() {
        return userId;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public double getMoney() {
        return money;
    }

    @Override
    public <T> T getPrimaryKeyValue() {
        return (T) new Integer(userId);
    }

    @Override
    public boolean isUpgradeRecreated() {
        return false;
    }
}
