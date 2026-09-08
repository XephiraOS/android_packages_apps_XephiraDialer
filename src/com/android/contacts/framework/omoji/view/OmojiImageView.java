package com.android.contacts.framework.omoji.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.appcompat.widget.AppCompatImageView;

/* compiled from: OmojiImageView.kt */
/* loaded from: classes.dex */
public final class OmojiImageView extends AppCompatImageView {

    /* renamed from: a, reason: collision with root package name */
    public static final a f16281a = new a(null);

    /* compiled from: OmojiImageView.kt */
    /* loaded from: classes.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.f fVar) {
            this();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OmojiImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
        kotlin.jvm.internal.i.f(context, "context");
        kotlin.jvm.internal.i.f(attrs, "attrs");
    }

    @Override // android.widget.ImageView, android.view.View
    public void onMeasure(int i10, int i11) {
        int size = View.MeasureSpec.getSize(i10);
        if (size != View.MeasureSpec.getSize(i11)) {
            i10 = View.MeasureSpec.makeMeasureSpec(size, 1073741824);
            i11 = i10;
        }
        super.onMeasure(i10, i11);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent event) {
        kotlin.jvm.internal.i.f(event, "event");
        if (isEnabled()) {
            int action = event.getAction();
            if (action != 0) {
                if (action == 1 || action == 3) {
                    setAlpha(1.0f);
                }
            } else {
                setAlpha(0.35f);
            }
        }
        return super.onTouchEvent(event);
    }
}
