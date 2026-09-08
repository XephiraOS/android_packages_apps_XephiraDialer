package androidx.loader.app;

import W.c;
import android.os.Bundle;
import android.os.Looper;
import android.util.Log;
import androidx.lifecycle.I;
import androidx.lifecycle.InterfaceC0492o;
import androidx.lifecycle.K;
import androidx.lifecycle.M;
import androidx.lifecycle.v;
import androidx.lifecycle.w;
import androidx.loader.app.a;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.reflect.Modifier;
import p.j;

/* loaded from: classes.dex */
public class LoaderManagerImpl extends androidx.loader.app.a {

    /* renamed from: c, reason: collision with root package name */
    public static boolean f10391c = false;

    /* renamed from: a, reason: collision with root package name */
    public final InterfaceC0492o f10392a;

    /* renamed from: b, reason: collision with root package name */
    public final LoaderViewModel f10393b;

    /* loaded from: classes.dex */
    public static class LoaderViewModel extends I {

        /* renamed from: f, reason: collision with root package name */
        public static final K.b f10394f = new a();

        /* renamed from: d, reason: collision with root package name */
        public j<a> f10395d = new j<>();

        /* renamed from: e, reason: collision with root package name */
        public boolean f10396e = false;

        /* loaded from: classes.dex */
        public static class a implements K.b {
            @Override // androidx.lifecycle.K.b
            public <T extends I> T a(Class<T> cls) {
                return new LoaderViewModel();
            }
        }

        public static LoaderViewModel i(M m10) {
            return (LoaderViewModel) new K(m10, f10394f).a(LoaderViewModel.class);
        }

        @Override // androidx.lifecycle.I
        public void e() {
            super.e();
            int i10 = this.f10395d.i();
            for (int i11 = 0; i11 < i10; i11++) {
                this.f10395d.j(i11).p(true);
            }
            this.f10395d.b();
        }

        public void g(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
            if (this.f10395d.i() > 0) {
                printWriter.print(str);
                printWriter.println("Loaders:");
                String str2 = str + "    ";
                for (int i10 = 0; i10 < this.f10395d.i(); i10++) {
                    a j10 = this.f10395d.j(i10);
                    printWriter.print(str);
                    printWriter.print("  #");
                    printWriter.print(this.f10395d.f(i10));
                    printWriter.print(": ");
                    printWriter.println(j10.toString());
                    j10.q(str2, fileDescriptor, printWriter, strArr);
                }
            }
        }

        public void h() {
            this.f10396e = false;
        }

        public <D> a<D> j(int i10) {
            return this.f10395d.d(i10);
        }

        public boolean k() {
            return this.f10396e;
        }

        public void l() {
            int i10 = this.f10395d.i();
            for (int i11 = 0; i11 < i10; i11++) {
                this.f10395d.j(i11).s();
            }
        }

        public void m(int i10, a aVar) {
            this.f10395d.g(i10, aVar);
        }

        public void n(int i10) {
            this.f10395d.h(i10);
        }

        public void o() {
            this.f10396e = true;
        }
    }

    /* loaded from: classes.dex */
    public static class a<D> extends v<D> implements c.InterfaceC0078c<D> {

        /* renamed from: l, reason: collision with root package name */
        public final int f10397l;

        /* renamed from: m, reason: collision with root package name */
        public final Bundle f10398m;

        /* renamed from: n, reason: collision with root package name */
        public final c<D> f10399n;

        /* renamed from: o, reason: collision with root package name */
        public InterfaceC0492o f10400o;

        /* renamed from: p, reason: collision with root package name */
        public b<D> f10401p;

        /* renamed from: q, reason: collision with root package name */
        public c<D> f10402q;

        public a(int i10, Bundle bundle, c<D> cVar, c<D> cVar2) {
            this.f10397l = i10;
            this.f10398m = bundle;
            this.f10399n = cVar;
            this.f10402q = cVar2;
            cVar.u(i10, this);
        }

        @Override // androidx.lifecycle.LiveData
        public void k() {
            if (LoaderManagerImpl.f10391c) {
                Log.v("LoaderManager", "  Starting: " + this);
            }
            this.f10399n.y();
        }

