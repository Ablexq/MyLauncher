package com.example.mylauncher;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private LaunchUtil mLaunchUtil;
    private ComponentName mDefault;
    private ComponentName mDouble11;
    private ComponentName mDouble22;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mDefault = new ComponentName(getBaseContext(), getPackageName() + ".DefaultAlias");
        mDouble11 = new ComponentName(getBaseContext(), getPackageName() + ".NewActivity1");
        mDouble22 = new ComponentName(getBaseContext(), getPackageName() + ".NewActivity2");
        mLaunchUtil = new LaunchUtil(getApplicationContext().getPackageManager());
    }

    public void onclick(View view) {
        switch (view.getId()) {
            case R.id.btn1:
                changeIcon11();
                break;
            case R.id.btn2:
                changeIcon22();
                break;
            case R.id.btn3:
                defaultIcon();
                break;
            case R.id.btn4:
                showToast();
                break;
            default:
                break;
        }
    }

    private void defaultIcon() {
        mLaunchUtil.disableComponent(mDouble11);
        mLaunchUtil.disableComponent(mDouble22);
        mLaunchUtil.enableComponent(mDefault);
    }


    public void changeIcon11() {
        mLaunchUtil.disableComponent(mDefault);
        mLaunchUtil.disableComponent(mDouble22);
        mLaunchUtil.enableComponent(mDouble11);
    }

    public void changeIcon22() {
        mLaunchUtil.disableComponent(mDefault);
        mLaunchUtil.disableComponent(mDouble11);
        mLaunchUtil.enableComponent(mDouble22);
    }

    //原理如下：
    //自定义一个空数组，每次把数组整体向前移动一位，
    //然后给数组最后一位赋值一个时间数，当SystemClock.uptimeMillis()与数组第一位之间的时间差小于1秒时，生效。
    private long[] mHints = new long[5];

    public void showToast() {
        //把从第二位至最后一位之间的数字复制到第一位至倒数第一位
        //src 拷贝的源数组
        //srcPos 从源数组的那个位置开始拷贝.
        //dst 目标数组
        //dstPos 从目标数组的那个位子开始写数据
        //length 拷贝的元素的个数
        System.arraycopy(mHints, 1, mHints, 0, mHints.length - 1);
        mHints[mHints.length - 1] = SystemClock.uptimeMillis();//从开机到现在的时间毫秒数
        if (SystemClock.uptimeMillis() - mHints[0] <= 1000) {//连续点击之间间隔小于一秒，有效
            Toast.makeText(MainActivity.this, "你成功了", Toast.LENGTH_SHORT).show();
        }
    }


}
