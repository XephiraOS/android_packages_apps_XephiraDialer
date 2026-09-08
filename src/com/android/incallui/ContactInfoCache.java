package com.android.incallui;

import F2.a;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Looper;
import android.provider.ContactsContract;
import android.text.TextUtils;
import com.android.incallui.CallerInfoAsyncQuery;
import com.android.incallui.ContactsAsyncHelper;
import com.google.common.collect.Maps;
import com.internal_dependency.InternalSdkDepends;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* loaded from: classes.dex */
public class ContactInfoCache implements ContactsAsyncHelper.OnImageLoadCompleteListener {
    private static final String TAG = "ContactInfoCache";
    public static final int TOKEN_UPDATE_PHOTO_FOR_CALL_STATE = 0;
    private static ContactInfoCache sCache;
    private final Context mContext;
    private final F2.a mPhoneNumberService;
    private final HashMap<String, ContactCacheEntry> mInfoMap = Maps.f();
    private final HashMap<String, Set<ContactInfoCacheCallback>> mCallBacks = Maps.f();

    /* loaded from: classes.dex */
    public static class ContactCacheEntry {
        public String callId;
        public int callState;
        public String company;
        public Uri contactPhotoThumbnailUri;
        public Uri contactUri;
        public long createTime;
        public Uri displayPhotoUri;
        public String fdnName;
        public boolean isIncomingCall;
        public boolean isLocked;
        public boolean isSipCall;
        public String label;
        public String location;
        public String lookupKey;
        public Uri lookupUri;
        public String name;
        public String number;
        public String omojiColor;
        public Drawable omojiPhoto;
        public Uri omojiPhotoUri;
        public Uri personUri;
        public Drawable photo;
        public String title;
        public int slotId = -1;
        public int subId = -1;
        public long person_id = -1;
        public int contactQueryState = 0;
        public A2.A yellowPageInfo = new A2.A();
        public int yellowPageQueryState = 0;
        public int whiteListQueryState = 0;
        public boolean isWhiteListNumber = false;
        public int locationQueryState = 0;
        public long lastCallTime = 0;
        public int callLogQueryState = 0;
        public boolean isVoiceMail = false;
        public boolean isVoiceMailComplete = false;
        public boolean isYellowPageNumber = false;
        public boolean shouldAutoRecord = false;
        public int customRecordQueryState = 0;
        public int fdnQueryState = 0;
        public boolean isShowFdnName = false;
        public long contactType = 0;
        public boolean starred = false;
        public boolean isPenetratedIncomingCall = false;
        public boolean isInWhiteList = false;

