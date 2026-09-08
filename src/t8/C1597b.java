package t8;

import android.content.Context;
import u8.C1613a;
import y8.C1714f;
import y8.C1716h;
import y8.InterfaceC1715g;

/* compiled from: AppStartAgent.java */
/* renamed from: t8.b, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C1597b {
    public static /* synthetic */ String b() {
        return "调用AppStart";
    }

    public static void c(Context context) {
        C1714f.c("AppStartAgent", new InterfaceC1715g() { // from class: t8.a
            @Override // y8.InterfaceC1715g
            public final Object get() {
                String b10;
                b10 = C1597b.b();
                return b10;
            }
        });
        v8.h.c().a(context, new C1613a(context, C1716h.a()));
    }
}
