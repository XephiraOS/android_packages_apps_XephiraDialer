package e2;

import android.bluetooth.BluetoothDevice;
import com.android.incallui.R;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.i;

/* compiled from: AudioModeInfo.kt */
/* renamed from: e2.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0966a {

    /* renamed from: a, reason: collision with root package name */
    public final String f30571a;

    /* renamed from: b, reason: collision with root package name */
    public final int f30572b;

    /* renamed from: c, reason: collision with root package name */
    public final int f30573c;

    /* renamed from: d, reason: collision with root package name */
    public final int f30574d;

    /* renamed from: e, reason: collision with root package name */
    public final BluetoothDevice f30575e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f30576f;

    /* renamed from: g, reason: collision with root package name */
    public final boolean f30577g;

    public C0966a(String str, int i10, int i11, int i12, BluetoothDevice bluetoothDevice, boolean z10, boolean z11) {
        this.f30571a = str;
        this.f30572b = i10;
        this.f30573c = i11;
        this.f30574d = i12;
        this.f30575e = bluetoothDevice;
        this.f30576f = z10;
        this.f30577g = z11;
    }

    public final int a() {
        return this.f30574d;
    }

    public final BluetoothDevice b() {
        return this.f30575e;
    }

    public final boolean c() {
        return this.f30576f;
    }

    public final boolean d() {
        return this.f30577g;
    }

    public final int e() {
        return this.f30573c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C0966a)) {
            return false;
        }
        C0966a c0966a = (C0966a) obj;
        if (i.b(this.f30571a, c0966a.f30571a) && this.f30572b == c0966a.f30572b && this.f30573c == c0966a.f30573c && this.f30574d == c0966a.f30574d && i.b(this.f30575e, c0966a.f30575e) && this.f30576f == c0966a.f30576f && this.f30577g == c0966a.f30577g) {
            return true;
        }
        return false;
    }

    public final String f() {
        return this.f30571a;
    }

    public final int g() {
        return this.f30572b;
    }

    public final void h(boolean z10) {
        this.f30576f = z10;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode;
        String str = this.f30571a;
        int i10 = 0;
        if (str == null) {
            hashCode = 0;
        } else {
            hashCode = str.hashCode();
        }
        int hashCode2 = ((((((hashCode * 31) + Integer.hashCode(this.f30572b)) * 31) + Integer.hashCode(this.f30573c)) * 31) + Integer.hashCode(this.f30574d)) * 31;
        BluetoothDevice bluetoothDevice = this.f30575e;
        if (bluetoothDevice != null) {
            i10 = bluetoothDevice.hashCode();
        }
        int i11 = (hashCode2 + i10) * 31;
        boolean z10 = this.f30576f;
        int i12 = 1;
        int i13 = z10;
        if (z10 != 0) {
            i13 = 1;
        }
        int i14 = (i11 + i13) * 31;
        boolean z11 = this.f30577g;
        if (!z11) {
            i12 = z11 ? 1 : 0;
        }
        return i14 + i12;
    }

    public String toString() {
        return "AudioModeInfo(nameString=" + this.f30571a + ", nameStringResId=" + this.f30572b + ", iconResId=" + this.f30573c + ", audioRoute=" + this.f30574d + ", bluetoothDevice=" + this.f30575e + ", checkedState=" + this.f30576f + ", enableState=" + this.f30577g + ')';
    }

    public /* synthetic */ C0966a(String str, int i10, int i11, int i12, BluetoothDevice bluetoothDevice, boolean z10, boolean z11, int i13, f fVar) {
        this((i13 & 1) != 0 ? null : str, (i13 & 2) != 0 ? R.string.oplus_audio_mode : i10, i11, i12, (i13 & 16) != 0 ? null : bluetoothDevice, (i13 & 32) != 0 ? false : z10, (i13 & 64) != 0 ? true : z11);
    }
}
