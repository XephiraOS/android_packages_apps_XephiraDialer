package c1;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import d1.C0947b;
import java.io.IOException;
import java.util.UUID;

/* compiled from: BlueSocketOperationImpl.java */
/* renamed from: c1.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0547a implements InterfaceC0549c {

    /* renamed from: d, reason: collision with root package name */
    public static final UUID f12709d = UUID.fromString("0000112f-0000-1000-8000-00805F9B34FB");

    /* renamed from: a, reason: collision with root package name */
    public BluetoothSocket f12710a = null;

    /* renamed from: b, reason: collision with root package name */
    public BluetoothDevice f12711b = null;

    /* renamed from: c, reason: collision with root package name */
    public C0947b f12712c = new C0947b();

    @Override // c1.InterfaceC0549c
    public int a() {
        BluetoothDevice bluetoothDevice = this.f12711b;
        if (bluetoothDevice == null) {
            return -1;
        }
        try {
            BluetoothSocket createRfcommSocketToServiceRecord = bluetoothDevice.createRfcommSocketToServiceRecord(f12709d);
            this.f12710a = createRfcommSocketToServiceRecord;
            createRfcommSocketToServiceRecord.connect();
            return 0;
        } catch (IOException e10) {
            H7.b.c("BlueSocketOperationImpl", "Exception e: " + e10);
            C0947b.a(e10.getMessage(), 3);
            BluetoothSocket bluetoothSocket = this.f12710a;
            if (bluetoothSocket != null) {
                try {
                    bluetoothSocket.close();
                } catch (IOException e11) {
                    H7.b.c("BlueSocketOperationImpl", "e=" + e11);
                }
            }
            return -1;
        }
    }

    @Override // c1.InterfaceC0549c
    public boolean b(Object obj) {
        e((BluetoothDevice) obj);
        return false;
    }

    @Override // c1.InterfaceC0549c
    public int c() {
        try {
            this.f12710a.close();
            return 0;
        } catch (IOException e10) {
            C0947b.a(e10.getMessage(), 3);
            return -2;
        }
    }

    @Override // c1.InterfaceC0549c
    public BluetoothSocket d() {
        return this.f12710a;
    }

    public void e(BluetoothDevice bluetoothDevice) {
        this.f12711b = bluetoothDevice;
    }
}
