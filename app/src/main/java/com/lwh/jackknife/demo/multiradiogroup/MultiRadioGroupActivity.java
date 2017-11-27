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

package com.lwh.jackknife.demo.multiradiogroup;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.lwh.jackknife.demo.R;
import com.lwh.jackknife.widget.MultiRadioGroup;

public class MultiRadioGroupActivity extends Activity {

    MultiRadioGroup multiradiogroup;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multi_radio_group);
        multiradiogroup = (MultiRadioGroup) findViewById(R.id.multiradiogroup);
        multiradiogroup.check(R.id.radiobutton_firstbutton);
    }
}
