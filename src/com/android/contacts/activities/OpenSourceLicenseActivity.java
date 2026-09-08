package com.android.contacts.activities;

import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.TextAppearanceSpan;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.android.contacts.activities.OpenSourceLicenseActivity;
import com.android.contacts.framework.baseui.activity.BasicActivity;
import com.android.contacts.framework.baseui.util.A;
import com.coui.appcompat.toolbar.COUIToolbar;
import com.oplus.dialer.R;
import com.ted.number.q;
import java.io.InputStream;
import kotlin.Result;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.i;

/* compiled from: OpenSourceLicenseActivity.kt */
/* loaded from: classes.dex */
public final class OpenSourceLicenseActivity extends BasicActivity {

    /* renamed from: o, reason: collision with root package name */
    public static final a f13640o = new a(null);

    /* compiled from: OpenSourceLicenseActivity.kt */
    /* loaded from: classes.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }
    }

    /* compiled from: OpenSourceLicenseActivity.kt */
    /* loaded from: classes.dex */
    public static final class b extends RecyclerView.Adapter<RecyclerView.B> {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f13641a;

        /* compiled from: OpenSourceLicenseActivity.kt */
        /* loaded from: classes.dex */
        public static final class a extends RecyclerView.B {
            public a(View view) {
                super(view);
            }
        }

        public b(View view) {
            this.f13641a = view;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return 1;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(RecyclerView.B holder, int i10) {
            i.f(holder, "holder");
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public RecyclerView.B onCreateViewHolder(ViewGroup parent, int i10) {
            i.f(parent, "parent");
            return new a(this.f13641a);
        }
    }

    public static final void r1(OpenSourceLicenseActivity this$0, View view) {
        i.f(this$0, "this$0");
        if (C7.a.a()) {
            return;
        }
        this$0.onBackPressed();
    }

    private final void t1(RecyclerView recyclerView, View view) {
        if (recyclerView != null && view != null) {
            b bVar = new b(view);
            recyclerView.setPadding(0, getResources().getDimensionPixelSize(R.dimen.large_toolbar_height) + getResources().getDimensionPixelSize(R.dimen.divider_background_height), 0, 0);
            recyclerView.setLayoutManager(new LinearLayoutManager(this));
            recyclerView.setAdapter(bVar);
            return;
        }
        H7.b.i("OpenSourceLicenseActivity", "setContentView  recyclerView or contentView is null; return");
    }

    @Override // com.android.contacts.framework.baseui.activity.BasicActivity
    public void B0() {
        COUIToolbar cOUIToolbar = (COUIToolbar) findViewById(R.id.toolbar);
        if (cOUIToolbar != null) {
            cOUIToolbar.setNavigationIcon(R.drawable.coui_back_arrow);
            cOUIToolbar.setNavigationContentDescription(R.string.abc_action_bar_up_description);
            cOUIToolbar.setTitle("");
            cOUIToolbar.setIsTitleCenterStyle(false);
            cOUIToolbar.setNavigationOnClickListener(new View.OnClickListener() { // from class: p0.k
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    OpenSourceLicenseActivity.r1(OpenSourceLicenseActivity.this, view);
                }
            });
        }
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        super.onBackPressed();
        A.b(this, "open_source_licenses_back");
    }

    @Override // com.android.contacts.framework.baseui.activity.BasicActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.open_source_statement_activity);
        View inflate = getLayoutInflater().inflate(R.layout.open_source_statement_view, (ViewGroup) null);
        View findViewById = inflate.findViewById(R.id.open_source_statement_text);
        i.d(findViewById, "null cannot be cast to non-null type android.widget.TextView");
        s1((TextView) findViewById);
        t1((RecyclerView) findViewById(R.id.recyclerView), inflate);
    }

    public final String q1() {
        String str;
        InputStream open = getResources().getAssets().open("open_source_statement_notice.html");
        i.e(open, "resources.assets.open(LICENSE_FILE_NAME)");
        try {
            byte[] bArr = new byte[open.available()];
            if (open.read(bArr) > 0) {
                str = new q(106, bArr).a();
            } else {
                str = "";
            }
            m9.q qVar = m9.q.f35511a;
            kotlin.io.a.a(open, null);
            return str;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                kotlin.io.a.a(open, th);
                throw th2;
            }
        }
    }

    public final void s1(TextView textView) {
        if (textView == null) {
            return;
        }
        SpannableString spannableString = new SpannableString(com.ted.number.b.a(q1(), 0));
        u1(spannableString);
        textView.setText(spannableString);
    }

    public final void u1(SpannableString spannableString) {
        Object b10;
        try {
            Result.a aVar = Result.f34166a;
            spannableString.setSpan(new TextAppearanceSpan(this, R.style.NormalColorStyle), 0, spannableString.length() - 1, 33);
            b10 = Result.b(m9.q.f35511a);
        } catch (Throwable th) {
            Result.a aVar2 = Result.f34166a;
            b10 = Result.b(kotlin.b.a(th));
        }
        Throwable d10 = Result.d(b10);
        if (d10 != null) {
            H7.b.c("OpenSourceLicenseActivity", "setNormalColorStyle e = " + d10);
        }
    }
}
