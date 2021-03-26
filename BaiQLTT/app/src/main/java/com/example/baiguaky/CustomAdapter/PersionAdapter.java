package com.example.baiguaky.CustomAdapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.baiguaky.MainActivity;
import com.example.baiguaky.R;

import java.util.ArrayList;
import java.util.List;

public class PersionAdapter extends BaseAdapter {
    private Context mContext;
    private int layout;
    private List<Persion> list=new ArrayList<>();

    public PersionAdapter(Context mContext, int layout, List<Persion> list) {
        this.mContext = mContext;
        this.layout = layout;
        this.list = list;
    }

    public PersionAdapter(MainActivity mContext, int dongchitietthongtincanhan, ArrayList<com.example.baiguaky.CustomAdapter.Persion> arrayList) {
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
        TextView txtTen=(TextView)view.findViewById(R.id.txtTen_DongChiTietCaNhan);
        TextView txtSDT=(TextView)view.findViewById(R.id.txtSDT_DongChiTietCaNhan);
        TextView txtDC=(TextView)view.findViewById(R.id.txtDC_DongChiTietCaNhan);
        TextView txtID=(TextView)view.findViewById(R.id.txtID_DongChiTietCaNhan);
        Persion p=list.get(position);
        txtTen.setText(p.getTen());
        txtSDT.setText(p.getSdt());
        txtDC.setText(p.getDiachi());
        txtID.setText(p.getQueQuan());
        txtID.setVisibility(View.GONE);
        return view;
    }
}
