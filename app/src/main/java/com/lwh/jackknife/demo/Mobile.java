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

public class Mobile {

    private String brand;//品牌
    private String modelNumber;//型号
    private int price;//价格

    public Mobile(String brand, String modelNumber, int price) {
        this.brand = brand;
        this.modelNumber = modelNumber;
        this.price = price;
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
                "brand='" + brand + '\'' +
                ", modelNumber='" + modelNumber + '\'' +
                ", price=" + price +
                '}';
    }
}
