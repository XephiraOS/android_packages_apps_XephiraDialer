package W2;

import W2.a;
import android.graphics.Bitmap;
import com.heytap.accessory.constant.FastPairConstants;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;
import java.util.Iterator;

/* compiled from: StandardGifDecoder.java */
/* loaded from: classes.dex */
public class e implements a {

    /* renamed from: u, reason: collision with root package name */
    public static final String f4167u = "e";

    /* renamed from: a, reason: collision with root package name */
    public int[] f4168a;

    /* renamed from: b, reason: collision with root package name */
    public final int[] f4169b;

    /* renamed from: c, reason: collision with root package name */
    public final a.InterfaceC0079a f4170c;

    /* renamed from: d, reason: collision with root package name */
    public ByteBuffer f4171d;

    /* renamed from: e, reason: collision with root package name */
    public byte[] f4172e;

    /* renamed from: f, reason: collision with root package name */
    public short[] f4173f;

    /* renamed from: g, reason: collision with root package name */
    public byte[] f4174g;

    /* renamed from: h, reason: collision with root package name */
    public byte[] f4175h;

    /* renamed from: i, reason: collision with root package name */
    public byte[] f4176i;

    /* renamed from: j, reason: collision with root package name */
    public int[] f4177j;

    /* renamed from: k, reason: collision with root package name */
    public int f4178k;

    /* renamed from: l, reason: collision with root package name */
    public c f4179l;

    /* renamed from: m, reason: collision with root package name */
    public Bitmap f4180m;

    /* renamed from: n, reason: collision with root package name */
    public boolean f4181n;

    /* renamed from: o, reason: collision with root package name */
    public int f4182o;

    /* renamed from: p, reason: collision with root package name */
    public int f4183p;

    /* renamed from: q, reason: collision with root package name */
    public int f4184q;

    /* renamed from: r, reason: collision with root package name */
    public int f4185r;

    /* renamed from: s, reason: collision with root package name */
    public Boolean f4186s;

    /* renamed from: t, reason: collision with root package name */
    public Bitmap.Config f4187t;

    public e(a.InterfaceC0079a interfaceC0079a, c cVar, ByteBuffer byteBuffer, int i10) {
        this(interfaceC0079a);
        r(cVar, byteBuffer, i10);
    }

