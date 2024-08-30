package com.example.realmadridpertemuan3;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Arrays;

public class FormOutputActivity extends AppCompatActivity {

    TextView tvGetName, tvGetRelgion, tvGetGender;
    Button btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_form_output);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        initView();
    }

    public void initView(){
        Intent intent = getIntent();
        String[] data = intent.getStringArrayExtra("data"); //menangkap data dari view form

        String nama = "", jk = "", agama = "";

        if(data != null){
            nama = data[0];
            jk = data[1];
            agama = data[2];
        }else{
            //jika data kosong
        }

        //memeriksa jenis kelamin
        if (jk.equals("Pria")){ //jika seorang pria
            switch (agama){
                case "Islam":
                    Toast.makeText(getApplicationContext(), "Halo Pak " + nama + ", Assalamualaikum", Toast.LENGTH_LONG).show();;
                    break;
                case "Kristen":
                    Toast.makeText(getApplicationContext(), "Halo Pak " + nama + ", Shalom", Toast.LENGTH_LONG).show();;
                    break;
                case "Hindu":
                    Toast.makeText(getApplicationContext(), "Halo Pak " + nama + ", Om swastiastu", Toast.LENGTH_LONG).show();;
                    break;
                case "Buddha":
                    Toast.makeText(getApplicationContext(), "Halo Pak " + nama + ", Namo Buddhaya", Toast.LENGTH_LONG).show();;
                    break;
                case "Katolik":
                    Toast.makeText(getApplicationContext(), "Halo Pak " + nama + ", Salam Sejahtera", Toast.LENGTH_LONG).show();;
                    break;
                case "Khonghucu":
                    Toast.makeText(getApplicationContext(), "Halo Pak " + nama + ", Wei De Dong Tian", Toast.LENGTH_LONG).show();;
                    break;
                default:
                    Toast.makeText(getApplicationContext(), "Halo Pak " + nama + ", Salam", Toast.LENGTH_LONG).show();;
                    break;
            }
        }
        else{ //jika seorang wanita
            switch (agama){
                case "Islam":
                    Toast.makeText(getApplicationContext(), "Halo Ibu " + nama + ", Assalamualaikum", Toast.LENGTH_LONG).show();;
                    break;
                case "Kristen":
                    Toast.makeText(getApplicationContext(), "Halo Ibu " + nama + ", Shalom", Toast.LENGTH_LONG).show();;
                    break;
                case "Hindu":
                    Toast.makeText(getApplicationContext(), "Halo Ibu " + nama + ", Om swastiastu", Toast.LENGTH_LONG).show();;
                    break;
                case "Buddha":
                    Toast.makeText(getApplicationContext(), "Halo Ibu " + nama + ", Namo Buddhaya", Toast.LENGTH_LONG);
                    break;
                case "Katolik":
                    Toast.makeText(getApplicationContext(), "Halo Ibu " + nama + ", Salam Sejahtera", Toast.LENGTH_LONG).show();;
                    break;
                case "Khonghucu":
                    Toast.makeText(getApplicationContext(), "Halo Ibu " + nama + ", Wei De Dong Tian", Toast.LENGTH_LONG).show();;
                    break;
                default:
                    Toast.makeText(getApplicationContext(), "Halo Ibu " + nama + ", Salam", Toast.LENGTH_LONG).show();
                    break;
            }
        }

        tvGetName = findViewById(R.id.tvGetName);
        tvGetName.setText(data[0]);

        tvGetGender = findViewById(R.id.tvGetGender);
        tvGetGender.setText(data[1]);

        tvGetRelgion = findViewById(R.id.tvGetReligion);
        tvGetRelgion.setText(data[2]);

        btnBack = findViewById(R.id.btnBack);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(FormOutputActivity.this, FormActivity.class);
                startActivity(i);
                finish();
            }
        });
    }
}