package com.android.contacts.quickcontact;

import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes.dex */
public class WebAddress {

    /* renamed from: f, reason: collision with root package name */
    public static Pattern f17060f = Pattern.compile("(?:(http|https|file)\\:\\/\\/)?(?:([-A-Za-z0-9$_.+!*'(),;?&=]+(?:\\:[-A-Za-z0-9$_.+!*'(),;?&=]+)?)@)?([a-zA-Z0-9 -\ud7ff豈-\ufdcfﷰ-\uffef%_-][a-zA-Z0-9 -\ud7ff豈-\ufdcfﷰ-\uffef%_\\.-]*|\\[[0-9a-fA-F:\\.]+\\])?(?:\\:([0-9]*))?(\\/?[^#]*)?.*", 2);

    /* renamed from: a, reason: collision with root package name */
    public String f17061a;

    /* renamed from: b, reason: collision with root package name */
    public String f17062b;

    /* renamed from: c, reason: collision with root package name */
    public int f17063c;

    /* renamed from: d, reason: collision with root package name */
    public String f17064d;

    /* renamed from: e, reason: collision with root package name */
    public String f17065e;

    /* loaded from: classes.dex */
    public class ParseException extends Exception {
        public String response;

        public ParseException(String str) {
            this.response = str;
        }
    }

    public WebAddress(String str) {
        str.getClass();
        this.f17061a = "";
        this.f17062b = "";
        this.f17063c = -1;
        this.f17064d = "/";
        this.f17065e = "";
        Matcher matcher = f17060f.matcher(str);
        if (matcher.matches()) {
            String group = matcher.group(1);
            if (group != null) {
                this.f17061a = group.toLowerCase(Locale.ROOT);
            }
            String group2 = matcher.group(2);
            if (group2 != null) {
                this.f17065e = group2;
            }
            String group3 = matcher.group(3);
            if (group3 != null) {
                this.f17062b = group3;
            }
            String group4 = matcher.group(4);
            if (group4 != null && group4.length() > 0) {
                try {
                    this.f17063c = Integer.parseInt(group4);
                } catch (NumberFormatException unused) {
                    throw new ParseException("Bad port");
                }
            }
            String group5 = matcher.group(5);
            if (group5 != null && group5.length() > 0) {
                if (group5.charAt(0) == '/') {
                    this.f17064d = group5;
                } else {
                    this.f17064d = "/" + group5;
                }
            }
            if (this.f17063c == 443 && this.f17061a.equals("")) {
                this.f17061a = "https";
            } else if (this.f17063c == -1) {
                if (this.f17061a.equals("https")) {
                    this.f17063c = 443;
                } else {
                    this.f17063c = 80;
                }
            }
            if (this.f17061a.equals("")) {
                this.f17061a = "http";
                return;
            }
            return;
        }
        throw new ParseException("Bad address");
    }

    public String toString() {
        String str;
        String str2 = "";
        if ((this.f17063c == 443 || !this.f17061a.equals("https")) && (this.f17063c == 80 || !this.f17061a.equals("http"))) {
            str = "";
        } else {
            str = ":" + Integer.toString(this.f17063c);
        }
        if (this.f17065e.length() > 0) {
            str2 = this.f17065e + "@";
        }
        return this.f17061a + "://" + str2 + this.f17062b + str + this.f17064d;
    }
}
