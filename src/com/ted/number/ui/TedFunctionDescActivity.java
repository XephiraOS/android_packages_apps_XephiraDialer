package com.ted.number.ui;

import android.content.Context;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.android.contacts.ContactsApplication;
import com.android.contacts.framework.baseui.util.A;
import com.android.contacts.framework.baseui.util.StatementUtils;
import com.android.contacts.framework.baseui.util.j;
import com.coui.appcompat.grid.COUIPercentWidthRecyclerView;
import com.customize.contacts.FeatureOption;
import com.oplus.dialer.R;
import com.oplus.foundation.util.OsUtils;
import com.oplus.foundation.util.feature.FeatureUtil;
import java.util.HashMap;

/* loaded from: classes4.dex */
public class TedFunctionDescActivity extends TedBaseActivity {

    /* loaded from: classes4.dex */
    public class a extends j {

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Context f29764c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ int f29765d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(Context context, boolean z10, Context context2, int i10) {
            super(context, z10);
            this.f29764c = context2;
            this.f29765d = i10;
        }

        @Override // com.coui.appcompat.statement.COUIStatementClickableSpan, android.text.style.ClickableSpan
        public void onClick(View view) {
            super.onClick(view);
            StatementUtils.A(this.f29764c, 2, false, this.f29765d);
        }
    }

    /* loaded from: classes4.dex */
    public class b extends j {

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Context f29766c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ int f29767d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(Context context, boolean z10, Context context2, int i10) {
            super(context, z10);
            this.f29766c = context2;
            this.f29767d = i10;
        }

        @Override // com.coui.appcompat.statement.COUIStatementClickableSpan, android.text.style.ClickableSpan
        public void onClick(View view) {
            super.onClick(view);
            StatementUtils.A(this.f29766c, 1, false, this.f29767d);
        }
    }

    /* loaded from: classes4.dex */
    public class c extends j {

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Context f29768c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ int f29769d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(Context context, boolean z10, Context context2, int i10) {
            super(context, z10);
            this.f29768c = context2;
            this.f29769d = i10;
        }

        @Override // com.coui.appcompat.statement.COUIStatementClickableSpan, android.text.style.ClickableSpan
        public void onClick(View view) {
            super.onClick(view);
            StatementUtils.A(this.f29768c, 13, false, this.f29769d);
        }
    }

    /* loaded from: classes4.dex */
    public class d extends j {

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Context f29770c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ int f29771d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(Context context, boolean z10, Context context2, int i10) {
            super(context, z10);
            this.f29770c = context2;
            this.f29771d = i10;
        }

        @Override // com.coui.appcompat.statement.COUIStatementClickableSpan, android.text.style.ClickableSpan
        public void onClick(View view) {
            super.onClick(view);
            StatementUtils.A(this.f29770c, 1, false, this.f29771d);
        }
    }

    /* loaded from: classes4.dex */
    public class e extends j {

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Context f29773c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ int f29774d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(Context context, boolean z10, Context context2, int i10) {
            super(context, z10);
            this.f29773c = context2;
            this.f29774d = i10;
        }

        @Override // com.coui.appcompat.statement.COUIStatementClickableSpan, android.text.style.ClickableSpan
        public void onClick(View view) {
            super.onClick(view);
            StatementUtils.A(this.f29773c, 2, false, this.f29774d);
        }
    }

    /* loaded from: classes4.dex */
    public class f extends j {

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Context f29776c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ int f29777d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(Context context, boolean z10, Context context2, int i10) {
            super(context, z10);
            this.f29776c = context2;
            this.f29777d = i10;
        }

        @Override // com.coui.appcompat.statement.COUIStatementClickableSpan, android.text.style.ClickableSpan
        public void onClick(View view) {
            super.onClick(view);
            StatementUtils.A(this.f29776c, 13, false, this.f29777d);
        }
    }

    public static SpannableString v1(Context context, int i10) {
        String string = context.getString(R.string.number_recognition_user_agreement);
        String string2 = context.getString(R.string.number_recognition_personal_information_protection_policy);
        String string3 = context.getString(R.string.personal_information_sharing_third_party_list);
        String string4 = context.getString(R.string.number_recognition_function_description_content_v2, string, string2, string3);
        SpannableString spannableString = new SpannableString(string4);
        a aVar = new a(context, false, context, i10);
        b bVar = new b(context, false, context, i10);
        c cVar = new c(context, false, context, i10);
        int length = string2.length();
        int lastIndexOf = string4.lastIndexOf(string2);
        int length2 = string.length();
        int lastIndexOf2 = string4.lastIndexOf(string);
        int length3 = string3.length();
        int lastIndexOf3 = string4.lastIndexOf(string3);
        spannableString.setSpan(bVar, lastIndexOf, length + lastIndexOf, 33);
        spannableString.setSpan(aVar, lastIndexOf2, length2 + lastIndexOf2, 33);
        spannableString.setSpan(cVar, lastIndexOf3, length3 + lastIndexOf3, 33);
        return spannableString;
    }

