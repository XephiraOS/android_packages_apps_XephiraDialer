package com.oplus.blacklistapp.activities;

import S8.o;
import android.R;
import android.app.Dialog;
import android.content.AsyncQueryHandler;
import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.database.ContentObserver;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.text.InputFilter;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.animation.Animation;
import android.view.inputmethod.InputMethodManager;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.CheckBox;
import android.widget.ListAdapter;
import android.widget.ResourceCursorAdapter;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import com.android.contacts.business.calllog.breenocall.BreenoCallContract;
import com.coui.appcompat.cardlist.COUICardListHelper;
import com.coui.appcompat.cardlist.COUICardListSelectedItemLayout;
import com.coui.appcompat.dialog.COUIAlertDialogBuilder;
import com.coui.appcompat.edittext.COUIEditText;
import com.coui.appcompat.list.COUIListView;
import com.coui.appcompat.statusbar.COUIStatusBarResponseUtil;
import com.coui.appcompat.toolbar.COUIToolbar;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.oplus.blacklist.database.a;
import com.oplus.blacklistapp.BlackListAppUtil;
import com.oplus.blacklistapp.activities.KeyWordListActivity;
import com.oplus.blacklistapp.callintercept.CallInterceptController;
import com.oplus.blacklistapp.p;
import com.oplus.blacklistapp.r;
import com.oplus.blacklistapp.s;
import com.oplus.blacklistapp.t;
import com.oplus.blacklistapp.u;
import com.oplus.utils.AnimationAnimationListenerC0842c;
import com.oplus.utils.B;
import com.oplus.utils.C0846g;
import com.oplus.utils.C0861w;
import com.oplus.utils.C0863y;
import com.oplus.utils.InterfaceC0859u;
import com.oplus.utils.L;
import com.oplus.utils.StatisticsUtils;
import com.oplus.utils.T;
import com.oplus.utils.Z;
import com.oplus.widget.EditModeHandler;
import com.oplus.widget.MultiChoiceListview;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

/* loaded from: classes3.dex */
public class KeyWordListActivity extends BaseNavigationActivity implements o, COUIListView.ScrollMultiChoiceListener, CallInterceptController.b {

    /* renamed from: T, reason: collision with root package name */
    public static boolean f26330T = false;

    /* renamed from: A, reason: collision with root package name */
    public COUIToolbar f26331A;

    /* renamed from: B, reason: collision with root package name */
    public MenuItem f26332B;

    /* renamed from: C, reason: collision with root package name */
    public EditModeHandler f26333C;

    /* renamed from: D, reason: collision with root package name */
    public B f26334D;

    /* renamed from: E, reason: collision with root package name */
    public AppBarLayout f26335E;

    /* renamed from: H, reason: collision with root package name */
    public COUIStatusBarResponseUtil f26338H;

    /* renamed from: I, reason: collision with root package name */
    public MenuItem f26339I;

    /* renamed from: J, reason: collision with root package name */
    public MenuItem f26340J;

    /* renamed from: K, reason: collision with root package name */
    public String[] f26341K;

    /* renamed from: L, reason: collision with root package name */
    public S8.h f26342L;

    /* renamed from: M, reason: collision with root package name */
    public androidx.appcompat.app.b f26343M;

    /* renamed from: N, reason: collision with root package name */
    public int f26344N;

    /* renamed from: O, reason: collision with root package name */
    public androidx.appcompat.app.b f26345O;

    /* renamed from: Q, reason: collision with root package name */
    public COUIAlertDialogBuilder f26347Q;

    /* renamed from: R, reason: collision with root package name */
    public boolean f26348R;

    /* renamed from: p, reason: collision with root package name */
    public MultiChoiceListview f26353p;

    /* renamed from: q, reason: collision with root package name */
    public k f26354q;

    /* renamed from: y, reason: collision with root package name */
    public l f26357y;

    /* renamed from: m, reason: collision with root package name */
    public boolean f26350m = false;

    /* renamed from: n, reason: collision with root package name */
    public m f26351n = null;

    /* renamed from: o, reason: collision with root package name */
    public int f26352o = 0;

    /* renamed from: r, reason: collision with root package name */
    public boolean f26355r = false;

    /* renamed from: x, reason: collision with root package name */
    public String f26356x = null;

    /* renamed from: z, reason: collision with root package name */
    public String f26358z = null;

    /* renamed from: F, reason: collision with root package name */
    public Set<Long> f26336F = G6.b.a();

    /* renamed from: G, reason: collision with root package name */
    public Set<Long> f26337G = G6.b.a();

    /* renamed from: P, reason: collision with root package name */
    public ContentObserver f26346P = null;

    /* renamed from: S, reason: collision with root package name */
    public InterfaceC0859u f26349S = new j();

    /* loaded from: classes3.dex */
    public class a implements BottomNavigationView.c {
        public a() {
        }

