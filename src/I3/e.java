package I3;

import I3.d;
import android.content.Context;
import android.telephony.PhoneNumberUtils;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.HashMap;

/* compiled from: CsvImporterDefault.java */
/* loaded from: classes3.dex */
public class e extends d {

    /* renamed from: n, reason: collision with root package name */
    public Context f1331n;

    public e(Context context, String[] strArr) {
        super(context);
        this.f1331n = context;
        if (H7.a.b()) {
            H7.b.b("CsvImporterDefault", "Build CsvImporterDefault.");
        }
    }

    public void C(int i10, String str, a aVar, a aVar2) {
        String replaceAll = str.replaceAll(" ::: ", "");
        if (44 == i10) {
            E(3, 1, replaceAll, "vnd.android.cursor.dir/postal-address_v2", aVar);
            return;
        }
        if (45 == i10) {
            E(6, 1, replaceAll, "vnd.android.cursor.dir/postal-address_v2", aVar);
            return;
        }
        if (46 == i10) {
            E(8, 1, replaceAll, "vnd.android.cursor.dir/postal-address_v2", aVar);
            return;
        }
        if (47 == i10) {
            E(7, 1, replaceAll, "vnd.android.cursor.dir/postal-address_v2", aVar);
            return;
        }
        if (48 == i10) {
            E(9, 1, replaceAll, "vnd.android.cursor.dir/postal-address_v2", aVar);
            return;
        }
        if (49 == i10) {
            E(4, 1, replaceAll, "vnd.android.cursor.dir/postal-address_v2", aVar);
            return;
        }
        if (62 == i10) {
            E(0, 1, replaceAll, "vnd.android.cursor.dir/postal-address_v2", aVar);
            return;
        }
        if (50 == i10) {
            E(3, 2, replaceAll, "vnd.android.cursor.dir/postal-address_v2", aVar2);
            return;
        }
        if (51 == i10) {
            E(6, 2, replaceAll, "vnd.android.cursor.dir/postal-address_v2", aVar2);
            return;
        }
        if (52 == i10) {
            E(8, 2, replaceAll, "vnd.android.cursor.dir/postal-address_v2", aVar2);
            return;
        }
        if (53 == i10) {
            E(7, 2, replaceAll, "vnd.android.cursor.dir/postal-address_v2", aVar2);
        } else if (54 == i10) {
            E(9, 2, replaceAll, "vnd.android.cursor.dir/postal-address_v2", aVar2);
        } else if (55 == i10) {
            E(4, 2, replaceAll, "vnd.android.cursor.dir/postal-address_v2", aVar2);
        }
    }

    public void D(int i10, String str, String str2, ArrayList<a> arrayList) {
        a aVar = new a();
        aVar.i(str2);
        aVar.j(i10);
        aVar.g(0, str);
        arrayList.add(aVar);
        this.f1315c = true;
    }

    public void E(int i10, int i11, String str, String str2, a aVar) {
        aVar.i(str2);
        aVar.g(i10, str);
        aVar.j(i11);
        this.f1315c = true;
    }

    public void F(int i10, String str, ArrayList<a> arrayList) {
        if (28 == i10) {
            D(1, str, "vnd.android.cursor.item/email_v2", arrayList);
        } else if (29 == i10) {
            D(2, str, "vnd.android.cursor.item/email_v2", arrayList);
        }
    }

    public void G(int i10, String str, ArrayList<a> arrayList) {
        if (76 == i10) {
            D(3, str, "vnd.android.cursor.item/contact_event", arrayList);
        } else if (77 == i10) {
            D(1, str, "vnd.android.cursor.item/contact_event", arrayList);
        }
    }

    public void H(String str, String str2, String[] strArr, String[] strArr2, ArrayList<a> arrayList) {
        String[] split;
        String replace = str.replace("Type", "Value");
        if (replace != null) {
            for (int i10 = 0; i10 < strArr.length; i10++) {
                if (replace.equals(strArr[i10]) && (split = strArr2[i10].split(" ::: ")) != null) {
                    for (String str3 : split) {
                        a aVar = new a();
                        aVar.i("vnd.android.cursor.item/email_v2");
                        int S10 = S(str2);
                        if (S10 == -1) {
                            aVar.h(str2);
                            aVar.j(0);
                        } else {
                            aVar.j(S10);
                        }
                        aVar.g(0, str3);
                        arrayList.add(aVar);
                    }
                    this.f1315c = true;
                }
            }
        }
    }

