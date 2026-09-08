package C7;

import com.oplus.os.OplusBuild;

/* compiled from: CompatUtils.kt */
/* loaded from: classes3.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public static final b f398a = new b();

    public static final boolean a(int i10, int i11) {
        int i12 = OplusBuild.VERSION.SDK_VERSION;
        if (i12 > i10) {
            return true;
        }
        if (i12 == i10 && OplusBuild.VERSION.SDK_SUB_VERSION >= i11) {
            return true;
        }
        return false;
    }

    public static final boolean b() {
        return true;
    }
}
