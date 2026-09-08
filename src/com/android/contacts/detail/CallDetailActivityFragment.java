package com.android.contacts.detail;

import a4.C0421a;
import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.ContentUris;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.database.ContentObserver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.MessageQueue;
import android.os.Parcelable;
import android.os.Vibrator;
import android.provider.CallLog;
import android.provider.ContactsContract;
import android.telephony.SubscriptionInfo;
import android.text.TextUtils;
import android.text.format.DateFormat;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LiveData;
import com.android.contacts.ContactLoader;
import com.android.contacts.ContactsApplication;
import com.android.contacts.PhoneCallDetails;
import com.android.contacts.business.calllog.breenocall.BreenoCallContract;
import com.android.contacts.c1;
import com.android.contacts.detail.CallDetailActivityFragment;
import com.android.contacts.detail.CallDetailUnfamiliarNumberFragment;
import com.android.contacts.detail.CallLogDeleteHelper;
import com.android.contacts.detail.z0;
import com.android.contacts.framework.baseui.calllog.CallRecordingsCache;
import com.android.contacts.framework.baseui.sim.SimContactInfo;
import com.android.contacts.util.C0703d;
import com.android.contacts.util.InterfaceC0702c;
import com.android.incallui.OplusAutoRedialNotificationUI;
import com.android.incallui.OplusPhoneCapabilities;
import com.coui.appcompat.poplist.PopupListItem;
import com.coui.appcompat.scrollbar.COUIScrollBar;
import com.customize.contacts.FeatureOption;
import com.customize.contacts.activities.ContactsTabActivity;
import com.customize.contacts.activities.MoreCallLogActivity;
import com.customize.contacts.mediaplayer.RecordPlayerPresenter;
import com.customize.contacts.model.NewCallRepository;
import com.customize.contacts.util.BlackListUtils;
import com.customize.contacts.util.C0792c;
import com.customize.contacts.util.C0799j;
import com.customize.contacts.util.C0802m;
import com.customize.contacts.util.C0811w;
import com.customize.contacts.util.b0;
import com.google.android.material.appbar.AppBarLayout;
import com.oplus.dialer.R;
import com.oplus.foundation.util.display.DisplayUtil;
import com.oplus.foundation.util.feature.AppMetaFeatures;
import com.oplus.foundation.util.feature.CommonFeatureOption;
import com.oplus.foundation.util.systemcore.PrimaryUserUtils;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Result;
import kotlin.jvm.internal.Ref$ObjectRef;
import org.opencv.imgproc.Imgproc;
import w0.C1641a;
import z0.C1725e;

/* compiled from: CallDetailActivityFragment.kt */
/* loaded from: classes.dex */
public class CallDetailActivityFragment extends DetailActivityFragment {

    /* renamed from: C1, reason: collision with root package name */
    public static final b f14178C1 = new b(null);

    /* renamed from: D1, reason: collision with root package name */
    public static final String[] f14179D1 = {BreenoCallContract.BaseColumns._ID, "number", BreenoCallContract.BaseColumns.DATE, "duration", OplusAutoRedialNotificationUI.TYPE, "name", "numbertype", "numberlabel", "countryiso", "ring_time", "features", "simid", "hasRecog", "formatted_number"};

    /* renamed from: E1, reason: collision with root package name */
    public static final String[] f14180E1 = {BreenoCallContract.BaseColumns._ID, "number", BreenoCallContract.BaseColumns.DATE, "duration", OplusAutoRedialNotificationUI.TYPE, "name", "numbertype", "numberlabel", "countryiso", "ring_time", "features", "simid", "hasRecog", "formatted_number", "call_log_mapping"};

    /* renamed from: K0, reason: collision with root package name */
    public InterfaceC0702c f14185K0;

    /* renamed from: L0, reason: collision with root package name */
    public com.android.contacts.calllog.I f14186L0;

    /* renamed from: M0, reason: collision with root package name */
    public String f14187M0;

    /* renamed from: N0, reason: collision with root package name */
    public String f14188N0;

    /* renamed from: O0, reason: collision with root package name */
    public String f14189O0;

    /* renamed from: Q0, reason: collision with root package name */
    public int f14191Q0;

    /* renamed from: R0, reason: collision with root package name */
    public Uri f14192R0;

    /* renamed from: S0, reason: collision with root package name */
    public int f14193S0;

    /* renamed from: U0, reason: collision with root package name */
    public boolean f14195U0;

    /* renamed from: V0, reason: collision with root package name */
    public boolean f14196V0;

    /* renamed from: W0, reason: collision with root package name */
    public boolean f14197W0;

    /* renamed from: X0, reason: collision with root package name */
    public boolean f14198X0;

    /* renamed from: Y0, reason: collision with root package name */
    public Uri f14199Y0;

    /* renamed from: b1, reason: collision with root package name */
    public BroadcastReceiver f14202b1;

    /* renamed from: c1, reason: collision with root package name */
    public BroadcastReceiver f14203c1;

    /* renamed from: d1, reason: collision with root package name */
    public BroadcastReceiver f14204d1;

    /* renamed from: e1, reason: collision with root package name */
    public Handler f14205e1;

    /* renamed from: f1, reason: collision with root package name */
    public String f14206f1;

    /* renamed from: g1, reason: collision with root package name */
    public g f14207g1;

    /* renamed from: h1, reason: collision with root package name */
    public boolean f14208h1;

    /* renamed from: i1, reason: collision with root package name */
    public boolean f14209i1;

    /* renamed from: j1, reason: collision with root package name */
    public boolean f14210j1;

    /* renamed from: m1, reason: collision with root package name */
    public boolean f14213m1;

    /* renamed from: o1, reason: collision with root package name */
    public boolean f14215o1;

    /* renamed from: p1, reason: collision with root package name */
    public k f14216p1;

    /* renamed from: q1, reason: collision with root package name */
    public PhoneCallDetails[] f14217q1;

    /* renamed from: s1, reason: collision with root package name */
    public boolean f14219s1;

    /* renamed from: t1, reason: collision with root package name */
    public boolean f14220t1;

    /* renamed from: u1, reason: collision with root package name */
    public RecordPlayerPresenter f14221u1;

    /* renamed from: v1, reason: collision with root package name */
    public boolean f14222v1;

    /* renamed from: w1, reason: collision with root package name */
    public volatile boolean f14223w1;

    /* renamed from: I0, reason: collision with root package name */
    public long f14183I0 = -1;

    /* renamed from: J0, reason: collision with root package name */
    public long f14184J0 = -1;

    /* renamed from: P0, reason: collision with root package name */
    public long f14190P0 = -1;

    /* renamed from: T0, reason: collision with root package name */
    public long f14194T0 = -1;

    /* renamed from: Z0, reason: collision with root package name */
    public final ArrayList<b0.a> f14200Z0 = new ArrayList<>();

    /* renamed from: a1, reason: collision with root package name */
    public final HashMap<Integer, SubscriptionInfo> f14201a1 = new HashMap<>();

    /* renamed from: k1, reason: collision with root package name */
    public boolean f14211k1 = true;

    /* renamed from: l1, reason: collision with root package name */
    public boolean f14212l1 = true;

    /* renamed from: n1, reason: collision with root package name */
    public boolean f14214n1 = true;

    /* renamed from: r1, reason: collision with root package name */
    public int f14218r1 = -1;

    /* renamed from: x1, reason: collision with root package name */
    public final c1 f14224x1 = new c1();

    /* renamed from: y1, reason: collision with root package name */
    public final z0.h f14225y1 = new o();

    /* renamed from: z1, reason: collision with root package name */
    public final E f14226z1 = new p();

    /* renamed from: A1, reason: collision with root package name */
    public final ContentObserver f14181A1 = new q(new Handler());

