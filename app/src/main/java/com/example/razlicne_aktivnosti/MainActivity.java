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

public class MainActivity extends AppCompatActivity {
    public int i=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        i=getIntent().getIntExtra("stevec", 0);
        Button count=findViewById(R.id.button3);
        Button hello=findViewById(R.id.button);
        Button third=findViewById(R.id.button2);
        TextView st=findViewById(R.id.textView2);
        st.setText(String.valueOf(i));
        count.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                st.setText(String.valueOf(i+1));
                i++;
            }
        });
        hello.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, HelloActivity.class);
                intent.putExtra("stevec", i);
                startActivity(intent);
            }
        });
        third.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(MainActivity.this, ThirdActivity.class);
                intent2.putExtra("stevec", i);
                startActivity(intent2);
            }
        });
    }
}