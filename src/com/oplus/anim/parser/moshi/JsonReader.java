package com.oplus.anim.parser.moshi;

import G9.b;
import G9.d;
import G9.i;
import java.io.Closeable;
import java.io.IOException;
import java.util.Arrays;
import k6.C1215a;
import okio.ByteString;

/* loaded from: classes3.dex */
public abstract class JsonReader implements Closeable {

    /* renamed from: g, reason: collision with root package name */
    public static final String[] f26127g = new String[128];

    /* renamed from: a, reason: collision with root package name */
    public int f26128a;

    /* renamed from: b, reason: collision with root package name */
    public int[] f26129b = new int[32];

    /* renamed from: c, reason: collision with root package name */
    public String[] f26130c = new String[32];

    /* renamed from: d, reason: collision with root package name */
    public int[] f26131d = new int[32];

    /* renamed from: e, reason: collision with root package name */
    public boolean f26132e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f26133f;

    /* loaded from: classes3.dex */
    public enum Token {
        BEGIN_ARRAY,
        END_ARRAY,
        BEGIN_OBJECT,
        END_OBJECT,
        NAME,
        STRING,
        NUMBER,
        BOOLEAN,
        NULL,
        END_DOCUMENT
    }

    /* loaded from: classes3.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public final String[] f26145a;

        /* renamed from: b, reason: collision with root package name */
        public final i f26146b;

        public a(String[] strArr, i iVar) {
            this.f26145a = strArr;
            this.f26146b = iVar;
        }

        public static a a(String... strArr) {
            try {
                ByteString[] byteStringArr = new ByteString[strArr.length];
                b bVar = new b();
                for (int i10 = 0; i10 < strArr.length; i10++) {
                    JsonReader.T(bVar, strArr[i10]);
                    bVar.readByte();
                    byteStringArr[i10] = bVar.y();
                }
                return new a((String[]) strArr.clone(), i.k(byteStringArr));
            } catch (IOException e10) {
                throw new AssertionError(e10);
            }
        }
    }

    static {
        for (int i10 = 0; i10 <= 31; i10++) {
            f26127g[i10] = String.format("\\u%04x", Integer.valueOf(i10));
        }
        String[] strArr = f26127g;
        strArr[34] = "\\\"";
        strArr[92] = "\\\\";
        strArr[9] = "\\t";
        strArr[8] = "\\b";
        strArr[10] = "\\n";
        strArr[13] = "\\r";
        strArr[12] = "\\f";
    }

    public static JsonReader B(d dVar) {
        return new com.oplus.anim.parser.moshi.a(dVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x002b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void T(G9.c r7, java.lang.String r8) {
        /*
            java.lang.String[] r0 = com.oplus.anim.parser.moshi.JsonReader.f26127g
            r1 = 34
            r7.x(r1)
            int r2 = r8.length()
            r3 = 0
            r4 = r3
        Ld:
            if (r3 >= r2) goto L36
            char r5 = r8.charAt(r3)
            r6 = 128(0x80, float:1.794E-43)
            if (r5 >= r6) goto L1c
            r5 = r0[r5]
            if (r5 != 0) goto L29
            goto L33
        L1c:
            r6 = 8232(0x2028, float:1.1535E-41)
            if (r5 != r6) goto L23
            java.lang.String r5 = "\\u2028"
            goto L29
        L23:
            r6 = 8233(0x2029, float:1.1537E-41)
            if (r5 != r6) goto L33
            java.lang.String r5 = "\\u2029"
        L29:
            if (r4 >= r3) goto L2e
            r7.R(r8, r4, r3)
        L2e:
            r7.K(r5)
            int r4 = r3 + 1
        L33:
            int r3 = r3 + 1
            goto Ld
        L36:
            if (r4 >= r2) goto L3b
            r7.R(r8, r4, r2)
        L3b:
            r7.x(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.anim.parser.moshi.JsonReader.T(G9.c, java.lang.String):void");
    }

    public abstract Token G();

    public final void I(int i10) {
        int i11 = this.f26128a;
        int[] iArr = this.f26129b;
        if (i11 == iArr.length) {
            if (i11 != 256) {
                this.f26129b = Arrays.copyOf(iArr, iArr.length * 2);
                String[] strArr = this.f26130c;
                this.f26130c = (String[]) Arrays.copyOf(strArr, strArr.length * 2);
                int[] iArr2 = this.f26131d;
                this.f26131d = Arrays.copyOf(iArr2, iArr2.length * 2);
            } else {
                throw new JsonDataException("Nesting too deep at " + d());
            }
        }
        int[] iArr3 = this.f26129b;
        int i12 = this.f26128a;
        this.f26128a = i12 + 1;
        iArr3[i12] = i10;
    }

    public abstract int L(a aVar);

    public abstract void O();

    public abstract void S();

    public final JsonEncodingException U(String str) {
        throw new JsonEncodingException(str + " at path " + d());
    }

    public abstract void c();

    public final String d() {
        return C1215a.a(this.f26128a, this.f26129b, this.f26130c, this.f26131d);
    }

    public abstract void e();

    public abstract void f();

    public abstract void g();

    public abstract boolean l();

    public abstract boolean o();

    public abstract double r();

    public abstract int s();

    public abstract String u();

    public abstract String y();
}
