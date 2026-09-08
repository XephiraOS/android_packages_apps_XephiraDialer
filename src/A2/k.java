package A2;

import android.text.TextUtils;
import com.android.incallui.ContactInfoCache;
import com.android.incallui.InCallPresenter;
import com.android.incallui.Log;
import com.android.incallui.OplusPhoneUtils;
import com.google.common.collect.Maps;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import w2.InterfaceC1646a;

/* compiled from: OplusContactsQueryCallback.java */
/* loaded from: classes.dex */
public class k {

    /* renamed from: a, reason: collision with root package name */
    public HashMap<String, Set<b>> f143a = Maps.f();

    /* renamed from: b, reason: collision with root package name */
    public final HashMap<String, Set<b>> f144b = Maps.f();

    /* renamed from: c, reason: collision with root package name */
    public ContactInfoCache.ContactInfoCacheCallback f145c;

    /* renamed from: d, reason: collision with root package name */
    public a f146d;

    /* renamed from: e, reason: collision with root package name */
    public InterfaceC1646a f147e;

    /* compiled from: OplusContactsQueryCallback.java */
    /* loaded from: classes.dex */
    public interface a {
        void onQueryCustomRecordComplete(String str, ContactInfoCache.ContactCacheEntry contactCacheEntry);
    }

    /* compiled from: OplusContactsQueryCallback.java */
    /* loaded from: classes.dex */
    public interface b extends ContactInfoCache.ContactInfoCacheCallback {
        boolean isInterceptQuery();

        void onQueryCallLogComplete(String str, ContactInfoCache.ContactCacheEntry contactCacheEntry);

        void onQueryCustomRecordComplete(String str, ContactInfoCache.ContactCacheEntry contactCacheEntry);

        void onQueryLocationComplete(String str, ContactInfoCache.ContactCacheEntry contactCacheEntry);
    }

    public void a(String str, b bVar) {
        if (Log.sDebug) {
            Log.d("OplusContactsQueryCallback", "addCallBack   number = " + D2.g.l(str) + " callBack = " + bVar);
        }
        String formatQueryNumber = OplusPhoneUtils.formatQueryNumber(str);
        Set<b> d10 = d(formatQueryNumber);
        if (d10 != null) {
            d10.add(bVar);
        } else {
            HashSet d11 = com.google.common.collect.y.d();
            d11.add(bVar);
            this.f143a.put(formatQueryNumber, d11);
        }
        if (Log.sDebug) {
            Log.d("OplusContactsQueryCallback", "addCallBack   complete callBacks = " + d(formatQueryNumber));
        }
    }

    public void b() {
        if (Log.sDebug) {
            D2.g.e("OplusContactsQueryCallback", "clearResource... ");
        }
        this.f143a.clear();
    }

    public void c(String str, ContactInfoCache.ContactCacheEntry contactCacheEntry) {
        if (Log.sDebug) {
            D2.g.e("OplusContactsQueryCallback", "fireContactInfoChangeListener listener = " + this.f145c);
        }
        InterfaceC1646a interfaceC1646a = this.f147e;
        if (interfaceC1646a != null) {
            interfaceC1646a.c0();
        } else {
            ContactInfoCache.ContactInfoCacheCallback contactInfoCacheCallback = this.f145c;
            if (contactInfoCacheCallback != null) {
                contactInfoCacheCallback.onContactInfoComplete(str, contactCacheEntry);
            }
        }
        if (InCallPresenter.getInstance().getAnswerPresenter() != null) {
            InCallPresenter.getInstance().getAnswerPresenter().onContactInfoComplete(contactCacheEntry);
        }
    }

    public Set<b> d(String str) {
        String formatQueryNumber = OplusPhoneUtils.formatQueryNumber(str);
        HashMap<String, Set<b>> hashMap = this.f143a;
        if (hashMap != null) {
            return hashMap.get(formatQueryNumber);
        }
        if (Log.sDebug) {
            Log.d("OplusContactsQueryCallback", "getCallbacks...mCallBacks is null");
            return null;
        }
        return null;
    }