    @Override // W2.a
    public void a() {
        this.f4178k = (this.f4178k + 1) % this.f4179l.f4152c;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x004e A[Catch: all -> 0x000e, TryCatch #0 {all -> 0x000e, blocks: (B:3:0x0001, B:5:0x0009, B:8:0x003d, B:13:0x0047, B:15:0x004e, B:16:0x0058, B:18:0x0069, B:19:0x0075, B:22:0x007e, B:24:0x0082, B:26:0x008a, B:27:0x00a0, B:31:0x00a4, B:33:0x00a8, B:35:0x00ba, B:37:0x00be, B:38:0x00c2, B:41:0x007a, B:43:0x00c8, B:45:0x00d0, B:48:0x0011, B:50:0x0019, B:51:0x003b), top: B:2:0x0001 }] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0069 A[Catch: all -> 0x000e, TryCatch #0 {all -> 0x000e, blocks: (B:3:0x0001, B:5:0x0009, B:8:0x003d, B:13:0x0047, B:15:0x004e, B:16:0x0058, B:18:0x0069, B:19:0x0075, B:22:0x007e, B:24:0x0082, B:26:0x008a, B:27:0x00a0, B:31:0x00a4, B:33:0x00a8, B:35:0x00ba, B:37:0x00be, B:38:0x00c2, B:41:0x007a, B:43:0x00c8, B:45:0x00d0, B:48:0x0011, B:50:0x0019, B:51:0x003b), top: B:2:0x0001 }] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0082 A[Catch: all -> 0x000e, TryCatch #0 {all -> 0x000e, blocks: (B:3:0x0001, B:5:0x0009, B:8:0x003d, B:13:0x0047, B:15:0x004e, B:16:0x0058, B:18:0x0069, B:19:0x0075, B:22:0x007e, B:24:0x0082, B:26:0x008a, B:27:0x00a0, B:31:0x00a4, B:33:0x00a8, B:35:0x00ba, B:37:0x00be, B:38:0x00c2, B:41:0x007a, B:43:0x00c8, B:45:0x00d0, B:48:0x0011, B:50:0x0019, B:51:0x003b), top: B:2:0x0001 }] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00a4 A[Catch: all -> 0x000e, TRY_ENTER, TryCatch #0 {all -> 0x000e, blocks: (B:3:0x0001, B:5:0x0009, B:8:0x003d, B:13:0x0047, B:15:0x004e, B:16:0x0058, B:18:0x0069, B:19:0x0075, B:22:0x007e, B:24:0x0082, B:26:0x008a, B:27:0x00a0, B:31:0x00a4, B:33:0x00a8, B:35:0x00ba, B:37:0x00be, B:38:0x00c2, B:41:0x007a, B:43:0x00c8, B:45:0x00d0, B:48:0x0011, B:50:0x0019, B:51:0x003b), top: B:2:0x0001 }] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x007a A[Catch: all -> 0x000e, TryCatch #0 {all -> 0x000e, blocks: (B:3:0x0001, B:5:0x0009, B:8:0x003d, B:13:0x0047, B:15:0x004e, B:16:0x0058, B:18:0x0069, B:19:0x0075, B:22:0x007e, B:24:0x0082, B:26:0x008a, B:27:0x00a0, B:31:0x00a4, B:33:0x00a8, B:35:0x00ba, B:37:0x00be, B:38:0x00c2, B:41:0x007a, B:43:0x00c8, B:45:0x00d0, B:48:0x0011, B:50:0x0019, B:51:0x003b), top: B:2:0x0001 }] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0074  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00d0 A[Catch: all -> 0x000e, TRY_LEAVE, TryCatch #0 {all -> 0x000e, blocks: (B:3:0x0001, B:5:0x0009, B:8:0x003d, B:13:0x0047, B:15:0x004e, B:16:0x0058, B:18:0x0069, B:19:0x0075, B:22:0x007e, B:24:0x0082, B:26:0x008a, B:27:0x00a0, B:31:0x00a4, B:33:0x00a8, B:35:0x00ba, B:37:0x00be, B:38:0x00c2, B:41:0x007a, B:43:0x00c8, B:45:0x00d0, B:48:0x0011, B:50:0x0019, B:51:0x003b), top: B:2:0x0001 }] */
    @Override // W2.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public synchronized android.graphics.Bitmap b() {
        /*
            Method dump skipped, instructions count: 234
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: W2.e.b():android.graphics.Bitmap");
    }

    @Override // W2.a
    public int c() {
        return this.f4179l.f4152c;
    }

    @Override // W2.a
    public void clear() {
        this.f4179l = null;
        byte[] bArr = this.f4176i;
        if (bArr != null) {
            this.f4170c.d(bArr);
        }
        int[] iArr = this.f4177j;
        if (iArr != null) {
            this.f4170c.f(iArr);
        }
        Bitmap bitmap = this.f4180m;
        if (bitmap != null) {
            this.f4170c.c(bitmap);
        }
        this.f4180m = null;
        this.f4171d = null;
        this.f4186s = null;
        byte[] bArr2 = this.f4172e;
        if (bArr2 != null) {
            this.f4170c.d(bArr2);
        }
    }

    @Override // W2.a
    public int d() {
        int i10;
        if (this.f4179l.f4152c > 0 && (i10 = this.f4178k) >= 0) {
            return n(i10);
        }
        return 0;
    }

    @Override // W2.a
    public void e(Bitmap.Config config) {
        Bitmap.Config config2;
        Bitmap.Config config3 = Bitmap.Config.ARGB_8888;
        if (config != config3 && config != (config2 = Bitmap.Config.RGB_565)) {
            throw new IllegalArgumentException("Unsupported format: " + config + ", must be one of " + config3 + " or " + config2);
        }
        this.f4187t = config;
    }

    @Override // W2.a
    public ByteBuffer f() {
        return this.f4171d;
    }

    @Override // W2.a
    public void g() {
        this.f4178k = -1;
    }

    @Override // W2.a
    public int h() {
        return this.f4178k;
    }

    @Override // W2.a
    public int i() {
        return this.f4171d.limit() + this.f4176i.length + (this.f4177j.length * 4);
    }

    public final int j(int i10, int i11, int i12) {
        int i13 = 0;
        int i14 = 0;
        int i15 = 0;
        int i16 = 0;
        int i17 = 0;
        for (int i18 = i10; i18 < this.f4183p + i10; i18++) {
            byte[] bArr = this.f4176i;
            if (i18 >= bArr.length || i18 >= i11) {
                break;
            }
            int i19 = this.f4168a[bArr[i18] & FastPairConstants.GO_INTENT_NOT_SET];
            if (i19 != 0) {
                i13 += (i19 >> 24) & 255;
                i14 += (i19 >> 16) & 255;
                i15 += (i19 >> 8) & 255;
                i16 += i19 & 255;
                i17++;
            }
        }
        int i20 = i10 + i12;
        for (int i21 = i20; i21 < this.f4183p + i20; i21++) {
            byte[] bArr2 = this.f4176i;
            if (i21 >= bArr2.length || i21 >= i11) {
                break;
            }
            int i22 = this.f4168a[bArr2[i21] & FastPairConstants.GO_INTENT_NOT_SET];
            if (i22 != 0) {
                i13 += (i22 >> 24) & 255;
                i14 += (i22 >> 16) & 255;
                i15 += (i22 >> 8) & 255;
                i16 += i22 & 255;
                i17++;
            }
        }
        if (i17 == 0) {
            return 0;
        }
        return ((i13 / i17) << 24) | ((i14 / i17) << 16) | ((i15 / i17) << 8) | (i16 / i17);
    }

    public final void k(b bVar) {
        boolean z10;
        boolean booleanValue;
        int i10;
        int i11;
        boolean z11;
        int i12;
        int i13;
        int i14;
        int[] iArr = this.f4177j;
        int i15 = bVar.f4142d;
        int i16 = this.f4183p;
        int i17 = i15 / i16;
        int i18 = bVar.f4140b / i16;
        int i19 = bVar.f4141c / i16;
        int i20 = bVar.f4139a / i16;
        if (this.f4178k == 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        int i21 = this.f4185r;
        int i22 = this.f4184q;
        byte[] bArr = this.f4176i;
        int[] iArr2 = this.f4168a;
        Boolean bool = this.f4186s;
        int i23 = 8;
        int i24 = 0;
        int i25 = 0;
        int i26 = 1;
        while (i25 < i17) {
            Boolean bool2 = bool;
            if (bVar.f4143e) {
                if (i24 >= i17) {
                    int i27 = i26 + 1;
                    i10 = i17;
                    if (i27 != 2) {
                        if (i27 != 3) {
                            if (i27 == 4) {
                                i26 = i27;
                                i24 = 1;
                                i23 = 2;
                            }
                        } else {
                            i23 = 4;
                            i26 = i27;
                            i24 = 2;
                        }
                    } else {
                        i24 = 4;
                    }
                    i26 = i27;
                } else {
                    i10 = i17;
                }
                i11 = i24 + i23;
            } else {
                i10 = i17;
                i11 = i24;
                i24 = i25;
            }
            int i28 = i24 + i18;
            if (i16 == 1) {
                z11 = true;
            } else {
                z11 = false;
            }
            if (i28 < i22) {
                int i29 = i28 * i21;
                int i30 = i29 + i20;
                int i31 = i30 + i19;
                int i32 = i29 + i21;
                if (i32 < i31) {
                    i31 = i32;
                }
                i12 = i11;
                int i33 = i25 * i16 * bVar.f4141c;
                if (z11) {
                    int i34 = i30;
                    while (i34 < i31) {
                        int i35 = i18;
                        int i36 = iArr2[bArr[i33] & FastPairConstants.GO_INTENT_NOT_SET];
                        if (i36 != 0) {
                            iArr[i34] = i36;
                        } else if (z10 && bool2 == null) {
                            bool2 = Boolean.TRUE;
                        }
                        i33 += i16;
                        i34++;
                        i18 = i35;
                    }
                } else {
                    i14 = i18;
                    int i37 = ((i31 - i30) * i16) + i33;
                    int i38 = i30;
                    while (true) {
                        i13 = i19;
                        if (i38 >= i31) {
                            break;
                        }
                        int j10 = j(i33, i37, bVar.f4141c);
                        if (j10 != 0) {
                            iArr[i38] = j10;
                        } else if (z10 && bool2 == null) {
                            bool2 = Boolean.TRUE;
                        }
                        i33 += i16;
                        i38++;
                        i19 = i13;
                    }
                    bool = bool2;
                    i25++;
                    i18 = i14;
                    i17 = i10;
                    i19 = i13;
                    i24 = i12;
                }
            } else {
                i12 = i11;
            }
            i14 = i18;
            i13 = i19;
            bool = bool2;
            i25++;
            i18 = i14;
            i17 = i10;
            i19 = i13;
            i24 = i12;
        }
        Boolean bool3 = bool;
        if (this.f4186s == null) {
            if (bool3 == null) {
                booleanValue = false;
            } else {
                booleanValue = bool3.booleanValue();
            }
            this.f4186s = Boolean.valueOf(booleanValue);
        }
    }

    public final void l(b bVar) {
        boolean z10;
        boolean z11;
        b bVar2 = bVar;
        int[] iArr = this.f4177j;
        int i10 = bVar2.f4142d;
        int i11 = bVar2.f4140b;
        int i12 = bVar2.f4141c;
        int i13 = bVar2.f4139a;
        if (this.f4178k == 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        int i14 = this.f4185r;
        byte[] bArr = this.f4176i;
        int[] iArr2 = this.f4168a;
        int i15 = 0;
        byte b10 = -1;
        while (i15 < i10) {
            int i16 = (i15 + i11) * i14;
            int i17 = i16 + i13;
            int i18 = i17 + i12;
            int i19 = i16 + i14;
            if (i19 < i18) {
                i18 = i19;
            }
            int i20 = bVar2.f4141c * i15;
            int i21 = i17;
            while (i21 < i18) {
                byte b11 = bArr[i20];
                int i22 = i10;
                int i23 = b11 & FastPairConstants.GO_INTENT_NOT_SET;
                if (i23 != b10) {
                    int i24 = iArr2[i23];
                    if (i24 != 0) {
                        iArr[i21] = i24;
                    } else {
                        b10 = b11;
                    }
                }
                i20++;
                i21++;
                i10 = i22;
            }
            i15++;
            bVar2 = bVar;
        }
        Boolean bool = this.f4186s;
        if ((bool != null && bool.booleanValue()) || (this.f4186s == null && z10 && b10 != -1)) {
            z11 = true;
        } else {
            z11 = false;
        }
        this.f4186s = Boolean.valueOf(z11);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v10 */
    /* JADX WARN: Type inference failed for: r7v11 */
    /* JADX WARN: Type inference failed for: r7v12 */
    /* JADX WARN: Type inference failed for: r7v15, types: [short] */
    /* JADX WARN: Type inference failed for: r7v17 */
    public final void m(b bVar) {
        int i10;
        int i11;
        short s10;
        e eVar = this;
        if (bVar != null) {
            eVar.f4171d.position(bVar.f4148j);
        }
        if (bVar == null) {
            c cVar = eVar.f4179l;
            i10 = cVar.f4155f;
            i11 = cVar.f4156g;
        } else {
            i10 = bVar.f4141c;
            i11 = bVar.f4142d;
        }
        int i12 = i10 * i11;
        byte[] bArr = eVar.f4176i;
        if (bArr == null || bArr.length < i12) {
            eVar.f4176i = eVar.f4170c.e(i12);
        }
        byte[] bArr2 = eVar.f4176i;
        if (eVar.f4173f == null) {
            eVar.f4173f = new short[4096];
        }
        short[] sArr = eVar.f4173f;
        if (eVar.f4174g == null) {
            eVar.f4174g = new byte[4096];
        }
        byte[] bArr3 = eVar.f4174g;
        if (eVar.f4175h == null) {
            eVar.f4175h = new byte[4097];
        }
        byte[] bArr4 = eVar.f4175h;
        int q10 = q();
        int i13 = 1 << q10;
        int i14 = i13 + 1;
        int i15 = i13 + 2;
        int i16 = q10 + 1;
        int i17 = (1 << i16) - 1;
        int i18 = 0;
        for (int i19 = 0; i19 < i13; i19++) {
            sArr[i19] = 0;
            bArr3[i19] = (byte) i19;
        }
        byte[] bArr5 = eVar.f4172e;
        int i20 = i16;
        int i21 = i15;
        int i22 = i17;
        int i23 = 0;
        int i24 = 0;
        int i25 = 0;
        int i26 = 0;
        int i27 = 0;
        int i28 = 0;
        int i29 = 0;
        int i30 = -1;
        while (true) {
            if (i18 >= i12) {
                break;
            }
            if (i23 == 0) {
                i23 = p();
                if (i23 <= 0) {
                    eVar.f4182o = 3;
                    break;
                }
                i24 = 0;
            }
            i26 += (bArr5[i24] & FastPairConstants.GO_INTENT_NOT_SET) << i25;
            i24++;
            i23--;
            int i31 = i25 + 8;
            int i32 = i21;
            int i33 = i20;
            int i34 = i30;
            int i35 = i16;
            int i36 = i28;
            while (true) {
                if (i31 >= i33) {
                    int i37 = i15;
                    int i38 = i26 & i22;
                    i26 >>= i33;
                    i31 -= i33;
                    if (i38 == i13) {
                        i22 = i17;
                        i33 = i35;
                        i32 = i37;
                        i15 = i32;
                        i34 = -1;
                    } else {
                        if (i38 == i14) {
                            i25 = i31;
                            i28 = i36;
                            i21 = i32;
                            i16 = i35;
                            i15 = i37;
                            i30 = i34;
                            i20 = i33;
                            eVar = this;
                            break;
                        }
                        if (i34 == -1) {
                            bArr2[i27] = bArr3[i38];
                            i27++;
                            i18++;
                            i34 = i38;
                            i36 = i34;
                            i15 = i37;
                            i31 = i31;
                        } else {
                            if (i38 >= i32) {
                                bArr4[i29] = (byte) i36;
                                i29++;
                                s10 = i34;
                            } else {
                                s10 = i38;
                            }
                            while (s10 >= i13) {
                                bArr4[i29] = bArr3[s10];
                                i29++;
                                s10 = sArr[s10];
                            }
                            i36 = bArr3[s10] & FastPairConstants.GO_INTENT_NOT_SET;
                            byte b10 = (byte) i36;
                            bArr2[i27] = b10;
                            while (true) {
                                i27++;
                                i18++;
                                if (i29 <= 0) {
                                    break;
                                }
                                i29--;
                                bArr2[i27] = bArr4[i29];
                            }
                            byte[] bArr6 = bArr4;
                            if (i32 < 4096) {
                                sArr[i32] = (short) i34;
                                bArr3[i32] = b10;
                                i32++;
                                if ((i32 & i22) == 0 && i32 < 4096) {
                                    i33++;
                                    i22 += i32;
                                }
                            }
                            i34 = i38;
                            i15 = i37;
                            i31 = i31;
                            bArr4 = bArr6;
                        }
                    }
                } else {
                    i30 = i34;
                    i21 = i32;
                    i25 = i31;
                    eVar = this;
                    i28 = i36;
                    i16 = i35;
                    i20 = i33;
                    break;
                }
            }
        }
        Arrays.fill(bArr2, i27, i12, (byte) 0);
    }

    public int n(int i10) {
        if (i10 >= 0) {
            c cVar = this.f4179l;
            if (i10 < cVar.f4152c) {
                return cVar.f4154e.get(i10).f4147i;
            }
        }
        return -1;
    }

    public final Bitmap o() {
        Bitmap.Config config;
        Boolean bool = this.f4186s;
        if (bool != null && !bool.booleanValue()) {
            config = this.f4187t;
        } else {
            config = Bitmap.Config.ARGB_8888;
        }
        Bitmap a10 = this.f4170c.a(this.f4185r, this.f4184q, config);
        a10.setHasAlpha(true);
        return a10;
    }

    public final int p() {
        int q10 = q();
        if (q10 <= 0) {
            return q10;
        }
        ByteBuffer byteBuffer = this.f4171d;
        byteBuffer.get(this.f4172e, 0, Math.min(q10, byteBuffer.remaining()));
        return q10;
    }

    public final int q() {
        return this.f4171d.get() & FastPairConstants.GO_INTENT_NOT_SET;
    }

    public synchronized void r(c cVar, ByteBuffer byteBuffer, int i10) {
        try {
            if (i10 > 0) {
                int highestOneBit = Integer.highestOneBit(i10);
                this.f4182o = 0;
                this.f4179l = cVar;
                this.f4178k = -1;
                ByteBuffer asReadOnlyBuffer = byteBuffer.asReadOnlyBuffer();
                this.f4171d = asReadOnlyBuffer;
                asReadOnlyBuffer.position(0);
                this.f4171d.order(ByteOrder.LITTLE_ENDIAN);
                this.f4181n = false;
                Iterator<b> it = cVar.f4154e.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    } else if (it.next().f4145g == 3) {
                        this.f4181n = true;
                        break;
                    }
                }
                this.f4183p = highestOneBit;
                int i11 = cVar.f4155f;
                this.f4185r = i11 / highestOneBit;
                int i12 = cVar.f4156g;
                this.f4184q = i12 / highestOneBit;
                this.f4176i = this.f4170c.e(i11 * i12);
                this.f4177j = this.f4170c.b(this.f4185r * this.f4184q);
            } else {
                throw new IllegalArgumentException("Sample size must be >=0, not: " + i10);
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public final Bitmap s(b bVar, b bVar2) {
        int i10;
        int i11;
        Bitmap bitmap;
        int[] iArr = this.f4177j;
        int i12 = 0;
        if (bVar2 == null) {
            Bitmap bitmap2 = this.f4180m;
            if (bitmap2 != null) {
                this.f4170c.c(bitmap2);
            }
            this.f4180m = null;
            Arrays.fill(iArr, 0);
        }
        if (bVar2 != null && bVar2.f4145g == 3 && this.f4180m == null) {
            Arrays.fill(iArr, 0);
        }
        if (bVar2 != null && (i11 = bVar2.f4145g) > 0) {
            if (i11 == 2) {
                if (!bVar.f4144f) {
                    c cVar = this.f4179l;
                    int i13 = cVar.f4161l;
                    if (bVar.f4149k == null || cVar.f4159j != bVar.f4146h) {
                        i12 = i13;
                    }
                }
                int i14 = bVar2.f4142d;
                int i15 = this.f4183p;
                int i16 = i14 / i15;
                int i17 = bVar2.f4140b / i15;
                int i18 = bVar2.f4141c / i15;
                int i19 = bVar2.f4139a / i15;
                int i20 = this.f4185r;
                int i21 = (i17 * i20) + i19;
                int i22 = (i16 * i20) + i21;
                while (i21 < i22) {
                    int i23 = i21 + i18;
                    for (int i24 = i21; i24 < i23; i24++) {
                        iArr[i24] = i12;
                    }
                    i21 += this.f4185r;
                }
            } else if (i11 == 3 && (bitmap = this.f4180m) != null) {
                int i25 = this.f4185r;
                bitmap.getPixels(iArr, 0, i25, 0, 0, i25, this.f4184q);
            }
        }
        m(bVar);
        if (!bVar.f4143e && this.f4183p == 1) {
            l(bVar);
        } else {
            k(bVar);
        }
        if (this.f4181n && ((i10 = bVar.f4145g) == 0 || i10 == 1)) {
            if (this.f4180m == null) {
                this.f4180m = o();
            }
            Bitmap bitmap3 = this.f4180m;
            int i26 = this.f4185r;
            bitmap3.setPixels(iArr, 0, i26, 0, 0, i26, this.f4184q);
        }
        Bitmap o10 = o();
        int i27 = this.f4185r;
        o10.setPixels(iArr, 0, i27, 0, 0, i27, this.f4184q);
        return o10;
    }

    public e(a.InterfaceC0079a interfaceC0079a) {
        this.f4169b = new int[256];
        this.f4187t = Bitmap.Config.ARGB_8888;
        this.f4170c = interfaceC0079a;
        this.f4179l = new c();
    }
}
