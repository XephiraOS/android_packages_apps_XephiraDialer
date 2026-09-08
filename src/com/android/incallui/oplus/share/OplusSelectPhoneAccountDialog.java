package com.android.incallui.oplus.share;

import A2.v;
import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.hardware.display.DisplayManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.telecom.PhoneAccount;
import android.telecom.PhoneAccountHandle;
import android.telecom.TelecomManager;
import android.telephony.SubscriptionInfo;
import android.telephony.SubscriptionManager;
import android.util.SparseArray;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ListAdapter;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import androidx.lifecycle.w;
import com.android.incallui.InCallPresenter;
import com.android.incallui.Log;
import com.android.incallui.OplusFeatureOption;
import com.android.incallui.OplusPhoneUtils;
import com.android.incallui.R;
import com.android.incallui.mvvm.repository.dynamic.ResponsiveConfigRepository;
import com.android.incallui.oplus.share.OplusSelectPhoneAccountDialog;
import com.android.incallui.oplus.widgets.COUIThemeActivity;
import com.coui.appcompat.contextutil.COUIContextUtil;
import com.coui.appcompat.dialog.COUIAlertDialogBuilder;
import com.coui.appcompat.panel.COUIBottomSheetDialog;
import com.coui.appcompat.vibrateutil.VibrateUtils;
import com.internal_dependency.AddOnSdkDepends;
import f.C0991a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes.dex */
public class OplusSelectPhoneAccountDialog extends COUIThemeActivity implements DialogInterface.OnClickListener, DialogInterface.OnCancelListener, DialogInterface.OnDismissListener, DialogInterface.OnKeyListener {

    /* renamed from: c, reason: collision with root package name */
    public v f19085c;

    /* renamed from: d, reason: collision with root package name */
    public PhoneAccountHandle f19086d;

    /* renamed from: i, reason: collision with root package name */
    public ArrayList<PhoneAccountHandle> f19091i;

    /* renamed from: j, reason: collision with root package name */
    public SparseArray<ArrayList<PhoneAccountHandle>> f19092j;

    /* renamed from: k, reason: collision with root package name */
    public List<Map<String, Object>> f19093k;

    /* renamed from: l, reason: collision with root package name */
    public SubscriptionManager f19094l;

    /* renamed from: m, reason: collision with root package name */
    public TelecomManager f19095m;

    /* renamed from: a, reason: collision with root package name */
    public int f19083a = 0;

    /* renamed from: b, reason: collision with root package name */
    public Dialog f19084b = null;

    /* renamed from: e, reason: collision with root package name */
    public boolean f19087e = false;

    /* renamed from: f, reason: collision with root package name */
    public int f19088f = -1;

    /* renamed from: g, reason: collision with root package name */
    public boolean f19089g = false;

    /* renamed from: h, reason: collision with root package name */
    public String f19090h = null;

    /* renamed from: n, reason: collision with root package name */
    public AtomicBoolean f19096n = new AtomicBoolean(false);

    /* renamed from: o, reason: collision with root package name */
    public w<Integer> f19097o = new w() { // from class: A2.u
        @Override // androidx.lifecycle.w
        public final void onChanged(Object obj) {
            OplusSelectPhoneAccountDialog.this.K0((Integer) obj);
        }
    };

    /* renamed from: p, reason: collision with root package name */
    public SubscriptionManager.OnSubscriptionsChangedListener f19098p = new a();

    /* renamed from: q, reason: collision with root package name */
    public Handler f19099q = new b(Looper.getMainLooper());

    /* renamed from: r, reason: collision with root package name */
    public final BroadcastReceiver f19100r = new e();

    /* loaded from: classes.dex */
    public class a extends SubscriptionManager.OnSubscriptionsChangedListener {
        public a() {
        }

        @Override // android.telephony.SubscriptionManager.OnSubscriptionsChangedListener
        public void onSubscriptionsChanged() {
            if (OplusPhoneUtils.getAvailableCardSize(OplusSelectPhoneAccountDialog.this.getApplicationContext()) < 1) {
                OplusSelectPhoneAccountDialog.this.finish();
            }
        }
    }

