package com.android.incallui;

import android.content.Context;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.provider.ContactsContract;
import android.telephony.PhoneNumberUtils;
import com.android.contacts.business.calllog.breenocall.BreenoCallContract;
import com.internal_dependency.InternalSdkDepends;
import com.oplus.backup.sdk.common.utils.ModuleType;

/* loaded from: classes.dex */
public class CallerInfo {
    private static final String IS_VIP = "is_vip";
    private static final String PHONE_LOOKUP_COMPANY = "company";
    private static final String PHONE_LOOKUP_TITLE = "title";
    private static final String TAG = "CallerInfo";
    public Drawable cachedPhoto;
    public String cnapName;
    public String company;
    public Uri contactDisplayPhotoUri;
    public boolean contactExists;
    public long contactIdOrZero;
    public Uri contactPhotoThumbnailUri;
    public Uri contactRefUri;
    public Uri contactRingtoneUri;
    public String forwardingNumber;
    public boolean isCachedPhotoCurrent;
    public String lookupKeyOrNull;
    public String name;
    public int namePresentation;
    public boolean needUpdate;
    public String normalizedNumber;
    public String numberLabel;
    public int numberPresentation;
    public int numberType;
    public String omojiColor;
    public Uri omojiPhotoUri;
    public String phoneLabel;
    public String phoneNumber;
    public int photoResource;
    public boolean shouldSendToVoicemail;
    public boolean starred;
    public String title;
    public boolean mIsVipContact = false;
    private boolean mIsEmergency = false;
    private boolean mIsVoiceMail = false;

    public static CallerInfo doSecondaryLookupIfNecessary(Context context, String str, CallerInfo callerInfo) {
        if (!callerInfo.contactExists && InternalSdkDepends.getSInstance().isUriNumber(str)) {
            String usernameFromUriNumber = InternalSdkDepends.getSInstance().getUsernameFromUriNumber(str);
            if (PhoneNumberUtils.isGlobalPhoneNumber(usernameFromUriNumber)) {
                return getCallerInfo(context, Uri.withAppendedPath(ContactsContract.PhoneLookup.ENTERPRISE_CONTENT_FILTER_URI, Uri.encode(usernameFromUriNumber)));
            }
            return callerInfo;
        }
        return callerInfo;
    }

