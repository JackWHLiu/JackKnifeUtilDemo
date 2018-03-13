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

package com.lwh.jackknife.demo.animator;

import android.app.Activity;
import android.os.Bundle;
import android.provider.AlarmClock;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;

import com.lwh.jackknife.demo.R;
import com.lwh.jackknife.widget.animator.ActionWrapper;
import com.lwh.jackknife.widget.animator.AlphaAction;
import com.lwh.jackknife.widget.animator.AlphaAnimator;
import com.lwh.jackknife.widget.animator.AnimatorBuilder;
import com.lwh.jackknife.widget.animator.CubicTo;
import com.lwh.jackknife.widget.animator.LineTo;
import com.lwh.jackknife.widget.animator.MoveTo;
import com.lwh.jackknife.widget.animator.PathAction;
import com.lwh.jackknife.widget.animator.PathAnimator;
import com.lwh.jackknife.widget.animator.QuadTo;
import com.lwh.jackknife.widget.animator.RotateAction;
import com.lwh.jackknife.widget.animator.RotateAnimator;
import com.lwh.jackknife.widget.animator.ScaleAction;
import com.lwh.jackknife.widget.animator.ScaleAnimator;

import java.util.ArrayList;
import java.util.List;

public class AnimatorActivity extends Activity {

    private Button button_animator;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animator);
        button_animator = (Button) findViewById(R.id.button_animator);
        button_animator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                方式一
//                AlphaAnimator alphaAnimator = new AlphaAnimator();
//                alphaAnimator.add(new AlphaAction(0.3f))
//                        .add(new AlphaAction(1.0f));
//                RotateAnimator rotateAnimator = new RotateAnimator(alphaAnimator);
//                rotateAnimator.add(new RotateAction(145));
//                ScaleAnimator scaleAnimator = new ScaleAnimator(rotateAnimator);
//                scaleAnimator.add(new ScaleAction(0.5f, 2.0f))
//                        .add(new ScaleAction(1.0f, 1.0f));
//                PathAnimator pathAnimator = new PathAnimator(scaleAnimator);
//                pathAnimator.add(new LineTo(200, 100));
//                pathAnimator.add(new LineTo(100, 100));
//                pathAnimator.add(new CubicTo(938, 389, 389, 389, 324, 364));
//                pathAnimator.add(new QuadTo(200, 160, 0, -20));
//                pathAnimator.add(new MoveTo(0, 0));
//                pathAnimator.startAnimation(button_animator, 2000);

//                方式二，推荐，避免重复使用同种动画，也可以用方式一，根据自己的喜好来
                List<AlphaAction> alphaActions = new ArrayList<>();
                alphaActions.add(new AlphaAction(0.3f));
                alphaActions.add(new AlphaAction(1.0f));
                List<RotateAction> rotateActions = new ArrayList<>();
                rotateActions.add(new RotateAction(145));
                List<ScaleAction> scaleActions = new ArrayList<>();
                scaleActions.add(new ScaleAction(0.5f, 2.0f));
                scaleActions.add(new ScaleAction(1.0f, 1.0f));
                List<PathAction> pathActions = new ArrayList<>();
                pathActions.add(new LineTo(200, 100));
                pathActions.add(new LineTo(100, 100));
                pathActions.add(new CubicTo(938, 389, 389, 389, 324, 364));
                pathActions.add(new QuadTo(200, 160, 0, -20));
                pathActions.add(new MoveTo(0, 0));
                ActionWrapper animator = new AnimatorBuilder()
                        .alpha(alphaActions)
                        .rotate(rotateActions)
                        .scale(scaleActions)
                        .path(pathActions)
                        .build();
                animator.startAnimation(button_animator, 2000);
            }
        });
    }
}
