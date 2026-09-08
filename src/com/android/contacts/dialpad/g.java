package com.android.contacts.dialpad;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.provider.ContactsContract;
import android.text.TextUtils;
import android.view.Window;
import android.view.WindowManager;
import com.android.contacts.activities.ContactSelectionActivity;
import com.android.contacts.dialpad.ContactInfoForSpeedDial;
import com.android.contacts.dialpad.SpeedDialManageActivity;
import com.coui.appcompat.dialog.COUIAlertDialogBuilder;
import com.customize.contacts.util.HandlerC0795f;
import com.oplus.dialer.R;
import java.lang.ref.WeakReference;
import kotlin.NoWhenBranchMatchedException;

/* compiled from: SpeedDialManager.kt */
/* loaded from: classes.dex */
public final class g {

    /* renamed from: m, reason: collision with root package name */
    public static final a f14932m = new a(null);

    /* renamed from: a, reason: collision with root package name */
    public final Context f14933a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f14934b;

    /* renamed from: c, reason: collision with root package name */
    public final d f14935c;

    /* renamed from: d, reason: collision with root package name */
    public final SharedPreferences f14936d;

    /* renamed from: e, reason: collision with root package name */
    public String f14937e;

    /* renamed from: f, reason: collision with root package name */
    public String f14938f;

    /* renamed from: g, reason: collision with root package name */
    public String f14939g;

    /* renamed from: h, reason: collision with root package name */
    public c f14940h;

    /* renamed from: i, reason: collision with root package name */
    public b f14941i;

    /* renamed from: j, reason: collision with root package name */
    public int f14942j;

    /* renamed from: k, reason: collision with root package name */
    public COUIAlertDialogBuilder f14943k;

    /* renamed from: l, reason: collision with root package name */
    public androidx.appcompat.app.b f14944l;

    /* compiled from: SpeedDialManager.kt */
    /* loaded from: classes.dex */
    public static final class a {
        public a() {
        }

        public final boolean b(Context context) {
            if (!(context instanceof Activity)) {
                return false;
            }
            Activity activity = (Activity) context;
            if (!activity.isFinishing() && !activity.isDestroyed()) {
                return false;
            }
            return true;
        }

        public /* synthetic */ a(kotlin.jvm.internal.f fVar) {
            this();
        }
    }

    /* compiled from: SpeedDialManager.kt */
    /* loaded from: classes.dex */
    public interface b {
        void a(int i10);

        void b(String str);

        void c(int i10);
    }

    /* compiled from: SpeedDialManager.kt */
    /* loaded from: classes.dex */
    public static final class c extends HandlerC0795f {

        /* renamed from: f, reason: collision with root package name */
        public final WeakReference<g> f14945f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(ContentResolver contentResolver, g speedDialManager) {
            super(contentResolver);
            kotlin.jvm.internal.i.f(contentResolver, "contentResolver");
            kotlin.jvm.internal.i.f(speedDialManager, "speedDialManager");
            this.f14945f = new WeakReference<>(speedDialManager);
        }

