package com.oua.ocr.bc;

import com.oua.ocr.ContactInfo;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.function.Consumer;
import java.util.regex.Pattern;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: libBCREngine.java */
/* loaded from: classes4.dex */
public class Title {
    static HashSet<Integer> langSet;
    public ArrayList<String[]> results;
    static Pattern re_Negative = Pattern.compile("(邮[\\s政证]*编[码]?|地址|\\bmbH(?:$\\b)|\\bGmbH(?:$\\b)|IDENTIFICATION|\\bid\\b|Signature|MANAGEMENT SYSTEM|許可|番号|時間|統編|厦|郵件|cdgm|email|e-mail|your|\\broom\\b|\\bst\\.?\\b|統一|\\bbuilding\\b|suite|add\\:|\\bplaza\\b|編號|统一|编号|街|股票|@|纳税|识别号|证券|代码|层|郵編|网页|邮箱|路|Japan|q\\s*q|@|ww|\\brom\\b|skype|israrl|israel|有限公司|税號|微信|\\bwechat\\b|\\bp\\.?o\\.?b\\b|ltd\\.|\\broad|\\boy[\\.,\\s]*$|会社$|部$|课$|グループ$|営業課$|^MANAGEMENT$|^ce$)", 66);
    static String dec_titles = "供应商|design|sourcing|account|department|运营|研发|品质|品质部|国内|国内销售|中国区|华南公司|数据服务|材料|工艺部|pc工艺|现场|安全|国内|营业|应用工程师|运营商|副总裁|業務|業務代表|資深|大客户|投资|經理|北大|清華|清华|技术|业务|高性能|实验室|副总监|主任高性能|商界|项目|营运|商务|營業|渠道|自商務長|事務部長|运营总监|資深經理|产品总监|商务总监|常务副总|执行总经理|所长|资深经理|资深业务拓展经理|资深|产品方案销售经理|产品|市场经理|市场|联合创始人|业务代表";
    static ReToken re_titles_beg = new ReToken();
    static ReToken re_titles_end = new ReToken();
    static Pattern re_Name = Pattern.compile(".{2,30}(博士|教授|p\\.?h\\.?d)", 66);

    public static void compile(HashSet<Integer> hashSet) {
        langSet = hashSet;
        re_titles_beg.compile_beg();
        ReToken reToken = re_titles_end;
        ReToken reToken2 = re_titles_beg;
        reToken.cn = reToken2.cn;
        reToken.en = reToken2.en;
        reToken.compile_end();
    }

    public static void init() {
        re_titles_beg.init();
        re_titles_end.init();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$contains$0(String str, String str2) {
        LogUtil.println("Title => re_titles_beg: " + str + " | " + str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$contains$1(String str, String str2) {
        LogUtil.println("Title => re_titles_end: " + str + " | " + str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$contains$2(BBox bBox, BCard bCard, String[] strArr) {
        bBox.fields.add(strArr);
        if (strArr[0].indexOf("Title") >= 0) {
            bCard.items.add(new ContactInfo.CompanyItem(strArr[1], 't'));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$contains$3(final BCard bCard, final BBox bBox) {
        if (bBox.fields.size() == bCard.use_gt && contains(bBox.text).booleanValue()) {
            bCard.Title_idx.add(Integer.valueOf(bBox.idx));
            this.results.forEach(new Consumer() { // from class: com.oua.ocr.bc.u
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    Title.lambda$contains$2(BBox.this, bCard, (String[]) obj);
                }
            });
        }
    }

    public static void update(Info info) {
        re_titles_beg.update(info.titles, info.titles_cn);
    }

    public Boolean contains(final String str) {
        ArrayList<String> find_all = Regex.find_all(str, re_Negative);
        int i10 = 0;
        if (find_all.size() > 0) {
            LogUtil.println("Title => negative: " + str + " | " + find_all.get(0));
            return Boolean.FALSE;
        }
        this.results = new ArrayList<>();
        ArrayList<String[]> find_all_groups = Regex.find_all_groups(str, re_Name);
        if (find_all_groups.size() > 0) {
            this.results.add(new String[]{"Title.re_Name", find_all_groups.get(0)[1]});
            LogUtil.println("Title => re_Name: " + str + " | " + find_all_groups.get(0)[1]);
            return Boolean.TRUE;
        }
        this.results = new ArrayList<>();
        String[] split = str.toLowerCase().split("[\\-\\|,，\\(\\)\\/\\&\\!]| of | and | to | der ");
        int length = split.length;
        while (true) {
            if (i10 >= length) {
                break;
            }
            String str2 = split[i10];
            if (Regex.find_all(str2, Regex.re_Numbers).size() <= 0) {
                ArrayList<String> find_all2 = re_titles_beg.find_all(str2);
                if (find_all2.size() > 0) {
                    if (str.length() >= 3 && (str.toLowerCase().indexOf("dr.") == 0 || str.toLowerCase().indexOf("dr ") == 0)) {
                        this.results.add(new String[]{"Title.dr", "Dr."});
                        LogUtil.println("Title => re_titles_dr: " + str + " | Doctor");
                    } else {
                        this.results.add(new String[]{"Title.re_titles_beg", str});
                        find_all2.forEach(new Consumer() { // from class: com.oua.ocr.bc.s
                            @Override // java.util.function.Consumer
                            public final void accept(Object obj) {
                                Title.lambda$contains$0(str, (String) obj);
                            }
                        });
                    }
                } else {
                    ArrayList<String> find_all3 = re_titles_end.find_all(str2);
                    if (find_all3.size() > 0) {
                        this.results.add(new String[]{"Title.re_titles_end", str});
                        find_all3.forEach(new Consumer() { // from class: com.oua.ocr.bc.t
                            @Override // java.util.function.Consumer
                            public final void accept(Object obj) {
                                Title.lambda$contains$1(str, (String) obj);
                            }
                        });
                        break;
                    }
                }
            }
            i10++;
        }
        if (this.results.size() == 0) {
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }

    public void contains(final BCard bCard) {
        bCard.bboxes.forEach(new Consumer() { // from class: com.oua.ocr.bc.r
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                Title.this.lambda$contains$3(bCard, (BBox) obj);
            }
        });
    }
}
