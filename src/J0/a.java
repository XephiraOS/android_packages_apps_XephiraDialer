package J0;

import android.content.Context;
import android.content.Intent;

/* compiled from: AbstractBroadcastIntentProcessor.java */
/* loaded from: classes.dex */
public class a {
    public void a(Intent intent, Context context) {
        String str;
        if (context == null) {
            return;
        }
        if (intent.getData() != null) {
            str = intent.getData().getSchemeSpecificPart();
        } else {
            str = null;
        }
        k.d(context, intent, str);
    }

    public void b(Intent intent, Context context) {
        if (context == null) {
            return;
        }
        Intent intent2 = new Intent("android.intent.action.CALL");
        intent2.setFlags(276824064);
        intent2.setData(intent.getData());
        R7.b.d(context, intent2, H0.d.f1213a);
    }

    public void c(Context context, Intent intent) {
        if (context == null) {
            return;
        }
        R7.b.d(context, intent, H0.d.f1213a);
    }
}
