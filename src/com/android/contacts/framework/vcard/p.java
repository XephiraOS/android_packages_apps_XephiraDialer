package com.android.contacts.framework.vcard;

import java.util.Set;

/* compiled from: VCardParserImpl_V40.java */
/* loaded from: classes.dex */
public class p extends o {
    public static String L(char c10) {
        if (c10 != 'n' && c10 != 'N') {
            return String.valueOf(c10);
        }
        return "\n";
    }

    public static String O(String str) {
        StringBuilder sb = new StringBuilder();
        int length = str.length();
        int i10 = 0;
        while (i10 < length) {
            char charAt = str.charAt(i10);
            if (charAt == '\\' && i10 < length - 1) {
                i10++;
                char charAt2 = str.charAt(i10);
                if (charAt2 != 'n' && charAt2 != 'N') {
                    sb.append(charAt2);
                } else {
                    sb.append("\n");
                }
            } else {
                sb.append(charAt);
            }
            i10++;
        }
        return sb.toString();
    }

    @Override // com.android.contacts.framework.vcard.o, com.android.contacts.framework.vcard.n
    public String D(String str) {
        return O(str);
    }

    @Override // com.android.contacts.framework.vcard.o, com.android.contacts.framework.vcard.n
    public Set<String> f() {
        return s.f16553b;
    }

    @Override // com.android.contacts.framework.vcard.o, com.android.contacts.framework.vcard.n
    public int n() {
        return 2;
    }

    @Override // com.android.contacts.framework.vcard.o, com.android.contacts.framework.vcard.n
    public String o() {
        return "4.0";
    }
}
