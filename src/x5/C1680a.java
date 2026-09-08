package x5;

import com.color.oshare.ColorOshareDevice;
import com.oplus.oshare.OplusOshareDevice;

/* compiled from: OplusOshareDevice.java */
/* renamed from: x5.a, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C1680a {

    /* renamed from: a, reason: collision with root package name */
    public OplusOshareDevice f37999a;

    /* renamed from: b, reason: collision with root package name */
    public ColorOshareDevice f38000b;

    public C1680a(OplusOshareDevice oplusOshareDevice) {
        this.f37999a = oplusOshareDevice;
    }

    public boolean equals(Object obj) {
        if (A5.a.b()) {
            return this.f37999a.equals(obj);
        }
        return this.f38000b.equals(obj);
    }

    public String toString() {
        if (A5.a.b()) {
            return this.f37999a.toString();
        }
        return this.f38000b.toString();
    }
}
