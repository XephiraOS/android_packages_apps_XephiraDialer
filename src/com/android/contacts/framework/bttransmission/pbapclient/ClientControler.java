package com.android.contacts.framework.bttransmission.pbapclient;

import a1.h;
import a1.i;
import android.bluetooth.BluetoothDevice;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import c1.C0548b;
import c1.InterfaceC0549c;
import d1.C0946a;
import d1.C0947b;
import java.io.FileNotFoundException;

/* loaded from: classes.dex */
public class ClientControler {

    /* renamed from: o, reason: collision with root package name */
    public static boolean f16169o = false;

    /* renamed from: p, reason: collision with root package name */
    public static ClientControler f16170p;

    /* renamed from: a, reason: collision with root package name */
    public InterfaceC0549c f16171a;

    /* renamed from: b, reason: collision with root package name */
    public h f16172b;

    /* renamed from: c, reason: collision with root package name */
    public c f16173c;

    /* renamed from: d, reason: collision with root package name */
    public b f16174d;

    /* renamed from: e, reason: collision with root package name */
    public Handler f16175e;

    /* renamed from: f, reason: collision with root package name */
    public BluetoothDevice f16176f;

    /* renamed from: g, reason: collision with root package name */
    public C0947b f16177g;

    /* renamed from: h, reason: collision with root package name */
    public int f16178h;

    /* renamed from: i, reason: collision with root package name */
    public int f16179i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f16180j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f16181k;

    /* renamed from: l, reason: collision with root package name */
    public boolean f16182l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f16183m;

    /* renamed from: n, reason: collision with root package name */
    public WorkerState f16184n;

    /* loaded from: classes.dex */
    public enum WorkerState {
        WORKING,
        STOPED,
        WAIT,
        INTERRUPT
    }

    /* loaded from: classes.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ClientControler.this.B();
        }
    }

    /* loaded from: classes.dex */
    public class b extends Thread {
        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            if (!ClientControler.this.f16180j) {
                try {
                    ClientControler.this.f16178h = 0;
                    ClientControler.this.r();
                    ClientControler.this.G();
                    ClientControler.this.C();
                    ClientControler.this.F();
                    ClientControler.this.K();
                } catch (Exception e10) {
                    ClientControler.this.M();
                    C0947b unused = ClientControler.this.f16177g;
                    C0947b.a("properties file not found error:" + e10.getMessage(), 3);
                }
            }
        }

