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

package com.lwh.jackknife.demo.letterview;

import android.content.Context;
import android.view.View;
import android.widget.SectionIndexer;
import android.widget.TextView;

import com.lwh.jackknife.demo.R;
import com.lwh.jackknife.util.Logger;
import com.lwh.jackknife.util.TextUtils;
import com.lwh.jackknife.widget.CommonAdapter;
import com.lwh.jackknife.widget.ViewHolder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
public class ContactAdapter extends CommonAdapter<Contact> implements SectionIndexer {

    PinyinComparator mComparator;

    public ContactAdapter(Context context) {
        super(context);
        mComparator = new PinyinComparator();
        replaceItems(mDatas);
    }

    @Override
    protected int getItemLayoutId() {
        return R.layout.item_contact;
    }

    @Override
    protected int[] getItemViewIds() {
        return new int[] {R.id.textview_letter, R.id.textview_name};
    }

    @Override
    protected List<Contact> initDatas() {
        List<Contact> contacts = new ArrayList<>();
        contacts.add(new Contact("习近平"));
        contacts.add(new Contact("鹿晗"));
        contacts.add(new Contact("杨幂"));
        contacts.add(new Contact("王宝强"));
        contacts.add(new Contact("张国荣"));
        contacts.add(new Contact("莫言"));
        contacts.add(new Contact("孙杨"));
        contacts.add(new Contact("刘强东"));
        contacts.add(new Contact("雷军"));
        contacts.add(new Contact("马化腾"));
        contacts.add(new Contact("马云"));
        contacts.add(new Contact("Ricky"));
        contacts.add(new Contact("Danny"));
        contacts.add(new Contact("David"));
        contacts.add(new Contact("Elaine"));
        contacts.add(new Contact("Tony"));
        contacts.add(new Contact("Jason"));
        contacts.add(new Contact("许嵩"));
        contacts.add(new Contact("黄晓明"));
        contacts.add(new Contact("张杰"));
        contacts.add(new Contact("周杰伦"));
        contacts.add(new Contact("赵本山"));
        contacts.add(new Contact("QQ"));
        contacts.add(new Contact("YY"));
        contacts.add(new Contact("斗鱼主播"));
        contacts.add(new Contact("A"));
        contacts.add(new Contact("B"));
        contacts.add(new Contact("C"));
        contacts.add(new Contact("D"));
        contacts.add(new Contact("E"));
        contacts.add(new Contact("F"));
        contacts.add(new Contact("G"));
        contacts.add(new Contact("H"));
        contacts.add(new Contact("I"));
        contacts.add(new Contact("J"));
        contacts.add(new Contact("K"));
        contacts.add(new Contact("L"));
        contacts.add(new Contact("M"));
        contacts.add(new Contact("N"));
        contacts.add(new Contact("O"));
        contacts.add(new Contact("P"));
        contacts.add(new Contact("Q"));
        contacts.add(new Contact("R"));
        contacts.add(new Contact("R2"));
        contacts.add(new Contact("rpk"));
        contacts.add(new Contact("Rj"));
        contacts.add(new Contact("Rr"));
        contacts.add(new Contact("Rr1"));
        contacts.add(new Contact("rS"));
        contacts.add(new Contact("S"));
        contacts.add(new Contact("T"));
        contacts.add(new Contact("U"));
        contacts.add(new Contact("V"));
        contacts.add(new Contact("W"));
        contacts.add(new Contact("X"));
        contacts.add(new Contact("Y"));
        contacts.add(new Contact("Z"));
        return contacts;
    }

    @Override
    protected <VIEW extends View> void onBindViewHolder(int position, Contact contact, ViewHolder<VIEW> holder) {
        TextView textview_letter = (TextView) holder.findViewById(R.id.textview_letter);
        TextView textview_name = (TextView) holder.findViewById(R.id.textview_name);
        int section = getSectionForPosition(position);
        if (position == getPositionForSection(section)) {
            textview_letter.setVisibility(View.VISIBLE);
            textview_letter.setText(contact.getSortLetter().toUpperCase().substring(0, 1));
        } else {
            textview_letter.setVisibility(View.GONE);
        }
        textview_name.setText(contact.getName());
    }

    public void replaceItems(List<Contact> contacts) {
        contacts = generateLetters(contacts);
        super.replaceItems(contacts);
    }

    private List<Contact> generateLetters(List<Contact> contacts) {
        for (Contact contact : contacts) {
            String sortLetter = TextUtils.getPinyinFromSentence(contact.getName()).toUpperCase();
            Logger.error(sortLetter);
            contact.setSortLetter(sortLetter);
        }
        Collections.sort(contacts, mComparator);
        return contacts;
    }

    @Override
    public Object[] getSections() {
        return new Object[0];
    }

    @Override
    public int getPositionForSection(int sectionIndex) {
        for (int i = 0; i < getCount(); i++) {
            String sortLetter = mDatas.get(i).getSortLetter();
            if (sortLetter != null) {
                char first = sortLetter.toUpperCase().charAt(0);
                if (first == sectionIndex) {
                    return i;
                }
            }
        }
        return -1;
    }

    @Override
    public int getSectionForPosition(int i) {
        return mDatas.get(i).getSortLetter() == null ? -1 : mDatas.get(i).getSortLetter().toUpperCase().charAt(0);
    }

    public int getPositionForSection(char sectionIndex) {
        for (int i = 0; i < getCount(); i++) {
            String sortLetter = mDatas.get(i).getSortLetter();
            if (sortLetter != null) {
                char first = sortLetter.toUpperCase().charAt(0);
                if (first == sectionIndex) {
                    return i + 1;
                }
            }
        }
        return -1;
    }

    public class PinyinComparator implements Comparator<Sort> {

        @Override
        public int compare(Sort lhs, Sort rhs) {
            if (lhs.getSortLetter().equals("@")
                    || rhs.getSortLetter().equals("#")) {
                return -1;
            } else if (lhs.getSortLetter().equals("#")
                    || rhs.getSortLetter().equals("@")) {
                return 1;
            } else {
                return lhs.getSortLetter().compareTo(rhs.getSortLetter());
            }
        }
    }
}
