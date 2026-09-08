package com.customize.contacts.activities;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.icu.text.Collator;
import android.icu.util.ULocale;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import com.android.contacts.ContactsApplication;
import com.android.contacts.framework.baseui.activity.BasicActivity;
import com.coui.appcompat.statusbar.COUIStatusBarResponseUtil;
import com.coui.appcompat.toolbar.COUIToolbar;
import com.customize.contacts.FeatureOption;
import com.customize.contacts.util.C0794e;
import com.customize.contacts.util.C0811w;
import com.customize.contacts.widget.MultiChoiceListView;
import com.customize.contacts.widget.TouchSearchView;
import com.oplus.dialer.R;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import m1.C1320p;

/* loaded from: classes3.dex */
public class CountryOrAreaPickerActivity extends BasicActivity implements TouchSearchView.d, COUIStatusBarResponseUtil.StatusBarClickListener {

    /* renamed from: A, reason: collision with root package name */
    public List<String> f20297A;

    /* renamed from: B, reason: collision with root package name */
    public List<String> f20298B;

    /* renamed from: D, reason: collision with root package name */
    public int f20300D;

    /* renamed from: E, reason: collision with root package name */
    public String f20301E;

    /* renamed from: F, reason: collision with root package name */
    public COUIStatusBarResponseUtil f20302F;

    /* renamed from: o, reason: collision with root package name */
    public TouchSearchView f20306o;

    /* renamed from: z, reason: collision with root package name */
    public ULocale f20312z;

    /* renamed from: p, reason: collision with root package name */
    public com.customize.contacts.util.I f20307p = null;

    /* renamed from: q, reason: collision with root package name */
    public final String f20308q = "CountryOrAreaPickerActivity";

    /* renamed from: r, reason: collision with root package name */
    public MultiChoiceListView f20309r = null;

    /* renamed from: x, reason: collision with root package name */
    public P3.d f20310x = null;

    /* renamed from: y, reason: collision with root package name */
    public int f20311y = 0;

    /* renamed from: C, reason: collision with root package name */
    public boolean f20299C = true;

    /* renamed from: G, reason: collision with root package name */
    public View.OnTouchListener f20303G = new a();

    /* renamed from: H, reason: collision with root package name */
    public AdapterView.OnItemClickListener f20304H = new b();

    /* renamed from: I, reason: collision with root package name */
    public final BroadcastReceiver f20305I = new c();

