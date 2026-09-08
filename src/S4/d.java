package S4;

import java.util.List;

/* compiled from: DecoderResult.java */
/* loaded from: classes3.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public final byte[] f3493a;

    /* renamed from: b, reason: collision with root package name */
    public int f3494b;

    /* renamed from: c, reason: collision with root package name */
    public final String f3495c;

    /* renamed from: d, reason: collision with root package name */
    public final List<byte[]> f3496d;

    /* renamed from: e, reason: collision with root package name */
    public final String f3497e;

    /* renamed from: f, reason: collision with root package name */
    public Integer f3498f;

    /* renamed from: g, reason: collision with root package name */
    public Integer f3499g;

    /* renamed from: h, reason: collision with root package name */
    public Object f3500h;

    /* renamed from: i, reason: collision with root package name */
    public final int f3501i;

    /* renamed from: j, reason: collision with root package name */
    public final int f3502j;

    public d(byte[] bArr, String str, List<byte[]> list, String str2) {
        this(bArr, str, list, str2, -1, -1);
    }

    public List<byte[]> a() {
        return this.f3496d;
    }

    public String b() {
        return this.f3497e;
    }

    public int c() {
        return this.f3494b;
    }

    public Object d() {
        return this.f3500h;
    }

    public byte[] e() {
        return this.f3493a;
    }

    public int f() {
        return this.f3501i;
    }

    public int g() {
        return this.f3502j;
    }

    public String h() {
        return this.f3495c;
    }

    public boolean i() {
        if (this.f3501i >= 0 && this.f3502j >= 0) {
            return true;
        }
        return false;
    }

    public void j(Integer num) {
        this.f3499g = num;
    }

    public void k(Integer num) {
        this.f3498f = num;
    }

    public void l(int i10) {
        this.f3494b = i10;
    }

    public void m(Object obj) {
        this.f3500h = obj;
    }

    public d(byte[] bArr, String str, List<byte[]> list, String str2, int i10, int i11) {
        this.f3493a = bArr;
        this.f3494b = bArr == null ? 0 : bArr.length * 8;
        this.f3495c = str;
        this.f3496d = list;
        this.f3497e = str2;
        this.f3501i = i11;
        this.f3502j = i10;
    }
}
