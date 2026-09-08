package W;

import android.content.Context;
import android.database.ContentObserver;
import android.os.Handler;
import java.io.FileDescriptor;
import java.io.PrintWriter;

/* compiled from: Loader.java */
/* loaded from: classes.dex */
public class c<D> {

    /* renamed from: a, reason: collision with root package name */
    public int f4113a;

    /* renamed from: b, reason: collision with root package name */
    public InterfaceC0078c<D> f4114b;

    /* renamed from: c, reason: collision with root package name */
    public b<D> f4115c;

    /* renamed from: d, reason: collision with root package name */
    public Context f4116d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f4117e = false;

    /* renamed from: f, reason: collision with root package name */
    public boolean f4118f = false;

    /* renamed from: g, reason: collision with root package name */
    public boolean f4119g = true;

    /* renamed from: h, reason: collision with root package name */
    public boolean f4120h = false;

    /* renamed from: i, reason: collision with root package name */
    public boolean f4121i = false;

    /* compiled from: Loader.java */
    /* loaded from: classes.dex */
    public final class a extends ContentObserver {
        public a() {
            super(new Handler());
        }

        @Override // android.database.ContentObserver
        public boolean deliverSelfNotifications() {
            return true;
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean z10) {
            c.this.p();
        }
    }

    /* compiled from: Loader.java */
    /* loaded from: classes.dex */
    public interface b<D> {
        void j(c<D> cVar);
    }

    /* compiled from: Loader.java */
    /* renamed from: W.c$c, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0078c<D> {
        void t(c<D> cVar, D d10);
    }

    public c(Context context) {
        this.f4116d = context.getApplicationContext();
    }

    public boolean A() {
        boolean z10 = this.f4120h;
        this.f4120h = false;
        this.f4121i |= z10;
        return z10;
    }

    public void B(InterfaceC0078c<D> interfaceC0078c) {
        InterfaceC0078c<D> interfaceC0078c2 = this.f4114b;
        if (interfaceC0078c2 != null) {
            if (interfaceC0078c2 == interfaceC0078c) {
                this.f4114b = null;
                return;
            }
            throw new IllegalArgumentException("Attempting to unregister the wrong listener");
        }
        throw new IllegalStateException("No listener register");
    }

    public void C(b<D> bVar) {
        b<D> bVar2 = this.f4115c;
        if (bVar2 != null) {
            if (bVar2 == bVar) {
                this.f4115c = null;
                return;
            }
            throw new IllegalArgumentException("Attempting to unregister the wrong listener");
        }
        throw new IllegalStateException("No listener register");
    }

    public void a() {
        this.f4118f = true;
        n();
    }

    public boolean b() {
        return o();
    }

    public void c() {
        this.f4121i = false;
    }

    public String d(D d10) {
        StringBuilder sb = new StringBuilder(64);
        I.b.a(d10, sb);
        sb.append("}");
        return sb.toString();
    }

    public void e() {
        b<D> bVar = this.f4115c;
        if (bVar != null) {
            bVar.j(this);
        }
    }

    public void f(D d10) {
        InterfaceC0078c<D> interfaceC0078c = this.f4114b;
        if (interfaceC0078c != null) {
            interfaceC0078c.t(this, d10);
        }
    }

    @Deprecated
    public void g(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        printWriter.print(str);
        printWriter.print("mId=");
        printWriter.print(this.f4113a);
        printWriter.print(" mListener=");
        printWriter.println(this.f4114b);
        if (this.f4117e || this.f4120h || this.f4121i) {
            printWriter.print(str);
            printWriter.print("mStarted=");
            printWriter.print(this.f4117e);
            printWriter.print(" mContentChanged=");
            printWriter.print(this.f4120h);
            printWriter.print(" mProcessingChange=");
            printWriter.println(this.f4121i);
        }
        if (this.f4118f || this.f4119g) {
            printWriter.print(str);
            printWriter.print("mAbandoned=");
            printWriter.print(this.f4118f);
            printWriter.print(" mReset=");
            printWriter.println(this.f4119g);
        }
    }

    public void h() {
        q();
    }

    public Context i() {
        return this.f4116d;
    }

    public int j() {
        return this.f4113a;
    }

    public boolean k() {
        return this.f4118f;
    }

    public boolean l() {
        return this.f4119g;
    }

    public boolean m() {
        return this.f4117e;
    }

    public boolean o() {
        return false;
    }

    public void p() {
        if (this.f4117e) {
            h();
        } else {
            this.f4120h = true;
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(64);
        I.b.a(this, sb);
        sb.append(" id=");
        sb.append(this.f4113a);
        sb.append("}");
        return sb.toString();
    }

    public void u(int i10, InterfaceC0078c<D> interfaceC0078c) {
        if (this.f4114b == null) {
            this.f4114b = interfaceC0078c;
            this.f4113a = i10;
            return;
        }
        throw new IllegalStateException("There is already a listener registered");
    }

    public void v(b<D> bVar) {
        if (this.f4115c == null) {
            this.f4115c = bVar;
            return;
        }
        throw new IllegalStateException("There is already a listener registered");
    }

    public void w() {
        r();
        this.f4119g = true;
        this.f4117e = false;
        this.f4118f = false;
        this.f4120h = false;
        this.f4121i = false;
    }

    public void x() {
        if (this.f4121i) {
            p();
        }
    }

    public final void y() {
        this.f4117e = true;
        this.f4119g = false;
        this.f4118f = false;
        s();
    }

    public void z() {
        this.f4117e = false;
        t();
    }

    public void n() {
    }

    public void q() {
    }

    public void r() {
    }

    public void s() {
    }

    public void t() {
    }
}
