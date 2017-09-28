package com.curry.wsd.spannablestring.base;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;

/**
 * Created by WuSongDa on 2017/9/28.
 */
public abstract class BaseActivity extends AppCompatActivity{


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        beforeInit();
        if (getContentViewLayoutId()!=0) {
            setContentView(getContentViewLayoutId());
            initView(savedInstanceState);
        }
    }

    protected abstract void beforeInit();

    protected abstract void initView(Bundle savedInstanceState);

    protected abstract int getContentViewLayoutId();

    @Override
    public void setContentView(@LayoutRes int layoutResID) {
        super.setContentView(layoutResID);
        ButterKnife.bind(this);
    }
}
