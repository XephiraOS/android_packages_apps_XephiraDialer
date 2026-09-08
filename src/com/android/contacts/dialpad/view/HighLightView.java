package com.android.contacts.dialpad.view;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;
import com.android.contacts.framework.baseui.util.r;
import com.android.contacts.framework.phonenumber.PhoneNumberUtils;
import com.android.incallui.OplusPhoneUtils;
import com.customize.contacts.FeatureOption;
import com.customize.contacts.util.K;
import com.oplus.dialer.R;
import java.util.ArrayList;
import java.util.regex.Pattern;
import z7.b0;
import z7.c0;
import z7.d0;
import z7.e0;

/* loaded from: classes.dex */
public class HighLightView extends AppCompatTextView {

    /* renamed from: B, reason: collision with root package name */
    public static final char[] f15035B = {'2', '2', '2', '3', '3', '3', '4', '4', '4', '5', '5', '5', '6', '6', '6', '7', '7', '7', '7', '8', '8', '8', '9', '9', '9', '9'};

    /* renamed from: C, reason: collision with root package name */
    public static final char[] f15036C = {'1', '1', '1', '1', '1', '2', '2', '2', '2', '3', '3', '3', '3', '4', '4', '4', '4', '4', '4', '5', '5', '5', '5', '5', '6', '6', '6', '6', '6', '7', '7', '7', '7', '7', '8', '8', '8', '8', '8', '8', '8', '9', '9', '9', '9', '9'};

    /* renamed from: D, reason: collision with root package name */
    public static final char[] f15037D = {'2', '2', '2', '2', '2', '3', '3', '3', '3', '3', '4', '4', '4', '5', '5', '5', '6', '6', '6', '6', '6', '7', '7', '7', '7', '8', '8', '8', '8', '9', '9', '9', '9'};

    /* renamed from: E, reason: collision with root package name */
    public static final char[] f15038E = {'2', '2', '2', '2', '3', '3', '3', '3', '3', '4', '4', '4', '4', '5', '5', '5', '5', '6', '6', '6', '6', '7', '7', '7', '7', '8', '8', '8', '8', '9', '9', '9', '9'};

    /* renamed from: F, reason: collision with root package name */
    public static final char[] f15039F = {'2', '2', '2', '2', '2', '3', '3', '3', '3', '3', '4', '4', '4', '4', '4', '4', '5', '5', '5', '5', '6', '6', '6', '6', '7', '7', '7', '7', '8', '8', '9', '9', '9'};

    /* renamed from: G, reason: collision with root package name */
    public static final char[] f15040G = {'1', '1', '1', '1', '2', '2', '2', '2', '3', '3', '3', '4', '4', '4', '5', '5', '5', '5', '6', '6', '6', '7', '7', '7', '7', '8', '8', '8', '8', '9', '9', '9', '9', '9', '0', '0', '0'};

    /* renamed from: H, reason: collision with root package name */
    public static final Pattern f15041H = Pattern.compile("^[a-zA-Z0-9\\+\\(\\)\\s,\\-]*");

    /* renamed from: I, reason: collision with root package name */
    public static b0 f15042I;

    /* renamed from: A, reason: collision with root package name */
    public int f15043A;

    /* renamed from: a, reason: collision with root package name */
    public boolean f15044a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f15045b;

    /* renamed from: c, reason: collision with root package name */
    public StringBuilder f15046c;

    /* renamed from: d, reason: collision with root package name */
    public TextPaint f15047d;

    /* renamed from: e, reason: collision with root package name */
    public TextPaint f15048e;

    /* renamed from: f, reason: collision with root package name */
    public int f15049f;

    /* renamed from: g, reason: collision with root package name */
    public String f15050g;

    /* renamed from: h, reason: collision with root package name */
    public String f15051h;

    /* renamed from: i, reason: collision with root package name */
    public ArrayList<b0.a> f15052i;

    /* renamed from: j, reason: collision with root package name */
    public ArrayList<String> f15053j;

    /* renamed from: k, reason: collision with root package name */
    public String f15054k;

    /* renamed from: l, reason: collision with root package name */
    public String f15055l;

    /* renamed from: m, reason: collision with root package name */
    public String f15056m;

    /* renamed from: n, reason: collision with root package name */
    public boolean f15057n;

    /* renamed from: o, reason: collision with root package name */
    public String f15058o;

