package J6;

import android.content.ContentProviderOperation;
import com.color.inner.content.ContentProviderOperationWrapper;

/* compiled from: ContentProviderOperationNativeOplusCompat.java */
/* loaded from: classes3.dex */
public class b {
    public static Object a(ContentProviderOperation contentProviderOperation) {
        return Integer.valueOf(ContentProviderOperationWrapper.getType(contentProviderOperation));
    }
}
