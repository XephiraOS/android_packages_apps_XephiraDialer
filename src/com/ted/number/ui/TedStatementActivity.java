package com.ted.number.ui;

import C7.e;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.text.Layout;
import android.text.Selection;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.CharacterStyle;
import android.text.style.TextAppearanceSpan;
import android.text.style.UpdateAppearance;
import android.util.Log;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.android.contacts.framework.baseui.util.A;
import com.android.contacts.framework.baseui.util.StatementUtils;
import com.android.incallui.OplusPhoneUtils;
import com.coui.appcompat.toolbar.COUIToolbar;
import com.customize.contacts.FeatureOption;
import com.customize.contacts.util.C0792c;
import com.customize.contacts.util.C0811w;
import com.customize.contacts.util.K;
import com.oplus.dialer.R;
import com.oplus.foundation.util.OsUtils;
import com.oplus.foundation.util.feature.FeatureUtil;
import com.ted.number.CustomHTMLTagHandler;
import com.ted.number.DocumentHelper;
import com.ted.number.p;
import com.ted.number.q;
import com.ted.number.r;
import com.ted.number.ui.TedStatementActivity;
import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import v9.InterfaceC1637a;

/* loaded from: classes4.dex */
public class TedStatementActivity extends TedBaseActivity {

    /* renamed from: y, reason: collision with root package name */
    public static final Pattern f29779y = Pattern.compile("((http|ftp|https)://)(([a-zA-Z0-9\\._-]+\\.[a-zA-Z]{2,6})|([0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}))(:[0-9]{1,4})*(/[a-zA-Z0-9\\&%_\\./-~-]*)?", 2);

    /* renamed from: p, reason: collision with root package name */
    public int f29780p = 0;

    /* renamed from: q, reason: collision with root package name */
    public int f29781q = 0;

    /* renamed from: r, reason: collision with root package name */
    public TextView f29782r;

    /* renamed from: x, reason: collision with root package name */
    public COUIToolbar f29783x;

    /* loaded from: classes4.dex */
    public class a extends d {

        /* renamed from: a, reason: collision with root package name */
        public final int f29784a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f29785b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(String str) {
            super();
            this.f29785b = str;
            this.f29784a = TedStatementActivity.this.getColor(R.color.coui_clickable_text_color);
        }

        @Override // com.ted.number.ui.TedStatementActivity.d
        public boolean a(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() == 1) {
                Uri parse = Uri.parse(this.f29785b);
                Context context = view.getContext();
                Intent intent = new Intent("android.intent.action.VIEW", parse);
                intent.putExtra("com.android.browser.application_id", context.getPackageName());
                R7.b.c(context, intent);
            }
            return true;
        }

