package com.google.zxing.aztec.decoder;

import A2.z;
import S4.b;
import U4.c;
import com.android.contacts.list.d;
import com.android.contacts.util.o;
import com.android.incallui.OplusPhoneUtils;
import com.customize.contacts.backupandrestore.plugin.ContactBackupPlugin;
import com.google.zxing.FormatException;
import com.google.zxing.common.reedsolomon.ReedSolomonException;
import com.heytap.accessory.e;
import com.oplus.backup.sdk.common.utils.Constants;
import java.util.Arrays;
import s1.v;

/* loaded from: classes3.dex */
public final class Decoder {

    /* renamed from: b, reason: collision with root package name */
    public static final String[] f25014b = {"CTRL_PS", " ", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "CTRL_LL", "CTRL_ML", "CTRL_DL", "CTRL_BS"};

    /* renamed from: c, reason: collision with root package name */
    public static final String[] f25015c = {"CTRL_PS", " ", "a", e.f25269e, "c", d.f16900U, "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", o.f17586f, "p", "q", "r", "s", "t", "u", v.f36673e, "w", "x", "y", z.f196a, "CTRL_US", "CTRL_ML", "CTRL_DL", "CTRL_BS"};

    /* renamed from: d, reason: collision with root package name */
    public static final String[] f25016d = {"CTRL_PS", " ", "\u0001", "\u0002", "\u0003", "\u0004", "\u0005", "\u0006", "\u0007", "\b", "\t", "\n", "\u000b", "\f", "\r", "\u001b", "\u001c", "\u001d", "\u001e", "\u001f", "@", "\\", "^", "_", "`", "|", "~", "\u007f", "CTRL_LL", "CTRL_UL", "CTRL_PL", "CTRL_BS"};

    /* renamed from: e, reason: collision with root package name */
    public static final String[] f25017e = {"", "\r", ContactBackupPlugin.END_OF_LINE, ". ", ", ", ": ", "!", "\"", "#", "$", "%", "&", "'", "(", ")", "*", "+", ",", "-", ".", "/", ":", Constants.DataMigration.SPLIT_TAG, "<", "=", ">", "?", "[", "]", "{", "}", "CTRL_UL"};

    /* renamed from: f, reason: collision with root package name */
    public static final String[] f25018f = {"CTRL_PS", " ", OplusPhoneUtils.DeviceState.UNLOCK_DEVICE, OplusPhoneUtils.DeviceState.LOCK_DEVICE, "2", "3", "4", "5", "6", "7", "8", "9", ",", ".", "CTRL_UL", "CTRL_US"};

    /* renamed from: a, reason: collision with root package name */
    public Q4.a f25019a;

    /* loaded from: classes3.dex */
    public enum Table {
        UPPER,
        LOWER,
        MIXED,
        DIGIT,
        PUNCT,
        BINARY
    }

    /* loaded from: classes3.dex */
    public static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f25027a;

