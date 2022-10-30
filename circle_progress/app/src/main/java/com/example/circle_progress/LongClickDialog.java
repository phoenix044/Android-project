package com.example.circle_progress;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.widget.ImageButton;

import androidx.annotation.NonNull;

public class LongClickDialog extends Dialog {
    private LongClickProgressView longClickProgressView;
    private Context mContext;

    public LongClickDialog(@NonNull Context context) {
        super(context, R.style.edit_AlertDialog_style);
        if (context instanceof Activity) {
            setOwnerActivity((Activity) context);
        }
        mContext = context;
    }


    @Override
    protected void onCreate(Bundle onSavedInstanceState) {
        super.onCreate(onSavedInstanceState);
        setContentView(R.layout.fragmenr_long_click);

        longClickProgressView = findViewById(R.id.long_click);
        setCancelable(false);
        setCanceledOnTouchOutside(false);
        longClickProgressView.setOnLongClickStateListener(new LongClickProgressView.OnLongClickStateListener() {
            @Override
            public void onFinish() {
                longClickProgressView.setCenterImage(R.drawable.unlock);
                ImageButton lock_button = getOwnerActivity().findViewById(R.id.btn_long_click);
                if (lock_button.isSelected())   lock_button.setSelected(false);
                dismiss();
                dismiss();
            }

            @Override
            public void onProgress(float progress) {

            }

            @Override
            public void onCancel() {

            }
        });
    }
}
