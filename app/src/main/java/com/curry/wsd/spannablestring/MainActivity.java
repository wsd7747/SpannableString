package com.curry.wsd.spannablestring;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.BackgroundColorSpan;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.StyleSpan;
import android.text.style.SuperscriptSpan;
import android.text.style.URLSpan;
import android.view.View;
import android.widget.TextView;

import com.curry.wsd.spannablestring.base.BaseActivity;
import com.curry.wsd.spannablestring.utils.StatusBarUtil;

import butterknife.BindView;

public class MainActivity extends BaseActivity {

    @BindView(R.id.text01)
    TextView textView01;
    @BindView(R.id.text02)
    TextView textView02;
    @BindView(R.id.text03)
    TextView textView03;
    @BindView(R.id.text04)
    TextView textView04;
    @BindView(R.id.text05)
    TextView textView05;
    @BindView(R.id.text06)
    TextView textView06;
    @BindView(R.id.text07)
    TextView textView07;

    private int position;
    @Override
    protected void beforeInit() {
       // StatusBarUtil.setTranslucent(this);
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        initView01();

        initView02();

        initView03();

        initView04();

        handler.sendEmptyMessage(0x200);

        initView06();

        initView07();
    }

    private void initView07() {
        SpannableString spannableString07 = new SpannableString("22 + 32 = 13");
        SuperscriptSpan superscriptSpan01 = new SuperscriptSpan();
        SuperscriptSpan superscriptSpan02 = new SuperscriptSpan();
        spannableString07.setSpan(superscriptSpan01, 1, 2 ,Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
        spannableString07.setSpan(superscriptSpan02, 6, 7 ,Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
        RelativeSizeSpan sizeSpan05 = new RelativeSizeSpan(0.5f);
        RelativeSizeSpan sizeSpan06 = new RelativeSizeSpan(0.5f);
        spannableString07.setSpan(sizeSpan05, 1, 2 ,Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
        spannableString07.setSpan(sizeSpan06, 6, 7 ,Spanned.SPAN_INCLUSIVE_EXCLUSIVE);

        textView07.setText(spannableString07);
    }

    private void initView06() {
        SpannableString spannableString06 = new SpannableString(textView06.getText().toString());
        ClickableSpan clickableSpan = new MyClickableSpan("15726126182");
        ForegroundColorSpan colorSpan04 = new ForegroundColorSpan(Color.parseColor("#FFFFFF"));
        BackgroundColorSpan backgroundColorSpan = new BackgroundColorSpan(Color.parseColor("#0099EE"));
        spannableString06.setSpan(colorSpan04, 2, 9, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        spannableString06.setSpan(clickableSpan, 2, 9, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        spannableString06.setSpan(backgroundColorSpan, 2, 9, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        textView06.setText(spannableString06);
        textView06.setMovementMethod(LinkMovementMethod.getInstance());
    }

    private void initView04() {
        SpannableString spannableString04 = new SpannableString(textView04.getText().toString());
        StrikethroughSpan strikethroughSpan = new StrikethroughSpan();
        spannableString04.setSpan(strikethroughSpan, 0, spannableString04.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        textView04.setText(spannableString04);
    }

    private void initView03() {
        SpannableString spannableString03 = new SpannableString(textView03.getText().toString());

        ForegroundColorSpan colorSpan03 = new ForegroundColorSpan(Color.parseColor("#EE0000"));
        spannableString03.setSpan(colorSpan03, 0, spannableString03.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        RelativeSizeSpan sizeSpan03 = new RelativeSizeSpan(1.2f);
        spannableString03.setSpan(sizeSpan03, 1, spannableString03.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        StyleSpan styleSpan03 = new StyleSpan(Typeface.BOLD);
        spannableString03.setSpan(styleSpan03, 1, spannableString03.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        textView03.setText(spannableString03);
    }

    private void initView02() {
        SpannableString spannableString02 = new SpannableString(textView02.getText().toString());

        URLSpan urlSpan = new URLSpan("http://blog.csdn.net/wsd7747");
        textView02.setHighlightColor(Color.parseColor("#16646464"));
        spannableString02.setSpan(urlSpan, 9, spannableString02.length() - 8, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        ForegroundColorSpan colorSpan02 = new ForegroundColorSpan(Color.parseColor("#0099FF"));
        spannableString02.setSpan(colorSpan02, 9, spannableString02.length() - 8, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        textView02.setText(spannableString02);
        textView02.setMovementMethod(LinkMovementMethod.getInstance());
    }

    private void initView01() {
        SpannableString spannableString01 = new SpannableString(textView01.getText().toString());

        ForegroundColorSpan colorSpan01 = new ForegroundColorSpan(Color.parseColor("#0099FF"));
        spannableString01.setSpan(colorSpan01, 7, spannableString01.length() - 1, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        RelativeSizeSpan sizeSpan01 = new RelativeSizeSpan(1.3f);
        spannableString01.setSpan(sizeSpan01, 7, spannableString01.length() - 1, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        StyleSpan styleSpan01 = new StyleSpan(Typeface.BOLD);
        spannableString01.setSpan(styleSpan01, 7, spannableString01.length() - 1, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        textView01.setText(spannableString01);
    }

    @Override
    protected int getContentViewLayoutId() {
        return R.layout.activity_main;
    }

    class MyClickableSpan extends ClickableSpan {

        private String content;

        public MyClickableSpan(String content) {
            this.content = content;
        }

        @Override
        public void updateDrawState(TextPaint ds) {
            ds.setUnderlineText(false);
        }

        @Override
        public void onClick(View widget) {
            Intent intent = new Intent(MainActivity.this, OtherActivity.class);
            Bundle bundle = new Bundle();
            bundle.putString("content", content);
            intent.putExtra("bundle", bundle);
            startActivity(intent);
        }
    }

    Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 0x200:
                    SpannableString spannableString05 = new SpannableString(textView05.getText().toString());

                    RelativeSizeSpan sizeSpan = new RelativeSizeSpan(1.2f);
                    spannableString05.setSpan(sizeSpan, position, position + 1, Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
                    textView05.setText(spannableString05);
                    position++;
                    if(position >= textView05.getText().toString().length()) {
                        position = 0;
                    }
                    handler.sendEmptyMessageDelayed(0x200, 200);
                    break;
            }
        }
    };
}
