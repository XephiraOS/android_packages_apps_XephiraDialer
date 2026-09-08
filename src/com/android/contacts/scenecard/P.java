package com.android.contacts.scenecard;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import c.C0541b;
import com.android.contacts.framework.baseui.util.NumberIdentifyUtils;
import com.android.contacts.framework.baseui.util.StatementUtils;
import com.android.contacts.scenecard.P;
import com.coui.appcompat.button.COUIButton;
import com.coui.appcompat.panel.COUIBottomSheetDialog;
import com.coui.appcompat.statement.COUIUserStatementDialog;
import com.customize.contacts.FeatureOption;
import com.oplus.dialer.R;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import kotlin.Pair;
import x0.AbstractC1662B;

/* compiled from: SceneGrantFragment.kt */
/* loaded from: classes.dex */
public final class P extends Fragment {

    /* renamed from: j, reason: collision with root package name */
    public static final a f17092j = new a(null);

    /* renamed from: b, reason: collision with root package name */
    public Dialog f17094b;

    /* renamed from: c, reason: collision with root package name */
    public Dialog f17095c;

    /* renamed from: d, reason: collision with root package name */
    public Dialog f17096d;

    /* renamed from: e, reason: collision with root package name */
    public String f17097e;

    /* renamed from: f, reason: collision with root package name */
    public AbstractC1662B f17098f;

    /* renamed from: g, reason: collision with root package name */
    public InterfaceC0667a f17099g;

    /* renamed from: i, reason: collision with root package name */
    public final androidx.activity.result.b<String[]> f17101i;

    /* renamed from: a, reason: collision with root package name */
    public int f17093a = -1;

    /* renamed from: h, reason: collision with root package name */
    public final Handler f17100h = new Handler(Looper.getMainLooper());

    /* compiled from: SceneGrantFragment.kt */
    /* loaded from: classes.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.f fVar) {
            this();
        }
    }

    /* compiled from: SceneGrantFragment.kt */
    /* loaded from: classes.dex */
    public static final class b implements COUIUserStatementDialog.OnButtonClickListener {
        public b() {
        }

        public static final void c(P this$0, DialogInterface dialogInterface) {
            kotlin.jvm.internal.i.f(this$0, "this$0");
            this$0.C1(true, true);
        }

        public static final void d(P this$0, DialogInterface dialogInterface) {
            kotlin.jvm.internal.i.f(this$0, "this$0");
            this$0.C1(true, true);
        }

