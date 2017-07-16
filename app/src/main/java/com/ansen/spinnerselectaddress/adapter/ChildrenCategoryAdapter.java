package com.ansen.spinnerselectaddress.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.ansen.spinnerselectaddress.R;

/**
 * 子类别 适配器
 * @author ansen
 * @create time 2015-09-25
 */
public class ChildrenCategoryAdapter extends BaseAdapter {
	private Context mContext;
	private String[] str;

	public ChildrenCategoryAdapter(Context context) {
		mContext = context;
	}

	public void setDatas(String[] str) {
		this.str = str;
	}
	
	@Override
	public int getCount() {
		if(str == null){
			return 0;
		}
		return str.length;
	}

	@Override
	public Object getItem(int position) {
		return null;
	}

	@Override
	public long getItemId(int position) {
		return 0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder holder = null;
		if (convertView == null) {
			holder = new ViewHolder();
			convertView = LayoutInflater.from(mContext).inflate(R.layout.activity_children_category_item, null);
			holder.tvChildrenCategoryName = (TextView) convertView.findViewById(R.id.tv_children_category_name);
			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}
		holder.tvChildrenCategoryName.setText(str[position]);
		return convertView;
	}

	private  class ViewHolder {
		private TextView tvChildrenCategoryName;
	}
}
