package x1;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;

/* compiled from: ImapSimpleString.java */
/* loaded from: classes.dex */
public class h extends i {

    /* renamed from: i, reason: collision with root package name */
    public final String f37839i = "ImapSimpleString";

    /* renamed from: j, reason: collision with root package name */
    public String f37840j;

    public h(String str) {
        this.f37840j = str == null ? "" : str;
    }

    @Override // x1.AbstractC1675d
    public void b() {
        this.f37840j = null;
        super.b();
    }

    @Override // x1.i
    public InputStream g() {
        try {
            return new ByteArrayInputStream(this.f37840j.getBytes("US-ASCII"));
        } catch (UnsupportedEncodingException e10) {
            H7.b.c("ImapSimpleString", "Unsupported encoding: " + e10);
            return null;
        }
    }

    @Override // x1.i
    public String k() {
        return this.f37840j;
    }

    public String toString() {
        return "\"" + this.f37840j + "\"";
    }
}
