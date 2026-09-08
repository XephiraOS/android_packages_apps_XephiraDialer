package c;

import android.content.Context;
import android.content.Intent;
import c.AbstractC0540a;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.collections.C1229j;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.D;
import kotlin.collections.E;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.i;
import m9.g;

/* compiled from: ActivityResultContracts.kt */
/* renamed from: c.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0541b extends AbstractC0540a<String[], Map<String, Boolean>> {

    /* renamed from: a, reason: collision with root package name */
    public static final a f12677a = new a(null);

    /* compiled from: ActivityResultContracts.kt */
    /* renamed from: c.b$a */
    /* loaded from: classes.dex */
    public static final class a {
        public a() {
        }

        public final Intent a(String[] input) {
            i.f(input, "input");
            Intent putExtra = new Intent("androidx.activity.result.contract.action.REQUEST_PERMISSIONS").putExtra("androidx.activity.result.contract.extra.PERMISSIONS", input);
            i.e(putExtra, "Intent(ACTION_REQUEST_PE…EXTRA_PERMISSIONS, input)");
            return putExtra;
        }

        public /* synthetic */ a(f fVar) {
            this();
        }
    }

    @Override // c.AbstractC0540a
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public Intent a(Context context, String[] input) {
        i.f(context, "context");
        i.f(input, "input");
        return f12677a.a(input);
    }

    @Override // c.AbstractC0540a
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public AbstractC0540a.C0147a<Map<String, Boolean>> b(Context context, String[] input) {
        int a10;
        int b10;
        Map d10;
        i.f(context, "context");
        i.f(input, "input");
        if (input.length == 0) {
            d10 = E.d();
            return new AbstractC0540a.C0147a<>(d10);
        }
        for (String str : input) {
            if (androidx.core.content.b.a(context, str) != 0) {
                return null;
            }
        }
        a10 = D.a(input.length);
        b10 = B9.i.b(a10, 16);
        LinkedHashMap linkedHashMap = new LinkedHashMap(b10);
        for (String str2 : input) {
            Pair a11 = g.a(str2, Boolean.TRUE);
            linkedHashMap.put(a11.c(), a11.d());
        }
        return new AbstractC0540a.C0147a<>(linkedHashMap);
    }

    @Override // c.AbstractC0540a
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public Map<String, Boolean> c(int i10, Intent intent) {
        Map<String, Boolean> d10;
        List w10;
        List S10;
        Map<String, Boolean> j10;
        boolean z10;
        Map<String, Boolean> d11;
        Map<String, Boolean> d12;
        if (i10 != -1) {
            d12 = E.d();
            return d12;
        }
        if (intent == null) {
            d11 = E.d();
            return d11;
        }
        String[] stringArrayExtra = intent.getStringArrayExtra("androidx.activity.result.contract.extra.PERMISSIONS");
        int[] intArrayExtra = intent.getIntArrayExtra("androidx.activity.result.contract.extra.PERMISSION_GRANT_RESULTS");
        if (intArrayExtra == null || stringArrayExtra == null) {
            d10 = E.d();
            return d10;
        }
        ArrayList arrayList = new ArrayList(intArrayExtra.length);
        for (int i11 : intArrayExtra) {
            if (i11 == 0) {
                z10 = true;
            } else {
                z10 = false;
            }
            arrayList.add(Boolean.valueOf(z10));
        }
        w10 = C1229j.w(stringArrayExtra);
        S10 = CollectionsKt___CollectionsKt.S(w10, arrayList);
        j10 = E.j(S10);
        return j10;
    }
}