    /* loaded from: classes.dex */
    public class b extends Handler {
        public b(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i10 = message.what;
            if (i10 != 1000) {
                if (i10 == 2000) {
                    OplusSelectPhoneAccountDialog.this.s0();
                }
            } else {
                if (Log.sDebug) {
                    Log.d(this, "run finish");
                }
                if (!OplusSelectPhoneAccountDialog.this.isFinishing()) {
                    OplusSelectPhoneAccountDialog.this.finish();
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class c extends SimpleAdapter {
        public c(Context context, List list, int i10, String[] strArr, int[] iArr) {
            super(context, list, i10, strArr, iArr);
        }

        public final void a(int i10, View view) {
            Resources resources;
            if (view == null || i10 != getCount() - 1 || (resources = OplusSelectPhoneAccountDialog.this.getResources()) == null) {
                return;
            }
            int dimensionPixelSize = resources.getDimensionPixelSize(R.dimen.alert_dialog_item_padding_offset);
            view.setPaddingRelative(view.getPaddingStart(), view.getPaddingTop(), view.getPaddingEnd(), view.getPaddingBottom() + dimensionPixelSize);
            view.setMinimumHeight(view.getMinimumHeight() + dimensionPixelSize);
        }

        @Override // android.widget.SimpleAdapter, android.widget.Adapter
        public View getView(int i10, View view, ViewGroup viewGroup) {
            View view2 = super.getView(i10, null, viewGroup);
            a(i10, view2);
            return view2;
        }
    }

    /* loaded from: classes.dex */
    public class d implements CompoundButton.OnCheckedChangeListener {
        public d() {
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z10) {
            OplusSelectPhoneAccountDialog.this.f19089g = z10;
        }
    }

    /* loaded from: classes.dex */
    public class e extends BroadcastReceiver {
        public e() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if (Log.sDebug) {
                Log.d(this, "onReceive... action = " + action);
            }
            if (OplusPhoneUtils.ACTION_SUBINFO_RECORD_UPDATED.equals(action) && OplusPhoneUtils.getAvailableCardSize(context) < 1) {
                OplusSelectPhoneAccountDialog.this.finish();
            }
        }
    }

    /* loaded from: classes.dex */
    public class f extends SparseArray<ArrayList<PhoneAccountHandle>> {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ArrayList f19106a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ArrayList f19107b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ ArrayList f19108c;

        public f(ArrayList arrayList, ArrayList arrayList2, ArrayList arrayList3) {
            this.f19106a = arrayList;
            this.f19107b = arrayList2;
            this.f19108c = arrayList3;
            put(0, arrayList);
            put(1, arrayList2);
            put(-1, arrayList3);
        }

        @Override // android.util.SparseArray
        public /* bridge */ /* synthetic */ SparseArray<ArrayList<PhoneAccountHandle>> clone() {
            return super.clone();
        }
    }

    /* loaded from: classes.dex */
    public @interface g {

        /* renamed from: e, reason: collision with root package name */
        public static final int[] f19110e = {0, 1, -1};
    }

    private void r0() {
        if (!isFinishing()) {
            v0(1);
        }
        v vVar = this.f19085c;
        if (vVar != null) {
            vVar.b();
        }
    }

    private void x0(int i10) {
        try {
            dismissDialog(i10);
        } catch (IllegalArgumentException unused) {
        }
    }

    public final List<Map<String, Object>> B0() {
        this.f19091i = null;
        try {
            ArrayList arrayList = new ArrayList();
            ArrayList<PhoneAccountHandle> arrayList2 = new ArrayList<>();
            for (int i10 : g.f19110e) {
                Iterator<PhoneAccountHandle> it = this.f19092j.get(i10).iterator();
                while (it.hasNext()) {
                    PhoneAccountHandle next = it.next();
                    HashMap hashMap = new HashMap();
                    hashMap.put("icon", Integer.valueOf(y0(i10)));
                    hashMap.put("account", z0(next));
                    arrayList.add(hashMap);
                    arrayList2.add(next);
                }
            }
            if (arrayList2.size() > 0) {
                this.f19091i = arrayList2;
            } else {
                Log.d("OplusSelectPhoneAccountDialog", "getDialogData: SuggestedPhoneAccounts is empty");
            }
            return arrayList;
        } catch (Exception e10) {
            Log.d("OplusSelectPhoneAccountDialog", "getDialogData: Exception: " + e10.getMessage());
            return new ArrayList();
        }
    }

    public final SparseArray<ArrayList<PhoneAccountHandle>> D0(ArrayList<PhoneAccountHandle> arrayList) {
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = new ArrayList();
        if (arrayList != null) {
            Iterator<PhoneAccountHandle> it = arrayList.iterator();
            while (it.hasNext()) {
                PhoneAccountHandle next = it.next();
                int c10 = A2.d.c(next);
                if (c10 != 0) {
                    if (c10 != 1) {
                        arrayList4.add(next);
                    } else {
                        arrayList3.add(next);
                    }
                } else {
                    arrayList2.add(next);
                }
            }
        }
        return new f(arrayList2, arrayList3, arrayList4);
    }

    public final boolean H0(int i10) {
        if (this.f19094l == null) {
            Log.d("OplusSelectPhoneAccountDialog", "isESim: mSubManager is null");
            return false;
        }
        if (androidx.core.content.b.a(this, "android.permission.READ_PHONE_STATE") != 0) {
            return false;
        }
        SubscriptionInfo activeSubscriptionInfoForSimSlotIndex = this.f19094l.getActiveSubscriptionInfoForSimSlotIndex(i10);
        if (activeSubscriptionInfoForSimSlotIndex == null) {
            Log.d("OplusSelectPhoneAccountDialog", "isESim: SubscriptionInfo is null");
            return false;
        }
        return activeSubscriptionInfoForSimSlotIndex.isEmbedded();
    }

    public final /* synthetic */ void K0(Integer num) {
        if (this.f19083a == 4 && ResponsiveConfigRepository.f18540a.F1()) {
            boolean compareAndSet = this.f19096n.compareAndSet(false, true);
            Log.d(this, "foldChangeObserver: needChangeToDefaultDisplay is " + compareAndSet);
            if (compareAndSet) {
                this.f19087e = true;
                x0(4);
            }
        }
    }

    public final /* synthetic */ void L0(PhoneAccountHandle phoneAccountHandle, View view) {
        this.f19085c.m(phoneAccountHandle, null, -1);
        v0(0);
    }

    public final /* synthetic */ void M0(PhoneAccountHandle phoneAccountHandle, View view) {
        this.f19085c.m(phoneAccountHandle, null, -1);
        v0(0);
    }

    public final /* synthetic */ void N0(COUIBottomSheetDialog cOUIBottomSheetDialog, DialogInterface dialogInterface) {
        ResponsiveConfigRepository.f18540a.h1().n(this.f19097o);
        if (L1.a.b(cOUIBottomSheetDialog)) {
            onCancel(dialogInterface);
        } else {
            onDismiss(dialogInterface);
        }
        if (this.f19096n.compareAndSet(true, false)) {
            this.f19099q.removeMessages(2000);
            this.f19099q.sendEmptyMessageDelayed(2000, 100L);
        }
    }

    public final /* synthetic */ void O0(COUIBottomSheetDialog cOUIBottomSheetDialog, DialogInterface dialogInterface) {
        this.f19096n.set(false);
        ResponsiveConfigRepository.f18540a.h1().j(this.f19097o);
        cOUIBottomSheetDialog.setPanelBackground(C0991a.b(this, R.drawable.fold_screen_dialog_background));
        L1.a.a(cOUIBottomSheetDialog);
    }

    public final Dialog Q0() {
        final COUIBottomSheetDialog cOUIBottomSheetDialog = new COUIBottomSheetDialog(this, R.style.DefaultBottomSheetDialog);
        View inflate = cOUIBottomSheetDialog.getLayoutInflater().inflate(R.layout.select_account_layout_for_fold_screen, (ViewGroup) null);
        if (inflate != null) {
            View findViewById = inflate.findViewById(R.id.account_btn_1);
            TextView textView = (TextView) inflate.findViewById(R.id.account_btn_label_1);
            Iterator<PhoneAccountHandle> it = this.f19092j.get(0).iterator();
            while (it.hasNext()) {
                final PhoneAccountHandle next = it.next();
                if (textView != null) {
                    textView.setText(z0(next));
                    if (H0(0)) {
                        textView.setCompoundDrawablesWithIntrinsicBounds(C0991a.b(this, R.drawable.incall_ic_select_account_esim), (Drawable) null, (Drawable) null, (Drawable) null);
                    }
                }
                if (findViewById != null) {
                    findViewById.setOnClickListener(new View.OnClickListener() { // from class: A2.q
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            OplusSelectPhoneAccountDialog.this.L0(next, view);
                        }
                    });
                }
            }
            View findViewById2 = inflate.findViewById(R.id.account_btn_2);
            TextView textView2 = (TextView) inflate.findViewById(R.id.account_btn_label_2);
            Iterator<PhoneAccountHandle> it2 = this.f19092j.get(1).iterator();
            while (it2.hasNext()) {
                final PhoneAccountHandle next2 = it2.next();
                if (textView2 != null) {
                    textView2.setText(z0(next2));
                    if (H0(1)) {
                        textView2.setCompoundDrawablesWithIntrinsicBounds(C0991a.b(this, R.drawable.incall_ic_select_account_esim), (Drawable) null, (Drawable) null, (Drawable) null);
                    }
                }
                if (findViewById2 != null) {
                    findViewById2.setOnClickListener(new View.OnClickListener() { // from class: A2.r
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            OplusSelectPhoneAccountDialog.this.M0(next2, view);
                        }
                    });
                }
            }
            cOUIBottomSheetDialog.setContentView(inflate);
        }
        cOUIBottomSheetDialog.setNavColor(0);
        cOUIBottomSheetDialog.setIsShowInMaxHeight(true);
        cOUIBottomSheetDialog.setCanceledOnTouchOutside(false);
        cOUIBottomSheetDialog.setOnCancelListener(this);
        cOUIBottomSheetDialog.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: A2.s
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface dialogInterface) {
                OplusSelectPhoneAccountDialog.this.N0(cOUIBottomSheetDialog, dialogInterface);
            }
        });
        cOUIBottomSheetDialog.setOnKeyListener(this);
        cOUIBottomSheetDialog.setOnShowListener(new DialogInterface.OnShowListener() { // from class: A2.t
            @Override // android.content.DialogInterface.OnShowListener
            public final void onShow(DialogInterface dialogInterface) {
                OplusSelectPhoneAccountDialog.this.O0(cOUIBottomSheetDialog, dialogInterface);
            }
        });
        return cOUIBottomSheetDialog;
    }

    public void R0() {
        try {
            registerReceiver(this.f19100r, new IntentFilter(OplusPhoneUtils.ACTION_SUBINFO_RECORD_UPDATED), 2);
        } catch (Exception e10) {
            Log.d("OplusSelectPhoneAccountDialog", "Exception: " + e10.toString());
        }
    }

    public void T0() {
        try {
            unregisterReceiver(this.f19100r);
        } catch (Exception e10) {
            Log.d("OplusSelectPhoneAccountDialog", "Exception: " + e10.toString());
        }
    }

    public final void U0(boolean z10) {
        Window window = getWindow();
        if (window == null) {
            Log.d("OplusSelectPhoneAccountDialog", "setBackgroundDimEnabled: window is null, ignore");
        } else if (z10) {
            Log.d("OplusSelectPhoneAccountDialog", "setBackgroundDimEnabled: enable background dim");
            window.addFlags(2);
        } else {
            Log.d("OplusSelectPhoneAccountDialog", "setBackgroundDimEnabled: disable background dim");
            window.clearFlags(2);
        }
    }

    public final void Y0() {
        OplusPhoneUtils.setDefaultDisplayResources(getResources());
        U0(true);
    }

    public final void b1(PhoneAccountHandle phoneAccountHandle, int i10) {
        this.f19087e = true;
        x0(1);
        this.f19086d = phoneAccountHandle;
        showDialog(i10);
    }

    @Override // android.app.Activity
    public void finish() {
        super.finish();
        if (Log.sDebug) {
            Log.d(this, "real finish");
        }
        v vVar = this.f19085c;
        if (vVar != null) {
            vVar.p(null);
            this.f19085c.f();
        }
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        if (Log.sDebug) {
            Log.d("OplusSelectPhoneAccountDialog", "mAlertDialog onCancel");
        }
        if (this.f19087e) {
            this.f19087e = false;
        } else {
            r0();
        }
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i10) {
        if (Log.sDebug) {
            Log.d("OplusSelectPhoneAccountDialog", "which :" + i10);
        }
        v vVar = this.f19085c;
        if (vVar == null) {
            return;
        }
        if (i10 == -1) {
            int i11 = this.f19083a;
            if (i11 != 2) {
                if (i11 == 3) {
                    if (this.f19089g) {
                        OplusPhoneUtils.setRakutenPrefixPreferenceValue(this, 0);
                    }
                    this.f19085c.m(this.f19086d, null, 1);
                    v0(0);
                    return;
                }
                return;
            }
            vVar.m(this.f19086d, "+81", -1);
            v0(0);
            return;
        }
        if (i10 == -3) {
            if (this.f19083a == 2) {
                vVar.m(this.f19086d, null, -1);
                v0(0);
                return;
            }
            return;
        }
        if (i10 == -2) {
            int i12 = this.f19083a;
            if (i12 != 1) {
                if (i12 == 3) {
                    if (this.f19089g) {
                        OplusPhoneUtils.setRakutenPrefixPreferenceValue(this, 1);
                    }
                    this.f19085c.m(this.f19086d, null, 0);
                    v0(0);
                    return;
                }
                return;
            }
            r0();
            return;
        }
        ArrayList<PhoneAccountHandle> arrayList = this.f19091i;
        if (arrayList != null && i10 >= 0 && i10 < arrayList.size()) {
            PhoneAccountHandle phoneAccountHandle = this.f19091i.get(i10);
            int c10 = A2.d.c(phoneAccountHandle);
            int d10 = A2.d.d(phoneAccountHandle);
            Uri h10 = this.f19085c.h();
            if (OplusPhoneUtils.shouldShowDialogForJapan(this, h10, c10, A2.d.d(phoneAccountHandle))) {
                b1(phoneAccountHandle, 2);
                return;
            }
            if (!this.f19085c.l(h10) && !this.f19085c.k(h10) && OplusPhoneUtils.shouldCheckRakutenPrefix(this, h10, c10, d10)) {
                int rakutenPrefixPreferenceValue = OplusPhoneUtils.getRakutenPrefixPreferenceValue(this);
                if (rakutenPrefixPreferenceValue == 0) {
                    this.f19085c.m(phoneAccountHandle, null, 1);
                    v0(0);
                    return;
                } else if (rakutenPrefixPreferenceValue == 2) {
                    b1(phoneAccountHandle, 3);
                    return;
                } else if (rakutenPrefixPreferenceValue == 1) {
                    this.f19085c.m(phoneAccountHandle, null, 0);
                    v0(0);
                    return;
                }
            }
            this.f19085c.m(phoneAccountHandle, null, -1);
            v0(0);
            return;
        }
        r0();
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (Log.sDebug) {
            Log.d(this, "dialog onCreate");
        }
        this.f19090h = OplusPhoneUtils.getRakutenPrefixString(this);
        v oplusSelectPhoneAccountManager = InCallPresenter.getInstance().realInstance().getOplusSelectPhoneAccountManager();
        this.f19085c = oplusSelectPhoneAccountManager;
        if (oplusSelectPhoneAccountManager != null) {
            oplusSelectPhoneAccountManager.p(this);
        }
        Intent intent = getIntent();
        this.f19086d = (PhoneAccountHandle) intent.getParcelableExtra("android.telecom.extra.PHONE_ACCOUNT_HANDLE");
        this.f19088f = intent.getIntExtra("dialog_type", 0);
        this.f19094l = (SubscriptionManager) getSystemService("telephony_subscription_service");
        this.f19095m = (TelecomManager) getSystemService("telecom");
        this.f19092j = D0(intent.getParcelableArrayListExtra("selectPhoneAccountAccounts"));
        this.f19093k = B0();
        if (OplusFeatureOption.VERSION_STORE) {
            if (((DisplayManager) getSystemService(DisplayManager.class)).getDisplay(1) != null && L1.c.g(getApplicationContext())) {
                t0();
            } else {
                Y0();
            }
        } else if (getDisplayId() == 0) {
            Y0();
        } else {
            t0();
        }
        if (this.f19086d != null) {
            int i10 = this.f19088f;
            if (i10 == 1) {
                showDialog(2);
            } else if (i10 == 2) {
                showDialog(3);
            }
        } else if (this.f19091i != null) {
            if (this.f19088f == 3) {
                showDialog(4);
            } else {
                showDialog(1);
            }
        }
        overridePendingTransition(R.anim.oplus_incall_bottom_dialog_enter, R.anim.oplus_incall_bottom_dialog_exit);
        R0();
        OplusPhoneUtils.oplusAddOnSubscriptionsChangedListener(this, this.f19098p);
    }

    @Override // android.app.Activity
    public Dialog onCreateDialog(int i10) {
        if (i10 != 1) {
            if (i10 != 2) {
                if (i10 != 3) {
                    if (i10 == 4) {
                        this.f19084b = Q0();
                    }
                } else {
                    View inflate = ((LayoutInflater) getSystemService("layout_inflater")).inflate(R.layout.oplus_dialog_view_with_checkbox, (ViewGroup) null);
                    ((TextView) inflate.findViewById(R.id.oplus_dialog_content)).setText(getString(R.string.Rakuten_prefix_dialog_message, this.f19090h));
                    CheckBox checkBox = (CheckBox) inflate.findViewById(R.id.oplus_remember);
                    this.f19089g = false;
                    checkBox.setChecked(false);
                    checkBox.setOnCheckedChangeListener(new d());
                    this.f19084b = new COUIAlertDialogBuilder(this).setTitle(R.string.Rakuten_dialog_title).setView(inflate).setPositiveButton(R.string.Rakuten_prefix_dialog_use, this).setNegativeButton(R.string.Rakuten_prefix_dialog_not_use, this).setOnKeyListener(this).setOnCancelListener(this).setOnDismissListener(this).create();
                }
            } else {
                this.f19084b = new COUIAlertDialogBuilder(this, R.style.COUIAlertDialog_Bottom).setPositiveButton((CharSequence) getString(R.string.oplus_call_to_japan), (DialogInterface.OnClickListener) this).setNeutralButton((CharSequence) getString(R.string.oplus_call_this_number), (DialogInterface.OnClickListener) this).setNegativeButton(android.R.string.cancel, (DialogInterface.OnClickListener) this).setOnKeyListener(this).setOnCancelListener(this).setOnDismissListener(this).create();
            }
        } else {
            this.f19084b = new COUIAlertDialogBuilder(this, R.style.COUIAlertDialog_Bottom).setMessage(R.string.select_phone_account_dialog_title).setAdapter((ListAdapter) new c(this, this.f19093k, R.layout.select_account_dialog_layout, new String[]{"icon", "account"}, new int[]{R.id.select_account_ic, R.id.select_account_txt}), (DialogInterface.OnClickListener) this).setNegativeButton(android.R.string.cancel, (DialogInterface.OnClickListener) this).setOnKeyListener(this).setOnCancelListener(this).setOnDismissListener(this).show();
        }
        return this.f19084b;
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.f19086d = null;
        T0();
        OplusPhoneUtils.oplusRemoveOnSubscriptionsChangedListener(this, this.f19098p);
        ResponsiveConfigRepository.f18540a.h1().n(this.f19097o);
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        if (Log.sDebug) {
            Log.d("OplusSelectPhoneAccountDialog", "mAlertDialog onDismiss");
        }
        if (this.f19087e) {
            this.f19087e = false;
        } else if (!isFinishing()) {
            u0();
        }
    }

    @Override // android.content.DialogInterface.OnKeyListener
    public boolean onKey(DialogInterface dialogInterface, int i10, KeyEvent keyEvent) {
        if (Log.sDebug) {
            Log.d("OplusSelectPhoneAccountDialog", "key code is :" + i10);
        }
        if (keyEvent != null && keyEvent.getAction() == 0) {
            return false;
        }
        if (i10 != 4) {
            if (i10 != 82) {
                return false;
            }
            return true;
        }
        r0();
        return true;
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        overridePendingTransition(R.anim.oplus_incall_bottom_dialog_enter, R.anim.oplus_incall_bottom_dialog_exit);
    }

    @Override // android.app.Activity
    public void onPrepareDialog(int i10, Dialog dialog) {
        Dialog dialog2;
        Button b10;
        super.onPrepareDialog(i10, dialog);
        this.f19083a = i10;
        if (2 == i10 && (dialog2 = this.f19084b) != null && (dialog2 instanceof androidx.appcompat.app.b) && (b10 = ((androidx.appcompat.app.b) dialog2).b(-3)) != null) {
            b10.setTextColor(COUIContextUtil.getAttrColor(getApplicationContext(), R.attr.couiColorPrimaryNeutral, 0));
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (Log.sDebug) {
            Log.d(this, "dialog onResume");
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
    }

    public final void s0() {
        Log.d("OplusSelectPhoneAccountDialog", "changeToDefaultDisplayDialog: ");
        Intent intent = getIntent();
        intent.putExtra("dialog_type", 0);
        L1.c.h(this, intent);
    }

    public final void t0() {
        AddOnSdkDepends.Companion.getSInstance().collapseDragonflyPanels();
        U0(false);
    }

    public void u0() {
        v0(0);
    }

    public void v0(int i10) {
        int i11;
        if (this.f19099q.hasMessages(1000)) {
            if (Log.sDebug) {
                Log.d("OplusSelectPhoneAccountDialog", "already finish return ");
                return;
            }
            return;
        }
        if (i10 != 0) {
            i11 = 260;
            if (i10 == 1 && this.f19083a == 3) {
                i11 = VibrateUtils.STRENGTH_OFFSET;
            }
        } else {
            i11 = 300;
        }
        x0(this.f19083a);
        if (Log.sDebug) {
            Log.d("OplusSelectPhoneAccountDialog", "delayToFinishActivity delay = " + i11);
        }
        this.f19099q.sendEmptyMessageDelayed(1000, i11);
    }

    public final int y0(int i10) {
        if (H0(i10)) {
            return R.drawable.incall_ic_select_account_esim;
        }
        if (i10 != 0) {
            if (i10 != 1) {
                return R.drawable.incall_ic_select_account_default;
            }
            return R.drawable.incall_ic_select_account_slot_2;
        }
        return R.drawable.incall_ic_select_account_slot_1;
    }

    public final String z0(PhoneAccountHandle phoneAccountHandle) {
        TelecomManager telecomManager = this.f19095m;
        if (telecomManager == null) {
            Log.d("OplusSelectPhoneAccountDialog", "getAccountLabel: mTelecomManager is null");
            return "";
        }
        PhoneAccount phoneAccount = telecomManager.getPhoneAccount(phoneAccountHandle);
        if (phoneAccount == null) {
            Log.d("OplusSelectPhoneAccountDialog", "getAccountLabel: PhoneAccount is null");
            return "";
        }
        CharSequence label = phoneAccount.getLabel();
        if (label == null) {
            Log.d("OplusSelectPhoneAccountDialog", "getAccountLabel: Label is null");
            return "";
        }
        return label.toString();
    }
}