    @Override // com.ted.number.ui.TedBaseActivity, com.android.contacts.framework.baseui.activity.BasicActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.ted_common_activity_layout);
        y1();
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == 16908332) {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(menuItem);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        HashMap hashMap = new HashMap();
        hashMap.put("enter_page", String.valueOf(0));
        A.d(this, 200034402, hashMap);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        HashMap hashMap = new HashMap();
        hashMap.put("exit_page", String.valueOf(0));
        A.d(this, 200034403, hashMap);
    }

    public final SpannableString w1(Context context, int i10) {
        String string;
        String str;
        int lastIndexOf;
        String string2 = context.getString(R.string.number_recognition_user_agreement);
        String string3 = context.getString(R.string.number_recognition_personal_information_protection_policy);
        String string4 = context.getString(R.string.personal_information_sharing_third_party_list);
        if (FeatureOption.i()) {
            string = context.getString(R.string.refer_to_details_3, string2, string3, string4);
        } else {
            string = context.getString(R.string.refer_to_details_two_arg, string2, string3);
        }
        String e10 = M7.a.e(context, "com.ted.number", "number_recognition_function_description");
        if (TextUtils.isEmpty(e10)) {
            str = context.getString(R.string.number_recognition_function_description_content_v3) + "\n\n" + string;
        } else {
            str = e10 + "\n\n" + string;
        }
        String str2 = str;
        SpannableString spannableString = new SpannableString(str2);
        int lastIndexOf2 = str2.lastIndexOf(string3);
        if (lastIndexOf2 != -1) {
            spannableString.setSpan(new d(context, false, context, i10), lastIndexOf2, string3.length() + lastIndexOf2, 33);
        }
        int lastIndexOf3 = str2.lastIndexOf(string2);
        if (lastIndexOf3 != -1) {
            spannableString.setSpan(new e(context, false, context, i10), lastIndexOf3, string2.length() + lastIndexOf3, 33);
        }
        if (FeatureOption.i() && (lastIndexOf = str2.lastIndexOf(string4)) != -1) {
            spannableString.setSpan(new f(context, false, context, i10), lastIndexOf, string4.length() + lastIndexOf, 33);
        }
        return spannableString;
    }

    public final String x1() {
        String string = getString(R.string.number_recognition_function_description_content_v2);
        int indexOf = string.indexOf(getString(R.string.refer_to_details_3));
        if (indexOf != -1) {
            return string.substring(0, indexOf);
        }
        return getString(R.string.number_recognition_function_description_content_v2, getString(R.string.number_recognition_user_agreement), getString(R.string.number_recognition_personal_information_protection_policy), getString(R.string.personal_information_sharing_third_party_list));
    }

    public final void y1() {
        boolean z10;
        String l10 = C7.e.l(getIntent(), "source");
        if (l10 == null) {
            l10 = "";
        }
        int d10 = C7.e.d(getIntent(), "extra_from", -1);
        View inflate = getLayoutInflater().inflate(R.layout.ted_function_desc_activity, (ViewGroup) null);
        TextView textView = (TextView) inflate.findViewById(R.id.ted_about_info_content);
        COUIPercentWidthRecyclerView cOUIPercentWidthRecyclerView = (COUIPercentWidthRecyclerView) findViewById(R.id.recyclerView);
        if (d10 != 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        cOUIPercentWidthRecyclerView.setPercentIndentEnabled(z10);
        if (H7.a.b()) {
            H7.b.b("TedFunctionDescActivity", "settingType = " + l10 + ", extraFrom = " + d10);
        }
        boolean i10 = FeatureOption.i();
        int i11 = R.string.function_desc;
        if (i10) {
            if (TextUtils.equals(l10, "boot_wizard") || d10 == 0 || d10 == 1) {
                if (OsUtils.f() && d10 == 1) {
                    r1();
                }
                i11 = R.string.pref_title_service_number_recognition;
            }
            if (d10 != 1 && !TextUtils.equals(l10, "boot_wizard")) {
                textView.setMovementMethod(LinkMovementMethod.getInstance());
                if (FeatureUtil.P()) {
                    textView.setText(w1(this, d10));
                } else {
                    textView.setText(v1(this, d10));
                }
            } else if (FeatureUtil.P()) {
                textView.setText(R.string.number_recognition_function_description_content_v3);
            } else {
                textView.setText(x1());
            }
        } else if (FeatureUtil.P()) {
            textView.setMovementMethod(LinkMovementMethod.getInstance());
            textView.setText(w1(this, d10));
        } else {
            textView.setText(getResources().getString(R.string.number_recognition_function_description_content));
        }
        s1(this, i11);
        if (ContactsApplication.f13094j) {
            textView.setTextDirection(4);
        } else {
            textView.setTextDirection(3);
        }
        t1((RecyclerView) findViewById(R.id.recyclerView), inflate);
    }
}
