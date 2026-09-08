package com.oplus.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import androidx.preference.Preference;
import androidx.preference.l;
import b9.C0532b;
import b9.k;
import com.coui.appcompat.button.COUIButton;
import com.coui.appcompat.button.SingleButtonWrap;
import com.oplus.blacklistapp.p;
import com.oplus.blacklistapp.r;
import com.oplus.widget.BlacklistBigButtonPreference;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.i;

/* compiled from: BlacklistBigButtonPreference.kt */
/* loaded from: classes4.dex */
public final class BlacklistBigButtonPreference extends Preference {

    /* renamed from: a, reason: collision with root package name */
    public final View.OnClickListener f29213a;

    /* renamed from: b, reason: collision with root package name */
    public CharSequence f29214b;

    /* renamed from: c, reason: collision with root package name */
    public int f29215c;

    /* renamed from: d, reason: collision with root package name */
    public int f29216d;

    /* renamed from: e, reason: collision with root package name */
    public a f29217e;

    /* renamed from: f, reason: collision with root package name */
    public SingleButtonWrap f29218f;

    /* compiled from: BlacklistBigButtonPreference.kt */
    /* loaded from: classes4.dex */
    public interface a {
        void onButtonClick();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public BlacklistBigButtonPreference(Context context) {
        this(context, null, 0, 0, 14, null);
        i.f(context, "context");
    }

    public static final void b(BlacklistBigButtonPreference this$0, View view) {
        i.f(this$0, "this$0");
        a aVar = this$0.f29217e;
        if (aVar != null) {
            aVar.onButtonClick();
        }
    }

    private final CharSequence getBtnText() {
        return this.f29214b;
    }

    private final int getDrawableColor() {
        return this.f29216d;
    }

    private final int getTextColor() {
        return this.f29215c;
    }

    public final void c(Configuration newConfig) {
        i.f(newConfig, "newConfig");
        SingleButtonWrap singleButtonWrap = this.f29218f;
        if (singleButtonWrap != null) {
            singleButtonWrap.onConfigurationChanged(newConfig);
        }
    }

    public final void d(a aVar) {
        this.f29217e = aVar;
    }

    @Override // androidx.preference.Preference
    public void onBindViewHolder(l holder) {
        COUIButton cOUIButton;
        i.f(holder, "holder");
        super.onBindViewHolder(holder);
        View e10 = holder.e(p.f27345K0);
        View view = null;
        if (e10 instanceof COUIButton) {
            cOUIButton = (COUIButton) e10;
        } else {
            cOUIButton = null;
        }
        if (cOUIButton != null) {
            SingleButtonWrap singleButtonWrap = this.f29218f;
            if (singleButtonWrap != null) {
                view = singleButtonWrap.getProcessView();
            }
            if (!i.b(view, cOUIButton)) {
                this.f29218f = new SingleButtonWrap(cOUIButton, 6);
            }
            cOUIButton.setText(getBtnText());
            if (getTextColor() != 0) {
                cOUIButton.setTextColor(getTextColor());
            }
            if (getDrawableColor() != 0) {
                cOUIButton.setDrawableColor(getDrawableColor());
            }
            cOUIButton.setOnClickListener(this.f29213a);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public BlacklistBigButtonPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 0, 12, null);
        i.f(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public BlacklistBigButtonPreference(Context context, AttributeSet attributeSet, int i10) {
        this(context, attributeSet, i10, 0, 8, null);
        i.f(context, "context");
    }

    public /* synthetic */ BlacklistBigButtonPreference(Context context, AttributeSet attributeSet, int i10, int i11, int i12, f fVar) {
        this(context, (i12 & 2) != 0 ? null : attributeSet, (i12 & 4) != 0 ? C0532b.f12343b : i10, (i12 & 8) != 0 ? k.f12524b : i11);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BlacklistBigButtonPreference(Context context, AttributeSet attributeSet, int i10, int i11) {
        super(context, attributeSet, i10, i11);
        i.f(context, "context");
        this.f29213a = new View.OnClickListener() { // from class: S8.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BlacklistBigButtonPreference.b(BlacklistBigButtonPreference.this, view);
            }
        };
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, b9.l.f12628k, i10, i11);
        i.e(obtainStyledAttributes, "context.obtainStyledAttr…    defStyleRes\n        )");
        this.f29214b = obtainStyledAttributes.getText(b9.l.f12634m);
        this.f29215c = obtainStyledAttributes.getColor(b9.l.f12637n, 0);
        this.f29216d = obtainStyledAttributes.getColor(b9.l.f12631l, 0);
        obtainStyledAttributes.recycle();
        setLayoutResource(r.f27457l);
    }
}
