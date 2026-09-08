package P4;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.ResultMetadataType;
import java.util.EnumMap;
import java.util.Map;

/* compiled from: Result.java */
/* loaded from: classes3.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    public final String f2949a;

    /* renamed from: b, reason: collision with root package name */
    public final byte[] f2950b;

    /* renamed from: c, reason: collision with root package name */
    public final int f2951c;

    /* renamed from: d, reason: collision with root package name */
    public g[] f2952d;

    /* renamed from: e, reason: collision with root package name */
    public final BarcodeFormat f2953e;

    /* renamed from: f, reason: collision with root package name */
    public Map<ResultMetadataType, Object> f2954f;

    /* renamed from: g, reason: collision with root package name */
    public final long f2955g;

    public f(String str, byte[] bArr, g[] gVarArr, BarcodeFormat barcodeFormat) {
        this(str, bArr, gVarArr, barcodeFormat, System.currentTimeMillis());
    }

    public void a(g[] gVarArr) {
        g[] gVarArr2 = this.f2952d;
        if (gVarArr2 == null) {
            this.f2952d = gVarArr;
            return;
        }
        if (gVarArr != null && gVarArr.length > 0) {
            g[] gVarArr3 = new g[gVarArr2.length + gVarArr.length];
            System.arraycopy(gVarArr2, 0, gVarArr3, 0, gVarArr2.length);
            System.arraycopy(gVarArr, 0, gVarArr3, gVarArr2.length, gVarArr.length);
            this.f2952d = gVarArr3;
        }
    }

    public BarcodeFormat b() {
        return this.f2953e;
    }

    public byte[] c() {
        return this.f2950b;
    }

    public Map<ResultMetadataType, Object> d() {
        return this.f2954f;
    }

    public g[] e() {
        return this.f2952d;
    }

    public String f() {
        return this.f2949a;
    }

    public void g(Map<ResultMetadataType, Object> map) {
        if (map != null) {
            Map<ResultMetadataType, Object> map2 = this.f2954f;
            if (map2 == null) {
                this.f2954f = map;
            } else {
                map2.putAll(map);
            }
        }
    }

    public void h(ResultMetadataType resultMetadataType, Object obj) {
        if (this.f2954f == null) {
            this.f2954f = new EnumMap(ResultMetadataType.class);
        }
        this.f2954f.put(resultMetadataType, obj);
    }

    public String toString() {
        return this.f2949a;
    }

    public f(String str, byte[] bArr, g[] gVarArr, BarcodeFormat barcodeFormat, long j10) {
        this(str, bArr, bArr == null ? 0 : bArr.length * 8, gVarArr, barcodeFormat, j10);
    }

    public f(String str, byte[] bArr, int i10, g[] gVarArr, BarcodeFormat barcodeFormat, long j10) {
        this.f2949a = str;
        this.f2950b = bArr;
        this.f2951c = i10;
        this.f2952d = gVarArr;
        this.f2953e = barcodeFormat;
        this.f2954f = null;
        this.f2955g = j10;
    }
}
