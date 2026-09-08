package com.oua.ocr.bc;

import com.oua.ocr.ContactInfo;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.function.Consumer;
import java.util.regex.Pattern;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: libBCREngine.java */
/* loaded from: classes4.dex */
public class Website {
    static ArrayList<String[]> groups;
    static HashSet<Integer> langSet;
    static Pattern re_Website_0;
    static Pattern re_Website_1;
    static Pattern re_Website_no_spaces_0;
    static Pattern re_Website_no_spaces_no_w;
    public ArrayList<String[]> results;
    static Pattern re_Negative = Pattern.compile("(add:|no\\.|mansion)", 66);
    static ReToken re_website = new ReToken();

    public static void compile(HashSet<Integer> hashSet) {
        langSet = hashSet;
        String concat = re_website.concat();
        re_Website_0 = Pattern.compile("(?:" + concat + ")*([htpslio\\:\\/\\s]*[w]{2,3}[.,]*[a-zÀ-ÖØ-öø-ÿ\\.\\/\\-_0-9\\s\\]\\&]+)", 66);
        re_Website_1 = Pattern.compile("(?:" + concat + ")*((?:[htpslio\\:\\/]*|facebook)[a-zÀ-ÖØ-öø-ÿ\\.\\/\\-_0-9\\s]+\\.(edu|net|org|com|au|cn|br|ca|eu|es|id|ch|fr|no|in|ji|de|ai|be|sg|kr|mx|uk|it|nl|pt|ru|se|co|jp|ar)+(?:(?![a-zÀ-ÖØ-öø-ÿ0-9\\-])[a-zÀ-ÖØ-öø-ÿ\\.\\/\\-_0-9\\s]*))", 66);
        re_Website_no_spaces_0 = Pattern.compile("(?:" + concat + ")*([htpslio\\:\\/]*[w]{2,3}[a-zÀ-ÖØ-öø-ÿ\\.\\/\\-_0-9]+)", 66);
        re_Website_no_spaces_no_w = Pattern.compile("(?:" + concat + ")*(http\\:\\/\\/[a-zÀ-ÖØ-öø-ÿ\\.\\/\\-_0-9]+)", 66);
    }

    public static void init() {
        re_website.init();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$contains$1(String[] strArr) {
        this.results.add(new String[]{"Website.re_Website_0", strArr[1]});
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$contains$2(String[] strArr) {
        this.results.add(new String[]{"Website.re_Website_1", strArr[1]});
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$contains$3(BBox bBox, BCard bCard, String[] strArr) {
        bBox.fields.add(strArr);
        bCard.items.add(new ContactInfo.WebItem(strArr[1]));
        LogUtil.println("Website => " + bBox.text + "|" + strArr[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$contains$4(final BCard bCard, final BBox bBox) {
        if ((!Utils.containsField("Email", bBox.fields).booleanValue() && contains(bBox.text).booleanValue()) || contains_no_spaces(bBox.text).booleanValue()) {
            this.results.forEach(new Consumer() { // from class: com.oua.ocr.bc.y
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    Website.lambda$contains$3(BBox.this, bCard, (String[]) obj);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$contains_no_spaces$0(String[] strArr) {
        this.results.add(new String[]{"Website.re_Website_no_spaces_0", strArr[1]});
    }

    public static void update(Info info) {
        re_website.update(info.website_tokens, info.website_tokens_cn);
    }

    public Boolean contains(String str) {
        if (Regex.find_all(str, re_Negative).size() > 0) {
            return Boolean.FALSE;
        }
        groups = Regex.find_all_groups(str, re_Website_0);
        this.results = new ArrayList<>();
        if (groups.size() > 0) {
            groups.forEach(new Consumer() { // from class: com.oua.ocr.bc.v
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    Website.this.lambda$contains$1((String[]) obj);
                }
            });
            return Boolean.TRUE;
        }
        ArrayList<String[]> find_all_groups = Regex.find_all_groups(str, re_Website_1);
        groups = find_all_groups;
        if (find_all_groups.size() > 0) {
            groups.forEach(new Consumer() { // from class: com.oua.ocr.bc.w
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    Website.this.lambda$contains$2((String[]) obj);
                }
            });
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

    public Boolean contains_no_spaces(String str) {
        ArrayList<String[]> find_all_groups = Regex.find_all_groups(str, re_Website_no_spaces_0);
        groups = find_all_groups;
        if (find_all_groups.size() == 0) {
            ArrayList<String[]> find_all_groups2 = Regex.find_all_groups(str, re_Website_no_spaces_no_w);
            groups = find_all_groups2;
            if (find_all_groups2.size() == 0) {
                return Boolean.FALSE;
            }
        }
        this.results = new ArrayList<>();
        groups.forEach(new Consumer() { // from class: com.oua.ocr.bc.z
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                Website.this.lambda$contains_no_spaces$0((String[]) obj);
            }
        });
        return Boolean.TRUE;
    }

    public void contains(final BCard bCard) {
        bCard.bboxes.forEach(new Consumer() { // from class: com.oua.ocr.bc.x
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                Website.this.lambda$contains$4(bCard, (BBox) obj);
            }
        });
    }
}
