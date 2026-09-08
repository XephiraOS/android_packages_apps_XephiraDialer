package S9;

import java.util.Locale;
import org.apache.james.mime4j.MimeException;

/* compiled from: FallbackBodyDescriptorBuilder.java */
/* loaded from: classes4.dex */
public class h implements c {

    /* renamed from: a, reason: collision with root package name */
    public final String f3623a;

    /* renamed from: b, reason: collision with root package name */
    public final K9.c f3624b;

    /* renamed from: c, reason: collision with root package name */
    public String f3625c;

    /* renamed from: d, reason: collision with root package name */
    public String f3626d;

    /* renamed from: e, reason: collision with root package name */
    public String f3627e;

    /* renamed from: f, reason: collision with root package name */
    public String f3628f;

    /* renamed from: g, reason: collision with root package name */
    public String f3629g;

    /* renamed from: h, reason: collision with root package name */
    public String f3630h;

    /* renamed from: i, reason: collision with root package name */
    public long f3631i;

    public h() {
        this(null, null);
    }

    @Override // S9.c
    public i a(r rVar) {
        String name = rVar.getName();
        Locale locale = Locale.US;
        String lowerCase = name.toLowerCase(locale);
        if (lowerCase.equals("content-transfer-encoding") && this.f3630h == null) {
            String b10 = rVar.b();
            if (b10 != null) {
                String lowerCase2 = b10.trim().toLowerCase(locale);
                if (lowerCase2.length() > 0) {
                    this.f3630h = lowerCase2;
                    return null;
                }
                return null;
            }
            return null;
        }
        if (lowerCase.equals("content-length") && this.f3631i == -1) {
            String b11 = rVar.b();
            if (b11 != null) {
                String trim = b11.trim();
                try {
                    this.f3631i = Long.parseLong(trim.trim());
                    return null;
                } catch (NumberFormatException unused) {
                    if (this.f3624b.b("Invalid content length: " + trim, "ignoring Content-Length header")) {
                        throw new MimeException("Invalid Content-Length header: " + trim);
                    }
                    return null;
                }
            }
            return null;
        }
        if (lowerCase.equals("content-type") && this.f3627e == null) {
            c(rVar);
            return null;
        }
        return null;
    }