    public void I(String str, String str2, a aVar) {
        aVar.i("vnd.android.cursor.item/organization");
        if (str.endsWith("Name")) {
            aVar.g(0, str2);
        }
        if (str.endsWith("Title")) {
            aVar.g(3, str2);
        }
        aVar.j(1);
        this.f1315c = true;
    }

    public void J(String str, String str2, String[] strArr, String[] strArr2, ArrayList<a> arrayList) {
        String replace = str.replace("Type", "Value");
        if (replace != null) {
            for (int i10 = 0; i10 < strArr.length; i10++) {
                if (replace.equals(strArr[i10])) {
                    String[] split = strArr2[i10].split(" ::: ");
                    if (split != null) {
                        for (String str3 : split) {
                            a aVar = new a();
                            aVar.i("vnd.android.cursor.item/phone_v2");
                            int T10 = T(str2);
                            if (T10 == -1) {
                                aVar.h(str2);
                                aVar.j(0);
                            } else {
                                aVar.j(T10);
                            }
                            aVar.g(0, str3);
                            arrayList.add(aVar);
                        }
                        this.f1315c = true;
                        return;
                    }
                    return;
                }
            }
        }
    }

    public void K(int i10, String str, a aVar) {
        if (i10 == 0) {
            aVar.i("vnd.android.cursor.item/name");
            aVar.g(2, str);
            this.f1315c = true;
            return;
        }
        if (1 == i10) {
            aVar.i("vnd.android.cursor.item/name");
            aVar.g(4, str);
            this.f1315c = true;
            return;
        }
        if (2 == i10) {
            aVar.i("vnd.android.cursor.item/name");
            aVar.g(1, str);
            this.f1315c = true;
            return;
        }
        if (3 == i10) {
            aVar.i("vnd.android.cursor.item/name");
            aVar.g(3, str);
            this.f1315c = true;
            return;
        }
        if (4 == i10) {
            aVar.i("vnd.android.cursor.item/name");
            aVar.g(5, str);
            this.f1315c = true;
            return;
        }
        if (6 == i10) {
            aVar.i("vnd.android.cursor.item/name");
            aVar.g(6, str);
            this.f1315c = true;
            return;
        }
        if (7 == i10) {
            aVar.i("vnd.android.cursor.item/name");
            aVar.g(7, str);
            this.f1315c = true;
        } else if (8 == i10) {
            aVar.i("vnd.android.cursor.item/name");
            aVar.g(8, str);
            this.f1315c = true;
        } else if (9 == i10) {
            aVar.i("vnd.android.cursor.item/name");
            aVar.g(0, str);
            this.f1315c = true;
        }
    }

    public void L(int i10, String str, ArrayList<a> arrayList) {
        if (i10 == 81) {
            a aVar = new a();
            aVar.i("vnd.android.cursor.item/nickname");
            aVar.g(0, str);
            arrayList.add(aVar);
            this.f1315c = true;
        }
    }

    public void M(int i10, String str, ArrayList<a> arrayList) {
        if (39 == i10) {
            a aVar = new a();
            aVar.i("vnd.android.cursor.item/website");
            aVar.g(0, str);
            arrayList.add(aVar);
            this.f1315c = true;
        }
    }

    public void N(int i10, String str, a aVar) {
        aVar.i("vnd.android.cursor.item/organization");
        if (i10 == 71) {
            aVar.g(0, str);
        }
        if (i10 == 72) {
            aVar.g(3, str);
        }
        aVar.j(1);
        this.f1315c = true;
    }

    public void O(int i10, String str, ArrayList<a> arrayList, ArrayList<a> arrayList2) {
        String[] split;
        if (40 == i10 && (split = str.split(" ::: ")) != null && split.length > 0) {
            for (String str2 : split) {
                int indexOf = str2.indexOf(":");
                if (indexOf != -1) {
                    Integer num = a.f1305e.get(str2.substring(0, indexOf));
                    String substring = str2.substring(indexOf + 1);
                    if (num != null) {
                        P(num.intValue(), substring, arrayList);
                        F(num.intValue(), substring, arrayList2);
                    }
                }
            }
        }
    }

