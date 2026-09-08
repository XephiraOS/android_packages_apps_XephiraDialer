package com.ted.number.protection;

import B3.a;
import android.content.Context;
import android.text.SpannableString;
import android.view.View;
import com.android.contacts.framework.baseui.util.NumberIdentifyUtils;
import com.android.contacts.framework.baseui.util.StatementUtils;
import com.android.contacts.framework.baseui.util.j;
import com.customize.contacts.FeatureOption;
import com.oplus.dialer.R;
import kotlin.jvm.internal.i;
import kotlin.text.StringsKt__StringsKt;
import m9.d;
import v9.InterfaceC1637a;

/* compiled from: RevokeStatusSource.kt */
/* loaded from: classes4.dex */
public final class RevokeStatusSource {

    /* renamed from: a, reason: collision with root package name */
    public final d f29689a;

    /* compiled from: RevokeStatusSource.kt */
    /* loaded from: classes4.dex */
    public static final class a extends j {

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Context f29690c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(Context context) {
            super(context, false);
            this.f29690c = context;
        }

        @Override // com.coui.appcompat.statement.COUIStatementClickableSpan, android.text.style.ClickableSpan
        public void onClick(View widget) {
            i.f(widget, "widget");
            super.onClick(widget);
            StatementUtils.B(this.f29690c, 1, false, 0, 8, null);
        }
    }

    /* compiled from: RevokeStatusSource.kt */
    /* loaded from: classes4.dex */
    public static final class b extends j {

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Context f29691c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(Context context) {
            super(context, false);
            this.f29691c = context;
        }

        @Override // com.coui.appcompat.statement.COUIStatementClickableSpan, android.text.style.ClickableSpan
        public void onClick(View widget) {
            i.f(widget, "widget");
            super.onClick(widget);
            StatementUtils.B(this.f29691c, 2, false, 0, 8, null);
        }
    }

    public RevokeStatusSource() {
        d b10;
        b10 = kotlin.a.b(new InterfaceC1637a<Boolean>() { // from class: com.ted.number.protection.RevokeStatusSource$isPersonalProtectionRevokeSupport$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // v9.InterfaceC1637a
            public final Boolean invoke() {
                return Boolean.valueOf(FeatureOption.i() && a.u());
            }
        });
        this.f29689a = b10;
    }

    public SpannableString a(Context context) {
        int O10;
        int O11;
        i.f(context, "context");
        String string = context.getString(R.string.number_recognition_personal_information_protection_policy);
        i.e(string, "context.getString(R.stri…mation_protection_policy)");
        String string2 = context.getString(R.string.number_recognition_user_agreement);
        i.e(string2, "context.getString(R.stri…cognition_user_agreement)");
        String str = context.getString(R.string.refer_to_details_two_arg, string2, string);
        i.e(str, "builder.toString()");
        SpannableString spannableString = new SpannableString(str);
        a aVar = new a(context);
        b bVar = new b(context);
        int length = string.length();
        O10 = StringsKt__StringsKt.O(str, string, 0, false, 6, null);
        int length2 = string2.length();
        O11 = StringsKt__StringsKt.O(str, string2, 0, false, 6, null);
        spannableString.setSpan(aVar, O10, length + O10, 33);
        spannableString.setSpan(bVar, O11, length2 + O11, 33);
        return spannableString;
    }

    public CharSequence b(Context context) {
        i.f(context, "context");
        String string = context.getString(R.string.description_revoke_personal_information_protection_policy_v2);
        i.e(string, "context.getString(R.stri…ion_protection_policy_v2)");
        return string;
    }

    public boolean c() {
        return e();
    }

    public boolean d() {
        P7.a aVar = P7.a.f2961a;
        if (NumberIdentifyUtils.f(aVar.a()) != 0 && !NumberIdentifyUtils.e(aVar.a())) {
            return false;
        }
        return true;
    }

    public final boolean e() {
        return ((Boolean) this.f29689a.getValue()).booleanValue();
    }

    public void f() {
        NumberIdentifyUtils.r(P7.a.f2961a.a(), false);
        NumberIdentifyUtils.s();
    }
}
