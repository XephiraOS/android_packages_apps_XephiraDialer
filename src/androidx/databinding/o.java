package androidx.databinding;

import android.view.View;
import android.view.ViewStub;

/* compiled from: ViewStubProxy.java */
/* loaded from: classes.dex */
public class o {

    /* renamed from: a, reason: collision with root package name */
    public ViewStub f9660a;

    /* renamed from: b, reason: collision with root package name */
    public ViewDataBinding f9661b;

    /* renamed from: c, reason: collision with root package name */
    public View f9662c;

    /* renamed from: d, reason: collision with root package name */
    public ViewStub.OnInflateListener f9663d;

    /* renamed from: e, reason: collision with root package name */
    public ViewDataBinding f9664e;

    /* renamed from: f, reason: collision with root package name */
    public ViewStub.OnInflateListener f9665f;

    /* compiled from: ViewStubProxy.java */
    /* loaded from: classes.dex */
    public class a implements ViewStub.OnInflateListener {
        public a() {
        }

        @Override // android.view.ViewStub.OnInflateListener
        public void onInflate(ViewStub viewStub, View view) {
            o.this.f9662c = view;
            o oVar = o.this;
            oVar.f9661b = g.c(oVar.f9664e.f9631l, view, viewStub.getLayoutResource());
            o.this.f9660a = null;
            if (o.this.f9663d != null) {
                o.this.f9663d.onInflate(viewStub, view);
                o.this.f9663d = null;
            }
            o.this.f9664e.O0();
            o.this.f9664e.G0();
        }
    }

    public o(ViewStub viewStub) {
        a aVar = new a();
        this.f9665f = aVar;
        this.f9660a = viewStub;
        viewStub.setOnInflateListener(aVar);
    }

    public ViewDataBinding g() {
        return this.f9661b;
    }

    public View h() {
        return this.f9662c;
    }

    public ViewStub i() {
        return this.f9660a;
    }

    public boolean j() {
        if (this.f9662c != null) {
            return true;
        }
        return false;
    }

    public void k(ViewDataBinding viewDataBinding) {
        this.f9664e = viewDataBinding;
    }

    public void l(ViewStub.OnInflateListener onInflateListener) {
        if (this.f9660a != null) {
            this.f9663d = onInflateListener;
        }
    }
}
