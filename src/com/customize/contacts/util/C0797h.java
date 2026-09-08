package com.customize.contacts.util;

import android.content.Context;
import android.os.AsyncTask;

/* compiled from: AsyncTaskUtils.java */
/* renamed from: com.customize.contacts.util.h, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C0797h {
    public static void a(Context context, AsyncTask<Void, Void, ?> asyncTask, Object obj) {
        if (asyncTask != null) {
            asyncTask.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
        }
        synchronized (obj) {
            try {
                obj.wait(1000L);
            } catch (InterruptedException unused) {
            }
        }
    }
}
