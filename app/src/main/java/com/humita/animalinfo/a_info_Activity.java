// 반려동물 정보 등록 화면 액티비티.

package com.humita.animalinfo;

import android.content.ContentResolver;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.InputStream;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class a_info_Activity extends AppCompatActivity {
    ImageView aimgV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.a_info);

        Button CancleB = findViewById(R.id.cancleB);
        Button SaveB = findViewById(R.id.saveB);
        aimgV = findViewById(R.id.Selectimg_animal);

        SaveB.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                showSaveMessage();
            }
        });

        CancleB.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent = new Intent();
                setResult(RESULT_OK, intent);
                finish();
            }
        });

        aimgV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openGallery();
            }
        });
    }

    public void openGallery(){
        Intent og = new Intent();
        og.setType("image/*");
        og.setAction(Intent.ACTION_GET_CONTENT);

        startActivityForResult(og, 101);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode==101){
            if(resultCode==RESULT_OK){
                Uri fileUri = data.getData();

                ContentResolver r1 = getContentResolver();

                try {
                    InputStream is1 = r1.openInputStream(fileUri);

                    Bitmap iB1 = BitmapFactory.decodeStream(is1);
                    aimgV.setImageBitmap(iB1);

                    is1.close();
                } catch (Exception e){
                    e.printStackTrace();
                }
            }
        }
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
}