    public void e(String str, ContactInfoCache.ContactCacheEntry contactCacheEntry, int i10, boolean z10) {
        if (Log.sDebug) {
            D2.g.e("OplusContactsQueryCallback", "onQueryInfoChanged number = " + D2.g.l(str) + "  newState = " + A.c(i10) + " isContactState = " + z10);
        }
        switch (i10) {
            case 2:
                if (Log.sDebug) {
                    Log.d("OplusContactsQueryCallback", "QUERY_STATE_INFO_COMPLETE");
                }
                if (z10) {
                    if (!TextUtils.isEmpty(contactCacheEntry.name)) {
                        if (Log.sDebug) {
                            Log.d("OplusContactsQueryCallback", "QUERY_STATE_INFO_COMPLETE contact is exit name = " + D2.g.o(contactCacheEntry.name));
                        }
                    } else if (contactCacheEntry.yellowPageInfo.f95c != null) {
                        if (Log.sDebug) {
                            Log.d("OplusContactsQueryCallback", "QUERY_STATE_INFO_COMPLETE contact is not yellowPageName name = " + D2.g.o(contactCacheEntry.yellowPageInfo.f95c));
                        }
                        A a10 = contactCacheEntry.yellowPageInfo;
                        contactCacheEntry.name = a10.f95c;
                        contactCacheEntry.photo = a10.f101i;
                    }
                    j(str, contactCacheEntry, false);
                    h(str, contactCacheEntry);
                } else {
                    if (Log.sDebug) {
                        Log.d("OplusContactsQueryCallback", "QUERY_STATE_INFO_COMPLETE yellow page complete");
                    }
                    if (contactCacheEntry.contactQueryState == 3 && contactCacheEntry.person_id == -1) {
                        A a11 = contactCacheEntry.yellowPageInfo;
                        if (a11.f95c != null) {
                            if (Log.sDebug) {
                                Log.d("OplusContactsQueryCallback", "QUERY_STATE_INFO_COMPLETE yellow page complete send noti");
                            }
                            if (!contactCacheEntry.isShowFdnName) {
                                A a12 = contactCacheEntry.yellowPageInfo;
                                contactCacheEntry.name = a12.f95c;
                                contactCacheEntry.photo = a12.f101i;
                            }
                            j(str, contactCacheEntry, false);
                        } else if (a11.f97e == null && TextUtils.isEmpty(a11.f96d)) {
                            if (contactCacheEntry.isShowFdnName) {
                                j(str, contactCacheEntry, false);
                            }
                        } else {
                            j(str, contactCacheEntry, false);
                        }
                    } else if (contactCacheEntry.isShowFdnName) {
                        j(str, contactCacheEntry, false);
                    }
                }
                j(str, contactCacheEntry, true);
                return;
            case 3:
                if (Log.sDebug) {
                    Log.d("OplusContactsQueryCallback", "QUERY_STATE_PHOTO_COMPLETE");
                }
                if (z10) {
                    if (contactCacheEntry.photo == null && contactCacheEntry.name == null) {
                        int i11 = contactCacheEntry.yellowPageQueryState;
                        if (i11 == 3 || i11 == 2) {
                            A a13 = contactCacheEntry.yellowPageInfo;
                            if (a13.f95c != null || a13.f101i != null || a13.f97e != null || !TextUtils.isEmpty(a13.f96d)) {
                                if (Log.sDebug) {
                                    Log.d("OplusContactsQueryCallback", "QUERY_STATE_PHOTO_COMPLETE  contact is not exit ");
                                }
                                A a14 = contactCacheEntry.yellowPageInfo;
                                contactCacheEntry.name = a14.f95c;
                                contactCacheEntry.photo = a14.f101i;
                                i(contactCacheEntry, str, false);
                            }
                        }
                        if (contactCacheEntry.person_id == -1) {
                            if (Log.sDebug) {
                                Log.d("OplusContactsQueryCallback", "QUERY_STATE_PHOTO_COMPLETE  to callback contact info for stranger call");
                            }
                            i(contactCacheEntry, str, false);
                        }
                    } else {
                        if (Log.sDebug) {
                            Log.d("OplusContactsQueryCallback", "QUERY_STATE_PHOTO_COMPLETE  contact is exit photo = " + contactCacheEntry.photo);
                        }
                        i(contactCacheEntry, str, false);
                    }
                    h(str, contactCacheEntry);
                } else if (contactCacheEntry.contactQueryState == 3 && contactCacheEntry.person_id == -1) {
                    A a15 = contactCacheEntry.yellowPageInfo;
                    if (a15.f95c != null || a15.f97e != null || !TextUtils.isEmpty(a15.f96d)) {
                        if (!contactCacheEntry.isShowFdnName) {
                            A a16 = contactCacheEntry.yellowPageInfo;
                            contactCacheEntry.name = a16.f95c;
                            contactCacheEntry.photo = a16.f101i;
                        }
                        i(contactCacheEntry, str, false);
                    }
                }
                i(contactCacheEntry, str, true);
                return;
            case 4:
                if (Log.sDebug) {
                    Log.d("OplusContactsQueryCallback", "QUERY_STATE_LOCATION_COMPLETE update...");
                }
                k(str, contactCacheEntry);
                return;
            case 5:
                g(str, contactCacheEntry);
                return;
            case 6:
                h(str, contactCacheEntry);
                return;
            case 7:
                j(str, contactCacheEntry, false);
                return;
            default:
                return;
        }
    }

