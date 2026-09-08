package F6;

import android.app.OplusActivityManager;
import android.content.Context;
import android.os.customize.OplusCustomizeContactManager;
import android.telephony.OplusOSTelephonyManager;
import com.oplus.os.OplusBuild;
import java.util.List;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.i;

/* compiled from: SdkAddonUtils.kt */
/* loaded from: classes3.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public static final a f998a = new a(null);

    /* compiled from: SdkAddonUtils.kt */
    /* loaded from: classes3.dex */
    public static final class a {
        public a() {
        }

        public final int a() {
            return 0;
        }

        public final int b() {
            return 1;
        }

        public final void c(String packageName, List<String> targetPkgList) {
            i.f(packageName, "packageName");
            i.f(targetPkgList, "targetPkgList");
            new OplusActivityManager().addBackgroundRestrictedInfo(packageName, targetPkgList);
        }

        public final int d(Context ctx) {
            i.f(ctx, "ctx");
            return OplusCustomizeContactManager.getInstance(ctx).getContactBlockPattern();
        }

        public final int e(Context ctx) {
            i.f(ctx, "ctx");
            return OplusCustomizeContactManager.getInstance(ctx).getContactMatchPattern();
        }

        public final int f(Context ctx) {
            i.f(ctx, "ctx");
            return OplusCustomizeContactManager.getInstance(ctx).getContactNumberHideMode();
        }

        public final int g(Context ctx) {
            i.f(ctx, "ctx");
            return OplusCustomizeContactManager.getInstance(ctx).getContactNumberMaskEnable();
        }

        public final int h(Context ctx) {
            i.f(ctx, "ctx");
            return OplusCustomizeContactManager.getInstance(ctx).getContactOutgoOrIncomePattern();
        }

        public final int i() {
            return OplusBuild.getOplusOSVERSION();
        }

        public final boolean j(Context ctx) {
            i.f(ctx, "ctx");
            return OplusCustomizeContactManager.getInstance(ctx).isContactBlackListEnable();
        }

        public final boolean k(Context ctx) {
            i.f(ctx, "ctx");
            return OplusOSTelephonyManager.getDefault(ctx.getApplicationContext()).isOplusHasSoftSimCard();
        }

        public final int l(Context ctx) {
            i.f(ctx, "ctx");
            return OplusOSTelephonyManager.getDefault(ctx.getApplicationContext()).oplusGetSoftSimCardSlotId();
        }

        public final int m(Context context, int i10) {
            i.f(context, "context");
            return OplusOSTelephonyManager.oplusgetSubId(context.getApplicationContext(), i10);
        }

        public /* synthetic */ a(f fVar) {
            this();
        }
    }

    public static final int a() {
        return f998a.a();
    }

    public static final int b() {
        return f998a.b();
    }

    public static final void c(String str, List<String> list) {
        f998a.c(str, list);
    }

    public static final int d() {
        return f998a.i();
    }

    public static final boolean e(Context context) {
        return f998a.k(context);
    }

    public static final int f(Context context) {
        return f998a.l(context);
    }

    public static final int g(Context context, int i10) {
        return f998a.m(context, i10);
    }
}