        /* JADX WARN: Code restructure failed: missing block: B:28:0x0064, code lost:
        
            if (kotlin.jvm.internal.i.b(r0, r2) == false) goto L26;
         */
        @Override // com.customize.contacts.util.HandlerC0795f
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void e(int r4, java.lang.Object r5, android.database.Cursor r6) {
            /*
                r3 = this;
                java.lang.ref.WeakReference<com.android.contacts.dialpad.g> r3 = r3.f14945f
                java.lang.Object r3 = r3.get()
                com.android.contacts.dialpad.g r3 = (com.android.contacts.dialpad.g) r3
                if (r3 != 0) goto Lb
                return
            Lb:
                com.android.contacts.dialpad.g$a r5 = com.android.contacts.dialpad.g.f14932m
                android.content.Context r0 = com.android.contacts.dialpad.g.b(r3)
                boolean r5 = com.android.contacts.dialpad.g.a.a(r5, r0)
                if (r5 == 0) goto L18
                return
            L18:
                r5 = 1
                if (r4 != r5) goto La7
                if (r6 == 0) goto L8f
                boolean r4 = r6.moveToFirst()     // Catch: java.lang.Throwable -> L4b
                if (r4 == 0) goto L8f
                com.android.contacts.dialpad.ContactInfoForSpeedDial$c r4 = com.android.contacts.dialpad.ContactInfoForSpeedDial.c.f14863a     // Catch: java.lang.Throwable -> L4b
                int r5 = r4.d()     // Catch: java.lang.Throwable -> L4b
                java.lang.String r5 = r6.getString(r5)     // Catch: java.lang.Throwable -> L4b
                int r0 = r4.b()     // Catch: java.lang.Throwable -> L4b
                java.lang.String r0 = r6.getString(r0)     // Catch: java.lang.Throwable -> L4b
                int r4 = r4.c()     // Catch: java.lang.Throwable -> L4b
                java.lang.String r4 = r6.getString(r4)     // Catch: java.lang.Throwable -> L4b
                java.lang.String r1 = com.android.contacts.dialpad.g.f(r3)     // Catch: java.lang.Throwable -> L4b
                r2 = 0
                if (r1 != 0) goto L4d
                java.lang.String r1 = "speedDialName"
                kotlin.jvm.internal.i.q(r1)     // Catch: java.lang.Throwable -> L4b
                r1 = r2
                goto L4d
            L4b:
                r3 = move-exception
                goto La3
            L4d:
                boolean r1 = kotlin.jvm.internal.i.b(r5, r1)     // Catch: java.lang.Throwable -> L4b
                if (r1 == 0) goto L66
                java.lang.String r1 = com.android.contacts.dialpad.g.g(r3)     // Catch: java.lang.Throwable -> L4b
                if (r1 != 0) goto L5f
                java.lang.String r1 = "speedDialNumber"
                kotlin.jvm.internal.i.q(r1)     // Catch: java.lang.Throwable -> L4b
                goto L60
            L5f:
                r2 = r1
            L60:
                boolean r1 = kotlin.jvm.internal.i.b(r0, r2)     // Catch: java.lang.Throwable -> L4b
                if (r1 != 0) goto L7e
            L66:
                java.lang.String r1 = "number"
                kotlin.jvm.internal.i.e(r0, r1)     // Catch: java.lang.Throwable -> L4b
                com.android.contacts.dialpad.g.j(r3, r0)     // Catch: java.lang.Throwable -> L4b
                java.lang.String r0 = "dataId"
                kotlin.jvm.internal.i.e(r4, r0)     // Catch: java.lang.Throwable -> L4b
                com.android.contacts.dialpad.g.h(r3, r4)     // Catch: java.lang.Throwable -> L4b
                java.lang.String r4 = "name"
                kotlin.jvm.internal.i.e(r5, r4)     // Catch: java.lang.Throwable -> L4b
                com.android.contacts.dialpad.g.i(r3, r5)     // Catch: java.lang.Throwable -> L4b
            L7e:
                com.android.contacts.dialpad.g$d r4 = com.android.contacts.dialpad.g.e(r3)     // Catch: java.lang.Throwable -> L4b
                r5 = 3
                android.os.Message r4 = android.os.Message.obtain(r4, r5)     // Catch: java.lang.Throwable -> L4b
                com.android.contacts.dialpad.g$d r3 = com.android.contacts.dialpad.g.e(r3)     // Catch: java.lang.Throwable -> L4b
                r3.sendMessageAtFrontOfQueue(r4)     // Catch: java.lang.Throwable -> L4b
                goto L9f
            L8f:
                com.android.contacts.dialpad.g.k(r3)     // Catch: java.lang.Throwable -> L4b
                com.android.contacts.dialpad.g$b r4 = com.android.contacts.dialpad.g.d(r3)     // Catch: java.lang.Throwable -> L4b
                if (r4 == 0) goto L9f
                int r3 = com.android.contacts.dialpad.g.c(r3)     // Catch: java.lang.Throwable -> L4b
                r4.a(r3)     // Catch: java.lang.Throwable -> L4b
            L9f:
                com.oplus.foundation.util.io.e.a(r6)
                goto La7
            La3:
                com.oplus.foundation.util.io.e.a(r6)
                throw r3
            La7:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.android.contacts.dialpad.g.c.e(int, java.lang.Object, android.database.Cursor):void");
        }
    }

    /* compiled from: SpeedDialManager.kt */
    /* loaded from: classes.dex */
    public static final class d extends Handler {

        /* renamed from: a, reason: collision with root package name */
        public final WeakReference<g> f14946a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(g speedDialManager) {
            super(Looper.getMainLooper());
            kotlin.jvm.internal.i.f(speedDialManager, "speedDialManager");
            this.f14946a = new WeakReference<>(speedDialManager);
        }

        @Override // android.os.Handler
        public void handleMessage(Message msg) {
            kotlin.jvm.internal.i.f(msg, "msg");
            H7.b.b("SpeedDialManager", "SpeedDialHandler, msg = " + msg.what);
            g gVar = this.f14946a.get();
            if (gVar == null || g.f14932m.b(gVar.f14933a)) {
                return;
            }
            int i10 = msg.what;
            if (i10 == 3) {
                b bVar = gVar.f14941i;
                if (bVar != null) {
                    String str = gVar.f14938f;
                    if (str == null) {
                        kotlin.jvm.internal.i.q("speedDialNumber");
                        str = null;
                    }
                    bVar.b(str);
                    return;
                }
                return;
            }
            if (i10 == 5) {
                b bVar2 = gVar.f14941i;
                if (bVar2 != null) {
                    bVar2.c(gVar.f14942j);
                    return;
                }
                return;
            }
            H7.b.i("SpeedDialManager", "error msg");
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public g(Context context) {
        this(context, false, 2, null);
        kotlin.jvm.internal.i.f(context, "context");
    }

    public static final void s(g this$0, DialogInterface dialogInterface, int i10) {
        kotlin.jvm.internal.i.f(this$0, "this$0");
        this$0.f14935c.sendMessageAtFrontOfQueue(Message.obtain(this$0.f14935c, 5));
    }

    public final ContactInfoForSpeedDial l(String str, String displayName, String data1) {
        ContactInfoForSpeedDial contactInfoForSpeedDial;
        Cursor e10;
        kotlin.jvm.internal.i.f(displayName, "displayName");
        kotlin.jvm.internal.i.f(data1, "data1");
        Cursor cursor = null;
        try {
            try {
                boolean z10 = !TextUtils.isEmpty(str);
                if (z10) {
                    e10 = G7.c.e(this.f14933a.getContentResolver(), ContactsContract.Data.CONTENT_URI, ContactInfoForSpeedDial.c.f14863a.h(), "Data._id=?", new String[]{str}, null);
                } else if (!z10) {
                    e10 = G7.c.e(this.f14933a.getContentResolver(), ContactsContract.Data.CONTENT_URI, ContactInfoForSpeedDial.c.f14863a.h(), "Data.display_name=? and Data.data1=?", new String[]{displayName, data1}, null);
                } else {
                    throw new NoWhenBranchMatchedException();
                }
                cursor = e10;
                if (cursor != null && cursor.moveToFirst()) {
                    ContactInfoForSpeedDial.c cVar = ContactInfoForSpeedDial.c.f14863a;
                    String string = cursor.getString(cVar.d());
                    kotlin.jvm.internal.i.e(string, "cursor.getString(DISPLAY_NAME_INDEX)");
                    String string2 = cursor.getString(cVar.b());
                    kotlin.jvm.internal.i.e(string2, "cursor.getString(DATA1_INDEX)");
                    long j10 = cursor.getLong(cVar.f());
                    Uri b10 = U7.g.b(cursor.getString(cVar.g()));
                    String string3 = cursor.getString(cVar.e());
                    kotlin.jvm.internal.i.e(string3, "cursor.getString(LOOKUP_INDEX)");
                    String string4 = cursor.getString(cVar.c());
                    kotlin.jvm.internal.i.e(string4, "cursor.getString(DATA_ID_INDEX)");
                    contactInfoForSpeedDial = new ContactInfoForSpeedDial(string4, string, string2, j10, b10, string3, cursor.getLong(cVar.a()));
                } else {
                    contactInfoForSpeedDial = new ContactInfoForSpeedDial(null, null, null, 0L, null, null, 0L, 127, null);
                }
            } catch (Exception e11) {
                H7.b.c("SpeedDialManager", "getContactsInfo: " + e11);
                contactInfoForSpeedDial = new ContactInfoForSpeedDial(null, null, null, 0L, null, null, 0L, 127, null);
            }
            com.oplus.foundation.util.io.e.a(cursor);
            return contactInfoForSpeedDial;
        } catch (Throwable th) {
            com.oplus.foundation.util.io.e.a(null);
            throw th;
        }
    }

    public final boolean m(int i10, String input) {
        c cVar;
        c cVar2;
        kotlin.jvm.internal.i.f(input, "input");
        if (!TextUtils.isEmpty(input)) {
            return false;
        }
        this.f14942j = i10;
        SharedPreferences sharedPreferences = this.f14936d;
        SpeedDialManageActivity.a aVar = SpeedDialManageActivity.f14891G;
        String string = sharedPreferences.getString(String.valueOf(aVar.a(i10)), "");
        kotlin.jvm.internal.i.c(string);
        this.f14939g = string;
        String string2 = this.f14936d.getString(String.valueOf(this.f14942j), "");
        kotlin.jvm.internal.i.c(string2);
        this.f14938f = string2;
        String string3 = this.f14936d.getString(String.valueOf(aVar.b(this.f14942j)), "");
        kotlin.jvm.internal.i.c(string3);
        this.f14937e = string3;
        String str = null;
        if (string3 == null) {
            kotlin.jvm.internal.i.q("speedDialName");
            string3 = null;
        }
        if (!TextUtils.isEmpty(string3)) {
            String str2 = this.f14939g;
            if (str2 == null) {
                kotlin.jvm.internal.i.q("speedDialDataId");
                str2 = null;
            }
            if (!TextUtils.isEmpty(str2)) {
                H7.b.b("SpeedDialManager", "[handleSpeedDial] mSpeedDialDataId not empty");
                c cVar3 = this.f14940h;
                if (cVar3 == null) {
                    kotlin.jvm.internal.i.q("queryHandler");
                    cVar3 = null;
                }
                cVar3.c(1);
                c cVar4 = this.f14940h;
                if (cVar4 == null) {
                    kotlin.jvm.internal.i.q("queryHandler");
                    cVar2 = null;
                } else {
                    cVar2 = cVar4;
                }
                Uri uri = ContactsContract.Data.CONTENT_URI;
                String[] h10 = ContactInfoForSpeedDial.c.f14863a.h();
                String str3 = this.f14939g;
                if (str3 == null) {
                    kotlin.jvm.internal.i.q("speedDialDataId");
                } else {
                    str = str3;
                }
                cVar2.i(1, null, uri, h10, "Data._id = " + str, null, null);
            } else {
                H7.b.b("SpeedDialManager", "[handleSpeedDial] mSpeedDialDataId is empty");
                c cVar5 = this.f14940h;
                if (cVar5 == null) {
                    kotlin.jvm.internal.i.q("queryHandler");
                    cVar5 = null;
                }
                cVar5.c(1);
                c cVar6 = this.f14940h;
                if (cVar6 == null) {
                    kotlin.jvm.internal.i.q("queryHandler");
                    cVar = null;
                } else {
                    cVar = cVar6;
                }
                Uri uri2 = ContactsContract.Data.CONTENT_URI;
                String[] h11 = ContactInfoForSpeedDial.c.f14863a.h();
                String str4 = this.f14937e;
                if (str4 == null) {
                    kotlin.jvm.internal.i.q("speedDialName");
                    str4 = null;
                }
                String str5 = this.f14938f;
                if (str5 == null) {
                    kotlin.jvm.internal.i.q("speedDialNumber");
                } else {
                    str = str5;
                }
                cVar.i(1, null, uri2, h11, "Data.display_name=? and Data.data1=?", new String[]{str4, str}, null);
            }
            return true;
        }
        if (!this.f14934b) {
            return false;
        }
        r();
        return true;
    }

    public final void n() {
        Integer num;
        Window window;
        Window window2;
        WindowManager.LayoutParams attributes;
        androidx.appcompat.app.b bVar = this.f14944l;
        if (bVar != null && bVar.isShowing() && this.f14943k != null) {
            androidx.appcompat.app.b bVar2 = this.f14944l;
            androidx.appcompat.app.b bVar3 = null;
            if (bVar2 != null && (window2 = bVar2.getWindow()) != null && (attributes = window2.getAttributes()) != null) {
                num = Integer.valueOf(attributes.gravity);
            } else {
                num = null;
            }
            int d10 = com.oplus.foundation.util.ui.b.d(this.f14933a, null, 2, null);
            if (num == null || num.intValue() != d10) {
                androidx.appcompat.app.b bVar4 = this.f14944l;
                if (bVar4 != null && (window = bVar4.getWindow()) != null) {
                    window.setWindowAnimations(0);
                }
                androidx.appcompat.app.b bVar5 = this.f14944l;
                if (bVar5 != null) {
                    bVar5.dismiss();
                }
                COUIAlertDialogBuilder cOUIAlertDialogBuilder = this.f14943k;
                if (cOUIAlertDialogBuilder != null) {
                    cOUIAlertDialogBuilder.setWindowGravity(d10);
                }
                COUIAlertDialogBuilder cOUIAlertDialogBuilder2 = this.f14943k;
                if (cOUIAlertDialogBuilder2 != null) {
                    cOUIAlertDialogBuilder2.setWindowAnimStyle(com.oplus.foundation.util.ui.b.b(this.f14933a, false, null, 6, null));
                }
                COUIAlertDialogBuilder cOUIAlertDialogBuilder3 = this.f14943k;
                if (cOUIAlertDialogBuilder3 != null) {
                    bVar3 = cOUIAlertDialogBuilder3.show();
                }
                this.f14944l = bVar3;
            }
        }
    }

    public final void o(b listener) {
        kotlin.jvm.internal.i.f(listener, "listener");
        this.f14941i = listener;
    }

    public final void p() {
        ContentResolver contentResolver = this.f14933a.getContentResolver();
        kotlin.jvm.internal.i.e(contentResolver, "context.contentResolver");
        this.f14940h = new c(contentResolver, this);
    }

    public final void q(int i10) {
        Activity activity;
        Intent intent = new Intent(this.f14933a, (Class<?>) ContactSelectionActivity.class);
        intent.setAction("com.oplus.contacts.ui.SELECT_CONTACTS_SPEED_DIAL");
        intent.putExtra(R0.c.f3183a, true);
        Context context = this.f14933a;
        if (context instanceof Activity) {
            activity = (Activity) context;
        } else {
            activity = null;
        }
        if (activity != null) {
            Q7.b.b(activity, intent, i10, 0);
        }
    }

    public final void r() {
        if (!this.f14934b) {
            H7.b.c("SpeedDialManager", "supportSetSpeedDial: false");
            return;
        }
        String string = this.f14933a.getString(R.string.numeric_button_set_speed_dial_tips_v2);
        kotlin.jvm.internal.i.e(string, "context.getString(R.stri…n_set_speed_dial_tips_v2)");
        U0.b bVar = new U0.b(this.f14933a, 2132083073);
        bVar.setTitle((CharSequence) string);
        bVar.setPositiveButton(R.string.oplus_button_set, new DialogInterface.OnClickListener() { // from class: com.android.contacts.dialpad.f
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i10) {
                g.s(g.this, dialogInterface, i10);
            }
        });
        bVar.setNegativeButton(android.R.string.cancel, (DialogInterface.OnClickListener) null);
        bVar.setWindowGravity(bVar.getBottomAlertDialogWindowGravity(bVar.getContext()));
        bVar.setWindowAnimStyle(bVar.getBottomAlertDialogWindowAnimStyle(bVar.getContext()));
        this.f14943k = bVar;
        this.f14944l = bVar.show();
    }

    public final void t(int i10, ContactInfoForSpeedDial contactInfoForSpeedDial) {
        SharedPreferences.Editor edit = this.f14936d.edit();
        if (contactInfoForSpeedDial == null) {
            SpeedDialManageActivity.a aVar = SpeedDialManageActivity.f14891G;
            edit.putString(String.valueOf(aVar.a(i10)), "");
            edit.putString(String.valueOf(i10), "");
            edit.putString(String.valueOf(aVar.b(i10)), "");
        } else {
            SpeedDialManageActivity.a aVar2 = SpeedDialManageActivity.f14891G;
            edit.putString(String.valueOf(aVar2.a(i10)), contactInfoForSpeedDial.d());
            edit.putString(String.valueOf(i10), contactInfoForSpeedDial.h());
            edit.putString(String.valueOf(aVar2.b(i10)), contactInfoForSpeedDial.f());
        }
        edit.apply();
    }

    public g(Context context, boolean z10) {
        kotlin.jvm.internal.i.f(context, "context");
        this.f14933a = context;
        this.f14934b = z10;
        this.f14935c = new d(this);
        SharedPreferences sharedPreferences = context.getSharedPreferences("speed_dial", 0);
        kotlin.jvm.internal.i.e(sharedPreferences, "context.getSharedPrefere…ME, Context.MODE_PRIVATE)");
        this.f14936d = sharedPreferences;
    }

    public /* synthetic */ g(Context context, boolean z10, int i10, kotlin.jvm.internal.f fVar) {
        this(context, (i10 & 2) != 0 ? true : z10);
    }
}
