package com.oplus.blacklistapp.callintercept.settings;

import android.app.Dialog;
import android.content.ContentResolver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.database.ContentObserver;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.COUIRecyclerView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.coui.appcompat.checkbox.COUICheckBox;
import com.coui.appcompat.contextutil.COUIContextUtil;
import com.coui.appcompat.couiswitch.COUISwitch;
import com.coui.appcompat.dialog.COUIAlertDialogBuilder;
import com.coui.appcompat.seekbar.COUISeekBar;
import com.oplus.blacklistapp.callintercept.settings.l;
import com.oplus.common.data.SettingsWrapper$Global;
import com.oplus.utils.C0844e;
import com.oplus.utils.C0846g;
import com.oplus.utils.C0849j;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.text.StringsKt__StringsKt;
import kotlinx.coroutines.C1248i;
import kotlinx.coroutines.F;
import v6.C1632f;
import v9.InterfaceC1637a;

/* compiled from: CallHarassInterceptMarkedNumberFragment.kt */
/* loaded from: classes3.dex */
public final class CallHarassInterceptMarkedNumberFragment extends Fragment implements l.g {

    /* renamed from: n, reason: collision with root package name */
    public static final a f26764n = new a(null);

    /* renamed from: a, reason: collision with root package name */
    public COUIRecyclerView f26765a;

    /* renamed from: b, reason: collision with root package name */
    public LayoutInflater f26766b;

    /* renamed from: c, reason: collision with root package name */
    public l f26767c;

    /* renamed from: e, reason: collision with root package name */
    public COUIRecyclerView f26769e;

    /* renamed from: f, reason: collision with root package name */
    public int f26770f;

    /* renamed from: h, reason: collision with root package name */
    public ContentObserver f26772h;

    /* renamed from: i, reason: collision with root package name */
    public SharedPreferences.OnSharedPreferenceChangeListener f26773i;

    /* renamed from: l, reason: collision with root package name */
    public Dialog f26776l;

    /* renamed from: d, reason: collision with root package name */
    public ArrayList<f> f26768d = new ArrayList<>();

    /* renamed from: g, reason: collision with root package name */
    public final A f26771g = new A();

    /* renamed from: j, reason: collision with root package name */
    public int f26774j = 1;

    /* renamed from: k, reason: collision with root package name */
    public final List<Integer> f26775k = y1();

    /* renamed from: m, reason: collision with root package name */
    public Handler f26777m = new c(Looper.getMainLooper());

    /* compiled from: CallHarassInterceptMarkedNumberFragment.kt */
    /* loaded from: classes3.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.f fVar) {
            this();
        }
    }

    /* compiled from: CallHarassInterceptMarkedNumberFragment.kt */
    /* loaded from: classes3.dex */
    public static final class c extends Handler {
        public c(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message msg) {
            kotlin.jvm.internal.i.f(msg, "msg");
            if (!CallHarassInterceptMarkedNumberFragment.this.isAdded()) {
                return;
            }
            int i10 = msg.what;
            if (i10 == 101) {
                CallHarassInterceptMarkedNumberFragment.this.F1();
                CallHarassInterceptMarkedNumberFragment.this.M1();
                C0849j.z(CallHarassInterceptMarkedNumberFragment.this.getActivity());
            } else {
                Log.w("CallHarassInterceptMarkedNumberFragment", "Message not expected: " + i10);
            }
        }
    }

