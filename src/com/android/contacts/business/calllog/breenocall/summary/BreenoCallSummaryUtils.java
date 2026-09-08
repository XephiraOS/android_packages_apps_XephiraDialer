package com.android.contacts.business.calllog.breenocall.summary;

import android.content.ActivityNotFoundException;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.net.Uri;
import android.provider.CallLog;
import androidx.activity.ComponentActivity;
import androidx.activity.result.ActivityResult;
import c.C0543d;
import com.android.contacts.business.calllog.breenocall.FeatureOpt;
import com.android.contacts.business.calllog.f;
import com.android.contacts.framework.baseui.util.t;
import com.android.incallui.OplusPhoneCapabilities;
import java.util.ArrayList;
import kotlin.Result;
import kotlin.collections.o;
import kotlin.jvm.internal.i;
import kotlinx.coroutines.C1248i;
import kotlinx.coroutines.F;
import kotlinx.coroutines.S;
import m9.d;
import m9.q;
import v9.InterfaceC1637a;

/* compiled from: BreenoCallSummaryUtils.kt */
/* loaded from: classes.dex */
public final class BreenoCallSummaryUtils {
    private static final int ERROR_CODE_SUMMARY_NOT_EXIST = -10;
    private static final String EXTRA_SUMMARY_ID = "speech_log_id";
    public static final BreenoCallSummaryUtils INSTANCE;
    private static final d NOTE_AUTHORITY$delegate;
    private static final String NOTE_AUTHORITY_1 = "com.nearme.note";
    private static final String NOTE_AUTHORITY_2 = "com.coloros.note";
    private static final String NOTE_AUTHORITY_3 = "com.oneplus.note";
    private static final String PARAM_CALLER_PACKAGE = "caller_package";
    private static final String PARAM_SUMMARY_ID = "speech_log_id";
    private static final String TAG = "BreenoCallSummaryUtils";
    private static final Uri TEXT_NOTE_URI;
    private static final String VIEW_AUTO_SUMMARY_CALLS_ACTION = "oplus.intent.action.ADD_CALL_AUTO_SUMMARY";
    private static final String VIEW_CALL_SUMMARY_ACTION = "com.oplus.note.action.OPEN_SUMMARY_NOTE";

    static {
        d b10;
        BreenoCallSummaryUtils breenoCallSummaryUtils = new BreenoCallSummaryUtils();
        INSTANCE = breenoCallSummaryUtils;
        b10 = kotlin.a.b(new InterfaceC1637a<String>() { // from class: com.android.contacts.business.calllog.breenocall.summary.BreenoCallSummaryUtils$NOTE_AUTHORITY$2
            @Override // v9.InterfaceC1637a
            public final String invoke() {
                return BreenoCallSummaryUtils.getSummaryProviderAuthority(P7.a.f2961a.a());
            }
        });
        NOTE_AUTHORITY$delegate = b10;
        TEXT_NOTE_URI = Uri.parse("content://" + breenoCallSummaryUtils.getNOTE_AUTHORITY() + "/text_note");
    }

    private BreenoCallSummaryUtils() {
    }

    public static final void deleteCallSummaryContent(Context context, String uuid) {
        ArrayList d10;
        i.f(context, "context");
        i.f(uuid, "uuid");
        d10 = o.d(uuid);
        deleteCallSummaryContentList(context, d10);
    }

