package j6;

import com.oplus.anim.C0820a;
import com.oplus.anim.parser.moshi.JsonReader;
import f6.C1014a;
import f6.C1015b;

/* compiled from: DropShadowEffectParser.java */
/* renamed from: j6.k, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C1183k {

    /* renamed from: f, reason: collision with root package name */
    public static final JsonReader.a f33923f = JsonReader.a.a("ef");

    /* renamed from: g, reason: collision with root package name */
    public static final JsonReader.a f33924g = JsonReader.a.a("nm", s1.v.f36673e);

    /* renamed from: a, reason: collision with root package name */
    public C1014a f33925a;

    /* renamed from: b, reason: collision with root package name */
    public C1015b f33926b;

    /* renamed from: c, reason: collision with root package name */
    public C1015b f33927c;

    /* renamed from: d, reason: collision with root package name */
    public C1015b f33928d;

    /* renamed from: e, reason: collision with root package name */
    public C1015b f33929e;

    /* JADX WARN: Code restructure failed: missing block: B:46:0x0052, code lost:
    
        if (r0.equals("Opacity") == false) goto L12;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void a(com.oplus.anim.parser.moshi.JsonReader r6, com.oplus.anim.C0820a r7) {
        /*
            r5 = this;
            r6.e()
            java.lang.String r0 = ""
        L5:
            boolean r1 = r6.l()
            if (r1 == 0) goto L90
            com.oplus.anim.parser.moshi.JsonReader$a r1 = j6.C1183k.f33924g
            int r1 = r6.L(r1)
            if (r1 == 0) goto L8a
            r2 = 1
            if (r1 == r2) goto L1d
            r6.O()
            r6.S()
            goto L5
        L1d:
            r0.hashCode()
            int r1 = r0.hashCode()
            r3 = 0
            r4 = -1
            switch(r1) {
                case 353103893: goto L55;
                case 397447147: goto L4c;
                case 1041377119: goto L41;
                case 1379387491: goto L36;
                case 1383710113: goto L2b;
                default: goto L29;
            }
        L29:
            r2 = r4
            goto L5f
        L2b:
            java.lang.String r1 = "Softness"
            boolean r1 = r0.equals(r1)
            if (r1 != 0) goto L34
            goto L29
        L34:
            r2 = 4
            goto L5f
        L36:
            java.lang.String r1 = "Shadow Color"
            boolean r1 = r0.equals(r1)
            if (r1 != 0) goto L3f
            goto L29
        L3f:
            r2 = 3
            goto L5f
        L41:
            java.lang.String r1 = "Direction"
            boolean r1 = r0.equals(r1)
            if (r1 != 0) goto L4a
            goto L29
        L4a:
            r2 = 2
            goto L5f
        L4c:
            java.lang.String r1 = "Opacity"
            boolean r1 = r0.equals(r1)
            if (r1 != 0) goto L5f
            goto L29
        L55:
            java.lang.String r1 = "Distance"
            boolean r1 = r0.equals(r1)
            if (r1 != 0) goto L5e
            goto L29
        L5e:
            r2 = r3
        L5f:
            switch(r2) {
                case 0: goto L82;
                case 1: goto L7b;
                case 2: goto L74;
                case 3: goto L6d;
                case 4: goto L66;
                default: goto L62;
            }
        L62:
            r6.S()
            goto L5
        L66:
            f6.b r1 = j6.C1176d.e(r6, r7)
            r5.f33929e = r1
            goto L5
        L6d:
            f6.a r1 = j6.C1176d.c(r6, r7)
            r5.f33925a = r1
            goto L5
        L74:
            f6.b r1 = j6.C1176d.f(r6, r7, r3)
            r5.f33927c = r1
            goto L5
        L7b:
            f6.b r1 = j6.C1176d.f(r6, r7, r3)
            r5.f33926b = r1
            goto L5
        L82:
            f6.b r1 = j6.C1176d.e(r6, r7)
            r5.f33928d = r1
            goto L5
        L8a:
            java.lang.String r0 = r6.y()
            goto L5
        L90:
            r6.g()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: j6.C1183k.a(com.oplus.anim.parser.moshi.JsonReader, com.oplus.anim.a):void");
    }

    public C1182j b(JsonReader jsonReader, C0820a c0820a) {
        C1015b c1015b;
        C1015b c1015b2;
        C1015b c1015b3;
        C1015b c1015b4;
        while (jsonReader.l()) {
            if (jsonReader.L(f33923f) != 0) {
                jsonReader.O();
                jsonReader.S();
            } else {
                jsonReader.c();
                while (jsonReader.l()) {
                    a(jsonReader, c0820a);
                }
                jsonReader.f();
            }
        }
        C1014a c1014a = this.f33925a;
        if (c1014a != null && (c1015b = this.f33926b) != null && (c1015b2 = this.f33927c) != null && (c1015b3 = this.f33928d) != null && (c1015b4 = this.f33929e) != null) {
            return new C1182j(c1014a, c1015b, c1015b2, c1015b3, c1015b4);
        }
        return null;
    }
}
