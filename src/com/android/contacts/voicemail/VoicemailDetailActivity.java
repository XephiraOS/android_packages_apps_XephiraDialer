package com.android.contacts.voicemail;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.Cursor;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.CancellationSignal;
import android.os.Handler;
import android.os.Message;
import android.provider.CallLog;
import android.text.TextUtils;
import android.text.format.DateFormat;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewTreeObserver;
import android.widget.ListAdapter;
import androidx.appcompat.app.ActionBar;
import com.android.contacts.ContactsApplication;
import com.android.contacts.activities.CallDetailActivity;
import com.android.contacts.framework.baseui.activity.BasicActivity;
import com.android.contacts.voicemail.a;
import com.coui.appcompat.list.COUIListView;
import com.coui.appcompat.toolbar.COUIToolbar;
import com.customize.contacts.util.C0799j;
import com.google.android.material.appbar.AppBarLayout;
import com.oplus.dialer.R;
import java.lang.ref.WeakReference;
import w0.C1643c;

/* loaded from: classes.dex */
public class VoicemailDetailActivity extends BasicActivity {

    /* renamed from: A, reason: collision with root package name */
    public d f17824A;

    /* renamed from: B, reason: collision with root package name */
    public c f17825B;

    /* renamed from: C, reason: collision with root package name */
    public e f17826C;

    /* renamed from: D, reason: collision with root package name */
    public Handler f17827D = new a();

    /* renamed from: o, reason: collision with root package name */
    public String f17828o;

    /* renamed from: p, reason: collision with root package name */
    public String f17829p;

    /* renamed from: q, reason: collision with root package name */
    public String f17830q;

    /* renamed from: r, reason: collision with root package name */
    public long f17831r;

    /* renamed from: x, reason: collision with root package name */
    public COUIListView f17832x;

    /* renamed from: y, reason: collision with root package name */
    public VoicemailPlaybackPresenter f17833y;

    /* renamed from: z, reason: collision with root package name */
    public com.android.contacts.voicemail.a f17834z;

    /* loaded from: classes.dex */
    public class a extends Handler {
        public a() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (!VoicemailDetailActivity.this.isFinishing() && !VoicemailDetailActivity.this.isDestroyed()) {
                VoicemailDetailActivity.this.y1();
                VoicemailDetailActivity.this.f17834z.notifyDataSetChanged();
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements ViewTreeObserver.OnPreDrawListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AppBarLayout f17836a;

        public b(AppBarLayout appBarLayout) {
            this.f17836a = appBarLayout;
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            this.f17836a.getViewTreeObserver().removeOnPreDrawListener(this);
            VoicemailDetailActivity.this.f17832x.setPadding(VoicemailDetailActivity.this.f17832x.getPaddingStart(), this.f17836a.getMeasuredHeight() + VoicemailDetailActivity.this.f17832x.getPaddingTop(), VoicemailDetailActivity.this.f17832x.getPaddingEnd(), VoicemailDetailActivity.this.f17832x.getPaddingBottom());
            return false;
        }
    }

    /* loaded from: classes.dex */
    public static class c extends AsyncTask<Void, Void, Long> {

        /* renamed from: a, reason: collision with root package name */
        public WeakReference<VoicemailDetailActivity> f17838a;

        /* renamed from: b, reason: collision with root package name */
        public CancellationSignal f17839b = new CancellationSignal();

        public c(VoicemailDetailActivity voicemailDetailActivity) {
            this.f17838a = new WeakReference<>(voicemailDetailActivity);
        }

        public final void b() {
            this.f17839b.cancel();
            cancel(true);
        }

        @Override // android.os.AsyncTask
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public Long doInBackground(Void... voidArr) {
            VoicemailDetailActivity voicemailDetailActivity = this.f17838a.get();
            if (voicemailDetailActivity == null) {
                return null;
            }
            return Long.valueOf(d(voicemailDetailActivity, voicemailDetailActivity.f17828o));
        }

        public final long d(VoicemailDetailActivity voicemailDetailActivity, String str) {
            long e10 = e(voicemailDetailActivity, str, voicemailDetailActivity.f17831r);
            if (-1 == e10 && -1 != voicemailDetailActivity.f17831r) {
                voicemailDetailActivity.f17831r = -1L;
                return e(voicemailDetailActivity, str, voicemailDetailActivity.f17831r);
            }
            return e10;
        }

