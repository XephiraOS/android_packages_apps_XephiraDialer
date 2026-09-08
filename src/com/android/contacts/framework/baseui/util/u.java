package com.android.contacts.framework.baseui.util;

import android.content.Context;
import android.text.SpannableString;
import android.view.View;
import com.coui.appcompat.clickablespan.COUIClickableSpan;
import kotlin.text.StringsKt__StringsKt;

/* compiled from: SpannableStringUtils.kt */
/* loaded from: classes.dex */
public final class u {

    /* renamed from: a */
    public static final u f15958a = new u();

    /* compiled from: SpannableStringUtils.kt */
    /* loaded from: classes.dex */
    public static final class a extends j {

        /* renamed from: c */
        public final /* synthetic */ Context f15959c;

        /* renamed from: d */
        public final /* synthetic */ COUIClickableSpan.SpannableStrClickListener f15960d;

        /* renamed from: e */
        public final /* synthetic */ boolean f15961e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(Context context, boolean z10, COUIClickableSpan.SpannableStrClickListener spannableStrClickListener, boolean z11) {
            super(context, z10);
            this.f15959c = context;
            this.f15960d = spannableStrClickListener;
            this.f15961e = z11;
        }

        @Override // com.coui.appcompat.statement.COUIStatementClickableSpan, android.text.style.ClickableSpan
        public void onClick(View widget) {
            kotlin.jvm.internal.i.f(widget, "widget");
            super.onClick(widget);
            COUIClickableSpan.SpannableStrClickListener spannableStrClickListener = this.f15960d;
            if (spannableStrClickListener != null) {
                spannableStrClickListener.onClick();
            } else {
                StatementUtils.B(this.f15959c, 1, this.f15961e, 0, 8, null);
            }
        }
    }

    /* compiled from: SpannableStringUtils.kt */
    /* loaded from: classes.dex */
    public static final class b extends j {

        /* renamed from: c */
        public final /* synthetic */ Context f15962c;

        /* renamed from: d */
        public final /* synthetic */ COUIClickableSpan.SpannableStrClickListener f15963d;

        /* renamed from: e */
        public final /* synthetic */ boolean f15964e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(Context context, boolean z10, COUIClickableSpan.SpannableStrClickListener spannableStrClickListener, boolean z11) {
            super(context, z10);
            this.f15962c = context;
            this.f15963d = spannableStrClickListener;
            this.f15964e = z11;
        }

        @Override // com.coui.appcompat.statement.COUIStatementClickableSpan, android.text.style.ClickableSpan
        public void onClick(View widget) {
            kotlin.jvm.internal.i.f(widget, "widget");
            super.onClick(widget);
            COUIClickableSpan.SpannableStrClickListener spannableStrClickListener = this.f15963d;
            if (spannableStrClickListener != null) {
                spannableStrClickListener.onClick();
            } else {
                StatementUtils.B(this.f15962c, 2, this.f15964e, 0, 8, null);
            }
        }
    }

    /* compiled from: SpannableStringUtils.kt */
    /* loaded from: classes.dex */
    public static final class c extends j {

        /* renamed from: c */
        public final /* synthetic */ Context f15965c;

        /* renamed from: d */
        public final /* synthetic */ COUIClickableSpan.SpannableStrClickListener f15966d;

        /* renamed from: e */
        public final /* synthetic */ boolean f15967e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(Context context, boolean z10, COUIClickableSpan.SpannableStrClickListener spannableStrClickListener, boolean z11) {
            super(context, z10);
            this.f15965c = context;
            this.f15966d = spannableStrClickListener;
            this.f15967e = z11;
        }

        @Override // com.coui.appcompat.statement.COUIStatementClickableSpan, android.text.style.ClickableSpan
        public void onClick(View widget) {
            kotlin.jvm.internal.i.f(widget, "widget");
            super.onClick(widget);
            COUIClickableSpan.SpannableStrClickListener spannableStrClickListener = this.f15966d;
            if (spannableStrClickListener != null) {
                spannableStrClickListener.onClick();
            } else {
                StatementUtils.B(this.f15965c, 13, this.f15967e, 0, 8, null);
            }
        }
    }

    /* compiled from: SpannableStringUtils.kt */
    /* loaded from: classes.dex */
    public static final class d extends j {

        /* renamed from: c */
        public final /* synthetic */ Context f15968c;

        /* renamed from: d */
        public final /* synthetic */ COUIClickableSpan.SpannableStrClickListener f15969d;

        /* renamed from: e */
        public final /* synthetic */ boolean f15970e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(Context context, boolean z10, COUIClickableSpan.SpannableStrClickListener spannableStrClickListener, boolean z11) {
            super(context, z10);
            this.f15968c = context;
            this.f15969d = spannableStrClickListener;
            this.f15970e = z11;
        }

