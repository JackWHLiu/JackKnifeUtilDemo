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

import java.util.List;

public class ArticlePresenter extends BasePresenter<IArticleView> {

    IArticleView mArticleView;
    ArticleModel mArticleModel;

    public void fetchArticles() {
        if (isViewAttached()) {
            mArticleView = getView();
            mArticleModel = new ArticleModel(Article.class);
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
