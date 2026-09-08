package com.android.contacts.voicemail.impl;

import android.app.IntentService;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.telecom.PhoneAccountHandle;
import s1.e;

/* loaded from: classes.dex */
public class LegacyVoicemailService extends IntentService {

    /* renamed from: a, reason: collision with root package name */
    public Handler f17946a;

    /* loaded from: classes.dex */
    public class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PhoneAccountHandle f17947a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f17948b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f17949c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ String f17950d;

        /* renamed from: e, reason: collision with root package name */
        public final /* synthetic */ PendingIntent f17951e;

        /* renamed from: f, reason: collision with root package name */
        public final /* synthetic */ PendingIntent f17952f;

        public a(PhoneAccountHandle phoneAccountHandle, String str, String str2, String str3, PendingIntent pendingIntent, PendingIntent pendingIntent2) {
            this.f17947a = phoneAccountHandle;
            this.f17948b = str;
            this.f17949c = str2;
            this.f17950d = str3;
            this.f17951e = pendingIntent;
            this.f17952f = pendingIntent2;
        }

        @Override // java.lang.Runnable
        public void run() {
            e.d(LegacyVoicemailService.this, this.f17947a, this.f17948b, this.f17949c, this.f17950d, this.f17951e, this.f17952f);
        }
    }

    /* loaded from: classes.dex */
    public class b implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PhoneAccountHandle f17954a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f17955b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f17956c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ PendingIntent f17957d;

        /* renamed from: e, reason: collision with root package name */
        public final /* synthetic */ PendingIntent f17958e;

        public b(PhoneAccountHandle phoneAccountHandle, String str, String str2, PendingIntent pendingIntent, PendingIntent pendingIntent2) {
            this.f17954a = phoneAccountHandle;
            this.f17955b = str;
            this.f17956c = str2;
            this.f17957d = pendingIntent;
            this.f17958e = pendingIntent2;
        }

        @Override // java.lang.Runnable
        public void run() {
            e.d(LegacyVoicemailService.this, this.f17954a, this.f17955b, "", this.f17956c, this.f17957d, this.f17958e);
        }
    }

    public LegacyVoicemailService() {
        super("LegacyVoicemailService");
        this.f17946a = new Handler(Looper.getMainLooper());
    }

    public static Intent a(Context context, Intent intent) {
        Intent intent2 = new Intent(context, (Class<?>) LegacyVoicemailService.class);
        intent2.setAction("createNotification");
        intent2.putExtra("extraIntent", intent);
        return intent2;
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x00a1 A[Catch: Exception -> 0x0099, TRY_LEAVE, TryCatch #2 {Exception -> 0x0099, blocks: (B:34:0x00a1, B:63:0x0095, B:64:0x0098, B:58:0x008f), top: B:30:0x0072, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00c4  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00c7 A[Catch: Exception -> 0x00d8, TryCatch #3 {Exception -> 0x00d8, blocks: (B:7:0x000e, B:9:0x001a, B:12:0x0025, B:15:0x0053, B:36:0x00be, B:40:0x00c7, B:41:0x00e3, B:43:0x0108, B:46:0x00db, B:70:0x00aa, B:18:0x0116, B:20:0x011e, B:22:0x0139, B:24:0x013d, B:27:0x0130), top: B:6:0x000e }] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0108 A[Catch: Exception -> 0x00d8, TryCatch #3 {Exception -> 0x00d8, blocks: (B:7:0x000e, B:9:0x001a, B:12:0x0025, B:15:0x0053, B:36:0x00be, B:40:0x00c7, B:41:0x00e3, B:43:0x0108, B:46:0x00db, B:70:0x00aa, B:18:0x0116, B:20:0x011e, B:22:0x0139, B:24:0x013d, B:27:0x0130), top: B:6:0x000e }] */
    /* JADX WARN: Removed duplicated region for block: B:45:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00db A[Catch: Exception -> 0x00d8, TryCatch #3 {Exception -> 0x00d8, blocks: (B:7:0x000e, B:9:0x001a, B:12:0x0025, B:15:0x0053, B:36:0x00be, B:40:0x00c7, B:41:0x00e3, B:43:0x0108, B:46:0x00db, B:70:0x00aa, B:18:0x0116, B:20:0x011e, B:22:0x0139, B:24:0x013d, B:27:0x0130), top: B:6:0x000e }] */
    @Override // android.app.IntentService
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onHandleIntent(android.content.Intent r19) {
        /*
            Method dump skipped, instructions count: 352
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.contacts.voicemail.impl.LegacyVoicemailService.onHandleIntent(android.content.Intent):void");
    }
}