        @Override // com.coui.appcompat.statement.COUIStatementClickableSpan, android.text.style.ClickableSpan
        public void onClick(View widget) {
            kotlin.jvm.internal.i.f(widget, "widget");
            super.onClick(widget);
            COUIClickableSpan.SpannableStrClickListener spannableStrClickListener = this.f15969d;
            if (spannableStrClickListener != null) {
                spannableStrClickListener.onClick();
            } else {
                StatementUtils.B(this.f15968c, 1, this.f15970e, 0, 8, null);
            }
        }
    }

    /* compiled from: SpannableStringUtils.kt */
    /* loaded from: classes.dex */
    public static final class e extends j {

        /* renamed from: c */
        public final /* synthetic */ Context f15971c;

        /* renamed from: d */
        public final /* synthetic */ COUIClickableSpan.SpannableStrClickListener f15972d;

        /* renamed from: e */
        public final /* synthetic */ boolean f15973e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(Context context, boolean z10, COUIClickableSpan.SpannableStrClickListener spannableStrClickListener, boolean z11) {
            super(context, z10);
            this.f15971c = context;
            this.f15972d = spannableStrClickListener;
            this.f15973e = z11;
        }

        @Override // com.coui.appcompat.statement.COUIStatementClickableSpan, android.text.style.ClickableSpan
        public void onClick(View widget) {
            kotlin.jvm.internal.i.f(widget, "widget");
            super.onClick(widget);
            COUIClickableSpan.SpannableStrClickListener spannableStrClickListener = this.f15972d;
            if (spannableStrClickListener != null) {
                spannableStrClickListener.onClick();
            } else {
                StatementUtils.B(this.f15971c, 2, this.f15973e, 0, 8, null);
            }
        }
    }

    /* compiled from: SpannableStringUtils.kt */
    /* loaded from: classes.dex */
    public static final class f extends j {

        /* renamed from: c */
        public final /* synthetic */ Context f15974c;

        /* renamed from: d */
        public final /* synthetic */ COUIClickableSpan.SpannableStrClickListener f15975d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(Context context, boolean z10, COUIClickableSpan.SpannableStrClickListener spannableStrClickListener) {
            super(context, z10);
            this.f15974c = context;
            this.f15975d = spannableStrClickListener;
        }

        @Override // com.coui.appcompat.statement.COUIStatementClickableSpan, android.text.style.ClickableSpan
        public void onClick(View widget) {
            kotlin.jvm.internal.i.f(widget, "widget");
            super.onClick(widget);
            COUIClickableSpan.SpannableStrClickListener spannableStrClickListener = this.f15975d;
            if (spannableStrClickListener != null) {
                spannableStrClickListener.onClick();
            } else {
                StatementUtils.B(this.f15974c, 17, false, 0, 8, null);
            }
        }
    }

    public static final SpannableString a(Context context, boolean z10, boolean z11, COUIClickableSpan.SpannableStrClickListener spannableStrClickListener, COUIClickableSpan.SpannableStrClickListener spannableStrClickListener2, COUIClickableSpan.SpannableStrClickListener spannableStrClickListener3) {
        int O10;
        int O11;
        int O12;
        kotlin.jvm.internal.i.f(context, "context");
        String string = context.getString(N0.k.f1974p);
        kotlin.jvm.internal.i.e(string, "context.getString(R.stri…cognition_user_agreement)");
        String string2 = context.getString(N0.k.f1973o);
        kotlin.jvm.internal.i.e(string2, "context.getString(R.stri…mation_protection_policy)");
        String string3 = context.getString(N0.k.f1979u);
        kotlin.jvm.internal.i.e(string3, "context.getString(R.stri…sharing_third_party_list)");
        String str = context.getString(N0.k.f1981w, string, string2, string3);
        kotlin.jvm.internal.i.e(str, "builder.toString()");
        SpannableString spannableString = new SpannableString(str);
        b bVar = new b(context, z10, spannableStrClickListener, z11);
        a aVar = new a(context, z10, spannableStrClickListener2, z11);
        c cVar = new c(context, z10, spannableStrClickListener3, z11);
        int length = string.length();
        O10 = StringsKt__StringsKt.O(str, string, 0, false, 6, null);
        spannableString.setSpan(bVar, O10, length + O10, 33);
        int length2 = string2.length();
        O11 = StringsKt__StringsKt.O(str, string2, 0, false, 6, null);
        spannableString.setSpan(aVar, O11, length2 + O11, 33);
        int length3 = string3.length();
        O12 = StringsKt__StringsKt.O(str, string3, 0, false, 6, null);
        spannableString.setSpan(cVar, O12, length3 + O12, 33);
        return spannableString;
    }

