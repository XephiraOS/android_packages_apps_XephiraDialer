package com.android.contacts.scenecard;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewStub;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import com.android.contacts.activities.RequestPermissionsActivityBase;
import com.android.contacts.framework.baseui.util.StatementUtils;
import com.coui.appcompat.button.COUIButton;
import com.coui.appcompat.textviewcompatutil.COUITextViewCompatUtil;
import com.customize.contacts.FeatureOption;
import com.oplus.dialer.R;
import java.util.Set;
import kotlin.Pair;
import v9.InterfaceC1637a;
import x0.AbstractC1662B;

/* compiled from: SceneStatementAndPermissionChecker.kt */
/* loaded from: classes.dex */
public final class SceneStatementAndPermissionChecker {

    /* renamed from: a, reason: collision with root package name */
    public static final SceneStatementAndPermissionChecker f17245a = new SceneStatementAndPermissionChecker();

    /* renamed from: b, reason: collision with root package name */
    public static boolean f17246b;

    /* renamed from: c, reason: collision with root package name */
    public static final m9.d f17247c;

    static {
        m9.d b10;
        b10 = kotlin.a.b(new InterfaceC1637a<String[]>() { // from class: com.android.contacts.scenecard.SceneStatementAndPermissionChecker$permissions$2
            @Override // v9.InterfaceC1637a
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public final String[] invoke() {
                Set<String> f10 = com.android.contacts.util.w.f();
                f10.remove("android.permission.READ_PHONE_NUMBERS");
                kotlin.jvm.internal.i.e(f10, "getPermissionSet().also …_PHONE_NUMBERS)\n        }");
                return (String[]) f10.toArray(new String[0]);
            }
        });
        f17247c = b10;
    }

    public static final void c(View view) {
        f17245a.g();
    }

    public final boolean b(androidx.databinding.o oVar) {
        if (oVar == null) {
            H7.b.c("SceneStatementAndPermissionChecker", "checkUIVisible stub is null");
            return false;
        }
        boolean k10 = k();
        boolean i10 = i();
        boolean j10 = j();
        if (!j10 && !k10 && !i10 && f()) {
            View h10 = oVar.h();
            if (h10 != null) {
                h10.setVisibility(8);
                return true;
            }
            return true;
        }
        AbstractC1662B d10 = d(oVar);
        TextView textView = d10.f37659J;
        kotlin.jvm.internal.i.e(textView, "permissionOrStatementVie…permissionOrStatementHint");
        COUIButton cOUIButton = d10.f37656G;
        kotlin.jvm.internal.i.e(cOUIButton, "permissionOrStatementViewBinding.actionView");
        COUITextViewCompatUtil.setPressRippleDrawable(cOUIButton);
        cOUIButton.setOnClickListener(new View.OnClickListener() { // from class: com.android.contacts.scenecard.W
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SceneStatementAndPermissionChecker.c(view);
            }
        });
        if (j10) {
            cOUIButton.setText(R.string.to_set);
            textView.setText(R.string.pls_set_default_dialer);
        } else if (k10) {
            cOUIButton.setText(R.string.to_view);
            textView.setText(R.string.pls_view_user_notice);
        } else if (i10) {
            cOUIButton.setText(R.string.to_open);
            textView.setText(R.string.open_number_recognition);
        } else {
            cOUIButton.setText(R.string.to_grant);
            textView.setText(R.string.need_grant_permission_to_use);
        }
        View h11 = oVar.h();
        if (h11 != null) {
            h11.setVisibility(0);
        }
        return false;
    }

    public final AbstractC1662B d(androidx.databinding.o oVar) {
        if (oVar.j()) {
            ViewDataBinding g10 = oVar.g();
            kotlin.jvm.internal.i.d(g10, "null cannot be cast to non-null type com.android.contacts.databinding.SceneNoAgreePermissionOrStatementBinding");
            return (AbstractC1662B) g10;
        }
        ViewStub i10 = oVar.i();
        if (i10 != null) {
            i10.inflate();
        }
        ViewDataBinding g11 = oVar.g();
        kotlin.jvm.internal.i.d(g11, "null cannot be cast to non-null type com.android.contacts.databinding.SceneNoAgreePermissionOrStatementBinding");
        AbstractC1662B abstractC1662B = (AbstractC1662B) g11;
        X x10 = X.f17252a;
        TextView title = abstractC1662B.f37660K;
        kotlin.jvm.internal.i.e(title, "title");
        x10.c(title);
        x10.b(abstractC1662B.f37660K);
        return abstractC1662B;
    }

    public final String[] e() {
        return (String[]) f17247c.getValue();
    }

    public final boolean f() {
        if (f17246b) {
            return true;
        }
        boolean l10 = com.android.contacts.util.w.l(P7.a.f2961a.a(), e());
        f17246b = l10;
        return l10;
    }

    public final void g() {
        C0672f c0672f = C0672f.f17272a;
        P7.a aVar = P7.a.f2961a;
        Pair<Intent, Bundle> a10 = c0672f.a(aVar.a(), 1, null, R.string.grant_for_use_function);
        aVar.a().startActivity(a10.a(), a10.b());
    }

    public final boolean h() {
        if (!k() && !i() && f()) {
            return false;
        }
        return true;
    }

    public final boolean i() {
        if (FeatureOption.i()) {
            return StatementUtils.s(P7.a.f2961a.a(), false, 2, null);
        }
        return RequestPermissionsActivityBase.d2(P7.a.f2961a.a(), false);
    }

    public final boolean j() {
        if (!com.android.contacts.framework.api.appstore.appinfo.a.k()) {
            return false;
        }
        P7.a aVar = P7.a.f2961a;
        if (kotlin.jvm.internal.i.b(aVar.a().getPackageName(), P7.d.a(aVar.a()))) {
            return false;
        }
        return true;
    }

    public final boolean k() {
        return RequestPermissionsActivityBase.e2(P7.a.f2961a.a());
    }
}
