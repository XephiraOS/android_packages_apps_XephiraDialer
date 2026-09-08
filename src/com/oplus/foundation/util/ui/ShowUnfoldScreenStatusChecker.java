package com.oplus.foundation.util.ui;

import android.content.Context;
import android.provider.Settings;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.p;
import com.coui.appcompat.baseview.util.FoldSettingsHelper;
import kotlin.jvm.internal.f;
import kotlinx.coroutines.C1248i;
import kotlinx.coroutines.InterfaceC1265l0;
import kotlinx.coroutines.S;

/* compiled from: ShowUnfoldScreenStatusChecker.kt */
/* loaded from: classes3.dex */
public final class ShowUnfoldScreenStatusChecker {

    /* renamed from: d, reason: collision with root package name */
    public static final a f28364d = new a(null);

    /* renamed from: a, reason: collision with root package name */
    public InterfaceC1265l0 f28365a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f28366b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f28367c = true;

    /* compiled from: ShowUnfoldScreenStatusChecker.kt */
    /* loaded from: classes3.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }
    }

    public final boolean b() {
        return this.f28366b;
    }

    public final boolean c(Context context) {
        int i10 = Settings.Global.getInt(context.getContentResolver(), FoldSettingsHelper.SYSTEM_FOLDING_MODE_KEY, -1);
        H7.b.e("ResponseUIConfigStatusChecker", "isShowUnFoldScreenFromSettings " + i10);
        if (i10 == 1) {
            return true;
        }
        return false;
    }

    public final boolean d() {
        return this.f28367c;
    }

    public final void e(AppCompatActivity appCompatActivity, boolean z10) {
        InterfaceC1265l0 d10;
        if (appCompatActivity == null) {
            H7.b.i("ResponseUIConfigStatusChecker", "activity is null");
            return;
        }
        if (this.f28366b) {
            H7.b.e("ResponseUIConfigStatusChecker", "already refreshing");
            return;
        }
        H7.b.e("ResponseUIConfigStatusChecker", "refreshIfNeed");
        this.f28367c = z10;
        InterfaceC1265l0 interfaceC1265l0 = this.f28365a;
        if (interfaceC1265l0 != null) {
            InterfaceC1265l0.a.a(interfaceC1265l0, null, 1, null);
        }
        d10 = C1248i.d(p.a(appCompatActivity), S.b(), null, new ShowUnfoldScreenStatusChecker$refreshIfNeed$1(this, appCompatActivity, z10, null), 2, null);
        this.f28365a = d10;
    }

    public final void f(boolean z10) {
        this.f28366b = z10;
    }

    public final void g(boolean z10) {
        this.f28367c = z10;
    }
}
