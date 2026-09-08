package q0;

import com.android.contacts.assisteddialing.TransformationInfo;
import java.util.Optional;

/* compiled from: AssistedDialingMediatorImpl.java */
/* renamed from: q0.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C1477b implements InterfaceC1476a {

    /* renamed from: a, reason: collision with root package name */
    public final g f36120a;

    /* renamed from: b, reason: collision with root package name */
    public final com.android.contacts.assisteddialing.a f36121b;

    public C1477b(g gVar, com.android.contacts.assisteddialing.a aVar) {
        if (gVar != null) {
            if (aVar != null) {
                this.f36120a = gVar;
                this.f36121b = aVar;
                return;
            }
            throw new NullPointerException("numberTransformer was null");
        }
        throw new NullPointerException("locationDetector was null");
    }

    @Override // q0.InterfaceC1476a
    public Optional<TransformationInfo> a(String str) {
        Optional<String> a10 = this.f36120a.a();
        Optional<String> b10 = this.f36120a.b();
        if (a10.isPresent() && b10.isPresent()) {
            return this.f36121b.a(str, a10.get(), b10.get());
        }
        H7.b.e("AssistedDialingMediatorImpl", "attemptAssistedDial: Unable to determine country codes");
        return Optional.empty();
    }
}
