package B6;

import android.content.Context;
import android.net.Uri;
import com.oplus.common.data.b;
import z6.InterfaceC1735a;

/* compiled from: SettingsApiImpl.kt */
/* loaded from: classes3.dex */
public final class a implements InterfaceC1735a {

    /* renamed from: a, reason: collision with root package name */
    public int f260a = 2;

    @Override // z6.InterfaceC1735a
    public boolean a(Context context, int i10, String str, int i11) {
        Boolean bool;
        if (context != null) {
            b.g f10 = f(i10);
            if (f10 != null) {
                bool = Boolean.valueOf(f10.g(context.getContentResolver(), str, i11));
            } else {
                bool = null;
            }
            if (bool != null) {
                return bool.booleanValue();
            }
        }
        return false;
    }

    @Override // z6.InterfaceC1735a
    public Uri b(int i10, String str) {
        b.g f10 = f(i10);
        if (f10 != null) {
            return f10.e(str);
        }
        return null;
    }

    @Override // z6.InterfaceC1735a
    public int c(Context context, int i10, String str, int i11) {
        Integer num;
        if (context != null) {
            b.g f10 = f(i10);
            if (f10 != null) {
                num = Integer.valueOf(f10.b(context.getContentResolver(), str, i11));
            } else {
                num = null;
            }
            if (num != null) {
                return num.intValue();
            }
        }
        return -1;
    }

    @Override // z6.InterfaceC1735a
    public void d(int i10) {
        this.f260a = i10;
    }

    @Override // z6.InterfaceC1735a
    public int e(Context context, int i10, String str) {
        Integer num;
        if (context != null) {
            b.g f10 = f(i10);
            if (f10 != null) {
                num = Integer.valueOf(f10.a(context.getContentResolver(), str));
            } else {
                num = null;
            }
            if (num != null) {
                return num.intValue();
            }
        }
        return -1;
    }

    public final b.g f(int i10) {
        b a10 = b.C0248b.a(this.f260a);
        if (i10 != 0) {
            if (i10 != 1) {
                if (i10 != 2) {
                    return null;
                }
                return a10.f27763c;
            }
            return a10.f27761a;
        }
        return a10.f27762b;
    }
}
