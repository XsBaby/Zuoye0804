package com.xushuai.zuoye0804;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import com.xushuai.zuoye0804.adapter.GvAdapter;
import com.xushuai.zuoye0804.bean.ImageInfo;
import com.xushuai.zuoye0804.view.PicShowDialog;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<ImageInfo> list;
    private String[] urls = {ConstantValue.PIC_URL1, ConstantValue.PIC_URL2, ConstantValue.PIC_URL3, ConstantValue.PIC_URL4};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initData();
        initView();
    }

    private void initData() {
        list = new ArrayList<>();
        for (int i = 0; i < urls.length; i++) {
            ImageInfo imageInfo = new ImageInfo(urls[i], 200, 200);
            list.add(imageInfo);
        }
    }

    private void initView() {
        GridView gv_pic = (GridView) findViewById(R.id.gv_pic);
        gv_pic.setAdapter(new GvAdapter(this, list));
        gv_pic.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                PicShowDialog dialog = new PicShowDialog(MainActivity.this, list, position);
                dialog.show();
            }
        });
    }
}