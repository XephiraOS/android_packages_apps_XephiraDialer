package com.android.incallui.oplus.widgets;

import android.content.Context;
import android.content.res.Configuration;
import android.util.AttributeSet;
import android.widget.TextView;
import com.android.incallui.Log;
import com.internal_dependency.AddOnSdkDepends;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.i;

/* compiled from: AdaptiveFontWeightTextView.kt */
/* loaded from: classes.dex */
public final class AdaptiveFontWeightTextView extends TextView {

    /* renamed from: b, reason: collision with root package name */
    public static final a f19125b = new a(null);

    /* renamed from: a, reason: collision with root package name */
    public Integer f19126a;

    /* compiled from: AdaptiveFontWeightTextView.kt */
    /* loaded from: classes.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }
    }

    public AdaptiveFontWeightTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // android.widget.TextView, android.view.View
    public void onConfigurationChanged(Configuration newConfig) {
        String str;
        i.f(newConfig, "newConfig");
        super.onConfigurationChanged(newConfig);
        int configurationFontVariation = AddOnSdkDepends.Companion.getSInstance().getConfigurationFontVariation(newConfig);
        Integer num = this.f19126a;
        if (num == null || configurationFontVariation != num.intValue()) {
            int i10 = configurationFontVariation & 4095;
            int i11 = (61440 & configurationFontVariation) >> 12;
            if (i11 != 0) {
                str = "'wght' " + i10;
            } else {
                str = "'wght' 550";
            }
            if (Log.sDebug) {
                Log.d("AdaptiveFontWeightTextView", "onConfigurationChanged variation = " + i10 + " , status = " + i11 + " , fontVariationSettings = " + str);
            }
            setFontVariationSettings(str);
        }
        this.f19126a = Integer.valueOf(configurationFontVariation);
    }
}
