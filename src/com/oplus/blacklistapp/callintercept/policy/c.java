package com.oplus.blacklistapp.callintercept.policy;

import android.text.TextUtils;
import com.oplus.blacklistapp.callintercept.policy.a;
import com.oplus.utils.C0846g;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import v6.C1627a;

/* compiled from: ContactsQueryCallback.java */
/* loaded from: classes3.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    public final HashMap<String, Set<a>> f26661a = new HashMap<>();

    /* renamed from: b, reason: collision with root package name */
    public final HashMap<String, Set<a>> f26662b = new HashMap<>();

    /* compiled from: ContactsQueryCallback.java */
    /* loaded from: classes3.dex */
    public interface a extends a.b {
        void a(String str, a.C0239a c0239a);

        void b(String str, a.C0239a c0239a);

        void c(String str, a.C0239a c0239a);

        boolean isInterceptQuery();
    }

    public void a(String str, a aVar) {
        if (C1627a.f37411c) {
            C1627a.c("ContactsQueryCallback", "addCallBack   number = " + C0846g.f(str) + " callBack = " + aVar);
        }
        Set<a> set = this.f26661a.get(str);
        if (set != null) {
            set.add(aVar);
        } else {
            HashSet hashSet = new HashSet();
            hashSet.add(aVar);
            this.f26661a.put(str, hashSet);
        }
        if (C1627a.f37411c) {
            C1627a.c("ContactsQueryCallback", "addCallBack   complete callBacks = " + this.f26661a.get(str));
        }
    }

    public void b() {
        if (C1627a.f37411c) {
            C1627a.e("ContactsQueryCallback", "clearResource... mCallBacks = " + this.f26661a.values());
        }
        this.f26661a.clear();
    }

    public void c(String str) {
        if (C1627a.f37411c) {
            C1627a.c("ContactsQueryCallback", "clearCallbacks... number = " + C0846g.f(str) + "  mCallBacks = " + this.f26661a.values());
        }
        this.f26661a.remove(str);
    }

    public void d(String str, a.C0239a c0239a, int i10, boolean z10) {
        f fVar;
        String str2;
        if (C1627a.f37411c) {
            C1627a.e("ContactsQueryCallback", "onQueryInfoChanged number = " + C0846g.f(str) + "  newState = " + f.b(i10) + " isContactState = " + z10);
        }
        if (i10 != 2) {
            if (i10 != 3) {
                if (i10 != 4) {
                    if (i10 != 5) {
                        if (i10 == 6) {
                            f(str, c0239a);
                            return;
                        }
                        return;
                    }
                    e(str, c0239a);
                    return;
                }
                if (C1627a.f37411c) {
                    C1627a.c("ContactsQueryCallback", "QUERY_STATE_LOCATION_COMPLETE update...");
                }
                i(str, c0239a);
                return;
            }
            if (C1627a.f37411c) {
                C1627a.c("ContactsQueryCallback", "QUERY_STATE_PHOTO_COMPLETE");
            }
            if (z10) {
                if (c0239a.f26628e == null && c0239a.f26624a == null) {
                    int i11 = c0239a.f26641r;
                    if (i11 == 3 || i11 == 2) {
                        f fVar2 = c0239a.f26640q;
                        if (fVar2.f26720c != null || fVar2.f26725h != null || fVar2.f26721d != null) {
                            if (C1627a.f37411c) {
                                C1627a.c("ContactsQueryCallback", "QUERY_STATE_PHOTO_COMPLETE  contact is not exit ");
                            }
                            f fVar3 = c0239a.f26640q;
                            c0239a.f26624a = fVar3.f26720c;
                            c0239a.f26628e = fVar3.f26725h;
                            g(c0239a, str, false);
                        }
                    }
                } else {
                    if (C1627a.f37411c) {
                        C1627a.c("ContactsQueryCallback", "QUERY_STATE_PHOTO_COMPLETE  contact is exit photo = " + c0239a.f26628e);
                    }
                    g(c0239a, str, false);
                }
                f(str, c0239a);
            } else if (c0239a.f26639p == 3 && c0239a.f26638o == -1 && ((str2 = (fVar = c0239a.f26640q).f26720c) != null || fVar.f26721d != null)) {
                c0239a.f26624a = str2;
                c0239a.f26628e = fVar.f26725h;
                g(c0239a, str, false);
            }
            g(c0239a, str, true);
            return;
        }
        if (C1627a.f37411c) {
            C1627a.c("ContactsQueryCallback", "QUERY_STATE_INFO_COMPLETE");
        }
        if (z10) {
            if (!TextUtils.isEmpty(c0239a.f26624a)) {
                if (C1627a.f37411c) {
                    C1627a.c("ContactsQueryCallback", "QUERY_STATE_INFO_COMPLETE contact is exit");
                }
            } else if (c0239a.f26640q.f26720c != null) {
                if (C1627a.f37411c) {
                    C1627a.c("ContactsQueryCallback", "QUERY_STATE_INFO_COMPLETE contact is not yellowPageName");
                }
                f fVar4 = c0239a.f26640q;
                c0239a.f26624a = fVar4.f26720c;
                c0239a.f26628e = fVar4.f26725h;
            }
            h(str, c0239a, false);
            f(str, c0239a);
        } else {
            if (C1627a.f37411c) {
                C1627a.c("ContactsQueryCallback", "QUERY_STATE_INFO_COMPLETE yellow page complete");
            }
            if (c0239a.f26639p == 3 && c0239a.f26638o == -1) {
                f fVar5 = c0239a.f26640q;
                if (fVar5.f26720c != null) {
                    if (C1627a.f37411c) {
                        C1627a.c("ContactsQueryCallback", "QUERY_STATE_INFO_COMPLETE yellow page complete send noti");
                    }
                    f fVar6 = c0239a.f26640q;
                    c0239a.f26624a = fVar6.f26720c;
                    c0239a.f26628e = fVar6.f26725h;
                    h(str, c0239a, false);
                } else if (fVar5.f26721d != null) {
                    h(str, c0239a, false);
                }
            }
        }
        h(str, c0239a, true);
    }

    public final void e(String str, a.C0239a c0239a) {
        Set<a> set = this.f26661a.get(str);
        if (C1627a.f37411c) {
            C1627a.e("ContactsQueryCallback", "sendCallLogInfoNotifications  callBacks = " + set);
        }
        if (set != null) {
            for (a aVar : set) {
                if (aVar.isInterceptQuery()) {
                    aVar.b(str, c0239a);
                }
            }
        }
    }

    public final void f(String str, a.C0239a c0239a) {
        Set<a> set;
        if (c0239a != null && c0239a.f26617A == 6) {
            int i10 = c0239a.f26639p;
            if ((i10 == 2 || i10 == 3) && (set = this.f26661a.get(str)) != null) {
                Iterator<a> it = set.iterator();
                while (it.hasNext()) {
                    it.next().c(str, c0239a);
                }
            }
        }
    }

    public final void g(a.C0239a c0239a, String str, boolean z10) {
        Set<a> set = this.f26661a.get(str);
        if (C1627a.f37411c) {
            C1627a.e("ContactsQueryCallback", "sendImageNotifications... number = " + C0846g.f(str) + "  callBacks = " + set + "  isInterceptCallback = " + z10);
        }
        if (set != null) {
            for (a aVar : set) {
                if (aVar.isInterceptQuery() == z10) {
                    aVar.e(str, c0239a);
                }
            }
        }
    }

    public final void h(String str, a.C0239a c0239a, boolean z10) {
        Set<a> set = this.f26661a.get(str);
        if (C1627a.f37411c) {
            C1627a.e("ContactsQueryCallback", "sendInfoNotifications... number = " + C0846g.f(str) + "  callBacks = " + set + "  isInterceptCallback = " + z10);
        }
        if (set != null) {
            for (a aVar : set) {
                if (aVar.isInterceptQuery() == z10) {
                    aVar.d(str, c0239a);
                }
            }
        }
    }

    public final void i(String str, a.C0239a c0239a) {
        Set<a> set = this.f26661a.get(str);
        if (C1627a.f37411c) {
            C1627a.e("ContactsQueryCallback", "sendLocationInfoNotifications... number = " + C0846g.f(str) + "  callBacks = " + set);
        }
        if (set != null) {
            for (a aVar : set) {
                if (!aVar.isInterceptQuery()) {
                    aVar.a(str, c0239a);
                }
            }
        }
    }
}
