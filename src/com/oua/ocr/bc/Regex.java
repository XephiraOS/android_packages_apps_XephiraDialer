package com.oua.ocr.bc;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: libBCREngine.java */
/* loaded from: classes4.dex */
public class Regex {
    static Pattern re_Numbers = Pattern.compile("[2-9]+", 66);

    public static Boolean contains_numbers(String str) {
        boolean z10;
        if (find_all(str, re_Numbers).size() > 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        return Boolean.valueOf(z10);
    }

    public static int count_numbers(String str) {
        int i10;
        int i11 = 0;
        for (char c10 : str.toCharArray()) {
            if ('0' <= c10 && c10 <= '9') {
                i10 = 1;
            } else {
                i10 = 0;
            }
            i11 += i10;
        }
        return i11;
    }

    public static ArrayList<String> find_all(String str, Pattern pattern) {
        String group;
        ArrayList<String> arrayList = new ArrayList<>();
        try {
            Matcher matcher = pattern.matcher(str);
            while (matcher.find()) {
                if (matcher.group(0) == null) {
                    group = "";
                } else {
                    group = matcher.group(0);
                }
                arrayList.add(group);
            }
        } catch (PatternSyntaxException e10) {
            LogUtil.println("This string could not compile: " + e10.getPattern());
            LogUtil.println(e10.getMessage());
        }
        return arrayList;
    }

    public static ArrayList<String[]> find_all_groups(String str, Pattern pattern) {
        String group;
        ArrayList<String[]> arrayList = new ArrayList<>();
        try {
            Matcher matcher = pattern.matcher(str);
            int groupCount = matcher.groupCount() + 1;
            while (matcher.find()) {
                arrayList.add(new String[groupCount]);
                for (int i10 = 0; i10 < groupCount; i10++) {
                    String[] strArr = arrayList.get(arrayList.size() - 1);
                    if (matcher.group(i10) == null) {
                        group = "";
                    } else {
                        group = matcher.group(i10);
                    }
                    strArr[i10] = group;
                }
            }
        } catch (PatternSyntaxException e10) {
            LogUtil.println("This string could not compile: " + e10.getPattern());
            LogUtil.println(e10.getMessage());
        }
        return arrayList;
    }

    public static ArrayList<MatchGroup> find_all_match_groups(String str, Pattern pattern) {
        String group;
        ArrayList<MatchGroup> arrayList = new ArrayList<>();
        try {
            Matcher matcher = pattern.matcher(str);
            int groupCount = matcher.groupCount() + 1;
            while (matcher.find()) {
                MatchGroup matchGroup = new MatchGroup(groupCount);
                matchGroup.start = matcher.start();
                matchGroup.end = matcher.end();
                for (int i10 = 0; i10 < groupCount; i10++) {
                    String[] strArr = matchGroup.group;
                    if (matcher.group(i10) == null) {
                        group = "";
                    } else {
                        group = matcher.group(i10);
                    }
                    strArr[i10] = group;
                }
                arrayList.add(matchGroup);
            }
        } catch (PatternSyntaxException e10) {
            LogUtil.println("This string could not compile: " + e10.getPattern());
            LogUtil.println(e10.getMessage());
        }
        return arrayList;
    }

    public static Boolean inRange(char c10, char c11, char c12) {
        boolean z10;
        if (c11 <= c10 && c10 <= c12) {
            z10 = true;
        } else {
            z10 = false;
        }
        return Boolean.valueOf(z10);
    }

    public static int which_char(char c10) {
        if (inRange(c10, (char) 19968, (char) 40959).booleanValue()) {
            return 5;
        }
        if (inRange(c10, (char) 44032, (char) 55215).booleanValue()) {
            return 23;
        }
        if (inRange(c10, (char) 12352, (char) 12799).booleanValue()) {
            return 22;
        }
        if (('a' > c10 || c10 > 'z') && !inRange(c10, (char) 192, (char) 214).booleanValue() && !inRange(c10, (char) 216, (char) 246).booleanValue() && !inRange(c10, (char) 248, (char) 255).booleanValue() && !inRange(c10, (char) 1024, (char) 1279).booleanValue()) {
            return -1;
        }
        return 11;
    }

    public static int which_language(String str) {
        for (int i10 = 0; i10 < str.length(); i10++) {
            char charAt = str.charAt(i10);
            if (inRange(charAt, (char) 19968, (char) 40959).booleanValue() || inRange(charAt, (char) 44032, (char) 55215).booleanValue() || inRange(charAt, (char) 12352, (char) 12799).booleanValue()) {
                return 5;
            }
        }
        return 11;
    }

    public static int which_language0(String str) {
        if (str.length() == 0) {
            return -1;
        }
        int which_char = which_char(Character.toLowerCase(str.charAt(0)));
        if (which_char == 5 || which_char == 23 || which_char == 22) {
            return 5;
        }
        return which_char;
    }
}
