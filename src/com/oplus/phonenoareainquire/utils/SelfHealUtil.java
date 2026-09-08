package com.oplus.phonenoareainquire.utils;

import android.content.ContentProvider;
import android.content.ContentProviderClient;
import android.content.Context;
import android.database.sqlite.SQLiteException;
import android.os.PowerManager;
import android.util.Log;
import com.oplus.phonenoareainquire.PhoneNoInquireProvider;
import com.oplus.phonenoareainquire.PhoneNumberAreaApplication;
import com.oplus.phonenoareainquire.service.OplusLocaleChangeJobIntentService;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.jvm.internal.i;
import kotlin.text.n;
import kotlinx.coroutines.C1244g;
import kotlinx.coroutines.F;
import kotlinx.coroutines.S;

/* compiled from: SelfHealUtil.kt */
/* loaded from: classes3.dex */
public final class SelfHealUtil {

    /* renamed from: a, reason: collision with root package name */
    public static final SelfHealUtil f28876a = new SelfHealUtil();

    /* renamed from: b, reason: collision with root package name */
    public static final AtomicInteger f28877b = new AtomicInteger(0);

    /* renamed from: c, reason: collision with root package name */
    public static PowerManager.WakeLock f28878c;

    /* renamed from: d, reason: collision with root package name */
    public static Context f28879d;

    public static final void b(File file) {
        boolean o10;
        boolean o11;
        if (!file.exists()) {
            return;
        }
        if (file.isFile()) {
            String name = file.getName();
            i.e(name, "getName(...)");
            o10 = n.o(name, ".txt", false, 2, null);
            if (!o10) {
                String name2 = file.getName();
                i.e(name2, "getName(...)");
                o11 = n.o(name2, ".dat", false, 2, null);
                if (!o11) {
                    return;
                }
            }
            file.delete();
            return;
        }
        if (file.isDirectory()) {
            File[] listFiles = file.listFiles();
            if (listFiles != null && listFiles.length != 0) {
                for (File file2 : listFiles) {
                    i.c(file2);
                    b(file2);
                }
                file.delete();
                return;
            }
            file.delete();
        }
    }

    public static final void c(Context context) {
        ContentProviderClient contentProviderClient = null;
        ContentProvider localContentProvider = null;
        ContentProviderClient contentProviderClient2 = null;
        contentProviderClient = null;
        contentProviderClient = null;
        try {
            try {
                Object systemService = context.getSystemService("power");
                i.d(systemService, "null cannot be cast to non-null type android.os.PowerManager");
                PowerManager.WakeLock newWakeLock = ((PowerManager) systemService).newWakeLock(1, "PhoneNumberAttribution:updateDbFile");
                f28878c = newWakeLock;
                if (newWakeLock != null) {
                    newWakeLock.acquire();
                }
                b(new File(PhoneNoInquireProvider.f28806z));
                ContentProviderClient acquireContentProviderClient = context.getContentResolver().acquireContentProviderClient("com.oplus.dialer.inquirenoarea");
                if (acquireContentProviderClient != null) {
                    try {
                        localContentProvider = acquireContentProviderClient.getLocalContentProvider();
                    } catch (SQLiteException e10) {
                        e = e10;
                        contentProviderClient = acquireContentProviderClient;
                        Log.e("SelfHealUtil", "exception when clear app data " + e);
                        PowerManager.WakeLock wakeLock = f28878c;
                        if (wakeLock != null) {
                            wakeLock.release();
                        }
                        if (contentProviderClient == null) {
                            return;
                        }
                        contentProviderClient.close();
                        return;
                    } catch (FileNotFoundException e11) {
                        e = e11;
                        contentProviderClient = acquireContentProviderClient;
                        Log.e("SelfHealUtil", "exception when clear app data " + e);
                        PowerManager.WakeLock wakeLock2 = f28878c;
                        if (wakeLock2 != null) {
                            wakeLock2.release();
                        }
                        if (contentProviderClient == null) {
                            return;
                        }
                        contentProviderClient.close();
                        return;
                    } catch (IOException e12) {
                        e = e12;
                        contentProviderClient = acquireContentProviderClient;
                        Log.e("SelfHealUtil", "exception when clear app data " + e);
                        PowerManager.WakeLock wakeLock3 = f28878c;
                        if (wakeLock3 != null) {
                            wakeLock3.release();
                        }
                        if (contentProviderClient == null) {
                            return;
                        }
                        contentProviderClient.close();
                        return;
                    } catch (Throwable th) {
                        th = th;
                        contentProviderClient2 = acquireContentProviderClient;
                        PowerManager.WakeLock wakeLock4 = f28878c;
                        if (wakeLock4 != null) {
                            wakeLock4.release();
                        }
                        if (contentProviderClient2 != null) {
                            contentProviderClient2.close();
                        }
                        throw th;
                    }
                }
                com.oplus.phonenoareainquire.e.g(context).e(com.oplus.phonenoareainquire.e.g(context).getReadableDatabase(), "doClearAppData-1");
                if (localContentProvider instanceof PhoneNoInquireProvider) {
                    ((PhoneNoInquireProvider) localContentProvider).F();
                    ((PhoneNoInquireProvider) localContentProvider).C(context);
                    ((PhoneNoInquireProvider) localContentProvider).e();
                    CountDownLatch countDownLatch = new CountDownLatch(1);
                    ((PhoneNoInquireProvider) localContentProvider).P(countDownLatch);
                    b.i(context, ((PhoneNoInquireProvider) localContentProvider).f28810d, countDownLatch);
                    OplusLocaleChangeJobIntentService.f28872j.f(PhoneNumberAreaApplication.b("Multi_Language_Table.txt", PhoneNoInquireProvider.f28795E), context, com.oplus.phonenoareainquire.e.g(context).getReadableDatabase(), "doClearAppData-2");
                    Log.d("SelfHealUtil", "self heal complete");
                }
                PowerManager.WakeLock wakeLock5 = f28878c;
                if (wakeLock5 != null) {
                    wakeLock5.release();
                }
                if (acquireContentProviderClient != null) {
                    acquireContentProviderClient.close();
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (SQLiteException e13) {
            e = e13;
        } catch (FileNotFoundException e14) {
            e = e14;
        } catch (IOException e15) {
            e = e15;
        }
    }

    public static final void d() {
        Context context;
        AtomicInteger atomicInteger = f28877b;
        atomicInteger.addAndGet(1);
        LogUtil.a("SelfHealUtil", "current finished count is : " + atomicInteger.get());
        if (atomicInteger.get() == 4 && (context = f28879d) != null) {
            C1244g.d(F.b(), S.c(), null, new SelfHealUtil$markInitFileComplete$1$1(context, null), 2, null);
        }
    }

    public static final void e(Context c10) {
        i.f(c10, "c");
        f28879d = c10;
    }
}
