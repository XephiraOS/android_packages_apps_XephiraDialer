package com.oplus.phonenoareainquire;

import android.content.BroadcastReceiver;
import android.content.ContentProvider;
import android.content.ContentProviderClient;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import com.oplus.phonenoareainquire.service.OplusLocaleChangeJobIntentService;
import d8.C0958a;
import java.io.DataInputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: classes3.dex */
public class UpdateDatabaseReceiver extends BroadcastReceiver {

    /* renamed from: c, reason: collision with root package name */
    public static ThreadPoolExecutor f28834c;

    /* renamed from: d, reason: collision with root package name */
    public static LinkedBlockingQueue<Runnable> f28835d;

    /* renamed from: b, reason: collision with root package name */
    public static final boolean f28833b = PhoneNumberAreaApplication.f28829a;

    /* renamed from: a, reason: collision with root package name */
    public static final String f28832a = C0958a.a();

    /* loaded from: classes3.dex */
    public class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ArrayList f28836a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ k f28837b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Context f28838c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ ContentProviderClient f28839d;

        public a(ArrayList arrayList, k kVar, Context context, ContentProviderClient contentProviderClient) {
            this.f28836a = arrayList;
            this.f28837b = kVar;
            this.f28838c = context;
            this.f28839d = contentProviderClient;
        }

        @Override // java.lang.Runnable
        public void run() {
            Iterator it = this.f28836a.iterator();
            while (it.hasNext()) {
                String str = (String) it.next();
                if (str.startsWith("PhoneNumberData_3_1_0")) {
                    UpdateDatabaseReceiver.d(this.f28837b);
                } else {
                    if (str.equals("carrier_data")) {
                        this.f28837b.k(UpdateDatabaseReceiver.f28832a, PhoneNoInquireProvider.r(), str);
                    } else {
                        this.f28837b.m(UpdateDatabaseReceiver.f28832a, PhoneNoInquireProvider.r(), str);
                    }
                    if (str.equals("city_name_table.txt")) {
                        this.f28838c.getContentResolver().call(PhoneNoInquireProvider.f28803r, "refresh_province_and_city_table", (String) null, (Bundle) null);
                    }
                    if (str.equals("Multi_Language_Table.txt")) {
                        try {
                            OplusLocaleChangeJobIntentService.n(PhoneNumberAreaApplication.b("Multi_Language_Table.txt", PhoneNoInquireProvider.f28795E), this.f28838c, null, "SAU");
                        } catch (Exception e10) {
                            try {
                                OplusLocaleChangeJobIntentService.n(null, this.f28838c, null, "SAU-Exception");
                            } catch (Exception unused) {
                                Log.e("UpdateDatabaseReceiver", "e = " + e10);
                            }
                            Log.e("UpdateDatabaseReceiver", "" + e10);
                        }
                    }
                }
                ContentProvider localContentProvider = this.f28839d.getLocalContentProvider();
                if (localContentProvider instanceof PhoneNoInquireProvider) {
                    PhoneNoInquireProvider phoneNoInquireProvider = (PhoneNoInquireProvider) localContentProvider;
                    d.c().a();
                    phoneNoInquireProvider.K(new DataInputStream(PhoneNumberAreaApplication.b("PhoneNumberData_3_1_0.dat", PhoneNoInquireProvider.f28792B)));
                    CountDownLatch countDownLatch = new CountDownLatch(1);
                    phoneNoInquireProvider.P(countDownLatch);
                    com.oplus.phonenoareainquire.utils.b bVar = com.oplus.phonenoareainquire.utils.b.f28881a;
                    com.oplus.phonenoareainquire.utils.b.i(this.f28838c, phoneNoInquireProvider.f28810d, countDownLatch);
                    com.oplus.phonenoareainquire.utils.e.b();
                    try {
                        com.oplus.phonenoareainquire.utils.e.h();
                    } catch (Throwable th) {
                        Log.e("UpdateDatabaseReceiver", "Exception when init loadLocationInfoCache in sExecutor's task" + th);
                    }
                }
            }
            this.f28839d.close();
        }
    }

    public static void c(Context context) {
        ArrayList<String> e10 = k.e(f28832a);
        if (e10 != null && !e10.isEmpty()) {
            ContentProviderClient acquireContentProviderClient = context.getContentResolver().acquireContentProviderClient("com.oplus.dialer.inquirenoarea");
            f28834c.execute(new a(e10, new k(context), context, acquireContentProviderClient));
        }
    }

    public static void d(k kVar) {
        if (kVar.l(kVar.f(), f28832a + "PhoneNumberData_3_1_0.dat") == 27) {
            int j10 = kVar.j();
            if (f28833b) {
                Log.d("UpdateDatabaseReceiver", "revertDbFile result = " + j10);
            }
        }
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (intent == null || context == null) {
            return;
        }
        if (f28834c == null) {
            f28835d = new LinkedBlockingQueue<>();
            f28834c = new ThreadPoolExecutor(1, 1, 100L, TimeUnit.SECONDS, f28835d);
        }
        String action = intent.getAction();
        Log.d("UpdateDatabaseReceiver", "received update broadcast action = " + action);
        if (C0958a.b(action)) {
            c(context);
        }
    }
}