        /* JADX WARN: Code restructure failed: missing block: B:18:0x0065, code lost:
        
            return r1;
         */
        /* JADX WARN: Code restructure failed: missing block: B:25:0x0062, code lost:
        
            if (r12 == null) goto L24;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final long e(com.android.contacts.voicemail.VoicemailDetailActivity r11, java.lang.String r12, long r13) {
            /*
                r10 = this;
                boolean r0 = android.text.TextUtils.isEmpty(r12)
                r1 = -1
                if (r0 == 0) goto L9
                return r1
            L9:
                android.net.Uri r12 = R0.d.c(r12)
                int r0 = (r13 > r1 ? 1 : (r13 == r1 ? 0 : -1))
                if (r0 == 0) goto L19
                java.lang.String r13 = java.lang.String.valueOf(r13)
                android.net.Uri r12 = android.net.Uri.withAppendedPath(r12, r13)
            L19:
                r4 = r12
                r12 = 0
                android.content.ContentResolver r3 = r11.getContentResolver()     // Catch: java.lang.Throwable -> L42 java.lang.Exception -> L44
                java.lang.String[] r5 = com.android.contacts.calllog.J.a()     // Catch: java.lang.Throwable -> L42 java.lang.Exception -> L44
                android.os.CancellationSignal r9 = r10.f17839b     // Catch: java.lang.Throwable -> L42 java.lang.Exception -> L44
                r6 = 0
                r7 = 0
                r8 = 0
                android.database.Cursor r12 = r3.query(r4, r5, r6, r7, r8, r9)     // Catch: java.lang.Throwable -> L42 java.lang.Exception -> L44
                if (r12 == 0) goto L46
                boolean r10 = r12.moveToFirst()     // Catch: java.lang.Throwable -> L42 java.lang.Exception -> L44
                if (r10 == 0) goto L46
                r10 = 0
                long r1 = r12.getLong(r10)     // Catch: java.lang.Throwable -> L42 java.lang.Exception -> L44
                r10 = 1
                java.lang.String r10 = r12.getString(r10)     // Catch: java.lang.Throwable -> L42 java.lang.Exception -> L44
                com.android.contacts.voicemail.VoicemailDetailActivity.v1(r11, r10)     // Catch: java.lang.Throwable -> L42 java.lang.Exception -> L44
                goto L46
            L42:
                r10 = move-exception
                goto L66
            L44:
                r10 = move-exception
                goto L4c
            L46:
                if (r12 == 0) goto L65
            L48:
                r12.close()
                goto L65
            L4c:
                java.lang.String r11 = "VoicemailDetailActivity"
                java.lang.StringBuilder r13 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L42
                r13.<init>()     // Catch: java.lang.Throwable -> L42
                java.lang.String r14 = "getContactIdByNumber error "
                r13.append(r14)     // Catch: java.lang.Throwable -> L42
                r13.append(r10)     // Catch: java.lang.Throwable -> L42
                java.lang.String r10 = r13.toString()     // Catch: java.lang.Throwable -> L42
                H7.b.c(r11, r10)     // Catch: java.lang.Throwable -> L42
                if (r12 == 0) goto L65
                goto L48
            L65:
                return r1
            L66:
                if (r12 == 0) goto L6b
                r12.close()
            L6b:
                throw r10
            */
            throw new UnsupportedOperationException("Method not decompiled: com.android.contacts.voicemail.VoicemailDetailActivity.c.e(com.android.contacts.voicemail.VoicemailDetailActivity, java.lang.String, long):long");
        }

        @Override // android.os.AsyncTask
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(Long l10) {
            VoicemailDetailActivity voicemailDetailActivity = this.f17838a.get();
            if (voicemailDetailActivity != null) {
                voicemailDetailActivity.f17831r = l10.longValue();
                voicemailDetailActivity.B1();
            }
        }
    }

    /* loaded from: classes.dex */
    public static class d extends AsyncTask<Void, Void, Cursor> {

        /* renamed from: a, reason: collision with root package name */
        public WeakReference<VoicemailDetailActivity> f17840a;

        /* renamed from: b, reason: collision with root package name */
        public CancellationSignal f17841b = new CancellationSignal();

        public d(VoicemailDetailActivity voicemailDetailActivity) {
            this.f17840a = new WeakReference<>(voicemailDetailActivity);
        }

        public final void b() {
            this.f17841b.cancel();
            cancel(true);
        }

        @Override // android.os.AsyncTask
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public Cursor doInBackground(Void... voidArr) {
            VoicemailDetailActivity voicemailDetailActivity = this.f17840a.get();
            if (voicemailDetailActivity == null) {
                return null;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("(matched_number =?1 OR number=?1) AND type =?2");
            if (C1643c.q()) {
                sb.append(C1643c.m(ContactsApplication.h()));
            }
            try {
                return voicemailDetailActivity.getContentResolver().query(CallLog.Calls.CONTENT_URI_WITH_VOICEMAIL, a.InterfaceC0175a.f17936a, sb.toString(), new String[]{voicemailDetailActivity.f17828o, String.valueOf(4)}, "date DESC ", this.f17841b);
            } catch (Exception e10) {
                H7.b.c("VoicemailDetailActivity", "exception in VoicemailDetailActivity " + e10);
                return null;
            }
        }

        @Override // android.os.AsyncTask
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(Cursor cursor) {
            VoicemailDetailActivity voicemailDetailActivity = this.f17840a.get();
            if (voicemailDetailActivity != null) {
                voicemailDetailActivity.f17834z.changeCursor(cursor);
            }
        }
    }

