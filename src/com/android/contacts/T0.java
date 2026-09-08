package com.android.contacts;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.widget.ImageView;
import com.oplus.dialer.R;

/* compiled from: PhoneCallDetailsHelper.java */
/* loaded from: classes.dex */
public class T0 {

    /* renamed from: a, reason: collision with root package name */
    public final com.android.contacts.calllog.I f13213a;

    /* renamed from: b, reason: collision with root package name */
    public final Context f13214b;

    /* renamed from: c, reason: collision with root package name */
    public final String f13215c;

    /* renamed from: d, reason: collision with root package name */
    public final int f13216d;

    public T0(Context context, com.android.contacts.calllog.I i10) {
        this.f13213a = i10;
        this.f13214b = context;
        this.f13215c = context.getResources().getString(R.string.unknown);
        this.f13216d = context.getColor(R.color.coui_preference_secondary_text_color);
    }

    public static String c(CharSequence charSequence) {
        if (charSequence == null) {
            return "";
        }
        return charSequence.toString();
    }

    public final CharSequence b(CharSequence charSequence, int i10) {
        SpannableString spannableString = new SpannableString(charSequence);
        spannableString.setSpan(new ForegroundColorSpan(i10), 0, charSequence.length(), 18);
        return spannableString;
    }

    public final /* synthetic */ void d(String str, int i10, PhoneCallDetails phoneCallDetails, int i11, long j10) {
        int i12;
        if (com.customize.contacts.util.J.m(str, i10, phoneCallDetails.f13169c)) {
            if (com.customize.contacts.util.J.h(this.f13214b, phoneCallDetails.f13177k, i10, i11) == -1) {
                i12 = 0;
            } else {
                i12 = 1;
            }
            G0.c.n(this.f13214b, 1, R0.c.f3189g, i12);
            G0.c.t(this.f13214b, 1, R0.c.f3190h, phoneCallDetails.f13167a.toString());
            G0.c.t(this.f13214b, 1, R0.c.f3191i, String.valueOf(j10));
            G0.c.q(this.f13214b, 1, "last_ted_recog_time", -1L);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:50:0x02a5  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x02b0  */
    /* JADX WARN: Removed duplicated region for block: B:56:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void e(com.android.contacts.U0 r17, final com.android.contacts.PhoneCallDetails r18, final java.lang.String r19, final long r20, long r22, long r24, int r26, int r27, boolean r28, F0.a r29) {
        /*
            Method dump skipped, instructions count: 717
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.contacts.T0.e(com.android.contacts.U0, com.android.contacts.PhoneCallDetails, java.lang.String, long, long, long, int, int, boolean, F0.a):void");
    }

    public final void f(long j10, ImageView imageView, long j11, long j12, int i10) {
        if (imageView != null && this.f13214b != null) {
            Resources resources = imageView.getResources();
            if (j10 == j11 && i10 > 1) {
                Drawable drawable = this.f13214b.getDrawable(R.drawable.pb_ic_call_log_sim1);
                drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
                imageView.setImageDrawable(drawable);
                imageView.setVisibility(0);
                imageView.setContentDescription(resources.getString(R.string.sim_1_description));
                return;
            }
            if (j10 == j12 && i10 > 1) {
                Drawable drawable2 = this.f13214b.getDrawable(R.drawable.pb_ic_call_log_sim2);
                drawable2.setBounds(0, 0, drawable2.getMinimumWidth(), drawable2.getMinimumHeight());
                imageView.setImageDrawable(drawable2);
                imageView.setVisibility(0);
                imageView.setContentDescription(resources.getString(R.string.sim_2_description));
                return;
            }
            imageView.setVisibility(8);
        }
    }
}
