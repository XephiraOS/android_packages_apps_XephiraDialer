package w1;

import com.android.contacts.voicemail.impl.mail.g;
import com.customize.contacts.backupandrestore.plugin.ContactBackupPlugin;
import java.io.BufferedWriter;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.regex.Pattern;

/* compiled from: MimeBodyPart.java */
/* renamed from: w1.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C1645b extends com.android.contacts.voicemail.impl.mail.b {

    /* renamed from: d, reason: collision with root package name */
    public static final Pattern f37572d = Pattern.compile("^<?([^>]+)>?$");

    /* renamed from: e, reason: collision with root package name */
    public static final Pattern f37573e = Pattern.compile("\r?\n");

    /* renamed from: a, reason: collision with root package name */
    public c f37574a;

    /* renamed from: b, reason: collision with root package name */
    public com.android.contacts.voicemail.impl.mail.a f37575b;

    /* renamed from: c, reason: collision with root package name */
    public int f37576c;

    public C1645b() {
        this(null);
    }

    @Override // com.android.contacts.voicemail.impl.mail.h
    public String a() {
        return f.c(e(), null);
    }

    @Override // com.android.contacts.voicemail.impl.mail.h
    public com.android.contacts.voicemail.impl.mail.a b() {
        return this.f37575b;
    }

    @Override // com.android.contacts.voicemail.impl.mail.h
    public int c() {
        return this.f37576c;
    }

    @Override // com.android.contacts.voicemail.impl.mail.h
    public void d(com.android.contacts.voicemail.impl.mail.a aVar) {
        this.f37575b = aVar;
        if (aVar instanceof g) {
            g gVar = (g) aVar;
            gVar.e(this);
            h("Content-Type", gVar.c());
        }
    }

    @Override // com.android.contacts.voicemail.impl.mail.h
    public String e() {
        String i10 = i("Content-Type");
        if (i10 == null) {
            return "text/plain";
        }
        return i10;
    }

    @Override // com.android.contacts.voicemail.impl.mail.h
    public void f(String str, String str2) {
        this.f37574a.a(str, str2);
    }

    @Override // com.android.contacts.voicemail.impl.mail.h
    public String[] g(String str) {
        return this.f37574a.f(str);
    }

    @Override // com.android.contacts.voicemail.impl.mail.h
    public void h(String str, String str2) {
        this.f37574a.h(str, str2);
    }

    public String i(String str) {
        return this.f37574a.e(str);
    }

    public void j(int i10) {
        this.f37576c = i10;
    }

    @Override // com.android.contacts.voicemail.impl.mail.h
    public void writeTo(OutputStream outputStream) {
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream), 1024);
        this.f37574a.i(outputStream);
        bufferedWriter.write(ContactBackupPlugin.END_OF_LINE);
        bufferedWriter.flush();
        com.android.contacts.voicemail.impl.mail.a aVar = this.f37575b;
        if (aVar != null) {
            aVar.writeTo(outputStream);
        }
    }

    public C1645b(com.android.contacts.voicemail.impl.mail.a aVar) {
        this(aVar, null);
    }

    public C1645b(com.android.contacts.voicemail.impl.mail.a aVar, String str) {
        this.f37574a = new c();
        if (str != null) {
            h("Content-Type", str);
        }
        d(aVar);
    }
}
