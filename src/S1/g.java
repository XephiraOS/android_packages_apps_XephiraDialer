package s1;

import android.content.Context;
import android.telecom.PhoneAccountHandle;
import java.util.ArrayList;
import java.util.List;

/* compiled from: PhoneAccountUtils.java */
/* loaded from: classes.dex */
public class g {
    public static List<PhoneAccountHandle> a(Context context) {
        ArrayList arrayList = new ArrayList();
        List<PhoneAccountHandle> c10 = i.c(context);
        if (c10 != null) {
            for (PhoneAccountHandle phoneAccountHandle : c10) {
                if (i.d(context, phoneAccountHandle).hasCapabilities(4)) {
                    arrayList.add(phoneAccountHandle);
                }
            }
        }
        return arrayList;
    }
}
