package com.android.incallui.mvvm.widget;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;
import com.coui.appcompat.textutil.COUIChangeTextUtil;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.i;

/* compiled from: SuitableSizeTextView.kt */
/* loaded from: classes.dex */
public class SuitableSizeTextView extends AppCompatTextView {

    /* renamed from: b, reason: collision with root package name */
    public static final a f18725b = new a(null);

    /* renamed from: a, reason: collision with root package name */
    public int f18726a;

    /* compiled from: SuitableSizeTextView.kt */
    /* loaded from: classes.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SuitableSizeTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        i.f(context, "context");
    }

    private final void a(int i10) {
        super.setTextSize(0, COUIChangeTextUtil.getSuitableFontSize(getTextSize(), getResources().getConfiguration().fontScale, i10));
    }

    public final int getMFontScaleLevel() {
        return this.f18726a;
    }

    public final void setMFontScaleLevel(int i10) {
        this.f18726a = i10;
        a(i10);
    }

    @Override // androidx.appcompat.widget.AppCompatTextView, android.widget.TextView
    public void setTextSize(int i10, float f10) {
        super.setTextSize(i10, f10);
        a(this.f18726a);
    }

    public /* synthetic */ SuitableSizeTextView(Context context, AttributeSet attributeSet, int i10, int i11, f fVar) {
        this(context, (i11 & 2) != 0 ? null : attributeSet, (i11 & 4) != 0 ? R.attr.textViewStyle : i10);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SuitableSizeTextView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        i.f(context, "context");
        this.f18726a = 1;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, com.android.incallui.R.styleable.SuitableSizeTextView);
        setMFontScaleLevel(obtainStyledAttributes.getInteger(com.android.incallui.R.styleable.SuitableSizeTextView_fontScaleLevel, 1));
        obtainStyledAttributes.recycle();
    }
}
