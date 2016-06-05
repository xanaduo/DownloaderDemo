package com.showbabyapp.myapplication.ui.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.showbabyapp.myapplication.R;
import com.showbabyapp.myapplication.bean.AppliInfo;

import java.util.ArrayList;

/**
 * Created by 秀宝-段誉 on 2016-06-05.
 * 邮箱：xanaduo@qq.com
 */
public class Adapter extends BaseAdapter {
    private AppliInfo appliInfo;

    public Adapter() {
        this.appliInfo = new AppliInfo();
        this.appliInfo.data = new ArrayList<>();
    }

    public void setData(AppliInfo appliInfo) {
        this.appliInfo = appliInfo;
        this.notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return appliInfo.data.size();
    }

    @Override
    public AppliInfo.Appli getItem(int position) {
        return appliInfo.data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Holder holder;
        if (convertView == null) {
            convertView = View.inflate(parent.getContext(), R.layout.text_row_item, null);
            holder = new Holder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (Holder) convertView.getTag();
        }
        holder.iniData(getItem(position));
        return convertView;
    }

    class Holder {
        private TextView textView;

        public Holder(View v) {
            this.textView = (TextView) v.findViewById(R.id.textView);
        }

        public void iniData(AppliInfo.Appli appli) {
            textView.setText(appli.name);
        }
    }
}
