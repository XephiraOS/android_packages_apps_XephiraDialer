package com.ted.number.ui;

import C7.e;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputFilter;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.style.ForegroundColorSpan;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckedTextView;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import com.android.contacts.framework.baseui.activity.BasicActivity;
import com.android.contacts.framework.baseui.util.C0636a;
import com.android.contacts.framework.baseui.util.C0637b;
import com.android.contacts.framework.baseui.util.r;
import com.android.contacts.util.C;
import com.coui.appcompat.cardlist.COUICardListHelper;
import com.coui.appcompat.scrollview.COUIScrollView;
import com.coui.appcompat.toolbar.COUIToolbar;
import com.customize.contacts.FeatureOption;
import com.oplus.dialer.R;
import com.oplus.foundation.util.feature.FeatureUtil;
import com.oplus.foundation.util.ui.c;
import com.ted.number.ui.ErrorRecoveryActivity;
import h1.C1074c;

/* loaded from: classes4.dex */
public class ErrorRecoveryActivity extends BasicActivity implements TextWatcher, View.OnClickListener {

    /* renamed from: A, reason: collision with root package name */
    public String f29705A;

    /* renamed from: B, reason: collision with root package name */
    public int f29706B;

    /* renamed from: D, reason: collision with root package name */
    public String[] f29708D;

    /* renamed from: H, reason: collision with root package name */
    public MenuItem f29712H;

    /* renamed from: o, reason: collision with root package name */
    public CheckedTextView f29714o;

    /* renamed from: p, reason: collision with root package name */
    public CheckedTextView f29715p;

    /* renamed from: q, reason: collision with root package name */
    public CheckedTextView f29716q;

    /* renamed from: r, reason: collision with root package name */
    public EditText f29717r;

    /* renamed from: x, reason: collision with root package name */
    public EditText f29718x;

    /* renamed from: y, reason: collision with root package name */
    public EditText f29719y;

    /* renamed from: z, reason: collision with root package name */
    public String f29720z;

    /* renamed from: C, reason: collision with root package name */
    public boolean f29707C = false;

    /* renamed from: E, reason: collision with root package name */
    public boolean f29709E = false;

    /* renamed from: F, reason: collision with root package name */
    public int f29710F = 0;

    /* renamed from: G, reason: collision with root package name */
    public int f29711G = 0;

    /* renamed from: I, reason: collision with root package name */
    public int f29713I = 0;

    /* loaded from: classes4.dex */
    public class a extends AsyncTask<Void, Void, Boolean> {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f29721a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f29722b;

        public a(String str, String str2) {
            this.f29721a = str;
            this.f29722b = str2;
        }

        @Override // android.os.AsyncTask
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Boolean doInBackground(Void... voidArr) {
            return Boolean.valueOf(E0.b.c(ErrorRecoveryActivity.this.f29705A, this.f29721a, ErrorRecoveryActivity.this.f29720z + "##" + String.valueOf(ErrorRecoveryActivity.this.f29710F), this.f29721a, this.f29722b, ErrorRecoveryActivity.this.f29713I));
        }

