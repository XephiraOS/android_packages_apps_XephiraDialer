package L0;

import H0.d;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import com.android.contacts.framework.appstore.settings.ODialerSettingActivity;
import kotlin.jvm.internal.i;

/* compiled from: SettingsJumpHelper.kt */
/* loaded from: classes.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public static final c f1709a = new c();

    public final void a(Context context) {
        i.f(context, "context");
        R7.b.f(context, new Intent(context, (Class<?>) ODialerSettingActivity.class), 0, null, 6, null);
    }

    public final void b(Activity activity) {
        i.f(activity, "activity");
        Intent intent = new Intent("android.telecom.action.SHOW_CALL_SETTINGS");
        Resources resources = activity.getResources();
        int i10 = d.f1220h;
        intent.putExtra("navigate_title_text", resources.getString(i10));
        intent.putExtra("from_dialpad", true);
        intent.putExtra("navigate_title_id", i10);
        intent.putExtra("navigate_parent_package", activity.getPackageName());
        R7.b.f(activity, intent, 0, null, 6, null);
    }
}
