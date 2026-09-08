package com.ted.number;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.view.View;
import com.android.contacts.business.calllog.breenocall.BreenoCallContract;
import com.android.contacts.framework.baseui.activity.BasicActivity;
import com.android.contacts.framework.baseui.util.A;
import com.android.contacts.framework.baseui.util.StatementUtils;
import com.android.incallui.OplusAutoRedialNotificationUI;
import com.coui.appcompat.statement.COUIStatementClickableSpan;
import com.ted.number.CustomHTMLTagHandler;
import com.ted.number.b;
import java.util.HashMap;
import org.xml.sax.Attributes;
import v9.InterfaceC1637a;

/* compiled from: CustomHTMLTagHandler.kt */
/* loaded from: classes4.dex */
public final class CustomHTMLTagHandler implements b.c {

    /* renamed from: d, reason: collision with root package name */
    public static final a f29553d = new a(null);

    /* renamed from: a, reason: collision with root package name */
    public final BasicActivity f29554a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f29555b;

    /* renamed from: c, reason: collision with root package name */
    public final InterfaceC1637a<String> f29556c;

    /* compiled from: CustomHTMLTagHandler.kt */
    /* loaded from: classes4.dex */
    public static final class DownloadTag {

        /* renamed from: d, reason: collision with root package name */
        public static final Companion f29557d = new Companion(null);

        /* renamed from: a, reason: collision with root package name */
        public final int f29558a;

        /* renamed from: b, reason: collision with root package name */
        public final String f29559b;

        /* renamed from: c, reason: collision with root package name */
        public final String f29560c;

        /* compiled from: CustomHTMLTagHandler.kt */
        /* loaded from: classes4.dex */
        public static final class Companion {
            public Companion() {
            }

            public final void a(final BasicActivity context, SpannableStringBuilder spannable, final boolean z10, final InterfaceC1637a<String> getFileContentFunc) {
                kotlin.jvm.internal.i.f(context, "context");
                kotlin.jvm.internal.i.f(spannable, "spannable");
                kotlin.jvm.internal.i.f(getFileContentFunc, "getFileContentFunc");
                final DownloadTag downloadTag = (DownloadTag) b.a.n(spannable, DownloadTag.class);
                if (downloadTag != null) {
                    b.a.A(spannable, downloadTag, new COUIStatementClickableSpan(getFileContentFunc, z10, downloadTag) { // from class: com.ted.number.CustomHTMLTagHandler$DownloadTag$Companion$handleEndTag$1

                        /* renamed from: b, reason: collision with root package name */
                        public final /* synthetic */ InterfaceC1637a<String> f29562b;

                        /* renamed from: c, reason: collision with root package name */
                        public final /* synthetic */ boolean f29563c;

                        /* renamed from: d, reason: collision with root package name */
                        public final /* synthetic */ CustomHTMLTagHandler.DownloadTag f29564d;

                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(BasicActivity.this);
                            this.f29562b = getFileContentFunc;
                            this.f29563c = z10;
                            this.f29564d = downloadTag;
                        }

                        @Override // com.coui.appcompat.statement.COUIStatementClickableSpan, android.text.style.ClickableSpan
                        public void onClick(View widget) {
                            kotlin.jvm.internal.i.f(widget, "widget");
                            super.onClick(widget);
                            DocumentHelper documentHelper = DocumentHelper.f29569a;
                            Context applicationContext = BasicActivity.this.getApplicationContext();
                            kotlin.jvm.internal.i.e(applicationContext, "context.applicationContext");
                            final BasicActivity basicActivity = BasicActivity.this;
                            final CustomHTMLTagHandler.DownloadTag downloadTag2 = this.f29564d;
                            documentHelper.d(applicationContext, new InterfaceC1637a<String>() { // from class: com.ted.number.CustomHTMLTagHandler$DownloadTag$Companion$handleEndTag$1$onClick$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(0);
                                }

                                @Override // v9.InterfaceC1637a
                                public final String invoke() {
                                    return M7.a.g(BasicActivity.this, "com.ted.number", downloadTag2.b(), null, 8, null) + downloadTag2.a() + ".txt";
                                }
                            }, this.f29562b.invoke(), new p(BasicActivity.this, this.f29563c));
                            HashMap hashMap = new HashMap();
                            hashMap.put("download_service", String.valueOf(this.f29564d.c()));
                            A.a(BasicActivity.this, 2000323, 200035415, hashMap, false);
                        }
                    });
                }
            }

            public final void b(Attributes attributes, SpannableStringBuilder spannable) {
                Integer num;
                kotlin.jvm.internal.i.f(attributes, "attributes");
                kotlin.jvm.internal.i.f(spannable, "spannable");
                String value = attributes.getValue("", OplusAutoRedialNotificationUI.TYPE);
                if (value != null) {
                    num = kotlin.text.m.g(value);
                } else {
                    num = null;
                }
                String value2 = attributes.getValue("", BreenoCallContract.BaseColumns.DATE);
                String value3 = attributes.getValue("", "meta_res_title");
                if (num != null && value2 != null && value3 != null) {
                    b.a.B(spannable, new DownloadTag(num.intValue(), value2, value3));
                    return;
                }
                H7.b.c("CustomHTMLTagHandler", "handleStartTag download " + num + " " + value2 + " " + value3);
            }

