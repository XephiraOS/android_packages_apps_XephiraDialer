package a1;

import com.coui.appcompat.vibrateutil.VibrateUtils;
import com.heytap.accessory.constant.FastPairConstants;
import java.io.ByteArrayOutputStream;
import java.security.SecureRandom;
import java.util.Calendar;

/* compiled from: HeaderSet.java */
/* renamed from: a1.f, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0415f {

    /* renamed from: a, reason: collision with root package name */
    public Long f6304a;

    /* renamed from: b, reason: collision with root package name */
    public Byte f6305b;

    /* renamed from: c, reason: collision with root package name */
    public String f6306c;

    /* renamed from: d, reason: collision with root package name */
    public String f6307d;

    /* renamed from: e, reason: collision with root package name */
    public String f6308e;

    /* renamed from: f, reason: collision with root package name */
    public Long f6309f;

    /* renamed from: g, reason: collision with root package name */
    public Long f6310g;

    /* renamed from: h, reason: collision with root package name */
    public Calendar f6311h;

    /* renamed from: i, reason: collision with root package name */
    public Calendar f6312i;

    /* renamed from: j, reason: collision with root package name */
    public String f6313j;

    /* renamed from: k, reason: collision with root package name */
    public byte[] f6314k;

    /* renamed from: l, reason: collision with root package name */
    public byte[] f6315l;

    /* renamed from: m, reason: collision with root package name */
    public byte[] f6316m;

    /* renamed from: n, reason: collision with root package name */
    public byte[] f6317n;

    /* renamed from: o, reason: collision with root package name */
    public byte[] f6318o;

    /* renamed from: u, reason: collision with root package name */
    public Byte f6324u;

    /* renamed from: v, reason: collision with root package name */
    public Byte f6325v;

    /* renamed from: w, reason: collision with root package name */
    public byte[] f6326w;

    /* renamed from: x, reason: collision with root package name */
    public byte[] f6327x;

    /* renamed from: y, reason: collision with root package name */
    public byte[] f6328y;

    /* renamed from: z, reason: collision with root package name */
    public byte[] f6329z;

    /* renamed from: p, reason: collision with root package name */
    public String[] f6319p = new String[16];

    /* renamed from: q, reason: collision with root package name */
    public byte[][] f6320q = new byte[16];

    /* renamed from: r, reason: collision with root package name */
    public Byte[] f6321r = new Byte[16];

    /* renamed from: s, reason: collision with root package name */
    public Long[] f6322s = new Long[16];

    /* renamed from: A, reason: collision with root package name */
    public int f6303A = -1;

    /* renamed from: t, reason: collision with root package name */
    public final SecureRandom f6323t = new SecureRandom();

    public Object a(int i10) {
        switch (i10) {
            case 1:
                return this.f6306c;
            case 5:
                return this.f6313j;
            case 21:
                return this.f6307d;
            case 66:
                return this.f6308e;
            case 68:
                return this.f6311h;
            case 70:
                return this.f6314k;
            case 71:
                return this.f6315l;
            case 74:
                return this.f6316m;
            case 76:
                return this.f6317n;
            case 79:
                return this.f6318o;
            case 148:
                return this.f6305b;
            case 151:
                return this.f6324u;
            case VibrateUtils.TYPE_STEPABLE_REGULATE /* 152 */:
                return this.f6325v;
            case 192:
                return this.f6304a;
            case 195:
                return this.f6309f;
            case 196:
                return this.f6312i;
            case 214:
                return this.f6310g;
            default:
                if (i10 >= 48 && i10 <= 63) {
                    return this.f6319p[i10 - 48];
                }
                if (i10 >= 112 && i10 <= 127) {
                    return this.f6320q[i10 - 112];
                }
                if (i10 >= 176 && i10 <= 191) {
                    return this.f6321r[i10 - 176];
                }
                if (i10 >= 240 && i10 <= 255) {
                    return this.f6322s[i10 - 240];
                }
                throw new IllegalArgumentException("Invalid Header Identifier");
        }
    }

    public int[] b() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        if (this.f6304a != null) {
            byteArrayOutputStream.write(192);
        }
        if (this.f6305b != null) {
            byteArrayOutputStream.write(148);
        }
        if (this.f6306c != null) {
            byteArrayOutputStream.write(1);
        }
        if (this.f6307d != null) {
            byteArrayOutputStream.write(21);
        }
        if (this.f6308e != null) {
            byteArrayOutputStream.write(66);
        }
        if (this.f6309f != null) {
            byteArrayOutputStream.write(195);
        }
        if (this.f6310g != null) {
            byteArrayOutputStream.write(214);
        }
        if (this.f6311h != null) {
            byteArrayOutputStream.write(68);
        }
        if (this.f6312i != null) {
            byteArrayOutputStream.write(196);
        }
        if (this.f6313j != null) {
            byteArrayOutputStream.write(5);
        }
        if (this.f6314k != null) {
            byteArrayOutputStream.write(70);
        }
        if (this.f6315l != null) {
            byteArrayOutputStream.write(71);
        }
        if (this.f6316m != null) {
            byteArrayOutputStream.write(74);
        }
        if (this.f6317n != null) {
            byteArrayOutputStream.write(76);
        }
        if (this.f6318o != null) {
            byteArrayOutputStream.write(79);
        }
        if (this.f6324u != null) {
            byteArrayOutputStream.write(151);
        }
        if (this.f6325v != null) {
            byteArrayOutputStream.write(VibrateUtils.TYPE_STEPABLE_REGULATE);
        }
        for (int i10 = 48; i10 < 64; i10++) {
            if (this.f6319p[i10 - 48] != null) {
                byteArrayOutputStream.write(i10);
            }
        }
        for (int i11 = 112; i11 < 128; i11++) {
            if (this.f6320q[i11 - 112] != null) {
                byteArrayOutputStream.write(i11);
            }
        }
        for (int i12 = 176; i12 < 192; i12++) {
            if (this.f6321r[i12 - 176] != null) {
                byteArrayOutputStream.write(i12);
            }
        }
        for (int i13 = 240; i13 < 256; i13++) {
            if (this.f6322s[i13 - 240] != null) {
                byteArrayOutputStream.write(i13);
            }
        }
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        byteArrayOutputStream.close();
        if (byteArray != null && byteArray.length != 0) {
            int[] iArr = new int[byteArray.length];
            for (int i14 = 0; i14 < byteArray.length; i14++) {
                iArr[i14] = byteArray[i14] & FastPairConstants.GO_INTENT_NOT_SET;
            }
            return iArr;
        }
        return null;
    }

    public void c(int i10, Object obj) {
        switch (i10) {
            case 1:
                if (obj != null && !(obj instanceof String)) {
                    throw new IllegalArgumentException("Name must be a String");
                }
                this.f6306c = (String) obj;
                return;
            case 5:
                if (obj != null && !(obj instanceof String)) {
                    throw new IllegalArgumentException("Description must be a String");
                }
                this.f6313j = (String) obj;
                return;
            case 21:
                if (obj != null && !(obj instanceof String)) {
                    throw new IllegalArgumentException("Name must be a String");
                }
                this.f6307d = (String) obj;
                return;
            case 66:
                if (obj != null && !(obj instanceof String)) {
                    throw new IllegalArgumentException("Type must be a String");
                }
                this.f6308e = (String) obj;
                return;
            case 68:
                if (obj != null && !(obj instanceof Calendar)) {
                    throw new IllegalArgumentException("Time ISO 8601 must be a Calendar");
                }
                this.f6311h = (Calendar) obj;
                return;
            case 70:
                if (obj == null) {
                    this.f6314k = null;
                    return;
                } else {
                    if (obj instanceof byte[]) {
                        byte[] bArr = new byte[((byte[]) obj).length];
                        this.f6314k = bArr;
                        System.arraycopy(obj, 0, bArr, 0, bArr.length);
                        return;
                    }
                    throw new IllegalArgumentException("Target must be a byte array");
                }
            case 71:
                if (obj == null) {
                    this.f6315l = null;
                    return;
                } else {
                    if (obj instanceof byte[]) {
                        byte[] bArr2 = new byte[((byte[]) obj).length];
                        this.f6315l = bArr2;
                        System.arraycopy(obj, 0, bArr2, 0, bArr2.length);
                        return;
                    }
                    throw new IllegalArgumentException("HTTP must be a byte array");
                }
            case 74:
                if (obj == null) {
                    this.f6316m = null;
                    return;
                } else {
                    if (obj instanceof byte[]) {
                        byte[] bArr3 = new byte[((byte[]) obj).length];
                        this.f6316m = bArr3;
                        System.arraycopy(obj, 0, bArr3, 0, bArr3.length);
                        return;
                    }
                    throw new IllegalArgumentException("WHO must be a byte array");
                }
            case 76:
                if (obj == null) {
                    this.f6317n = null;
                    return;
                } else {
                    if (obj instanceof byte[]) {
                        byte[] bArr4 = new byte[((byte[]) obj).length];
                        this.f6317n = bArr4;
                        System.arraycopy(obj, 0, bArr4, 0, bArr4.length);
                        return;
                    }
                    throw new IllegalArgumentException("Application Parameter must be a byte array");
                }
            case 79:
                if (obj == null) {
                    this.f6318o = null;
                    return;
                } else {
                    if (obj instanceof byte[]) {
                        byte[] bArr5 = new byte[((byte[]) obj).length];
                        this.f6318o = bArr5;
                        System.arraycopy(obj, 0, bArr5, 0, bArr5.length);
                        return;
                    }
                    throw new IllegalArgumentException("Object Class must be a byte array");
                }
            case 148:
                if (obj != null && !(obj instanceof Byte)) {
                    throw new IllegalArgumentException("Action Id must be a Byte");
                }
                this.f6305b = (Byte) obj;
                return;
            case 151:
                if (obj != null && !(obj instanceof Byte)) {
                    throw new IllegalArgumentException("Single Response Mode must be a Byte");
                }
                this.f6324u = (Byte) obj;
                return;
            case VibrateUtils.TYPE_STEPABLE_REGULATE /* 152 */:
                if (obj != null && !(obj instanceof Byte)) {
                    throw new IllegalArgumentException("Single Response Mode Parameter must be a Byte");
                }
                this.f6325v = (Byte) obj;
                return;
            case 192:
                if (!(obj instanceof Long)) {
                    if (obj == null) {
                        this.f6304a = null;
                        return;
                    }
                    throw new IllegalArgumentException("Count must be a Long");
                }
                Long l10 = (Long) obj;
                long longValue = l10.longValue();
                if (longValue >= 0 && longValue <= 4294967295L) {
                    this.f6304a = l10;
                    return;
                }
                throw new IllegalArgumentException("Count must be between 0 and 0xFFFFFFFF");
            case 195:
                break;
            case 196:
                if (obj != null && !(obj instanceof Calendar)) {
                    throw new IllegalArgumentException("Time 4 Byte must be a Calendar");
                }
                this.f6312i = (Calendar) obj;
                return;
            case 214:
                if (!(obj instanceof Long)) {
                    if (obj == null) {
                        this.f6310g = null;
                        return;
                    }
                    throw new IllegalArgumentException("Length must be a Long");
                }
                Long l11 = (Long) obj;
                long longValue2 = l11.longValue();
                if (longValue2 >= 0 && longValue2 <= 4294967295L) {
                    this.f6310g = l11;
                    break;
                } else {
                    throw new IllegalArgumentException("Length must be between 0 and 0xFFFFFFFF");
                }
            default:
                if (i10 >= 48 && i10 <= 63) {
                    if (obj != null && !(obj instanceof String)) {
                        throw new IllegalArgumentException("Unicode String User Defined must be a String");
                    }
                    this.f6319p[i10 - 48] = (String) obj;
                    return;
                }
                if (i10 >= 112 && i10 <= 127) {
                    if (obj == null) {
                        this.f6320q[i10 - 112] = null;
                        return;
                    } else {
                        if (obj instanceof byte[]) {
                            byte[] bArr6 = new byte[((byte[]) obj).length];
                            this.f6320q[i10 - 112] = bArr6;
                            System.arraycopy(obj, 0, bArr6, 0, bArr6.length);
                            return;
                        }
                        throw new IllegalArgumentException("Byte Sequence User Defined must be a byte array");
                    }
                }
                if (i10 >= 176 && i10 <= 191) {
                    if (obj != null && !(obj instanceof Byte)) {
                        throw new IllegalArgumentException("ByteUser Defined must be a Byte");
                    }
                    this.f6321r[i10 - 176] = (Byte) obj;
                    return;
                }
                if (i10 >= 240 && i10 <= 255) {
                    if (!(obj instanceof Long)) {
                        if (obj == null) {
                            this.f6322s[i10 - 240] = null;
                            return;
                        }
                        throw new IllegalArgumentException("Integer User Defined must be a Long");
                    }
                    Long l12 = (Long) obj;
                    long longValue3 = l12.longValue();
                    if (longValue3 >= 0 && longValue3 <= 4294967295L) {
                        this.f6322s[i10 - 240] = l12;
                        return;
                    }
                    throw new IllegalArgumentException("Integer User Defined must be between 0 and 0xFFFFFFFF");
                }
                throw new IllegalArgumentException("Invalid Header Identifier");
        }
        if (!(obj instanceof Long)) {
            if (obj == null) {
                this.f6309f = null;
                return;
            }
            throw new IllegalArgumentException("Length must be a Long");
        }
        Long l13 = (Long) obj;
        long longValue4 = l13.longValue();
        if (longValue4 >= 0 && longValue4 <= 4294967295L) {
            this.f6309f = l13;
            return;
        }
        throw new IllegalArgumentException("Length must be between 0 and 0xFFFFFFFF");
    }
}
