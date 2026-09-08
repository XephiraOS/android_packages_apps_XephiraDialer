package e8;

import android.content.Context;
import com.heytap.accessory.constant.AFConstants;
import com.oplus.phonenoareainquire.utils.LogUtil;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.i;
import s8.C1569l;

/* compiled from: StatisticsActionUtils.kt */
/* renamed from: e8.a, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C0988a {

    /* renamed from: a, reason: collision with root package name */
    public static final C0988a f31653a = new C0988a();

    public static final void a(Context context, int i10, int i11, Map<String, String> map) {
        if (context != null && map != null) {
            C1569l.s(context, String.valueOf(i10), String.valueOf(i11), map);
        } else {
            LogUtil.h("StatisticsActionUtils", "addCommonUserAction context or eventMap is null");
        }
    }

    public static final void b(Context context, String action, String extra) {
        i.f(action, "action");
        i.f(extra, "extra");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(AFConstants.EXTRA_INTENT_ACTION, action);
        linkedHashMap.put("extra", extra);
        a(context, 2000302, 200031214, linkedHashMap);
    }
}
