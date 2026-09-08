package x1;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;

/* compiled from: ImapMemoryLiteral.java */
/* loaded from: classes.dex */
public class f extends i {

    /* renamed from: i, reason: collision with root package name */
    public final String f37835i = "ImapMemoryLiteral";

    /* renamed from: j, reason: collision with root package name */
    public byte[] f37836j;

    public f(com.android.contacts.voicemail.impl.mail.d dVar) {
        int read;
        this.f37836j = new byte[dVar.a()];
        int i10 = 0;
        while (true) {
            byte[] bArr = this.f37836j;
            if (i10 >= bArr.length || (read = dVar.read(bArr, i10, bArr.length - i10)) < 0) {
                break;
            } else {
                i10 += read;
            }
        }
        if (i10 != this.f37836j.length) {
            H7.b.i("ImapMemoryLiteral", "length mismatch");
        }
    }

    @Override // x1.AbstractC1675d
    public void b() {
        this.f37836j = null;
        super.b();
    }

    @Override // x1.i
    public InputStream g() {
        return new ByteArrayInputStream(this.f37836j);
    }

    @Override // x1.i
    public String k() {
        try {
            return new String(this.f37836j, "US-ASCII");
        } catch (UnsupportedEncodingException e10) {
            H7.b.c("ImapMemoryLiteral", "Unsupported encoding: " + e10);
            return null;
        }
    }

    public String toString() {
        return String.format("{%d byte literal(memory)}", Integer.valueOf(this.f37836j.length));
    }
}
