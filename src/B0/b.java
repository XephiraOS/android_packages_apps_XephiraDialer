package B0;

import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.widget.TextView;
import com.android.contacts.framework.phonenumber.PhoneNumberUtils;

/* compiled from: PrefixHighlighter.java */
/* loaded from: classes.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    public final int f220a;

    /* renamed from: b, reason: collision with root package name */
    public ForegroundColorSpan f221b;

    public b(int i10) {
        this.f220a = i10;
    }

    public CharSequence a(CharSequence charSequence, char[] cArr) {
        if (cArr != null && !TextUtils.isEmpty(charSequence)) {
            int[] a10 = a.a(charSequence, cArr);
            if (a10[0] == -1) {
                cArr = PhoneNumberUtils.e(String.copyValueOf(cArr)).toUpperCase().toCharArray();
                a10 = a.a(charSequence, cArr);
            }
            if (a10[0] != -1) {
                if (this.f221b == null) {
                    this.f221b = new ForegroundColorSpan(this.f220a);
                }
                SpannableString spannableString = new SpannableString(charSequence);
                try {
                    ForegroundColorSpan foregroundColorSpan = this.f221b;
                    int i10 = a10[0];
                    spannableString.setSpan(foregroundColorSpan, i10, (cArr.length + i10) - a10[1], 0);
                } catch (Exception e10) {
                    H7.b.c("PrefixHighlighter", "e=" + e10);
                }
                return spannableString;
            }
        }
        return charSequence;
    }

    /* JADX WARN: Code restructure failed: missing block: B:34:0x004b, code lost:
    
        if (r8 <= 0) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0053, code lost:
    
        if (r18[r8 - 1] != (r13 - 1)) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0055, code lost:
    
        r4.setSpan(new android.text.style.ForegroundColorSpan(r16.f220a), r13, r15, 34);
     */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0093 A[Catch: Exception -> 0x00c3, TryCatch #0 {Exception -> 0x00c3, blocks: (B:7:0x0017, B:10:0x0025, B:12:0x003a, B:14:0x0040, B:19:0x0093, B:21:0x009d, B:35:0x004d, B:37:0x0055, B:39:0x0060, B:41:0x0064, B:43:0x0068, B:48:0x006f, B:50:0x007f, B:52:0x0085, B:56:0x008b, B:26:0x00a4, B:28:0x00aa), top: B:6:0x0017 }] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0092 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.CharSequence b(java.lang.CharSequence r17, int[] r18) {
        /*
            r16 = this;
            r0 = r16
            r1 = r18
            java.lang.String r2 = "^[a-zA-Z0-9]*"
            boolean r3 = android.text.TextUtils.isEmpty(r17)
            if (r3 == 0) goto Le
            r0 = 0
            return r0
        Le:
            java.lang.String r3 = r17.toString()
            android.text.SpannableStringBuilder r4 = new android.text.SpannableStringBuilder
            r4.<init>(r3)
            int r5 = r1.length     // Catch: java.lang.Exception -> Lc3
            int r6 = r3.length()     // Catch: java.lang.Exception -> Lc3
            r7 = 0
            r8 = r7
            r9 = r8
            r10 = r9
        L20:
            r11 = 34
            r12 = 1
            if (r8 >= r5) goto La0
            r13 = r1[r8]     // Catch: java.lang.Exception -> Lc3
            java.lang.String r14 = B0.a.c(r3, r13, r7, r12)     // Catch: java.lang.Exception -> Lc3
            int r15 = r14.length()     // Catch: java.lang.Exception -> Lc3
            int r15 = r15 + r13
            java.lang.String r7 = com.customize.contacts.util.j0.a(r14)     // Catch: java.lang.Exception -> Lc3
            boolean r14 = r14.matches(r2)     // Catch: java.lang.Exception -> Lc3
            if (r14 != 0) goto L49
            boolean r14 = android.text.TextUtils.isEmpty(r7)     // Catch: java.lang.Exception -> Lc3
            if (r14 != 0) goto L47
            boolean r7 = r7.matches(r2)     // Catch: java.lang.Exception -> Lc3
            if (r7 == 0) goto L47
            goto L49
        L47:
            r10 = 0
            goto L90
        L49:
            if (r10 == 0) goto L60
            if (r8 <= 0) goto L60
            int r7 = r8 + (-1)
            r7 = r1[r7]     // Catch: java.lang.Exception -> Lc3
            int r14 = r13 + (-1)
            if (r7 != r14) goto L60
            android.text.style.ForegroundColorSpan r7 = new android.text.style.ForegroundColorSpan     // Catch: java.lang.Exception -> Lc3
            int r14 = r0.f220a     // Catch: java.lang.Exception -> Lc3
            r7.<init>(r14)     // Catch: java.lang.Exception -> Lc3
            r4.setSpan(r7, r13, r15, r11)     // Catch: java.lang.Exception -> Lc3
            goto L9d
        L60:
            int r7 = r13 + 1
        L62:
            if (r7 >= r6) goto L8f
            int r10 = r8 + 1
            if (r10 >= r5) goto L6f
            r14 = r1[r10]     // Catch: java.lang.Exception -> Lc3
            if (r14 != r7) goto L6f
            r8 = r10
            r9 = r12
            goto L8f
        L6f:
            int r10 = r7 + 1
            java.lang.String r7 = r3.substring(r7, r10)     // Catch: java.lang.Exception -> Lc3
            java.lang.String r14 = com.customize.contacts.util.j0.a(r7)     // Catch: java.lang.Exception -> Lc3
            boolean r7 = r7.matches(r2)     // Catch: java.lang.Exception -> Lc3
            if (r7 != 0) goto L8b
            boolean r7 = android.text.TextUtils.isEmpty(r14)     // Catch: java.lang.Exception -> Lc3
            if (r7 != 0) goto L8f
            boolean r7 = r14.matches(r2)     // Catch: java.lang.Exception -> Lc3
            if (r7 == 0) goto L8f
        L8b:
            int r15 = r15 + 1
            r7 = r10
            goto L62
        L8f:
            r10 = r12
        L90:
            if (r9 == 0) goto L93
            goto La0
        L93:
            android.text.style.ForegroundColorSpan r7 = new android.text.style.ForegroundColorSpan     // Catch: java.lang.Exception -> Lc3
            int r14 = r0.f220a     // Catch: java.lang.Exception -> Lc3
            r7.<init>(r14)     // Catch: java.lang.Exception -> Lc3
            r4.setSpan(r7, r13, r15, r11)     // Catch: java.lang.Exception -> Lc3
        L9d:
            int r8 = r8 + r12
            r7 = 0
            goto L20
        La0:
            if (r9 == 0) goto Lc3
            if (r8 == r5) goto Lc3
            r4.clearSpans()     // Catch: java.lang.Exception -> Lc3
            r2 = 0
        La8:
            if (r2 >= r5) goto Lc3
            r6 = r1[r2]     // Catch: java.lang.Exception -> Lc3
            android.text.style.ForegroundColorSpan r7 = new android.text.style.ForegroundColorSpan     // Catch: java.lang.Exception -> Lc3
            int r8 = r0.f220a     // Catch: java.lang.Exception -> Lc3
            r7.<init>(r8)     // Catch: java.lang.Exception -> Lc3
            r8 = 0
            java.lang.String r9 = B0.a.c(r3, r6, r8, r12)     // Catch: java.lang.Exception -> Lc3
            int r9 = r9.length()     // Catch: java.lang.Exception -> Lc3
            int r9 = r9 + r6
            r4.setSpan(r7, r6, r9, r11)     // Catch: java.lang.Exception -> Lc3
            int r2 = r2 + 1
            goto La8
        Lc3:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: B0.b.b(java.lang.CharSequence, int[]):java.lang.CharSequence");
    }

    public void c(TextView textView, String str, char[] cArr) {
        textView.setText(a(str, cArr));
    }
}
