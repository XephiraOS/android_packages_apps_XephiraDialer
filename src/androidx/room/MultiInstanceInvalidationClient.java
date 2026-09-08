package androidx.room;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import androidx.room.IMultiInstanceInvalidationCallback;
import androidx.room.IMultiInstanceInvalidationService;
import androidx.room.s;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes.dex */
public class MultiInstanceInvalidationClient {

    /* renamed from: a, reason: collision with root package name */
    public final Context f11242a;

    /* renamed from: b, reason: collision with root package name */
    public final String f11243b;

    /* renamed from: c, reason: collision with root package name */
    public int f11244c;

    /* renamed from: d, reason: collision with root package name */
    public final s f11245d;

    /* renamed from: e, reason: collision with root package name */
    public final s.c f11246e;

    /* renamed from: f, reason: collision with root package name */
    public IMultiInstanceInvalidationService f11247f;

    /* renamed from: g, reason: collision with root package name */
    public final Executor f11248g;

    /* renamed from: h, reason: collision with root package name */
    public final IMultiInstanceInvalidationCallback f11249h = new IMultiInstanceInvalidationCallback.Stub() { // from class: androidx.room.MultiInstanceInvalidationClient.1

        /* renamed from: androidx.room.MultiInstanceInvalidationClient$1$a */
        /* loaded from: classes.dex */
        public class a implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ String[] f11255a;

            public a(String[] strArr) {
                this.f11255a = strArr;
            }

            @Override // java.lang.Runnable
            public void run() {
                MultiInstanceInvalidationClient.this.f11245d.f(this.f11255a);
            }
        }

        @Override // androidx.room.IMultiInstanceInvalidationCallback
        public void o1(String[] strArr) {
            MultiInstanceInvalidationClient.this.f11248g.execute(new a(strArr));
        }
    };

    /* renamed from: i, reason: collision with root package name */
    public final AtomicBoolean f11250i = new AtomicBoolean(false);

    /* renamed from: j, reason: collision with root package name */
    public final ServiceConnection f11251j;

    /* renamed from: k, reason: collision with root package name */
    public final Runnable f11252k;

    /* renamed from: l, reason: collision with root package name */
    public final Runnable f11253l;

    /* loaded from: classes.dex */
    public class a implements ServiceConnection {
        public a() {
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            MultiInstanceInvalidationClient.this.f11247f = IMultiInstanceInvalidationService.Stub.N7(iBinder);
            MultiInstanceInvalidationClient multiInstanceInvalidationClient = MultiInstanceInvalidationClient.this;
            multiInstanceInvalidationClient.f11248g.execute(multiInstanceInvalidationClient.f11252k);
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            MultiInstanceInvalidationClient multiInstanceInvalidationClient = MultiInstanceInvalidationClient.this;
            multiInstanceInvalidationClient.f11248g.execute(multiInstanceInvalidationClient.f11253l);
            MultiInstanceInvalidationClient.this.f11247f = null;
        }
    }

    /* loaded from: classes.dex */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                MultiInstanceInvalidationClient multiInstanceInvalidationClient = MultiInstanceInvalidationClient.this;
                IMultiInstanceInvalidationService iMultiInstanceInvalidationService = multiInstanceInvalidationClient.f11247f;
                if (iMultiInstanceInvalidationService != null) {
                    multiInstanceInvalidationClient.f11244c = iMultiInstanceInvalidationService.Z1(multiInstanceInvalidationClient.f11249h, multiInstanceInvalidationClient.f11243b);
                    MultiInstanceInvalidationClient multiInstanceInvalidationClient2 = MultiInstanceInvalidationClient.this;
                    multiInstanceInvalidationClient2.f11245d.a(multiInstanceInvalidationClient2.f11246e);
                }
            } catch (RemoteException e10) {
                Log.w("ROOM", "Cannot register multi-instance invalidation callback", e10);
            }
        }
    }

    /* loaded from: classes.dex */
    public class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            MultiInstanceInvalidationClient multiInstanceInvalidationClient = MultiInstanceInvalidationClient.this;
            multiInstanceInvalidationClient.f11245d.i(multiInstanceInvalidationClient.f11246e);
        }
    }

    /* loaded from: classes.dex */
    public class d extends s.c {
        public d(String[] strArr) {
            super(strArr);
        }

        @Override // androidx.room.s.c
        public boolean a() {
            return true;
        }

        @Override // androidx.room.s.c
        public void b(Set<String> set) {
            if (MultiInstanceInvalidationClient.this.f11250i.get()) {
                return;
            }
            try {
                MultiInstanceInvalidationClient multiInstanceInvalidationClient = MultiInstanceInvalidationClient.this;
                IMultiInstanceInvalidationService iMultiInstanceInvalidationService = multiInstanceInvalidationClient.f11247f;
                if (iMultiInstanceInvalidationService != null) {
                    iMultiInstanceInvalidationService.c7(multiInstanceInvalidationClient.f11244c, (String[]) set.toArray(new String[0]));
                }
            } catch (RemoteException e10) {
                Log.w("ROOM", "Cannot broadcast invalidation", e10);
            }
        }
    }

    public MultiInstanceInvalidationClient(Context context, String str, Intent intent, s sVar, Executor executor) {
        a aVar = new a();
        this.f11251j = aVar;
        this.f11252k = new b();
        this.f11253l = new c();
        Context applicationContext = context.getApplicationContext();
        this.f11242a = applicationContext;
        this.f11243b = str;
        this.f11245d = sVar;
        this.f11248g = executor;
        this.f11246e = new d((String[]) sVar.f11359a.keySet().toArray(new String[0]));
        applicationContext.bindService(intent, aVar, 1);
    }
}
