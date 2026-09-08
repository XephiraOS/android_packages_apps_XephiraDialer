package x1;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import y1.C1701a;

/* compiled from: ImapTempFileLiteral.java */
/* loaded from: classes.dex */
public class j extends i {

    /* renamed from: i, reason: collision with root package name */
    public final String f37847i = "ImapTempFileLiteral";

    /* renamed from: j, reason: collision with root package name */
    public final File f37848j;

    /* renamed from: k, reason: collision with root package name */
    public final int f37849k;

    public j(com.android.contacts.voicemail.impl.mail.d dVar) {
        this.f37849k = dVar.a();
        File createTempFile = File.createTempFile("imap", ".tmp", com.android.contacts.voicemail.impl.mail.j.a());
        this.f37848j = createTempFile;
        FileOutputStream fileOutputStream = new FileOutputStream(createTempFile);
        I9.a.c(dVar, fileOutputStream);
        fileOutputStream.close();
    }

    @Override // x1.AbstractC1675d
    public void b() {
        try {
            if (!c() && this.f37848j.exists()) {
                this.f37848j.delete();
            }
        } catch (RuntimeException e10) {
            C1.a.f("ImapTempFileLiteral", "Failed to remove temp file: " + e10.getMessage());
        }
        super.b();
    }

    public void finalize() {
        try {
            b();
        } finally {
            super.finalize();
        }
    }

    @Override // x1.i
    public InputStream g() {
        a();
        try {
            return new FileInputStream(this.f37848j);
        } catch (FileNotFoundException unused) {
            C1.a.f("ImapTempFileLiteral", "ImapTempFileLiteral: Temp file not found");
            return new ByteArrayInputStream(new byte[0]);
        }
    }

    @Override // x1.i
    public String k() {
        a();
        try {
            byte[] g10 = I9.a.g(g());
            if (g10.length <= 2097152) {
                return C1701a.d(g10);
            }
            throw new IOException();
        } catch (IOException e10) {
            C1.a.f("ImapTempFileLiteral", "ImapTempFileLiteral: Error while reading temp file " + e10);
            return "";
        }
    }

    public String toString() {
        return String.format("{%d byte literal(file)}", Integer.valueOf(this.f37849k));
    }
}
