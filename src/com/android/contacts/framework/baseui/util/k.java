package com.android.contacts.framework.baseui.util;

import android.net.Uri;
import java.util.ArrayList;

/* compiled from: LookupKeyUtil.java */
/* loaded from: classes.dex */
public class k {

    /* compiled from: LookupKeyUtil.java */
    /* loaded from: classes.dex */
    public static class a implements Comparable<a> {

        /* renamed from: a, reason: collision with root package name */
        public int f15935a;

        /* renamed from: b, reason: collision with root package name */
        public int f15936b;

        /* renamed from: c, reason: collision with root package name */
        public String f15937c;

        /* renamed from: d, reason: collision with root package name */
        public String f15938d;

        /* renamed from: e, reason: collision with root package name */
        public long f15939e;

        @Override // java.lang.Comparable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compareTo(a aVar) {
            long j10 = this.f15939e;
            long j11 = aVar.f15939e;
            if (j10 > j11) {
                return -1;
            }
            if (j10 < j11) {
                return 1;
            }
            return 0;
        }
    }

    public static int a(String str, String str2) {
        if (str != null && str2 != null) {
            return (str.hashCode() ^ str2.hashCode()) & 4095;
        }
        return 0;
    }

    public static ArrayList<a> b(String str) {
        int i10;
        int i11;
        String substring;
        ArrayList<a> arrayList = new ArrayList<>();
        if (str == null) {
            return arrayList;
        }
        if ("profile".equals(str)) {
            a aVar = new a();
            aVar.f15936b = 3;
            arrayList.add(aVar);
            return arrayList;
        }
        String decode = Uri.decode(str);
        int length = decode.length();
        String str2 = null;
        int i12 = 0;
        boolean z10 = false;
        while (i12 < length) {
            int i13 = 0;
            char c10 = 0;
            while (i12 < length) {
                int i14 = i12 + 1;
                char charAt = decode.charAt(i12);
                if (charAt >= '0' && charAt <= '9') {
                    i13 = (i13 * 10) + (charAt - '0');
                    c10 = charAt;
                    i12 = i14;
                } else {
                    c10 = charAt;
                    i12 = i14;
                    break;
                }
            }
            if (c10 == 'i') {
                z10 = false;
                i10 = 0;
            } else if (c10 == 'e') {
                i10 = 0;
                z10 = true;
            } else if (c10 == 'n') {
                i10 = 1;
            } else if (c10 == 'r') {
                i10 = 2;
            } else {
                throw new IllegalArgumentException("Invalid lookup id: " + str);
            }
            if (i10 != 0) {
                if (i10 != 1) {
                    if (i10 == 2) {
                        int i15 = i12;
                        int i16 = -1;
                        while (i15 < length) {
                            char charAt2 = decode.charAt(i15);
                            if (charAt2 == '-' && i16 == -1) {
                                i16 = i15;
                            }
                            i15++;
                            if (charAt2 == '.') {
                                break;
                            }
                        }
                        if (i16 != -1) {
                            str2 = decode.substring(i12, i16);
                            i12 = i16 + 1;
                        }
                        if (i15 == length) {
                            substring = decode.substring(i12);
                        } else {
                            substring = decode.substring(i12, i15 - 1);
                        }
                        i11 = i15;
                    } else {
                        throw new IllegalStateException();
                    }
                } else {
                    i11 = i12;
                    while (true) {
                        if (i11 >= length) {
                            break;
                        }
                        int i17 = i11 + 1;
                        if (decode.charAt(i11) == '.') {
                            i11 = i17;
                            break;
                        }
                        i11 = i17;
                    }
                    if (i11 == length) {
                        substring = decode.substring(i12);
                    } else {
                        substring = decode.substring(i12, i11 - 1);
                    }
                }
            } else if (z10) {
                StringBuffer stringBuffer = new StringBuffer();
                while (true) {
                    if (i12 >= length) {
                        break;
                    }
                    int i18 = i12 + 1;
                    char charAt3 = decode.charAt(i12);
                    if (charAt3 == '.') {
                        if (i18 != length) {
                            if (decode.charAt(i18) == '.') {
                                stringBuffer.append('.');
                                i12 += 2;
                            } else {
                                i12 = i18;
                                break;
                            }
                        } else {
                            throw new IllegalArgumentException("Invalid lookup id: " + str);
                        }
                    } else {
                        stringBuffer.append(charAt3);
                        i12 = i18;
                    }
                }
                i11 = i12;
                substring = stringBuffer.toString();
            } else {
                i11 = i12;
                while (true) {
                    if (i11 >= length) {
                        break;
                    }
                    int i19 = i11 + 1;
                    if (decode.charAt(i11) == '.') {
                        i11 = i19;
                        break;
                    }
                    i11 = i19;
                }
                if (i11 == length) {
                    substring = decode.substring(i12);
                } else {
                    substring = decode.substring(i12, i11 - 1);
                }
            }
            a aVar2 = new a();
            aVar2.f15935a = i13;
            aVar2.f15936b = i10;
            aVar2.f15937c = str2;
            aVar2.f15938d = substring;
            aVar2.f15939e = -1L;
            arrayList.add(aVar2);
            i12 = i11;
        }
        return arrayList;
    }
}