        @Override // com.google.android.material.navigation.NavigationBarView.c
        public boolean onNavigationItemSelected(MenuItem menuItem) {
            KeyWordListActivity.this.showDialog(1);
            if (KeyWordListActivity.this.f26347Q != null) {
                KeyWordListActivity.this.f26347Q.updateViewAfterShown();
                return false;
            }
            return false;
        }
    }

    /* loaded from: classes3.dex */
    public class d implements ViewTreeObserver.OnGlobalLayoutListener {
        public d() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            KeyWordListActivity.this.f26335E.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            int measuredHeight = KeyWordListActivity.this.f26335E.getMeasuredHeight();
            KeyWordListActivity.this.f26353p.setClipToPadding(false);
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) KeyWordListActivity.this.f26353p.getLayoutParams();
            marginLayoutParams.topMargin = measuredHeight + KeyWordListActivity.this.getResources().getDimensionPixelSize(com.oplus.blacklistapp.n.f27290o);
            KeyWordListActivity.this.f26353p.setLayoutParams(marginLayoutParams);
        }
    }

    /* loaded from: classes3.dex */
    public class e extends ContentObserver {
        public e(Handler handler) {
            super(handler);
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean z10, Uri uri) {
            super.onChange(z10, uri);
            KeyWordListActivity.this.f26357y.c();
        }
    }

    /* loaded from: classes3.dex */
    public class f implements S8.i {
        public f() {
        }

        @Override // S8.i
        public void g() {
            KeyWordListActivity keyWordListActivity = KeyWordListActivity.this;
            keyWordListActivity.f26356x = keyWordListActivity.f26342L.h().getText().toString().trim();
            KeyWordListActivity.this.f26357y.b(KeyWordListActivity.this.f26356x);
            KeyWordListActivity.this.f26342L.g();
        }

        @Override // S8.i
        public void onCancel() {
            KeyWordListActivity.this.f26342L.g();
        }
    }

    /* loaded from: classes3.dex */
    public class g implements InputFilter {
        public g() {
        }

        @Override // android.text.InputFilter
        public CharSequence filter(CharSequence charSequence, int i10, int i11, Spanned spanned, int i12, int i13) {
            String trim = charSequence.toString().trim();
            if (charSequence instanceof Spanned) {
                int length = trim.length();
                SpannableString spannableString = new SpannableString(trim);
                if (i11 <= length) {
                    TextUtils.copySpansFrom((Spanned) charSequence, i10, i11, null, spannableString, 0);
                } else {
                    TextUtils.copySpansFrom((Spanned) charSequence, i10, length, null, spannableString, 0);
                }
                return spannableString;
            }
            return trim;
        }
    }

    /* loaded from: classes3.dex */
    public class h implements Toolbar.g {
        public h() {
        }

        @Override // androidx.appcompat.widget.Toolbar.g
        public boolean onMenuItemClick(MenuItem menuItem) {
            int itemId = menuItem.getItemId();
            if (itemId == p.f27330D) {
                if (!BlackListAppUtil.c().a()) {
                    KeyWordListActivity.this.I1();
                    return true;
                }
                Log.i("KeyWordListActivity", "Invalid click return --------------");
                return false;
            }
            if (itemId == p.f27400m) {
                KeyWordListActivity.this.N1();
                return true;
            }
            if (itemId == p.f27380c) {
                KeyWordListActivity.this.G1(null);
                return true;
            }
            if (itemId == p.f27327B0) {
                KeyWordListActivity.this.f26333C.f();
                return true;
            }
            return true;
        }
    }

    /* loaded from: classes3.dex */
    public class i implements View.OnClickListener {
        public i() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            KeyWordListActivity.this.finish();
        }
    }

    /* loaded from: classes3.dex */
    public class j implements InterfaceC0859u {

        /* loaded from: classes3.dex */
        public class a implements View.OnClickListener {
            public a() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                KeyWordListActivity.this.finish();
            }
        }

        public j() {
        }

        @Override // com.oplus.utils.InterfaceC0859u
        public void a(boolean z10) {
            KeyWordListActivity.this.f26331A.getMenu().clear();
            if (z10) {
                KeyWordListActivity.this.f26331A.setNavigationIcon(X8.g.f4850c);
                KeyWordListActivity.this.f26331A.setNavigationContentDescription(e.h.f30261a);
                KeyWordListActivity.this.f26331A.setIsTitleCenterStyle(false);
                KeyWordListActivity.this.f26331A.setNavigationOnClickListener(new a());
                KeyWordListActivity.this.f26331A.inflateMenu(s.f27478g);
                KeyWordListActivity keyWordListActivity = KeyWordListActivity.this;
                keyWordListActivity.f26339I = keyWordListActivity.f26331A.getMenu().findItem(p.f27330D);
                e();
                return;
            }
            KeyWordListActivity.this.getMenuInflater().inflate(s.f27475d, KeyWordListActivity.this.f26331A.getMenu());
            KeyWordListActivity.this.f26331A.setIsTitleCenterStyle(true);
            KeyWordListActivity.this.f26331A.setNavigationIcon((Drawable) null);
            KeyWordListActivity keyWordListActivity2 = KeyWordListActivity.this;
            keyWordListActivity2.f26340J = keyWordListActivity2.f26331A.getMenu().findItem(p.f27327B0);
            d();
        }

        @Override // com.oplus.utils.InterfaceC0859u
        public void b() {
            a(false);
            KeyWordListActivity.this.f26354q.g(true);
            KeyWordListActivity.this.f26354q.notifyDataSetChanged();
            KeyWordListActivity.this.f26333C.h(KeyWordListActivity.this.f26336F);
            KeyWordListActivity.this.f26333C.l(KeyWordListActivity.this.f26337G);
            d();
        }

        @Override // com.oplus.utils.InterfaceC0859u
        public void c() {
            a(true);
            KeyWordListActivity.this.f26339I.setVisible(true);
            KeyWordListActivity.this.f26354q.g(false);
            KeyWordListActivity.this.f26354q.notifyDataSetChanged();
            KeyWordListActivity.this.Q1();
            KeyWordListActivity.this.f26337G.clear();
            KeyWordListActivity.this.f26333C.l(KeyWordListActivity.this.f26337G);
        }

        @Override // com.oplus.utils.InterfaceC0859u
        public void d() {
            if (KeyWordListActivity.this.f26331A != null) {
                KeyWordListActivity.this.f26331A.setTitle(KeyWordListActivity.this.f26333C.b());
            }
            g();
        }

        @Override // com.oplus.utils.InterfaceC0859u
        public void e() {
            if (KeyWordListActivity.this.f26331A != null) {
                KeyWordListActivity.this.f26331A.setTitle(u.f27512F0);
            }
        }

        @Override // com.oplus.utils.InterfaceC0859u
        public void f(boolean z10) {
            if (KeyWordListActivity.this.f26339I != null) {
                KeyWordListActivity.this.f26339I.setVisible(z10);
            }
        }

        public void g() {
            int c10 = KeyWordListActivity.this.f26333C.c();
            int count = KeyWordListActivity.this.f26354q.getCount();
            if (KeyWordListActivity.this.f26340J != null) {
                if (c10 < count) {
                    KeyWordListActivity.this.f26340J.setTitle(u.f27562R2);
                } else {
                    KeyWordListActivity.this.f26340J.setTitle(u.f27644j3);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public static final class l extends AsyncQueryHandler {

        /* renamed from: a, reason: collision with root package name */
        public WeakReference<KeyWordListActivity> f26381a;

        public l(KeyWordListActivity keyWordListActivity) {
            super(keyWordListActivity.getContentResolver());
            this.f26381a = new WeakReference<>(keyWordListActivity);
        }

        public final void a(Context context, String str, int i10) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("keyword", str);
            contentValues.put("slot_id", Integer.valueOf(i10));
            startInsert(1, null, a.d.f26237a, contentValues);
            HashMap hashMap = new HashMap();
            hashMap.put("keyword", str);
            StatisticsUtils.a(context, 2010802, 201080006, hashMap, false);
        }

        public void b(String str) {
            KeyWordListActivity keyWordListActivity = this.f26381a.get();
            if (keyWordListActivity == null) {
                return;
            }
            if (!TextUtils.isEmpty(keyWordListActivity.f26358z)) {
                a(keyWordListActivity, str, -1);
            } else {
                a(keyWordListActivity, str, keyWordListActivity.f26352o);
            }
            KeyWordListActivity.f26330T = true;
        }

        public void c() {
            KeyWordListActivity keyWordListActivity = this.f26381a.get();
            if (keyWordListActivity == null) {
                return;
            }
            String str = "slot_id ='" + keyWordListActivity.f26352o + "' OR slot_id ='-1'";
            cancelOperation(1);
            startQuery(1, null, a.d.f26237a, new String[]{BreenoCallContract.BaseColumns._ID, "keyword"}, str, null, "_id DESC");
        }

        @Override // android.content.AsyncQueryHandler
        public void onInsertComplete(int i10, Object obj, Uri uri) {
            c();
        }

        @Override // android.content.AsyncQueryHandler
        public void onQueryComplete(int i10, Object obj, Cursor cursor) {
            KeyWordListActivity keyWordListActivity = this.f26381a.get();
            if (keyWordListActivity == null) {
                return;
            }
            try {
                keyWordListActivity.f26354q.changeCursor(cursor);
                keyWordListActivity.f26354q.notifyDataSetChanged();
                keyWordListActivity.invalidateOptionsMenu();
                if (cursor != null && !cursor.isClosed()) {
                    int count = cursor.getCount();
                    boolean z10 = false;
                    if (count <= 0) {
                        keyWordListActivity.f26353p.setVisibility(8);
                        keyWordListActivity.f26264j.setVisibility(0);
                    } else {
                        keyWordListActivity.f26353p.setVisibility(0);
                        keyWordListActivity.f26264j.setVisibility(8);
                    }
                    InterfaceC0859u interfaceC0859u = keyWordListActivity.f26349S;
                    if (count > 0) {
                        z10 = true;
                    }
                    interfaceC0859u.f(z10);
                    keyWordListActivity.K1(cursor);
                }
            } catch (Exception e10) {
                Log.e("KeyWordListActivity", "e = " + e10);
                if (cursor != null) {
                    cursor.close();
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class m extends AsyncTask<Void, Void, Void> {
        @Override // android.os.AsyncTask
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Void doInBackground(Void... voidArr) {
            StringBuilder sb = new StringBuilder();
            Iterator it = KeyWordListActivity.this.f26337G.iterator();
            while (it.hasNext()) {
                long longValue = ((Long) it.next()).longValue();
                sb.append(",");
                sb.append(longValue);
            }
            try {
                if (sb.length() > 0) {
                    String substring = sb.substring(1);
                    KeyWordListActivity.this.getContentResolver().delete(a.d.f26237a, "_id IN (" + substring + ")", null);
                }
            } catch (Exception e10) {
                Log.e("KeyWordListActivity", "delete keywords failed" + e10);
            }
            return null;
        }

        @Override // android.os.AsyncTask
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(Void r22) {
            KeyWordListActivity.this.H1();
            KeyWordListActivity keyWordListActivity = KeyWordListActivity.this;
            keyWordListActivity.f26351n = null;
            keyWordListActivity.N1();
            C0861w.g(KeyWordListActivity.this.getApplicationContext()).l();
        }

        @Override // android.os.AsyncTask
        public void onPreExecute() {
            KeyWordListActivity.this.P1();
        }

        public m() {
        }
    }

    /* loaded from: classes3.dex */
    public class n implements DialogInterface.OnClickListener, DialogInterface.OnDismissListener {

        /* renamed from: a, reason: collision with root package name */
        public final int f26383a;

        public n(int i10) {
            this.f26383a = i10;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i10) {
            if (i10 == -3) {
                KeyWordListActivity keyWordListActivity = KeyWordListActivity.this;
                if (keyWordListActivity.f26351n == null) {
                    keyWordListActivity.f26351n = new m();
                    KeyWordListActivity.this.f26351n.execute(new Void[0]);
                }
            }
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            KeyWordListActivity.this.removeDialog(this.f26383a);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void I1() {
        boolean z10 = true;
        b1(true);
        EditModeHandler editModeHandler = this.f26333C;
        if (editModeHandler != null) {
            editModeHandler.a();
        }
        R0(true, this.f26353p);
        MenuItem menuItem = this.f26332B;
        if (menuItem != null) {
            if (this.f26337G.size() <= 0) {
                z10 = false;
            }
            menuItem.setEnabled(z10);
        }
        f26330T = false;
        s0(n0());
    }

    private void L1() {
        this.f26331A.setOnMenuItemClickListener(new h());
        this.f26331A.setNavigationOnClickListener(new i());
        this.f26349S.a(true);
    }

    public static /* synthetic */ boolean M1(TextView textView, int i10, KeyEvent keyEvent) {
        if (i10 != 6) {
            return false;
        }
        InputMethodManager inputMethodManager = (InputMethodManager) textView.getContext().getSystemService("input_method");
        if (inputMethodManager.isActive()) {
            inputMethodManager.hideSoftInputFromWindow(textView.getApplicationWindowToken(), 0);
            return true;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void N1() {
        boolean z10;
        if (!this.f26333C.d()) {
            return;
        }
        b1(false);
        this.f26333C.e();
        R0(false, this.f26353p);
        MenuItem menuItem = this.f26332B;
        if (menuItem != null) {
            if (this.f26337G.size() > 0) {
                z10 = true;
            } else {
                z10 = false;
            }
            menuItem.setEnabled(z10);
        }
        s0(n0());
        this.f26348R = false;
    }

    public void G1(String str) {
        androidx.appcompat.app.b m10 = this.f26342L.m(this, r.f27456k, new f(), getString(u.f27600b), null, getString(u.f27716y0), getString(u.f27550O2));
        this.f26345O = m10;
        this.f26342L.i(m10, true, getString(u.f27657m1));
        this.f26342L.h().setMaxLines(100);
        this.f26342L.h().setInputType(1);
        O1();
        if (!TextUtils.isEmpty(str)) {
            this.f26342L.h().setText(str);
        }
        this.f26342L.h().setFilters(new InputFilter[]{new g(), new InputFilter.LengthFilter(100)});
    }

    public final void H1() {
        androidx.appcompat.app.b bVar = this.f26343M;
        if (bVar != null && bVar.isShowing()) {
            this.f26343M.dismiss();
        }
        this.f26343M = null;
    }

    public final Dialog J1(int i10) {
        int size = this.f26337G.size();
        if (this.f26354q.getCount() == 0) {
            return null;
        }
        String format = String.format(getResources().getQuantityString(t.f27489k, size), Integer.valueOf(size));
        n nVar = new n(i10);
        COUIAlertDialogBuilder neutralButton = new S8.b(this, X8.n.f5032d).setTitle((CharSequence) format).setNegativeButton(R.string.cancel, (DialogInterface.OnClickListener) nVar).setNeutralButton(u.f27502C2, (DialogInterface.OnClickListener) nVar);
        this.f26347Q = neutralButton;
        androidx.appcompat.app.b create = neutralButton.create();
        create.setOnDismissListener(nVar);
        return create;
    }

    public final void K1(Cursor cursor) {
        try {
            this.f26336F.clear();
            cursor.moveToPosition(-1);
            while (cursor.moveToNext()) {
                this.f26336F.add(Long.valueOf(cursor.getInt(0)));
            }
        } catch (Exception unused) {
        }
    }

    @Override // com.oplus.blacklistapp.activities.BaseNavigationActivity
    public void O0() {
        boolean z10;
        super.O0();
        this.f26263i.inflateMenu(s.f27474c);
        MenuItem findItem = this.f26263i.getMenu().findItem(p.f27422x);
        this.f26332B = findItem;
        if (findItem != null) {
            findItem.setTitle(u.f27502C2);
            MenuItem menuItem = this.f26332B;
            if (this.f26337G.size() > 0) {
                z10 = true;
            } else {
                z10 = false;
            }
            menuItem.setEnabled(z10);
        }
        this.f26263i.setOnNavigationItemSelectedListener(new a());
    }

    public final void O1() {
        COUIEditText h10;
        S8.h hVar = this.f26342L;
        if (hVar != null && (h10 = hVar.h()) != null) {
            h10.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: p6.k
                @Override // android.widget.TextView.OnEditorActionListener
                public final boolean onEditorAction(TextView textView, int i10, KeyEvent keyEvent) {
                    boolean M12;
                    M12 = KeyWordListActivity.M1(textView, i10, keyEvent);
                    return M12;
                }
            });
        }
    }

    public final void P1() {
        H1();
        this.f26343M = com.oplus.utils.r.b(this, getString(u.f27584X0));
    }

    public void Q1() {
        this.f26357y.c();
    }

    public final void R1(Configuration configuration) {
        androidx.appcompat.app.b bVar;
        COUIEditText cOUIEditText;
        int i10 = configuration.orientation;
        if (this.f26344N != i10 && (bVar = this.f26345O) != null && bVar.isShowing() && (cOUIEditText = (COUIEditText) this.f26345O.findViewById(p.f27397k0)) != null) {
            ViewGroup viewGroup = (ViewGroup) cOUIEditText.getParent();
            viewGroup.removeView(cOUIEditText);
            viewGroup.addView(cOUIEditText);
        }
        this.f26344N = i10;
    }

    @Override // com.oplus.blacklistapp.framework.baseui.BasicActivity
    public boolean n0() {
        EditModeHandler editModeHandler = this.f26333C;
        if (editModeHandler != null) {
            return editModeHandler.d();
        }
        return false;
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i10, int i11, Intent intent) {
        super.onActivityResult(i10, i11, intent);
        if (i10 == 10 && !isFinishing()) {
            String[] f10 = L.f(this);
            this.f26341K = f10;
            if (f10 != null && f10.length > 0) {
                for (String str : f10) {
                    if (shouldShowRequestPermissionRationale(str)) {
                        requestPermissions(this.f26341K, 1);
                        return;
                    }
                }
                L.p(this, this.f26341K);
                return;
            }
            C0861w.g(getApplicationContext()).k();
        }
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        if (this.f26333C.d()) {
            N1();
        } else {
            super.onBackPressed();
        }
    }

    @Override // com.oplus.blacklistapp.activities.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.activity.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        R1(configuration);
    }

    @Override // com.oplus.blacklistapp.activities.BaseNavigationActivity, com.oplus.blacklistapp.activities.BaseActivity, com.oplus.blacklistapp.framework.baseui.BasicActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        String[] f10 = L.f(this);
        this.f26341K = f10;
        if (f10 != null) {
            requestPermissions(f10, 1);
        } else {
            androidx.appcompat.app.b bVar = L.f29055a;
            if (bVar != null && bVar.isShowing()) {
                L.f29055a.dismiss();
                L.f29055a = null;
            }
        }
        if (this.f26341K == null) {
            C0861w.g(getApplicationContext()).k();
        }
        setContentView(r.f27448c);
        Window window = getWindow();
        if (window != null) {
            window.setBackgroundDrawable(null);
        }
        View findViewById = findViewById(p.f27386f);
        if (findViewById != null) {
            findViewById.setVisibility(8);
        }
        this.f26342L = new S8.h();
        this.f26344N = getResources().getConfiguration().orientation;
        this.f26331A = (COUIToolbar) findViewById(p.f27363T0);
        L1();
        this.f26349S.e();
        this.f26334D = new b();
        MultiChoiceListview multiChoiceListview = (MultiChoiceListview) findViewById(R.id.list);
        this.f26353p = multiChoiceListview;
        multiChoiceListview.setChoiceMode(2);
        this.f26353p.setDivider(null);
        this.f26353p.setBackground(null);
        this.f26353p.setVerticalFadingEdgeEnabled(false);
        this.f26354q = new k(this, this);
        this.f26353p.setOnScrollListener(new c());
        if (this.f26333C == null) {
            this.f26333C = new EditModeHandler(this, this.f26354q, this.f26349S, this.f26334D, EditModeHandler.Mode.KEY_WORD_MODE);
        }
        this.f26353p.setAdapter((ListAdapter) this.f26354q);
        this.f26353p.setScrollMultiChoiceListener(this);
        N0(com.oplus.blacklistapp.o.f27321x, u.f27569T1, null, null);
        AppBarLayout appBarLayout = (AppBarLayout) findViewById(p.f27376a);
        this.f26335E = appBarLayout;
        appBarLayout.getViewTreeObserver().addOnGlobalLayoutListener(new d());
        this.f26353p.setNestedScrollingEnabled(true);
        this.f26357y = new l(this);
        COUIStatusBarResponseUtil cOUIStatusBarResponseUtil = new COUIStatusBarResponseUtil(this);
        this.f26338H = cOUIStatusBarResponseUtil;
        cOUIStatusBarResponseUtil.setStatusBarClickListener(this);
        Intent intent = getIntent();
        if (intent != null) {
            try {
                this.f26352o = C0863y.b(intent, "slotId", 0);
            } catch (Exception e10) {
                Log.e("KeyWordListActivity", "Exception in getIntExtra: " + e10);
            }
            this.f26358z = C0863y.d(intent, "keyWord");
        }
        if (!TextUtils.isEmpty(this.f26358z)) {
            G1(this.f26358z);
        }
        CallInterceptController.e().d(this);
    }

    @Override // android.app.Activity
    public Dialog onCreateDialog(int i10, Bundle bundle) {
        if (i10 != 1) {
            return null;
        }
        return J1(i10);
    }

    @Override // com.oplus.blacklistapp.activities.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        CallInterceptController.e().m(this);
        this.f26342L.g();
        L.i();
        H1();
    }

    @Override // S8.o
    public void onItemClick(AdapterView<?> adapterView, View view, int i10, long j10) {
        EditModeHandler editModeHandler = this.f26333C;
        if (editModeHandler != null && editModeHandler.d()) {
            CheckBox checkBox = (CheckBox) view.findViewById(p.f27370X);
            COUICardListSelectedItemLayout cOUICardListSelectedItemLayout = (COUICardListSelectedItemLayout) view.findViewById(p.f27364U);
            if (checkBox == null) {
                return;
            }
            boolean z10 = true;
            boolean z11 = !checkBox.isChecked();
            checkBox.setChecked(z11);
            Z.a(cOUICardListSelectedItemLayout, z11);
            Cursor cursor = this.f26354q.getCursor();
            cursor.moveToPosition(i10);
            long j11 = cursor.getInt(0);
            if (this.f26337G.contains(Long.valueOf(j11))) {
                this.f26337G.remove(Long.valueOf(j11));
            } else {
                this.f26337G.add(Long.valueOf(j11));
            }
            this.f26333C.l(this.f26337G);
            this.f26349S.d();
            MenuItem menuItem = this.f26332B;
            if (menuItem != null) {
                if (this.f26337G.size() <= 0) {
                    z10 = false;
                }
                menuItem.setEnabled(z10);
            }
        }
    }

    @Override // S8.o
    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i10, long j10) {
        EditModeHandler editModeHandler = this.f26333C;
        if (editModeHandler != null && editModeHandler.d()) {
            return false;
        }
        this.f26354q.getCursor().moveToPosition(i10);
        this.f26337G.add(Long.valueOf(r1.getInt(0)));
        I1();
        return true;
    }

    @Override // com.coui.appcompat.list.COUIListView.ScrollMultiChoiceListener
    public void onItemTouch(int i10, View view) {
        EditModeHandler editModeHandler;
        if (view != null && (editModeHandler = this.f26333C) != null && editModeHandler.d()) {
            CheckBox checkBox = (CheckBox) view.findViewById(p.f27370X);
            COUICardListSelectedItemLayout cOUICardListSelectedItemLayout = (COUICardListSelectedItemLayout) view.findViewById(p.f27364U);
            if (checkBox == null) {
                return;
            }
            boolean z10 = true;
            boolean z11 = !checkBox.isChecked();
            checkBox.setChecked(z11);
            Z.a(cOUICardListSelectedItemLayout, z11);
            int headerViewsCount = i10 - this.f26353p.getHeaderViewsCount();
            Cursor cursor = this.f26354q.getCursor();
            cursor.moveToPosition(headerViewsCount);
            long j10 = cursor.getInt(0);
            if (this.f26337G.contains(Long.valueOf(j10))) {
                this.f26337G.remove(Long.valueOf(j10));
            } else {
                this.f26337G.add(Long.valueOf(j10));
            }
            this.f26333C.l(this.f26337G);
            this.f26349S.d();
            MenuItem menuItem = this.f26332B;
            if (menuItem != null) {
                if (this.f26337G.size() <= 0) {
                    z10 = false;
                }
                menuItem.setEnabled(z10);
            }
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        if (this.f26346P != null) {
            getContentResolver().unregisterContentObserver(this.f26346P);
            this.f26346P = null;
        }
        super.onPause();
        this.f26338H.onPause();
        T.c();
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onRequestPermissionsResult(int i10, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i10, strArr, iArr);
        if (!L.j(iArr)) {
            String[] f10 = L.f(this);
            this.f26341K = f10;
            if (f10 != null && f10.length > 0) {
                L.p(this, f10);
                return;
            }
            return;
        }
        C0861w.g(getApplicationContext()).k();
    }

    @Override // com.oplus.blacklistapp.activities.BaseActivity, com.oplus.blacklistapp.framework.baseui.BasicActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.f26338H.onResume();
        if (this.f26346P == null) {
            this.f26346P = new e(new Handler());
        }
        getContentResolver().registerContentObserver(Uri.withAppendedPath(com.oplus.blacklist.database.a.f26233b, "kw_list"), true, this.f26346P);
        this.f26357y.c();
    }

    @Override // com.oplus.blacklistapp.activities.BaseActivity, com.coui.appcompat.statusbar.COUIStatusBarResponseUtil.StatusBarClickListener
    public void onStatusBarClicked() {
        T.e(this, this.f26353p);
    }

    @Override // com.oplus.blacklistapp.callintercept.CallInterceptController.b
    public void u(int i10) {
        C0846g.i("KeyWordListActivity", "handleHotPlugOut slot = " + i10);
        finish();
    }

    /* loaded from: classes3.dex */
    public class b implements B {
        public b() {
        }

        @Override // com.oplus.utils.B
        public void b() {
            KeyWordListActivity.this.f26337G.clear();
            KeyWordListActivity.this.f26337G.addAll(KeyWordListActivity.this.f26336F);
            if (KeyWordListActivity.this.f26332B != null) {
                KeyWordListActivity.this.f26332B.setEnabled(true);
            }
        }

        @Override // com.oplus.utils.B
        public void c() {
            KeyWordListActivity.this.f26337G.clear();
            if (KeyWordListActivity.this.f26332B != null) {
                KeyWordListActivity.this.f26332B.setEnabled(false);
            }
        }

        @Override // com.oplus.utils.B
        public void a() {
        }
    }

    /* loaded from: classes3.dex */
    public class k extends ResourceCursorAdapter {

        /* renamed from: a, reason: collision with root package name */
        public final Context f26370a;

        /* renamed from: b, reason: collision with root package name */
        public boolean f26371b;

        /* renamed from: c, reason: collision with root package name */
        public final o f26372c;

        /* loaded from: classes3.dex */
        public class a implements ViewTreeObserver.OnGlobalLayoutListener {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ TextView f26374a;

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ ViewGroup f26375b;

            /* renamed from: c, reason: collision with root package name */
            public final /* synthetic */ Context f26376c;

            public a(TextView textView, ViewGroup viewGroup, Context context) {
                this.f26374a = textView;
                this.f26375b = viewGroup;
                this.f26376c = context;
            }

            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                this.f26374a.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                if (this.f26374a.getLineCount() > 1) {
                    this.f26375b.setMinimumHeight(this.f26376c.getResources().getDimensionPixelSize(com.oplus.blacklistapp.n.f27282g));
                } else {
                    this.f26375b.setMinimumHeight(this.f26376c.getResources().getDimensionPixelSize(com.oplus.blacklistapp.n.f27281f));
                }
            }
        }

        public k(Context context, o oVar) {
            super(context, r.f27459n, null);
            this.f26371b = true;
            this.f26370a = context;
            this.f26372c = oVar;
        }

        @Override // android.widget.CursorAdapter
        public void bindView(final View view, Context context, Cursor cursor) {
            final long j10 = cursor.getLong(cursor.getColumnIndex(BreenoCallContract.BaseColumns._ID));
            final int position = cursor.getPosition();
            String string = cursor.getString(cursor.getColumnIndex("keyword"));
            TextView textView = (TextView) view.findViewById(p.f27352O);
            ViewGroup viewGroup = (ViewGroup) view.findViewById(p.f27383d0);
            View findViewById = view.findViewById(p.f27390h);
            textView.setText(string);
            textView.getViewTreeObserver().addOnGlobalLayoutListener(new a(textView, viewGroup, context));
            CheckBox checkBox = (CheckBox) view.findViewById(p.f27370X);
            COUICardListSelectedItemLayout cOUICardListSelectedItemLayout = (COUICardListSelectedItemLayout) view.findViewById(p.f27364U);
            cOUICardListSelectedItemLayout.setOnClickListener(new View.OnClickListener() { // from class: p6.l
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    KeyWordListActivity.k.this.e(view, position, j10, view2);
                }
            });
            cOUICardListSelectedItemLayout.setOnLongClickListener(new View.OnLongClickListener() { // from class: p6.m
                @Override // android.view.View.OnLongClickListener
                public final boolean onLongClick(View view2) {
                    boolean f10;
                    f10 = KeyWordListActivity.k.this.f(view, position, j10, view2);
                    return f10;
                }
            });
            if (KeyWordListActivity.this.f26355r) {
                checkBox.setChecked(KeyWordListActivity.this.f26337G.contains(Long.valueOf(j10)));
                if (checkBox.getVisibility() != 0) {
                    if (this.f26371b && !KeyWordListActivity.this.f26348R) {
                        d(KeyWordListActivity.this.f26355r, checkBox);
                    } else {
                        checkBox.setVisibility(0);
                    }
                } else {
                    checkBox.setVisibility(0);
                }
                Z.a(cOUICardListSelectedItemLayout, checkBox.isChecked());
            } else {
                if (checkBox.getVisibility() == 0 && !KeyWordListActivity.f26330T && !KeyWordListActivity.this.f26348R) {
                    d(KeyWordListActivity.this.f26355r, checkBox);
                } else {
                    checkBox.setVisibility(8);
                    checkBox.setChecked(false);
                }
                Z.a(cOUICardListSelectedItemLayout, false);
            }
            if (cursor.isLast()) {
                findViewById.setVisibility(8);
            } else {
                findViewById.setVisibility(0);
            }
        }

        public final void d(boolean z10, CheckBox checkBox) {
            b bVar = new b(z10, checkBox);
            if (z10) {
                if (!BlackListAppUtil.f26245b) {
                    AnimationAnimationListenerC0842c.l(this.f26370a, null, 0).r(false, bVar, checkBox);
                    return;
                } else {
                    AnimationAnimationListenerC0842c.j(this.f26370a, null, 0).r(false, bVar, checkBox);
                    return;
                }
            }
            if (!BlackListAppUtil.f26245b) {
                AnimationAnimationListenerC0842c.m(this.f26370a, null, 8).r(false, bVar, checkBox);
            } else {
                AnimationAnimationListenerC0842c.k(this.f26370a, null, 8).r(false, bVar, checkBox);
            }
        }

        public final /* synthetic */ void e(View view, int i10, long j10, View view2) {
            o oVar = this.f26372c;
            if (oVar != null) {
                oVar.onItemClick(null, view, i10, j10);
            }
        }

        public final /* synthetic */ boolean f(View view, int i10, long j10, View view2) {
            o oVar = this.f26372c;
            if (oVar != null) {
                return oVar.onItemLongClick(null, view, i10, j10);
            }
            return false;
        }

        public void g(boolean z10) {
            KeyWordListActivity.this.f26355r = z10;
        }

        @Override // android.widget.BaseAdapter, android.widget.Adapter
        public int getItemViewType(int i10) {
            return COUICardListHelper.getPositionInGroup(((Cursor) getItem(i10)).getCount(), i10);
        }

        @Override // android.widget.BaseAdapter, android.widget.Adapter
        public int getViewTypeCount() {
            return 5;
        }

        @Override // android.widget.ResourceCursorAdapter, android.widget.CursorAdapter
        public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
            View newView = super.newView(context, cursor, viewGroup);
            COUICardListHelper.setItemCardBackground((COUICardListSelectedItemLayout) newView.findViewById(p.f27364U), getItemViewType(cursor.getPosition()));
            return newView;
        }

        /* loaded from: classes3.dex */
        public class b implements Animation.AnimationListener {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ boolean f26378a;

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ CheckBox f26379b;

            public b(boolean z10, CheckBox checkBox) {
                this.f26378a = z10;
                this.f26379b = checkBox;
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                k kVar = k.this;
                KeyWordListActivity.this.f26350m = false;
                if (!this.f26378a) {
                    kVar.f26371b = true;
                    this.f26379b.setChecked(false);
                    this.f26379b.setVisibility(8);
                } else {
                    kVar.f26371b = false;
                    this.f26379b.setVisibility(0);
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                KeyWordListActivity.this.f26350m = true;
                this.f26379b.setVisibility(0);
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        }
    }

    @Override // com.oplus.blacklistapp.callintercept.CallInterceptController.b
    public void P0(int i10) {
    }

    /* loaded from: classes3.dex */
    public class c implements AbsListView.OnScrollListener {
        public c() {
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i10) {
            boolean z10;
            if (KeyWordListActivity.this.f26354q != null) {
                KeyWordListActivity keyWordListActivity = KeyWordListActivity.this;
                if (i10 != 0) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                keyWordListActivity.f26348R = z10;
            }
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i10, int i11, int i12) {
        }
    }
}
