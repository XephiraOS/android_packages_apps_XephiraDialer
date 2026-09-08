package com.android.incallui;

import android.content.ContentProviderOperation;
import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.provider.ContactsContract;
import android.view.KeyEvent;
import com.coui.appcompat.dialog.COUIAlertDialogBuilder;
import java.util.ArrayList;
import java.util.Map;

/* loaded from: classes.dex */
public class OplusNumberMarkUtils {
    private static final String ACTION_INSERT_BLACK_LIST_NUMBER = "oplus.intent.action.BLACKLIST_DATA_CHANGE";
    private static final int ADD_TO_SAVED_CONTACTS = 1;
    private static final String LOG_TAG = "OplusNumberMarkUtils";
    private static final int NEW_CONTACT = 0;
    private androidx.appcompat.app.b mBlacklistDialog;
    private androidx.appcompat.app.b mContactDialog;
    private Context mContext;

    /* loaded from: classes.dex */
    public static final class OplusBlacklist {
        public static final String AUTHORITY;
        public static final Uri AUTHORITY_URI;
        public static final Uri BLACKLIST_CONTENT_URI;
        public static final String BLACKLIST_TABLE = "bl_list";
        public static final String BLOCK_TYPE = "block_type";
        public static final int BLOCK_TYPE_BOTH = 3;
        public static final String CONTACTID = "contactID";
        public static final String LIST_TYPE = "list_type";
        public static final int LIST_TYPE_BLACK = 1;
        public static final String NUMBER = "number";

        static {
            String blackListAuthority = ConfigurationConstants.getBlackListAuthority();
            AUTHORITY = blackListAuthority;
            Uri parse = Uri.parse("content://" + blackListAuthority);
            AUTHORITY_URI = parse;
            BLACKLIST_CONTENT_URI = Uri.withAppendedPath(parse, BLACKLIST_TABLE);
        }
    }

    /* loaded from: classes.dex */
    public static final class OplusContact {
        public static final String FROM_OPLUS_APP = "from_oppo_app";
        public static final String OPLUS_COLUMN_SIM_IMSI = "imsi";
        public static final String OPLUS_CONTACTS_FLAG_UNFAMILIAR_NUMBER = "unfamiliar_number";
        public static final String OPLUS_INSERT_CONTACTS_ACTION = "com.oppo.contacts.INSERT_CONTACTS";
        public static final String OPLUS_MARK_CONTACTS_ACTION = "oppo.intent.action.contacts.MARK_NUMBER";
        public static final String OPLUS_MARK_CONTACTS_CALL_TYPE = "callType";
        public static final String OPLUS_MARK_CONTACTS_NUMBER = "number";
    }

    public OplusNumberMarkUtils(Context context) {
        this.mContext = context;
    }

