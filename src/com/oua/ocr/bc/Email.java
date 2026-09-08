package com.oua.ocr.bc;

import com.oua.ocr.ContactInfo;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.regex.Pattern;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: libBCREngine.java */
/* loaded from: classes4.dex */
public class Email {
    static ArrayList<String[]> groups;
    static HashSet<Integer> langSet;
    static Pattern re_Email_at;
    static Pattern re_Email_at_domain;
    static Pattern re_Email_no_at;
    public ArrayList<String[]> results;
    static Pattern re_Negative = Pattern.compile("(^postadress)", 66);
    static ReToken re_email = new ReToken();
    static HashSet<String> im = new HashSet<>(Arrays.asList("msn", "t", "qq", "q", "f"));
    static Pattern re_Email_domain = Pattern.compile(".+\\.(edu|net|org|com|au|cn|br|ca|eu|es|id|ch|fr|no|in|ji|de|ai|be|sg|kr|mx|uk|it|nl|\\.|pt|ru|se|co|jp|ar)$", 66);

    public static void compile(HashSet<Integer> hashSet) {
        langSet = hashSet;
        String concat = re_email.concat();
        re_Email_at_domain = Pattern.compile("(" + concat + "|\\be\\b|\\bf\\b|\\bt|\\bqq\\b|\\bq\\b)*[\\/\\s\\.:,)]*((?:[0-9a-zÀ-ÖØ-öø-ÿ\\-\\.\\_\\s＿]*)(?:@/?[0-9a-zÀ-ÖØ-öø-ÿ\\-\\._\\s＿&]+)\\.[a-z]+)", 66);
        re_Email_at = Pattern.compile("(" + concat + "|\\be\\b|\\bf\\b|\\bt|\\bqq\\b|\\bq\\b)*[\\/\\s\\.:,)]*((?:[0-9a-zÀ-ÖØ-öø-ÿ\\-\\.\\_\\s＿]*)(?:@/?[0-9a-zÀ-ÖØ-öø-ÿ\\-\\._\\s＿&]+))", 66);
        re_Email_no_at = Pattern.compile("(" + concat + ")+\\b[\\/\\s\\.:,)]*([0-9a-zÀ-ÖØ-öø-ÿ\\-\\.\\_\\s＿&]+)", 66);
    }

    public static void init() {
        re_email.init();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int lambda$contains$0(String str, String str2) {
        return str2.length() - str.length();
    }

    public static void update(Info info) {
        re_email.update(info.email_tokens, info.email_tokens_cn);
    }

    public Boolean contains(BBox bBox) {
        String str;
        String replace = bBox.text.replace("/", "");
        if (Regex.find_all(replace, re_Negative).size() > 0) {
            return Boolean.FALSE;
        }
        ArrayList<String[]> find_all_groups = Regex.find_all_groups(replace, re_Email_at_domain);
        groups = find_all_groups;
        if (find_all_groups.size() == 0) {
            groups = Regex.find_all_groups(replace, re_Email_at);
            str = "Email.re_Email_at";
        } else {
            str = "Email.re_Email_at_domain";
        }
        if (groups.size() == 0) {
            groups = Regex.find_all_groups(replace, re_Email_no_at);
            str = "Email.re_Email_no_at";
        }
        this.results = new ArrayList<>();
        Iterator<String[]> it = groups.iterator();
        while (it.hasNext()) {
            this.results.add(new String[]{str, it.next()[2]});
        }
        return Boolean.TRUE;
    }

    public String extract_chars(String str) {
        char charAt;
        String str2 = "";
        for (int i10 = 0; i10 < str.length() && ('0' > (charAt = str.charAt(i10)) || charAt > '9'); i10++) {
            if ('a' <= charAt && charAt <= 'z') {
                str2 = str2 + charAt;
            }
        }
        return str2;
    }

    public void contains(BCard bCard) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (BBox bBox : bCard.bboxes) {
            if (contains(bBox).booleanValue()) {
                Iterator<String[]> it = this.results.iterator();
                while (it.hasNext()) {
                    String[] next = it.next();
                    bBox.fields.add(next);
                    bCard.items.add(new ContactInfo.EmailItem(next[1]));
                    LogUtil.println("Email => " + next[0] + "|" + next[1]);
                    int indexOf = next[1].indexOf("@");
                    if (indexOf == 0) {
                        if (Regex.find_all(next[1], re_Email_domain).size() == 0) {
                            arrayList2.add(extract_chars(next[1].substring(1).toLowerCase()));
                        }
                    } else if (indexOf > 0) {
                        arrayList.add(extract_chars(next[1].substring(0, indexOf).toLowerCase()));
                    } else {
                        arrayList.add(extract_chars(next[1].toLowerCase()));
                    }
                }
            }
        }
        if (arrayList.size() == 0 && arrayList2.size() != 0) {
            arrayList = arrayList2;
        }
        if (arrayList.size() > 0) {
            arrayList.sort(new Comparator() { // from class: com.oua.ocr.bc.k
                @Override // java.util.Comparator
                public final int compare(Object obj, Object obj2) {
                    int lambda$contains$0;
                    lambda$contains$0 = Email.lambda$contains$0((String) obj, (String) obj2);
                    return lambda$contains$0;
                }
            });
            bCard.email = (String) arrayList.get(0);
        }
    }
}
