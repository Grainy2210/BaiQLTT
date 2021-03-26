package com.example.baiguaky;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.baiguaky.CustomAdapter.Persion;
import com.example.baiguaky.CustomAdapter.PersionAdapter;

import java.io.Serializable;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements Serializable {
    public static final int Them=1;
    public static final int LuuThem=2;
    public static final int Sua=3;
    public static final int LuuSua=4;
    public static final int LocDS=5;
    ListView lvDS;
    Button btnLoc,btnThem,btnClose;
    Spinner btnSpell;
    ArrayList<Persion>arrayList=new ArrayList();
    ArrayAdapter<PersionAdapter>arrayAdapter=null;
    ArrayAdapter<String>TenSpiner=null;
    PersionAdapter adapter;
   // String adapterTenQQ;
    static int viTri;
    static String queQuan="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Add();
        BanDau();
        lvDS.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int i, long id) {
                viTri=i;
                return false;
            }
        });
        btnSpell.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                queQuan=TenSpiner.getItem(position).trim() ;
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        btnLoc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(com.example.baiguaky.MainActivity.this,LocDanhSach.class);
                Bundle bundle=new Bundle();
                bundle.putSerializable("DS",arrayList);
                bundle.putString("qq",queQuan);
                intent.putExtra("data",bundle);
                startActivityForResult(intent, com.example.baiguaky.MainActivity.LocDS);
            }
        });
        btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(com.example.baiguaky.MainActivity.this,EditDanhSach.class);
                Bundle bundle=new Bundle();
                bundle.putInt("TT",0);
                intent.putExtra("data",bundle);
                startActivityForResult(intent, com.example.baiguaky.MainActivity.Them);
            }
        });
        btnClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder dialog=new AlertDialog.Builder(com.example.baiguaky.MainActivity.this);
                dialog.setTitle("Mời bạn xác nhận ?");
                dialog.setMessage("Có chắc thoát ?");
                dialog.setPositiveButton("Đồng ý", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                      finish();
                    }
                });
                dialog.setNegativeButton("Thoát", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
                dialog.show();
            }
        });

    }
    public void Add(){
        lvDS=(ListView)findViewById(R.id.lsDS_Main);
        btnThem=(Button)findViewById(R.id.btnThem_Main);
        btnClose=(Button)findViewById(R.id.btnClose_Main);
        btnSpell=(Spinner)findViewById(R.id.spQueQuan_Main);
        btnLoc=(Button)findViewById(R.id.btnLoc_Main);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu,v , menuInfo);
        getMenuInflater().inflate(R.menu.contextmn,menu);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Bundle bundle;
        switch (requestCode){
            case com.example.baiguaky.MainActivity.Them:{
                if(resultCode == com.example.baiguaky.MainActivity.LuuThem);
                Toast.makeText(com.example.baiguaky.MainActivity.this,"dag them",Toast.LENGTH_LONG).show();
                bundle=data.getBundleExtra("data");
                Persion p=(Persion)bundle.getSerializable("Persion");
                arrayList.add(p);

            }break;
            case com.example.baiguaky.MainActivity.Sua:{
                if(resultCode == com.example.baiguaky.MainActivity.LuuSua){
                    bundle=data.getBundleExtra("data");
                    Persion p=(Persion)bundle.getSerializable("Persion");
                    arrayList.set(viTri,p);
                }
            }break;
        }
        adapter.notifyDataSetChanged();
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        Intent intent;
        Bundle bundle=new Bundle();
        switch (item.getItemId()){
            case R.id.mnEdit:{
                if(viTri!=0){
                    intent = new Intent(com.example.baiguaky.MainActivity.this,EditDanhSach.class);
                    Persion p=arrayList.get(viTri);
                    bundle.putInt("TT",1);
                    bundle.putSerializable("Pesion",p);
                    intent.putExtra("data",bundle);
                    startActivityForResult(intent, com.example.baiguaky.MainActivity.Sua);
                }
                else{Toast.makeText(com.example.baiguaky.MainActivity.this,"Hàng này không thể sửa",Toast.LENGTH_LONG).show();}
            }break;
            case R.id.mnDelete:{
                if(viTri==0){
                    Toast.makeText(com.example.baiguaky.MainActivity.this,"Hàng này không thể xóa",Toast.LENGTH_LONG).show();
                }
                else{
                    AlertDialog.Builder dialog=new AlertDialog.Builder(this);
                    dialog.setTitle("Mời bạn xác nhận ?");
                    dialog.setMessage("Có chắc xóa ?");
                    dialog.setPositiveButton("Đồng ý", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            arrayList.remove(viTri);
                            adapter.notifyDataSetChanged();
                        }
                    });
                    dialog.setNegativeButton("Thoát", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.cancel();
                        }
                    });
                    dialog.show();
                }

            }break;

        }
        return super.onContextItemSelected(item);
    }

    public void BanDau(){
        arrayList.add(new Persion("Ten","SDT","Dia Chi",""));
        adapter=new PersionAdapter(com.example.baiguaky.MainActivity.this,R.layout.dongchitietthongtincanhan,arrayList);
        lvDS.setAdapter(adapter);
        registerForContextMenu(lvDS);
        String ss[]={"Hà Tĩnh","Nghệ An"," Cà Mau"," Bình Dương","Gia Lai"};
        TenSpiner=new ArrayAdapter<String>(com.example.baiguaky.MainActivity.this,android.R.layout.simple_list_item_1,ss);
        btnSpell.setAdapter(TenSpiner);
    }
}