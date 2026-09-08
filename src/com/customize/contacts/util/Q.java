package com.customize.contacts.util;

import android.text.TextUtils;
import com.heytap.accessory.constant.FastPairConstants;
import java.text.CollationKey;
import java.text.Collator;
import java.text.RuleBasedCollator;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;

/* compiled from: NameNormalizer.java */
/* loaded from: classes3.dex */
public final class Q {

    /* renamed from: a, reason: collision with root package name */
    public static final char[] f21931a;

    /* renamed from: b, reason: collision with root package name */
    public static final char[] f21932b;

    /* renamed from: c, reason: collision with root package name */
    public static final char[] f21933c;

    /* renamed from: d, reason: collision with root package name */
    public static final RuleBasedCollator f21934d;

    static {
        RuleBasedCollator ruleBasedCollator = (RuleBasedCollator) Collator.getInstance(Locale.US);
        f21934d = ruleBasedCollator;
        ruleBasedCollator.setStrength(0);
        ruleBasedCollator.setDecomposition(1);
        f21932b = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
        f21931a = new char[256];
        f21933c = new char[256];
        for (int i10 = 0; i10 < 256; i10++) {
            char[] cArr = f21931a;
            char[] cArr2 = f21932b;
            cArr[i10] = cArr2[(i10 >> 4) & 15];
            f21933c[i10] = cArr2[i10 & 15];
        }
    }

    public static String a(byte[] bArr, boolean z10) {
        char[] cArr = new char[bArr.length * 2];
        int i10 = 0;
        for (int i11 = 0; i11 < bArr.length; i11++) {
            int i12 = bArr[i11] & FastPairConstants.GO_INTENT_NOT_SET;
            if (z10 && i12 == 0 && i11 == bArr.length - 1) {
                break;
            }
            int i13 = i10 + 1;
            cArr[i10] = f21931a[i12];
            i10 += 2;
            cArr[i13] = f21933c[i12];
        }
        return new String(cArr, 0, i10);
    }

    public static String b(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        char[] charArray = str.toCharArray();
        int i10 = 0;
        for (char c10 : charArray) {
            if (Character.isLetterOrDigit(c10)) {
                charArray[i10] = c10;
                i10++;
            }
        }
        if (i10 != charArray.length) {
            return new String(charArray, 0, i10);
        }
        return str;
    }

    public static String c(String str) {
        CollationKey collationKey = f21934d.getCollationKey(b(str));
        if (collationKey == null) {
            return "";
        }
        return a(collationKey.toByteArray(), true);
    }

    public static ArrayList<String> d(ArrayList<String> arrayList) {
        ArrayList<String> arrayList2 = new ArrayList<>(arrayList.size());
        Iterator<String> it = arrayList.iterator();
        while (it.hasNext()) {
            String c10 = c(it.next());
            if (!TextUtils.isEmpty(c10)) {
                arrayList2.add(c10);
            }
        }
        return arrayList2;
    }
}
