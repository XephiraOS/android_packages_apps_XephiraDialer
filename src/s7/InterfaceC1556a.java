package s7;

import android.view.MenuItem;
import java.util.List;
import kotlin.jvm.internal.i;
import m7.e;
import s7.c;

/* compiled from: ILazyInflateToolbarPopupMenu.kt */
/* renamed from: s7.a, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public interface InterfaceC1556a extends c.a {

    /* compiled from: ILazyInflateToolbarPopupMenu.kt */
    /* renamed from: s7.a$a, reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static final class C0358a {
        public static boolean a(InterfaceC1556a interfaceC1556a, MenuItem item) {
            i.f(item, "item");
            if (item.getItemId() == e.f35184f) {
                return true;
            }
            return false;
        }
    }

    List<C1557b> U();

    void z(C1557b c1557b);
}
