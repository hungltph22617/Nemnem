package com.example.nemnem;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.nemnem.Dao.NguoimuaDao;
import com.example.nemnem.FragmentcuaHome.Caidat;
import com.example.nemnem.model.nguoimua;
import com.google.android.material.textfield.TextInputEditText;

import java.util.List;

public class MainActivity2 extends AppCompatActivity {
    Button login;
    TextInputEditText pass, account;
    NguoimuaDao nguoimuadao;
    List<nguoimua> nguoimuaList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        pass = findViewById(R.id.pass);
        account = findViewById(R.id.account);
        login = findViewById(R.id.login);
        nguoimuadao = new NguoimuaDao(getBaseContext());
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nguoimuaList = nguoimuadao.selectAll();
                String nameUser = account.getText().toString().trim();
                String passUser = pass.getText().toString().trim();
                if( nameUser.isEmpty()||passUser.isEmpty() ){
                    Toast.makeText(MainActivity2.this, "Không được để trống", Toast.LENGTH_SHORT).show();
                }else{
                    for (nguoimua user:nguoimuaList){
                        if (!user.getTen().equals(nameUser)||!(user.getSdt()+"").equals(passUser)){
                            Toast.makeText(getBaseContext(), "Tài khoản hoặc mật khẩu không hợp lệ", Toast.LENGTH_SHORT).show();
                        }else {
                            Caidat.nguoimuaLogin = user;
                            finish();
                        }
                    }
                }
            }
        });
    }
}