        @Override // com.coui.appcompat.statement.COUIUserStatementDialog.OnButtonClickListener
        public void onBottomButtonClick() {
            Context requireContext = P.this.requireContext();
            kotlin.jvm.internal.i.e(requireContext, "requireContext()");
            StatementUtils.d(requireContext, true);
            Dialog dialog = P.this.f17095c;
            if (dialog != null) {
                final P p10 = P.this;
                dialog.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.android.contacts.scenecard.Q
                    @Override // android.content.DialogInterface.OnDismissListener
                    public final void onDismiss(DialogInterface dialogInterface) {
                        P.b.c(P.this, dialogInterface);
                    }
                });
            }
            Dialog dialog2 = P.this.f17095c;
            if (dialog2 != null) {
                dialog2.dismiss();
            }
            P.this.f17095c = null;
        }

        @Override // com.coui.appcompat.statement.COUIUserStatementDialog.OnButtonClickListener
        public void onExitButtonClick() {
            Context requireContext = P.this.requireContext();
            kotlin.jvm.internal.i.e(requireContext, "requireContext()");
            StatementUtils.d(requireContext, false);
            Dialog dialog = P.this.f17095c;
            if (dialog != null) {
                final P p10 = P.this;
                dialog.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.android.contacts.scenecard.S
                    @Override // android.content.DialogInterface.OnDismissListener
                    public final void onDismiss(DialogInterface dialogInterface) {
                        P.b.d(P.this, dialogInterface);
                    }
                });
            }
            Dialog dialog2 = P.this.f17095c;
            if (dialog2 != null) {
                dialog2.dismiss();
            }
            P.this.f17095c = null;
        }
    }

    /* compiled from: SceneGrantFragment.kt */
    /* loaded from: classes.dex */
    public static final class c implements COUIUserStatementDialog.OnButtonClickListener {
        public c() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void c(P this$0, DialogInterface dialogInterface) {
            kotlin.jvm.internal.i.f(this$0, "this$0");
            this$0.C1(true, true);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void d(P this$0, DialogInterface dialogInterface) {
            kotlin.jvm.internal.i.f(this$0, "this$0");
            this$0.C1(true, true);
        }

        @Override // com.coui.appcompat.statement.COUIUserStatementDialog.OnButtonClickListener
        public void onBottomButtonClick() {
            Context requireContext = P.this.requireContext();
            kotlin.jvm.internal.i.e(requireContext, "requireContext()");
            StatementUtils.d(requireContext, true);
            Dialog dialog = P.this.f17095c;
            if (dialog != null) {
                final P p10 = P.this;
                dialog.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.android.contacts.scenecard.U
                    @Override // android.content.DialogInterface.OnDismissListener
                    public final void onDismiss(DialogInterface dialogInterface) {
                        P.c.c(P.this, dialogInterface);
                    }
                });
            }
            Dialog dialog2 = P.this.f17095c;
            if (dialog2 != null) {
                dialog2.dismiss();
            }
            P.this.f17095c = null;
        }

        @Override // com.coui.appcompat.statement.COUIUserStatementDialog.OnButtonClickListener
        public void onExitButtonClick() {
            androidx.preference.j.b(P.this.requireContext()).edit().putInt("identify_unfamiliar_number_recognition_dialog", 0).apply();
            Context requireContext = P.this.requireContext();
            kotlin.jvm.internal.i.e(requireContext, "requireContext()");
            NumberIdentifyUtils.n(requireContext, 0, null, null, false, 28, null);
            Dialog dialog = P.this.f17095c;
            if (dialog != null) {
                final P p10 = P.this;
                dialog.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.android.contacts.scenecard.T
                    @Override // android.content.DialogInterface.OnDismissListener
                    public final void onDismiss(DialogInterface dialogInterface) {
                        P.c.d(P.this, dialogInterface);
                    }
                });
            }
            Dialog dialog2 = P.this.f17095c;
            if (dialog2 != null) {
                dialog2.dismiss();
            }
            P.this.f17095c = null;
        }
    }

    /* compiled from: SceneGrantFragment.kt */
    /* loaded from: classes.dex */
    public static final class d implements COUIUserStatementDialog.OnButtonClickListener {
        public d() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void b(P this$0, DialogInterface dialogInterface) {
            kotlin.jvm.internal.i.f(this$0, "this$0");
            P.D1(this$0, true, false, 2, null);
        }

        @Override // com.coui.appcompat.statement.COUIUserStatementDialog.OnButtonClickListener
        public void onBottomButtonClick() {
            Context requireContext = P.this.requireContext();
            kotlin.jvm.internal.i.e(requireContext, "requireContext()");
            StatementUtils.e(requireContext, true);
            Dialog dialog = P.this.f17094b;
            if (dialog != null) {
                final P p10 = P.this;
                dialog.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.android.contacts.scenecard.V
                    @Override // android.content.DialogInterface.OnDismissListener
                    public final void onDismiss(DialogInterface dialogInterface) {
                        P.d.b(P.this, dialogInterface);
                    }
                });
            }
            Dialog dialog2 = P.this.f17094b;
            if (dialog2 != null) {
                dialog2.dismiss();
            }
            P.this.f17094b = null;
        }

        @Override // com.coui.appcompat.statement.COUIUserStatementDialog.OnButtonClickListener
        public void onExitButtonClick() {
            Context requireContext = P.this.requireContext();
            kotlin.jvm.internal.i.e(requireContext, "requireContext()");
            StatementUtils.e(requireContext, false);
            Dialog dialog = P.this.f17094b;
            if (dialog != null) {
                dialog.dismiss();
            }
            P.this.f17094b = null;
            FragmentActivity activity = P.this.getActivity();
            if (activity != null) {
                activity.finish();
            }
        }
    }

    public P() {
        androidx.activity.result.b<String[]> registerForActivityResult = registerForActivityResult(new C0541b(), new androidx.activity.result.a() { // from class: com.android.contacts.scenecard.G
            @Override // androidx.activity.result.a
            public final void a(Object obj) {
                P.M1(P.this, (Map) obj);
            }
        });
        kotlin.jvm.internal.i.e(registerForActivityResult, "registerForActivityResul…        }\n        }\n    }");
        this.f17101i = registerForActivityResult;
    }

    public static final void A1(P this$0) {
        kotlin.jvm.internal.i.f(this$0, "this$0");
        Dialog dialog = this$0.f17095c;
        if (dialog != null) {
            dialog.dismiss();
        }
        this$0.f17095c = null;
        FragmentActivity activity = this$0.getActivity();
        if (activity != null) {
            activity.finish();
        }
    }

    public static final void B1(P this$0) {
        kotlin.jvm.internal.i.f(this$0, "this$0");
        InterfaceC0667a interfaceC0667a = this$0.f17099g;
        if (interfaceC0667a != null) {
            interfaceC0667a.q();
        }
    }

    public static /* synthetic */ void D1(P p10, boolean z10, boolean z11, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            z10 = false;
        }
        if ((i10 & 2) != 0) {
            z11 = false;
        }
        p10.C1(z10, z11);
    }

    public static final void E1(final P this$0, View view) {
        kotlin.jvm.internal.i.f(this$0, "this$0");
        this$0.C1(true, true);
        this$0.f17100h.postDelayed(new Runnable() { // from class: com.android.contacts.scenecard.H
            @Override // java.lang.Runnable
            public final void run() {
                P.this.t1();
            }
        }, 1, 200L);
    }

    public static final void J1(P this$0) {
        kotlin.jvm.internal.i.f(this$0, "this$0");
        FragmentActivity activity = this$0.getActivity();
        if (activity != null) {
            activity.finish();
        }
    }

    public static final void K1(P this$0) {
        kotlin.jvm.internal.i.f(this$0, "this$0");
        InterfaceC0667a interfaceC0667a = this$0.f17099g;
        if (interfaceC0667a != null) {
            interfaceC0667a.q();
        }
    }

    public static final void M1(P this$0, Map permissionGrantStates) {
        String str;
        kotlin.jvm.internal.i.f(this$0, "this$0");
        H7.b.e("SceneGrantFragment", "systemPermissionLauncher " + permissionGrantStates);
        if (permissionGrantStates.isEmpty()) {
            H7.b.i("SceneGrantFragment", "permissionGrantStates is empty");
            return;
        }
        kotlin.jvm.internal.i.e(permissionGrantStates, "permissionGrantStates");
        if (!permissionGrantStates.isEmpty()) {
            Iterator it = permissionGrantStates.entrySet().iterator();
            while (it.hasNext()) {
                if (!((Boolean) ((Map.Entry) it.next()).getValue()).booleanValue()) {
                    Iterator it2 = permissionGrantStates.entrySet().iterator();
                    do {
                        str = null;
                        if (!it2.hasNext()) {
                            break;
                        }
                        Map.Entry entry = (Map.Entry) it2.next();
                        if (!((Boolean) entry.getValue()).booleanValue()) {
                            str = (String) entry.getKey();
                        }
                    } while (str == null);
                    if (str != null && str.length() != 0) {
                        this$0.u1(str);
                        return;
                    } else {
                        H7.b.i("SceneGrantFragment", "unGrantPermission is null");
                        return;
                    }
                }
            }
        }
        this$0.s1();
    }

    public static final void v1(P this$0, String unGrantPermission) {
        kotlin.jvm.internal.i.f(this$0, "this$0");
        kotlin.jvm.internal.i.f(unGrantPermission, "$unGrantPermission");
        this$0.F1();
        InterfaceC0667a interfaceC0667a = this$0.f17099g;
        if (interfaceC0667a != null) {
            interfaceC0667a.q();
        }
        C0672f c0672f = C0672f.f17272a;
        Context requireContext = this$0.requireContext();
        kotlin.jvm.internal.i.e(requireContext, "requireContext()");
        Pair<Intent, Bundle> a10 = c0672f.a(requireContext, 1, 5, R.string.set_for_use_function);
        Intent a11 = a10.a();
        Bundle b10 = a10.b();
        a11.putExtra("ungranted_permission", unGrantPermission);
        R7.b.e(this$0.getContext(), a11, 0, b10);
    }

    public static final void w1(P this$0) {
        kotlin.jvm.internal.i.f(this$0, "this$0");
        this$0.F1();
        this$0.f17096d = null;
        this$0.f17097e = null;
    }

    public static final void y1(P this$0) {
        kotlin.jvm.internal.i.f(this$0, "this$0");
        InterfaceC0667a interfaceC0667a = this$0.f17099g;
        if (interfaceC0667a != null) {
            interfaceC0667a.q();
        }
    }

    public final void C1(boolean z10, boolean z11) {
        COUIButton cOUIButton;
        COUIButton cOUIButton2;
        TextView textView;
        COUIButton cOUIButton3;
        TextView textView2;
        COUIButton cOUIButton4;
        TextView textView3;
        if (!z10 && L1()) {
            this.f17093a = 0;
            AbstractC1662B abstractC1662B = this.f17098f;
            if (abstractC1662B != null && (textView3 = abstractC1662B.f37659J) != null) {
                textView3.setText(R.string.pls_view_user_notice);
            }
            AbstractC1662B abstractC1662B2 = this.f17098f;
            if (abstractC1662B2 != null && (cOUIButton4 = abstractC1662B2.f37656G) != null) {
                cOUIButton4.setText(R.string.to_view);
            }
            H7.b.e("SceneGrantFragment", "showUserNoticeDialog");
            return;
        }
        if (!z11 && G1()) {
            this.f17093a = 1;
            AbstractC1662B abstractC1662B3 = this.f17098f;
            if (abstractC1662B3 != null && (textView2 = abstractC1662B3.f37659J) != null) {
                textView2.setText(R.string.open_number_recognition);
            }
            AbstractC1662B abstractC1662B4 = this.f17098f;
            if (abstractC1662B4 != null && (cOUIButton3 = abstractC1662B4.f37656G) != null) {
                cOUIButton3.setText(R.string.to_open);
            }
            H7.b.e("SceneGrantFragment", "showNumberRecognitionNoticeDialog");
            return;
        }
        if (H1()) {
            this.f17093a = 2;
            AbstractC1662B abstractC1662B5 = this.f17098f;
            if (abstractC1662B5 != null && (textView = abstractC1662B5.f37659J) != null) {
                textView.setText(R.string.need_grant_permission_to_use);
            }
            AbstractC1662B abstractC1662B6 = this.f17098f;
            if (abstractC1662B6 != null && (cOUIButton2 = abstractC1662B6.f37656G) != null) {
                cOUIButton2.setText(R.string.to_grant);
            }
            AbstractC1662B abstractC1662B7 = this.f17098f;
            if (abstractC1662B7 != null && (cOUIButton = abstractC1662B7.f37656G) != null) {
                cOUIButton.setOnClickListener(new View.OnClickListener() { // from class: com.android.contacts.scenecard.F
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        P.E1(P.this, view);
                    }
                });
            }
            H7.b.e("SceneGrantFragment", "showPermissionDialog");
            return;
        }
        s1();
    }

    public final void F1() {
        this.f17100h.removeMessages(1);
        AbstractC1662B abstractC1662B = this.f17098f;
        if (abstractC1662B != null) {
            COUIButton cOUIButton = abstractC1662B.f37656G;
            kotlin.jvm.internal.i.e(cOUIButton, "binding.actionView");
            cOUIButton.setVisibility(0);
            ImageView imageView = abstractC1662B.f37657H;
            kotlin.jvm.internal.i.e(imageView, "binding.imageView");
            imageView.setVisibility(0);
            TextView textView = abstractC1662B.f37659J;
            kotlin.jvm.internal.i.e(textView, "binding.permissionOrStatementHint");
            textView.setVisibility(0);
        }
    }

    public final boolean G1() {
        if (SceneStatementAndPermissionChecker.f17245a.i()) {
            if (FeatureOption.i()) {
                x1();
            } else {
                z1();
            }
            return true;
        }
        Dialog dialog = this.f17095c;
        if (dialog != null) {
            dialog.dismiss();
        }
        this.f17095c = null;
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean H1() {
        if (FeatureOption.o()) {
            return false;
        }
        if (SceneStatementAndPermissionChecker.f17245a.f() && requireContext().checkSelfPermission("android.permission.READ_PHONE_NUMBERS") == 0) {
            return false;
        }
        ArrayList arrayList = new ArrayList();
        String[] g10 = com.android.contacts.util.w.g();
        kotlin.jvm.internal.i.e(g10, "getPermissions()");
        for (String permission : g10) {
            if (!com.android.contacts.util.w.k(requireContext(), permission)) {
                kotlin.jvm.internal.i.e(permission, "permission");
                arrayList.add(permission);
            }
        }
        H7.b.e("SceneGrantFragment", "unsatisfiedPermissions : " + arrayList);
        this.f17101i.a(arrayList.toArray(new String[0]));
        return true;
    }

    public final void I1() {
        Dialog dialog = this.f17094b;
        if (dialog == null || !dialog.isShowing()) {
            d dVar = new d();
            E e10 = E.f17080a;
            Context requireContext = requireContext();
            kotlin.jvm.internal.i.e(requireContext, "requireContext()");
            COUIBottomSheetDialog A10 = e10.A(requireContext, new Runnable() { // from class: com.android.contacts.scenecard.L
                @Override // java.lang.Runnable
                public final void run() {
                    P.J1(P.this);
                }
            }, dVar, new Runnable() { // from class: com.android.contacts.scenecard.M
                @Override // java.lang.Runnable
                public final void run() {
                    P.K1(P.this);
                }
            });
            this.f17094b = A10;
            if (A10 != null) {
                A10.show();
            }
        }
    }

    public final boolean L1() {
        if (SceneStatementAndPermissionChecker.f17245a.k()) {
            I1();
            return true;
        }
        Dialog dialog = this.f17094b;
        if (dialog != null) {
            dialog.dismiss();
        }
        this.f17094b = null;
        return false;
    }

    @Override // androidx.fragment.app.Fragment
    public void dump(String prefix, FileDescriptor fileDescriptor, PrintWriter writer, String[] strArr) {
        kotlin.jvm.internal.i.f(prefix, "prefix");
        kotlin.jvm.internal.i.f(writer, "writer");
        super.dump(prefix, fileDescriptor, writer, strArr);
        writer.println(prefix + " grantStage: " + this.f17093a);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        InterfaceC0667a interfaceC0667a;
        kotlin.jvm.internal.i.f(context, "context");
        super.onAttach(context);
        if (context instanceof InterfaceC0667a) {
            interfaceC0667a = (InterfaceC0667a) context;
        } else {
            interfaceC0667a = null;
        }
        this.f17099g = interfaceC0667a;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        kotlin.jvm.internal.i.f(inflater, "inflater");
        AbstractC1662B i12 = AbstractC1662B.i1(inflater, viewGroup, false);
        kotlin.jvm.internal.i.e(i12, "inflate(inflater, container, false)");
        this.f17098f = i12;
        X x10 = X.f17252a;
        x10.b(i12.f37660K);
        TextView textView = i12.f37660K;
        kotlin.jvm.internal.i.e(textView, "binding.title");
        x10.c(textView);
        t1();
        View K02 = i12.K0();
        kotlin.jvm.internal.i.e(K02, "binding.root");
        return K02;
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        H7.b.e("SceneGrantFragment", "onResume");
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        H7.b.e("SceneGrantFragment", "onStart");
        D1(this, false, false, 3, null);
    }

    public final int r1() {
        return this.f17093a;
    }

    public final void s1() {
        InterfaceC0667a interfaceC0667a;
        Context context = getContext();
        if (context != null) {
            X.a.b(context).d(new Intent("com.android.contacts.action.SCENE_GRANT_DONE"));
        }
        t1();
        this.f17093a = 4;
        H7.b.e("SceneGrantFragment", "grantDone");
        Dialog dialog = this.f17094b;
        if (dialog != null) {
            dialog.dismiss();
        }
        Dialog dialog2 = this.f17095c;
        if (dialog2 != null) {
            dialog2.dismiss();
        }
        Dialog dialog3 = this.f17096d;
        if (dialog3 != null) {
            dialog3.dismiss();
        }
        LayoutInflater.Factory activity = getActivity();
        if (activity instanceof InterfaceC0667a) {
            interfaceC0667a = (InterfaceC0667a) activity;
        } else {
            interfaceC0667a = null;
        }
        if (interfaceC0667a != null) {
            interfaceC0667a.E();
        }
    }

    public final void t1() {
        AbstractC1662B abstractC1662B = this.f17098f;
        if (abstractC1662B != null) {
            COUIButton cOUIButton = abstractC1662B.f37656G;
            kotlin.jvm.internal.i.e(cOUIButton, "binding.actionView");
            cOUIButton.setVisibility(8);
            ImageView imageView = abstractC1662B.f37657H;
            kotlin.jvm.internal.i.e(imageView, "binding.imageView");
            imageView.setVisibility(8);
            TextView textView = abstractC1662B.f37659J;
            kotlin.jvm.internal.i.e(textView, "binding.permissionOrStatementHint");
            textView.setVisibility(8);
        }
    }

    public final void u1(final String str) {
        this.f17093a = 3;
        Dialog dialog = this.f17096d;
        if (dialog != null && dialog.isShowing() && kotlin.jvm.internal.i.b(this.f17097e, str)) {
            H7.b.e("SceneGrantFragment", "permission dialog is showing");
            return;
        }
        Dialog dialog2 = this.f17096d;
        if (dialog2 != null) {
            dialog2.dismiss();
        }
        this.f17097e = str;
        E e10 = E.f17080a;
        Context requireContext = requireContext();
        Runnable runnable = new Runnable() { // from class: com.android.contacts.scenecard.N
            @Override // java.lang.Runnable
            public final void run() {
                P.w1(P.this);
            }
        };
        Runnable runnable2 = new Runnable() { // from class: com.android.contacts.scenecard.O
            @Override // java.lang.Runnable
            public final void run() {
                P.v1(P.this, str);
            }
        };
        kotlin.jvm.internal.i.e(requireContext, "requireContext()");
        Dialog w10 = e10.w(requireContext, str, runnable2, runnable);
        this.f17096d = w10;
        if (w10 != null) {
            w10.show();
        }
    }

    public final void x1() {
        Dialog dialog = this.f17095c;
        if (dialog == null || !dialog.isShowing()) {
            b bVar = new b();
            E e10 = E.f17080a;
            Context requireContext = requireContext();
            kotlin.jvm.internal.i.e(requireContext, "requireContext()");
            COUIBottomSheetDialog n10 = e10.n(requireContext, null, bVar, new Runnable() { // from class: com.android.contacts.scenecard.K
                @Override // java.lang.Runnable
                public final void run() {
                    P.y1(P.this);
                }
            });
            this.f17095c = n10;
            if (n10 != null) {
                n10.show();
            }
        }
    }

    public final void z1() {
        Dialog dialog = this.f17095c;
        if (dialog == null || !dialog.isShowing()) {
            c cVar = new c();
            E e10 = E.f17080a;
            Context requireContext = requireContext();
            kotlin.jvm.internal.i.e(requireContext, "requireContext()");
            COUIBottomSheetDialog s10 = e10.s(requireContext, cVar, new Runnable() { // from class: com.android.contacts.scenecard.I
                @Override // java.lang.Runnable
                public final void run() {
                    P.A1(P.this);
                }
            }, new Runnable() { // from class: com.android.contacts.scenecard.J
                @Override // java.lang.Runnable
                public final void run() {
                    P.B1(P.this);
                }
            });
            this.f17095c = s10;
            if (s10 != null) {
                s10.show();
            }
        }
    }
}
