package com.oplus.phonenoareainquire;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.oplus.phonenoareainquire.service.OplusLocaleChangeJobIntentService;
import com.oplus.phonenoareainquire.utils.LogUtil;

/* compiled from: UpdateMultiLanguageUtils.kt */
/* loaded from: classes3.dex */
public final class UpdateMultiLanguageUtils extends BroadcastReceiver {

    /* renamed from: a, reason: collision with root package name */
    public static final a f28840a = new a(null);

    /* compiled from: UpdateMultiLanguageUtils.kt */
    /* loaded from: classes3.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.f fVar) {
            this();
        }
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        kotlin.jvm.internal.i.f(context, "context");
        kotlin.jvm.internal.i.f(intent, "intent");
        LogUtil.a("UpdateMultiLanguageUtils", "start update the table in OplusLocaleChangeJobIntentService");
        if (TextUtils.equals(intent.getAction(), "android.intent.action.LOCALE_CHANGED")) {
            OplusLocaleChangeJobIntentService.f28872j.b(context, intent);
        }
    }
}