    /* JADX WARN: Code restructure failed: missing block: B:6:0x0245, code lost:
    
        if (r13.isClosed() == false) goto L91;
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x0231, code lost:
    
        r13.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:96:0x022f, code lost:
    
        if (r13.isClosed() != false) goto L100;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static com.android.incallui.CallerInfo getCallerInfo(android.content.Context r11, android.net.Uri r12, android.database.Cursor r13) {
        /*
            Method dump skipped, instructions count: 597
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.incallui.CallerInfo.getCallerInfo(android.content.Context, android.net.Uri, android.database.Cursor):com.android.incallui.CallerInfo");
    }

    private static int getColumnIndexForPersonId(Uri uri, Cursor cursor) {
        int i10;
        Log.v(TAG, "- getColumnIndexForPersonId: contactRef URI = '" + D2.g.o(uri) + "'...");
        String uri2 = uri.toString();
        String str = "contact_id";
        if (uri2.startsWith("content://com.android.contacts/data/phones")) {
            Log.v(TAG, "'data/phones' URI; using RawContacts.CONTACT_ID");
        } else if (uri2.startsWith("content://com.android.contacts/data")) {
            Log.v(TAG, "'data' URI; using Data.CONTACT_ID");
        } else if (uri2.startsWith("content://com.android.contacts/phone_lookup")) {
            Log.v(TAG, "'phone_lookup' URI; using PhoneLookup._ID");
            str = BreenoCallContract.BaseColumns._ID;
        } else {
            Log.v(TAG, "Unexpected prefix for contactRef '" + D2.g.o(uri2) + "'");
            str = null;
        }
        if (str != null) {
            i10 = cursor.getColumnIndex(str);
        } else {
            i10 = -1;
        }
        Log.v(TAG, "==> Using column '" + str + "' (columnIndex = " + i10 + ") for person_id lookup...");
        return i10;
    }

    private static String normalize(String str) {
        if (str != null && str.length() <= 0) {
            return null;
        }
        return str;
    }

    public boolean isEmergencyNumber() {
        return this.mIsEmergency;
    }

    public boolean isVoiceMailNumber() {
        return this.mIsVoiceMail;
    }

    public CallerInfo markAsEmergency(Context context) {
        this.phoneNumber = context.getString(R.string.emergency_call_dialog_number_for_display);
        this.mIsEmergency = true;
        return this;
    }

    public CallerInfo markAsVoiceMail(Context context) {
        this.mIsVoiceMail = true;
        try {
            this.phoneNumber = D2.l.d(context);
        } catch (SecurityException e10) {
            Log.e(TAG, "Cannot access VoiceMail.", (Exception) e10);
        }
        return this;
    }

    public String toString() {
        String str;
        if (Log.sDebug) {
            StringBuilder sb = new StringBuilder(ModuleType.TYPE_SYSTEM_SETTING);
            sb.append(super.toString() + " { ");
            sb.append("\nname: " + D2.g.o(this.name));
            sb.append("\nphoneNumber: " + D2.g.l(this.phoneNumber));
            sb.append("\ncompany: " + D2.g.o(this.company));
            sb.append("\ntitle: " + D2.g.o(this.title));
            sb.append("\nnormalizedNumber: " + D2.g.l(this.normalizedNumber));
            sb.append("\forwardingNumber: " + D2.g.l(this.forwardingNumber));
            sb.append("\ncnapName: " + D2.g.o(this.cnapName));
            sb.append("\nnumberPresentation: " + this.numberPresentation);
            sb.append("\nnamePresentation: " + this.namePresentation);
            sb.append("\ncontactExists: " + this.contactExists);
            sb.append("\nphoneLabel: " + D2.g.o(this.phoneLabel));
            sb.append("\nnumberType: " + this.numberType);
            sb.append("\nnumberLabel: " + D2.g.o(this.numberLabel));
            sb.append("\nphotoResource: " + this.photoResource);
            sb.append("\ncontactIdOrZero: " + this.contactIdOrZero);
            sb.append("\nneedUpdate: " + this.needUpdate);
            sb.append("\ncontactRefUri: " + D2.g.o(this.contactRefUri));
            sb.append("\ncontactRingtoneUri: " + this.contactRingtoneUri);
            sb.append("\ncontactDisplayPhotoUri: " + this.contactDisplayPhotoUri);
            sb.append("\nomojiPhotoUri: " + D2.g.o(this.omojiPhotoUri));
            sb.append("\nomojiColor: " + this.omojiColor);
            sb.append("\nshouldSendToVoicemail: " + this.shouldSendToVoicemail);
            sb.append("\ncachedPhoto: " + this.cachedPhoto);
            sb.append("\nisCachedPhotoCurrent: " + this.isCachedPhotoCurrent);
            sb.append("\nemergency: " + this.mIsEmergency);
            sb.append("\nvoicemail " + this.mIsVoiceMail);
            sb.append(" }");
            return sb.toString();
        }
        StringBuilder sb2 = new StringBuilder(128);
        sb2.append(super.toString() + " { ");
        StringBuilder sb3 = new StringBuilder();
        sb3.append("name ");
        String str2 = "non-null";
        if (this.name != null) {
            str = "non-null";
        } else {
            str = "null";
        }
        sb3.append(str);
        sb2.append(sb3.toString());
        StringBuilder sb4 = new StringBuilder();
        sb4.append(", phoneNumber ");
        if (this.phoneNumber == null) {
            str2 = "null";
        }
        sb4.append(str2);
        sb2.append(sb4.toString());
        sb2.append(" }");
        return sb2.toString();
    }

    public CallerInfo markAsEmergency(Context context, String str) {
        String normalizeNumber = PhoneNumberUtils.normalizeNumber(str);
        if (context.getResources().getBoolean(R.bool.config_emergency_display)) {
            this.name = context.getString(R.string.emergency_call_dialog_number_for_display_operator);
        } else {
            this.name = context.getString(R.string.emergency_call_dialog_number_for_display) + " " + normalizeNumber;
        }
        this.phoneNumber = null;
        this.photoResource = R.drawable.img_phone;
        this.mIsEmergency = true;
        return this;
    }

    public static CallerInfo getCallerInfo(Context context, Uri uri) {
        return getCallerInfo(context, uri, context.getContentResolver().query(uri, null, null, null, null));
    }
}