            public /* synthetic */ Companion(kotlin.jvm.internal.f fVar) {
                this();
            }
        }

        public DownloadTag(int i10, String date, String metaResTitle) {
            kotlin.jvm.internal.i.f(date, "date");
            kotlin.jvm.internal.i.f(metaResTitle, "metaResTitle");
            this.f29558a = i10;
            this.f29559b = date;
            this.f29560c = metaResTitle;
        }

        public final String a() {
            return this.f29559b;
        }

        public final String b() {
            return this.f29560c;
        }

        public final int c() {
            return this.f29558a;
        }
    }

    /* compiled from: CustomHTMLTagHandler.kt */
    /* loaded from: classes4.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.f fVar) {
            this();
        }
    }

    /* compiled from: CustomHTMLTagHandler.kt */
    /* loaded from: classes4.dex */
    public static final class b {

        /* renamed from: b, reason: collision with root package name */
        public static final a f29565b = new a(null);

        /* renamed from: a, reason: collision with root package name */
        public final int f29566a;

        /* compiled from: CustomHTMLTagHandler.kt */
        /* loaded from: classes4.dex */
        public static final class a {

            /* compiled from: CustomHTMLTagHandler.kt */
            /* renamed from: com.ted.number.CustomHTMLTagHandler$b$a$a, reason: collision with other inner class name */
            /* loaded from: classes4.dex */
            public static final class C0281a extends COUIStatementClickableSpan {

                /* renamed from: a, reason: collision with root package name */
                public final /* synthetic */ Context f29567a;

                /* renamed from: b, reason: collision with root package name */
                public final /* synthetic */ b f29568b;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public C0281a(Context context, b bVar) {
                    super(context);
                    this.f29567a = context;
                    this.f29568b = bVar;
                }

                @Override // com.coui.appcompat.statement.COUIStatementClickableSpan, android.text.style.ClickableSpan
                public void onClick(View widget) {
                    kotlin.jvm.internal.i.f(widget, "widget");
                    super.onClick(widget);
                    StatementUtils.A(this.f29567a, this.f29568b.a(), false, 0);
                }
            }

            public a() {
            }

            public final void a(Context context, SpannableStringBuilder spannable) {
                Integer num;
                kotlin.jvm.internal.i.f(context, "context");
                kotlin.jvm.internal.i.f(spannable, "spannable");
                b bVar = (b) b.a.n(spannable, b.class);
                if (bVar != null) {
                    num = Integer.valueOf(bVar.a());
                } else {
                    num = null;
                }
                if (num != null) {
                    b.a.A(spannable, bVar, new C0281a(context, bVar));
                }
            }

            public final void b(Attributes attributes, SpannableStringBuilder spannable) {
                Integer num;
                kotlin.jvm.internal.i.f(attributes, "attributes");
                kotlin.jvm.internal.i.f(spannable, "spannable");
                String value = attributes.getValue("", "source");
                if (value != null) {
                    num = kotlin.text.m.g(value);
                } else {
                    num = null;
                }
                H7.b.e("CustomHTMLTagHandler", "handleStartTag statement sourceType = " + num);
                if (num != null) {
                    b.a.B(spannable, new b(num.intValue()));
                }
            }

            public /* synthetic */ a(kotlin.jvm.internal.f fVar) {
                this();
            }
        }

        public b(int i10) {
            this.f29566a = i10;
        }

        public final int a() {
            return this.f29566a;
        }
    }

    public CustomHTMLTagHandler(BasicActivity activity, boolean z10, InterfaceC1637a<String> getFileContentFunc) {
        kotlin.jvm.internal.i.f(activity, "activity");
        kotlin.jvm.internal.i.f(getFileContentFunc, "getFileContentFunc");
        this.f29554a = activity;
        this.f29555b = z10;
        this.f29556c = getFileContentFunc;
    }

    @Override // com.ted.number.b.c
    public void a(String tag, SpannableStringBuilder spannable) {
        boolean p10;
        boolean p11;
        kotlin.jvm.internal.i.f(tag, "tag");
        kotlin.jvm.internal.i.f(spannable, "spannable");
        p10 = kotlin.text.n.p("statement", tag, true);
        if (!p10) {
            p11 = kotlin.text.n.p("download", tag, true);
            if (p11) {
                DownloadTag.f29557d.a(this.f29554a, spannable, this.f29555b, this.f29556c);
                return;
            }
            return;
        }
        b.f29565b.a(this.f29554a, spannable);
    }

    @Override // com.ted.number.b.c
    public void b(String tag, SpannableStringBuilder spannable, Attributes attributes) {
        boolean p10;
        boolean p11;
        kotlin.jvm.internal.i.f(tag, "tag");
        kotlin.jvm.internal.i.f(spannable, "spannable");
        kotlin.jvm.internal.i.f(attributes, "attributes");
        p10 = kotlin.text.n.p("statement", tag, true);
        if (!p10) {
            p11 = kotlin.text.n.p("download", tag, true);
            if (p11) {
                DownloadTag.f29557d.b(attributes, spannable);
                return;
            }
            return;
        }
        b.f29565b.b(attributes, spannable);
    }
}
