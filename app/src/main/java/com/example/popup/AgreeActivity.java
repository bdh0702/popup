package com.example.popup;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatCheckBox;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Toast;

public class AgreeActivity extends AppCompatActivity {

    public Button btn_next; //다음 진행 버튼

    public int TERMS_AGREE_1 = 0; //체크 안될 시 0  체크시 1
    public int TERMS_AGREE_2 = 0;
    public int TERMS_AGREE_3 = 0;

    AppCompatCheckBox check1; //첫번째 동의
    AppCompatCheckBox check2; //두번째 동의
    AppCompatCheckBox check3; //모두 동의
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agree);
        check1=findViewById(R.id.check1);
        check1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    TERMS_AGREE_1 = 1;
                }else{
                    TERMS_AGREE_1 = 0;
                }
            }
        });
        check2=findViewById(R.id.check2);
        check2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    TERMS_AGREE_2 = 1;
                }else{
                    TERMS_AGREE_2 = 0;
                }
            }
        });
        check3=findViewById(R.id.check3);
        check3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    check1.setChecked(true);
                    check2.setChecked(true);
                    TERMS_AGREE_3 = 1;
                }else{
                    check1.setChecked(false);
                    check2.setChecked(false);
                    TERMS_AGREE_3 = 0;
                }
            }
        });
        btn_next = findViewById(R.id.btn_next);
        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(TERMS_AGREE_3 != 1){
                    if(TERMS_AGREE_2 == 1){
                        if(TERMS_AGREE_1 ==1){
                            Intent intent = new Intent(AgreeActivity.this,HomeActivity.class);
                            startActivity(intent);
                        } else {
                            Toast.makeText(AgreeActivity.this, "약관을 체크해주세요", Toast.LENGTH_SHORT).show();
                            return;
                        }
                    } else {
                        Toast.makeText(AgreeActivity.this, "약관을 체크해주세요", Toast.LENGTH_SHORT).show();
                        return;
                    }
                }
                else {
                    Intent intent = new Intent(AgreeActivity.this,HomeActivity.class);
                    startActivity(intent);
                }
            }
        });


    }
}


