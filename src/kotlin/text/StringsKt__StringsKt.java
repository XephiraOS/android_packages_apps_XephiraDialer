package kotlin.text;

import com.customize.contacts.backupandrestore.plugin.ContactBackupPlugin;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;
import kotlin.collections.A;
import kotlin.collections.C1228i;
import kotlin.collections.C1229j;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.sequences.SequencesKt___SequencesKt;

/* compiled from: Strings.kt */
/* loaded from: classes4.dex */
public class StringsKt__StringsKt extends n {
    public static /* synthetic */ boolean A(CharSequence charSequence, CharSequence charSequence2, boolean z10, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            z10 = false;
        }
        return z(charSequence, charSequence2, z10);
    }

    public static final Pair<Integer, String> B(CharSequence charSequence, Collection<String> collection, int i10, boolean z10, boolean z11) {
        int D10;
        int e10;
        B9.d h10;
        Object obj;
        Object obj2;
        int b10;
        Object I10;
        if (!z10 && collection.size() == 1) {
            I10 = CollectionsKt___CollectionsKt.I(collection);
            String str = (String) I10;
            int J10 = !z11 ? J(charSequence, str, i10, false, 4, null) : O(charSequence, str, i10, false, 4, null);
            if (J10 < 0) {
                return null;
            }
            return m9.g.a(Integer.valueOf(J10), str);
        }
        if (!z11) {
            b10 = B9.i.b(i10, 0);
            h10 = new B9.f(b10, charSequence.length());
        } else {
            D10 = D(charSequence);
            e10 = B9.i.e(i10, D10);
            h10 = B9.i.h(e10, 0);
        }
        if (charSequence instanceof String) {
            int a10 = h10.a();
            int c10 = h10.c();
            int e11 = h10.e();
            if ((e11 > 0 && a10 <= c10) || (e11 < 0 && c10 <= a10)) {
                while (true) {
                    Iterator<T> it = collection.iterator();
                    while (true) {
                        if (it.hasNext()) {
                            obj2 = it.next();
                            String str2 = (String) obj2;
                            if (n.r(str2, 0, (String) charSequence, a10, str2.length(), z10)) {
                                break;
                            }
                        } else {
                            obj2 = null;
                            break;
                        }
                    }
                    String str3 = (String) obj2;
                    if (str3 != null) {
                        return m9.g.a(Integer.valueOf(a10), str3);
                    }
                    if (a10 == c10) {
                        break;
                    }
                    a10 += e11;
                }
            }
        } else {
            int a11 = h10.a();
            int c11 = h10.c();
            int e12 = h10.e();
            if ((e12 > 0 && a11 <= c11) || (e12 < 0 && c11 <= a11)) {
                while (true) {
                    Iterator<T> it2 = collection.iterator();
                    while (true) {
                        if (it2.hasNext()) {
                            obj = it2.next();
                            String str4 = (String) obj;
                            if (U(str4, 0, charSequence, a11, str4.length(), z10)) {
                                break;
                            }
                        } else {
                            obj = null;
                            break;
                        }
                    }
                    String str5 = (String) obj;
                    if (str5 != null) {
                        return m9.g.a(Integer.valueOf(a11), str5);
                    }
                    if (a11 == c11) {
                        break;
                    }
                    a11 += e12;
                }
            }
        }
        return null;
    }

    public static final B9.f C(CharSequence charSequence) {
        kotlin.jvm.internal.i.f(charSequence, "<this>");
        return new B9.f(0, charSequence.length() - 1);
    }

    public static int D(CharSequence charSequence) {
        kotlin.jvm.internal.i.f(charSequence, "<this>");
        return charSequence.length() - 1;
    }

    public static final int E(CharSequence charSequence, char c10, int i10, boolean z10) {
        kotlin.jvm.internal.i.f(charSequence, "<this>");
        if (!z10 && (charSequence instanceof String)) {
            return ((String) charSequence).indexOf(c10, i10);
        }
        return K(charSequence, new char[]{c10}, i10, z10);
    }

    public static final int F(CharSequence charSequence, String string, int i10, boolean z10) {
        kotlin.jvm.internal.i.f(charSequence, "<this>");
        kotlin.jvm.internal.i.f(string, "string");
        if (!z10 && (charSequence instanceof String)) {
            return ((String) charSequence).indexOf(string, i10);
        }
        return H(charSequence, string, i10, charSequence.length(), z10, false, 16, null);
    }

    public static final int G(CharSequence charSequence, CharSequence charSequence2, int i10, int i11, boolean z10, boolean z11) {
        int D10;
        int e10;
        int b10;
        B9.d h10;
        int b11;
        int e11;
        if (!z11) {
            b11 = B9.i.b(i10, 0);
            e11 = B9.i.e(i11, charSequence.length());
            h10 = new B9.f(b11, e11);
        } else {
            D10 = D(charSequence);
            e10 = B9.i.e(i10, D10);
            b10 = B9.i.b(i11, 0);
            h10 = B9.i.h(e10, b10);
        }
        if ((charSequence instanceof String) && (charSequence2 instanceof String)) {
            int a10 = h10.a();
            int c10 = h10.c();
            int e12 = h10.e();
            if ((e12 > 0 && a10 <= c10) || (e12 < 0 && c10 <= a10)) {
                while (!n.r((String) charSequence2, 0, (String) charSequence, a10, charSequence2.length(), z10)) {
                    if (a10 != c10) {
                        a10 += e12;
                    } else {
                        return -1;
                    }
                }
                return a10;
            }
            return -1;
        }
        int a11 = h10.a();
        int c11 = h10.c();
        int e13 = h10.e();
        if ((e13 > 0 && a11 <= c11) || (e13 < 0 && c11 <= a11)) {
            while (!U(charSequence2, 0, charSequence, a11, charSequence2.length(), z10)) {
                if (a11 != c11) {
                    a11 += e13;
                } else {
                    return -1;
                }
            }
            return a11;
        }
        return -1;
    }

    public static /* synthetic */ int H(CharSequence charSequence, CharSequence charSequence2, int i10, int i11, boolean z10, boolean z11, int i12, Object obj) {
        if ((i12 & 16) != 0) {
            z11 = false;
        }
        return G(charSequence, charSequence2, i10, i11, z10, z11);
    }

    public static /* synthetic */ int I(CharSequence charSequence, char c10, int i10, boolean z10, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            i10 = 0;
        }
        if ((i11 & 4) != 0) {
            z10 = false;
        }
        return E(charSequence, c10, i10, z10);
    }

    public static /* synthetic */ int J(CharSequence charSequence, String str, int i10, boolean z10, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            i10 = 0;
        }
        if ((i11 & 4) != 0) {
            z10 = false;
        }
        return F(charSequence, str, i10, z10);
    }

    public static final int K(CharSequence charSequence, char[] chars, int i10, boolean z10) {
        int b10;
        int D10;
        char H10;
        kotlin.jvm.internal.i.f(charSequence, "<this>");
        kotlin.jvm.internal.i.f(chars, "chars");
        if (z10 || chars.length != 1 || !(charSequence instanceof String)) {
            b10 = B9.i.b(i10, 0);
            D10 = D(charSequence);
            A it = new B9.f(b10, D10).iterator();
            while (it.hasNext()) {
                int a10 = it.a();
                char charAt = charSequence.charAt(a10);
                for (char c10 : chars) {
                    if (c.d(c10, charAt, z10)) {
                        return a10;
                    }
                }
            }
            return -1;
        }
        H10 = C1229j.H(chars);
        return ((String) charSequence).indexOf(H10, i10);
    }

    public static final int L(CharSequence charSequence, char c10, int i10, boolean z10) {
        kotlin.jvm.internal.i.f(charSequence, "<this>");
        if (!z10 && (charSequence instanceof String)) {
            return ((String) charSequence).lastIndexOf(c10, i10);
        }
        return P(charSequence, new char[]{c10}, i10, z10);
    }

    public static final int M(CharSequence charSequence, String string, int i10, boolean z10) {
        kotlin.jvm.internal.i.f(charSequence, "<this>");
        kotlin.jvm.internal.i.f(string, "string");
        if (!z10 && (charSequence instanceof String)) {
            return ((String) charSequence).lastIndexOf(string, i10);
        }
        return G(charSequence, string, i10, 0, z10, true);
    }

    public static /* synthetic */ int N(CharSequence charSequence, char c10, int i10, boolean z10, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            i10 = D(charSequence);
        }
        if ((i11 & 4) != 0) {
            z10 = false;
        }
        return L(charSequence, c10, i10, z10);
    }

    public static /* synthetic */ int O(CharSequence charSequence, String str, int i10, boolean z10, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            i10 = D(charSequence);
        }
        if ((i11 & 4) != 0) {
            z10 = false;
        }
        return M(charSequence, str, i10, z10);
    }

    public static final int P(CharSequence charSequence, char[] chars, int i10, boolean z10) {
        int D10;
        int e10;
        char H10;
        kotlin.jvm.internal.i.f(charSequence, "<this>");
        kotlin.jvm.internal.i.f(chars, "chars");
        if (z10 || chars.length != 1 || !(charSequence instanceof String)) {
            D10 = D(charSequence);
            for (e10 = B9.i.e(i10, D10); -1 < e10; e10--) {
                char charAt = charSequence.charAt(e10);
                for (char c10 : chars) {
                    if (c.d(c10, charAt, z10)) {
                        return e10;
                    }
                }
            }
            return -1;
        }
        H10 = C1229j.H(chars);
        return ((String) charSequence).lastIndexOf(H10, i10);
    }

    public static final kotlin.sequences.e<String> Q(CharSequence charSequence) {
        kotlin.jvm.internal.i.f(charSequence, "<this>");
        return a0(charSequence, new String[]{ContactBackupPlugin.END_OF_LINE, "\n", "\r"}, false, 0, 6, null);
    }

    public static final List<String> R(CharSequence charSequence) {
        List<String> o10;
        kotlin.jvm.internal.i.f(charSequence, "<this>");
        o10 = SequencesKt___SequencesKt.o(Q(charSequence));
        return o10;
    }

    public static final kotlin.sequences.e<B9.f> S(CharSequence charSequence, String[] strArr, int i10, final boolean z10, int i11) {
        final List f10;
        V(i11);
        f10 = C1228i.f(strArr);
        return new e(charSequence, i10, i11, new v9.p<CharSequence, Integer, Pair<? extends Integer, ? extends Integer>>() { // from class: kotlin.text.StringsKt__StringsKt$rangesDelimitedBy$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            public final Pair<Integer, Integer> b(CharSequence $receiver, int i12) {
                Pair B10;
                kotlin.jvm.internal.i.f($receiver, "$this$$receiver");
                B10 = StringsKt__StringsKt.B($receiver, f10, i12, z10, false);
                if (B10 != null) {
                    return m9.g.a(B10.c(), Integer.valueOf(((String) B10.d()).length()));
                }
                return null;
            }

            @Override // v9.p
            public /* bridge */ /* synthetic */ Pair<? extends Integer, ? extends Integer> invoke(CharSequence charSequence2, Integer num) {
                return b(charSequence2, num.intValue());
            }
        });
    }

    public static /* synthetic */ kotlin.sequences.e T(CharSequence charSequence, String[] strArr, int i10, boolean z10, int i11, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            i10 = 0;
        }
        if ((i12 & 4) != 0) {
            z10 = false;
        }
        if ((i12 & 8) != 0) {
            i11 = 0;
        }
        return S(charSequence, strArr, i10, z10, i11);
    }

    public static final boolean U(CharSequence charSequence, int i10, CharSequence other, int i11, int i12, boolean z10) {
        kotlin.jvm.internal.i.f(charSequence, "<this>");
        kotlin.jvm.internal.i.f(other, "other");
        if (i11 < 0 || i10 < 0 || i10 > charSequence.length() - i12 || i11 > other.length() - i12) {
            return false;
        }
        for (int i13 = 0; i13 < i12; i13++) {
            if (!c.d(charSequence.charAt(i10 + i13), other.charAt(i11 + i13), z10)) {
                return false;
            }
        }
        return true;
    }

    public static final void V(int i10) {
        if (i10 >= 0) {
            return;
        }
        throw new IllegalArgumentException(("Limit must be non-negative, but was " + i10).toString());
    }

    public static final List<String> W(CharSequence charSequence, String[] delimiters, boolean z10, int i10) {
        Iterable e10;
        int p10;
        kotlin.jvm.internal.i.f(charSequence, "<this>");
        kotlin.jvm.internal.i.f(delimiters, "delimiters");
        if (delimiters.length == 1) {
            String str = delimiters[0];
            if (str.length() != 0) {
                return X(charSequence, str, z10, i10);
            }
        }
        e10 = SequencesKt___SequencesKt.e(T(charSequence, delimiters, 0, z10, i10, 2, null));
        p10 = kotlin.collections.p.p(e10, 10);
        ArrayList arrayList = new ArrayList(p10);
        Iterator it = e10.iterator();
        while (it.hasNext()) {
            arrayList.add(b0(charSequence, (B9.f) it.next()));
        }
        return arrayList;
    }

    public static final List<String> X(CharSequence charSequence, String str, boolean z10, int i10) {
        List<String> b10;
        boolean z11;
        V(i10);
        int i11 = 0;
        int F10 = F(charSequence, str, 0, z10);
        if (F10 == -1 || i10 == 1) {
            b10 = kotlin.collections.n.b(charSequence.toString());
            return b10;
        }
        if (i10 > 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        int i12 = 10;
        if (z11) {
            i12 = B9.i.e(i10, 10);
        }
        ArrayList arrayList = new ArrayList(i12);
        do {
            arrayList.add(charSequence.subSequence(i11, F10).toString());
            i11 = str.length() + F10;
            if (z11 && arrayList.size() == i10 - 1) {
                break;
            }
            F10 = F(charSequence, str, i11, z10);
        } while (F10 != -1);
        arrayList.add(charSequence.subSequence(i11, charSequence.length()).toString());
        return arrayList;
    }

    public static /* synthetic */ List Y(CharSequence charSequence, String[] strArr, boolean z10, int i10, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            z10 = false;
        }
        if ((i11 & 4) != 0) {
            i10 = 0;
        }
        return W(charSequence, strArr, z10, i10);
    }

    public static final kotlin.sequences.e<String> Z(final CharSequence charSequence, String[] delimiters, boolean z10, int i10) {
        kotlin.sequences.e<String> m10;
        kotlin.jvm.internal.i.f(charSequence, "<this>");
        kotlin.jvm.internal.i.f(delimiters, "delimiters");
        m10 = SequencesKt___SequencesKt.m(T(charSequence, delimiters, 0, z10, i10, 2, null), new v9.l<B9.f, String>() { // from class: kotlin.text.StringsKt__StringsKt$splitToSequence$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // v9.l
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public final String invoke(B9.f it) {
                kotlin.jvm.internal.i.f(it, "it");
                return StringsKt__StringsKt.b0(charSequence, it);
            }
        });
        return m10;
    }

    public static /* synthetic */ kotlin.sequences.e a0(CharSequence charSequence, String[] strArr, boolean z10, int i10, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            z10 = false;
        }
        if ((i11 & 4) != 0) {
            i10 = 0;
        }
        return Z(charSequence, strArr, z10, i10);
    }

    public static final String b0(CharSequence charSequence, B9.f range) {
        kotlin.jvm.internal.i.f(charSequence, "<this>");
        kotlin.jvm.internal.i.f(range, "range");
        return charSequence.subSequence(range.k().intValue(), range.j().intValue() + 1).toString();
    }

    public static final String c0(String str, char c10, String missingDelimiterValue) {
        int I10;
        kotlin.jvm.internal.i.f(str, "<this>");
        kotlin.jvm.internal.i.f(missingDelimiterValue, "missingDelimiterValue");
        I10 = I(str, c10, 0, false, 6, null);
        if (I10 != -1) {
            String substring = str.substring(I10 + 1, str.length());
            kotlin.jvm.internal.i.e(substring, "substring(...)");
            return substring;
        }
        return missingDelimiterValue;
    }

    public static final String d0(String str, String delimiter, String missingDelimiterValue) {
        int J10;
        kotlin.jvm.internal.i.f(str, "<this>");
        kotlin.jvm.internal.i.f(delimiter, "delimiter");
        kotlin.jvm.internal.i.f(missingDelimiterValue, "missingDelimiterValue");
        J10 = J(str, delimiter, 0, false, 6, null);
        if (J10 != -1) {
            String substring = str.substring(J10 + delimiter.length(), str.length());
            kotlin.jvm.internal.i.e(substring, "substring(...)");
            return substring;
        }
        return missingDelimiterValue;
    }

    public static /* synthetic */ String e0(String str, char c10, String str2, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            str2 = str;
        }
        return c0(str, c10, str2);
    }

    public static /* synthetic */ String f0(String str, String str2, String str3, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            str3 = str;
        }
        return d0(str, str2, str3);
    }

    public static final String g0(String str, char c10, String missingDelimiterValue) {
        kotlin.jvm.internal.i.f(str, "<this>");
        kotlin.jvm.internal.i.f(missingDelimiterValue, "missingDelimiterValue");
        int N10 = N(str, c10, 0, false, 6, null);
        if (N10 != -1) {
            String substring = str.substring(N10 + 1, str.length());
            kotlin.jvm.internal.i.e(substring, "substring(...)");
            return substring;
        }
        return missingDelimiterValue;
    }

    public static /* synthetic */ String h0(String str, char c10, String str2, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            str2 = str;
        }
        return g0(str, c10, str2);
    }

    public static Boolean i0(String str) {
        kotlin.jvm.internal.i.f(str, "<this>");
        if (kotlin.jvm.internal.i.b(str, "true")) {
            return Boolean.TRUE;
        }
        if (kotlin.jvm.internal.i.b(str, "false")) {
            return Boolean.FALSE;
        }
        return null;
    }

    public static CharSequence j0(CharSequence charSequence) {
        int i10;
        kotlin.jvm.internal.i.f(charSequence, "<this>");
        int length = charSequence.length() - 1;
        int i11 = 0;
        boolean z10 = false;
        while (i11 <= length) {
            if (!z10) {
                i10 = i11;
            } else {
                i10 = length;
            }
            boolean c10 = b.c(charSequence.charAt(i10));
            if (!z10) {
                if (!c10) {
                    z10 = true;
                } else {
                    i11++;
                }
            } else {
                if (!c10) {
                    break;
                }
                length--;
            }
        }
        return charSequence.subSequence(i11, length + 1);
    }

    public static boolean x(CharSequence charSequence, CharSequence other, boolean z10) {
        int J10;
        kotlin.jvm.internal.i.f(charSequence, "<this>");
        kotlin.jvm.internal.i.f(other, "other");
        if (other instanceof String) {
            J10 = J(charSequence, (String) other, 0, z10, 2, null);
            if (J10 < 0) {
                return false;
            }
        } else if (H(charSequence, other, 0, charSequence.length(), z10, false, 16, null) < 0) {
            return false;
        }
        return true;
    }

    public static /* synthetic */ boolean y(CharSequence charSequence, CharSequence charSequence2, boolean z10, int i10, Object obj) {
        boolean x10;
        if ((i10 & 2) != 0) {
            z10 = false;
        }
        x10 = x(charSequence, charSequence2, z10);
        return x10;
    }

    public static final boolean z(CharSequence charSequence, CharSequence suffix, boolean z10) {
        boolean o10;
        kotlin.jvm.internal.i.f(charSequence, "<this>");
        kotlin.jvm.internal.i.f(suffix, "suffix");
        if (!z10 && (charSequence instanceof String) && (suffix instanceof String)) {
            o10 = n.o((String) charSequence, (String) suffix, false, 2, null);
            return o10;
        }
        return U(charSequence, charSequence.length() - suffix.length(), suffix, 0, suffix.length(), z10);
    }
}
