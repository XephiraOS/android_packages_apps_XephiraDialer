package c;

import android.content.Context;
import android.content.Intent;
import c.AbstractC0540a;
import kotlin.jvm.internal.i;

/* compiled from: ActivityResultContracts.kt */
/* renamed from: c.c, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0542c extends AbstractC0540a<String, Boolean> {
    @Override // c.AbstractC0540a
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public Intent a(Context context, String input) {
        i.f(context, "context");
        i.f(input, "input");
        return C0541b.f12677a.a(new String[]{input});
    }

    @Override // c.AbstractC0540a
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public AbstractC0540a.C0147a<Boolean> b(Context context, String input) {
        i.f(context, "context");
        i.f(input, "input");
        if (androidx.core.content.b.a(context, input) == 0) {
            return new AbstractC0540a.C0147a<>(Boolean.TRUE);
        }
        return null;
    }

    @Override // c.AbstractC0540a
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public Boolean c(int i10, Intent intent) {
        if (intent != null && i10 == -1) {
            int[] intArrayExtra = intent.getIntArrayExtra("androidx.activity.result.contract.extra.PERMISSION_GRANT_RESULTS");
            boolean z10 = false;
            if (intArrayExtra != null) {
                int length = intArrayExtra.length;
                int i11 = 0;
                while (true) {
                    if (i11 >= length) {
                        break;
                    }
                    if (intArrayExtra[i11] == 0) {
                        z10 = true;
                        break;
                    }
                    i11++;
                }
            }
            return Boolean.valueOf(z10);
        }
        return Boolean.FALSE;
    }
}