        @Override // android.os.AsyncTask
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(Boolean bool) {
            if (bool.booleanValue()) {
                ErrorRecoveryActivity errorRecoveryActivity = ErrorRecoveryActivity.this;
                c.e(errorRecoveryActivity, errorRecoveryActivity.getString(R.string.toast_submit_error_recovery));
                ErrorRecoveryActivity.this.finish();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b extends AsyncTask<Void, Void, Void> {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f29724a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f29725b;

        public b(String str, String str2) {
            this.f29724a = str;
            this.f29725b = str2;
        }

        @Override // android.os.AsyncTask
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Void doInBackground(Void... voidArr) {
            String str;
            if (ErrorRecoveryActivity.this.f29706B >= 0 && ErrorRecoveryActivity.this.f29706B < ErrorRecoveryActivity.this.f29708D.length) {
                str = ErrorRecoveryActivity.this.f29708D[ErrorRecoveryActivity.this.f29706B];
            } else {
                str = null;
            }
            E0.b.d(ErrorRecoveryActivity.this.f29705A, str + "##" + String.valueOf(ErrorRecoveryActivity.this.f29710F), this.f29724a, this.f29725b, ErrorRecoveryActivity.this.f29713I);
            return null;
        }

        @Override // android.os.AsyncTask
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(Void r22) {
            ErrorRecoveryActivity errorRecoveryActivity = ErrorRecoveryActivity.this;
            c.e(errorRecoveryActivity, errorRecoveryActivity.getString(R.string.toast_submit_error_recovery));
            ErrorRecoveryActivity.this.finish();
        }
    }

    private void A1() {
        this.f29714o = (CheckedTextView) findViewById(R.id.ted_name_error);
        this.f29715p = (CheckedTextView) findViewById(R.id.ted_address_error);
        this.f29716q = (CheckedTextView) findViewById(R.id.ted_personal_number_error);
        this.f29717r = (EditText) findViewById(R.id.ted_correction_input);
        EditText editText = (EditText) findViewById(R.id.contact_information);
        this.f29718x = editText;
        editText.setHint(R.string.ted_correction_hint_contact_info);
        this.f29719y = (EditText) findViewById(R.id.ted_correction_number_input);
        View findViewById = findViewById(R.id.divider);
        if (FeatureOption.i() && !FeatureUtil.O()) {
            z1(this);
        }
        COUICardListHelper.setItemCardBackground(findViewById(R.id.ted_correction_number_input_container), 4);
        COUICardListHelper.setItemCardBackground(this.f29714o, 1);
        COUICardListHelper.setItemCardBackground(this.f29715p, 3);
        COUICardListHelper.setItemCardBackground(findViewById(R.id.ted_correction_input_container), 4);
        COUICardListHelper.setItemCardBackground(findViewById(R.id.ted_contact_information_container), 4);
        this.f29714o.setOnClickListener(this);
        this.f29715p.setOnClickListener(this);
        this.f29716q.setOnClickListener(this);
        this.f29717r.addTextChangedListener(this);
        this.f29718x.addTextChangedListener(this);
        if (C0637b.h()) {
            this.f29719y.setText(C0637b.d(this.f29705A));
        } else {
            this.f29719y.setText(this.f29705A);
        }
        this.f29719y.setInputType(3);
        this.f29719y.setFilters(new InputFilter[]{new InputFilter.LengthFilter(25)});
        this.f29719y.setTextDirection(3);
        C1074c.d(this, this.f29719y);
        if (!this.f29707C) {
            this.f29716q.setVisibility(8);
            findViewById.setVisibility(8);
        } else {
            findViewById.setVisibility(0);
            COUICardListHelper.setItemCardBackground(this.f29715p, 2);
            COUICardListHelper.setItemCardBackground(this.f29716q, 3);
        }
    }

    private void y1() {
        Intent intent = getIntent();
        this.f29705A = e.l(intent, "unknown_number");
        this.f29720z = e.l(intent, "recognition_name");
        this.f29706B = e.d(intent, "mark_type", 0);
        this.f29707C = !TextUtils.isEmpty(this.f29720z);
        this.f29713I = e.d(intent, "number_supplier_type", 0);
    }

    public final /* synthetic */ boolean B1(MenuItem menuItem) {
        int itemId = menuItem.getItemId();
        if (itemId != R.id.cancel) {
            if (itemId == R.id.save) {
                D1();
                return true;
            }
            return true;
        }
        finish();
        return true;
    }

    public final void C1() {
        if (this.f29707C) {
            this.f29714o.setText(getString(R.string.ted_name_error));
            this.f29715p.setText(getString(R.string.ted_address_website_error));
            this.f29716q.setText(getString(R.string.ted_personal_number_error));
            this.f29717r.setHint(getString(R.string.ted_name_error_hint));
            this.f29717r.setFocusable(true);
            this.f29714o.setChecked(true);
            this.f29710F = 0;
            return;
        }
        this.f29714o.setText(getString(R.string.ted_personal_number_mark_error));
        this.f29715p.setText(getString(R.string.ted_mark_type_error));
        this.f29717r.setHint(getString(R.string.ted_personal_number_mark_error));
        this.f29717r.setFocusable(true);
        this.f29714o.setChecked(true);
        this.f29710F = 4;
        this.f29708D = E0.b.v(this);
    }

    public final void D1() {
        this.f29705A = this.f29719y.getText().toString();
        H7.b.b("ErrorRevoveryActivity", "submitRecovery, the mNumber is " + H7.a.d(this.f29705A));
        if (TextUtils.isEmpty(this.f29705A)) {
            return;
        }
        String trim = this.f29717r.getText().toString().trim();
        String trim2 = this.f29718x.getText().toString().trim();
        if (this.f29707C) {
            int i10 = this.f29710F;
            if ((i10 == 0 || i10 == 2) && TextUtils.isEmpty(trim)) {
                c.e(this, getString(R.string.toast_add_error_recovery_yp));
                return;
            } else {
                new a(trim, trim2).execute(new Void[0]);
                return;
            }
        }
        new b(trim, trim2).execute(new Void[0]);
    }

    public final void E1() {
        ViewGroup viewGroup;
        View findViewById = findViewById(R.id.number_layout);
        if (findViewById != null && (viewGroup = (ViewGroup) findViewById.getParent()) != null) {
            viewGroup.removeView(findViewById);
            viewGroup.addView(findViewById);
        }
    }

    public final void F1() {
        MenuItem menuItem = this.f29712H;
        if (menuItem != null) {
            menuItem.setEnabled(this.f29709E);
        }
    }

    @Override // com.android.contacts.framework.baseui.activity.BasicActivity
    public boolean H0() {
        return true;
    }

    @Override // com.android.contacts.framework.baseui.activity.BasicActivity
    public boolean Q0() {
        return false;
    }

    @Override // com.android.contacts.framework.baseui.activity.BasicActivity
    public boolean T0() {
        return false;
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        boolean z10;
        int i10 = this.f29710F;
        if (i10 != 0 && i10 != 2) {
            if (!x1() && !w1()) {
                z10 = false;
            } else {
                z10 = true;
            }
            this.f29709E = z10;
        } else {
            this.f29709E = x1();
        }
        F1();
    }

    @Override // android.app.Activity
    public void finish() {
        super.finish();
        C0636a.b(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == null) {
            return;
        }
        int id = view.getId();
        boolean z10 = true;
        if (id != R.id.ted_address_error) {
            if (id != R.id.ted_name_error) {
                if (id == R.id.ted_personal_number_error) {
                    this.f29714o.setChecked(false);
                    this.f29715p.setChecked(false);
                    this.f29716q.setChecked(true);
                    this.f29717r.setHint(getString(R.string.ted_personal_number_error));
                    this.f29710F = 3;
                    if (!x1() && !w1()) {
                        z10 = false;
                    }
                    this.f29709E = z10;
                    F1();
                    return;
                }
                return;
            }
            this.f29714o.setChecked(true);
            this.f29715p.setChecked(false);
            if (this.f29707C) {
                this.f29716q.setChecked(false);
                this.f29717r.setHint(getString(R.string.ted_name_error_hint));
                this.f29710F = 0;
                this.f29709E = x1();
                F1();
                return;
            }
            this.f29717r.setHint(getString(R.string.ted_personal_number_mark_error));
            this.f29710F = 4;
            return;
        }
        this.f29714o.setChecked(false);
        this.f29715p.setChecked(true);
        if (this.f29707C) {
            this.f29716q.setChecked(false);
            this.f29717r.setHint(getString(R.string.ted_address_website_error_hint));
            this.f29710F = 2;
            this.f29709E = x1();
            F1();
            return;
        }
        this.f29717r.setHint(getString(R.string.ted_mark_type_error));
        this.f29710F = 1;
    }

    @Override // com.android.contacts.framework.baseui.activity.BasicActivity, androidx.appcompat.app.AppCompatActivity, androidx.activity.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        int i10 = configuration.orientation;
        if (this.f29711G != i10) {
            E1();
            this.f29711G = i10;
        }
    }

    @Override // com.android.contacts.framework.baseui.activity.BasicActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.ted_error_recovery_activity);
        COUIToolbar cOUIToolbar = (COUIToolbar) findViewById(R.id.toolbar);
        cOUIToolbar.setIsTitleCenterStyle(true);
        cOUIToolbar.inflateMenu(R.menu.cancel_save_menu);
        MenuItem findItem = cOUIToolbar.getMenu().findItem(R.id.save);
        this.f29712H = findItem;
        if (findItem != null) {
            findItem.setTitle(R.string.ted_correction_button_submit);
        }
        cOUIToolbar.setOnMenuItemClickListener(new Toolbar.g() { // from class: g9.a
            @Override // androidx.appcompat.widget.Toolbar.g
            public final boolean onMenuItemClick(MenuItem menuItem) {
                boolean B12;
                B12 = ErrorRecoveryActivity.this.B1(menuItem);
                return B12;
            }
        });
        cOUIToolbar.setTitle(R.string.ted_actionbar_correction_mark);
        COUIScrollView cOUIScrollView = (COUIScrollView) findViewById(R.id.scroll_view);
        cOUIScrollView.setNestedScrollingEnabled(true);
        C.c(this, cOUIScrollView, 0);
        y1();
        A1();
        C1();
        this.f29711G = getResources().getConfiguration().orientation;
        F1();
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuItem findItem;
        getMenuInflater().inflate(R.menu.cancel_save_menu, menu);
        if (menu != null && (findItem = menu.findItem(R.id.save)) != null) {
            findItem.setTitle(R.string.ted_correction_button_submit);
            return true;
        }
        return true;
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        int itemId = menuItem.getItemId();
        if (itemId != R.id.cancel) {
            if (itemId == R.id.save) {
                D1();
                return true;
            }
            return true;
        }
        finish();
        return true;
    }

