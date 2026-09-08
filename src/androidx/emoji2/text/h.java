package androidx.emoji2.text;

import android.text.Editable;
import android.text.Selection;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.method.MetaKeyKeyListener;
import android.view.KeyEvent;
import android.view.inputmethod.InputConnection;
import androidx.emoji2.text.e;
import androidx.emoji2.text.m;
import java.util.Arrays;
import java.util.Set;

/* compiled from: EmojiProcessor.java */
/* loaded from: classes.dex */
public final class h {

    /* renamed from: a, reason: collision with root package name */
    public final e.j f9788a;

    /* renamed from: b, reason: collision with root package name */
    public final m f9789b;

    /* renamed from: c, reason: collision with root package name */
    public e.InterfaceC0121e f9790c;

    /* renamed from: d, reason: collision with root package name */
    public final boolean f9791d;

    /* renamed from: e, reason: collision with root package name */
    public final int[] f9792e;

    /* compiled from: EmojiProcessor.java */
    /* loaded from: classes.dex */
    public static final class a {
        public static int a(CharSequence charSequence, int i10, int i11) {
            int length = charSequence.length();
            if (i10 < 0 || length < i10 || i11 < 0) {
                return -1;
            }
            while (true) {
                boolean z10 = false;
                while (i11 != 0) {
                    i10--;
                    if (i10 < 0) {
                        if (z10) {
                            return -1;
                        }
                        return 0;
                    }
                    char charAt = charSequence.charAt(i10);
                    if (z10) {
                        if (!Character.isHighSurrogate(charAt)) {
                            return -1;
                        }
                        i11--;
                    } else if (!Character.isSurrogate(charAt)) {
                        i11--;
                    } else {
                        if (Character.isHighSurrogate(charAt)) {
                            return -1;
                        }
                        z10 = true;
                    }
                }
                return i10;
            }
        }

        public static int b(CharSequence charSequence, int i10, int i11) {
            int length = charSequence.length();
            if (i10 < 0 || length < i10 || i11 < 0) {
                return -1;
            }
            while (true) {
                boolean z10 = false;
                while (i11 != 0) {
                    if (i10 >= length) {
                        if (z10) {
                            return -1;
                        }
                        return length;
                    }
                    char charAt = charSequence.charAt(i10);
                    if (z10) {
                        if (!Character.isLowSurrogate(charAt)) {
                            return -1;
                        }
                        i11--;
                        i10++;
                    } else if (!Character.isSurrogate(charAt)) {
                        i11--;
                        i10++;
                    } else {
                        if (Character.isLowSurrogate(charAt)) {
                            return -1;
                        }
                        i10++;
                        z10 = true;
                    }
                }
                return i10;
            }
        }
    }

    /* compiled from: EmojiProcessor.java */
    /* loaded from: classes.dex */
    public static class b implements c<q> {

        /* renamed from: a, reason: collision with root package name */
        public q f9793a;

        /* renamed from: b, reason: collision with root package name */
        public final e.j f9794b;

        public b(q qVar, e.j jVar) {
            this.f9793a = qVar;
            this.f9794b = jVar;
        }

        @Override // androidx.emoji2.text.h.c
        public boolean a(CharSequence charSequence, int i10, int i11, o oVar) {
            Spannable spannableString;
            if (oVar.k()) {
                return true;
            }
            if (this.f9793a == null) {
                if (charSequence instanceof Spannable) {
                    spannableString = (Spannable) charSequence;
                } else {
                    spannableString = new SpannableString(charSequence);
                }
                this.f9793a = new q(spannableString);
            }
            this.f9793a.setSpan(this.f9794b.a(oVar), i10, i11, 33);
            return true;
        }

        @Override // androidx.emoji2.text.h.c
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public q getResult() {
            return this.f9793a;
        }
    }

    /* compiled from: EmojiProcessor.java */
    /* loaded from: classes.dex */
    public interface c<T> {
        boolean a(CharSequence charSequence, int i10, int i11, o oVar);

