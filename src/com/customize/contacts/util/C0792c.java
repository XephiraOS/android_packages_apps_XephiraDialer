package com.customize.contacts.util;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.provider.ContactsContract;
import android.text.TextUtils;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.android.contacts.activities.ContactEditorActivity;
import com.android.contacts.framework.baseui.util.C0636a;
import com.android.contacts.framework.baseui.util.C0637b;
import com.android.incallui.OplusNumberMarkUtils;
import com.android.incallui.OplusPhoneCapabilities;
import com.android.incallui.OplusPhoneUtils;
import com.coloros.contacts.common.ContactParcelable;
import com.customize.contacts.activities.BusinessCardCaptureActivity;
import com.oplus.contacts.list.fragment.FoldableContactsMainListFragment;
import com.oplus.dialer.R;
import com.oplus.foundation.util.feature.CommonFeatureOption;
import java.util.ArrayList;

/* compiled from: ActivityUtils.java */
/* renamed from: com.customize.contacts.util.c, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C0792c {
    public static boolean a(Activity activity, int i10, int i11, Intent intent) {
        if (i10 != 999 || com.android.contacts.util.w.l(activity, com.android.contacts.util.w.g())) {
            return true;
        }
        if (!activity.shouldShowRequestPermissionRationale("android.permission.WRITE_CONTACTS") && (!CommonFeatureOption.j() || !activity.shouldShowRequestPermissionRationale("android.permission.CALL_PHONE"))) {
            com.android.contacts.util.w.B(activity, false);
            return false;
        }
        com.android.contacts.util.w.w(activity);
        return false;
    }

    public static Intent b(Activity activity) {
        Intent intent = new Intent();
        intent.setAction("android.intent.action.MANAGE_APP_PERMISSIONS");
        intent.putExtra("android.intent.extra.PACKAGE_NAME", activity.getPackageName());
        return intent;
    }

    public static boolean c(Activity activity) {
        if (activity != null && !activity.isFinishing() && !activity.isDestroyed()) {
            return true;
        }
        return false;
    }

    public static boolean d(Activity activity) {
        boolean isTaskRoot = activity.isTaskRoot();
        H7.b.b("ActivityUtils", "isTaskToot = " + isTaskRoot);
        return isTaskRoot;
    }

    public static boolean e(Activity activity, boolean z10) {
        if (activity != null) {
            try {
                return activity.moveTaskToBack(z10);
            } catch (Exception e10) {
                H7.b.c("ActivityUtils", "moveTaskToBack error " + e10);
                return false;
            }
        }
        return false;
    }

    public static boolean f(Activity activity, int i10, String[] strArr, int[] iArr) {
        if (i10 != 1 || strArr == null || strArr.length <= 0 || com.android.contacts.util.w.q(strArr, iArr)) {
            return true;
        }
        if (!activity.shouldShowRequestPermissionRationale("android.permission.WRITE_CONTACTS") && !activity.shouldShowRequestPermissionRationale("android.permission.READ_PHONE_STATE")) {
            com.android.contacts.util.w.B(activity, false);
            return false;
        }
        activity.finish();
        return false;
    }

    public static Intent g(Context context, String str, String str2, String str3, String str4) {
        if (context == null) {
            return null;
        }
        Intent intent = new Intent(k0.f22137a, ContactsContract.Contacts.CONTENT_URI);
        if (C0637b.h()) {
            intent.putExtra("edit_page_start_source", 2);
        }
        intent.putExtra("phone", str);
        intent.putExtra(OplusNumberMarkUtils.OplusContact.OPLUS_COLUMN_SIM_IMSI, str2);
        intent.putExtra("ABOUT_TO_SAVE_ACCOUNT_NAME", str3);
        intent.putExtra("ABOUT_TO_SAVE_ACCOUNT_TYPE", str4);
        intent.putExtra("from_dialpad", true);
        intent.setFlags(OplusPhoneCapabilities.MTK_CAPABILITY_VIDEO_RINGTONE);
        R7.b.c(context, intent);
        return intent;
    }

    public static void h(Activity activity, ArrayList<ContactParcelable> arrayList) {
        if (arrayList != null && arrayList.size() != 0) {
            if (arrayList.size() == 1) {
                R7.b.c(activity, new Intent("android.intent.action.SENDTO", Uri.fromParts("mailto", arrayList.get(0).p(), null)));
                return;
            }
            Intent intent = new Intent("android.intent.action.SEND");
            intent.setType("plain/text");
            String[] strArr = new String[arrayList.size()];
            for (int i10 = 0; i10 < arrayList.size(); i10++) {
                strArr[i10] = arrayList.get(i10).p();
            }
            intent.putExtra("android.intent.extra.EMAIL", strArr);
            R7.b.c(activity, intent);
            return;
        }
        com.oplus.foundation.util.ui.c.d(activity, R.string.toast_msg_contacts_no_email);
    }

    public static void i(Context context, ArrayList<ContactParcelable> arrayList, boolean z10, boolean z11) {
        int i10;
        if (arrayList != null && arrayList.size() != 0) {
            if (arrayList.size() == 1) {
                R7.b.c(context, new Intent("android.intent.action.SENDTO", Uri.fromParts("smsto", arrayList.get(0).p(), null)));
                return;
            } else {
                if (arrayList.size() > 200) {
                    com.oplus.foundation.util.ui.c.c(context, context.getString(R.string.too_many_recipients, 200));
                    return;
                }
                Intent intent = new Intent("oppo.intent.action.OPPO_SENDTO");
                intent.putParcelableArrayListExtra("SELECTED_CONTACTS", arrayList);
                R7.b.c(context, intent);
                return;
            }
        }
        if (z10) {
            if (z11) {
                i10 = R.string.toast_msg_no_phone_number_select;
            } else {
                i10 = R.string.toast_msg_group_contact_no_phone_number;
            }
        } else {
            i10 = R.string.toast_msg_contacts_no_phone_number;
        }
        com.oplus.foundation.util.ui.c.d(context, i10);
    }

    public static void j(Activity activity, int i10) {
        if (activity == null) {
            return;
        }
        Intent intent = new Intent("com.android.phone.CallFeaturesSetting.ADD_VOICEMAIL");
        intent.addCategory("android.intent.category.DEFAULT");
        if (B3.a.i()) {
            intent.putExtra(OplusPhoneUtils.SUBSCRIPTION_KEY, i10);
        }
        R7.b.c(activity, intent);
    }

    public static void k(Context context, int i10, int i11) {
        String str;
        if (context == null) {
            return;
        }
        Intent intent = new Intent();
        if (i10 == 0) {
            com.android.contacts.framework.baseui.util.A.a(context, 2000303, 200030294, null, false);
            str = "android.telecom.action.SHOW_CALL_SETTINGS";
        } else if (i10 == 6) {
            if (J.s(context, i11)) {
                i11 = 0;
            }
            str = k0.f22139c;
            if (context.getPackageManager().queryIntentActivities(new Intent("oplus.intent.action.BLACKLIST_INTERCEPT_MARKED_NUMBER"), 0).size() > 0) {
                H7.b.b("ActivityUtils", "intercept marked number page exist");
                str = "oplus.intent.action.BLACKLIST_INTERCEPT_MARKED_NUMBER";
            }
            String c10 = com.android.contacts.framework.api.appstore.appinfo.a.c();
            if (!TextUtils.isEmpty(c10)) {
                intent.setPackage(c10);
            }
        } else {
            com.android.contacts.framework.baseui.util.A.b(context, "setting_entry");
            intent.setPackage(context.getPackageName());
            str = "com.oplus.contacts.ui.FUNCTIONS_PAGE";
        }
        intent.setAction(str);
        intent.putExtra("from_dialpad", true);
        intent.putExtra("slotId", i11);
        R7.b.c(context, intent);
    }

    public static void l(Fragment fragment, int i10, int i11) {
        k(fragment.getContext(), i10, i11);
    }

    public static void m(Context context) {
        if (context == null) {
            H7.b.c("ActivityUtils", "startClonePhoenActivity error: context is null (return) ");
            return;
        }
        Intent intent = new Intent(context.getString(R.string.backup_and_restore_phone_clone_action));
        intent.putExtra("isDirectlyExit", true);
        R7.b.c(context, intent);
    }

    public static void n(Fragment fragment) {
        com.android.contacts.framework.baseui.util.A.a(fragment.getContext(), 2000310, 200030039, null, false);
        FragmentActivity activity = fragment.getActivity();
        if (activity == null) {
            H7.b.c("ActivityUtils", "startCreateNewContacts : activity is null");
            return;
        }
        try {
            Intent intent = new Intent(k0.f22137a, ContactsContract.Contacts.CONTENT_URI, fragment.getContext(), ContactEditorActivity.class);
            intent.putExtra("FROM_ADD_MENU", true);
            if (fragment instanceof FoldableContactsMainListFragment) {
                ((FoldableContactsMainListFragment) fragment).startActivity(intent);
            } else {
                H7.b.c("ActivityUtils", "startCreateNewContacts is not ContactUnfoldFragment ! ");
                activity.startActivity(intent);
            }
            C0636a.a(activity);
        } catch (Exception e10) {
            H7.b.c("ActivityUtils", "e = " + e10);
        }
    }

    public static void o(Context context) {
        Intent intent = new Intent(R0.e.f3254b);
        intent.putExtra("statement_intent_flag", 2);
        if (!R7.b.d(context, intent, 0)) {
            Intent intent2 = new Intent("android.oem.intent.action.OP_LEGAL");
            intent2.putExtra("op_legal_notices_type", 3);
            R7.b.d(context, intent2, 0);
        }
    }

    public static void p(Context context) {
        Intent intent = new Intent(context, (Class<?>) BusinessCardCaptureActivity.class);
        intent.putExtra("mode", "from_card_activity");
        R7.b.c(context, intent);
    }

    public static void q(Activity activity) {
        Q7.b.b(activity, b(activity), 999, 0);
    }

    public static void r(Activity activity) {
        if (activity == null) {
            return;
        }
        R7.b.c(activity, new Intent("android.settings.SETTINGS"));
    }
}
