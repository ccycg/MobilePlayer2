package com.example.yangcg.mobileplayer2.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;

import com.example.yangcg.mobileplayer2.R;

public class SplashActivity extends Activity {


    private static final Object TAG = SplashActivity.class.getSimpleName() ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                //两秒后才执行到这里
                //执行在主线程中
                StartMainActivity();
                Log.e((String) TAG,"当前线程名称==" +Thread.currentThread().getName());
            }
        },2000);
    }
    /*
    * 跳转到主页面，并且把当前页面关闭掉
    * */
    private void StartMainActivity() {
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
        //关闭当前页面
        finish();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.e((String) TAG,"onTouchEvent==Action"+event.getAction());
        StartMainActivity();
        return super.onTouchEvent(event);
    }
}
