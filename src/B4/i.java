package b4;

import android.bluetooth.BluetoothManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.activity.result.ActivityResult;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import c.C0543d;
import com.android.contacts.framework.baseui.util.A;
import com.android.contacts.framework.baseui.util.n;
import com.android.contacts.util.w;
import com.coui.appcompat.dialog.COUIAlertDialogBuilder;
import com.customize.contacts.FeatureOption;
import com.customize.contacts.util.C0792c;
import com.oplus.dialer.R;
import com.oplus.foundation.util.OsUtils;
import com.oplus.foundation.util.display.DisplayUtil;
import java.util.ArrayList;
import java.util.HashMap;

/* compiled from: FromDeviceFragment.kt */
/* loaded from: classes3.dex */
public final class i extends Fragment {

    /* renamed from: d, reason: collision with root package name */
    public static final a f12146d = new a(null);

    /* renamed from: a, reason: collision with root package name */
    public androidx.appcompat.app.b f12147a;

    /* renamed from: b, reason: collision with root package name */
    public final androidx.activity.result.b<Intent> f12148b;

    /* renamed from: c, reason: collision with root package name */
    public final androidx.activity.result.b<Intent> f12149c;

    /* compiled from: FromDeviceFragment.kt */
    /* loaded from: classes3.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.f fVar) {
            this();
        }
    }

    public i() {
        androidx.activity.result.b<Intent> registerForActivityResult = registerForActivityResult(new C0543d(), new androidx.activity.result.a() { // from class: b4.b
            @Override // androidx.activity.result.a
            public final void a(Object obj) {
                i.t1(i.this, (ActivityResult) obj);
            }
        });
        kotlin.jvm.internal.i.e(registerForActivityResult, "registerForActivityResul…ctivity()\n        }\n    }");
        this.f12148b = registerForActivityResult;
        androidx.activity.result.b<Intent> registerForActivityResult2 = registerForActivityResult(new C0543d(), new androidx.activity.result.a() { // from class: b4.c
            @Override // androidx.activity.result.a
            public final void a(Object obj) {
                i.v1(i.this, (ActivityResult) obj);
            }
        });
        kotlin.jvm.internal.i.e(registerForActivityResult2, "registerForActivityResul…ionDialogIfNeeded()\n    }");
        this.f12149c = registerForActivityResult2;
    }

    public static final void k1(i this$0, View view) {
        kotlin.jvm.internal.i.f(this$0, "this$0");
        if (!this$0.l1(this$0.j1())) {
            this$0.u1();
        }
    }

    public static final void o1(i this$0, DialogInterface dialogInterface, int i10) {
        kotlin.jvm.internal.i.f(this$0, "this$0");
        FragmentActivity activity = this$0.getActivity();
        if (activity != null) {
            if (!OsUtils.f28275a.i() && FeatureOption.o()) {
                C0792c.q(activity);
            } else {
                Q7.c.b(this$0.f12149c, K7.b.a(activity, "android.permission.BLUETOOTH_CONNECT", FeatureOption.i()), null, 2, null);
            }
        }
    }

    public static final void q1(i this$0, DialogInterface dialogInterface) {
        kotlin.jvm.internal.i.f(this$0, "this$0");
        this$0.f12147a = null;
    }

    public static final void r1(i this$0, DialogInterface dialogInterface) {
        kotlin.jvm.internal.i.f(this$0, "this$0");
        FragmentActivity activity = this$0.getActivity();
        if (activity != null) {
            activity.finish();
        }
    }

    public static final void t1(i this$0, ActivityResult activityResult) {
        kotlin.jvm.internal.i.f(this$0, "this$0");
        if (activityResult.d() == -1) {
            this$0.u1();
        }
    }

    public static final void v1(i this$0, ActivityResult activityResult) {
        kotlin.jvm.internal.i.f(this$0, "this$0");
        this$0.s1();
    }

    public final String[] j1() {
        ArrayList arrayList = new ArrayList();
        if (OsUtils.f28275a.j()) {
            arrayList.add("android.permission.BLUETOOTH_CONNECT");
        }
        return (String[]) arrayList.toArray(new String[0]);
    }

    public final boolean l1(String[] permissions) {
        kotlin.jvm.internal.i.f(permissions, "permissions");
        ArrayList arrayList = new ArrayList();
        for (String str : permissions) {
            if (!w.k(getContext(), str)) {
                arrayList.add(str);
            }
        }
        if (arrayList.size() <= 0) {
            return false;
        }
        requestPermissions((String[]) arrayList.toArray(new String[0]), 0);
        return true;
    }

    public final void m1() {
        String str;
        String str2;
        Context context = getContext();
        if (context != null) {
            if (OsUtils.f28275a.j()) {
                int checkSelfPermission = context.checkSelfPermission("android.permission.BLUETOOTH_CONNECT");
                if (H7.a.b()) {
                    H7.b.b("FromDeviceFragment", "hasConnectPermission = " + checkSelfPermission);
                }
                if (checkSelfPermission != 0) {
                    str = getString(R.string.runtime_permission_bluetooth_scan);
                    str2 = getString(R.string.bluetooth_scan_permission_guidance_dialog_message_v2, getString(R.string.name));
                    if (TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                        n1(str, str2);
                        return;
                    }
                }
            }
            str = null;
            str2 = null;
            if (TextUtils.isEmpty(str)) {
            }
        }
    }

    public final void n1(String str, String str2) {
        TextView textView;
        androidx.appcompat.app.b bVar = this.f12147a;
        if (bVar != null && bVar.isShowing()) {
            return;
        }
        COUIAlertDialogBuilder message = new COUIAlertDialogBuilder(requireContext()).setTitle((CharSequence) str).setMessage((CharSequence) str2);
        message.setPositiveButton(R.string.oplus_button_set, new DialogInterface.OnClickListener() { // from class: b4.e
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i10) {
                i.o1(i.this, dialogInterface, i10);
            }
        });
        message.setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() { // from class: b4.f
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i10) {
                i.p1(dialogInterface, i10);
            }
        });
        message.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: b4.g
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface dialogInterface) {
                i.q1(i.this, dialogInterface);
            }
        });
        androidx.appcompat.app.b show = message.show();
        show.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: b4.h
            @Override // android.content.DialogInterface.OnCancelListener
            public final void onCancel(DialogInterface dialogInterface) {
                i.r1(i.this, dialogInterface);
            }
        });
        show.setCanceledOnTouchOutside(false);
        this.f12147a = show;
        kotlin.jvm.internal.i.c(show);
        View findViewById = show.findViewById(R.id.message);
        if (findViewById instanceof TextView) {
            textView = (TextView) findViewById;
        } else {
            textView = null;
        }
        if (textView != null) {
            textView.setGravity(17);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        ViewGroup.LayoutParams layoutParams;
        int dimensionPixelOffset;
        kotlin.jvm.internal.i.f(inflater, "inflater");
        View inflate = inflater.inflate(R.layout.from_device_layout, viewGroup, false);
        TextView textView = (TextView) inflate.findViewById(R.id.notice_title);
        if (textView != null) {
            textView.setText(R.string.open_other_device_bloothtooth_tablet);
        }
        TextView textView2 = (TextView) inflate.findViewById(R.id.notice);
        if (textView2 != null) {
            textView2.setText(getResources().getString(R.string.open_android_bluetooth_step));
        }
        Button button = (Button) inflate.findViewById(R.id.nextBtn);
        if (button != null) {
            layoutParams = button.getLayoutParams();
        } else {
            layoutParams = null;
        }
        kotlin.jvm.internal.i.d(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        if (n.b()) {
            dimensionPixelOffset = DisplayUtil.d(getContext()) + getResources().getDimensionPixelOffset(R.dimen.DP_24);
        } else {
            dimensionPixelOffset = getResources().getDimensionPixelOffset(R.dimen.DP_24);
        }
        marginLayoutParams.bottomMargin = dimensionPixelOffset;
        button.setLayoutParams(marginLayoutParams);
        button.setOnClickListener(new View.OnClickListener() { // from class: b4.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                i.k1(i.this, view);
            }
        });
        com.oplus.foundation.util.ui.d dVar = com.oplus.foundation.util.ui.d.f28372a;
        com.oplus.foundation.util.ui.d.d(textView, dVar.a());
        com.oplus.foundation.util.ui.d.d(textView2, dVar.a());
        l1(j1());
        return inflate;
    }

    @Override // androidx.fragment.app.Fragment
    public void onRequestPermissionsResult(int i10, String[] permissions, int[] grantResults) {
        boolean z10;
        kotlin.jvm.internal.i.f(permissions, "permissions");
        kotlin.jvm.internal.i.f(grantResults, "grantResults");
        super.onRequestPermissionsResult(i10, permissions, grantResults);
        if (grantResults.length == 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (!z10) {
            for (int i11 : grantResults) {
                if (i11 != 0) {
                    m1();
                    return;
                }
            }
        }
    }

    public final void s1() {
        FragmentActivity activity;
        if (OsUtils.f28275a.j() && (activity = getActivity()) != null && activity.shouldShowRequestPermissionRationale("android.permission.BLUETOOTH_CONNECT")) {
            l1(j1());
        } else {
            m1();
        }
    }

    public final void u1() {
        Context context = getContext();
        if (context != null) {
            Object systemService = context.getSystemService("bluetooth");
            kotlin.jvm.internal.i.d(systemService, "null cannot be cast to non-null type android.bluetooth.BluetoothManager");
            if (!((BluetoothManager) systemService).getAdapter().isEnabled()) {
                w1();
                return;
            }
            R7.b.f(context, new Intent("android.bluetooth.devicepicker.action.LAUNCH"), 0, null, 6, null);
            HashMap hashMap = new HashMap();
            hashMap.put("device_type", 1);
            A.a(context, 2000314, 200030182, hashMap, false);
        }
    }

    public final void w1() {
        this.f12148b.a(new Intent("android.bluetooth.adapter.action.REQUEST_ENABLE"));
    }

    public static final void p1(DialogInterface dialogInterface, int i10) {
    }
}
