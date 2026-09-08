package com.google.zxing.datamatrix.decoder;

import S4.c;
import S4.d;
import com.google.zxing.FormatException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collection;

/* loaded from: classes3.dex */
public final class DecodedBitStreamParser {

    /* renamed from: b, reason: collision with root package name */
    public static final char[] f25059b;

    /* renamed from: d, reason: collision with root package name */
    public static final char[] f25061d;

    /* renamed from: a, reason: collision with root package name */
    public static final char[] f25058a = {'*', '*', '*', ' ', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};

    /* renamed from: c, reason: collision with root package name */
    public static final char[] f25060c = {'*', '*', '*', ' ', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};

    /* renamed from: e, reason: collision with root package name */
    public static final char[] f25062e = {'`', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', '{', '|', '}', '~', 127};

    /* loaded from: classes3.dex */
    public enum Mode {
        PAD_ENCODE,
        ASCII_ENCODE,
        C40_ENCODE,
        TEXT_ENCODE,
        ANSIX12_ENCODE,
        EDIFACT_ENCODE,
        BASE256_ENCODE
    }

    /* loaded from: classes3.dex */
    public static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f25071a;

        static {
            int[] iArr = new int[Mode.values().length];
            f25071a = iArr;
            try {
                iArr[Mode.C40_ENCODE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f25071a[Mode.TEXT_ENCODE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f25071a[Mode.ANSIX12_ENCODE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f25071a[Mode.EDIFACT_ENCODE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f25071a[Mode.BASE256_ENCODE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    static {
        char[] cArr = {'!', '\"', '#', '$', '%', '&', '\'', '(', ')', '*', '+', ',', '-', '.', '/', ':', ';', '<', '=', '>', '?', '@', '[', '\\', ']', '^', '_'};
        f25059b = cArr;
        f25061d = cArr;
    }

    public static d a(byte[] bArr) {
        c cVar = new c(bArr);
        StringBuilder sb = new StringBuilder(100);
        StringBuilder sb2 = new StringBuilder(0);
        ArrayList arrayList = new ArrayList(1);
        Mode mode = Mode.ASCII_ENCODE;
        do {
            Mode mode2 = Mode.ASCII_ENCODE;
            if (mode == mode2) {
                mode = c(cVar, sb, sb2);
            } else {
                int i10 = a.f25071a[mode.ordinal()];
                if (i10 != 1) {
                    if (i10 != 2) {
                        if (i10 != 3) {
                            if (i10 != 4) {
                                if (i10 == 5) {
                                    d(cVar, sb, arrayList);
                                } else {
                                    throw FormatException.a();
                                }
                            } else {
                                f(cVar, sb);
                            }
                        } else {
                            b(cVar, sb);
                        }
                    } else {
                        g(cVar, sb);
                    }
                } else {
                    e(cVar, sb);
                }
                mode = mode2;
            }
            if (mode == Mode.PAD_ENCODE) {
                break;
            }
        } while (cVar.a() > 0);
        if (sb2.length() > 0) {
            sb.append((CharSequence) sb2);
        }
        String sb3 = sb.toString();
        if (arrayList.isEmpty()) {
            arrayList = null;
        }
        return new d(bArr, sb3, arrayList, null);
    }

    public static void b(c cVar, StringBuilder sb) {
        int d10;
        int[] iArr = new int[3];
        while (cVar.a() != 8 && (d10 = cVar.d(8)) != 254) {
            h(d10, cVar.d(8), iArr);
            for (int i10 = 0; i10 < 3; i10++) {
                int i11 = iArr[i10];
                if (i11 != 0) {
                    if (i11 != 1) {
                        if (i11 != 2) {
                            if (i11 != 3) {
                                if (i11 < 14) {
                                    sb.append((char) (i11 + 44));
                                } else if (i11 < 40) {
                                    sb.append((char) (i11 + 51));
                                } else {
                                    throw FormatException.a();
                                }
                            } else {
                                sb.append(' ');
                            }
                        } else {
                            sb.append('>');
                        }
                    } else {
                        sb.append('*');
                    }
                } else {
                    sb.append('\r');
                }
            }
            if (cVar.a() <= 0) {
                return;
            }
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:22:0x0037. Please report as an issue. */
    public static Mode c(c cVar, StringBuilder sb, StringBuilder sb2) {
        boolean z10 = false;
        do {
            int d10 = cVar.d(8);
            if (d10 != 0) {
                if (d10 <= 128) {
                    if (z10) {
                        d10 += 128;
                    }
                    sb.append((char) (d10 - 1));
                    return Mode.ASCII_ENCODE;
                }
                if (d10 == 129) {
                    return Mode.PAD_ENCODE;
                }
                if (d10 <= 229) {
                    int i10 = d10 - 130;
                    if (i10 < 10) {
                        sb.append('0');
                    }
                    sb.append(i10);
                } else {
                    switch (d10) {
                        case 230:
                            return Mode.C40_ENCODE;
                        case 231:
                            return Mode.BASE256_ENCODE;
                        case 232:
                            sb.append((char) 29);
                            break;
                        case 233:
                        case 234:
                        case 241:
                            break;
                        case 235:
                            z10 = true;
                            break;
                        case 236:
                            sb.append("[)>\u001e05\u001d");
                            sb2.insert(0, "\u001e\u0004");
                            break;
                        case 237:
                            sb.append("[)>\u001e06\u001d");
                            sb2.insert(0, "\u001e\u0004");
                            break;
                        case 238:
                            return Mode.ANSIX12_ENCODE;
                        case 239:
                            return Mode.TEXT_ENCODE;
                        case 240:
                            return Mode.EDIFACT_ENCODE;
                        default:
                            if (d10 != 254 || cVar.a() != 0) {
                                throw FormatException.a();
                            }
                            break;
                    }
                }
            } else {
                throw FormatException.a();
            }
        } while (cVar.a() > 0);
        return Mode.ASCII_ENCODE;
    }

    public static void d(c cVar, StringBuilder sb, Collection<byte[]> collection) {
        int c10 = cVar.c();
        int i10 = c10 + 2;
        int i11 = i(cVar.d(8), c10 + 1);
        if (i11 == 0) {
            i11 = cVar.a() / 8;
        } else if (i11 >= 250) {
            i11 = ((i11 - 249) * 250) + i(cVar.d(8), i10);
            i10 = c10 + 3;
        }
        if (i11 >= 0) {
            byte[] bArr = new byte[i11];
            int i12 = 0;
            while (i12 < i11) {
                if (cVar.a() >= 8) {
                    bArr[i12] = (byte) i(cVar.d(8), i10);
                    i12++;
                    i10++;
                } else {
                    throw FormatException.a();
                }
            }
            collection.add(bArr);
            try {
                sb.append(new String(bArr, "ISO8859_1"));
                return;
            } catch (UnsupportedEncodingException e10) {
                throw new IllegalStateException("Platform does not support required encoding: ".concat(String.valueOf(e10)));
            }
        }
        throw FormatException.a();
    }

    public static void e(c cVar, StringBuilder sb) {
        int d10;
        int[] iArr = new int[3];
        boolean z10 = false;
        int i10 = 0;
        while (cVar.a() != 8 && (d10 = cVar.d(8)) != 254) {
            h(d10, cVar.d(8), iArr);
            for (int i11 = 0; i11 < 3; i11++) {
                int i12 = iArr[i11];
                if (i10 != 0) {
                    if (i10 != 1) {
                        if (i10 != 2) {
                            if (i10 == 3) {
                                if (z10) {
                                    sb.append((char) (i12 + 224));
                                    z10 = false;
                                    i10 = 0;
                                } else {
                                    sb.append((char) (i12 + 96));
                                    i10 = 0;
                                }
                            } else {
                                throw FormatException.a();
                            }
                        } else {
                            char[] cArr = f25059b;
                            if (i12 < cArr.length) {
                                char c10 = cArr[i12];
                                if (z10) {
                                    sb.append((char) (c10 + 128));
                                    z10 = false;
                                } else {
                                    sb.append(c10);
                                }
                            } else if (i12 != 27) {
                                if (i12 == 30) {
                                    z10 = true;
                                } else {
                                    throw FormatException.a();
                                }
                            } else {
                                sb.append((char) 29);
                            }
                            i10 = 0;
                        }
                    } else if (z10) {
                        sb.append((char) (i12 + 128));
                        z10 = false;
                        i10 = 0;
                    } else {
                        sb.append((char) i12);
                        i10 = 0;
                    }
                } else if (i12 < 3) {
                    i10 = i12 + 1;
                } else {
                    char[] cArr2 = f25058a;
                    if (i12 < cArr2.length) {
                        char c11 = cArr2[i12];
                        if (z10) {
                            sb.append((char) (c11 + 128));
                            z10 = false;
                        } else {
                            sb.append(c11);
                        }
                    } else {
                        throw FormatException.a();
                    }
                }
            }
            if (cVar.a() <= 0) {
                return;
            }
        }
    }

    public static void f(c cVar, StringBuilder sb) {
        while (cVar.a() > 16) {
            for (int i10 = 0; i10 < 4; i10++) {
                int d10 = cVar.d(6);
                if (d10 == 31) {
                    int b10 = 8 - cVar.b();
                    if (b10 != 8) {
                        cVar.d(b10);
                        return;
                    }
                    return;
                }
                if ((d10 & 32) == 0) {
                    d10 |= 64;
                }
                sb.append((char) d10);
            }
            if (cVar.a() <= 0) {
                return;
            }
        }
    }

    public static void g(c cVar, StringBuilder sb) {
        int d10;
        int[] iArr = new int[3];
        boolean z10 = false;
        int i10 = 0;
        while (cVar.a() != 8 && (d10 = cVar.d(8)) != 254) {
            h(d10, cVar.d(8), iArr);
            for (int i11 = 0; i11 < 3; i11++) {
                int i12 = iArr[i11];
                if (i10 != 0) {
                    if (i10 != 1) {
                        if (i10 != 2) {
                            if (i10 == 3) {
                                char[] cArr = f25062e;
                                if (i12 < cArr.length) {
                                    char c10 = cArr[i12];
                                    if (z10) {
                                        sb.append((char) (c10 + 128));
                                        z10 = false;
                                        i10 = 0;
                                    } else {
                                        sb.append(c10);
                                        i10 = 0;
                                    }
                                } else {
                                    throw FormatException.a();
                                }
                            } else {
                                throw FormatException.a();
                            }
                        } else {
                            char[] cArr2 = f25061d;
                            if (i12 < cArr2.length) {
                                char c11 = cArr2[i12];
                                if (z10) {
                                    sb.append((char) (c11 + 128));
                                    z10 = false;
                                } else {
                                    sb.append(c11);
                                }
                            } else if (i12 != 27) {
                                if (i12 == 30) {
                                    z10 = true;
                                } else {
                                    throw FormatException.a();
                                }
                            } else {
                                sb.append((char) 29);
                            }
                            i10 = 0;
                        }
                    } else if (z10) {
                        sb.append((char) (i12 + 128));
                        z10 = false;
                        i10 = 0;
                    } else {
                        sb.append((char) i12);
                        i10 = 0;
                    }
                } else if (i12 < 3) {
                    i10 = i12 + 1;
                } else {
                    char[] cArr3 = f25060c;
                    if (i12 < cArr3.length) {
                        char c12 = cArr3[i12];
                        if (z10) {
                            sb.append((char) (c12 + 128));
                            z10 = false;
                        } else {
                            sb.append(c12);
                        }
                    } else {
                        throw FormatException.a();
                    }
                }
            }
            if (cVar.a() <= 0) {
                return;
            }
        }
    }

    public static void h(int i10, int i11, int[] iArr) {
        int i12 = ((i10 << 8) + i11) - 1;
        int i13 = i12 / 1600;
        iArr[0] = i13;
        int i14 = i12 - (i13 * 1600);
        int i15 = i14 / 40;
        iArr[1] = i15;
        iArr[2] = i14 - (i15 * 40);
    }

    public static int i(int i10, int i11) {
        int i12 = i10 - (((i11 * 149) % 255) + 1);
        if (i12 >= 0) {
            return i12;
        }
        return i12 + 256;
    }
}
