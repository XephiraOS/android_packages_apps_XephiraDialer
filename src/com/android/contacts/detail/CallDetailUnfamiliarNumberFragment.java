package com.android.contacts.detail;

import android.content.BroadcastReceiver;
import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.database.Cursor;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.provider.CallLog;
import android.provider.ContactsContract;
import android.telephony.PhoneNumberUtils;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.util.Pair;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.android.contacts.HandlerC0582c;
import com.android.contacts.PhoneCallDetails;
import com.android.contacts.ProximitySensorManager;
import com.android.contacts.business.calllog.breenocall.BreenoCallContract;
import com.android.contacts.business.calllog.breenocall.BreenoCallLogEntity;
import com.android.contacts.business.calllog.breenocall.detail.BreenoCallTipManager;
import com.android.contacts.business.calllog.breenocall.summary.AutoCallSummaryTipManager;
import com.android.contacts.detail.CallDetailActivityFragment;
import com.android.contacts.framework.api.numberidentify.interfaces.IRecognitionNumber;
import com.android.contacts.framework.baseui.util.C0636a;
import com.android.contacts.framework.baseui.util.C0637b;
import com.android.contacts.voicemail.VoicemailStatusHelperImpl;
import com.android.contacts.voicemail.b;
import com.android.incallui.OplusNumberMarkUtils;
import com.android.incallui.OplusPhoneCapabilities;
import com.android.incallui.OplusPhoneUtils;
import com.coui.appcompat.statusbar.COUIStatusBarResponseUtil;
import com.coui.appcompat.textviewcompatutil.COUITextViewCompatUtil;
import com.customize.contacts.FeatureOption;
import com.customize.contacts.fragment.BaseActivityFragment;
import com.customize.contacts.mediaplayer.RecordPlayerPresenter;
import com.customize.contacts.model.NewCallRepository;
import com.customize.contacts.util.BlackListUtils;
import com.customize.contacts.util.C0792c;
import com.customize.contacts.util.C0801l;
import com.customize.contacts.util.C0811w;
import com.customize.contacts.widget.ColorRoundLocalImageView;
import com.customize.contacts.widget.MultiChoiceListView;
import com.oplus.dialer.R;
import com.oplus.foundation.util.display.DisplayUtil;
import com.oplus.foundation.util.feature.CommonFeatureOption;
import com.oplus.foundation.util.feature.CommonOSPublicFeature;
import com.oplus.foundation.util.feature.FeatureUtil;
import com.oplus.foundation.util.feature.VirtualSupportUtils;
import com.oplus.foundation.util.systemcore.PrimaryUserUtils;
import h1.C1074c;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ThreadPoolExecutor;
import r0.C1498a;
import r0.C1501d;
import v9.InterfaceC1637a;
import w0.C1641a;
import w0.C1643c;
import y0.InterfaceC1699a;
import y0.InterfaceC1700b;
import z0.C1725e;
import z0.InterfaceC1721a;
import z0.InterfaceC1724d;

/* loaded from: classes.dex */
public class CallDetailUnfamiliarNumberFragment extends Fragment implements y0.c, InterfaceC1724d, w0.e, w0.n, View.OnClickListener, COUIStatusBarResponseUtil.StatusBarClickListener, HandlerC0582c.a, BreenoCallTipManager.ITipController {

    /* renamed from: A, reason: collision with root package name */
    public View f14253A;

    /* renamed from: B, reason: collision with root package name */
    public MultiChoiceListView f14255B;

    /* renamed from: C, reason: collision with root package name */
    public View f14257C;

    /* renamed from: C0, reason: collision with root package name */
    public ViewGroup f14258C0;

    /* renamed from: D, reason: collision with root package name */
    public View f14259D;

    /* renamed from: D0, reason: collision with root package name */
    public long f14260D0;

    /* renamed from: E, reason: collision with root package name */
    public ViewGroup f14261E;

    /* renamed from: F, reason: collision with root package name */
    public TextView f14263F;

    /* renamed from: G, reason: collision with root package name */
    public TextView f14265G;

    /* renamed from: H, reason: collision with root package name */
    public TextView f14267H;

    /* renamed from: I, reason: collision with root package name */
    public TextView f14269I;

    /* renamed from: J, reason: collision with root package name */
    public TextView f14271J;

    /* renamed from: K, reason: collision with root package name */
    public TextView f14273K;

    /* renamed from: L, reason: collision with root package name */
    public View f14275L;

    /* renamed from: M, reason: collision with root package name */
    public ColorRoundLocalImageView f14277M;

    /* renamed from: N, reason: collision with root package name */
    public ImageView f14278N;

    /* renamed from: O, reason: collision with root package name */
    public ImageView f14279O;

    /* renamed from: P, reason: collision with root package name */
    public View f14280P;

    /* renamed from: Q, reason: collision with root package name */
    public TextView f14281Q;

    /* renamed from: R, reason: collision with root package name */
    public ViewStub f14282R;

    /* renamed from: S, reason: collision with root package name */
    public View f14283S;

    /* renamed from: T, reason: collision with root package name */
    public TextView f14284T;

    /* renamed from: U, reason: collision with root package name */
    public View f14285U;

    /* renamed from: V, reason: collision with root package name */
    public CallDetailActivityFragment.g f14286V;

    /* renamed from: W, reason: collision with root package name */
    public LayoutInflater f14287W;

    /* renamed from: X, reason: collision with root package name */
    public com.android.contacts.calllog.I f14288X;

    /* renamed from: Y, reason: collision with root package name */
    public Z0.b f14289Y;

    /* renamed from: a0, reason: collision with root package name */
    public COUIStatusBarResponseUtil f14292a0;

    /* renamed from: b, reason: collision with root package name */
    public HandlerC0582c f14293b;

    /* renamed from: c, reason: collision with root package name */
    public E f14295c;

    /* renamed from: d, reason: collision with root package name */
    public com.android.contacts.voicemail.b f14297d;

    /* renamed from: e, reason: collision with root package name */
    public ProximitySensorManager f14299e;

    /* renamed from: f, reason: collision with root package name */
    public View f14301f;

    /* renamed from: g, reason: collision with root package name */
    public TextView f14303g;

    /* renamed from: h, reason: collision with root package name */
    public TextView f14305h;

    /* renamed from: h0, reason: collision with root package name */
    public InterfaceC1700b f14306h0;

    /* renamed from: i0, reason: collision with root package name */
    public InterfaceC1721a f14308i0;

    /* renamed from: j0, reason: collision with root package name */
    public PhoneCallDetails f14310j0;

    /* renamed from: k, reason: collision with root package name */
    public String f14311k;

    /* renamed from: l, reason: collision with root package name */
    public String f14313l;

    /* renamed from: m0, reason: collision with root package name */
    public int f14316m0;

    /* renamed from: n, reason: collision with root package name */
    public String f14317n;

    /* renamed from: n0, reason: collision with root package name */
    public RelativeLayout f14318n0;

    /* renamed from: o, reason: collision with root package name */
    public String f14319o;

    /* renamed from: p0, reason: collision with root package name */
    public BroadcastReceiver f14322p0;

    /* renamed from: q0, reason: collision with root package name */
    public ThreadPoolExecutor f14324q0;

    /* renamed from: r0, reason: collision with root package name */
    public String f14326r0;

    /* renamed from: s0, reason: collision with root package name */
    public w0.d f14327s0;

    /* renamed from: t0, reason: collision with root package name */
    public w0.m f14328t0;

    /* renamed from: x0, reason: collision with root package name */
    public RecordPlayerPresenter f14333x0;

    /* renamed from: a, reason: collision with root package name */
    public final h f14291a = new h();

    /* renamed from: i, reason: collision with root package name */
    public Context f14307i = null;

    /* renamed from: j, reason: collision with root package name */
    public PhoneCallDetails[] f14309j = null;

    /* renamed from: m, reason: collision with root package name */
    public int f14315m = 0;

    /* renamed from: p, reason: collision with root package name */
    public int f14321p = 0;

    /* renamed from: q, reason: collision with root package name */
    public long f14323q = -1;

    /* renamed from: r, reason: collision with root package name */
    public long f14325r = -1;

    /* renamed from: x, reason: collision with root package name */
    public long f14332x = -1;

    /* renamed from: y, reason: collision with root package name */
    public boolean f14334y = false;

    /* renamed from: z, reason: collision with root package name */
    public boolean f14336z = false;

    /* renamed from: Z, reason: collision with root package name */
    public boolean f14290Z = false;

    /* renamed from: b0, reason: collision with root package name */
    public com.customize.contacts.widget.i f14294b0 = null;

    /* renamed from: c0, reason: collision with root package name */
    public GestureDetector f14296c0 = null;

    /* renamed from: d0, reason: collision with root package name */
    public f f14298d0 = null;

    /* renamed from: e0, reason: collision with root package name */
    public View.OnTouchListener f14300e0 = null;

    /* renamed from: f0, reason: collision with root package name */
    public boolean f14302f0 = false;

    /* renamed from: g0, reason: collision with root package name */
    public boolean f14304g0 = false;

    /* renamed from: k0, reason: collision with root package name */
    public volatile boolean f14312k0 = false;

    /* renamed from: l0, reason: collision with root package name */
    public int f14314l0 = E0.b.r();

    /* renamed from: o0, reason: collision with root package name */
    public final i f14320o0 = new i();

    /* renamed from: u0, reason: collision with root package name */
    public boolean f14329u0 = false;

    /* renamed from: v0, reason: collision with root package name */
    public boolean f14330v0 = false;

    /* renamed from: w0, reason: collision with root package name */
    public boolean f14331w0 = false;

    /* renamed from: y0, reason: collision with root package name */
    public boolean f14335y0 = false;

    /* renamed from: z0, reason: collision with root package name */
    public boolean f14337z0 = false;

    /* renamed from: A0, reason: collision with root package name */
    public boolean f14254A0 = false;

    /* renamed from: B0, reason: collision with root package name */
    public NafcNumState f14256B0 = NafcNumState.NAFC_NUMBER_QUERYING;

    /* renamed from: E0, reason: collision with root package name */
    public final Handler f14262E0 = new Handler(Looper.getMainLooper());

    /* renamed from: F0, reason: collision with root package name */
    public BreenoCallTipManager f14264F0 = null;

    /* renamed from: G0, reason: collision with root package name */
    public boolean f14266G0 = false;

    /* renamed from: H0, reason: collision with root package name */
    public boolean f14268H0 = false;

