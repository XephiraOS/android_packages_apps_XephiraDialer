package com.android.contacts.editor;

import android.app.Activity;
import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Entity;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ResolveInfo;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Parcel;
import android.os.SystemClock;
import android.provider.ContactsContract;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.loader.app.a;
import com.android.contacts.ContactLoader;
import com.android.contacts.ContactSaveService;
import com.android.contacts.N0;
import com.android.contacts.Y0;
import com.android.contacts.activities.ContactEditorActivity;
import com.android.contacts.business.calllog.breenocall.BreenoCallContract;
import com.android.contacts.business.calllog.breenocall.BreenoCallLogEntity;
import com.android.contacts.business.calllog.breenocall.BreenoCallLogEntityUtils;
import com.android.contacts.business.calllog.breenocall.NameInfo;
import com.android.contacts.business.calllog.breenocall.OrgInfo;
import com.android.contacts.business.calllog.breenocall.PersonalInfo;
import com.android.contacts.business.calllog.breenocall.TitleInfo;
import com.android.contacts.business.calllog.breenocall.detail.BreenoCallUtils;
import com.android.contacts.business.calllog.breenocall.detail.widget.ChipGroupView;
import com.android.contacts.business.calllog.breenocall.detail.widget.FieldEditListener;
import com.android.contacts.business.calllog.breenocall.statistics.BreenoCallStatistics;
import com.android.contacts.editor.A;
import com.android.contacts.editor.B;
import com.android.contacts.editor.ContactEditorFragment;
import com.android.contacts.editor.RawContactReadOnlyEditorView;
import com.android.contacts.framework.baseui.sim.SimContactInfo;
import com.android.contacts.framework.baseui.util.C0636a;
import com.android.contacts.framework.baseui.util.C0638c;
import com.android.contacts.framework.omoji.utils.OmojiUtils;
import com.android.contacts.framework.phonenumber.PhoneNumberUtils;
import com.android.contacts.model.Account;
import com.android.contacts.model.AccountType;
import com.android.contacts.model.AccountWithDataSet;
import com.android.contacts.model.EntityDelta;
import com.android.contacts.model.EntityDeltaList;
import com.android.contacts.statistics.InputFieldUploadStatus;
import com.android.contacts.util.ContentAssociateCreator;
import com.android.incallui.OplusNumberMarkUtils;
import com.android.incallui.OplusPhoneCapabilities;
import com.android.incallui.OplusPhoneUtils;
import com.coui.appcompat.dialog.COUIAlertDialogBuilder;
import com.coui.appcompat.poplist.COUIPopupListWindow;
import com.coui.appcompat.poplist.PopupListItem;
import com.coui.appcompat.textviewcompatutil.COUITextViewCompatUtil;
import com.coui.appcompat.toolbar.COUIToolbar;
import com.customize.contacts.FeatureOption;
import com.customize.contacts.util.C0798i;
import com.customize.contacts.util.C0811w;
import com.customize.contacts.util.SoftKeyboardUtil;
import com.customize.contacts.util.W;
import com.customize.contacts.util.b0;
import com.customize.contacts.util.h0;
import com.customize.contacts.util.k0;
import com.customize.contacts.widget.EditRingtoneView;
import com.heytap.accessory.constant.AFConstants;
import com.oplus.dialer.R;
import com.oplus.foundation.util.OsUtils;
import com.oplus.foundation.util.systemcore.PrimaryUserUtils;
import com.oplus.omoji.ui.OmojiPanelFragment;
import java.io.File;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;
import m1.C1322s;
import n1.AbstractC1362a;
import o1.C1393c;
import q1.C1480a;
import r0.C1501d;

/* loaded from: classes.dex */
public class ContactEditorFragment extends Fragment implements RawContactReadOnlyEditorView.a, com.android.contacts.util.s, ContentAssociateCreator.a {

    /* renamed from: I0, reason: collision with root package name */
    public static boolean f15091I0 = false;

    /* renamed from: A0, reason: collision with root package name */
    public String f15093A0;

    /* renamed from: B0, reason: collision with root package name */
    public BreenoCallLogEntity f15095B0;

    /* renamed from: E, reason: collision with root package name */
    public Dialog f15100E;

    /* renamed from: F, reason: collision with root package name */
    public ContentAssociateCreator f15102F;

    /* renamed from: J, reason: collision with root package name */
    public Cursor f15109J;

    /* renamed from: K, reason: collision with root package name */
    public File f15110K;

    /* renamed from: L, reason: collision with root package name */
    public Context f15111L;

    /* renamed from: M, reason: collision with root package name */
    public String f15112M;

    /* renamed from: N, reason: collision with root package name */
    public Uri f15113N;

    /* renamed from: O, reason: collision with root package name */
    public Bundle f15114O;

    /* renamed from: P, reason: collision with root package name */
    public u f15115P;

    /* renamed from: Q, reason: collision with root package name */
    public long f15116Q;

    /* renamed from: R, reason: collision with root package name */
    public boolean f15117R;

    /* renamed from: S, reason: collision with root package name */
    public LinearLayout f15118S;

    /* renamed from: T, reason: collision with root package name */
    public EntityDeltaList f15119T;

    /* renamed from: V, reason: collision with root package name */
    public EntityDelta f15121V;

    /* renamed from: Y, reason: collision with root package name */
    public ViewIdGenerator f15124Y;

    /* renamed from: Z, reason: collision with root package name */
    public long f15125Z;

    /* renamed from: a, reason: collision with root package name */
    public TextFieldsEditorView f15126a;

    /* renamed from: a0, reason: collision with root package name */
    public int f15127a0;

    /* renamed from: b, reason: collision with root package name */
    public EditRingtoneView f15128b;

    /* renamed from: c0, reason: collision with root package name */
    public long f15131c0;

    /* renamed from: d0, reason: collision with root package name */
    public int f15133d0;

    /* renamed from: e, reason: collision with root package name */
    public com.customize.contacts.manager.z f15134e;

    /* renamed from: e0, reason: collision with root package name */
    public boolean f15135e0;

    /* renamed from: g0, reason: collision with root package name */
    public boolean f15139g0;

    /* renamed from: k, reason: collision with root package name */
    public AccountWithDataSet f15146k;

    /* renamed from: k0, reason: collision with root package name */
    public ThreadPoolExecutor f15147k0;

    /* renamed from: l0, reason: collision with root package name */
    public ExecutorService f15149l0;

    /* renamed from: p0, reason: collision with root package name */
    public Dialog f15157p0;

    /* renamed from: s0, reason: collision with root package name */
    public COUIToolbar f15162s0;

    /* renamed from: x, reason: collision with root package name */
    public View f15167x;

    /* renamed from: x0, reason: collision with root package name */
    public BaseRawContactEditorView f15168x0;

    /* renamed from: y, reason: collision with root package name */
    public ImageView f15169y;

    /* renamed from: c, reason: collision with root package name */
    public final s f15130c = new s();

    /* renamed from: d, reason: collision with root package name */
    public InputFieldUploadStatus f15132d = new InputFieldUploadStatus();

    /* renamed from: f, reason: collision with root package name */
    public String f15136f = R0.a.f3165a;

    /* renamed from: g, reason: collision with root package name */
    public String f15138g = R0.a.f3166b;

    /* renamed from: h, reason: collision with root package name */
    public String f15140h = null;

    /* renamed from: i, reason: collision with root package name */
    public int f15142i = -1;

    /* renamed from: j, reason: collision with root package name */
    public boolean f15144j = false;

    /* renamed from: l, reason: collision with root package name */
    public final List<String> f15148l = new ArrayList();

    /* renamed from: m, reason: collision with root package name */
    public boolean f15150m = false;

    /* renamed from: n, reason: collision with root package name */
    public boolean f15152n = false;

    /* renamed from: o, reason: collision with root package name */
    public ContactLoader.Result f15154o = null;

    /* renamed from: p, reason: collision with root package name */
    public final Object f15156p = new Object();

    /* renamed from: q, reason: collision with root package name */
    public androidx.appcompat.app.b f15158q = null;

    /* renamed from: r, reason: collision with root package name */
    public String f15160r = null;

    /* renamed from: z, reason: collision with root package name */
    public androidx.appcompat.app.b f15171z = null;

    /* renamed from: A, reason: collision with root package name */
    public COUIPopupListWindow f15092A = null;

    /* renamed from: B, reason: collision with root package name */
    public androidx.appcompat.app.b f15094B = null;

    /* renamed from: C, reason: collision with root package name */
    public ArrayList<Account> f15096C = null;

    /* renamed from: D, reason: collision with root package name */
    public int f15098D = -1;

    /* renamed from: G, reason: collision with root package name */
    public Bitmap f15104G = null;

    /* renamed from: H, reason: collision with root package name */
    public long f15106H = -1;

    /* renamed from: I, reason: collision with root package name */
    public long f15108I = -1;

    /* renamed from: U, reason: collision with root package name */
    public EntityDeltaList f15120U = null;

    /* renamed from: W, reason: collision with root package name */
    public EntityDelta f15122W = null;

    /* renamed from: X, reason: collision with root package name */
    public long f15123X = -1;

    /* renamed from: b0, reason: collision with root package name */
    public boolean f15129b0 = false;

    /* renamed from: f0, reason: collision with root package name */
    public boolean f15137f0 = true;

    /* renamed from: h0, reason: collision with root package name */
    public boolean f15141h0 = false;

    /* renamed from: i0, reason: collision with root package name */
    public boolean f15143i0 = false;

    /* renamed from: j0, reason: collision with root package name */
    public boolean f15145j0 = false;

    /* renamed from: m0, reason: collision with root package name */
    public final Object f15151m0 = new Object();

    /* renamed from: n0, reason: collision with root package name */
    public boolean f15153n0 = false;

    /* renamed from: o0, reason: collision with root package name */
    public long f15155o0 = -1;

    /* renamed from: q0, reason: collision with root package name */
    public Uri f15159q0 = null;

    /* renamed from: r0, reason: collision with root package name */
    public Uri f15161r0 = null;

    /* renamed from: t0, reason: collision with root package name */
    public boolean f15163t0 = true;

    /* renamed from: u0, reason: collision with root package name */
    public BroadcastReceiver f15164u0 = null;

    /* renamed from: v0, reason: collision with root package name */
    public boolean f15165v0 = false;

    /* renamed from: w0, reason: collision with root package name */
    public boolean f15166w0 = false;

    /* renamed from: y0, reason: collision with root package name */
    public Bundle f15170y0 = null;

    /* renamed from: z0, reason: collision with root package name */
    public Uri f15172z0 = null;

    /* renamed from: C0, reason: collision with root package name */
    public final EntityDelta.b f15097C0 = new r();

    /* renamed from: D0, reason: collision with root package name */
    public Handler f15099D0 = new w(this);

    /* renamed from: E0, reason: collision with root package name */
    public final a.InterfaceC0129a<ContactLoader.Result> f15101E0 = new q();

    /* renamed from: F0, reason: collision with root package name */
    public final a.InterfaceC0129a<Cursor> f15103F0 = new a();

    /* renamed from: G0, reason: collision with root package name */
    public final EditRingtoneView.b f15105G0 = new b();

    /* renamed from: H0, reason: collision with root package name */
    public final BroadcastReceiver f15107H0 = new g();

    /* loaded from: classes.dex */
    public class b implements EditRingtoneView.b {
        public b() {
        }

        @Override // com.customize.contacts.widget.EditRingtoneView.b
        public void a() {
            FragmentActivity activity;
            if (C7.a.a()) {
                H7.b.e("ContactEditorFragment", "filter click!");
                return;
            }
            if (ContactEditorFragment.this.l3() && ContactEditorFragment.this.isAdded() && (activity = ContactEditorFragment.this.getActivity()) != null) {
                if (com.android.contacts.util.w.k(activity, com.android.contacts.util.w.e())) {
                    ContactEditorFragment.this.X3();
                } else {
                    ContactEditorFragment.this.requestPermissions(new String[]{com.android.contacts.util.w.e()}, 11);
                }
            }
        }

        @Override // com.customize.contacts.widget.EditRingtoneView.b
        public void b() {
            FragmentActivity activity;
            if (ContactEditorFragment.this.l3() && ContactEditorFragment.this.isAdded() && (activity = ContactEditorFragment.this.getActivity()) != null && !ContactEditorFragment.this.f15163t0 && !com.android.contacts.util.w.k(activity, com.android.contacts.util.w.e())) {
                com.android.contacts.util.w.y(activity, false, null, com.android.contacts.util.w.e());
            }
        }
    }

    /* loaded from: classes.dex */
    public class c implements DialogInterface.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f15175a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Account f15176b;