    /* renamed from: B1, reason: collision with root package name */
    public final BroadcastReceiver f14182B1 = new BroadcastReceiver() { // from class: com.android.contacts.detail.CallDetailActivityFragment$mBroadcastReceiver$1
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            int i10;
            int i11;
            kotlin.jvm.internal.i.f(context, "context");
            kotlin.jvm.internal.i.f(intent, "intent");
            String action = intent.getAction();
            if (H7.a.b()) {
                i11 = CallDetailActivityFragment.this.f14218r1;
                H7.b.b("CallDetailActivityFragment", "onReceived action : " + action + ", mSlotId : " + i11);
            }
            if (TextUtils.equals("local.intent.action.SUBINFO_STATE_CHANGE", action) && TextUtils.equals("PLUGOUT", C7.e.l(intent, "simstate"))) {
                i10 = CallDetailActivityFragment.this.f14218r1;
                if (TextUtils.equals(String.valueOf(i10), C7.e.l(intent, "slotid"))) {
                    H7.b.e("CallDetailActivityFragment", "onReceived: mFinishInCallback : " + CallDetailActivityFragment.this.f14223w1);
                    if (!CallDetailActivityFragment.this.f14223w1) {
                        CallDetailActivityFragment.this.o1();
                    }
                }
            }
        }
    };

    /* compiled from: CallDetailActivityFragment.kt */
    /* loaded from: classes.dex */
    public enum Tasks {
        UPDATE_PHONE_CALL_DETAILS,
        UPDATE_CONTACT_DETAILS,
        UPDATE_CONTACT_AND_CALLOG,
        DELETE_CALLLOG
    }

    /* compiled from: CallDetailActivityFragment.kt */
    /* loaded from: classes.dex */
    public static final class a extends Handler {

        /* renamed from: a, reason: collision with root package name */
        public final WeakReference<CallDetailActivityFragment> f14232a;

        public a(CallDetailActivityFragment fragment) {
            kotlin.jvm.internal.i.f(fragment, "fragment");
            this.f14232a = new WeakReference<>(fragment);
        }

        @Override // android.os.Handler
        public void handleMessage(Message msg) {
            kotlin.jvm.internal.i.f(msg, "msg");
            CallDetailActivityFragment callDetailActivityFragment = this.f14232a.get();
            if (callDetailActivityFragment == null) {
                return;
            }
            int i10 = msg.what;
            if (i10 == 2) {
                callDetailActivityFragment.x6();
            } else if (i10 == 3) {
                callDetailActivityFragment.J6(true);
            }
        }
    }

    /* compiled from: CallDetailActivityFragment.kt */
    /* loaded from: classes.dex */
    public static final class b {
        public b() {
        }

        public /* synthetic */ b(kotlin.jvm.internal.f fVar) {
            this();
        }
    }

    /* compiled from: CallDetailActivityFragment.kt */
    /* loaded from: classes.dex */
    public final class c extends BroadcastReceiver {
        public c() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            kotlin.jvm.internal.i.f(context, "context");
            kotlin.jvm.internal.i.f(intent, "intent");
            if (!kotlin.jvm.internal.i.b("com.oplus.contacts.CONTACT_NOT_FIND", intent.getAction()) || CallDetailActivityFragment.this.f14208h1) {
                return;
            }
            H7.b.e("CallDetailActivityFragment", "contact not find, query contact info again");
            if (!CallDetailActivityFragment.this.f14219s1) {
                CallDetailActivityFragment.this.w4(true);
            }
            CallDetailActivityFragment.this.H6();
        }
    }

    /* compiled from: CallDetailActivityFragment.kt */
    /* loaded from: classes.dex */
    public static final class d extends com.android.contacts.util.D<Void, Void, Void, CallDetailActivityFragment> {

        /* renamed from: b, reason: collision with root package name */
        public final ArrayList<Q0.b> f14234b;

        /* renamed from: c, reason: collision with root package name */
        public final boolean f14235c;

        /* compiled from: CallDetailActivityFragment.kt */
        /* loaded from: classes.dex */
        public static final class a implements com.android.contacts.framework.baseui.util.t {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ CallDetailActivityFragment f14236a;

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ d f14237b;

            /* renamed from: c, reason: collision with root package name */
            public final /* synthetic */ FragmentActivity f14238c;

            /* renamed from: d, reason: collision with root package name */
            public final /* synthetic */ Handler f14239d;

            public a(CallDetailActivityFragment callDetailActivityFragment, d dVar, FragmentActivity fragmentActivity, Handler handler) {
                this.f14236a = callDetailActivityFragment;
                this.f14237b = dVar;
                this.f14238c = fragmentActivity;
                this.f14239d = handler;
            }

            public static final void c(d this$0, CallDetailActivityFragment callDetailActivityFragment) {
                kotlin.jvm.internal.i.f(this$0, "this$0");
                H7.b.e("CallDetailActivityFragment", "onCall: fragment.finish");
                this$0.h(callDetailActivityFragment);
            }

            @Override // com.android.contacts.framework.baseui.util.t
            public void a(int i10, Object obj, Object obj2) {
                H7.b.e("CallDetailActivityFragment", "onCall: code: " + i10 + ", obj: " + obj + ", obj2: " + obj2 + ", isShowInChildUI: " + this.f14236a.E1());
                d dVar = this.f14237b;
                dVar.j(this.f14238c, dVar.g());
                Handler handler = this.f14239d;
                final d dVar2 = this.f14237b;
                final CallDetailActivityFragment callDetailActivityFragment = this.f14236a;
                handler.post(new Runnable() { // from class: com.android.contacts.detail.c
                    @Override // java.lang.Runnable
                    public final void run() {
                        CallDetailActivityFragment.d.a.c(CallDetailActivityFragment.d.this, callDetailActivityFragment);
                    }
                });
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(CallDetailActivityFragment target, ArrayList<Q0.b> list, boolean z10) {
            super(target);
            kotlin.jvm.internal.i.f(target, "target");
            kotlin.jvm.internal.i.f(list, "list");
            this.f14234b = list;
            this.f14235c = z10;
        }

        @Override // com.android.contacts.util.D
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public Void a(CallDetailActivityFragment callDetailActivityFragment, Void... params) {
            boolean z10;
            a aVar;
            kotlin.jvm.internal.i.f(params, "params");
            if (callDetailActivityFragment != null && C0792c.c(callDetailActivityFragment.getActivity())) {
                FragmentActivity requireActivity = callDetailActivityFragment.requireActivity();
                kotlin.jvm.internal.i.e(requireActivity, "fragment.requireActivity()");
                if (!callDetailActivityFragment.E1() && this.f14235c && AppMetaFeatures.b()) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                callDetailActivityFragment.f14223w1 = z10;
                if (H7.a.b()) {
                    H7.b.b("CallDetailActivityFragment", "mFinishInCallback: " + callDetailActivityFragment.f14223w1 + ", " + callDetailActivityFragment.E1());
                }
                if (callDetailActivityFragment.f14223w1) {
                    aVar = new a(callDetailActivityFragment, this, requireActivity, new Handler(Looper.getMainLooper()));
                } else {
                    aVar = null;
                }
                CallLogDeleteHelper.f(requireActivity, this.f14234b, this.f14235c, new D(2, 2, null), aVar);
                if (aVar == null) {
                    j(requireActivity, this.f14234b);
                }
            }
            return null;
        }

        public final ArrayList<Q0.b> g() {
            return this.f14234b;
        }

        public final void h(CallDetailActivityFragment callDetailActivityFragment) {
            if (callDetailActivityFragment != null && C0792c.c(callDetailActivityFragment.getActivity())) {
                Intent intent = new Intent("com.oplus.contacts.DETAIL_UPDATE_DONE");
                intent.putExtra("from_calllog", true);
                X.a b10 = X.a.b(callDetailActivityFragment.requireActivity());
                kotlin.jvm.internal.i.e(b10, "getInstance(fragment.requireActivity())");
                b10.d(intent);
                B3.c.d().h();
                callDetailActivityFragment.o1();
            }
        }

        @Override // com.android.contacts.util.D
        /* renamed from: i, reason: merged with bridge method [inline-methods] */
        public void b(CallDetailActivityFragment callDetailActivityFragment, Void r42) {
            Boolean bool;
            if (callDetailActivityFragment != null) {
                bool = Boolean.valueOf(callDetailActivityFragment.f14223w1);
            } else {
                bool = null;
            }
            H7.b.e("CallDetailActivityFragment", "onPostExecute[delete]: mFinishInCallback: " + bool);
            if (callDetailActivityFragment != null && !callDetailActivityFragment.f14223w1) {
                h(callDetailActivityFragment);
            }
        }

        public final void j(FragmentActivity fragmentActivity, ArrayList<Q0.b> arrayList) {
            ArrayList<String> arrayList2 = new ArrayList<>();
            int i10 = 0;
            for (Q0.b bVar : arrayList) {
                if (!bVar.a().isEmpty()) {
                    String d10 = bVar.d();
                    if (d10 != null) {
                        arrayList2.add(d10);
                    }
                    i10 += bVar.a().size();
                }
            }
            com.customize.contacts.util.h0.d(fragmentActivity, "delete", String.valueOf(i10));
            Intent intent = new Intent("oplus.intent.action.calllog.clear_catch");
            intent.putStringArrayListExtra("number_list_key", arrayList2);
            X.a b10 = X.a.b(fragmentActivity);
            kotlin.jvm.internal.i.e(b10, "getInstance(context)");
            b10.d(intent);
        }
    }

    /* compiled from: CallDetailActivityFragment.kt */
    /* loaded from: classes.dex */
    public interface e {
        boolean q0(int i10);
    }

    /* compiled from: CallDetailActivityFragment.kt */
    /* loaded from: classes.dex */
    public final class f extends BroadcastReceiver {
        public f() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            kotlin.jvm.internal.i.f(context, "context");
            kotlin.jvm.internal.i.f(intent, "intent");
            RecordPlayerPresenter recordPlayerPresenter = CallDetailActivityFragment.this.f14221u1;
            if ((recordPlayerPresenter == null || !recordPlayerPresenter.g0()) && !CallDetailActivityFragment.this.f14210j1 && CallDetailActivityFragment.this.v3() && kotlin.jvm.internal.i.b("com.gesture.dial.forDial", intent.getAction())) {
                if (H7.a.b()) {
                    H7.b.b("CallDetailActivityFragment", "received ACTION_GESTURE_DIAL,start call number : " + H7.a.d(CallDetailActivityFragment.this.f14187M0) + " ,mCanPlaceCall = " + CallDetailActivityFragment.this.f14212l1);
                }
                if (CallDetailActivityFragment.this.f14212l1 && !TextUtils.isEmpty(CallDetailActivityFragment.this.f14187M0)) {
                    Intent intent2 = new Intent(C0421a.f6395a, Uri.fromParts("tel", CallDetailActivityFragment.this.f14187M0, null));
                    intent2.setFlags(OplusPhoneCapabilities.CAPABILITY_SUPPORTS_RTT_REMOTE);
                    intent2.putExtra("countryiso", CallDetailActivityFragment.this.f14188N0);
                    Map<String, String> b02 = com.customize.contacts.util.h0.b0(CallDetailActivityFragment.this.getActivity());
                    b02.put("scenarios", "2");
                    com.android.contacts.framework.baseui.util.A.a(ContactsApplication.h(), 2000305, 200031809, b02, false);
                    intent2.putExtra("dialer_from", "gesture_dial");
                    C0802m.a(CallDetailActivityFragment.this.getActivity(), intent2);
                    CallDetailActivityFragment.this.K6();
                }
            }
        }
    }

    /* compiled from: CallDetailActivityFragment.kt */
    /* loaded from: classes.dex */
    public interface g {
        CallDetailActivityFragment a();

        void b(PhoneCallDetails[] phoneCallDetailsArr);
    }

    /* compiled from: CallDetailActivityFragment.kt */
    /* loaded from: classes.dex */
    public final class h extends BroadcastReceiver {
        public h() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            kotlin.jvm.internal.i.f(context, "context");
            kotlin.jvm.internal.i.f(intent, "intent");
            String action = intent.getAction();
            if (kotlin.jvm.internal.i.b("android.intent.action.SIM_STATE_CHANGED", action) || kotlin.jvm.internal.i.b("android.intent.action.SIM_SETTING_INFO_CHANGED", action) || kotlin.jvm.internal.i.b("android.intent.action.ACTION_SUBINFO_CONTENT_CHANGE", action)) {
                Handler handler = CallDetailActivityFragment.this.f14205e1;
                if (handler == null) {
                    handler = new a(CallDetailActivityFragment.this);
                    CallDetailActivityFragment.this.f14205e1 = handler;
                }
                handler.removeMessages(2);
                handler.sendEmptyMessageDelayed(2, COUIScrollBar.SCROLLER_FADE_TIMEOUT);
            }
        }
    }

    /* compiled from: CallDetailActivityFragment.kt */
    /* loaded from: classes.dex */
    public static final class i extends com.android.contacts.util.D<Void, Void, Void, CallDetailActivityFragment> {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public i(CallDetailActivityFragment target) {
            super(target);
            kotlin.jvm.internal.i.f(target, "target");
        }

        @Override // com.android.contacts.util.D
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public Void a(CallDetailActivityFragment callDetailActivityFragment, Void... arg0) {
            FragmentActivity activity;
            long j10;
            Uri uri;
            kotlin.jvm.internal.i.f(arg0, "arg0");
            if (callDetailActivityFragment != null && (activity = callDetailActivityFragment.getActivity()) != null && !activity.isFinishing() && !activity.isDestroyed()) {
                if (callDetailActivityFragment.v3()) {
                    if (H7.a.b()) {
                        H7.b.b("CallDetailActivityFragment", "[updateContactAndCallLogData] query contact info mNumber = " + H7.a.d(callDetailActivityFragment.f14187M0));
                    }
                    if (!TextUtils.isEmpty(callDetailActivityFragment.f14187M0)) {
                        j10 = callDetailActivityFragment.R5(callDetailActivityFragment.f14187M0);
                    } else {
                        return null;
                    }
                } else if (!callDetailActivityFragment.f14219s1 && (uri = callDetailActivityFragment.f14192R0) != null) {
                    j10 = ContentUris.parseId(uri);
                } else {
                    j10 = -1;
                }
                if ((j10 == -1 || callDetailActivityFragment.f14195U0) && !callDetailActivityFragment.f14219s1) {
                    callDetailActivityFragment.w4(true);
                } else {
                    callDetailActivityFragment.w4(false);
                    callDetailActivityFragment.f14199Y0 = ContentUris.withAppendedId(ContactsContract.Contacts.CONTENT_URI, j10);
                }
            }
            return null;
        }

        @Override // com.android.contacts.util.D
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public void b(CallDetailActivityFragment callDetailActivityFragment, Void r52) {
            FragmentActivity activity;
            if (callDetailActivityFragment != null && (activity = callDetailActivityFragment.getActivity()) != null && !activity.isFinishing() && !activity.isDestroyed()) {
                if (callDetailActivityFragment.v3()) {
                    boolean z10 = true;
                    callDetailActivityFragment.k4(true);
                    CallDetailUnfamiliarNumberFragment C32 = callDetailActivityFragment.C3();
                    if (C32 != null) {
                        C32.N2(callDetailActivityFragment.f14187M0);
                        C32.M2(callDetailActivityFragment.f14206f1);
                        C32.T2(callDetailActivityFragment.B3());
                        if (callDetailActivityFragment.B3() <= 1) {
                            z10 = false;
                        }
                        C32.U2(z10);
                        C32.R2(callDetailActivityFragment.f14183I0);
                        C32.S2(callDetailActivityFragment.f14184J0);
                    }
                } else {
                    callDetailActivityFragment.k4(false);
                    ContactLoaderFragment w32 = callDetailActivityFragment.w3();
                    if (w32 != null) {
                        if (C1641a.l(activity, FeatureOption.o())) {
                            w32.o1(callDetailActivityFragment.s3(), callDetailActivityFragment.x3());
                        }
                        w32.n1(callDetailActivityFragment.f14199Y0);
                    }
                }
                callDetailActivityFragment.J6(false);
                callDetailActivityFragment.z1();
            }
        }
    }

    /* compiled from: CallDetailActivityFragment.kt */
    /* loaded from: classes.dex */
    public static final class j extends com.android.contacts.util.D<Void, Void, Void, CallDetailActivityFragment> {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public j(CallDetailActivityFragment target) {
            super(target);
            kotlin.jvm.internal.i.f(target, "target");
        }

        /* JADX WARN: Removed duplicated region for block: B:36:0x0055  */
        @Override // com.android.contacts.util.D
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public java.lang.Void a(com.android.contacts.detail.CallDetailActivityFragment r12, java.lang.Void... r13) {
            /*
                r11 = this;
                java.lang.String r11 = "arg0"
                kotlin.jvm.internal.i.f(r13, r11)
                r11 = 0
                if (r12 != 0) goto L9
                return r11
            L9:
                androidx.fragment.app.FragmentActivity r13 = r12.getActivity()
                if (r13 == 0) goto Lbe
                boolean r0 = r13.isFinishing()
                if (r0 != 0) goto Lbe
                boolean r0 = r13.isDestroyed()
                if (r0 == 0) goto L1d
                goto Lbe
            L1d:
                boolean r0 = com.android.contacts.detail.CallDetailActivityFragment.o5(r12)
                java.lang.String r1 = "CallDetailActivityFragment"
                r2 = -1
                r4 = 0
                if (r0 == 0) goto L62
                android.content.ContentResolver r5 = r13.getContentResolver()     // Catch: java.lang.Throwable -> L59
                android.net.Uri r6 = android.provider.ContactsContract.Data.CONTENT_URI     // Catch: java.lang.Throwable -> L59
                java.lang.String r13 = "contact_id"
                java.lang.String[] r7 = new java.lang.String[]{r13}     // Catch: java.lang.Throwable -> L59
                java.lang.String r8 = "UPPER(data1)=UPPER(?) AND mimetype='vnd.android.cursor.item/email_v2'"
                java.lang.String r13 = com.android.contacts.detail.CallDetailActivityFragment.v5(r12)     // Catch: java.lang.Throwable -> L59
                java.lang.String[] r9 = new java.lang.String[]{r13}     // Catch: java.lang.Throwable -> L59
                r10 = 0
                android.database.Cursor r13 = G7.c.e(r5, r6, r7, r8, r9, r10)     // Catch: java.lang.Throwable -> L59
                if (r13 == 0) goto L52
                boolean r0 = r13.moveToFirst()     // Catch: java.lang.Throwable -> L50
                if (r0 == 0) goto L52
                long r5 = r13.getLong(r4)     // Catch: java.lang.Throwable -> L50
                goto L53
            L50:
                r11 = move-exception
                goto L5c
            L52:
                r5 = r2
            L53:
                if (r13 == 0) goto L7d
                r13.close()
                goto L7d
            L59:
                r12 = move-exception
                r13 = r11
                r11 = r12
            L5c:
                if (r13 == 0) goto L61
                r13.close()
            L61:
                throw r11
            L62:
                android.net.Uri r13 = com.android.contacts.detail.CallDetailActivityFragment.k5(r12)
                if (r13 == 0) goto L75
                long r5 = android.content.ContentUris.parseId(r13)     // Catch: java.lang.NumberFormatException -> L6d
                goto L7d
            L6d:
                java.lang.String r13 = "uri is unavailable"
                H7.b.c(r1, r13)
                r5 = r2
                goto L7d
            L75:
                java.lang.String r13 = com.android.contacts.detail.CallDetailActivityFragment.v5(r12)
                long r5 = com.android.contacts.detail.CallDetailActivityFragment.f5(r12, r13)
            L7d:
                boolean r13 = H7.a.b()
                if (r13 == 0) goto L97
                java.lang.StringBuilder r13 = new java.lang.StringBuilder
                r13.<init>()
                java.lang.String r0 = "[updateContactData] contactId = "
                r13.append(r0)
                r13.append(r5)
                java.lang.String r13 = r13.toString()
                H7.b.b(r1, r13)
            L97:
                int r13 = (r5 > r2 ? 1 : (r5 == r2 ? 0 : -1))
                r0 = 1
                if (r13 == 0) goto La2
                boolean r13 = com.android.contacts.detail.CallDetailActivityFragment.s5(r12)
                if (r13 == 0) goto Laf
            La2:
                boolean r13 = com.android.contacts.detail.CallDetailActivityFragment.r5(r12)
                if (r13 != 0) goto Laf
                com.android.contacts.detail.CallDetailActivityFragment.H5(r12, r4)
                r12.w4(r0)
                goto Lbe
            Laf:
                com.android.contacts.detail.CallDetailActivityFragment.H5(r12, r0)
                r12.w4(r4)
                android.net.Uri r13 = android.provider.ContactsContract.Contacts.CONTENT_URI
                android.net.Uri r13 = android.content.ContentUris.withAppendedId(r13, r5)
                com.android.contacts.detail.CallDetailActivityFragment.G5(r12, r13)
            Lbe:
                return r11
            */
            throw new UnsupportedOperationException("Method not decompiled: com.android.contacts.detail.CallDetailActivityFragment.j.a(com.android.contacts.detail.CallDetailActivityFragment, java.lang.Void[]):java.lang.Void");
        }

        @Override // com.android.contacts.util.D
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public void b(CallDetailActivityFragment callDetailActivityFragment, Void r42) {
            FragmentActivity activity;
            if (callDetailActivityFragment != null && (activity = callDetailActivityFragment.getActivity()) != null && !activity.isFinishing() && !activity.isDestroyed()) {
                if (H7.a.b()) {
                    H7.b.b("CallDetailActivityFragment", "[updateContactData onPostExecute] mNumberIsSaved = " + callDetailActivityFragment.f14198X0);
                }
                if (callDetailActivityFragment.f14208h1) {
                    callDetailActivityFragment.q6(callDetailActivityFragment.f14198X0);
                } else {
                    callDetailActivityFragment.u6(callDetailActivityFragment.v3());
                }
                if (callDetailActivityFragment.v3()) {
                    callDetailActivityFragment.k4(true);
                    CallDetailUnfamiliarNumberFragment C32 = callDetailActivityFragment.C3();
                    if (C32 != null && !callDetailActivityFragment.f14208h1) {
                        C32.N2(callDetailActivityFragment.f14187M0);
                        C32.M2(callDetailActivityFragment.f14206f1);
                        C32.T2(callDetailActivityFragment.B3());
                        C32.R2(callDetailActivityFragment.f14183I0);
                        C32.S2(callDetailActivityFragment.f14184J0);
                        return;
                    }
                    return;
                }
                callDetailActivityFragment.k4(false);
                ContactLoaderFragment w32 = callDetailActivityFragment.w3();
                if (w32 != null) {
                    if (C1641a.l(activity, FeatureOption.o())) {
                        w32.o1(callDetailActivityFragment.s3(), callDetailActivityFragment.x3());
                    }
                    w32.n1(callDetailActivityFragment.f14199Y0);
                }
            }
        }
    }

    /* compiled from: CallDetailActivityFragment.kt */
    /* loaded from: classes.dex */
    public static final class k extends com.android.contacts.util.D<Void, Void, PhoneCallDetails[], CallDetailActivityFragment> {

        /* renamed from: b, reason: collision with root package name */
        public final boolean f14242b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public k(CallDetailActivityFragment target, boolean z10) {
            super(target);
            kotlin.jvm.internal.i.f(target, "target");
            this.f14242b = z10;
        }

        @Override // com.android.contacts.util.D
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public PhoneCallDetails[] a(CallDetailActivityFragment callDetailActivityFragment, Void... params) {
            FragmentActivity activity;
            kotlin.jvm.internal.i.f(params, "params");
            if (callDetailActivityFragment != null && (activity = callDetailActivityFragment.getActivity()) != null && !activity.isFinishing() && !activity.isDestroyed()) {
                return callDetailActivityFragment.V5();
            }
            return null;
        }

        @Override // com.android.contacts.util.D
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public void b(CallDetailActivityFragment callDetailActivityFragment, PhoneCallDetails[] phoneCallDetailsArr) {
            FragmentActivity activity;
            Object b10;
            z0 p32;
            boolean z10;
            CallDetailUnfamiliarNumberFragment C32;
            boolean z11 = true;
            if (phoneCallDetailsArr == null) {
                if (callDetailActivityFragment != null) {
                    if (this.f14242b && callDetailActivityFragment.t3() && callDetailActivityFragment.v3()) {
                        FragmentActivity activity2 = callDetailActivityFragment.getActivity();
                        if (activity2 != null) {
                            Intent intent = new Intent("com.oplus.contacts.DETAIL_UPDATE_DONE");
                            intent.putExtra("from_calllog", true);
                            X.a.b(activity2).d(intent);
                        }
                        H7.b.e("CallDetailActivityFragment", "onPostExecute[update]: mFinishInCallback: " + callDetailActivityFragment.f14223w1);
                        if (!callDetailActivityFragment.f14223w1) {
                            callDetailActivityFragment.o1();
                        }
                    } else if (CommonFeatureOption.j() && callDetailActivityFragment.v3() && (C32 = callDetailActivityFragment.C3()) != null) {
                        C32.z2();
                    }
                    callDetailActivityFragment.f14216p1 = null;
                    return;
                }
                return;
            }
            if (callDetailActivityFragment != null && (activity = callDetailActivityFragment.getActivity()) != null && !activity.isFinishing() && !activity.isDestroyed()) {
                if (H7.a.b()) {
                    H7.b.b("CallDetailActivityFragment", "----onPostExecute----");
                }
                callDetailActivityFragment.f14216p1 = null;
                try {
                    Result.a aVar = Result.f34166a;
                    if (callDetailActivityFragment.C3() != null) {
                        CallDetailUnfamiliarNumberFragment C33 = callDetailActivityFragment.C3();
                        if (C33 != null) {
                            C33.H2(callDetailActivityFragment.f14188N0);
                        }
                        CallDetailUnfamiliarNumberFragment C34 = callDetailActivityFragment.C3();
                        if (C34 != null) {
                            if (callDetailActivityFragment.B3() > 1) {
                                z10 = true;
                            } else {
                                z10 = false;
                            }
                            C34.U2(z10);
                        }
                    }
                    if (callDetailActivityFragment.p3() != null && (p32 = callDetailActivityFragment.p3()) != null) {
                        if (callDetailActivityFragment.B3() <= 1) {
                            z11 = false;
                        }
                        p32.c3(z11);
                    }
                    callDetailActivityFragment.o6(phoneCallDetailsArr);
                    b10 = Result.b(m9.q.f35511a);
                } catch (Throwable th) {
                    Result.a aVar2 = Result.f34166a;
                    b10 = Result.b(kotlin.b.a(th));
                }
                Throwable d10 = Result.d(b10);
                if (d10 != null) {
                    H7.b.c("CallDetailActivityFragment", "Exception e: " + d10);
                }
                if (H7.a.b()) {
                    H7.b.b("CallDetailActivityFragment", "----onPostExecute end----");
                }
            }
        }
    }

    /* compiled from: CallDetailActivityFragment.kt */
    /* loaded from: classes.dex */
    public static final class l implements CallLogDeleteHelper.a {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Ref$ObjectRef<String> f14243a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ArrayList<Q0.d> f14244b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ CallDetailActivityFragment f14245c;

        public l(Ref$ObjectRef<String> ref$ObjectRef, ArrayList<Q0.d> arrayList, CallDetailActivityFragment callDetailActivityFragment) {
            this.f14243a = ref$ObjectRef;
            this.f14244b = arrayList;
            this.f14245c = callDetailActivityFragment;
        }

        @Override // com.android.contacts.detail.CallLogDeleteHelper.a
        public void a(Dialog dialog) {
            kotlin.jvm.internal.i.f(dialog, "dialog");
            U0.n.d(dialog);
        }

        @Override // com.android.contacts.detail.CallLogDeleteHelper.a
        public void onClick(int i10, boolean z10) {
            Q0.b bVar = new Q0.b(this.f14243a.element, null, null, null, null, null, 62, null);
            bVar.a().addAll(this.f14244b);
            ArrayList arrayList = new ArrayList();
            arrayList.add(bVar);
            InterfaceC0702c interfaceC0702c = this.f14245c.f14185K0;
            if (interfaceC0702c == null) {
                kotlin.jvm.internal.i.q("mAsyncTaskExecutor");
                interfaceC0702c = null;
            }
            interfaceC0702c.a(Tasks.DELETE_CALLLOG, new d(this.f14245c, arrayList, z10), new Void[0]);
        }
    }

    /* compiled from: CallDetailActivityFragment.kt */
    /* loaded from: classes.dex */
    public static final class m implements RecordPlayerPresenter.a {
        public m() {
        }

        @Override // com.customize.contacts.mediaplayer.RecordPlayerPresenter.a
        public void a(String str) {
            H7.b.b("CallDetailActivityFragment", "unfamiliarNumber onCallRecordChange startUpdateData");
            if (AppMetaFeatures.b()) {
                CallRecordingsCache.f15754a.s();
            }
            CallDetailActivityFragment.this.z6();
        }
    }

    /* compiled from: CallDetailActivityFragment.kt */
    /* loaded from: classes.dex */
    public static final class n implements RecordPlayerPresenter.a {
        public n() {
        }

        @Override // com.customize.contacts.mediaplayer.RecordPlayerPresenter.a
        public void a(String str) {
            H7.b.b("CallDetailActivityFragment", "senderDetails onCallRecordChange startUpdateData");
            if (AppMetaFeatures.b()) {
                CallRecordingsCache.f15754a.s();
            }
            CallDetailActivityFragment.this.z6();
        }
    }

    /* compiled from: CallDetailActivityFragment.kt */
    /* loaded from: classes.dex */
    public static final class o implements z0.h {
        public o() {
        }

        @Override // com.android.contacts.detail.z0.h
        public boolean a() {
            return com.customize.contacts.util.b0.i0(CallDetailActivityFragment.this.o3().getApplicationContext());
        }

        @Override // com.android.contacts.detail.z0.h
        public boolean b() {
            return com.customize.contacts.util.b0.C0(CallDetailActivityFragment.this.o3().getApplicationContext(), CallDetailActivityFragment.this.f14200Z0);
        }

        @Override // com.android.contacts.detail.z0.h
        public boolean c() {
            return com.customize.contacts.util.b0.z0(CallDetailActivityFragment.this.o3().getApplicationContext(), CallDetailActivityFragment.this.f14200Z0);
        }

        @Override // com.android.contacts.detail.z0.h
        public void d(Intent intent) {
            kotlin.jvm.internal.i.f(intent, "intent");
            CallDetailActivityFragment.this.Q3(intent);
        }
    }

    /* compiled from: CallDetailActivityFragment.kt */
    /* loaded from: classes.dex */
    public static final class p implements E {
        public p() {
        }

        @Override // com.android.contacts.detail.E
        public boolean a() {
            return com.customize.contacts.util.b0.i0(CallDetailActivityFragment.this.o3().getApplicationContext());
        }

        @Override // com.android.contacts.detail.E
        public boolean b() {
            return com.customize.contacts.util.b0.C0(CallDetailActivityFragment.this.o3().getApplicationContext(), CallDetailActivityFragment.this.f14200Z0);
        }

        @Override // com.android.contacts.detail.E
        public boolean c() {
            return com.customize.contacts.util.b0.z0(CallDetailActivityFragment.this.o3().getApplicationContext(), CallDetailActivityFragment.this.f14200Z0);
        }

        @Override // com.android.contacts.detail.E
        public void d() {
            com.customize.contacts.util.h0.d(CallDetailActivityFragment.this.o3(), "click_item", "all");
            H7.b.b("CallDetailActivityFragment", " expandMoreCallLog mCallLogCount = " + CallDetailActivityFragment.this.f14191Q0);
            Intent intent = new Intent(CallDetailActivityFragment.this.o3(), (Class<?>) MoreCallLogActivity.class);
            CallDetailActivityFragment callDetailActivityFragment = CallDetailActivityFragment.this;
            intent.putExtra("simid", callDetailActivityFragment.f14190P0);
            intent.putExtra("number", callDetailActivityFragment.f14187M0);
            intent.putExtra(BreenoCallContract.BaseColumns.NORMALIZED_NUMBER, callDetailActivityFragment.f14206f1);
            intent.putExtra("IsFromCalllogSearch", callDetailActivityFragment.f14213m1);
            intent.putExtra(OplusAutoRedialNotificationUI.TYPE, callDetailActivityFragment.f14193S0);
            intent.putExtra("countryiso", callDetailActivityFragment.f14188N0);
            intent.putExtra("isUnfamiliarNumber", callDetailActivityFragment.v3());
            CallDetailActivityFragment.this.startActivityForResult(intent, Imgproc.COLOR_RGBA2YUV_YV12);
        }
    }

    /* compiled from: CallDetailActivityFragment.kt */
    /* loaded from: classes.dex */
    public static final class q extends ContentObserver {
        public q(Handler handler) {
            super(handler);
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean z10) {
            Handler handler = CallDetailActivityFragment.this.f14205e1;
            if (handler == null) {
                handler = new a(CallDetailActivityFragment.this);
                CallDetailActivityFragment.this.f14205e1 = handler;
            }
            handler.removeMessages(3);
            handler.sendEmptyMessageDelayed(3, 500L);
            CallDetailActivityFragment.this.J6(true);
        }
    }

    /* compiled from: CallDetailActivityFragment.kt */
    /* loaded from: classes.dex */
    public static final class r implements g {
        public r() {
        }

        @Override // com.android.contacts.detail.CallDetailActivityFragment.g
        public CallDetailActivityFragment a() {
            return CallDetailActivityFragment.this;
        }

        @Override // com.android.contacts.detail.CallDetailActivityFragment.g
        public void b(PhoneCallDetails[] phoneCallDetailsArr) {
            CallDetailActivityFragment.this.h3(phoneCallDetailsArr);
        }
    }

    private final void A6() {
        Object b10;
        try {
            Result.a aVar = Result.f34166a;
            o3().getContentResolver().unregisterContentObserver(this.f14181A1);
            b10 = Result.b(m9.q.f35511a);
        } catch (Throwable th) {
            Result.a aVar2 = Result.f34166a;
            b10 = Result.b(kotlin.b.a(th));
        }
        Throwable d10 = Result.d(b10);
        if (d10 != null) {
            H7.b.c("CallDetailActivityFragment", "unregisterCallLogObserver " + d10);
        }
    }

    private final void E6() {
        if (this.f14202b1 != null) {
            try {
                o3().unregisterReceiver(this.f14202b1);
                this.f14202b1 = null;
            } catch (IllegalArgumentException e10) {
                H7.b.c("CallDetailActivityFragment", "unregisterSimStateChangedReceiver IllegalArgumentException: " + e10);
            }
        }
    }

    public static final void P5(CallDetailActivityFragment this$0) {
        kotlin.jvm.internal.i.f(this$0, "this$0");
        if (this$0.A3().f14358a) {
            this$0.f4();
        } else {
            this$0.K4();
        }
    }

    private final void T5() {
        Object b10;
        int size;
        this.f14200Z0.clear();
        if (B3.a.i()) {
            List<SubscriptionInfo> e10 = com.customize.contacts.util.b0.e(o3());
            kotlin.jvm.internal.i.e(e10, "colorgetActiveSubInfoList(mContext)");
            if (e10.isEmpty()) {
                size = 0;
            } else {
                size = e10.size();
            }
            C4(size);
            if (H7.a.b()) {
                H7.b.h("CallDetailActivityFragment", "getdualSimInfoList(): mSimCount = " + B3());
            }
            if (B3() > 1) {
                this.f14201a1.clear();
                int size2 = e10.size();
                for (int i10 = 0; i10 < size2; i10++) {
                    SubscriptionInfo subInfo = e10.get(i10);
                    long subscriptionId = subInfo.getSubscriptionId();
                    int simSlotIndex = subInfo.getSimSlotIndex();
                    if (simSlotIndex != 0) {
                        if (simSlotIndex == 1) {
                            this.f14184J0 = subscriptionId;
                        }
                    } else {
                        this.f14183I0 = subscriptionId;
                    }
                    HashMap<Integer, SubscriptionInfo> hashMap = this.f14201a1;
                    Integer valueOf = Integer.valueOf(subInfo.getSubscriptionId());
                    kotlin.jvm.internal.i.e(subInfo, "subInfo");
                    hashMap.put(valueOf, subInfo);
                    this.f14200Z0.add(new b0.a(simSlotIndex, subscriptionId, com.customize.contacts.util.b0.t0(o3(), subInfo.getSimSlotIndex())));
                }
                return;
            }
            for (SubscriptionInfo subscriptionInfo : e10) {
                this.f14200Z0.add(new b0.a(subscriptionInfo.getSimSlotIndex(), subscriptionInfo.getSubscriptionId(), com.customize.contacts.util.b0.t0(o3(), subscriptionInfo.getSimSlotIndex())));
            }
            return;
        }
        C4(com.customize.contacts.util.b0.T(o3()) ? 1 : 0);
        try {
            Result.a aVar = Result.f34166a;
            if (B3() == 1) {
                this.f14200Z0.add(new b0.a(0, D7.c.r(o3(), 0), D7.c.n(0)));
            }
            b10 = Result.b(m9.q.f35511a);
        } catch (Throwable th) {
            Result.a aVar2 = Result.f34166a;
            b10 = Result.b(kotlin.b.a(th));
        }
        Throwable d10 = Result.d(b10);
        if (d10 != null) {
            H7.b.c("CallDetailActivityFragment", "getSimInfoList single SIM error " + d10);
        }
        if (H7.a.b()) {
            H7.b.h("CallDetailActivityFragment", "getsingleSimInfoList(): mSimCount = " + B3());
        }
    }

    private final Uri W5() {
        Object b10;
        Parcelable parcelable = null;
        try {
            Result.a aVar = Result.f34166a;
            parcelable = C7.e.j(t1(), "EXTRA_VOICEMAIL_URI");
            b10 = Result.b(m9.q.f35511a);
        } catch (Throwable th) {
            Result.a aVar2 = Result.f34166a;
            b10 = Result.b(kotlin.b.a(th));
        }
        Throwable d10 = Result.d(b10);
        if (d10 != null) {
            H7.b.c("CallDetailActivityFragment", "getVoicemailUri e = " + d10);
        }
        return (Uri) parcelable;
    }

    private final boolean Y5() {
        if (W5() != null) {
            return true;
        }
        return false;
    }

    private final void b2() {
        View view;
        Integer q12;
        if (CommonFeatureOption.j() && E1() && this.f14222v1 && kotlin.jvm.internal.i.b("search_unfold_contact", getTag()) && (view = getView()) != null && (q12 = q1()) != null) {
            view.setPadding(view.getPaddingLeft(), view.getPaddingTop(), view.getPaddingRight(), q12.intValue());
        }
    }

    public static final boolean h6(CallDetailActivityFragment this$0) {
        Object b10;
        kotlin.jvm.internal.i.f(this$0, "this$0");
        try {
            Result.a aVar = Result.f34166a;
            if (H7.a.b()) {
                H7.b.b("CallDetailActivityFragment", "queueIdle---------------");
            }
            b10 = Result.b(LayoutInflater.from(this$0.o3()).inflate(R.layout.contact_editor_fragment, (ViewGroup) null));
        } catch (Throwable th) {
            Result.a aVar2 = Result.f34166a;
            b10 = Result.b(kotlin.b.a(th));
        }
        Throwable d10 = Result.d(b10);
        if (d10 != null) {
            H7.b.c("CallDetailActivityFragment", "queueIdle exception " + d10);
            return false;
        }
        return false;
    }

    private final void i6() {
        Object b10;
        try {
            Result.a aVar = Result.f34166a;
            o3().getContentResolver().registerContentObserver(CallLog.Calls.CONTENT_URI_WITH_VOICEMAIL, false, this.f14181A1);
            b10 = Result.b(m9.q.f35511a);
        } catch (Throwable th) {
            Result.a aVar2 = Result.f34166a;
            b10 = Result.b(kotlin.b.a(th));
        }
        Throwable d10 = Result.d(b10);
        if (d10 != null) {
            H7.b.c("CallDetailActivityFragment", "registerCallLogObserver " + d10);
        }
    }

    private final void l6() {
        Object b10;
        this.f14202b1 = new h();
        IntentFilter intentFilter = new IntentFilter();
        C0811w.j(o3(), this.f14202b1, intentFilter, "android.intent.action.SIM_STATE_CHANGED");
        intentFilter.addAction("android.intent.action.SIM_SETTING_INFO_CHANGED");
        intentFilter.addAction("android.intent.action.ACTION_SUBINFO_CONTENT_CHANGE");
        try {
            Result.a aVar = Result.f34166a;
            b10 = Result.b(o3().registerReceiver(this.f14202b1, intentFilter, R0.b.f3175i, null, 2));
        } catch (Throwable th) {
            Result.a aVar2 = Result.f34166a;
            b10 = Result.b(kotlin.b.a(th));
        }
        Throwable d10 = Result.d(b10);
        if (d10 != null) {
            H7.b.c("CallDetailActivityFragment", "registerSimStateChangedReceiver Exception: " + d10);
            this.f14202b1 = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void x6() {
        com.android.contacts.calllog.I i10;
        boolean k10;
        boolean z10;
        H7.b.e("CallDetailActivityFragment", "sim state has changed mIsFirstSimStateChangeBroadcast = " + this.f14214n1);
        FragmentActivity activity = getActivity();
        if (activity == null) {
            return;
        }
        if (!this.f14214n1 && !activity.isFinishing() && !activity.isDestroyed()) {
            T5();
            c4(o3());
            com.android.contacts.calllog.I i11 = this.f14186L0;
            if (i11 == null) {
                kotlin.jvm.internal.i.q("mPhoneNumberHelper");
                i11 = null;
            }
            i11.l(o3());
            CallDetailUnfamiliarNumberFragment C32 = C3();
            if (C32 != null && C32.isAdded()) {
                C32.h3();
                C32.j3();
            }
            CallDetailUnfamiliarNumberFragment z32 = z3();
            if (z32 != null && z32.isAdded()) {
                z32.h3();
                z32.j3();
            }
            z0 p32 = p3();
            if (p32 != null && p32.isAdded()) {
                p32.l3();
            }
            if (this.f14208h1) {
                return;
            }
            com.android.contacts.calllog.I i12 = this.f14186L0;
            if (i12 == null) {
                kotlin.jvm.internal.i.q("mPhoneNumberHelper");
                i10 = null;
            } else {
                i10 = i12;
            }
            if (B3() > 1) {
                long j10 = this.f14190P0;
                if (j10 >= 0) {
                    k10 = i10.j(j10, this.f14187M0, this.f14183I0, this.f14184J0);
                    z10 = this.f14196V0;
                    if (!z10 && Boolean.compare(z10, k10) != 0) {
                        this.f14196V0 = k10;
                        H6();
                        return;
                    } else {
                        this.f14196V0 = k10;
                        J6(false);
                        return;
                    }
                }
            }
            k10 = i10.k(this.f14187M0);
            z10 = this.f14196V0;
            if (!z10) {
            }
            this.f14196V0 = k10;
            J6(false);
            return;
        }
        this.f14214n1 = false;
    }

    public final void B6() {
        Object b10;
        BroadcastReceiver broadcastReceiver = this.f14204d1;
        if (broadcastReceiver != null) {
            try {
                Result.a aVar = Result.f34166a;
                X.a b11 = X.a.b(o3());
                kotlin.jvm.internal.i.e(b11, "getInstance(mContext)");
                b11.e(broadcastReceiver);
                this.f14204d1 = null;
                b10 = Result.b(m9.q.f35511a);
            } catch (Throwable th) {
                Result.a aVar2 = Result.f34166a;
                b10 = Result.b(kotlin.b.a(th));
            }
            Throwable d10 = Result.d(b10);
            if (d10 != null) {
                H7.b.c("CallDetailActivityFragment", "unregisterContactNotFindReceiver Exception e: " + d10);
            }
            Result.a(b10);
        }
    }

    public final void C6() {
        if (this.f14203c1 != null) {
            try {
                o3().unregisterReceiver(this.f14203c1);
                this.f14203c1 = null;
            } catch (IllegalArgumentException e10) {
                H7.b.c("CallDetailActivityFragment", "unregisterGestureDialReceiver IllegalArgumentException: " + e10);
            }
        }
    }

    public final void D6() {
        Object b10;
        if (-1 != this.f14218r1) {
            try {
                Result.a aVar = Result.f34166a;
                X.a b11 = X.a.b(o3());
                kotlin.jvm.internal.i.e(b11, "getInstance(mContext)");
                b11.e(this.f14182B1);
                b10 = Result.b(m9.q.f35511a);
            } catch (Throwable th) {
                Result.a aVar2 = Result.f34166a;
                b10 = Result.b(kotlin.b.a(th));
            }
            Throwable d10 = Result.d(b10);
            if (d10 != null) {
                H7.b.b("CallDetailActivityFragment", "unregister local receiver error" + d10);
            }
        }
    }

    @Override // com.android.contacts.detail.DetailActivityFragment
    public boolean F3() {
        if ((B3.a.f0() && com.android.contacts.calllog.I.i(this.f14187M0)) || (B3.a.D() && com.android.contacts.calllog.I.h(this.f14187M0))) {
            return true;
        }
        return false;
    }

    public final void F6() {
        MenuItem k32;
        if (!CommonFeatureOption.o(getContext()) && (k32 = k3(R.id.menu_black_list)) != null) {
            if (CommonFeatureOption.j()) {
                G6(k32);
            } else {
                k32.setVisible(false);
            }
        }
    }

    @Override // com.android.contacts.detail.DetailActivityFragment
    public void G3() {
        if (J3()) {
            f6();
        } else {
            super.G3();
        }
    }

    public final void G6(MenuItem menuItem) {
        if (!A3().f14364g && PrimaryUserUtils.a() && !F3() && !B3.a.p()) {
            if (A3().f14358a) {
                menuItem.setVisible(true);
                menuItem.setTitle(R.string.remove_from_blacklist);
                return;
            } else if (A3().f14359b) {
                menuItem.setVisible(true);
                menuItem.setTitle(R.string.oplus_intercept_contact);
                return;
            } else if (this.f14215o1) {
                menuItem.setVisible(false);
                return;
            } else {
                menuItem.setVisible(true);
                menuItem.setTitle(R.string.oplus_intercept_contact);
                return;
            }
        }
        menuItem.setVisible(false);
    }

    public final void H6() {
        InterfaceC0702c interfaceC0702c = this.f14185K0;
        if (interfaceC0702c == null) {
            kotlin.jvm.internal.i.q("mAsyncTaskExecutor");
            interfaceC0702c = null;
        }
        interfaceC0702c.a(Tasks.UPDATE_CONTACT_AND_CALLOG, new i(this), new Void[0]);
    }

    @Override // com.android.contacts.detail.DetailActivityFragment
    public void I3() {
        super.I3();
        this.f14224x1.j(getContext(), this.f14189O0, this.f14218r1, 1);
    }

    public final void I6() {
        InterfaceC0702c interfaceC0702c = this.f14185K0;
        if (interfaceC0702c == null) {
            kotlin.jvm.internal.i.q("mAsyncTaskExecutor");
            interfaceC0702c = null;
        }
        interfaceC0702c.a(Tasks.UPDATE_CONTACT_DETAILS, new j(this), new Void[0]);
    }

    @Override // com.android.contacts.detail.DetailActivityFragment, com.customize.contacts.fragment.BaseActivityFragment
    public boolean J1(com.customize.contacts.fragment.y menu) {
        MenuBuilder menuBuilder;
        boolean z10;
        MenuItem k32;
        kotlin.jvm.internal.i.f(menu, "menu");
        Menu b10 = menu.b();
        if (b10 instanceof MenuBuilder) {
            menuBuilder = (MenuBuilder) b10;
        } else {
            menuBuilder = null;
        }
        if (menuBuilder != null) {
            menuBuilder.stopDispatchingItemsChanged();
        }
        super.J1(menu);
        if (v3()) {
            MenuItem k33 = k3(R.id.star);
            if (k33 != null) {
                k33.setVisible(false);
            }
            MenuItem k34 = k3(R.id.add);
            if (k34 != null) {
                k34.setVisible(true);
            }
            MenuItem k35 = k3(R.id.menu_edit);
            if (k35 != null) {
                k35.setVisible(false);
            }
            if ((B3.a.f0() && com.android.contacts.calllog.I.i(this.f14187M0)) || (B3.a.D() && com.android.contacts.calllog.I.h(this.f14187M0))) {
                MenuItem k36 = k3(R.id.star);
                if (k36 != null) {
                    k36.setVisible(false);
                }
                MenuItem k37 = k3(R.id.add);
                if (k37 != null) {
                    k37.setVisible(false);
                }
            }
        } else {
            ContactLoader.Result n32 = n3();
            if (n32 != null && n32.f0() && (k32 = k3(R.id.star)) != null) {
                k32.setVisible(false);
            }
            MenuItem k38 = k3(R.id.add);
            if (k38 != null) {
                k38.setVisible(false);
            }
            if (n32 != null && n32.f0() && !com.customize.contacts.util.b0.m0(o3().getApplicationContext(), 0) && !com.customize.contacts.util.b0.m0(o3().getApplicationContext(), 1)) {
                z10 = true;
            } else {
                z10 = false;
            }
            MenuItem k39 = k3(R.id.menu_edit);
            if (k39 != null) {
                k39.setVisible(!z10);
            }
        }
        if (menuBuilder != null) {
            menuBuilder.startDispatchingItemsChanged();
        }
        return false;
    }

    @Override // com.android.contacts.detail.DetailActivityFragment
    public boolean J3() {
        Uri uri;
        if (q3() == 0 && v3()) {
            return true;
        }
        if (q3() == 1) {
            ContactLoader.Result n32 = n3();
            if (n32 != null) {
                uri = n32.L();
            } else {
                uri = null;
            }
            if (uri == null) {
                return true;
            }
        }
        return false;
    }

    public final void J6(boolean z10) {
        Object b10;
        if (this.f14216p1 != null) {
            H7.b.e("CallDetailActivityFragment", "Query CallLog AsyncTask are running");
            return;
        }
        this.f14216p1 = new k(this, z10);
        if (CommonFeatureOption.j()) {
            try {
                Result.a aVar = Result.f34166a;
                InterfaceC0702c interfaceC0702c = this.f14185K0;
                if (interfaceC0702c == null) {
                    kotlin.jvm.internal.i.q("mAsyncTaskExecutor");
                    interfaceC0702c = null;
                }
                b10 = Result.b(interfaceC0702c.a(Tasks.UPDATE_PHONE_CALL_DETAILS, this.f14216p1, new Void[0]));
            } catch (Throwable th) {
                Result.a aVar2 = Result.f34166a;
                b10 = Result.b(kotlin.b.a(th));
            }
            Throwable d10 = Result.d(b10);
            if (d10 != null) {
                H7.b.c("CallDetailActivityFragment", "e = " + d10);
            }
        }
    }

    public final void K6() {
        Object systemService = o3().getSystemService("vibrator");
        kotlin.jvm.internal.i.d(systemService, "null cannot be cast to non-null type android.os.Vibrator");
        ((Vibrator) systemService).vibrate(100L);
    }

    @Override // com.android.contacts.detail.DetailActivityFragment, com.customize.contacts.fragment.BaseActivityFragment
    public boolean M1(com.customize.contacts.fragment.y menu) {
        MenuItem k32;
        MenuItem k33;
        kotlin.jvm.internal.i.f(menu, "menu");
        boolean M12 = super.M1(menu);
        if (v3()) {
            F6();
            return false;
        }
        if (this.f14209i1 && (k33 = k3(R.id.menu_edit)) != null) {
            k33.setVisible(false);
        }
        if (this.f14219s1 && (k32 = k3(R.id.star)) != null) {
            k32.setVisible(false);
        }
        return M12;
    }

    public final void N5() {
        androidx.fragment.app.B p10 = getChildFragmentManager().p();
        kotlin.jvm.internal.i.e(p10, "childFragmentManager.beginTransaction()");
        if (q3() == 0) {
            if (v3()) {
                CallDetailUnfamiliarNumberFragment C32 = C3();
                if (C32 != null && !C32.isAdded()) {
                    p10.c(R.id.about_fragment_container, C32, "view-pager-numbers-fragment");
                }
                z0 p32 = p3();
                if (p32 != null && p32.isAdded()) {
                    p10.r(p32);
                }
            } else {
                z0 p33 = p3();
                if (p33 != null && !p33.isAdded()) {
                    p10.c(R.id.about_fragment_container, p33, "view-pager-contacts-fragment");
                }
                CallDetailUnfamiliarNumberFragment C33 = C3();
                if (C33 != null && C33.isAdded()) {
                    p10.r(C33);
                }
            }
        } else if (q3() == 1) {
            if (v3()) {
                CallDetailUnfamiliarNumberFragment z32 = z3();
                if (z32 != null && !z32.isAdded()) {
                    p10.c(R.id.about_fragment_container, z32, "view-pager-sms-fragment");
                }
                z0 p34 = p3();
                if (p34 != null && p34.isAdded()) {
                    p10.r(p34);
                }
            } else {
                z0 p35 = p3();
                if (p35 != null && !p35.isAdded()) {
                    p10.c(R.id.about_fragment_container, p35, "view-pager-contacts-fragment");
                }
                CallDetailUnfamiliarNumberFragment z33 = z3();
                if (z33 != null && z33.isAdded()) {
                    p10.r(z33);
                }
            }
        }
        p10.j();
        getChildFragmentManager().i0();
    }

    public final void O5(ArrayList<Q0.b> list, boolean z10) {
        kotlin.jvm.internal.i.f(list, "list");
        InterfaceC0702c interfaceC0702c = this.f14185K0;
        if (interfaceC0702c == null) {
            kotlin.jvm.internal.i.q("mAsyncTaskExecutor");
            interfaceC0702c = null;
        }
        interfaceC0702c.a(Tasks.DELETE_CALLLOG, new d(this, list, z10), new Void[0]);
    }

    public final boolean Q5() {
        FragmentActivity activity = getActivity();
        if (!(activity instanceof ContactsTabActivity) || !E1()) {
            return true;
        }
        ContactsTabActivity contactsTabActivity = (ContactsTabActivity) activity;
        if (contactsTabActivity.E2() && kotlin.jvm.internal.i.b("unfold_dial_contact", getTag())) {
            return true;
        }
        if (contactsTabActivity.C2()) {
            if (kotlin.jvm.internal.i.b("right_fragment_tag_show_detail", getTag()) || kotlin.jvm.internal.i.b("right_fragment_tag_show_profile", getTag())) {
                return true;
            }
            return false;
        }
        return false;
    }

    public final long R5(String str) {
        long S52 = S5(str, this.f14194T0);
        if (-1 == S52 && -1 != this.f14194T0) {
            this.f14194T0 = -1L;
            return S5(str, -1L);
        }
        return S52;
    }

    public final long S5(String str, long j10) {
        long j11 = -1;
        if (TextUtils.isEmpty(str)) {
            return -1L;
        }
        Uri build = R0.d.c(str).buildUpon().appendQueryParameter("countryISO_for_calllog", this.f14188N0).build();
        H7.b.b("CallDetailActivityFragment", "mCountryIso in call log detail is " + this.f14188N0);
        if (j10 != -1) {
            build = Uri.withAppendedPath(build, String.valueOf(j10));
        }
        Uri uri = build;
        Cursor cursor = null;
        try {
            cursor = G7.c.e(o3().getContentResolver(), uri, com.android.contacts.calllog.J.a(), null, null, null);
            if (cursor != null && cursor.moveToFirst()) {
                j11 = cursor.getLong(0);
            }
            return j11;
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }
    }

    public final Object U5(Intent intent, String str) {
        Parcelable parcelable = null;
        if (intent == null) {
            return null;
        }
        try {
            Result.a aVar = Result.f34166a;
            parcelable = intent.getParcelableExtra(str);
            Result.b(m9.q.f35511a);
            return parcelable;
        } catch (Throwable th) {
            Result.a aVar2 = Result.f34166a;
            Result.b(kotlin.b.a(th));
            return parcelable;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:46:0x0161, code lost:
    
        r4 = r6[r9];
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x0163, code lost:
    
        if (r4 != null) goto L53;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x0166, code lost:
    
        r4.f13183q = r2.getString(r7);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final com.android.contacts.PhoneCallDetails[] V5() {
        /*
            Method dump skipped, instructions count: 437
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.contacts.detail.CallDetailActivityFragment.V5():com.android.contacts.PhoneCallDetails[]");
    }

    public final boolean X5() {
        CallDetailUnfamiliarNumberFragment z32;
        NewCallRepository W12;
        LiveData<Boolean> k10;
        NewCallRepository W13;
        LiveData<Boolean> k11;
        CallDetailUnfamiliarNumberFragment C32 = C3();
        if ((C32 != null && (W13 = C32.W1()) != null && (k11 = W13.k()) != null && kotlin.jvm.internal.i.b(k11.getValue(), Boolean.TRUE)) || ((z32 = z3()) != null && (W12 = z32.W1()) != null && (k10 = W12.k()) != null && kotlin.jvm.internal.i.b(k10.getValue(), Boolean.TRUE))) {
            return true;
        }
        return false;
    }

    public final void Z5(Bundle bundle) {
        Uri uri;
        boolean z10;
        boolean z11;
        if (bundle != null) {
            this.f14187M0 = bundle.getString("number", "");
            this.f14206f1 = bundle.getString(BreenoCallContract.BaseColumns.NORMALIZED_NUMBER, "");
            this.f14190P0 = bundle.getLong("simid", -1L);
            this.f14189O0 = bundle.getString("name", "");
            Object obj = bundle.get("contact_uri");
            if (obj instanceof Uri) {
                uri = (Uri) obj;
            } else {
                uri = null;
            }
            this.f14192R0 = uri;
            this.f14195U0 = bundle.getBoolean("isSpecialNumber");
            this.f14197W0 = bundle.getBoolean("isServiceNumber", false);
            if (U5(t1(), "sim_contacts_info") == null && this.f14199Y0 == null && this.f14192R0 == null) {
                z10 = true;
            } else {
                z10 = false;
            }
            w4(z10);
            this.f14213m1 = bundle.getBoolean("IsFromCalllogSearch", false);
            String string = bundle.getString("call_log_phone_num", "");
            if (TextUtils.isEmpty(this.f14187M0) && !TextUtils.isEmpty(string)) {
                this.f14187M0 = string;
                w4(true);
                v4(true);
            }
            if (C1641a.l(o3(), FeatureOption.o())) {
                t4(bundle.getBoolean("from_calllog", false));
                z4(bundle.getString("number", ""));
            }
            this.f14209i1 = bundle.getBoolean("from_blacklist", false);
            if (!bundle.getBoolean("from_sms", false) && !this.f14209i1) {
                z11 = false;
            } else {
                z11 = true;
            }
            this.f14208h1 = z11;
            if (z11) {
                this.f14187M0 = bundle.getString("contact_number", "");
                this.f14210j1 = bundle.getBoolean("is_email", false);
                Z1(R.string.oplus_mms_send_detail_title);
                E4(R.string.oplus_mms_send_detail_title);
            } else {
                E4(R.string.dialog_detail_title);
            }
            this.f14193S0 = bundle.getInt(OplusAutoRedialNotificationUI.TYPE);
            this.f14194T0 = bundle.getLong("contact_id", -1L);
            this.f14188N0 = bundle.getString("countryiso");
            if (H7.a.b()) {
                H7.b.b("CallDetailActivityFragment", "mIsFromGlobalSearch: " + u3() + ", mNumber: " + H7.a.d(this.f14187M0) + ", mSimId: " + this.f14190P0 + ", mIsUnfamiliarNumber: " + v3() + ", mIsFromSms: " + this.f14208h1 + ", mCallType: " + this.f14193S0 + ", mContactId: " + this.f14194T0 + ", Iso: " + this.f14188N0 + ", isServiceNumber: " + this.f14197W0 + ", mIsSpecialNumber: " + this.f14195U0);
            }
        }
        if (Y5()) {
            w4(true);
        }
    }

    public final void a6() {
        Object b10;
        Object b11;
        try {
            Result.a aVar = Result.f34166a;
            if (U5(t1(), "sim_contacts_info") != null) {
                Object U52 = U5(t1(), "sim_contacts_info");
                if (U52 != null) {
                    this.f14218r1 = com.customize.contacts.util.b0.K(o3(), ((SimContactInfo) U52).d());
                }
                this.f14219s1 = true;
                if (H7.a.b()) {
                    H7.b.b("CallDetailActivityFragment", "register local broadcast mSlotId : " + this.f14218r1);
                }
                if (-1 != this.f14218r1) {
                    try {
                        X.a b12 = X.a.b(o3());
                        kotlin.jvm.internal.i.e(b12, "getInstance(mContext)");
                        IntentFilter intentFilter = new IntentFilter();
                        intentFilter.addAction("local.intent.action.SUBINFO_STATE_CHANGE");
                        b12.c(this.f14182B1, intentFilter);
                        b11 = Result.b(m9.q.f35511a);
                    } catch (Throwable th) {
                        Result.a aVar2 = Result.f34166a;
                        b11 = Result.b(kotlin.b.a(th));
                    }
                    Throwable d10 = Result.d(b11);
                    if (d10 != null) {
                        H7.b.c("CallDetailActivityFragment", "register local broadcast error" + d10);
                    }
                }
            }
            b10 = Result.b(m9.q.f35511a);
        } catch (Throwable th2) {
            Result.a aVar3 = Result.f34166a;
            b10 = Result.b(kotlin.b.a(th2));
        }
        Throwable d11 = Result.d(b10);
        if (d11 != null) {
            H7.b.c("CallDetailActivityFragment", "initForSimContact e " + d11);
        }
    }

    public final void b6() {
        z0 p32;
        boolean z10;
        boolean z11;
        z0 p33 = p3();
        boolean z12 = false;
        if (p33 != null && (p33 instanceof C0606f)) {
            ((C0606f) p33).b3(this.f14225y1);
            if (B3() > 1) {
                z11 = true;
            } else {
                z11 = false;
            }
            p33.c3(z11);
            p33.a3(E1());
        }
        CallDetailUnfamiliarNumberFragment C32 = C3();
        com.android.contacts.calllog.I i10 = null;
        if (C32 != null) {
            C32.Q2(this.f14221u1);
            com.android.contacts.calllog.I i11 = this.f14186L0;
            if (i11 == null) {
                kotlin.jvm.internal.i.q("mPhoneNumberHelper");
                i11 = null;
            }
            C32.P2(i11);
            C32.N2(this.f14187M0);
            C32.M2(this.f14206f1);
            C32.T2(B3());
            if (B3() > 1) {
                z10 = true;
            } else {
                z10 = false;
            }
            C32.U2(z10);
            C32.R2(this.f14183I0);
            C32.S2(this.f14184J0);
            C32.I2(this.f14207g1);
            C32.H2(this.f14188N0);
            C32.K2(E1());
            RecordPlayerPresenter recordPlayerPresenter = this.f14221u1;
            if (recordPlayerPresenter != null) {
                recordPlayerPresenter.I0(new m());
            }
        }
        CallDetailUnfamiliarNumberFragment z32 = z3();
        if (z32 != null) {
            z32.Q2(this.f14221u1);
            com.android.contacts.calllog.I i12 = this.f14186L0;
            if (i12 == null) {
                kotlin.jvm.internal.i.q("mPhoneNumberHelper");
            } else {
                i10 = i12;
            }
            z32.P2(i10);
            z32.N2(this.f14187M0);
            z32.M2(this.f14206f1);
            z32.T2(B3());
            if (B3() > 1) {
                z12 = true;
            }
            z32.U2(z12);
            z32.V2(this.f14190P0);
            z32.J2(this.f14208h1);
            z32.K2(E1());
            RecordPlayerPresenter recordPlayerPresenter2 = this.f14221u1;
            if (recordPlayerPresenter2 != null) {
                recordPlayerPresenter2.I0(new n());
            }
        }
        if (q3() == 1) {
            CallDetailUnfamiliarNumberFragment z33 = z3();
            if (z33 != null) {
                j4(z33);
            }
        } else {
            CallDetailUnfamiliarNumberFragment C33 = C3();
            if (C33 != null) {
                j4(C33);
            }
        }
        if (C1641a.l(o3(), FeatureOption.o()) && (p32 = p3()) != null) {
            p32.Y2(s3());
        }
    }

    public final void c6() {
        com.android.contacts.calllog.I i10 = null;
        if (this.f14208h1) {
            r4(1);
            boolean p62 = p6();
            CallDetailUnfamiliarNumberFragment z32 = z3();
            if (z32 != null) {
                com.android.contacts.calllog.I i11 = this.f14186L0;
                if (i11 == null) {
                    kotlin.jvm.internal.i.q("mPhoneNumberHelper");
                } else {
                    i10 = i11;
                }
                new y0.d(z32, i10);
                new C1725e(z32);
                z32.L2(this.f14226z1);
            }
            if (!p62) {
                N5();
                return;
            }
            return;
        }
        r4(0);
        boolean p63 = p6();
        CallDetailUnfamiliarNumberFragment C32 = C3();
        if (C32 != null) {
            C32.setNumberInfo(this.f14195U0, this.f14197W0, this.f14215o1);
            C32.L2(this.f14226z1);
            com.android.contacts.calllog.I i12 = this.f14186L0;
            if (i12 == null) {
                kotlin.jvm.internal.i.q("mPhoneNumberHelper");
            } else {
                i10 = i12;
            }
            new y0.d(C32, i10);
            new C1725e(C32);
        }
        if (!p63) {
            N5();
        }
    }

    public final void d6() {
        HashMap<String, Integer> hashMap = new HashMap<>(6);
        hashMap.put(getString(R.string.add_to_saved_contacts), 8);
        hashMap.put(getString(R.string.oplus_intercept_contact), 11);
        hashMap.put(getString(R.string.remove_from_blacklist), 12);
        hashMap.put(getString(R.string.oplus_add_number_to_whitelist), 14);
        hashMap.put(getString(R.string.oplus_remove_number_from_whitelist), 15);
        hashMap.put(getString(R.string.oplus_mark_unknow_number_title), 9);
        hashMap.put(getString(R.string.modify_mark), 9);
        hashMap.put(getString(R.string.ted_actionbar_correction_mark), 10);
        hashMap.put(getString(R.string.block_all_this_call_type), 13);
        hashMap.put(getString(R.string.delete_button), 7);
        hashMap.put(getString(R.string.intercept_special_name_number), 20);
        if (CommonFeatureOption.o(getContext()) && X5()) {
            hashMap.put(getString(R.string.menu_message_box), 19);
        }
        y4(hashMap);
    }

    @Override // com.android.contacts.detail.DetailActivityFragment
    public void e3() {
        com.android.contacts.framework.api.appstore.appinfo.a.a(getActivity(), new Runnable() { // from class: com.android.contacts.detail.a
            @Override // java.lang.Runnable
            public final void run() {
                CallDetailActivityFragment.P5(CallDetailActivityFragment.this);
            }
        });
    }

    public final void e6(ArrayList<PopupListItem> arrayList, boolean z10) {
        if (!A3().f14364g && PrimaryUserUtils.a() && !z10 && !B3.a.p()) {
            if (A3().f14358a) {
                if (CommonFeatureOption.o(getContext())) {
                    arrayList.add(com.android.contacts.framework.baseui.util.q.e(getString(R.string.remove_from_blacklist), false, false, 0, null, null, 0, null, null, null, 0, 2046, null));
                }
                arrayList.add(com.android.contacts.framework.baseui.util.q.e(getString(R.string.oplus_add_number_to_whitelist), false, false, 0, null, null, 0, null, null, null, 0, 2046, null));
            } else if (A3().f14359b) {
                if (CommonFeatureOption.o(getContext())) {
                    arrayList.add(com.android.contacts.framework.baseui.util.q.e(getString(R.string.oplus_intercept_contact), false, false, 0, null, null, 0, null, null, null, 0, 2046, null));
                }
                arrayList.add(com.android.contacts.framework.baseui.util.q.e(getString(R.string.oplus_remove_number_from_whitelist), false, false, 0, null, null, 0, null, null, null, 0, 2046, null));
            } else if (this.f14215o1) {
                arrayList.add(com.android.contacts.framework.baseui.util.q.e(getString(R.string.oplus_add_number_to_whitelist), false, false, 0, null, null, 0, null, null, null, 0, 2046, null));
            } else if (CommonFeatureOption.o(getContext())) {
                arrayList.add(com.android.contacts.framework.baseui.util.q.e(getString(R.string.oplus_intercept_contact), false, false, 0, null, null, 0, null, null, null, 0, 2046, null));
            }
        }
    }

    public final void f6() {
        boolean z10;
        String string;
        d6();
        boolean F32 = F3();
        ArrayList<PopupListItem> arrayList = new ArrayList<>();
        if (!A3().f14365h && !F32 && CommonFeatureOption.o(getContext())) {
            arrayList.add(com.android.contacts.framework.baseui.util.q.e(getString(R.string.add_to_saved_contacts), false, false, 0, null, null, 0, null, null, null, 0, 2046, null));
        }
        if (CommonFeatureOption.o(getContext()) && X5()) {
            arrayList.add(com.android.contacts.framework.baseui.util.q.e(getString(R.string.menu_message_box), false, false, 0, null, null, 0, null, null, null, 0, 2046, null));
        }
        if (CommonFeatureOption.j()) {
            e6(arrayList, F32);
            if (A3().f14360c && PrimaryUserUtils.a() && !F32) {
                arrayList.add(com.android.contacts.framework.baseui.util.q.e(getString(R.string.block_all_this_call_type), false, false, 0, null, null, 0, null, null, null, 0, 2046, null));
            }
            if (B3.a.Q() && A3().f14362e && PrimaryUserUtils.a() && !F32) {
                if (A3().f14363f) {
                    string = getString(R.string.modify_mark);
                } else {
                    string = getString(R.string.oplus_mark_unknow_number_title);
                }
                arrayList.add(com.android.contacts.framework.baseui.util.q.e(string, false, false, 0, null, null, 0, null, null, null, 0, 2046, null));
            }
            if (B3.a.Q() && A3().f14361d && !F32) {
                arrayList.add(com.android.contacts.framework.baseui.util.q.e(getString(R.string.ted_actionbar_correction_mark), false, false, 0, null, null, 0, null, null, null, 0, 2046, null));
            }
            if (BlackListUtils.q() && !TextUtils.isEmpty(this.f14189O0)) {
                arrayList.add(com.android.contacts.framework.baseui.util.q.e(getString(R.string.intercept_special_name_number), false, false, 0, null, null, 0, null, null, null, 0, 2046, null));
            }
        }
        PhoneCallDetails[] phoneCallDetailsArr = this.f14217q1;
        if (!A3().f14364g && phoneCallDetailsArr != null) {
            if (phoneCallDetailsArr.length == 0) {
                z10 = true;
            } else {
                z10 = false;
            }
            if ((!z10) && !this.f14208h1) {
                arrayList.add(com.android.contacts.framework.baseui.util.q.e(getString(R.string.delete_button), false, false, 0, null, null, 0, null, null, null, 0, 2046, null));
            }
        }
        x4(arrayList);
    }

    public final void g6() {
        if (!this.f14220t1) {
            Looper.myQueue().addIdleHandler(new MessageQueue.IdleHandler() { // from class: com.android.contacts.detail.b
                @Override // android.os.MessageQueue.IdleHandler
                public final boolean queueIdle() {
                    boolean h62;
                    h62 = CallDetailActivityFragment.h6(CallDetailActivityFragment.this);
                    return h62;
                }
            });
            this.f14220t1 = true;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v2, types: [T, java.lang.String] */
    @Override // com.android.contacts.detail.DetailActivityFragment
    public void h3(PhoneCallDetails[] phoneCallDetailsArr) {
        if (phoneCallDetailsArr != null && phoneCallDetailsArr.length != 0) {
            Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
            ArrayList arrayList = new ArrayList();
            for (PhoneCallDetails phoneCallDetails : phoneCallDetailsArr) {
                CharSequence charSequence = phoneCallDetails.f13167a;
                if (charSequence != null) {
                    ref$ObjectRef.element = charSequence.toString();
                    arrayList.add(new Q0.d(phoneCallDetails.f13175i, phoneCallDetails.f13170d, phoneCallDetails.f13169c, phoneCallDetails.b(), phoneCallDetails.f13183q));
                }
            }
            FragmentActivity activity = getActivity();
            T t10 = ref$ObjectRef.element;
            if (t10 != 0 && activity != null) {
                kotlin.jvm.internal.i.c(t10);
                CallLogDeleteHelper.i(activity, (String) t10, arrayList, arrayList.size(), arrayList.size(), new l(ref$ObjectRef, arrayList, this));
                return;
            }
            return;
        }
        H7.b.i("CallDetailActivityFragment", "deleteCalllogAndRefresh: phone details is empty!");
    }

    @Override // com.android.contacts.detail.DetailActivityFragment
    public void h4(boolean z10, boolean z11) {
        super.h4(z10, z11);
        CallDetailUnfamiliarNumberFragment z32 = z3();
        if (z32 != null) {
            z32.B0(z10, z11);
        }
    }

    @Override // com.android.contacts.detail.DetailActivityFragment
    public void i4(ContactLoader.Result result) {
        super.i4(result);
        H7.b.b("CallDetailActivityFragment", "setContactData mIsUnfamiliarNumber = " + v3());
        if (v3()) {
            return;
        }
        o4(result);
        w6();
    }

    @Override // com.android.contacts.detail.DetailActivityFragment
    public boolean j3() {
        if (n3() == null && !v3()) {
            return false;
        }
        return super.j3();
    }

    public final void j6() {
        Object b10;
        try {
            Result.a aVar = Result.f34166a;
            c cVar = new c();
            this.f14204d1 = cVar;
            X.a b11 = X.a.b(o3());
            kotlin.jvm.internal.i.e(b11, "getInstance(mContext)");
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("com.oplus.contacts.CONTACT_NOT_FIND");
            b11.c(cVar, intentFilter);
            b10 = Result.b(m9.q.f35511a);
        } catch (Throwable th) {
            Result.a aVar2 = Result.f34166a;
            b10 = Result.b(kotlin.b.a(th));
        }
        Throwable d10 = Result.d(b10);
        if (d10 != null) {
            H7.b.c("CallDetailActivityFragment", "registerContactNotFindReceiver Exception e: " + d10);
        }
    }

    public final void k6() {
        Object b10;
        this.f14203c1 = new f();
        IntentFilter intentFilter = new IntentFilter("com.gesture.dial.forDial");
        try {
            Result.a aVar = Result.f34166a;
            b10 = Result.b(o3().registerReceiver(this.f14203c1, intentFilter, R0.b.f3175i, null, 2));
        } catch (Throwable th) {
            Result.a aVar2 = Result.f34166a;
            b10 = Result.b(kotlin.b.a(th));
        }
        Throwable d10 = Result.d(b10);
        if (d10 != null) {
            H7.b.c("CallDetailActivityFragment", "registerGestureDialReceiver Exception: " + d10);
            this.f14203c1 = null;
        }
    }

    @Override // com.customize.contacts.fragment.BaseActivityFragment
    public void m1() {
        super.m1();
        z0 p32 = p3();
        if (p32 != null) {
            p32.N2();
        }
    }

    public final void m6(Intent intent) {
        kotlin.jvm.internal.i.f(intent, "intent");
        V1(intent);
        ContactLoaderFragment w32 = w3();
        if (w32 != null) {
            w32.n1(intent.getData());
        }
    }

    public final void n6() {
        z0 p32 = p3();
        if (p32 != null) {
            p32.Q2();
        }
    }

    public final void o6(PhoneCallDetails[] phoneCallDetailsArr) {
        C0606f c0606f;
        this.f14217q1 = phoneCallDetailsArr;
        if (!v3()) {
            w6();
            return;
        }
        Fragment m02 = getChildFragmentManager().m0("view-pager-contacts-fragment");
        if (m02 instanceof C0606f) {
            c0606f = (C0606f) m02;
        } else {
            c0606f = null;
        }
        CallDetailUnfamiliarNumberFragment C32 = C3();
        CallDetailUnfamiliarNumberFragment z32 = z3();
        if (c0606f != null && C32 != null && !C32.isAdded() && !this.f14208h1) {
            H7.b.e("CallDetailActivityFragment", "replace mUnfamiliarNumberFragment");
            androidx.fragment.app.B p10 = getChildFragmentManager().p();
            kotlin.jvm.internal.i.e(p10, "childFragmentManager.beginTransaction()");
            p10.t(R.id.about_fragment_container, C32, "view-pager-numbers-fragment");
            p10.j();
            getChildFragmentManager().i0();
            t6();
        } else if (c0606f != null && z32 != null && !z32.isAdded() && this.f14208h1) {
            H7.b.e("CallDetailActivityFragment", "replace mSenderDetailsFragment");
            androidx.fragment.app.B p11 = getChildFragmentManager().p();
            kotlin.jvm.internal.i.e(p11, "childFragmentManager.beginTransaction()");
            p11.t(R.id.about_fragment_container, z32, "view-pager-sms-fragment");
            p11.j();
            getChildFragmentManager().i0();
            t6();
        }
        v6();
    }

    @Override // com.android.contacts.detail.DetailActivityFragment, androidx.fragment.app.Fragment
    public void onAttachFragment(Fragment fragment) {
        kotlin.jvm.internal.i.f(fragment, "fragment");
        if (!u3()) {
            super.onAttachFragment(fragment);
        }
    }

    @Override // com.customize.contacts.fragment.BaseActivityFragment, androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration newConfig) {
        kotlin.jvm.internal.i.f(newConfig, "newConfig");
        super.onConfigurationChanged(newConfig);
        boolean z10 = this.f14222v1;
        boolean r10 = DisplayUtil.r(getActivity(), newConfig, null, 4, null);
        this.f14222v1 = r10;
        if (z10 != r10) {
            b2();
        }
    }

    @Override // com.android.contacts.detail.DetailActivityFragment, com.customize.contacts.fragment.BaseActivityFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        E6();
        A6();
        D6();
        this.f14216p1 = null;
        RecordPlayerPresenter recordPlayerPresenter = this.f14221u1;
        if (recordPlayerPresenter != null) {
            recordPlayerPresenter.l0();
        }
        Handler handler = this.f14205e1;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
        c1 c1Var = this.f14224x1;
        if (c1Var != null) {
            c1Var.e();
        }
        super.onDestroy();
    }

    @Override // com.android.contacts.detail.DetailActivityFragment, androidx.fragment.app.Fragment
    public void onPause() {
        RecordPlayerPresenter recordPlayerPresenter = this.f14221u1;
        if (recordPlayerPresenter != null) {
            recordPlayerPresenter.m0();
        }
        super.onPause();
    }

    @Override // com.android.contacts.detail.DetailActivityFragment, com.customize.contacts.fragment.BaseActivityFragment, androidx.fragment.app.Fragment
    public void onResume() {
        this.f14212l1 = true;
        RecordPlayerPresenter recordPlayerPresenter = this.f14221u1;
        if (recordPlayerPresenter != null) {
            recordPlayerPresenter.o0();
        }
        super.onResume();
        if (!v3()) {
            g6();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        boolean k10;
        com.android.contacts.calllog.I i10;
        super.onStart();
        if (H7.a.b()) {
            H7.b.b("CallDetailActivityFragment", "onStart");
        }
        C0799j.c(F7.b.e(o3()));
        C0799j.d(DateFormat.getTimeFormat(o3()));
        com.android.contacts.calllog.I i11 = null;
        if (B3() > 1 && this.f14190P0 >= 0) {
            com.android.contacts.calllog.I i12 = this.f14186L0;
            if (i12 == null) {
                kotlin.jvm.internal.i.q("mPhoneNumberHelper");
                i10 = null;
            } else {
                i10 = i12;
            }
            k10 = i10.j(this.f14190P0, this.f14187M0, this.f14183I0, this.f14184J0);
        } else {
            com.android.contacts.calllog.I i13 = this.f14186L0;
            if (i13 == null) {
                kotlin.jvm.internal.i.q("mPhoneNumberHelper");
            } else {
                i11 = i13;
            }
            k10 = i11.k(this.f14187M0);
        }
        this.f14196V0 = k10;
        if (H7.a.b()) {
            H7.b.b("CallDetailActivityFragment", "mIsFirst = " + this.f14211k1 + " ,isVoicemailNumber = mIsFromOplusApps = " + this.f14208h1);
        }
        z6();
        this.f14211k1 = false;
        k6();
        j6();
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        C6();
        B6();
        super.onStop();
        RecordPlayerPresenter recordPlayerPresenter = this.f14221u1;
        if (recordPlayerPresenter != null) {
            recordPlayerPresenter.p0();
        }
    }

    @Override // com.android.contacts.detail.DetailActivityFragment, com.customize.contacts.fragment.BaseActivityFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        Object b10;
        boolean z10;
        kotlin.jvm.internal.i.f(view, "view");
        super.onViewCreated(view, bundle);
        if (H7.a.b()) {
            H7.b.b("CallDetailActivityFragment", "onCreate");
        }
        Intent t12 = t1();
        FragmentActivity activity = getActivity();
        if (getContext() != null && t12 != null && activity != null) {
            if (AppMetaFeatures.b()) {
                CallRecordingsCache.f15754a.r(activity);
            }
            this.f14222v1 = DisplayUtil.r(activity, null, null, 6, null);
            b2();
            this.f14199Y0 = t12.getData();
            Z5(t12.getExtras());
            a6();
            try {
                Result.a aVar = Result.f34166a;
                this.f14215o1 = C7.e.c(t1(), "is_from_block_list", false);
                u4(C7.e.c(t1(), "from_dialer", false));
                b10 = Result.b(m9.q.f35511a);
            } catch (Throwable th) {
                Result.a aVar2 = Result.f34166a;
                b10 = Result.b(kotlin.b.a(th));
            }
            Throwable d10 = Result.d(b10);
            if (d10 != null) {
                H7.b.c("CallDetailActivityFragment", "onViewCreated e =" + d10);
            }
            l4(this.f14215o1);
            if (u3()) {
                this.f14199Y0 = null;
            }
            H7.b.e("CallDetailActivityFragment", "mLookupUri = " + this.f14199Y0);
            if ((this.f14199Y0 == null || !kotlin.jvm.internal.i.b(this.f14187M0, "")) && ((this.f14199Y0 == null || kotlin.jvm.internal.i.b(this.f14187M0, "") || this.f14194T0 != -1) && t12.getAction() == null)) {
                z10 = true;
            } else {
                z10 = false;
            }
            s4(z10);
            this.f14186L0 = new com.android.contacts.calllog.I(o3());
            InterfaceC0702c c10 = C0703d.c();
            kotlin.jvm.internal.i.e(c10, "createThreadPoolExecutor()");
            this.f14185K0 = c10;
            T5();
            this.f14221u1 = RecordPlayerPresenter.f21643D.a(activity);
            c6();
            this.f14207g1 = new r();
            b6();
            this.f14211k1 = true;
            if (v3()) {
                k4(true);
            } else {
                k4(false);
            }
            l6();
            i6();
            return;
        }
        o1();
    }

    public final boolean p6() {
        z0 z0Var;
        z0 z0Var2;
        boolean z10 = false;
        CallDetailUnfamiliarNumberFragment callDetailUnfamiliarNumberFragment = null;
        if (q3() == 0) {
            Fragment m02 = getChildFragmentManager().m0("view-pager-contacts-fragment");
            if (m02 instanceof z0) {
                z0Var2 = (z0) m02;
            } else {
                z0Var2 = null;
            }
            q4(z0Var2);
            Fragment m03 = getChildFragmentManager().m0("view-pager-numbers-fragment");
            if (m03 instanceof CallDetailUnfamiliarNumberFragment) {
                callDetailUnfamiliarNumberFragment = (CallDetailUnfamiliarNumberFragment) m03;
            }
            D4(callDetailUnfamiliarNumberFragment);
            if (p3() != null && C3() != null) {
                z10 = true;
            } else {
                if (p3() == null) {
                    q4(new C0606f());
                }
                if (C3() == null) {
                    D4(new CallDetailUnfamiliarNumberFragment());
                }
            }
            z0 p32 = p3();
            if (p32 != null) {
                p32.b3(this.f14225y1);
            }
            return z10;
        }
        if (q3() == 1) {
            Fragment m04 = getChildFragmentManager().m0("view-pager-contacts-fragment");
            if (m04 instanceof z0) {
                z0Var = (z0) m04;
            } else {
                z0Var = null;
            }
            q4(z0Var);
            Fragment m05 = getChildFragmentManager().m0("view-pager-sms-fragment");
            if (m05 instanceof CallDetailUnfamiliarNumberFragment) {
                callDetailUnfamiliarNumberFragment = (CallDetailUnfamiliarNumberFragment) m05;
            }
            A4(callDetailUnfamiliarNumberFragment);
            if (p3() != null && z3() != null) {
                z10 = true;
            } else {
                if (p3() == null) {
                    q4(new C0606f());
                }
                if (z3() == null) {
                    A4(new CallDetailUnfamiliarNumberFragment());
                }
            }
            z0 p33 = p3();
            if (p33 != null) {
                p33.b3(this.f14225y1);
            }
        }
        return z10;
    }

    public final void q6(boolean z10) {
        CallDetailUnfamiliarNumberFragment callDetailUnfamiliarNumberFragment;
        if (H7.a.b()) {
            H7.b.b("CallDetailActivityFragment", "setMmsDetailsData hasSaved = " + z10);
        }
        Fragment m02 = getChildFragmentManager().m0("view-pager-sms-fragment");
        C0606f c0606f = null;
        if (m02 instanceof CallDetailUnfamiliarNumberFragment) {
            callDetailUnfamiliarNumberFragment = (CallDetailUnfamiliarNumberFragment) m02;
        } else {
            callDetailUnfamiliarNumberFragment = null;
        }
        if (z10) {
            z0 p32 = p3();
            if (p32 != null && callDetailUnfamiliarNumberFragment != null && !p32.isAdded()) {
                H7.b.b("CallDetailActivityFragment", "replace mDetailFragment without callLog");
                androidx.fragment.app.B p10 = getChildFragmentManager().p();
                kotlin.jvm.internal.i.e(p10, "childFragmentManager.beginTransaction()");
                p10.t(R.id.about_fragment_container, p32, "view-pager-contacts-fragment");
                p10.j();
                return;
            }
            return;
        }
        Fragment m03 = getChildFragmentManager().m0("view-pager-contacts-fragment");
        if (m03 instanceof C0606f) {
            c0606f = (C0606f) m03;
        }
        CallDetailUnfamiliarNumberFragment z32 = z3();
        if (z32 != null) {
            if (c0606f != null && !z32.isAdded() && v3()) {
                H7.b.e("CallDetailActivityFragment", "replace mSenderDetailsFragment");
                androidx.fragment.app.B p11 = getChildFragmentManager().p();
                kotlin.jvm.internal.i.e(p11, "childFragmentManager.beginTransaction()");
                p11.t(R.id.about_fragment_container, z32, "view-pager-sms-fragment");
                p11.j();
                getChildFragmentManager().i0();
            }
            z32.z2();
        }
        J6(false);
    }

    public final void r6(CallDetailUnfamiliarNumberFragment.i info) {
        kotlin.jvm.internal.i.f(info, "info");
        B4(info);
        z1();
    }

    public final void s6() {
        int i10;
        z0 p32 = p3();
        if (p32 != null && p32.j2().getPaddingTop() <= 0) {
            AppBarLayout p12 = p1();
            if (p12 != null) {
                i10 = p12.getMeasuredHeight();
            } else {
                i10 = 0;
            }
            int dimensionPixelSize = i10 + getResources().getDimensionPixelSize(R.dimen.DP_30);
            p32.j2().setPadding(0, dimensionPixelSize, 0, 0);
            p32.j2().smoothScrollByOffset(-dimensionPixelSize);
        }
    }

    public final void t6() {
        int i10;
        CallDetailUnfamiliarNumberFragment C32 = C3();
        if (C32 != null && C32.V1().getPaddingTop() <= 0) {
            AppBarLayout p12 = p1();
            if (p12 != null) {
                i10 = p12.getMeasuredHeight();
            } else {
                i10 = 0;
            }
            int dimensionPixelSize = i10 + getResources().getDimensionPixelSize(R.dimen.DP_30);
            C32.V1().setPadding(0, dimensionPixelSize, 0, 0);
            C32.V1().smoothScrollByOffset(-dimensionPixelSize);
        }
    }

    public final void u6(boolean z10) {
        w4(z10);
    }

    public final void v6() {
        if (H7.a.b()) {
            H7.b.b("CallDetailActivityFragment", "showCallLog mPhonedetails = " + Arrays.toString(this.f14217q1));
        }
        if (CommonFeatureOption.j()) {
            CallDetailUnfamiliarNumberFragment C32 = C3();
            if (C32 != null) {
                C32.G2(this.f14217q1);
            }
            CallDetailUnfamiliarNumberFragment z32 = z3();
            if (z32 != null) {
                z32.G2(this.f14217q1);
            }
        }
    }

    public final void w6() {
        CallDetailUnfamiliarNumberFragment callDetailUnfamiliarNumberFragment;
        H7.b.b("CallDetailActivityFragment", "showContactWithCallLog ");
        if (n3() == null) {
            H7.b.i("CallDetailActivityFragment", "mContactData is null");
            return;
        }
        z0 p32 = p3();
        if (p32 == null) {
            return;
        }
        Fragment m02 = getChildFragmentManager().m0("view-pager-numbers-fragment");
        Uri uri = null;
        if (m02 instanceof CallDetailUnfamiliarNumberFragment) {
            callDetailUnfamiliarNumberFragment = (CallDetailUnfamiliarNumberFragment) m02;
        } else {
            callDetailUnfamiliarNumberFragment = null;
        }
        if (callDetailUnfamiliarNumberFragment != null && !p32.isAdded()) {
            H7.b.e("CallDetailActivityFragment", "replace mDetailFragment");
            androidx.fragment.app.B p10 = getChildFragmentManager().p();
            kotlin.jvm.internal.i.e(p10, "childFragmentManager.beginTransaction()");
            p10.t(R.id.about_fragment_container, p32, "view-pager-contacts-fragment");
            p10.j();
            getChildFragmentManager().i0();
        }
        Uri uri2 = this.f14192R0;
        ContactLoader.Result n32 = n3();
        if (n32 != null) {
            uri = n32.L();
        }
        this.f14192R0 = uri;
        if (!U7.g.a(uri2, uri)) {
            n6();
        }
        p32.W2(this.f14192R0, n3());
        s6();
    }

    /* JADX WARN: Removed duplicated region for block: B:104:0x02d8  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x0364  */
    /* JADX WARN: Unreachable blocks removed: 2, instructions: 2 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final android.database.Cursor y6() {
        /*
            Method dump skipped, instructions count: 1059
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.contacts.detail.CallDetailActivityFragment.y6():android.database.Cursor");
    }

    public final void z6() {
        if (this.f14208h1) {
            if (!this.f14211k1 && !this.f14196V0) {
                I6();
                return;
            } else {
                q6(false);
                return;
            }
        }
        if (u3()) {
            H6();
            return;
        }
        if (!this.f14211k1 && !this.f14196V0) {
            H6();
            return;
        }
        J6(false);
        if (this.f14199Y0 == null && !this.f14196V0 && !this.f14219s1) {
            I6();
        }
    }
}
