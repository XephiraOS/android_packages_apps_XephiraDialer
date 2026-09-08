package com.android.contacts.framework.baseui.highlight;

import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.preference.l;
import com.android.contacts.framework.baseui.util.i;
import com.coui.appcompat.cardlist.COUICardListSelectedItemLayout;
import com.coui.appcompat.preference.COUISwitchPreference;
import kotlin.jvm.internal.f;

/* compiled from: HighlightSwitchPreference.kt */
/* loaded from: classes.dex */
public final class HighlightSwitchPreference extends COUISwitchPreference {

    /* renamed from: b, reason: collision with root package name */
    public static final a f15817b = new a(null);

    /* renamed from: a, reason: collision with root package name */
    public boolean f15818a;

    /* compiled from: HighlightSwitchPreference.kt */
    /* loaded from: classes.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }
    }

    /* compiled from: Runnable.kt */
    /* loaded from: classes.dex */
    public static final class b implements Runnable {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ l f15820b;

        public b(l lVar) {
            this.f15820b = lVar;
        }

        @Override // java.lang.Runnable
        public final void run() {
            HighlightSwitchPreference.this.b(this.f15820b.itemView);
        }
    }

    public HighlightSwitchPreference(Context context) {
        super(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void b(View view) {
        COUICardListSelectedItemLayout cOUICardListSelectedItemLayout;
        H7.b.b("HighlightSwitchPreference", "addHighlightBackground");
        if (!this.f15818a) {
            return;
        }
        this.f15818a = false;
        if (getContext() != null) {
            if (view instanceof COUICardListSelectedItemLayout) {
                cOUICardListSelectedItemLayout = (COUICardListSelectedItemLayout) view;
            } else {
                cOUICardListSelectedItemLayout = null;
            }
            ValueAnimator c10 = i.c(cOUICardListSelectedItemLayout);
            if (c10 != null) {
                c10.start();
            }
        }
    }

    public final void c(boolean z10) {
        this.f15818a = z10;
    }

    @Override // com.coui.appcompat.preference.COUISwitchPreference, androidx.preference.SwitchPreference, androidx.preference.Preference
    public void onBindViewHolder(l holder) {
        View view;
        kotlin.jvm.internal.i.f(holder, "holder");
        super.onBindViewHolder(holder);
        if (this.f15818a && (view = holder.itemView) != null) {
            view.postDelayed(new b(holder), 600L);
        }
    }

    public HighlightSwitchPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public HighlightSwitchPreference(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
    }

    public HighlightSwitchPreference(Context context, AttributeSet attributeSet, int i10, int i11) {
        super(context, attributeSet, i10, i11);
    }
}
