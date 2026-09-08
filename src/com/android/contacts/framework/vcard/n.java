package com.android.contacts.framework.vcard;

import com.android.contacts.framework.vcard.exception.VCardAgentNotSupportedException;
import com.android.contacts.framework.vcard.exception.VCardException;
import com.android.contacts.framework.vcard.exception.VCardInvalidCommentLineException;
import com.android.contacts.framework.vcard.exception.VCardInvalidLineException;
import com.android.contacts.framework.vcard.exception.VCardVersionException;
import com.customize.contacts.backupandrestore.plugin.ContactBackupPlugin;
import com.oplus.backup.sdk.common.utils.Constants;
import java.io.BufferedReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* compiled from: VCardParserImpl_V21.java */
/* loaded from: classes.dex */
public class n {

    /* renamed from: a, reason: collision with root package name */
    public final String f16532a;

    /* renamed from: b, reason: collision with root package name */
    public final List<l> f16533b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f16534c;

    /* renamed from: d, reason: collision with root package name */
    public String f16535d;

    /* renamed from: e, reason: collision with root package name */
    public String f16536e;

    /* renamed from: f, reason: collision with root package name */
    public a f16537f;

    /* renamed from: g, reason: collision with root package name */
    public final Set<String> f16538g;

    /* renamed from: h, reason: collision with root package name */
    public final Set<String> f16539h;

    /* compiled from: VCardParserImpl_V21.java */
    /* loaded from: classes.dex */
    public static final class a extends BufferedReader {

        /* renamed from: a, reason: collision with root package name */
        public long f16540a;

        /* renamed from: b, reason: collision with root package name */
        public boolean f16541b;

        /* renamed from: c, reason: collision with root package name */
        public String f16542c;

        public a(Reader reader) {
            super(reader);
        }

        public String a() {
            if (!this.f16541b) {
                long currentTimeMillis = System.currentTimeMillis();
                String readLine = super.readLine();
                this.f16540a += System.currentTimeMillis() - currentTimeMillis;
                this.f16542c = readLine;
                this.f16541b = true;
            }
            return this.f16542c;
        }

        @Override // java.io.BufferedReader
        public String readLine() {
            if (this.f16541b) {
                String str = this.f16542c;
                this.f16542c = null;
                this.f16541b = false;
                return str;
            }
            long currentTimeMillis = System.currentTimeMillis();
            String readLine = super.readLine();
            this.f16540a += System.currentTimeMillis() - currentTimeMillis;
            return readLine;
        }
    }

    public n() {
        this(-1073741824);
    }

    public static String L(char c10) {
        if (c10 != '\\' && c10 != ';' && c10 != ':' && c10 != ',') {
            return null;
        }
        return String.valueOf(c10);
    }

    public void A(u uVar, String str) {
        if (!h().contains(str.toUpperCase()) && !str.startsWith("X-") && !this.f16539h.contains(str)) {
            this.f16539h.add(str);
            H7.b.i(h.LOG_TAG, String.format("The value unsupported by TYPE of %s: ", Integer.valueOf(n()), str));
        }
        uVar.b("VALUE", str);
    }

    public final boolean B(char c10) {
        if (c10 < 'a' || c10 > 'z') {
            if (c10 >= 'A' && c10 <= 'Z') {
                return true;
            }
            return false;
        }
        return true;
    }

