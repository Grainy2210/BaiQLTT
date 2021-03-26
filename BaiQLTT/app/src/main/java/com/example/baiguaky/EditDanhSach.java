package com.example.baiguaky;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.baiguaky.CustomAdapter.Persion;

public class EditDanhSach extends AppCompatActivity {
    Button btnXacNhan;
    EditText txtTen,txtSDT,txtDC;
    Spinner btnQQ;
    static int tt;
    String qq;
    ArrayAdapter<String> TenSpiner=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_danh_sach);

        Add();
        BanDau();
        btnXacNhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(tt==0){
                    Intent intent = new Intent();
                    Bundle bundle=new Bundle();
                    Persion p=new Persion(txtTen.getText().toString().trim(),txtSDT.getText().toString().trim() ,txtDC.getText().toString().trim(),qq.trim());
                    bundle.putSerializable("Persion",p);
                    intent.putExtra("data",bundle);
                    setResult(MainActivity.LuuThem,intent);
                    finish();
                }
                else{
                    Intent intent = new Intent();
                    Bundle bundle=new Bundle();
                    Persion p=new Persion(txtTen.getText().toString().trim(),txtSDT.getText().toString().trim() ,txtDC.getText().toString().trim(),qq.trim());
                    bundle.putSerializable("Persion",p);
                    intent.putExtra("data",bundle);
                    setResult(MainActivity.LuuSua,intent);
                    finish();
                }
            }
        });
        btnQQ.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                qq=TenSpiner.getItem(position).trim();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
    public  void Add(){
        btnXacNhan=(Button)findViewById(R.id.btnXacNhan_Edit);
        txtTen=(EditText)findViewById(R.id.txtTen_EditCaNhan);
        txtDC=(EditText)findViewById(R.id.txtDC_EditCaNhan);
        txtSDT=(EditText)findViewById(R.id.txtSDT_EditCaNhan);
        btnQQ=(Spinner)findViewById(R.id.spQQ_EditCaNhan);
    }
    public void BanDau(){
        Intent inten=getIntent();
        Bundle bundle=inten.getBundleExtra("data");
         tt=bundle.getInt("TT");
        String ss[]={"Bình Dương","TP HCM","Đăk Lăk","Hà Nội","Gia Lai"};
        TenSpiner=new ArrayAdapter<String>(EditDanhSach.this,android.R.layout.simple_list_item_1,ss);
        btnQQ.setAdapter(TenSpiner);
        if(tt==1){
           Persion p=(Persion) bundle.getSerializable("Pesion");
           txtTen.setText(p.getTen());
           txtSDT.setText(p.getSdt());
           txtDC.setText(p.getDiachi());
           //btnQQ.setText(p.getQueQuan());

        }

    }
}