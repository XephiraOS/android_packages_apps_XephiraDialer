package x8;

import android.content.Context;
import android.util.ArrayMap;
import com.heytap.accessory.constant.FastPairConstants;
import java.util.Map;
import y8.C1714f;
import y8.InterfaceC1715g;

/* compiled from: ChattyEventTracker.java */
/* renamed from: x8.d, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C1691d {

    /* renamed from: a, reason: collision with root package name */
    public final Map<String, b> f38081a;

    /* renamed from: b, reason: collision with root package name */
    public int f38082b;

    /* compiled from: ChattyEventTracker.java */
    /* renamed from: x8.d$b */
    /* loaded from: classes3.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public final String f38083a;

        /* renamed from: b, reason: collision with root package name */
        public final String f38084b;

        /* renamed from: c, reason: collision with root package name */
        public final String f38085c;

        /* renamed from: d, reason: collision with root package name */
        public int f38086d;

        public b(String str, String str2, String str3) {
            this.f38083a = str;
            this.f38084b = str2;
            this.f38085c = str3;
        }

        public int e() {
            int i10 = this.f38086d;
            this.f38086d = i10 + 1;
            return i10;
        }
    }

    /* compiled from: ChattyEventTracker.java */
    /* renamed from: x8.d$c */
    /* loaded from: classes3.dex */
    public static class c {

        /* renamed from: a, reason: collision with root package name */
        public static final C1691d f38087a = new C1691d();
    }

    public static C1691d e() {
        return c.f38087a;
    }

    public static /* synthetic */ String f() {
        return "context is empty.";
    }

    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public void h(Context context) {
        for (b bVar : this.f38081a.values()) {
            u8.b bVar2 = new u8.b(context, "21000", FastPairConstants.STATUS_CONNECT_RESULT_FAIL, "chatty_event");
            ArrayMap arrayMap = new ArrayMap();
            arrayMap.put("app_id", String.valueOf(bVar.f38083a));
            arrayMap.put("log_tag", bVar.f38084b);
            arrayMap.put("event_id", bVar.f38085c);
            arrayMap.put("times", String.valueOf(bVar.f38086d));
            bVar2.q(arrayMap);
            t8.f.a(context, bVar2);
        }
        this.f38082b = 0;
        this.f38081a.clear();
        HandlerThreadC1695h.c().h(1);
    }

    public final /* synthetic */ void g(Context context, u8.b bVar) {
        i(context, bVar.e(), bVar.o(), bVar.m());
    }

    public final void i(final Context context, String str, String str2, String str3) {
        String str4 = str + str2 + str3;
        b bVar = this.f38081a.get(str4);
        if (bVar == null) {
            b bVar2 = new b(str, str2, str3);
            bVar2.e();
            this.f38081a.put(str4, bVar2);
        } else {
            bVar.e();
        }
        int i10 = this.f38082b + 1;
        this.f38082b = i10;
        if (i10 >= 100) {
            h(context);
        } else if (i10 == 1 && !HandlerThreadC1695h.c().d(1)) {
            HandlerThreadC1695h.c().g(1, new Runnable() { // from class: x8.c
                @Override // java.lang.Runnable
                public final void run() {
                    C1691d.this.h(context);
                }
            }, 300000L);
        }
    }

    public void j(final u8.b bVar) {
        final Context applicationContext = bVar.f().getApplicationContext();
        if (applicationContext == null) {
            C1714f.b("ChattyEventTracker", new InterfaceC1715g() { // from class: x8.a
                @Override // y8.InterfaceC1715g
                public final Object get() {
                    String f10;
                    f10 = C1691d.f();
                    return f10;
                }
            });
        } else {
            HandlerThreadC1695h.b(new Runnable() { // from class: x8.b
                @Override // java.lang.Runnable
                public final void run() {
                    C1691d.this.g(applicationContext, bVar);
                }
            });
        }
    }

    public C1691d() {
        this.f38081a = new ArrayMap();
    }
}
