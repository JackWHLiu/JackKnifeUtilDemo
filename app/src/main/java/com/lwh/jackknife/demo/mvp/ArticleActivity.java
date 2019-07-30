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

package com.lwh.jackknife.demo.mvp;

import android.content.Context;
import android.os.Bundle;
import android.widget.TextView;

import com.lwh.jackknife.demo.R;
import com.lwh.jackknife.mvp.BaseActivity;

import java.util.List;

public class ArticleActivity extends BaseActivity<IArticleView, ArticlePresenter> implements IArticleView {

    TextView textview_article_recommended;

    @Override
    protected ArticlePresenter createPresenter() {
        return new ArticlePresenter();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_article);
        initViews();
        mPresenter.fetchArticles();
    }

    private void initViews() {
        textview_article_recommended = (TextView) findViewById(R.id.textview_article_recommended);
    }

    @Override
    public void showLoading() {
    }

    @Override
    public void hideLoading() {
    }

    @Override
    public Context getContext() {
        return this;
    }

    private String printResult(List<Article> articles) {
        StringBuilder sb = new StringBuilder();
        for (Article article : articles) {
            sb.append(article.toString()+"\n");
        }
        return sb.toString();
    }

    @Override
    public void showRecommendedArticles(List<Article> articles) {
        textview_article_recommended.setText(printResult(articles));
    }
}
