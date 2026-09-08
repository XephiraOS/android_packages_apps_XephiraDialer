package com.android.contacts.framework.vcard;

import com.android.contacts.framework.vcard.exception.VCardException;
import com.android.contacts.framework.vcard.exception.VCardInvalidLineException;
import java.util.Set;

/* compiled from: VCardParserImpl_V30.java */
/* loaded from: classes.dex */
public class o extends n {

    /* renamed from: i, reason: collision with root package name */
    public String f16543i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f16544j;

    public o() {
        this.f16544j = false;
    }

    public static String L(char c10) {
        if (c10 != 'n' && c10 != 'N') {
            return String.valueOf(c10);
        }
        return "\n";
    }

    public static String O(String str) {
        StringBuilder sb = new StringBuilder();
        int length = str.length();
        int i10 = 0;
        while (i10 < length) {
            char charAt = str.charAt(i10);
            if (charAt == '\\' && i10 < length - 1) {
                i10++;
                char charAt2 = str.charAt(i10);
                if (charAt2 != 'n' && charAt2 != 'N') {
                    sb.append(charAt2);
                } else {
                    sb.append("\n");
                }
            } else {
                sb.append(charAt);
            }
            i10++;
        }
        return sb.toString();
    }

    @Override // com.android.contacts.framework.vcard.n
    public String D(String str) {
        return O(str);
    }

    @Override // com.android.contacts.framework.vcard.n
    public String J() {
        String str = this.f16543i;
        if (str != null) {
            return str;
        }
        return this.f16537f.a();
    }

    @Override // com.android.contacts.framework.vcard.n
    public boolean K(boolean z10) {
        return super.K(z10);
    }

    public String M(String str) {
        return VCardUtils.o(str, "ISO-8859-1", "UTF-8");
    }

    public final void N(u uVar, String str, String str2) {
        int length = str2.length();
        StringBuilder sb = null;
        boolean z10 = false;
        for (int i10 = 0; i10 < length; i10++) {
            char charAt = str2.charAt(i10);
            if (charAt == '\"') {
                if (z10 && sb != null) {
                    uVar.b(str, M(sb.toString()));
                    sb = null;
                    z10 = false;
                } else {
                    if (sb != null) {
                        if (sb.length() > 0) {
                            H7.b.i(h.LOG_TAG, "Unexpected Dquote inside property.");
                        } else {
                            uVar.b(str, M(sb.toString()));
                        }
                    }
                    z10 = true;
                }
            } else if (charAt == ',' && !z10) {
                if (sb == null) {
                    H7.b.i(h.LOG_TAG, "Comma is used before actual string comes. (" + str2 + ")");
                } else {
                    uVar.b(str, M(sb.toString()));
                    sb = null;
                }
            } else {
                if (sb == null) {
                    sb = new StringBuilder();
                }
                sb.append(charAt);
            }
        }
        if (z10) {
            H7.b.b(h.LOG_TAG, "Dangling Dquote.");
        }
        if (sb != null) {
            if (sb.length() == 0) {
                H7.b.i(h.LOG_TAG, "Unintended behavior. We must not see empty StringBuilder at the end of parameter value parsing.");
            } else {
                uVar.b(str, M(sb.toString()));
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x002b, code lost:
    
        return r0.toString();
     */
    @Override // com.android.contacts.framework.vcard.n
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.String e(java.lang.String r3) {
        /*
            r2 = this;
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r3)
        L8:
            java.lang.String r3 = r2.i()
            if (r3 == 0) goto L30
            int r1 = r3.length()
            if (r1 != 0) goto L15
            goto L27
        L15:
            java.lang.String r1 = " "
            boolean r1 = r3.startsWith(r1)
            if (r1 != 0) goto L2c
            java.lang.String r1 = "\t"
            boolean r1 = r3.startsWith(r1)
            if (r1 != 0) goto L2c
            r2.f16543i = r3
        L27:
            java.lang.String r2 = r0.toString()
            return r2
        L2c:
            r0.append(r3)
            goto L8
        L30:
            com.android.contacts.framework.vcard.exception.VCardInvalidLineException r2 = new com.android.contacts.framework.vcard.exception.VCardInvalidLineException
            java.lang.String r3 = "File ended during parsing BASE64 binary"
            r2.<init>(r3)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.contacts.framework.vcard.o.e(java.lang.String):java.lang.String");
    }

    @Override // com.android.contacts.framework.vcard.n
    public Set<String> f() {
        return r.f16550b;
    }

    @Override // com.android.contacts.framework.vcard.n
    public String i() {
        String str = this.f16543i;
        if (str != null) {
            this.f16543i = null;
            return str;
        }
        return this.f16537f.readLine();
    }

    @Override // com.android.contacts.framework.vcard.n
    public String j() {
        StringBuilder sb = null;
        while (true) {
            String readLine = this.f16537f.readLine();
            if (readLine == null) {
                if (sb != null) {
                    return sb.toString();
                }
                String str = this.f16543i;
                if (str != null) {
                    this.f16543i = null;
                    return str;
                }
                throw new VCardInvalidLineException("Reached end of buffer.");
            }
            if (readLine.length() == 0) {
                if (sb != null) {
                    return sb.toString();
                }
                String str2 = this.f16543i;
                if (str2 != null) {
                    this.f16543i = null;
                    return str2;
                }
            } else if (readLine.charAt(0) != ' ' && readLine.charAt(0) != '\t') {
                String str3 = this.f16543i;
                if (str3 == null) {
                    this.f16543i = readLine;
                    if (sb != null) {
                        return sb.toString();
                    }
                } else {
                    this.f16543i = readLine;
                    return str3;
                }
            } else if (sb != null) {
                sb.append(readLine.substring(1));
            } else if (this.f16543i != null) {
                sb = new StringBuilder();
                sb.append(this.f16543i);
                this.f16543i = null;
                sb.append(readLine.substring(1));
            } else {
                throw new VCardInvalidLineException("Space exists at the beginning of the line");
            }
        }
    }

    @Override // com.android.contacts.framework.vcard.n
    public int n() {
        return 1;
    }

    @Override // com.android.contacts.framework.vcard.n
    public String o() {
        return "3.0";
    }

    @Override // com.android.contacts.framework.vcard.n
    public void q(u uVar) {
        if (!this.f16544j) {
            H7.b.i(h.LOG_TAG, "AGENT in vCard 3.0 is not supported yet. Ignore it");
            this.f16544j = true;
        }
    }

    @Override // com.android.contacts.framework.vcard.n
    public void r(u uVar, String str, String str2) {
        N(uVar, str, str2);
    }

    @Override // com.android.contacts.framework.vcard.n
    public void w(u uVar, String str) {
        z(uVar, str);
    }

    @Override // com.android.contacts.framework.vcard.n
    public void x(u uVar, String str) {
        try {
            super.x(uVar, str);
        } catch (VCardException unused) {
            String[] split = str.split("=", 2);
            if (split.length == 2) {
                r(uVar, split[0], split[1]);
                return;
            }
            throw new VCardException("Unknown params value: " + str);
        }
    }

    @Override // com.android.contacts.framework.vcard.n
    public void z(u uVar, String str) {
        N(uVar, "TYPE", str);
    }

    public o(int i10) {
        super(i10);
        this.f16544j = false;
    }
}
