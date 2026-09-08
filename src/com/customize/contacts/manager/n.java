package com.customize.contacts.manager;

import S3.c;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Rect;
import android.net.Uri;
import android.os.AsyncTask;
import android.provider.ContactsContract;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.PopupWindow;
import androidx.fragment.app.Fragment;
import com.android.contacts.ContactLoader;
import com.android.contacts.framework.baseui.util.C0637b;
import com.android.contacts.framework.baseui.util.E;
import com.coui.appcompat.dialog.COUIAlertDialogBuilder;
import com.coui.appcompat.poplist.COUIPopupListWindow;
import com.coui.appcompat.poplist.COUISubMenuClickListener;
import com.coui.appcompat.poplist.PopupListItem;
import com.coui.appcompat.uiutil.UIUtil;
import com.customize.contacts.FeatureOption;
import com.customize.contacts.activities.ContactsTabActivity;
import com.customize.contacts.feature.OSPublicFeature;
import com.customize.contacts.manager.n;
import com.customize.contacts.util.BlackListUtils;
import com.customize.contacts.util.C0798i;
import com.customize.contacts.util.ContactDataUtils;
import com.customize.contacts.util.c0;
import com.oplus.dialer.R;
import com.oplus.foundation.util.feature.CommonFeatureOption;
import com.oplus.foundation.util.systemcore.PrimaryUserUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ThreadPoolExecutor;
import n1.AbstractC1362a;
import r0.C1501d;

/* compiled from: ListItemLongClickManager.java */
/* loaded from: classes3.dex */
public class n {

    /* renamed from: a, reason: collision with root package name */
    public static ThreadPoolExecutor f21567a = N7.a.b();

    /* compiled from: ListItemLongClickManager.java */
    /* loaded from: classes3.dex */
    public class a implements PopupWindow.OnDismissListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ COUIPopupListWindow f21568a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ i f21569b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Context f21570c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ boolean f21571d;