        T getResult();
    }

    /* compiled from: EmojiProcessor.java */
    /* loaded from: classes.dex */
    public static final class e {

        /* renamed from: a, reason: collision with root package name */
        public int f9796a = 1;

        /* renamed from: b, reason: collision with root package name */
        public final m.a f9797b;

        /* renamed from: c, reason: collision with root package name */
        public m.a f9798c;

        /* renamed from: d, reason: collision with root package name */
        public m.a f9799d;

        /* renamed from: e, reason: collision with root package name */
        public int f9800e;

        /* renamed from: f, reason: collision with root package name */
        public int f9801f;

        /* renamed from: g, reason: collision with root package name */
        public final boolean f9802g;

        /* renamed from: h, reason: collision with root package name */
        public final int[] f9803h;

        public e(m.a aVar, boolean z10, int[] iArr) {
            this.f9797b = aVar;
            this.f9798c = aVar;
            this.f9802g = z10;
            this.f9803h = iArr;
        }

        public static boolean d(int i10) {
            if (i10 == 65039) {
                return true;
            }
            return false;
        }

        public static boolean f(int i10) {
            if (i10 == 65038) {
                return true;
            }
            return false;
        }

        public int a(int i10) {
            m.a a10 = this.f9798c.a(i10);
            int i11 = 2;
            if (this.f9796a != 2) {
                if (a10 == null) {
                    i11 = g();
                } else {
                    this.f9796a = 2;
                    this.f9798c = a10;
                    this.f9801f = 1;
                }
            } else if (a10 != null) {
                this.f9798c = a10;
                this.f9801f++;
            } else if (f(i10)) {
                i11 = g();
            } else if (!d(i10)) {
                if (this.f9798c.b() != null) {
                    i11 = 3;
                    if (this.f9801f == 1) {
                        if (h()) {
                            this.f9799d = this.f9798c;
                            g();
                        } else {
                            i11 = g();
                        }
                    } else {
                        this.f9799d = this.f9798c;
                        g();
                    }
                } else {
                    i11 = g();
                }
            }
            this.f9800e = i10;
            return i11;
        }

        public o b() {
            return this.f9798c.b();
        }

        public o c() {
            return this.f9799d.b();
        }

        public boolean e() {
            if (this.f9796a == 2 && this.f9798c.b() != null && (this.f9801f > 1 || h())) {
                return true;
            }
            return false;
        }

        public final int g() {
            this.f9796a = 1;
            this.f9798c = this.f9797b;
            this.f9801f = 0;
            return 1;
        }

        public final boolean h() {
            if (this.f9798c.b().j() || d(this.f9800e)) {
                return true;
            }
            if (this.f9802g) {
                if (this.f9803h == null) {
                    return true;
                }
                if (Arrays.binarySearch(this.f9803h, this.f9798c.b().b(0)) < 0) {
                    return true;
                }
            }
            return false;
        }
    }

    public h(m mVar, e.j jVar, e.InterfaceC0121e interfaceC0121e, boolean z10, int[] iArr, Set<int[]> set) {
        this.f9788a = jVar;
        this.f9789b = mVar;
        this.f9790c = interfaceC0121e;
        this.f9791d = z10;
        this.f9792e = iArr;
        g(set);
    }

