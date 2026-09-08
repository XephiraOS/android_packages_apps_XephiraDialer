package d7;

import android.content.Context;
import com.oplus.epona.e;
import com.oplus.epona.g;
import com.oplus.epona.k;

/* compiled from: CompatPermissionCheck.java */
/* renamed from: d7.b, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C0957b implements e {
    @Override // com.oplus.epona.e
    public boolean a(Context context) {
        if (context == null) {
            return false;
        }
        if (k.a()) {
            return new g().a(context);
        }
        if (context.checkCallingPermission("com.oppo.permission.safe.SECURITY") != 0) {
            return false;
        }
        return true;
    }
}