    public static /* synthetic */ SpannableString b(Context context, boolean z10, boolean z11, COUIClickableSpan.SpannableStrClickListener spannableStrClickListener, COUIClickableSpan.SpannableStrClickListener spannableStrClickListener2, COUIClickableSpan.SpannableStrClickListener spannableStrClickListener3, int i10, Object obj) {
        COUIClickableSpan.SpannableStrClickListener spannableStrClickListener4;
        COUIClickableSpan.SpannableStrClickListener spannableStrClickListener5;
        COUIClickableSpan.SpannableStrClickListener spannableStrClickListener6;
        if ((i10 & 2) != 0) {
            z10 = false;
        }
        boolean z12 = z10;
        if ((i10 & 8) != 0) {
            spannableStrClickListener4 = null;
        } else {
            spannableStrClickListener4 = spannableStrClickListener;
        }
        if ((i10 & 16) != 0) {
            spannableStrClickListener5 = null;
        } else {
            spannableStrClickListener5 = spannableStrClickListener2;
        }
        if ((i10 & 32) != 0) {
            spannableStrClickListener6 = null;
        } else {
            spannableStrClickListener6 = spannableStrClickListener3;
        }
        return a(context, z12, z11, spannableStrClickListener4, spannableStrClickListener5, spannableStrClickListener6);
    }

    public static final SpannableString c(Context context, boolean z10, boolean z11) {
        return e(context, z10, z11, null, null, 24, null);
    }

    public static final SpannableString d(Context context, boolean z10, boolean z11, COUIClickableSpan.SpannableStrClickListener spannableStrClickListener, COUIClickableSpan.SpannableStrClickListener spannableStrClickListener2) {
        int O10;
        int O11;
        if (context == null) {
            H7.b.b("SpannableStringUtils", "getStateColorClickableSpan context == null");
            return new SpannableString("");
        }
        String string = context.getString(N0.k.f1974p);
        kotlin.jvm.internal.i.e(string, "context.getString(R.stri…cognition_user_agreement)");
        String string2 = context.getString(N0.k.f1973o);
        kotlin.jvm.internal.i.e(string2, "context.getString(R.stri…mation_protection_policy)");
        String string3 = context.getString(N0.k.f1982x, string, string2);
        kotlin.jvm.internal.i.e(string3, "context.getString(R.stri…ceProtocol, secretPolicy)");
        SpannableString spannableString = new SpannableString(string3);
        d dVar = new d(context, z10, spannableStrClickListener2, z11);
        e eVar = new e(context, z10, spannableStrClickListener, z11);
        int length = string2.length();
        O10 = StringsKt__StringsKt.O(string3, string2, 0, false, 6, null);
        int length2 = string.length();
        O11 = StringsKt__StringsKt.O(string3, string, 0, false, 6, null);
        spannableString.setSpan(dVar, O10, length + O10, 33);
        spannableString.setSpan(eVar, O11, length2 + O11, 33);
        return spannableString;
    }

    public static /* synthetic */ SpannableString e(Context context, boolean z10, boolean z11, COUIClickableSpan.SpannableStrClickListener spannableStrClickListener, COUIClickableSpan.SpannableStrClickListener spannableStrClickListener2, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            z10 = false;
        }
        if ((i10 & 8) != 0) {
            spannableStrClickListener = null;
        }
        if ((i10 & 16) != 0) {
            spannableStrClickListener2 = null;
        }
        return d(context, z10, z11, spannableStrClickListener, spannableStrClickListener2);
    }

    public static final SpannableString f(Context context, boolean z10, COUIClickableSpan.SpannableStrClickListener spannableStrClickListener) {
        int O10;
        kotlin.jvm.internal.i.f(context, "context");
        String string = context.getString(N0.k.f1978t);
        kotlin.jvm.internal.i.e(string, "context.getString(R.stri…mation_protection_policy)");
        String string2 = context.getString(N0.k.f1980v, string);
        kotlin.jvm.internal.i.e(string2, "context.getString(R.stri…ails_1, protectionPolicy)");
        SpannableString spannableString = new SpannableString(string2);
        f fVar = new f(context, z10, spannableStrClickListener);
        int length = string.length();
        O10 = StringsKt__StringsKt.O(string2, string, 0, false, 6, null);
        spannableString.setSpan(fVar, O10, length + O10, 33);
        return spannableString;
    }

    public static /* synthetic */ SpannableString g(Context context, boolean z10, COUIClickableSpan.SpannableStrClickListener spannableStrClickListener, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            z10 = false;
        }
        if ((i10 & 4) != 0) {
            spannableStrClickListener = null;
        }
        return f(context, z10, spannableStrClickListener);
    }
}
