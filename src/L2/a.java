package L2;

import android.util.Log;
import kotlin.jvm.internal.i;

/* compiled from: OplusLogWrapper.kt */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final a f1714a = new a();

    public void a(String tag, String objTag, String msg) {
        i.f(tag, "tag");
        i.f(objTag, "objTag");
        i.f(msg, "msg");
        Log.d("InCall_" + tag, objTag + com.android.incallui.Log.TAG_DELIMETER + msg);
    }

    public void b(String tag, String objTag, String msg) {
        i.f(tag, "tag");
        i.f(objTag, "objTag");
        i.f(msg, "msg");
        Log.w("InCall_" + tag, objTag + com.android.incallui.Log.TAG_DELIMETER + msg);
    }
}
