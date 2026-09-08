package V1;

import android.view.View;

/* compiled from: OnClickListener.java */
/* loaded from: classes.dex */
public final class a implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    public final InterfaceC0074a f3963a;

    /* renamed from: b, reason: collision with root package name */
    public final int f3964b;

    /* compiled from: OnClickListener.java */
    /* renamed from: V1.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0074a {
        void i0(int i10, View view);
    }

    public a(InterfaceC0074a interfaceC0074a, int i10) {
        this.f3963a = interfaceC0074a;
        this.f3964b = i10;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        this.f3963a.i0(this.f3964b, view);
    }
}