        static {
            int[] iArr = new int[Table.values().length];
            f25027a = iArr;
            try {
                iArr[Table.UPPER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f25027a[Table.LOWER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f25027a[Table.MIXED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f25027a[Table.PUNCT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f25027a[Table.DIGIT.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    public static byte[] a(boolean[] zArr) {
        int length = (zArr.length + 7) / 8;
        byte[] bArr = new byte[length];
        for (int i10 = 0; i10 < length; i10++) {
            bArr[i10] = h(zArr, i10 << 3);
        }
        return bArr;
    }

    public static String e(Table table, int i10) {
        int i11 = a.f25027a[table.ordinal()];
        if (i11 != 1) {
            if (i11 != 2) {
                if (i11 != 3) {
                    if (i11 != 4) {
                        if (i11 == 5) {
                            return f25018f[i10];
                        }
                        throw new IllegalStateException("Bad table");
                    }
                    return f25017e[i10];
                }
                return f25016d[i10];
            }
            return f25015c[i10];
        }
        return f25014b[i10];
    }

    public static String f(boolean[] zArr) {
        int i10;
        int length = zArr.length;
        Table table = Table.UPPER;
        StringBuilder sb = new StringBuilder(20);
        Table table2 = table;
        int i11 = 0;
        while (i11 < length) {
            if (table == Table.BINARY) {
                if (length - i11 < 5) {
                    break;
                }
                int i12 = i(zArr, i11, 5);
                int i13 = i11 + 5;
                if (i12 == 0) {
                    if (length - i13 < 11) {
                        break;
                    }
                    i12 = i(zArr, i13, 11) + 31;
                    i13 = i11 + 16;
                }
                int i14 = 0;
                while (true) {
                    if (i14 < i12) {
                        if (length - i13 < 8) {
                            i11 = length;
                            break;
                        }
                        sb.append((char) i(zArr, i13, 8));
                        i13 += 8;
                        i14++;
                    } else {
                        i11 = i13;
                        break;
                    }
                }
                table = table2;
            } else {
                if (table == Table.DIGIT) {
                    i10 = 4;
                } else {
                    i10 = 5;
                }
                if (length - i11 < i10) {
                    break;
                }
                int i15 = i(zArr, i11, i10);
                i11 += i10;
                String e10 = e(table, i15);
                if (e10.startsWith("CTRL_")) {
                    table2 = g(e10.charAt(5));
                    if (e10.charAt(6) != 'L') {
                        table2 = table;
                        table = table2;
                    }
                } else {
                    sb.append(e10);
                }
                table = table2;
            }
        }
        return sb.toString();
    }

    public static Table g(char c10) {
        if (c10 != 'B') {
            if (c10 != 'D') {
                if (c10 != 'P') {
                    if (c10 != 'L') {
                        if (c10 != 'M') {
                            return Table.UPPER;
                        }
                        return Table.MIXED;
                    }
                    return Table.LOWER;
                }
                return Table.PUNCT;
            }
            return Table.DIGIT;
        }
        return Table.BINARY;
    }

    public static byte h(boolean[] zArr, int i10) {
        int i11;
        int length = zArr.length - i10;
        if (length >= 8) {
            i11 = i(zArr, i10, 8);
        } else {
            i11 = i(zArr, i10, length) << (8 - length);
        }
        return (byte) i11;
    }

    public static int i(boolean[] zArr, int i10, int i11) {
        int i12 = 0;
        for (int i13 = i10; i13 < i10 + i11; i13++) {
            i12 <<= 1;
            if (zArr[i13]) {
                i12 |= 1;
            }
        }
        return i12;
    }

    public static int j(int i10, boolean z10) {
        int i11;
        if (z10) {
            i11 = 88;
        } else {
            i11 = 112;
        }
        return (i11 + (i10 << 4)) * i10;
    }

    public final boolean[] b(boolean[] zArr) {
        int i10;
        U4.a aVar;
        boolean z10;
        boolean z11;
        if (this.f25019a.d() <= 2) {
            aVar = U4.a.f3854j;
            i10 = 6;
        } else {
            i10 = 8;
            if (this.f25019a.d() <= 8) {
                aVar = U4.a.f3858n;
            } else if (this.f25019a.d() <= 22) {
                aVar = U4.a.f3853i;
                i10 = 10;
            } else {
                aVar = U4.a.f3852h;
                i10 = 12;
            }
        }
        int c10 = this.f25019a.c();
        int length = zArr.length / i10;
        if (length >= c10) {
            int length2 = zArr.length % i10;
            int[] iArr = new int[length];
            int i11 = 0;
            while (i11 < length) {
                iArr[i11] = i(zArr, length2, i10);
                i11++;
                length2 += i10;
            }
            try {
                new c(aVar).a(iArr, length - c10);
                int i12 = 1 << i10;
                int i13 = i12 - 1;
                int i14 = 0;
                for (int i15 = 0; i15 < c10; i15++) {
                    int i16 = iArr[i15];
                    if (i16 != 0 && i16 != i13) {
                        if (i16 == 1 || i16 == i12 - 2) {
                            i14++;
                        }
                    } else {
                        throw FormatException.a();
                    }
                }
                boolean[] zArr2 = new boolean[(c10 * i10) - i14];
                int i17 = 0;
                for (int i18 = 0; i18 < c10; i18++) {
                    int i19 = iArr[i18];
                    if (i19 != 1 && i19 != i12 - 2) {
                        int i20 = i10 - 1;
                        while (i20 >= 0) {
                            int i21 = i17 + 1;
                            if (((1 << i20) & i19) != 0) {
                                z11 = true;
                            } else {
                                z11 = false;
                            }
                            zArr2[i17] = z11;
                            i20--;
                            i17 = i21;
                        }
                    } else {
                        int i22 = (i17 + i10) - 1;
                        if (i19 > 1) {
                            z10 = true;
                        } else {
                            z10 = false;
                        }
                        Arrays.fill(zArr2, i17, i22, z10);
                        i17 += i10 - 1;
                    }
                }
                return zArr2;
            } catch (ReedSolomonException e10) {
                throw FormatException.b(e10);
            }
        }
        throw FormatException.a();
    }

    public S4.d c(Q4.a aVar) {
        this.f25019a = aVar;
        boolean[] b10 = b(d(aVar.a()));
        S4.d dVar = new S4.d(a(b10), f(b10), null, null);
        dVar.l(b10.length);
        return dVar;
    }

    public final boolean[] d(b bVar) {
        int i10;
        int i11;
        boolean e10 = this.f25019a.e();
        int d10 = this.f25019a.d();
        if (e10) {
            i10 = 11;
        } else {
            i10 = 14;
        }
        int i12 = i10 + (d10 << 2);
        int[] iArr = new int[i12];
        boolean[] zArr = new boolean[j(d10, e10)];
        int i13 = 2;
        if (e10) {
            for (int i14 = 0; i14 < i12; i14++) {
                iArr[i14] = i14;
            }
        } else {
            int i15 = i12 / 2;
            int i16 = ((i12 + 1) + (((i15 - 1) / 15) * 2)) / 2;
            for (int i17 = 0; i17 < i15; i17++) {
                iArr[(i15 - i17) - 1] = (i16 - r11) - 1;
                iArr[i15 + i17] = (i17 / 15) + i17 + i16 + 1;
            }
        }
        int i18 = 0;
        int i19 = 0;
        while (i18 < d10) {
            int i20 = (d10 - i18) << i13;
            if (e10) {
                i11 = 9;
            } else {
                i11 = 12;
            }
            int i21 = i20 + i11;
            int i22 = i18 << 1;
            int i23 = (i12 - 1) - i22;
            int i24 = 0;
            while (i24 < i21) {
                int i25 = i24 << 1;
                int i26 = 0;
                while (i26 < i13) {
                    int i27 = i22 + i26;
                    int i28 = i22 + i24;
                    zArr[i19 + i25 + i26] = bVar.d(iArr[i27], iArr[i28]);
                    int i29 = i23 - i26;
                    zArr[(i21 * 2) + i19 + i25 + i26] = bVar.d(iArr[i28], iArr[i29]);
                    int i30 = i23 - i24;
                    zArr[(i21 * 4) + i19 + i25 + i26] = bVar.d(iArr[i29], iArr[i30]);
                    zArr[(i21 * 6) + i19 + i25 + i26] = bVar.d(iArr[i30], iArr[i27]);
                    i26++;
                    e10 = e10;
                    d10 = d10;
                    i13 = 2;
                }
                i24++;
                i13 = 2;
            }
            i19 += i21 << 3;
            i18++;
            d10 = d10;
            i13 = 2;
        }
        return zArr;
    }
}