    public static boolean a(Editable editable, KeyEvent keyEvent, boolean z10) {
        i[] iVarArr;
        if (f(keyEvent)) {
            return false;
        }
        int selectionStart = Selection.getSelectionStart(editable);
        int selectionEnd = Selection.getSelectionEnd(editable);
        if (!e(selectionStart, selectionEnd) && (iVarArr = (i[]) editable.getSpans(selectionStart, selectionEnd, i.class)) != null && iVarArr.length > 0) {
            for (i iVar : iVarArr) {
                int spanStart = editable.getSpanStart(iVar);
                int spanEnd = editable.getSpanEnd(iVar);
                if ((z10 && spanStart == selectionStart) || ((!z10 && spanEnd == selectionStart) || (selectionStart > spanStart && selectionStart < spanEnd))) {
                    editable.delete(spanStart, spanEnd);
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean b(InputConnection inputConnection, Editable editable, int i10, int i11, boolean z10) {
        int max;
        int min;
        if (editable != null && inputConnection != null && i10 >= 0 && i11 >= 0) {
            int selectionStart = Selection.getSelectionStart(editable);
            int selectionEnd = Selection.getSelectionEnd(editable);
            if (e(selectionStart, selectionEnd)) {
                return false;
            }
            if (z10) {
                max = a.a(editable, selectionStart, Math.max(i10, 0));
                min = a.b(editable, selectionEnd, Math.max(i11, 0));
                if (max == -1 || min == -1) {
                    return false;
                }
            } else {
                max = Math.max(selectionStart - i10, 0);
                min = Math.min(selectionEnd + i11, editable.length());
            }
            i[] iVarArr = (i[]) editable.getSpans(max, min, i.class);
            if (iVarArr != null && iVarArr.length > 0) {
                for (i iVar : iVarArr) {
                    int spanStart = editable.getSpanStart(iVar);
                    int spanEnd = editable.getSpanEnd(iVar);
                    max = Math.min(spanStart, max);
                    min = Math.max(spanEnd, min);
                }
                int max2 = Math.max(max, 0);
                int min2 = Math.min(min, editable.length());
                inputConnection.beginBatchEdit();
                editable.delete(max2, min2);
                inputConnection.endBatchEdit();
                return true;
            }
        }
        return false;
    }

    public static boolean c(Editable editable, int i10, KeyEvent keyEvent) {
        boolean a10;
        if (i10 != 67) {
            if (i10 == 112) {
                a10 = a(editable, keyEvent, true);
            }
            return false;
        }
        a10 = a(editable, keyEvent, false);
        if (a10) {
            MetaKeyKeyListener.adjustMetaAfterKeypress(editable);
            return true;
        }
        return false;
    }

    public static boolean e(int i10, int i11) {
        if (i10 != -1 && i11 != -1 && i10 == i11) {
            return false;
        }
        return true;
    }

    public static boolean f(KeyEvent keyEvent) {
        return !KeyEvent.metaStateHasNoModifiers(keyEvent.getMetaState());
    }

    public final boolean d(CharSequence charSequence, int i10, int i11, o oVar) {
        if (oVar.d() == 0) {
            oVar.m(this.f9790c.a(charSequence, i10, i11, oVar.h()));
        }
        if (oVar.d() == 2) {
            return true;
        }
        return false;
    }

    public final void g(Set<int[]> set) {
        if (set.isEmpty()) {
            return;
        }
        for (int[] iArr : set) {
            String str = new String(iArr, 0, iArr.length);
            i(str, 0, str.length(), 1, true, new d(str));
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0049 A[Catch: all -> 0x002a, TryCatch #0 {all -> 0x002a, blocks: (B:51:0x000e, B:54:0x0013, B:56:0x0017, B:58:0x0024, B:9:0x003a, B:11:0x0042, B:13:0x0045, B:15:0x0049, B:17:0x0055, B:19:0x0058, B:24:0x0066, B:30:0x0074, B:31:0x0080, B:33:0x0094, B:6:0x002f), top: B:50:0x000e }] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0094 A[Catch: all -> 0x002a, TRY_LEAVE, TryCatch #0 {all -> 0x002a, blocks: (B:51:0x000e, B:54:0x0013, B:56:0x0017, B:58:0x0024, B:9:0x003a, B:11:0x0042, B:13:0x0045, B:15:0x0049, B:17:0x0055, B:19:0x0058, B:24:0x0066, B:30:0x0074, B:31:0x0080, B:33:0x0094, B:6:0x002f), top: B:50:0x000e }] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00a0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.CharSequence h(java.lang.CharSequence r11, int r12, int r13, int r14, boolean r15) {
        /*
            r10 = this;
            boolean r0 = r11 instanceof androidx.emoji2.text.n
            if (r0 == 0) goto La
            r1 = r11
            androidx.emoji2.text.n r1 = (androidx.emoji2.text.n) r1
            r1.a()
        La:
            java.lang.Class<androidx.emoji2.text.i> r1 = androidx.emoji2.text.i.class
            if (r0 != 0) goto L2f
            boolean r2 = r11 instanceof android.text.Spannable     // Catch: java.lang.Throwable -> L2a
            if (r2 == 0) goto L13
            goto L2f
        L13:
            boolean r2 = r11 instanceof android.text.Spanned     // Catch: java.lang.Throwable -> L2a
            if (r2 == 0) goto L2d
            r2 = r11
            android.text.Spanned r2 = (android.text.Spanned) r2     // Catch: java.lang.Throwable -> L2a
            int r3 = r12 + (-1)
            int r4 = r13 + 1
            int r2 = r2.nextSpanTransition(r3, r4, r1)     // Catch: java.lang.Throwable -> L2a
            if (r2 > r13) goto L2d
            androidx.emoji2.text.q r2 = new androidx.emoji2.text.q     // Catch: java.lang.Throwable -> L2a
            r2.<init>(r11)     // Catch: java.lang.Throwable -> L2a
            goto L37
        L2a:
            r10 = move-exception
            goto Lb2
        L2d:
            r2 = 0
            goto L37
        L2f:
            androidx.emoji2.text.q r2 = new androidx.emoji2.text.q     // Catch: java.lang.Throwable -> L2a
            r3 = r11
            android.text.Spannable r3 = (android.text.Spannable) r3     // Catch: java.lang.Throwable -> L2a
            r2.<init>(r3)     // Catch: java.lang.Throwable -> L2a
        L37:
            r3 = 0
            if (r2 == 0) goto L63
            java.lang.Object[] r4 = r2.getSpans(r12, r13, r1)     // Catch: java.lang.Throwable -> L2a
            androidx.emoji2.text.i[] r4 = (androidx.emoji2.text.i[]) r4     // Catch: java.lang.Throwable -> L2a
            if (r4 == 0) goto L63
            int r5 = r4.length     // Catch: java.lang.Throwable -> L2a
            if (r5 <= 0) goto L63
            int r5 = r4.length     // Catch: java.lang.Throwable -> L2a
            r6 = r3
        L47:
            if (r6 >= r5) goto L63
            r7 = r4[r6]     // Catch: java.lang.Throwable -> L2a
            int r8 = r2.getSpanStart(r7)     // Catch: java.lang.Throwable -> L2a
            int r9 = r2.getSpanEnd(r7)     // Catch: java.lang.Throwable -> L2a
            if (r8 == r13) goto L58
            r2.removeSpan(r7)     // Catch: java.lang.Throwable -> L2a
        L58:
            int r12 = java.lang.Math.min(r8, r12)     // Catch: java.lang.Throwable -> L2a
            int r13 = java.lang.Math.max(r9, r13)     // Catch: java.lang.Throwable -> L2a
            int r6 = r6 + 1
            goto L47
        L63:
            r4 = r13
            if (r12 == r4) goto La9
            int r13 = r11.length()     // Catch: java.lang.Throwable -> L2a
            if (r12 < r13) goto L6d
            goto La9
        L6d:
            r13 = 2147483647(0x7fffffff, float:NaN)
            if (r14 == r13) goto L80
            if (r2 == 0) goto L80
            int r13 = r2.length()     // Catch: java.lang.Throwable -> L2a
            java.lang.Object[] r13 = r2.getSpans(r3, r13, r1)     // Catch: java.lang.Throwable -> L2a
            androidx.emoji2.text.i[] r13 = (androidx.emoji2.text.i[]) r13     // Catch: java.lang.Throwable -> L2a
            int r13 = r13.length     // Catch: java.lang.Throwable -> L2a
            int r14 = r14 - r13
        L80:
            r5 = r14
            androidx.emoji2.text.h$b r7 = new androidx.emoji2.text.h$b     // Catch: java.lang.Throwable -> L2a
            androidx.emoji2.text.e$j r13 = r10.f9788a     // Catch: java.lang.Throwable -> L2a
            r7.<init>(r2, r13)     // Catch: java.lang.Throwable -> L2a
            r1 = r10
            r2 = r11
            r3 = r12
            r6 = r15
            java.lang.Object r10 = r1.i(r2, r3, r4, r5, r6, r7)     // Catch: java.lang.Throwable -> L2a
            androidx.emoji2.text.q r10 = (androidx.emoji2.text.q) r10     // Catch: java.lang.Throwable -> L2a
            if (r10 == 0) goto La0
            android.text.Spannable r10 = r10.b()     // Catch: java.lang.Throwable -> L2a
            if (r0 == 0) goto L9f
            androidx.emoji2.text.n r11 = (androidx.emoji2.text.n) r11
            r11.d()
        L9f:
            return r10
        La0:
            if (r0 == 0) goto La8
            r10 = r11
            androidx.emoji2.text.n r10 = (androidx.emoji2.text.n) r10
            r10.d()
        La8:
            return r11
        La9:
            if (r0 == 0) goto Lb1
            r10 = r11
            androidx.emoji2.text.n r10 = (androidx.emoji2.text.n) r10
            r10.d()
        Lb1:
            return r11
        Lb2:
            if (r0 == 0) goto Lb9
            androidx.emoji2.text.n r11 = (androidx.emoji2.text.n) r11
            r11.d()
        Lb9:
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.emoji2.text.h.h(java.lang.CharSequence, int, int, int, boolean):java.lang.CharSequence");
    }

    public final <T> T i(CharSequence charSequence, int i10, int i11, int i12, boolean z10, c<T> cVar) {
        int i13;
        e eVar = new e(this.f9789b.f(), this.f9791d, this.f9792e);
        int i14 = 0;
        boolean z11 = true;
        int codePointAt = Character.codePointAt(charSequence, i10);
        loop0: while (true) {
            i13 = i10;
            while (i10 < i11 && i14 < i12 && z11) {
                int a10 = eVar.a(codePointAt);
                if (a10 != 1) {
                    if (a10 != 2) {
                        if (a10 == 3) {
                            if (z10 || !d(charSequence, i13, i10, eVar.c())) {
                                z11 = cVar.a(charSequence, i13, i10, eVar.c());
                                i14++;
                            }
                        }
                    } else {
                        i10 += Character.charCount(codePointAt);
                        if (i10 < i11) {
                            codePointAt = Character.codePointAt(charSequence, i10);
                        }
                    }
                } else {
                    i13 += Character.charCount(Character.codePointAt(charSequence, i13));
                    if (i13 < i11) {
                        codePointAt = Character.codePointAt(charSequence, i13);
                    }
                    i10 = i13;
                }
            }
        }
        if (eVar.e() && i14 < i12 && z11 && (z10 || !d(charSequence, i13, i10, eVar.b()))) {
            cVar.a(charSequence, i13, i10, eVar.b());
        }
        return cVar.getResult();
    }

    /* compiled from: EmojiProcessor.java */
    /* loaded from: classes.dex */
    public static class d implements c<d> {

        /* renamed from: a, reason: collision with root package name */
        public final String f9795a;

        public d(String str) {
            this.f9795a = str;
        }

        @Override // androidx.emoji2.text.h.c
        public boolean a(CharSequence charSequence, int i10, int i11, o oVar) {
            if (!TextUtils.equals(charSequence.subSequence(i10, i11), this.f9795a)) {
                return true;
            }
            oVar.l(true);
            return false;
        }

        @Override // androidx.emoji2.text.h.c
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public d getResult() {
            return this;
        }
    }
}
