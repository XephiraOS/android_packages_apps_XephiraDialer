package com.oplus.utils;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Log;
import android.widget.TextView;
import com.coui.appcompat.dialog.COUIAlertDialogBuilder;
import com.oplus.blacklistapp.activities.BlockedCallLogAndSmsListActivity;
import com.oplus.blacklistapp.activities.CustomBlackListActivity;
import com.oplus.blacklistapp.activities.PseudoBaseStationActivity;
import com.oplus.blacklistapp.callintercept.settings.CallHarassInterceptSetting;
import com.oplus.blacklistapp.callintercept.settings.HarassInterceptSetting;
import java.util.ArrayList;

/* compiled from: PermissionHelper.java */
/* loaded from: classes3.dex */
public class L {

    /* renamed from: a, reason: collision with root package name */
    public static androidx.appcompat.app.b f29055a;

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x009b, code lost:
    
        if (r4.equals("android.permission.READ_SMS") == false) goto L18;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static int e(java.lang.String[] r6) {
        /*
            int r0 = com.oplus.blacklistapp.u.f27524I0
            if (r6 == 0) goto Lb6
            int r1 = r6.length
            if (r1 != 0) goto L9
            goto Lb6
        L9:
            int r1 = r6.length
            r2 = 0
            r3 = r2
        Lc:
            if (r3 >= r1) goto L19
            r4 = r6[r3]
            boolean r5 = android.text.TextUtils.isEmpty(r4)
            if (r5 == 0) goto L1a
            int r3 = r3 + 1
            goto Lc
        L19:
            r4 = 0
        L1a:
            boolean r6 = android.text.TextUtils.isEmpty(r4)
            if (r6 == 0) goto L21
            return r0
        L21:
            r4.hashCode()
            int r6 = r4.hashCode()
            r1 = -1
            switch(r6) {
                case -2062386608: goto L95;
                case -1921431796: goto L8a;
                case -1888586689: goto L7f;
                case -406040016: goto L74;
                case -63024214: goto L69;
                case -5573545: goto L5e;
                case 112197485: goto L53;
                case 610633091: goto L48;
                case 691260818: goto L3c;
                case 1977429404: goto L2f;
                default: goto L2c;
            }
        L2c:
            r2 = r1
            goto L9e
        L2f:
            java.lang.String r6 = "android.permission.READ_CONTACTS"
            boolean r6 = r4.equals(r6)
            if (r6 != 0) goto L38
            goto L2c
        L38:
            r2 = 9
            goto L9e
        L3c:
            java.lang.String r6 = "android.permission.READ_MEDIA_AUDIO"
            boolean r6 = r4.equals(r6)
            if (r6 != 0) goto L45
            goto L2c
        L45:
            r2 = 8
            goto L9e
        L48:
            java.lang.String r6 = "android.permission.WRITE_CALL_LOG"
            boolean r6 = r4.equals(r6)
            if (r6 != 0) goto L51
            goto L2c
        L51:
            r2 = 7
            goto L9e
        L53:
            java.lang.String r6 = "android.permission.CALL_PHONE"
            boolean r6 = r4.equals(r6)
            if (r6 != 0) goto L5c
            goto L2c
        L5c:
            r2 = 6
            goto L9e
        L5e:
            java.lang.String r6 = "android.permission.READ_PHONE_STATE"
            boolean r6 = r4.equals(r6)
            if (r6 != 0) goto L67
            goto L2c
        L67:
            r2 = 5
            goto L9e
        L69:
            java.lang.String r6 = "android.permission.ACCESS_COARSE_LOCATION"
            boolean r6 = r4.equals(r6)
            if (r6 != 0) goto L72
            goto L2c
        L72:
            r2 = 4
            goto L9e
        L74:
            java.lang.String r6 = "android.permission.READ_EXTERNAL_STORAGE"
            boolean r6 = r4.equals(r6)
            if (r6 != 0) goto L7d
            goto L2c
        L7d:
            r2 = 3
            goto L9e
        L7f:
            java.lang.String r6 = "android.permission.ACCESS_FINE_LOCATION"
            boolean r6 = r4.equals(r6)
            if (r6 != 0) goto L88
            goto L2c
        L88:
            r2 = 2
            goto L9e
        L8a:
            java.lang.String r6 = "android.permission.READ_CALL_LOG"
            boolean r6 = r4.equals(r6)
            if (r6 != 0) goto L93
            goto L2c
        L93:
            r2 = 1
            goto L9e
        L95:
            java.lang.String r6 = "android.permission.READ_SMS"
            boolean r6 = r4.equals(r6)
            if (r6 != 0) goto L9e
            goto L2c
        L9e:
            switch(r2) {
                case 0: goto Lb4;
                case 1: goto Lb1;
                case 2: goto Lae;
                case 3: goto Lab;
                case 4: goto Lae;
                case 5: goto La8;
                case 6: goto La8;
                case 7: goto Lb1;
                case 8: goto La5;
                case 9: goto La2;
                default: goto La1;
            }
        La1:
            goto Lb6
        La2:
            int r0 = com.oplus.blacklistapp.u.f27540M0
            goto Lb6
        La5:
            int r0 = com.oplus.blacklistapp.u.f27713x2
            goto Lb6
        La8:
            int r0 = com.oplus.blacklistapp.u.f27536L0
            goto Lb6
        Lab:
            int r0 = com.oplus.blacklistapp.u.f27520H0
            goto Lb6
        Lae:
            int r0 = com.oplus.blacklistapp.u.f27516G0
            goto Lb6
        Lb1:
            int r0 = com.oplus.blacklistapp.u.f27524I0
            goto Lb6
        Lb4:
            int r0 = com.oplus.blacklistapp.u.f27544N0
        Lb6:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.utils.L.e(java.lang.String[]):int");
    }

    public static String[] f(Activity activity) {
        ArrayList arrayList = new ArrayList();
        if (activity instanceof CustomBlackListActivity) {
            if (!h(activity, "android.permission.READ_CONTACTS")) {
                arrayList.add("android.permission.READ_CONTACTS");
            }
        } else if (activity instanceof PseudoBaseStationActivity) {
            if (!h(activity, "android.permission.ACCESS_FINE_LOCATION")) {
                arrayList.add("android.permission.ACCESS_FINE_LOCATION");
            }
            if (!h(activity, "android.permission.ACCESS_COARSE_LOCATION")) {
                arrayList.add("android.permission.ACCESS_COARSE_LOCATION");
            }
        } else if (activity instanceof BlockedCallLogAndSmsListActivity) {
            if (!h(activity, "android.permission.READ_CONTACTS")) {
                arrayList.add("android.permission.READ_CONTACTS");
            }
            if (!h(activity, "android.permission.READ_CALL_LOG")) {
                arrayList.add("android.permission.READ_CALL_LOG");
            }
            if (!h(activity, "android.permission.WRITE_CALL_LOG")) {
                arrayList.add("android.permission.WRITE_CALL_LOG");
            }
            if (!h(activity, "android.permission.READ_PHONE_STATE")) {
                arrayList.add("android.permission.READ_PHONE_STATE");
            }
            if (!h(activity, "android.permission.CALL_PHONE")) {
                arrayList.add("android.permission.CALL_PHONE");
            }
        } else if (((activity instanceof HarassInterceptSetting) || (activity instanceof CallHarassInterceptSetting)) && !h(activity, "android.permission.READ_PHONE_STATE")) {
            arrayList.add("android.permission.READ_PHONE_STATE");
        }
        SharedPreferences b10 = androidx.preference.j.b(activity);
        if (!h(activity, "android.permission.READ_MEDIA_AUDIO")) {
            if (b10.getBoolean("show_without_audio_permission_dialog", true)) {
                arrayList.add("android.permission.READ_MEDIA_AUDIO");
            }
        } else {
            b10.edit().putBoolean("show_without_audio_permission_dialog", true).apply();
        }
        if (arrayList.size() > 0) {
            return (String[]) arrayList.toArray(new String[0]);
        }
        return null;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x0084, code lost:
    
        if (r2.equals("android.permission.READ_SMS") == false) goto L13;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.String g(android.app.Activity r4, java.lang.String[] r5, int r6, int r7) {
        /*
            java.lang.String r7 = r4.getString(r7)
            java.lang.Object[] r7 = new java.lang.Object[]{r7}
            java.lang.String r6 = r4.getString(r6, r7)
            int r7 = r5.length
            r0 = 0
            r1 = r0
        Lf:
            if (r1 >= r7) goto L1c
            r2 = r5[r1]
            boolean r3 = android.text.TextUtils.isEmpty(r2)
            if (r3 == 0) goto L1d
            int r1 = r1 + 1
            goto Lf
        L1c:
            r2 = 0
        L1d:
            boolean r5 = android.text.TextUtils.isEmpty(r2)
            if (r5 == 0) goto L24
            return r6
        L24:
            r2.hashCode()
            int r5 = r2.hashCode()
            r7 = -1
            switch(r5) {
                case -2062386608: goto L7e;
                case -1921431796: goto L73;
                case -1888586689: goto L68;
                case -63024214: goto L5d;
                case -5573545: goto L52;
                case 112197485: goto L47;
                case 610633091: goto L3c;
                case 1977429404: goto L31;
                default: goto L2f;
            }
        L2f:
            r0 = r7
            goto L87
        L31:
            java.lang.String r5 = "android.permission.READ_CONTACTS"
            boolean r5 = r2.equals(r5)
            if (r5 != 0) goto L3a
            goto L2f
        L3a:
            r0 = 7
            goto L87
        L3c:
            java.lang.String r5 = "android.permission.WRITE_CALL_LOG"
            boolean r5 = r2.equals(r5)
            if (r5 != 0) goto L45
            goto L2f
        L45:
            r0 = 6
            goto L87
        L47:
            java.lang.String r5 = "android.permission.CALL_PHONE"
            boolean r5 = r2.equals(r5)
            if (r5 != 0) goto L50
            goto L2f
        L50:
            r0 = 5
            goto L87
        L52:
            java.lang.String r5 = "android.permission.READ_PHONE_STATE"
            boolean r5 = r2.equals(r5)
            if (r5 != 0) goto L5b
            goto L2f
        L5b:
            r0 = 4
            goto L87
        L5d:
            java.lang.String r5 = "android.permission.ACCESS_COARSE_LOCATION"
            boolean r5 = r2.equals(r5)
            if (r5 != 0) goto L66
            goto L2f
        L66:
            r0 = 3
            goto L87
        L68:
            java.lang.String r5 = "android.permission.ACCESS_FINE_LOCATION"
            boolean r5 = r2.equals(r5)
            if (r5 != 0) goto L71
            goto L2f
        L71:
            r0 = 2
            goto L87
        L73:
            java.lang.String r5 = "android.permission.READ_CALL_LOG"
            boolean r5 = r2.equals(r5)
            if (r5 != 0) goto L7c
            goto L2f
        L7c:
            r0 = 1
            goto L87
        L7e:
            java.lang.String r5 = "android.permission.READ_SMS"
            boolean r5 = r2.equals(r5)
            if (r5 != 0) goto L87
            goto L2f
        L87:
            switch(r0) {
                case 0: goto La7;
                case 1: goto La0;
                case 2: goto L99;
                case 3: goto L99;
                case 4: goto L92;
                case 5: goto L92;
                case 6: goto La0;
                case 7: goto L8b;
                default: goto L8a;
            }
        L8a:
            goto Lad
        L8b:
            int r5 = com.oplus.blacklistapp.u.f27633h2
            java.lang.String r6 = r4.getString(r5)
            goto Lad
        L92:
            int r5 = com.oplus.blacklistapp.u.f27603b2
            java.lang.String r6 = r4.getString(r5)
            goto Lad
        L99:
            int r5 = com.oplus.blacklistapp.u.f27628g2
            java.lang.String r6 = r4.getString(r5)
            goto Lad
        La0:
            int r5 = com.oplus.blacklistapp.u.f27598a2
            java.lang.String r6 = r4.getString(r5)
            goto Lad
        La7:
            int r5 = com.oplus.blacklistapp.u.f27643j2
            java.lang.String r6 = r4.getString(r5)
        Lad:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.utils.L.g(android.app.Activity, java.lang.String[], int, int):java.lang.String");
    }

    public static boolean h(Context context, String str) {
        if (context.checkSelfPermission(str) == 0) {
            return true;
        }
        return false;
    }

    public static void i() {
        try {
            androidx.appcompat.app.b bVar = f29055a;
            if (bVar != null) {
                bVar.dismiss();
            }
        } catch (Exception e10) {
            Log.e("PermissionHelper", "hidePermissionDialog error:" + e10);
        }
    }

    public static boolean j(int[] iArr) {
        if (iArr == null || iArr.length == 0) {
            return false;
        }
        for (int i10 : iArr) {
            if (i10 != 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean k(String[] strArr, String str) {
        String str2;
        int length = strArr.length;
        int i10 = 0;
        while (true) {
            if (i10 < length) {
                str2 = strArr[i10];
                if (!TextUtils.isEmpty(str2)) {
                    break;
                }
                i10++;
            } else {
                str2 = null;
                break;
            }
        }
        return TextUtils.equals(str2, str);
    }

    public static /* synthetic */ void l(Activity activity, String[] strArr, DialogInterface dialogInterface, int i10) {
        C0846g.i("PermissionHelper", "positive");
        M.c(activity, strArr[0], 10, l7.b.f34735c);
        f29055a = null;
    }

    public static /* synthetic */ void m(boolean z10, Activity activity, InterfaceC0851l interfaceC0851l, DialogInterface dialogInterface, int i10) {
        C0846g.i("PermissionHelper", "negative");
        f29055a = null;
        if (!z10) {
            activity.finish();
            return;
        }
        androidx.preference.j.b(activity).edit().putBoolean("show_without_audio_permission_dialog", false).apply();
        if (interfaceC0851l != null) {
            if ((activity instanceof PseudoBaseStationActivity) || (activity instanceof BlockedCallLogAndSmsListActivity)) {
                interfaceC0851l.onCancel();
            }
        }
    }

    public static /* synthetic */ void n(boolean z10, Activity activity, InterfaceC0851l interfaceC0851l, DialogInterface dialogInterface) {
        C0846g.i("PermissionHelper", "cancel");
        f29055a = null;
        if (!z10) {
            activity.finish();
            return;
        }
        androidx.preference.j.b(activity).edit().putBoolean("show_without_audio_permission_dialog", false).apply();
        if (interfaceC0851l != null) {
            if ((activity instanceof PseudoBaseStationActivity) || (activity instanceof BlockedCallLogAndSmsListActivity)) {
                interfaceC0851l.onCancel();
            }
        }
    }

    public static /* synthetic */ void o(DialogInterface dialogInterface) {
        C0846g.i("PermissionHelper", "onDismiss");
        f29055a = null;
    }

    public static void p(Activity activity, String[] strArr) {
        q(activity, strArr, null);
    }

    public static void q(final Activity activity, final String[] strArr, final InterfaceC0851l interfaceC0851l) {
        String g10;
        String string;
        int i10;
        if (f29055a == null && strArr != null && strArr.length != 0) {
            if (activity instanceof PseudoBaseStationActivity) {
                int i11 = com.oplus.blacklistapp.u.f27532K0;
                int i12 = com.oplus.blacklistapp.u.f27708w2;
                g10 = g(activity, strArr, i11, i12);
                string = activity.getString(e(strArr), activity.getString(i12));
            } else if (activity instanceof BlockedCallLogAndSmsListActivity) {
                int i13 = com.oplus.blacklistapp.u.f27532K0;
                int i14 = com.oplus.blacklistapp.u.f27563S;
                g10 = g(activity, strArr, i13, i14);
                string = activity.getString(e(strArr), activity.getString(i14));
            } else if (!(activity instanceof HarassInterceptSetting) && !(activity instanceof CallHarassInterceptSetting)) {
                int i15 = com.oplus.blacklistapp.u.f27532K0;
                int i16 = com.oplus.blacklistapp.u.f27499C;
                g10 = activity.getString(i15, activity.getString(i16));
                string = activity.getString(e(strArr), activity.getString(i16));
            } else {
                int i17 = com.oplus.blacklistapp.u.f27532K0;
                int i18 = com.oplus.blacklistapp.u.f27563S;
                g10 = g(activity, strArr, i17, i18);
                string = activity.getString(e(strArr), activity.getString(i18));
            }
            final boolean k10 = k(strArr, "android.permission.READ_MEDIA_AUDIO");
            if (k10) {
                g10 = activity.getString(com.oplus.blacklistapp.u.f27638i2);
            }
            COUIAlertDialogBuilder cOUIAlertDialogBuilder = new COUIAlertDialogBuilder(activity);
            cOUIAlertDialogBuilder.setTitle((CharSequence) g10);
            cOUIAlertDialogBuilder.setMessage((CharSequence) string);
            cOUIAlertDialogBuilder.setPositiveButton((CharSequence) activity.getString(com.oplus.blacklistapp.u.f27594Z2), new DialogInterface.OnClickListener() { // from class: com.oplus.utils.H
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i19) {
                    L.l(activity, strArr, dialogInterface, i19);
                }
            });
            if (k10) {
                i10 = com.oplus.blacklistapp.u.f27716y0;
            } else {
                i10 = com.oplus.blacklistapp.u.f27528J0;
            }
            cOUIAlertDialogBuilder.setNegativeButton(i10, new DialogInterface.OnClickListener() { // from class: com.oplus.utils.I
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i19) {
                    L.m(k10, activity, interfaceC0851l, dialogInterface, i19);
                }
            });
            androidx.appcompat.app.b create = cOUIAlertDialogBuilder.create();
            f29055a = create;
            create.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.oplus.utils.J
                @Override // android.content.DialogInterface.OnCancelListener
                public final void onCancel(DialogInterface dialogInterface) {
                    L.n(k10, activity, interfaceC0851l, dialogInterface);
                }
            });
            f29055a.setCanceledOnTouchOutside(false);
            f29055a.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.oplus.utils.K
                @Override // android.content.DialogInterface.OnDismissListener
                public final void onDismiss(DialogInterface dialogInterface) {
                    L.o(dialogInterface);
                }
            });
            f29055a.show();
            cOUIAlertDialogBuilder.updateViewAfterShown();
            TextView textView = (TextView) f29055a.findViewById(R.id.message);
            if (textView != null) {
                textView.setGravity(17);
            }
        }
    }
}
