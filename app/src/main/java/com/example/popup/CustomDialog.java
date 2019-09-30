package com.example.popup;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Toast;

import androidx.appcompat.widget.AppCompatCheckBox;

public class CustomDialog {
    Button btn_next,btn_ok1,btn_ok2;
    private Context context;
    public int TERMS_AGREE_1 = 0; //체크 안될 시 0  체크시 1
    public int TERMS_AGREE_2 = 0;
    public int TERMS_AGREE_3 = 0;

    AppCompatCheckBox check1; //첫번째 동의
    AppCompatCheckBox check2; //두번째 동의
    AppCompatCheckBox check3; //모두 동의

    public CustomDialog(Context context) {
        this.context = context;
    }

    public void call(){
        final Dialog dlg = new Dialog(context);
        dlg.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dlg.setContentView(R.layout.activity_agree);
        dlg.show();

        btn_next = dlg.findViewById(R.id.btn_next); //다음 진행 버튼
        btn_ok1 = dlg.findViewById(R.id.agree_ok1);
        btn_ok2 = dlg.findViewById(R.id.agree_ok2);
        check1 = dlg.findViewById(R.id.check1);
        check2 = dlg.findViewById(R.id.check2);
        check3 = dlg.findViewById(R.id.check3);

        btn_ok1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(dlg.getContext(),Popup.class);
                dlg.getContext().startActivity(intent);
            }
        });

        btn_ok2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(dlg.getContext(),Popup2.class);
                dlg.getContext().startActivity(intent);
            }
        });

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

        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(TERMS_AGREE_3 != 1){
                    if(TERMS_AGREE_2 == 1){
                        if(TERMS_AGREE_1 ==1){
                            Intent intent = new Intent(dlg.getContext(),HomeActivity.class);
                            dlg.getContext().startActivity(intent);
                        } else {
                            Toast.makeText(dlg.getContext(), "약관을 체크해주세요", Toast.LENGTH_SHORT).show();
                            return;
                        }
                    } else {
                        Toast.makeText(dlg.getContext(), "약관을 체크해주세요", Toast.LENGTH_SHORT).show();
                        return;
                    }
                }
                else {
                    Intent intent = new Intent(dlg.getContext(),HomeActivity.class);
                    dlg.getContext().startActivity(intent);
                    dlg.dismiss();
                }
            }
        });


    }


}
