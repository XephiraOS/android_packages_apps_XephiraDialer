package com.android.contacts.framework.baseui.calllog.utils;

import G0.c;
import H7.b;
import android.content.Context;
import android.database.ContentObserver;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.provider.Settings;
import androidx.lifecycle.v;
import kotlin.jvm.internal.i;
import m9.q;

/* compiled from: HideContactsNumberUtils.kt */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: c, reason: collision with root package name */
    public static boolean f15809c;

    /* renamed from: a, reason: collision with root package name */
    public static final a f15807a = new a();

    /* renamed from: b, reason: collision with root package name */
    public static final ContentObserver f15808b = new C0166a(new Handler(Looper.getMainLooper()));

    /* renamed from: d, reason: collision with root package name */
    public static final v<q> f15810d = new v<>();

    /* compiled from: HideContactsNumberUtils.kt */
    /* renamed from: com.android.contacts.framework.baseui.calllog.utils.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static final class C0166a extends ContentObserver {
        public C0166a(Handler handler) {
            super(handler);
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean z10) {
            b.b("HideContactsNumberUtils", "Hide contacts number switch has changed.");
            a.e();
            a.f15810d.o(q.f35511a);
        }
    }

    static {
        e();
    }

    public static final boolean b(Context context) {
        i.f(context, "context");
        if (c.d(context, 1, "oplus_customize_hide_contact_number_switch", 0) == 1) {
            return true;
        }
        return false;
    }

    public static final boolean c(Uri uri) {
        if (uri != null && f15809c) {
            return true;
        }
        return false;
    }

    public static final void d(Context context) {
        i.f(context, "context");
        context.getContentResolver().registerContentObserver(Settings.Global.getUriFor("oplus_customize_hide_contact_number_switch"), false, f15808b);
    }

    public static final void e() {
        boolean b10 = b(P7.a.f2961a.a());
        f15809c = b10;
        b.b("HideContactsNumberUtils", "updateHideContactsNumber isHideContactsNumber= " + b10);
    }
}
