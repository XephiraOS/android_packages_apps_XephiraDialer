package com.android.contacts.util;

import android.R;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.android.contacts.model.AccountType;
import com.android.contacts.model.AccountWithDataSet;
import com.android.contacts.vcard.ImportVCardActivity;
import com.coui.appcompat.dialog.COUIAlertDialogBuilder;
import java.util.List;
import n1.AbstractC1362a;

/* compiled from: AccountSelectionUtil.java */
/* renamed from: com.android.contacts.util.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0701b {

    /* renamed from: a, reason: collision with root package name */
    public static boolean f17557a = false;

    /* renamed from: b, reason: collision with root package name */
    public static Uri f17558b;

    /* compiled from: AccountSelectionUtil.java */
    /* renamed from: com.android.contacts.util.b$a */
    /* loaded from: classes.dex */
    public class a extends ArrayAdapter<AccountWithDataSet> {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LayoutInflater f17559a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ List f17560b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Context f17561c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ AbstractC1362a f17562d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(Context context, int i10, List list, LayoutInflater layoutInflater, List list2, Context context2, AbstractC1362a abstractC1362a) {
            super(context, i10, list);
            this.f17559a = layoutInflater;
            this.f17560b = list2;
            this.f17561c = context2;
            this.f17562d = abstractC1362a;
        }

        @Override // android.widget.ArrayAdapter, android.widget.Adapter
        public View getView(int i10, View view, ViewGroup viewGroup) {
            boolean z10 = false;
            if (view == null) {
                view = this.f17559a.inflate(R.layout.simple_list_item_2, viewGroup, false);
            }
            TextView textView = (TextView) view.findViewById(R.id.text1);
            TextView textView2 = (TextView) view.findViewById(R.id.text2);
            textView.setTextColor(getContext().getColor(com.oplus.dialer.R.color.coui_preference_title_color));
            textView2.setTextColor(getContext().getColor(com.oplus.dialer.R.color.coui_preference_secondary_text_color));
            List list = this.f17560b;
            if (list != null && list.size() > 1) {
                if (i10 == this.f17560b.size() - 1) {
                    z10 = true;
                }
                C0701b.f(this.f17561c, view, z10, textView, textView2);
            }
            AccountWithDataSet accountWithDataSet = (AccountWithDataSet) getItem(i10);
            AccountType c10 = this.f17562d.c(accountWithDataSet.f16942b, accountWithDataSet.f16970c);
            Context context = getContext();
            if (TextUtils.equals(R0.a.f3165a, accountWithDataSet.f16941a)) {
                textView.setText("oppo");
            } else {
                textView.setText(accountWithDataSet.f16941a);
            }
            textView2.setText(c10.f(context));
            return view;
        }
    }

    /* compiled from: AccountSelectionUtil.java */
    /* renamed from: com.android.contacts.util.b$b, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class DialogInterfaceOnCancelListenerC0174b implements DialogInterface.OnCancelListener {
        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            dialogInterface.dismiss();
        }
    }

    /* compiled from: AccountSelectionUtil.java */
    /* renamed from: com.android.contacts.util.b$c */
    /* loaded from: classes.dex */
    public static class c implements DialogInterface.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        public final List<AccountWithDataSet> f17563a;

        /* renamed from: b, reason: collision with root package name */
        public final Context f17564b;

        /* renamed from: c, reason: collision with root package name */
        public final int f17565c;

        public c(Context context, List<AccountWithDataSet> list, int i10) {
            if (list == null || list.size() == 0) {
                H7.b.c("AccountSelectionUtil", "The size of Account list is 0.");
            }
            this.f17564b = context;
            this.f17563a = list;
            this.f17565c = i10;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i10) {
            dialogInterface.dismiss();
            C0701b.b(this.f17564b, this.f17565c, this.f17563a.get(i10));
        }
    }

    public static void b(Context context, int i10, AccountWithDataSet accountWithDataSet) {
        switch (i10) {
            case com.oplus.dialer.R.string.import_from_sdcard /* 2132018410 */:
                c(context, accountWithDataSet);
                return;
            case com.oplus.dialer.R.string.import_from_sim /* 2132018411 */:
                d(context, accountWithDataSet);
                return;
            default:
                return;
        }
    }

    public static void c(Context context, AccountWithDataSet accountWithDataSet) {
        Intent intent = new Intent(context, (Class<?>) ImportVCardActivity.class);
        if (accountWithDataSet != null) {
            intent.putExtra("account_name", accountWithDataSet.f16941a);
            intent.putExtra("account_type", accountWithDataSet.f16942b);
            intent.putExtra("data_set", accountWithDataSet.f16970c);
        }
        if (f17557a) {
            intent.setAction("android.intent.action.VIEW");
            intent.setData(f17558b);
        }
        f17557a = false;
        f17558b = null;
        R7.b.c(context, intent);
    }

    public static void d(Context context, AccountWithDataSet accountWithDataSet) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setType("vnd.android.cursor.item/sim-contact");
        if (accountWithDataSet != null) {
            intent.putExtra("account_name", accountWithDataSet.f16941a);
            intent.putExtra("account_type", accountWithDataSet.f16942b);
            intent.putExtra("data_set", accountWithDataSet.f16970c);
        }
        intent.setClassName("com.android.phone", "com.android.phone.SimContacts");
        R7.b.c(context, intent);
    }

    public static Dialog e(Context context, int i10, DialogInterface.OnClickListener onClickListener, DialogInterface.OnCancelListener onCancelListener) {
        AbstractC1362a h10 = AbstractC1362a.h(context);
        List<AccountWithDataSet> g10 = h10.g(true);
        a aVar = new a(context, R.layout.simple_list_item_2, g10, (LayoutInflater) new ContextThemeWrapper(context, R.style.Theme.Light).getSystemService("layout_inflater"), g10, context, h10);
        if (onClickListener == null) {
            onClickListener = new c(context, g10, i10);
        }
        if (onCancelListener == null) {
            onCancelListener = new DialogInterfaceOnCancelListenerC0174b();
        }
        return new COUIAlertDialogBuilder(context).setTitle(com.oplus.dialer.R.string.dialog_create_contact_account).setSingleChoiceItems((ListAdapter) aVar, 0, onClickListener).setOnCancelListener(onCancelListener).show();
    }

    public static void f(Context context, View view, boolean z10, TextView textView, TextView textView2) {
        int i10;
        if (context != null && context.getResources() != null && view != null) {
            int dimensionPixelSize = context.getResources().getDimensionPixelSize(com.oplus.dialer.R.dimen.DP_30);
            if (z10) {
                i10 = context.getResources().getDimensionPixelSize(com.oplus.dialer.R.dimen.DP_22);
            } else {
                i10 = 0;
            }
            view.setPadding(dimensionPixelSize, 0, dimensionPixelSize, i10);
            if (textView != null && textView2 != null) {
                textView.setTextSize(0, context.getResources().getDimensionPixelSize(com.oplus.dialer.R.dimen.SP_16));
                textView2.setTextSize(0, context.getResources().getDimensionPixelSize(com.oplus.dialer.R.dimen.SP_12));
                textView.setTextAlignment(5);
                textView2.setTextAlignment(5);
            }
        }
    }
}
