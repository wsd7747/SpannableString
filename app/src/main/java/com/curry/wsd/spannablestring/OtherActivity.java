package com.curry.wsd.spannablestring;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.curry.wsd.spannablestring.base.BaseActivity;
import com.curry.wsd.spannablestring.utils.StatusBarUtil;

public class OtherActivity extends BaseActivity {

    @Override
    protected void beforeInit() {
        //StatusBarUtil.setTranslucent(this);
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        TextView textView = (TextView) findViewById(R.id.text01);
        Intent intent = getIntent();
        if(intent != null) {
            Bundle bundle = intent.getBundleExtra("bundle");
            if(bundle != null) {
                String content = bundle.getString("content");
                textView.setText("这是传过来的内容：" + content);
            }
        }
    }

    @Override
    protected int getContentViewLayoutId() {
        return R.layout.activity_main;
    }
}