    /* renamed from: I0, reason: collision with root package name */
    public AutoCallSummaryTipManager f14270I0 = null;

    /* renamed from: J0, reason: collision with root package name */
    public NewCallRepository f14272J0 = null;

    /* renamed from: K0, reason: collision with root package name */
    public com.android.contacts.framework.baseui.util.t f14274K0 = new a();

    /* renamed from: L0, reason: collision with root package name */
    public final androidx.lifecycle.w<Boolean> f14276L0 = new androidx.lifecycle.w() { // from class: com.android.contacts.detail.t
        @Override // androidx.lifecycle.w
        public final void onChanged(Object obj) {
            CallDetailUnfamiliarNumberFragment.this.k2((Boolean) obj);
        }
    };

    /* loaded from: classes.dex */
    public enum NafcNumState {
        NAFC_NUMBER_QUERYING,
        NAFC_NUMBER_NORMAL,
        NAFC_NUMBER_FRAUD
    }

    /* loaded from: classes.dex */
    public class a implements com.android.contacts.framework.baseui.util.t {
        public a() {
        }

        @Override // com.android.contacts.framework.baseui.util.t
        public void a(int i10, Object obj, Object obj2) {
            H7.b.e("UnfamiliarNumberFragment", "onCall: code: " + i10 + ", mShowCallSummaryTip: " + CallDetailUnfamiliarNumberFragment.this.f14268H0);
            if (i10 == 1) {
                CallDetailUnfamiliarNumberFragment.this.f14268H0 = true;
                CallDetailUnfamiliarNumberFragment.this.Y2();
            } else if (i10 == 0) {
                CallDetailUnfamiliarNumberFragment.this.b2();
                CallDetailUnfamiliarNumberFragment.this.f14268H0 = false;
            }
        }
    }

    /* loaded from: classes.dex */
    public class b extends AsyncTask<Void, Void, Void> {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Uri f14343a;

        public b(Uri uri) {
            this.f14343a = uri;
        }

        @Override // android.os.AsyncTask
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Void doInBackground(Void... voidArr) {
            FragmentActivity activity = CallDetailUnfamiliarNumberFragment.this.getActivity();
            if (activity == null) {
                return null;
            }
            ContentValues contentValues = new ContentValues();
            contentValues.put("is_read", Boolean.TRUE);
            G7.c.g(activity.getContentResolver(), this.f14343a, contentValues, "is_read = 0", null);
            return null;
        }

