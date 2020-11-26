package com.beebeom.a04_implicitintent_2;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText editTextMessage = findViewById(R.id.et_msg);
        findViewById(R.id.btn_send_msg).setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_SEND);
            //메세지를 보낼때는 setType을 해줘야함.
            intent.setType("text/plain");
            //키 값도 이렇게 해줘야함.
            intent.putExtra(Intent.EXTRA_TEXT, editTextMessage.getText().toString());
            if (intent.resolveActivity(getPackageManager()) != null){
                startActivity(intent);
            }else {
                Toast.makeText(this, "이 액션을 수행할 어플리케이션이 없습니다.", Toast.LENGTH_SHORT).show();
            }
            //암시적 인텐트를 사용하는 여러가지 방법은
            //https://developer.android.com/guide/components/intents-common
            //안드로이드 개발자에 다 나와있음.
        });
    }
}