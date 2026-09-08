package o6;

import android.content.Context;
import android.text.TextUtils;
import com.oplus.utils.C0848i;

/* compiled from: NumberMatchFuzzyProcessor.java */
/* loaded from: classes3.dex */
public class f extends AbstractC1405a {
    @Override // o6.AbstractC1405a
    public boolean d(Context context, String str, String str2) {
        String t10 = C0848i.t(str2, I6.a.b(context).a());
        String t11 = C0848i.t(str, I6.a.b(context).a());
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && !TextUtils.isEmpty(t11) && !TextUtils.isEmpty(t10)) {
            return t11.contains(t10);
        }
        return false;
    }

    @Override // o6.AbstractC1405a
    public boolean e() {
        return false;
    }
}
