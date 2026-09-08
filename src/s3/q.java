package S3;

import com.android.contacts.framework.vcard.VCardEntry;
import com.android.contacts.framework.vcard.u;

/* compiled from: VcardInterpreterImpl.java */
/* loaded from: classes3.dex */
public class q implements com.android.contacts.framework.vcard.l {

    /* renamed from: a, reason: collision with root package name */
    public VCardEntry f3483a = new VCardEntry();

    @Override // com.android.contacts.framework.vcard.l
    public void a() {
        H7.b.b("VcardInterpreterImpl", "onEntryEnded");
    }

    @Override // com.android.contacts.framework.vcard.l
    public void b() {
        H7.b.b("VcardInterpreterImpl", "onVcardStarted");
    }

    @Override // com.android.contacts.framework.vcard.l
    public void c() {
        H7.b.b("VcardInterpreterImpl", "onVCardEnded");
    }

    @Override // com.android.contacts.framework.vcard.l
    public void d(u uVar) {
        H7.b.b("VcardInterpreterImpl", "onPropertyCreated");
        this.f3483a.x(uVar);
    }

    @Override // com.android.contacts.framework.vcard.l
    public void e() {
        H7.b.b("VcardInterpreterImpl", "onEntryStarted");
    }

    public VCardEntry f() {
        return this.f3483a;
    }
}
