package com.android.contacts.framework.vcard;

import android.content.ContentResolver;
import android.database.Cursor;
import android.provider.ContactsContract;
import android.text.TextUtils;
import com.android.contacts.business.calllog.breenocall.BreenoCallContract;
import com.android.contacts.model.Account;
import com.customize.contacts.backupandrestore.plugin.ContactBackupPlugin;
import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import l1.C1288a;

/* loaded from: classes.dex */
public class VCardUtils {

    /* renamed from: a, reason: collision with root package name */
    public static int f16466a;

    /* renamed from: b, reason: collision with root package name */
    public static final Map<Integer, String> f16467b;

    /* renamed from: c, reason: collision with root package name */
    public static final Set<String> f16468c;

    /* renamed from: d, reason: collision with root package name */
    public static final Map<String, Integer> f16469d;

    /* renamed from: e, reason: collision with root package name */
    public static final Map<Integer, String> f16470e;

    /* renamed from: f, reason: collision with root package name */
    public static final Set<String> f16471f;

    /* renamed from: g, reason: collision with root package name */
    public static final Set<Character> f16472g;

    /* renamed from: h, reason: collision with root package name */
    public static final int[] f16473h;

    /* renamed from: i, reason: collision with root package name */
    public static final int[] f16474i;

    /* loaded from: classes.dex */
    public static class DecoderException extends Exception {
        public DecoderException(String str) {
            super(str);
        }
    }

    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public static byte f16475a = 61;

