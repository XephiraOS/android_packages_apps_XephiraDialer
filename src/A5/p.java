package a5;

import com.google.zxing.ReaderException;

/* compiled from: UPCEANExtensionSupport.java */
/* loaded from: classes3.dex */
public final class p {

    /* renamed from: c, reason: collision with root package name */
    public static final int[] f6434c = {1, 1, 2};

    /* renamed from: a, reason: collision with root package name */
    public final n f6435a = new n();

    /* renamed from: b, reason: collision with root package name */
    public final o f6436b = new o();

    public P4.f a(int i10, S4.a aVar, int i11) {
        int[] m10 = q.m(aVar, i11, false, f6434c);
        try {
            return this.f6436b.b(i10, aVar, m10);
        } catch (ReaderException unused) {
            return this.f6435a.b(i10, aVar, m10);
        }
    }
}
