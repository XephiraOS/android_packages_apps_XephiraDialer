package m1;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;

/* compiled from: ContactsIntentResolver.java */
/* renamed from: m1.n, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C1318n {

    /* renamed from: a, reason: collision with root package name */
    public final Activity f35008a;

    public C1318n(Activity activity) {
        this.f35008a = activity;
    }

    public C1319o a(Intent intent) {
        C1319o c1319o = new C1319o();
        String action = intent.getAction();
        H7.b.e("ContactsIntentResolver", "Called with action: " + action);
        if ("com.android.contacts.action.LIST_DEFAULT".equals(action)) {
            c1319o.g(10);
        } else if ("com.android.contacts.action.LIST_ALL_CONTACTS".equals(action)) {
            c1319o.g(15);
        } else if ("com.android.contacts.action.LIST_CONTACTS_WITH_PHONES".equals(action)) {
            c1319o.g(17);
        } else if ("com.android.contacts.action.LIST_STARRED".equals(action)) {
            c1319o.g(30);
        } else if ("com.android.contacts.action.LIST_FREQUENT".equals(action)) {
            c1319o.g(40);
        } else if ("com.android.contacts.action.LIST_STREQUENT".equals(action)) {
            c1319o.g(50);
        } else if ("com.android.contacts.action.LIST_GROUP".equals(action)) {
            c1319o.g(20);
        } else if ("android.intent.action.PICK".equals(action)) {
            String resolveType = intent.resolveType(this.f35008a);
            if ("vnd.android.cursor.dir/contact".equals(resolveType)) {
                if (C7.e.c(intent, "photo_select", false)) {
                    c1319o.g(170);
                } else {
                    c1319o.g(60);
                }
            } else if ("vnd.android.cursor.dir/person".equals(resolveType)) {
                c1319o.g(60);
                c1319o.j(true);
            } else if ("vnd.android.cursor.dir/phone_v2".equals(resolveType)) {
                c1319o.g(90);
            } else if ("vnd.android.cursor.dir/phone".equals(resolveType)) {
                c1319o.g(90);
                c1319o.j(true);
            } else if ("vnd.android.cursor.dir/postal-address_v2".equals(resolveType)) {
                c1319o.g(100);
            } else if ("vnd.android.cursor.dir/postal-address".equals(resolveType)) {
                c1319o.g(100);
                c1319o.j(true);
            } else if ("vnd.android.cursor.dir/email_v2".equals(resolveType)) {
                c1319o.g(105);
            }
        } else if ("android.intent.action.CREATE_SHORTCUT".equals(action)) {
            String className = intent.getComponent().getClassName();
            if (className.equals("alias.DialShortcut")) {
                c1319o.g(120);
            } else if (className.equals("alias.MessageShortcut")) {
                c1319o.g(130);
            } else {
                c1319o.g(110);
            }
        } else if ("android.intent.action.GET_CONTENT".equals(action)) {
            String type = intent.getType();
            if ("vnd.android.cursor.item/contact".equals(type)) {
                if (C7.e.c(intent, "photo_select", false)) {
                    c1319o.g(170);
                } else {
                    c1319o.g(70);
                }
            } else if ("vnd.android.cursor.item/phone_v2".equals(type)) {
                c1319o.g(90);
            } else if ("vnd.android.cursor.item/phone".equals(type)) {
                c1319o.g(90);
                c1319o.j(true);
            } else if ("vnd.android.cursor.item/postal-address_v2".equals(type)) {
                c1319o.g(100);
            } else if ("vnd.android.cursor.item/postal-address".equals(type)) {
                c1319o.g(100);
                c1319o.j(true);
            } else if ("vnd.android.cursor.item/person".equals(type)) {
                c1319o.g(70);
                c1319o.j(true);
            }
        } else if ("android.intent.action.INSERT_OR_EDIT".equals(action)) {
            c1319o.g(80);
        } else if ("android.intent.action.SEARCH".equals(action)) {
            String stringExtra = intent.getStringExtra("query");
            if (TextUtils.isEmpty(stringExtra)) {
                stringExtra = intent.getStringExtra("phone");
            }
            if (TextUtils.isEmpty(stringExtra)) {
                stringExtra = intent.getStringExtra("email");
            }
            c1319o.k(stringExtra);
            c1319o.l(true);
        } else if ("android.intent.action.VIEW".equals(action)) {
            String resolveType2 = intent.resolveType(this.f35008a);
            if (!"vnd.android.cursor.dir/contact".equals(resolveType2) && !"vnd.android.cursor.dir/person".equals(resolveType2)) {
                c1319o.g(140);
                c1319o.i(intent.getData());
                intent.setAction("android.intent.action.VIEW");
                intent.setData(null);
            } else {
                c1319o.g(15);
            }
        } else if ("android.provider.Contacts.SEARCH_SUGGESTION_CLICKED".equals(action)) {
            Uri data = intent.getData();
            c1319o.g(140);
            c1319o.i(data);
            intent.setAction("android.intent.action.VIEW");
            intent.setData(null);
        } else if (r0.f.o(action)) {
            c1319o.g(150);
        } else if ("com.oplus.contacts.ui.LIST_RELATION_CONTACTS".equals(action)) {
            c1319o.g(160);
        } else if ("com.oplus.contacts.ui.SELECT_CONTACTS_SPEED_DIAL".equals(action)) {
            c1319o.g(90);
        } else if ("com.oplus.contacts.ui.SELECT_CONTACTS_FOR_SPEED_DIAL_WIDGET".equals(action)) {
            c1319o.g(90);
        }
        String l10 = C7.e.l(intent, "com.android.contacts.extra.TITLE_EXTRA");
        if (l10 != null) {
            c1319o.h(l10);
        }
        return c1319o;
    }
}
