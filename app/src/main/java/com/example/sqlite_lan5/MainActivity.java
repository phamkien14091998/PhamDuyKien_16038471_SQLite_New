package com.example.sqlite_lan5;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private EditText edtMSSV,edtTenSV;
    private Button btnThem,btnSua,btnXoa;
    private ListView lvSV;

    private ArrayList listSinhVien= new ArrayList();
    private ArrayAdapter  adapter;
    DBSV_SQLite dbsv_sqLite;
    int idTam=0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtMSSV= findViewById(R.id.edtMSSV);
        edtTenSV= findViewById(R.id.edtTenSV);
        btnThem= findViewById(R.id.btnThem);
        btnSua= findViewById(R.id.btnSua);
        btnXoa= findViewById(R.id.btnXoa);
        lvSV= findViewById(R.id.lvSV);

        dbsv_sqLite= new DBSV_SQLite(this,"SinhVien",null,1);
        dbsv_sqLite.query("create table if not exists SinhVien(id integer primary key autoincrement,mssv integer,tenSV text)");

        adapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,listSinhVien);
        loadDB();

        btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                dbsv_sqLite.insert(new SinhVien(Integer.parseInt(edtMSSV.getText().toString()),edtTenSV.getText().toString()));
                Toast.makeText(MainActivity.this, "Thêm Thành Công", Toast.LENGTH_SHORT).show();
                loadDB();
            }
        });

        lvSV.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                SinhVien sinhVien=(SinhVien)listSinhVien.get(i);
                edtMSSV.setText(String.valueOf(sinhVien.getMssv()));
                edtTenSV.setText(sinhVien.getTenSV());
                idTam=sinhVien.getId();
            }
        });

        btnSua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(idTam !=0){
                    dbsv_sqLite.update(new SinhVien(idTam,Integer.parseInt(edtMSSV.getText().toString()),edtTenSV.getText().toString()));
                    idTam=0;
                    Toast.makeText(MainActivity.this, "Sửa Thành Công", Toast.LENGTH_SHORT).show();
                    loadDB();
                }
            }
        });
        btnXoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(idTam !=0){
                    dbsv_sqLite.delete(idTam);
                    idTam=0;
                    Toast.makeText(MainActivity.this, "Xóa Thành Công", Toast.LENGTH_SHORT).show();
                    loadDB();
                }
            }
        });

    }

    public void loadDB(){
        listSinhVien.clear();
        Cursor cursor= dbsv_sqLite.queryCursor("Select * from SinhVien");
        while (cursor.moveToNext()){
            listSinhVien.add(new SinhVien(cursor.getInt(0),cursor.getInt(1),cursor.getString(2)));

        }
        lvSV.setAdapter(adapter);
        adapter.notifyDataSetChanged();
        edtTenSV.setText("");
        edtMSSV.setText("");

    }


}
