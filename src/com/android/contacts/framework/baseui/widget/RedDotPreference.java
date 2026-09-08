package com.android.contacts.framework.baseui.widget;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.COUIRecyclerView;
import com.coui.appcompat.cardlist.COUICardListHelper;
import com.coui.appcompat.cardlist.COUICardListSelectedItemLayout;
import com.coui.appcompat.preference.COUIPreference;
import com.coui.appcompat.reddot.COUIHintRedDot;

/* compiled from: RedDotPreference.kt */
/* loaded from: classes.dex */
public class RedDotPreference extends COUIPreference implements COUIRecyclerView.b {

    /* renamed from: j, reason: collision with root package name */
    public static final a f16094j = new a(null);

    /* renamed from: a, reason: collision with root package name */
    public View f16095a;

    /* renamed from: b, reason: collision with root package name */
    public TextView f16096b;

    /* renamed from: c, reason: collision with root package name */
    public COUIHintRedDot f16097c;

    /* renamed from: d, reason: collision with root package name */
    public ImageView f16098d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f16099e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f16100f;

    /* renamed from: g, reason: collision with root package name */
    public int f16101g;

    /* renamed from: h, reason: collision with root package name */
    public int f16102h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f16103i;

    /* compiled from: RedDotPreference.kt */
    /* loaded from: classes.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.f fVar) {
            this();
        }
    }

    /* compiled from: Runnable.kt */
    /* loaded from: classes.dex */
    public static final class b implements Runnable {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ androidx.preference.l f16105b;

        public b(androidx.preference.l lVar) {
            this.f16105b = lVar;
        }

        @Override // java.lang.Runnable
        public final void run() {
            RedDotPreference.this.b(this.f16105b.itemView);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public RedDotPreference(Context context) {
        this(context, null);
        kotlin.jvm.internal.i.f(context, "context");
    }

    public final void b(View view) {
        COUICardListSelectedItemLayout cOUICardListSelectedItemLayout;
        H7.b.b("RedDotPreference", "addHighlightBackground");
        if (!this.f16103i) {
            return;
        }
        this.f16103i = false;
        if (view instanceof COUICardListSelectedItemLayout) {
            cOUICardListSelectedItemLayout = (COUICardListSelectedItemLayout) view;
        } else {
            cOUICardListSelectedItemLayout = null;
        }
        ValueAnimator c10 = com.android.contacts.framework.baseui.util.i.c(cOUICardListSelectedItemLayout);
        if (c10 != null) {
            c10.start();
        }
    }

    public final void c(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes;
        if (context != null && (obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, N0.m.f2122W3)) != null) {
            this.f16099e = obtainStyledAttributes.getBoolean(N0.m.f2127X3, true);
            this.f16100f = obtainStyledAttributes.getBoolean(N0.m.f2132Y3, true);
            this.f16101g = obtainStyledAttributes.getInt(N0.m.f2137Z3, 0);
            this.f16102h = obtainStyledAttributes.getInt(N0.m.f2143a4, 0);
            obtainStyledAttributes.recycle();
        }
    }

    public final void d(boolean z10) {
        this.f16103i = z10;
    }

    @Override // com.coui.appcompat.preference.COUIPreference, androidx.recyclerview.widget.COUIRecyclerView.b
    public boolean drawDivider() {
        if (!(this.f16095a instanceof COUICardListSelectedItemLayout)) {
            return false;
        }
        int positionInGroup = COUICardListHelper.getPositionInGroup(this);
        if (positionInGroup != 1 && positionInGroup != 2) {
            return false;
        }
        return true;
    }

    @Override // com.coui.appcompat.preference.COUIPreference, androidx.recyclerview.widget.COUIRecyclerView.b
    public View getDividerEndAlignView() {
        return this.f16098d;
    }

    @Override // com.coui.appcompat.preference.COUIPreference, androidx.recyclerview.widget.COUIRecyclerView.b
    public View getDividerStartAlignView() {
        return this.f16095a;
    }

    @Override // com.coui.appcompat.preference.COUIPreference, androidx.preference.Preference
    public void onBindViewHolder(androidx.preference.l holder) {
        int i10;
        kotlin.jvm.internal.i.f(holder, "holder");
        super.onBindViewHolder(holder);
        View view = holder.itemView;
        this.f16095a = view;
        ImageView imageView = (ImageView) view.findViewById(N0.i.f1947y);
        COUIHintRedDot cOUIHintRedDot = null;
        if (imageView != null) {
            kotlin.jvm.internal.i.e(imageView, "findViewById<ImageView>(….red_dot_preference_next)");
            if (this.f16099e) {
                i10 = 0;
            } else {
                i10 = 8;
            }
            imageView.setVisibility(i10);
        } else {
            imageView = null;
        }
        this.f16098d = imageView;
        TextView textView = (TextView) view.findViewById(N0.i.f1948z);
        if (textView != null) {
            kotlin.jvm.internal.i.e(textView, "findViewById<TextView>(R….red_dot_preference_text)");
            textView.setText(getTitle());
        } else {
            textView = null;
        }
        this.f16096b = textView;
        COUIHintRedDot cOUIHintRedDot2 = (COUIHintRedDot) view.findViewById(N0.i.f1946x);
        if (cOUIHintRedDot2 != null) {
            kotlin.jvm.internal.i.e(cOUIHintRedDot2, "findViewById<COUIHintRedDot>(R.id.red_dot)");
            if (this.f16100f) {
                cOUIHintRedDot2.setVisibility(0);
                cOUIHintRedDot2.setPointMode(this.f16101g);
                cOUIHintRedDot2.setPointNumber(this.f16102h);
            } else {
                cOUIHintRedDot2.setVisibility(8);
            }
            cOUIHintRedDot = cOUIHintRedDot2;
        }
        this.f16097c = cOUIHintRedDot;
        if (this.f16103i) {
            holder.itemView.postDelayed(new b(holder), 600L);
        }
        COUICardListHelper.setItemCardBackground(holder.itemView, COUICardListHelper.getPositionInGroup(this));
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public RedDotPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        kotlin.jvm.internal.i.f(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public RedDotPreference(Context context, AttributeSet attributeSet, int i10) {
        this(context, attributeSet, i10, 0);
        kotlin.jvm.internal.i.f(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RedDotPreference(Context context, AttributeSet attributeSet, int i10, int i11) {
        super(context, attributeSet, i10, i11);
        kotlin.jvm.internal.i.f(context, "context");
        this.f16099e = true;
        this.f16100f = true;
        setLayoutResource(N0.j.f1949a);
        c(context, attributeSet);
    }
}
