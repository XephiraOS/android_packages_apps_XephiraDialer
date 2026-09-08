package kotlin.text;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: Indent.kt */
/* loaded from: classes4.dex */
public class StringsKt__IndentKt extends g {
    public static final v9.l<String, String> b(final String str) {
        if (str.length() == 0) {
            return new v9.l<String, String>() { // from class: kotlin.text.StringsKt__IndentKt$getIndentFunction$1
                @Override // v9.l
                /* renamed from: b, reason: merged with bridge method [inline-methods] */
                public final String invoke(String line) {
                    kotlin.jvm.internal.i.f(line, "line");
                    return line;
                }
            };
        }
        return new v9.l<String, String>() { // from class: kotlin.text.StringsKt__IndentKt$getIndentFunction$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // v9.l
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public final String invoke(String line) {
                kotlin.jvm.internal.i.f(line, "line");
                return str + line;
            }
        };
    }

    public static final int c(String str) {
        int length = str.length();
        int i10 = 0;
        while (true) {
            if (i10 < length) {
                if (!b.c(str.charAt(i10))) {
                    break;
                }
                i10++;
            } else {
                i10 = -1;
                break;
            }
        }
        if (i10 == -1) {
            return str.length();
        }
        return i10;
    }

    public static final String d(String str, String newIndent) {
        int i10;
        String invoke;
        kotlin.jvm.internal.i.f(str, "<this>");
        kotlin.jvm.internal.i.f(newIndent, "newIndent");
        List<String> R10 = StringsKt__StringsKt.R(str);
        ArrayList arrayList = new ArrayList();
        for (Object obj : R10) {
            if (!f.q((String) obj)) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList(kotlin.collections.m.p(arrayList, 10));
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(Integer.valueOf(c((String) it.next())));
        }
        Integer num = (Integer) kotlin.collections.m.G(arrayList2);
        int i11 = 0;
        if (num != null) {
            i10 = num.intValue();
        } else {
            i10 = 0;
        }
        int length = str.length() + (newIndent.length() * R10.size());
        v9.l<String, String> b10 = b(newIndent);
        int i12 = kotlin.collections.m.i(R10);
        ArrayList arrayList3 = new ArrayList();
        for (Object obj2 : R10) {
            int i13 = i11 + 1;
            if (i11 < 0) {
                kotlin.collections.m.o();
            }
            String str2 = (String) obj2;
            if ((i11 == 0 || i11 == i12) && f.q(str2)) {
                str2 = null;
            } else {
                String k02 = p.k0(str2, i10);
                if (k02 != null && (invoke = b10.invoke(k02)) != null) {
                    str2 = invoke;
                }
            }
            if (str2 != null) {
                arrayList3.add(str2);
            }
            i11 = i13;
        }
        String sb = ((StringBuilder) kotlin.collections.m.B(arrayList3, new StringBuilder(length), "\n", null, null, 0, null, null, 124, null)).toString();
        kotlin.jvm.internal.i.e(sb, "toString(...)");
        return sb;
    }

    public static String e(String str) {
        kotlin.jvm.internal.i.f(str, "<this>");
        return d(str, "");
    }
}