    @Override // android.app.Activity
    public boolean onPrepareOptionsMenu(Menu menu) {
        MenuItem findItem = menu.findItem(R.id.save);
        H7.b.e("ErrorRecoveryActivity", "mIsHasContent = " + this.f29709E);
        if (findItem != null) {
            H7.b.e("ErrorRecoveryActivity", "mIsHasContent 2 = " + this.f29709E);
            findItem.setEnabled(this.f29709E);
            return true;
        }
        return true;
    }

    public final boolean w1() {
        EditText editText = this.f29718x;
        if (editText != null && !TextUtils.isEmpty(editText.getText())) {
            return true;
        }
        return false;
    }

    public final boolean x1() {
        EditText editText = this.f29717r;
        if (editText != null && !TextUtils.isEmpty(editText.getText())) {
            return true;
        }
        return false;
    }

    public final void z1(Context context) {
        ((LinearLayout) findViewById(R.id.layout_teddy_brand)).setVisibility(0);
        TextView textView = (TextView) findViewById(R.id.ted_data_surport_tag);
        String string = context.getString(R.string.ted_number_recognition_surport);
        String string2 = context.getString(R.string.ted_mobile);
        int indexOf = string.indexOf(string2);
        SpannableString spannableString = new SpannableString(string);
        try {
            spannableString.setSpan(new ForegroundColorSpan(r.a(this)), indexOf, string2.length() + indexOf, 0);
        } catch (Exception e10) {
            H7.b.c("ErrorRecoveryActivity", "initTedTextView e:" + e10);
        }
        textView.setText(spannableString);
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
    }
}
