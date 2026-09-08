package J6;

import android.content.ContentProviderOperation;
import com.oplus.compat.utils.util.UnSupportedApiVersionException;
import com.oplus.inner.content.ContentProviderOperationWrapper;

/* compiled from: ContentProviderOperationNative.java */
/* loaded from: classes3.dex */
public class a {
    public static int a(ContentProviderOperation contentProviderOperation) {
        if (S6.c.n()) {
            return contentProviderOperation.getType();
        }
        if (S6.c.j()) {
            return ContentProviderOperationWrapper.getType(contentProviderOperation);
        }
        if (S6.c.l()) {
            return ((Integer) b(contentProviderOperation)).intValue();
        }
        throw new UnSupportedApiVersionException();
    }

    public static Object b(ContentProviderOperation contentProviderOperation) {
        return b.a(contentProviderOperation);
    }
}
