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

package com.lwh.jackknife.demo.mvp;

public class Article {

    private String name;
    private String country;
    private String author;

    public Article(String name, String country, String author) {
        this.name = name;
        this.country = country;
        this.author = author;
    }

    @Override
    public String toString() {
        return "Article{" +
                "name='" + name + '\'' +
                ", country='" + country + '\'' +
                ", author='" + author + '\'' +
                '}';
    }
}
