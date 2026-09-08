package h9;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.IBinder;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Log;
import com.oplus.utils.C0844e;
import com.oplus.utils.C0846g;
import com.ted.phonenumber.entrys.CallerIdItem$MarkerData;
import com.ted.phonenumber.entrys.RecognitionNumber;
import com.ted.phonenumber.entrys.RequestData;
import com.ted.phonenumber.service.INumListCallback;
import com.ted.phonenumber.service.INumberService;
import java.util.HashMap;
import java.util.List;
import z6.b;

/* compiled from: TedServiceHelper.java */
/* renamed from: h9.a, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public class C1087a {

    /* renamed from: f, reason: collision with root package name */
    public static C1087a f32133f;

    /* renamed from: a, reason: collision with root package name */
    public INumberService f32134a;

    /* renamed from: d, reason: collision with root package name */
    public final Context f32137d;

    /* renamed from: c, reason: collision with root package name */
    public final HashMap<String, RecognitionNumber> f32136c = new HashMap<>();

    /* renamed from: e, reason: collision with root package name */
    public final ServiceConnection f32138e = new ServiceConnectionC0304a();

    /* renamed from: b, reason: collision with root package name */
    public final Object f32135b = new Object();

    /* compiled from: TedServiceHelper.java */
    /* renamed from: h9.a$a, reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class ServiceConnectionC0304a implements ServiceConnection {
        public ServiceConnectionC0304a() {
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            synchronized (C1087a.this.f32135b) {
                C0846g.i("InCallUI_TedServiceHelper", "onServiceConnected...");
                C1087a.this.f32134a = INumberService.Stub.N7(iBinder);
                C1087a.this.f32135b.notifyAll();
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            synchronized (C1087a.this.f32135b) {
                C0846g.i("InCallUI_TedServiceHelper", "onServiceDisconnected...");
                C1087a c1087a = C1087a.this;
                c1087a.f32134a = null;
                c1087a.f32135b.notifyAll();
            }
        }
    }

    public C1087a(Context context) {
        this.f32137d = context;
    }

    public static C1087a e(Context context) {
        if (f32133f == null) {
            synchronized (C1087a.class) {
                try {
                    if (f32133f == null) {
                        f32133f = new C1087a(context.getApplicationContext());
                    }
                } finally {
                }
            }
        }
        return f32133f;
    }

    public static boolean i(Context context) {
        Bundle bundle = new Bundle();
        bundle.putBoolean("online_recognize_switch", false);
        try {
            Bundle call = context.getContentResolver().call("com.number.recognition.settings", "get_property", (String) null, bundle);
            if (call != null) {
                return call.getBoolean("online_recognize_switch", false);
            }
        } catch (IllegalArgumentException e10) {
            Log.e("InCallUI_TedServiceHelper", "isOnlineRecognizeSwitchOn " + e10);
        }
        return false;
    }

    public static boolean m(Context context) {
        if (C0844e.i()) {
            return i(context);
        }
        if (b.c(context, 0, "UpdateStrangers", 1) != 1) {
            return false;
        }
        return true;
    }

    public boolean b() {
        if (!l7.b.d()) {
            return false;
        }
        C0846g.i("InCallUI_TedServiceHelper", "start bind servie ...");
        Intent intent = new Intent("com.ted.number.service");
        intent.setPackage("com.ted.number");
        return this.f32137d.getApplicationContext().bindService(intent, this.f32138e, 1);
    }

    public final void c() {
        if (this.f32134a != null) {
            synchronized (this.f32135b) {
                try {
                    if (this.f32134a != null) {
                        this.f32134a = null;
                    }
                } finally {
                }
            }
        }
    }

    public RecognitionNumber d(String str) {
        HashMap<String, RecognitionNumber> hashMap;
        if (!TextUtils.isEmpty(str) && (hashMap = this.f32136c) != null) {
            return hashMap.get(str);
        }
        return null;
    }

    public String f(String str) {
        RecognitionNumber d10;
        if (TextUtils.isEmpty(str) || (d10 = d(str)) == null) {
            return null;
        }
        return d10.c0();
    }

    public String g(String str) {
        RecognitionNumber recognitionNumber;
        HashMap<String, RecognitionNumber> hashMap = this.f32136c;
        if (hashMap != null && hashMap.size() > 0 && (recognitionNumber = this.f32136c.get(str)) != null) {
            return recognitionNumber.getName();
        }
        return null;
    }

    public final boolean h(CallerIdItem$MarkerData callerIdItem$MarkerData, CallerIdItem$MarkerData callerIdItem$MarkerData2) {
        if (callerIdItem$MarkerData == null && callerIdItem$MarkerData2 == null) {
            return true;
        }
        if (callerIdItem$MarkerData != null && callerIdItem$MarkerData2 != null && k(callerIdItem$MarkerData.b(), callerIdItem$MarkerData2.b()) && callerIdItem$MarkerData.j0() == callerIdItem$MarkerData2.j0()) {
            return true;
        }
        return false;
    }

    public boolean j(String str) {
        RecognitionNumber recognitionNumber;
        HashMap<String, RecognitionNumber> hashMap = this.f32136c;
        if (hashMap != null && (recognitionNumber = hashMap.get(str)) != null) {
            if (!TextUtils.isEmpty(recognitionNumber.getName())) {
                return true;
            }
            CallerIdItem$MarkerData b10 = recognitionNumber.b();
            if (b10 != null && !TextUtils.isEmpty(b10.b())) {
                return true;
            }
        }
        return false;
    }

    public boolean k(String str, String str2) {
        if (TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) {
            return true;
        }
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && str.equals(str2)) {
            return true;
        }
        return false;
    }

    public final boolean l(RecognitionNumber recognitionNumber, String str) {
        RecognitionNumber recognitionNumber2 = this.f32136c.get(str);
        if (recognitionNumber2 == null || !k(recognitionNumber.getName(), recognitionNumber2.getName()) || !k(recognitionNumber.c0(), recognitionNumber2.c0()) || !h(recognitionNumber.b(), recognitionNumber2.b())) {
            return true;
        }
        return false;
    }

    public byte[] n(String str) {
        try {
            u();
            INumberService iNumberService = this.f32134a;
            if (iNumberService != null) {
                return iNumberService.V(str);
            }
            return null;
        } catch (Exception e10) {
            Log.e("InCallUI_TedServiceHelper", "load icon error:" + e10);
            return null;
        }
    }

    public byte[] o(String str) {
        try {
            u();
            INumberService iNumberService = this.f32134a;
            if (iNumberService != null) {
                return iNumberService.V(str);
            }
            return null;
        } catch (Exception e10) {
            Log.e("InCallUI_TedServiceHelper", "loadIconData, exception = " + e10);
            return null;
        }
    }

    public void p(List<RequestData> list, INumListCallback.Stub stub) {
        try {
            u();
            INumberService iNumberService = this.f32134a;
            if (iNumberService != null) {
                iNumberService.i0(list, stub);
            }
        } catch (DeadObjectException e10) {
            Log.e("InCallUI_TedServiceHelper", "DeadObjectException1:" + e10);
            try {
                c();
                u();
                INumberService iNumberService2 = this.f32134a;
                if (iNumberService2 != null) {
                    iNumberService2.i0(list, stub);
                }
            } catch (Exception e11) {
                Log.e("InCallUI_TedServiceHelper", "queryBatch Exception1:" + e11);
            }
        } catch (RemoteException e12) {
            Log.e("InCallUI_TedServiceHelper", "queryBatch RemoteException:" + e12);
        } catch (InterruptedException e13) {
            Log.e("InCallUI_TedServiceHelper", "queryBatch InterruptedException:" + e13);
        } catch (Exception e14) {
            Log.e("InCallUI_TedServiceHelper", "queryBatch Exception:" + e14);
        }
    }

    public RecognitionNumber q(RequestData requestData) {
        try {
            u();
            INumberService iNumberService = this.f32134a;
            if (iNumberService == null) {
                return null;
            }
            return iNumberService.C6(requestData);
        } catch (DeadObjectException e10) {
            Log.e("InCallUI_TedServiceHelper", "DeadObjectException1:" + e10);
            try {
                c();
                u();
                INumberService iNumberService2 = this.f32134a;
                if (iNumberService2 == null) {
                    return null;
                }
                return iNumberService2.C6(requestData);
            } catch (Exception e11) {
                Log.e("InCallUI_TedServiceHelper", "queryNumberInfo Exception1:" + e11);
                return null;
            }
        } catch (RemoteException e12) {
            Log.e("InCallUI_TedServiceHelper", "queryNumberInfo RemoteException:" + e12);
            return null;
        } catch (InterruptedException e13) {
            Log.e("InCallUI_TedServiceHelper", "queryNumberInfo InterruptedException:" + e13);
            return null;
        } catch (Exception e14) {
            Log.e("InCallUI_TedServiceHelper", "queryNumberInfo Exception:" + e14);
            return null;
        }
    }

    public RecognitionNumber r(String str, int i10, int i11, boolean z10) {
        RequestData requestData;
        RecognitionNumber recognitionNumber = null;
        try {
            try {
                u();
                if (this.f32134a == null) {
                    return null;
                }
                RequestData.b t10 = new RequestData.b().r(str).o(0).s(i10).t(i11);
                if (C0844e.i()) {
                    t10.q(true);
                } else {
                    t10.q(z10);
                }
                RequestData n10 = t10.n();
                try {
                    return this.f32134a.C6(n10);
                } catch (DeadObjectException e10) {
                    requestData = n10;
                    e = e10;
                    Log.e("InCallUI_TedServiceHelper", "queryNumberInfo onRetry:" + e);
                    try {
                        c();
                        u();
                        INumberService iNumberService = this.f32134a;
                        if (iNumberService != null) {
                            recognitionNumber = iNumberService.C6(requestData);
                        } else {
                            Log.e("InCallUI_TedServiceHelper", "mPageService is null onRetry");
                        }
                        return recognitionNumber;
                    } catch (Exception e11) {
                        Log.e("InCallUI_TedServiceHelper", "queryNumberInfo Exception on retry :" + e11);
                        return recognitionNumber;
                    }
                }
            } catch (DeadObjectException e12) {
                e = e12;
                requestData = null;
            }
        } catch (RemoteException e13) {
            Log.e("InCallUI_TedServiceHelper", "queryNumberInfo RemoteException:" + e13);
            return null;
        } catch (InterruptedException e14) {
            Log.e("InCallUI_TedServiceHelper", "queryNumberInfo InterruptedException:" + e14);
            return null;
        } catch (Exception e15) {
            Log.e("InCallUI_TedServiceHelper", "queryNumberInfo Exception:" + e15);
            return null;
        }
    }

    public boolean s(String str, int i10) {
        boolean z10;
        if (!l7.b.d()) {
            return false;
        }
        if (!C0844e.i()) {
            z10 = m(this.f32137d);
        } else {
            z10 = true;
        }
        RecognitionNumber r10 = r(str, i10, 4000, z10);
        if (r10 == null || !l(r10, str)) {
            return false;
        }
        this.f32136c.put(str, r10);
        return true;
    }

    public boolean t(String str, String str2) {
        boolean z10 = false;
        if (TextUtils.isEmpty(str) || !l7.b.d()) {
            return false;
        }
        RequestData.b t10 = new RequestData.b().r(str).o(1).p(str2).t(4000L);
        if (!C0844e.i()) {
            t10.q(m(this.f32137d));
        }
        try {
            RecognitionNumber q10 = q(t10.n());
            if (q10 == null) {
                return false;
            }
            if (q10.equals(this.f32136c.get(str))) {
                return false;
            }
            try {
                this.f32136c.put(str, q10);
                return true;
            } catch (Exception e10) {
                e = e10;
                z10 = true;
                Log.e("InCallUI_TedServiceHelper", "" + e);
                return z10;
            }
        } catch (Exception e11) {
            e = e11;
        }
    }

    public final void u() {
        if (this.f32134a != null) {
            C0846g.i("InCallUI_TedServiceHelper", " IPageService binder object isAlive : " + this.f32134a.asBinder().isBinderAlive());
        }
        INumberService iNumberService = this.f32134a;
        if (iNumberService != null && iNumberService.asBinder().isBinderAlive()) {
            C0846g.i("InCallUI_TedServiceHelper", " IPageService proxy object != null 1");
            return;
        }
        synchronized (this.f32135b) {
            try {
                INumberService iNumberService2 = this.f32134a;
                if (iNumberService2 != null && iNumberService2.asBinder().isBinderAlive()) {
                    C0846g.i("InCallUI_TedServiceHelper", " IPageService proxy object != null 2");
                }
                if (b()) {
                    C0846g.i("InCallUI_TedServiceHelper", " synchronizedLock mLock.wait : " + Thread.currentThread());
                    this.f32135b.wait();
                    if (this.f32134a != null) {
                        C0846g.i("InCallUI_TedServiceHelper", " synchronizedLock mLock.notify, proxy !=null thread:" + Thread.currentThread());
                    } else {
                        C0846g.i("InCallUI_TedServiceHelper", " synchronizedLock mLock.notify, proxy=null!! thread:" + Thread.currentThread());
                    }
                } else {
                    C0846g.i("InCallUI_TedServiceHelper", " synchronizedLock bindService failed!");
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void v() {
        if (this.f32134a != null) {
            this.f32137d.getApplicationContext().unbindService(this.f32138e);
        }
    }
}
