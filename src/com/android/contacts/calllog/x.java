package com.android.contacts.calllog;

import android.content.Context;
import android.graphics.drawable.Drawable;
import com.oplus.dialer.R;

/* compiled from: CallTypeIconsCache.java */
/* loaded from: classes.dex */
public class x {

    /* renamed from: v, reason: collision with root package name */
    public static volatile x f14032v;

    /* renamed from: a, reason: collision with root package name */
    public Drawable f14033a;

    /* renamed from: b, reason: collision with root package name */
    public Drawable f14034b;

    /* renamed from: c, reason: collision with root package name */
    public Drawable f14035c;

    /* renamed from: d, reason: collision with root package name */
    public Drawable f14036d;

    /* renamed from: e, reason: collision with root package name */
    public Drawable f14037e;

    /* renamed from: f, reason: collision with root package name */
    public Drawable f14038f;

    /* renamed from: g, reason: collision with root package name */
    public Drawable f14039g;

    /* renamed from: h, reason: collision with root package name */
    public Drawable f14040h;

    /* renamed from: i, reason: collision with root package name */
    public Drawable f14041i;

    /* renamed from: j, reason: collision with root package name */
    public Drawable f14042j;

    /* renamed from: k, reason: collision with root package name */
    public Drawable f14043k;

    /* renamed from: l, reason: collision with root package name */
    public Drawable f14044l;

    /* renamed from: m, reason: collision with root package name */
    public Drawable f14045m;

    /* renamed from: n, reason: collision with root package name */
    public Drawable f14046n;

    /* renamed from: o, reason: collision with root package name */
    public Drawable f14047o;

    /* renamed from: p, reason: collision with root package name */
    public Drawable f14048p;

    /* renamed from: q, reason: collision with root package name */
    public Drawable f14049q;

    /* renamed from: r, reason: collision with root package name */
    public Drawable f14050r;

    /* renamed from: s, reason: collision with root package name */
    public Drawable f14051s;

    /* renamed from: t, reason: collision with root package name */
    public Drawable f14052t;

    /* renamed from: u, reason: collision with root package name */
    public boolean f14053u = false;

    public static synchronized x b(Context context) {
        x xVar;
        synchronized (x.class) {
            try {
                if (f14032v == null) {
                    f14032v = new x();
                    f14032v.c(context);
                }
                if (f14032v.f14053u) {
                    H7.b.e("CallTypeIcons", "refresh ----------- ");
                    f14032v.c(context);
                    f14032v.f14053u = false;
                }
                xVar = f14032v;
            } catch (Throwable th) {
                throw th;
            }
        }
        return xVar;
    }

    public void a() {
        this.f14053u = true;
    }

    public final void c(Context context) {
        this.f14033a = context.getDrawable(R.drawable.pb_ic_call_incoming);
        this.f14034b = context.getDrawable(R.drawable.pb_ic_call_outgoing);
        this.f14035c = context.getDrawable(R.drawable.pb_ic_call_missed);
        this.f14036d = context.getDrawable(R.drawable.pb_ic_call_voicemail);
        this.f14037e = context.getDrawable(R.drawable.pb_ic_call_declined);
        this.f14038f = context.getDrawable(R.drawable.pb_ic_call_incoming_video);
        this.f14039g = context.getDrawable(R.drawable.pb_ic_call_outgoing_video);
        this.f14040h = context.getDrawable(R.drawable.pb_ic_call_missed_video);
        this.f14041i = context.getDrawable(R.drawable.pb_ic_call_declined_video);
        this.f14042j = context.getDrawable(R.drawable.pb_ic_call_incoming_wifi);
        this.f14043k = context.getDrawable(R.drawable.pb_ic_call_outgoing_wifi);
        if (B3.a.Z() || B3.a.a0()) {
            this.f14045m = context.getDrawable(R.drawable.pb_ic_call_incoming_vowifi_video);
            this.f14046n = context.getDrawable(R.drawable.pb_ic_call_outgoing_vowifi_video);
            this.f14047o = context.getDrawable(R.drawable.pb_ic_call_missed_vowifi_video);
            this.f14048p = context.getDrawable(R.drawable.pb_ic_call_rejected_vowifi_video);
            this.f14049q = context.getDrawable(R.drawable.pb_ic_call_incoming_vowifi);
            this.f14050r = context.getDrawable(R.drawable.pb_ic_call_outgoing_vowifi);
            this.f14051s = context.getDrawable(R.drawable.pb_ic_call_missed_vowifi);
            this.f14052t = context.getDrawable(R.drawable.pb_ic_call_rejected_vowifi);
        }
        if (B3.a.G()) {
            this.f14044l = context.getDrawable(R.drawable.pb_ic_call_assistant);
        }
    }
}
