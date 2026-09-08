package com.oua.ocr.bc;

import com.oua.ocr.ContactInfo;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.function.Consumer;
import java.util.regex.Pattern;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: libBCREngine.java */
/* loaded from: classes4.dex */
public class Name {
    static ArrayList<String[]> groups;
    static HashSet<Integer> langSet;
    static HashSet<Integer> langs;
    static Pattern re_Name_Title_1;
    static Pattern re_Name_cn_beg;
    static Pattern re_Name_en;
    static Pattern re_Title_beg;
    public static ArrayList<NamePod> results;
    static String titles;
    static Pattern re_Cut = Pattern.compile("[一-\u9fff가-\ud7af\u3040-ㇿ\\s]+|[a-zÀ-ÖØ-öø-ÿĀ-ſЀ-ӿ\\s\\.\\_\\-]+", 66);
    static Pattern re_Negative = Pattern.compile("([0-9]+|地址|st\\.|add\\:|中华区|営業|中国語|国際部長|代表|创新|营业|变速|业务|电感|器件|微信|研究|營業|div\\.|\\btop\\b|\\bin\\b|touch|inherence|chance|award|what|more|paper|deputy|engineer|chief|sensors|member|create|professional|domain|ntegrated|\\bpure\\b|registered|organization|technologies|voice|noise|\\bby\\b|listen|sales|electronics|district|business|world|abilities|deformation|processing|prototypes|prototyping|牌|陶瓷|线路|板部|地区|您|\\sthe\\s|unknown|silicon|valley|tracking|inside|\\bred\\b|\\bpill\\b|\\bout\\b|\\bis\\b|audio|video|vision|central|china|life|wireless|communications|building|dev\\.?|\\bh\\.?k\\.?\\b|\\bfor\\b|测|&|group|glass|future|quality|service|system|imagination|metal|innovation|electrical|beyond|\\bktv\\b|标签|以人为本|保护|dreams|r&D|品质|高效|模型|冠名|吸波|特材|铁氧体|导电|赞助|智能|责任|专业|专注|服务|国际|顶尖|科技|未来|采客|亚太|光学|中華|模组|www|\\.com|portable|\\bdirect line\\b|公众号|電\\s*郵|手\\s*機|電\\s*話|电\\s*话|传\\s*真|手\\s*机|邮\\s*箱|fax|有限公司|傳\\s*真|邮件|e-mail|email|mobile|\\biso\\b|\\bit\\b|\\bup\\b|\\bcs\\b)", 66);
    static ReToken re_names = new ReToken();
    static Pattern re_Title_beg_Name = Pattern.compile("^\\s*(?:dr\\.?\\s?|代表取締役\\s?|取締役\\s?|役\\s?)([一-\u9fff가-\ud7af\u3040-ㇿ\\s]+|[a-zÀ-ÖØ-öø-ÿĀ-ſЀ-ӿ\\s\\.]+)", 66);
    static Pattern re_Title_Name = Pattern.compile("役([一-\u9fff가-\ud7af\u3040-ㇿ\\s]{3,})", 66);
    static Pattern re_Name_Title_0 = Pattern.compile("^\\s*(?!dr\\.?\\s?)([一-\u9fff가-\ud7af\u3040-ㇿ]+|[a-zÀ-ÖØ-öø-ÿĀ-ſЀ-ӿ\\s\\.\\(\\)\\-]+)[,\\s\\.]*(?:博士|副教授|教授|postdoctoral|ph\\.?d\\.?|ph\\.o\\.?)", 66);
    static int NUM_SPACES = 5;

    public static void compile(HashSet<Integer> hashSet) {
        langSet = hashSet;
        re_names.pre();
        if (Title.re_titles_beg.cn.length() > 0) {
            titles = Title.dec_titles + "|" + Title.re_titles_beg.cn + "|(?:" + Title.re_titles_beg.en + ")(?:\\b|$)";
        } else {
            titles = Title.dec_titles + "|(?:" + Title.re_titles_beg.en + ")(?:\\b|$)";
        }
        re_Title_beg = Pattern.compile("^(" + titles + ")", 66);
        re_Name_Title_1 = Pattern.compile("^([a-zÀ-ÖØ-öø-ÿĀ-ſЀ-ӿ\\(\\)\\-\\s\\.]+?\\s|[一-\u9fff가-\ud7af\u3040-ㇿ\\s]+?)[,\\.\\s/]*(?:" + titles + ")", 66);
        re_Name_cn_beg = Pattern.compile("^\\s*((?:" + re_names.cn + ")[\\s一-\u9fff가-\ud7af\u3040-ㇿ]{1,3})\\b", 66);
        re_Name_en = Pattern.compile("(?:^|\\b)(" + re_names.en + ")(?:\\b|$)", 66);
        NUM_SPACES = 5;
        if (langs.contains(5)) {
            NUM_SPACES = 4;
        }
    }