    public void P(int i10, String str, ArrayList<a> arrayList) {
        String stripSeparators = PhoneNumberUtils.stripSeparators(str);
        if (TextUtils.isEmpty(stripSeparators)) {
            return;
        }
        if (13 == i10) {
            D(2, stripSeparators, "vnd.android.cursor.item/phone_v2", arrayList);
            return;
        }
        if (14 == i10) {
            D(1, stripSeparators, "vnd.android.cursor.item/phone_v2", arrayList);
            return;
        }
        if (15 == i10) {
            D(3, stripSeparators, "vnd.android.cursor.item/phone_v2", arrayList);
            return;
        }
        if (17 == i10) {
            D(12, stripSeparators, "vnd.android.cursor.item/phone_v2", arrayList);
            return;
        }
        if (18 == i10) {
            D(6, stripSeparators, "vnd.android.cursor.item/phone_v2", arrayList);
            return;
        }
        if (16 == i10) {
            D(7, stripSeparators, "vnd.android.cursor.item/phone_v2", arrayList);
        } else if (22 == i10) {
            D(5, stripSeparators, "vnd.android.cursor.item/phone_v2", arrayList);
        } else if (23 == i10) {
            D(4, stripSeparators, "vnd.android.cursor.item/phone_v2", arrayList);
        }
    }

    public void Q(int i10, String str, ArrayList<a> arrayList) {
        if (33 == i10 || 34 == i10 || 35 == i10) {
            a aVar = new a();
            aVar.i("vnd.android.cursor.item/website");
            aVar.g(0, str);
            arrayList.add(aVar);
            this.f1315c = true;
        }
    }

    public void R(int i10, String str, ArrayList<a> arrayList) {
        String str2;
        if (i10 == 66) {
            long p10 = p(str);
            if (p10 != -1) {
                a aVar = new a();
                aVar.i("vnd.android.cursor.item/group_membership");
                aVar.g(0, String.valueOf(p10));
                arrayList.add(aVar);
                this.f1315c = true;
                return;
            }
            return;
        }
        if (i10 == 67) {
            String[] split = str.split(" ::: ");
            for (int i11 = 0; i11 != split.length; i11++) {
                if (split[i11].startsWith("* ")) {
                    str2 = split[i11].substring(2);
                    if (!"My Contacts".equals(str2)) {
                        if ("Starred".equals(str2)) {
                        }
                    }
                } else {
                    str2 = split[i11];
                }
                long p11 = p(str2);
                if (p11 != -1) {
                    a aVar2 = new a();
                    aVar2.i("vnd.android.cursor.item/group_membership");
                    aVar2.g(0, String.valueOf(p11));
                    arrayList.add(aVar2);
                    this.f1315c = true;
                }
            }
        }
    }

    public int S(String str) {
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        if (!"* Home".equals(str) && !"Home".equals(str)) {
            if (!"Work".equals(str) && !"* Work".equals(str)) {
                return -1;
            }
            return 2;
        }
        return 1;
    }

    public int T(String str) {
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        if ("Home".equals(str)) {
            return 1;
        }
        if ("Mobile".equals(str)) {
            return 2;
        }
        if ("Work Fax".equals(str)) {
            return 3;
        }
        if ("Work Fax".equals(str)) {
            return 4;
        }
        if ("Home Fax".equals(str)) {
            return 5;
        }
        if ("pager".equals(str)) {
            return 6;
        }
        if (!"Main".equals(str)) {
            return -1;
        }
        return 12;
    }

