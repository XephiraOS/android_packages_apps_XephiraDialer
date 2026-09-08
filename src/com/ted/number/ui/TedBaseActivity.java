package com.ted.number.ui;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowInsetsController;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.X;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.android.contacts.framework.baseui.activity.BasicActivity;
import com.coui.appcompat.toolbar.COUIToolbar;
import com.oplus.dialer.R;

/* loaded from: classes4.dex */
public class TedBaseActivity extends BasicActivity {

    /* renamed from: o, reason: collision with root package name */
    public String f29760o = "TedBaseActivityds";

    /* loaded from: classes4.dex */
    public static class b extends LinearLayoutManager {
        public b(Context context) {
            super(context);
        }

        @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.o
        public RecyclerView.LayoutParams generateDefaultLayoutParams() {
            return new RecyclerView.LayoutParams(-1, -2);
        }
    }

    @Override // com.android.contacts.framework.baseui.activity.BasicActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    public void p1(Activity activity, androidx.appcompat.app.b bVar) {
        if (!activity.isFinishing() && !activity.isDestroyed() && bVar != null && bVar.isShowing()) {
            bVar.dismiss();
        }
    }

    public void q1(Activity activity, DialogInterface dialogInterface) {
        if (dialogInterface != null && activity != null && !activity.isDestroyed() && !activity.isFinishing()) {
            dialogInterface.dismiss();
        }
    }

    public void r1() {
        WindowInsetsController windowInsetsController = getWindow().getDecorView().getWindowInsetsController();
        if (windowInsetsController != null) {
            windowInsetsController.hide(X.k.d());
        }
    }

    public void s1(Activity activity, int i10) {
        if (activity == null) {
            return;
        }
        if (activity instanceof AppCompatActivity) {
            COUIToolbar cOUIToolbar = (COUIToolbar) activity.findViewById(R.id.toolbar);
            if (cOUIToolbar != null) {
                cOUIToolbar.setTitle(i10);
                AppCompatActivity appCompatActivity = (AppCompatActivity) activity;
                appCompatActivity.setSupportActionBar(cOUIToolbar);
                ActionBar supportActionBar = appCompatActivity.getSupportActionBar();
                if (supportActionBar != null) {
                    supportActionBar.t(true);
                    return;
                }
                return;
            }
            return;
        }
        COUIToolbar cOUIToolbar2 = (COUIToolbar) activity.findViewById(R.id.toolbar);
        if (cOUIToolbar2 != null) {
            cOUIToolbar2.setTitle(i10);
            android.app.ActionBar actionBar = activity.getActionBar();
            if (actionBar != null) {
                actionBar.setDisplayHomeAsUpEnabled(true);
            }
        }
    }

    public void t1(RecyclerView recyclerView, View view) {
        if (recyclerView != null && view != null) {
            a aVar = new a(view);
            recyclerView.setPadding(0, getResources().getDimensionPixelSize(R.dimen.large_toolbar_height) + getResources().getDimensionPixelSize(R.dimen.divider_background_height), 0, 0);
            recyclerView.setLayoutManager(new b(this));
            recyclerView.setAdapter(aVar);
            return;
        }
        H7.b.i(this.f29760o, "setContentView  recyclerView or contentView is null; return");
    }

    public void u1(Activity activity, androidx.appcompat.app.b bVar) {
        if (bVar != null && activity != null && !bVar.isShowing() && !activity.isDestroyed() && !activity.isFinishing()) {
            bVar.show();
        }
    }

    /* loaded from: classes4.dex */
    public class a extends RecyclerView.Adapter {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f29761a;

        /* renamed from: com.ted.number.ui.TedBaseActivity$a$a, reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class C0286a extends RecyclerView.B {
            public C0286a(View view) {
                super(view);
            }
        }

        public a(View view) {
            this.f29761a = view;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return 1;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public RecyclerView.B onCreateViewHolder(ViewGroup viewGroup, int i10) {
            return new C0286a(this.f29761a);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(RecyclerView.B b10, int i10) {
        }
    }
}
