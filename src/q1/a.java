package Q1;

import T1.a;
import android.app.Application;
import android.content.ContentResolver;
import com.android.incallui.OplusInCallPresenter;
import com.internal_dependency.AddOnSdkDepends;
import com.internal_dependency.SettingsUtils;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.i;

/* compiled from: FoldConfigRepository.kt */
/* loaded from: classes.dex */
public final class a implements T1.a {

    /* renamed from: a, reason: collision with root package name */
    public static final C0059a f3120a = new C0059a(null);

    /* compiled from: FoldConfigRepository.kt */
    /* renamed from: Q1.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static final class C0059a {
        public C0059a() {
        }

        public /* synthetic */ C0059a(f fVar) {
            this();
        }
    }

    public Application B() {
        return a.C0066a.b(this);
    }

    @Override // d2.InterfaceC0949b
    public OplusInCallPresenter C0() {
        return a.C0066a.c(this);
    }

    @Override // T1.a
    public boolean R0() {
        SettingsUtils settingsUtils = SettingsUtils.INSTANCE;
        ContentResolver contentResolver = B().getContentResolver();
        i.e(contentResolver, "application.contentResolver");
        if (settingsUtils.getGlobalSettingsInt(contentResolver, "oplus_customize_auto_answer_with_screen_unfold", 1) == 1) {
            return true;
        }
        return false;
    }

    @Override // T1.a
    public void collapseDragonflyPanels() {
        o().collapseDragonflyPanels();
    }

    @Override // d2.InterfaceC0949b
    public void f() {
        a.C0066a.d(this);
    }

    @Override // T1.a
    public boolean m1() {
        SettingsUtils settingsUtils = SettingsUtils.INSTANCE;
        ContentResolver contentResolver = B().getContentResolver();
        i.e(contentResolver, "application.contentResolver");
        if (settingsUtils.getGlobalSettingsInt(contentResolver, "oplus_customize_auto_end_with_screen_fold", 1) == 1) {
            return true;
        }
        return false;
    }

    public AddOnSdkDepends o() {
        return a.C0066a.a(this);
    }
}