        public String toString() {
            if (Log.sDebug) {
                StringBuilder sb = new StringBuilder();
                sb.append("ContactCacheEntry{\n");
                sb.append("name: " + D2.g.o(this.name));
                sb.append("  number: " + D2.g.l(this.number));
                sb.append("  location: " + D2.g.o(this.location));
                sb.append("  label: " + D2.g.o(this.label));
                sb.append("  company: " + D2.g.o(this.company));
                sb.append("  title: " + D2.g.o(this.title));
                sb.append("  photo: " + this.photo);
                sb.append("  contactUri: " + D2.g.o(this.contactUri));
                sb.append("  displayPhotoUri: " + this.displayPhotoUri);
                sb.append("  subId: " + this.subId);
                sb.append("  slotId: " + this.slotId);
                sb.append("  callState: " + this.callState + "\n");
                StringBuilder sb2 = new StringBuilder();
                sb2.append("  person_id: ");
                sb2.append(this.person_id);
                sb.append(sb2.toString());
                sb.append("  lookupKey: " + this.lookupKey);
                sb.append("  contactQueryState: " + A2.A.c(this.contactQueryState));
                sb.append("  yellowPageName: " + D2.g.o(this.yellowPageInfo.f95c));
                sb.append("  mAntiFraudCenterNumber: " + D2.g.o(this.yellowPageInfo.f96d));
                sb.append("  markInfo: " + this.yellowPageInfo.f97e);
                sb.append("  markInfoCounter: " + this.yellowPageInfo.f98f);
                sb.append("  markInfoType: " + this.yellowPageInfo.f99g);
                sb.append("  yellowPagePhoto: " + this.yellowPageInfo.f101i);
                sb.append("  yellowPageQureyState: " + A2.A.c(this.yellowPageQueryState) + "\n");
                StringBuilder sb3 = new StringBuilder();
                sb3.append("  isIncomingCall: ");
                sb3.append(this.isIncomingCall);
                sb.append(sb3.toString());
                sb.append("  isLocked: " + this.isLocked);
                sb.append("  locationQueryState: " + A2.A.c(this.locationQueryState));
                sb.append("  lastCallTime: " + this.lastCallTime);
                sb.append("  callLogQueryState: " + A2.A.c(this.callLogQueryState));
                sb.append("  isVoiceMail: " + this.isVoiceMail);
                sb.append("  isYellowPageNumber: " + this.isYellowPageNumber);
                sb.append("  shouldAutoRecord: " + this.shouldAutoRecord);
                sb.append("  contactType: " + this.contactType);
                sb.append("  starred: " + this.starred);
                sb.append("  isPenetratedIncomingCall: " + this.isPenetratedIncomingCall);
                sb.append("  isInWhiteList: " + this.isInWhiteList);
                sb.append("  whiteListQueryState: " + A2.A.c(this.whiteListQueryState));
                sb.append("  isWhiteListNumber: " + this.isWhiteListNumber);
                sb.append("  customRecordQueryState: " + this.customRecordQueryState);
                sb.append("\n}");
                return sb.toString();
            }
            return "ContactCacheEntry{name='" + D2.g.o(this.name) + "', number='" + D2.g.l(this.number) + "', location='" + D2.g.o(this.location) + "', label='" + D2.g.o(this.label) + "', photo=" + this.photo + ", isSipCall=" + this.isSipCall + ", contactUri=" + D2.g.o(this.contactUri) + ", displayPhotoUri=" + this.displayPhotoUri + '}';
        }
    }

    /* loaded from: classes.dex */
    public interface ContactInfoCacheCallback {
        void onContactInfoComplete(String str, ContactCacheEntry contactCacheEntry);

        void onImageLoadComplete(String str, ContactCacheEntry contactCacheEntry);
    }

    /* loaded from: classes.dex */
    public static class ContactType {
        public static final int CONTACT_TYPE_NORMAL = 0;
        public static final int CONTACT_TYPE_VIP = 1;

        public static final boolean isVipContact(long j10) {
            if (j10 == 1) {
                return true;
            }
            return false;
        }
    }

    /* loaded from: classes.dex */
    public class FindInfoCallback implements CallerInfoAsyncQuery.OnQueryCompleteListener {
        private final boolean mIsIncoming;

        public FindInfoCallback(boolean z10) {
            this.mIsIncoming = z10;
        }

        @Override // com.android.incallui.CallerInfoAsyncQuery.OnQueryCompleteListener
        public void onQueryComplete(int i10, Object obj, CallerInfo callerInfo) {
            ContactInfoCache.this.findInfoQueryComplete((Call) obj, callerInfo, this.mIsIncoming, true);
        }

        public void onQuickImageLoadComplete(Drawable drawable, Object obj) {
            ContactInfoCache.this.onImageLoadComplete(-1, drawable, null, obj);
        }
    }

    /* loaded from: classes.dex */
    public class PhoneNumberServiceListener {
        private final String mCallId;

        public PhoneNumberServiceListener(String str) {
            this.mCallId = str;
        }

        public void onImageFetchComplete(Bitmap bitmap) {
            ContactInfoCache.this.onImageLoadComplete(0, null, bitmap, this.mCallId);
        }