        public void b() {
            executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, null);
        }
    }

    /* loaded from: classes.dex */
    public class c extends BroadcastReceiver {
        public c() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            IRecognitionNumber iRecognitionNumber = (IRecognitionNumber) C7.e.j(intent, "markedRecognitionNumber");
            CallDetailUnfamiliarNumberFragment.log("mNumberMarkUpdateReceiver: recognitionNumber = ");
            if (iRecognitionNumber != null) {
                CallDetailUnfamiliarNumberFragment.this.f14308i0.f(iRecognitionNumber);
            }
            CallDetailUnfamiliarNumberFragment.this.z0();
        }
    }

    /* loaded from: classes.dex */
    public class d implements ViewTreeObserver.OnGlobalLayoutListener {

        /* renamed from: a, reason: collision with root package name */
        public int f14346a = -1;

        public d() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            if (CallDetailUnfamiliarNumberFragment.this.f14253A != null && CallDetailUnfamiliarNumberFragment.this.f14257C != null && CallDetailUnfamiliarNumberFragment.this.f14285U != null && CallDetailUnfamiliarNumberFragment.this.f14255B != null && CallDetailUnfamiliarNumberFragment.this.f14284T != null) {
                int height = ((CallDetailUnfamiliarNumberFragment.this.f14253A.getHeight() - CallDetailUnfamiliarNumberFragment.this.f14257C.getHeight()) - CallDetailUnfamiliarNumberFragment.this.f14255B.getListPaddingTop()) - CallDetailUnfamiliarNumberFragment.this.f14285U.getHeight();
                if (height < 0) {
                    height = 0;
                }
                if (this.f14346a == height) {
                    return;
                }
                H7.b.e("UnfamiliarNumberFragment", "onGlobalLayout remainHeight = " + height);
                CallDetailUnfamiliarNumberFragment.this.f14284T.setHeight(height);
                this.f14346a = height;
            }
        }
    }

    /* loaded from: classes.dex */
    public class e implements DialogInterface.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f14348a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f14349b;

        public e(boolean z10, String str) {
            this.f14348a = z10;
            this.f14349b = str;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i10) {
            if (this.f14348a) {
                CallDetailUnfamiliarNumberFragment.this.f14306h0.h(this.f14349b);
            } else {
                CallDetailUnfamiliarNumberFragment.this.f14306h0.k(this.f14349b);
            }
        }
    }

    /* loaded from: classes.dex */
    public class f extends GestureDetector.SimpleOnGestureListener {

        /* renamed from: a, reason: collision with root package name */
        public View f14351a;

        public void a(View view) {
            this.f14351a = view;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public void onLongPress(MotionEvent motionEvent) {
            View view = this.f14351a;
            if (view instanceof TextView) {
                view.setTag(((TextView) view).getText());
            } else {
                view.setTag(CallDetailUnfamiliarNumberFragment.this.f14311k);
            }
            if (!C0637b.h()) {
                CallDetailUnfamiliarNumberFragment.this.a3(this.f14351a, motionEvent);
            }
        }

        public f() {
        }
    }

    /* loaded from: classes.dex */
    public static class g implements BreenoCallTipManager.INumberTypeInfoQuery {
        public g() {
        }

        @Override // com.android.contacts.business.calllog.breenocall.detail.BreenoCallTipManager.INumberTypeInfoQuery
        public BreenoCallTipManager.NumberTypeInfo query(Context context, String str) {
            boolean z10;
            boolean z11;
            boolean z12 = true;
            boolean z13 = false;
            String str2 = OplusPhoneUtils.DeviceState.UNLOCK_DEVICE;
            String str3 = null;
            try {
                try {
                    Cursor e10 = G7.c.e(context.getContentResolver(), CallLog.Calls.CONTENT_URI, new String[]{"lookup_uri", "hasRecog"}, "number= ?", new String[]{str}, "date DESC");
                    if (e10 != null) {
                        try {
                            if (e10.moveToFirst()) {
                                str3 = e10.getString(0);
                                str2 = e10.getString(1);
                            }
                        } finally {
                        }
                    }
                    if (e10 != null) {
                        e10.close();
                    }
                } catch (Exception e11) {
                    H7.b.c("UnfamiliarNumberFragment", "Query number info exception: " + e11);
                }
                if (TextUtils.isEmpty(str3)) {
                    z11 = com.android.contacts.calllog.k.i1(str, str2);
                } else {
                    z11 = false;
                }
                if (!z11) {
                    try {
                        boolean g10 = com.android.contacts.framework.baseui.util.w.g(context, str);
                        if (!g10) {
                            ArrayList arrayList = new ArrayList();
                            arrayList.add(str);
                            z13 = BlackListUtils.d(context, arrayList).get("isBlackList").booleanValue();
                        }
                        z10 = z13;
                        z13 = g10;
                    } catch (Exception e12) {
                        e = e12;
                        z10 = false;
                        z13 = z11;
                        H7.b.c("UnfamiliarNumberFragment", "queryNumberInfo: exception: " + e);
                        z11 = z13;
                        return new BreenoCallTipManager.NumberTypeInfo(z12, z11, z10);
                    }
                } else {
                    z10 = false;
                }
                try {
                    H7.b.b("UnfamiliarNumberFragment", "queryEntity: [" + z13 + ", " + z11 + ", " + z10 + "]");
                    z12 = z13;
                } catch (Exception e13) {
                    e = e13;
                    z13 = z11;
                    H7.b.c("UnfamiliarNumberFragment", "queryNumberInfo: exception: " + e);
                    z11 = z13;
                    return new BreenoCallTipManager.NumberTypeInfo(z12, z11, z10);
                }
            } catch (Exception e14) {
                e = e14;
                z10 = false;
                H7.b.c("UnfamiliarNumberFragment", "queryNumberInfo: exception: " + e);
                z11 = z13;
                return new BreenoCallTipManager.NumberTypeInfo(z12, z11, z10);
            }
            return new BreenoCallTipManager.NumberTypeInfo(z12, z11, z10);
        }
    }

    /* loaded from: classes.dex */
    public class h implements ProximitySensorManager.b {

        /* renamed from: a, reason: collision with root package name */
        public final Runnable f14353a;

        /* renamed from: b, reason: collision with root package name */
        public final Runnable f14354b;

        /* loaded from: classes.dex */
        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                CallDetailUnfamiliarNumberFragment.this.f14253A.findViewById(R.id.blank).setVisibility(0);
                if (CallDetailUnfamiliarNumberFragment.this.getActivity() != null) {
                    ((AppCompatActivity) CallDetailUnfamiliarNumberFragment.this.getActivity()).getSupportActionBar().l();
                }
            }
        }

        /* loaded from: classes.dex */
        public class b implements Runnable {
            public b() {
            }

            @Override // java.lang.Runnable
            public void run() {
                CallDetailUnfamiliarNumberFragment.this.f14253A.findViewById(R.id.blank).setVisibility(8);
                if (CallDetailUnfamiliarNumberFragment.this.getActivity() != null) {
                    ((AppCompatActivity) CallDetailUnfamiliarNumberFragment.this.getActivity()).getSupportActionBar().C();
                }
            }
        }

        @Override // com.android.contacts.ProximitySensorManager.b
        public synchronized void a() {
            c();
            d(this.f14353a, 100L);
        }

        @Override // com.android.contacts.ProximitySensorManager.b
        public synchronized void b() {
            c();
            d(this.f14354b, 500L);
        }

        public synchronized void c() {
            View findViewById = CallDetailUnfamiliarNumberFragment.this.f14253A.findViewById(R.id.blank);
            findViewById.removeCallbacks(this.f14353a);
            findViewById.removeCallbacks(this.f14354b);
        }

        public final synchronized void d(Runnable runnable, long j10) {
            CallDetailUnfamiliarNumberFragment.this.f14253A.findViewById(R.id.blank).postDelayed(runnable, j10);
        }

        public h() {
            this.f14353a = new a();
            this.f14354b = new b();
        }
    }

    /* loaded from: classes.dex */
    public static class i {

        /* renamed from: a, reason: collision with root package name */
        public boolean f14358a;

        /* renamed from: b, reason: collision with root package name */
        public boolean f14359b;

        /* renamed from: c, reason: collision with root package name */
        public boolean f14360c;

        /* renamed from: d, reason: collision with root package name */
        public boolean f14361d;

        /* renamed from: e, reason: collision with root package name */
        public boolean f14362e;

        /* renamed from: f, reason: collision with root package name */
        public boolean f14363f;

        /* renamed from: g, reason: collision with root package name */
        public boolean f14364g;

        /* renamed from: h, reason: collision with root package name */
        public boolean f14365h;
    }

    private Intent U1() {
        Fragment parentFragment = getParentFragment();
        if (parentFragment instanceof BaseActivityFragment) {
            return ((BaseActivityFragment) parentFragment).t1();
        }
        return getActivity().getIntent();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a3(View view, MotionEvent motionEvent) {
        com.customize.contacts.widget.i iVar = this.f14294b0;
        if (iVar != null) {
            iVar.x(view);
            this.f14294b0.v(view, (int) motionEvent.getX(), (int) motionEvent.getY(), true);
        }
    }

    private boolean d3() {
        boolean z10;
        if (this.f14264F0 != null && isTipShownable() && (this.f14256B0 == NafcNumState.NAFC_NUMBER_NORMAL || !E0.a.d())) {
            z10 = this.f14264F0.trySaveContact();
        } else {
            z10 = false;
        }
        H7.b.b("UnfamiliarNumberFragment", "trySaveContact: hasBreenoCallInfo: " + z10);
        return z10;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean l2(View view, MotionEvent motionEvent) {
        this.f14298d0.a(view);
        return this.f14296c0.onTouchEvent(motionEvent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void log(String str) {
        H7.b.b("UnfamiliarNumberFragment", str);
    }

    public final boolean A2() {
        if (B3.a.u() && !this.f14290Z && !this.f14334y) {
            return true;
        }
        return false;
    }

    @Override // y0.c
    public void B0(boolean z10, boolean z11) {
        log("updateBlacklistAwareView: isAddedInBlackList = " + z10 + ", isAddedInWhiteList = " + z11);
        i iVar = this.f14320o0;
        iVar.f14358a = z10;
        iVar.f14359b = z11;
        g3();
    }

    public final void B2() {
        if (isAdded()) {
            Fragment parentFragment = getParentFragment();
            if (parentFragment instanceof BaseActivityFragment) {
                ((BaseActivityFragment) parentFragment).z1();
            } else {
                requireActivity().invalidateOptionsMenu();
            }
        }
    }

    public void C2() {
        FragmentActivity activity = getActivity();
        if (!C0792c.c(activity)) {
            return;
        }
        String str = C1501d.f36273b;
        if (com.android.contacts.framework.baseui.util.l.d(activity, str)) {
            com.android.contacts.framework.baseui.util.l.f(activity, str, null, 0);
        } else if (isAdded()) {
            U0.b bVar = new U0.b(activity, 2132083073);
            bVar.setTitle(R.string.dialog_title_remove_number_blacklist).setNegativeButton(android.R.string.cancel, (DialogInterface.OnClickListener) null).setNeutralButton((CharSequence) getString(R.string.remove), new DialogInterface.OnClickListener() { // from class: com.android.contacts.detail.u
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i10) {
                    CallDetailUnfamiliarNumberFragment.this.o2(dialogInterface, i10);
                }
            });
            U0.n.d(bVar.show());
        }
    }

    public void D2() {
        this.f14306h0.a(this.f14311k);
    }

    public void E2() {
        if (this.f14334y) {
            this.f14306h0.j(666, this.f14311k);
        } else {
            this.f14306h0.n(666, this.f14311k);
        }
    }

    public final void F2(Context context) {
        Intent intent = new Intent(C1498a.f36263v);
        intent.setPackage("com.android.server.telecom");
        context.sendBroadcast(intent);
    }

    public final void G1() {
        String str;
        String str2;
        if (C1641a.l(this.f14307i, FeatureOption.o()) && !TextUtils.isEmpty(this.f14326r0)) {
            String a10 = C1074c.a(this.f14311k, null, this.f14307i);
            if (C0637b.h()) {
                a10 = C0637b.d(a10);
            }
            this.f14265G.setText(a10);
            this.f14265G.setVisibility(0);
            return;
        }
        if (this.f14290Z) {
            if (!TextUtils.isEmpty(this.f14311k)) {
                str2 = PhoneNumberUtils.formatNumber(this.f14311k, this.f14319o);
            } else {
                str2 = "";
            }
            if (C0637b.h()) {
                str2 = C0637b.d(str2);
            }
            this.f14265G.setText(str2);
            this.f14265G.setVisibility(0);
            return;
        }
        if (this.f14308i0.j()) {
            if (C0637b.h()) {
                this.f14271J.setText(C0637b.d(this.f14311k));
            } else {
                String str3 = this.f14311k;
                if (TextUtils.isEmpty(this.f14319o)) {
                    str = C7.c.b(this.f14307i).a();
                } else {
                    str = this.f14319o;
                }
                this.f14271J.setText(PhoneNumberUtils.formatNumber(str3, str));
            }
            this.f14271J.setVisibility(0);
            this.f14265G.setVisibility(8);
            return;
        }
        if (this.f14308i0.l() != null && !TextUtils.isEmpty(this.f14308i0.l().f38245a)) {
            this.f14265G.setText(this.f14311k);
            this.f14265G.setVisibility(0);
        } else {
            this.f14306h0.g(C0801l.l(this.f14313l, this.f14311k, this.f14315m, this.f14319o), this.f14319o, (int) this.f14323q, this.f14315m, this, new InterfaceC1699a() { // from class: com.android.contacts.detail.q
                @Override // y0.InterfaceC1699a
                public final void a(String str4) {
                    CallDetailUnfamiliarNumberFragment.this.d2(str4);
                }
            });
        }
    }

    public void G2(PhoneCallDetails[] phoneCallDetailsArr) {
        this.f14309j = phoneCallDetailsArr;
        if (phoneCallDetailsArr != null && phoneCallDetailsArr.length > 0) {
            this.f14310j0 = phoneCallDetailsArr[0];
        } else {
            this.f14310j0 = null;
        }
        if (this.f14312k0) {
            H1();
        }
        Q1();
        z2();
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x002e, code lost:
    
        if (com.customize.contacts.util.J.o(r5.f13184r, r4, r3, r5.f13169c) != false) goto L12;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void H1() {
        /*
            Method dump skipped, instructions count: 295
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.contacts.detail.CallDetailUnfamiliarNumberFragment.H1():void");
    }

    public void H2(String str) {
        this.f14319o = str;
    }

    public final void I1(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.f14263F.setText(str);
            return;
        }
        if (this.f14290Z) {
            this.f14263F.setText(C0811w.d(this.f14307i, this.f14311k));
            return;
        }
        if (B3.a.u()) {
            if (this.f14308i0.k() != null && !TextUtils.isEmpty(this.f14308i0.k().f38247a)) {
                this.f14263F.setText(this.f14308i0.k().f38247a);
                this.f14254A0 = true;
                H7.b.e("UnfamiliarNumberFragment", "bindNumberOrNameView: is a service number.");
                return;
            } else if (this.f14308i0.l() != null && !TextUtils.isEmpty(this.f14308i0.l().f38245a)) {
                this.f14263F.setText(this.f14308i0.l().f38245a);
                this.f14337z0 = true;
                H7.b.e("UnfamiliarNumberFragment", "bindNumberOrNameView: is a special number.");
                return;
            }
        } else if (this.f14308i0.l() != null && !TextUtils.isEmpty(this.f14308i0.l().f38245a)) {
            this.f14263F.setText(this.f14308i0.l().f38245a);
            this.f14337z0 = true;
            H7.b.e("UnfamiliarNumberFragment", "bindNumberOrNameView: is a special number..");
            return;
        }
        if (C0637b.h()) {
            this.f14263F.setText(C0637b.d(C1074c.a(this.f14311k, null, this.f14307i)));
        } else {
            this.f14263F.setText(C1074c.a(this.f14311k, null, this.f14307i));
        }
        if (C1641a.l(this.f14307i, FeatureOption.o())) {
            H7.b.e("UnfamiliarNumberFragment", "bindNumberOrNameView fdn name:");
            if (!TextUtils.isEmpty(this.f14326r0)) {
                this.f14263F.setText(this.f14326r0);
                return;
            }
        }
        if (B3.a.f0() && this.f14307i != null) {
            if (TextUtils.equals(this.f14311k, "-100")) {
                this.f14263F.setText(this.f14307i.getResources().getString(R.string.anonymous_number));
            }
            if (TextUtils.equals(this.f14311k, "-101")) {
                this.f14263F.setText(this.f14307i.getResources().getString(R.string.unrecognized_number));
            }
            if (TextUtils.equals(this.f14311k, "-102")) {
                this.f14263F.setText(this.f14307i.getResources().getString(R.string.payphone_number));
                return;
            }
            return;
        }
        if (B3.a.D() && this.f14307i != null) {
            if (TextUtils.equals(this.f14311k, OplusPhoneUtils.DeviceState.INVALID_STATUS)) {
                this.f14263F.setText(R.string.unknown_number);
            }
            if (TextUtils.equals(this.f14311k, "-2")) {
                this.f14263F.setText(R.string.private_num);
            }
            if (TextUtils.equals(this.f14311k, "-3")) {
                this.f14263F.setText(this.f14307i.getResources().getString(R.string.payphone_number));
            }
        }
    }

    public void I2(CallDetailActivityFragment.g gVar) {
        this.f14286V = gVar;
    }

    public final void J1() {
        if (FeatureUtil.O() && FeatureUtil.L()) {
            int c10 = this.f14308i0.c();
            if (c10 > 0) {
                if (this.f14285U == null) {
                    this.f14285U = this.f14287W.inflate(R.layout.call_detail_unfamiliar_number_recognition, (ViewGroup) null);
                    final Pair<String, String> g10 = this.f14308i0.g(c10);
                    if (g10 != null && !TextUtils.isEmpty((CharSequence) g10.first) && !TextUtils.isEmpty((CharSequence) g10.second)) {
                        Context context = this.f14307i;
                        SpannableString b10 = U7.d.b(context, context.getString(R.string.number_provider_hint, g10.first), (CharSequence) g10.first, Integer.valueOf(this.f14307i.getColor(R.color.coui_clickable_text_color)), new InterfaceC1637a() { // from class: com.android.contacts.detail.l
                            @Override // v9.InterfaceC1637a
                            public final Object invoke() {
                                m9.q e22;
                                e22 = CallDetailUnfamiliarNumberFragment.this.e2(g10);
                                return e22;
                            }
                        });
                        TextView textView = (TextView) this.f14285U.findViewById(R.id.number_supplier_info);
                        textView.setMovementMethod(LinkMovementMethod.getInstance());
                        textView.setText(b10);
                        this.f14255B.addFooterView(this.f14285U);
                        this.f14285U.getViewTreeObserver().addOnGlobalLayoutListener(new d());
                        return;
                    }
                    H7.b.e("UnfamiliarNumberFragment", "numberNamePair error : " + g10);
                    return;
                }
                return;
            }
            View view = this.f14285U;
            if (view != null) {
                this.f14255B.removeFooterView(view);
                TextView textView2 = this.f14284T;
                textView2.setHeight(textView2.getContext().getResources().getDimensionPixelSize(R.dimen.DP_30));
                this.f14285U = null;
            }
        }
    }

    public void J2(boolean z10) {
        this.f14336z = z10;
    }

    public final void K1() {
        if (this.f14290Z) {
            this.f14277M.setImageResource(R.drawable.pb_ic_voice_mail);
            return;
        }
        if (B3.a.u()) {
            if (this.f14308i0.k() != null && !TextUtils.isEmpty(this.f14308i0.k().f38248b)) {
                this.f14277M.setHasBorder(true);
                this.f14289Y.j(this.f14277M, Uri.parse(this.f14308i0.k().f38248b), this.f14307i.getResources().getDimensionPixelOffset(R.dimen.color_detail_photo_size), false, false, null);
                return;
            } else if (this.f14308i0.l() != null && this.f14308i0.l().f38246b < 0) {
                this.f14277M.setHasBorder(true);
                this.f14289Y.q(this.f14277M, this.f14308i0.l().f38246b, false, false, null);
                return;
            } else {
                this.f14277M.setImageResource(R.drawable.pb_ic_default_large_photo);
                return;
            }
        }
        if (this.f14308i0.l() != null && this.f14308i0.l().f38246b < 0) {
            this.f14277M.setHasBorder(true);
            this.f14289Y.q(this.f14277M, this.f14308i0.l().f38246b, false, false, null);
        } else {
            this.f14277M.setImageResource(R.drawable.pb_ic_default_large_photo);
        }
    }

    public void K2(boolean z10) {
        this.f14330v0 = z10;
    }

    @Override // y0.c
    public void L0(Intent intent) {
        R7.b.c(this.f14307i, intent);
    }

    public final void L1() {
        RelativeLayout relativeLayout = this.f14318n0;
        if (relativeLayout != null && relativeLayout.findViewById(R.id.ted_more_relevant_numbers) != null) {
            View findViewById = this.f14318n0.findViewById(R.id.ted_more_relevant_numbers);
            View findViewById2 = this.f14318n0.findViewById(R.id.divider_more_relevant_numbers);
            if (findViewById != null) {
                if (this.f14308i0.k() != null && this.f14308i0.k().f38249c != null && this.f14308i0.k().f38249c.size() != 0) {
                    findViewById.setOnClickListener(new View.OnClickListener() { // from class: com.android.contacts.detail.m
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            CallDetailUnfamiliarNumberFragment.this.f2(view);
                        }
                    });
                    findViewById.setVisibility(0);
                    if (findViewById2 != null) {
                        findViewById2.setVisibility(0);
                    }
                    ((TextView) findViewById.findViewById(R.id.ted_numbers)).setText(String.format(this.f14307i.getString(R.string.ted_numbers), String.valueOf(this.f14308i0.k().f38249c.size())));
                    return;
                }
                findViewById.setVisibility(8);
                if (findViewById2 != null) {
                    findViewById2.setVisibility(8);
                }
            }
        }
    }

    public void L2(E e10) {
        this.f14295c = e10;
    }

    public final void M1() {
        if ((this.f14308i0.l() != null && this.f14308i0.l().f38246b < 0) || (this.f14308i0.b() != null && C1725e.r(this.f14308i0.b().e()))) {
            this.f14320o0.f14361d = false;
        } else {
            this.f14320o0.f14361d = true;
        }
    }

    public void M2(String str) {
        this.f14313l = str;
    }

    public final void N1() {
        if (this.f14308i0.j() && this.f14308i0.b() != null && !TextUtils.isEmpty(this.f14308i0.b().S())) {
            this.f14269I.setText(this.f14308i0.b().S());
            this.f14269I.setVisibility(0);
        }
    }

    public void N2(String str) {
        this.f14311k = str;
    }

    public final void O1() {
        if (v2()) {
            i3(false);
        } else if (!this.f14334y) {
            this.f14324q0.execute(new Runnable() { // from class: com.android.contacts.detail.i
                @Override // java.lang.Runnable
                public final void run() {
                    CallDetailUnfamiliarNumberFragment.this.h2();
                }
            });
        }
    }

    public final void O2() {
        this.f14322p0 = new c();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.oplus.contacts.display_settings_changed");
        X.a.b(this.f14307i).c(this.f14322p0, intentFilter);
    }

    public void P1() {
        try {
            C0792c.l(this, 6, D7.c.q(this.f14307i, Integer.valueOf((int) this.f14323q)));
        } catch (Exception unused) {
            H7.b.c("UnfamiliarNumberFragment", "startCallSettingsActivity error!");
        }
    }

    public void P2(com.android.contacts.calllog.I i10) {
        this.f14288X = i10;
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0085 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void Q1() {
        /*
            r13 = this;
            com.android.contacts.PhoneCallDetails[] r0 = r13.f14309j
            if (r0 == 0) goto L89
            int r1 = r0.length
            if (r1 != 0) goto L9
            goto L89
        L9:
            r1 = 0
            r0 = r0[r1]
            int r0 = r0.f13169c
            r13.f14314l0 = r0
            android.view.View r0 = r13.f14275L
            if (r0 == 0) goto L17
            r0.setVisibility(r1)
        L17:
            android.view.ViewGroup r0 = r13.f14261E
            if (r0 == 0) goto L1e
            r0.setVisibility(r1)
        L1e:
            com.android.contacts.PhoneCallDetails[] r0 = r13.f14309j
            int r0 = r0.length
            r2 = 3
            if (r0 <= r2) goto L25
            r0 = r2
        L25:
            android.view.ViewGroup r3 = r13.f14261E
            if (r3 == 0) goto L2c
            r3.removeAllViews()
        L2c:
            androidx.fragment.app.FragmentActivity r3 = r13.getActivity()
            if (r3 != 0) goto L3a
            java.lang.String r13 = "UnfamiliarNumberFragment"
            java.lang.String r0 = "buildCallLogEntries: activity is null!"
            H7.b.c(r13, r0)
            return
        L3a:
            if (r1 >= r0) goto L88
            com.android.contacts.PhoneCallDetails[] r4 = r13.f14309j
            r9 = r4[r1]
            android.view.LayoutInflater r4 = r13.f14287W
            r5 = 0
            r6 = 2131624277(0x7f0e0155, float:1.887573E38)
            android.view.View r4 = r4.inflate(r6, r5)
            E3.j$f r5 = new E3.j$f
            r5.<init>(r4, r6, r1)
            r4.setTag(r5)
            E3.j r5 = new E3.j
            r5.<init>(r3)
            com.android.contacts.detail.CallDetailActivityFragment$g r6 = r13.f14286V
            r5.x(r6)
            r6 = 1
            if (r0 != r6) goto L62
            r6 = 4
        L60:
            r12 = r6
            goto L6d
        L62:
            if (r1 != 0) goto L65
            goto L60
        L65:
            int r6 = r0 + (-1)
            if (r1 != r6) goto L6b
            r12 = r2
            goto L6d
        L6b:
            r6 = 2
            goto L60
        L6d:
            com.coui.appcompat.cardlist.COUICardListHelper.setItemCardBackground(r4, r12)
            android.view.ViewGroup r6 = r13.f14261E
            r6.addView(r4, r1)
            if (r9 == 0) goto L85
            com.customize.contacts.mediaplayer.RecordPlayerPresenter r6 = r13.f14333x0
            r5.A(r6)
            boolean r10 = r13.f14302f0
            r11 = 1
            r7 = 0
            r8 = 1
            r6 = r4
            r5.w(r6, r7, r8, r9, r10, r11, r12)
        L85:
            int r1 = r1 + 1
            goto L3a
        L88:
            return
        L89:
            android.view.View r0 = r13.f14275L
            r1 = 8
            if (r0 == 0) goto L92
            r0.setVisibility(r1)
        L92:
            android.view.ViewGroup r0 = r13.f14261E
            if (r0 == 0) goto La3
            r0.removeAllViews()
            android.view.ViewGroup r0 = r13.f14261E
            r0.setVisibility(r1)
            android.view.View r13 = r13.f14259D
            r13.setVisibility(r1)
        La3:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.contacts.detail.CallDetailUnfamiliarNumberFragment.Q1():void");
    }

    public void Q2(RecordPlayerPresenter recordPlayerPresenter) {
        this.f14333x0 = recordPlayerPresenter;
    }

    public void R1() {
        ViewStub viewStub = (ViewStub) this.f14257C.findViewById(R.id.ust_phone_entry_stub);
        if (viewStub != null) {
            viewStub.inflate();
        }
        View findViewById = this.f14257C.findViewById(R.id.actions_view_container);
        if (findViewById != null) {
            findViewById.setOnClickListener(this);
            findViewById.setBackground(this.f14307i.getDrawable(R.drawable.coui_preference_bg_selector));
            ViewStub viewStub2 = (ViewStub) findViewById.findViewById(R.id.video_call_action_view_stub);
            ViewStub viewStub3 = (ViewStub) findViewById.findViewById(R.id.rcs_state_button_view_stub);
            if (viewStub2 != null) {
                viewStub2.inflate();
            }
            if (viewStub3 != null) {
                viewStub3.inflate();
            }
        }
        TextView textView = (TextView) this.f14257C.findViewById(R.id.data);
        ImageView imageView = (ImageView) this.f14257C.findViewById(R.id.contact_detail_item_icon);
        this.f14267H = (TextView) this.f14257C.findViewById(R.id.place);
        final View findViewById2 = this.f14257C.findViewById(R.id.ust_rcs_state_container);
        View findViewById3 = this.f14257C.findViewById(R.id.secondary_action_view_container);
        final View findViewById4 = this.f14257C.findViewById(R.id.ust_rcs_action_view_container);
        final ImageView imageView2 = (ImageView) this.f14257C.findViewById(R.id.secondary_action_button);
        final ImageView imageView3 = (ImageView) this.f14257C.findViewById(R.id.ust_rcs_video_button);
        textView.setText(this.f14311k);
        imageView.setImageResource(R.drawable.pb_ic_call);
        imageView.setVisibility(0);
        if (findViewById3 != null) {
            findViewById3.setOnClickListener(this);
        }
        if (findViewById4 != null) {
            findViewById4.setOnClickListener(this);
        }
        if (findViewById3 != null) {
            findViewById3.setVisibility(0);
        }
        w0.j jVar = new w0.j() { // from class: com.android.contacts.detail.k
            @Override // w0.j
            public final void a(Object obj) {
                CallDetailUnfamiliarNumberFragment.this.j2(findViewById2, imageView2, findViewById4, imageView3, (Void) obj);
            }
        };
        jVar.a(null);
        C1643c.B(this.f14307i, this.f14311k, jVar);
    }

    public void R2(long j10) {
        this.f14325r = j10;
    }

    public void S1() {
        PhoneCallDetails[] phoneCallDetailsArr;
        CallDetailActivityFragment.g gVar = this.f14286V;
        if (gVar != null && (phoneCallDetailsArr = this.f14309j) != null && phoneCallDetailsArr.length > 0) {
            gVar.b(phoneCallDetailsArr);
        }
    }

    public void S2(long j10) {
        this.f14332x = j10;
    }

    public void T1(boolean z10) {
        this.f14299e.a(z10);
    }

    public void T2(int i10) {
        this.f14321p = i10;
    }

    public void U2(boolean z10) {
        this.f14302f0 = z10;
    }

    public ListView V1() {
        return this.f14255B;
    }

    public void V2(long j10) {
        this.f14323q = j10;
    }

    public NewCallRepository W1() {
        return this.f14272J0;
    }

    public void W2(String str, boolean z10) {
        int i10;
        int i11;
        if (z10) {
            boolean A10 = B3.a.A();
            i10 = R.string.dialog_title_add_number_blacklist;
            if (A10) {
                if (B3.a.Y()) {
                    i11 = R.string.intercept_number_use_third_mms_tips_v2;
                } else {
                    i11 = R.string.intercept_number_except_mms_tips_v2;
                }
            } else {
                i11 = R.string.intercept_number_tips_v2;
            }
        } else {
            boolean A11 = B3.a.A();
            i10 = R.string.dialog_title_add_number_whitelist;
            if (A11) {
                i11 = R.string.oplus_intercept_number_whitelist_except_mms_tips_v2;
            } else {
                i11 = R.string.oplus_intercept_number_whitelist_tips_v2;
            }
        }
        FragmentActivity activity = getActivity();
        if (activity == null) {
            return;
        }
        String str2 = C1501d.f36273b;
        if (com.android.contacts.framework.baseui.util.l.d(activity, str2)) {
            com.android.contacts.framework.baseui.util.l.f(activity, str2, null, 0);
            return;
        }
        U0.b bVar = new U0.b(activity, 2132083073);
        bVar.setTitle(i10).setMessage(i11).setNegativeButton(android.R.string.cancel, new DialogInterface.OnClickListener() { // from class: com.android.contacts.detail.w
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i12) {
                CallDetailUnfamiliarNumberFragment.this.p2(dialogInterface, i12);
            }
        }).setNeutralButton(R.string.add, (DialogInterface.OnClickListener) new e(z10, str));
        androidx.appcompat.app.b create = bVar.create();
        U0.n.d(create);
        if (isAdded() && !activity.isFinishing() && !activity.isDestroyed()) {
            create.show();
            bVar.updateViewAfterShown();
        }
    }

    public final b.a X1(Cursor cursor) {
        List<b.a> a10 = this.f14297d.a(cursor);
        if (a10.size() == 0) {
            return null;
        }
        if (a10.size() > 1) {
            H7.b.i("UnfamiliarNumberFragment", String.format("Expected 1, found (%d) num of status messages. Will use the first one.", Integer.valueOf(a10.size())));
        }
        return a10.get(0);
    }

    public void X2(boolean z10) {
        W2(this.f14311k, z10);
    }

    public final Uri Y1() {
        return (Uri) C7.e.j(getActivity().getIntent(), "EXTRA_VOICEMAIL_URI");
    }

    public final void Y2() {
        if (H7.a.b()) {
            H7.b.b("UnfamiliarNumberFragment", "showCallSummaryTip: " + this.f14266G0 + ", " + this.f14268H0);
        }
        if (this.f14266G0 && this.f14268H0) {
            AutoCallSummaryTipManager autoCallSummaryTipManager = this.f14270I0;
            View view = null;
            if (autoCallSummaryTipManager != null) {
                view = autoCallSummaryTipManager.getTipView(null, this.f14258C0);
            }
            if (view != null && !Z1(view, AutoCallSummaryTipManager.TIP_ID)) {
                view.setVisibility(0);
                view.setTag(AutoCallSummaryTipManager.TIP_ID);
                n2(view);
            }
        }
    }

    public final boolean Z1(View view, String str) {
        int childCount = this.f14258C0.getChildCount();
        boolean z10 = false;
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = this.f14258C0.getChildAt(i10);
            if (view == childAt && str.equals(childAt.getTag())) {
                z10 = true;
            }
        }
        H7.b.b("UnfamiliarNumberFragment", "Tipview[" + str + "] hasAdded: " + z10);
        return z10;
    }

    public final void Z2(final String str, final String str2) {
        U0.n.d(new U0.b(this.f14307i, 2132083077).setTitle(R.string.contact_number_provider_title).setItems(new CharSequence[]{this.f14307i.getString(R.string.place_call_contact), this.f14307i.getString(R.string.cancel)}, new DialogInterface.OnClickListener() { // from class: com.android.contacts.detail.o
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i10) {
                CallDetailUnfamiliarNumberFragment.this.q2(str2, str, dialogInterface, i10);
            }
        }).show());
    }

    public final boolean a2() {
        if (Y1() != null) {
            return true;
        }
        return false;
    }

    public final void b2() {
        ViewGroup viewGroup;
        AutoCallSummaryTipManager autoCallSummaryTipManager;
        View tipView;
        if (H7.a.b()) {
            H7.b.b("UnfamiliarNumberFragment", "hdieCallSummaryTip: " + this.f14266G0 + ", " + this.f14268H0);
        }
        if (this.f14266G0 && this.f14268H0 && (viewGroup = this.f14258C0) != null && (autoCallSummaryTipManager = this.f14270I0) != null && (tipView = autoCallSummaryTipManager.getTipView(null, viewGroup)) != null && Z1(tipView, AutoCallSummaryTipManager.TIP_ID)) {
            tipView.setVisibility(8);
            this.f14258C0.removeView(tipView);
        }
    }

    /* renamed from: b3, reason: merged with bridge method [inline-methods] */
    public final void n2(View view) {
        if (this.f14260D0 != -1) {
            this.f14258C0.removeAllViews();
            this.f14258C0.addView(view);
        }
    }

    public boolean c2() {
        com.customize.contacts.widget.i iVar = this.f14294b0;
        if (iVar != null && iVar.i()) {
            this.f14294b0.h();
            return true;
        }
        return false;
    }

    public final void c3() {
        if (this.f14318n0 == null) {
            this.f14318n0 = (RelativeLayout) this.f14287W.inflate(R.layout.ted_recognition_detail_view, (ViewGroup) null);
        }
        LinearLayout linearLayout = (LinearLayout) this.f14257C.findViewById(R.id.ted_detail_view_container);
        if (linearLayout.getChildAt(0) == null || linearLayout.getChildAt(0) != this.f14318n0) {
            if (this.f14318n0.getParent() != null) {
                ((ViewGroup) this.f14318n0.getParent()).removeView(this.f14318n0);
            }
            linearLayout.addView(this.f14318n0, 0);
        }
    }

    @Override // y0.c
    public void d0(InterfaceC1700b interfaceC1700b) {
        this.f14306h0 = interfaceC1700b;
    }

    public final /* synthetic */ void d2(String str) {
        if (getActivity() != null && !getActivity().isDestroyed()) {
            if (!TextUtils.isEmpty(str)) {
                if (C0637b.h()) {
                    this.f14265G.setVisibility(8);
                    return;
                }
                this.f14265G.setText(str);
                this.f14265G.setVisibility(0);
                TextView textView = this.f14267H;
                if (textView != null) {
                    textView.setText(str);
                    this.f14267H.setVisibility(0);
                    return;
                }
                return;
            }
            this.f14265G.setVisibility(8);
        }
    }

    public final /* synthetic */ m9.q e2(Pair pair) {
        Z2((String) pair.first, (String) pair.second);
        return null;
    }

    public final void e3() {
        boolean z10;
        boolean z11;
        boolean d10 = E0.a.d();
        if (this.f14308i0.b() != null) {
            z10 = this.f14308i0.b().a();
        } else {
            z10 = false;
        }
        if (d10 && z10) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            if (this.f14283S == null) {
                this.f14283S = this.f14282R.inflate().findViewById(R.id.national_anti_fraud_tips);
            }
            View view = this.f14283S;
            if (view != null) {
                view.setVisibility(0);
            }
            this.f14256B0 = NafcNumState.NAFC_NUMBER_FRAUD;
        } else {
            View view2 = this.f14283S;
            if (view2 != null) {
                view2.setVisibility(8);
            }
            this.f14256B0 = NafcNumState.NAFC_NUMBER_NORMAL;
        }
        if (H7.a.b()) {
            H7.b.b("UnfamiliarNumberFragment", "updateNAFCTips: show nafc-tips: " + z11 + ", nafc-enabled: " + d10 + ", is fraud: " + z10 + ", is service: " + this.f14254A0 + ", is special: " + this.f14337z0 + ", is blacklist: " + this.f14335y0);
        }
        x2();
    }

    @Override // y0.c, z0.InterfaceC1724d
    public void f(int i10, Intent intent) {
        if (isAdded()) {
            S7.b.b(this, intent, i10, 0);
        }
    }

    public final /* synthetic */ void f2(View view) {
        if (this.f14308i0.b() == null) {
            return;
        }
        com.ted.number.s.b(this.f14307i, this.f14308i0.b().getName(), this.f14308i0.b().o0(), this.f14316m0);
    }

    public final void f3() {
        if (this.f14330v0) {
            this.f14255B.setIsParentChildHierarchy(this.f14331w0);
        } else {
            this.f14255B.setIsParentChildHierarchy(false);
        }
    }

    public final /* synthetic */ void g2(boolean z10) {
        this.f14280P.setEnabled(z10);
        this.f14281Q.setEnabled(z10);
        this.f14279O.setEnabled(z10);
        E e10 = this.f14295c;
        if (e10 != null && e10.b()) {
            this.f14278N.setImageResource(R.drawable.pb_dr_detail_wifi_call);
            this.f14279O.setImageResource(R.drawable.pb_dr_video_wifi_call);
        } else {
            this.f14278N.setImageResource(R.drawable.pb_dr_detail_call);
            this.f14279O.setImageResource(R.drawable.pb_dr_video_call);
        }
        if ((B3.a.f0() && com.android.contacts.calllog.I.i(this.f14311k)) || (B3.a.D() && com.android.contacts.calllog.I.h(this.f14311k))) {
            this.f14280P.setEnabled(false);
            this.f14281Q.setEnabled(false);
            this.f14279O.setEnabled(false);
        }
    }

    public final void g3() {
        if (C0792c.c(getActivity())) {
            this.f14320o0.f14365h = this.f14308i0.j();
            Fragment parentFragment = getParentFragment();
            if (parentFragment instanceof CallDetailActivityFragment) {
                ((CallDetailActivityFragment) parentFragment).r6(this.f14320o0);
            }
        }
    }

    public final /* synthetic */ void h2() {
        final boolean z10 = false;
        if (com.android.contacts.framework.api.appstore.appinfo.a.k()) {
            Context context = getContext();
            if (context != null) {
                z10 = com.android.contacts.framework.api.appstore.simcard.a.f(context);
            }
        } else {
            E e10 = this.f14295c;
            if (e10 != null && e10.c() && this.f14295c.a()) {
                z10 = true;
            }
        }
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.runOnUiThread(new Runnable() { // from class: com.android.contacts.detail.j
                @Override // java.lang.Runnable
                public final void run() {
                    CallDetailUnfamiliarNumberFragment.this.g2(z10);
                }
            });
        }
    }

    public void h3() {
        O1();
    }

    public final /* synthetic */ void i2(View view, ImageView imageView, View view2, ImageView imageView2) {
        HashMap<String, Boolean> l10 = C1643c.l(this.f14307i, this.f14311k);
        C1643c.C(l10, this.f14307i, view, imageView);
        C1643c.D(l10, this.f14307i, view2, imageView2);
    }

    public final void i3(boolean z10) {
        int i10;
        View view = this.f14280P;
        if (z10) {
            i10 = 0;
        } else {
            i10 = 8;
        }
        view.setVisibility(i10);
    }

    @Override // com.android.contacts.business.calllog.breenocall.detail.BreenoCallTipManager.ITipController
    public boolean isTipShownable() {
        boolean z10;
        if (!this.f14335y0 && !this.f14337z0 && !this.f14254A0) {
            z10 = true;
        } else {
            z10 = false;
        }
        H7.b.b("UnfamiliarNumberFragment", "isTipShownable: " + z10 + "[" + this.f14335y0 + ", " + this.f14337z0 + ", " + this.f14254A0 + "]");
        return z10;
    }

    public final /* synthetic */ void j2(final View view, final ImageView imageView, final View view2, final ImageView imageView2, Void r12) {
        FragmentActivity activity = getActivity();
        if (activity != null && isAdded()) {
            activity.runOnUiThread(new Runnable() { // from class: com.android.contacts.detail.n
                @Override // java.lang.Runnable
                public final void run() {
                    CallDetailUnfamiliarNumberFragment.this.i2(view, imageView, view2, imageView2);
                }
            });
        }
    }

    public void j3() {
        if (this.f14321p > 1) {
            long j10 = this.f14323q;
            if (j10 >= 0) {
                this.f14290Z = this.f14288X.j(j10, this.f14311k, this.f14325r, this.f14332x);
                H7.b.b("UnfamiliarNumberFragment", "mIsVoicemailNumber = ");
            }
        }
        this.f14290Z = this.f14288X.k(this.f14311k);
        H7.b.b("UnfamiliarNumberFragment", "mIsVoicemailNumber = ");
    }

    public final /* synthetic */ void k2(Boolean bool) {
        H7.b.e("UnfamiliarNumberFragment", "OnChange: hasMessage: " + bool);
        if (getActivity() != null) {
            getActivity().runOnUiThread(new Runnable() { // from class: com.android.contacts.detail.x
                @Override // java.lang.Runnable
                public final void run() {
                    CallDetailUnfamiliarNumberFragment.this.B2();
                }
            });
        }
    }

    @Override // com.android.contacts.HandlerC0582c.a
    public void l(Cursor cursor) {
        if (cursor == null) {
            this.f14301f.setVisibility(8);
            return;
        }
        final b.a X12 = X1(cursor);
        if (X12 != null && X12.a()) {
            this.f14301f.setVisibility(0);
            this.f14303g.setText(X12.f17941c);
            int i10 = X12.f17942d;
            if (i10 != -1) {
                this.f14305h.setText(i10);
            }
            if (X12.f17943e != null) {
                this.f14305h.setClickable(true);
                this.f14305h.setOnClickListener(new View.OnClickListener() { // from class: com.android.contacts.detail.v
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        CallDetailUnfamiliarNumberFragment.this.r2(X12, view);
                    }
                });
                return;
            } else {
                this.f14305h.setClickable(false);
                return;
            }
        }
        this.f14301f.setVisibility(8);
    }

    public final /* synthetic */ boolean m2(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 2) {
            c2();
            return false;
        }
        return false;
    }

    public final /* synthetic */ void o2(DialogInterface dialogInterface, int i10) {
        this.f14306h0.c(this.f14311k);
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i10, int i11, Intent intent) {
        log("onActivityResult: " + i10 + ", " + i11);
        if (-1 == i11 && (i10 == 766 || i10 == 666)) {
            if (getActivity() != null && !getActivity().isFinishing()) {
                Fragment parentFragment = getParentFragment();
                if (parentFragment instanceof CallDetailActivityFragment) {
                    CallDetailActivityFragment callDetailActivityFragment = (CallDetailActivityFragment) parentFragment;
                    if (intent != null && intent.getData() != null) {
                        if (callDetailActivityFragment.E1()) {
                            callDetailActivityFragment.m6(intent);
                            return;
                        } else {
                            R7.b.c(getContext(), intent);
                            callDetailActivityFragment.o1();
                            return;
                        }
                    }
                    callDetailActivityFragment.o1();
                    return;
                }
                getActivity().finish();
                return;
            }
            return;
        }
        if (-1 == i11 && i10 == 201) {
            I1(C7.e.l(intent, "new_corrected_name"));
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.actions_view_container /* 2131427429 */:
            case R.id.call /* 2131427563 */:
            case R.id.layout_call /* 2131428245 */:
                if (this.f14334y) {
                    this.f14306h0.l(this.f14311k);
                    return;
                } else {
                    this.f14306h0.d(this.f14311k, this.f14319o, getActivity());
                    return;
                }
            case R.id.layout_sms /* 2131428248 */:
            case R.id.secondary_action_view_container /* 2131428906 */:
            case R.id.sms /* 2131429015 */:
                this.f14306h0.e(this.f14311k);
                return;
            case R.id.layout_video /* 2131428250 */:
            case R.id.ust_rcs_action_view_container /* 2131429331 */:
            case R.id.video_call /* 2131429348 */:
                this.f14306h0.m(this.f14311k, this.f14319o, getActivity());
                return;
            case R.id.more_call_log /* 2131428427 */:
                this.f14295c.d();
                return;
            default:
                return;
        }
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.f14331w0 = DisplayUtil.n(getActivity());
        f3();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        ArrayList<String> arrayList;
        super.onCreate(bundle);
        H7.b.b("UnfamiliarNumberFragment", "onCreate");
        this.f14307i = getActivity();
        Bundle extras = U1().getExtras();
        boolean z10 = false;
        if (extras != null) {
            this.f14311k = extras.getString("number", "");
            this.f14313l = extras.getString(BreenoCallContract.BaseColumns.NORMALIZED_NUMBER, "");
            if (CommonOSPublicFeature.h()) {
                this.f14315m = extras.getInt("roam_call_type", 0);
                H7.b.e("UnfamiliarNumberFragment", "mRoamType = " + this.f14315m);
            }
            this.f14323q = extras.getLong("simid", -1L);
            this.f14334y = extras.getBoolean("is_email", false);
            this.f14317n = extras.getString("has_recognized", OplusPhoneUtils.DeviceState.LOCK_DEVICE);
            if (extras.getBoolean("notify_from_telecom", false)) {
                F2(this.f14307i);
            }
            if (C1641a.l(this.f14307i, FeatureOption.o())) {
                this.f14326r0 = extras.getString("name", "");
            }
        }
        log("onCreate, mSimId = " + this.f14323q + ", mIsEmail = " + this.f14334y);
        this.f14297d = new VoicemailStatusHelperImpl();
        this.f14293b = new HandlerC0582c(this);
        this.f14289Y = Z0.b.g(this.f14307i);
        this.f14299e = new ProximitySensorManager(this.f14307i, this.f14291a);
        COUIStatusBarResponseUtil cOUIStatusBarResponseUtil = new COUIStatusBarResponseUtil(getActivity());
        this.f14292a0 = cOUIStatusBarResponseUtil;
        cOUIStatusBarResponseUtil.setStatusBarClickListener(this);
        Object[] objArr = 0;
        this.f14298d0 = new f();
        this.f14296c0 = new GestureDetector(this.f14307i, this.f14298d0);
        com.customize.contacts.widget.i iVar = new com.customize.contacts.widget.i(this.f14307i);
        this.f14294b0 = iVar;
        iVar.u(0);
        this.f14300e0 = new View.OnTouchListener() { // from class: com.android.contacts.detail.p
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                boolean l22;
                l22 = CallDetailUnfamiliarNumberFragment.this.l2(view, motionEvent);
                return l22;
            }
        };
        O2();
        this.f14324q0 = N7.a.a();
        this.f14327s0 = C1641a.h(this.f14307i, this);
        this.f14328t0 = C1641a.i(this.f14307i, this);
        if (C1643c.w()) {
            this.f14304g0 = true;
        }
        if (bundle != null) {
            this.f14311k = bundle.getString("number", OplusPhoneUtils.DeviceState.UNLOCK_DEVICE);
            this.f14335y0 = bundle.getBoolean("is_blacklist_record", false);
            this.f14337z0 = bundle.getBoolean("is_special_number", false);
            this.f14254A0 = bundle.getBoolean("is_service_number", false);
        }
        if (TextUtils.isEmpty(this.f14311k) && C7.e.c(U1(), "from_sms", false)) {
            this.f14311k = U7.f.f(C7.e.l(U1(), "contact_number"));
            z10 = true;
        }
        if (TextUtils.isEmpty(this.f14311k)) {
            this.f14311k = OplusPhoneUtils.DeviceState.UNLOCK_DEVICE;
        }
        if (H7.a.b()) {
            H7.b.b("UnfamiliarNumberFragment", "onCreate: " + this.f14335y0 + ", " + this.f14337z0 + ", " + this.f14254A0);
        }
        BreenoCallTipManager breenoCallTipManager = new BreenoCallTipManager(this.f14307i, this.f14311k, this, this.f14262E0);
        this.f14264F0 = breenoCallTipManager;
        if (z10) {
            breenoCallTipManager.setINumberTypeInfoQueryer(new g());
        }
        getLifecycle().a(this.f14264F0);
        this.f14270I0 = new AutoCallSummaryTipManager(this.f14307i, getLifecycle(), this.f14274K0);
        getLifecycle().a(this.f14270I0);
        ArrayList<String> arrayList2 = new ArrayList<>();
        arrayList2.add(this.f14311k);
        if (!TextUtils.isEmpty(this.f14313l)) {
            arrayList = new ArrayList<>();
            arrayList.add(this.f14313l);
        } else {
            arrayList = null;
        }
        this.f14270I0.asyncLoad(null, arrayList2, arrayList);
        NewCallRepository newCallRepository = new NewCallRepository(getContext(), getLifecycle());
        this.f14272J0 = newCallRepository;
        newCallRepository.k().i(this, this.f14276L0);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View view;
        this.f14287W = (LayoutInflater) getActivity().getSystemService("layout_inflater");
        View inflate = layoutInflater.inflate(R.layout.call_detail, viewGroup, false);
        this.f14253A = inflate;
        MultiChoiceListView multiChoiceListView = (MultiChoiceListView) inflate.findViewById(R.id.history);
        this.f14255B = multiChoiceListView;
        multiChoiceListView.setNestedScrollingEnabled(true);
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.large_toolbar_height) + getResources().getDimensionPixelSize(R.dimen.divider_background_height);
        this.f14255B.setPadding(0, dimensionPixelSize, 0, 0);
        this.f14255B.smoothScrollByOffset(-dimensionPixelSize);
        View inflate2 = this.f14287W.inflate(R.layout.call_detail_unfamiliar_number, (ViewGroup) null);
        this.f14257C = inflate2;
        this.f14259D = inflate2.findViewById(R.id.ted_more_call_log_bottom_divider);
        this.f14284T = com.android.contacts.util.C.a(requireContext(), this.f14255B);
        if (!CommonFeatureOption.j()) {
            this.f14257C.findViewById(R.id.detail_header_bottom_layout).setVisibility(8);
        }
        if (this.f14336z && (view = this.f14259D) != null) {
            view.setVisibility(8);
        }
        TextView textView = (TextView) this.f14257C.findViewById(R.id.number);
        this.f14263F = textView;
        textView.setOnTouchListener(this.f14300e0);
        this.f14263F.setOnClickListener(null);
        this.f14265G = (TextView) this.f14257C.findViewById(R.id.location);
        ColorRoundLocalImageView colorRoundLocalImageView = (ColorRoundLocalImageView) this.f14257C.findViewById(R.id.calls_detail_photo);
        this.f14277M = colorRoundLocalImageView;
        colorRoundLocalImageView.setEnabled(false);
        this.f14273K = (TextView) this.f14257C.findViewById(R.id.phone_flag);
        this.f14269I = (TextView) this.f14257C.findViewById(R.id.phone_type);
        this.f14271J = (TextView) this.f14257C.findViewById(R.id.phone_number);
        this.f14275L = this.f14257C.findViewById(R.id.more_call_log_container);
        if (this.f14336z) {
            this.f14257C.findViewById(R.id.voicemail_container).setVisibility(8);
            this.f14275L.setVisibility(8);
        }
        this.f14301f = this.f14257C.findViewById(R.id.voicemail_status);
        this.f14303g = (TextView) this.f14257C.findViewById(R.id.voicemail_status_message);
        this.f14305h = (TextView) this.f14257C.findViewById(R.id.voicemail_status_action);
        y2();
        this.f14261E = (ViewGroup) this.f14257C.findViewById(R.id.call_detail_number_list);
        this.f14255B.addHeaderView(this.f14257C);
        this.f14255B.setAdapter((ListAdapter) null);
        this.f14255B.setFocusable(false);
        this.f14255B.setOnTouchListener(new View.OnTouchListener() { // from class: com.android.contacts.detail.s
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view2, MotionEvent motionEvent) {
                boolean m22;
                m22 = CallDetailUnfamiliarNumberFragment.this.m2(view2, motionEvent);
                return m22;
            }
        });
        if (this.f14288X == null) {
            this.f14288X = new com.android.contacts.calllog.I(this.f14307i);
        }
        this.f14316m0 = R.string.dialog_detail_title;
        TextView textView2 = (TextView) this.f14257C.findViewById(R.id.more_call_log);
        textView2.setOnClickListener(this);
        COUITextViewCompatUtil.setPressRippleDrawable(textView2);
        View findViewById = this.f14257C.findViewById(R.id.detail_header_bottom_layout);
        View findViewById2 = this.f14257C.findViewById(R.id.layout_call);
        View findViewById3 = this.f14257C.findViewById(R.id.layout_sms);
        this.f14280P = this.f14257C.findViewById(R.id.layout_video);
        this.f14278N = (ImageView) this.f14257C.findViewById(R.id.call);
        ImageView imageView = (ImageView) this.f14257C.findViewById(R.id.sms);
        findViewById2.setOnClickListener(this);
        findViewById3.setOnClickListener(this);
        this.f14280P.setOnClickListener(this);
        TextView textView3 = (TextView) this.f14257C.findViewById(R.id.call_text);
        TextView textView4 = (TextView) this.f14257C.findViewById(R.id.sms_text);
        this.f14281Q = (TextView) this.f14257C.findViewById(R.id.video_text);
        findViewById3.setContentDescription(getString(R.string.sms));
        this.f14280P.setContentDescription(getString(R.string.video_call));
        this.f14279O = (ImageView) this.f14257C.findViewById(R.id.video_call);
        if (v2()) {
            this.f14280P.setVisibility(8);
        } else if (this.f14334y) {
            ((TextView) this.f14257C.findViewById(R.id.call_text)).setText(R.string.oplus_add_emailLabelsGroup);
            this.f14278N.setImageResource(R.drawable.pb_dr_detail_email);
            findViewById2.setContentDescription(getString(R.string.oplus_add_emailLabelsGroup));
            this.f14280P.setVisibility(8);
        } else {
            this.f14278N.setImageResource(R.drawable.pb_dr_detail_call);
            findViewById2.setContentDescription(getString(R.string.make_dial));
            this.f14280P.setVisibility(0);
        }
        if ((B3.a.f0() && com.android.contacts.calllog.I.i(this.f14311k)) || (B3.a.D() && com.android.contacts.calllog.I.h(this.f14311k))) {
            findViewById2.setEnabled(false);
            textView3.setEnabled(false);
            this.f14278N.setEnabled(false);
            findViewById3.setEnabled(false);
            textView4.setEnabled(false);
            imageView.setEnabled(false);
            this.f14280P.setEnabled(false);
            this.f14281Q.setEnabled(false);
            this.f14279O.setEnabled(false);
        }
        if (this.f14304g0) {
            if (findViewById != null) {
                findViewById.setVisibility(8);
            }
            if (this.f14311k != null) {
                R1();
            }
        }
        this.f14282R = (ViewStub) this.f14257C.findViewById(R.id.national_anti_fraud_tips);
        this.f14331w0 = DisplayUtil.n(getActivity());
        f3();
        this.f14258C0 = (ViewGroup) this.f14257C.findViewById(R.id.tips_layout);
        return this.f14253A;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        ColorRoundLocalImageView colorRoundLocalImageView;
        super.onDestroy();
        if (this.f14322p0 != null) {
            X.a.b(this.f14307i).e(this.f14322p0);
        }
        ThreadPoolExecutor threadPoolExecutor = this.f14324q0;
        if (threadPoolExecutor != null) {
            threadPoolExecutor.shutdown();
            this.f14324q0 = null;
        }
        w0.d dVar = this.f14327s0;
        if (dVar != null) {
            dVar.a();
        }
        Z0.b bVar = this.f14289Y;
        if (bVar != null && (colorRoundLocalImageView = this.f14277M) != null) {
            bVar.v(colorRoundLocalImageView);
        }
        w0.m mVar = this.f14328t0;
        if (mVar != null) {
            mVar.a();
        }
        this.f14260D0 = -1L;
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        H7.b.b("UnfamiliarNumberFragment", "onPause");
        T1(false);
        this.f14291a.c();
        com.customize.contacts.util.i0.b();
        this.f14292a0.onPause();
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        H7.b.b("UnfamiliarNumberFragment", "onResume");
        super.onResume();
        this.f14292a0.onResume();
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("number", this.f14311k);
        bundle.putBoolean("is_blacklist_record", this.f14335y0);
        bundle.putBoolean("is_special_number", this.f14337z0);
        bundle.putBoolean("is_service_number", this.f14254A0);
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        boolean z10;
        w0.d dVar;
        super.onStart();
        H7.b.b("UnfamiliarNumberFragment", "onStart");
        this.f14260D0 = System.currentTimeMillis();
        j3();
        I1(null);
        G1();
        if (this.f14336z && !FeatureOption.o()) {
            z10 = false;
        } else {
            z10 = true;
        }
        this.f14308i0.h(this.f14311k, this.f14323q, A2(), z10);
        h3();
        if (C1641a.l(this.f14307i, FeatureOption.o()) && (dVar = this.f14327s0) != null) {
            dVar.b(this.f14311k);
        }
        C1641a.v(this.f14328t0, this.f14311k, (int) this.f14323q);
        this.f14272J0.m(this.f14311k);
    }

    @Override // com.coui.appcompat.statusbar.COUIStatusBarResponseUtil.StatusBarClickListener
    public void onStatusBarClicked() {
        com.customize.contacts.util.i0.d(getActivity(), this.f14255B);
        c2();
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        c2();
    }

    @Override // com.android.contacts.business.calllog.breenocall.detail.BreenoCallTipManager.ITipController
    public void onTipDismiss(String str, boolean z10) {
        View view;
        int childCount = this.f14258C0.getChildCount();
        int i10 = 0;
        while (true) {
            if (i10 < childCount) {
                view = this.f14258C0.getChildAt(i10);
                if (str.equals(view.getTag())) {
                    break;
                } else {
                    i10++;
                }
            } else {
                view = null;
                break;
            }
        }
        H7.b.b("UnfamiliarNumberFragment", "onTipDismiss tipId: " + str + ", child: " + view + ", clicked: " + z10);
        if (view != null) {
            view.setVisibility(8);
            this.f14258C0.removeView(view);
            if (z10) {
                this.f14266G0 = false;
                return;
            }
            return;
        }
        Y2();
    }

    @Override // com.android.contacts.business.calllog.breenocall.detail.BreenoCallTipManager.ITipController
    public void onTipUpdated(String str) {
        final View view;
        H7.b.b("UnfamiliarNumberFragment", "onTipUpdated mNafcQueryState: " + this.f14256B0);
        if (this.f14256B0 != NafcNumState.NAFC_NUMBER_NORMAL && E0.a.d()) {
            NafcNumState nafcNumState = this.f14256B0;
            if (nafcNumState == NafcNumState.NAFC_NUMBER_QUERYING) {
                H7.b.b("UnfamiliarNumberFragment", "Nafc number querying...");
                return;
            } else {
                if (nafcNumState == NafcNumState.NAFC_NUMBER_FRAUD) {
                    H7.b.b("UnfamiliarNumberFragment", "Nafc number, do not show breeno tip.");
                    return;
                }
                return;
            }
        }
        if (isTipShownable()) {
            BreenoCallTipManager breenoCallTipManager = this.f14264F0;
            if (breenoCallTipManager != null) {
                view = breenoCallTipManager.getTipView();
            } else {
                view = null;
            }
            if (view != null) {
                if (!Z1(view, str)) {
                    view.setTag(str);
                    this.f14262E0.post(new Runnable() { // from class: com.android.contacts.detail.r
                        @Override // java.lang.Runnable
                        public final void run() {
                            CallDetailUnfamiliarNumberFragment.this.n2(view);
                        }
                    });
                    return;
                }
                return;
            }
            this.f14266G0 = true;
            Y2();
            return;
        }
        this.f14266G0 = true;
        Y2();
    }

    public final /* synthetic */ void p2(DialogInterface dialogInterface, int i10) {
        com.customize.contacts.util.h0.x(this.f14307i, "double_check", "no");
    }

    public final /* synthetic */ void q2(String str, String str2, DialogInterface dialogInterface, int i10) {
        H7.b.e("UnfamiliarNumberFragment", "ContactNumberInfoDialog which = " + i10);
        if (i10 == 0) {
            Intent intent = new Intent(com.android.contacts.framework.api.appstore.appinfo.a.d(), Uri.fromParts("tel", str, null));
            intent.setFlags(OplusPhoneCapabilities.CAPABILITY_SUPPORTS_RTT_REMOTE);
            com.android.contacts.framework.baseui.util.p.a(this.f14307i, intent);
            com.customize.contacts.util.h0.a0(str2);
        }
    }

    @Override // z0.InterfaceC1724d
    public void r(InterfaceC1721a interfaceC1721a) {
        this.f14308i0 = interfaceC1721a;
    }

    public final /* synthetic */ void r2(b.a aVar, View view) {
        R7.b.c(getActivity(), new Intent("android.intent.action.VIEW", aVar.f17943e));
    }

    @Override // com.android.contacts.business.calllog.breenocall.detail.BreenoCallTipManager.ITipController
    public void requestSaveContact(BreenoCallLogEntity breenoCallLogEntity) {
        if (C0792c.c(getActivity())) {
            Intent intent = new Intent("android.intent.action.INSERT", ContactsContract.Contacts.CONTENT_URI);
            intent.putExtra(BreenoCallContract.IntentExtras.BREENO_CALL_INFO, breenoCallLogEntity);
            intent.putExtra("destroy_previous_activity", true);
            intent.putExtra(OplusNumberMarkUtils.OplusContact.OPLUS_CONTACTS_FLAG_UNFAMILIAR_NUMBER, breenoCallLogEntity.getNumber());
            intent.setFlags(OplusPhoneCapabilities.MTK_CAPABILITY_VIDEO_RINGTONE);
            if (C0637b.h()) {
                intent.putExtra("edit_page_start_source", 3);
            }
            f(766, intent);
            C0636a.a(getActivity());
        }
    }

    public void s2() {
        this.f14308i0.e(201, this.f14311k);
        if (C0792c.c(getActivity())) {
            C0636a.a(getActivity());
        }
    }

    @Override // com.android.contacts.business.calllog.breenocall.detail.BreenoCallTipManager.ITipController
    public void setNumberInfo(boolean z10, boolean z11, boolean z12) {
        this.f14337z0 = z10;
        this.f14254A0 = z11;
        this.f14335y0 = z12;
    }

    public void t2() {
        this.f14308i0.i(767, this.f14311k, this.f14314l0);
    }

    public final void u2(Uri uri) {
        new b(uri).b();
    }

    public final boolean v2() {
        if (VirtualSupportUtils.m()) {
            return true;
        }
        return !PrimaryUserUtils.a();
    }

    public void w2(String str) {
        String str2;
        if (B3.a.u()) {
            if (this.f14308i0.k() != null && !TextUtils.isEmpty(this.f14308i0.k().f38247a)) {
                str2 = this.f14308i0.k().f38247a;
            } else {
                if (this.f14308i0.l() != null && !TextUtils.isEmpty(this.f14308i0.l().f38245a)) {
                    str2 = this.f14308i0.l().f38245a;
                }
                str2 = null;
            }
        } else {
            if (this.f14308i0.l() != null && !TextUtils.isEmpty(this.f14308i0.l().f38245a)) {
                str2 = this.f14308i0.l().f38245a;
            }
            str2 = null;
        }
        if (this.f14336z && this.f14334y) {
            this.f14306h0.f(766, this.f14311k, str);
        } else if (TextUtils.isEmpty(str2) && d3()) {
            return;
        } else {
            this.f14306h0.i(766, this.f14311k, str2, str);
        }
        FragmentActivity activity = getActivity();
        if (activity != null && !activity.isDestroyed() && !activity.isFinishing()) {
            C0636a.a(activity);
        }
    }

    @Override // w0.n
    public void x(String str) {
        H7.b.b("UnfamiliarNumberFragment", "updateSdnMark sdnMark");
        if (this.f14273K != null) {
            if (!TextUtils.isEmpty(str)) {
                this.f14329u0 = true;
                this.f14273K.setText(str);
                this.f14273K.setVisibility(0);
            } else if (this.f14329u0) {
                this.f14329u0 = false;
                this.f14273K.setVisibility(8);
            }
        }
    }

    public final void x2() {
        boolean z10;
        if (!isTipShownable()) {
            if (this.f14256B0 == NafcNumState.NAFC_NUMBER_NORMAL) {
                z10 = true;
            } else {
                z10 = false;
            }
            this.f14266G0 = z10;
            onTipDismiss(BreenoCallTipManager.TIP_ID, false);
            return;
        }
        NafcNumState nafcNumState = this.f14256B0;
        if (nafcNumState == NafcNumState.NAFC_NUMBER_NORMAL) {
            onTipUpdated(BreenoCallTipManager.TIP_ID);
        } else if (nafcNumState == NafcNumState.NAFC_NUMBER_FRAUD) {
            this.f14266G0 = false;
            onTipDismiss(BreenoCallTipManager.TIP_ID, false);
        }
    }

    @Override // w0.e
    public void y(String str) {
        if (C1641a.l(this.f14307i, FeatureOption.o())) {
            this.f14326r0 = str;
            if (!TextUtils.isEmpty(str)) {
                H7.b.e("UnfamiliarNumberFragment", "updateFdnName fdnName");
                TextView textView = this.f14263F;
                if (textView != null) {
                    textView.setText(str);
                }
                TextView textView2 = this.f14265G;
                if (textView2 != null) {
                    textView2.setText(this.f14311k);
                    this.f14265G.setVisibility(0);
                }
            }
        }
    }

    public final void y2() {
        View findViewById = this.f14257C.findViewById(R.id.voicemail_container);
        if (a2()) {
            s1.s sVar = new s1.s();
            Bundle bundle = new Bundle();
            bundle.putParcelable("EXTRA_VOICEMAIL_URI", Y1());
            if (C7.e.c(U1(), "EXTRA_VOICEMAIL_START_PLAYBACK", false)) {
                bundle.putBoolean("EXTRA_VOICEMAIL_START_PLAYBACK", true);
            }
            sVar.setArguments(bundle);
            findViewById.setVisibility(0);
            getActivity().getSupportFragmentManager().p().b(R.id.voicemail_container, sVar).j();
            this.f14293b.n(Y1());
            u2(Y1());
            return;
        }
        this.f14301f.setVisibility(8);
        findViewById.setVisibility(8);
    }

    @Override // z0.InterfaceC1724d
    public void z0() {
        if (getActivity() != null && !getActivity().isDestroyed()) {
            I1(null);
            K1();
            G1();
            boolean j10 = this.f14308i0.j();
            this.f14312k0 = false;
            if (A2() && !this.f14329u0) {
                if (j10) {
                    c3();
                    M1();
                    N1();
                    L1();
                    J1();
                } else {
                    this.f14312k0 = true;
                    H1();
                }
                if (v2()) {
                    i3(false);
                } else {
                    i3(!j10);
                }
            }
            g3();
            e3();
        }
    }

    public void z2() {
        this.f14306h0.b(this.f14311k, this);
    }
}
