package com.example.baiguaky;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.example.baiguaky.CustomAdapter.Persion;
import com.example.baiguaky.CustomAdapter.PersionAdapter;
import com.example.qlttcanhan_tkuudd_thayduy.CustomAdapter.PersionAdapter_LocDanhSach;

import java.util.ArrayList;

public class LocDanhSach extends AppCompatActivity {
    ListView lvDS;
    TextView txtTenQQ;
    ArrayList<Persion> arrayListChinh=new ArrayList();
    ArrayAdapter<PersionAdapter_LocDanhSach> arrayAdapter=null;
    PersionAdapter_LocDanhSach adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loc_danh_sach);
        Add();
        BanDau();
    }
    public void Add(){
        lvDS=(ListView)findViewById(R.id.lvds_LocDS);
        txtTenQQ=(TextView)findViewById(R.id.txtTenQq_LocDS);
    }
    public void BanDau(){
        Intent intent=getIntent();
        Bundle bundle=intent.getBundleExtra("data");
        String qq=bundle.getString("qq");
        int y=qq.length();
        int z;
        txtTenQQ.setText("Quê quán :"+qq);
        ArrayList<Persion> arrayList=(ArrayList)bundle.getSerializable("DS");
        for(int i=0;i<arrayList.size();i++){
           Persion p= arrayList.get(i);
            if(i==0) arrayListChinh.add(p);
            z=p.getQueQuan().length();
           if(z==y){
               arrayListChinh.add(p);
           }
        }
        //txtTenQQ.setText("Quê quán :"+qq+" do dai :"+y);
        adapter=new PersionAdapter_LocDanhSach(LocDanhSach.this,R.layout.donglocdanhsach,arrayListChinh);
        adapter.notifyDataSetChanged();
        lvDS.setAdapter(adapter);
    }
}