    /* loaded from: classes.dex */
    public class e extends BroadcastReceiver {
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if ("android.intent.action.SIM_STATE_CHANGED".equals(intent.getAction())) {
                VoicemailDetailActivity.this.f17827D.sendEmptyMessageDelayed(1, 1000L);
            }
        }

        public e() {
        }
    }

    public final void A1() {
        if (this.f17826C == null) {
            this.f17826C = new e();
        }
        registerReceiver(this.f17826C, new IntentFilter("android.intent.action.SIM_STATE_CHANGED"), 2);
    }

    public final void B1() {
        String str;
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.v(4, 4);
            supportActionBar.t(true);
            if (TextUtils.isEmpty(this.f17830q)) {
                if (TextUtils.isEmpty(this.f17829p)) {
                    str = this.f17828o;
                } else {
                    str = this.f17829p;
                }
            } else {
                str = this.f17830q;
            }
            supportActionBar.A(str);
        }
    }

    @Override // com.android.contacts.framework.baseui.activity.BasicActivity
    public boolean H0() {
        return true;
    }

    @Override // com.android.contacts.framework.baseui.activity.BasicActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_voicemail_detail);
        z1(getIntent());
        AppBarLayout appBarLayout = (AppBarLayout) findViewById(R.id.appbar);
        COUIListView cOUIListView = (COUIListView) findViewById(R.id.list);
        this.f17832x = cOUIListView;
        cOUIListView.setNestedScrollingEnabled(true);
        com.android.contacts.voicemail.a aVar = new com.android.contacts.voicemail.a(this, null);
        this.f17834z = aVar;
        this.f17832x.setAdapter((ListAdapter) aVar);
        setSupportActionBar((COUIToolbar) findViewById(R.id.toolbar));
        appBarLayout.getViewTreeObserver().addOnPreDrawListener(new b(appBarLayout));
        B1();
        VoicemailPlaybackPresenter h10 = VoicemailPlaybackPresenter.h(this, bundle);
        this.f17833y = h10;
        this.f17834z.c(h10);
        A1();
        y1();
        d dVar = this.f17824A;
        if (dVar != null) {
            dVar.b();
            this.f17824A = null;
        }
        d dVar2 = new d(this);
        this.f17824A = dVar2;
        dVar2.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.voicemail_detail_menu, menu);
        return true;
    }

    @Override // com.android.contacts.framework.baseui.activity.BasicActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        d dVar = this.f17824A;
        if (dVar != null) {
            dVar.b();
            this.f17824A = null;
        }
        c cVar = this.f17825B;
        if (cVar != null) {
            cVar.b();
            this.f17825B = null;
        }
        e eVar = this.f17826C;
        if (eVar != null) {
            unregisterReceiver(eVar);
        }
        this.f17833y.p();
        super.onDestroy();
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == 16908332) {
            finish();
            return true;
        }
        if (menuItem.getItemId() == R.id.detail_btn) {
            long j10 = this.f17831r;
            if (j10 >= 0) {
                com.android.contacts.dialpad.a.b(this, j10, this.f17828o, null);
            } else {
                Intent intent = new Intent(this, (Class<?>) CallDetailActivity.class);
                intent.putExtra("number", this.f17828o);
                intent.putExtra("matched_number", this.f17828o);
                intent.putExtra("contact_uri", (String) null);
                intent.putExtra("contact_id", this.f17831r);
                intent.putExtra("name", this.f17830q);
                intent.putExtra("IsFromCalllogSearch", true);
                R7.b.c(this, intent);
            }
            return true;
        }
        return super.onOptionsItemSelected(menuItem);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        this.f17833y.q();
        super.onPause();
    }

    @Override // com.android.contacts.framework.baseui.activity.BasicActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        this.f17833y.r();
        super.onResume();
    }

    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        this.f17833y.s(bundle);
        super.onSaveInstanceState(bundle);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        C0799j.c(F7.b.e(this));
        C0799j.d(DateFormat.getTimeFormat(this));
        c cVar = this.f17825B;
        if (cVar != null) {
            cVar.b();
            this.f17825B = null;
        }
        c cVar2 = new c(this);
        this.f17825B = cVar2;
        cVar2.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
    }

    public final void y1() {
        this.f17834z.b();
    }

    public final void z1(Intent intent) {
        if (intent == null) {
            finish();
            return;
        }
        this.f17828o = C7.e.l(intent, "extra_number");
        this.f17829p = C7.e.l(intent, "extra_format_number");
        this.f17830q = C7.e.l(intent, "extra_name");
        this.f17831r = C7.e.f(intent, "extra_contact_id", -1L);
        if (TextUtils.isEmpty(this.f17828o)) {
            finish();
        }
        if (H7.a.b()) {
            H7.b.b("VoicemailDetailActivity", "VoicemailDetailActivity mNumber " + H7.a.d(this.f17828o) + " mContactId " + this.f17831r);
        }
    }
}
