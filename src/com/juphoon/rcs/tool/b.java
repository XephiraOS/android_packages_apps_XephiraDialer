package com.juphoon.rcs.tool;

import android.text.TextUtils;
import com.android.incallui.OplusPhoneUtils;
import java.util.HashSet;
import java.util.Set;

/* compiled from: RcsNumberUtils.java */
/* loaded from: classes3.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    public static Set<String> f25570a;

    public static boolean a(char c10) {
        if (c10 != '+' && (c10 < '0' || c10 > '9')) {
            return false;
        }
        return true;
    }

    public static String b(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        for (int i10 = 0; i10 < str.length(); i10++) {
            char charAt = str.charAt(i10);
            if (a(charAt)) {
                sb.append(charAt);
            }
        }
        return sb.toString();
    }

    public static String c(String str) {
        boolean z10;
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        String b10 = b(str);
        if (b10.startsWith("+")) {
            b10 = b10.substring(1);
        } else if (b10.startsWith("00")) {
            b10 = b10.substring(2);
        } else {
            z10 = false;
            f();
            if (!z10 && b10.length() >= 9) {
                for (int i10 = 4; i10 >= 1; i10--) {
                    if (f25570a.contains(b10.substring(0, i10))) {
                        return b10.substring(i10);
                    }
                }
                return b10;
            }
        }
        z10 = true;
        f();
        return !z10 ? b10 : b10;
    }

    public static String d(String str, String str2) {
        int i10;
        if (!TextUtils.isEmpty(str) && str.length() >= 7 && !TextUtils.isEmpty(str2)) {
            StringBuilder sb = new StringBuilder();
            if (str.startsWith("00")) {
                sb.append("+");
                i10 = 2;
            } else {
                if (!str.startsWith("+")) {
                    sb.append("+");
                    sb.append(str2);
                }
                i10 = 0;
            }
            while (i10 < str.length()) {
                char charAt = str.charAt(i10);
                if (a(charAt)) {
                    sb.append(charAt);
                }
                i10++;
            }
            return sb.toString();
        }
        return str;
    }

    public static String e(String str) {
        String substring;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String b10 = b(str);
        if (b10.startsWith("+")) {
            substring = b10.substring(1);
        } else {
            if (b10.startsWith("00")) {
                substring = b10.substring(2);
            }
            return null;
        }
        f();
        if (substring.length() >= 9) {
            for (int i10 = 4; i10 >= 1; i10--) {
                String substring2 = substring.substring(0, i10);
                if (f25570a.contains(substring2)) {
                    return substring2;
                }
            }
        }
        return null;
    }

    public static void f() {
        if (f25570a != null) {
            return;
        }
        HashSet hashSet = new HashSet();
        f25570a = hashSet;
        hashSet.add("376");
        f25570a.add("971");
        f25570a.add("93");
        f25570a.add("1268");
        f25570a.add("1264");
        f25570a.add("355");
        f25570a.add("374");
        f25570a.add("599");
        f25570a.add("244");
        f25570a.add("672");
        f25570a.add("54");
        f25570a.add("1684");
        f25570a.add("43");
        f25570a.add("61");
        f25570a.add("297");
        f25570a.add("358");
        f25570a.add("994");
        f25570a.add("387");
        f25570a.add("1246");
        f25570a.add("880");
        f25570a.add("32");
        f25570a.add("226");
        f25570a.add("359");
        f25570a.add("973");
        f25570a.add("257");
        f25570a.add("229");
        f25570a.add("590");
        f25570a.add("1441");
        f25570a.add("673");
        f25570a.add("591");
        f25570a.add("55");
        f25570a.add("1242");
        f25570a.add("975");
        f25570a.add("47");
        f25570a.add("267");
        f25570a.add("375");
        f25570a.add("501");
        f25570a.add(OplusPhoneUtils.DeviceState.LOCK_DEVICE);
        f25570a.add("61");
        f25570a.add("243");
        f25570a.add("236");
        f25570a.add("242");
        f25570a.add("41");
        f25570a.add("225");
        f25570a.add("682");
        f25570a.add("56");
        f25570a.add("237");
        f25570a.add("86");
        f25570a.add("57");
        f25570a.add("506");
        f25570a.add("53");
        f25570a.add("238");
        f25570a.add("61");
        f25570a.add("357");
        f25570a.add("420");
        f25570a.add("49");
        f25570a.add("253");
        f25570a.add("45");
        f25570a.add("1767");
        f25570a.add("1809");
        f25570a.add("213");
        f25570a.add("593");
        f25570a.add("372");
        f25570a.add("20");
        f25570a.add("212");
        f25570a.add("291");
        f25570a.add("34");
        f25570a.add("251");
        f25570a.add("358");
        f25570a.add("679");
        f25570a.add("500");
        f25570a.add("691");
        f25570a.add("298");
        f25570a.add("33");
        f25570a.add("241");
        f25570a.add("44");
        f25570a.add("1473");
        f25570a.add("995");
        f25570a.add("594");
        f25570a.add("1481");
        f25570a.add("233");
        f25570a.add("350");
        f25570a.add("299");
        f25570a.add("220");
        f25570a.add("224");
        f25570a.add("590");
        f25570a.add("240");
        f25570a.add("30");
        f25570a.add("500");
        f25570a.add("502");
        f25570a.add("1671");
        f25570a.add("245");
        f25570a.add("592");
        f25570a.add("852");
        f25570a.add("672");
        f25570a.add("504");
        f25570a.add("385");
        f25570a.add("509");
        f25570a.add("36");
        f25570a.add("62");
        f25570a.add("353");
        f25570a.add("972");
        f25570a.add("44");
        f25570a.add("91");
        f25570a.add("246");
        f25570a.add("964");
        f25570a.add("98");
        f25570a.add("354");
        f25570a.add("39");
        f25570a.add("44");
        f25570a.add("1876");
        f25570a.add("962");
        f25570a.add("81");
        f25570a.add("254");
        f25570a.add("996");
        f25570a.add("855");
        f25570a.add("686");
        f25570a.add("269");
        f25570a.add("1869");
        f25570a.add("850");
        f25570a.add("82");
        f25570a.add("965");
        f25570a.add("1345");
        f25570a.add("7");
        f25570a.add("856");
        f25570a.add("961");
        f25570a.add("1758");
        f25570a.add("423");
        f25570a.add("94");
        f25570a.add("231");
        f25570a.add("266");
        f25570a.add("370");
        f25570a.add("352");
        f25570a.add("371");
        f25570a.add("218");
        f25570a.add("212");
        f25570a.add("377");
        f25570a.add("373");
        f25570a.add("382");
        f25570a.add("1599");
        f25570a.add("261");
        f25570a.add("692");
        f25570a.add("389");
        f25570a.add("223");
        f25570a.add("95");
        f25570a.add("976");
        f25570a.add("853");
        f25570a.add("1670");
        f25570a.add("596");
        f25570a.add("222");
        f25570a.add("1664");
        f25570a.add("356");
        f25570a.add("230");
        f25570a.add("960");
        f25570a.add("265");
        f25570a.add("52");
        f25570a.add("60");
        f25570a.add("258");
        f25570a.add("264");
        f25570a.add("687");
        f25570a.add("227");
        f25570a.add("6723");
        f25570a.add("234");
        f25570a.add("505");
        f25570a.add("31");
        f25570a.add("47");
        f25570a.add("977");
        f25570a.add("674");
        f25570a.add("683");
        f25570a.add("64");
        f25570a.add("968");
        f25570a.add("507");
        f25570a.add("51");
        f25570a.add("689");
        f25570a.add("675");
        f25570a.add("63");
        f25570a.add("92");
        f25570a.add("48");
        f25570a.add("508");
        f25570a.add("872");
        f25570a.add("1787");
        f25570a.add("970");
        f25570a.add("351");
        f25570a.add("680");
        f25570a.add("595");
        f25570a.add("974");
        f25570a.add("262");
        f25570a.add("40");
        f25570a.add("381");
        f25570a.add("7");
        f25570a.add("250");
        f25570a.add("966");
        f25570a.add("677");
        f25570a.add("248");
        f25570a.add("249");
        f25570a.add("46");
        f25570a.add("65");
        f25570a.add("290");
        f25570a.add("386");
        f25570a.add("47");
        f25570a.add("421");
        f25570a.add("232");
        f25570a.add("378");
        f25570a.add("221");
        f25570a.add("252");
        f25570a.add("597");
        f25570a.add("239");
        f25570a.add("503");
        f25570a.add("963");
        f25570a.add("268");
        f25570a.add("1649");
        f25570a.add("235");
        f25570a.add("596");
        f25570a.add("228");
        f25570a.add("66");
        f25570a.add("992");
        f25570a.add("690");
        f25570a.add("670");
        f25570a.add("993");
        f25570a.add("216");
        f25570a.add("676");
        f25570a.add("90");
        f25570a.add("1868");
        f25570a.add("688");
        f25570a.add("886");
        f25570a.add("255");
        f25570a.add("380");
        f25570a.add("256");
        f25570a.add("699");
        f25570a.add(OplusPhoneUtils.DeviceState.LOCK_DEVICE);
        f25570a.add("598");
        f25570a.add("998");
        f25570a.add("379");
        f25570a.add("1784");
        f25570a.add("58");
        f25570a.add("1284");
        f25570a.add("1340");
        f25570a.add("84");
        f25570a.add("678");
        f25570a.add("681");
        f25570a.add("685");
        f25570a.add("967");
        f25570a.add("269");
        f25570a.add("27");
        f25570a.add("260");
        f25570a.add("263");
    }
}