        public a(COUIPopupListWindow cOUIPopupListWindow, i iVar, Context context, boolean z10) {
            this.f21568a = cOUIPopupListWindow;
            this.f21569b = iVar;
            this.f21570c = context;
            this.f21571d = z10;
        }

        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            this.f21568a.setOnDismissListener(null);
            E.a(this.f21569b.f21592a);
            ViewGroup viewGroup = this.f21569b.f21606o;
            if (viewGroup != null) {
                viewGroup.requestDisallowInterceptTouchEvent(false);
            }
            n.x(this.f21570c, true, this.f21571d);
        }
    }

    /* compiled from: ListItemLongClickManager.java */
    /* loaded from: classes3.dex */
    public class b implements AdapterView.OnItemClickListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ List f21572a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ COUIPopupListWindow f21573b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ h f21574c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ HashMap f21575d;

        /* renamed from: e, reason: collision with root package name */
        public final /* synthetic */ ArrayList f21576e;

        /* renamed from: f, reason: collision with root package name */
        public final /* synthetic */ int f21577f;

        /* renamed from: g, reason: collision with root package name */
        public final /* synthetic */ i f21578g;

        /* renamed from: h, reason: collision with root package name */
        public final /* synthetic */ Context f21579h;

        /* renamed from: i, reason: collision with root package name */
        public final /* synthetic */ boolean f21580i;

        public b(List list, COUIPopupListWindow cOUIPopupListWindow, h hVar, HashMap hashMap, ArrayList arrayList, int i10, i iVar, Context context, boolean z10) {
            this.f21572a = list;
            this.f21573b = cOUIPopupListWindow;
            this.f21574c = hVar;
            this.f21575d = hashMap;
            this.f21576e = arrayList;
            this.f21577f = i10;
            this.f21578g = iVar;
            this.f21579h = context;
            this.f21580i = z10;
        }

        public static /* synthetic */ void k(Context context, i iVar) {
            N3.b.i(context.getApplicationContext(), iVar.f21593b, iVar.f21594c);
        }

        public static /* synthetic */ void n(Context context, i iVar) {
            com.android.contacts.util.B.a(context, iVar.f21595d, String.valueOf(iVar.f21593b), null);
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i10, long j10) {
            PopupListItem popupListItem = (PopupListItem) this.f21572a.get(i10);
            if (this.f21573b.isShowing() && popupListItem != null && !popupListItem.hasSubMenu()) {
                this.f21573b.dismiss();
                h hVar = this.f21574c;
                if (hVar != null) {
                    hVar.a();
                }
            }
            int intValue = ((Integer) this.f21575d.get(this.f21576e.get(i10))).intValue();
            int i11 = this.f21577f;
            if (1 == i11) {
                if (7 == intValue) {
                    intValue = 6;
                }
            } else if (2 == i11 && 6 == intValue) {
                intValue = 7;
            }
            switch (intValue) {
                case 2:
                    final Context context = this.f21579h;
                    final i iVar = this.f21578g;
                    final boolean z10 = this.f21580i;
                    com.android.contacts.framework.api.appstore.appinfo.a.a(context, new Runnable() { // from class: com.customize.contacts.manager.q
                        @Override // java.lang.Runnable
                        public final void run() {
                            n.i(context, iVar, z10);
                        }
                    });
                    return;
                case 3:
                    n.C(this.f21579h, this.f21578g, this.f21580i);
                    return;
                case 4:
                    ArrayList<String> arrayList = this.f21578g.f21598g;
                    if (arrayList != null && arrayList.size() > 0) {
                        final Context context2 = this.f21579h;
                        final i iVar2 = this.f21578g;
                        final boolean z11 = this.f21580i;
                        com.android.contacts.framework.api.appstore.appinfo.a.a(context2, new Runnable() { // from class: com.customize.contacts.manager.o
                            @Override // java.lang.Runnable
                            public final void run() {
                                n.m(context2, iVar2, z11);
                            }
                        });
                        return;
                    }
                    com.oplus.foundation.util.ui.c.b(this.f21579h, R.string.oplus_no_phonenumber_tips);
                    return;
                case 5:
                    final Context context3 = this.f21579h;
                    final i iVar3 = this.f21578g;
                    final boolean z12 = this.f21580i;
                    com.android.contacts.framework.api.appstore.appinfo.a.a(context3, new Runnable() { // from class: com.customize.contacts.manager.p
                        @Override // java.lang.Runnable
                        public final void run() {
                            n.j(context3, iVar3, z12);
                        }
                    });
                    return;
                case 6:
                    n.A(this.f21579h, this.f21578g, this.f21580i);
                    return;
                case 7:
                    ThreadPoolExecutor threadPoolExecutor = n.f21567a;
                    final Context context4 = this.f21579h;
                    final i iVar4 = this.f21578g;
                    threadPoolExecutor.execute(new Runnable() { // from class: com.customize.contacts.manager.r
                        @Override // java.lang.Runnable
                        public final void run() {
                            n.b.k(context4, iVar4);
                        }
                    });
                    return;
                case 8:
                    ThreadPoolExecutor threadPoolExecutor2 = n.f21567a;
                    final Context context5 = this.f21579h;
                    final i iVar5 = this.f21578g;
                    threadPoolExecutor2.execute(new Runnable() { // from class: com.customize.contacts.manager.s
                        @Override // java.lang.Runnable
                        public final void run() {
                            n.g(context5, iVar5, true);
                        }
                    });
                    return;
                case 9:
                    ThreadPoolExecutor threadPoolExecutor3 = n.f21567a;
                    final Context context6 = this.f21579h;
                    final i iVar6 = this.f21578g;
                    threadPoolExecutor3.execute(new Runnable() { // from class: com.customize.contacts.manager.t
                        @Override // java.lang.Runnable
                        public final void run() {
                            n.g(context6, iVar6, false);
                        }
                    });
                    return;
                case 10:
                    ThreadPoolExecutor threadPoolExecutor4 = n.f21567a;
                    final Context context7 = this.f21579h;
                    final i iVar7 = this.f21578g;
                    threadPoolExecutor4.execute(new Runnable() { // from class: com.customize.contacts.manager.u
                        @Override // java.lang.Runnable
                        public final void run() {
                            n.b.n(context7, iVar7);
                        }
                    });
                    return;
                default:
                    return;
            }
        }
    }

    /* compiled from: ListItemLongClickManager.java */
    /* loaded from: classes3.dex */
    public class c implements c.b {

        /* renamed from: a, reason: collision with root package name */
        public boolean f21581a = true;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Context f21582b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ i f21583c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ int f21584d;

        /* renamed from: e, reason: collision with root package name */
        public final /* synthetic */ S3.n f21585e;

        public c(Context context, i iVar, int i10, S3.n nVar) {
            this.f21582b = context;
            this.f21583c = iVar;
            this.f21584d = i10;
            this.f21585e = nVar;
        }

        @Override // S3.c.b
        public void a(ContactLoader.Result result) {
            if (this.f21581a) {
                n.v(this.f21582b, this.f21583c, this.f21584d, this.f21585e);
                this.f21581a = false;
            }
        }

        @Override // S3.c.b
        public void onError(String str) {
            H7.b.c("ListItemLongClickManager", str);
        }
    }

    /* compiled from: ListItemLongClickManager.java */
    /* loaded from: classes3.dex */
    public class d implements DialogInterface.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f21586a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ i f21587b;

        public d(Context context, i iVar) {
            this.f21586a = context;
            this.f21587b = iVar;
        }

        public static /* synthetic */ void b(Context context, i iVar) {
            N3.b.b(context.getApplicationContext(), iVar.f21593b, iVar.f21600i, iVar.f21598g);
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i10) {
            dialogInterface.dismiss();
            ThreadPoolExecutor threadPoolExecutor = n.f21567a;
            final Context context = this.f21586a;
            final i iVar = this.f21587b;
            threadPoolExecutor.execute(new Runnable() { // from class: com.customize.contacts.manager.v
                @Override // java.lang.Runnable
                public final void run() {
                    n.d.b(context, iVar);
                }
            });
        }
    }

    /* compiled from: ListItemLongClickManager.java */
    /* loaded from: classes3.dex */
    public class e implements DialogInterface.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f21588a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ i f21589b;

        public e(Context context, i iVar) {
            this.f21588a = context;
            this.f21589b = iVar;
        }

        public static /* synthetic */ void b(Context context, i iVar) {
            N3.b.q(context.getApplicationContext(), iVar.f21593b, iVar.f21598g);
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i10) {
            dialogInterface.dismiss();
            ThreadPoolExecutor threadPoolExecutor = n.f21567a;
            final Context context = this.f21588a;
            final i iVar = this.f21589b;
            threadPoolExecutor.execute(new Runnable() { // from class: com.customize.contacts.manager.w
                @Override // java.lang.Runnable
                public final void run() {
                    n.e.b(context, iVar);
                }
            });
        }
    }

    /* compiled from: ListItemLongClickManager.java */
    /* loaded from: classes3.dex */
    public class f implements DialogInterface.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f21590a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ i f21591b;

        public f(Context context, i iVar) {
            this.f21590a = context;
            this.f21591b = iVar;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i10) {
            dialogInterface.dismiss();
            Object[] objArr = 0;
            j jVar = new j();
            jVar.f21609c = this.f21590a.getApplicationContext();
            i iVar = this.f21591b;
            jVar.f21610d = iVar.f21593b;
            jVar.f21607a = true;
            if (iVar.f21603l) {
                jVar.f21607a = false;
                jVar.f21608b = true;
            } else if (TextUtils.equals(iVar.f21597f, "com.android.oplus.sim")) {
                jVar.f21607a = true;
            } else {
                jVar.f21607a = false;
                jVar.f21608b = false;
            }
            new g().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, jVar);
        }
    }

    /* compiled from: ListItemLongClickManager.java */
    /* loaded from: classes3.dex */
    public static class g extends AsyncTask<j, Void, j> {
        @Override // android.os.AsyncTask
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public j doInBackground(j... jVarArr) {
            boolean z10 = false;
            j jVar = jVarArr[0];
            if (jVar.f21607a && FeatureOption.k()) {
                jVar.f21611e = c0.c(jVar.f21609c, jVar.f21610d, "mainLongClick");
            } else {
                if (c0.f(jVar.f21609c, String.valueOf(jVar.f21610d), null, jVar.f21608b, "mainLongClick") > 0) {
                    z10 = true;
                }
                jVar.f21611e = z10;
            }
            return jVar;
        }

        @Override // android.os.AsyncTask
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(j jVar) {
            super.onPostExecute(jVar);
            B3.c.d().h();
            C0798i.b(jVar.f21609c);
            Intent intent = new Intent("oplus.intent.action.DELETE_CONTACT_COMPLET");
            X.a b10 = X.a.b(jVar.f21609c);
            b10.d(intent);
            intent.setAction("com.oplus.contacts.force_refresh_calllog");
            b10.d(intent);
        }

        public g() {
        }
    }

    /* compiled from: ListItemLongClickManager.java */
    /* loaded from: classes3.dex */
    public interface h {
        void a();
    }

    /* compiled from: ListItemLongClickManager.java */
    /* loaded from: classes3.dex */
    public static class i {

        /* renamed from: a, reason: collision with root package name */
        public View f21592a;

        /* renamed from: b, reason: collision with root package name */
        public long f21593b;

        /* renamed from: c, reason: collision with root package name */
        public long f21594c;

        /* renamed from: d, reason: collision with root package name */
        public String f21595d;

        /* renamed from: e, reason: collision with root package name */
        public String f21596e;

        /* renamed from: f, reason: collision with root package name */
        public String f21597f;

        /* renamed from: g, reason: collision with root package name */
        public ArrayList<String> f21598g;

        /* renamed from: h, reason: collision with root package name */
        public ArrayList<String> f21599h;

        /* renamed from: i, reason: collision with root package name */
        public boolean f21600i;

        /* renamed from: j, reason: collision with root package name */
        public boolean f21601j;

        /* renamed from: k, reason: collision with root package name */
        public boolean f21602k;

        /* renamed from: l, reason: collision with root package name */
        public boolean f21603l;

        /* renamed from: m, reason: collision with root package name */
        public int f21604m;

        /* renamed from: n, reason: collision with root package name */
        public int f21605n;

        /* renamed from: o, reason: collision with root package name */
        public ViewGroup f21606o;

        public i(ViewGroup viewGroup, View view, long j10, long j11, String str, String str2, String str3, ArrayList<String> arrayList, ArrayList<String> arrayList2, boolean z10, boolean z11, boolean z12, boolean z13, int i10, int i11) {
            this.f21606o = viewGroup;
            this.f21592a = view;
            this.f21593b = j10;
            this.f21594c = j11;
            this.f21595d = str;
            this.f21596e = str2;
            this.f21597f = str3;
            this.f21598g = arrayList;
            this.f21599h = arrayList2;
            this.f21600i = z10;
            this.f21601j = z11;
            this.f21602k = z12;
            this.f21603l = z13;
            this.f21604m = i10;
            this.f21605n = i11;
        }
    }

    /* compiled from: ListItemLongClickManager.java */
    /* loaded from: classes3.dex */
    public static class j {

        /* renamed from: a, reason: collision with root package name */
        public boolean f21607a;

        /* renamed from: b, reason: collision with root package name */
        public boolean f21608b;

        /* renamed from: c, reason: collision with root package name */
        public Context f21609c;

        /* renamed from: d, reason: collision with root package name */
        public long f21610d;

        /* renamed from: e, reason: collision with root package name */
        public boolean f21611e;

        public j() {
        }
    }

    public static void A(Context context, i iVar, boolean z10) {
        n(z10, new U0.b(context, 2132083073).setTitle(R.string.dialog_title_delete_contact).setNegativeButton(android.R.string.cancel, (DialogInterface.OnClickListener) null).setNeutralButton(R.string.delete_button, (DialogInterface.OnClickListener) new f(context, iVar)).show());
    }

    public static void B(final Fragment fragment, final Context context, final i iVar, int i10, boolean z10, boolean z11, final h hVar) {
        int[] iArr;
        int i11;
        ArrayList arrayList = new ArrayList();
        Resources resources = context.getResources();
        HashMap hashMap = new HashMap(7);
        int i12 = 1;
        hashMap.put(resources.getString(R.string.oplus_share), 1);
        hashMap.put(resources.getString(R.string.oplus_add_contacts_to_vip), 2);
        hashMap.put(resources.getString(R.string.oplus_remove_contacts_from_vip), 3);
        hashMap.put(resources.getString(R.string.oplus_intercept_contact), 4);
        hashMap.put(resources.getString(R.string.remove_from_blacklist), 5);
        hashMap.put(resources.getString(R.string.delete_button), 6);
        hashMap.put(resources.getString(R.string.oplus_move_out_group), 7);
        hashMap.put(resources.getString(R.string.oplus_starred_contacts), 8);
        hashMap.put(resources.getString(R.string.delete_favorites), 9);
        if (!C0637b.h()) {
            arrayList.add(resources.getString(R.string.oplus_share));
        }
        int i13 = 0;
        if (1 == i10) {
            boolean equals = TextUtils.equals(iVar.f21597f, "com.android.oplus.sim");
            if (!equals) {
                if (iVar.f21603l) {
                    arrayList.add(resources.getString(R.string.delete_favorites));
                } else {
                    arrayList.add(resources.getString(R.string.oplus_starred_contacts));
                }
            }
            if (iVar.f21602k) {
                arrayList.add(resources.getString(R.string.oplus_remove_contacts_from_vip));
            } else {
                if (!equals) {
                    arrayList.add(resources.getString(R.string.oplus_add_contacts_to_vip));
                }
                if (CommonFeatureOption.j() && PrimaryUserUtils.a() && !B3.a.p()) {
                    if (iVar.f21600i) {
                        arrayList.add(resources.getString(R.string.remove_from_blacklist));
                    } else {
                        arrayList.add(resources.getString(R.string.oplus_intercept_contact));
                    }
                }
            }
            ArrayList<String> arrayList2 = iVar.f21598g;
            if (arrayList2 != null) {
                i11 = arrayList2.size();
            } else {
                i11 = 0;
            }
            if (com.android.contacts.util.B.b(context, i11)) {
                hashMap.put(resources.getString(R.string.quick_dial_add_to_desktop), 10);
                arrayList.add(resources.getString(R.string.quick_dial_add_to_desktop));
            }
        } else if (3 == i10) {
            arrayList.add(resources.getString(R.string.oplus_remove_contacts_from_vip));
        } else if (2 == i10) {
            if (CommonFeatureOption.j() && !iVar.f21602k && PrimaryUserUtils.a() && !B3.a.p()) {
                if (iVar.f21600i) {
                    arrayList.add(resources.getString(R.string.remove_from_blacklist));
                } else {
                    arrayList.add(resources.getString(R.string.oplus_intercept_contact));
                }
            }
            arrayList.add(resources.getString(R.string.oplus_move_out_group));
        }
        if (1 == i10) {
            arrayList.add(resources.getString(R.string.delete_button));
        }
        final S3.n a10 = S3.n.a(iVar.f21593b, context, null);
        final COUIPopupListWindow cOUIPopupListWindow = new COUIPopupListWindow(context);
        ArrayList arrayList3 = new ArrayList();
        int i14 = 0;
        while (i14 < arrayList.size()) {
            int intValue = ((Integer) hashMap.get(arrayList.get(i14))).intValue();
            if (6 == intValue) {
                arrayList3.add(com.android.contacts.framework.baseui.util.q.a((String) arrayList.get(i14)));
            } else if (i12 == intValue) {
                PopupListItem a11 = com.android.contacts.framework.baseui.util.q.a((String) arrayList.get(i14));
                if (B3.a.B() && a10.e()) {
                    iArr = new int[3];
                    iArr[i13] = R.string.share_with_text_type;
                    iArr[i12] = R.string.share_with_vcard_type;
                    iArr[2] = R.string.share_with_qr_code_type;
                } else {
                    iArr = new int[2];
                    iArr[i13] = R.string.share_with_text_type;
                    iArr[i12] = R.string.share_with_vcard_type;
                }
                ArrayList<PopupListItem> arrayList4 = new ArrayList<>();
                int length = iArr.length;
                while (i13 < length) {
                    arrayList4.add(com.android.contacts.framework.baseui.util.q.a(context.getResources().getString(iArr[i13])));
                    i13++;
                    iArr = iArr;
                }
                a11.setSubMenuItemList(arrayList4);
                arrayList3.add(a11);
            } else {
                arrayList3.add(com.android.contacts.framework.baseui.util.q.a((String) arrayList.get(i14)));
            }
            i14++;
            i12 = 1;
            i13 = 0;
        }
        cOUIPopupListWindow.setItemList(arrayList3);
        cOUIPopupListWindow.setDismissTouchOutside(true);
        cOUIPopupListWindow.setOnDismissListener(new a(cOUIPopupListWindow, iVar, context, z11));
        cOUIPopupListWindow.setOnItemClickListener(new b(arrayList3, cOUIPopupListWindow, hVar, hashMap, arrayList, i10, iVar, context, z10));
        cOUIPopupListWindow.setSubMenuClickListener(new COUISubMenuClickListener() { // from class: com.customize.contacts.manager.k
            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView adapterView, View view, int i15, long j10) {
                n.s(COUIPopupListWindow.this, hVar, fragment, context, iVar, a10, adapterView, view, i15, j10);
            }
        });
        cOUIPopupListWindow.setSubMenuOffset(0, UIUtil.getStatusBarHeight(context));
        iVar.f21592a.setTag(R.id.list_item_long_clicked, Boolean.TRUE);
        iVar.f21592a.setBackgroundColor(com.android.contacts.framework.baseui.util.r.b(context));
        iVar.f21592a.getLocalVisibleRect(new Rect());
        cOUIPopupListWindow.show(iVar.f21592a, iVar.f21604m, iVar.f21605n);
        ViewGroup viewGroup = iVar.f21606o;
        if (viewGroup != null) {
            viewGroup.requestDisallowInterceptTouchEvent(true);
        }
        Z3.j.a(cOUIPopupListWindow);
        x(context, false, z11);
    }

    public static void C(Context context, i iVar, boolean z10) {
        n(z10, new U0.b(context, 2132083073).setTitle(R.string.oplus_remove_contacts_from_vip_v2).setNegativeButton(android.R.string.cancel, (DialogInterface.OnClickListener) null).setNeutralButton(R.string.remove, (DialogInterface.OnClickListener) new e(context, iVar)).show());
    }

    public static void D(Context context, i iVar, boolean z10) {
        int i10;
        if (context instanceof Activity) {
            String str = C1501d.f36273b;
            if (com.android.contacts.framework.baseui.util.l.d(context, str)) {
                com.android.contacts.framework.baseui.util.l.f((Activity) context, str, null, 2);
                return;
            }
        }
        if (B3.a.A()) {
            if (B3.a.Y()) {
                i10 = R.string.intercept_contact_use_third_mms_tips_v2;
            } else {
                i10 = R.string.intercept_contact_except_mms_tips_v2;
            }
        } else {
            i10 = R.string.intercept_contact_tips_v2;
        }
        k kVar = new k(context, iVar);
        n(z10, new U0.b(context, 2132083073).setTitle(R.string.dialog_title_add_blacklist).setMessage(i10).setNegativeButton(android.R.string.cancel, (DialogInterface.OnClickListener) kVar).setNeutralButton(R.string.add, (DialogInterface.OnClickListener) kVar).show());
    }

    public static /* bridge */ /* synthetic */ void g(Context context, i iVar, boolean z10) {
        w(context, iVar, z10);
    }

    public static /* bridge */ /* synthetic */ void i(Context context, i iVar, boolean z10) {
        y(context, iVar, z10);
    }

    public static /* bridge */ /* synthetic */ void j(Context context, i iVar, boolean z10) {
        z(context, iVar, z10);
    }

    public static /* bridge */ /* synthetic */ void m(Context context, i iVar, boolean z10) {
        D(context, iVar, z10);
    }

    public static void n(boolean z10, Dialog dialog) {
        if (z10) {
            U0.n.a(dialog);
        }
    }

    public static void o(Context context, i iVar) {
        BlackListUtils.o(context, iVar.f21593b, iVar.f21598g, true, false, false);
        com.android.contacts.framework.baseui.util.A.a(context, 2000304, 200030240, null, false);
    }

    public static boolean p(Context context, i iVar, Intent intent) {
        String str;
        if (TextUtils.isEmpty(iVar.f21595d) && iVar.f21598g.size() <= 0 && iVar.f21599h.size() <= 0) {
            com.oplus.foundation.util.ui.c.b(context, R.string.donot_share);
            return false;
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(iVar.f21595d + ":\n");
        HashSet hashSet = new HashSet();
        Iterator<String> it = iVar.f21598g.iterator();
        while (it.hasNext()) {
            String next = it.next();
            if (!TextUtils.isEmpty(next)) {
                String d10 = U7.f.d(next);
                if (!hashSet.contains(d10)) {
                    hashSet.add(d10);
                    stringBuffer.append(d10 + "；\n");
                }
            }
        }
        hashSet.clear();
        Iterator<String> it2 = iVar.f21599h.iterator();
        while (it2.hasNext()) {
            String next2 = it2.next();
            if (!TextUtils.isEmpty(next2) && !hashSet.contains(next2)) {
                hashSet.add(next2);
                stringBuffer.append(next2 + "；\n");
            }
        }
        hashSet.clear();
        int length = stringBuffer.length();
        if (length > 0) {
            str = stringBuffer.substring(0, length - 1);
        } else {
            str = "";
        }
        intent.setType("text/plain");
        intent.putExtra("android.intent.extra.TEXT", (CharSequence) str);
        return true;
    }

    public static /* synthetic */ void q(S3.n nVar, Context context) {
        nVar.d();
        com.android.contacts.framework.baseui.util.A.a(context, 2000309, 200032401, null, false);
    }

    public static /* synthetic */ void s(COUIPopupListWindow cOUIPopupListWindow, h hVar, Fragment fragment, Context context, i iVar, S3.n nVar, AdapterView adapterView, View view, int i10, long j10) {
        if (cOUIPopupListWindow.isShowing()) {
            cOUIPopupListWindow.dismiss();
            if (hVar != null) {
                hVar.a();
            }
        }
        if (fragment == null) {
            v(context, iVar, i10, nVar);
            return;
        }
        new S3.c(context, U7.g.b("content://com.android.contacts/contacts/lookup/" + iVar.f21596e)).d(fragment, new c(context, iVar, i10, nVar));
    }

    public static void t(Context context, i iVar) {
        BlackListUtils.o(context, iVar.f21593b, iVar.f21598g, false, false, false);
        com.android.contacts.framework.baseui.util.A.a(context, 2000304, 200030241, null, false);
    }

    public static void u(Context context, i iVar, int i10) {
        String str = iVar.f21596e;
        Intent intent = new Intent("android.intent.action.SEND");
        intent.putExtra("send_entrance", context.getPackageName());
        if (i10 == 1) {
            if (!p(context, iVar, intent)) {
                return;
            }
        } else {
            Uri withAppendedPath = Uri.withAppendedPath(ContactsContract.Contacts.CONTENT_VCARD_URI, str);
            intent.setType("text/x-vcard");
            intent.putExtra("android.intent.extra.STREAM", withAppendedPath);
        }
        R7.b.d(context, Intent.createChooser(intent, context.getText(R.string.share_via)), R.string.share_account_error);
        com.android.contacts.framework.api.infocollection.a.c();
    }

    public static void v(final Context context, i iVar, int i10, final S3.n nVar) {
        if (1 == i10) {
            u(context, iVar, 2);
            return;
        }
        if (i10 == 0) {
            u(context, iVar, 1);
        } else if (2 == i10 && nVar != null) {
            N7.a.b().execute(new Runnable() { // from class: com.customize.contacts.manager.l
                @Override // java.lang.Runnable
                public final void run() {
                    n.q(S3.n.this, context);
                }
            });
        }
    }

    public static void w(Context context, i iVar, boolean z10) {
        if (context != null) {
            ContactDataUtils.b(context, ContactsContract.Contacts.getLookupUri(iVar.f21593b, iVar.f21596e), z10);
        }
    }

    public static void x(Context context, boolean z10, boolean z11) {
        if ((context instanceof ContactsTabActivity) && !z11) {
            ((ContactsTabActivity) context).g3(z10);
        }
    }

    public static void y(Context context, i iVar, boolean z10) {
        if (!AbstractC1362a.h(context).c(iVar.f21597f, null).b()) {
            com.oplus.foundation.util.ui.c.b(context, R.string.read_only_contact_to_vip_tips_tablet);
            return;
        }
        if (context instanceof Activity) {
            String str = C1501d.f36273b;
            if (com.android.contacts.framework.baseui.util.l.d(context, str)) {
                com.android.contacts.framework.baseui.util.l.f((Activity) context, str, null, 2);
                return;
            }
        }
        COUIAlertDialogBuilder neutralButton = new U0.b(context, 2132083073).setTitle(R.string.oplus_add_contacts_to_vip).setNegativeButton(android.R.string.cancel, (DialogInterface.OnClickListener) null).setNeutralButton(R.string.add, (DialogInterface.OnClickListener) new d(context, iVar));
        if (B3.a.c0()) {
            if (OSPublicFeature.F()) {
                neutralButton.setMessage(R.string.oplus_add_contacts_to_vip_tips_for_drive_mode_v2);
            } else {
                neutralButton.setMessage(R.string.oplus_add_contacts_to_vip_tips_without_vibrate_for_drive_mode_v2);
            }
        }
        n(z10, neutralButton.show());
    }

    public static void z(final Context context, final i iVar, boolean z10) {
        if (context instanceof Activity) {
            String str = C1501d.f36273b;
            if (com.android.contacts.framework.baseui.util.l.d(context, str)) {
                com.android.contacts.framework.baseui.util.l.f((Activity) context, str, null, 2);
                return;
            }
        }
        n(z10, new U0.b(context, 2132083073).setTitle(R.string.dialog_title_remove_blacklist).setNegativeButton(android.R.string.cancel, (DialogInterface.OnClickListener) null).setNeutralButton(R.string.remove, new DialogInterface.OnClickListener() { // from class: com.customize.contacts.manager.m
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i10) {
                n.t(context, iVar);
            }
        }).show());
    }

    /* compiled from: ListItemLongClickManager.java */
    /* loaded from: classes3.dex */
    public static class k implements DialogInterface.OnClickListener, DialogInterface.OnCancelListener {

        /* renamed from: a, reason: collision with root package name */
        public i f21612a;

        /* renamed from: b, reason: collision with root package name */
        public Context f21613b;

        public k(Context context, i iVar) {
            this.f21613b = context;
            this.f21612a = iVar;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i10) {
            dialogInterface.dismiss();
            if (-3 == i10) {
                n.o(this.f21613b, this.f21612a);
            }
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
        }
    }
}
