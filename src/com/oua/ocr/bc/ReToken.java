package com.oua.ocr.bc;

import java.util.ArrayList;
import java.util.regex.Pattern;

/* compiled from: libBCREngine.java */
/* loaded from: classes4.dex */
class ReToken {
    public String cn;
    public String en;
    public Pattern re;

    private Pattern _compile(String str) {
        return Pattern.compile(str, 66);
    }

    public void compile() {
        pre();
        if (this.cn.length() > 0) {
            this.re = _compile("((?:^|\\b)(?:" + this.en + ")(?:\\b|$)|(?:" + this.cn + "))");
            return;
        }
        this.re = _compile("((?:^|\\b)(?:" + this.en + ")(?:\\b|$))");
    }

    public void compile_beg() {
        pre();
        String str = "(?:" + this.en + ")(?:\\b|$)";
        if (this.cn.length() > 0) {
            str = str + "|" + this.cn;
        }
        this.re = _compile("^(" + str + ")");
    }

    public void compile_end() {
        String str;
        pre();
        if (this.cn.length() > 0) {
            str = "((?:^|\\b)(?:" + this.en + ")|(?:" + this.cn + "))";
        } else {
            str = "((?:^|\\b)(?:" + this.en + "))";
        }
        this.re = _compile(str + "[)\\s]*$");
    }

    public String concat() {
        pre();
        if (this.cn.length() == 0) {
            return this.en;
        }
        return this.en + "|" + this.cn;
    }

    public Boolean find(String str) {
        if (Regex.find_all(str, this.re).size() > 0) {
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

    public ArrayList<String> find_all(String str) {
        return Regex.find_all(str, this.re);
    }

    public void init() {
        this.en = "";
        this.cn = "";
    }

    public void pre() {
        this.en = replace(this.en);
        if (this.cn.length() > 0) {
            this.cn = replace(this.cn);
        } else {
            this.cn = "中文占位";
        }
    }

    public String replace(String str) {
        return str.replace(" ", "\\s*").replace("\\.", ".").replace(".", "\\.").replace("-", "\\-");
    }

    public void update(String str, String str2) {
        this.en = Utils.extend(this.en, str);
        this.cn = Utils.extend(this.cn, str2);
    }
}
