package com.oplus.google.i18n.phonenumbers.prefixmapper;

import java.io.Externalizable;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

/* loaded from: classes3.dex */
public class MappingFileProvider implements Externalizable {

    /* renamed from: a, reason: collision with root package name */
    public static final Map<String, String> f28377a;
    private List<Set<String>> availableLanguages;
    private int[] countryCallingCodes;
    private int numOfEntries = 0;

    static {
        HashMap hashMap = new HashMap();
        hashMap.put("zh_TW", "zh_Hant");
        hashMap.put("zh_HK", "zh_Hant");
        hashMap.put("zh_MO", "zh_Hant");
        f28377a = Collections.unmodifiableMap(hashMap);
    }

    public final void a(String str, StringBuilder sb) {
        if (str.length() > 0) {
            sb.append('_');
            sb.append(str);
        }
    }

    public final StringBuilder b(String str, String str2, String str3) {
        StringBuilder sb = new StringBuilder(str);
        a(str2, sb);
        a(str3, sb);
        return sb;
    }

    public final String c(Set<String> set, String str, String str2, String str3) {
        String sb = b(str, str2, str3).toString();
        String str4 = f28377a.get(sb);
        if (str4 != null && set.contains(str4)) {
            return str4;
        }
        if (set.contains(sb)) {
            return sb;
        }
        if (e(str2, str3)) {
            if (set.contains(str)) {
                return str;
            }
            return "";
        }
        if (str2.length() > 0 && str3.length() > 0) {
            String str5 = str + '_' + str2;
            if (set.contains(str5)) {
                return str5;
            }
            String str6 = str + '_' + str3;
            if (set.contains(str6)) {
                return str6;
            }
            if (set.contains(str)) {
                return str;
            }
            return "";
        }
        return "";
    }

    public String d(int i10, String str, String str2, String str3) {
        int binarySearch;
        if (str.length() == 0 || (binarySearch = Arrays.binarySearch(this.countryCallingCodes, i10)) < 0) {
            return "";
        }
        Set<String> set = this.availableLanguages.get(binarySearch);
        if (set.size() > 0) {
            String c10 = c(set, str, str2, str3);
            if (c10.length() > 0) {
                return i10 + '_' + c10;
            }
        }
        return "";
    }

    public final boolean e(String str, String str2) {
        if ((str.length() == 0 && str2.length() > 0) || (str2.length() == 0 && str.length() > 0)) {
            return true;
        }
        return false;
    }

    @Override // java.io.Externalizable
    public void readExternal(ObjectInput objectInput) {
        int readInt = objectInput.readInt();
        this.numOfEntries = readInt;
        int[] iArr = this.countryCallingCodes;
        if (iArr == null || iArr.length < readInt) {
            this.countryCallingCodes = new int[readInt];
        }
        if (this.availableLanguages == null) {
            this.availableLanguages = new ArrayList();
        }
        for (int i10 = 0; i10 < this.numOfEntries; i10++) {
            this.countryCallingCodes[i10] = objectInput.readInt();
            int readInt2 = objectInput.readInt();
            HashSet hashSet = new HashSet();
            for (int i11 = 0; i11 < readInt2; i11++) {
                hashSet.add(objectInput.readUTF());
            }
            this.availableLanguages.add(hashSet);
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i10 = 0; i10 < this.numOfEntries; i10++) {
            sb.append(this.countryCallingCodes[i10]);
            sb.append('|');
            Iterator it = new TreeSet(this.availableLanguages.get(i10)).iterator();
            while (it.hasNext()) {
                sb.append((String) it.next());
                sb.append(',');
            }
            sb.append('\n');
        }
        return sb.toString();
    }

    @Override // java.io.Externalizable
    public void writeExternal(ObjectOutput objectOutput) {
        objectOutput.writeInt(this.numOfEntries);
        for (int i10 = 0; i10 < this.numOfEntries; i10++) {
            objectOutput.writeInt(this.countryCallingCodes[i10]);
            Set<String> set = this.availableLanguages.get(i10);
            objectOutput.writeInt(set.size());
            Iterator<String> it = set.iterator();
            while (it.hasNext()) {
                objectOutput.writeUTF(it.next());
            }
        }
    }
}
