package com.oplus.utils;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.lang.ref.WeakReference;

/* compiled from: WeakHandler.kt */
/* loaded from: classes3.dex */
public abstract class a0<T> extends Handler {

    /* renamed from: a, reason: collision with root package name */
    public final WeakReference<T> f29120a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a0(Looper looper, T t10) {
        super(looper);
        kotlin.jvm.internal.i.f(looper, "looper");
        this.f29120a = new WeakReference<>(t10);
    }

    public abstract void a(Message message, T t10);

    @Override // android.os.Handler
    public void handleMessage(Message msg) {
        kotlin.jvm.internal.i.f(msg, "msg");
        T t10 = this.f29120a.get();
        if (t10 != null) {
            a(msg, t10);
        }
    }
}