        @Override // androidx.lifecycle.LiveData
        public void l() {
            if (LoaderManagerImpl.f10391c) {
                Log.v("LoaderManager", "  Stopping: " + this);
            }
            this.f10399n.z();
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // androidx.lifecycle.LiveData
        public void n(w<? super D> wVar) {
            super.n(wVar);
            this.f10400o = null;
            this.f10401p = null;
        }

        @Override // androidx.lifecycle.v, androidx.lifecycle.LiveData
        public void o(D d10) {
            super.o(d10);
            c<D> cVar = this.f10402q;
            if (cVar != null) {
                cVar.w();
                this.f10402q = null;
            }
        }

        public c<D> p(boolean z10) {
            if (LoaderManagerImpl.f10391c) {
                Log.v("LoaderManager", "  Destroying: " + this);
            }
            this.f10399n.b();
            this.f10399n.a();
            b<D> bVar = this.f10401p;
            if (bVar != null) {
                n(bVar);
                if (z10) {
                    bVar.c();
                }
            }
            this.f10399n.B(this);
            if ((bVar != null && !bVar.b()) || z10) {
                this.f10399n.w();
                return this.f10402q;
            }
            return this.f10399n;
        }

        public void q(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
            printWriter.print(str);
            printWriter.print("mId=");
            printWriter.print(this.f10397l);
            printWriter.print(" mArgs=");
            printWriter.println(this.f10398m);
            printWriter.print(str);
            printWriter.print("mLoader=");
            printWriter.println(this.f10399n);
            this.f10399n.g(str + "  ", fileDescriptor, printWriter, strArr);
            if (this.f10401p != null) {
                printWriter.print(str);
                printWriter.print("mCallbacks=");
                printWriter.println(this.f10401p);
                this.f10401p.a(str + "  ", printWriter);
            }
            printWriter.print(str);
            printWriter.print("mData=");
            printWriter.println(r().d(getValue()));
            printWriter.print(str);
            printWriter.print("mStarted=");
            printWriter.println(f());
        }

        public c<D> r() {
            return this.f10399n;
        }

        public void s() {
            InterfaceC0492o interfaceC0492o = this.f10400o;
            b<D> bVar = this.f10401p;
            if (interfaceC0492o != null && bVar != null) {
                super.n(bVar);
                i(interfaceC0492o, bVar);
            }
        }

        @Override // W.c.InterfaceC0078c
        public void t(c<D> cVar, D d10) {
            if (LoaderManagerImpl.f10391c) {
                Log.v("LoaderManager", "onLoadComplete: " + this);
            }
            if (Looper.myLooper() == Looper.getMainLooper()) {
                o(d10);
                return;
            }
            if (LoaderManagerImpl.f10391c) {
                Log.w("LoaderManager", "onLoadComplete was incorrectly called on a background thread");
            }
            m(d10);
        }

        public String toString() {
            StringBuilder sb = new StringBuilder(64);
            sb.append("LoaderInfo{");
            sb.append(Integer.toHexString(System.identityHashCode(this)));
            sb.append(" #");
            sb.append(this.f10397l);
            sb.append(" : ");
            I.b.a(this.f10399n, sb);
            sb.append("}}");
            return sb.toString();
        }

        public c<D> u(InterfaceC0492o interfaceC0492o, a.InterfaceC0129a<D> interfaceC0129a) {
            b<D> bVar = new b<>(this.f10399n, interfaceC0129a);
            i(interfaceC0492o, bVar);
            b<D> bVar2 = this.f10401p;
            if (bVar2 != null) {
                n(bVar2);
            }
            this.f10400o = interfaceC0492o;
            this.f10401p = bVar;
            return this.f10399n;
        }
    }

    /* loaded from: classes.dex */
    public static class b<D> implements w<D> {

        /* renamed from: a, reason: collision with root package name */
        public final c<D> f10403a;

        /* renamed from: b, reason: collision with root package name */
        public final a.InterfaceC0129a<D> f10404b;

        /* renamed from: c, reason: collision with root package name */
        public boolean f10405c = false;

        public b(c<D> cVar, a.InterfaceC0129a<D> interfaceC0129a) {
            this.f10403a = cVar;
            this.f10404b = interfaceC0129a;
        }

        public void a(String str, PrintWriter printWriter) {
            printWriter.print(str);
            printWriter.print("mDeliveredData=");
            printWriter.println(this.f10405c);
        }

        public boolean b() {
            return this.f10405c;
        }

        public void c() {
            if (this.f10405c) {
                if (LoaderManagerImpl.f10391c) {
                    Log.v("LoaderManager", "  Resetting: " + this.f10403a);
                }
                this.f10404b.Q(this.f10403a);
            }
        }

