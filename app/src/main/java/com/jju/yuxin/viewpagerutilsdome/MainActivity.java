package com.jju.yuxin.viewpagerutilsdome;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.jju.yuxin.viewpagerutils_v1.ADViewPagerUtils;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ViewPager vp_vp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        vp_vp = (ViewPager) findViewById(R.id.vp_vp);
        List<Bitmap> bitmaps =new ArrayList<>();
        Bitmap bitmap1= BitmapFactory.decodeResource(getResources(),R.drawable.page1);
        Bitmap bitmap2= BitmapFactory.decodeResource(getResources(),R.drawable.page2);
        Bitmap bitmap3= BitmapFactory.decodeResource(getResources(),R.drawable.page3);
        Bitmap bitmap4= BitmapFactory.decodeResource(getResources(),R.drawable.page4);
        bitmaps.add(bitmap1);
        bitmaps.add(bitmap2);
        bitmaps.add(bitmap3);
        bitmaps.add(bitmap4);
        ADViewPagerUtils adViewPagerUtils=new ADViewPagerUtils(this,vp_vp,bitmaps);
        adViewPagerUtils.init();
    }
}