    public boolean C(String str) {
        if (!f().contains(str.toUpperCase()) && !str.startsWith("X-") && !this.f16538g.contains(str)) {
            this.f16538g.add(str);
            H7.b.i(h.LOG_TAG, "Property name unsupported by vCard 2.1: " + str);
            return true;
        }
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x002b, code lost:
    
        H7.b.e(com.android.contacts.framework.vcard.h.LOG_TAG, "Cancel request has come. exitting parse operation.");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void E(java.io.InputStream r3) {
        /*
            r2 = this;
            if (r3 == 0) goto L57
            java.io.InputStreamReader r0 = new java.io.InputStreamReader
            java.lang.String r1 = r2.f16532a
            r0.<init>(r3, r1)
            com.android.contacts.framework.vcard.n$a r3 = new com.android.contacts.framework.vcard.n$a
            r3.<init>(r0)
            r2.f16537f = r3
            java.util.List<com.android.contacts.framework.vcard.l> r3 = r2.f16533b
            java.util.Iterator r3 = r3.iterator()
        L16:
            boolean r0 = r3.hasNext()
            if (r0 == 0) goto L26
            java.lang.Object r0 = r3.next()
            com.android.contacts.framework.vcard.l r0 = (com.android.contacts.framework.vcard.l) r0
            r0.b()
            goto L16
        L26:
            monitor-enter(r2)
            boolean r3 = r2.f16534c     // Catch: java.lang.Throwable -> L35
            if (r3 == 0) goto L37
            java.lang.String r3 = "vCard"
            java.lang.String r0 = "Cancel request has come. exitting parse operation."
            H7.b.e(r3, r0)     // Catch: java.lang.Throwable -> L35
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L35
            goto L3e
        L35:
            r3 = move-exception
            goto L55
        L37:
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L35
            boolean r3 = r2.I()
            if (r3 != 0) goto L26
        L3e:
            java.util.List<com.android.contacts.framework.vcard.l> r2 = r2.f16533b
            java.util.Iterator r2 = r2.iterator()
        L44:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L54
            java.lang.Object r3 = r2.next()
            com.android.contacts.framework.vcard.l r3 = (com.android.contacts.framework.vcard.l) r3
            r3.c()
            goto L44
        L54:
            return
        L55:
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L35
            throw r3
        L57:
            java.lang.NullPointerException r2 = new java.lang.NullPointerException
            java.lang.String r3 = "InputStream must not be null."
            r2.<init>(r3)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.contacts.framework.vcard.n.E(java.io.InputStream):void");
    }

    public boolean F() {
        this.f16535d = "8BIT";
        u c10 = c(j());
        String upperCase = c10.d().toUpperCase();
        String g10 = c10.g();
        if (upperCase.equals("BEGIN")) {
            if (g10.equalsIgnoreCase("VCARD")) {
                v();
                return false;
            }
            throw new VCardException("Unknown BEGIN type: " + g10);
        }
        if (upperCase.equals("END")) {
            if (g10.equalsIgnoreCase("VCARD")) {
                return true;
            }
            throw new VCardException("Unknown END type: " + g10);
        }
        G(c10, upperCase);
        return false;
    }

    public final void G(u uVar, String str) {
        String g10 = uVar.g();
        if (str.equals("AGENT")) {
            q(uVar);
            return;
        }
        if (C(str)) {
            if (str.equals("VERSION") && !g10.equals(o())) {
                throw new VCardVersionException("Incompatible version: " + g10 + " != " + o());
            }
            y(uVar, str);
            return;
        }
        throw new VCardException("Unknown property name: \"" + str + "\"");
    }

    public void H() {
        boolean z10;
        try {
            z10 = F();
        } catch (VCardInvalidCommentLineException unused) {
            H7.b.c(h.LOG_TAG, "Invalid line which looks like some comment was found. Ignored.");
            z10 = false;
        }
        while (!z10) {
            try {
                z10 = F();
            } catch (VCardInvalidCommentLineException unused2) {
                H7.b.c(h.LOG_TAG, "Invalid line which looks like some comment was found. Ignored.");
            }
        }
    }

    public final boolean I() {
        this.f16535d = "8BIT";
        this.f16536e = "UTF-8";
        try {
        } catch (VCardInvalidLineException e10) {
            H7.b.c("VCardParserImpl_V21", "parseOneVCard error" + e10);
        }
        if (!K(true)) {
            return false;
        }
        Iterator<l> it = this.f16533b.iterator();
        while (it.hasNext()) {
            it.next().e();
        }
        H();
        Iterator<l> it2 = this.f16533b.iterator();
        while (it2.hasNext()) {
            it2.next().a();
        }
        return true;
    }

    public String J() {
        return this.f16537f.a();
    }

    public boolean K(boolean z10) {
        while (true) {
            String i10 = i();
            if (i10 == null) {
                return false;
            }
            if (i10.trim().length() > 0) {
                String[] split = i10.split(":", 2);
                if (split.length == 2 && split[0].trim().equalsIgnoreCase("BEGIN") && split[1].trim().equalsIgnoreCase("VCARD")) {
                    return true;
                }
                if (z10) {
                    if (!z10) {
                        throw new VCardException("Reached where must not be reached.");
                    }
                } else {
                    throw new VCardException("Expected String \"BEGIN:VCARD\" did not come (Instead, \"" + i10 + "\" came)");
                }
            }
        }
    }

    public void a(l lVar) {
        this.f16533b.add(lVar);
    }

    public final synchronized void b() {
        H7.b.e(h.LOG_TAG, "ParserImpl received cancel operation.");
        this.f16534c = true;
    }

    public u c(String str) {
        u uVar = new u();
        int length = str.length();
        if (length > 0 && str.charAt(0) == '#') {
            throw new VCardInvalidCommentLineException();
        }
        char c10 = 0;
        int i10 = 0;
        for (int i11 = 0; i11 < length; i11++) {
            char charAt = str.charAt(i11);
            String str2 = "";
            if (c10 != 0) {
                if (c10 != 1) {
                    if (c10 == 2 && charAt == '\"') {
                        if ("2.1".equalsIgnoreCase(o())) {
                            H7.b.i(h.LOG_TAG, "Double-quoted params found in vCard 2.1. Silently allow it");
                        }
                        c10 = 1;
                    }
                } else if (charAt == '\"') {
                    if ("2.1".equalsIgnoreCase(o())) {
                        H7.b.i(h.LOG_TAG, "Double-quoted params found in vCard 2.1. Silently allow it");
                    }
                    c10 = 2;
                } else if (charAt == ';') {
                    x(uVar, str.substring(i10, i11));
                    i10 = i11 + 1;
                } else if (charAt == ':') {
                    x(uVar, str.substring(i10, i11));
                    if (i11 < length - 1) {
                        str2 = str.substring(i11 + 1);
                    }
                    uVar.k(str2);
                    return uVar;
                }
            } else {
                if (charAt == ':') {
                    uVar.j(str.substring(i10, i11));
                    if (i11 < length - 1) {
                        str2 = str.substring(i11 + 1);
                    }
                    uVar.k(str2);
                    return uVar;
                }
                if (charAt == '.') {
                    String substring = str.substring(i10, i11);
                    if (substring.length() == 0) {
                        H7.b.i(h.LOG_TAG, "Empty group found. Ignoring.");
                    } else {
                        uVar.a(substring);
                    }
                    i10 = i11 + 1;
                } else if (charAt == ';') {
                    uVar.j(str.substring(i10, i11));
                    i10 = i11 + 1;
                    c10 = 1;
                }
            }
        }
        throw new VCardInvalidLineException("Invalid line: \"" + str + "\"");
    }

    public Set<String> d() {
        return q.f16548e;
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x005b, code lost:
    
        return r0.toString();
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0037, code lost:
    
        H7.b.i(com.android.contacts.framework.vcard.h.LOG_TAG, "Found a next property during parsing a BASE64 string, which must not contain semi-colon or colon. Treat the line as next property.");
        H7.b.i(com.android.contacts.framework.vcard.h.LOG_TAG, "Problematic line: " + r4.trim());
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.String e(java.lang.String r4) {
        /*
            r3 = this;
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r4)
        L8:
            java.lang.String r4 = r3.J()
            if (r4 == 0) goto L5c
            java.lang.String r1 = r3.l(r4)
            java.util.Set r2 = r3.f()
            boolean r2 = r2.contains(r1)
            if (r2 != 0) goto L37
            java.lang.String r2 = "X-ANDROID-CUSTOM"
            boolean r1 = r2.equals(r1)
            if (r1 == 0) goto L25
            goto L37
        L25:
            r3.i()
            int r1 = r4.length()
            if (r1 != 0) goto L2f
            goto L57
        L2f:
            java.lang.String r4 = r4.trim()
            r0.append(r4)
            goto L8
        L37:
            java.lang.String r3 = "Found a next property during parsing a BASE64 string, which must not contain semi-colon or colon. Treat the line as next property."
            java.lang.String r1 = "vCard"
            H7.b.i(r1, r3)
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r2 = "Problematic line: "
            r3.append(r2)
            java.lang.String r4 = r4.trim()
            r3.append(r4)
            java.lang.String r3 = r3.toString()
            H7.b.i(r1, r3)
        L57:
            java.lang.String r3 = r0.toString()
            return r3
        L5c:
            com.android.contacts.framework.vcard.exception.VCardInvalidLineException r3 = new com.android.contacts.framework.vcard.exception.VCardInvalidLineException
            java.lang.String r4 = "File ended during parsing BASE64 binary"
            r3.<init>(r4)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.contacts.framework.vcard.n.e(java.lang.String):java.lang.String");
    }

    public Set<String> f() {
        return q.f16545b;
    }

    public Set<String> g() {
        return q.f16546c;
    }

    public Set<String> h() {
        return q.f16547d;
    }

    public String i() {
        return this.f16537f.readLine();
    }

    public String j() {
        String i10;
        do {
            i10 = i();
            if (i10 == null) {
                throw new VCardInvalidLineException("Reached end of buffer.");
            }
        } while (i10.trim().length() <= 0);
        return i10;
    }

    public final String k(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        while (true) {
            String J10 = J();
            if (J10 == null || J10.length() == 0 || l(J10) != null) {
                break;
            }
            i();
            sb.append(" ");
            sb.append(J10);
        }
        return sb.toString();
    }

    public final String l(String str) {
        int indexOf = str.indexOf(":");
        if (indexOf > -1) {
            int indexOf2 = str.indexOf(Constants.DataMigration.SPLIT_TAG);
            if (indexOf2 != -1) {
                indexOf = Math.min(indexOf, indexOf2);
            }
            return str.substring(0, indexOf).toUpperCase();
        }
        return null;
    }

    public final String m(String str) {
        if (str.trim().endsWith("=")) {
            int length = str.length();
            do {
            } while (str.charAt(length - 1) != '=');
            StringBuilder sb = new StringBuilder();
            sb.append(str.substring(0, length));
            sb.append(ContactBackupPlugin.END_OF_LINE);
            while (true) {
                String i10 = i();
                if (i10 != null) {
                    if (i10.trim().endsWith("=")) {
                        int length2 = i10.length();
                        do {
                        } while (i10.charAt(length2 - 1) != '=');
                        sb.append(i10.substring(0, length2));
                        sb.append(ContactBackupPlugin.END_OF_LINE);
                    } else {
                        sb.append(i10);
                        return sb.toString();
                    }
                } else {
                    throw new VCardException("File ended during parsing a Quoted-Printable String");
                }
            }
        } else {
            return str;
        }
    }

    public int n() {
        return 0;
    }

    public String o() {
        return "2.1";
    }

    public final void p(u uVar, String str, String str2, String str3) {
        ArrayList arrayList = new ArrayList();
        if (this.f16535d.equals("QUOTED-PRINTABLE")) {
            String m10 = m(str);
            uVar.k(m10);
            Iterator<String> it = VCardUtils.c(m10, n()).iterator();
            while (it.hasNext()) {
                arrayList.add(VCardUtils.z(it.next(), false, str2, str3));
            }
        } else {
            Iterator<String> it2 = VCardUtils.c(k(str), n()).iterator();
            while (it2.hasNext()) {
                arrayList.add(VCardUtils.o(it2.next(), str2, str3));
            }
        }
        uVar.l(arrayList);
        Iterator<l> it3 = this.f16533b.iterator();
        while (it3.hasNext()) {
            it3.next().d(uVar);
        }
    }

    public void q(u uVar) {
        if (!uVar.g().toUpperCase().contains("BEGIN:VCARD")) {
            Iterator<l> it = this.f16533b.iterator();
            while (it.hasNext()) {
                it.next().d(uVar);
            }
            return;
        }
        throw new VCardAgentNotSupportedException("AGENT Property is not supported now.");
    }

    public void r(u uVar, String str, String str2) {
        uVar.b(str, str2);
    }

    public void s(u uVar, String str) {
        this.f16536e = str;
        uVar.b("CHARSET", str);
    }

    public void t(u uVar, String str) {
        if (!d().contains(str) && !str.startsWith("X-")) {
            throw new VCardException("Unknown encoding \"" + str + "\"");
        }
        uVar.b("ENCODING", str);
        this.f16535d = str.toUpperCase();
    }

    public void u(u uVar, String str) {
        String[] split = str.split("-");
        if (split.length == 2) {
            String str2 = split[0];
            int length = str2.length();
            for (int i10 = 0; i10 < length; i10++) {
                if (!B(str2.charAt(i10))) {
                    throw new VCardException("Invalid Language: \"" + str + "\"");
                }
            }
            String str3 = split[1];
            int length2 = str3.length();
            for (int i11 = 0; i11 < length2; i11++) {
                if (!B(str3.charAt(i11))) {
                    throw new VCardException("Invalid Language: \"" + str + "\"");
                }
            }
            uVar.b("LANGUAGE", str);
            return;
        }
        throw new VCardException("Invalid Language: \"" + str + "\"");
    }

    public final void v() {
        Iterator<l> it = this.f16533b.iterator();
        while (it.hasNext()) {
            it.next().e();
        }
        H();
        Iterator<l> it2 = this.f16533b.iterator();
        while (it2.hasNext()) {
            it2.next().a();
        }
    }

    public void w(u uVar, String str) {
        z(uVar, str);
    }

    public void x(u uVar, String str) {
        String[] split = str.split("=", 2);
        if (split.length == 2) {
            String upperCase = split[0].trim().toUpperCase();
            String trim = split[1].trim();
            if (upperCase.equals("TYPE")) {
                z(uVar, trim);
                return;
            }
            if (upperCase.equals("VALUE")) {
                A(uVar, trim);
                return;
            }
            if (upperCase.equals("ENCODING")) {
                t(uVar, trim.toUpperCase());
                return;
            }
            if (upperCase.equals("CHARSET")) {
                s(uVar, trim);
                return;
            }
            if (upperCase.equals("LANGUAGE")) {
                u(uVar, trim);
                return;
            }
            if (upperCase.startsWith("X-")) {
                r(uVar, upperCase, trim);
                return;
            }
            if (upperCase.equals("CALSCALE")) {
                r(uVar, upperCase, trim);
                return;
            }
            throw new VCardException("Unknown type \"" + upperCase + "\"");
        }
        w(uVar, split[0]);
    }

    /* JADX WARN: Code restructure failed: missing block: B:48:0x00ee, code lost:
    
        r0 = r2.toString();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void y(com.android.contacts.framework.vcard.u r8, java.lang.String r9) {
        /*
            Method dump skipped, instructions count: 412
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.contacts.framework.vcard.n.y(com.android.contacts.framework.vcard.u, java.lang.String):void");
    }

    public void z(u uVar, String str) {
        if (!g().contains(str.toUpperCase()) && !str.startsWith("X-") && !this.f16538g.contains(str)) {
            this.f16538g.add(str);
            H7.b.i(h.LOG_TAG, String.format("TYPE unsupported by %s: ", Integer.valueOf(n()), str));
        }
        uVar.b("TYPE", str);
    }

    public n(int i10) {
        this.f16533b = new ArrayList();
        this.f16538g = new HashSet();
        this.f16539h = new HashSet();
        this.f16532a = "ISO-8859-1";
    }

    public String D(String str) {
        return str;
    }
}
