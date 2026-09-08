package I3;

import android.content.Context;
import android.text.TextUtils;
import java.lang.Character;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* compiled from: ContactInfo.java */
/* loaded from: classes3.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    public int f1310a = 0;

    /* renamed from: b, reason: collision with root package name */
    public HashMap<String, ArrayList<a>> f1311b;

    public b() {
        this.f1311b = null;
        this.f1311b = new HashMap<>();
    }

    public static String a(String str, String str2, String str3, String str4, String str5) {
        if (str5 == null) {
            str5 = "";
        }
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(str)) {
            sb.append(str);
            sb.append(str5);
        }
        if (!TextUtils.isEmpty(str2)) {
            sb.append(str2);
            sb.append(str5);
        }
        if (!TextUtils.isEmpty(str3)) {
            sb.append(str3);
            sb.append(str5);
        }
        if (!TextUtils.isEmpty(str4)) {
            sb.append(str4);
            sb.append(str5);
        }
        String sb2 = sb.toString();
        if (!TextUtils.isEmpty(str5)) {
            return sb2.substring(0, sb2.length() - str5.length());
        }
        return sb2;
    }

    public static boolean b(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        for (char c10 : str.toCharArray()) {
            if (h(c10)) {
                return true;
            }
        }
        return false;
    }

    public static b f(Context context) {
        return new b();
    }

    public static boolean h(char c10) {
        Character.UnicodeBlock of = Character.UnicodeBlock.of(c10);
        if (of != Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS && of != Character.UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS && of != Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_A && of != Character.UnicodeBlock.GENERAL_PUNCTUATION && of != Character.UnicodeBlock.CJK_SYMBOLS_AND_PUNCTUATION && of != Character.UnicodeBlock.HALFWIDTH_AND_FULLWIDTH_FORMS) {
            return false;
        }
        return true;
    }

    public static boolean i(String[] strArr, String str) {
        if (strArr == null || strArr.length == 0) {
            return false;
        }
        if (str == null) {
            return true;
        }
        for (int i10 = 0; i10 != strArr.length; i10++) {
            if (str.equals(strArr[i10])) {
                return true;
            }
        }
        return false;
    }

    public HashMap<String, ArrayList<a>> c() {
        return this.f1311b;
    }

    public ArrayList<a> d(String str) {
        if (this.f1311b.containsKey(str)) {
            return this.f1311b.get(str);
        }
        return null;
    }

    public String e() {
        a aVar;
        ArrayList<a> d10 = d("vnd.android.cursor.item/name");
        if (d10 == null || d10.isEmpty() || (aVar = d10.get(0)) == null) {
            return null;
        }
        String a10 = aVar.a(2);
        String a11 = aVar.a(4);
        String a12 = aVar.a(1);
        String a13 = aVar.a(5);
        if (!b(a10) && !b(a11) && !b(a12) && !b(a13)) {
            return a(a12, a11, a10, a13, null);
        }
        return a(a10, a11, a12, a13, null);
    }

    public int g() {
        return this.f1310a;
    }

    public void j(b bVar, String[] strArr) {
        if (bVar == null) {
            return;
        }
        for (Map.Entry<String, ArrayList<a>> entry : bVar.c().entrySet()) {
            String key = entry.getKey();
            ArrayList<a> value = entry.getValue();
            if (H7.a.b()) {
                H7.b.b("ContactInfo", "mimetype = " + key);
            }
            if (!i(strArr, key)) {
                l(key, value);
            }
        }
    }

    public void k(a aVar) {
        ArrayList<a> arrayList;
        if (aVar == null) {
            return;
        }
        String e10 = aVar.e();
        if (!this.f1311b.containsKey(e10)) {
            arrayList = new ArrayList<>();
            this.f1311b.put(e10, arrayList);
        } else {
            arrayList = this.f1311b.get(e10);
        }
        arrayList.add(aVar);
    }

    public void l(String str, ArrayList<a> arrayList) {
        if (arrayList != null && !arrayList.isEmpty()) {
            if (!this.f1311b.containsKey(str)) {
                this.f1311b.put(str, arrayList);
            } else {
                this.f1311b.get(str).addAll(arrayList);
            }
        }
    }

    public void m(HashMap<String, ArrayList<a>> hashMap) {
        HashMap<String, ArrayList<a>> hashMap2 = this.f1311b;
        if (hashMap2 != null) {
            hashMap2.putAll(hashMap);
        }
    }

    public void n(int i10) {
        this.f1310a = i10;
    }
}
