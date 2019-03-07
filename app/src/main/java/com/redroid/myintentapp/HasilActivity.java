package com.redroid.myintentapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;

public class HasilActivity extends AppCompatActivity implements View.OnClickListener{
    private Button btnPilih;
    private RadioGroup rbAngka;
    public static String EXTRA_SELECTED_VALUE = "extra_selected_value";
    public static int RESULT_CODE = 110;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hasil);
        btnPilih = (Button)findViewById(R.id.btn_pilih);
        btnPilih.setOnClickListener(this);
        rbAngka = (RadioGroup)findViewById(R.id.rg_nomer);
    }

    @Override
    public void onClick(View view) {
        if (view.getId()== R.id.btn_pilih){
            if (rbAngka.getCheckedRadioButtonId() != 0){
                int value = 0;
                switch (rbAngka.getCheckedRadioButtonId()){
                    case R.id.rb_60:
                        value = 60 ;
                        break;
                    case R.id.rb_120:
                        value = 120;
                        break;
                    case R.id.rb_180:
                        value = 180;
                        break;
                    case  R.id.rb_240:
                        value = 240;
                        break;
                }
                Intent resultIntent = new Intent();
                resultIntent.putExtra(EXTRA_SELECTED_VALUE, value);
                setResult(RESULT_CODE, resultIntent);
                finish();
            }
        }
    }
}
