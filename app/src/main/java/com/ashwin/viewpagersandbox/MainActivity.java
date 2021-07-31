package com.ashwin.viewpagersandbox;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.ashwin.viewpagersandbox.frag.FragActivity;
import com.ashwin.viewpagersandbox.fragtab1.FragTab1Activity;
import com.ashwin.viewpagersandbox.fragtab2.FragTab2Activity;
import com.ashwin.viewpagersandbox.view.ViewActivity;
import com.ashwin.viewpagersandbox.viewtab.ViewTabActivity;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button viewButton = findViewById(R.id.view_button);
        viewButton.setOnClickListener(view -> {
            startActivity(new Intent(MainActivity.this, ViewActivity.class));
        });

        Button fragButton = findViewById(R.id.frag_button);
        fragButton.setOnClickListener(view -> {
            startActivity(new Intent(MainActivity.this, FragActivity.class));
        });

        Button viewTabButton = findViewById(R.id.view_tab_button);
        viewTabButton.setOnClickListener(view -> {
            startActivity(new Intent(MainActivity.this, ViewTabActivity.class));
        });

        Button fragTab1Button = findViewById(R.id.frag_tab_1_button);
        fragTab1Button.setOnClickListener(view -> {
            startActivity(new Intent(MainActivity.this, FragTab1Activity.class));
        });

        Button fragTab2Button = findViewById(R.id.frag_tab_2_button);
        fragTab2Button.setOnClickListener(view -> {
            startActivity(new Intent(MainActivity.this, FragTab2Activity.class));
        });
    }
}
