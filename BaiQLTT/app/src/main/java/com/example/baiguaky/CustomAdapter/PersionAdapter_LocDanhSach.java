package com.example.qlttcanhan_tkuudd_thayduy.CustomAdapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.baiguaky.CustomAdapter.Persion;
import com.example.baiguaky.R;

import java.util.ArrayList;
import java.util.List;

public class PersionAdapter_LocDanhSach extends BaseAdapter {
    private Context mContext;
    private int layout;
    private List<Persion> list=new ArrayList<>();

    public PersionAdapter_LocDanhSach(Context mContext, int layout, List<Persion> list) {
        this.mContext = mContext;
        this.layout = layout;
        this.list = list;
    }
    @Override
    public int getCount() {
        return list.size();
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
    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater layoutInflater =(LayoutInflater)mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view=layoutInflater .inflate(layout, null);
        TextView txtTen=(TextView)view.findViewById(R.id.txtTen_LocDS);
        TextView txtSDT=(TextView)view.findViewById(R.id.txtSDT_LocDS);
        Persion p=list.get(position);
        txtTen.setText(p.getTen());
        txtSDT.setText(p.getSdt());
        return view;
    }
}