        public static final byte[] a(byte[] bArr) {
            if (bArr == null) {
                return null;
            }
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            int i10 = 0;
            while (i10 < bArr.length) {
                byte b10 = bArr[i10];
                if (b10 == f16475a) {
                    try {
                        int digit = Character.digit((char) bArr[i10 + 1], 16);
                        i10 += 2;
                        int digit2 = Character.digit((char) bArr[i10], 16);
                        if (digit != -1 && digit2 != -1) {
                            byteArrayOutputStream.write((char) ((digit << 4) + digit2));
                        } else {
                            throw new DecoderException("Invalid quoted-printable encoding");
                        }
                    } catch (ArrayIndexOutOfBoundsException unused) {
                        throw new DecoderException("Invalid quoted-printable encoding");
                    }
                } else {
                    byteArrayOutputStream.write(b10);
                }
                i10++;
            }
            return byteArrayOutputStream.toByteArray();
        }
    }

    /* loaded from: classes.dex */
    public static class b {
        public static boolean a(char c10) {
            if ((' ' > c10 || c10 > '~') && c10 != '\r' && c10 != '\n') {
                return false;
            }
            return true;
        }

        public static boolean b(CharSequence charSequence) {
            int length = charSequence.length();
            for (int i10 = 0; i10 < length; i10++) {
                if (!a(charSequence.charAt(i10))) {
                    return false;
                }
            }
            return true;
        }
    }

    static {
        HashMap hashMap = new HashMap();
        f16467b = hashMap;
        HashMap hashMap2 = new HashMap();
        f16469d = hashMap2;
        hashMap.put(9, "CAR");
        hashMap2.put("CAR", 9);
        hashMap.put(6, "PAGER");
        hashMap2.put("PAGER", 6);
        hashMap.put(11, "ISDN");
        hashMap2.put("ISDN", 11);
        hashMap2.put("HOME", 1);
        hashMap2.put("WORK", 3);
        hashMap2.put("CELL", 2);
        hashMap2.put("OTHER", 7);
        hashMap2.put("CALLBACK", 8);
        hashMap2.put("COMPANY-MAIN", 10);
        hashMap2.put("RADIO", 14);
        hashMap2.put("TTY-TDD", 16);
        hashMap2.put("ASSISTANT", 19);
        hashMap2.put("VOICE", 7);
        hashMap2.put("TLX", 15);
        hashMap2.put("MSG", 20);
        HashSet hashSet = new HashSet();
        f16468c = hashSet;
        hashSet.add("MODEM");
        hashSet.add("MSG");
        hashSet.add("BBS");
        hashSet.add("VIDEO");
        HashMap hashMap3 = new HashMap();
        f16470e = hashMap3;
        hashMap3.put(0, "X-AIM");
        hashMap3.put(1, "X-MSN");
        hashMap3.put(2, "X-YAHOO");
        hashMap3.put(3, "X-SKYPE-USERNAME");
        hashMap3.put(5, "X-GOOGLE-TALK");
        hashMap3.put(6, "X-ICQ");
        hashMap3.put(7, "X-JABBER");
        hashMap3.put(4, "X-QQ");
        hashMap3.put(8, "X-NETMEETING");
        hashMap3.put(15, "X-WECHAT");
        f16471f = new HashSet(Arrays.asList("MOBILE", "携帯電話", "携帯", "ケイタイ", "ｹｲﾀｲ"));
        f16472g = new HashSet(Arrays.asList('[', ']', '=', ':', '.', ',', ' '));
        f16473h = new int[]{58, 59, 44, 32};
        f16474i = new int[]{59, 58};
    }

    public static void A(int i10) {
        f16466a = i10;
    }

    public static String[] B(int i10, String str, String str2, String str3) {
        String[] strArr = new String[3];
        int b10 = e.b(i10);
        if (b10 != 4) {
            if (b10 != 8) {
                if (C1288a.f34668a) {
                    strArr[0] = str;
                    strArr[1] = str2;
                    strArr[2] = str3;
                } else {
                    strArr[0] = str3;
                    strArr[1] = str2;
                    strArr[2] = str;
                }
            } else if (l(str) && l(str3)) {
                strArr[0] = str3;
                strArr[1] = str2;
                strArr[2] = str;
            } else {
                strArr[0] = str;
                strArr[1] = str2;
                strArr[2] = str3;
            }
        } else {
            strArr[0] = str2;
            strArr[1] = str3;
            strArr[2] = str;
        }
        return strArr;
    }

    public static String C(String str) {
        int length;
        if (str == null) {
            length = 0;
        } else {
            length = str.length();
        }
        if (length <= 0) {
            return str;
        }
        if (length > 200) {
            return str.substring(0, 201);
        }
        return str;
    }

    public static String D(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        int length = str.length();
        int i10 = 0;
        while (i10 < length) {
            char charAt = str.charAt(i10);
            String a10 = com.android.contacts.framework.vcard.b.a(charAt);
            if (a10 != null) {
                sb.append(a10);
            } else {
                sb.append(charAt);
            }
            i10 = str.offsetByCodePoints(i10, 1);
        }
        return sb.toString();
    }

    public static String E(String str, int[] iArr) {
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        StringBuilder sb = new StringBuilder();
        int length = str.length();
        boolean z10 = false;
        for (int i10 = 0; i10 < length; i10 = str.offsetByCodePoints(i10, 1)) {
            int codePointAt = str.codePointAt(i10);
            if (codePointAt >= 32 && codePointAt != 34) {
                sb.appendCodePoint(codePointAt);
                int length2 = iArr.length;
                int i11 = 0;
                while (true) {
                    if (i11 >= length2) {
                        break;
                    }
                    if (codePointAt == iArr[i11]) {
                        z10 = true;
                        break;
                    }
                    i11++;
                }
            }
        }
        String sb2 = sb.toString();
        if (sb2.isEmpty() || n(sb2)) {
            return "";
        }
        if (z10) {
            return '\"' + sb2 + '\"';
        }
        return sb2;
    }

    public static String F(String str) {
        return E(str, f16473h);
    }

    public static String G(String str) {
        return E(str, f16474i);
    }

    public static boolean a(String str) {
        int length = str.length() % 3;
        if (str.length() < 2 || (length != 1 && length != 0)) {
            return false;
        }
        for (int i10 = 0; i10 < str.length(); i10 += 3) {
            if (str.charAt(i10) != '=') {
                return false;
            }
        }
        return true;
    }

    public static boolean b(String... strArr) {
        if (strArr == null) {
            return true;
        }
        for (String str : strArr) {
            if (!TextUtils.isEmpty(str)) {
                return false;
            }
        }
        return true;
    }

    public static List<String> c(String str, int i10) {
        String L10;
        ArrayList arrayList = new ArrayList();
        StringBuilder sb = new StringBuilder();
        int length = str.length();
        int i11 = 0;
        while (i11 < length) {
            char charAt = str.charAt(i11);
            if (charAt == '\\' && i11 < length - 1) {
                int i12 = i11 + 1;
                char charAt2 = str.charAt(i12);
                if (e.h(i10)) {
                    L10 = p.L(charAt2);
                } else if (e.g(i10)) {
                    L10 = o.L(charAt2);
                } else {
                    if (!e.f(i10)) {
                        H7.b.i(h.LOG_TAG, "Unknown vCard type");
                    }
                    L10 = n.L(charAt2);
                }
                if (L10 != null) {
                    sb.append(L10);
                    i11 = i12;
                } else {
                    sb.append(charAt);
                }
            } else if (charAt == ';') {
                arrayList.add(sb.toString());
                sb = new StringBuilder();
            } else {
                sb.append(charAt);
            }
            i11++;
        }
        arrayList.add(sb.toString());
        return arrayList;
    }

    public static String d(int i10, String str, String str2, String str3) {
        return e(i10, str, str2, str3, null, null);
    }

    public static String e(int i10, String str, String str2, String str3, String str4, String str5) {
        boolean z10;
        StringBuilder sb = new StringBuilder();
        String[] B10 = B(i10, str, str2, str3);
        if (!TextUtils.isEmpty(str4)) {
            sb.append(str4);
            z10 = false;
        } else {
            z10 = true;
        }
        for (String str6 : B10) {
            if (!TextUtils.isEmpty(str6)) {
                if (z10) {
                    z10 = false;
                } else {
                    sb.append(' ');
                }
                sb.append(str6);
            }
        }
        if (!TextUtils.isEmpty(str5)) {
            if (!z10) {
                sb.append(' ');
            }
            sb.append(str5);
        }
        return sb.toString();
    }

    public static String f(String str, String str2, String str3) {
        StringBuilder sb = new StringBuilder();
        String[] strArr = {str, str2, str3};
        boolean z10 = true;
        for (int i10 = 0; i10 < 3; i10++) {
            String str4 = strArr[i10];
            if (!TextUtils.isEmpty(str4)) {
                if (z10) {
                    z10 = false;
                } else {
                    sb.append(' ');
                }
                sb.append(str4);
            }
        }
        return sb.toString();
    }

    public static boolean g(Collection<String> collection) {
        if (collection == null) {
            return true;
        }
        for (String str : collection) {
            if (!TextUtils.isEmpty(str)) {
                int length = str.length();
                for (int i10 = 0; i10 < length; i10 = str.offsetByCodePoints(i10, 1)) {
                    int codePointAt = str.codePointAt(i10);
                    if ((97 > codePointAt || codePointAt >= 123) && ((65 > codePointAt || codePointAt >= 91) && ((48 > codePointAt || codePointAt >= 58) && codePointAt != 45))) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public static boolean h(String... strArr) {
        if (strArr == null) {
            return true;
        }
        return g(Arrays.asList(strArr));
    }

    public static boolean i(Collection<String> collection) {
        if (collection == null) {
            return true;
        }
        for (String str : collection) {
            if (!TextUtils.isEmpty(str)) {
                int length = str.length();
                for (int i10 = 0; i10 < length; i10 = str.offsetByCodePoints(i10, 1)) {
                    int codePointAt = str.codePointAt(i10);
                    if (32 > codePointAt || codePointAt > 126) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public static boolean j(String... strArr) {
        if (strArr == null) {
            return true;
        }
        return i(Arrays.asList(strArr));
    }

    public static boolean k(Collection<String> collection) {
        if (collection == null) {
            return true;
        }
        for (String str : collection) {
            if (!TextUtils.isEmpty(str) && !b.b(str)) {
                return false;
            }
        }
        return true;
    }

    public static boolean l(String... strArr) {
        if (strArr == null) {
            return true;
        }
        return k(Arrays.asList(strArr));
    }

    public static boolean m(Collection<String> collection) {
        if (collection == null) {
            return true;
        }
        for (String str : collection) {
            if (!TextUtils.isEmpty(str)) {
                int length = str.length();
                for (int i10 = 0; i10 < length; i10 = str.offsetByCodePoints(i10, 1)) {
                    if (!Character.isWhitespace(str.codePointAt(i10))) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public static boolean n(String... strArr) {
        if (strArr == null) {
            return true;
        }
        return m(Arrays.asList(strArr));
    }

    public static final String o(String str, String str2, String str3) {
        if (str2.equalsIgnoreCase(str3)) {
            return str;
        }
        ByteBuffer encode = Charset.forName(str2).encode(str);
        byte[] bArr = new byte[encode.remaining()];
        encode.get(bArr);
        try {
            return new String(bArr, str3);
        } catch (UnsupportedEncodingException unused) {
            H7.b.c(h.LOG_TAG, "Failed to encode: charset=" + str3);
            return null;
        }
    }

    public static long p(ContentResolver contentResolver, String str, Account account) {
        String str2;
        if (TextUtils.isEmpty(str)) {
            return -1L;
        }
        if (str.contains("'")) {
            str = str.replace("'", "''");
        }
        if (account.d()) {
            str2 = "deleted=0 AND account_name IS NULL  AND account_type IS NULL ";
        } else {
            str2 = "deleted=0 AND account_name='" + account.f16941a + "'  AND account_type='" + account.f16942b + "' ";
        }
        Cursor cursor = null;
        try {
            try {
                Cursor query = contentResolver.query(ContactsContract.Groups.CONTENT_URI, new String[]{BreenoCallContract.BaseColumns._ID}, "title=? AND " + str2, new String[]{str}, null);
                if (query == null) {
                    if (query != null) {
                        query.close();
                    }
                    return -1L;
                }
                if (!query.moveToFirst()) {
                    query.close();
                    return -1L;
                }
                long j10 = query.getLong(0);
                query.close();
                return j10;
            } catch (Exception e10) {
                H7.b.c(h.LOG_TAG, "Exception e: " + e10);
                if (0 != 0) {
                    cursor.close();
                }
                return -1L;
            }
        } catch (Throwable th) {
            if (0 != 0) {
                cursor.close();
            }
            throw th;
        }
    }

    public static Object q(Collection<String> collection, String str) {
        boolean z10;
        if (str == null) {
            str = "";
        }
        boolean z11 = false;
        int i10 = -1;
        String str2 = null;
        if (collection != null) {
            Iterator<String> it = collection.iterator();
            z10 = false;
            boolean z12 = false;
            while (it.hasNext()) {
                String next = it.next();
                if (next != null) {
                    String upperCase = next.toUpperCase();
                    if (upperCase.equals("PREF")) {
                        z12 = true;
                    } else if (upperCase.equals("FAX")) {
                        z10 = true;
                    } else {
                        if (upperCase.startsWith("X-") && i10 < 0) {
                            next = next.substring(2);
                        }
                        if (next.length() != 0) {
                            Integer num = f16469d.get(next.toUpperCase());
                            if (num != null) {
                                int intValue = num.intValue();
                                int indexOf = str.indexOf("@");
                                if ((intValue == 6 && indexOf > 0 && indexOf < str.length() - 1) || i10 < 0 || i10 == 0 || i10 == 7) {
                                    i10 = num.intValue();
                                }
                            } else if (i10 < 0) {
                                i10 = 0;
                                str2 = next;
                            }
                        }
                    }
                }
            }
            z11 = z12;
        } else {
            z10 = false;
        }
        if (i10 < 0) {
            if (z11) {
                i10 = 12;
            } else {
                i10 = 1;
            }
        }
        if (z10) {
            if (i10 == 1) {
                i10 = 5;
            } else if (i10 == 3) {
                i10 = 4;
            } else if (i10 == 7) {
                i10 = 13;
            }
        }
        if (i10 == 0) {
            return str2;
        }
        return Integer.valueOf(i10);
    }

    public static String r(Integer num) {
        return f16467b.get(num);
    }

    public static int s() {
        return f16466a;
    }

    public static String t(int i10) {
        return f16470e.get(Integer.valueOf(i10));
    }

    public static int u(ContentResolver contentResolver, String str, Account account) {
        if (str == null || account == null) {
            return 0;
        }
        Cursor cursor = null;
        try {
            try {
                Cursor query = contentResolver.query(ContactsContract.Groups.CONTENT_URI, null, "title=? AND account_name='" + account.f16941a + "' AND account_type='" + account.f16942b + "' AND deleted=0", new String[]{str}, null);
                if (query == null) {
                    if (query != null) {
                        query.close();
                    }
                    return 0;
                }
                int count = query.getCount();
                query.close();
                return count;
            } catch (Exception e10) {
                H7.b.c(h.LOG_TAG, "Exception e: " + e10);
                if (0 != 0) {
                    cursor.close();
                }
                return 0;
            }
        } catch (Throwable th) {
            if (0 != 0) {
                cursor.close();
            }
            throw th;
        }
    }

    public static String v(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        if (bArr.length >= 3 && bArr[0] == 71 && bArr[1] == 73 && bArr[2] == 70) {
            return "GIF";
        }
        if (bArr.length >= 4 && bArr[0] == -119 && bArr[1] == 80 && bArr[2] == 78 && bArr[3] == 71) {
            return "PNG";
        }
        if (bArr.length < 2 || bArr[0] != -1 || bArr[1] != -40) {
            return null;
        }
        return "JPEG";
    }

    public static boolean w(String str) {
        if (!"_AUTO_CELL".equals(str) && !f16471f.contains(str)) {
            return false;
        }
        return true;
    }

    public static boolean x(String str) {
        if (TextUtils.isEmpty(str)) {
            return true;
        }
        int length = str.length();
        int i10 = 0;
        while (i10 < length) {
            int codePointAt = str.codePointAt(i10);
            if (32 > codePointAt || codePointAt > 126 || f16472g.contains(Character.valueOf((char) codePointAt))) {
                return false;
            }
            i10 = str.offsetByCodePoints(i10, 1);
        }
        return true;
    }

    public static boolean y(String str) {
        return f16468c.contains(str);
    }

    public static String z(String str, boolean z10, String str2, String str3) {
        String[] strArr;
        byte[] bytes;
        int i10;
        char charAt;
        StringBuilder sb = new StringBuilder();
        int length = str.length();
        int i11 = 0;
        while (i11 < length) {
            char charAt2 = str.charAt(i11);
            if (charAt2 == '=' && i11 < length - 1 && ((charAt = str.charAt((i10 = i11 + 1))) == ' ' || charAt == '\t')) {
                sb.append(charAt);
                i11 = i10;
            } else {
                sb.append(charAt2);
            }
            i11++;
        }
        String sb2 = sb.toString();
        if (z10) {
            strArr = sb2.split(ContactBackupPlugin.END_OF_LINE);
        } else {
            StringBuilder sb3 = new StringBuilder();
            int length2 = sb2.length();
            ArrayList arrayList = new ArrayList();
            int i12 = 0;
            while (i12 < length2) {
                char charAt3 = sb2.charAt(i12);
                if (charAt3 == '\n') {
                    arrayList.add(sb3.toString());
                    sb3 = new StringBuilder();
                } else if (charAt3 == '\r') {
                    arrayList.add(sb3.toString());
                    sb3 = new StringBuilder();
                    if (i12 < length2 - 1) {
                        int i13 = i12 + 1;
                        if (sb2.charAt(i13) == '\n') {
                            i12 = i13;
                        }
                    }
                } else {
                    sb3.append(charAt3);
                }
                i12++;
            }
            String sb4 = sb3.toString();
            if (sb4.length() > 0) {
                arrayList.add(sb4);
            }
            strArr = (String[]) arrayList.toArray(new String[0]);
        }
        StringBuilder sb5 = new StringBuilder();
        for (String str4 : strArr) {
            if (str4.endsWith("=")) {
                str4 = str4.substring(0, str4.length() - 1);
            }
            sb5.append(str4);
        }
        String sb6 = sb5.toString();
        if (TextUtils.isEmpty(sb6)) {
            H7.b.i(h.LOG_TAG, "Given raw string is empty.");
        }
        try {
            bytes = sb6.getBytes(str2);
        } catch (UnsupportedEncodingException unused) {
            H7.b.i(h.LOG_TAG, "Failed to decode: " + str2);
            bytes = sb6.getBytes();
        }
        try {
            bytes = a.a(bytes);
        } catch (DecoderException unused2) {
            H7.b.c(h.LOG_TAG, "DecoderException is thrown.");
        }
        try {
            return new String(bytes, str3);
        } catch (UnsupportedEncodingException unused3) {
            H7.b.c(h.LOG_TAG, "Failed to encode: charset=" + str3);
            return new String(bytes);
        }
    }
}
