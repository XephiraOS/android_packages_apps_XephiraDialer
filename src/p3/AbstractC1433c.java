package p3;

import android.graphics.drawable.Drawable;
import o3.InterfaceC1399c;
import s3.C1541l;

/* compiled from: CustomTarget.java */
/* renamed from: p3.c, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC1433c<T> implements InterfaceC1438h<T> {

    /* renamed from: a, reason: collision with root package name */
    public final int f35994a;

    /* renamed from: b, reason: collision with root package name */
    public final int f35995b;

    /* renamed from: c, reason: collision with root package name */
    public InterfaceC1399c f35996c;

    public AbstractC1433c() {
        this(Integer.MIN_VALUE, Integer.MIN_VALUE);
    }

    @Override // p3.InterfaceC1438h
    public final void f(InterfaceC1399c interfaceC1399c) {
        this.f35996c = interfaceC1399c;
    }

    @Override // p3.InterfaceC1438h
    public final InterfaceC1399c getRequest() {
        return this.f35996c;
    }

    @Override // p3.InterfaceC1438h
    public final void i(InterfaceC1437g interfaceC1437g) {
        interfaceC1437g.d(this.f35994a, this.f35995b);
    }

    public AbstractC1433c(int i10, int i11) {
        if (C1541l.t(i10, i11)) {
            this.f35994a = i10;
            this.f35995b = i11;
            return;
        }
        throw new IllegalArgumentException("Width and height must both be > 0 or Target#SIZE_ORIGINAL, but given width: " + i10 + " and height: " + i11);
    }

    @Override // com.bumptech.glide.manager.k
    public void b() {
    }

    @Override // p3.InterfaceC1438h
    public final void c(InterfaceC1437g interfaceC1437g) {
    }

    @Override // p3.InterfaceC1438h
    public void d(Drawable drawable) {
    }

    @Override // com.bumptech.glide.manager.k
    public void e() {
    }

    @Override // p3.InterfaceC1438h
    public void g(Drawable drawable) {
    }

    @Override // com.bumptech.glide.manager.k
    public void onStart() {
    }
}