        public c(int i10, Account account) {
            this.f15175a = i10;
            this.f15176b = account;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i10) {
            ContactEditorFragment.this.f15142i = this.f15175a;
            ContactEditorFragment.this.h4(this.f15176b);
            h0.J(ContactEditorFragment.this.f15111L, "yes");
        }
    }

    /* loaded from: classes.dex */
    public class e implements DialogInterface.OnClickListener {
        public e() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i10) {
            if (ContactEditorFragment.this.f15094B != null) {
                ContactEditorFragment.this.f15094B.dismiss();
            }
            h0.J(ContactEditorFragment.this.f15111L, "no");
        }
    }

    /* loaded from: classes.dex */
    public class f implements DialogInterface.OnDismissListener {
        public f() {
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            ContactEditorFragment.this.f15144j = false;
            if (ContactEditorFragment.this.f15157p0 != null) {
                ContactEditorFragment.this.f15157p0 = null;
            }
        }
    }

    /* loaded from: classes.dex */
    public class g extends BroadcastReceiver {
        public g() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            H7.b.b("ContactEditorFragment", "onReceive action : " + action);
            if (TextUtils.equals("com.oplus.contacts.action_SIM_ABSENT", action) && "com.android.oplus.sim".equals(ContactEditorFragment.this.f15138g) && ContactEditorFragment.this.f15115P != null) {
                ContactEditorFragment.this.f15115P.d();
            }
        }
    }

    /* loaded from: classes.dex */
    public class h implements androidx.fragment.app.x {
        public h() {
        }

        @Override // androidx.fragment.app.x
        public void a(String str, Bundle bundle) {
            int i10 = bundle.getInt("panel_request_type", -1);
            H7.b.e("ContactEditorFragment", "requestKey = " + str + ", type = " + i10);
            String str2 = null;
            if (i10 == 0) {
                ContactEditorFragment.this.f15168x0.setPhotoBitmap(null);
                ContactEditorFragment.this.f15170y0 = null;
                ContactEditorFragment.this.f15168x0.b(ContactEditorFragment.this.f15121V, null);
                return;
            }
            if (i10 == 1) {
                ContactEditorFragment contactEditorFragment = ContactEditorFragment.this;
                contactEditorFragment.f15106H = contactEditorFragment.f15168x0.getRawContactId();
                boolean z10 = bundle.getBoolean("delete_temp_photo_uri");
                String string = bundle.getString("new_crop_photo_uri");
                if (bundle.getBoolean("is_from_document") && string != null) {
                    ContactEditorFragment.this.f15159q0 = Uri.parse(string);
                }
                ContactEditorFragment.this.m4(z10);
                ContactEditorFragment.this.f15170y0 = null;
                ContactEditorFragment.this.f15168x0.b(ContactEditorFragment.this.f15121V, null);
                return;
            }
            if (i10 == 2) {
                ContactEditorFragment contactEditorFragment2 = ContactEditorFragment.this;
                contactEditorFragment2.f15106H = contactEditorFragment2.f15168x0.getRawContactId();
                String string2 = bundle.getString("contact_photo_uri");
                String string3 = bundle.getString("dial_photo_uri");
                String string4 = bundle.getString("dial_photo_bg_color");
                com.android.contacts.util.i.u(ContactEditorFragment.this.f15111L, Uri.parse(string2), ContactEditorFragment.this.f15159q0, false);
                ContactEditorFragment.this.m4(false);
                if (!TextUtils.isEmpty(string3) && !TextUtils.isEmpty(string4)) {
                    com.android.contacts.util.i.u(ContactEditorFragment.this.f15111L, Uri.parse(string3), ContactEditorFragment.this.f15172z0, false);
                    if (ContactEditorFragment.this.f15121V != null) {
                        str2 = ContactEditorFragment.this.f15121V.w("vnd.android.cursor.item/omoji_photo", "data1");
                    }
                    ContactEditorFragment contactEditorFragment3 = ContactEditorFragment.this;
                    contactEditorFragment3.f15170y0 = OmojiUtils.d(str2, contactEditorFragment3.f15172z0.toString(), string4);
                    ContactEditorFragment.this.f15168x0.b(ContactEditorFragment.this.f15121V, ContactEditorFragment.this.f15170y0);
                }
                OmojiUtils.m(ContactEditorFragment.this.getContext());
                return;
            }
            H7.b.c("ContactEditorFragment", "onFragmentResult ERROR");
        }
    }

    /* loaded from: classes.dex */
    public class i implements View.OnClickListener {
        public i() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (ContactEditorFragment.this.f15127a0 == 1) {
                com.android.contacts.framework.baseui.util.A.a(ContactEditorFragment.this.f15111L, 2000310, 200030259, null, false);
                ContactEditorFragment.this.f15121V.z0(1L);
                ContactEditorFragment.this.e4(2);
            }
        }
    }

    /* loaded from: classes.dex */
    public class j implements View.OnClickListener {
        public j() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ContactEditorFragment.this.f15115P.f();
            h0.P(ContactEditorFragment.this.f15111L, ContactEditorFragment.this.f15152n, "delete");
        }
    }

    /* loaded from: classes.dex */
    public class k implements View.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ TextView f15185a;

        public k(TextView textView) {
            this.f15185a = textView;
        }

        public final /* synthetic */ void b() {
            ContactEditorFragment.this.D4();
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (ContactEditorFragment.this.f15168x0 == null || ContactEditorFragment.this.f15168x0.getPhotoEditor() == null || !ContactEditorFragment.this.f15168x0.getPhotoEditor().y()) {
                ContactEditorFragment.this.D4();
            } else {
                ContactEditorFragment.this.f15168x0.getPhotoEditor().B();
                this.f15185a.postDelayed(new Runnable() { // from class: com.android.contacts.editor.p
                    @Override // java.lang.Runnable
                    public final void run() {
                        ContactEditorFragment.k.this.b();
                    }
                }, 100L);
            }
        }
    }

    /* loaded from: classes.dex */
    public class l implements View.OnClickListener {

        /* loaded from: classes.dex */
        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                boolean z10;
                FragmentActivity activity = ContactEditorFragment.this.getActivity();
                if (activity == null) {
                    return;
                }
                h0.M(activity, ContactEditorFragment.this.f15152n, "save_place");
                Intent intent = ContactEditorFragment.this.getActivity().getIntent();
                boolean l02 = b0.l0(activity) & (!C7.e.c(intent, "scan_qrcode", false));
                if (C7.e.l(intent, "business_card_photo_path") == null) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                ArrayList<Account> f10 = M3.c.f(activity, z10 & l02, true, false);
                Message message = new Message();
                message.obj = f10;
                message.what = 0;
                ContactEditorFragment.this.f15099D0.sendMessage(message);
                synchronized (ContactEditorFragment.this.f15151m0) {
                    ContactEditorFragment.this.f15151m0.notifyAll();
                }
            }
        }

        public l() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (!ContactEditorFragment.this.f15144j) {
                ContactEditorFragment.this.f15144j = true;
                if (!ContactEditorFragment.this.s3()) {
                    ContactEditorFragment.this.f15147k0.execute(new a());
                    ContactEditorFragment.this.L4();
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class m implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Uri f15189a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Uri f15190b;

        public m(Uri uri, Uri uri2) {
            this.f15189a = uri;
            this.f15190b = uri2;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.android.contacts.util.i.u(ContactEditorFragment.this.f15111L, this.f15189a, this.f15190b, false);
        }
    }

    /* loaded from: classes.dex */
    public class n implements Runnable {
        public n() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (ContactEditorFragment.this.f15111L != null) {
                C0798i.b(ContactEditorFragment.this.f15111L);
            }
        }
    }

    /* loaded from: classes.dex */
    public class o implements Runnable {
        public o() {
        }

        @Override // java.lang.Runnable
        public void run() {
            C0798i.c(ContactEditorFragment.this.f15111L);
            if (ContactEditorFragment.this.s3()) {
                W.h(ContactEditorFragment.this.f15111L);
                W.e(ContactEditorFragment.this.f15111L);
            }
        }
    }

    /* loaded from: classes.dex */
    public class p implements Runnable {
        public p() {
        }

        @Override // java.lang.Runnable
        public void run() {
            C0798i.c(ContactEditorFragment.this.f15111L);
            if (ContactEditorFragment.this.s3()) {
                W.h(ContactEditorFragment.this.f15111L);
                W.e(ContactEditorFragment.this.f15111L);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class r implements EntityDelta.b {

        /* renamed from: a, reason: collision with root package name */
        public final WeakReference<ContactEditorFragment> f15196a;

        public static /* synthetic */ void c(ContactEditorFragment contactEditorFragment) {
            contactEditorFragment.Z3(contactEditorFragment.f15162s0.getMenu());
        }

        @Override // com.android.contacts.model.EntityDelta.b
        public void a() {
            final ContactEditorFragment contactEditorFragment = this.f15196a.get();
            if (contactEditorFragment != null && contactEditorFragment.f15118S != null && contactEditorFragment.f15162s0 != null) {
                contactEditorFragment.f15118S.post(new Runnable() { // from class: com.android.contacts.editor.q
                    @Override // java.lang.Runnable
                    public final void run() {
                        ContactEditorFragment.r.c(ContactEditorFragment.this);
                    }
                });
            }
        }

        public r(ContactEditorFragment contactEditorFragment) {
            this.f15196a = new WeakReference<>(contactEditorFragment);
        }
    }

    /* loaded from: classes.dex */
    public class s implements Comparator<EntityDelta> {
        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(EntityDelta entityDelta, EntityDelta entityDelta2) {
            boolean z10 = false;
            if (entityDelta.equals(entityDelta2)) {
                return 0;
            }
            AbstractC1362a h10 = AbstractC1362a.h(ContactEditorFragment.this.f15111L);
            AccountType c10 = h10.c(entityDelta.N().z("account_type"), entityDelta.N().z("data_set"));
            AccountType c11 = h10.c(entityDelta2.N().z("account_type"), entityDelta2.N().z("data_set"));
            if (!c10.b() && c11.b()) {
                return 1;
            }
            if (c10.b() && !c11.b()) {
                return -1;
            }
            boolean z11 = c10 instanceof com.android.contacts.model.h;
            boolean z12 = c11 instanceof com.android.contacts.model.h;
            if (z11 && !z12) {
                return -1;
            }
            if (!z11 && z12) {
                return 1;
            }
            if (z11 && z12) {
                z10 = true;
            }
            if (!z10) {
                if (c10.f16944a == null || TextUtils.isEmpty(c11.f16944a)) {
                    return 1;
                }
                int compareTo = c10.f16944a.compareTo(c11.f16944a);
                if (compareTo != 0) {
                    return compareTo;
                }
                if (c10.f16945b != null) {
                    if (TextUtils.isEmpty(c11.f16945b)) {
                        return 1;
                    }
                    int compareTo2 = c10.f16945b.compareTo(c11.f16945b);
                    if (compareTo2 != 0) {
                        return compareTo2;
                    }
                } else if (c11.f16945b != null) {
                    return 1;
                }
            }
            EntityDelta.ValuesDelta N10 = entityDelta.N();
            String z13 = N10.z("account_name");
            String str = "";
            if (z13 == null) {
                z13 = "";
            }
            EntityDelta.ValuesDelta N11 = entityDelta2.N();
            String z14 = N11.z("account_name");
            if (z14 != null) {
                str = z14;
            }
            int compareTo3 = z13.compareTo(str);
            if (compareTo3 != 0) {
                return compareTo3;
            }
            Long x10 = N10.x(BreenoCallContract.BaseColumns._ID);
            Long x11 = N11.x(BreenoCallContract.BaseColumns._ID);
            if (x10 == null) {
                return -1;
            }
            if (x11 == null) {
                return 1;
            }
            return (int) (x10.longValue() - x11.longValue());
        }

        public s() {
        }
    }

    /* loaded from: classes.dex */
    public class t extends BroadcastReceiver {
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String l10 = C7.e.l(intent, "reason");
            if ("recentapps".equals(l10) || "homekey".equals(l10)) {
                H7.b.e("ContactEditorFragment", " --- home key pressed ---");
                if (!ContactEditorFragment.this.f15166w0) {
                    try {
                        ContactEditorFragment.this.S2();
                    } catch (Exception e10) {
                        H7.b.c("ContactEditorFragment", "" + e10);
                    }
                    if (ContactEditorFragment.this.i3() && ContactEditorFragment.this.m3()) {
                        ContactEditorFragment.this.f15165v0 = true;
                        ContactEditorFragment.this.r4(true);
                        ContactEditorFragment.this.e4(4);
                        return;
                    }
                    return;
                }
                H7.b.e("ContactEditorFragment", " --- home key pressed but account is loading");
            }
        }

        public t() {
        }
    }

    /* loaded from: classes.dex */
    public interface u {
        void a();

        void b(Uri uri);

        void c();

        void d();

        void e(AccountWithDataSet accountWithDataSet, Bundle bundle);

        void f();

        void g(Intent intent);

        void h(AccountWithDataSet accountWithDataSet, Uri uri, Bundle bundle, boolean z10);

        void onCancel();
    }

    /* loaded from: classes.dex */
    public final class v implements A.a, B.d {

        /* renamed from: a, reason: collision with root package name */
        public final RawContactEditorView f15199a;

        /* renamed from: b, reason: collision with root package name */
        public final boolean f15200b;

        @Override // com.android.contacts.editor.B.d
        public void a() {
            ContactEditorFragment.this.f15106H = this.f15199a.getRawContactId();
            try {
                ContactEditorFragment.this.f15153n0 = false;
                Intent o10 = com.android.contacts.util.i.o(ContactEditorFragment.this.f15111L, ContactEditorFragment.this.f15161r0);
                ContactEditorFragment.this.f15127a0 = 4;
                if (P7.c.b(o10, ContactEditorFragment.this.f15111L, true) != null) {
                    S7.b.b(ContactEditorFragment.this, o10, 2, R.string.activity_not_found);
                } else {
                    S7.b.b(ContactEditorFragment.this, com.android.contacts.util.i.m(), 1004, R.string.activity_not_found);
                }
                C0636a.a(ContactEditorFragment.this.getActivity());
            } catch (Exception e10) {
                Log.e("ContactEditorFragment", "" + e10);
                com.oplus.foundation.util.ui.c.b(ContactEditorFragment.this.f15111L, R.string.phone_no_photo);
            }
        }

        @Override // com.android.contacts.editor.B.d
        public void b() {
            boolean z10;
            int childCount = ContactEditorFragment.this.f15118S.getChildCount();
            for (int i10 = 0; i10 < childCount; i10++) {
                View childAt = ContactEditorFragment.this.f15118S.getChildAt(i10);
                if (childAt instanceof BaseRawContactEditorView) {
                    BaseRawContactEditorView baseRawContactEditorView = (BaseRawContactEditorView) childAt;
                    PhotoEditorView photoEditor = baseRawContactEditorView.getPhotoEditor();
                    if (baseRawContactEditorView == this.f15199a) {
                        z10 = true;
                    } else {
                        z10 = false;
                    }
                    photoEditor.setSuperPrimary(z10);
                }
            }
        }

        @Override // com.android.contacts.editor.A.a
        public void c(int i10) {
            int i11;
            if (ContactEditorFragment.this.l3() && ContactEditorFragment.this.isAdded()) {
                ContactEditorFragment contactEditorFragment = ContactEditorFragment.this;
                if (contactEditorFragment.B3(contactEditorFragment.f15138g)) {
                    com.oplus.foundation.util.ui.c.b(ContactEditorFragment.this.f15111L, R.string.contact_editor_avatar_click_toast);
                    return;
                }
                int i12 = 1;
                if (i10 == 1) {
                    if (C7.a.a()) {
                        H7.b.e("ContactEditorFragment", "onRequest Invalid click return --------------");
                        return;
                    }
                    if (this.f15200b) {
                        if (this.f15199a.a()) {
                            if (ContactEditorFragment.this.k3()) {
                                i11 = 3;
                            } else {
                                i11 = 2;
                            }
                        } else {
                            i11 = 0;
                        }
                        FragmentActivity activity = ContactEditorFragment.this.getActivity();
                        if (activity != null && !OsUtils.k() && activity.checkSelfPermission("android.permission.ACCESS_MEDIA_LOCATION") != 0) {
                            if (activity.checkSelfPermission("android.permission.READ_EXTERNAL_STORAGE") == 0) {
                                activity.requestPermissions(new String[]{"android.permission.ACCESS_MEDIA_LOCATION"}, 0);
                            } else {
                                com.android.contacts.util.w.y(activity, false, null, "android.permission.ACCESS_MEDIA_LOCATION");
                                return;
                            }
                        }
                        i12 = i11;
                    } else if (!this.f15199a.a() || !ContactEditorFragment.this.k3()) {
                        return;
                    }
                    ContactEditorFragment.this.l4(this.f15199a, this, i12);
                }
            }
        }

        @Override // com.android.contacts.editor.A.a
        public void e(String str) {
            RawContactEditorView rawContactEditorView = this.f15199a;
            if (rawContactEditorView != null) {
                rawContactEditorView.i(str);
            }
        }

        @Override // com.android.contacts.editor.B.d
        public void f() {
            ContactEditorFragment.this.f15106H = this.f15199a.getRawContactId();
            ContactEditorFragment.this.f15153n0 = true;
            if (com.android.contacts.util.w.k(ContactEditorFragment.this.f15111L, "android.permission.CAMERA")) {
                FragmentActivity activity = ContactEditorFragment.this.getActivity();
                if (activity != null) {
                    String str = C1501d.f36274c;
                    if (com.android.contacts.framework.baseui.util.l.d(activity, str)) {
                        com.android.contacts.framework.baseui.util.l.f(activity, str, null, 0);
                        return;
                    }
                }
                ContactEditorFragment contactEditorFragment = ContactEditorFragment.this;
                contactEditorFragment.I4(contactEditorFragment.f15161r0, true);
                return;
            }
            ContactEditorFragment.this.requestPermissions(new String[]{"android.permission.CAMERA"}, 10);
        }

        @Override // com.android.contacts.editor.B.d
        public void g() {
            this.f15199a.setPhotoBitmap(null);
        }

        public v(RawContactEditorView rawContactEditorView, boolean z10) {
            this.f15199a = rawContactEditorView;
            this.f15200b = z10;
        }

        @Override // com.android.contacts.editor.A.a
        public void d(A a10) {
        }
    }

    /* loaded from: classes.dex */
    public static class w extends Handler {

        /* renamed from: a, reason: collision with root package name */
        public WeakReference<ContactEditorFragment> f15202a;

        public w(ContactEditorFragment contactEditorFragment) {
            this.f15202a = new WeakReference<>(contactEditorFragment);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            ContactEditorFragment contactEditorFragment = this.f15202a.get();
            if (contactEditorFragment == null) {
                return;
            }
            try {
                contactEditorFragment.x4(false);
                contactEditorFragment.z4((ArrayList) message.obj);
            } catch (Exception e10) {
                H7.b.b("ContactEditorFragment", "showAccountPopupwindow: " + e10);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class x implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final WeakReference<ContactEditorFragment> f15203a;

        @Override // java.lang.Runnable
        public void run() {
            ContactEditorFragment contactEditorFragment = this.f15203a.get();
            if (contactEditorFragment != null && contactEditorFragment.isAdded()) {
                contactEditorFragment.E4();
            }
        }

        public x(ContactEditorFragment contactEditorFragment) {
            this.f15203a = new WeakReference<>(contactEditorFragment);
        }
    }

    public static boolean A3(EntityDeltaList entityDeltaList) {
        String z10 = entityDeltaList.get(0).N().z("account_type");
        if (!"com.oplus.contacts.sim".equals(z10) && !TextUtils.equals("com.android.oplus.sim", z10)) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void E4() {
        OmojiPanelFragment omojiPanelFragment = new OmojiPanelFragment();
        omojiPanelFragment.init(this.f15161r0, this.f15159q0, this.f15168x0.a(), s3(), 2);
        omojiPanelFragment.showPanelFragment(getParentFragmentManager(), omojiPanelFragment);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void I4(Uri uri, boolean z10) {
        int i10;
        Intent p10 = com.android.contacts.util.i.p(uri);
        if (z10) {
            i10 = R.string.activity_not_found;
        } else {
            i10 = 0;
        }
        S7.b.b(this, p10, 1, i10);
    }

    private void J4() {
        try {
            X.a.b(getActivity()).e(this.f15107H0);
        } catch (Exception e10) {
            H7.b.b("ContactEditorFragment", "unregister local receiver error" + e10);
        }
    }

    public static /* synthetic */ void L3(SoftReference softReference, Account account) {
        ContactEditorFragment contactEditorFragment = (ContactEditorFragment) softReference.get();
        if (contactEditorFragment != null && contactEditorFragment.isAdded()) {
            contactEditorFragment.h4(account);
            contactEditorFragment.K4();
        }
    }

    private void T2(Intent intent) {
        try {
            S7.b.b(this, intent, 1003, R.string.activity_not_found);
        } catch (Exception e10) {
            H7.b.c("ContactEditorFragment", "Cannot crop image" + e10);
            com.oplus.foundation.util.ui.c.b(this.f15111L, R.string.phone_no_photo);
        }
    }

    private void d4() {
        try {
            X.a b10 = X.a.b(getActivity());
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("com.oplus.contacts.action_SIM_ABSENT");
            b10.c(this.f15107H0, intentFilter);
        } catch (Exception e10) {
            H7.b.b("ContactEditorFragment", "register local broadcast error" + e10);
        }
    }

    private String f3() {
        ArrayList<EntityDelta.ValuesDelta> D10 = this.f15121V.D("vnd.android.cursor.item/phone_v2");
        StringBuilder sb = new StringBuilder();
        if (!C0811w.g(D10)) {
            for (EntityDelta.ValuesDelta valuesDelta : D10) {
                if (valuesDelta.R()) {
                    String z10 = valuesDelta.z("data1");
                    if (!TextUtils.isEmpty(z10)) {
                        String d10 = U7.f.d(z10);
                        valuesDelta.e0("data1", d10);
                        sb.append(d10);
                        sb.append(",");
                    }
                }
            }
        }
        return sb.toString();
    }

    private void o4() {
        getParentFragmentManager().B1("panel_request_key_for_edit", this, new h());
    }

    public static boolean r3() {
        return f15091I0;
    }

    private void setEnabled(boolean z10) {
        if (this.f15137f0 != z10) {
            this.f15137f0 = z10;
            LinearLayout linearLayout = this.f15118S;
            if (linearLayout != null) {
                int childCount = linearLayout.getChildCount();
                for (int i10 = 0; i10 < childCount; i10++) {
                    this.f15118S.getChildAt(i10).setEnabled(z10);
                }
            }
            FragmentActivity activity = getActivity();
            if (activity != null) {
                activity.invalidateOptionsMenu();
            }
        }
    }

    public static void w4(A a10, List<String> list, ChipGroupView chipGroupView, List<String> list2) {
        FieldEditListener fieldEditListener = new FieldEditListener(a10, chipGroupView, list);
        chipGroupView.setDatas(list2, 0);
        chipGroupView.setOnCheckedStateChangeListener(fieldEditListener);
        a10.b(fieldEditListener);
    }

    public final void A2(boolean z10) {
        if (!s3() && this.f15163t0 && !z10 && !p3()) {
            View inflate = getLayoutInflater().inflate(R.layout.contact_editor_expand_more_layout, (ViewGroup) this.f15118S, false);
            TextView textView = (TextView) inflate.findViewById(R.id.expand_more_tv);
            COUITextViewCompatUtil.setPressRippleDrawable(textView);
            textView.setOnClickListener(new k(textView));
            LinearLayout linearLayout = this.f15118S;
            if (linearLayout != null) {
                linearLayout.addView(inflate);
            }
        }
    }

    public final void A4(Account account, int i10) {
        androidx.appcompat.app.b bVar = this.f15094B;
        if (bVar != null && bVar.isShowing()) {
            this.f15094B.dismiss();
            return;
        }
        COUIAlertDialogBuilder cOUIAlertDialogBuilder = new COUIAlertDialogBuilder(this.f15111L);
        cOUIAlertDialogBuilder.setTitle(R.string.contact_editor_location_change_dialog_title).setMessage(R.string.contact_editor_location_change_dialog_msg).setPositiveButton(R.string.dialog_positive_btn_str_continue, (DialogInterface.OnClickListener) new c(i10, account));
        cOUIAlertDialogBuilder.setNegativeButton(R.string.cancel, (DialogInterface.OnClickListener) new e()).setOnDismissListener(new d()).setCancelable(false);
        androidx.appcompat.app.b show = cOUIAlertDialogBuilder.show();
        this.f15094B = show;
        show.setCanceledOnTouchOutside(false);
    }

    public final void B2() {
        if (s3() && this.f15163t0 && !z3()) {
            View inflate = getLayoutInflater().inflate(R.layout.contact_editor_expand_more_layout, (ViewGroup) this.f15118S, false);
            final TextView textView = (TextView) inflate.findViewById(R.id.expand_more_tv);
            COUITextViewCompatUtil.setPressRippleDrawable(textView);
            textView.setOnClickListener(new View.OnClickListener() { // from class: com.android.contacts.editor.n
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ContactEditorFragment.this.E3(textView, view);
                }
            });
            LinearLayout linearLayout = this.f15118S;
            if (linearLayout != null) {
                linearLayout.addView(inflate);
            }
        }
    }

    public final boolean B3(String str) {
        if (!"com.oplus.contacts.sim".equals(str) && !"com.android.oplus.sim".equals(str)) {
            return false;
        }
        return true;
    }

    public final void B4(Dialog dialog) {
        FragmentActivity activity = getActivity();
        if (activity != null && !activity.isFinishing() && !activity.isDestroyed() && !dialog.isShowing()) {
            dialog.show();
        }
    }

    public final void C2(int i10, int i11, int i12) {
        if (this.f15129b0) {
            C1480a.g(getActivity(), i10, i11, i12);
            this.f15129b0 = false;
        }
    }

    public String C3() {
        if (!l3()) {
            return null;
        }
        Iterator<EntityDelta> it = this.f15119T.iterator();
        while (it.hasNext()) {
            ArrayList<EntityDelta.ValuesDelta> D10 = it.next().D("vnd.android.cursor.item/email_v2");
            if (C0811w.g(D10)) {
                return null;
            }
            if (!"com.oplus.contacts.sim".equals(this.f15138g) && !TextUtils.equals("com.android.oplus.sim", this.f15138g)) {
                for (EntityDelta.ValuesDelta valuesDelta : D10) {
                    if (valuesDelta.R()) {
                        String z10 = valuesDelta.z("data1");
                        if (!TextUtils.isEmpty(z10)) {
                            String replace = z10.replace(" ", "");
                            valuesDelta.e0("data1", replace);
                            return replace;
                        }
                    }
                }
            } else {
                String z11 = D10.get(0).z("data1");
                if (z11 != null && !TextUtils.isEmpty(z11.trim())) {
                    z11.replace(" ", "");
                    return null;
                }
                return "email_null";
            }
        }
        return null;
    }

    public final void C4() {
        if (!isAdded()) {
            return;
        }
        Dialog dialog = this.f15171z;
        if (dialog == null) {
            COUIAlertDialogBuilder positiveButton = new COUIAlertDialogBuilder(getActivity()).setTitle(R.string.oplus_save_only_email_error).setPositiveButton(R.string.oplus_know, (DialogInterface.OnClickListener) null);
            androidx.appcompat.app.b create = positiveButton.create();
            this.f15171z = create;
            B4(create);
            positiveButton.updateViewAfterShown();
            return;
        }
        B4(dialog);
    }

    public final void D2(Account account) {
        if (!M3.c.t(account)) {
            return;
        }
        Iterator<EntityDelta> it = this.f15119T.iterator();
        while (it.hasNext()) {
            EntityDelta next = it.next();
            if (next != null) {
                ArrayList<EntityDelta.ValuesDelta> D10 = next.D("vnd.android.cursor.item/phone_v2");
                ArrayList<EntityDelta.ValuesDelta> D11 = next.D("vnd.android.cursor.item/email_v2");
                boolean z10 = true;
                if (D10.size() <= 2 && D11.size() <= 1) {
                    z10 = false;
                }
                boolean t32 = t3(next);
                if (z10 && t32) {
                    h0.I(this.f15111L, "both");
                } else if (z10) {
                    h0.I(this.f15111L, "quantitative_restriction");
                } else if (t32) {
                    h0.I(this.f15111L, "nonsupport");
                }
            }
        }
    }

    public final void D3(long j10) {
        this.f15111L.startService(ContactSaveService.i(this.f15111L, this.f15116Q, j10, this.f15117R, ContactEditorActivity.class, "joinCompleted"));
    }

    public final void D4() {
        int i10;
        boolean z10;
        h0.M(this.f15111L, this.f15152n, "more");
        this.f15163t0 = false;
        FragmentActivity activity = getActivity();
        View currentFocus = activity.getCurrentFocus();
        if (currentFocus != null) {
            i10 = currentFocus.getId();
            z10 = true;
        } else {
            i10 = 0;
            z10 = false;
        }
        E2(false);
        if (z10 && activity.findViewById(i10) != null) {
            activity.findViewById(i10).requestFocus();
        }
        u4(true);
    }

    @Override // com.android.contacts.editor.RawContactReadOnlyEditorView.a
    public void E(AccountWithDataSet accountWithDataSet, Uri uri) {
        this.f15115P.h(accountWithDataSet, uri, null, false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:101:0x0432  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x043f A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:117:0x04b3 A[LOOP:1: B:115:0x04ad->B:117:0x04b3, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:121:0x04d1  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x04fc  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x0525  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x052d  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x053e  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x051a  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x04e8  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x0545  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x057e  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x0590  */
    /* JADX WARN: Removed duplicated region for block: B:161:0x0599  */
    /* JADX WARN: Removed duplicated region for block: B:163:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:188:0x0380  */
    /* JADX WARN: Removed duplicated region for block: B:189:0x0336 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:195:0x035b  */
    /* JADX WARN: Removed duplicated region for block: B:198:0x0362  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x02cb  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x02df  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x031f  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x032d  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x037e  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0414  */
    /* JADX WARN: Type inference failed for: r0v22, types: [com.customize.contacts.widget.SimContactEditorView] */
    /* JADX WARN: Type inference failed for: r0v51 */
    /* JADX WARN: Type inference failed for: r0v55, types: [com.android.contacts.editor.BaseRawContactEditorView] */
    /* JADX WARN: Type inference failed for: r13v1 */
    /* JADX WARN: Type inference failed for: r13v5, types: [android.view.View, com.android.contacts.editor.BaseRawContactEditorView] */
    /* JADX WARN: Type inference failed for: r13v6 */
    /* JADX WARN: Type inference failed for: r1v22, types: [n1.a] */
    /* JADX WARN: Type inference failed for: r22v0, types: [com.android.contacts.editor.RawContactReadOnlyEditorView$a, androidx.fragment.app.Fragment, com.android.contacts.editor.ContactEditorFragment, com.android.contacts.util.s] */
    /* JADX WARN: Type inference failed for: r2v34, types: [android.widget.LinearLayout, android.view.ViewGroup] */
    /* JADX WARN: Type inference failed for: r2v7 */
    /* JADX WARN: Type inference failed for: r2v70, types: [boolean] */
    /* JADX WARN: Type inference failed for: r2v75, types: [boolean] */
    /* JADX WARN: Type inference failed for: r2v8, types: [int, boolean] */
    /* JADX WARN: Type inference failed for: r2v84, types: [com.customize.contacts.util.SoftKeyboardUtil] */
    /* JADX WARN: Type inference failed for: r2v93 */
    /* JADX WARN: Type inference failed for: r3v6 */
    /* JADX WARN: Type inference failed for: r3v7, types: [int, boolean] */
    /* JADX WARN: Type inference failed for: r3v9 */
    /* JADX WARN: Type inference failed for: r4v21, types: [com.android.contacts.model.EntityDelta] */
    /* JADX WARN: Type inference failed for: r9v1, types: [android.view.LayoutInflater] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void E2(boolean r23) {
        /*
            Method dump skipped, instructions count: 1437
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.contacts.editor.ContactEditorFragment.E2(boolean):void");
    }

    public final /* synthetic */ void E3(TextView textView, View view) {
        if (s3()) {
            BaseRawContactEditorView baseRawContactEditorView = this.f15168x0;
            if (baseRawContactEditorView != null && baseRawContactEditorView.getPhotoEditor() != null && this.f15168x0.getPhotoEditor().y()) {
                this.f15168x0.getPhotoEditor().B();
                textView.postDelayed(new Runnable() { // from class: com.android.contacts.editor.b
                    @Override // java.lang.Runnable
                    public final void run() {
                        ContactEditorFragment.this.G4();
                    }
                }, 100L);
                return;
            } else {
                G4();
                return;
            }
        }
        Intent intent = new Intent(k0.f22137a, ContactsContract.Contacts.CONTENT_URI);
        if (l3()) {
            intent.putExtra("android.provider.extra.DATA_SET", this.f15119T.get(0));
        }
        intent.putExtra("android.provider.extra.ACCOUNT", new AccountWithDataSet(this.f15136f, this.f15138g, null));
        intent.setFlags(OplusPhoneCapabilities.MTK_CAPABILITY_VIDEO_RINGTONE);
        SoftKeyboardUtil.a().b(getView());
        R7.b.c(this.f15111L, intent);
    }

    public final void F2(ContactLoader.Result result) {
        this.f15140h = "";
        setEnabled(true);
        this.f15123X = result.M();
        this.f15138g = result.p();
        this.f15136f = result.o();
        EntityDeltaList k10 = EntityDeltaList.k(result.D().iterator());
        this.f15119T = k10;
        k10.p(this.f15097C0);
        p4(this.f15114O);
        this.f15114O = null;
        boolean g02 = result.g0();
        this.f15143i0 = g02;
        if (g02) {
            Iterator<EntityDelta> it = this.f15119T.iterator();
            boolean z10 = false;
            while (it.hasNext()) {
                EntityDelta next = it.next();
                next.y0();
                if (next.N().z("account_type") == null || TextUtils.equals(next.N().z("account_type"), R0.a.f3166b)) {
                    z10 = true;
                }
            }
            if (!z10) {
                ContentValues contentValues = new ContentValues();
                contentValues.put("account_name", R0.a.f3165a);
                contentValues.put("account_type", R0.a.f3166b);
                contentValues.putNull("data_set");
                EntityDelta entityDelta = new EntityDelta(EntityDelta.ValuesDelta.m(contentValues));
                entityDelta.y0();
                this.f15119T.add(entityDelta);
            }
        }
        this.f15139g0 = true;
        E2(true);
    }

    public final /* synthetic */ void F3(RawContactEditorView rawContactEditorView, Bitmap bitmap) {
        v4(rawContactEditorView.getRawContactId(), bitmap);
    }

    public final void F4(RawContactEditorView rawContactEditorView, B.d dVar, int i10) {
        S2();
        if (this.f15100E == null) {
            Dialog c10 = B.c(this.f15111L, rawContactEditorView.getPhotoEditor(), dVar, i10);
            this.f15100E = c10;
            B4(c10);
        }
    }

    public final void G2(AccountWithDataSet accountWithDataSet, AccountType accountType) {
        H2(accountWithDataSet, accountType, null, null);
    }

    public final /* synthetic */ void G3(final RawContactEditorView rawContactEditorView, final Bitmap bitmap) {
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.runOnUiThread(new Runnable() { // from class: com.android.contacts.editor.c
                @Override // java.lang.Runnable
                public final void run() {
                    ContactEditorFragment.this.F3(rawContactEditorView, bitmap);
                }
            });
        }
    }

    public final void G4() {
        int i10;
        FragmentActivity activity = getActivity();
        this.f15163t0 = false;
        View currentFocus = activity.getCurrentFocus();
        if (currentFocus != null) {
            i10 = currentFocus.getId();
        } else {
            i10 = 0;
        }
        E2(false);
        if (activity.findViewById(i10) != null) {
            activity.findViewById(i10).requestFocus();
        }
        u4(true);
    }

    public final void H2(AccountWithDataSet accountWithDataSet, AccountType accountType, EntityDelta entityDelta, AccountType accountType2) {
        String str;
        this.f15127a0 = 1;
        ContentValues contentValues = new ContentValues();
        if (accountWithDataSet != null && !TextUtils.isEmpty(accountWithDataSet.f16941a) && !TextUtils.isEmpty(accountWithDataSet.f16942b)) {
            contentValues.put("account_name", accountWithDataSet.f16941a);
            contentValues.put("account_type", accountWithDataSet.f16942b);
            contentValues.put("data_set", accountWithDataSet.f16970c);
        } else {
            contentValues.putNull("account_name");
            contentValues.putNull("account_type");
            contentValues.putNull("data_set");
        }
        EntityDelta.ValuesDelta m10 = EntityDelta.ValuesDelta.m(contentValues);
        if (entityDelta != null) {
            m10.d0(BreenoCallContract.BaseColumns._ID, entityDelta.N().E().longValue());
        }
        EntityDelta entityDelta2 = new EntityDelta(m10);
        Parcel parcel = null;
        if (entityDelta == null) {
            Bundle bundle = this.f15114O;
            if (bundle != null) {
                BreenoCallUtils.parseBreenoCallInfoForEditor(bundle, "NOTES_LIST");
            }
            com.android.contacts.model.d.G(this.f15111L, accountType, entityDelta2, this.f15114O);
        } else {
            Context context = this.f15111L;
            if (accountWithDataSet == null) {
                str = null;
            } else {
                str = accountWithDataSet.f16941a;
            }
            com.android.contacts.model.d.D(context, entityDelta, entityDelta2, accountType2, accountType, str);
        }
        if (this.f15141h0) {
            entityDelta2.y0();
        }
        EntityDeltaList entityDeltaList = this.f15119T;
        if (entityDeltaList == null) {
            EntityDeltaList m11 = EntityDeltaList.m(entityDelta2);
            this.f15119T = m11;
            m11.p(this.f15097C0);
            if (this.f15155o0 > 0) {
                try {
                    parcel = Parcel.obtain();
                    parcel.writeParcelable(entityDelta2, 0);
                    parcel.setDataPosition(0);
                    this.f15120U = EntityDeltaList.m((EntityDelta) parcel.readParcelable(EntityDelta.class.getClassLoader()));
                    parcel.recycle();
                } catch (Throwable th) {
                    if (parcel != null) {
                        parcel.recycle();
                    }
                    throw th;
                }
            }
        } else {
            entityDeltaList.add(entityDelta2);
        }
        this.f15139g0 = true;
        E2(true);
    }

    public final /* synthetic */ void H3(HashMap hashMap, int i10, int i11, DialogInterface dialogInterface, int i12) {
        g4(0);
        hashMap.put("click_item", "save");
        com.android.contacts.framework.baseui.util.A.a(getActivity(), i10, i11, hashMap, false);
    }

    public final void H4(String str) {
        try {
            com.oplus.foundation.util.ui.c.c(this.f15111L, str);
        } catch (Exception e10) {
            H7.b.c("ContactEditorFragment", "e = " + e10);
        }
    }

    public final void I2() {
        if (this.f15109J != null && this.f15118S != null && !"com.oplus.contacts.sim".equals(this.f15138g)) {
            int childCount = this.f15118S.getChildCount();
            for (int i10 = 0; i10 < childCount; i10++) {
                if (this.f15118S.getChildAt(i10) instanceof BaseRawContactEditorView) {
                    ((BaseRawContactEditorView) this.f15118S.getChildAt(i10)).setGroupMetaData(this.f15109J);
                }
            }
        }
    }

    public final /* synthetic */ void I3(HashMap hashMap, int i10, int i11, DialogInterface dialogInterface, int i12) {
        if (this.f15155o0 > 0) {
            com.android.contacts.framework.baseui.util.A.a(getActivity(), 2000322, 200030282, null, false);
        }
        hashMap.put("click_item", "do_not_save");
        com.android.contacts.framework.baseui.util.A.a(getActivity(), i10, i11, hashMap, false);
        O2(false);
        getActivity().finish();
    }

    public final void J2(BreenoCallLogEntity breenoCallLogEntity, RawContactEditorView rawContactEditorView) {
        ChipGroupView chipGroupView;
        View findViewById = rawContactEditorView.findViewById(R.id.candidates);
        if (findViewById instanceof ChipGroupView) {
            chipGroupView = (ChipGroupView) findViewById;
        } else {
            chipGroupView = null;
        }
        if (this.f15126a != null && chipGroupView != null) {
            breenoCallLogEntity.nomarlize();
            this.f15126a.f();
            List<NameInfo> nameInfoList = breenoCallLogEntity.getNameInfoList();
            if (nameInfoList != null && nameInfoList.size() > 1) {
                ArrayList arrayList = new ArrayList();
                int min = Math.min(nameInfoList.size(), 3);
                for (int i10 = 0; i10 < min; i10++) {
                    arrayList.add(nameInfoList.get(i10).getName());
                }
                ArrayList arrayList2 = new ArrayList();
                arrayList2.add("data1");
                arrayList2.add("data4");
                arrayList2.add("data3");
                arrayList2.add("data5");
                arrayList2.add("data2");
                arrayList2.add("data6");
                w4(this.f15126a, arrayList2, chipGroupView, arrayList);
            }
        }
    }

    public final /* synthetic */ boolean J3(MenuItem menuItem) {
        u uVar;
        if (menuItem.getItemId() == R.id.save) {
            H7.b.e("ContactEditorFragment", "save: account is loading: " + this.f15166w0);
            if (!this.f15166w0) {
                if (getActivity() != null) {
                    SoftKeyboardUtil.a().b(getActivity().getWindow().getDecorView());
                    C1480a.h(getActivity(), getActivity().getIntent());
                }
                U2();
                return true;
            }
            return true;
        }
        if (menuItem.getItemId() == R.id.cancel && (uVar = this.f15115P) != null) {
            uVar.onCancel();
            h0.P(this.f15111L, this.f15152n, "cancel");
            return true;
        }
        return true;
    }

    public final void K2(BreenoCallLogEntity breenoCallLogEntity, RawContactEditorView rawContactEditorView) {
        A a10;
        List<TitleInfo> titles;
        List<OrgInfo> orgs;
        breenoCallLogEntity.nomarlize();
        PersonalInfo personalInfo = breenoCallLogEntity.getPersonalInfo();
        CustomizeKindSectionView organizationEditor = rawContactEditorView.getOrganizationEditor();
        if (organizationEditor != null) {
            a10 = organizationEditor.getEditor();
        } else {
            a10 = null;
        }
        if (personalInfo != null && a10 != null) {
            a10.f();
            ChipGroupView orgChipGroupView = rawContactEditorView.getOrgChipGroupView();
            if (orgChipGroupView != null && (orgs = personalInfo.getOrgs()) != null && orgs.size() > 1) {
                H7.b.b("ContactEditorFragment", "bindOrgChipGroupView: org count: " + orgs.size());
                ArrayList arrayList = new ArrayList();
                int min = Math.min(orgs.size(), 3);
                for (int i10 = 0; i10 < min; i10++) {
                    arrayList.add(orgs.get(i10).getName());
                }
                ArrayList arrayList2 = new ArrayList();
                arrayList2.add("data1");
                w4(a10, arrayList2, orgChipGroupView, arrayList);
            }
            ChipGroupView titleChipGroupView = rawContactEditorView.getTitleChipGroupView();
            if (titleChipGroupView != null && (titles = personalInfo.getTitles()) != null && titles.size() > 1) {
                H7.b.b("ContactEditorFragment", "bindOrgChipGroupView: titles count: " + titles.size());
                ArrayList arrayList3 = new ArrayList();
                int min2 = Math.min(titles.size(), 3);
                for (int i11 = 0; i11 < min2; i11++) {
                    arrayList3.add(titles.get(i11).getName());
                }
                ArrayList arrayList4 = new ArrayList();
                arrayList4.add("data4");
                w4(a10, arrayList4, titleChipGroupView, arrayList3);
            }
        }
    }

    public final /* synthetic */ void K3() {
        OmojiUtils.m(getContext());
    }

    public final void K4() {
        this.f15166w0 = false;
        View view = this.f15167x;
        if (view != null && view.getVisibility() == 4) {
            this.f15167x.setVisibility(0);
        }
    }

    public final void L2() {
        List<AccountWithDataSet> g10 = AbstractC1362a.h(this.f15111L).g(true);
        if (g10.isEmpty()) {
            N2();
        } else {
            M2(g10.get(0));
        }
    }

    public final void L4() {
        synchronized (this.f15151m0) {
            try {
                this.f15151m0.wait(1000);
            } catch (InterruptedException unused) {
            }
        }
    }

    public final void M2(AccountWithDataSet accountWithDataSet) {
        String str;
        AbstractC1362a h10 = AbstractC1362a.h(this.f15111L);
        String str2 = null;
        if (accountWithDataSet != null) {
            str = accountWithDataSet.f16942b;
        } else {
            str = null;
        }
        if (accountWithDataSet != null) {
            str2 = accountWithDataSet.f16970c;
        }
        AccountType c10 = h10.c(str, str2);
        if (c10.d() != null) {
            u uVar = this.f15115P;
            if (uVar != null) {
                uVar.e(accountWithDataSet, this.f15114O);
                return;
            }
            return;
        }
        G2(accountWithDataSet, c10);
    }

    public final /* synthetic */ void M3(Context context, Handler handler, final SoftReference softReference) {
        final Account l10 = M3.c.l(context);
        if (l10 == null) {
            l10 = new Account(this.f15136f, this.f15138g);
        }
        handler.post(new Runnable() { // from class: com.android.contacts.editor.m
            @Override // java.lang.Runnable
            public final void run() {
                ContactEditorFragment.L3(softReference, l10);
            }
        });
    }

    public final void N2() {
        if (TextUtils.isEmpty(this.f15136f) || TextUtils.isEmpty(this.f15138g)) {
            this.f15136f = R0.a.f3165a;
            this.f15138g = R0.a.f3166b;
        }
        M2(new AccountWithDataSet(this.f15136f, this.f15138g, null));
    }

    public final /* synthetic */ void N3() {
        SoftKeyboardUtil.a().f(getActivity().getCurrentFocus());
    }

    public final void O2(boolean z10) {
        FragmentActivity activity = getActivity();
        if (activity != null) {
            BreenoCallLogEntity breenoCallLogEntity = this.f15095B0;
            if (breenoCallLogEntity != null) {
                BreenoCallLogEntityUtils.deleteBreenoCallLogEntity(activity, breenoCallLogEntity.getId());
                z2(activity, z10, this.f15095B0);
            } else {
                H7.b.b("ContactEditorFragment", "Breeno call info NOT shown, no need to delete.");
            }
        }
    }

    public final /* synthetic */ void O3(RawContactEditorView rawContactEditorView, B.d dVar, int i10, boolean z10) {
        if (z10) {
            SoftKeyboardUtil.a().c(this.f15168x0.getPhotoEditor(), new x());
        } else {
            SoftKeyboardUtil.a().b(this.f15168x0);
            F4(rawContactEditorView, dVar, i10);
        }
    }

    public void P2() {
        if (getLoaderManager() != null) {
            getLoaderManager().a(1);
        }
    }

    public final /* synthetic */ void P3() {
        this.f15111L.getContentResolver().delete(this.f15161r0, null, null);
    }

    public final void Q2(BaseRawContactEditorView baseRawContactEditorView) {
        View findViewById = baseRawContactEditorView.findViewById(R.id.account);
        findViewById.setEnabled(false);
        this.f15167x = findViewById;
        View findViewById2 = baseRawContactEditorView.findViewById(R.id.account_name);
        if (findViewById2 != null) {
            findViewById2.setEnabled(false);
        }
        View findViewById3 = baseRawContactEditorView.findViewById(R.id.editor_expansion_view);
        if (findViewById3 != null) {
            findViewById3.setVisibility(8);
        }
    }

    public final /* synthetic */ void Q3(ArrayList arrayList, AdapterView adapterView, View view, int i10, long j10) {
        PopupListItem popupListItem = (PopupListItem) arrayList.get(i10);
        PopupListItem popupListItem2 = (PopupListItem) arrayList.get(this.f15142i);
        if (popupListItem != null && i10 != this.f15142i) {
            popupListItem.setChecked(true);
            if (popupListItem2 != null) {
                popupListItem2.setChecked(false);
            }
            i4(i10);
        }
        this.f15092A.dismiss();
    }

    public void R2() {
        ContentAssociateCreator contentAssociateCreator = this.f15102F;
        if (contentAssociateCreator != null) {
            contentAssociateCreator.k();
        }
    }

    public final /* synthetic */ void R3() {
        x4(true);
    }

    public final void S2() {
        Dialog dialog = this.f15100E;
        if (dialog != null && dialog.isShowing()) {
            this.f15100E.dismiss();
        }
        this.f15100E = null;
    }

    public void S3(String str, Uri uri, Bundle bundle) {
        boolean z10;
        boolean z11;
        String string;
        if (getActivity() != null && isAdded()) {
            this.f15112M = str;
            this.f15113N = uri;
            H7.b.e("ContactEditorFragment", "load mLookupUri = " + this.f15113N);
            this.f15114O = bundle;
            boolean z12 = false;
            if (bundle != null && bundle.containsKey("addToDefaultDirectory")) {
                z10 = true;
            } else {
                z10 = false;
            }
            this.f15135e0 = z10;
            Bundle bundle2 = this.f15114O;
            if (bundle2 != null && bundle2.getBoolean("newLocalProfile")) {
                z11 = true;
            } else {
                z11 = false;
            }
            this.f15141h0 = z11;
            Bundle bundle3 = this.f15114O;
            if (bundle3 != null && bundle3.getBoolean("editProfile")) {
                z12 = true;
            }
            this.f15145j0 = z12;
            Intent intent = getActivity().getIntent();
            if (intent.hasExtra("STORAGE_TYPE")) {
                String l10 = C7.e.l(intent, "STORAGE_TYPE");
                String l11 = C7.e.l(intent, "account_name");
                if (l10 == null) {
                    l10 = this.f15138g;
                }
                this.f15138g = l10;
                if (l11 == null) {
                    l11 = this.f15136f;
                }
                this.f15136f = l11;
            } else if (C7.e.j(intent, "sim_contacts_info") != null) {
                SimContactInfo simContactInfo = (SimContactInfo) C7.e.j(intent, "sim_contacts_info");
                this.f15138g = "com.oplus.contacts.sim";
                this.f15136f = simContactInfo.d();
            }
            this.f15155o0 = C7.e.f(intent, "group_id", -1L);
            Bundle bundle4 = this.f15114O;
            if (bundle4 == null) {
                string = null;
            } else {
                string = bundle4.getString(OplusNumberMarkUtils.OplusContact.OPLUS_CONTACTS_FLAG_UNFAMILIAR_NUMBER);
            }
            this.f15160r = string;
        }
    }

    public void T3() {
        if (this.f15098D == 2) {
            synchronized (this.f15156p) {
                this.f15156p.notifyAll();
            }
        }
        androidx.appcompat.app.b bVar = this.f15158q;
        if (bVar != null && bVar.isShowing()) {
            this.f15158q.dismiss();
            this.f15158q = null;
        }
    }

    public void U2() {
        e4(0);
        h0.P(this.f15111L, this.f15152n, "done");
    }

    public void U3(Uri uri) {
        boolean z10;
        H7.b.e("ContactEditorFragment", "onJoinCompleted uri : " + uri);
        if (uri != null) {
            z10 = true;
        } else {
            z10 = false;
        }
        V3(false, 1, z10, uri);
    }

    public final String V2(String str, String str2) {
        Object valueOf;
        StringBuilder sb = new StringBuilder();
        sb.append("");
        Object obj = OplusPhoneUtils.DeviceState.UNLOCK_DEVICE;
        if (str == null) {
            valueOf = OplusPhoneUtils.DeviceState.UNLOCK_DEVICE;
        } else {
            valueOf = Integer.valueOf(str.length());
        }
        sb.append(valueOf);
        sb.append(",");
        String sb2 = sb.toString();
        StringBuilder sb3 = new StringBuilder();
        sb3.append(sb2);
        if (str2 != null) {
            obj = Integer.valueOf(str2.length());
        }
        sb3.append(obj);
        sb3.append(",");
        String sb4 = sb3.toString();
        StringBuilder sb5 = new StringBuilder();
        sb5.append(sb4);
        if (str == null) {
            str = "null";
        }
        sb5.append(str);
        String sb6 = sb5.toString();
        StringBuilder sb7 = new StringBuilder();
        sb7.append(sb6);
        if (str2 == null) {
            str2 = "null";
        }
        sb7.append(str2);
        return sb7.toString();
    }

    public void V3(boolean z10, int i10, boolean z11, Uri uri) {
        W3(z10, i10, z11, uri, null);
    }

    public final int W2() {
        return X2(AbstractC1362a.h(this.f15111L).g(true));
    }

    /* JADX WARN: Removed duplicated region for block: B:87:0x0349  */
    /* JADX WARN: Removed duplicated region for block: B:89:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void W3(boolean r18, int r19, boolean r20, android.net.Uri r21, android.content.Intent r22) {
        /*
            Method dump skipped, instructions count: 847
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.contacts.editor.ContactEditorFragment.W3(boolean, int, boolean, android.net.Uri, android.content.Intent):void");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final int X2(List<AccountWithDataSet> list) {
        int size;
        int i10;
        if (list == null) {
            size = 0;
        } else {
            size = list.size();
        }
        if (FeatureOption.k() && PrimaryUserUtils.a()) {
            if (B3.a.i()) {
                size += b0.u0(this.f15111L, 0) ? 1 : 0;
                i10 = b0.u0(this.f15111L, 1);
            } else {
                i10 = b0.T(this.f15111L);
            }
            return size + i10;
        }
        return size;
    }

    public final void X3() {
        EditRingtoneView editRingtoneView = this.f15128b;
        if (editRingtoneView != null) {
            editRingtoneView.f(requireActivity());
        }
    }

    public String Y2() {
        if (TextUtils.isEmpty(this.f15140h)) {
            return this.f15138g;
        }
        return this.f15140h;
    }

    public boolean Y3(int i10, String str) {
        boolean z10;
        if (!l3() || this.f15127a0 != 1) {
            return false;
        }
        if (i10 == 0 || i10 == 2) {
            getLoaderManager().a(1);
        }
        SoftKeyboardUtil.a().b(this.f15118S);
        if (i3() && m3()) {
            if (this.f15157p0 == null) {
                this.f15157p0 = g3(str);
            }
            if (!this.f15157p0.isShowing()) {
                B4(this.f15157p0);
            }
            return true;
        }
        H7.b.e("ContactEditorFragment", "preForSave mLookupUri : " + this.f15113N);
        Uri uri = this.f15113N;
        if (uri != null) {
            z10 = true;
        } else {
            z10 = false;
        }
        V3(false, i10, z10, uri);
        return true;
    }

    public ContactLoader.Result Z2() {
        return this.f15154o;
    }

    public final void Z3(Menu menu) {
        H7.b.b("ContactEditorFragment", "onPrepareOptionsMenu-----------");
        if (menu != null && menu.findItem(R.id.save) != null) {
            MenuItem findItem = menu.findItem(R.id.save);
            boolean z10 = false;
            if (i3()) {
                if (m3() && !this.f15166w0) {
                    z10 = true;
                }
                findItem.setEnabled(z10);
                return;
            }
            findItem.setEnabled(false);
        }
    }

    public final ArrayList<String> a3(String str, String str2) {
        ArrayList<EntityDelta.ValuesDelta> arrayList;
        ArrayList<String> arrayList2 = new ArrayList<>();
        EntityDelta entityDelta = this.f15121V;
        if (entityDelta != null) {
            arrayList = entityDelta.D(str);
        } else {
            arrayList = null;
        }
        if (arrayList != null && !arrayList.isEmpty()) {
            Iterator<EntityDelta.ValuesDelta> it = arrayList.iterator();
            while (it.hasNext()) {
                EntityDelta.ValuesDelta next = it.next();
                if (next != null) {
                    String z10 = next.z(str2);
                    if (!TextUtils.isEmpty(z10)) {
                        arrayList2.add(z10);
                    }
                }
            }
        }
        return arrayList2;
    }

    public final void a4() {
        this.f15166w0 = true;
        final SoftReference softReference = new SoftReference(this);
        final Context applicationContext = getActivity().getApplicationContext();
        final Handler handler = new Handler(Looper.getMainLooper());
        this.f15147k0.execute(new Runnable() { // from class: com.android.contacts.editor.l
            @Override // java.lang.Runnable
            public final void run() {
                ContactEditorFragment.this.M3(applicationContext, handler, softReference);
            }
        });
    }

    public boolean b3() {
        return this.f15165v0;
    }

    public final void b4(EntityDelta entityDelta, AccountWithDataSet accountWithDataSet, AccountWithDataSet accountWithDataSet2) {
        AbstractC1362a h10 = AbstractC1362a.h(this.f15111L);
        AccountType c10 = h10.c(accountWithDataSet.f16942b, accountWithDataSet.f16970c);
        AccountType c11 = h10.c(accountWithDataSet2.f16942b, accountWithDataSet2.f16970c);
        if (c11.d() != null) {
            H7.b.i("ContactEditorFragment", "external activity called in rebind situation");
            u uVar = this.f15115P;
            if (uVar != null) {
                uVar.e(accountWithDataSet2, this.f15114O);
                return;
            }
            return;
        }
        this.f15119T = null;
        H2(accountWithDataSet2, c11, entityDelta, c10);
    }

    public final String c3(Account account) {
        AbstractC1362a h10 = AbstractC1362a.h(this.f15111L);
        if (TextUtils.equals(R0.a.f3166b, account.f16942b)) {
            return M3.c.c(this.f15111L, account, -1, false);
        }
        if (TextUtils.equals("com.android.oplus.sim", account.f16942b)) {
            return com.customize.contacts.simcontacts.b.f(this.f15111L, com.customize.contacts.simcontacts.b.j(account.f16941a));
        }
        return h10.c(account.f16942b, null).f(this.f15111L).toString();
    }

    public final void c4() {
        this.f15164u0 = new t();
        try {
            getActivity().registerReceiver(this.f15164u0, new IntentFilter("android.intent.action.CLOSE_SYSTEM_DIALOGS"), R0.b.f3175i, null, 2);
        } catch (Exception e10) {
            H7.b.c("ContactEditorFragment", "Exception e: " + e10);
            this.f15164u0 = null;
        }
    }

    public Uri d3() {
        return this.f15113N;
    }

    public final String e3(Account account) {
        if (!TextUtils.equals(R0.a.f3166b, account.f16942b) && !TextUtils.equals("com.android.oplus.sim", account.f16942b)) {
            return account.f16941a;
        }
        return null;
    }

    public boolean e4(int i10) {
        if (this.f15119T != null && this.f15121V != null && l3() && this.f15127a0 == 1 && getActivity() != null) {
            if (i10 == 0 || i10 == 2) {
                if (isAdded()) {
                    getLoaderManager().a(1);
                }
            }
            String y32 = y3();
            String C32 = C3();
            if (y32 != null && y32.equals("number_null") && C32 != null && C32.equals("email_null") && v3()) {
                if (i10 == 4) {
                    return false;
                }
                H4(getString(R.string.oplus_toast_save_contact_failed));
                if (getActivity() != null) {
                    getActivity().finish();
                }
                return false;
            }
            if (A3(this.f15119T) && v3() && y32 != null && y32.equals("number_null") && (C32 == null || !C32.equals("email_null"))) {
                if (i10 != 4) {
                    C4();
                }
                return false;
            }
            if (A3(this.f15119T) && w3()) {
                H4(getString(R.string.too_long_name));
                return false;
            }
            if (y32 != null && !y32.equals("number_null")) {
                H4(String.format(getString(R.string.oplus_save_contact_phone_number_invalidate), y32));
                return false;
            }
            f4();
            this.f15127a0 = 2;
            y2();
            this.f15121V.p0();
            Intent k10 = ContactSaveService.k(getActivity(), this.f15121V, "saveMode", i10, s3(), getActivity().getClass(), "saveCompleted");
            if (!TextUtils.isEmpty(this.f15160r)) {
                k10.putExtra(OplusNumberMarkUtils.OplusContact.OPLUS_CONTACTS_FLAG_UNFAMILIAR_NUMBER, this.f15160r);
            }
            this.f15098D = i10;
            k10.putExtra("saveMode", i10);
            k10.putExtra("phone", C7.e.l(getActivity().getIntent(), "phone"));
            k10.putExtra("secondary_phone", C7.e.l(getActivity().getIntent(), "secondary_phone"));
            if (i10 == 2) {
                setEnabled(false);
                this.f15111L.startService(k10);
                Context context = this.f15111L;
                androidx.appcompat.app.b o10 = U0.k.o(context, context.getString(R.string.in_processing));
                this.f15158q = o10;
                J3.e.b(o10);
            } else {
                Bundle bundle = this.f15170y0;
                if (bundle != null) {
                    this.f15149l0.execute(new m((Uri) bundle.getParcelable("input_uri"), (Uri) this.f15170y0.getParcelable("output_uri")));
                }
                this.f15111L.startService(k10);
                if (i10 != 4) {
                    setEnabled(false);
                }
                if (j3()) {
                    com.android.contacts.framework.baseui.util.A.a(this.f15111L, 2000322, 200030283, null, false);
                }
                O2(true);
            }
            return true;
        }
        return false;
    }

    public final void f4() {
        AccountWithDataSet accountWithDataSet;
        if (!"android.intent.action.INSERT".equals(this.f15112M) && !r0.f.k(this.f15112M) && this.f15119T.size() == 1 && !s3()) {
            return;
        }
        EntityDelta.ValuesDelta N10 = this.f15119T.get(0).N();
        String z10 = N10.z("account_name");
        String z11 = N10.z("account_type");
        String z12 = N10.z("data_set");
        if (z10 != null && z11 != null) {
            accountWithDataSet = new AccountWithDataSet(z10, z11, z12);
        } else {
            accountWithDataSet = null;
        }
        com.android.contacts.editor.w.a(this.f15111L, accountWithDataSet);
    }

    public Dialog g3(String str) {
        final int i10;
        final int i11;
        final HashMap hashMap = new HashMap();
        hashMap.put("pop_up_situation", str);
        if (s3()) {
            i10 = 2000325;
        } else {
            i10 = 2000310;
        }
        if (s3()) {
            i11 = 200035805;
        } else {
            i11 = 200032812;
        }
        U0.b bVar = new U0.b(getActivity(), 2132083073);
        bVar.setTitle(R.string.dialog_title_save_contact_v2).setPositiveButton(R.string.oplus_menu_save, new DialogInterface.OnClickListener() { // from class: com.android.contacts.editor.i
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i12) {
                ContactEditorFragment.this.H3(hashMap, i10, i11, dialogInterface, i12);
            }
        }).setNegativeButton(R.string.do_no_save, new DialogInterface.OnClickListener() { // from class: com.android.contacts.editor.j
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i12) {
                ContactEditorFragment.this.I3(hashMap, i10, i11, dialogInterface, i12);
            }
        }).setOnDismissListener(new f());
        androidx.appcompat.app.b create = bVar.create();
        B4(create);
        bVar.updateViewAfterShown();
        return create;
    }

    public final boolean g4(int i10) {
        if (this.f15119T == null || this.f15121V == null) {
            return false;
        }
        if (w3() && A3(this.f15119T)) {
            H4(getString(R.string.too_long_name));
            return false;
        }
        String y32 = y3();
        String C32 = C3();
        if (y32 != null && y32.equals("number_null") && C32 != null && C32.equals("email_null") && v3()) {
            H4(getString(R.string.oplus_toast_save_contact_failed));
            return false;
        }
        if (A3(this.f15119T) && v3() && y32 != null && y32.equals("number_null") && (C32 == null || !C32.equals("email_null"))) {
            C4();
            return false;
        }
        if (y32 != null && !y32.equals("number_null")) {
            H4(String.format(getString(R.string.oplus_save_contact_phone_number_invalidate), y32));
            return false;
        }
        setEnabled(false);
        f4();
        this.f15127a0 = 2;
        Intent k10 = ContactSaveService.k(getActivity(), this.f15121V, "saveMode", i10, s3(), getActivity().getClass(), "saveCompleted");
        if (!TextUtils.isEmpty(this.f15160r)) {
            k10.putExtra(OplusNumberMarkUtils.OplusContact.OPLUS_CONTACTS_FLAG_UNFAMILIAR_NUMBER, this.f15160r);
        }
        getActivity().startService(k10);
        O2(true);
        return true;
    }

    public BaseRawContactEditorView h3(long j10) {
        for (int i10 = 0; i10 < this.f15118S.getChildCount(); i10++) {
            View childAt = this.f15118S.getChildAt(i10);
            if (childAt instanceof BaseRawContactEditorView) {
                BaseRawContactEditorView baseRawContactEditorView = (BaseRawContactEditorView) childAt;
                if (baseRawContactEditorView.getRawContactId() == j10) {
                    return baseRawContactEditorView;
                }
            }
        }
        return null;
    }

    public final void h4(Account account) {
        androidx.loader.app.a.c(this).g(2, new Bundle(), this.f15103F0);
        if (account != null) {
            b4(this.f15119T.get(0), this.f15146k, new AccountWithDataSet(account.f16941a, account.f16942b, null));
            if (FeatureOption.k() && getActivity().getCurrentFocus() != null) {
                getActivity().getCurrentFocus().postDelayed(new Runnable() { // from class: com.android.contacts.editor.d
                    @Override // java.lang.Runnable
                    public final void run() {
                        ContactEditorFragment.this.N3();
                    }
                }, 150L);
            }
        }
        if (account != null) {
            this.f15138g = account.f16942b;
            this.f15136f = account.f16941a;
            C1480a.a(getActivity(), account);
        }
    }

    public boolean i3() {
        return com.android.contacts.model.d.p(this.f15121V, AbstractC1362a.h(this.f15111L));
    }

    public final void i4(int i10) {
        Account account;
        int i11;
        String str;
        if (getActivity() == null) {
            return;
        }
        ArrayList<Account> arrayList = this.f15096C;
        if (arrayList != null && i10 < arrayList.size()) {
            account = this.f15096C.get(i10);
        } else {
            account = null;
        }
        if (M3.c.t(account) && b0.r0(this.f15111L, account.f16941a)) {
            h0.I(this.f15111L, "storage_full");
            if (b0.N(getActivity(), account.f16941a) == -1) {
                i11 = R.string.oplus_sim_not_ready_default;
            } else {
                i11 = R.string.oplus_msg_simcard_is_full_save_to_default;
            }
            ArrayList arrayList2 = new ArrayList();
            arrayList2.add(account);
            CharSequence[] d10 = M3.c.d(getActivity(), arrayList2, i11, true);
            if (this.f15142i < this.f15096C.size()) {
                str = M3.c.c(getActivity(), this.f15096C.get(this.f15142i), -1, false);
            } else {
                str = "";
            }
            H4(d10[0].toString() + str);
            return;
        }
        if (account != null && M3.c.t(account) && !b0.U(getActivity(), com.customize.contacts.simcontacts.b.j(account.f16941a))) {
            H4(getString(R.string.simcard_not_available));
            return;
        }
        if (!M3.c.s(account) && !M3.c.r(account) && u3()) {
            A4(account, i10);
            D2(account);
        } else {
            this.f15142i = i10;
            h4(account);
        }
    }

    public boolean j3() {
        if (this.f15120U == null) {
            return false;
        }
        if (this.f15119T.size() != this.f15120U.size()) {
            return true;
        }
        for (int i10 = 0; i10 < this.f15119T.size(); i10++) {
            if (!this.f15120U.get(i10).equals(this.f15119T.get(i10))) {
                return true;
            }
        }
        return false;
    }

    public final void j4(BaseRawContactEditorView baseRawContactEditorView) {
        baseRawContactEditorView.findViewById(R.id.account).setVisibility(8);
        k4(baseRawContactEditorView, 4);
    }

    public final boolean k3() {
        int childCount = this.f15118S.getChildCount();
        int i10 = 0;
        for (int i11 = 0; i11 < childCount; i11++) {
            View childAt = this.f15118S.getChildAt(i11);
            if ((childAt instanceof BaseRawContactEditorView) && ((BaseRawContactEditorView) childAt).a() && (i10 = i10 + 1) > 1) {
                return true;
            }
        }
        return false;
    }

    public final void k4(BaseRawContactEditorView baseRawContactEditorView, int i10) {
        View findViewById = baseRawContactEditorView.findViewById(R.id.blank_view);
        if (findViewById != null) {
            if (i10 == 4 || i10 == 8 || i10 == 0) {
                findViewById.setVisibility(i10);
            }
        }
    }

    public final boolean l3() {
        EntityDeltaList entityDeltaList = this.f15119T;
        if (entityDeltaList != null && entityDeltaList.size() > 0) {
            return true;
        }
        return false;
    }

    public final void l4(final RawContactEditorView rawContactEditorView, final B.d dVar, final int i10) {
        OmojiUtils.a(getContext(), new f1.d() { // from class: com.android.contacts.editor.o
            @Override // f1.d
            public final void a(boolean z10) {
                ContactEditorFragment.this.O3(rawContactEditorView, dVar, i10, z10);
            }
        });
    }

    public boolean m3() {
        Context context = this.f15111L;
        if (context != null && this.f15121V != null) {
            AbstractC1362a h10 = AbstractC1362a.h(context);
            EntityDelta.ValuesDelta N10 = this.f15121V.N();
            return com.android.contacts.model.d.s(this.f15121V, h10.c(N10.z("account_type"), N10.z("data_set")));
        }
        return false;
    }

    public final void m4(boolean z10) {
        if (z10) {
            try {
                this.f15149l0.execute(new Runnable() { // from class: com.android.contacts.editor.k
                    @Override // java.lang.Runnable
                    public final void run() {
                        ContactEditorFragment.this.P3();
                    }
                });
            } catch (Exception e10) {
                H7.b.c("ContactEditorFragment", "Cannot set photo" + e10);
                return;
            }
        }
        Bitmap e11 = I7.a.e(this.f15111L, this.f15159q0);
        this.f15104G = e11;
        v4(this.f15106H, e11);
        this.f15108I = this.f15106H;
        this.f15106H = -1L;
        h0.U(new HashMap(), this.f15153n0, this.f15111L);
        h0.F(this.f15111L, "yes");
    }

    public boolean n3() {
        if (s3()) {
            return z3();
        }
        return p3();
    }

    public void n4(ContactLoader.Result result) {
        if (this.f15119T != null && this.f15122W == null) {
            H7.b.h("ContactEditorFragment", "Ignoring background change. This will have to be rebased later");
            return;
        }
        ArrayList<Entity> D10 = result.D();
        if (D10.size() == 1) {
            ContentValues entityValues = D10.get(0).getEntityValues();
            String asString = entityValues.getAsString("account_type");
            this.f15138g = asString;
            String asString2 = entityValues.getAsString("data_set");
            AccountType c10 = AbstractC1362a.h(this.f15111L).c(asString, asString2);
            if (c10.g() != null && !c10.b()) {
                if (this.f15115P != null) {
                    this.f15115P.h(new AccountWithDataSet(entityValues.getAsString("account_name"), asString, asString2), ContentUris.withAppendedId(ContactsContract.RawContacts.CONTENT_URI, entityValues.getAsLong(BreenoCallContract.BaseColumns._ID).longValue()), this.f15114O, true);
                    return;
                }
                return;
            }
        }
        F2(result);
    }

    public final boolean o3(Intent intent) {
        int d10;
        EntityDeltaList entityDeltaList;
        if (intent == null || (d10 = C7.e.d(intent, "delete_count_key", 0)) <= 0 || (entityDeltaList = this.f15119T) == null || d10 != entityDeltaList.size()) {
            return false;
        }
        return true;
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        String str;
        String str2;
        String str3;
        Account account;
        super.onActivityCreated(bundle);
        int i10 = R.string.menu_newContact;
        int i11 = R.string.edit_my_info;
        if (bundle != null) {
            if (bundle.getBoolean("account_is_loading")) {
                a4();
            }
            this.f15133d0 = R.string.editContactDescription;
            if (this.f15119T != null) {
                E2(true);
            }
            if (this.f15152n) {
                COUIToolbar cOUIToolbar = this.f15162s0;
                if (!s3()) {
                    i11 = R.string.editContactDescription;
                }
                cOUIToolbar.setTitle(i11);
            } else {
                COUIToolbar cOUIToolbar2 = this.f15162s0;
                if (s3()) {
                    i10 = R.string.edit_my_info;
                }
                cOUIToolbar2.setTitle(i10);
            }
        } else {
            String str4 = null;
            if (!"android.intent.action.EDIT".equals(this.f15112M) && !"com.oplus.contacts.EDIT_CONTACTS".equals(this.f15112M)) {
                if (!"android.intent.action.INSERT".equals(this.f15112M) && !r0.f.k(this.f15112M)) {
                    if (!"saveCompleted".equals(this.f15112M)) {
                        if (C7.e.j(getActivity().getIntent(), "sim_contacts_info") != null) {
                            this.f15162s0.setTitle(R.string.editContactDescription);
                            this.f15133d0 = R.string.editContactDescription;
                            this.f15152n = true;
                            q4(true);
                            getLoaderManager().e(1, null, this.f15101E0);
                        } else {
                            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Unknown Action String " + this.f15112M + ". Only support android.intent.action.EDIT or android.intent.action.INSERT");
                            StringBuilder sb = new StringBuilder();
                            sb.append("Unknown Action");
                            sb.append(illegalArgumentException);
                            H7.b.c("ContactEditorFragment", sb.toString());
                            return;
                        }
                    }
                } else {
                    FragmentActivity activity = getActivity();
                    if (activity != null) {
                        Intent intent = activity.getIntent();
                        str2 = C7.e.l(intent, "ABOUT_TO_SAVE_ACCOUNT_NAME");
                        str3 = C7.e.l(intent, "ABOUT_TO_SAVE_ACCOUNT_TYPE");
                        str = C7.e.l(intent, OplusNumberMarkUtils.OplusContact.OPLUS_COLUMN_SIM_IMSI);
                    } else {
                        str = null;
                        str2 = null;
                        str3 = null;
                    }
                    H7.b.b("ContactEditorFragment", " the account type is : " + str3 + " is isEditingUserProfile : " + s3() + " mBusinessCardGroupId : " + this.f15155o0);
                    if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
                        this.f15136f = str2;
                        this.f15138g = str3;
                        account = new Account(str2, str3);
                    } else if (!TextUtils.isEmpty(str)) {
                        this.f15136f = com.customize.contacts.simcontacts.b.g(b0.K(this.f15111L, str));
                        this.f15138g = "com.android.oplus.sim";
                        account = new Account(this.f15136f, this.f15138g);
                    } else if (!s3()) {
                        if (this.f15155o0 > 0) {
                            this.f15136f = R0.a.f3165a;
                            this.f15138g = R0.a.f3166b;
                            account = new Account(this.f15136f, this.f15138g);
                        } else {
                            account = new Account(this.f15136f, this.f15138g);
                            if (W2() > 1) {
                                a4();
                            }
                        }
                    } else {
                        account = new Account(R0.a.f3165a, R0.a.f3166b);
                    }
                    H7.b.b("ContactEditorFragment", "onActivityCreated: " + s3());
                    if (s3()) {
                        i10 = R.string.edit_my_info;
                    }
                    this.f15133d0 = i10;
                    this.f15162s0.setTitle(i10);
                    Bundle bundle2 = this.f15114O;
                    if (bundle2 != null) {
                        str4 = bundle2.getString("android.provider.extra.DATA_SET");
                    }
                    M2(new AccountWithDataSet(account.f16941a, account.f16942b, str4));
                }
            } else {
                if (!s3()) {
                    i11 = R.string.editContactDescription;
                }
                this.f15133d0 = i11;
                H7.b.b("ContactEditorFragment", "onActivityCreated: run1" + s3());
                this.f15162s0.setTitle(this.f15133d0);
                this.f15152n = true;
                q4(true);
                getLoaderManager().e(1, null, this.f15101E0);
            }
        }
        Z3(this.f15162s0.getMenu());
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i10, int i11, Intent intent) {
        Uri uri;
        AccountWithDataSet accountWithDataSet;
        int i12;
        String str;
        boolean z10 = true;
        if (this.f15127a0 == 4) {
            this.f15127a0 = 1;
        }
        H7.b.e("ContactEditorFragment", "requestCode = " + i10 + ", resultCode = " + i11);
        if (i10 != 0) {
            if (i10 != 1 && i10 != 2) {
                if (i10 != 3) {
                    if (i10 != 998) {
                        if (i10 != 999) {
                            if (i10 != 1003) {
                                if (i10 != 1004) {
                                    com.customize.contacts.manager.z zVar = this.f15134e;
                                    if (zVar != null) {
                                        zVar.b(i10, i11, intent);
                                        return;
                                    }
                                    return;
                                }
                            } else {
                                if (i11 != -1) {
                                    h0.X(getContext());
                                    h0.F(getContext(), "no");
                                    return;
                                }
                                if (intent != null && intent.getData() != null) {
                                    com.android.contacts.util.i.u(this.f15111L, intent.getData(), this.f15159q0, false);
                                }
                                Context context = getContext();
                                if (this.f15153n0) {
                                    str = OplusPhoneUtils.DeviceState.LOCK_DEVICE;
                                } else {
                                    str = "2";
                                }
                                h0.T(context, 2, "state", str);
                                m4(true);
                                return;
                            }
                        } else {
                            FragmentActivity activity = getActivity();
                            if (activity != null && !activity.isFinishing() && !com.android.contacts.util.w.k(activity, "android.permission.CAMERA")) {
                                if (shouldShowRequestPermissionRationale("android.permission.CAMERA")) {
                                    requestPermissions(new String[]{"android.permission.CAMERA"}, 10);
                                    return;
                                }
                                if (com.android.contacts.framework.api.appstore.appinfo.a.k()) {
                                    i12 = R.string.launcher_odialer;
                                } else {
                                    i12 = R.string.people;
                                }
                                com.android.contacts.util.w.C(activity, false, getString(i12), null, new String[]{"android.permission.CAMERA"});
                                return;
                            }
                            return;
                        }
                    } else {
                        H7.b.e("ContactEditorFragment", "onActivityResult PERMISSION_AUDIO_RESULT_CODE");
                        return;
                    }
                } else if (i11 != -1) {
                    this.f15115P.c();
                    return;
                } else if (intent != null && (accountWithDataSet = (AccountWithDataSet) C7.e.j(intent, "android.provider.extra.ACCOUNT")) != null) {
                    M2(accountWithDataSet);
                    return;
                } else {
                    L2();
                    return;
                }
            }
            if (i11 != -1) {
                h0.X(getContext());
                h0.F(getActivity(), "no");
                return;
            }
            if (intent != null && intent.getData() != null) {
                uri = intent.getData();
                z10 = false;
            } else {
                uri = this.f15161r0;
            }
            if (!z10) {
                Uri uri2 = this.f15161r0;
                try {
                    if (!com.android.contacts.util.i.u(this.f15111L, uri, uri2, false)) {
                        return;
                    } else {
                        uri = uri2;
                    }
                } catch (SecurityException unused) {
                    H7.b.b("ContactEditorFragment", "Did not have read-access to uri : " + uri);
                    return;
                }
            }
            Intent l10 = com.android.contacts.util.i.l(uri, this.f15159q0);
            ResolveInfo b10 = P7.c.b(l10, this.f15111L, false);
            if (b10 != null) {
                l10.setPackage(b10.activityInfo.packageName);
                T2(l10);
                return;
            } else {
                this.f15159q0 = uri;
                m4(false);
                return;
            }
        }
        if (i11 == -1 && intent != null) {
            D3(ContentUris.parseId(intent.getData()));
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.f15111L = activity;
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        this.f15129b0 = true;
        if (bundle != null) {
            this.f15113N = (Uri) bundle.getParcelable("uri");
            H7.b.e("ContactEditorFragment", "onCreate mLookupUri = " + this.f15113N);
            this.f15112M = bundle.getString(AFConstants.EXTRA_INTENT_ACTION);
        }
        super.onCreate(bundle);
        if (bundle == null) {
            this.f15124Y = new ViewIdGenerator();
            this.f15161r0 = com.android.contacts.util.i.i(this.f15111L);
            this.f15159q0 = com.android.contacts.util.i.g(this.f15111L);
            this.f15172z0 = com.android.contacts.util.i.j(this.f15111L);
        } else {
            EntityDeltaList entityDeltaList = (EntityDeltaList) bundle.getParcelable("state");
            this.f15119T = entityDeltaList;
            if (entityDeltaList != null) {
                entityDeltaList.p(this.f15097C0);
            }
            this.f15161r0 = Uri.parse(bundle.getString("temp_photo_uri"));
            this.f15159q0 = Uri.parse(bundle.getString("cropped_photo_uri"));
            this.f15172z0 = Uri.parse(bundle.getString("temp_omoji_photo_uri"));
            this.f15153n0 = bundle.getBoolean("take_photo", false);
            this.f15106H = bundle.getLong("photorequester");
            this.f15124Y = (ViewIdGenerator) bundle.getParcelable("viewidgenerator");
            String string = bundle.getString("currentphotofile");
            if (string != null) {
                this.f15110K = new File(string);
            }
            this.f15116Q = bundle.getLong("contactidforjoin");
            this.f15117R = bundle.getBoolean("contactwritableforjoin");
            this.f15131c0 = bundle.getLong("showJoinSuggestions");
            this.f15137f0 = bundle.getBoolean("enabled");
            this.f15127a0 = bundle.getInt(AFConstants.EXTRA_STATUS);
            this.f15141h0 = bundle.getBoolean("newLocalProfile");
            this.f15143i0 = bundle.getBoolean("isUserProfile");
            this.f15152n = bundle.getBoolean("isEdit");
            this.f15163t0 = bundle.getBoolean("need_show_base_items");
            this.f15132d = (InputFieldUploadStatus) bundle.getParcelable("input_field_upload_status");
            this.f15093A0 = bundle.getString("display_name");
            q4(this.f15152n);
        }
        this.f15147k0 = new ThreadPoolExecutor(1, 2, 180L, TimeUnit.SECONDS, new LinkedBlockingQueue());
        this.f15149l0 = Executors.newSingleThreadExecutor();
        com.customize.contacts.manager.z zVar = new com.customize.contacts.manager.z(getActivity());
        this.f15134e = zVar;
        zVar.c();
        d4();
        o4();
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.contact_editor_fragment, viewGroup, false);
        ((ScrollView) inflate.findViewById(R.id.contact_editor_fragment_scrollView)).setNestedScrollingEnabled(true);
        this.f15118S = (LinearLayout) inflate.findViewById(R.id.editors);
        COUIToolbar cOUIToolbar = (COUIToolbar) inflate.findViewById(R.id.toolbar);
        this.f15162s0 = cOUIToolbar;
        cOUIToolbar.setIsTitleCenterStyle(true);
        this.f15162s0.inflateMenu(R.menu.cancel_save_menu);
        this.f15162s0.setOnMenuItemClickListener(new Toolbar.g() { // from class: com.android.contacts.editor.g
            @Override // androidx.appcompat.widget.Toolbar.g
            public final boolean onMenuItemClick(MenuItem menuItem) {
                boolean J32;
                J32 = ContactEditorFragment.this.J3(menuItem);
                return J32;
            }
        });
        this.f15162s0.post(new Runnable() { // from class: com.android.contacts.editor.h
            @Override // java.lang.Runnable
            public final void run() {
                ContactEditorFragment.this.K3();
            }
        });
        return inflate;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        ThreadPoolExecutor threadPoolExecutor = this.f15147k0;
        if (threadPoolExecutor != null) {
            threadPoolExecutor.shutdown();
        }
        q4(false);
        getActivity().getIntent().putExtra("STORAGE_TYPE", this.f15138g);
        getActivity().getIntent().putExtra("account_name", this.f15136f);
        EntityDelta.t0(null);
        ContactSaveService.o();
        S2();
        androidx.appcompat.app.b bVar = this.f15171z;
        if (bVar != null) {
            bVar.dismiss();
            this.f15171z = null;
        }
        Dialog dialog = this.f15157p0;
        if (dialog != null) {
            dialog.dismiss();
            this.f15157p0 = null;
        }
        com.customize.contacts.manager.z zVar = this.f15134e;
        if (zVar != null) {
            zVar.d();
        }
        COUIPopupListWindow cOUIPopupListWindow = this.f15092A;
        if (cOUIPopupListWindow != null && cOUIPopupListWindow.isShowing()) {
            this.f15092A.dismiss();
        }
        this.f15092A = null;
        J4();
        SoftKeyboardUtil.a().b(this.f15118S);
        com.android.contacts.util.y.c().f();
        ContentAssociateCreator contentAssociateCreator = this.f15102F;
        if (contentAssociateCreator != null) {
            contentAssociateCreator.l();
            this.f15102F = null;
        }
        getParentFragmentManager().v("panel_request_key_for_edit");
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        COUIPopupListWindow cOUIPopupListWindow = this.f15092A;
        if (cOUIPopupListWindow != null && cOUIPopupListWindow.isShowing()) {
            this.f15092A.dismiss();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onRequestPermissionsResult(int i10, String[] strArr, int[] iArr) {
        boolean z10;
        int i11;
        FragmentActivity activity = getActivity();
        if (activity != null && !activity.isFinishing()) {
            int i12 = 0;
            while (true) {
                if (i12 < iArr.length) {
                    if (iArr[i12] != 0) {
                        z10 = false;
                        break;
                    }
                    i12++;
                } else {
                    z10 = true;
                    break;
                }
            }
            if (i10 != 10) {
                if (i10 == 11) {
                    if (z10) {
                        if (!com.android.contacts.util.w.k(activity, com.android.contacts.util.w.e())) {
                            return;
                        }
                        X3();
                        return;
                    } else {
                        if (!shouldShowRequestPermissionRationale(com.android.contacts.util.w.e())) {
                            com.android.contacts.util.w.z(activity, false, null, com.android.contacts.util.w.e(), 998);
                            EditRingtoneView editRingtoneView = this.f15128b;
                            if (editRingtoneView != null) {
                                editRingtoneView.clearFocus();
                                return;
                            }
                            return;
                        }
                        return;
                    }
                }
                return;
            }
            if (z10) {
                String str = C1501d.f36274c;
                if (com.android.contacts.framework.baseui.util.l.d(activity, str)) {
                    com.android.contacts.framework.baseui.util.l.f(activity, str, null, 0);
                    return;
                } else if (com.android.contacts.framework.baseui.util.l.d(activity, C0811w.c(activity))) {
                    com.android.contacts.framework.baseui.util.l.f(activity, C0811w.c(activity), null, 0);
                    return;
                } else {
                    I4(this.f15161r0, false);
                    return;
                }
            }
            if (!shouldShowRequestPermissionRationale("android.permission.CAMERA")) {
                if (com.android.contacts.framework.api.appstore.appinfo.a.k()) {
                    i11 = R.string.launcher_odialer;
                } else {
                    i11 = R.string.people;
                }
                com.android.contacts.util.w.C(activity, false, getString(i11), null, new String[]{"android.permission.CAMERA"});
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        this.f15165v0 = false;
        EditRingtoneView editRingtoneView = this.f15128b;
        if (editRingtoneView != null) {
            editRingtoneView.o();
        }
        super.onResume();
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        bundle.putParcelable("uri", this.f15113N);
        bundle.putString(AFConstants.EXTRA_INTENT_ACTION, this.f15112M);
        bundle.putBoolean("account_is_loading", this.f15166w0);
        if (l3()) {
            bundle.putParcelable("state", this.f15119T);
        }
        bundle.putLong("photorequester", this.f15106H);
        bundle.putParcelable("viewidgenerator", this.f15124Y);
        File file = this.f15110K;
        if (file != null) {
            bundle.putString("currentphotofile", file.toString());
        }
        bundle.putLong("contactidforjoin", this.f15116Q);
        bundle.putBoolean("contactwritableforjoin", this.f15117R);
        bundle.putLong("showJoinSuggestions", this.f15131c0);
        bundle.putBoolean("enabled", this.f15137f0);
        bundle.putBoolean("newLocalProfile", this.f15141h0);
        bundle.putBoolean("isUserProfile", this.f15143i0);
        bundle.putInt(AFConstants.EXTRA_STATUS, this.f15127a0);
        bundle.putBoolean("isEdit", this.f15152n);
        bundle.putBoolean("need_show_base_items", this.f15163t0);
        bundle.putParcelable("input_field_upload_status", this.f15132d);
        Uri uri = this.f15161r0;
        if (uri != null) {
            bundle.putString("temp_photo_uri", uri.toString());
        }
        Uri uri2 = this.f15159q0;
        if (uri2 != null) {
            bundle.putString("cropped_photo_uri", uri2.toString());
        }
        Uri uri3 = this.f15172z0;
        if (uri3 != null) {
            bundle.putString("temp_omoji_photo_uri", uri3.toString());
        }
        bundle.putBoolean("take_photo", this.f15153n0);
        String str = this.f15093A0;
        if (str != null) {
            bundle.putString("display_name", str);
        }
        super.onSaveInstanceState(bundle);
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        getLoaderManager().e(2, null, this.f15103F0);
        if (this.f15127a0 == 4) {
            this.f15127a0 = 1;
        }
        c4();
        super.onStart();
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        if (this.f15164u0 != null) {
            try {
                getActivity().unregisterReceiver(this.f15164u0);
                this.f15164u0 = null;
            } catch (IllegalArgumentException e10) {
                H7.b.c("ContactEditorFragment", "Exception e: " + e10);
            }
        }
        super.onStop();
    }

    public boolean p3() {
        for (String str : BaseRawContactEditorView.f15081i) {
            if ("vnd.android.cursor.item/custom_vibration".equals(str)) {
                if (TextUtils.isEmpty(this.f15121V.N().z("custom_vibration"))) {
                    return false;
                }
            } else if ("vnd.android.cursor.item/custom_ringtone".equals(str)) {
                if (TextUtils.isEmpty(this.f15121V.N().z("custom_ringtone"))) {
                    return false;
                }
            } else if ("vnd.android.cursor.item/name".equals(str)) {
                ArrayList<EntityDelta.ValuesDelta> D10 = this.f15121V.D(str);
                if (D10 != null && D10.size() > 0) {
                    String z10 = D10.get(0).z("data7");
                    String z11 = D10.get(0).z("data8");
                    String z12 = D10.get(0).z("data9");
                    if (TextUtils.isEmpty(z10) && TextUtils.isEmpty(z11) && TextUtils.isEmpty(z12)) {
                        return false;
                    }
                }
            } else {
                ArrayList<EntityDelta.ValuesDelta> D11 = this.f15121V.D(str);
                if (D11 == null || D11.size() == 0) {
                    return false;
                }
            }
        }
        return true;
    }

    public void p4(Bundle bundle) {
        if (bundle != null && bundle.size() != 0 && this.f15119T != null) {
            AbstractC1362a h10 = AbstractC1362a.h(this.f15111L);
            Iterator<EntityDelta> it = this.f15119T.iterator();
            while (it.hasNext()) {
                EntityDelta next = it.next();
                AccountType c10 = h10.c(next.N().z("account_type"), next.N().z("data_set"));
                if (c10.b()) {
                    com.android.contacts.model.d.G(this.f15111L, c10, next, bundle);
                    this.f15138g = next.N().z("account_type");
                    this.f15136f = next.N().z("account_name");
                }
            }
        }
    }

    public final boolean q3() {
        int i10;
        AbstractC1362a h10 = AbstractC1362a.h(this.f15111L);
        EntityDeltaList entityDeltaList = this.f15119T;
        if (entityDeltaList != null) {
            i10 = entityDeltaList.size();
        } else {
            i10 = 0;
        }
        for (int i11 = 0; i11 < i10; i11++) {
            EntityDelta.ValuesDelta N10 = this.f15119T.get(i11).N();
            if (h10.c(N10.z("account_type"), N10.z("data_set")).b()) {
                return true;
            }
        }
        return false;
    }

    public final void q4(boolean z10) {
        f15091I0 = z10;
    }

    public void r4(boolean z10) {
        this.f15150m = z10;
    }

    @Override // com.android.contacts.util.s
    public void s(String str, String str2, View view) {
        if (getContext() == null) {
            if (H7.a.b()) {
                H7.b.i("ContactEditorFragment", "the context in onReadyToContentAssociate is null, return");
                return;
            }
            return;
        }
        if (C0638c.f15889a.c()) {
            if (H7.a.b()) {
                H7.b.b("ContactEditorFragment", "Number masking function is turned on!");
                return;
            }
            return;
        }
        if (this.f15102F == null) {
            this.f15102F = new ContentAssociateCreator(getContext(), new C1393c(this.f15111L.getApplicationContext()).g(), this);
        }
        if (this.f15102F.u()) {
            this.f15102F.k();
        }
        H7.b.b("ContactEditorFragment", "start ready to query " + str);
        if (TextUtils.equals("#displayName", str)) {
            str = "vnd.android.cursor.item/name";
        }
        this.f15102F.y(this.f15152n);
        this.f15102F.A(str);
        this.f15102F.z(str2);
        this.f15102F.v(this.f15148l);
        this.f15102F.w(view);
        this.f15102F.G();
    }

    public boolean s3() {
        if (!this.f15141h0 && !this.f15143i0 && !this.f15145j0) {
            return false;
        }
        return true;
    }

    public void s4(boolean z10) {
        this.f15165v0 = z10;
    }

    @Override // com.android.contacts.util.ContentAssociateCreator.a
    public void t0(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            Log.w("ContactEditorFragment", "the lookup key is empty ,return");
            return;
        }
        this.f15113N = Uri.parse("content://com.android.contacts/contacts/lookup/" + str + "/" + str2);
        StringBuilder sb = new StringBuilder();
        sb.append("the new lookup uri is : ");
        sb.append(this.f15113N);
        H7.b.b("ContactEditorFragment", sb.toString());
        this.f15122W = this.f15121V;
        getLoaderManager().g(1, null, this.f15101E0);
    }

    public final boolean t3(EntityDelta entityDelta) {
        String z10;
        if (entityDelta == null) {
            return false;
        }
        ArrayList arrayList = new ArrayList(Arrays.asList("vnd.android.cursor.item/phone_v2", "vnd.android.cursor.item/email_v2"));
        for (Map.Entry<String, ArrayList<EntityDelta.ValuesDelta>> entry : entityDelta.x().entrySet()) {
            if (!arrayList.contains(entry.getKey())) {
                Iterator<EntityDelta.ValuesDelta> it = entry.getValue().iterator();
                while (it.hasNext()) {
                    EntityDelta.ValuesDelta next = it.next();
                    if (next != null) {
                        if ("vnd.android.cursor.item/photo".equals(entry.getKey())) {
                            z10 = next.z("data15");
                        } else if ("vnd.android.cursor.item/custom_ringtone".equals(entry.getKey())) {
                            z10 = com.customize.contacts.manager.i.e(this.f15111L, next.z("custom_ringtone"));
                        } else if ("vnd.android.cursor.item/custom_vibration".equals(entry.getKey())) {
                            z10 = next.z("custom_vibration");
                        } else if ("vnd.android.cursor.item/name".equals(entry.getKey())) {
                            String z11 = next.z("data7");
                            String z12 = next.z("data8");
                            String z13 = next.z("data9");
                            if (!TextUtils.isEmpty(z11) || !TextUtils.isEmpty(z12) || !TextUtils.isEmpty(z13)) {
                                return true;
                            }
                            z10 = "";
                        } else {
                            z10 = next.z("data1");
                        }
                        if (!TextUtils.isEmpty(z10)) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    public void t4(u uVar) {
        this.f15115P = uVar;
    }

    public boolean u3() {
        Iterator<EntityDelta> it = this.f15119T.iterator();
        while (it.hasNext()) {
            EntityDelta next = it.next();
            if (next != null) {
                Iterator<Map.Entry<String, ArrayList<EntityDelta.ValuesDelta>>> it2 = next.x().entrySet().iterator();
                while (it2.hasNext()) {
                    Iterator<EntityDelta.ValuesDelta> it3 = it2.next().getValue().iterator();
                    while (it3.hasNext()) {
                        if (!TextUtils.isEmpty(it3.next().z("data1"))) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    public final void u4(boolean z10) {
        EntityDelta entityDelta = this.f15121V;
        if (entityDelta != null) {
            entityDelta.x0(z10);
        }
    }

    public boolean v3() {
        if ("com.oplus.contacts.sim".equals(this.f15138g) || TextUtils.equals("com.android.oplus.sim", this.f15138g)) {
            Iterator<EntityDelta> it = this.f15119T.iterator();
            while (it.hasNext()) {
                ArrayList<EntityDelta.ValuesDelta> D10 = it.next().D("vnd.android.cursor.item/name");
                if (C0811w.g(D10)) {
                    return true;
                }
                String z10 = D10.get(0).z("data1");
                if (!TextUtils.isEmpty(z10)) {
                    z10 = z10.replace(" ", "");
                }
                if (TextUtils.isEmpty(z10)) {
                    return true;
                }
            }
        }
        return false;
    }

    public final void v4(long j10, Bitmap bitmap) {
        BaseRawContactEditorView h32 = h3(j10);
        if (h32 != null) {
            h32.setPhotoBitmap(bitmap);
        } else {
            H7.b.i("ContactEditorFragment", "The contact that requested the photo is no longer present.");
        }
    }

    public boolean w3() {
        if ("com.oplus.contacts.sim".equals(this.f15138g)) {
            Iterator<EntityDelta> it = this.f15119T.iterator();
            while (it.hasNext()) {
                ArrayList<EntityDelta.ValuesDelta> D10 = it.next().D("vnd.android.cursor.item/name");
                if (C0811w.g(D10)) {
                    return false;
                }
                String z10 = D10.get(0).z("data1");
                H7.b.b("ContactEditorFragment", "isNameUnFitSimCard name = ");
                if (x3(z10)) {
                    return true;
                }
            }
        }
        return false;
    }

    public final void x2(EntityDelta entityDelta, BaseRawContactEditorView baseRawContactEditorView) {
        EntityDelta.ValuesDelta N10 = entityDelta.N();
        String z10 = N10.z("account_name");
        String z11 = N10.z("account_type");
        if (TextUtils.isEmpty(z10) || TextUtils.isEmpty(z11)) {
            z10 = R0.a.f3165a;
            z11 = R0.a.f3166b;
        }
        this.f15146k = new AccountWithDataSet(z10, z11, N10.z("data_set"));
        this.f15167x = baseRawContactEditorView.findViewById(R.id.account);
        this.f15169y = (ImageView) baseRawContactEditorView.findViewById(R.id.editor_expansion_view);
        View findViewById = baseRawContactEditorView.findViewById(R.id.expansion_click_view);
        if (this.f15167x == null) {
            H7.b.b("ContactEditorFragment", "mAnchorView is null, editor = " + baseRawContactEditorView);
            return;
        }
        if (this.f15113N != null) {
            Q2(this.f15168x0);
        } else {
            findViewById.setOnClickListener(new l());
        }
    }

    public boolean x3(String str) {
        int q10;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        int i10 = 14;
        if (FeatureOption.o() && (q10 = b0.q(this.f15111L, null, this.f15136f)) >= 0) {
            i10 = q10;
        }
        H7.b.b("ContactEditorFragment", "isNameUnFitSimCard, the simNameBytes is " + i10);
        if (str.length() > i10) {
            return true;
        }
        if (str.length() >= i10 / 2 && Pattern.compile("^[一-龥]{1,}.?[“%（）~‘，。？！：；……一-龥]{1}$").matcher(str).matches() && str.length() > i10) {
            return true;
        }
        if (!Pattern.compile("^[a-zA-Z\\d]{6,}.?[“%（）~‘，。？！：；……一-龥]{1}$").matcher(str).matches() || str.getBytes().length <= i10) {
            return false;
        }
        return true;
    }

    public void x4(boolean z10) {
        ImageView imageView = this.f15169y;
        if (imageView == null) {
            return;
        }
        ViewPropertyAnimator interpolator = imageView.animate().setDuration(400L).setInterpolator(Z3.f.f5907g);
        if (z10) {
            interpolator.rotation(0.0f).start();
        } else {
            interpolator.rotation(180.0f).start();
        }
    }

    public final void y2() {
        String l10 = C7.e.l(getActivity().getIntent(), "business_card_photo_path");
        H7.b.b("ContactEditorFragment", "addBusinessCardPhoto: businessCardPhotoPath = ");
        if (!TextUtils.isEmpty(l10)) {
            Bitmap decodeFile = BitmapFactory.decodeFile(l10);
            String substring = l10.substring(l10.lastIndexOf("/") + 1, l10.lastIndexOf("."));
            H7.b.b("ContactEditorFragment", "addBusinessCardPhoto: photo = " + decodeFile);
            if (decodeFile != null) {
                byte[] d10 = com.android.contacts.util.i.d(decodeFile);
                ContentValues contentValues = new ContentValues();
                contentValues.put("mimetype", "vnd.android.cursor.item/business_card_photo");
                contentValues.put("raw_contact_id", Long.valueOf(this.f15123X));
                contentValues.put("data15", d10);
                contentValues.put("data2", (Integer) 0);
                contentValues.put("data1", substring);
                EntityDelta.ValuesDelta m10 = EntityDelta.ValuesDelta.m(contentValues);
                EntityDelta entityDelta = this.f15121V;
                if (entityDelta != null) {
                    entityDelta.d(m10);
                } else {
                    this.f15119T.add(new EntityDelta(m10));
                }
            }
        }
    }

    public String y3() {
        if (!l3()) {
            return null;
        }
        if ("com.oplus.contacts.sim".equals(this.f15138g) || TextUtils.equals("com.android.oplus.sim", this.f15138g)) {
            Iterator<EntityDelta> it = this.f15119T.iterator();
            while (it.hasNext()) {
                ArrayList<EntityDelta.ValuesDelta> D10 = it.next().D("vnd.android.cursor.item/phone_v2");
                if (C0811w.g(D10)) {
                    return null;
                }
                String str = "";
                boolean z10 = false;
                for (EntityDelta.ValuesDelta valuesDelta : D10) {
                    if (valuesDelta.R()) {
                        str = valuesDelta.z("data1");
                        if (TextUtils.isEmpty(str)) {
                            continue;
                        } else {
                            str = U7.f.d(str);
                            valuesDelta.e0("data1", str);
                            if (!PhoneNumberUtils.c(str)) {
                                return str;
                            }
                            if (!TextUtils.isEmpty(str)) {
                                z10 = true;
                            }
                        }
                    }
                }
                if (z10) {
                    return null;
                }
                if (TextUtils.isEmpty(str)) {
                    return "number_null";
                }
            }
        }
        EntityDelta entityDelta = this.f15121V;
        if (entityDelta == null) {
            return null;
        }
        ArrayList<EntityDelta.ValuesDelta> D11 = entityDelta.D("vnd.android.cursor.item/phone_v2");
        if (C0811w.g(D11)) {
            return null;
        }
        for (EntityDelta.ValuesDelta valuesDelta2 : D11) {
            if (valuesDelta2.R()) {
                String z11 = valuesDelta2.z("data1");
                if (TextUtils.isEmpty(z11)) {
                    continue;
                } else {
                    String d10 = U7.f.d(z11);
                    valuesDelta2.e0("data1", d10);
                    if (!PhoneNumberUtils.c(d10)) {
                        return d10;
                    }
                }
            }
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x00f7  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0109  */
    /* JADX WARN: Removed duplicated region for block: B:19:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0100  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0097  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void y4(android.view.LayoutInflater r5, android.view.View r6, n1.AbstractC1362a r7, M3.c.a r8, boolean r9) {
        /*
            Method dump skipped, instructions count: 271
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.contacts.editor.ContactEditorFragment.y4(android.view.LayoutInflater, android.view.View, n1.a, M3.c$a, boolean):void");
    }

    public final void z2(Context context, boolean z10, BreenoCallLogEntity breenoCallLogEntity) {
        BreenoCallStatistics.trackEditorAction(context, z10, a3("vnd.android.cursor.item/name", "data1"), a3("vnd.android.cursor.item/organization", "data1"), a3("vnd.android.cursor.item/organization", "data4"), a3("vnd.android.cursor.item/note", "data1"), breenoCallLogEntity);
    }

    public boolean z3() {
        for (String str : BaseRawContactEditorView.f15081i) {
            if (!"vnd.android.cursor.item/custom_ringtone".equals(str) && !"vnd.android.cursor.item/custom_vibration".equals(str) && !"vnd.android.cursor.item/group_membership".equals(str)) {
                if ("vnd.android.cursor.item/name".equals(str)) {
                    ArrayList<EntityDelta.ValuesDelta> D10 = this.f15121V.D(str);
                    if (D10 != null && D10.size() > 0) {
                        String z10 = D10.get(0).z("data7");
                        String z11 = D10.get(0).z("data8");
                        String z12 = D10.get(0).z("data9");
                        if (TextUtils.isEmpty(z10) && TextUtils.isEmpty(z11) && TextUtils.isEmpty(z12)) {
                            return false;
                        }
                    }
                } else {
                    ArrayList<EntityDelta.ValuesDelta> D11 = this.f15121V.D(str);
                    if (D11 == null || D11.size() == 0) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public final void z4(ArrayList<Account> arrayList) {
        boolean z10;
        if (getActivity() == null) {
            H7.b.b("ContactEditorFragment", "showAccountPopupwindow getActivity() is null, then return.");
            return;
        }
        this.f15096C = arrayList;
        Account account = new Account(this.f15136f, this.f15138g);
        int size = arrayList.size();
        final ArrayList arrayList2 = new ArrayList();
        for (int i10 = 0; i10 != size; i10++) {
            Account account2 = arrayList.get(i10);
            if (account.equals(account2)) {
                this.f15142i = i10;
                C1480a.b(this.f15111L, account2);
                z10 = true;
            } else {
                z10 = false;
            }
            arrayList2.add(com.android.contacts.framework.baseui.util.q.c(c3(account2), true, z10, -1, e3(account2)));
        }
        COUIPopupListWindow cOUIPopupListWindow = this.f15092A;
        if (cOUIPopupListWindow != null && cOUIPopupListWindow.isShowing()) {
            this.f15092A.dismiss();
        }
        COUIPopupListWindow cOUIPopupListWindow2 = new COUIPopupListWindow(this.f15111L);
        this.f15092A = cOUIPopupListWindow2;
        cOUIPopupListWindow2.setItemList(arrayList2);
        this.f15092A.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.android.contacts.editor.e
            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView adapterView, View view, int i11, long j10) {
                ContactEditorFragment.this.Q3(arrayList2, adapterView, view, i11, j10);
            }
        });
        this.f15092A.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.android.contacts.editor.f
            @Override // android.widget.PopupWindow.OnDismissListener
            public final void onDismiss() {
                ContactEditorFragment.this.R3();
            }
        });
        this.f15092A.setDismissTouchOutside(true);
        this.f15092A.setInputMethodMode(2);
        this.f15092A.show(this.f15167x);
        this.f15144j = false;
    }

    /* loaded from: classes.dex */
    public class a implements a.InterfaceC0129a<Cursor> {
        public a() {
        }

        @Override // androidx.loader.app.a.InterfaceC0129a
        public W.c<Cursor> Z(int i10, Bundle bundle) {
            return new N0(ContactEditorFragment.this.f15111L, ContactsContract.Groups.CONTENT_URI);
        }

        @Override // androidx.loader.app.a.InterfaceC0129a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void S0(W.c<Cursor> cVar, Cursor cursor) {
            if (cursor != null && !(cursor instanceof C1322s)) {
                cursor = new C1322s(cursor);
            }
            ContactEditorFragment.this.f15109J = cursor;
            ContactEditorFragment.this.I2();
        }

        @Override // androidx.loader.app.a.InterfaceC0129a
        public void Q(W.c<Cursor> cVar) {
        }
    }

    /* loaded from: classes.dex */
    public class d implements DialogInterface.OnDismissListener {
        public d() {
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
        }
    }

    /* loaded from: classes.dex */
    public class q implements a.InterfaceC0129a<ContactLoader.Result> {
        public q() {
        }

        @Override // androidx.loader.app.a.InterfaceC0129a
        public W.c<ContactLoader.Result> Z(int i10, Bundle bundle) {
            ContactEditorFragment.this.f15125Z = SystemClock.elapsedRealtime();
            SimContactInfo simContactInfo = (SimContactInfo) C7.e.j(ContactEditorFragment.this.getActivity().getIntent(), "sim_contacts_info");
            if (simContactInfo != null) {
                return new Y0(ContactEditorFragment.this.f15111L, simContactInfo);
            }
            return new ContactLoader(ContactEditorFragment.this.f15111L, ContactEditorFragment.this.f15113N);
        }

        @Override // androidx.loader.app.a.InterfaceC0129a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void S0(W.c<ContactLoader.Result> cVar, ContactLoader.Result result) {
            H7.b.h("ContactEditorFragment", "Time needed for loading: " + (SystemClock.elapsedRealtime() - ContactEditorFragment.this.f15125Z));
            if (result.d0()) {
                ContactEditorFragment.this.f15127a0 = 1;
                ContactEditorFragment.this.f15113N = result.L();
                ContactEditorFragment.this.f15093A0 = result.B();
                ContactEditorFragment.this.f15154o = result;
                H7.b.e("ContactEditorFragment", "mLookupUri = " + ContactEditorFragment.this.f15113N);
                long elapsedRealtime = SystemClock.elapsedRealtime();
                ContactEditorFragment.this.n4(result);
                long elapsedRealtime2 = SystemClock.elapsedRealtime();
                if (ContactEditorFragment.this.f15108I != -1 && ContactEditorFragment.this.f15106H != -1) {
                    ContactEditorFragment contactEditorFragment = ContactEditorFragment.this;
                    contactEditorFragment.v4(contactEditorFragment.f15108I, ContactEditorFragment.this.f15104G);
                    ContactEditorFragment.this.f15108I = -1L;
                    ContactEditorFragment.this.f15104G = null;
                }
                H7.b.h("ContactEditorFragment", "Time needed for setting UI: " + (elapsedRealtime2 - elapsedRealtime));
                return;
            }
            H7.b.e("ContactEditorFragment", "No contact found. Closing activity");
            if (ContactEditorFragment.this.f15115P != null) {
                ContactEditorFragment.this.f15115P.a();
            }
        }

        @Override // androidx.loader.app.a.InterfaceC0129a
        public void Q(W.c<ContactLoader.Result> cVar) {
        }
    }
}