    /* loaded from: classes3.dex */
    public class a implements View.OnTouchListener {
        public a() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            TouchSearchView touchSearchView = CountryOrAreaPickerActivity.this.f20306o;
            if (touchSearchView != null) {
                touchSearchView.r();
                return false;
            }
            return false;
        }
    }

    /* loaded from: classes3.dex */
    public class b implements AdapterView.OnItemClickListener {
        public b() {
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i10, long j10) {
            String upperCase;
            String C12;
            Intent intent = new Intent();
            SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(CountryOrAreaPickerActivity.this.getApplicationContext());
            if (i10 > 0) {
                Cursor cursor = (Cursor) CountryOrAreaPickerActivity.this.f20310x.getItem(i10 - CountryOrAreaPickerActivity.this.f20309r.getHeaderViewsCount());
                String string = cursor.getString(cursor.getColumnIndex("country_iso"));
                C12 = string.substring(0, string.length() - 3);
                upperCase = string.substring(string.length() - 2);
            } else {
                upperCase = C7.c.b(CountryOrAreaPickerActivity.this.getApplicationContext()).f().toUpperCase(Locale.US);
                C12 = TextUtils.isEmpty(CountryOrAreaPickerActivity.this.f20301E) ? CountryOrAreaPickerActivity.this.C1(upperCase) : CountryOrAreaPickerActivity.this.f20301E;
            }
            CountryOrAreaPickerActivity.this.log("onItemClick: countryISo = " + upperCase);
            defaultSharedPreferences.edit().putString("assisted_dialing_" + CountryOrAreaPickerActivity.this.f20300D, upperCase).apply();
            intent.putExtra("countryIso", C12);
            CountryOrAreaPickerActivity.this.setResult(-1, intent);
            CountryOrAreaPickerActivity.this.finish();
        }
    }

    /* loaded from: classes3.dex */
    public class c extends BroadcastReceiver {
        public c() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String l10 = C7.e.l(intent, "ss");
            CountryOrAreaPickerActivity.this.log("simStatus = " + l10);
            if (CountryOrAreaPickerActivity.this.f20299C) {
                CountryOrAreaPickerActivity.this.f20299C = false;
            } else if ("ABSENT".equals(l10)) {
                CountryOrAreaPickerActivity.this.finish();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d extends com.android.contacts.util.D<Void, Void, Cursor, CountryOrAreaPickerActivity> {
        @Override // com.android.contacts.util.D
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public Cursor a(CountryOrAreaPickerActivity countryOrAreaPickerActivity, Void... voidArr) {
            StringBuilder sb;
            boolean equals = CountryOrAreaPickerActivity.this.f20312z.getCountry().equals("TW");
            boolean equals2 = CountryOrAreaPickerActivity.this.f20312z.getCountry().equals("HK");
            try {
                Cursor query = countryOrAreaPickerActivity.getContentResolver().query(R0.d.f3231r, null, null, null, null);
                if (query != null) {
                    try {
                        if (query.getCount() > 0) {
                            query.moveToPosition(-1);
                            MatrixCursor matrixCursor = new MatrixCursor(new String[]{"country_iso"});
                            ArrayList arrayList = new ArrayList();
                            String upperCase = C7.c.b(CountryOrAreaPickerActivity.this.getApplicationContext()).f().toUpperCase(Locale.US);
                            while (query.moveToNext()) {
                                String string = query.getString(query.getColumnIndex("country_iso"));
                                String string2 = query.getString(query.getColumnIndex("country_name"));
                                String string3 = query.getString(query.getColumnIndex("country_code"));
                                if (ContactsApplication.f13094j) {
                                    sb = new StringBuilder();
                                    sb.append(string3);
                                    sb.append("+");
                                } else {
                                    sb = new StringBuilder();
                                    sb.append("+");
                                    sb.append(string3);
                                }
                                String sb2 = sb.toString();
                                if (!FeatureOption.i()) {
                                    string2 = string;
                                }
                                arrayList.add(string2 + " (" + sb2 + ") " + string);
                                if (TextUtils.equals(string, upperCase)) {
                                    CountryOrAreaPickerActivity.this.f20301E = string2 + " (" + sb2 + ") ";
                                }
                            }
                            if (!equals && !equals2) {
                                Collections.sort(arrayList, Collator.getInstance(CountryOrAreaPickerActivity.this.f20312z));
                            }
                            Iterator it = arrayList.iterator();
                            while (it.hasNext()) {
                                matrixCursor.addRow(new Object[]{(String) it.next()});
                            }
                            Cursor f10 = C0794e.f(matrixCursor, equals, equals2);
                            query.close();
                            return f10;
                        }
                    } finally {
                    }
                }
                Cursor f11 = C0794e.f(CountryOrAreaPickerActivity.this.D1(), equals, equals2);
                if (query != null) {
                    query.close();
                }
                return f11;
            } catch (Exception e10) {
                H7.b.c("CountryOrAreaPickerActivity", "e: " + e10);
                return C0794e.f(CountryOrAreaPickerActivity.this.D1(), equals, equals2);
            }
        }

        @Override // com.android.contacts.util.D
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public void b(CountryOrAreaPickerActivity countryOrAreaPickerActivity, Cursor cursor) {
            if (cursor != null && !cursor.isClosed()) {
                CountryOrAreaPickerActivity.this.f20310x.h(0, cursor);
                CountryOrAreaPickerActivity.this.f20310x.notifyDataSetChanged();
                Bundle a10 = ((C0794e.c) cursor).a();
                String[] stringArray = a10.getStringArray("extra_address_book_index_title");
                int[] intArray = a10.getIntArray("extra_address_book_index_count");
                if (CountryOrAreaPickerActivity.this.f20312z.equals(ULocale.JAPAN)) {
                    stringArray = new String[]{"#"};
                    intArray = new int[]{cursor.getCount()};
                }
                com.customize.contacts.util.g0.a(CountryOrAreaPickerActivity.this.f20306o, stringArray, intArray);
                CountryOrAreaPickerActivity.this.f20310x.N(new C1320p(stringArray, intArray));
                CountryOrAreaPickerActivity countryOrAreaPickerActivity2 = CountryOrAreaPickerActivity.this;
                if (countryOrAreaPickerActivity2.f20307p == null) {
                    countryOrAreaPickerActivity2.f20307p = new com.customize.contacts.util.I(countryOrAreaPickerActivity2.f20306o, null, null);
                }
            }
        }

        public d(CountryOrAreaPickerActivity countryOrAreaPickerActivity) {
            super(countryOrAreaPickerActivity);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void F1(View view) {
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void log(String str) {
        if (H7.a.b()) {
            H7.b.b("CountryOrAreaPickerActivity", str);
        }
    }

    public void B1(CharSequence charSequence) {
        int i10 = 0;
        if (charSequence.equals("*")) {
            this.f20309r.setSelection(0);
            return;
        }
        Object[] sections = this.f20310x.getSections();
        if (sections != null && sections.length != 0) {
            String charSequence2 = charSequence.toString();
            while (true) {
                if (i10 != sections.length) {
                    if (charSequence2.equals(sections[i10].toString())) {
                        break;
                    } else {
                        i10++;
                    }
                } else {
                    i10 = -1;
                    break;
                }
            }
            int headerViewsCount = this.f20309r.getHeaderViewsCount();
            if (i10 != -1) {
                this.f20309r.setSelection(this.f20310x.getPositionForSection(i10) + headerViewsCount + 1);
                MultiChoiceListView multiChoiceListView = this.f20309r;
                multiChoiceListView.dispatchWindowVisibilityChanged(multiChoiceListView.getVisibility());
            }
        }
    }

    public final String C1(String str) {
        String str2;
        String str3;
        if (FeatureOption.i()) {
            str2 = C0794e.d(this, new ULocale.Builder().setRegion(str).build().getDisplayCountry(this.f20312z), str);
        } else {
            str2 = str;
        }
        String str4 = "";
        try {
            str3 = this.f20297A.get(this.f20298B.indexOf(str));
        } catch (Exception e10) {
            e = e10;
        }
        try {
            if (ContactsApplication.f13094j) {
                str3 = U7.a.d(str3);
            }
        } catch (Exception e11) {
            e = e11;
            str4 = str3;
            H7.b.c("CountryOrAreaPickerActivity", "Adapted to Arabia Error: " + e);
            str3 = str4;
            return str2 + " " + str3;
        }
        return str2 + " " + str3;
    }

    public final Cursor D1() {
        H7.b.b("CountryOrAreaPickerActivity", "getCursorFromLocalData");
        MatrixCursor matrixCursor = new MatrixCursor(new String[]{"country_iso"});
        ArrayList arrayList = new ArrayList();
        for (int i10 = 0; i10 < this.f20298B.size(); i10++) {
            arrayList.add(C1(this.f20298B.get(i10)) + " " + this.f20298B.get(i10));
        }
        if (!this.f20312z.getCountry().equals("TW")) {
            Collections.sort(arrayList, Collator.getInstance(this.f20312z));
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            matrixCursor.addRow(new Object[]{(String) it.next()});
        }
        return matrixCursor;
    }

    public final int E1(CharSequence charSequence) {
        int i10 = 0;
        if (charSequence.equals("*")) {
            return 0;
        }
        Object[] sections = this.f20310x.getSections();
        if (sections != null && sections.length != 0) {
            String charSequence2 = charSequence.toString();
            while (true) {
                if (i10 != sections.length) {
                    if (charSequence2.equals(sections[i10].toString())) {
                        break;
                    }
                    i10++;
                } else {
                    i10 = -1;
                    break;
                }
            }
            int headerViewsCount = this.f20309r.getHeaderViewsCount();
            if (i10 != -1) {
                return this.f20310x.getPositionForSection(i10) + headerViewsCount;
            }
        }
        return i10;
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // com.android.contacts.framework.baseui.activity.BasicActivity, androidx.appcompat.app.AppCompatActivity, androidx.activity.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (H7.a.b()) {
            H7.b.b("CountryOrAreaPickerActivity", "onConfigurationChanged");
        }
        TouchSearchView touchSearchView = this.f20306o;
        if (touchSearchView != null) {
            touchSearchView.r();
            this.f20306o.q(false);
        }
    }

    @Override // com.android.contacts.framework.baseui.activity.BasicActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        String language;
        super.onCreate(bundle);
        setContentView(R.layout.country_or_area_picker);
        this.f20298B = Arrays.asList(getResources().getStringArray(R.array.assisted_dialing_cc_values));
        this.f20297A = Arrays.asList(getResources().getStringArray(R.array.assisted_dialing_cc_entries));
        this.f20309r = (MultiChoiceListView) findViewById(android.R.id.list);
        View inflate = LayoutInflater.from(this).inflate(R.layout.country_list_header_view, (ViewGroup) null);
        COUIToolbar cOUIToolbar = (COUIToolbar) findViewById(R.id.toolbar);
        cOUIToolbar.setNavigationIcon(R.drawable.coui_back_arrow);
        cOUIToolbar.setNavigationContentDescription(R.string.abc_action_bar_up_description);
        cOUIToolbar.setNavigationOnClickListener(new View.OnClickListener() { // from class: com.customize.contacts.activities.M
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CountryOrAreaPickerActivity.this.F1(view);
            }
        });
        cOUIToolbar.setTitle(R.string.select_country_area);
        this.f20309r.addHeaderView(inflate);
        com.android.contacts.util.C.c(this, this.f20309r, getResources().getDimensionPixelSize(R.dimen.DP_30));
        inflate.setLayoutParams(new AbsListView.LayoutParams(-1, -2));
        this.f20309r.setNestedScrollingEnabled(true);
        this.f20306o = (TouchSearchView) findViewById(R.id.spell_bar);
        if (B3.a.L()) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f20306o.getLayoutParams();
            layoutParams.setMarginEnd(getResources().getDimensionPixelOffset(R.dimen.curved_contactslist_margin));
            this.f20306o.setLayoutParams(layoutParams);
        }
        this.f20309r.setVisibility(8);
        this.f20306o.setVisibility(4);
        P3.d dVar = new P3.d(this);
        this.f20310x = dVar;
        this.f20309r.setAdapter((ListAdapter) dVar);
        this.f20309r.setOnTouchListener(this.f20303G);
        this.f20309r.setOnItemClickListener(this.f20304H);
        this.f20306o.setTouchSearchActionListener(this);
        if (getResources().getConfiguration().getLocales().get(0).getLanguage().equals("bo")) {
            language = "zh";
        } else {
            language = getResources().getConfiguration().getLocales().get(0).getLanguage();
        }
        this.f20312z = new ULocale.Builder().setRegion(getResources().getConfiguration().getLocales().get(0).getCountry()).setLanguage(language).build();
        new d(this).execute(new Void[0]);
        this.f20300D = D7.c.r(getApplicationContext(), Integer.valueOf(C7.e.d(getIntent(), "slot_id", -1)));
        View H10 = this.f20310x.H(this, null);
        H10.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        this.f20311y = H10.getMeasuredHeight();
        COUIStatusBarResponseUtil cOUIStatusBarResponseUtil = new COUIStatusBarResponseUtil(this);
        this.f20302F = cOUIStatusBarResponseUtil;
        cOUIStatusBarResponseUtil.setStatusBarClickListener(this);
        try {
            X.a b10 = X.a.b(this);
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.SIM_STATE_CHANGED");
            b10.c(this.f20305I, intentFilter);
        } catch (Exception e10) {
            H7.b.b("CountryOrAreaPickerActivity", "regist local broadcast error" + e10);
        }
        this.f20306o.O(findViewById(R.id.toolbar), null);
    }

    @Override // com.android.contacts.framework.baseui.activity.BasicActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        try {
            X.a.b(this).e(this.f20305I);
        } catch (Exception e10) {
            H7.b.c("CountryOrAreaPickerActivity", "unregister local receiver error" + e10);
        }
        super.onDestroy();
    }

    @Override // com.customize.contacts.widget.TouchSearchView.d
    public void onKey(CharSequence charSequence) {
        if (this.f20306o == null) {
            return;
        }
        if (H7.a.b()) {
            log("onKey = ");
        }
        B1(charSequence);
        if (charSequence.equals("*")) {
            this.f20309r.setSelection(0);
            return;
        }
        if (charSequence.equals("#")) {
            this.f20306o.setName(new String[0]);
            return;
        }
        com.customize.contacts.util.I i10 = this.f20307p;
        if (i10 == null) {
            return;
        }
        i10.i(charSequence);
    }

    @Override // com.customize.contacts.widget.TouchSearchView.d
    public void onNameClick(CharSequence charSequence) {
        int E12;
        if (H7.a.b()) {
            log("onNameKey: ");
        }
        com.customize.contacts.util.I i10 = this.f20307p;
        if (i10 != null && (E12 = E1(i10.d()) + this.f20307p.b(charSequence)) != -1) {
            if (this.f20307p.h(charSequence)) {
                this.f20309r.setSelection(E12 + 1);
            } else {
                this.f20309r.setSelectionFromTop(E12 + 1, this.f20311y);
            }
            MultiChoiceListView multiChoiceListView = this.f20309r;
            multiChoiceListView.dispatchWindowVisibilityChanged(multiChoiceListView.getVisibility());
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        unregisterReceiver(this.f20305I);
        com.customize.contacts.util.i0.b();
        this.f20302F.onPause();
        super.onPause();
    }

    @Override // com.android.contacts.framework.baseui.activity.BasicActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        this.f20309r.setVisibility(0);
        if (!this.f20312z.equals(ULocale.JAPAN)) {
            this.f20306o.setVisibility(0);
        }
        this.f20302F.onResume();
        IntentFilter intentFilter = new IntentFilter();
        C0811w.j(this, this.f20305I, intentFilter, "android.intent.action.SIM_STATE_CHANGED");
        registerReceiver(this.f20305I, intentFilter, R0.b.f3175i, null, 2);
    }

    @Override // com.coui.appcompat.statusbar.COUIStatusBarResponseUtil.StatusBarClickListener
    public void onStatusBarClicked() {
        com.customize.contacts.util.i0.d(this, this.f20309r);
    }
}
