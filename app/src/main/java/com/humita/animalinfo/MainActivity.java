package com.humita.animalinfo;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public static final int REQUEST_CODE_MENU = 101;

    @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            ImageButton aHos_i = findViewById(R.id.i_AHos_info);
            aHos_i.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(getApplicationContext(), h_info_Activity.class);
                    startActivityForResult(intent, REQUEST_CODE_MENU);
                }
            });

            ImageButton ani_i = findViewById(R.id.i_A_info);
            ani_i.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(getApplicationContext(), a_info_Activity.class);
                    startActivityForResult(intent, REQUEST_CODE_MENU);
                }
            });
            ImageButton h_info_l = findViewById(R.id.i_aHos_info);
            h_info_l.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(getApplicationContext(), h_info_list_Activity.class);
                    startActivityForResult(intent, REQUEST_CODE_MENU);
                }
            });
            ImageButton i_Pri_info = findViewById(R.id.i_Pri_info);
        i_Pri_info.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(getApplicationContext(), priv_info_Activity.class);
                    startActivityForResult(intent, REQUEST_CODE_MENU);
                }
            });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode==RESULT_OK){
            Toast.makeText(getApplicationContext(), "메인 화면으로 돌아왔습니다.", Toast.LENGTH_LONG).show();
        }
    }
}