    public static void init() {
        re_names.init();
        langs = new HashSet<>();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$contains$0(BCard bCard, BBox bBox) {
        float f10;
        String str = bBox.text;
        if (bCard.Title_idx.contains(Integer.valueOf(bBox.idx))) {
            Boolean bool = Boolean.FALSE;
            if (Regex.find_all(" " + str + " ", re_Title_beg).size() > 0) {
                ArrayList<String[]> find_all_groups = Regex.find_all_groups(str, re_Title_beg_Name);
                groups = find_all_groups;
                if (find_all_groups.size() > 0 && groups.get(0)[1].length() >= 2 && 2 <= groups.get(0)[1].length() && groups.get(0)[1].length() <= 25) {
                    bCard.add_name(bBox.idx, groups.get(0)[1], 0.0f, "re_Title_beg_Name");
                    bool = Boolean.TRUE;
                }
            }
            if (!bool.booleanValue()) {
                ArrayList<String[]> find_all_groups2 = Regex.find_all_groups(str, re_Name_Title_0);
                groups = find_all_groups2;
                if (find_all_groups2.size() > 0 && groups.get(0)[1].length() >= 2 && 2 <= groups.get(0)[1].length() && groups.get(0)[1].length() <= 25) {
                    bCard.add_name(bBox.idx, groups.get(0)[1], 0.0f, "re_Name_Title_0");
                    bool = Boolean.TRUE;
                }
            }
            if (!bool.booleanValue()) {
                ArrayList<String[]> find_all_groups3 = Regex.find_all_groups(str, re_Title_Name);
                groups = find_all_groups3;
                if (find_all_groups3.size() > 0) {
                    bCard.add_name(bBox.idx, groups.get(0)[1], 0.0f, "re_Title_Name");
                    return;
                } else {
                    name_checker(bCard, bBox.idx, str, 0.0f);
                    return;
                }
            }
            return;
        }
        if (bCard.Title_idx.size() == 0) {
            f10 = (1.0f / bBox.dims[1]) + 1.0f;
        } else {
            Iterator<Integer> it = bCard.Title_idx.iterator();
            float f11 = 10000.0f;
            while (it.hasNext()) {
                float f12 = bCard.get_distance_to_title(bBox.idx, it.next().intValue());
                if (f12 < f11) {
                    f11 = f12;
                }
            }
            f10 = f11;
        }
        if (bBox.fields.size() != 0) {
            if (bBox.fields.size() == 1) {
                if ((bBox.fields.get(0)[0].indexOf("Address") != 0 && bBox.fields.get(0)[0].indexOf("Other") != 0) || f10 >= 1.0f || bBox.text.length() >= 20) {
                    return;
                }
            } else {
                return;
            }
        }
        if (Regex.find_all(str, re_Negative).size() == 0) {
            name_checker(bCard, bBox.idx, str, f10);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int lambda$contains$1(NamePod namePod, NamePod namePod2) {
        return Float.compare(namePod.dist, namePod2.dist);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int lambda$contains$2(NamePod namePod, NamePod namePod2) {
        return Float.compare(namePod.dist, namePod2.dist);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$contains$3(BCard bCard, NamePod namePod) {
        bCard.bboxes.get(namePod.idx).fields.add(new String[]{"Name", namePod.name});
        bCard.items.add(new ContactInfo.NameItem(namePod.FirstName, namePod.MiddleName, namePod.LastName, namePod.name));
        LogUtil.print(namePod.name + ",");
    }

    public static void name_checker(BCard bCard, int i10, String str, float f10) {
        boolean z10;
        char c10;
        ArrayList<String> find_all = Regex.find_all(str, re_Cut);
        if (find_all.size() >= 4) {
            return;
        }
        String replace = str.toLowerCase().replace(" ", "");
        if (replace.indexOf("name:") != 0 && replace.indexOf("n:") != 0) {
            z10 = false;
        } else {
            z10 = true;
        }
        Boolean valueOf = Boolean.valueOf(z10);
        Iterator<String> it = find_all.iterator();
        boolean z11 = false;
        boolean z12 = false;
        while (it.hasNext()) {
            String next = it.next();
            if (valueOf.booleanValue()) {
                valueOf = Boolean.FALSE;
            } else if (Regex.find_all(next, re_Title_beg).size() <= 0) {
                if (Regex.which_language0(next) == 11) {
                    if (!z12 && next.replace(" ", "").length() > 2) {
                        ArrayList<String[]> find_all_groups = Regex.find_all_groups(next, re_Name_Title_1);
                        groups = find_all_groups;
                        if (find_all_groups.size() > 0 && groups.get(0)[1].length() >= 2) {
                            next = groups.get(0)[1];
                        }
                        String replaceAll = next.replaceAll("[\\_\\.]", " ");
                        if (Regex.find_all(replaceAll, re_Name_en).size() > 0) {
                            String[] split = replaceAll.split("\\s+");
                            int length = split.length;
                            float length2 = (replaceAll.length() / 10.0f) + 1.0f;
                            if (length >= NUM_SPACES) {
                                bCard.add_name(i10, next.substring(0, split[0].length() + 1 + split[1].length()), f10 + 1000.0f, "re_Name_en_1," + length);
                            } else {
                                bCard.add_name(i10, next, f10 / length2, "re_Name_en_2");
                            }
                        } else if (next.length() >= 2) {
                            if (find_all.size() == 2 && z11) {
                                bCard.add_name(i10, next, f10, "re_Name_en_3");
                            } else {
                                bCard.add_name(i10, next, f10 + 1000.0f, "re_Name_en_4");
                            }
                        }
                        z12 = true;
                        c10 = 4;
                    }
                } else if (!z11) {
                    String replace2 = next.replace(" ", "");
                    if (re_names.cn.length() > 0) {
                        groups = Regex.find_all_groups(replace2 + " ", re_Name_cn_beg);
                    } else {
                        groups = new ArrayList<>();
                    }
                    if (groups.size() > 0 && groups.get(0)[1].length() >= 2) {
                        if (z12 && bCard.name_en.get(0).dist >= 1000.0f) {
                            bCard.add_name(i10, groups.get(0)[1], f10 + 1000.0f, "re_Name_cn_1");
                        } else {
                            bCard.add_name(i10, groups.get(0)[1], f10, "re_Name_cn_2");
                        }
                    } else if (replace2.length() >= 2) {
                        ArrayList<String[]> find_all_groups2 = Regex.find_all_groups(replace2 + " ", re_Name_Title_1);
                        groups = find_all_groups2;
                        if (find_all_groups2.size() > 0 && groups.get(0)[1].length() >= 1) {
                            if (groups.get(0)[1].length() <= 4) {
                                bCard.add_name(i10, groups.get(0)[1], f10 + 1000.0f, "re_Name_Title_1_1");
                            } else {
                                c10 = 4;
                            }
                        } else {
                            c10 = 4;
                            bCard.add_name(i10, replace2.substring(0, Math.min(4, replace2.length())), f10 + 1000.0f, "re_Name_Title_1_2");
                        }
                        z11 = true;
                    }
                    c10 = 4;
                    z11 = true;
                }
            } else {
                return;
            }
        }
    }

    public static float real_dist(float f10) {
        if (f10 >= 1000.0f) {
            return f10 - 1000.0f;
        }
        return f10;
    }

    public static void update(Info info) {
        langs.add(Integer.valueOf(info.lang));
        re_names.update(info.names, info.names_cn);
    }

    public void contains(final BCard bCard) {
        bCard.bboxes.forEach(new Consumer() { // from class: com.oua.ocr.bc.l
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                Name.lambda$contains$0(BCard.this, (BBox) obj);
            }
        });
        results = new ArrayList<>();
        if (bCard.name_cn.size() > 0) {
            bCard.name_cn.sort(new Comparator() { // from class: com.oua.ocr.bc.m
                @Override // java.util.Comparator
                public final int compare(Object obj, Object obj2) {
                    int lambda$contains$1;
                    lambda$contains$1 = Name.lambda$contains$1((NamePod) obj, (NamePod) obj2);
                    return lambda$contains$1;
                }
            });
            results.add(bCard.name_cn.get(0));
        }
        if (bCard.name_en.size() > 0) {
            bCard.name_en.sort(new Comparator() { // from class: com.oua.ocr.bc.n
                @Override // java.util.Comparator
                public final int compare(Object obj, Object obj2) {
                    int lambda$contains$2;
                    lambda$contains$2 = Name.lambda$contains$2((NamePod) obj, (NamePod) obj2);
                    return lambda$contains$2;
                }
            });
            Boolean bool = Boolean.FALSE;
            bCard.name_en.size();
            NamePod namePod = bCard.name_en.get(0);
            if (namePod.dist < 2.0f && (results.size() == 0 || Math.min((real_dist(results.get(0).dist) * 3.0f) + 0.5d, 1.2d) >= real_dist(namePod.dist))) {
                bool = Boolean.TRUE;
                results.add(namePod);
            }
            if (!bool.booleanValue() && bCard.email.length() > 0) {
                bool = Boolean.TRUE;
                int i10 = -1;
                float f10 = 0.0f;
                for (int i11 = 0; i11 < bCard.name_en.size(); i11++) {
                    float normalized_edit_distance = Utils.normalized_edit_distance(bCard.email, bCard.name_en.get(i11).name);
                    if (normalized_edit_distance > f10) {
                        i10 = i11;
                        f10 = normalized_edit_distance;
                    }
                }
                if (f10 >= 0.2d && (results.size() == 0 || results.get(0).dist * 2.0f > bCard.name_en.get(i10).dist || Math.abs(results.get(0).dist - bCard.name_en.get(i10).dist) < 0.001d)) {
                    results.add(bCard.name_en.get(i10));
                }
            }
            if (!bool.booleanValue() && bCard.lang == 11) {
                bool = Boolean.TRUE;
                results.add(bCard.name_en.get(0));
            }
            if (!bool.booleanValue() && results.size() == 1 && Math.abs(real_dist(bCard.name_en.get(0).dist) - real_dist(results.get(0).dist)) < 1.0E-4f) {
                results.add(bCard.name_en.get(0));
            }
        }
        LogUtil.print(bCard.file_path + ": ");
        results.forEach(new Consumer() { // from class: com.oua.ocr.bc.o
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                Name.lambda$contains$3(BCard.this, (NamePod) obj);
            }
        });
        LogUtil.print("\n");
    }
}
