package com.android.contacts.util;

import android.text.InputFilter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import java.util.Stack;

/* compiled from: SearchUtil.java */
/* loaded from: classes.dex */
public class z {

    /* compiled from: SearchUtil.java */
    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public int f17629a = -1;

        /* renamed from: b, reason: collision with root package name */
        public String f17630b;

        public String toString() {
            return "MatchedLine{line='" + this.f17630b + "', startIndex=" + this.f17629a + '}';
        }
    }

    public static String a(String str) {
        int i10 = 0;
        while (i10 < str.length()) {
            int codePointAt = str.codePointAt(i10);
            if (Character.isLetterOrDigit(codePointAt)) {
                break;
            }
            i10 += Character.charCount(codePointAt);
        }
        if (i10 == str.length()) {
            return "";
        }
        int length = str.length();
        do {
            length--;
            if (length <= -1) {
                break;
            }
            if (Character.isLowSurrogate(str.charAt(length))) {
                length--;
            }
        } while (!Character.isLetterOrDigit(str.codePointAt(length)));
        return str.substring(i10, length + 1);
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x0051, code lost:
    
        return r9;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static int b(java.lang.String r8, java.lang.String r9) {
        /*
            int r0 = r8.length()
            int r1 = r9.length()
            r2 = -1
            if (r0 >= r1) goto Lc
            return r2
        Lc:
            int r0 = r9.length()
            int[] r0 = new int[r0]
            r1 = 0
            r3 = r1
            r4 = r3
        L15:
            int r5 = r9.length()
            if (r3 >= r5) goto L29
            int r5 = java.lang.Character.codePointAt(r9, r3)
            r0[r4] = r5
            int r4 = r4 + 1
            int r5 = java.lang.Character.charCount(r5)
            int r3 = r3 + r5
            goto L15
        L29:
            r9 = r1
        L2a:
            int r3 = r8.length()
            if (r9 >= r3) goto L57
            r3 = r9
            r5 = r1
        L32:
            int r6 = r8.length()
            if (r3 >= r6) goto L4f
            if (r5 >= r4) goto L4f
            int r6 = r8.codePointAt(r3)
            int r6 = java.lang.Character.toLowerCase(r6)
            r7 = r0[r5]
            if (r6 == r7) goto L47
            goto L4f
        L47:
            int r6 = java.lang.Character.charCount(r6)
            int r3 = r3 + r6
            int r5 = r5 + 1
            goto L32
        L4f:
            if (r5 != r4) goto L52
            return r9
        L52:
            int r9 = d(r8, r9)
            goto L2a
        L57:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.contacts.util.z.b(java.lang.String, java.lang.String):int");
    }

    public static a c(String str, String str2) {
        a aVar = new a();
        int b10 = b(str, str2);
        if (b10 != -1) {
            int i10 = b10 - 1;
            while (i10 > -1 && str.charAt(i10) != '\n') {
                i10--;
            }
            int i11 = b10 + 1;
            while (i11 < str.length() && str.charAt(i11) != '\n') {
                i11++;
            }
            int i12 = i10 + 1;
            aVar.f17630b = str.substring(i12, i11);
            aVar.f17629a = b10 - i12;
        }
        return aVar;
    }

    public static int d(String str, int i10) {
        while (i10 <= str.length()) {
            if (i10 == str.length()) {
                return i10;
            }
            int codePointAt = str.codePointAt(i10);
            if (!Character.isLetterOrDigit(codePointAt)) {
                break;
            }
            i10 += Character.charCount(codePointAt);
        }
        while (i10 <= str.length()) {
            if (i10 == str.length()) {
                return i10;
            }
            int codePointAt2 = str.codePointAt(i10);
            if (Character.isLetterOrDigit(codePointAt2)) {
                break;
            }
            i10 += Character.charCount(codePointAt2);
        }
        return i10;
    }

    public static void e(EditText editText, int i10) {
        Stack stack = new Stack();
        stack.push(editText);
        while (!stack.isEmpty()) {
            View view = (View) stack.pop();
            if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                for (int i11 = 0; i11 < viewGroup.getChildCount(); i11++) {
                    stack.push(viewGroup.getChildAt(i11));
                }
            } else if (view instanceof EditText) {
                ((EditText) view).setFilters(new InputFilter[]{new InputFilter.LengthFilter(i10)});
                return;
            }
        }
    }
}
