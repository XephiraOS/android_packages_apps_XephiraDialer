package com.android.contacts.framework.baseui.util;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Icon;
import com.android.incallui.OplusPhoneCapabilities;
import com.coui.appcompat.scrollbar.COUIScrollBar;
import com.oplus.foundation.util.feature.FeatureUtil;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlinx.coroutines.M;
import p9.InterfaceC1470d;

/* compiled from: NotificationUtils.kt */
@InterfaceC1470d(c = "com.android.contacts.framework.baseui.util.NotificationUtilsKt$showNumberRecognitionNotificationIfNeed$1", f = "NotificationUtils.kt", l = {69}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class NotificationUtilsKt$showNumberRecognitionNotificationIfNeed$1 extends SuspendLambda implements v9.p<kotlinx.coroutines.E, kotlin.coroutines.c<? super m9.q>, Object> {
    final /* synthetic */ Context $context;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NotificationUtilsKt$showNumberRecognitionNotificationIfNeed$1(Context context, kotlin.coroutines.c<? super NotificationUtilsKt$showNumberRecognitionNotificationIfNeed$1> cVar) {
        super(2, cVar);
        this.$context = context;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final kotlin.coroutines.c<m9.q> create(Object obj, kotlin.coroutines.c<?> cVar) {
        return new NotificationUtilsKt$showNumberRecognitionNotificationIfNeed$1(this.$context, cVar);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object c10;
        boolean g10;
        c10 = kotlin.coroutines.intrinsics.b.c();
        int i10 = this.label;
        if (i10 != 0) {
            if (i10 == 1) {
                kotlin.b.b(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            kotlin.b.b(obj);
            this.label = 1;
            if (M.a(COUIScrollBar.SCROLLER_FADE_TIMEOUT, this) == c10) {
                return c10;
            }
        }
        if (!kotlin.jvm.internal.i.b(FeatureUtil.w(), StatementUtils.f15877a.k(this.$context)) && NumberIdentifyUtils.e(this.$context)) {
            if (this.$context.checkSelfPermission("android.permission.POST_NOTIFICATIONS") == 0) {
                g10 = NotificationUtilsKt.g(this.$context);
                if (g10) {
                    H7.b.e("NotificationUtils", "Notification Exist");
                    return m9.q.f35511a;
                }
                androidx.core.app.i c11 = androidx.core.app.i.c(this.$context);
                kotlin.jvm.internal.i.e(c11, "from(context)");
                if (c11.e("number_recognition_update") == null) {
                    c11.b(new NotificationChannel("number_recognition_update", this.$context.getString(N0.k.f1972n), 4));
                }
                Intent addFlags = new Intent().setAction("android.intent.action.DIAL").setPackage(this.$context.getPackageName()).addFlags(OplusPhoneCapabilities.CAPABILITY_SUPPORTS_RTT_REMOTE);
                kotlin.jvm.internal.i.e(addFlags, "Intent().setAction(Inten…t.FLAG_ACTIVITY_NEW_TASK)");
                PendingIntent activity = PendingIntent.getActivity(this.$context, 0, addFlags, 201326592);
                Context createPackageContext = this.$context.createPackageContext("com.ted.number", 0);
                String f10 = M7.a.f(this.$context, "com.ted.number", "number_recognition_notice_update_notification_title", createPackageContext);
                String f11 = M7.a.f(this.$context, "com.ted.number", "number_recognition_notice_update_notification_content", createPackageContext);
                String f12 = M7.a.f(this.$context, "com.ted.number", "number_recognition_notice_update_notification_action_button_text", createPackageContext);
                if (f10 != null && f10.length() != 0 && f11 != null && f11.length() != 0 && f12 != null && f12.length() != 0) {
                    Notification build = new Notification.Builder(this.$context, "number_recognition_update").setContentTitle(f10).setContentText(f11).setStyle(new Notification.BigTextStyle().bigText(f11)).setSmallIcon(N0.g.f1906f).setOngoing(true).setAutoCancel(true).setContentIntent(activity).addAction(new Notification.Action.Builder((Icon) null, f12, activity).build()).build();
                    kotlin.jvm.internal.i.e(build, "Builder(context, NUMBER_…\n                .build()");
                    c11.f("number_recognition", 1, build);
                    NotificationUtilsKt.f15870a = true;
                } else {
                    H7.b.i("NotificationUtils", f10 + " " + f11 + " " + f12);
                    return m9.q.f35511a;
                }
            } else {
                H7.b.i("NotificationUtils", "POST_NOTIFICATIONS not be granted");
                return m9.q.f35511a;
            }
        }
        return m9.q.f35511a;
    }

    @Override // v9.p
    public final Object invoke(kotlinx.coroutines.E e10, kotlin.coroutines.c<? super m9.q> cVar) {
        return ((NotificationUtilsKt$showNumberRecognitionNotificationIfNeed$1) create(e10, cVar)).invokeSuspend(m9.q.f35511a);
    }
}