        @Override // androidx.lifecycle.w
        public void onChanged(D d10) {
            if (LoaderManagerImpl.f10391c) {
                Log.v("LoaderManager", "  onLoadFinished in " + this.f10403a + ": " + this.f10403a.d(d10));
            }
            this.f10404b.S0(this.f10403a, d10);
            this.f10405c = true;
        }

        public String toString() {
            return this.f10404b.toString();
        }
    }

    public LoaderManagerImpl(InterfaceC0492o interfaceC0492o, M m10) {
        this.f10392a = interfaceC0492o;
        this.f10393b = LoaderViewModel.i(m10);
    }

    @Override // androidx.loader.app.a
    public void a(int i10) {
        if (!this.f10393b.k()) {
            if (Looper.getMainLooper() == Looper.myLooper()) {
                if (f10391c) {
                    Log.v("LoaderManager", "destroyLoader in " + this + " of " + i10);
                }
                a j10 = this.f10393b.j(i10);
                if (j10 != null) {
                    j10.p(true);
                    this.f10393b.n(i10);
                    return;
                }
                return;
            }
            throw new IllegalStateException("destroyLoader must be called on the main thread");
        }
        throw new IllegalStateException("Called while creating a loader");
    }

    @Override // androidx.loader.app.a
    @Deprecated
    public void b(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        this.f10393b.g(str, fileDescriptor, printWriter, strArr);
    }

    @Override // androidx.loader.app.a
    public <D> c<D> d(int i10) {
        if (!this.f10393b.k()) {
            a<D> j10 = this.f10393b.j(i10);
            if (j10 != null) {
                return j10.r();
            }
            return null;
        }
        throw new IllegalStateException("Called while creating a loader");
    }

    @Override // androidx.loader.app.a
    public <D> c<D> e(int i10, Bundle bundle, a.InterfaceC0129a<D> interfaceC0129a) {
        if (!this.f10393b.k()) {
            if (Looper.getMainLooper() == Looper.myLooper()) {
                a<D> j10 = this.f10393b.j(i10);
                if (f10391c) {
                    Log.v("LoaderManager", "initLoader in " + this + ": args=" + bundle);
                }
                if (j10 == null) {
                    return h(i10, bundle, interfaceC0129a, null);
                }
                if (f10391c) {
                    Log.v("LoaderManager", "  Re-using existing loader " + j10);
                }
                return j10.u(this.f10392a, interfaceC0129a);
            }
            throw new IllegalStateException("initLoader must be called on the main thread");
        }
        throw new IllegalStateException("Called while creating a loader");
    }

    @Override // androidx.loader.app.a
    public void f() {
        this.f10393b.l();
    }

    @Override // androidx.loader.app.a
    public <D> c<D> g(int i10, Bundle bundle, a.InterfaceC0129a<D> interfaceC0129a) {
        c<D> cVar;
        if (!this.f10393b.k()) {
            if (Looper.getMainLooper() == Looper.myLooper()) {
                if (f10391c) {
                    Log.v("LoaderManager", "restartLoader in " + this + ": args=" + bundle);
                }
                a<D> j10 = this.f10393b.j(i10);
                if (j10 != null) {
                    cVar = j10.p(false);
                } else {
                    cVar = null;
                }
                return h(i10, bundle, interfaceC0129a, cVar);
            }
            throw new IllegalStateException("restartLoader must be called on the main thread");
        }
        throw new IllegalStateException("Called while creating a loader");
    }

    public final <D> c<D> h(int i10, Bundle bundle, a.InterfaceC0129a<D> interfaceC0129a, c<D> cVar) {
        try {
            this.f10393b.o();
            c<D> Z9 = interfaceC0129a.Z(i10, bundle);
            if (Z9 != null) {
                if (Z9.getClass().isMemberClass() && !Modifier.isStatic(Z9.getClass().getModifiers())) {
                    throw new IllegalArgumentException("Object returned from onCreateLoader must not be a non-static inner member class: " + Z9);
                }
                a aVar = new a(i10, bundle, Z9, cVar);
                if (f10391c) {
                    Log.v("LoaderManager", "  Created new loader " + aVar);
                }
                this.f10393b.m(i10, aVar);
                this.f10393b.h();
                return aVar.u(this.f10392a, interfaceC0129a);
            }
            throw new IllegalArgumentException("Object returned from onCreateLoader must not be null");
        } catch (Throwable th) {
            this.f10393b.h();
            throw th;
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("LoaderManager{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(" in ");
        I.b.a(this.f10392a, sb);
        sb.append("}}");
        return sb.toString();
    }
}
