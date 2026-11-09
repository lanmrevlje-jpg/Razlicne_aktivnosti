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
    private void goToActivity1() {
        Intent intent = new Intent(this, MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
        startActivity(intent);
    }
    private void goToActivity2() {
        Intent intent = new Intent(this, HelloActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
        startActivity(intent);
    }
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
                goToActivity1();
            }
        });
        ma2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToActivity2();
            }
        });
        View layout = findViewById(R.id.main);
        if (layout != null) {
            layout.setOnTouchListener(new OnSwipeTouchListener(this) {
                @Override
                public void onSwipeLeft() {
                    goToActivity1();
                }

                @Override
                public void onSwipeRight() {
                    goToActivity2();
                }
            });
        }


    }
}