package com.oua.ocr.bc;

import com.oua.ocr.ContactInfo;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.function.Consumer;
import java.util.regex.Pattern;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: libBCREngine.java */
/* loaded from: classes4.dex */
public class Company {
    static HashSet<Integer> langSet;
    static String negative;
    static Pattern re_Negative;
    static ArrayList<String> res;
    public ArrayList<String[]> results;
    static ReToken re_company_beg = new ReToken();
    static ReToken re_company_mid = new ReToken();
    static ReToken re_company_end = new ReToken();
    static Pattern re_Department = Pattern.compile("(企画部|部门|发展处|研究院|办公室|分会|群|专营店|代表处|办|科|lab|技术院|研究室|r&d|单位|所|委员会|大中华区|laboratory|office|branch|institute|section|department|research|center|div.|division|dept.|ministry|部|中心|实验室|学院|處|处|部|组|群|unit|bureau|课)$", 66);
    static Pattern re_Company_tokens_0 = Pattern.compile("(有限公司$|ltd\\.?$|\bco\\.?\b|l\\.?d\\.?$|limited$|company$|corporation$)", 66);
    static Pattern re_Company_tokens_1 = Pattern.compile("(3m|有限公司|有限|\\bled\\b|ltd\\.?|co[.\\s,]*td.?$|\bco\\.?\b|l\\.?d\\.?$)", 66);

    public static void compile(HashSet<Integer> hashSet) {
        langSet = hashSet;
        re_Negative = Pattern.compile("(" + negative + ")", 66);
        re_company_beg.compile_beg();
        re_company_mid.compile();
        re_company_end.compile_end();
    }

    public static void init() {
        negative = "市|省|邮[\\s政证]*编[码]?|許可|番号|郵編|办事处|地址|公众号|微博|楼|registered|your|\\broom\\b|\\bst\\.?\\b|park|\\bbuilding\\b|suite|add\\:|\\bplaza\\b|街|@|层|网页|邮箱|路|q\\s*q|@|ww|\\brom\\b|skype|微信|\\bwechat\\b|\\bp\\.?o\\.?b\\b|\\broad|endereço|zone";
        re_company_beg.init();
        re_company_mid.init();
        re_company_end.init();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$contains$0(BBox bBox, BCard bCard, String[] strArr) {
        bBox.fields.add(strArr);
        if (strArr[0].equals("Others")) {
            return;
        }
        bCard.items.add(new ContactInfo.CompanyItem(strArr[1], Character.toLowerCase(strArr[0].split("\\.")[1].charAt(0))));
        LogUtil.println("Company => " + strArr[0] + " | " + strArr[1] + " | " + strArr[2]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$contains$1(final BCard bCard, final BBox bBox) {
        if (bBox.fields.size() == bCard.use_gt && contains(bBox.text).booleanValue()) {
            this.results.forEach(new Consumer() { // from class: com.oua.ocr.bc.e
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    Company.lambda$contains$0(BBox.this, bCard, (String[]) obj);
                }
            });
        }
    }

    public static void update(Info info) {
        re_company_beg.update(info.company_beg_tokens, info.company_beg_tokens_cn);
        re_company_mid.update(info.company_tokens, info.company_tokens_cn);
        re_company_end.update(info.company_end_tokens, info.company_end_tokens_cn);
    }

    public Boolean contains(String str) {
        int i10 = 0;
        for (int i11 = 0; i11 < str.length(); i11++) {
            if (str.charAt(i11) == ',') {
                i10++;
            }
            if (i10 >= 2) {
                return Boolean.FALSE;
            }
        }
        this.results = new ArrayList<>();
        if (Regex.find_all(str, re_Company_tokens_0).size() > 0) {
            this.results.add(new String[]{"Company.Company.re_Company_tokens_0", str, ""});
            return Boolean.TRUE;
        }
        if (Regex.find_all(str, re_Negative).size() > 0) {
            return Boolean.FALSE;
        }
        if (Regex.find_all(str, re_Company_tokens_1).size() > 0) {
            this.results.add(new String[]{"Company.Company.re_Company_tokens_1", str, ""});
            return Boolean.TRUE;
        }
        if (Regex.contains_numbers(str).booleanValue()) {
            return Boolean.FALSE;
        }
        if (Regex.find_all(str, re_Department).size() > 0) {
            this.results.add(new String[]{"Company.Department.re_Department", str, ""});
            return Boolean.TRUE;
        }
        ArrayList<String> find_all = re_company_beg.find_all(str);
        res = find_all;
        if (find_all.size() > 0) {
            this.results.add(new String[]{"Company.Company.re_company_beg", str, res.get(0)});
            return Boolean.TRUE;
        }
        ArrayList<String> find_all2 = re_company_mid.find_all(str);
        res = find_all2;
        if (find_all2.size() > 0) {
            this.results.add(new String[]{"Company.Company.re_company_mid", str, res.get(0)});
            return Boolean.TRUE;
        }
        ArrayList<String> find_all3 = re_company_end.find_all(str);
        res = find_all3;
        if (find_all3.size() > 0) {
            this.results.add(new String[]{"Company.Company.re_company_end", str, res.get(0)});
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

    public void contains(final BCard bCard) {
        bCard.bboxes.forEach(new Consumer() { // from class: com.oua.ocr.bc.d
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                Company.this.lambda$contains$1(bCard, (BBox) obj);
            }
        });
    }
}
