package F6;

import android.content.Intent;
import android.util.Log;
import com.oplus.contacts.common.ContactParcelable;
import com.oplus.os.OplusBuild;
import com.oplus.utils.C0863y;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.i;

/* compiled from: SdkCommonUtils.kt */
/* loaded from: classes3.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public static final a f999a = new a(null);

    /* compiled from: SdkCommonUtils.kt */
    /* loaded from: classes3.dex */
    public static final class a {

        /* compiled from: SdkCommonUtils.kt */
        /* renamed from: F6.c$a$a, reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public static final class C0018a implements H6.a {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ ContactParcelable f1000a;

            public C0018a(ContactParcelable contactParcelable) {
                this.f1000a = contactParcelable;
            }

            @Override // H6.a
            public String a() {
                return this.f1000a.k();
            }

            @Override // H6.a
            public long getId() {
                return this.f1000a.j();
            }
        }

        public a() {
        }

        public final int a() {
            try {
                return OplusBuild.getOplusOSVERSION();
            } catch (Throwable th) {
                Log.e("RomVersionUtil", "getRomVersionCode failed. error = " + th);
                return 0;
            }
        }

        public final ArrayList<H6.a> b(Intent data) {
            i.f(data, "data");
            ArrayList c10 = C0863y.c(data, "SELECTED_CONTACTS");
            if (c10 != null && c10.size() > 0) {
                ArrayList<H6.a> arrayList = new ArrayList<>(c10.size());
                Iterator it = c10.iterator();
                while (it.hasNext()) {
                    arrayList.add(new C0018a((ContactParcelable) it.next()));
                }
                return arrayList;
            }
            return null;
        }

        public final boolean c() {
            int a10 = a();
            if (a10 != 0 && a10 < 6) {
                return false;
            }
            return true;
        }

        public final boolean d() {
            return true;
        }

        public /* synthetic */ a(f fVar) {
            this();
        }
    }

    public static final ArrayList<H6.a> a(Intent intent) {
        return f999a.b(intent);
    }

    public static final boolean b() {
        return f999a.c();
    }

    public static final boolean c() {
        return f999a.d();
    }
}
