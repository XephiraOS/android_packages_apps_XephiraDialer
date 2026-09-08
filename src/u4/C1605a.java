package u4;

import android.graphics.Typeface;

/* compiled from: CancelableFontCallback.java */
/* renamed from: u4.a, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C1605a extends f {

    /* renamed from: a, reason: collision with root package name */
    public final Typeface f37319a;

    /* renamed from: b, reason: collision with root package name */
    public final InterfaceC0367a f37320b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f37321c;

    /* compiled from: CancelableFontCallback.java */
    /* renamed from: u4.a$a, reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0367a {
        void apply(Typeface typeface);
    }

    public C1605a(InterfaceC0367a interfaceC0367a, Typeface typeface) {
        this.f37319a = typeface;
        this.f37320b = interfaceC0367a;
    }

    public void a() {
        this.f37321c = true;
    }

    public final void b(Typeface typeface) {
        if (!this.f37321c) {
            this.f37320b.apply(typeface);
        }
    }

    @Override // u4.f
    public void onFontRetrievalFailed(int i10) {
        b(this.f37319a);
    }

    @Override // u4.f
    public void onFontRetrieved(Typeface typeface, boolean z10) {
        b(typeface);
    }
}
