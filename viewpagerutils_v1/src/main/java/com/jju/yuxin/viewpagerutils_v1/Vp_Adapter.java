package com.jju.yuxin.viewpagerutils_v1;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.List;

/**
 * =============================================================================
 * Copyright (c) 2016 yuxin All rights reserved.
 * Packname com.jju.yuxin.viewpagerdemo
 * Created by yuxin.
 * Created time 2016/12/5 0005 下午 3:13.
 * Version   1.0;
 * Describe : ViewPager的适配器
 * History:
 * ==============================================================================
 */

public class Vp_Adapter extends PagerAdapter {

    private Context mcontext;
    private List<Bitmap> bitmaps;
    private  boolean isInfiniteLoop;
    private  OnItemClickEvent onItemClickEvent;



    public Vp_Adapter(Context mcontext, List<Bitmap> bitmaps,boolean isInfiniteLoop) {
        this.mcontext = mcontext;
        this.bitmaps = bitmaps;
        this.isInfiniteLoop=isInfiniteLoop;

    }

    @Override
    public int getCount() {
        if (isInfiniteLoop){
        return Integer.MAX_VALUE;
        }else{
        return bitmaps.size();
        }
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view==object;
    }

    @Override
    public Object instantiateItem(final ViewGroup container, final int position) {
        ImageView imageView=new ImageView(mcontext);
        ViewGroup.LayoutParams params=new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        imageView.setLayoutParams(params);
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        if (isInfiniteLoop){
            imageView.setImageBitmap(bitmaps.get(position%bitmaps.size()));
        }else{
            imageView.setImageBitmap(bitmaps.get(position%bitmaps.size()));
        }

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //将当前的点击抛出去
                onItemClickEvent.itemClick(container,v,position);

            }
        });
        container.addView(imageView);
        return imageView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }

    public void setOnItemClickEvent(OnItemClickEvent onItemClickEvent){
        this.onItemClickEvent=onItemClickEvent;
    }


    public interface OnItemClickEvent{
        public void itemClick(ViewGroup container, View v, int position);
    }


}
