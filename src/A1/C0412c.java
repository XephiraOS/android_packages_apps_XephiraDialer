package a1;

import android.bluetooth.BluetoothSocket;
import java.io.InputStream;
import java.io.OutputStream;

/* compiled from: BluetoothPbapRfcommTransport.java */
/* renamed from: a1.c, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0412c implements k {

    /* renamed from: a, reason: collision with root package name */
    public BluetoothSocket f6276a;

    public C0412c(BluetoothSocket bluetoothSocket) {
        this.f6276a = bluetoothSocket;
    }

    @Override // a1.k
    public InputStream a() {
        return this.f6276a.getInputStream();
    }

    @Override // a1.k
    public OutputStream b() {
        return this.f6276a.getOutputStream();
    }
}
