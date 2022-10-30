package com.example.circle_progress;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Chronometer;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Chronometer mTimer = findViewById(R.id.timer);
        mTimer.setBase(SystemClock.elapsedRealtime());
        mTimer.start();
        ImageButton lockButton = findViewById(R.id.btn_long_click);
        lockButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                lockButton.setSelected(!lockButton.isSelected());
//                LongClickFragment longClickFragment = new LongClickFragment();
//                getSupportFragmentManager().beginTransaction().replace(R.id.container, longClickFragment).commit();
//
//                Dialog dialog = new Dialog(MainActivity.this, R.style.edit_AlertDialog_style);
//                dialog.setContentView(R.layout.fragmenr_long_click);
//                new LongClickProgressView(MainActivity.this);
//                LongClickProgressView longClickProgressView;
//                longClickProgressView = findViewById(R.id.long_click);
//                dialog.setCanceledOnTouchOutside(false);
//                dialog.show();
////                if (longClickProgressView.getProgressFinishState()) {
////                    dialog.dismiss();
////                }
                new LongClickDialog(MainActivity.this).show();
            }
        });

    }
}