        public void onPhoneNumberInfoComplete(a.InterfaceC0013a interfaceC0013a) {
            String charSequence;
            if (interfaceC0013a == null) {
                Log.d(ContactInfoCache.TAG, "Contact lookup done. Remote contact not found.");
                ContactInfoCache.this.clearCallbacks(this.mCallId);
                return;
            }
            ContactCacheEntry contactCacheEntry = new ContactCacheEntry();
            contactCacheEntry.name = interfaceC0013a.b();
            contactCacheEntry.number = interfaceC0013a.getNumber();
            int e10 = interfaceC0013a.e();
            String a10 = interfaceC0013a.a();
            if (e10 == 0) {
                contactCacheEntry.label = a10;
            } else {
                CharSequence typeLabel = ContactsContract.CommonDataKinds.Phone.getTypeLabel(ContactInfoCache.this.mContext.getResources(), e10, a10);
                if (typeLabel == null) {
                    charSequence = null;
                } else {
                    charSequence = typeLabel.toString();
                }
                contactCacheEntry.label = charSequence;
            }
            ContactCacheEntry contactCacheEntry2 = (ContactCacheEntry) ContactInfoCache.this.mInfoMap.get(this.mCallId);
            if (contactCacheEntry2 != null) {
                contactCacheEntry.location = contactCacheEntry2.location;
            }
            if (interfaceC0013a.c() == null && interfaceC0013a.d()) {
                Log.d(ContactInfoCache.TAG, "Business has no image. Using default.");
            }
            contactCacheEntry.callId = this.mCallId;
            ContactInfoCache.this.mInfoMap.put(this.mCallId, contactCacheEntry);
            ContactInfoCache.this.sendInfoNotifications(this.mCallId, contactCacheEntry);
            if (interfaceC0013a.c() == null) {
                ContactInfoCache.this.clearCallbacks(this.mCallId);
            }
        }
    }

    private ContactInfoCache(Context context) {
        this.mContext = context;
        H2.a.b(context);
    }