        public b() {
        }
    }

    /* loaded from: classes.dex */
    public class c extends Thread {
        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            try {
                ClientControler.this.r();
                ClientControler.this.E();
                if (ClientControler.f16169o) {
                    C0947b unused = ClientControler.this.f16177g;
                    C0947b.a("obex get need resend ", 1);
                    ClientControler.this.E();
                }
                if (ClientControler.f16169o) {
                    C0947b unused2 = ClientControler.this.f16177g;
                    C0947b.a("obex still get need resend ", 1);
                    ClientControler.this.f16182l = true;
                }
                ClientControler.this.L();
                ClientControler.this.f16184n = WorkerState.STOPED;
            } catch (Exception unused3) {
                ClientControler.this.M();
                C0947b unused4 = ClientControler.this.f16177g;
                C0947b.a("properties file not found error", 3);
            }
        }

        public c() {
        }
    }

    /* loaded from: classes.dex */
    public static class d {
        static {
            ClientControler.f16170p = new ClientControler();
        }

        public static ClientControler a() {
            return ClientControler.f16170p;
        }
    }

    /* loaded from: classes.dex */
    public static class e {

        /* renamed from: a, reason: collision with root package name */
        public static byte f16193a;

        public static void a() {
            f16193a = (byte) 0;
        }

        public static boolean b(byte b10) {
            if (b10 != 1) {
                if (b10 != 3) {
                    if (b10 != 6 || (f16193a & 8) <= 0) {
                        return false;
                    }
                    return true;
                }
                if ((f16193a & 2) <= 0) {
                    return false;
                }
                return true;
            }
            if ((f16193a & 1) <= 0) {
                return false;
            }
            return true;
        }

        public static void c(byte b10) {
            if (b10 != 1) {
                if (b10 != 2) {
                    if (b10 != 3) {
                        if (b10 != 4) {
                            if (b10 != 6) {
                                if (b10 != 7) {
                                    return;
                                }
                                f16193a = (byte) (f16193a & (-9));
                                return;
                            }
                            f16193a = (byte) (f16193a | 8);
                            return;
                        }
                        f16193a = (byte) (f16193a & (-3));
                        return;
                    }
                    f16193a = (byte) (f16193a | 2);
                    return;
                }
                f16193a = (byte) (f16193a & (-2));
                return;
            }
            f16193a = (byte) (f16193a | 1);
        }
    }

    public static ClientControler y() {
        return d.a();
    }

    public int A() {
        int i10 = this.f16178h;
        if (i10 < 0) {
            return 0;
        }
        return i10;
    }

    public final void B() {
        this.f16180j = true;
        int e10 = this.f16172b.e();
        if (e10 != -1000) {
            if (e10 == -3) {
                C0947b.a("obex abort request excetpion", 3);
            }
        } else {
            e.c((byte) 6);
        }
        try {
            this.f16178h = 0;
            C0946a.f();
        } catch (FileNotFoundException unused) {
            C0947b.a("rollback failed!!!!", 3);
        }
    }

    public final void C() {
        if (!e.b((byte) 1)) {
            return;
        }
        this.f16172b.b(this.f16171a.d());
        int a10 = this.f16172b.a();
        if (a10 != -1000) {
            if (a10 == -1) {
                try {
                    this.f16181k = true;
                    C0946a.a(this.f16176f.getAddress());
                } catch (FileNotFoundException unused) {
                    C0947b.a("properties file not found ", 3);
                }
                C0947b.a("obex connect failed", 3);
                return;
            }
            return;
        }
        e.c((byte) 3);
        C0947b.a("handle obex connect done ", 3);
    }

    public final void D() {
        if (!e.b((byte) 3)) {
            return;
        }
        int d10 = this.f16172b.d();
        if (d10 != -1000) {
            if (d10 == -4) {
                C0947b.a("obex disconnect failed", 3);
                e.c((byte) 4);
                return;
            }
            return;
        }
        e.c((byte) 4);
    }

    public final void E() {
        if (e.b((byte) 3) && !e.b((byte) 6)) {
            int c10 = this.f16172b.c();
            if (c10 != -7) {
                if (c10 == -2) {
                    this.f16182l = true;
                    C0947b.a("obex get request failed", 3);
                    return;
                }
                return;
            }
            C0947b.a("ObexOperation.OBEX_NEED_RESEND_REQUEST", 1);
            return;
        }
        e.c((byte) 7);
    }

    public final void F() {
        if (e.b((byte) 3) && !e.b((byte) 6)) {
            int f10 = this.f16172b.f();
            if (f10 >= 0) {
                this.f16178h = f10;
                return;
            }
            C0947b.a("obex get phonebook size request excetpion size = " + f10, 3);
            return;
        }
        e.c((byte) 7);
    }

    public final void G() {
        int a10 = this.f16171a.a();
        if (a10 != -1) {
            if (a10 == 0) {
                e.c((byte) 1);
            }
        } else {
            try {
                this.f16181k = true;
                C0946a.a(this.f16176f.getAddress());
            } catch (FileNotFoundException unused) {
                C0947b.a("properties file not found ", 3);
            }
            C0947b.a("socket connect failed", 3);
        }
    }

    public final void H() {
        if (!e.b((byte) 1)) {
            return;
        }
        int c10 = this.f16171a.c();
        if (c10 != -2) {
            if (c10 == 0) {
                e.c((byte) 4);
                return;
            }
            return;
        }
        C0947b.a("socket disconnect failed", 3);
    }

    public boolean I() {
        return this.f16180j;
    }

    public boolean J() {
        return this.f16183m;
    }

    public final void K() {
        if (this.f16181k) {
            this.f16181k = false;
            N(102);
            return;
        }
        C0947b.a(" onGetPBSizeDone down", 0);
        if (I()) {
            L();
            return;
        }
        N(100);
        if (this.f16178h <= 0) {
            L();
        }
    }

    public final void L() {
        C0947b.a(" work down " + this.f16182l, 0);
        if (this.f16182l) {
            this.f16182l = false;
            N(103);
        }
        s();
        e.a();
        O(false);
    }

    public final void M() {
        this.f16181k = false;
        this.f16182l = false;
        s();
        e.a();
        O(false);
        N(102);
    }

    public void N(int i10) {
        if (this.f16175e != null) {
            Message obtain = Message.obtain();
            obtain.what = i10;
            this.f16175e.sendMessage(obtain);
        }
    }

    public void O(boolean z10) {
        this.f16180j = z10;
    }

    public synchronized void P(int i10) {
        try {
            this.f16179i = i10;
            C0947b.a("set currentProgress = " + i10, 1);
            if (i10 > 0) {
                U();
            } else {
                T();
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public void Q(Handler handler) {
        this.f16175e = handler;
    }

    public void R(BluetoothDevice bluetoothDevice) {
        this.f16176f = bluetoothDevice;
        this.f16171a.b(bluetoothDevice);
    }

    public void S(boolean z10) {
        this.f16183m = z10;
    }

    public void T() {
        if (!I()) {
            N(1000);
        }
    }

    public void U() {
        if (this.f16175e != null && !I()) {
            N(1001);
            C0947b.a("send message in uiProgressUpdate and current process is" + this.f16179i, 1);
        }
    }

    public void q() {
        new Thread(new a()).start();
    }

    public final void r() {
        WorkerState workerState = WorkerState.WORKING;
    }

    public final void s() {
        this.f16178h = 0;
        D();
        H();
    }

    public void t() {
        c cVar = new c();
        this.f16173c = cVar;
        cVar.start();
    }

    public int u() {
        return this.f16179i;
    }

    public BluetoothDevice v() {
        return this.f16176f;
    }

    public Handler w() {
        return this.f16175e;
    }

    public Intent x(Context context) {
        String str = v().getAddress().replace(":", "-") + ".vcf";
        Intent intent = new Intent("oplus.intent.action.importiphone_vcard");
        intent.putExtra("device_name", v().getName());
        intent.putExtra("android.intent.extra.STREAM", context.getFilesDir() + "/" + str);
        return intent;
    }

    public void z() {
        O(false);
        b bVar = new b();
        this.f16174d = bVar;
        bVar.start();
    }

    public ClientControler() {
        this.f16173c = null;
        this.f16174d = null;
        this.f16175e = null;
        this.f16176f = null;
        this.f16177g = new C0947b();
        this.f16178h = 0;
        this.f16179i = 0;
        this.f16180j = false;
        this.f16181k = false;
        this.f16182l = false;
        this.f16183m = false;
        this.f16184n = null;
        this.f16171a = new C0548b();
        this.f16172b = new i();
    }
}