    /* renamed from: p, reason: collision with root package name */
    public String f15059p;

    /* renamed from: q, reason: collision with root package name */
    public String f15060q;

    /* renamed from: r, reason: collision with root package name */
    public String f15061r;

    /* renamed from: x, reason: collision with root package name */
    public int f15062x;

    /* renamed from: y, reason: collision with root package name */
    public int f15063y;

    /* renamed from: z, reason: collision with root package name */
    public int f15064z;

    public HighLightView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f15044a = false;
        this.f15045b = false;
        this.f15046c = new StringBuilder();
        this.f15057n = false;
        this.f15064z = -1;
        this.f15043A = -1;
        if (f15042I == null) {
            f15042I = b0.c();
        }
        TextPaint paint = getPaint();
        this.f15047d = paint;
        if (paint == null) {
            this.f15047d = new TextPaint(1);
        }
        this.f15047d = new TextPaint(1);
        this.f15047d.setColor(context.getColor(R.color.coui_preference_title_color));
        this.f15047d.density = getResources().getDisplayMetrics().density;
        this.f15047d.setTextSize(getTextSize());
        this.f15048e = new TextPaint(1);
        int a10 = r.a(context);
        this.f15049f = a10;
        this.f15048e.setColor(a10);
        this.f15048e.density = getResources().getDisplayMetrics().density;
        this.f15048e.setTextSize(getTextSize());
    }

    public static String c(String str) {
        if (str != null && str.length() != 0) {
            StringBuffer stringBuffer = new StringBuffer();
            int length = str.length();
            for (int i10 = 0; i10 != length; i10++) {
                char charAt = str.charAt(i10);
                if ((charAt >= 'a' && charAt <= 'z') || (charAt >= 'A' && charAt <= 'Z')) {
                    stringBuffer.append(f15035B[Character.toUpperCase(charAt) - 'A']);
                } else {
                    stringBuffer.append(charAt);
                }
            }
            return stringBuffer.toString();
        }
        return "";
    }

    public static ArrayList<String> f(String str) {
        int i10;
        ArrayList<b0.a> b10 = f15042I.b(str);
        int size = b10.size();
        ArrayList arrayList = new ArrayList();
        for (int i11 = 0; i11 < size; i11++) {
            b0.a aVar = b10.get(i11);
            if (aVar.f38336a == 2) {
                arrayList.add(aVar.f38338c);
            } else {
                for (char c10 : aVar.f38338c.toCharArray()) {
                    arrayList.add(Character.toString(c10));
                }
            }
        }
        ArrayList arrayList2 = new ArrayList();
        int size2 = arrayList.size();
        for (int i12 = 0; i12 < size2; i12++) {
            ArrayList<String> c11 = e0.c(str.charAt(i12));
            if (c11 == null) {
                ArrayList arrayList3 = new ArrayList();
                arrayList3.add((String) arrayList.get(i12));
                arrayList2.add(arrayList3);
            } else {
                arrayList2.add(c11);
            }
        }
        ArrayList<ArrayList<String>> b11 = e0.b(arrayList2);
        if (b11 != null) {
            i10 = b11.size();
        } else {
            i10 = 0;
        }
        ArrayList<String> arrayList4 = new ArrayList<>();
        for (int i13 = 0; i13 < i10; i13++) {
            ArrayList<String> arrayList5 = b11.get(i13);
            StringBuilder sb = new StringBuilder();
            int size3 = arrayList5.size();
            for (int i14 = 0; i14 < size3; i14++) {
                String str2 = arrayList5.get(i14);
                if (i14 == size3 - 1) {
                    sb.append(str2);
                } else {
                    sb.append(str2.charAt(0));
                }
            }
            arrayList4.add(c(sb.toString()));
        }
        return arrayList4;
    }

    public static String l(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        char[] charArray = str.toCharArray();
        int i10 = 0;
        for (char c10 : charArray) {
            if (!Character.isSpace(c10)) {
                charArray[i10] = c10;
                i10++;
            }
        }
        if (i10 != charArray.length) {
            return new String(charArray, 0, i10);
        }
        return str;
    }

    public static String m(String str) {
        char[] charArray = str.toCharArray();
        int i10 = 0;
        for (char c10 : charArray) {
            if (c10 >= '1' && c10 <= '5') {
                charArray[i10] = c10;
                i10++;
            }
        }
        if (i10 != charArray.length) {
            return new String(charArray, 0, i10);
        }
        return str;
    }

    public boolean a() {
        if (!this.f15057n && this.f15043A > 0) {
            return true;
        }
        return false;
    }

    public String b(String str) {
        if (str != null && str.length() != 0) {
            String trim = str.trim();
            StringBuilder sb = new StringBuilder();
            char[] charArray = trim.toCharArray();
            for (int i10 = 0; i10 < charArray.length; i10++) {
                if (charArray[i10] == ' ' && charArray[i10 + 1] == ' ') {
                    charArray[i10] = '$';
                }
            }
            for (char c10 : charArray) {
                if (c10 != '$') {
                    sb.append(c10);
                }
            }
            return sb.toString();
        }
        return null;
    }

    public final String d(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        int length = str.length();
        for (int i10 = 0; i10 < length; i10++) {
            char charAt = str.charAt(i10);
            if (charAt != 19968) {
                if (charAt != 20008) {
                    if (charAt != 20022) {
                        if (charAt != 20031) {
                            if (charAt == 20059) {
                                sb.append("5");
                            }
                        } else {
                            sb.append("3");
                        }
                    } else {
                        sb.append("4");
                    }
                } else {
                    sb.append("2");
                }
            } else {
                sb.append(OplusPhoneUtils.DeviceState.LOCK_DEVICE);
            }
        }
        return sb.toString();
    }

    public String e(String str) {
        return d(c0.b(str));
    }

    public void g(String str) {
        this.f15064z = -1;
        this.f15043A = -1;
        int indexOf = this.f15055l.indexOf(str);
        if (indexOf < 0) {
            str = PhoneNumberUtils.e(str);
            indexOf = this.f15055l.indexOf(str);
        }
        if (indexOf >= 0) {
            this.f15064z = indexOf;
            int i10 = this.f15062x;
            if (indexOf >= i10) {
                this.f15064z = i10 - 1;
            }
            this.f15043A = Math.min(i10 - this.f15064z, str.length());
            return;
        }
        int i11 = 0;
        if (this.f15058o.startsWith(str)) {
            this.f15064z = 0;
            int length = this.f15062x - (this.f15058o.length() - str.length());
            this.f15043A = length;
            if (length <= 0) {
                this.f15043A = 1;
                return;
            }
            return;
        }
        int[] iArr = new int[this.f15062x];
        for (int i12 = 0; i12 < this.f15062x; i12++) {
            iArr[i12] = this.f15053j.get(i12).length();
        }
        int indexOf2 = this.f15056m.indexOf(str);
        if (indexOf2 >= 0) {
            int i13 = iArr[0];
            while (i13 <= indexOf2) {
                i11++;
                i13 += iArr[i11];
            }
            this.f15064z = i11;
            int length2 = str.length();
            while (length2 > 0) {
                length2 -= iArr[i11];
                i11++;
            }
            this.f15043A = i11 - this.f15064z;
        }
    }

    public void h(String str) {
        this.f15064z = -1;
        this.f15043A = -1;
        int indexOf = this.f15059p.indexOf(str);
        if (indexOf >= 0) {
            this.f15064z = indexOf;
            int i10 = this.f15062x;
            if (indexOf >= i10) {
                this.f15064z = i10 - 1;
            }
            this.f15043A = Math.min(i10 - this.f15064z, str.length());
            return;
        }
        int i11 = 0;
        if (this.f15060q.startsWith(str)) {
            this.f15064z = 0;
            int length = this.f15062x - (this.f15060q.length() - str.length());
            this.f15043A = length;
            if (length <= 0) {
                this.f15043A = 1;
                return;
            }
            return;
        }
        int[] iArr = new int[this.f15062x];
        for (int i12 = 0; i12 < this.f15062x; i12++) {
            iArr[i12] = this.f15053j.get(i12).length();
        }
        int indexOf2 = this.f15061r.indexOf(str);
        if (indexOf2 >= 0) {
            int i13 = iArr[0];
            while (i13 <= indexOf2) {
                i11++;
                i13 += iArr[i11];
            }
            this.f15064z = i11;
            int length2 = str.length();
            while (length2 > 0) {
                length2 -= iArr[i11];
                i11++;
            }
            this.f15043A = i11 - this.f15064z;
        }
    }

    public final void i(String str, String str2) {
        int indexOf = str.indexOf(str2);
        if (indexOf >= 0) {
            this.f15064z = indexOf;
            this.f15043A = str2.length();
        }
    }

    public final void j(String str, String str2) {
        ArrayList<b0.a> b10 = f15042I.b(str);
        this.f15052i = b10;
        int size = b10.size();
        ArrayList arrayList = new ArrayList();
        if (size == 0) {
            return;
        }
        for (int i10 = 0; i10 < size; i10++) {
            b0.a aVar = this.f15052i.get(i10);
            if (aVar.f38336a == 2) {
                arrayList.add(aVar.f38338c);
            } else {
                for (char c10 : aVar.f38338c.toCharArray()) {
                    arrayList.add(Character.toString(c10));
                }
            }
        }
        ArrayList arrayList2 = new ArrayList();
        int length = str.length();
        for (int i11 = 0; i11 < length; i11++) {
            ArrayList<String> c11 = e0.c(str.charAt(i11));
            if (c11 == null) {
                ArrayList arrayList3 = new ArrayList();
                arrayList3.add((String) arrayList.get(i11));
                arrayList2.add(arrayList3);
            } else {
                arrayList2.add(c11);
            }
        }
        ArrayList<ArrayList<String>> b11 = e0.b(arrayList2);
        if (b11 == null) {
            this.f15064z = -1;
            this.f15043A = -1;
            return;
        }
        int size2 = b11.size();
        for (int i12 = 0; i12 < size2; i12++) {
            ArrayList<String> arrayList4 = b11.get(i12);
            StringBuilder sb = new StringBuilder();
            StringBuilder sb2 = new StringBuilder();
            StringBuilder sb3 = new StringBuilder();
            int size3 = arrayList4.size();
            this.f15062x = size3;
            for (int i13 = 0; i13 < size3; i13++) {
                String str3 = arrayList4.get(i13);
                if (i13 == size3 - 1) {
                    sb.append(str3);
                } else {
                    sb.append(str3.charAt(0));
                }
                sb2.append(str3);
                if (i13 == 0) {
                    sb3.append(str3);
                } else {
                    sb3.append(str3.charAt(0));
                }
            }
            this.f15053j = arrayList4;
            this.f15055l = c(sb.toString());
            this.f15058o = c(sb3.toString());
            this.f15056m = c(sb2.toString());
            g(str2);
            if (this.f15064z != -1 && this.f15043A != -1) {
                return;
            }
        }
    }

    public final void k(String str, String str2) {
        ArrayList<b0.a> b10 = f15042I.b(str);
        this.f15052i = b10;
        int size = b10.size();
        ArrayList arrayList = new ArrayList();
        for (int i10 = 0; i10 < size; i10++) {
            b0.a aVar = this.f15052i.get(i10);
            if (aVar.f38336a == 2) {
                arrayList.add(d0.a(aVar.f38338c));
            } else {
                for (char c10 : aVar.f38338c.toCharArray()) {
                    arrayList.add(Character.toString(c10));
                }
            }
        }
        ArrayList arrayList2 = new ArrayList();
        int length = str.length();
        for (int i11 = 0; i11 < length; i11++) {
            ArrayList<String> d10 = e0.d(str.charAt(i11));
            if (d10 == null) {
                ArrayList arrayList3 = new ArrayList();
                arrayList3.add((String) arrayList.get(i11));
                arrayList2.add(arrayList3);
            } else {
                arrayList2.add(d10);
            }
        }
        ArrayList<ArrayList<String>> b11 = e0.b(arrayList2);
        if (b11 == null) {
            this.f15064z = -1;
            this.f15043A = -1;
            return;
        }
        int size2 = b11.size();
        for (int i12 = 0; i12 < size2; i12++) {
            ArrayList<String> arrayList4 = b11.get(i12);
            StringBuilder sb = new StringBuilder();
            StringBuilder sb2 = new StringBuilder();
            StringBuilder sb3 = new StringBuilder();
            int size3 = arrayList4.size();
            this.f15062x = size3;
            for (int i13 = 0; i13 < size3; i13++) {
                String str3 = arrayList4.get(i13);
                sb.append(str3.charAt(0));
                sb2.append(str3);
                if (i13 == 0) {
                    sb3.append(str3);
                } else {
                    sb3.append(str3.charAt(0));
                }
            }
            this.f15053j = arrayList4;
            this.f15059p = sb.toString();
            this.f15060q = sb3.toString();
            this.f15061r = sb2.toString();
            h(str2);
            if (this.f15064z != -1 && this.f15043A != -1) {
                return;
            }
        }
    }

    public void n(String str) {
        ArrayList<b0.a> b10 = f15042I.b(str);
        this.f15052i = b10;
        int size = b10.size();
        this.f15053j = new ArrayList<>();
        for (int i10 = 0; i10 < size; i10++) {
            b0.a aVar = this.f15052i.get(i10);
            if (aVar.f38336a == 2) {
                this.f15053j.add(aVar.f38338c);
            } else {
                for (char c10 : aVar.f38338c.toCharArray()) {
                    if (c10 != '(' && c10 != 65288) {
                        this.f15053j.add(Character.toString(c10));
                    } else if (H7.a.b()) {
                        H7.b.b("HighLightView", "[praseContactName] the name contain (");
                    }
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        StringBuilder sb3 = new StringBuilder();
        int size2 = this.f15053j.size();
        this.f15062x = size2;
        for (int i11 = 0; i11 < size2; i11++) {
            String str2 = this.f15053j.get(i11);
            if (i11 == size2 - 1) {
                sb.append(str2);
            } else {
                sb.append(str2.charAt(0));
            }
            sb2.append(str2);
            if (i11 == 0) {
                sb3.append(str2);
            } else {
                sb3.append(str2.charAt(0));
            }
        }
        this.f15055l = c(sb.toString());
        this.f15058o = c(sb3.toString());
        this.f15056m = c(sb2.toString());
    }

    public void o(String str) {
        ArrayList<b0.a> b10 = f15042I.b(str);
        this.f15052i = b10;
        int size = b10.size();
        this.f15053j = new ArrayList<>();
        for (int i10 = 0; i10 < size; i10++) {
            b0.a aVar = this.f15052i.get(i10);
            if (aVar.f38336a == 2) {
                this.f15053j.add(d0.a(aVar.f38338c));
            } else {
                for (char c10 : aVar.f38338c.toCharArray()) {
                    if (c10 != '(' && c10 != 65288) {
                        this.f15053j.add(Character.toString(c10));
                    } else {
                        H7.b.b("HighLightView", "[praseContactName] the name contain (");
                    }
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        StringBuilder sb3 = new StringBuilder();
        int size2 = this.f15053j.size();
        this.f15062x = size2;
        for (int i11 = 0; i11 < size2; i11++) {
            String str2 = this.f15053j.get(i11);
            sb.append(str2.charAt(0));
            sb2.append(str2);
            if (i11 == 0) {
                sb3.append(str2);
            } else {
                sb3.append(str2.charAt(0));
            }
        }
        this.f15059p = sb.toString();
        this.f15060q = sb3.toString();
        this.f15061r = sb2.toString();
    }

    public final void p(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str3)) {
            return;
        }
        if (K.h()) {
            o(str2);
            h(str3);
            if (this.f15064z == -1 || this.f15043A == -1) {
                k(str2, str3);
                return;
            }
            return;
        }
        n(str2);
        g(str3);
        if (this.f15064z == -1 || this.f15043A == -1) {
            j(str2, str3);
        }
    }

    public void q(String str, String str2, String str3, int i10) {
        String l10 = l(str2);
        this.f15050g = l10;
        if (TextUtils.isEmpty(l10)) {
            this.f15064z = -1;
            this.f15043A = -1;
            setText(str2);
            return;
        }
        if (this.f15057n) {
            setText(str2);
            return;
        }
        if (this.f15044a) {
            setText(str2);
            return;
        }
        String c10 = c(str3);
        this.f15051h = c10;
        this.f15063y = i10;
        this.f15054k = str2;
        if (i10 == 4 || i10 == 5 || i10 == 6 || i10 == 7 || i10 == 8 || i10 == 9) {
            p(str, this.f15050g, c10);
            String a10 = com.android.contacts.dialpad.b.a(this.f15050g);
            if (a10 != null) {
                i(a10, str3);
            }
            if (i10 != 8 && r()) {
                return;
            }
        }
        if (FeatureOption.o() && this.f15045b && !K.h()) {
            setText(str2);
            return;
        }
        if (i10 == 0) {
            p(str, this.f15050g, this.f15051h);
        } else if (i10 == 1) {
            s(str, this.f15050g, this.f15051h);
        } else if (i10 == 3) {
            this.f15064z = -1;
            this.f15043A = -1;
        } else if (i10 == 2) {
            ArrayList<String> f10 = f(this.f15050g);
            this.f15064z = -1;
            this.f15043A = -1;
            int size = f10.size();
            int i11 = 0;
            while (true) {
                if (i11 >= size) {
                    break;
                }
                if (f10.get(i11).startsWith(this.f15051h)) {
                    this.f15064z = 0;
                    this.f15043A = Math.min(this.f15050g.length() - this.f15064z, str3.length());
                    break;
                }
                i11++;
            }
        }
        if (!TextUtils.isEmpty(this.f15051h) && this.f15064z >= 0) {
            t();
        } else {
            setText(str2);
        }
    }

    public final boolean r() {
        String str;
        int i10;
        String str2;
        int length;
        if (!TextUtils.isEmpty(this.f15051h) && this.f15064z >= 0) {
            if (this.f15063y == 2) {
                str = this.f15050g;
                i10 = str.length();
            } else {
                str = this.f15050g;
                i10 = this.f15062x;
            }
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
            boolean matches = str.matches(f15041H.pattern());
            String b10 = b(this.f15054k);
            if (!TextUtils.isEmpty(b10)) {
                String[] split = b10.split(" ");
                int i11 = this.f15064z;
                if (i11 > 0) {
                    str2 = str.substring(0, i11);
                } else {
                    str2 = null;
                }
                int i12 = this.f15064z;
                String substring = str.substring(i12, this.f15043A + i12);
                if (str2 != null) {
                    try {
                        setNormalMode(true);
                        length = str2.length();
                        if (!matches) {
                            setText(str);
                            return true;
                        }
                    } catch (Exception e10) {
                        H7.b.c("HighLightView", "on draw  error!");
                        H7.b.c("HighLightView", "Exception e: " + e10);
                    }
                } else {
                    length = 0;
                }
                if (H7.a.b()) {
                    H7.b.b("HighLightView", "secondLength = 0 secondIndex = 0");
                }
                int length2 = substring.length();
                StringBuilder sb = new StringBuilder();
                if (split.length > 0) {
                    int i13 = 0;
                    while (i13 < split.length && length2 >= split[i13].length()) {
                        sb.append(split[i13] + " ");
                        length2 -= split[i13].length();
                        i13++;
                    }
                    if (length2 > 0) {
                        if (length2 <= split[i13].length()) {
                            sb.append(split[i13].substring(0, length2));
                        } else {
                            StringBuilder sb2 = new StringBuilder();
                            String str3 = split[i13];
                            sb2.append(str3.substring(0, str3.length()));
                            sb2.append(" ");
                            sb.append(sb2.toString());
                            sb.append(split[i13 + 1].substring(0, length2 - split[i13].length()));
                        }
                    }
                }
                String sb3 = sb.toString();
                if (sb3 != null) {
                    int length3 = sb3.length() + length;
                    if (length3 <= i10) {
                        i10 = length3;
                    }
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(this.f15049f), length, i10, 33);
                }
                setText(spannableStringBuilder);
                return true;
            }
        }
        return false;
    }

    public final void s(String str, String str2, String str3) {
        this.f15064z = -1;
        this.f15043A = -1;
        String e10 = e(str2);
        if (TextUtils.isEmpty(e10)) {
            return;
        }
        String m10 = m(str3);
        if (e10.startsWith(m10)) {
            this.f15064z = 0;
            this.f15043A = m10.length();
        }
    }

    public void setHightTextColor(int i10) {
        this.f15049f = i10;
        this.f15048e.setColor(i10);
    }

    public void setNormalMode(boolean z10) {
        this.f15057n = z10;
    }

    public void setTextPaintColor(int i10) {
        this.f15047d.setColor(i10);
    }

    /* JADX WARN: Removed duplicated region for block: B:46:0x0302  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0303  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void t() {
        /*
            Method dump skipped, instructions count: 812
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.contacts.dialpad.view.HighLightView.t():void");
    }

    public void setToken(b0.a aVar) {
    }
}
