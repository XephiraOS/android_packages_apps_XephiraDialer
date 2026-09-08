package com.oua.ocr.bc;

import com.oua.ocr.ContactInfo;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.function.Consumer;
import java.util.regex.Pattern;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: libBCREngine.java */
/* loaded from: classes4.dex */
public class Address {
    static HashSet<Integer> langSet;
    static String name;
    static ArrayList<String> res_Cities;
    static ArrayList<String> res_Countries;
    static ArrayList<String> res_Locations;
    static ArrayList<String> res_Provinces;
    public ArrayList<String[]> results;
    static ReToken re_level0 = new ReToken();
    static ReToken re_level1 = new ReToken();
    static ReToken re_level2 = new ReToken();
    static ReToken re_location = new ReToken();
    static String json_zipcode = "";
    static Pattern re_Numbers = Pattern.compile("([0-9\\-#]+)", 66);
    static Pattern re_Postcodes = Pattern.compile("([0-9]{5,})", 66);
    static Pattern re_Postcodes_uk = Pattern.compile("\\b((?:(?:gir)|(?:[a-pr-uwyz])(?:(?:[0-9](?:[a-hjkpstuw]|[0-9])?)|(?:[a-hk-y][0-9](?:[0-9]|[abehmnprv-y])?)))) ?([0-9][abd-hjlnp-uw-z]{2})(?:\\b|$)", 66);
    static Pattern re_Negative = Pattern.compile("(www|\\.com|portable|\\bdirect line\\b|許可|認証|番号|毫米波|雷达|公众号|電\\s*郵|手\\s*機|電\\s*話|电\\s*话|传\\s*真|总监|手\\s*机|邮\\s*箱|fax|有限公司|傳\\s*真|经理|e-mail|email|mobile|\\biso\\b|id\\:)", 66);

    public static void compile(HashSet<Integer> hashSet) {
        langSet = hashSet;
        re_level0.compile();
        re_level1.compile();
        re_level2.compile();
        re_location.compile();
    }