    /* compiled from: CallHarassInterceptMarkedNumberFragment.kt */
    /* loaded from: classes3.dex */
    public static final class d extends ContentObserver {
        public d(Handler handler) {
            super(handler);
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean z10, Uri uri) {
            super.onChange(z10, uri);
            CallHarassInterceptMarkedNumberFragment.this.f26777m.removeMessages(101);
            CallHarassInterceptMarkedNumberFragment.this.f26777m.sendEmptyMessageDelayed(101, 200L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String B1(String str) {
        if (kotlin.jvm.internal.i.b(str, getString(com.oplus.blacklistapp.u.f27675q)) || kotlin.jvm.internal.i.b(str, getString(com.oplus.blacklistapp.u.f27501C1))) {
            String HARASS_INTERCEPT_MARK_NUMBER_FRAUD_KEY = C1632f.f37455i;
            kotlin.jvm.internal.i.e(HARASS_INTERCEPT_MARK_NUMBER_FRAUD_KEY, "HARASS_INTERCEPT_MARK_NUMBER_FRAUD_KEY");
            return HARASS_INTERCEPT_MARK_NUMBER_FRAUD_KEY;
        }
        if (kotlin.jvm.internal.i.b(str, getString(com.oplus.blacklistapp.u.f27497B1))) {
            String HARASS_INTERCEPT_MARK_HARASSMENT_KEY = C1632f.f37456j;
            kotlin.jvm.internal.i.e(HARASS_INTERCEPT_MARK_HARASSMENT_KEY, "HARASS_INTERCEPT_MARK_HARASSMENT_KEY");
            return HARASS_INTERCEPT_MARK_HARASSMENT_KEY;
        }
        if (kotlin.jvm.internal.i.b(str, getString(com.oplus.blacklistapp.u.f27722z1))) {
            String HARASS_INTERCEPT_MARK_ADVERTISING_KEY = C1632f.f37457k;
            kotlin.jvm.internal.i.e(HARASS_INTERCEPT_MARK_ADVERTISING_KEY, "HARASS_INTERCEPT_MARK_ADVERTISING_KEY");
            return HARASS_INTERCEPT_MARK_ADVERTISING_KEY;
        }
        if (kotlin.jvm.internal.i.b(str, getString(com.oplus.blacklistapp.u.f27505D1))) {
            String HARASS_INTERCEPT_MARK_NUMBER_INTERMEDIARY_KEY = C1632f.f37458l;
            kotlin.jvm.internal.i.e(HARASS_INTERCEPT_MARK_NUMBER_INTERMEDIARY_KEY, "HARASS_INTERCEPT_MARK_NUMBER_INTERMEDIARY_KEY");
            return HARASS_INTERCEPT_MARK_NUMBER_INTERMEDIARY_KEY;
        }
        return "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void F1() {
        String string;
        this.f26768d.clear();
        f fVar = new f(0, null, false, null, false, false, false, 127, null);
        fVar.m(0);
        fVar.j("");
        fVar.i(false);
        fVar.o("");
        fVar.k(true);
        for (int i10 = 0; i10 < 10; i10++) {
            f a10 = fVar.a();
            if (i10 != 0) {
                if (i10 != 1) {
                    if (i10 != 2) {
                        if (i10 != 3) {
                            if (i10 != 4) {
                                if (i10 == 5) {
                                    String HARASS_INTERCEPT_MARK_NUMBER_INTERMEDIARY_KEY = C1632f.f37458l;
                                    kotlin.jvm.internal.i.e(HARASS_INTERCEPT_MARK_NUMBER_INTERMEDIARY_KEY, "HARASS_INTERCEPT_MARK_NUMBER_INTERMEDIARY_KEY");
                                    boolean H12 = H1(HARASS_INTERCEPT_MARK_NUMBER_INTERMEDIARY_KEY, 0);
                                    a10.m(1);
                                    String string2 = getString(com.oplus.blacklistapp.u.f27505D1);
                                    kotlin.jvm.internal.i.e(string2, "getString(R.string.mark_number_intermediary)");
                                    a10.j(string2);
                                    a10.i(H12);
                                    String quantityString = getResources().getQuantityString(com.oplus.blacklistapp.t.f27479a, z1(w1(a10.c()), a10.b()), Integer.valueOf(z1(w1(a10.c()), a10.b())));
                                    kotlin.jvm.internal.i.e(quantityString, "resources.getQuantityStr…nvert(content), checked))");
                                    a10.o(quantityString);
                                    a10.k(true);
                                    a10.n(true);
                                }
                            } else {
                                String HARASS_INTERCEPT_MARK_ADVERTISING_KEY = C1632f.f37457k;
                                kotlin.jvm.internal.i.e(HARASS_INTERCEPT_MARK_ADVERTISING_KEY, "HARASS_INTERCEPT_MARK_ADVERTISING_KEY");
                                boolean H13 = H1(HARASS_INTERCEPT_MARK_ADVERTISING_KEY, 0);
                                a10.m(1);
                                String string3 = getString(com.oplus.blacklistapp.u.f27722z1);
                                kotlin.jvm.internal.i.e(string3, "getString(R.string.mark_number_advertisement)");
                                a10.j(string3);
                                a10.i(H13);
                                String quantityString2 = getResources().getQuantityString(com.oplus.blacklistapp.t.f27479a, z1(w1(a10.c()), a10.b()), Integer.valueOf(z1(w1(a10.c()), a10.b())));
                                kotlin.jvm.internal.i.e(quantityString2, "resources.getQuantityStr…nvert(content), checked))");
                                a10.o(quantityString2);
                                a10.k(true);
                            }
                        } else {
                            String HARASS_INTERCEPT_MARK_HARASSMENT_KEY = C1632f.f37456j;
                            kotlin.jvm.internal.i.e(HARASS_INTERCEPT_MARK_HARASSMENT_KEY, "HARASS_INTERCEPT_MARK_HARASSMENT_KEY");
                            boolean H14 = H1(HARASS_INTERCEPT_MARK_HARASSMENT_KEY, 0);
                            a10.m(1);
                            String string4 = getString(com.oplus.blacklistapp.u.f27497B1);
                            kotlin.jvm.internal.i.e(string4, "getString(R.string.mark_number_harassment)");
                            a10.j(string4);
                            a10.i(H14);
                            String quantityString3 = getResources().getQuantityString(com.oplus.blacklistapp.t.f27479a, z1(w1(a10.c()), a10.b()), Integer.valueOf(z1(w1(a10.c()), a10.b())));
                            kotlin.jvm.internal.i.e(quantityString3, "resources.getQuantityStr…nvert(content), checked))");
                            a10.o(quantityString3);
                            a10.k(true);
                        }
                    } else {
                        String HARASS_INTERCEPT_MARK_NUMBER_FRAUD_KEY = C1632f.f37455i;
                        kotlin.jvm.internal.i.e(HARASS_INTERCEPT_MARK_NUMBER_FRAUD_KEY, "HARASS_INTERCEPT_MARK_NUMBER_FRAUD_KEY");
                        boolean H15 = H1(HARASS_INTERCEPT_MARK_NUMBER_FRAUD_KEY, 3);
                        a10.m(1);
                        if (C0844e.m(getContext())) {
                            string = getString(com.oplus.blacklistapp.u.f27501C1);
                            kotlin.jvm.internal.i.e(string, "{\n                      …                        }");
                        } else {
                            string = getString(com.oplus.blacklistapp.u.f27675q);
                            kotlin.jvm.internal.i.e(string, "{\n                      …                        }");
                        }
                        a10.j(string);
                        a10.i(H15);
                        String quantityString4 = getResources().getQuantityString(com.oplus.blacklistapp.t.f27479a, z1(w1(a10.c()), a10.b()), Integer.valueOf(z1(w1(a10.c()), a10.b())));
                        kotlin.jvm.internal.i.e(quantityString4, "resources.getQuantityStr…nvert(content), checked))");
                        a10.o(quantityString4);
                        a10.k(true);
                        a10.l(true);
                    }
                } else {
                    a10.m(0);
                    String string5 = getString(com.oplus.blacklistapp.u.f27702v1);
                    kotlin.jvm.internal.i.e(string5, "getString(R.string.interception_type)");
                    a10.j(string5);
                    a10.i(false);
                    a10.o("");
                    a10.k(true);
                }
            } else {
                boolean C10 = C1632f.C(androidx.preference.j.b(requireContext()), "harass_intercept_marked_number_v2", 3, this.f26770f);
                a10.m(4);
                String string6 = getString(com.oplus.blacklistapp.u.f27672p1);
                kotlin.jvm.internal.i.e(string6, "getString(R.string.intercept_marked_number)");
                a10.j(string6);
                a10.i(C10);
            }
            this.f26768d.add(a10);
        }
        U1();
    }

    public static final void J1(CallHarassInterceptMarkedNumberFragment this$0, SharedPreferences sharedPreferences, String str) {
        kotlin.jvm.internal.i.f(this$0, "this$0");
        if (kotlin.jvm.internal.i.b(str, "harass_intercept_marked_number_v2") || kotlin.jvm.internal.i.b(str, C1632f.f37470x) || kotlin.jvm.internal.i.b(str, C1632f.f37471y) || kotlin.jvm.internal.i.b(str, C1632f.f37472z) || kotlin.jvm.internal.i.b(str, C1632f.f37426A) || kotlin.jvm.internal.i.b(str, C1632f.f37427B) || kotlin.jvm.internal.i.b(str, C1632f.f37428C) || kotlin.jvm.internal.i.b(str, C1632f.f37429D) || kotlin.jvm.internal.i.b(str, C1632f.f37430E)) {
            this$0.f26777m.removeMessages(101);
            this$0.f26777m.sendEmptyMessageDelayed(101, 200L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void L1(String str, boolean z10, int i10) {
        int i11 = 1;
        int c10 = z6.b.c(getActivity(), 1, str, i10);
        if (this.f26770f == 1) {
            i11 = 2;
        }
        int a10 = com.oplus.blacklistapp.callintercept.a.a(c10, i11, z10);
        C0846g.i("CallHarassInterceptMarkedNumberFragment", "putIntHarassInterceptkeyValue " + str + " =  " + c10 + "mSlotId:" + this.f26770f + "   bitField:" + i11 + "  newKeyValue = " + a10);
        z6.b.k(getActivity(), 1, str, a10, 0, 16, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void M1() {
        C0846g.i("CallHarassInterceptMarkedNumberFragment", "refreshData");
        U1();
        l lVar = this.f26767c;
        if (lVar != null) {
            lVar.notifyDataSetChanged();
        }
    }

    public static final void Q1(CallHarassInterceptMarkedNumberFragment this$0, f info, int i10, String content, DialogInterface dialogInterface, int i11) {
        kotlin.jvm.internal.i.f(this$0, "this$0");
        kotlin.jvm.internal.i.f(info, "$info");
        kotlin.jvm.internal.i.f(content, "$content");
        this$0.K1(info, i10, content);
    }

    public static final void R1(CallHarassInterceptMarkedNumberFragment this$0, DialogInterface dialogInterface, int i10) {
        kotlin.jvm.internal.i.f(this$0, "this$0");
        this$0.I1();
    }

    public static final void S1(CallHarassInterceptMarkedNumberFragment this$0, String content, f info, DialogInterface dialogInterface) {
        View view;
        TextView textView;
        kotlin.jvm.internal.i.f(this$0, "this$0");
        kotlin.jvm.internal.i.f(content, "$content");
        kotlin.jvm.internal.i.f(info, "$info");
        Dialog dialog = this$0.f26776l;
        COUISeekBar cOUISeekBar = null;
        if (dialog != null) {
            view = dialog.findViewById(com.oplus.blacklistapp.p.f27324A);
        } else {
            view = null;
        }
        if (view != null) {
            textView = (TextView) view.findViewById(com.oplus.blacklistapp.p.f27424y);
        } else {
            textView = null;
        }
        int z12 = this$0.z1(this$0.w1(content), info.b());
        if (textView != null) {
            this$0.N1(textView, z12);
        }
        if (view != null) {
            cOUISeekBar = (COUISeekBar) view.findViewById(com.oplus.blacklistapp.p.f27350N);
        }
        this$0.f26774j = z12;
        if (cOUISeekBar != null) {
            cOUISeekBar.setMax(this$0.f26775k.size() - 1);
            cOUISeekBar.setProgress(this$0.A1(z12));
            if (textView != null) {
                cOUISeekBar.setOnSeekBarChangeListener(this$0.x1(textView));
            }
        }
    }

    public static final void T1(CallHarassInterceptMarkedNumberFragment this$0, DialogInterface dialogInterface) {
        kotlin.jvm.internal.i.f(this$0, "this$0");
        this$0.f26776l = null;
    }

    public final int A1(int i10) {
        return this.f26775k.indexOf(Integer.valueOf(i10));
    }

    public final String C1(String str) {
        if (kotlin.jvm.internal.i.b(str, getString(com.oplus.blacklistapp.u.f27675q)) || kotlin.jvm.internal.i.b(str, getString(com.oplus.blacklistapp.u.f27501C1))) {
            String HARASS_INTERCEPT_MARK_NUMBER_FRAUD_OLD_KEY = C1632f.f37459m;
            kotlin.jvm.internal.i.e(HARASS_INTERCEPT_MARK_NUMBER_FRAUD_OLD_KEY, "HARASS_INTERCEPT_MARK_NUMBER_FRAUD_OLD_KEY");
            return HARASS_INTERCEPT_MARK_NUMBER_FRAUD_OLD_KEY;
        }
        if (kotlin.jvm.internal.i.b(str, getString(com.oplus.blacklistapp.u.f27497B1))) {
            String HARASS_INTERCEPT_MARK_HARASSMENT_OLD_KEY = C1632f.f37460n;
            kotlin.jvm.internal.i.e(HARASS_INTERCEPT_MARK_HARASSMENT_OLD_KEY, "HARASS_INTERCEPT_MARK_HARASSMENT_OLD_KEY");
            return HARASS_INTERCEPT_MARK_HARASSMENT_OLD_KEY;
        }
        if (kotlin.jvm.internal.i.b(str, getString(com.oplus.blacklistapp.u.f27722z1))) {
            String HARASS_INTERCEPT_MARK_ADVERTISING_OLD_KEY = C1632f.f37461o;
            kotlin.jvm.internal.i.e(HARASS_INTERCEPT_MARK_ADVERTISING_OLD_KEY, "HARASS_INTERCEPT_MARK_ADVERTISING_OLD_KEY");
            return HARASS_INTERCEPT_MARK_ADVERTISING_OLD_KEY;
        }
        if (kotlin.jvm.internal.i.b(str, getString(com.oplus.blacklistapp.u.f27505D1))) {
            String HARASS_INTERCEPT_MARK_NUMBER_INTERMEDIARY_OLD_KEY = C1632f.f37462p;
            kotlin.jvm.internal.i.e(HARASS_INTERCEPT_MARK_NUMBER_INTERMEDIARY_OLD_KEY, "HARASS_INTERCEPT_MARK_NUMBER_INTERMEDIARY_OLD_KEY");
            return HARASS_INTERCEPT_MARK_NUMBER_INTERMEDIARY_OLD_KEY;
        }
        return "";
    }

    public final int D1() {
        return COUIContextUtil.getAttrColor(getContext(), X8.c.f4343B);
    }

    public final int E1(int i10) {
        if (i10 >= 0 && i10 < this.f26775k.size()) {
            return this.f26775k.get(i10).intValue();
        }
        return 1;
    }

    public final boolean G1(int i10) {
        boolean z10 = false;
        if (this.f26770f != 0 ? (i10 & 2) == 2 : (i10 & 1) == 1) {
            z10 = true;
        }
        C0846g.i("CallHarassInterceptMarkedNumberFragment", "isHarassInterceptOpen " + z10);
        return z10;
    }

    public final boolean H1(final String key, int i10) {
        int i11;
        ContentResolver contentResolver;
        kotlin.jvm.internal.i.f(key, "key");
        Context context = getContext();
        if (context != null && (contentResolver = context.getContentResolver()) != null) {
            i11 = SettingsWrapper$Global.a(contentResolver, key, i10, new InterfaceC1637a<Integer>() { // from class: com.oplus.blacklistapp.callintercept.settings.CallHarassInterceptMarkedNumberFragment$isHarassInterceptOpen$keyValue$1$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // v9.InterfaceC1637a
                /* renamed from: b, reason: merged with bridge method [inline-methods] */
                public final Integer invoke() {
                    return Integer.valueOf(z6.b.b(CallHarassInterceptMarkedNumberFragment.this.getContext(), 1, key));
                }
            });
        } else {
            i11 = i10;
        }
        C1632f.j0(getContext(), key, i11, i10);
        boolean G12 = G1(i11);
        C0846g.i("CallHarassInterceptMarkedNumberFragment", "isHarassInterceptOpen " + key + " =  " + i11 + " defaultValue = " + i10 + "  isOpen = " + G12);
        return G12;
    }

    public final void I1() {
        this.f26776l = null;
    }

    public final void K1(f fVar, int i10, String str) {
        RecyclerView.B b10;
        l.b bVar;
        MarkNumberThresholdUtil.g(this.f26770f, requireContext(), w1(str), this.f26774j, true);
        V1(fVar);
        COUIRecyclerView cOUIRecyclerView = this.f26769e;
        if (cOUIRecyclerView != null) {
            b10 = cOUIRecyclerView.findViewHolderForAdapterPosition(i10);
        } else {
            b10 = null;
        }
        if (b10 instanceof l.b) {
            bVar = (l.b) b10;
        } else {
            bVar = null;
        }
        if (bVar != null && !fVar.b()) {
            COUICheckBox f10 = bVar.f();
            if (f10 != null) {
                f10.setState(2);
            }
            fVar.i(true);
            if (!kotlin.jvm.internal.i.b(fVar.c(), getString(com.oplus.blacklistapp.u.f27675q)) && !kotlin.jvm.internal.i.b(fVar.c(), getString(com.oplus.blacklistapp.u.f27501C1))) {
                L1(B1(fVar.c()), fVar.b(), 0);
                L1(C1(fVar.c()), fVar.b(), 0);
            } else {
                L1(B1(fVar.c()), fVar.b(), 3);
                L1(C1(fVar.c()), fVar.b(), 3);
            }
        }
        this.f26776l = null;
    }

    @Override // com.oplus.blacklistapp.callintercept.settings.l.g
    public void N(int i10) {
        C1248i.d(androidx.lifecycle.p.a(this), null, null, new CallHarassInterceptMarkedNumberFragment$onMultiContentClick$1(this, i10, null), 3, null);
    }

    public final void N1(TextView textView, int i10) {
        int J10;
        String quantityString = getResources().getQuantityString(com.oplus.blacklistapp.t.f27479a, i10, Integer.valueOf(i10));
        kotlin.jvm.internal.i.e(quantityString, "resources.getQuantityStr…ld, threshold, threshold)");
        SpannableString spannableString = new SpannableString(quantityString);
        int D12 = D1();
        J10 = StringsKt__StringsKt.J(quantityString, String.valueOf(i10), 0, false, 6, null);
        if (J10 != -1) {
            spannableString.setSpan(new ForegroundColorSpan(D12), J10, String.valueOf(i10).length() + J10, 33);
        }
        textView.setText(spannableString);
    }

    public final void O1(String str, int i10) {
        Context context;
        int i11 = this.f26770f;
        FragmentActivity activity = getActivity();
        if (activity != null) {
            context = activity.getApplicationContext();
        } else {
            context = null;
        }
        MarkNumberThresholdUtil.g(i11, context, str, i10, false);
        Log.d("CallHarassInterceptMarkedNumberFragment", "Set threshold for content '" + str + "': " + i10);
    }

    public final void P1(final int i10, final String str) {
        f fVar = this.f26768d.get(i10);
        kotlin.jvm.internal.i.e(fVar, "data[position]");
        final f fVar2 = fVar;
        COUIAlertDialogBuilder cOUIAlertDialogBuilder = new COUIAlertDialogBuilder(requireContext());
        cOUIAlertDialogBuilder.setTitle((CharSequence) getString(com.oplus.blacklistapp.u.f27590Y2));
        cOUIAlertDialogBuilder.setView(com.oplus.blacklistapp.r.f27471z);
        cOUIAlertDialogBuilder.setPositiveButton(com.oplus.blacklistapp.u.f27507E, new DialogInterface.OnClickListener() { // from class: com.oplus.blacklistapp.callintercept.settings.n
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i11) {
                CallHarassInterceptMarkedNumberFragment.Q1(CallHarassInterceptMarkedNumberFragment.this, fVar2, i10, str, dialogInterface, i11);
            }
        });
        cOUIAlertDialogBuilder.setNegativeButton(com.oplus.blacklistapp.u.f27716y0, new DialogInterface.OnClickListener() { // from class: com.oplus.blacklistapp.callintercept.settings.o
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i11) {
                CallHarassInterceptMarkedNumberFragment.R1(CallHarassInterceptMarkedNumberFragment.this, dialogInterface, i11);
            }
        });
        androidx.appcompat.app.b create = cOUIAlertDialogBuilder.create();
        this.f26776l = create;
        if (create != null) {
            create.setOnShowListener(new DialogInterface.OnShowListener() { // from class: com.oplus.blacklistapp.callintercept.settings.p
                @Override // android.content.DialogInterface.OnShowListener
                public final void onShow(DialogInterface dialogInterface) {
                    CallHarassInterceptMarkedNumberFragment.S1(CallHarassInterceptMarkedNumberFragment.this, str, fVar2, dialogInterface);
                }
            });
        }
        Dialog dialog = this.f26776l;
        if (dialog != null) {
            dialog.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.oplus.blacklistapp.callintercept.settings.q
                @Override // android.content.DialogInterface.OnDismissListener
                public final void onDismiss(DialogInterface dialogInterface) {
                    CallHarassInterceptMarkedNumberFragment.T1(CallHarassInterceptMarkedNumberFragment.this, dialogInterface);
                }
            });
        }
        Dialog dialog2 = this.f26776l;
        if (dialog2 != null) {
            dialog2.show();
        }
    }

    @Override // com.oplus.blacklistapp.callintercept.settings.l.g
    public void U0(COUISwitch cOUISwitch, boolean z10) {
        kotlin.jvm.internal.i.f(cOUISwitch, "switch");
        C1248i.d(androidx.lifecycle.p.a(this), null, null, new CallHarassInterceptMarkedNumberFragment$onSwitchClick$1(this, z10, cOUISwitch, null), 3, null);
    }

    public final void U1() {
        Object obj;
        Iterator<T> it = this.f26768d.iterator();
        while (true) {
            if (it.hasNext()) {
                obj = it.next();
                if (((f) obj).e() == 4) {
                    break;
                }
            } else {
                obj = null;
                break;
            }
        }
        f fVar = (f) obj;
        boolean z10 = false;
        if (fVar != null && !fVar.b()) {
            Iterator<T> it2 = this.f26768d.iterator();
            while (it2.hasNext()) {
                ((f) it2.next()).k(false);
            }
            C0846g.i("CallHarassInterceptMarkedNumberFragment", "updateRadioButton master switch is off");
            return;
        }
        ArrayList<f> arrayList = this.f26768d;
        ArrayList arrayList2 = new ArrayList();
        for (Object obj2 : arrayList) {
            if (((f) obj2).e() == 1) {
                arrayList2.add(obj2);
            }
        }
        Iterator it3 = arrayList2.iterator();
        while (it3.hasNext()) {
            ((f) it3.next()).k(true);
        }
        Iterator<f> it4 = this.f26768d.iterator();
        while (true) {
            if (!it4.hasNext()) {
                break;
            }
            f next = it4.next();
            if (next.e() == 1 && next.b()) {
                z10 = true;
                break;
            }
        }
        Iterator<f> it5 = this.f26768d.iterator();
        while (it5.hasNext()) {
            f next2 = it5.next();
            if (next2.e() == 2 || ((next2.e() == 0 && kotlin.jvm.internal.i.b(next2.c(), getString(com.oplus.blacklistapp.u.f27670p))) || next2.e() == 3)) {
                next2.k(z10);
            }
        }
        C0846g.i("CallHarassInterceptMarkedNumberFragment", "updateRadioButton enable=" + z10);
    }

    public final void V1(f fVar) {
        int i10 = 0;
        for (Object obj : this.f26768d) {
            int i11 = i10 + 1;
            if (i10 < 0) {
                kotlin.collections.o.o();
            }
            f fVar2 = (f) obj;
            if (fVar2.e() == 1 && kotlin.jvm.internal.i.b(fVar2.c(), fVar.c())) {
                String quantityString = getResources().getQuantityString(com.oplus.blacklistapp.t.f27479a, z1(w1(fVar.c()), fVar.b()), Integer.valueOf(z1(w1(fVar.c()), fVar.b())));
                kotlin.jvm.internal.i.e(quantityString, "resources.getQuantityStr….content), info.checked))");
                fVar2.o(quantityString);
                l lVar = this.f26767c;
                if (lVar != null) {
                    lVar.notifyItemChanged(i10);
                }
            }
            i10 = i11;
        }
    }

    public final void initRecyclerView() {
        COUIRecyclerView cOUIRecyclerView;
        C0846g.i("CallHarassInterceptMarkedNumberFragment", "initRecyclerView");
        COUIRecyclerView cOUIRecyclerView2 = this.f26765a;
        l lVar = null;
        if (cOUIRecyclerView2 != null) {
            cOUIRecyclerView = (COUIRecyclerView) cOUIRecyclerView2.findViewById(com.oplus.blacklistapp.p.f27368W);
        } else {
            cOUIRecyclerView = null;
        }
        this.f26769e = cOUIRecyclerView;
        FragmentActivity activity = getActivity();
        if (activity != null) {
            lVar = new l(this.f26768d, activity, this);
        }
        this.f26767c = lVar;
        COUIRecyclerView cOUIRecyclerView3 = this.f26769e;
        if (cOUIRecyclerView3 != null) {
            cOUIRecyclerView3.setLayoutManager(new LinearLayoutManager(getActivity()));
            cOUIRecyclerView3.setNestedScrollingEnabled(true);
            cOUIRecyclerView3.setFocusable(false);
            cOUIRecyclerView3.setAdapter(this.f26767c);
        }
    }

    @Override // com.oplus.blacklistapp.callintercept.settings.l.g
    public void l0(COUICheckBox checkBox, int i10) {
        kotlin.jvm.internal.i.f(checkBox, "checkBox");
        C1248i.d(androidx.lifecycle.p.a(this), null, null, new CallHarassInterceptMarkedNumberFragment$onMultiChoiceClick$1(this, i10, checkBox, null), 3, null);
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        int i10;
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        if (arguments != null) {
            i10 = arguments.getInt("slotId");
        } else {
            i10 = 0;
        }
        this.f26770f = i10;
        C0846g.i("CallHarassInterceptMarkedNumberFragment", "slotId=" + i10);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        kotlin.jvm.internal.i.f(inflater, "inflater");
        C0846g.i("CallHarassInterceptMarkedNumberFragment", "onCreateView");
        this.f26766b = inflater;
        this.f26765a = (COUIRecyclerView) inflater.inflate(com.oplus.blacklistapp.r.f27432D, viewGroup, false);
        F1();
        initRecyclerView();
        return this.f26765a;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        this.f26771g.d();
        F.d(androidx.lifecycle.p.a(this), null, 1, null);
        super.onDestroy();
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        Context context = getContext();
        if (context != null) {
            if (this.f26773i != null) {
                androidx.preference.j.b(context).unregisterOnSharedPreferenceChangeListener(this.f26773i);
                this.f26773i = null;
            }
            ContentObserver contentObserver = this.f26772h;
            if (contentObserver != null) {
                context.getContentResolver().unregisterContentObserver(contentObserver);
                this.f26772h = null;
            }
        }
        super.onPause();
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        Context context = getContext();
        if (context != null) {
            if (this.f26773i == null) {
                this.f26773i = new SharedPreferences.OnSharedPreferenceChangeListener() { // from class: com.oplus.blacklistapp.callintercept.settings.m
                    @Override // android.content.SharedPreferences.OnSharedPreferenceChangeListener
                    public final void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
                        CallHarassInterceptMarkedNumberFragment.J1(CallHarassInterceptMarkedNumberFragment.this, sharedPreferences, str);
                    }
                };
            }
            androidx.preference.j.b(context).registerOnSharedPreferenceChangeListener(this.f26773i);
            ArrayList arrayList = new ArrayList();
            Uri uri = null;
            Uri h10 = z6.b.h(1, C1632f.f37455i, 0, 4, null);
            if (h10 != null) {
                arrayList.add(h10);
            }
            Uri h11 = z6.b.h(1, C1632f.f37456j, 0, 4, null);
            if (h11 != null) {
                arrayList.add(h11);
            }
            Uri h12 = z6.b.h(1, C1632f.f37457k, 0, 4, null);
            if (h12 != null) {
                arrayList.add(h12);
            }
            Uri h13 = z6.b.h(1, C1632f.f37458l, 0, 4, null);
            if (h13 != null) {
                arrayList.add(h13);
            }
            int i10 = this.f26770f;
            if (i10 != 0) {
                if (i10 == 1) {
                    uri = z6.b.h(1, C1632f.f37469w, 0, 4, null);
                }
            } else {
                uri = z6.b.h(1, C1632f.f37468v, 0, 4, null);
            }
            if (uri != null) {
                arrayList.add(uri);
            }
            if (!arrayList.isEmpty()) {
                if (this.f26772h == null) {
                    this.f26772h = new d(this.f26777m);
                }
                ContentObserver contentObserver = this.f26772h;
                if (contentObserver != null) {
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        context.getContentResolver().registerContentObserver((Uri) it.next(), true, contentObserver);
                    }
                }
            }
        }
        F1();
        M1();
    }

    @Override // com.oplus.blacklistapp.callintercept.settings.l.g
    public void q(RadioButton radioButton, int i10) {
        kotlin.jvm.internal.i.f(radioButton, "radioButton");
        C1248i.d(androidx.lifecycle.p.a(this), null, null, new CallHarassInterceptMarkedNumberFragment$onSingleChoiceClick$1(this, i10, radioButton, null), 3, null);
    }

    public final String w1(String str) {
        if (kotlin.jvm.internal.i.b(str, getString(com.oplus.blacklistapp.u.f27497B1))) {
            String HARASS_INTERCEPT_MARK_HARASSMENT_KEY = C1632f.f37456j;
            kotlin.jvm.internal.i.e(HARASS_INTERCEPT_MARK_HARASSMENT_KEY, "HARASS_INTERCEPT_MARK_HARASSMENT_KEY");
            return HARASS_INTERCEPT_MARK_HARASSMENT_KEY;
        }
        if (kotlin.jvm.internal.i.b(str, getString(com.oplus.blacklistapp.u.f27722z1))) {
            String HARASS_INTERCEPT_MARK_ADVERTISING_KEY = C1632f.f37457k;
            kotlin.jvm.internal.i.e(HARASS_INTERCEPT_MARK_ADVERTISING_KEY, "HARASS_INTERCEPT_MARK_ADVERTISING_KEY");
            return HARASS_INTERCEPT_MARK_ADVERTISING_KEY;
        }
        if (kotlin.jvm.internal.i.b(str, getString(com.oplus.blacklistapp.u.f27505D1))) {
            String HARASS_INTERCEPT_MARK_NUMBER_INTERMEDIARY_KEY = C1632f.f37458l;
            kotlin.jvm.internal.i.e(HARASS_INTERCEPT_MARK_NUMBER_INTERMEDIARY_KEY, "HARASS_INTERCEPT_MARK_NUMBER_INTERMEDIARY_KEY");
            return HARASS_INTERCEPT_MARK_NUMBER_INTERMEDIARY_KEY;
        }
        String HARASS_INTERCEPT_MARK_NUMBER_FRAUD_KEY = C1632f.f37455i;
        kotlin.jvm.internal.i.e(HARASS_INTERCEPT_MARK_NUMBER_FRAUD_KEY, "HARASS_INTERCEPT_MARK_NUMBER_FRAUD_KEY");
        return HARASS_INTERCEPT_MARK_NUMBER_FRAUD_KEY;
    }

    public final COUISeekBar.OnSeekBarChangeListener x1(TextView textView) {
        return new b(textView);
    }

    public final List<Integer> y1() {
        int i10;
        int i11;
        ArrayList arrayList = new ArrayList();
        int i12 = 1;
        while (true) {
            i10 = 10;
            if (i12 >= 10) {
                break;
            }
            for (int i13 = 0; i13 < 6; i13++) {
                arrayList.add(Integer.valueOf(i12));
            }
            i12++;
        }
        while (true) {
            if (i10 >= 20) {
                break;
            }
            for (int i14 = 0; i14 < 3; i14++) {
                arrayList.add(Integer.valueOf(i10));
            }
            i10++;
        }
        for (i11 = 20; i11 < 51; i11++) {
            arrayList.add(Integer.valueOf(i11));
        }
        return arrayList;
    }

    public final int z1(String str, boolean z10) {
        Context context;
        int i10 = this.f26770f;
        FragmentActivity activity = getActivity();
        Context context2 = null;
        if (activity != null) {
            context = activity.getApplicationContext();
        } else {
            context = null;
        }
        int e10 = MarkNumberThresholdUtil.e(i10, context, str);
        Log.d("CallHarassInterceptMarkedNumberFragment", "Current threshold for content '" + str + "': " + e10);
        if (e10 != 0) {
            return e10;
        }
        Log.d("CallHarassInterceptMarkedNumberFragment", "Threshold is default, isChecked: " + z10);
        if (z10) {
            try {
                int i11 = this.f26770f;
                FragmentActivity activity2 = getActivity();
                if (activity2 != null) {
                    context2 = activity2.getApplicationContext();
                }
                int d10 = MarkNumberThresholdUtil.d(i11, context2);
                C0846g.i("CallHarassInterceptMarkedNumberFragment", "Old threshold: " + d10);
                int c10 = MarkNumberThresholdUtil.c(d10);
                O1(str, c10);
                return c10;
            } catch (Exception e11) {
                C0846g.i("CallHarassInterceptMarkedNumberFragment", "Error getting new threshold: " + e11);
                O1(str, 1);
                return 1;
            }
        }
        O1(str, 1);
        return 1;
    }

    /* compiled from: CallHarassInterceptMarkedNumberFragment.kt */
    /* loaded from: classes3.dex */
    public static final class b implements COUISeekBar.OnSeekBarChangeListener {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ TextView f26779b;

        public b(TextView textView) {
            this.f26779b = textView;
        }

        @Override // com.coui.appcompat.seekbar.COUISeekBar.OnSeekBarChangeListener
        public void onProgressChanged(COUISeekBar cOUISeekBar, int i10, boolean z10) {
            int E12 = CallHarassInterceptMarkedNumberFragment.this.E1(i10);
            CallHarassInterceptMarkedNumberFragment.this.N1(this.f26779b, E12);
            CallHarassInterceptMarkedNumberFragment.this.f26774j = E12;
        }

        @Override // com.coui.appcompat.seekbar.COUISeekBar.OnSeekBarChangeListener
        public void onStartTrackingTouch(COUISeekBar cOUISeekBar) {
        }

        @Override // com.coui.appcompat.seekbar.COUISeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(COUISeekBar cOUISeekBar) {
        }
    }
}
