# SpannableString

### 关于SpannableString属性详细介绍以及利用SpannableString显示多种文本效果,喜欢的可以下载下来代码看看

SpannableString其实和String一样，都是一种字符串类型，同样TextView也可以直接设置SpannableString作为显示文本。不同的是SpannableString可以通过使用其方法setSpan方法实现字符串各种形式风格的显示,重要的是可以指定设置的区间，也就是为字符串指定下标区间内的子字符串设置格式。

### 下面我们一一解读几种Span常用的格式:

>#### 1) ForegroundColorSpan(为文本设置前景色),效果和TextView的setTextColor()类似
> 实现方法如下：
>
- SpannableString spannableString = new SpannableString("设置文字的前景色为淡蓝色");
- ForegroundColorSpan colorSpan = new ForegroundColorSpan(Color.parseColor("#0099EE"));
- spannableString.setSpan(colorSpan, 9, spannableString.length(), Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
- textView.setText(spannableString);
>#### 2) BackgroundColorSpan(为文本设置背景色),效果和TextView的setBackground()类似
> 实现方法如下：
>
- SpannableString spannableString = new SpannableString("设置文字的背景色为淡绿色");
- BackgroundColorSpan colorSpan = new BackgroundColorSpan(Color.parseColor("#AC00FF30"));
- spannableString.setSpan(colorSpan, 9, spannableString.length(), Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
- textView.setText(spannableString);
>#### 3) RelativeSizeSpan(设置文字相对大小)
> 实现方法如下：
>
- SpannableString spannableString = new SpannableString("万丈高楼平地起");
- RelativeSizeSpan sizeSpan01 = new RelativeSizeSpan(1.2f);
- RelativeSizeSpan sizeSpan02 = new RelativeSizeSpan(1.4f);
- RelativeSizeSpan sizeSpan03 = new RelativeSizeSpan(1.6f);
- spannableString.setSpan(sizeSpan01, 0, 1, Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
- spannableString.setSpan(sizeSpan02, 1, 2, Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
- spannableString.setSpan(sizeSpan03, 2, 3, Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
- textView.setText(spannableString);
>#### 4) StrikethroughSpan(为文本设置中划线，也就是常说的删除线)
> 实现方法如下：
>
- SpannableString spannableString = new SpannableString("为文字设置删除线");
- StrikethroughSpan strikethroughSpan = new StrikethroughSpan();
- spannableString.setSpan(strikethroughSpan, 5, spannableString.length(), Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
- textView.setText(spannableString);
>#### 5) UnderlineSpan(为文本设置下划线)
> 实现方法如下：
>
- SpannableString spannableString = new SpannableString("为文字设置下划线");
- UnderlineSpan underlineSpan = new UnderlineSpan();
- spannableString.setSpan(underlineSpan, 5, spannableString.length(), Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
- textView.setText(spannableString);
>#### 6) SuperscriptSpan(为文本设置上标)

>#### 7) SubscriptSpan(为文本设置下标)

>#### 8) StyleSpan，为文字设置风格（粗体、斜体）
> 实现方法如下：
>
- SpannableString spannableString = new SpannableString("为文字设置粗体、斜体风格");
- StyleSpan styleSpan_B  = new StyleSpan(Typeface.BOLD);
- StyleSpan styleSpan_I  = new StyleSpan(Typeface.ITALIC);
- spannableString.setSpan(styleSpan_B, 5, 7, Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
- spannableString.setSpan(styleSpan_I, 8, 10, Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
- textView.setHighlightColor(Color.parseColor("#36969696"));
- textView.setText(spannableString);
>#### 9) ImageSpan，设置文本图片
> 实现方法如下：
>
- SpannableString spannableString = new SpannableString("在文本中添加表情（表情）");
- Drawable drawable = getResources().getDrawable(R.mipmap.a9c);
- drawable.setBounds(0, 0, 42, 42);
- ImageSpan imageSpan = new ImageSpan(drawable);
- spannableString.setSpan(imageSpan, 6, 8, Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
- textView.setText(spannableString);
>#### 10) ClickableSpan，实现点击跳转页面的效果

>#### 11) URLSpan，实现超链接文本的效果
