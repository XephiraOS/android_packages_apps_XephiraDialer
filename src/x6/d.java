package X6;

import C7.e;
import android.app.Activity;
import android.app.role.RoleManager;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.activity.result.ActivityResult;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import c.C0543d;
import com.coui.appcompat.button.COUIButton;
import com.coui.appcompat.button.SingleButtonWrap;
import com.oplus.contacts.config.defaultdialer.SetDefaultImpl;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.i;

/* compiled from: SetDefaultDialerFragment.kt */
/* loaded from: classes3.dex */
public final class d extends Fragment implements View.OnClickListener {

    /* renamed from: e, reason: collision with root package name */
    public static final a f4303e = new a(null);

    /* renamed from: a, reason: collision with root package name */
    public SingleButtonWrap f4304a;

    /* renamed from: b, reason: collision with root package name */
    public long f4305b;

    /* renamed from: c, reason: collision with root package name */
    public final androidx.activity.result.b<Intent> f4306c;

    /* renamed from: d, reason: collision with root package name */
    public final androidx.activity.result.b<Intent> f4307d;

    /* compiled from: SetDefaultDialerFragment.kt */
    /* loaded from: classes3.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }
    }

    public d() {
        androidx.activity.result.b<Intent> registerForActivityResult = registerForActivityResult(new C0543d(), new androidx.activity.result.a() { // from class: X6.b
            @Override // androidx.activity.result.a
            public final void a(Object obj) {
                d.f1(d.this, (ActivityResult) obj);
            }
        });
        i.e(registerForActivityResult, "registerForActivityResul…        }\n        }\n    }");
        this.f4306c = registerForActivityResult;
        androidx.activity.result.b<Intent> registerForActivityResult2 = registerForActivityResult(new C0543d(), new androidx.activity.result.a() { // from class: X6.c
            @Override // androidx.activity.result.a
            public final void a(Object obj) {
                d.e1(d.this, (ActivityResult) obj);
            }
        });
        i.e(registerForActivityResult2, "registerForActivityResul…        }\n        }\n    }");
        this.f4307d = registerForActivityResult2;
    }

    public static final void e1(d this$0, ActivityResult activityResult) {
        i.f(this$0, "this$0");
        FragmentActivity activity = this$0.getActivity();
        if (activity != null) {
            String a10 = P7.d.a(activity);
            H7.b.e("SetDefaultDialerFragment", "activityLauncher defaultDialerPackage: " + a10);
            if (i.b(activity.getPackageName(), a10)) {
                this$0.g1(activity);
            } else if (Math.abs(System.currentTimeMillis() - this$0.f4305b) <= 500) {
                this$0.f4306c.a(new Intent("android.settings.MANAGE_DEFAULT_APPS_SETTINGS"));
                H7.b.e("SetDefaultDialerFragment", "activityLauncher ACTION_MANAGE_DEFAULT_APPS_SETTINGS ");
            }
        }
    }

    public static final void f1(d this$0, ActivityResult activityResult) {
        i.f(this$0, "this$0");
        FragmentActivity activity = this$0.getActivity();
        if (activity != null) {
            String a10 = P7.d.a(activity);
            H7.b.e("SetDefaultDialerFragment", "activityLauncherSettings defaultDialerPackage: " + a10);
            if (i.b(activity.getPackageName(), a10)) {
                this$0.g1(activity);
            }
        }
    }

    public final void g1(Activity activity) {
        SetDefaultImpl.f27800e.a().f(activity);
        e.b(activity);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        RoleManager roleManager;
        if (view != null && view.getId() == W6.a.f4213c) {
            FragmentActivity activity = getActivity();
            if (activity != null) {
                roleManager = (RoleManager) activity.getSystemService(RoleManager.class);
            } else {
                roleManager = null;
            }
            if (roleManager != null && roleManager.isRoleAvailable("android.app.role.DIALER")) {
                Intent createRequestRoleIntent = roleManager.createRequestRoleIntent("android.app.role.DIALER");
                i.e(createRequestRoleIntent, "roleManager.createReques…_DIALER\n                )");
                this.f4305b = System.currentTimeMillis();
                this.f4307d.a(createRequestRoleIntent);
                return;
            }
            H7.b.c("SetDefaultDialerFragment", "onClick set_as_default isRoleAvailable: false");
        }
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration newConfig) {
        i.f(newConfig, "newConfig");
        super.onConfigurationChanged(newConfig);
        SingleButtonWrap singleButtonWrap = this.f4304a;
        if (singleButtonWrap != null) {
            singleButtonWrap.onConfigurationChanged(newConfig);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        i.f(inflater, "inflater");
        View view = inflater.inflate(W6.b.f4216b, viewGroup, false);
        COUIButton cOUIButton = (COUIButton) view.findViewById(W6.a.f4213c);
        if (cOUIButton != null) {
            this.f4304a = new SingleButtonWrap(cOUIButton, 0);
            cOUIButton.setOnClickListener(this);
        }
        i.e(view, "view");
        return view;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        SingleButtonWrap singleButtonWrap = this.f4304a;
        if (singleButtonWrap != null) {
            singleButtonWrap.release();
        }
    }
}
