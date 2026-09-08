package com.android.incallui.oplus.share;

import android.content.BroadcastReceiver;

/* loaded from: classes.dex */
public class OplusNoteGuidReceiver extends BroadcastReceiver {
    /* JADX WARN: Removed duplicated region for block: B:10:0x0050  */
    @Override // android.content.BroadcastReceiver
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onReceive(android.content.Context r4, android.content.Intent r5) {
        /*
            r3 = this;
            java.lang.String r3 = r5.getAction()
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r0 = "onReceive...action = "
            r4.append(r0)
            r4.append(r3)
            java.lang.String r4 = r4.toString()
            java.lang.String r0 = "OplusNoteGuidReceiver"
            com.android.incallui.Log.i(r0, r4)
            java.lang.String r4 = "oplus.intent.action.NOTE_GUID"
            boolean r3 = r4.equals(r3)
            if (r3 == 0) goto L7f
            r3 = 0
            java.lang.String r4 = "call_id"
            java.lang.String r4 = r5.getStringExtra(r4)     // Catch: java.lang.Exception -> L32
            java.lang.String r1 = "guid"
            java.lang.String r3 = r5.getStringExtra(r1)     // Catch: java.lang.Exception -> L30
            goto L4c
        L30:
            r5 = move-exception
            goto L34
        L32:
            r5 = move-exception
            r4 = r3
        L34:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "onReceive...exception = "
            r1.append(r2)
            java.lang.String r5 = r5.getMessage()
            r1.append(r5)
            java.lang.String r5 = r1.toString()
            com.android.incallui.Log.i(r0, r5)
        L4c:
            boolean r5 = com.android.incallui.Log.sDebug
            if (r5 == 0) goto L6c
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r1 = "callId = "
            r5.append(r1)
            r5.append(r4)
            java.lang.String r1 = ", guid = "
            r5.append(r1)
            r5.append(r3)
            java.lang.String r5 = r5.toString()
            com.android.incallui.Log.d(r0, r5)
        L6c:
            com.android.incallui.CallList r5 = com.android.incallui.CallList.getInstance()
            com.android.incallui.Call r4 = r5.getCallById(r4)
            if (r4 == 0) goto L7f
            boolean r5 = android.text.TextUtils.isEmpty(r3)
            if (r5 != 0) goto L7f
            r4.setNotesGuid(r3)
        L7f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.incallui.oplus.share.OplusNoteGuidReceiver.onReceive(android.content.Context, android.content.Intent):void");
    }
}
