package com.android.incallui.oplus.callbutton.callbuttonview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.android.incallui.Log;
import com.android.incallui.oplus.widgets.b;
import k2.e;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.i;

/* compiled from: InCallButtonItem.kt */
/* loaded from: classes.dex */
public final class InCallButtonItem extends LinearLayout implements View.OnClickListener, b.a {

    /* renamed from: h, reason: collision with root package name */
    public static final a f18888h = new a(null);

    /* renamed from: a, reason: collision with root package name */
    public ImageView f18889a;

    /* renamed from: b, reason: collision with root package name */
    public ImageView f18890b;

    /* renamed from: c, reason: collision with root package name */
    public ImageView f18891c;

    /* renamed from: d, reason: collision with root package name */
    public TextView f18892d;

    /* renamed from: e, reason: collision with root package name */
    public Context f18893e;

    /* renamed from: f, reason: collision with root package name */
    public e f18894f;

    /* renamed from: g, reason: collision with root package name */
    public E2.b f18895g;

    /* compiled from: InCallButtonItem.kt */
    /* loaded from: classes.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InCallButtonItem(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        i.f(context, "context");
        this.f18893e = context;
        this.f18895g = new b(this);
    }

    public final void a(e callButton) {
        i.f(callButton, "callButton");
        this.f18894f = callButton;
        setVisibility(0);
        setId(callButton.f());
        getMText().setText(callButton.n());
        getMImage().setImageResource(callButton.b());
        getMSelectedImage().setImageResource(callButton.q());
        e eVar = this.f18894f;
        e eVar2 = null;
        if (eVar == null) {
            i.q("mCallButton");
            eVar = null;
        }
        if (!eVar.d()) {
            e eVar3 = this.f18894f;
            if (eVar3 == null) {
                i.q("mCallButton");
                eVar3 = null;
            }
            if (eVar3.p()) {
                getMImage().setAlpha(callButton.g());
                getMText().setAlpha(callButton.g());
                e eVar4 = this.f18894f;
                if (eVar4 == null) {
                    i.q("mCallButton");
                } else {
                    eVar2 = eVar4;
                }
                eVar2.e(true);
            }
        }
        setEnabled(callButton.isEnabled());
        setSelected(callButton.isSelected());
        String k10 = callButton.k();
        if (k10 != null && k10.length() != 0) {
            setContentDescription(callButton.k());
        }
        setOnClickListener(this);
    }

    @Override // com.android.incallui.oplus.widgets.b.a
    public void c() {
        Log.d("InCallButtonItem", "cancelPressState");
        setFocusable(false);
        setPressed(false);
    }

    public final ImageView getMCircle() {
        ImageView imageView = this.f18889a;
        if (imageView != null) {
            return imageView;
        }
        i.q("mCircle");
        return null;
    }

    public final ImageView getMImage() {
        ImageView imageView = this.f18890b;
        if (imageView != null) {
            return imageView;
        }
        i.q("mImage");
        return null;
    }

    public final ImageView getMSelectedImage() {
        ImageView imageView = this.f18891c;
        if (imageView != null) {
            return imageView;
        }
        i.q("mSelectedImage");
        return null;
    }

    public final TextView getMText() {
        TextView textView = this.f18892d;
        if (textView != null) {
            return textView;
        }
        i.q("mText");
        return null;
    }

    @Override // android.view.View
    public boolean isEnabled() {
        return isActivated();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        i.f(view, "view");
        Log.d("InCallButtonItem", "onClick " + view.getId() + "...");
        if (!view.isActivated()) {
            return;
        }
        e eVar = this.f18894f;
        if (eVar == null) {
            i.q("mCallButton");
            eVar = null;
        }
        eVar.i(this.f18893e);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        Log.d("InCallButtonItem", "onTouchEvent...");
        E2.b bVar = this.f18895g;
        if (bVar == null) {
            i.q("mOplusTouchEventMonitor");
            bVar = null;
        }
        bVar.a(motionEvent);
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public void setEnabled(boolean z10) {
        if (isActivated() != z10) {
            Log.d("InCallButtonItem", "setActivated: " + z10 + ", view: " + isActivated());
            super.setActivated(z10);
        }
    }

    public final void setMCircle(ImageView imageView) {
        i.f(imageView, "<set-?>");
        this.f18889a = imageView;
    }

    public final void setMImage(ImageView imageView) {
        i.f(imageView, "<set-?>");
        this.f18890b = imageView;
    }

    public final void setMSelectedImage(ImageView imageView) {
        i.f(imageView, "<set-?>");
        this.f18891c = imageView;
    }

    public final void setMText(TextView textView) {
        i.f(textView, "<set-?>");
        this.f18892d = textView;
    }

    @Override // android.view.View
    public void setPressed(boolean z10) {
        if (z10 != isPressed()) {
            super.setPressed(z10);
        }
    }

    @Override // android.view.View
    public void setSelected(boolean z10) {
        if (isSelected() != z10) {
            Log.d("InCallButtonItem", "setSelected " + z10);
            super.setSelected(z10);
        }
    }

    public final void setText(String str) {
        getMText().setText(str);
    }
}
