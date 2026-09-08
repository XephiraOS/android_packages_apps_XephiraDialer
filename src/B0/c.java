package B0;

import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.util.Pair;
import com.customize.contacts.util.Q;
import com.google.common.collect.n;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.regex.Pattern;

/* compiled from: TextHighlighter.java */
/* loaded from: classes.dex */
public class c {

    /* renamed from: b, reason: collision with root package name */
    public static final Pattern f222b = Pattern.compile("[^\u0080-\uffff\\p{Alnum}_]");

    /* renamed from: a, reason: collision with root package name */
    public final int f223a;

    public c(int i10) {
        this.f223a = i10;
    }

    public static ArrayList<String> e(String str) {
        ArrayList<String> f10 = n.f();
        for (String str2 : f222b.split(str)) {
            if (!TextUtils.isEmpty(str2)) {
                f10.add(str2);
            }
        }
        return f10;
    }

    public CharSequence a(CharSequence charSequence, String str) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(charSequence)) {
            try {
                ArrayList<String> e10 = e(str);
                ArrayList<String> d10 = Q.d(e10);
                String upperCase = charSequence.toString().toUpperCase();
                ArrayList<String> e11 = e(charSequence.toString().toUpperCase());
                ArrayList<String> d11 = Q.d(e11);
                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(charSequence);
                boolean[] zArr = new boolean[e10.size()];
                boolean[] zArr2 = new boolean[e11.size()];
                int i10 = 0;
                for (int i11 = 0; i11 < d11.size(); i11++) {
                    int i12 = 0;
                    while (true) {
                        if (i12 >= d10.size()) {
                            break;
                        }
                        if (!zArr[i12]) {
                            if (d11.get(i11).startsWith(d10.get(i12))) {
                                zArr[i12] = true;
                                zArr2[i11] = true;
                                int indexOf = upperCase.indexOf(e11.get(i11), i10);
                                spannableStringBuilder.setSpan(new ForegroundColorSpan(this.f223a), indexOf, e10.get(i12).length() + indexOf, 34);
                                i10 += e11.get(i11).length();
                                break;
                            }
                            if (d10.get(i12).startsWith(d11.get(i11))) {
                                break;
                            }
                        }
                        i12++;
                    }
                }
                ArrayList<Pair<String, String>> d12 = d(e11, d11, zArr2);
                ArrayList<Pair<String, String>> c10 = c(e10, d10, zArr);
                if (d12.size() > 0 && c10.size() > 0) {
                    f(upperCase, spannableStringBuilder, d12, c10);
                }
                return spannableStringBuilder;
            } catch (Exception e12) {
                H7.b.c("TextHighlighter", "applyPrefixHighlight error " + e12);
            }
        }
        return charSequence;
    }

    public CharSequence b(String str, String str2) {
        String[] strArr;
        if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str)) {
            try {
                ArrayList<String> e10 = e(str2);
                String[] split = str.split("\\n");
                int length = split.length;
                int i10 = 0;
                while (i10 < length) {
                    String str3 = split[i10];
                    String upperCase = str3.toUpperCase();
                    ArrayList<String> e11 = e(upperCase);
                    SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str3);
                    int size = e10.size();
                    boolean[] zArr = new boolean[size];
                    int i11 = 0;
                    int i12 = 0;
                    while (i11 < e11.size()) {
                        int i13 = 0;
                        while (true) {
                            if (i13 < e10.size()) {
                                if (!zArr[i13] && e11.get(i11).startsWith(e10.get(i13))) {
                                    zArr[i13] = true;
                                    int indexOf = upperCase.indexOf(e11.get(i11), i12);
                                    strArr = split;
                                    spannableStringBuilder.setSpan(new ForegroundColorSpan(this.f223a), indexOf, e10.get(i13).length() + indexOf, 34);
                                    i12 += e11.get(i11).length();
                                    break;
                                }
                                i13++;
                                split = split;
                            } else {
                                strArr = split;
                                break;
                            }
                        }
                        i11++;
                        split = strArr;
                    }
                    String[] strArr2 = split;
                    int i14 = 0;
                    boolean z10 = false;
                    while (true) {
                        if (i14 < size) {
                            if (zArr[i14]) {
                                i14++;
                                z10 = true;
                            }
                        } else if (z10) {
                            return spannableStringBuilder;
                        }
                    }
                    i10++;
                    split = strArr2;
                }
            } catch (Exception e12) {
                H7.b.c("TextHighlighter", "findMatchHighlightLine error " + e12);
            }
        }
        return str;
    }

    public final ArrayList<Pair<String, String>> c(ArrayList<String> arrayList, ArrayList<String> arrayList2, boolean[] zArr) {
        ArrayList<Pair<String, String>> arrayList3 = new ArrayList<>(arrayList.size());
        int length = zArr.length;
        int size = arrayList2.size();
        int size2 = arrayList.size();
        for (int i10 = 0; i10 < length; i10++) {
            if (!zArr[i10] && i10 < size && i10 < size2) {
                arrayList3.add(new Pair<>(arrayList2.get(i10), arrayList.get(i10)));
            }
        }
        return arrayList3;
    }

    public final ArrayList<Pair<String, String>> d(ArrayList<String> arrayList, ArrayList<String> arrayList2, boolean[] zArr) {
        ArrayList<Pair<String, String>> arrayList3 = new ArrayList<>(arrayList2.size());
        int length = zArr.length;
        int size = arrayList2.size();
        int size2 = arrayList.size();
        for (int i10 = 0; i10 < length; i10++) {
            if (!zArr[i10] && i10 < size && i10 < size2) {
                arrayList3.add(new Pair<>(arrayList2.get(i10), arrayList.get(i10)));
            }
        }
        return arrayList3;
    }

    public final void f(String str, SpannableStringBuilder spannableStringBuilder, ArrayList<Pair<String, String>> arrayList, ArrayList<Pair<String, String>> arrayList2) {
        for (int i10 = 0; i10 < arrayList2.size(); i10++) {
            Pair<String, String> pair = arrayList2.get(i10);
            Iterator<Pair<String, String>> it = arrayList.iterator();
            while (true) {
                if (it.hasNext()) {
                    Pair<String, String> next = it.next();
                    if (((String) pair.first).indexOf((String) next.first) == 0) {
                        int indexOf = str.indexOf((String) next.second);
                        spannableStringBuilder.setSpan(new ForegroundColorSpan(this.f223a), indexOf, ((String) next.second).length() + indexOf, 34);
                        it.remove();
                        if (TextUtils.isEmpty(((String) pair.first).substring(((String) next.first).length()))) {
                            break;
                        } else {
                            pair = new Pair<>(((String) pair.first).substring(((String) next.first).length()), ((String) pair.second).substring(((String) next.second).length()));
                        }
                    } else if (((String) next.first).indexOf((String) pair.first) == 0) {
                        int indexOf2 = str.indexOf((String) next.second);
                        spannableStringBuilder.setSpan(new ForegroundColorSpan(this.f223a), indexOf2, ((String) pair.second).length() + indexOf2, 34);
                        it.remove();
                        break;
                    }
                }
            }
        }
    }
}