    @Override // I3.d
    public b d(ArrayList<String[]> arrayList) {
        HashMap<String, ArrayList<a>> hashMap;
        int i10;
        ArrayList<a> arrayList2;
        ArrayList<a> arrayList3;
        ArrayList<a> arrayList4;
        String[] strArr;
        ArrayList<a> arrayList5;
        ArrayList<a> arrayList6;
        ArrayList<a> arrayList7;
        if (arrayList == null || arrayList.isEmpty()) {
            return null;
        }
        int i11 = 0;
        String[] strArr2 = arrayList.get(0);
        if (strArr2 == null) {
            return null;
        }
        String[] s10 = s();
        b f10 = b.f(this.f1331n);
        HashMap<String, ArrayList<a>> hashMap2 = new HashMap<>();
        ArrayList<a> arrayList8 = new ArrayList<>();
        ArrayList<a> arrayList9 = new ArrayList<>();
        ArrayList<a> arrayList10 = new ArrayList<>();
        ArrayList<a> arrayList11 = new ArrayList<>();
        ArrayList<a> arrayList12 = new ArrayList<>();
        ArrayList<a> arrayList13 = new ArrayList<>();
        ArrayList<a> arrayList14 = new ArrayList<>();
        ArrayList<a> arrayList15 = new ArrayList<>();
        ArrayList<a> arrayList16 = new ArrayList<>();
        ArrayList<a> arrayList17 = new ArrayList<>();
        a aVar = new a();
        a aVar2 = new a();
        a aVar3 = new a();
        a aVar4 = new a();
        if (!u(strArr2)) {
            ArrayList<a> arrayList18 = arrayList14;
            while (i11 < strArr2.length && i11 < s10.length) {
                if (!TextUtils.isEmpty(strArr2[i11]) && !TextUtils.isEmpty(s10[i11])) {
                    String str = s10[i11];
                    strArr = s10;
                    Integer num = a.f1305e.get(str);
                    if (num != null) {
                        int intValue = num.intValue();
                        K(intValue, strArr2[i11], aVar);
                        P(intValue, strArr2[i11], arrayList9);
                        F(intValue, strArr2[i11], arrayList10);
                        N(intValue, strArr2[i11], aVar2);
                        R(intValue, strArr2[i11], arrayList12);
                        L(intValue, strArr2[i11], arrayList13);
                        C(intValue, strArr2[i11], aVar3, aVar4);
                        Q(intValue, strArr2[i11], arrayList15);
                        G(intValue, strArr2[i11], arrayList16);
                        M(intValue, strArr2[i11], arrayList17);
                        O(intValue, strArr2[i11], arrayList9, arrayList10);
                        i10 = i11;
                        arrayList2 = arrayList15;
                        arrayList3 = arrayList13;
                        arrayList4 = arrayList17;
                    } else {
                        ArrayList<a> arrayList19 = arrayList16;
                        if (str.startsWith("Phone") && str.endsWith("Type")) {
                            arrayList4 = arrayList17;
                            i10 = i11;
                            arrayList6 = arrayList18;
                            arrayList5 = arrayList19;
                            arrayList2 = arrayList15;
                            arrayList3 = arrayList13;
                            arrayList7 = arrayList12;
                            J(str, strArr2[i11], strArr, strArr2, arrayList9);
                        } else {
                            arrayList2 = arrayList15;
                            arrayList3 = arrayList13;
                            arrayList4 = arrayList17;
                            arrayList6 = arrayList18;
                            arrayList5 = arrayList19;
                            i10 = i11;
                            arrayList7 = arrayList12;
                            if (strArr[i10].startsWith("E-mail") && strArr[i10].endsWith("Type")) {
                                H(str, strArr2[i10], strArr, strArr2, arrayList10);
                            } else if (strArr[i10].startsWith("Organization") && (strArr[i10].endsWith("Name") || strArr[i10].endsWith("Title"))) {
                                I(strArr[i10], strArr2[i10], aVar2);
                            } else {
                                this.f1316d.add(str);
                            }
                        }
                        i11 = i10 + 1;
                        arrayList12 = arrayList7;
                        arrayList16 = arrayList5;
                        arrayList17 = arrayList4;
                        arrayList15 = arrayList2;
                        arrayList13 = arrayList3;
                        arrayList18 = arrayList6;
                        s10 = strArr;
                    }
                } else {
                    i10 = i11;
                    arrayList2 = arrayList15;
                    arrayList3 = arrayList13;
                    arrayList4 = arrayList17;
                    strArr = s10;
                }
                arrayList6 = arrayList18;
                arrayList5 = arrayList16;
                arrayList7 = arrayList12;
                i11 = i10 + 1;
                arrayList12 = arrayList7;
                arrayList16 = arrayList5;
                arrayList17 = arrayList4;
                arrayList15 = arrayList2;
                arrayList13 = arrayList3;
                arrayList18 = arrayList6;
                s10 = strArr;
            }
            ArrayList<a> arrayList20 = arrayList18;
            arrayList11.add(aVar2);
            arrayList8.add(aVar);
            arrayList20.add(aVar3);
            arrayList20.add(aVar4);
            hashMap = hashMap2;
            hashMap.put("vnd.android.cursor.item/name", arrayList8);
            hashMap.put("vnd.android.cursor.item/organization", arrayList11);
            hashMap.put("vnd.android.cursor.item/phone_v2", arrayList9);
            hashMap.put("vnd.android.cursor.item/email_v2", arrayList10);
            hashMap.put("vnd.android.cursor.item/group_membership", arrayList12);
            hashMap.put("vnd.android.cursor.item/nickname", arrayList13);
            hashMap.put("vnd.android.cursor.item/postal-address_v2", arrayList20);
            hashMap.put("vnd.android.cursor.item/website", arrayList15);
            hashMap.put("vnd.android.cursor.item/contact_event", arrayList16);
            hashMap.put("vnd.android.cursor.item/note", arrayList17);
        } else {
            hashMap = hashMap2;
        }
        if (!this.f1315c) {
            return null;
        }
        f10.m(hashMap);
        return f10;
    }

    @Override // I3.d
    public d.a[] r() {
        return null;
    }
}
