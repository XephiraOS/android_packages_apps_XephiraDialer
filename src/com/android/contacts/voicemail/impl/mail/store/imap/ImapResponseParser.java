package com.android.contacts.voicemail.impl.mail.store.imap;

import H7.b;
import android.text.TextUtils;
import com.android.contacts.voicemail.impl.mail.MessagingException;
import com.android.contacts.voicemail.impl.mail.d;
import com.android.contacts.voicemail.impl.mail.i;
import com.android.incallui.OplusPhoneCapabilities;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import x1.AbstractC1675d;
import x1.e;
import x1.f;
import x1.g;
import x1.h;
import x1.j;

/* loaded from: classes.dex */
public class ImapResponseParser {

    /* renamed from: a, reason: collision with root package name */
    public final i f18127a;

    /* renamed from: b, reason: collision with root package name */
    public final int f18128b;

    /* renamed from: c, reason: collision with root package name */
    public final StringBuilder f18129c;

    /* renamed from: d, reason: collision with root package name */
    public final StringBuilder f18130d;

    /* renamed from: e, reason: collision with root package name */
    public final ArrayList<g> f18131e;

    /* loaded from: classes.dex */
    public static class ByeException extends IOException {
        public ByeException() {
            super("Received BYE");
        }
    }

    public ImapResponseParser(InputStream inputStream) {
        this(inputStream, OplusPhoneCapabilities.CAPABILITY_INVITE_PARTICIPANTS);
    }

    public static IOException c() {
        b.b("ImapResponseParser", "End of stream reached");
        return new IOException("End of stream reached");
    }

    public void a() {
        Iterator<g> it = this.f18131e.iterator();
        while (it.hasNext()) {
            it.next().b();
        }
        this.f18131e.clear();
    }

    public void b(char c10) {
        int l10 = l();
        if (c10 == l10) {
        } else {
            throw new IOException(String.format("Expected %04x (%c) but got %04x (%c)", Integer.valueOf(c10), Character.valueOf(c10), Integer.valueOf(l10), Character.valueOf((char) l10)));
        }
    }

    public final void d(Exception exc) {
        for (int i10 = 0; i10 < 4; i10++) {
            try {
                int l10 = l();
                if (l10 == -1 || l10 == 10) {
                    break;
                }
            } catch (IOException unused) {
            }
        }
        b.i("ImapResponseParser", "Exception detected: " + exc);
    }

    public final x1.i e() {
        this.f18130d.setLength(0);
        while (true) {
            int k10 = k();
            if (k10 == 40 || k10 == 41 || k10 == 123 || k10 == 32 || k10 == 93 || k10 == 37 || k10 == 34 || ((k10 >= 0 && k10 <= 31) || k10 == 127)) {
                break;
            }
            if (k10 == 91) {
                this.f18130d.append((char) l());
                this.f18130d.append(n(']'));
                this.f18130d.append(']');
            } else {
                this.f18130d.append((char) l());
            }
        }
        if (this.f18130d.length() != 0) {
            String sb = this.f18130d.toString();
            if ("NIL".equalsIgnoreCase(sb)) {
                return x1.i.f37842g;
            }
            return new h(sb);
        }
        throw new MessagingException("Expected string, none found.");
    }

    public final AbstractC1675d f() {
        int k10 = k();
        if (k10 != 10) {
            if (k10 != 13) {
                if (k10 != 34) {
                    if (k10 != 40) {
                        if (k10 != 91) {
                            if (k10 != 123) {
                                return e();
                            }
                            return i();
                        }
                        return h('[', ']');
                    }
                    return h('(', ')');
                }
                l();
                return new h(n('\"'));
            }
            l();
            b('\n');
            return null;
        }
        l();
        return null;
    }

    public final void g(e eVar, char c10) {
        while (true) {
            int k10 = k();
            if (k10 == c10) {
                return;
            }
            if (k10 != 32) {
                AbstractC1675d f10 = f();
                if (f10 == null) {
                    return;
                } else {
                    eVar.f(f10);
                }
            } else {
                l();
            }
        }
    }

    public final e h(char c10, char c11) {
        b(c10);
        e eVar = new e();
        g(eVar, c11);
        b(c11);
        return eVar;
    }

    public final x1.i i() {
        b('{');
        try {
            int parseInt = Integer.parseInt(n('}'));
            if (parseInt >= 0) {
                b('\r');
                b('\n');
                d dVar = new d(this.f18127a, parseInt);
                if (parseInt > this.f18128b) {
                    return new j(dVar);
                }
                return new f(dVar);
            }
            throw new MessagingException("Invalid negative length in literal");
        } catch (NumberFormatException unused) {
            throw new MessagingException("Invalid length in literal");
        }
    }

    public final g j() {
        String n10;
        g gVar = null;
        try {
            int k10 = k();
            if (k10 == 43) {
                l();
                b(' ');
                g gVar2 = new g(null, true);
                try {
                    gVar2.f(new h(o()));
                    return gVar2;
                } catch (Throwable th) {
                    th = th;
                    gVar = gVar2;
                }
            } else {
                if (k10 == 42) {
                    l();
                    b(' ');
                    n10 = null;
                } else {
                    n10 = n(' ');
                }
                g gVar3 = new g(n10, false);
                try {
                    gVar3.f(e());
                    if (k() == 32) {
                        l();
                        if (gVar3.z()) {
                            if (k() == 91) {
                                gVar3.f(h('[', ']'));
                                if (k() == 32) {
                                    l();
                                }
                            }
                            String o10 = o();
                            if (!TextUtils.isEmpty(o10)) {
                                gVar3.f(new h(o10));
                            }
                        } else {
                            g(gVar3, (char) 0);
                        }
                    } else {
                        b('\r');
                        b('\n');
                    }
                    return gVar3;
                } catch (Throwable th2) {
                    th = th2;
                    gVar = gVar3;
                }
            }
        } catch (Throwable th3) {
            th = th3;
        }
        if (gVar != null) {
            gVar.b();
        }
        throw th;
    }

    public final int k() {
        int a10 = this.f18127a.a();
        if (a10 != -1) {
            return a10;
        }
        throw c();
    }

    public final int l() {
        int read = this.f18127a.read();
        if (read != -1) {
            return read;
        }
        throw c();
    }

    public g m(boolean z10) {
        try {
            g j10 = j();
            if (!z10 && j10.o(0, "BYE")) {
                b.i("ImapResponseParser", "Received BYE");
                j10.b();
                throw new ByeException();
            }
            this.f18131e.add(j10);
            return j10;
        } catch (IOException e10) {
            d(e10);
            throw e10;
        } catch (RuntimeException e11) {
            d(e11);
            throw e11;
        }
    }

    public String n(char c10) {
        this.f18129c.setLength(0);
        while (true) {
            int l10 = l();
            if (l10 != c10) {
                this.f18129c.append((char) l10);
            } else {
                return this.f18129c.toString();
            }
        }
    }

    public String o() {
        String n10 = n('\r');
        b('\n');
        return n10;
    }

    public ImapResponseParser(InputStream inputStream, int i10) {
        this.f18129c = new StringBuilder();
        this.f18130d = new StringBuilder();
        this.f18131e = new ArrayList<>();
        this.f18127a = new i(inputStream);
        this.f18128b = i10;
    }
}
