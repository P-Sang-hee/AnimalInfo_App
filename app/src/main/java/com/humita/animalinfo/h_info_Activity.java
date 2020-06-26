// 병원 정보 등록 및 공유 화면 액티비티.

package com.humita.animalinfo;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.humita.animalinfo.R;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class h_info_Activity extends AppCompatActivity {

    SQLiteDatabase hos_database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.h_info);

        Button CancleB = findViewById(R.id.cancleB);
        Button SaveB = findViewById(R.id.saveB);
        Button ShareB = findViewById(R.id.shareB);

        CancleB.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent = new Intent();
                setResult(RESULT_OK, intent);
                finish();
            }
        });

        SaveB.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                showSaveMessage();
            }
        });
        ShareB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showShareMessage();
            }
        });
    }

    private void showSaveMessage(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("저장");
        builder.setMessage("저장하시겠습니까?");
        builder.setIcon(android.R.drawable.ic_dialog_alert);

        builder.setPositiveButton("저장", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                Toast.makeText(getApplicationContext(), "저장되었습니다.", Toast.LENGTH_LONG).show();
            }
            // 필수 작성란이 비어있을 경우, 공란이 존재합니다 토스트 메세지 띄우는 부분 구현.
            // 또한, 기기 내부에 저장하는 코드 구현 필요.
        });

        builder.setNeutralButton("취소", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getApplicationContext(), "취소되었습니다.", Toast.LENGTH_LONG).show();
            }
        });

        AlertDialog savedialog = builder.create();
        savedialog.show();
    }

    private void showShareMessage(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("공유");
        builder.setMessage("공유하시겠습니까?");
        builder.setMessage("해당 병원이 위치한 지역을 선택하여 주십시오.");
        builder.setIcon(android.R.drawable.ic_dialog_alert);

        //지역 선택 spinner 추가.

        builder.setPositiveButton("공유", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getApplicationContext(), "공유되었습니다.", Toast.LENGTH_LONG).show();
            }
        });

        builder.setNeutralButton("취소", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getApplicationContext(), "취소되었습니다.", Toast.LENGTH_LONG).show();
            }
        });

        AlertDialog savedialog = builder.create();
        savedialog.show();
    }

}
