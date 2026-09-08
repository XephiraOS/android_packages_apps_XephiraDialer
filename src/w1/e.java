package w1;

import com.android.contacts.voicemail.impl.mail.MessagingException;
import com.android.contacts.voicemail.impl.mail.g;
import com.customize.contacts.backupandrestore.plugin.ContactBackupPlugin;
import java.io.BufferedWriter;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

/* compiled from: MimeMultipart.java */
/* loaded from: classes.dex */
public class e extends g {

    /* renamed from: d, reason: collision with root package name */
    public String f37597d;

    /* renamed from: e, reason: collision with root package name */
    public String f37598e;

    /* renamed from: f, reason: collision with root package name */
    public String f37599f;

    /* renamed from: g, reason: collision with root package name */
    public String f37600g;

    public e() {
        this.f37599f = f();
        h("mixed");
    }

    @Override // com.android.contacts.voicemail.impl.mail.g
    public String c() {
        return this.f37598e;
    }

    public String f() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("----");
        for (int i10 = 0; i10 < 30; i10++) {
            stringBuffer.append(Integer.toString((int) (Math.random() * 35.0d), 36));
        }
        return stringBuffer.toString().toUpperCase();
    }

    public void g(String str) {
        this.f37597d = str;
    }

    public void h(String str) {
        this.f37600g = str;
        this.f37598e = String.format("multipart/%s; boundary=\"%s\"", str, this.f37599f);
    }

    @Override // com.android.contacts.voicemail.impl.mail.a
    public void writeTo(OutputStream outputStream) {
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream), 1024);
        if (this.f37597d != null) {
            bufferedWriter.write(this.f37597d + ContactBackupPlugin.END_OF_LINE);
        }
        int size = this.f18097b.size();
        for (int i10 = 0; i10 < size; i10++) {
            com.android.contacts.voicemail.impl.mail.b bVar = this.f18097b.get(i10);
            bufferedWriter.write("--" + this.f37599f + ContactBackupPlugin.END_OF_LINE);
            bufferedWriter.flush();
            bVar.writeTo(outputStream);
            bufferedWriter.write(ContactBackupPlugin.END_OF_LINE);
        }
        bufferedWriter.write("--" + this.f37599f + "--\r\n");
        bufferedWriter.flush();
    }

    public e(String str) {
        this.f37598e = str;
        try {
            this.f37600g = f.c(str, null).split("/")[1];
            String c10 = f.c(str, "boundary");
            this.f37599f = c10;
            if (c10 != null) {
                return;
            }
            throw new MessagingException("MultiPart does not contain boundary: " + str);
        } catch (Exception e10) {
            throw new MessagingException("Invalid MultiPart Content-Type; must contain subtype and boundary. (" + str + ")", e10);
        }
    }
}