    public static ContactCacheEntry buildCacheEntryFromCall(Context context, Call call, boolean z10) {
        ContactCacheEntry contactCacheEntry = new ContactCacheEntry();
        populateCacheEntry(context, CallerInfoUtils.buildCallerInfo(context, call), contactCacheEntry, call.getNumberPresentation(), z10);
        return contactCacheEntry;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearCallbacks(String str) {
        this.mCallBacks.remove(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void findInfoQueryComplete(Call call, CallerInfo callerInfo, boolean z10, boolean z11) {
        String str;
        String id = call.getId();
        int numberPresentation = call.getNumberPresentation();
        if (callerInfo.contactExists || callerInfo.isEmergencyNumber() || callerInfo.isVoiceMailNumber()) {
            numberPresentation = 1;
        }
        int i10 = numberPresentation;
        String str2 = TAG;
        if (("findInfoQueryComplete didLocalLookup = " + z11 + "  call id = " + call) != null) {
            str = call.getId();
        } else {
            str = null;
        }
        Log.d(str2, str);
        if (!TextUtils.isEmpty(call.getNumber())) {
            callerInfo.phoneNumber = call.getNumber();
        }
        if (callerInfo.isVoiceMailNumber()) {
            if (D2.l.i(this.mContext)) {
                int subId = call.getSubId();
                if (subId > 0) {
                    callerInfo.phoneNumber = D2.l.f(this.mContext, subId, call.getAccountHandle());
                }
            } else {
                callerInfo.phoneNumber = D2.l.e(this.mContext);
            }
        }
        ContactCacheEntry contactCacheEntry = this.mInfoMap.get(id);
        if (!z11 || callerInfo.contactExists || (contactCacheEntry != null && TextUtils.isEmpty(contactCacheEntry.name))) {
            contactCacheEntry = buildEntry(this.mContext, id, callerInfo, i10, z10);
            this.mInfoMap.put(id, contactCacheEntry);
        }
        sendInfoNotifications(id, contactCacheEntry);
        if (z11) {
            boolean z12 = callerInfo.contactExists;
            if (contactCacheEntry != null && (contactCacheEntry.displayPhotoUri != null || contactCacheEntry.omojiPhotoUri != null)) {
                Log.d(str2, "Contact lookup. Local contact found, starting image load");
                ContactsAsyncHelper.startObtainPhotoAsync(0, this.mContext, contactCacheEntry.displayPhotoUri, contactCacheEntry.contactPhotoThumbnailUri, contactCacheEntry.omojiPhotoUri, this, id);
            } else if (z12) {
                Log.d(str2, "Contact lookup done. Local contact found, no image.");
                clearCallbacks(id);
            } else {
                Log.d(str2, "Contact lookup done. Local contact not found and no remote lookup service available.");
            }
        }
    }

    public static synchronized ContactInfoCache getInstance(Context context) {
        ContactInfoCache contactInfoCache;
        synchronized (ContactInfoCache.class) {
            try {
                if (sCache == null) {
                    sCache = new ContactInfoCache(context.getApplicationContext());
                }
                contactInfoCache = sCache;
            } catch (Throwable th) {
                throw th;
            }
        }
        return contactInfoCache;
    }

    private static String getPresentationString(Context context, int i10) {
        String k10 = D2.b.k(context);
        if (OplusFeatureOption.OPLUS_PHONE_ADD_HARASS_INTERCEPT_TYPE) {
            String callerIdName = OplusPhoneUtils.getCallerIdName(context, i10);
            Log.d(TAG, "  ==>  get caller id name = " + D2.g.o(callerIdName));
            if (!TextUtils.isEmpty(callerIdName)) {
                return callerIdName;
            }
            return k10;
        }
        return k10;
    }

    public static void populateCacheEntry(Context context, CallerInfo callerInfo, ContactCacheEntry contactCacheEntry, int i10, boolean z10) {
        boolean z11;
        String str;
        String callerIdName;
        com.google.common.base.k.o(callerInfo);
        String str2 = callerInfo.phoneNumber;
        if (!TextUtils.isEmpty(str2)) {
            z11 = InternalSdkDepends.getSInstance().isUriNumber(str2);
            if (str2.startsWith("sip:")) {
                str2 = str2.substring(4);
            }
        } else {
            z11 = false;
        }
        String str3 = null;
        if (TextUtils.isEmpty(callerInfo.name)) {
            if (!TextUtils.isEmpty(str2) && !str2.startsWith("anonymous")) {
                if (i10 != 1) {
                    callerIdName = getPresentationString(context, i10);
                    Log.d(TAG, "  ==> presentation not allowed! ");
                } else if (!TextUtils.isEmpty(callerInfo.cnapName)) {
                    callerIdName = callerInfo.cnapName;
                    callerInfo.name = callerIdName;
                    Log.d(TAG, "  ==> cnapName available: displayNumber '" + D2.g.l(str2) + "'");
                    str = null;
                    str3 = callerIdName;
                } else {
                    Log.d(TAG, "  ==>  no name; falling back to number: displayNumber '" + D2.g.l(str2));
                    str = null;
                }
            } else {
                callerIdName = getPresentationString(context, i10);
                Log.d(TAG, "  ==> no name *or* number! ");
            }
            str2 = null;
            str = null;
            str3 = callerIdName;
        } else {
            if (i10 != 1) {
                String presentationString = getPresentationString(context, i10);
                Log.d(TAG, "  ==> valid name, but presentation not allowed!");
                str = null;
                str3 = presentationString;
                str2 = null;
            } else {
                String str4 = callerInfo.name;
                String str5 = callerInfo.phoneLabel;
                Log.d(TAG, "  ==>  name is present in CallerInfo: displayNumber '" + D2.g.l(str2) + "'");
                str3 = str4;
                str = str5;
            }
            if (OplusFeatureOption.OPLUS_PHONE_DISPLAY_CALLER_ID_NAME && (callerIdName = OplusPhoneUtils.getCallerIdName(context, i10)) != null) {
                Log.d(TAG, "  ==>  name is caller id name");
                str3 = callerIdName;
            }
        }
        contactCacheEntry.name = str3;
        contactCacheEntry.number = str2;
        contactCacheEntry.company = callerInfo.company;
        contactCacheEntry.title = callerInfo.title;
        contactCacheEntry.isVoiceMail = callerInfo.isVoiceMailNumber();
        if (Log.sOplusDebug) {
            Log.d(TAG, "isVoiceMail = " + contactCacheEntry.isVoiceMail);
        }
        contactCacheEntry.label = str;
        contactCacheEntry.isSipCall = z11;
    }

    private void sendImageNotifications(String str, ContactCacheEntry contactCacheEntry) {
        Set<ContactInfoCacheCallback> set = this.mCallBacks.get(str);
        if (set != null && contactCacheEntry.photo != null) {
            Iterator<ContactInfoCacheCallback> it = set.iterator();
            while (it.hasNext()) {
                it.next().onImageLoadComplete(str, contactCacheEntry);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendInfoNotifications(String str, ContactCacheEntry contactCacheEntry) {
        Set<ContactInfoCacheCallback> set = this.mCallBacks.get(str);
        if (set != null) {
            Iterator<ContactInfoCacheCallback> it = set.iterator();
            while (it.hasNext()) {
                it.next().onContactInfoComplete(str, contactCacheEntry);
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0018, code lost:
    
        if (r5 != null) goto L15;
     */
    /* JADX WARN: Removed duplicated region for block: B:11:0x0056  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public com.android.incallui.ContactInfoCache.ContactCacheEntry buildEntry(android.content.Context r5, java.lang.String r6, com.android.incallui.CallerInfo r7, int r8, boolean r9) {
        /*
            r4 = this;
            com.android.incallui.ContactInfoCache$ContactCacheEntry r4 = new com.android.incallui.ContactInfoCache$ContactCacheEntry
            r4.<init>()
            populateCacheEntry(r5, r7, r4, r8, r9)
            int r8 = r7.photoResource
            r9 = 0
            if (r8 == 0) goto L12
            android.graphics.drawable.Drawable r5 = r5.getDrawable(r8)
            goto L23
        L12:
            boolean r5 = r7.isCachedPhotoCurrent
            if (r5 == 0) goto L1b
            android.graphics.drawable.Drawable r5 = r7.cachedPhoto
            if (r5 == 0) goto L22
            goto L23
        L1b:
            android.net.Uri r5 = r7.contactDisplayPhotoUri
            if (r5 != 0) goto L20
            goto L22
        L20:
            r4.displayPhotoUri = r5
        L22:
            r5 = r9
        L23:
            android.net.Uri r8 = r7.contactPhotoThumbnailUri
            r4.contactPhotoThumbnailUri = r8
            android.net.Uri r8 = r7.omojiPhotoUri
            r4.omojiPhotoUri = r8
            java.lang.String r8 = r7.omojiColor
            r4.omojiColor = r8
            java.lang.String r8 = r7.lookupKeyOrNull
            if (r8 == 0) goto L43
            long r0 = r7.contactIdOrZero
            r2 = 0
            int r2 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r2 != 0) goto L3c
            goto L43
        L3c:
            android.net.Uri r8 = android.provider.ContactsContract.Contacts.getLookupUri(r0, r8)
            r4.lookupUri = r8
            goto L4c
        L43:
            java.lang.String r8 = com.android.incallui.ContactInfoCache.TAG
            java.lang.String r0 = "lookup key is null or contact ID is 0. Don't create a lookup uri."
            com.android.incallui.Log.v(r8, r0)
            r4.lookupUri = r9
        L4c:
            r4.photo = r5
            java.lang.String r5 = r7.lookupKeyOrNull
            r4.lookupKey = r5
            boolean r5 = r7.contactExists
            if (r5 == 0) goto L61
            long r7 = r7.contactIdOrZero
            r4.person_id = r7
            r7 = 1
            r4.contactType = r7
            r5 = 0
            r4.isYellowPageNumber = r5
        L61:
            r4.callId = r6
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.incallui.ContactInfoCache.buildEntry(android.content.Context, java.lang.String, com.android.incallui.CallerInfo, int, boolean):com.android.incallui.ContactInfoCache$ContactCacheEntry");
    }

    public void clearCache() {
        this.mInfoMap.clear();
        this.mCallBacks.clear();
    }

    public void findInfo(Call call, boolean z10, ContactInfoCacheCallback contactInfoCacheCallback) {
        boolean z11;
        String str;
        if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
            z11 = true;
        } else {
            z11 = false;
        }
        com.google.common.base.k.u(z11);
        com.google.common.base.k.o(contactInfoCacheCallback);
        String id = call.getId();
        ContactCacheEntry contactCacheEntry = this.mInfoMap.get(id);
        Set<ContactInfoCacheCallback> set = this.mCallBacks.get(id);
        if (contactCacheEntry != null) {
            String str2 = TAG;
            StringBuilder sb = new StringBuilder();
            sb.append("Contact lookup. In memory cache hit; lookup ");
            if (set == null) {
                str = "complete";
            } else {
                str = "still running";
            }
            sb.append(str);
            Log.d(str2, sb.toString());
            contactInfoCacheCallback.onContactInfoComplete(id, contactCacheEntry);
            if (set == null) {
                return;
            }
        }
        if (set != null) {
            set.add(contactInfoCacheCallback);
            return;
        }
        Log.d(TAG, "Contact lookup. In memory cache miss; searching provider.");
        HashSet d10 = com.google.common.collect.y.d();
        d10.add(contactInfoCacheCallback);
        this.mCallBacks.put(id, d10);
        findInfoQueryComplete(call, CallerInfoUtils.getCallerInfoForCall(this.mContext, call, new FindInfoCallback(z10)), z10, false);
    }

    public ContactCacheEntry getInfo(String str) {
        return this.mInfoMap.get(str);
    }

    @Override // com.android.incallui.ContactsAsyncHelper.OnImageLoadCompleteListener
    public void onImageLoadComplete(int i10, Drawable drawable, Bitmap bitmap, Object obj) {
        Log.d(this, "Image load complete with context: ", this.mContext);
        String str = (String) obj;
        ContactCacheEntry contactCacheEntry = this.mInfoMap.get(str);
        if (contactCacheEntry == null) {
            Log.e(this, "Image Load received for empty search entry.");
            clearCallbacks(str);
            return;
        }
        Log.d(this, "setting photo for entry: ", contactCacheEntry);
        if (contactCacheEntry.photo != null) {
            Log.d(this, "already has photo so return!!! ");
            return;
        }
        if (drawable != null) {
            Log.v(this, "direct drawable: ", drawable);
            contactCacheEntry.photo = drawable;
        } else if (bitmap != null) {
            Log.v(this, "photo icon: ", bitmap);
            contactCacheEntry.photo = new BitmapDrawable(this.mContext.getResources(), bitmap);
        } else {
            Log.v(this, "unknown photo");
            contactCacheEntry.photo = null;
        }
        sendImageNotifications(str, contactCacheEntry);
        clearCallbacks(str);
    }

    @Override // com.android.incallui.ContactsAsyncHelper.OnImageLoadCompleteListener
    public void onOmojiLoadComplete(int i10, Drawable drawable, Object obj) {
        if (Log.sDebug) {
            D2.g.k(TAG, "ContactInfoCache onOmojiLoadComplete token = " + i10 + " photo = " + drawable);
        }
    }
}
