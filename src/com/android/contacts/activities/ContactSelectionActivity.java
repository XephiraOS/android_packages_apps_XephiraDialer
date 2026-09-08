package com.android.contacts.activities;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.ContentUris;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.provider.ContactsContract;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.AbsListView;
import android.widget.RelativeLayout;
import androidx.activity.n;
import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;
import com.android.contacts.activities.ContactSelectionActivity;
import com.android.contacts.framework.baseui.util.C0636a;
import com.android.contacts.util.B;
import com.android.contacts.util.w;
import com.android.incallui.OplusNumberMarkUtils;
import com.coui.appcompat.searchview.COUISearchBar;
import com.coui.appcompat.statusbar.COUIStatusBarResponseUtil;
import com.coui.appcompat.theme.COUIThemeOverlay;
import com.coui.appcompat.toolbar.COUIToolbar;
import com.customize.contacts.activities.MultiContactPickActivity;
import com.customize.contacts.activities.SearchAnimatorsActivity;
import com.customize.contacts.fragment.p;
import com.customize.contacts.model.IdRecord;
import com.customize.contacts.util.C0792c;
import com.customize.contacts.util.ContactDataUtils;
import com.customize.contacts.util.i0;
import com.google.android.material.appbar.AppBarLayout;
import com.oplus.dialer.R;
import java.util.ArrayList;
import m1.AbstractViewOnFocusChangeListenerC1314j;
import m1.C1318n;
import m1.C1319o;
import m1.G;
import m1.M;
import m1.N;
import m1.O;
import m1.P;
import m1.S;

/* loaded from: classes.dex */
public class ContactSelectionActivity extends SearchAnimatorsActivity implements SearchView.l, View.OnTouchListener, COUIStatusBarResponseUtil.StatusBarClickListener {

    /* renamed from: Q, reason: collision with root package name */
    public BroadcastReceiver f13623Q;

    /* renamed from: R, reason: collision with root package name */
    public AbstractViewOnFocusChangeListenerC1314j<?> f13624R;

    /* renamed from: U, reason: collision with root package name */
    public C1319o f13627U;

    /* renamed from: W, reason: collision with root package name */
    public e f13629W;

    /* renamed from: X, reason: collision with root package name */
    public COUIStatusBarResponseUtil f13630X;

    /* renamed from: T, reason: collision with root package name */
    public int f13626T = -1;

    /* renamed from: V, reason: collision with root package name */
    public boolean f13628V = true;

    /* renamed from: S, reason: collision with root package name */
    public final C1318n f13625S = new C1318n(this);

    /* loaded from: classes.dex */
    public class a extends n {
        public a(boolean z10) {
            super(z10);
        }

        @Override // androidx.activity.n
        public void d() {
            if (ContactSelectionActivity.this.U1()) {
                COUISearchBar cOUISearchBar = ContactSelectionActivity.this.f20568p;
                if (cOUISearchBar != null) {
                    cOUISearchBar.changeStateWithAnimation(0);
                    return;
                }
                return;
            }
            ContactSelectionActivity.this.finish();
        }
    }