    public static void init() {
        re_level0.init();
        re_level1.init();
        re_level2.init();
        re_location.init();
        json_zipcode = "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$contains$0(BBox bBox, String[] strArr) {
        if (strArr[0].equals("Address")) {
            bBox.fields.add(strArr);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$contains$1(Boolean bool, String[] strArr, String[] strArr2) {
        String str;
        String str2;
        if (bool.booleanValue()) {
            StringBuilder sb = new StringBuilder();
            sb.append(strArr[1]);
            if (strArr[1].length() == 0) {
                str2 = strArr2[1];
            } else {
                str2 = " " + strArr2[1];
            }
            sb.append(str2);
            strArr[1] = sb.toString();
            strArr[2] = strArr[2] + strArr2[2];
            strArr[3] = strArr[3] + strArr2[3];
            strArr[4] = strArr[4] + strArr2[4];
            strArr[5] = strArr[5] + strArr2[5];
            return;
        }
        StringBuilder sb2 = new StringBuilder();
        if (strArr[1].length() == 0) {
            str = strArr2[1];
        } else {
            str = strArr2[1] + " ";
        }
        sb2.append(str);
        sb2.append(strArr[1]);
        strArr[1] = sb2.toString();
        strArr[2] = strArr2[2] + strArr[2];
        strArr[3] = strArr2[3] + strArr[3];
        strArr[4] = strArr2[4] + strArr[4];
        strArr[5] = strArr2[5] + strArr[5];
    }

    public static void update(Info info) {
        re_level0.update(info.address_level0, info.address_level0_cn);
        re_level1.update(info.address_level1, info.address_level1_cn);
        re_level2.update(info.address_level2, info.address_level2_cn);
        re_location.update(info.address_tokens, info.address_tokens_cn);
        json_zipcode = Utils.extend(json_zipcode, info.address_zipcode);
    }

    public int check_size(ArrayList<String> arrayList) {
        return new HashSet(arrayList).size();
    }

    public Boolean contains(String str, int i10) {
        if (Regex.find_all(str, re_Negative).size() > 0) {
            return Boolean.FALSE;
        }
        int i11 = i10 > 0 ? 0 : 1;
        match(str);
        this.results = new ArrayList<>();
        ArrayList<String> find_all = Regex.find_all(str, re_Numbers);
        LogUtil.println("Address => " + str + " | " + res_Locations.size() + " | " + find_all.size());
        if (res_Countries.size() + res_Provinces.size() + res_Cities.size() == 0 && res_Locations.size() + find_all.size() <= i11) {
            if (find_all.size() + res_Locations.size() > 0) {
                this.results.add(new String[]{"Others", str});
            }
            return Boolean.FALSE;
        }
        boolean z10 = Regex.which_language(str) == 5;
        Boolean valueOf = Boolean.valueOf(z10);
        ArrayList<String> find_all2 = Regex.find_all(str, re_Postcodes);
        LogUtil.println("Zipcode => " + str + " | " + find_all2 + " | " + valueOf);
        if (find_all2.size() == 0 && !z10) {
            find_all2 = Regex.find_all(str, re_Postcodes_uk);
        }
        ArrayList<String[]> arrayList = this.results;
        String pick_location = pick_location(res_Countries, valueOf);
        String pick_location2 = pick_location(res_Provinces, valueOf);
        String pick_location3 = pick_location(res_Cities, valueOf);
        Boolean bool = Boolean.FALSE;
        arrayList.add(new String[]{"Address", str, pick_location, pick_location2, pick_location3, pick_location(find_all2, bool)});
        LogUtil.println("Address => Location:" + str + "|" + pick_location(res_Countries, valueOf) + "|" + pick_location(res_Provinces, valueOf) + "|" + pick_location(res_Cities, valueOf) + "|" + pick_location(find_all2, bool));
        return Boolean.TRUE;
    }

    public void match(String str) {
        res_Locations = re_location.find_all(str);
        res_Countries = re_level0.find_all(str);
        res_Provinces = re_level1.find_all(str);
        res_Cities = re_level2.find_all(str);
    }

    public String pick_location(ArrayList<String> arrayList, Boolean bool) {
        if (arrayList.size() == 0) {
            return new String("");
        }
        if (arrayList.size() != 1 && !bool.booleanValue()) {
            return arrayList.get(arrayList.size() - 1);
        }
        return arrayList.get(0);
    }

    public String toString() {
        return "Address \n[level0_cn: " + re_level0.cn + "], \n[level1_cn: " + re_level1.cn + "], \n[level2_cn: " + re_level2.cn + "]\nAddress \n[level0_en: " + re_level0.en + "], \n[level1_en: " + re_level1.en + "], \n[level2_en: " + re_level2.en + "]\n";
    }

    public void contains(BCard bCard) {
        int i10;
        int i11;
        int i12;
        char c10;
        char c11;
        char c12;
        final String[] strArr = new String[6];
        strArr[0] = "";
        strArr[1] = "";
        strArr[2] = "";
        strArr[3] = "";
        strArr[4] = "";
        strArr[5] = "";
        int size = bCard.bboxes.size() - 1;
        final Boolean isCJK = Utils.isCJK(langSet);
        if (isCJK.booleanValue()) {
            i10 = 1;
            i11 = size;
            i12 = 0;
        } else {
            i12 = bCard.bboxes.size() - 1;
            i11 = 0;
            i10 = -1;
        }
        int i13 = 0;
        int i14 = -1;
        while (true) {
            final BBox bBox = bCard.bboxes.get(i12);
            boolean z10 = bBox.fields.size() == 0 && contains(bBox.text, i13).booleanValue() && this.results.size() > 0;
            if (z10) {
                this.results.forEach(new Consumer() { // from class: com.oua.ocr.bc.a
                    @Override // java.util.function.Consumer
                    public final void accept(Object obj) {
                        Address.lambda$contains$0(BBox.this, (String[]) obj);
                    }
                });
            }
            if (i13 > 0 && (!z10 || ((i14 != -1 && i14 != bBox.lang) || ((this.results.get(0)[2].length() > 0 && strArr[2].length() > 0) || ((this.results.get(0)[3].length() > 0 && strArr[3].length() > 0) || ((this.results.get(0)[4].length() > 0 && strArr[4].length() > 0) || (this.results.get(0)[5].length() > 0 && strArr[5].length() > 0))))))) {
                bCard.items.add(new ContactInfo.AddressItem(strArr[1], strArr[2], strArr[3], strArr[4], strArr[5]));
                LogUtil.println("Address => Added: " + strArr[1]);
                for (int i15 = 0; i15 < 6; i15++) {
                    strArr[i15] = "";
                }
                i13 = 0;
            }
            if (z10) {
                this.results.forEach(new Consumer() { // from class: com.oua.ocr.bc.b
                    @Override // java.util.function.Consumer
                    public final void accept(Object obj) {
                        Address.lambda$contains$1(isCJK, strArr, (String[]) obj);
                    }
                });
                i13++;
                i14 = bBox.lang;
                LogUtil.println("Address => has_result: " + bBox.text + " | " + i14);
            }
            if (i13 <= 0 || i12 != i11) {
                c10 = 2;
                c11 = 3;
                c12 = 4;
            } else {
                c10 = 2;
                c11 = 3;
                c12 = 4;
                bCard.items.add(new ContactInfo.AddressItem(strArr[1], strArr[2], strArr[3], strArr[4], strArr[5]));
            }
            if (i12 == i11) {
                return;
            } else {
                i12 += i10;
            }
        }
    }
}
