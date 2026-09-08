package A2;

import A2.A;
import android.content.Context;
import android.os.Bundle;
import com.android.incallui.Log;
import com.android.incallui.OplusFeatureOption;

/* compiled from: OplusYellowPageQuery.java */
/* loaded from: classes.dex */
public abstract class x {
    public abstract void a(A a10, Bundle bundle, A.a aVar);

    public abstract void b();

    public abstract boolean c(A a10);

    public abstract boolean d(Context context, String str, int i10, int i11);

    public final void e(Context context, String str, String str2, int i10, A.a aVar, int i11) {
        D2.g.k("OplusYellowPageQuery", " startQueryInfo number = " + D2.g.l(str) + " type = " + i10);
        A a10 = new A();
        a10.f93a = str;
        a10.f94b = str2;
        a10.f104l = i11;
        d(context, str, i10, i11);
        int i12 = 3;
        if (c(a10)) {
            if (Log.sDebug) {
                Log.d("OplusYellowPageQuery", "Have local data  info = " + a10);
            }
            if (a10.f101i == null) {
                i12 = 2;
            }
            a10.f103k = i12;
            aVar.a(a10);
        } else if (OplusFeatureOption.OPLUS_VERSION_EXP && !OplusFeatureOption.FEATURE_NUMBER_RECOGNITION.value().booleanValue()) {
            if (Log.sDebug) {
                Log.d("OplusYellowPageQuery", "region is exp");
            }
            a10.f103k = 3;
            aVar.a(a10);
        } else {
            Bundle bundle = new Bundle();
            bundle.putString("query_param", "QueryOmojiInfo");
            a(a10, bundle, aVar);
        }
        b();
    }
}
