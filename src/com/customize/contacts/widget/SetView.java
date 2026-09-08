package com.customize.contacts.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.android.contacts.framework.baseui.widget.SelectedCardView;
import com.oplus.dialer.R;

/* loaded from: classes3.dex */
public abstract class SetView extends SelectedCardView implements View.OnClickListener {

    /* renamed from: c, reason: collision with root package name */
    public TextView f22417c;

    /* renamed from: d, reason: collision with root package name */
    public ImageView f22418d;

    /* renamed from: e, reason: collision with root package name */
    public String f22419e;

    /* renamed from: f, reason: collision with root package name */
    public ColorStateList f22420f;

    public SetView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public abstract String getColumnKey();

    public abstract String getDefaultData();

    public abstract int getDefaultHint();

    public abstract int getLeftIconResId();

    public abstract String getMimeType();

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        TextView textView = (TextView) findViewById(R.id.label);
        this.f22417c = textView;
        this.f22420f = textView.getTextColors();
        ImageView imageView = (ImageView) findViewById(R.id.left_icon_view);
        this.f22418d = imageView;
        imageView.setImageResource(getLeftIconResId());
    }

    @Override // com.coui.appcompat.preference.ListSelectedItemLayout, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean onTouchEvent = super.onTouchEvent(motionEvent);
        if (motionEvent.getAction() == 1) {
            onClick(this);
        }
        return onTouchEvent;
    }
}
