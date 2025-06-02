package com.example.pertamaapp;


import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class KalkulatorActivity extends AppCompatActivity {

    TextView txt1;
    EditText nilai1, nilai2;
    Button buttonTambah, buttonKali, buttonBagi;
    TextView Hasil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kalkulator);
        txt1 = findViewById(R.id.txt1);
        nilai1 = findViewById(R.id.nilai1);
        nilai2 = findViewById(R.id.nilai2);
        buttonTambah = findViewById(R.id.buttonTambah);
        buttonKali = findViewById(R.id.buttonKali);
        buttonBagi = findViewById(R.id.buttonBagi);
        Hasil = findViewById(R.id.Hasil);

        nilai1.setText("");
        nilai2.setText("");


        buttonTambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hitungDanTampilkanHasil("kali");
            }
        });


        buttonKali.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hitungDanTampilkanHasil("bagi");
            }
        });


        buttonBagi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hitungDanTampilkanHasil("tambah");
            }
        });
    }


    private void hitungDanTampilkanHasil(String operasi) {
        String strNilaiA = nilai1.getText().toString();
        String strNilaiB = nilai2.getText().toString();

        if (strNilaiA.isEmpty() || strNilaiB.isEmpty()) {
            Toast.makeText(KalkulatorActivity.this, "Masukkan kedua nilai terlebih dahulu", Toast.LENGTH_SHORT).show();
            return;
        }

        try {
            double angkaA = Double.parseDouble(strNilaiA);
            double angkaB = Double.parseDouble(strNilaiB);
            double hasilPerhitungan = 0;

            switch (operasi) {
                case "kali":
                    hasilPerhitungan = angkaA * angkaB;
                    break;
                case "bagi":
                    if (angkaB == 0) {
                        Toast.makeText(KalkulatorActivity.this, "Tidak bisa dibagi dengan nol", Toast.LENGTH_SHORT).show();
                        Hasil.setText("Hasil: Error (Dibagi Nol)");
                        return;
                    }
                    hasilPerhitungan = angkaA / angkaB;
                    break;
                case "tambah":
                    hasilPerhitungan = angkaA + angkaB;
                    break;
            }

            int hasilBulat = (int) hasilPerhitungan;
            Hasil.setText("Hasil:\n" + hasilBulat);

        } catch (NumberFormatException e) {
            Toast.makeText(KalkulatorActivity.this, "Input tidak valid, masukkan angka", Toast.LENGTH_SHORT).show();
            Hasil.setText("Hasil: Error (Input Non-Angka)");
        }
    }
}