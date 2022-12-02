package com.example.nemnem;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import com.google.android.material.textfield.TextInputEditText;

public class MainActivity2 extends AppCompatActivity {
    Button login;
    TextInputEditText pass, account;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        pass = findViewById(R.id.pass);
        account = findViewById(R.id.account);
        login = findViewById(R.id.login);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(pass.getText().toString().equals("") | account.getText().toString().equals("")){
                    Toast.makeText(MainActivity2.this, "Không được để trống", Toast.LENGTH_SHORT).show();
                }else if(pass.getText().toString().equals("123") | account.getText().toString().equals("Admin")){
                    Intent intent = new Intent(MainActivity2.this, MainActivity3.class);
                    startActivity(intent);
                    finish();
                }else{
                    Toast.makeText(MainActivity2.this, "Nhập sai vui lòng nhập lại", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}