        @Override // android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            textPaint.setColor(this.f29784a);
        }
    }

    /* loaded from: classes4.dex */
    public class b extends d {

        /* renamed from: a, reason: collision with root package name */
        public final int f29787a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f29788b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(int i10) {
            super();
            this.f29788b = i10;
            this.f29787a = TedStatementActivity.this.getColor(R.color.coui_clickable_text_color);
        }

        @Override // com.ted.number.ui.TedStatementActivity.d
        public boolean a(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() != 1 || C7.a.a()) {
                return true;
            }
            int i10 = this.f29788b;
            if (i10 == 3) {
                TedStatementActivity.this.z1();
            } else if (i10 == 16) {
                C0792c.o(TedStatementActivity.this);
            } else if (i10 == 18) {
                Uri parse = Uri.parse(TedStatementActivity.this.getString(R.string.no_translation_cloud_service_url));
                Intent intent = new Intent("android.intent.action.VIEW");
                intent.setData(parse);
                R7.b.c(TedStatementActivity.this, intent);
            } else if (i10 == 19) {
                Uri parse2 = Uri.parse(TedStatementActivity.this.getString(R.string.no_translation_heytap_account_url, K.a()));
                Intent intent2 = new Intent("android.intent.action.VIEW");
                intent2.setData(parse2);
                R7.b.c(TedStatementActivity.this, intent2);
            } else if (i10 == 15) {
                com.android.contacts.framework.api.businesshall.a.n(TedStatementActivity.this);
            } else if (i10 == 10) {
                com.android.contacts.framework.api.infocollection.a.d(TedStatementActivity.this);
            } else {
                Intent intent3 = new Intent(TedStatementActivity.this, (Class<?>) TedStatementActivity.class);
                intent3.putExtra("source", this.f29788b);
                intent3.putExtra("extra_from", TedStatementActivity.this.f29781q);
                R7.b.c(TedStatementActivity.this, intent3);
            }
            return true;
        }

        @Override // android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            textPaint.setColor(this.f29787a);
        }
    }

    /* loaded from: classes4.dex */
    public static class c extends LinkMovementMethod {
        @Override // android.text.method.LinkMovementMethod, android.text.method.ScrollingMovementMethod, android.text.method.BaseMovementMethod, android.text.method.MovementMethod
        public boolean onTouchEvent(TextView textView, Spannable spannable, MotionEvent motionEvent) {
            int action = motionEvent.getAction();
            if (action != 1 && action != 0) {
                if (action == 3) {
                    Selection.removeSelection(spannable);
                }
            } else {
                int x10 = (int) motionEvent.getX();
                int y10 = (int) motionEvent.getY();
                int totalPaddingLeft = x10 - textView.getTotalPaddingLeft();
                int totalPaddingTop = y10 - textView.getTotalPaddingTop();
                int scrollX = totalPaddingLeft + textView.getScrollX();
                int scrollY = totalPaddingTop + textView.getScrollY();
                Layout layout = textView.getLayout();
                int offsetForHorizontal = layout.getOffsetForHorizontal(layout.getLineForVertical(scrollY), scrollX);
                d[] dVarArr = (d[]) spannable.getSpans(offsetForHorizontal, offsetForHorizontal, d.class);
                if (dVarArr.length != 0) {
                    if (action == 1) {
                        dVarArr[0].a(textView, motionEvent);
                    } else if (action == 0) {
                        dVarArr[0].a(textView, motionEvent);
                        Selection.setSelection(spannable, spannable.getSpanStart(dVarArr[0]), spannable.getSpanEnd(dVarArr[0]));
                    }
                    return true;
                }
                Selection.removeSelection(spannable);
            }
            return super.onTouchEvent(textView, spannable, motionEvent);
        }

        public c() {
        }
    }

    /* loaded from: classes4.dex */
    public static abstract class d extends CharacterStyle implements UpdateAppearance {
        public abstract boolean a(View view, MotionEvent motionEvent);

        public d() {
        }
    }

    private void Q1(SpannableString spannableString) {
        try {
            spannableString.setSpan(new TextAppearanceSpan(this, R.style.NormalColorStyle), 0, spannableString.length() - 1, 33);
        } catch (Exception e10) {
            H7.b.c("TedStatementActivity", "setNormalColorStyle e : " + e10);
        }
    }

    public final Context A1(int i10) {
        if (FeatureUtil.O() && (i10 == 2 || i10 == 1 || i10 == 13 || i10 == 12)) {
            try {
                return createPackageContext("com.ted.number", 0);
            } catch (PackageManager.NameNotFoundException e10) {
                H7.b.c("TedStatementActivity", "getAssertContext : " + e10);
            }
        }
        return this;
    }

    public final String B1(String str, String str2) {
        if (!"cn".equals(str) && !"tw".equals(str) && !"hk".equals(str)) {
            return str2 + "_en.html";
        }
        return str2 + "_" + str + ".html";
    }

    public final String C1(String str) {
        return str + File.separator + "business_hall_protect_privacy";
    }

    public final String D1(Context context, List<String> list) {
        StringBuilder sb;
        StringBuilder sb2 = new StringBuilder();
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            String str = "";
            InputStream inputStream = null;
            try {
                try {
                    inputStream = context.getResources().getAssets().open(it.next());
                    byte[] bArr = new byte[inputStream.available()];
                    if (inputStream.read(bArr) > 0) {
                        str = new q(106, bArr).a();
                    }
                } catch (Exception e10) {
                    Log.e("TedStatementActivity", "e=" + e10);
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (Exception e11) {
                            sb = new StringBuilder();
                            sb.append("e=");
                            sb.append(e11);
                            Log.e("TedStatementActivity", sb.toString());
                            sb2.append(str);
                        }
                    }
                }
                try {
                    inputStream.close();
                } catch (Exception e12) {
                    sb = new StringBuilder();
                    sb.append("e=");
                    sb.append(e12);
                    Log.e("TedStatementActivity", sb.toString());
                    sb2.append(str);
                }
                sb2.append(str);
            } catch (Throwable th) {
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (Exception e13) {
                        Log.e("TedStatementActivity", "e=" + e13);
                    }
                }
                throw th;
            }
        }
        return sb2.toString();
    }

    public final String E1() {
        int i10 = this.f29780p;
        if (i10 == 15) {
            return "2";
        }
        if (i10 == 17) {
            return "3";
        }
        return OplusPhoneUtils.DeviceState.LOCK_DEVICE;
    }

    public final String F1() {
        int indexOf;
        String charSequence = this.f29782r.getText().toString();
        int i10 = this.f29780p;
        if (i10 == 15) {
            indexOf = charSequence.indexOf(getString(R.string.no_translation_welcome_use_business_hall_service));
        } else if (i10 == 17) {
            indexOf = charSequence.indexOf(getString(R.string.no_translation_contacts_personal_information_protection_policy));
        } else {
            indexOf = charSequence.indexOf(getString(R.string.welcome_use_smart_strange_number_recognize));
        }
        if (indexOf != -1) {
            return charSequence.substring(indexOf).replaceAll(" ", "");
        }
        return charSequence.replaceAll(" ", "");
    }

    public final String G1() {
        int i10 = this.f29780p;
        if (i10 == 15) {
            return getString(R.string.no_translation_business_hall_personal_information_protection_policy) + "20220527.txt";
        }
        if (i10 == 17) {
            return getString(R.string.no_translation_contacts_personal_information_protection_policy) + "20241121.txt";
        }
        if (i10 == -1) {
            return getString(R.string.no_translatable_number_recognition_personal_information_protection_policy) + "20220215.txt";
        }
        if (i10 == 1) {
            if (FeatureUtil.O()) {
                return getString(R.string.no_translatable_number_recognition_personal_information_protection_policy) + M7.a.a(this, "com.ted.number", "number_recognition_protect_privacy_update_date", "20220215") + ".txt";
            }
            return getString(R.string.no_translatable_number_recognition_personal_information_protection_policy) + "20220215.txt";
        }
        return String.valueOf(i10);
    }

    public final List<String> H1(int i10) {
        String str;
        String C12;
        ArrayList arrayList = new ArrayList();
        String a10 = K.a();
        if (!a10.equalsIgnoreCase("zh-CN") && !a10.startsWith("zh-Hans") && !a10.startsWith("bo") && !a10.startsWith("ug")) {
            if (!a10.equalsIgnoreCase("zh-Hant-TW") && !a10.equalsIgnoreCase("zh-TW")) {
                if (!a10.equalsIgnoreCase("zh-HK") && !a10.startsWith("zh-Hant")) {
                    str = "en";
                } else {
                    str = "hk";
                }
            } else {
                str = "tw";
            }
        } else {
            str = "cn";
        }
        H7.b.e("TedStatementActivity", "language = " + str);
        if (i10 == 2) {
            arrayList.add(B1(str, "number_recognition_user_protocol"));
        } else if (i10 != 1 && i10 != -1) {
            if (i10 == 6) {
                arrayList.add(B1(str, "tort_action_guideline"));
            } else if (i10 == 7) {
                arrayList.add(B1(str, "tort_action_notify_guideline"));
            } else if (i10 == 8) {
                arrayList.add(B1(str, "user_behavior"));
            } else if (i10 == 9) {
                arrayList.add(B1(str, "violations_report"));
            } else if (i10 != 11) {
                if (i10 == 13) {
                    arrayList.add(B1(str, "number_recognition_sharing_third_party_protocol"));
                } else if (i10 == 12) {
                    arrayList.add(B1(str, "number_recognition_collect_private_protocol"));
                } else if (i10 == 14) {
                    arrayList.add(B1(str, "business_hall_function_description"));
                } else if (i10 == 15) {
                    if (C0811w.e()) {
                        if (B3.a.S()) {
                            C12 = C1("oppo".toLowerCase());
                        } else {
                            C12 = C1("oppo");
                        }
                    } else {
                        C12 = C1("oppo".toLowerCase());
                    }
                    arrayList.add(B1(str, C12));
                } else if (i10 == 17) {
                    arrayList.add(B1(str, "contact_privacy_protocol_header"));
                    arrayList.add(B1(str, "contact_privacy_protocol_welcome"));
                    arrayList.add(B1(str, "contact_privacy_protocol_body"));
                    arrayList.add(B1(str, "contact_privacy_protocol_footer"));
                }
            }
        } else {
            arrayList.add(B1(str, "number_recognition_protect_privacy"));
        }
        return arrayList;
    }

    public final SpannableString I1(List<String> list, int i10) {
        try {
            return new SpannableString(com.ted.number.b.a(D1(A1(i10), list), 0));
        } catch (Throwable unused) {
            return new SpannableString(com.ted.number.b.a(D1(this, list), 0));
        }
    }

    public final boolean J1(TedStatementActivity tedStatementActivity) {
        if (OsUtils.f() && FeatureOption.i() && 1 == tedStatementActivity.f29781q) {
            return true;
        }
        return false;
    }

    public final boolean K1() {
        if (FeatureUtil.O() && FeatureOption.o()) {
            int i10 = this.f29780p;
            if (i10 == 2) {
                if (P1(M7.a.b(this, "com.ted.number", "number_recognition_export_user_protocol"))) {
                    H7.b.e("TedStatementActivity", "setHTMLArrayContent: export_user_protocol");
                    return true;
                }
                return false;
            }
            if (i10 == 1 && P1(M7.a.b(this, "com.ted.number", "number_recognition_export_protect_privacy"))) {
                H7.b.e("TedStatementActivity", "setHTMLArrayContent: protect_privacy");
                return true;
            }
            return false;
        }
        return false;
    }

    public final void L1() {
        String[] strArr;
        int[] iArr;
        int[] iArr2;
        if (K1()) {
            return;
        }
        SpannableString I12 = I1(H1(this.f29780p), this.f29780p);
        Q1(I12);
        int i10 = this.f29780p;
        if (i10 == 2) {
            N1(I12, new int[]{R.string.tort_action, R.string.tort_action_notify, R.string.user_behavior, R.string.violations_report, R.string.number_recognition_protect_privacy_witch_bracket}, new int[]{6, 7, 8, 9, 1});
            this.f29782r.setMovementMethod(new c());
        } else if (i10 == -1) {
            if (FeatureOption.i()) {
                N1(I12, new int[]{R.string.click_download, R.string.no_translation_smart_message_service_protocol}, new int[]{3, 2});
            }
            this.f29782r.setMovementMethod(new c());
        } else if (i10 == 1) {
            R1(I12);
            this.f29782r.setMovementMethod(new c());
        } else if (i10 != 11 && i10 != 13) {
            if (i10 == 12) {
                O1(new String[]{getString(R.string.txt_personal_information_collect_express_list), getString(R.string.business_functions), getString(R.string.purpose_collect), getString(R.string.way_collecting), getString(R.string.personal_information_collected), getString(R.string.personal_information_fields)}, I12);
            } else if (i10 == 14) {
                N1(I12, new int[]{R.string.no_translation_business_hall_personal_information_protection_policy}, new int[]{15});
                this.f29782r.setMovementMethod(new c());
            } else if (i10 == 15) {
                S1(I12);
                N1(I12, new int[]{R.string.click_download, R.string.no_translation_personal_information_protection_policy, R.string.no_translation_personal_information_collect_express_list, R.string.no_translation_personal_information_sharing_third_party_list}, new int[]{3, 16, 10, 11});
                this.f29782r.setMovementMethod(new c());
            } else if (i10 == 17) {
                if (StatementUtils.p(this)) {
                    iArr = new int[]{R.string.click_download, R.string.no_translation_personal_information_protection_policy, R.string.no_translation_personal_information_collect_express_list, R.string.no_translation_business_hall_personal_information_protection_policy_v2, R.string.no_translation_cloud_service_information_protection_policy, R.string.no_translation_heytap_account_personal_information_protection_policy};
                    iArr2 = new int[]{3, 16, 10, 15, 18, 19};
                } else {
                    iArr = new int[]{R.string.click_download, R.string.no_translation_personal_information_protection_policy, R.string.no_translation_business_hall_personal_information_protection_policy_v2, R.string.no_translation_cloud_service_information_protection_policy, R.string.no_translation_heytap_account_personal_information_protection_policy};
                    iArr2 = new int[]{3, 16, 15, 18, 19};
                }
                S1(I12);
                N1(I12, iArr, iArr2);
                this.f29782r.setMovementMethod(new c());
            }
        } else {
            if (i10 == 13) {
                strArr = new String[]{getString(R.string.txt_personal_information_sharing_third_party_list), getString(R.string.third_party_sdk_List), getString(R.string.sdk_name), getString(R.string.num_recognition_third_party_subject), getString(R.string.num_recognition_personal_information_third_collected), getString(R.string.third_party_call_permission), getString(R.string.num_recognition_processing_mode), getString(R.string.num_recognition_personal_information), getString(R.string.usage_scenario), getString(R.string.purpose_of_use), getString(R.string.num_recognition_third_party_official_website), getString(R.string.num_recognition_third_party_privacy_policy_link)};
            } else {
                strArr = new String[]{getString(R.string.txt_personal_information_sharing_third_party_list), getString(R.string.third_party_services_and_providers), getString(R.string.service_type), getString(R.string.third_party_subject), getString(R.string.personal_information_third_collected), getString(R.string.third_party_call_permission), getString(R.string.personal_information), getString(R.string.usage_scenario), getString(R.string.purpose_of_use), getString(R.string.processing_mode), getString(R.string.third_party_official_website), getString(R.string.third_party_privacy_policy_link)};
            }
            S1(I12);
            O1(strArr, I12);
            this.f29782r.setMovementMethod(new c());
        }
        this.f29782r.setText(I12);
    }

    public final d M1(int i10) {
        return new b(i10);
    }

    public final void N1(SpannableString spannableString, int[] iArr, int[] iArr2) {
        if (iArr == null || iArr.length == 0 || iArr2 == null || iArr2.length == 0 || iArr.length != iArr2.length) {
            return;
        }
        for (int i10 = 0; i10 < iArr2.length; i10++) {
            int i11 = iArr2[i10];
            String string = getString(iArr[i10]);
            int length = string.length();
            String spannableString2 = spannableString.toString();
            try {
                int indexOf = spannableString2.indexOf(string);
                if (i11 == 16 || i11 == -1) {
                    indexOf = spannableString2.lastIndexOf(string);
                }
                while (indexOf >= 0) {
                    spannableString.setSpan(M1(i11), indexOf, indexOf + length, 33);
                    indexOf = spannableString2.indexOf(string, indexOf + 1);
                    if (i11 == 3) {
                        break;
                    }
                }
            } catch (Throwable th) {
                H7.b.c("TedStatementActivity", "setDocUnderLine : " + th);
            }
        }
    }

    public final void O1(String[] strArr, SpannableString spannableString) {
        for (String str : strArr) {
            Matcher matcher = Pattern.compile(str).matcher(spannableString);
            while (matcher.find()) {
                try {
                    if (!str.equals(getString(R.string.third_party_services_and_providers)) && !str.equals(getString(R.string.third_party_sdk_List)) && !str.equals(getString(R.string.txt_personal_information_collect_express_list)) && !str.equals(getString(R.string.txt_personal_information_sharing_third_party_list))) {
                        spannableString.setSpan(new TextAppearanceSpan(this, R.style.NormalColorStyle), matcher.start(), matcher.end(), 33);
                    }
                    spannableString.setSpan(new TextAppearanceSpan(this, R.style.TitleColorStyle), matcher.start(), matcher.end(), 33);
                } catch (Exception e10) {
                    H7.b.c("TedStatementActivity", "setFontStyle : " + e10);
                }
            }
        }
    }

    public final boolean P1(String[] strArr) {
        if (strArr != null && strArr.length != 0) {
            SpannableString spannableString = new SpannableString(com.ted.number.b.b(r.a(strArr), 0, null, new CustomHTMLTagHandler(this, J1(this), new InterfaceC1637a() { // from class: g9.p
                @Override // v9.InterfaceC1637a
                public final Object invoke() {
                    String F12;
                    F12 = TedStatementActivity.this.F1();
                    return F12;
                }
            })));
            this.f29782r.setTextColor(getColor(R.color.coui_color_label_primary));
            this.f29782r.setText(spannableString);
            this.f29782r.setMovementMethod(new c());
            return true;
        }
        H7.b.c("TedStatementActivity", "setHTMLText: contentArr is empty");
        return false;
    }

    public final void R1(SpannableString spannableString) {
        if (FeatureOption.i()) {
            if (FeatureUtil.O()) {
                N1(spannableString, new int[]{R.string.no_translation_personal_information_sharing_third_party_list, R.string.number_recognition_protect_privacy_witch_bracket, R.string.privacy_download, R.string.no_translation_personal_information_collect_express_list}, new int[]{13, -1, 3, 12});
                return;
            } else {
                N1(spannableString, new int[]{R.string.click_download, R.string.no_translation_smart_message_service_protocol}, new int[]{3, 2});
                return;
            }
        }
        N1(spannableString, new int[]{R.string.no_translation_smart_message_service_protocol}, new int[]{2});
    }

    public final void S1(SpannableString spannableString) {
        Matcher matcher = f29779y.matcher(spannableString);
        while (matcher.find()) {
            try {
                spannableString.setSpan(new a(matcher.group()), matcher.start(), matcher.end(), 33);
            } catch (Exception unused) {
            }
        }
    }

    @Override // com.android.contacts.framework.baseui.activity.BasicActivity
    public void l0() {
        if (e.c(getIntent(), "from_car", false)) {
            setRequestedOrientation(0);
        } else {
            super.l0();
        }
    }

    @Override // com.ted.number.ui.TedBaseActivity, com.android.contacts.framework.baseui.activity.BasicActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.ted_common_activity_layout);
        b1((CoordinatorLayout) findViewById(R.id.coordinator));
        View inflate = getLayoutInflater().inflate(R.layout.ted_statement_content, (ViewGroup) null);
        this.f29782r = (TextView) inflate.findViewById(R.id.statement_text);
        this.f29783x = (COUIToolbar) findViewById(R.id.toolbar);
        this.f29780p = e.d(getIntent(), "source", 0);
        this.f29781q = e.d(getIntent(), "extra_from", 0);
        if (J1(this)) {
            r1();
        }
        int i10 = this.f29780p;
        if (i10 != 1 && i10 != 2 && i10 != 11 && i10 != 12 && i10 != 14 && i10 != 15 && i10 != 13 && i10 != 17) {
            if (i10 == 6 || i10 == 7 || i10 == 8 || i10 == 9) {
                this.f29783x.setTitle(R.string.user_protocol);
            }
        } else {
            this.f29783x.setTitle("");
        }
        setSupportActionBar(this.f29783x);
        if (getSupportActionBar() != null) {
            getSupportActionBar().t(true);
        }
        L1();
        t1((RecyclerView) findViewById(R.id.recyclerView), inflate);
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
        hashMap.put("enter_page", String.valueOf(this.f29780p));
        A.d(this, 200034402, hashMap);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        HashMap hashMap = new HashMap();
        hashMap.put("exit_page", String.valueOf(this.f29780p));
        A.d(this, 200034403, hashMap);
    }

    public final void z1() {
        if (!StatementUtils.p(this)) {
            com.oplus.foundation.util.ui.c.d(this, R.string.agree_user_notice_first);
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("download_service", E1());
        A.a(this, 2000323, 200035415, hashMap, false);
        DocumentHelper.f29569a.d(this, new InterfaceC1637a() { // from class: g9.q
            @Override // v9.InterfaceC1637a
            public final Object invoke() {
                String G12;
                G12 = TedStatementActivity.this.G1();
                return G12;
            }
        }, F1(), new p(this, J1(this)));
    }
}
