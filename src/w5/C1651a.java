package w5;

import android.content.Context;
import android.os.customize.OplusCustomizeContactManager;

/* compiled from: OplusCustomizeContactManager.java */
/* renamed from: w5.a, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C1651a {

    /* renamed from: b, reason: collision with root package name */
    public static C1651a f37615b;

    /* renamed from: a, reason: collision with root package name */
    public OplusCustomizeContactManager f37616a;

    public C1651a(OplusCustomizeContactManager oplusCustomizeContactManager) {
        this.f37616a = oplusCustomizeContactManager;
    }

    public static C1651a c(Context context) {
        if (f37615b == null) {
            synchronized (C1651a.class) {
                try {
                    if (f37615b == null) {
                        f37615b = new C1651a(OplusCustomizeContactManager.getInstance(context));
                    }
                } finally {
                }
            }
        }
        return f37615b;
    }

    public int a() {
        if (A5.a.b()) {
            return this.f37616a.getContactNumberHideMode();
        }
        throw new Exception("UnSupportedApiVersionException");
    }

    public int b() {
        if (A5.a.b()) {
            return this.f37616a.getContactNumberMaskEnable();
        }
        throw new Exception("UnSupportedApiVersionException");
    }

    public boolean d() {
        if (A5.a.b()) {
            return this.f37616a.isContactBlackListEnable();
        }
        throw new Exception("UnSupportedApiVersionException");
    }
}
