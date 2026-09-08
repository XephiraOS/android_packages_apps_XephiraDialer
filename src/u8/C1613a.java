package u8;

import android.content.Context;

/* compiled from: AppStartBean.java */
/* renamed from: u8.a, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C1613a extends f {

    /* renamed from: g, reason: collision with root package name */
    public String f37352g;

    public C1613a(Context context, String str) {
        super(context);
        this.f37352g = str;
        d("loginTime", str);
    }

    @Override // u8.f
    public int g() {
        return 1000;
    }

    public String l() {
        return this.f37352g;
    }

    public String toString() {
        return "loginTime is :" + l() + "\n";
    }
}