    private boolean addToBlackList(Context context, long j10, ArrayList<String> arrayList) {
        if (arrayList == null) {
            return false;
        }
        ArrayList<ContentProviderOperation> arrayList2 = new ArrayList<>();
        for (int i10 = 0; i10 < arrayList.size(); i10++) {
            ContentProviderOperation.Builder newInsert = ContentProviderOperation.newInsert(OplusBlacklist.BLACKLIST_CONTENT_URI);
            ContentValues contentValues = new ContentValues(4);
            contentValues.put(OplusBlacklist.CONTACTID, Long.valueOf(j10));
            contentValues.put("number", arrayList.get(i10));
            contentValues.put(OplusBlacklist.BLOCK_TYPE, (Integer) 3);
            contentValues.put(OplusBlacklist.LIST_TYPE, (Integer) 1);
            newInsert.withValues(contentValues);
            arrayList2.add(newInsert.build());
        }
        try {
            context.getContentResolver().applyBatch(OplusBlacklist.AUTHORITY, arrayList2);
            Intent intent = new Intent(ACTION_INSERT_BLACK_LIST_NUMBER);
            intent.putExtra("number_list", arrayList);
            intent.putExtra("is_insert_blacklist", true);
            intent.setFlags(OplusPhoneUtils.FLAG_RECEIVER_INCLUDE_BACKGROUND);
            context.sendBroadcast(intent, OplusPhoneUtils.PERMISSION_OPLUS_COMPONENT_SAFE);
            return true;
        } catch (Exception e10) {
            Log.i(LOG_TAG, "exception: " + e10.toString());
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showAddToContactDialog$1(String str, DialogInterface dialogInterface, int i10) {
        if (i10 != 0) {
            if (i10 == 1) {
                if (OplusPhoneUtils.isScreenLocked(this.mContext)) {
                    OplusPhoneUtils.dismissKeyguard();
                }
                startPickContactActivity(this.mContext, str);
                if (dialogInterface != null) {
                    dialogInterface.dismiss();
                    return;
                }
                return;
            }
            return;
        }
        if (OplusPhoneUtils.isScreenLocked(this.mContext)) {
            OplusPhoneUtils.dismissKeyguard();
        }
        saveNumber(this.mContext, str, null);
        if (dialogInterface != null) {
            dialogInterface.dismiss();
        }
        OplusPhoneUserActionStatistics.onCommon(this.mContext, OplusPhoneUserActionStatistics.TAG_NUMBER_RECOGNITION, OplusPhoneUserActionStatistics.NUMBER_MARK_FRAGMENT_SAVE_NEW_NUMBER, (Map) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$showAddToContactDialog$2(DialogInterface dialogInterface, int i10) {
        if (Log.sDebug) {
            Log.d(LOG_TAG, "showAddToContactDialog negative button clicked.");
        }
        if (dialogInterface != null) {
            dialogInterface.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$showAddToContactDialog$3(DialogInterface dialogInterface) {
        if (Log.sDebug) {
            Log.d(LOG_TAG, "showAddToContactDialog onDismiss");
        }
        if (dialogInterface != null) {
            dialogInterface.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$showAddToContactDialog$4(DialogInterface dialogInterface, int i10, KeyEvent keyEvent) {
        if (Log.sDebug) {
            Log.d(LOG_TAG, "showAddToContactDialog keyCode = " + i10);
        }
        if (i10 != 4 && i10 != 3) {
            return false;
        }
        if (dialogInterface != null) {
            dialogInterface.dismiss();
            return true;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showBlacklistDialog$0(String str, DialogInterface dialogInterface, int i10) {
        if (Log.sDebug) {
            Log.d(LOG_TAG, "showBlacklistDialog positive button clicked.");
        }
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add(str);
        addToBlackList(this.mContext, -1L, arrayList);
        if (dialogInterface != null) {
            dialogInterface.dismiss();
        }
        OplusPhoneUserActionStatistics.onCommon(this.mContext, OplusPhoneUserActionStatistics.TAG_NUMBER_RECOGNITION, OplusPhoneUserActionStatistics.NUMBER_MARK_FRAGMENT_ADD_BLACKLIST, (Map) null);
    }

    private void saveNumber(Context context, String str, String str2) {
        Intent intent = new Intent(OplusContact.OPLUS_INSERT_CONTACTS_ACTION, ContactsContract.Contacts.CONTENT_URI);
        intent.putExtra("phone", str);
        intent.putExtra(OplusContact.OPLUS_COLUMN_SIM_IMSI, str2);
        intent.putExtra(OplusContact.OPLUS_CONTACTS_FLAG_UNFAMILIAR_NUMBER, str);
        intent.addFlags(OplusPhoneCapabilities.CAPABILITY_SUPPORTS_RTT_REMOTE);
        OplusPhoneUtils.startSafeActivity(context, intent);
    }

    private void startPickContactActivity(Context context, String str) {
        Intent intent = new Intent("android.intent.action.INSERT_OR_EDIT");
        intent.setType("vnd.android.cursor.item/contact");
        intent.putExtra("phone", str);
        intent.putExtra(OplusContact.FROM_OPLUS_APP, true);
        intent.addFlags(OplusPhoneCapabilities.CAPABILITY_SUPPORTS_RTT_REMOTE);
        OplusPhoneUtils.startSafeActivity(context, intent);
    }

    public void showAddToContactDialog(final String str) {
        if (this.mContext == null) {
            if (Log.sDebug) {
                Log.d(LOG_TAG, "showAddToContactDialog, activity is null, return.");
            }
        } else {
            androidx.appcompat.app.b create = new COUIAlertDialogBuilder(this.mContext.getApplicationContext(), R.style.COUIAlertDialog_Bottom).setItems(this.mContext.getResources().getTextArray(R.array.contact_dialog_items), new DialogInterface.OnClickListener() { // from class: com.android.incallui.T
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i10) {
                    OplusNumberMarkUtils.this.lambda$showAddToContactDialog$1(str, dialogInterface, i10);
                }
            }).setNegativeButton(android.R.string.cancel, new DialogInterface.OnClickListener() { // from class: com.android.incallui.U
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i10) {
                    OplusNumberMarkUtils.lambda$showAddToContactDialog$2(dialogInterface, i10);
                }
            }).setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.android.incallui.V
                @Override // android.content.DialogInterface.OnDismissListener
                public final void onDismiss(DialogInterface dialogInterface) {
                    OplusNumberMarkUtils.lambda$showAddToContactDialog$3(dialogInterface);
                }
            }).setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: com.android.incallui.W
                @Override // android.content.DialogInterface.OnKeyListener
                public final boolean onKey(DialogInterface dialogInterface, int i10, KeyEvent keyEvent) {
                    boolean lambda$showAddToContactDialog$4;
                    lambda$showAddToContactDialog$4 = OplusNumberMarkUtils.lambda$showAddToContactDialog$4(dialogInterface, i10, keyEvent);
                    return lambda$showAddToContactDialog$4;
                }
            }).create();
            this.mContactDialog = create;
            create.getWindow().setType(2009);
            this.mContactDialog.setCanceledOnTouchOutside(true);
            this.mContactDialog.show();
        }
    }

    public void showBlacklistDialog(final String str) {
        if (this.mContext == null) {
            if (Log.sDebug) {
                Log.d(LOG_TAG, "showBlacklistDialog, activity is null, return.");
            }
        } else {
            androidx.appcompat.app.b create = new COUIAlertDialogBuilder(this.mContext.getApplicationContext(), R.style.COUIAlertDialog_Bottom).setMessage(R.string.oplus_blacklist_tips).setNegativeButton(android.R.string.cancel, new DialogInterface.OnClickListener() { // from class: com.android.incallui.OplusNumberMarkUtils.3
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i10) {
                    if (Log.sDebug) {
                        Log.d(OplusNumberMarkUtils.LOG_TAG, "showBlacklistDialog negative button clicked.");
                    }
                    if (dialogInterface != null) {
                        dialogInterface.dismiss();
                    }
                }
            }).setNeutralButton(R.string.oplus_block_number, new DialogInterface.OnClickListener() { // from class: com.android.incallui.X
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i10) {
                    OplusNumberMarkUtils.this.lambda$showBlacklistDialog$0(str, dialogInterface, i10);
                }
            }).setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.android.incallui.OplusNumberMarkUtils.2
                @Override // android.content.DialogInterface.OnDismissListener
                public void onDismiss(DialogInterface dialogInterface) {
                    if (Log.sDebug) {
                        Log.d(OplusNumberMarkUtils.LOG_TAG, "showBlacklistDialog onDismiss");
                    }
                    if (dialogInterface != null) {
                        dialogInterface.dismiss();
                    }
                }
            }).setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: com.android.incallui.OplusNumberMarkUtils.1
                @Override // android.content.DialogInterface.OnKeyListener
                public boolean onKey(DialogInterface dialogInterface, int i10, KeyEvent keyEvent) {
                    if (Log.sDebug) {
                        Log.d(OplusNumberMarkUtils.LOG_TAG, "showBlacklistDialog keyCode = " + i10);
                    }
                    if (i10 != 4 && i10 != 3) {
                        return false;
                    }
                    if (dialogInterface != null) {
                        dialogInterface.dismiss();
                        return true;
                    }
                    return true;
                }
            }).create();
            this.mBlacklistDialog = create;
            create.getWindow().setType(2009);
            this.mBlacklistDialog.setCanceledOnTouchOutside(true);
            this.mBlacklistDialog.show();
        }
    }

    public void startMarkNumber(String str, int i10) {
        Intent intent = new Intent(OplusContact.OPLUS_MARK_CONTACTS_ACTION);
        intent.putExtra("number", str);
        intent.putExtra(OplusContact.OPLUS_MARK_CONTACTS_CALL_TYPE, i10);
        intent.addFlags(OplusPhoneCapabilities.CAPABILITY_SUPPORTS_RTT_REMOTE);
        OplusPhoneUtils.startSafeActivity(this.mContext, intent);
    }
}
