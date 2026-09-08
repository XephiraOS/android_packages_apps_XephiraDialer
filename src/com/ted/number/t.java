package com.ted.number;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.IBinder;
import android.os.RemoteException;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.util.Log;
import com.android.incallui.R;
import com.ted.number.entrys.RecognitionNumber;
import com.ted.number.entrys.RequestData;
import com.ted.number.service.INumCallback;
import com.ted.number.service.INumberService;
import java.util.HashMap;

/* compiled from: TedServiceHelper.java */
/* loaded from: classes4.dex */
public class t {

    /* renamed from: f, reason: collision with root package name */
    public static t f29698f;

    /* renamed from: b, reason: collision with root package name */
    public INumberService f29700b;

    /* renamed from: d, reason: collision with root package name */
    public Context f29702d;

    /* renamed from: c, reason: collision with root package name */
    public HashMap<String, RecognitionNumber> f29701c = new HashMap<>();

    /* renamed from: e, reason: collision with root package name */
    public ServiceConnection f29703e = new a();

    /* renamed from: a, reason: collision with root package name */
    public final Object f29699a = new Object();

    /* compiled from: TedServiceHelper.java */
    /* loaded from: classes4.dex */
    public class a implements ServiceConnection {
        public a() {
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            synchronized (t.this.f29699a) {
                Log.d("TedServiceHelper", "onServiceConnected...");
                t.this.f29700b = INumberService.Stub.N7(iBinder);
                t.this.f29699a.notifyAll();
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            synchronized (t.this.f29699a) {
                Log.d("TedServiceHelper", "onServiceDisconnected...");
                t tVar = t.this;
                tVar.f29700b = null;
                tVar.f29699a.notifyAll();
            }
        }
    }

    public t(Context context) {
        this.f29702d = context;
    }

    public static void c() {
        t tVar = f29698f;
        if (tVar != null) {
            tVar.k();
        }
    }

    public static CharSequence e(Context context, String str, CharSequence charSequence) {
        if (!TextUtils.isEmpty(str)) {
            String f10 = f(str);
            new SpannableString(f10 + ((Object) charSequence)).setSpan(new ForegroundColorSpan(context.getColor(R.color.incall_ted_mark_text_color)), 0, f10.length(), 0);
            return f10 + ((Object) charSequence);
        }
        return charSequence;
    }

    public static String f(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (str.length() > 17) {
            return str.substring(0, 16) + "   ";
        }
        return str + "   ";
    }

    public static synchronized t g(Context context) {
        t tVar;
        synchronized (t.class) {
            try {
                if (f29698f == null) {
                    f29698f = new t(context.getApplicationContext());
                }
                tVar = f29698f;
            } catch (Throwable th) {
                throw th;
            }
        }
        return tVar;
    }

    public boolean b() {
        Log.d("TedServiceHelper", "start bind servie ...");
        Intent intent = new Intent("com.ted.number.service");
        intent.setPackage("com.ted.number");
        return this.f29702d.getApplicationContext().bindService(intent, this.f29703e, 1);
    }

    public final void d() {
        Object obj = this.f29699a;
        if (obj != null) {
            synchronized (obj) {
                try {
                    if (this.f29700b != null) {
                        this.f29700b = null;
                    }
                } finally {
                }
            }
        }
    }

    public byte[] h(String str) {
        try {
            j();
            INumberService iNumberService = this.f29700b;
            if (iNumberService != null) {
                return iNumberService.V(str);
            }
            return null;
        } catch (Exception e10) {
            Log.e("TedServiceHelper", "loadIconData, exception = " + e10);
            return null;
        }
    }

    public RecognitionNumber i(RequestData requestData, Bundle bundle, INumCallback.Stub stub) {
        try {
            try {
                j();
                INumberService iNumberService = this.f29700b;
                if (iNumberService != null) {
                    return iNumberService.R6(requestData, bundle, stub);
                }
                return null;
            } catch (Exception e10) {
                Log.e("TedServiceHelper", e10.getMessage());
                return null;
            }
        } catch (DeadObjectException unused) {
            this.d();
            INumberService iNumberService2 = this.f29700b;
            if (iNumberService2 != null) {
                return iNumberService2.R6(requestData, bundle, stub);
            }
            return null;
        } catch (RemoteException e11) {
            Log.d("TedServiceHelper", "Exception: " + e11.toString());
            return null;
        } catch (InterruptedException e12) {
            Log.d("TedServiceHelper", "Exception: " + e12.toString());
            return null;
        } catch (Exception e13) {
            Log.d("TedServiceHelper", "Exception: " + e13.toString());
            return null;
        }
    }

    public final void j() {
        if (this.f29700b == null) {
            synchronized (this.f29699a) {
                try {
                    if (this.f29700b == null) {
                        if (b()) {
                            Log.d("TedServiceHelper", " synchronizedLock mLock.wait : " + Thread.currentThread());
                            this.f29699a.wait();
                            if (this.f29700b != null) {
                                Log.d("TedServiceHelper", " synchronizedLock mLock.notify, proxy !=null thread:" + Thread.currentThread());
                            } else {
                                Log.d("TedServiceHelper", " synchronizedLock mLock.notify, proxy=null!! thread:" + Thread.currentThread());
                            }
                        } else {
                            Log.d("TedServiceHelper", " synchronizedLock bindService failed!");
                        }
                    } else {
                        Log.d("TedServiceHelper", " IPageService proxy object != null 2");
                    }
                } finally {
                }
            }
            return;
        }
        Log.d("TedServiceHelper", " IPageService proxy object != null 1");
    }

    public void k() {
        try {
            if (this.f29700b != null) {
                Log.d("TedServiceHelper", "start unbind service ...");
                this.f29702d.getApplicationContext().unbindService(this.f29703e);
                this.f29700b = null;
            }
        } catch (IllegalArgumentException e10) {
            if (com.android.incallui.Log.sDebug) {
                Log.e("TedServiceHelper", "unbindService, exception = " + e10);
            }
        }
    }
}
