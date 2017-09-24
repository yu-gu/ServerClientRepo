package com.example.android.moranlee.justgo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

public class select_from_food_database_activity extends AppCompatActivity {

    public String[] groupStrings = {"fruit", "meat", "dairy", "grain"};
    public String[][] childStrings = {
            {"apple", "banana", "pineapple", "peach"},
            {"beef", "pork", "mutton", "chicken"},
            {"milk", "yogurt", "ice cream"},
            {"oat", "rice", "barley", "wheat"}
    };

    public class expand_data_view extends BaseExpandableListAdapter {
        //        获取分组的个数
        @Override
        public int getGroupCount() {
            return groupStrings.length;
        }

        //        获取指定分组中的子选项的个数
        @Override
        public int getChildrenCount(int groupPosition) {
            return childStrings[groupPosition].length;
        }

        //        获取指定的分组数据
        @Override
        public Object getGroup(int groupPosition) {
            return groupStrings[groupPosition];
        }

        //        获取指定分组中的指定子选项数据
        @Override
        public Object getChild(int groupPosition, int childPosition) {
            return childStrings[groupPosition][childPosition];
        }

        //        获取指定分组的ID, 这个ID必须是唯一的
        @Override
        public long getGroupId(int groupPosition) {
            return groupPosition;
        }

        //        获取子选项的ID, 这个ID必须是唯一的
        @Override
        public long getChildId(int groupPosition, int childPosition) {
            return childPosition;
        }

        //        分组和子选项是否持有稳定的ID, 就是说底层数据的改变会不会影响到它们。
        @Override
        public boolean hasStableIds() {
            return true;
        }
        //        获取显示指定分组的视图
        @Override
        public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
            GroupViewHolder groupViewHolder;
            if (convertView == null) {
                convertView = LayoutInflater.from(select_from_food_database_activity.this).inflate(R.layout.item_expand_group, parent, false);
                groupViewHolder = new GroupViewHolder();
                groupViewHolder.tvTitle = (TextView) convertView.findViewById(R.id.label_expand_group);
                convertView.setTag(groupViewHolder);
            } else {
                groupViewHolder = (GroupViewHolder) convertView.getTag();
            }
            groupViewHolder.tvTitle.setText(groupStrings[groupPosition]);
            return convertView;
        }

        //        获取显示指定分组中的指定子选项的视图
        @Override
        public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
            ChildViewHolder childViewHolder;
            if (convertView == null) {
                convertView = LayoutInflater.from(select_from_food_database_activity.this).inflate(R.layout.item_expand_child, parent, false);
                childViewHolder = new ChildViewHolder();
                childViewHolder.tvTitle = (TextView) convertView.findViewById(R.id.label_expand_child);
                convertView.setTag(childViewHolder);
            } else {
                childViewHolder = (ChildViewHolder) convertView.getTag();
            }
            childViewHolder.tvTitle.setText(childStrings[groupPosition][childPosition]);
            return convertView;
        }

        //        指定位置上的子元素是否可选中
        @Override
        public boolean isChildSelectable(int groupPosition, int childPosition) {
            return true;
        }

        class GroupViewHolder {
            TextView tvTitle;
        }
        class ChildViewHolder {
            TextView tvTitle;
        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_from_database_activity);
    }
}
