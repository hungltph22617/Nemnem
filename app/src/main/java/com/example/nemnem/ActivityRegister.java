package com.example.nemnem;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import com.example.nemnem.Dao.NguoimuaDao;
import com.example.nemnem.model.nguoimua;
import com.google.android.material.textfield.TextInputEditText;

public class ActivityRegister extends AppCompatActivity {
    TextInputEditText editTextAccount,editTextPass,editTextAddress;
    Button btn_accept;
    NguoimuaDao nguoimuaDao;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        editTextAccount = findViewById(R.id.account);
        editTextPass =findViewById(R.id.pass);
        editTextAddress = findViewById(R.id.diachi);
        btn_accept = findViewById(R.id.login);

        nguoimuaDao = new NguoimuaDao(getBaseContext());
        btn_accept.setOnClickListener(v -> {
            nguoimua user = new nguoimua();
            user.setTen(editTextAccount.getText().toString().trim());
            user.setSdt(Integer.parseInt(editTextPass.getText().toString().trim()));
            user.setDiachi(editTextAddress.getText().toString().trim());
            if (editTextAccount.getText().toString().trim().isEmpty()||editTextPass.getText().toString().trim().isEmpty()||editTextAddress.getText().toString().trim().isEmpty()){
                Toast.makeText(getBaseContext(), "Không được để trống dữ liệu", Toast.LENGTH_SHORT).show();
            }else if(nguoimuaDao.insert(user)){
                Toast.makeText(getBaseContext(), "Đăng ký thành công", Toast.LENGTH_SHORT).show();
                finish();
            }else{
                Toast.makeText(getBaseContext(), "Đăng ký thất bại", Toast.LENGTH_SHORT).show();
            }
        });
    }
}