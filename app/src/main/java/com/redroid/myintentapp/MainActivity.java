package com.redroid.myintentapp;

import android.content.Intent;
import android.net.Uri;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btnPindah;
    private Button btnPindahData;
    private  Button btnPindahObject;
    private Button btnNumberTlp;
    private Button  btnPindahHasil;
    private TextView tvHasil;
    private int REQUEST_CODE = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnPindah = (Button)findViewById(R.id.btn_pindah);
        btnPindah.setOnClickListener(this);
        btnPindahData = (Button)findViewById(R.id.btn_pindah_data);
        btnPindahData.setOnClickListener(this);
        btnPindahObject = (Button) findViewById(R.id.btn_pindah_objek);
        btnPindahObject.setOnClickListener(this);
        btnNumberTlp = (Button)findViewById(R.id.btn_nomer_tlfon);
        btnNumberTlp.setOnClickListener(this);
        btnPindahHasil = (Button) findViewById(R.id.btn_pindah_hasil);
        btnPindahHasil.setOnClickListener(this);
        tvHasil = (TextView)findViewById(R.id.tv_hasil);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_pindah:
                Intent moveIntent = new Intent(MainActivity.this, PindahActivity.class);
                startActivity(moveIntent);
            break;
            case R.id.btn_pindah_data:
                Intent moveDataIntent = new Intent(MainActivity.this, PindahActivity.class);
                moveDataIntent.putExtra(PindahActivity.EXTRA_NAME, "agung");
                moveDataIntent.putExtra(PindahActivity.EXTRA_AGE, 19);
                startActivity(moveDataIntent);
                break;

            case R.id.btn_pindah_objek:
                Person mPerson = new Person();
                mPerson.setName("agung");
                mPerson.setEmail("gmail.com");
                mPerson.setAge(19);
                mPerson.setKota("smg");
                Intent moveObjectIntent = new Intent(MainActivity.this, PindahObjectActivity.class);
                moveObjectIntent.putExtra(PindahObjectActivity.EXTRA_PERSON, mPerson);
                startActivity(moveObjectIntent);
                break;

            case R.id.btn_nomer_tlfon:
                String phoneNumber = "085729785625";
                Intent dialPhoneIntent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel: " +phoneNumber));
                startActivity(dialPhoneIntent);
                break;

            case R.id.btn_pindah_hasil:
                Intent moveResultIntent = new Intent(MainActivity.this,HasilActivity.class);
                startActivityForResult(moveResultIntent, REQUEST_CODE);
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode,Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE){
            if (resultCode== HasilActivity.RESULT_CODE){
                int selectedValue = data.getIntExtra(HasilActivity.EXTRA_SELECTED_VALUE,0);
                tvHasil.setText("Hasil :" +selectedValue);
            }
        }
    }
}
