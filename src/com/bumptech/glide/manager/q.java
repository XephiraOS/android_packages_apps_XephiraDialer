package com.bumptech.glide.manager;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.util.Log;
import com.bumptech.glide.manager.b;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import s3.C1535f;
import s3.C1541l;

/* compiled from: SingletonConnectivityReceiver.java */
/* loaded from: classes.dex */
public final class q {

    /* renamed from: d, reason: collision with root package name */
    public static volatile q f19714d;

    /* renamed from: a, reason: collision with root package name */
    public final c f19715a;

    /* renamed from: b, reason: collision with root package name */
    public final Set<b.a> f19716b = new HashSet();

    /* renamed from: c, reason: collision with root package name */
    public boolean f19717c;

    /* compiled from: SingletonConnectivityReceiver.java */
    /* loaded from: classes.dex */
    public class a implements C1535f.b<ConnectivityManager> {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f19718a;

        public a(Context context) {
            this.f19718a = context;
        }

        @Override // s3.C1535f.b
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public ConnectivityManager get() {
            return (ConnectivityManager) this.f19718a.getSystemService("connectivity");
        }
    }

    /* compiled from: SingletonConnectivityReceiver.java */
    /* loaded from: classes.dex */
    public class b implements b.a {
        public b() {
        }

        @Override // com.bumptech.glide.manager.b.a
        public void a(boolean z10) {
            ArrayList arrayList;
            C1541l.a();
            synchronized (q.this) {
                arrayList = new ArrayList(q.this.f19716b);
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                ((b.a) it.next()).a(z10);
            }
        }
    }

    /* compiled from: SingletonConnectivityReceiver.java */
    /* loaded from: classes.dex */
    public interface c {
        boolean a();

        void b();
    }

    /* compiled from: SingletonConnectivityReceiver.java */
    /* loaded from: classes.dex */
    public static final class d implements c {

        /* renamed from: a, reason: collision with root package name */
        public boolean f19721a;

        /* renamed from: b, reason: collision with root package name */
        public final b.a f19722b;

        /* renamed from: c, reason: collision with root package name */
        public final C1535f.b<ConnectivityManager> f19723c;

        /* renamed from: d, reason: collision with root package name */
        public final ConnectivityManager.NetworkCallback f19724d = new a();

        /* compiled from: SingletonConnectivityReceiver.java */
        /* loaded from: classes.dex */
        public class a extends ConnectivityManager.NetworkCallback {

            /* compiled from: SingletonConnectivityReceiver.java */
            /* renamed from: com.bumptech.glide.manager.q$d$a$a, reason: collision with other inner class name */
            /* loaded from: classes.dex */
            public class RunnableC0196a implements Runnable {

                /* renamed from: a, reason: collision with root package name */
                public final /* synthetic */ boolean f19726a;

                public RunnableC0196a(boolean z10) {
                    this.f19726a = z10;
                }

                @Override // java.lang.Runnable
                public void run() {
                    a.this.a(this.f19726a);
                }
            }

            public a() {
            }

            public void a(boolean z10) {
                C1541l.a();
                d dVar = d.this;
                boolean z11 = dVar.f19721a;
                dVar.f19721a = z10;
                if (z11 != z10) {
                    dVar.f19722b.a(z10);
                }
            }

            public final void b(boolean z10) {
                C1541l.u(new RunnableC0196a(z10));
            }

            @Override // android.net.ConnectivityManager.NetworkCallback
            public void onAvailable(Network network) {
                b(true);
            }

            @Override // android.net.ConnectivityManager.NetworkCallback
            public void onLost(Network network) {
                b(false);
            }
        }

        public d(C1535f.b<ConnectivityManager> bVar, b.a aVar) {
            this.f19723c = bVar;
            this.f19722b = aVar;
        }

        @Override // com.bumptech.glide.manager.q.c
        public boolean a() {
            boolean z10;
            if (this.f19723c.get().getActiveNetwork() != null) {
                z10 = true;
            } else {
                z10 = false;
            }
            this.f19721a = z10;
            try {
                this.f19723c.get().registerDefaultNetworkCallback(this.f19724d);
                return true;
            } catch (RuntimeException e10) {
                if (Log.isLoggable("ConnectivityMonitor", 5)) {
                    Log.w("ConnectivityMonitor", "Failed to register callback", e10);
                }
                return false;
            }
        }

        @Override // com.bumptech.glide.manager.q.c
        public void b() {
            this.f19723c.get().unregisterNetworkCallback(this.f19724d);
        }
    }

    public q(Context context) {
        this.f19715a = new d(C1535f.a(new a(context)), new b());
    }

    public static q a(Context context) {
        if (f19714d == null) {
            synchronized (q.class) {
                try {
                    if (f19714d == null) {
                        f19714d = new q(context.getApplicationContext());
                    }
                } finally {
                }
            }
        }
        return f19714d;
    }

    public final void b() {
        if (!this.f19717c && !this.f19716b.isEmpty()) {
            this.f19717c = this.f19715a.a();
        }
    }

    public final void c() {
        if (this.f19717c && this.f19716b.isEmpty()) {
            this.f19715a.b();
            this.f19717c = false;
        }
    }

    public synchronized void d(b.a aVar) {
        this.f19716b.add(aVar);
        b();
    }

    public synchronized void e(b.a aVar) {
        this.f19716b.remove(aVar);
        c();
    }
}
