package w1;

import android.util.Base64OutputStream;
import com.android.contacts.voicemail.impl.mail.MessagingException;
import com.android.contacts.voicemail.impl.mail.j;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* compiled from: BinaryTempFileBody.java */
/* renamed from: w1.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C1644a implements com.android.contacts.voicemail.impl.mail.a {

    /* renamed from: a, reason: collision with root package name */
    public File f37570a;

    /* compiled from: BinaryTempFileBody.java */
    /* renamed from: w1.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0373a extends FilterInputStream {
        public C0373a(InputStream inputStream) {
            super(inputStream);
        }

        @Override // java.io.FilterInputStream, java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            super.close();
            C1644a.this.f37570a.delete();
        }
    }

    public InputStream b() {
        try {
            return new C0373a(new FileInputStream(this.f37570a));
        } catch (IOException e10) {
            throw new MessagingException("Unable to open body", e10);
        }
    }

    public OutputStream c() {
        File createTempFile = File.createTempFile("body", null, j.a());
        this.f37570a = createTempFile;
        createTempFile.deleteOnExit();
        return new FileOutputStream(this.f37570a);
    }

    @Override // com.android.contacts.voicemail.impl.mail.a
    public void writeTo(OutputStream outputStream) {
        InputStream b10 = b();
        Base64OutputStream base64OutputStream = new Base64OutputStream(outputStream, 20);
        I9.a.c(b10, base64OutputStream);
        base64OutputStream.close();
        this.f37570a.delete();
        b10.close();
    }
}
