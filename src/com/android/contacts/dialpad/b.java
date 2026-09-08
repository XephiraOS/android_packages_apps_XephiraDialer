package com.android.contacts.dialpad;

import com.android.contacts.dialpad.view.HighLightView;
import com.customize.contacts.util.K;

/* compiled from: ContactsForeignStringConvertUtils.java */
/* loaded from: classes.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public static final char[] f14910a = {225, 224, 7843, 227, 7841, 193, 192, 7842, 195, 7840, 259, 7855, 7857, 7857, 7859, 7863, 258, 7854, 7856, 7858, 7860, 7862, 226, 7845, 7847, 7851, 7849, 7853, 194, 7844, 7846, 7848, 7850, 7852};

    /* renamed from: b, reason: collision with root package name */
    public static final char[] f14911b = {272, 273};

    /* renamed from: c, reason: collision with root package name */
    public static final char[] f14912c = {233, 232, 7869, 7867, 7865, 201, 200, 7868, 7866, 7864, 234, 7871, 7873, 7877, 7875, 7879, 202, 7870, 7872, 7874, 7876, 7878};

    /* renamed from: d, reason: collision with root package name */
    public static final char[] f14913d = {7883, 237, 236, 7881, 297, 237, 236, 204, 7880, 296, 7883};

    /* renamed from: e, reason: collision with root package name */
    public static final char[] f14914e = {243, 242, 245, 7887, 7885, 211, 210, 7886, 213, 7884, 244, 7889, 7891, 7895, 7893, 7897, 212, 7888, 7890, 7894, 7892, 7896, 417, 7899, 7901, 7903, 7905, 7907, 416, 7898, 7900, 7902, 7904, 7906};

    /* renamed from: f, reason: collision with root package name */
    public static final char[] f14915f = {250, 249, 7911, 361, 7909, 218, 217, 7910, 360, 7908, 432, 7913, 7915, 7917, 7919, 7921, 431, 7912, 7914, 7916, 7918, 7920};

    /* renamed from: g, reason: collision with root package name */
    public static final char[] f14916g = {253, 7923, 7927, 7929, 7925, 221, 7922, 7926, 7928, 7924};

    public static String a(String str) {
        String a10 = K.a();
        if (a10.startsWith("th")) {
            return e(str);
        }
        if (a10.startsWith("vi")) {
            return g(str);
        }
        if (a10.startsWith("ru")) {
            return c(str);
        }
        if (!a10.equalsIgnoreCase("zh-TW") && !a10.equalsIgnoreCase("zh-Hant-TW")) {
            if (a10.startsWith("uk")) {
                return f(str);
            }
            return b(str);
        }
        return d(str);
    }

    public static String b(String str) {
        if (str != null && str.length() != 0) {
            StringBuilder sb = new StringBuilder();
            int length = str.length();
            for (int i10 = 0; i10 != length; i10++) {
                char charAt = str.charAt(i10);
                if ((charAt >= 'A' && charAt <= 'Z') || (charAt >= 'a' && charAt <= 'z')) {
                    sb.append(HighLightView.f15035B[Character.toUpperCase(charAt) - 'A']);
                } else if (charAt >= 313 && charAt <= 322) {
                    sb.append('5');
                } else if (charAt >= 346 && charAt <= 353) {
                    sb.append('7');
                } else if (charAt >= 377 && charAt <= 382) {
                    sb.append('9');
                } else if (charAt != 199 && charAt != 231 && (charAt < 262 || charAt > 269)) {
                    if (charAt != 209 && charAt != 241 && charAt != 504 && charAt != 505 && (charAt < 323 || charAt > 328)) {
                        if ((charAt >= 192 && charAt <= 197) || ((charAt >= 224 && charAt <= 229) || (charAt >= 256 && charAt <= 261))) {
                            sb.append('2');
                        } else if ((charAt >= 200 && charAt <= 203) || ((charAt >= 232 && charAt <= 235) || (charAt >= 274 && charAt <= 283))) {
                            sb.append('3');
                        } else if ((charAt >= 204 && charAt <= 207) || ((charAt >= 236 && charAt <= 239) || (charAt >= 296 && charAt <= 305))) {
                            sb.append('4');
                        } else if ((charAt >= 210 && charAt <= 214) || ((charAt >= 242 && charAt <= 246) || (charAt >= 332 && charAt <= 337))) {
                            sb.append('6');
                        } else if ((charAt >= 217 && charAt <= 220) || ((charAt >= 249 && charAt <= 252) || ((charAt >= 360 && charAt <= 371) || (charAt >= 469 && charAt <= 476)))) {
                            sb.append('8');
                        } else {
                            sb.append(charAt);
                        }
                    } else {
                        sb.append('6');
                    }
                } else {
                    sb.append('2');
                }
            }
            return sb.toString();
        }
        return "";
    }

    public static String c(String str) {
        if (str != null && str.length() != 0) {
            StringBuilder sb = new StringBuilder();
            int length = str.length();
            for (int i10 = 0; i10 != length; i10++) {
                char charAt = str.charAt(i10);
                if ((charAt >= 'A' && charAt <= 'Z') || (charAt >= 'a' && charAt <= 'z')) {
                    sb.append(HighLightView.f15035B[Character.toUpperCase(charAt) - 'A']);
                } else if (charAt != 1025 && charAt != 1105) {
                    if (charAt >= 1040 && charAt <= 1045) {
                        sb.append(HighLightView.f15038E[charAt - 1040]);
                    } else if (charAt >= 1046 && charAt <= 1071) {
                        sb.append(HighLightView.f15038E[charAt - 1039]);
                    } else if (charAt >= 1072 && charAt <= 1077) {
                        sb.append(HighLightView.f15038E[charAt - 1072]);
                    } else if (charAt >= 1078 && charAt <= 1103) {
                        sb.append(HighLightView.f15038E[charAt - 1071]);
                    } else {
                        sb.append(charAt);
                    }
                } else {
                    sb.append(HighLightView.f15038E[6]);
                }
            }
            return sb.toString();
        }
        return "";
    }

    public static String d(String str) {
        if (str != null && str.length() != 0) {
            StringBuilder sb = new StringBuilder();
            int length = str.length();
            for (int i10 = 0; i10 != length; i10++) {
                char charAt = str.charAt(i10);
                if ((charAt >= 'A' && charAt <= 'Z') || (charAt >= 'a' && charAt <= 'z')) {
                    sb.append(HighLightView.f15035B[Character.toUpperCase(charAt) - 'A']);
                } else if (charAt >= 12549 && charAt <= 12585) {
                    sb.append(HighLightView.f15040G[charAt - 12549]);
                } else {
                    sb.append(charAt);
                }
            }
            return sb.toString();
        }
        return null;
    }

    public static String e(String str) {
        if (str != null && str.length() != 0) {
            StringBuilder sb = new StringBuilder();
            int length = str.length();
            for (int i10 = 0; i10 != length; i10++) {
                char charAt = str.charAt(i10);
                if ((charAt >= 'a' && charAt <= 'z') || (charAt >= 'A' && charAt <= 'Z')) {
                    sb.append(HighLightView.f15035B[Character.toUpperCase(charAt) - 'A']);
                } else if (charAt >= 3585 && charAt <= 3630) {
                    sb.append(HighLightView.f15036C[charAt - 3585]);
                } else if ((charAt >= 3631 && charAt <= 3642) || (charAt >= 3648 && charAt <= 3662)) {
                    sb.append('0');
                } else if (charAt >= 3664 && charAt <= 3673) {
                    sb.append(String.valueOf(charAt - 3664));
                } else {
                    sb.append(charAt);
                }
            }
            return sb.toString();
        }
        return "";
    }

    public static String f(String str) {
        if (str != null && str.length() != 0) {
            StringBuilder sb = new StringBuilder();
            int length = str.length();
            for (int i10 = 0; i10 != length; i10++) {
                char charAt = str.charAt(i10);
                if ((charAt >= 'A' && charAt <= 'Z') || (charAt >= 'a' && charAt <= 'z')) {
                    sb.append(HighLightView.f15035B[Character.toUpperCase(charAt) - 'A']);
                } else if (charAt != 1168 && charAt != 1169 && ((charAt < 1040 || charAt > 1043) && (charAt < 1072 || charAt > 1075))) {
                    if (charAt != 1028 && charAt != 1108 && ((charAt < 1044 || charAt > 1047) && (charAt < 1076 || charAt > 1079))) {
                        if (charAt != 1048 && charAt != 1080 && charAt != 1030 && charAt != 1110 && charAt != 1031 && charAt != 1111) {
                            if ((charAt >= 1049 && charAt <= 1065) || charAt == 1068) {
                                sb.append(HighLightView.f15039F[charAt - 1036]);
                            } else if ((charAt >= 1081 && charAt <= 1097) || charAt == 1100) {
                                sb.append(HighLightView.f15039F[charAt - 1068]);
                            } else if (charAt >= 1070 && charAt <= 1071) {
                                sb.append(HighLightView.f15039F[charAt - 1039]);
                            } else if (charAt >= 1102 && charAt <= 1103) {
                                sb.append(HighLightView.f15039F[charAt - 1071]);
                            } else {
                                sb.append(charAt);
                            }
                        } else {
                            sb.append(HighLightView.f15039F[10]);
                        }
                    } else {
                        sb.append(HighLightView.f15039F[5]);
                    }
                } else {
                    sb.append(HighLightView.f15039F[0]);
                }
            }
            return sb.toString();
        }
        return "";
    }

    public static String g(String str) {
        if (str != null && str.length() != 0) {
            StringBuilder sb = new StringBuilder();
            int length = str.length();
            for (int i10 = 0; i10 != length; i10++) {
                char charAt = str.charAt(i10);
                if ((charAt >= 'A' && charAt <= 'Z') || (charAt >= 'a' && charAt <= 'z')) {
                    sb.append(HighLightView.f15035B[Character.toUpperCase(charAt) - 'A']);
                } else if (h(charAt, f14910a)) {
                    sb.append(HighLightView.f15037D[0]);
                } else if (h(charAt, f14911b)) {
                    sb.append(HighLightView.f15037D[5]);
                } else if (h(charAt, f14912c)) {
                    sb.append(HighLightView.f15037D[5]);
                } else if (h(charAt, f14913d)) {
                    sb.append(HighLightView.f15037D[10]);
                } else if (h(charAt, f14914e)) {
                    sb.append(HighLightView.f15037D[16]);
                } else if (h(charAt, f14915f)) {
                    sb.append(HighLightView.f15037D[25]);
                } else if (h(charAt, f14916g)) {
                    sb.append(HighLightView.f15037D[29]);
                } else {
                    sb.append(charAt);
                }
            }
            return sb.toString();
        }
        return "";
    }

    public static boolean h(char c10, char[] cArr) {
        if (cArr == null) {
            return false;
        }
        for (char c11 : cArr) {
            if (c11 == c10) {
                return true;
            }
        }
        return false;
    }
}
