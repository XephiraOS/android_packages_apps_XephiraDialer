package com.customize.contacts.model;

import M7.b;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import androidx.lifecycle.C0490m;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.v;
import com.oplus.dialer.R;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.collections.o;
import kotlin.collections.p;
import kotlin.jvm.internal.i;
import kotlin.text.Regex;
import kotlin.text.n;
import kotlinx.coroutines.C1248i;
import kotlinx.coroutines.S;

/* compiled from: NewCallRepository.kt */
/* loaded from: classes3.dex */
public final class NewCallRepository {

    /* renamed from: e, reason: collision with root package name */
    public static final a f21724e = new a(null);

    /* renamed from: f, reason: collision with root package name */
    public static final Uri f21725f = Uri.parse("content://com.newcall.messagebox.provider/newcall_log/");

    /* renamed from: a, reason: collision with root package name */
    public Context f21726a;

    /* renamed from: b, reason: collision with root package name */
    public Lifecycle f21727b;

    /* renamed from: c, reason: collision with root package name */
    public ArrayList<String> f21728c;

    /* renamed from: d, reason: collision with root package name */
    public v<Boolean> f21729d;

    /* compiled from: NewCallRepository.kt */
    /* loaded from: classes3.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.f fVar) {
            this();
        }
    }

    public NewCallRepository(Context context, Lifecycle lifecycle) {
        i.f(lifecycle, "lifecycle");
        this.f21726a = context;
        this.f21727b = lifecycle;
        this.f21729d = new v<>();
    }

    public static final void i(Context it, String[] numbers, DialogInterface dialogInterface, int i10) {
        i.f(it, "$it");
        i.f(numbers, "$numbers");
        Intent intent = new Intent();
        intent.putExtra("number", numbers[i10]);
        intent.putExtra("timeStamp", -1);
        intent.setClassName("com.newcall", "com.newcall.messagebox.view.activity.MessageActivity");
        R7.b.f(it, intent, 0, null, 6, null);
    }

    public final void h(final String[] strArr, final Context context) {
        if (context != null) {
            U0.b bVar = new U0.b(context, 2132083073);
            bVar.setTitle(R.string.choose_phone_number);
            bVar.setItems((CharSequence[]) strArr, new DialogInterface.OnClickListener() { // from class: com.customize.contacts.model.f
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i10) {
                    NewCallRepository.i(context, strArr, dialogInterface, i10);
                }
            });
            bVar.setNegativeButton(android.R.string.cancel, (DialogInterface.OnClickListener) null);
            bVar.setWindowAnimStyle(2132082730);
            bVar.show();
        }
    }

    public final ArrayList<String> j(ArrayList<String> arrayList) {
        ArrayList<String> arrayList2;
        int p10;
        String t10;
        if (arrayList != null) {
            p10 = p.p(arrayList, 10);
            arrayList2 = new ArrayList<>(p10);
            Iterator<T> it = arrayList.iterator();
            while (it.hasNext()) {
                t10 = n.t(new Regex("\\s+").b((String) it.next(), ""), "+86", "", false, 4, null);
                arrayList2.add(t10);
            }
        } else {
            arrayList2 = null;
        }
        if (!(arrayList2 instanceof ArrayList)) {
            return null;
        }
        return arrayList2;
    }

    public final LiveData<Boolean> k() {
        return this.f21729d;
    }

    public final boolean l(Context context) {
        if (context == null || b.C0045b.a(2).f1798b.a(context.getContentResolver(), "isNewCallEnable", 0) != 1 || b.C0045b.a(2).f1798b.a(context.getContentResolver(), "force_data_channel_control", 0) != 1 || !P7.c.d(context, "com.newcall", true)) {
            return false;
        }
        return true;
    }

    public final void m(String number) {
        ArrayList<String> d10;
        i.f(number, "number");
        d10 = o.d(number);
        n(d10);
    }

    public final void n(ArrayList<String> arrayList) {
        Context context = this.f21726a;
        if (context != null) {
            C1248i.d(C0490m.a(this.f21727b), S.b(), null, new NewCallRepository$loadNewCallMessage$1$1(this, context, arrayList, null), 2, null);
        }
    }

    public final void o() {
        v<Boolean> vVar = this.f21729d;
        boolean z10 = false;
        if (this.f21728c != null && (!r3.isEmpty())) {
            z10 = true;
        }
        vVar.m(Boolean.valueOf(z10));
    }

    public final void p(Context context) {
        ArrayList<String> arrayList;
        if (l(context) && (arrayList = this.f21728c) != null) {
            if (arrayList.size() == 1) {
                if (context != null) {
                    Intent intent = new Intent();
                    intent.putExtra("number", arrayList.get(0));
                    intent.putExtra("timeStamp", -1);
                    intent.setClassName("com.newcall", "com.newcall.messagebox.view.activity.MessageActivity");
                    R7.b.f(context, intent, 0, null, 6, null);
                    return;
                }
                return;
            }
            h((String[]) arrayList.toArray(new String[0]), context);
        }
    }
}