    public void f(String str, ContactInfoCache.ContactInfoCacheCallback contactInfoCacheCallback) {
        if (Log.sDebug) {
            D2.g.e("OplusContactsQueryCallback", "removeCallback number = " + D2.g.l(str) + "  callback = " + contactInfoCacheCallback);
        }
        if (str != null && contactInfoCacheCallback != null) {
            Set<b> d10 = d(str);
            if (Log.sDebug) {
                Log.d("OplusContactsQueryCallback", "removeCallback old set  = " + d10);
            }
            if (d10 != null && d10.contains(contactInfoCacheCallback)) {
                d10.remove(contactInfoCacheCallback);
            }
            Set<b> d11 = d(str);
            if (Log.sDebug) {
                D2.g.e("OplusContactsQueryCallback", "removeCallback new set  = " + d11);
            }
        }
    }

    public void g(String str, ContactInfoCache.ContactCacheEntry contactCacheEntry) {
        Set<b> d10 = d(str);
        if (Log.sDebug) {
            D2.g.e("OplusContactsQueryCallback", "sendCallLogInfoNotifications");
        }
        if (d10 != null) {
            for (b bVar : d10) {
                if (bVar.isInterceptQuery()) {
                    bVar.onQueryCallLogComplete(str, contactCacheEntry);
                }
            }
        }
    }

    public void h(String str, ContactInfoCache.ContactCacheEntry contactCacheEntry) {
        if (contactCacheEntry != null && contactCacheEntry.customRecordQueryState == 6) {
            int i10 = contactCacheEntry.contactQueryState;
            if (i10 == 2 || i10 == 3) {
                Set<b> d10 = d(str);
                if (d10 != null) {
                    Iterator<b> it = d10.iterator();
                    while (it.hasNext()) {
                        it.next().onQueryCustomRecordComplete(str, contactCacheEntry);
                    }
                }
                a aVar = this.f146d;
                if (aVar != null) {
                    aVar.onQueryCustomRecordComplete(str, contactCacheEntry);
                }
            }
        }
    }

    public void i(ContactInfoCache.ContactCacheEntry contactCacheEntry, String str, boolean z10) {
        Set<b> d10 = d(str);
        if (Log.sDebug) {
            D2.g.e("OplusContactsQueryCallback", "sendImageNotifications... number = " + D2.g.l(str) + "  callBacks = " + d10 + "  isInterceptCallback = " + z10);
        }
        if (d10 != null) {
            for (b bVar : d10) {
                if (bVar.isInterceptQuery() == z10) {
                    bVar.onImageLoadComplete(str, contactCacheEntry);
                }
            }
        }
    }

    public void j(String str, ContactInfoCache.ContactCacheEntry contactCacheEntry, boolean z10) {
        Set<b> d10 = d(str);
        if (Log.sDebug) {
            D2.g.e("OplusContactsQueryCallback", "sendInfoNotifications... number = " + D2.g.l(str) + "  callBacks = " + d10 + "  isInterceptCallback = " + z10);
        }
        if (d10 != null) {
            for (b bVar : d10) {
                if (bVar.isInterceptQuery() == z10) {
                    bVar.onContactInfoComplete(str, contactCacheEntry);
                }
            }
        }
    }

    public void k(String str, ContactInfoCache.ContactCacheEntry contactCacheEntry) {
        Set<b> d10 = d(str);
        if (Log.sDebug) {
            D2.g.e("OplusContactsQueryCallback", "sendLocationInfoNotifications... number = " + D2.g.l(str) + "  callBacks = " + d10);
        }
        if (d10 != null) {
            for (b bVar : d10) {
                if (!bVar.isInterceptQuery()) {
                    bVar.onQueryLocationComplete(str, contactCacheEntry);
                }
            }
        }
    }

    public void l(ContactInfoCache.ContactInfoCacheCallback contactInfoCacheCallback) {
        this.f145c = contactInfoCacheCallback;
    }

    public void m(a aVar) {
        this.f146d = aVar;
    }

    public void n(InterfaceC1646a interfaceC1646a) {
        this.f147e = interfaceC1646a;
        if (interfaceC1646a != null) {
            interfaceC1646a.c0();
        }
    }
}
