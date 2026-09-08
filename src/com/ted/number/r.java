package com.ted.number;

import kotlin.text.StringsKt__StringsKt;

/* compiled from: HTMLUtils.kt */
/* loaded from: classes4.dex */
public final class r {
    public static final String a(String[] strArr) {
        CharSequence j02;
        boolean o10;
        if (strArr == null) {
            H7.b.c("HTMLUtils", "protocolArray is null");
            return "";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(c());
        for (String str : strArr) {
            j02 = StringsKt__StringsKt.j0(str);
            o10 = kotlin.text.n.o(j02.toString(), "</p>", false, 2, null);
            if (!o10) {
                sb.append("<p>");
                sb.append(str);
                sb.append("</p>");
            } else {
                sb.append(str);
            }
        }
        sb.append(b());
        String sb2 = sb.toString();
        kotlin.jvm.internal.i.e(sb2, "stringBuilder.toString()");
        return sb2;
    }

    public static final String b() {
        return "</body>\n</html>";
    }

    public static final String c() {
        return "<!DOCTYPE html>\n<html lang=\"en\">\n<head>\n  <meta charset=\"UTF-8\">\n  <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n</head>\n<body lang=\"zh-CN\" bgcolor=\"#f0f0f0\" dir=\"ltr\" style=\"background: #f0f0f0\">";
    }
}
