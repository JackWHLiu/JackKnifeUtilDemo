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

import android.os.Parcel;
import android.os.Parcelable;

import com.lwh.jackknife.orm.AssignType;
import com.lwh.jackknife.orm.annotation.NonColumn;
import com.lwh.jackknife.orm.annotation.PrimaryKey;
import com.lwh.jackknife.orm.table.OrmTable;

public class Mobile implements OrmTable, Parcelable {

    @PrimaryKey(AssignType.AUTO_INCREMENT)
    private int _id;

    private String brand;//品牌

    private String modelNumber;//型号

    private String rom;

    private int price;//价格

    public Mobile() {
    }

    public Mobile(String brand, String modelNumber, int price) {
        this.brand = brand;
        this.modelNumber = modelNumber;
        this.price = price;
    }

    public Mobile(int id, String brand, String modelNumber, int price) {
        this._id = id;
        this.brand = brand;
        this.modelNumber = modelNumber;
        this.price = price;
    }

    public void setRom(String rom) {
        this.rom = rom;
    }

    public String getBrand() {
        return brand;
    }

    public String getModelNumber() {
        return modelNumber;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Mobile{" +
                "_id=" + _id +
                ", brand='" + brand + '\'' +
                ", modelNumber='" + modelNumber + '\'' +
                ", rom='" + rom + '\'' +
                ", price=" + price +
                '}';
    }

    @NonColumn
    public static Creator CREATOR = new ClassLoaderCreator<Mobile>() {
        @Override
        public Mobile createFromParcel(Parcel source) {
            return null;
        }

        @Override
        public Mobile[] newArray(int size) {
            return new Mobile[size];
        }

        @Override
        public Mobile createFromParcel(Parcel source, ClassLoader loader) {
            return null;
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {

    }
}
