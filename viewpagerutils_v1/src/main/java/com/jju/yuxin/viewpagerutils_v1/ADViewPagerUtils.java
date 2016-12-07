package com.jju.yuxin.viewpagerutils_v1;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Handler;
import android.os.Message;
import android.support.v4.view.ViewPager;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import static android.graphics.drawable.GradientDrawable.OVAL;
import static android.util.Log.e;

/**
 * =============================================================================
 * Copyright (c) 2016 yuxin All rights reserved.
 * Packname com.jju.yuxin.viewpagerdemo
 * Created by yuxin.
 * Created time 2016/12/5 0005 下午 10:48.
 * Version   1.0;
 * Describe :注意事项:传入的Viewpager的父容器应当是RelativeLayout
 *           控件的高度取决于外层包裹的RelativeLayout的高度
 * History:
 * ==============================================================================
 */

public class ADViewPagerUtils {
    private static final String TAG =ADViewPagerUtils.class.getSimpleName();

    //设置一个自己发自己handler
    private Handler mhandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (isInfiniteLoop) {
                int currentItem = vp_vp.getCurrentItem();
                vp_vp.setCurrentItem(currentItem+1);
            } else {
                int currentItem = vp_vp.getCurrentItem();
                e(TAG, "handleMessage" + "currentItem:"+(currentItem + 1) % bitmaps.size());
                vp_vp.setCurrentItem((currentItem + 1) % bitmaps.size());
            }
            mhandler.sendEmptyMessageDelayed(0, timer_delay);
        }
    };

    private Context mcontext;
    //需要传入的Viewpager对象
    private ViewPager vp_vp;
    //需要显示的bitmap
    private List<Bitmap> bitmaps;
    //bitmap的的底部
    private LinearLayout ll_buttom_bar;
    //底部导航栏
    private List<TextView> textViews;
    //是否为无限循环模式
    private boolean isInfiniteLoop = true;
    //设置自动轮播间隔
    private int timer_delay=2000;
    //设置低栏背景颜色
    private String buttomColor="#00ffffff";
    //圆点未选中颜色
    private String unpressedColor="#ffffff";
    //圆点选中的颜色
    private String pressedColor="#ff0000";
    //圆点间隔
    private int circleMargin=5;
    //圆点大小
    private int circleSize=10;
    //圆点位置，位于父容器的位置
    private int circleGravity=Gravity.RIGHT;
    //设置是否自动轮播
    private boolean isStartLoop=true;
    //底栏高度
    private float buttom_bar_high=20;

    //ViewPager的点击事件
    private setOnItemClickListener onitemClickListener;

    //ViewPager构造器
    public ADViewPagerUtils(Context mcontext, ViewPager viewPager, List<Bitmap> bitmaps) {
        this.mcontext=mcontext;
        this.vp_vp=viewPager;
        this.bitmaps=bitmaps;
    }


    public String getButtomColor() {
        return buttomColor;
    }

    /**
     * 设置低栏背景颜色 如:"#000000"
     * @param buttomColor
     * @return ADViewPagerUtils
     */
    public ADViewPagerUtils setButtomColor(String buttomColor) {
        this.buttomColor = buttomColor;
        return this;
    }

    public int getCircleGravity() {
        return circleGravity;
    }

    /**
     * 圆点位置，位于父容器的位置
     * Gravity.CENTER
     * Gravity.LEFT
     * Gravity.RIGHT
     * @param circleGravity
     * @return ADViewPagerUtils
     */
    public ADViewPagerUtils setCircleGravity(int circleGravity) {
        this.circleGravity = circleGravity;
        return this;
    }

    public int getCircleMargin() {
        return circleMargin;
    }

    /**
     * 圆点间隔
     * @param circleMargin  dp
     * @return 圆点间隔
     */
    public ADViewPagerUtils setCircleMargin(int circleMargin) {
        this.circleMargin = circleMargin;
        return this;
    }

    public int getCircleSize() {
        return circleSize;
    }

    /**
     * 圆点大小
     * @param circleSize  dp
     * @return  圆点大小
     */
    public ADViewPagerUtils setCircleSize(int circleSize) {
        this.circleSize = circleSize;
        return this;
    }


    public boolean isInfiniteLoop() {
        return isInfiniteLoop;
    }

    /**
     * 是否为无限循环模式
     * @param infiniteLoop
     * @return  ADViewPagerUtils
     */
    public ADViewPagerUtils setInfiniteLoop(boolean infiniteLoop) {
        isInfiniteLoop = infiniteLoop;
        return this;

    }

    public boolean isStartLoop() {
        return isStartLoop;
    }

    /**
     * 是否开启自动轮播
     * @param startLoop 是否开启自动轮播
     * @return   ADViewPagerUtils
     */
    public ADViewPagerUtils setStartLoop(boolean startLoop) {
        isStartLoop = startLoop;
        return this;
    }

    public String getPressedColor() {
        return pressedColor;
    }

    /**
     * 圆点选中的颜色 如:"#ff0000"
     * @param pressedColor 圆点选中的颜色
     * @return  ADViewPagerUtils
     */
    public ADViewPagerUtils setPressedColor(String pressedColor) {
        this.pressedColor = pressedColor;
        return this;
    }


    public int getTimer_delay() {
        return timer_delay;
    }

    /**
     * 设置自动轮播间隔  时间毫秒
     * @param timer_delay  时间毫秒
     * @return ADViewPagerUtils
     */
    public ADViewPagerUtils setTimer_delay(int timer_delay) {
        this.timer_delay = timer_delay;
        return this;
    }

    public String getUnpressedColor() {
        return unpressedColor;
    }

    /**
     * 圆点未选中颜色 如:"#ffffff"
     * @param unpressedColor 圆点未选中颜色
     * @return   ADViewPagerUtils
     */
    public ADViewPagerUtils setUnpressedColor(String unpressedColor) {
        this.unpressedColor = unpressedColor;
        return this;
    }

    public float getButtom_bar_high() {
        return buttom_bar_high;
    }

    /**
     * 底栏高度
     * @param buttom_bar_high  底栏高度
     * @return  ADViewPagerUtils
     */
    public ADViewPagerUtils setButtom_bar_high(float buttom_bar_high) {
        this.buttom_bar_high = buttom_bar_high;
        return this;
    }

    /**
     * 参数的设置需要在执行这个方法之前
     * ViewPager的初始化
     */
    public void init(){

        //设置底部指示栏
        //包裹指示器的RelativeLayout
        RelativeLayout parent = (RelativeLayout) vp_vp.getParent();
        //添加底栏
        ll_buttom_bar = new LinearLayout(mcontext);
        //设置底栏背景颜色
        ll_buttom_bar.setBackgroundColor(Color.parseColor(buttomColor));

        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, DensityUtil.dip2px(mcontext, buttom_bar_high));
        //设置底栏位于底部
        params.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
        ll_buttom_bar.setLayoutParams(params);
        //设置内容水平方向摆放
        ll_buttom_bar.setOrientation(LinearLayout.HORIZONTAL);
        //设置原点摆放位置
        ll_buttom_bar.setGravity(circleGravity);
        parent.addView(ll_buttom_bar);

        //设置适配器
        Vp_Adapter vp_adapter = new Vp_Adapter(mcontext, bitmaps, isInfiniteLoop);
        vp_vp.setAdapter(vp_adapter);

        int roundRadius = Integer.MAX_VALUE; //圆角半径
        int whiteColor = Color.parseColor(unpressedColor);//白色填充
        int redColor = Color.parseColor(pressedColor);//红色填充

        GradientDrawable unpress_gd = new GradientDrawable();//创建shape
        unpress_gd.setShape(OVAL);
        unpress_gd.setColor(whiteColor);
        unpress_gd.setCornerRadius(DensityUtil.dip2px(mcontext,roundRadius));

        GradientDrawable press_gd = new GradientDrawable();//创建shape
        press_gd.setShape(OVAL);
        press_gd.setColor(redColor);
        press_gd.setCornerRadius(DensityUtil.dip2px(mcontext,roundRadius));

        final StateListDrawable selectordrawable = new StateListDrawable();  //创建selector
        final StateListDrawable unselectordrawable = new StateListDrawable(); //创建selector
        //enable  true状态
        selectordrawable.addState(new int[]{android.R.attr.state_pressed},press_gd);
        selectordrawable.addState(new int[]{},unpress_gd);//默认
        //enable  false状态
        unselectordrawable.addState(new int[]{-android.R.attr.state_pressed},unpress_gd);
        unselectordrawable.addState(new int[]{},unpress_gd);//默认

        //动态添加四个小圆点
        textViews = new ArrayList<TextView>();
        for (int i = 0; i < bitmaps.size(); i++) {
            TextView textView = new TextView(mcontext);
            LinearLayout.LayoutParams tv_params = new LinearLayout.LayoutParams(DensityUtil.dip2px(mcontext, circleSize), DensityUtil.dip2px(mcontext, circleSize));
            tv_params.setMargins(0, 0, circleMargin, 0);
            tv_params.gravity=Gravity.CENTER_VERTICAL;
            textView.setLayoutParams(tv_params);
            textView.setTag(i);

            //将初始化的状态置为press false
            textView.setPressed(false);
            //代码编写shape和selector
            textView.setBackground(selectordrawable);

            ll_buttom_bar.addView(textView);
            textViews.add(textView);
        }

        //设置一看是进去的位置
        if (isInfiniteLoop) {
            vp_vp.setCurrentItem(Integer.MAX_VALUE / 2 - Integer.MAX_VALUE / 2 % bitmaps.size());
        } else {
            vp_vp.setCurrentItem(0);
        }

        //是否开启自动轮播
        if (isStartLoop){
            mhandler.sendEmptyMessageDelayed(0, timer_delay);
        }


        vp_vp.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                //动态改变小圆点
                for (TextView textview : textViews) {
                    //现将全部置为false
                    textview.setPressed(false);
                    textview.setBackground(unselectordrawable);
                }
                if (isInfiniteLoop) {
                    //将指定的position指定为true
                    textViews.get(position%bitmaps.size()).setPressed(true);
                    textViews.get(position%bitmaps.size()).setBackground(selectordrawable);
                } else {
                    //将指定的position指定为true
                    textViews.get(position).setPressed(true);
                    textViews.get(position).setBackground(selectordrawable);
                }
            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {
                mhandler.removeCallbacksAndMessages(null);
                switch (state) {
                    case ViewPager.SCROLL_STATE_IDLE:
                        //放置被点击的时候页面轮播
                        if (isStartLoop){
                            mhandler.sendEmptyMessageDelayed(0, timer_delay);
                        }
                        break;
                    default:
                        break;
                }

            }
        });

        vp_adapter.setOnItemClickEvent(new Vp_Adapter.OnItemClickEvent() {
            @Override
            public void itemClick(ViewGroup container, View v, int position) {
                //如果为无线轮播模式返回的v将不会有相同的
                onitemClickListener.itemClickListener(container,v,position%bitmaps.size());
            }
        });
    }

    public void  setOnItemClickListener(setOnItemClickListener onitemClickListener){
        this.onitemClickListener=onitemClickListener;
    }

    public interface setOnItemClickListener{
        public void itemClickListener(ViewGroup container, View v, int position);
    }

}
