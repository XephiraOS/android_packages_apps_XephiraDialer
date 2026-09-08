package c1;

import android.bluetooth.BluetoothSocket;
import d1.C0947b;

/* compiled from: BlueSocketProxy.java */
/* renamed from: c1.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0548b implements InterfaceC0549c {

    /* renamed from: b, reason: collision with root package name */
    public C0947b f12714b = new C0947b();

    /* renamed from: a, reason: collision with root package name */
    public InterfaceC0549c f12713a = new C0547a();

    @Override // c1.InterfaceC0549c
    public int a() {
        C0947b.a(" socket on connect", 0);
        return this.f12713a.a();
    }

    @Override // c1.InterfaceC0549c
    public boolean b(Object obj) {
        C0947b.a(" socket on setTarget", 0);
        return this.f12713a.b(obj);
    }

    @Override // c1.InterfaceC0549c
    public int c() {
        C0947b.a(" socket on disconnect", 0);
        return this.f12713a.c();
    }

    @Override // c1.InterfaceC0549c
    public BluetoothSocket d() {
        C0947b.a(" socket on getSocket", 0);
        return this.f12713a.d();
    }
}
