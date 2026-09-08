package r0;

import android.content.Intent;
import android.content.IntentFilter;
import com.android.incallui.OplusNumberMarkUtils;

/* compiled from: SdkActionUtils.kt */
/* loaded from: classes.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    public static final a f36278a = new a(null);

    /* compiled from: SdkActionUtils.kt */
    /* loaded from: classes.dex */
    public static final class a {
        public a() {
        }

        public final void a(IntentFilter filter) {
            kotlin.jvm.internal.i.f(filter, "filter");
            filter.addAction("com.android.oppo.cleardialerinfo");
            filter.addAction("com.android.oplus.cleardialerinfo");
        }

        public final boolean b(String str) {
            if (!"oppo.intent.action.OPPO_BLACK_LIST_CONTACTS".equals(str) && !"oplus.intent.action.BLACK_LIST_CONTACTS".equals(str)) {
                return false;
            }
            return true;
        }

        public final boolean c(String str) {
            if (!"com.android.oppo.cleardialerinfo".equals(str) && !"com.android.oplus.cleardialerinfo".equals(str)) {
                return false;
            }
            return true;
        }

        public final boolean d(String str) {
            if (!"oppo.intent.action.DIAL".equals(str) && !"oplus.intent.action.DIAL".equals(str)) {
                return false;
            }
            return true;
        }

        public final boolean e(String str) {
            if (!"oppo.intent.action.OPPO_FOR_BLACK_LIST".equals(str) && !"oplus.intent.action.FOR_BLACK_LIST".equals(str)) {
                return false;
            }
            return true;
        }

        public final boolean f(String str) {
            if (!"oppo.intent.action.OPPO_FOR_SMS".equals(str) && !"oplus.intent.action.FOR_SMS".equals(str)) {
                return false;
            }
            return true;
        }

        public final boolean g(String str) {
            if (!"oppo.intent.action.OPPO_FOR_SMS_RCS_CREATE_GROUP".equals(str) && !"oplus.intent.action.FOR_SMS_RCS_CREATE_GROUP".equals(str)) {
                return false;
            }
            return true;
        }

        public final boolean h(String str) {
            if (!"oppo.intent.action.OPPO_FOR_SMS_RCS_GROUP_INVITE".equals(str) && !"oplus.intent.action.FOR_SMS_RCS_GROUP_INVITE".equals(str)) {
                return false;
            }
            return true;
        }

        public final boolean i(String str) {
            if (!"oppo.intent.action.OPPO_FOR_SMS_RCS_MULTI_SEND".equals(str) && !"oplus.intent.action.FOR_SMS_RCS_MULTI_SEND".equals(str)) {
                return false;
            }
            return true;
        }

        public final boolean j(String str) {
            if (!"oppo.intent.insertcontact_resolver".equals(str) && !"oplus.intent.insertcontact_resolver".equals(str)) {
                return false;
            }
            return true;
        }

        public final boolean k(String str) {
            if (!OplusNumberMarkUtils.OplusContact.OPLUS_INSERT_CONTACTS_ACTION.equals(str) && !"com.oplus.contacts.INSERT_CONTACTS".equals(str)) {
                return false;
            }
            return true;
        }

        public final boolean l(String str) {
            if (!"oppo.intent.action.INSERT_OR_EDIT_IN_MMS".equals(str) && !"oplus.intent.action.INSERT_OR_EDIT_IN_MMS".equals(str)) {
                return false;
            }
            return true;
        }

        public final boolean m(String str) {
            if (!"oppo.intent.action.receive_vacrd".equals(str) && !"oplus.intent.action.receive_vacrd".equals(str)) {
                return false;
            }
            return true;
        }

        public final boolean n(String str) {
            if (!"com.oppo.contacts.ui.OPPO_SELECT_CONTACTS_RETURN_IDS".equals(str) && !"com.oplus.contacts.ui.SELECT_CONTACTS_RETURN_IDS".equals(str)) {
                return false;
            }
            return true;
        }

        public final boolean o(String str) {
            if (!"com.oppo.contacts.ui.OPPO_SELECT_CONTACTS_SET_RINGTONE".equals(str) && !"com.oplus.contacts.ui.SELECT_CONTACTS_SET_RINGTONE".equals(str)) {
                return false;
            }
            return true;
        }

        public final void p(Intent intent, CharSequence charSequence, String str) {
            kotlin.jvm.internal.i.f(intent, "intent");
            intent.putExtra("OPPO_DETAIL_CONTACT_NAME", charSequence);
            intent.putExtra("OPPO_DETAIL_CONTACT_PHONENUMBER", str);
        }

        public /* synthetic */ a(kotlin.jvm.internal.f fVar) {
            this();
        }
    }

    public static final void a(IntentFilter intentFilter) {
        f36278a.a(intentFilter);
    }

    public static final boolean b(String str) {
        return f36278a.b(str);
    }

    public static final boolean c(String str) {
        return f36278a.c(str);
    }

    public static final boolean d(String str) {
        return f36278a.d(str);
    }

    public static final boolean e(String str) {
        return f36278a.e(str);
    }

    public static final boolean f(String str) {
        return f36278a.f(str);
    }

    public static final boolean g(String str) {
        return f36278a.g(str);
    }

    public static final boolean h(String str) {
        return f36278a.h(str);
    }

    public static final boolean i(String str) {
        return f36278a.i(str);
    }

    public static final boolean j(String str) {
        return f36278a.j(str);
    }

    public static final boolean k(String str) {
        return f36278a.k(str);
    }

    public static final boolean l(String str) {
        return f36278a.l(str);
    }

    public static final boolean m(String str) {
        return f36278a.m(str);
    }

    public static final boolean n(String str) {
        return f36278a.n(str);
    }

    public static final boolean o(String str) {
        return f36278a.o(str);
    }

    public static final void p(Intent intent, CharSequence charSequence, String str) {
        f36278a.p(intent, charSequence, str);
    }
}
