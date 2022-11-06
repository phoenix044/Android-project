package com.example.circle_progress;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageButton;

import androidx.fragment.app.Fragment;

public class LongClickFragment extends Fragment {

    private View view;
    private Dialog mDialog;
    private boolean isFragmentAlive = true;

    @Override
    public void onCreate(Bundle savedInstanceState) {
//        getActivity().getWindow().addFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (view == null) {
            view = inflater.inflate(R.layout.fragmenr_long_click, container, false);
        }

        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        LongClickProgressView longClickProgressView = view.findViewById(R.id.long_click);
//        longClickProgressView.setOnLongClickStateListener(new LongClickProgressView.OnLongClickStateListener() {
//            @Override
//            public void onFinish() {
//                longClickProgressView.setCenterImage(R.drawable.unlock);
//                mDialog.dismiss();
//                stop();
//            }
//
//            @Override
//            public void onProgress(float progress) {
//
//            }
//
//            @Override
//            public void onCancel() {
//
//            }
//        });
    }


    public void stop() {
        if (getActivity().getSupportFragmentManager() != null) {
            getActivity().getSupportFragmentManager().beginTransaction().remove(this).commit();
            ImageButton lock_button = getActivity().findViewById(R.id.btn_long_click);
            if (lock_button.isSelected())   lock_button.setSelected(false);
        }
    }

    public boolean getFragmentAlive() {
        return isFragmentAlive;
    }
}
