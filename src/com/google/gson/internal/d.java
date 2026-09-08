package com.google.gson.internal;

/* compiled from: JavaVersion.java */
/* loaded from: classes3.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public static final int f24801a = a();

    public static int a() {
        return c(System.getProperty("java.version"));
    }

    public static int b(String str) {
        try {
            StringBuilder sb = new StringBuilder();
            for (int i10 = 0; i10 < str.length(); i10++) {
                char charAt = str.charAt(i10);
                if (!Character.isDigit(charAt)) {
                    break;
                }
                sb.append(charAt);
            }
            return Integer.parseInt(sb.toString());
        } catch (NumberFormatException unused) {
            return -1;
        }
    }

    public static int c(String str) {
        int e10 = e(str);
        if (e10 == -1) {
            e10 = b(str);
        }
        if (e10 == -1) {
            return 6;
        }
        return e10;
    }

    public static boolean d() {
        if (f24801a >= 9) {
            return true;
        }
        return false;
    }

    public static int e(String str) {
        try {
            String[] split = str.split("[._]");
            int parseInt = Integer.parseInt(split[0]);
            if (parseInt == 1 && split.length > 1) {
                return Integer.parseInt(split[1]);
            }
            return parseInt;
        } catch (NumberFormatException unused) {
            return -1;
        }
    }
}
