package com.customize.contacts.widget;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.android.contacts.framework.baseui.util.B;
import com.android.contacts.util.C;
import com.coui.appcompat.toolbar.COUIToolbar;
import com.customize.contacts.util.C0791b;
import com.oplus.dialer.R;
import com.oplus.foundation.appsupport.ui.widget.recyclerview.HeaderFooterRecyclerView;
import g9.C1056d;
import java.util.List;

/* compiled from: WindowDialogHelper.java */
/* loaded from: classes3.dex */
public class p implements DialogInterface.OnDismissListener, DialogInterface.OnCancelListener {

    /* renamed from: a, reason: collision with root package name */
    public boolean f22605a = false;

    /* renamed from: b, reason: collision with root package name */
    public f f22606b;

    /* renamed from: c, reason: collision with root package name */
    public androidx.appcompat.app.b f22607c;

    /* renamed from: d, reason: collision with root package name */
    public List<?> f22608d;

    /* renamed from: e, reason: collision with root package name */
    public String[] f22609e;

    /* renamed from: f, reason: collision with root package name */
    public int f22610f;

    /* renamed from: g, reason: collision with root package name */
    public a f22611g;

    /* renamed from: h, reason: collision with root package name */
    public Context f22612h;

    /* compiled from: WindowDialogHelper.java */
    /* loaded from: classes3.dex */
    public interface a {
        void a(Object obj);

        void b();

        void c();
    }

    public final f d(Context context, String str, int i10, boolean z10, int i11) {
        View inflate;
        final f fVar = new f(context, i10);
        View b10 = B.b(context, false);
        fVar.setContentView(b10);
        ViewGroup viewGroup = (ViewGroup) b10.getParent();
        if (i11 == 1) {
            inflate = LayoutInflater.from(context).inflate(R.layout.mark_dialog_content_view, viewGroup, false);
        } else {
            inflate = LayoutInflater.from(context).inflate(R.layout.account_select_content_view, viewGroup, false);
        }
        ((CoordinatorLayout) inflate.findViewById(R.id.coordinator)).setStatusBarBackgroundResource(2131231683);
        COUIToolbar cOUIToolbar = (COUIToolbar) inflate.findViewById(R.id.toolbar);
        cOUIToolbar.setTitle(str);
        cOUIToolbar.setIsTitleCenterStyle(z10);
        if (!z10) {
            cOUIToolbar.setNavigationIcon(R.drawable.coui_back_arrow);
            cOUIToolbar.setNavigationContentDescription(R.string.abc_action_bar_up_description);
            cOUIToolbar.setNavigationOnClickListener(new View.OnClickListener() { // from class: com.customize.contacts.widget.o
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    f.this.dismiss();
                }
            });
        } else {
            fVar.c(cOUIToolbar, R.menu.cancel_null_menu);
        }
        ViewGroup.LayoutParams layoutParams = inflate.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) layoutParams).topMargin = B.a(context);
        viewGroup.addView(inflate, 0, layoutParams);
        fVar.setOnDismissListener(this);
        fVar.setOnCancelListener(this);
        return fVar;
    }

    public final f e(String str, int i10) {
        final f d10 = d(this.f22612h, str, R.style.ActivityDialog, false, 1);
        C1056d c1056d = new C1056d(this.f22612h, i10, this.f22609e, this.f22611g, new C1056d.a() { // from class: com.customize.contacts.widget.n
            @Override // g9.C1056d.a
            public final void onClick(int i11) {
                p.this.i(d10, i11);
            }
        });
        HeaderFooterRecyclerView headerFooterRecyclerView = (HeaderFooterRecyclerView) d10.findViewById(R.id.recycle_view);
        Context context = this.f22612h;
        C.c(context, headerFooterRecyclerView, context.getResources().getDimensionPixelSize(R.dimen.DP_30));
        if (headerFooterRecyclerView != null) {
            headerFooterRecyclerView.setLayoutManager(new LinearLayoutManager(this.f22612h));
            headerFooterRecyclerView.setAdapter(c1056d);
            headerFooterRecyclerView.setNestedScrollingEnabled(true);
        }
        this.f22606b = d10;
        return d10;
    }

    public final f f(String str, C0791b c0791b, int i10) {
        final f d10 = d(this.f22612h, str, i10, true, 2);
        HeaderFooterRecyclerView headerFooterRecyclerView = (HeaderFooterRecyclerView) d10.findViewById(R.id.account_list);
        Context context = this.f22612h;
        C.c(context, headerFooterRecyclerView, context.getResources().getDimensionPixelSize(R.dimen.DP_30));
        if (headerFooterRecyclerView != null) {
            headerFooterRecyclerView.setLayoutManager(new LinearLayoutManager(this.f22612h));
            headerFooterRecyclerView.setAdapter(c0791b);
            headerFooterRecyclerView.setNestedScrollingEnabled(true);
            TextView textView = (TextView) LayoutInflater.from(this.f22612h).inflate(R.layout.account_select_view_header, (ViewGroup) null, false);
            textView.setText(R.string.oplus_select_group_summary);
            headerFooterRecyclerView.x(textView);
        }
        c0791b.i(new C0791b.a() { // from class: com.customize.contacts.widget.m
            @Override // com.customize.contacts.util.C0791b.a
            public final void onClick(int i11) {
                p.this.j(d10, i11);
            }
        });
        this.f22606b = d10;
        return d10;
    }

    public void g() {
        f fVar = this.f22606b;
        if (fVar != null && fVar.isShowing()) {
            this.f22606b.dismiss();
        }
    }

    public final /* synthetic */ void i(f fVar, int i10) {
        this.f22605a = true;
        if (this.f22609e.length - 1 != i10) {
            fVar.dismiss();
        }
    }

    public final /* synthetic */ void j(f fVar, int i10) {
        this.f22605a = true;
        fVar.dismiss();
    }

    public void k(boolean z10) {
        this.f22605a = z10;
    }

    public void l(androidx.appcompat.app.b bVar) {
        this.f22607c = bVar;
    }

    public void m(Context context, String str, C0791b c0791b, int i10, a aVar, int i11) {
        this.f22612h = context;
        this.f22610f = i10;
        this.f22611g = aVar;
        f(str, c0791b, i11).show();
    }

    public void n(Context context, String str, List<?> list, int i10, int i11, a aVar) {
        this.f22612h = context;
        this.f22608d = list;
        this.f22610f = i11;
        this.f22611g = aVar;
        int size = list.size();
        if (size < 1) {
            H7.b.c("WindowDialogHelper", "len is zero, error!");
            return;
        }
        this.f22609e = new String[size];
        for (int i12 = 0; i12 < size; i12++) {
            this.f22609e[i12] = (String) this.f22608d.get(i12);
        }
        e(str, i10).show();
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        dialogInterface.dismiss();
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        Activity activity = (Activity) this.f22612h;
        if (!this.f22605a) {
            this.f22611g.b();
        }
        this.f22608d = null;
        this.f22609e = null;
        this.f22611g = null;
        this.f22612h = null;
        this.f22606b = null;
        androidx.appcompat.app.b bVar = this.f22607c;
        if (bVar != null && bVar.isShowing()) {
            this.f22607c.dismiss();
        }
        if (42 == this.f22610f && activity != null) {
            activity.finish();
        }
    }
}