    /* loaded from: classes.dex */
    public class b implements ViewTreeObserver.OnGlobalLayoutListener {
        public b() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            ContactSelectionActivity.this.f20572y.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            int measuredHeight = ContactSelectionActivity.this.f20572y.getMeasuredHeight();
            ContactSelectionActivity contactSelectionActivity = ContactSelectionActivity.this;
            if (contactSelectionActivity.f20568p == null) {
                contactSelectionActivity.f20568p = contactSelectionActivity.f13624R.n1();
            }
            ContactSelectionActivity contactSelectionActivity2 = ContactSelectionActivity.this;
            if (contactSelectionActivity2.f20568p != null) {
                int dimensionPixelSize = measuredHeight - contactSelectionActivity2.getResources().getDimensionPixelSize(R.dimen.divider_background_height);
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) ContactSelectionActivity.this.f20568p.getLayoutParams();
                layoutParams.topMargin = dimensionPixelSize;
                layoutParams.addRule(10);
                ContactSelectionActivity.this.f20568p.setLayoutParams(layoutParams);
                measuredHeight = dimensionPixelSize + ContactSelectionActivity.this.f20568p.getMeasuredHeight() + ContactSelectionActivity.this.getResources().getDimensionPixelSize(R.dimen.list_padding_top);
            }
            ContactSelectionActivity contactSelectionActivity3 = ContactSelectionActivity.this;
            if (contactSelectionActivity3.f20569q == null) {
                contactSelectionActivity3.f20569q = new View(ContactSelectionActivity.this);
                ContactSelectionActivity.this.f20569q.setVisibility(4);
                ContactSelectionActivity.this.f13624R.u1().addHeaderView(ContactSelectionActivity.this.f20569q);
                ContactSelectionActivity.this.f13624R.i2(measuredHeight);
                ContactSelectionActivity.this.f20569q.setLayoutParams(new AbsListView.LayoutParams(-1, measuredHeight));
            }
            ContactSelectionActivity.this.f13624R.u1().setNestedScrollingEnabled(true);
        }
    }

    /* loaded from: classes.dex */
    public final class c implements M {
        @Override // m1.M
        public void a(Intent intent) {
            ContactSelectionActivity.this.m2(intent);
        }

        @Override // m1.M
        public void b(Uri uri) {
            boolean z10;
            if (uri == null) {
                return;
            }
            Bundle extras = ContactSelectionActivity.this.getIntent().getExtras();
            if (extras != null && !TextUtils.isEmpty(extras.getString("email"))) {
                z10 = true;
            } else {
                z10 = false;
            }
            if (extras != null && extras.getBoolean(R0.b.f3168b)) {
                ContactDataUtils.b(ContactSelectionActivity.this, uri, true);
                ContactSelectionActivity.this.finish();
            } else if (z10) {
                ContactSelectionActivity.this.u2(new Intent("android.intent.action.EDIT", uri));
            } else {
                ContactSelectionActivity.this.u2(new Intent("com.oplus.contacts.EDIT_CONTACTS", uri));
            }
        }

        @Override // m1.M
        public void c(Uri uri) {
            if (uri == null) {
                return;
            }
            if (ContactSelectionActivity.this.f13626T == 150) {
                long parseId = ContentUris.parseId(uri);
                String l10 = C7.e.l(ContactSelectionActivity.this.getIntent(), "CONTACTS_RINGTONE");
                ArrayList<? extends Parcelable> arrayList = new ArrayList<>();
                arrayList.add(new IdRecord(parseId));
                if (H7.a.b()) {
                    H7.b.b("ContactSelection", "contactId = " + parseId);
                    H7.b.b("ContactSelection", "contactsRingTone = " + l10);
                }
                Intent intent = new Intent("com.oplus.contacts.proc.SET_RINGTONE_TO_CONTACTS");
                intent.setPackage(C7.e.g());
                intent.putExtra("CONTACTS_RINGTONE", l10);
                intent.putParcelableArrayListExtra("NEW_RET_CONTACTS", arrayList);
                R7.b.c(ContactSelectionActivity.this, intent);
                ContactSelectionActivity.this.finish();
                return;
            }
            if (ContactSelectionActivity.this.f13626T == 160) {
                ContactSelectionActivity.this.o2(ContentUris.parseId(uri));
            } else {
                ContactSelectionActivity.this.n2(uri);
            }
        }

        @Override // m1.M
        public void d() {
            ContactSelectionActivity.this.v2();
        }

        public c() {
        }
    }

    /* loaded from: classes.dex */
    public final class d extends BroadcastReceiver {
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if ("com.oplus.contacts.display_settings_changed".equals(intent.getAction())) {
                ContactSelectionActivity.this.f13624R.V1();
            }
        }

        public d() {
        }
    }

    /* loaded from: classes.dex */
    public class e implements V3.a {
        @Override // V3.a
        public void a() {
            ContactSelectionActivity.this.e2();
        }

        @Override // V3.a
        public void b() {
            View view = ContactSelectionActivity.this.f20570r;
            if (view != null) {
                view.setVisibility(8);
            }
        }

        @Override // V3.a
        public void c(boolean z10) {
            int i10;
            AbstractViewOnFocusChangeListenerC1314j<?> abstractViewOnFocusChangeListenerC1314j;
            ContactSelectionActivity contactSelectionActivity = ContactSelectionActivity.this;
            if (contactSelectionActivity.f20568p == null && (abstractViewOnFocusChangeListenerC1314j = contactSelectionActivity.f13624R) != null) {
                contactSelectionActivity.f20568p = abstractViewOnFocusChangeListenerC1314j.n1();
            }
            ContactSelectionActivity contactSelectionActivity2 = ContactSelectionActivity.this;
            if (contactSelectionActivity2.f20568p != null && !contactSelectionActivity2.U1()) {
                COUISearchBar cOUISearchBar = ContactSelectionActivity.this.f20568p;
                if (z10) {
                    i10 = 0;
                } else {
                    i10 = 8;
                }
                cOUISearchBar.setVisibility(i10);
            }
        }

        @Override // V3.a
        public void d() {
            View view = ContactSelectionActivity.this.f20570r;
            if (view != null) {
                view.setVisibility(0);
            }
        }

        @Override // V3.a
        public void e() {
            ContactSelectionActivity.this.f2();
        }

        public e() {
        }
    }

    /* loaded from: classes.dex */
    public final class f implements N {
        @Override // m1.N
        public void a(Uri uri) {
            ContactSelectionActivity.this.n2(uri);
        }

        public f() {
        }
    }

    /* loaded from: classes.dex */
    public final class g implements O {
        @Override // m1.O
        public void a(Intent intent) {
            ContactSelectionActivity.this.m2(intent);
        }

        @Override // m1.O
        public void b() {
            ContactSelectionActivity.this.finish();
        }

        @Override // m1.O
        public void c(Uri uri) {
            if ("com.oplus.contacts.ui.SELECT_CONTACTS_FOR_SPEED_DIAL_WIDGET".equals(ContactSelectionActivity.this.getIntent().getAction())) {
                ContactSelectionActivity contactSelectionActivity = ContactSelectionActivity.this;
                B.c(contactSelectionActivity, contactSelectionActivity.getIntent(), uri);
            } else {
                ContactSelectionActivity.this.n2(uri);
            }
        }

        public g() {
        }
    }

    /* loaded from: classes.dex */
    public final class h implements P {
        @Override // m1.P
        public void a(Uri uri) {
            ContactSelectionActivity.this.n2(uri);
        }

        public h() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e2() {
        i2();
        K1();
        AbstractViewOnFocusChangeListenerC1314j<?> abstractViewOnFocusChangeListenerC1314j = this.f13624R;
        if (abstractViewOnFocusChangeListenerC1314j != null) {
            abstractViewOnFocusChangeListenerC1314j.s2(true);
            this.f13624R.e2(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f2() {
        i2();
        E1();
        AbstractViewOnFocusChangeListenerC1314j<?> abstractViewOnFocusChangeListenerC1314j = this.f13624R;
        if (abstractViewOnFocusChangeListenerC1314j != null) {
            abstractViewOnFocusChangeListenerC1314j.s2(false);
            this.f13624R.e2(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void l2(View view) {
        setResult(0);
        finish();
    }

    public final void d2() {
        AppBarLayout appBarLayout = this.f20572y;
        if (appBarLayout != null) {
            appBarLayout.getViewTreeObserver().addOnGlobalLayoutListener(new b());
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        return super.dispatchTouchEvent(motionEvent);
    }

    public final void g2() {
        if (this.f13627U.b() != null) {
            setTitle(this.f13627U.b());
            return;
        }
        switch (this.f13627U.a()) {
            case 60:
            case 70:
            case 80:
            case 90:
            case 100:
            case 105:
            case 150:
            case 160:
            case 170:
                setTitle(R.string.oplus_choose_a_contact);
                return;
            case 110:
                setTitle(R.string.shortcutActivityTitle);
                return;
            case 120:
                setTitle(R.string.callShortcutActivityTitle);
                return;
            case 130:
                setTitle(R.string.messageShortcutActivityTitle);
                return;
            default:
                setTitle(R.string.oplus_choose_a_contact);
                return;
        }
    }

    public void h2() {
        if (this.f13629W == null) {
            this.f13629W = new e();
        }
        H7.b.b("ContactSelection", "mActionCode = " + this.f13626T);
        switch (this.f13626T) {
            case 10:
            case 60:
                com.android.contacts.list.a aVar = new com.android.contacts.list.a();
                aVar.d2(false);
                aVar.M2(this.f13629W);
                this.f13624R = aVar;
                break;
            case 70:
                com.android.contacts.list.a aVar2 = new com.android.contacts.list.a();
                aVar2.M2(this.f13629W);
                this.f13624R = aVar2;
                break;
            case 80:
                com.android.contacts.list.a aVar3 = new com.android.contacts.list.a();
                aVar3.G2(true);
                aVar3.c2(0);
                aVar3.H2(true);
                aVar3.M2(this.f13629W);
                this.f13624R = aVar3;
                break;
            case 90:
                r2();
                p pVar = new p();
                pVar.P2();
                pVar.H2(this.f13629W);
                this.f13624R = pVar;
                break;
            case 100:
                r2();
                this.f13624R = new S();
                break;
            case 105:
                r2();
                com.customize.contacts.fragment.n nVar = new com.customize.contacts.fragment.n();
                nVar.J2(this.f13629W);
                this.f13624R = nVar;
                break;
            case 110:
                com.android.contacts.list.a aVar4 = new com.android.contacts.list.a();
                aVar4.N2(true);
                aVar4.M2(this.f13629W);
                this.f13624R = aVar4;
                break;
            case 120:
                r2();
                p pVar2 = new p();
                pVar2.P2();
                pVar2.I2("android.intent.action.CALL");
                pVar2.H2(this.f13629W);
                this.f13624R = pVar2;
                break;
            case 130:
                r2();
                p pVar3 = new p();
                pVar3.P2();
                pVar3.I2("android.intent.action.SENDTO");
                pVar3.H2(this.f13629W);
                this.f13624R = pVar3;
                break;
            case 150:
                com.android.contacts.list.a aVar5 = new com.android.contacts.list.a();
                aVar5.H2(true);
                aVar5.M2(this.f13629W);
                this.f13624R = aVar5;
                break;
            case 160:
                com.android.contacts.list.a aVar6 = new com.android.contacts.list.a();
                aVar6.M2(this.f13629W);
                aVar6.L2(getIntent());
                this.f13624R = aVar6;
                break;
            case 170:
                com.android.contacts.list.a aVar7 = new com.android.contacts.list.a();
                aVar7.M2(this.f13629W);
                aVar7.J2(true);
                aVar7.H2(true);
                this.f13624R = aVar7;
                break;
            default:
                H7.b.c("ContactSelection", "Invalid action code: " + this.f13626T);
                finish();
                return;
        }
        this.f13624R.g2(this.f13627U.d());
        this.f13624R.b2(20);
        getSupportFragmentManager().p().s(R.id.list_container, this.f13624R).j();
    }

    public final void i2() {
        if (this.f20568p == null) {
            this.f20568p = this.f13624R.n1();
        }
        x1();
        B1();
        z1();
        j2();
    }

    public final void j2() {
        AbstractViewOnFocusChangeListenerC1314j<?> abstractViewOnFocusChangeListenerC1314j;
        if (this.f20570r == null && (abstractViewOnFocusChangeListenerC1314j = this.f13624R) != null) {
            View x12 = abstractViewOnFocusChangeListenerC1314j.x1();
            this.f20570r = x12;
            x12.setOnTouchListener(this);
        }
    }

    public boolean k2() {
        boolean z10 = false;
        try {
            Intent intent = getIntent();
            String str = R0.c.f3183a;
            boolean c10 = C7.e.c(intent, str, false);
            if (!c10) {
                try {
                    if ("from_oplus_app".equals(str)) {
                        return C7.e.c(getIntent(), OplusNumberMarkUtils.OplusContact.FROM_OPLUS_APP, false);
                    }
                    return c10;
                } catch (Exception e10) {
                    e = e10;
                    z10 = c10;
                    H7.b.c("ContactSelection", "" + e);
                    return z10;
                }
            }
            return c10;
        } catch (Exception e11) {
            e = e11;
        }
    }

    public void m2(Intent intent) {
        intent.setFlags(1);
        setResult(-1, intent);
        finish();
    }

    public void n2(Uri uri) {
        Intent intent = new Intent();
        intent.setData(uri);
        m2(intent);
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x005d, code lost:
    
        if (r2.isClosed() == false) goto L7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x0034, code lost:
    
        if (r2.isClosed() == false) goto L7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0036, code lost:
    
        r2.close();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void o2(long r10) {
        /*
            r9 = this;
            java.lang.String r0 = "ContactSelection"
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "_id="
            r1.append(r2)
            r1.append(r10)
            java.lang.String r6 = r1.toString()
            r1 = 0
            android.content.ContentResolver r3 = r9.getContentResolver()     // Catch: java.lang.Throwable -> L3f java.lang.Exception -> L41
            android.net.Uri r4 = android.provider.ContactsContract.Contacts.CONTENT_URI     // Catch: java.lang.Throwable -> L3f java.lang.Exception -> L41
            java.lang.String r2 = "_id"
            java.lang.String r5 = "display_name"
            java.lang.String[] r5 = new java.lang.String[]{r2, r5}     // Catch: java.lang.Throwable -> L3f java.lang.Exception -> L41
            r7 = 0
            r8 = 0
            android.database.Cursor r2 = r3.query(r4, r5, r6, r7, r8)     // Catch: java.lang.Throwable -> L3f java.lang.Exception -> L41
            r2.moveToFirst()     // Catch: java.lang.Throwable -> L3a java.lang.Exception -> L3d
            r3 = 1
            java.lang.String r1 = r2.getString(r3)     // Catch: java.lang.Throwable -> L3a java.lang.Exception -> L3d
            boolean r3 = r2.isClosed()
            if (r3 != 0) goto L60
        L36:
            r2.close()
            goto L60
        L3a:
            r9 = move-exception
            r1 = r2
            goto L91
        L3d:
            r3 = move-exception
            goto L43
        L3f:
            r9 = move-exception
            goto L91
        L41:
            r3 = move-exception
            r2 = r1
        L43:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L3a
            r4.<init>()     // Catch: java.lang.Throwable -> L3a
            java.lang.String r5 = "Exception e: "
            r4.append(r5)     // Catch: java.lang.Throwable -> L3a
            r4.append(r3)     // Catch: java.lang.Throwable -> L3a
            java.lang.String r3 = r4.toString()     // Catch: java.lang.Throwable -> L3a
            H7.b.c(r0, r3)     // Catch: java.lang.Throwable -> L3a
            if (r2 == 0) goto L60
            boolean r3 = r2.isClosed()
            if (r3 != 0) goto L60
            goto L36
        L60:
            android.content.Intent r2 = new android.content.Intent
            r2.<init>()
            java.lang.String r3 = "CONTACT_NAME"
            r2.putExtra(r3, r1)
            java.lang.String r1 = "CONTACT_ID"
            r2.putExtra(r1, r10)
            r1 = -1
            r9.setResult(r1, r2)
            boolean r1 = H7.a.b()
            if (r1 == 0) goto L8d
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "contactId = "
            r1.append(r2)
            r1.append(r10)
            java.lang.String r10 = r1.toString()
            H7.b.b(r0, r10)
        L8d:
            r9.finish()
            return
        L91:
            if (r1 == 0) goto L9c
            boolean r10 = r1.isClosed()
            if (r10 != 0) goto L9c
            r1.close()
        L9c:
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.contacts.activities.ContactSelectionActivity.o2(long):void");
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i10, int i11, Intent intent) {
        super.onActivityResult(i10, i11, intent);
        if (i10 == 0) {
            if (i11 == -1) {
                if (intent != null) {
                    R7.b.c(this, intent);
                }
                finish();
                return;
            }
            return;
        }
        if (i10 == 1) {
            if (i11 == -1) {
                finish();
            }
        } else {
            if (i10 == 2) {
                if (i11 == -1) {
                    q2(intent);
                    return;
                } else {
                    finish();
                    return;
                }
            }
            if (i10 == 999) {
                boolean a10 = C0792c.a(this, i10, i11, intent);
                this.f13628V = a10;
                if (a10) {
                    h2();
                    d2();
                }
            }
        }
    }

    @Override // androidx.fragment.app.FragmentActivity
    public void onAttachFragment(Fragment fragment) {
        if (fragment instanceof AbstractViewOnFocusChangeListenerC1314j) {
            this.f13624R = (AbstractViewOnFocusChangeListenerC1314j) fragment;
            s2();
        }
    }

    @Override // com.customize.contacts.activities.SearchAnimatorsActivity, com.android.contacts.framework.baseui.activity.BasicActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (isFinishing()) {
            return;
        }
        this.f13628V = w.w(this);
        if (bundle != null) {
            this.f13626T = bundle.getInt("actionCode");
        }
        C1319o a10 = this.f13625S.a(getIntent());
        this.f13627U = a10;
        if (!a10.f()) {
            setResult(0);
            finish();
            return;
        }
        COUIStatusBarResponseUtil cOUIStatusBarResponseUtil = new COUIStatusBarResponseUtil(this);
        this.f13630X = cOUIStatusBarResponseUtil;
        cOUIStatusBarResponseUtil.setStatusBarClickListener(this);
        if (this.f13627U.a() == 150) {
            if (bundle == null) {
                w2();
                return;
            }
            return;
        }
        setContentView(R.layout.contact_picker);
        this.f20572y = (AppBarLayout) findViewById(R.id.appbar);
        COUIToolbar cOUIToolbar = (COUIToolbar) findViewById(R.id.toolbar);
        this.f20571x = cOUIToolbar;
        setSupportActionBar(cOUIToolbar);
        this.f20571x.setNavigationIcon(R.drawable.coui_back_arrow);
        this.f20571x.setNavigationContentDescription(R.string.abc_action_bar_up_description);
        this.f20571x.setNavigationOnClickListener(new View.OnClickListener() { // from class: p0.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ContactSelectionActivity.this.l2(view);
            }
        });
        if (this.f13626T != this.f13627U.a()) {
            this.f13626T = this.f13627U.a();
        }
        g2();
        p2();
        if (this.f13628V) {
            h2();
            d2();
        }
        getOnBackPressedDispatcher().h(new a(true));
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.contact_selection_menu, menu);
        return true;
    }

    @Override // com.android.contacts.framework.baseui.activity.BasicActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.f13623Q != null) {
            X.a.b(this).e(this.f13623Q);
        }
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == R.id.add) {
            v2();
        }
        return super.onOptionsItemSelected(menuItem);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        i0.b();
        this.f13630X.onPause();
    }

    @Override // android.app.Activity
    public boolean onPrepareOptionsMenu(Menu menu) {
        boolean z10;
        MenuItem findItem = menu.findItem(R.id.add);
        findItem.setIcon(R.drawable.pb_dr_menu_add);
        findItem.setContentDescription(getResources().getString(R.string.description_add_contact));
        if (t2() && !k2()) {
            z10 = true;
        } else {
            z10 = false;
        }
        findItem.setVisible(z10);
        return super.onPrepareOptionsMenu(menu);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onRequestPermissionsResult(int i10, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i10, strArr, iArr);
        boolean f10 = C0792c.f(this, i10, strArr, iArr);
        this.f13628V = f10;
        if (f10) {
            h2();
            d2();
        }
    }

    @Override // com.android.contacts.framework.baseui.activity.BasicActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.f13630X.onResume();
    }

    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putInt("actionCode", this.f13626T);
    }

    @Override // com.coui.appcompat.statusbar.COUIStatusBarResponseUtil.StatusBarClickListener
    public void onStatusBarClicked() {
        AbstractViewOnFocusChangeListenerC1314j<?> abstractViewOnFocusChangeListenerC1314j = this.f13624R;
        if (abstractViewOnFocusChangeListenerC1314j != null) {
            i0.d(this, abstractViewOnFocusChangeListenerC1314j.f34950a);
        }
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (!V1() && motionEvent.getAction() == 0) {
            this.f20568p.changeStateWithAnimation(0);
        }
        return true;
    }

    public final void p2() {
        this.f13623Q = new d();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.oplus.contacts.display_settings_changed");
        X.a.b(this).c(this.f13623Q, intentFilter);
    }

    public final void q2(Intent intent) {
        String str;
        ArrayList<? extends Parcelable> arrayList = null;
        try {
            str = C7.e.l(getIntent(), "CONTACTS_RINGTONE");
        } catch (Exception e10) {
            e = e10;
            str = null;
        }
        try {
            arrayList = C7.e.i(intent, "NEW_RET_CONTACTS");
        } catch (Exception e11) {
            e = e11;
            H7.b.c("ContactSelection", "" + e);
            Intent intent2 = new Intent("com.oplus.contacts.proc.SET_RINGTONE_TO_CONTACTS");
            intent2.setPackage(getPackageName());
            intent2.putExtra("CONTACTS_RINGTONE", str);
            intent2.putParcelableArrayListExtra("NEW_RET_CONTACTS", arrayList);
            R7.b.c(this, intent2);
            finish();
            overridePendingTransition(R.anim.zoom_fade_enter, R.anim.coui_push_down_exit_activitydialog);
        }
        Intent intent22 = new Intent("com.oplus.contacts.proc.SET_RINGTONE_TO_CONTACTS");
        intent22.setPackage(getPackageName());
        intent22.putExtra("CONTACTS_RINGTONE", str);
        intent22.putParcelableArrayListExtra("NEW_RET_CONTACTS", arrayList);
        R7.b.c(this, intent22);
        finish();
        overridePendingTransition(R.anim.zoom_fade_enter, R.anim.coui_push_down_exit_activitydialog);
    }

    public final void r2() {
        COUIThemeOverlay.getInstance().applyThemeOverlays(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void s2() {
        AbstractViewOnFocusChangeListenerC1314j<?> abstractViewOnFocusChangeListenerC1314j = this.f13624R;
        Object[] objArr = 0;
        Object[] objArr2 = 0;
        Object[] objArr3 = 0;
        if (abstractViewOnFocusChangeListenerC1314j instanceof com.android.contacts.list.a) {
            ((com.android.contacts.list.a) abstractViewOnFocusChangeListenerC1314j).K2(new c());
            return;
        }
        if (abstractViewOnFocusChangeListenerC1314j instanceof com.android.contacts.list.e) {
            ((com.android.contacts.list.e) abstractViewOnFocusChangeListenerC1314j).G2(new g());
            return;
        }
        if (abstractViewOnFocusChangeListenerC1314j instanceof S) {
            ((S) abstractViewOnFocusChangeListenerC1314j).A2(new h());
            return;
        }
        if (abstractViewOnFocusChangeListenerC1314j instanceof G) {
            ((G) abstractViewOnFocusChangeListenerC1314j).A2(new f());
            return;
        }
        H7.b.c("ContactSelection", "Unsupported list fragment type: " + this.f13624R);
        finish();
    }

    public final boolean t2() {
        int i10 = this.f13626T;
        if (i10 != 80 && (i10 != 70 || this.f13627U.e())) {
            return false;
        }
        return true;
    }

    public void u2(Intent intent) {
        intent.setFlags(33554432);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            intent.putExtras(extras);
        }
        R7.b.c(this, intent);
        finish();
        C0636a.a(this);
    }

    public final void v2() {
        u2(new Intent("android.intent.action.INSERT", ContactsContract.Contacts.CONTENT_URI));
        C0636a.a(this);
    }

    public final void w2() {
        Intent intent = new Intent("com.oplus.contacts.ui.SELECT_CONTACTS_ADD_TO_SPECIAL");
        intent.setComponent(new ComponentName(this, (Class<?>) MultiContactPickActivity.class));
        intent.putExtra("forRingtone", true);
        Q7.b.b(this, intent, 2, 0);
        overridePendingTransition(R.anim.coui_open_slide_enter, R.anim.coui_open_slide_exit);
    }

    @Override // androidx.appcompat.widget.SearchView.l
    public boolean z() {
        return true;
    }
}