    @Override // S9.c
    public c b() {
        return new h(this.f3627e, this.f3624b);
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x003c  */
    @Override // S9.c
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public S9.b build() {
        /*
            r14 = this;
            java.lang.String r0 = r14.f3627e
            java.lang.String r1 = r14.f3625c
            java.lang.String r2 = r14.f3626d
            java.lang.String r3 = r14.f3629g
            java.lang.String r4 = "text"
            if (r0 != 0) goto L1c
            java.lang.String r0 = "multipart/digest"
            java.lang.String r1 = r14.f3623a
            boolean r0 = org.apache.james.mime4j.util.MimeUtil.e(r0, r1)
            if (r0 == 0) goto L20
            java.lang.String r0 = "message/rfc822"
            java.lang.String r1 = "message"
            java.lang.String r2 = "rfc822"
        L1c:
            r6 = r0
            r7 = r1
            r8 = r2
            goto L27
        L20:
            java.lang.String r0 = "text/plain"
            java.lang.String r2 = "plain"
            r6 = r0
            r8 = r2
            r7 = r4
        L27:
            if (r3 != 0) goto L31
            boolean r0 = r4.equals(r7)
            if (r0 == 0) goto L31
            java.lang.String r3 = "us-ascii"
        L31:
            r10 = r3
            S9.a r0 = new S9.a
            java.lang.String r9 = r14.f3628f
            java.lang.String r1 = r14.f3630h
            if (r1 == 0) goto L3c
        L3a:
            r11 = r1
            goto L3f
        L3c:
            java.lang.String r1 = "7bit"
            goto L3a
        L3f:
            long r12 = r14.f3631i
            r5 = r0
            r5.<init>(r6, r7, r8, r9, r10, r11, r12)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: S9.h.build():S9.b");
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x00c5  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00d3  */
    /* JADX WARN: Removed duplicated region for block: B:40:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void c(S9.i r8) {
        /*
            r7 = this;
            boolean r0 = r8 instanceof S9.r
            if (r0 == 0) goto L7
            S9.r r8 = (S9.r) r8
            goto L15
        L7:
            S9.r r0 = new S9.r
            java.lang.String r1 = r8.getName()
            java.lang.String r8 = r8.b()
            r0.<init>(r1, r8)
            r8 = r0
        L15:
            S9.s r0 = S9.s.f3684d
            S9.p r8 = r0.g(r8)
            java.lang.String r0 = r8.b()
            java.util.HashMap r1 = new java.util.HashMap
            r1.<init>()
            java.util.List r8 = r8.a()
            java.util.Iterator r8 = r8.iterator()
        L2c:
            boolean r2 = r8.hasNext()
            if (r2 == 0) goto L4a
            java.lang.Object r2 = r8.next()
            S9.n r2 = (S9.n) r2
            java.lang.String r3 = r2.a()
            java.util.Locale r4 = java.util.Locale.US
            java.lang.String r3 = r3.toLowerCase(r4)
            java.lang.String r2 = r2.b()
            r1.put(r3, r2)
            goto L2c
        L4a:
            r8 = 0
            if (r0 == 0) goto L9b
            java.lang.String r0 = r0.toLowerCase()
            java.lang.String r0 = r0.trim()
            r2 = 47
            int r2 = r0.indexOf(r2)
            r3 = -1
            r4 = 0
            if (r2 == r3) goto L93
            java.lang.String r3 = r0.substring(r4, r2)
            java.lang.String r3 = r3.trim()
            r5 = 1
            int r2 = r2 + r5
            java.lang.String r2 = r0.substring(r2)
            java.lang.String r2 = r2.trim()
            int r6 = r3.length()
            if (r6 <= 0) goto L95
            int r6 = r2.length()
            if (r6 <= 0) goto L95
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r3)
            java.lang.String r4 = "/"
            r0.append(r4)
            r0.append(r2)
            java.lang.String r0 = r0.toString()
            r4 = r5
            goto L95
        L93:
            r2 = r8
            r3 = r2
        L95:
            if (r4 != 0) goto L9d
            r0 = r8
            r2 = r0
        L99:
            r3 = r2
            goto L9d
        L9b:
            r2 = r8
            goto L99
        L9d:
            java.lang.String r4 = "boundary"
            java.lang.Object r4 = r1.get(r4)
            java.lang.String r4 = (java.lang.String) r4
            if (r0 == 0) goto Lbd
            java.lang.String r5 = "multipart/"
            boolean r6 = r0.startsWith(r5)
            if (r6 == 0) goto Lb1
            if (r4 != 0) goto Lb7
        Lb1:
            boolean r5 = r0.startsWith(r5)
            if (r5 != 0) goto Lbd
        Lb7:
            r7.f3627e = r0
            r7.f3625c = r3
            r7.f3626d = r2
        Lbd:
            java.lang.String r0 = r7.f3627e
            boolean r0 = org.apache.james.mime4j.util.MimeUtil.c(r0)
            if (r0 == 0) goto Lc7
            r7.f3628f = r4
        Lc7:
            java.lang.String r0 = "charset"
            java.lang.Object r0 = r1.get(r0)
            java.lang.String r0 = (java.lang.String) r0
            r7.f3629g = r8
            if (r0 == 0) goto Ldf
            java.lang.String r8 = r0.trim()
            int r0 = r8.length()
            if (r0 <= 0) goto Ldf
            r7.f3629g = r8
        Ldf:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: S9.h.c(S9.i):void");
    }

    @Override // S9.c
    public void reset() {
        this.f3627e = null;
        this.f3626d = null;
        this.f3625c = null;
        this.f3628f = null;
        this.f3629g = null;
        this.f3630h = null;
        this.f3631i = -1L;
    }

    public h(String str, K9.c cVar) {
        this.f3623a = str;
        this.f3624b = cVar == null ? K9.c.f1690b : cVar;
        reset();
    }
}
