package com.oua.ocr.bc;

import com.android.incallui.OplusPhoneUtils;
import com.oua.ocr.ContactInfo;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.function.Consumer;
import java.util.regex.Pattern;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: libBCREngine.java */
/* loaded from: classes4.dex */
public class Phone {
    static HashSet<String> ext;
    static HashSet<String> fax;
    static HashSet<Integer> langSet;
    static Boolean lang_flag;
    static HashSet<Integer> langs;
    public ArrayList<String[]> results;
    static ReToken re_phone = new ReToken();
    static Pattern re_Negative = Pattern.compile("(\\bcep\\b|av\\.|地址|統編|許可|番号|ビル|階|〒|head|cert\\.?|stock|认证号|\\broom\\b|\\bst\\.?\\b|統一|\\bbuilding\\b|\\bdirector\\b|\\bplaza\\b|室|postcode|post|p\\.?c\\.?|zipcode|code|zip|編號|统一|编号|主任|街|股票|纳税|识别号|证券|代码|层|郵編|网页|邮箱|路|ISO|Japan|add:?|\\brom\\b|skype|israrl|israel|有限公司|税號|微信|\\bwechat\\b|\\bp\\.?o\\.?b\\b)", 66);
    static int min_length = 7;
    static float ratio = 0.1f;
    static HashSet<String> Phone_Work = new HashSet<>(Arrays.asList("销售", "销售热线", "销售电话", "续保电话", "热线", "电话", "座机", "总机", "専綫", "直线", "直线电话", "線", "线", "客服", "客服热线", "分机", "分機", "内线", "company", com.android.contacts.list.d.f16900U, "dial", "did", "dir", "direct", "main", com.android.contacts.util.o.f17586f, "office", "p", "phone", "support", "t", "hot", "line", "l", "general line"));
    static HashSet<String> Phone_Mobile = new HashSet<>(Arrays.asList("手機", "電話", "電话", "行动电话", "行動", "行動電話", "移动电话", "手提電話", "手机", "mobile", "手提", "tel", "telephone", "tell", "cell", "m", "mb", "mob", "mobile", "mp", "portable"));

    public static void compile(HashSet<Integer> hashSet) {
        boolean z10;
        langSet = hashSet;
        re_phone.pre();
        re_phone.re = Pattern.compile("((?:^|\\b)(?:" + re_phone.en + ")|(?:" + re_phone.cn + "))*[)\\s:;\\/／\\.：]*((?!\\s)[\\+0-9\\s()\\[\\]\\-\\.\\/\\*（）_#Oo]{3,})", 66);
        StringBuilder sb = new StringBuilder();
        sb.append("Ext => ");
        sb.append(ext);
        LogUtil.println(sb.toString());
        if (!langs.contains(50) && !langs.contains(49) && !langs.contains(59)) {
            z10 = false;
        } else {
            z10 = true;
        }
        lang_flag = Boolean.valueOf(z10);
        min_length = 7;
        ratio = 0.1f;
        if (langs.contains(54) || langs.contains(48) || langs.contains(52) || langs.contains(55)) {
            min_length = 9;
            ratio = 0.3f;
        }
    }

    public static void init() {
        re_phone.init();
        langs = new HashSet<>();
        fax = new HashSet<>();
        ext = new HashSet<>();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$contains$0(BBox bBox, BCard bCard, String[] strArr) {
        bBox.fields.add(strArr);
        bCard.items.add(new ContactInfo.PhoneItem(strArr[1], strArr[0].split("\\.")[1]));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$contains$1(final BCard bCard, final BBox bBox) {
        if (bBox.fields.size() == bCard.use_gt && contains(bBox.text).booleanValue()) {
            this.results.forEach(new Consumer() { // from class: com.oua.ocr.bc.q
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    Phone.lambda$contains$0(BBox.this, bCard, (String[]) obj);
                }
            });
        }
    }

    public static void update(Info info) {
        langs.add(Integer.valueOf(info.lang));
        re_phone.update(info.phone_tokens, info.phone_tokens_cn);
        re_phone.update(info.fax_tokens, info.fax_tokens_cn);
        re_phone.update(info.phone_ext_tokens, info.phone_ext_tokens_cn);
        if (info.fax_tokens.length() > 0) {
            fax.addAll(Arrays.asList(info.fax_tokens.split("\\|")));
        }
        if (info.fax_tokens_cn.length() > 0) {
            fax.addAll(Arrays.asList(info.fax_tokens_cn.split("\\|")));
        }
        if (info.phone_ext_tokens.length() > 0) {
            ext.addAll(Arrays.asList(info.phone_ext_tokens.split("\\|")));
        }
        if (info.phone_ext_tokens_cn.length() > 0) {
            ext.addAll(Arrays.asList(info.phone_ext_tokens_cn.split("\\|")));
        }
    }

    public Boolean contains(String str) {
        if (Regex.find_all(str, re_Negative).size() > 0) {
            return Boolean.FALSE;
        }
        ArrayList<MatchGroup> find_all_match_groups = Regex.find_all_match_groups(str, re_phone.re);
        if (find_all_match_groups.size() == 0) {
            return Boolean.FALSE;
        }
        Boolean bool = Boolean.FALSE;
        this.results = new ArrayList<>();
        Iterator<MatchGroup> it = find_all_match_groups.iterator();
        while (it.hasNext()) {
            String[] strArr = it.next().group;
            strArr[1] = strArr[1].toLowerCase();
            String replaceAll = strArr[2].replaceAll("[\\.·\\-()\\s（）]", "");
            strArr[2] = replaceAll;
            strArr[2] = replaceAll.replaceAll("[Oo]", OplusPhoneUtils.DeviceState.UNLOCK_DEVICE);
            LogUtil.println("Phone => " + strArr[0] + "|" + strArr[1] + "|" + strArr[2] + "|");
            if (strArr[2].length() >= 3) {
                if (strArr[1].length() > 0 && !strArr[1].equals(com.android.contacts.list.d.f16900U) && !strArr[1].equals("f")) {
                    bool = Boolean.TRUE;
                }
                if (strArr[1].length() > 0 && fax.contains(strArr[1])) {
                    this.results.add(new String[]{"Phone.FAX_WORK", strArr[2]});
                } else if (this.results.size() > 0 && ext.contains(strArr[1])) {
                    StringBuilder sb = new StringBuilder();
                    ArrayList<String[]> arrayList = this.results;
                    String[] strArr2 = arrayList.get(arrayList.size() - 1);
                    sb.append(strArr2[1]);
                    sb.append(",,");
                    sb.append(strArr[2]);
                    strArr2[1] = sb.toString();
                } else if ((this.results.size() > 0 && Regex.count_numbers(strArr[2]) >= min_length) || strArr[1].length() >= 2 || ((strArr[1].length() == 1 && Regex.count_numbers(strArr[2]) >= 7) || (Regex.count_numbers(strArr[2]) >= min_length && strArr[2].length() >= ratio * str.length()))) {
                    if (Phone_Mobile.contains(strArr[1])) {
                        this.results.add(new String[]{"Phone.MOBILE", strArr[2]});
                    } else {
                        this.results.add(new String[]{"Phone.WORK", strArr[2]});
                    }
                }
            }
        }
        if (this.results.size() != 0 && (bool.booleanValue() || !lang_flag.booleanValue() || find_all_match_groups.get(find_all_match_groups.size() - 1).end >= str.length())) {
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

    public void contains(final BCard bCard) {
        bCard.bboxes.forEach(new Consumer() { // from class: com.oua.ocr.bc.p
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                Phone.this.lambda$contains$1(bCard, (BBox) obj);
            }
        });
    }
}
