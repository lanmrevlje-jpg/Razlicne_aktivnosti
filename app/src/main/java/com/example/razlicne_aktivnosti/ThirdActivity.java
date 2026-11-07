package com.example.razlicne_aktivnosti;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ThirdActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_third);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        int i = getIntent().getIntExtra("stevec", 0);

        Button ma1=findViewById(R.id.button5);
        Button ma2=findViewById(R.id.button6);
        TextView s=findViewById(R.id.textView7);
        s.setText(String.valueOf(i));
        ma1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(ThirdActivity.this, MainActivity.class);
                intent.putExtra("stevec", i);
                startActivity(intent);

            }
        });
        ma2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2= new Intent(ThirdActivity.this, HelloActivity.class);
                intent2.putExtra("stevec", i);
                startActivity(intent2);
            }
        });
    }
}