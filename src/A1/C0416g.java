package a1;

import com.android.incallui.OplusPhoneUtils;
import com.coui.appcompat.vibrateutil.VibrateUtils;
import com.heytap.accessory.constant.FastPairConstants;
import d1.C0947b;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

/* compiled from: ObexHelper.java */
/* renamed from: a1.g, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0416g {

    /* renamed from: e, reason: collision with root package name */
    public static final boolean f6330e = C0947b.f29928a;

    /* renamed from: f, reason: collision with root package name */
    public static final Byte f6331f = (byte) 0;

    /* renamed from: g, reason: collision with root package name */
    public static final Byte f6332g = (byte) 1;

    /* renamed from: h, reason: collision with root package name */
    public static final Byte f6333h = (byte) 2;

    /* renamed from: i, reason: collision with root package name */
    public static final Byte f6334i = (byte) 0;

    /* renamed from: j, reason: collision with root package name */
    public static final Byte f6335j = (byte) 1;

    /* renamed from: k, reason: collision with root package name */
    public static final Byte f6336k = (byte) 2;

    /* renamed from: l, reason: collision with root package name */
    public static final Byte f6337l = (byte) 1;

    /* renamed from: m, reason: collision with root package name */
    public static final Byte f6338m = Byte.valueOf(FastPairConstants.GO_INTENT_MAX);

    /* renamed from: a, reason: collision with root package name */
    public boolean f6339a = false;

    /* renamed from: b, reason: collision with root package name */
    public boolean f6340b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f6341c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f6342d;

    public static byte[] a(long j10) {
        return new byte[]{(byte) ((j10 >> 24) & 255), (byte) ((j10 >> 16) & 255), (byte) ((j10 >> 8) & 255), (byte) (j10 & 255)};
    }

    public static long b(byte[] bArr) {
        long j10 = 0;
        long j11 = 0;
        for (int length = bArr.length - 1; length >= 0; length--) {
            long j12 = bArr[length];
            if (j12 < 0) {
                j12 += 256;
            }
            j10 |= j12 << ((int) j11);
            j11 += 8;
        }
        return j10;
    }

    public static String c(byte[] bArr, boolean z10) {
        if (bArr != 0 && bArr.length != 0) {
            int length = bArr.length;
            if (length % 2 == 0) {
                int i10 = length >> 1;
                if (z10) {
                    i10--;
                }
                char[] cArr = new char[i10];
                for (int i11 = 0; i11 < i10; i11++) {
                    int i12 = i11 * 2;
                    int i13 = bArr[i12];
                    int i14 = bArr[i12 + 1];
                    if (i13 < 0) {
                        i13 += 256;
                    }
                    if (i14 < 0) {
                        i14 += 256;
                    }
                    if (i13 == 0 && i14 == 0) {
                        return new String(cArr, 0, i11);
                    }
                    cArr[i11] = (char) (i14 | (i13 << 8));
                }
                return new String(cArr);
            }
            throw new IllegalArgumentException("Byte array not of a valid form");
        }
        return null;
    }

    public static byte[] d(String str) {
        if (str == null) {
            return null;
        }
        char[] charArray = str.toCharArray();
        int length = charArray.length * 2;
        byte[] bArr = new byte[length + 2];
        for (int i10 = 0; i10 < charArray.length; i10++) {
            int i11 = i10 * 2;
            char c10 = charArray[i10];
            bArr[i11] = (byte) (c10 >> '\b');
            bArr[i11 + 1] = (byte) c10;
        }
        bArr[length] = 0;
        bArr[length + 1] = 0;
        return bArr;
    }

    public static byte[] e(C0415f c0415f, boolean z10) {
        byte[] bArr = new byte[2];
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            boolean z11 = f6330e;
            if (z11) {
                H7.b.c("ObexHelper", "createHeader = " + c0415f);
            }
            if (c0415f.f6329z != null && c0415f.a(70) == null) {
                if (z11) {
                    H7.b.c("ObexHelper", " Add Header = 203");
                }
                byteArrayOutputStream.write(-53);
                byteArrayOutputStream.write(c0415f.f6329z);
            }
            Long l10 = (Long) c0415f.a(192);
            if (l10 != null) {
                if (z11) {
                    H7.b.c("ObexHelper", " Add Header = 192");
                }
                byteArrayOutputStream.write(-64);
                byteArrayOutputStream.write(a(l10.longValue()));
                if (z10) {
                    c0415f.c(192, null);
                }
            }
            String str = (String) c0415f.a(1);
            if (str != null) {
                if (z11) {
                    H7.b.c("ObexHelper", " Add Header = 1");
                }
                byteArrayOutputStream.write(1);
                byte[] d10 = d(str);
                int length = d10.length + 3;
                bArr[0] = (byte) ((length >> 8) & 255);
                bArr[1] = (byte) (length & 255);
                byteArrayOutputStream.write(bArr);
                byteArrayOutputStream.write(d10);
                if (z10) {
                    c0415f.c(1, null);
                }
            }
            String str2 = (String) c0415f.a(21);
            if (str2 != null) {
                if (z11) {
                    H7.b.c("ObexHelper", " Add Header = 21");
                }
                byteArrayOutputStream.write(21);
                byte[] d11 = d(str2);
                int length2 = d11.length + 3;
                bArr[0] = (byte) ((length2 >> 8) & 255);
                bArr[1] = (byte) (length2 & 255);
                byteArrayOutputStream.write(bArr);
                byteArrayOutputStream.write(d11);
                if (z10) {
                    c0415f.c(21, null);
                }
            }
            String str3 = (String) c0415f.a(66);
            if (str3 != null) {
                if (z11) {
                    H7.b.c("ObexHelper", " Add Header = 66");
                }
                byteArrayOutputStream.write(66);
                try {
                    byte[] bytes = str3.getBytes("ISO8859_1");
                    int length3 = bytes.length + 4;
                    bArr[0] = (byte) ((length3 >> 8) & 255);
                    bArr[1] = (byte) (length3 & 255);
                    byteArrayOutputStream.write(bArr);
                    byteArrayOutputStream.write(bytes);
                    byteArrayOutputStream.write(0);
                    if (z10) {
                        c0415f.c(66, null);
                    }
                } catch (UnsupportedEncodingException e10) {
                    throw e10;
                }
            }
            Long l11 = (Long) c0415f.a(195);
            if (l11 != null) {
                if (z11) {
                    H7.b.c("ObexHelper", " Add Header = 195");
                }
                byteArrayOutputStream.write(-61);
                byteArrayOutputStream.write(a(l11.longValue()));
                if (z10) {
                    c0415f.c(195, null);
                }
            }
            Calendar calendar = (Calendar) c0415f.a(68);
            if (calendar != null) {
                StringBuffer stringBuffer = new StringBuffer();
                int i10 = calendar.get(1);
                for (int i11 = i10; i11 < 1000; i11 *= 10) {
                    stringBuffer.append(OplusPhoneUtils.DeviceState.UNLOCK_DEVICE);
                }
                stringBuffer.append(i10);
                int i12 = calendar.get(2);
                if (i12 < 10) {
                    stringBuffer.append(OplusPhoneUtils.DeviceState.UNLOCK_DEVICE);
                }
                stringBuffer.append(i12);
                int i13 = calendar.get(5);
                if (i13 < 10) {
                    stringBuffer.append(OplusPhoneUtils.DeviceState.UNLOCK_DEVICE);
                }
                stringBuffer.append(i13);
                stringBuffer.append("T");
                int i14 = calendar.get(11);
                if (i14 < 10) {
                    stringBuffer.append(OplusPhoneUtils.DeviceState.UNLOCK_DEVICE);
                }
                stringBuffer.append(i14);
                int i15 = calendar.get(12);
                if (i15 < 10) {
                    stringBuffer.append(OplusPhoneUtils.DeviceState.UNLOCK_DEVICE);
                }
                stringBuffer.append(i15);
                int i16 = calendar.get(13);
                if (i16 < 10) {
                    stringBuffer.append(OplusPhoneUtils.DeviceState.UNLOCK_DEVICE);
                }
                stringBuffer.append(i16);
                if (calendar.getTimeZone().getID().equals("UTC")) {
                    stringBuffer.append("Z");
                }
                try {
                    byte[] bytes2 = stringBuffer.toString().getBytes("ISO8859_1");
                    int length4 = bytes2.length + 3;
                    bArr[0] = (byte) ((length4 >> 8) & 255);
                    bArr[1] = (byte) (length4 & 255);
                    byteArrayOutputStream.write(68);
                    byteArrayOutputStream.write(bArr);
                    byteArrayOutputStream.write(bytes2);
                    if (z10) {
                        c0415f.c(68, null);
                    }
                } catch (UnsupportedEncodingException e11) {
                    throw e11;
                }
            }
            Calendar calendar2 = (Calendar) c0415f.a(196);
            if (calendar2 != null) {
                byteArrayOutputStream.write(196);
                byteArrayOutputStream.write(a(calendar2.getTime().getTime() / 1000));
                if (z10) {
                    c0415f.c(196, null);
                }
            }
            String str4 = (String) c0415f.a(5);
            if (str4 != null) {
                byteArrayOutputStream.write(5);
                byte[] d12 = d(str4);
                int length5 = d12.length + 3;
                bArr[0] = (byte) ((length5 >> 8) & 255);
                bArr[1] = (byte) (length5 & 255);
                byteArrayOutputStream.write(bArr);
                byteArrayOutputStream.write(d12);
                if (z10) {
                    c0415f.c(5, null);
                }
            }
            byte[] bArr2 = (byte[]) c0415f.a(70);
            if (bArr2 != null) {
                if (f6330e) {
                    H7.b.c("ObexHelper", " Add Header = 70");
                }
                byteArrayOutputStream.write(70);
                int length6 = bArr2.length + 3;
                bArr[0] = (byte) ((length6 >> 8) & 255);
                bArr[1] = (byte) (length6 & 255);
                byteArrayOutputStream.write(bArr);
                byteArrayOutputStream.write(bArr2);
                if (z10) {
                    c0415f.c(70, null);
                }
            }
            byte[] bArr3 = (byte[]) c0415f.a(71);
            if (bArr3 != null) {
                byteArrayOutputStream.write(71);
                int length7 = bArr3.length + 3;
                bArr[0] = (byte) ((length7 >> 8) & 255);
                bArr[1] = (byte) (length7 & 255);
                byteArrayOutputStream.write(bArr);
                byteArrayOutputStream.write(bArr3);
                if (z10) {
                    c0415f.c(71, null);
                }
            }
            byte[] bArr4 = (byte[]) c0415f.a(74);
            if (bArr4 != null) {
                if (f6330e) {
                    H7.b.c("ObexHelper", " Add Header = 74");
                }
                byteArrayOutputStream.write(74);
                int length8 = bArr4.length + 3;
                bArr[0] = (byte) ((length8 >> 8) & 255);
                bArr[1] = (byte) (length8 & 255);
                byteArrayOutputStream.write(bArr);
                byteArrayOutputStream.write(bArr4);
                if (z10) {
                    c0415f.c(74, null);
                }
            }
            byte[] bArr5 = (byte[]) c0415f.a(76);
            if (bArr5 != null) {
                byteArrayOutputStream.write(76);
                int length9 = bArr5.length + 3;
                bArr[0] = (byte) ((length9 >> 8) & 255);
                bArr[1] = (byte) (length9 & 255);
                byteArrayOutputStream.write(bArr);
                byteArrayOutputStream.write(bArr5);
                if (z10) {
                    c0415f.c(76, null);
                }
            }
            byte[] bArr6 = (byte[]) c0415f.a(79);
            if (bArr6 != null) {
                byteArrayOutputStream.write(79);
                int length10 = bArr6.length + 3;
                bArr[0] = (byte) ((length10 >> 8) & 255);
                bArr[1] = (byte) (length10 & 255);
                byteArrayOutputStream.write(bArr);
                byteArrayOutputStream.write(bArr6);
                if (z10) {
                    c0415f.c(79, null);
                }
            }
            Byte b10 = (Byte) c0415f.a(151);
            if (b10 != null) {
                if (f6330e) {
                    H7.b.c("ObexHelper", " Add Header = 151");
                }
                byteArrayOutputStream.write(-105);
                byteArrayOutputStream.write(b10.byteValue());
                if (z10) {
                    c0415f.c(151, null);
                }
            }
            Byte b11 = (Byte) c0415f.a(VibrateUtils.TYPE_STEPABLE_REGULATE);
            if (b11 != null) {
                if (f6330e) {
                    H7.b.c("ObexHelper", " Add Header = 152");
                }
                byteArrayOutputStream.write(-104);
                byteArrayOutputStream.write(b11.byteValue());
                if (z10) {
                    c0415f.c(VibrateUtils.TYPE_STEPABLE_REGULATE, null);
                }
            }
            for (int i17 = 0; i17 < 16; i17++) {
                int i18 = i17 + 48;
                String str5 = (String) c0415f.a(i18);
                if (str5 != null) {
                    byteArrayOutputStream.write(((byte) i17) + 48);
                    byte[] d13 = d(str5);
                    int length11 = d13.length + 3;
                    bArr[0] = (byte) ((length11 >> 8) & 255);
                    bArr[1] = (byte) (length11 & 255);
                    byteArrayOutputStream.write(bArr);
                    byteArrayOutputStream.write(d13);
                    if (z10) {
                        c0415f.c(i18, null);
                    }
                }
                int i19 = i17 + 112;
                byte[] bArr7 = (byte[]) c0415f.a(i19);
                if (bArr7 != null) {
                    byteArrayOutputStream.write(((byte) i17) + 112);
                    int length12 = bArr7.length + 3;
                    bArr[0] = (byte) ((length12 >> 8) & 255);
                    bArr[1] = (byte) (length12 & 255);
                    byteArrayOutputStream.write(bArr);
                    byteArrayOutputStream.write(bArr7);
                    if (z10) {
                        c0415f.c(i19, null);
                    }
                }
                int i20 = i17 + 176;
                Byte b12 = (Byte) c0415f.a(i20);
                if (b12 != null) {
                    byteArrayOutputStream.write(((byte) i17) + 176);
                    byteArrayOutputStream.write(b12.byteValue());
                    if (z10) {
                        c0415f.c(i20, null);
                    }
                }
                int i21 = i17 + 240;
                Long l12 = (Long) c0415f.a(i21);
                if (l12 != null) {
                    byteArrayOutputStream.write(((byte) i17) + 240);
                    byteArrayOutputStream.write(a(l12.longValue()));
                    if (z10) {
                        c0415f.c(i21, null);
                    }
                }
            }
            if (c0415f.f6327x != null) {
                byteArrayOutputStream.write(77);
                int length13 = c0415f.f6327x.length + 3;
                bArr[0] = (byte) ((length13 >> 8) & 255);
                bArr[1] = (byte) (length13 & 255);
                byteArrayOutputStream.write(bArr);
                byteArrayOutputStream.write(c0415f.f6327x);
                if (z10) {
                    c0415f.f6327x = null;
                }
            }
            if (c0415f.f6328y != null) {
                byteArrayOutputStream.write(78);
                int length14 = c0415f.f6328y.length + 3;
                bArr[0] = (byte) ((length14 >> 8) & 255);
                bArr[1] = (byte) (length14 & 255);
                byteArrayOutputStream.write(bArr);
                byteArrayOutputStream.write(c0415f.f6328y);
                if (z10) {
                    c0415f.f6328y = null;
                }
            }
        } catch (IOException unused) {
        } catch (Throwable th) {
            byteArrayOutputStream.toByteArray();
            try {
                byteArrayOutputStream.close();
            } catch (Exception unused2) {
            }
            throw th;
        }
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        try {
            byteArrayOutputStream.close();
        } catch (Exception unused3) {
        }
        return byteArray;
    }

    public static int f(byte[] bArr, int i10, int i11) {
        int i12;
        int i13 = 0;
        int i14 = i10;
        int i15 = -1;
        while (i13 < i11 && i14 < bArr.length) {
            int i16 = bArr[i14];
            if (i16 < 0) {
                i16 += 256;
            }
            int i17 = i16 & 192;
            if (i17 != 0 && i17 != 64) {
                if (i17 != 128) {
                    if (i17 != 192) {
                        i12 = i13;
                    } else {
                        i14 += 5;
                        i12 = i13 + 5;
                    }
                } else {
                    i14 += 2;
                    i12 = i13 + 2;
                }
            } else {
                int i18 = bArr[i14 + 1];
                if (i18 < 0) {
                    i18 += 256;
                }
                int i19 = i18 << 8;
                int i20 = bArr[i14 + 2];
                if (i20 < 0) {
                    i20 += 256;
                }
                int i21 = i19 + i20;
                i14 = i14 + 3 + (i21 - 3);
                i12 = i21 + i13;
            }
            int i22 = i12;
            i15 = i13;
            i13 = i22;
        }
        if (i15 == 0) {
            if (i13 >= i11) {
                return -1;
            }
            return bArr.length;
        }
        return i15 + i10;
    }

    public static byte[] n(C0415f c0415f, byte[] bArr) {
        boolean z10;
        byte[] bArr2 = null;
        int i10 = 0;
        while (i10 < bArr.length) {
            try {
                int i11 = bArr[i10];
                int i12 = i11 & 255;
                if (f6330e) {
                    H7.b.c("ObexHelper", "updateHeaderSet headerID = " + i12);
                }
                int i13 = i11 & 192;
                if (i13 != 0 && i13 != 64) {
                    if (i13 != 128) {
                        if (i13 == 192) {
                            byte[] bArr3 = new byte[4];
                            System.arraycopy(bArr, i10 + 1, bArr3, 0, 4);
                            if (i12 != 196) {
                                if (i12 == 203) {
                                    try {
                                        byte[] bArr4 = new byte[4];
                                        c0415f.f6329z = bArr4;
                                        System.arraycopy(bArr3, 0, bArr4, 0, 4);
                                    } catch (Exception unused) {
                                        throw new IOException("Header was not formatted properly");
                                    }
                                } else {
                                    c0415f.c(i12, Long.valueOf(b(bArr3)));
                                }
                            } else {
                                Calendar calendar = Calendar.getInstance();
                                calendar.setTime(new Date(b(bArr3) * 1000));
                                c0415f.c(196, calendar);
                            }
                            i10 += 5;
                        }
                    } else {
                        try {
                            c0415f.c(i12, Byte.valueOf(bArr[i10 + 1]));
                        } catch (Exception unused2) {
                        }
                        i10 += 2;
                    }
                } else {
                    int i14 = ((bArr[i10 + 1] & 255) << 8) + (bArr[i10 + 2] & 255);
                    int i15 = i14 - 3;
                    int i16 = i10 + 3;
                    byte[] bArr5 = new byte[i15];
                    System.arraycopy(bArr, i16, bArr5, 0, i15);
                    if (i15 != 0 && (i15 <= 0 || bArr5[i14 - 4] == 0)) {
                        z10 = true;
                    } else {
                        z10 = false;
                    }
                    if (i12 != 66) {
                        if (i12 != 68) {
                            if (i12 != 72 && i12 != 73) {
                                if (i12 != 77) {
                                    if (i12 != 78) {
                                        if (i13 == 0) {
                                            c0415f.c(i12, c(bArr5, true));
                                        } else {
                                            c0415f.c(i12, bArr5);
                                        }
                                    } else {
                                        byte[] bArr6 = new byte[i15];
                                        c0415f.f6328y = bArr6;
                                        System.arraycopy(bArr, i16, bArr6, 0, i15);
                                    }
                                } else {
                                    byte[] bArr7 = new byte[i15];
                                    c0415f.f6327x = bArr7;
                                    System.arraycopy(bArr, i16, bArr7, 0, i15);
                                }
                            } else {
                                bArr2 = new byte[i14 - 2];
                                bArr2[0] = (byte) i12;
                                System.arraycopy(bArr, i16, bArr2, 1, i15);
                            }
                        } else {
                            try {
                                String str = new String(bArr5, "ISO8859_1");
                                Calendar calendar2 = Calendar.getInstance();
                                if (str.length() == 16 && str.charAt(15) == 'Z') {
                                    calendar2.setTimeZone(TimeZone.getTimeZone("UTC"));
                                }
                                calendar2.set(1, Integer.parseInt(str.substring(0, 4)));
                                calendar2.set(2, Integer.parseInt(str.substring(4, 6)));
                                calendar2.set(5, Integer.parseInt(str.substring(6, 8)));
                                calendar2.set(11, Integer.parseInt(str.substring(9, 11)));
                                calendar2.set(12, Integer.parseInt(str.substring(11, 13)));
                                calendar2.set(13, Integer.parseInt(str.substring(13, 15)));
                                c0415f.c(68, calendar2);
                            } catch (UnsupportedEncodingException e10) {
                                throw e10;
                            }
                        }
                        i10 = i16 + i15;
                    } else {
                        if (!z10) {
                            try {
                                c0415f.c(i12, new String(bArr5, 0, i15, " ISO8859_1"));
                            } catch (UnsupportedEncodingException e11) {
                                throw e11;
                            }
                        } else {
                            c0415f.c(i12, new String(bArr5, 0, i14 - 4, "ISO8859_1"));
                        }
                        i10 = i16 + i15;
                    }
                }
            } catch (IOException unused3) {
                throw new IOException("Header was not formatted properly");
            }
        }
        return bArr2;
    }

    public boolean g() {
        if (f6330e) {
            H7.b.h("ObexHelper", "getLocalSrmStatus: " + this.f6341c);
        }
        return this.f6341c;
    }

    public boolean h() {
        if (f6330e) {
            H7.b.h("ObexHelper", "getLocalSrmpWait: " + this.f6342d);
        }
        return this.f6342d;
    }

    public boolean i() {
        if (f6330e) {
            H7.b.h("ObexHelper", "getRemoteSrmStatus: " + this.f6340b);
        }
        return this.f6340b;
    }

    public void j() {
        if (f6330e) {
            H7.b.h("ObexHelper", "resetSrmStatus");
        }
        k(false);
        l(false);
        m(false);
    }

    public void k(boolean z10) {
        this.f6341c = z10;
        if (f6330e) {
            H7.b.h("ObexHelper", "setLocalSrmStatus: " + this.f6341c);
        }
    }

    public void l(boolean z10) {
        if (f6330e) {
            H7.b.h("ObexHelper", "setLocalSrmpWait: " + z10);
        }
        this.f6342d = z10;
    }

    public void m(boolean z10) {
        this.f6340b = z10;
        if (f6330e) {
            H7.b.h("ObexHelper", "setRemoteSrmStatus: " + this.f6340b);
        }
    }
}
