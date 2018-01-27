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

import com.lwh.jackknife.mvp.BaseModel;
import com.lwh.jackknife.mvp.BasePresenter;

import java.util.ArrayList;
import java.util.List;

public class ArticlePresenter extends BasePresenter<IArticleView> {

    IArticleView mArticleView;
    ArticleModel mArticleModel;

    public void fetchArticles() {
        if (isViewAttached()) {
            mArticleView = getView();
            mArticleModel = new ArticleModel();
            List<Article> articles = new ArrayList<>();
            articles.add(new Article("《三个火枪手》", "法国", "大仲马"));
            articles.add(new Article("《钢铁是怎样炼成的》", "前苏联", "奥斯特洛夫斯基"));
            articles.add(new Article("《呐喊》", "中国", "鲁迅"));
            articles.add(new Article("《巴黎圣母院》", "法国", "维克多·雨果"));
            articles.add(new Article("《老人与海》", "美国", "海明威"));
            articles.add(new Article("《鲁滨孙漂流记》", "英国", "丹尼尔·笛福"));
            articles.add(new Article("《子夜》", "中国", "茅盾"));
            articles.add(new Article("《雷雨》", "中国", "曹禺"));
            articles.add(new Article("《骆驼祥子》", "中国", "老舍"));
            articles.add(new Article("《窦娥冤》", "中国<元>", "关汉卿"));
            mArticleModel.add(articles);
            mArticleView.showLoading();
            mArticleModel.loadArticles(new BaseModel.OnLoadListener<Article>() {
                @Override
                public void onLoad(List<Article> articles) {
                    mArticleView.showRecommendedArticles(articles);
                    mArticleView.hideLoading();
                }
            });
        }
    }
}
