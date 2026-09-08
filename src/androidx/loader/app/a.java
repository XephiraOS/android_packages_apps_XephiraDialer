package androidx.loader.app;

import W.c;
import android.os.Bundle;
import androidx.lifecycle.InterfaceC0492o;
import androidx.lifecycle.N;
import java.io.FileDescriptor;
import java.io.PrintWriter;

/* compiled from: LoaderManager.java */
/* loaded from: classes.dex */
public abstract class a {

    /* compiled from: LoaderManager.java */
    /* renamed from: androidx.loader.app.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0129a<D> {
        void Q(c<D> cVar);

        void S0(c<D> cVar, D d10);

        c<D> Z(int i10, Bundle bundle);
    }

    public static <T extends InterfaceC0492o & N> a c(T t10) {
        return new LoaderManagerImpl(t10, t10.getViewModelStore());
    }

    public abstract void a(int i10);

    @Deprecated
    public abstract void b(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr);

    public abstract <D> c<D> d(int i10);

    public abstract <D> c<D> e(int i10, Bundle bundle, InterfaceC0129a<D> interfaceC0129a);

    public abstract void f();

    public abstract <D> c<D> g(int i10, Bundle bundle, InterfaceC0129a<D> interfaceC0129a);
}
