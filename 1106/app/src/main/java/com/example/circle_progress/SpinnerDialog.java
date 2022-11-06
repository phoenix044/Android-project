package com.example.circle_progress;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

public class SpinnerDialog extends Dialog {
    private Context mContext;
    private String[] mCategories, mItems = null;
    private String selectedCategory;
    private int currentCategory, currentItem;
    private ArrayAdapter adapter;
    private String category;
    private ListView category_listview, item_listview;

    public SpinnerDialog(Context context, String category){
        super(context, R.style.SpinnerDialog);
        mContext = context;
        selectedCategory = category;
    }

    @Override
    protected void onCreate(Bundle savedIntanceState) {
        super.onCreate(savedIntanceState);
        init();
    }

    private void init() {
        mCategories = new String[]{"走路","跑步", "骑车", "坐车"};
        if (selectedCategory != null && !selectedCategory.isEmpty()) {
        }
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View view = inflater.inflate(R.layout.spinner_layout, null);
        setContentView(view);

        category_listview = findViewById(R.id.spinner_list_1);
        category_listview.setAdapter(new ArrayAdapter<String>(mContext, R.layout.item_layout, mCategories));
        category_listview.setSelection(0);
        String[] tempArray = new String[]{"空"};
        adapter = new ArrayAdapter<String>(mContext, R.layout.item_layout, tempArray);
        item_listview = findViewById(R.id.spinner_list_2);
        item_listview.setAdapter(adapter);
        item_listview.setSelection(0);
        Button confirm_btn = findViewById(R.id.bt_confirm);
        confirm_btn.setOnClickListener(view1 -> dismiss());

        category_listview.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView absListView, int i) {
                if (i == SCROLL_STATE_IDLE) {
                    int position = category_listview.getFirstVisiblePosition();
                    category = mCategories[position + 1];
                    mItems = getItems(position + 1);
                    adapter = new ArrayAdapter<String>(mContext, R.layout.item_layout, mItems);
                    item_listview.setAdapter(adapter);
                }
            }

            @Override
            public void onScroll(AbsListView absListView, int i, int i1, int i2) {

            }
        });
    }

    private String[] getItems(int position) {
        String[] items = null;
        switch (position) {
            case 1:
                items = new String[]{"中慢走", "快走"};
                break;
            case 2:
                items = new String[]{"中慢跑", "快跑"};
                break;
            default:
                break;
        }
        return items;
    }
}
