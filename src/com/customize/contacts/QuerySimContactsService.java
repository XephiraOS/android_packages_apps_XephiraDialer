package com.customize.contacts;

import D7.c;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.telephony.TelephonyManager;
import com.customize.contacts.util.b0;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* loaded from: classes3.dex */
public class QuerySimContactsService extends Service {

    /* renamed from: a, reason: collision with root package name */
    public static LinkedBlockingQueue<Runnable> f20088a = new LinkedBlockingQueue<>();

    /* renamed from: b, reason: collision with root package name */
    public static ThreadPoolExecutor f20089b = new ThreadPoolExecutor(1, 2, 180, TimeUnit.SECONDS, f20088a);

    /* loaded from: classes3.dex */
    public class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f20090a;

        public a(int i10) {
            this.f20090a = i10;
        }

        /* JADX WARN: Removed duplicated region for block: B:32:0x00e3  */
        @Override // java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void run() {
            /*
                Method dump skipped, instructions count: 265
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.customize.contacts.QuerySimContactsService.a.run():void");
        }
    }

    /* loaded from: classes3.dex */
    public class b implements Callable<Integer> {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f20092a;

        public b(Context context) {
            this.f20092a = context;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Integer call() {
            int i10 = 0;
            try {
                boolean i11 = B3.a.i();
                try {
                    if (i11) {
                        if (5 == c.c(0)) {
                            int i12 = !b0.v0(this.f20092a, 0) ? 1 : 0;
                            QuerySimContactsService.this.c(0);
                            i10 = i12;
                        }
                        if (5 == c.c(1)) {
                            if (!b0.v0(this.f20092a, 1)) {
                                i10++;
                            }
                            QuerySimContactsService.this.c(1);
                        }
                    } else {
                        TelephonyManager telephonyManager = (TelephonyManager) this.f20092a.getSystemService(TelephonyManager.class);
                        if (telephonyManager != null && 5 == telephonyManager.getSimState()) {
                            int i13 = !b0.v0(this.f20092a, 0) ? 1 : 0;
                            QuerySimContactsService.this.c(0);
                            i10 = i13;
                        }
                    }
                } catch (Throwable th) {
                    th = th;
                    i10 = i11 ? 1 : 0;
                    H7.b.c("QuerySimContactsService", "getSimCount " + th);
                    return Integer.valueOf(i10);
                }
            } catch (Throwable th2) {
                th = th2;
            }
            return Integer.valueOf(i10);
        }
    }

    public final void b(Context context) {
        int i10;
        ExecutorService newFixedThreadPool = Executors.newFixedThreadPool(1);
        try {
            try {
                try {
                    try {
                        i10 = ((Integer) newFixedThreadPool.submit(new b(context)).get(8000L, TimeUnit.MILLISECONDS)).intValue();
                    } catch (TimeoutException unused) {
                        H7.b.c("QuerySimContactsService", "getSimCountAndAsyncQuery is time out.");
                        newFixedThreadPool.shutdown();
                        i10 = 0;
                        b0.L0(i10);
                    }
                } catch (InterruptedException unused2) {
                    H7.b.c("QuerySimContactsService", "getSimCountAndAsyncQuery is interrupted.");
                    newFixedThreadPool.shutdown();
                    i10 = 0;
                    b0.L0(i10);
                }
            } catch (Exception unused3) {
                H7.b.c("QuerySimContactsService", "getSimCountAndAsyncQuery has an error.");
                newFixedThreadPool.shutdown();
                i10 = 0;
                b0.L0(i10);
            }
            b0.L0(i10);
        } finally {
            newFixedThreadPool.shutdown();
        }
    }

    public final void c(int i10) {
        H7.b.b("QuerySimContactsService", "query slotId = " + i10);
        f20089b.execute(new a(i10));
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public void onStart(Intent intent, int i10) {
        super.onStart(intent, i10);
        H7.b.b("QuerySimContactsService", "OppoQuerySimContactsService onStart");
        b(getBaseContext());
    }
}
