package com.example.realmadridpertemuan3;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class FormActivity extends AppCompatActivity {

    String religion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_form);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        initview();
    }

    public void initview(){
        Spinner spReligion = findViewById(R.id.spReligion);
        Button btnKirim = findViewById(R.id.btnSubmit);
        EditText etName = findViewById(R.id.etName);
        RadioButton rbP = findViewById(R.id.rbPria), rbW = findViewById(R.id.rbWanita);



        ArrayList<String> listReligion = new ArrayList<>();
        listReligion.add("Islam");
        listReligion.add("Kristen");
        listReligion.add("Hindu");
        listReligion.add("Buddha");
        listReligion.add("Katolik");
        listReligion.add("Khonghucu");

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, listReligion);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spReligion.setAdapter(arrayAdapter);

        spReligion.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                religion = parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // Tidak ada tindakan jika tidak ada item yang dipilih
            }
        });

        btnKirim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String gender;

                if (rbP.isChecked()){
                    gender = rbP.getText().toString();
                }
                else {
                    gender = rbW.getText().toString();
                }

                AlertDialog.Builder builder = new AlertDialog.Builder(FormActivity.this);

                builder.setTitle("Konfirmasi Data");
                builder.setMessage("Apakah data berikut sudah benar?\n" + "Nama: " + etName.getText().toString() + "\nJenis Kelamin: " + gender + "\n" +
                        "Agama: " + religion);

                String[] data = new String[3];

                data[0] = etName.getText().toString();
                data[1] = gender;
                data[2] = religion;

                //tombol ya
                builder.setPositiveButton("Benar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                        Toast.makeText(getApplicationContext(), "Data berhasil dikirim!", Toast.LENGTH_LONG);
                        Intent intent = new Intent(FormActivity.this, FormOutputActivity.class);
                        intent.putExtra("data", data);
                        startActivity(intent);
                        finish();
                    }
                });

                //tombol tidak
                builder.setNegativeButton("Batal", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
                // Menampilkan dialog
                AlertDialog alertDialog = builder.create();
                alertDialog.show();
            }

        });
    }

}