    public static final void deleteCallSummaryContentList(Context context, ArrayList<String> uuids) {
        i.f(context, "context");
        i.f(uuids, "uuids");
        C1248i.d(F.a(S.b()), null, null, new BreenoCallSummaryUtils$deleteCallSummaryContentList$1(uuids, context, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String getNOTE_AUTHORITY() {
        return (String) NOTE_AUTHORITY$delegate.getValue();
    }

    public static final String getSummaryProviderAuthority(Context context) {
        if (context == null || hasProvider(context, NOTE_AUTHORITY_1)) {
            return NOTE_AUTHORITY_1;
        }
        if (hasProvider(context, NOTE_AUTHORITY_2)) {
            return NOTE_AUTHORITY_2;
        }
        if (!hasProvider(context, NOTE_AUTHORITY_3)) {
            return NOTE_AUTHORITY_1;
        }
        return NOTE_AUTHORITY_3;
    }

    public static final boolean hasProvider(Context context, String authority) {
        ProviderInfo providerInfo;
        i.f(context, "context");
        i.f(authority, "authority");
        PackageManager packageManager = context.getPackageManager();
        if (packageManager != null) {
            providerInfo = packageManager.resolveContentProvider(authority, 128);
        } else {
            providerInfo = null;
        }
        if (providerInfo != null) {
            return true;
        }
        return false;
    }

    public static final void ignoreCallSummaryTipShow(Context context, ArrayList<Long> ids) {
        i.f(context, "context");
        i.f(ids, "ids");
        C1248i.d(F.a(S.b()), null, null, new BreenoCallSummaryUtils$ignoreCallSummaryTipShow$1(ids, context, null), 3, null);
    }

    public static final void openAutoCallSummaryForNumber(Context context, ArrayList<Long> ids) {
        i.f(context, "context");
        i.f(ids, "ids");
        C1248i.d(F.a(S.b()), null, null, new BreenoCallSummaryUtils$openAutoCallSummaryForNumber$1(ids, context, null), 3, null);
    }

    public static final void setCallSummaryFeatureFlag(Context context, long j10, boolean z10) {
        i.f(context, "context");
        C1248i.d(F.a(S.b()), null, null, new BreenoCallSummaryUtils$setCallSummaryFeatureFlag$1(j10, context, z10, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void updateCallSummaryFeatureFlag(Context context, long j10, int i10, boolean z10) {
        Object b10;
        int i11 = i10 & OplusPhoneCapabilities.CAPABILITY_SUPPORTS_RTT_REMOTE;
        boolean z11 = true;
        ContentValues contentValues = new ContentValues(1);
        int i12 = 0;
        if (z10 && i11 == 0) {
            contentValues.put("features", Integer.valueOf(i10 | OplusPhoneCapabilities.CAPABILITY_SUPPORTS_RTT_REMOTE));
        } else if (!z10 && i11 == 268435456) {
            contentValues.put("features", Integer.valueOf(i10 ^ OplusPhoneCapabilities.CAPABILITY_SUPPORTS_RTT_REMOTE));
        } else {
            z11 = false;
        }
        if (z11) {
            Uri withAppendedId = ContentUris.withAppendedId(CallLog.Calls.CONTENT_URI, j10);
            i.e(withAppendedId, "withAppendedId(CallLog.Calls.CONTENT_URI, callId)");
            try {
                Result.a aVar = Result.f34166a;
                i12 = context.getContentResolver().update(withAppendedId, contentValues, null, null);
                b10 = Result.b(q.f35511a);
            } catch (Throwable th) {
                Result.a aVar2 = Result.f34166a;
                b10 = Result.b(kotlin.b.a(th));
            }
            Throwable d10 = Result.d(b10);
            if (d10 != null) {
                H7.b.i(TAG, "setCallSummaryFeatureFlag: failed: " + d10);
            }
        }
        H7.b.b(TAG, "setCallSummaryFeatureFlag: callId: " + j10 + ", set: " + z10 + ", update: " + z11 + ", count: " + i12);
    }

    public static final void viewCallSummaryContent(final ComponentActivity activity, final String uuid, final t tVar) {
        Object b10;
        i.f(activity, "activity");
        i.f(uuid, "uuid");
        try {
            Result.a aVar = Result.f34166a;
            Intent intent = new Intent(VIEW_CALL_SUMMARY_ACTION);
            intent.putExtra("speech_log_id", uuid);
            intent.setPackage(FeatureOpt.INSTANCE.getNotePackageName());
            androidx.activity.result.b j10 = activity.getActivityResultRegistry().j("VIEW_CALL_SUMMARY_ACTION", new C0543d(), new androidx.activity.result.a() { // from class: com.android.contacts.business.calllog.breenocall.summary.c
                @Override // androidx.activity.result.a
                public final void a(Object obj) {
                    BreenoCallSummaryUtils.viewCallSummaryContent$lambda$4$lambda$3(uuid, tVar, activity, (ActivityResult) obj);
                }
            });
            i.e(j10, "activity.activityResultR…      }\n                }");
            j10.a(intent);
            b10 = Result.b(q.f35511a);
        } catch (Throwable th) {
            Result.a aVar2 = Result.f34166a;
            b10 = Result.b(kotlin.b.a(th));
        }
        Throwable d10 = Result.d(b10);
        if (d10 != null) {
            H7.b.c(TAG, "viewCallSummaryContent: exception: " + d10);
            if (d10 instanceof ActivityNotFoundException) {
                if (tVar != null) {
                    t.a.a(tVar, 0, null, null, 4, null);
                }
                setCallSummaryFeatureFlag((Context) activity, uuid, false);
                com.oplus.foundation.util.ui.c.d(activity, f.f13712a);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void viewCallSummaryContent$lambda$4$lambda$3(String uuid, t tVar, ComponentActivity activity, ActivityResult activityResult) {
        i.f(uuid, "$uuid");
        i.f(activity, "$activity");
        H7.b.e(TAG, "viewCallSummaryContent: uuid: " + uuid + ", resultCode: " + activityResult.d());
        if (activityResult.d() == -10) {
            if (tVar != null) {
                t.a.a(tVar, 0, null, null, 4, null);
            }
            setCallSummaryFeatureFlag((Context) activity, uuid, false);
            com.oplus.foundation.util.ui.c.d(activity, f.f13715d);
        }
    }

    public static final void setCallSummaryFeatureFlag(Context context, String uuid, boolean z10) {
        i.f(context, "context");
        i.f(uuid, "uuid");
        C1248i.d(F.a(S.b()), null, null, new BreenoCallSummaryUtils$setCallSummaryFeatureFlag$2(context, uuid, z10, null), 3, null);
    }
}
