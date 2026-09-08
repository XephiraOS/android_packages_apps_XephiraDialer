package com.oplus.contacts.list.cloudsync;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import com.android.incallui.OplusPhoneCapabilities;
import com.coui.appcompat.dialog.COUIAlertDialogBuilder;
import com.oplus.contacts.list.cloudsync.CloudSyncPauseType;
import com.oplus.dialer.R;
import f.C0991a;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.i;
import m9.q;
import v9.InterfaceC1637a;
import v9.l;

/* compiled from: CloudSyncPauseType.kt */
/* loaded from: classes3.dex */
public abstract class CloudSyncPauseType {

    /* renamed from: a, reason: collision with root package name */
    public final InterfaceC1637a<q> f27863a;

    /* compiled from: CloudSyncPauseType.kt */
    /* loaded from: classes3.dex */
    public static final class CloudAppDisable extends CloudSyncPauseType {
        public CloudAppDisable(InterfaceC1637a<q> interfaceC1637a) {
            super(interfaceC1637a, null);
        }

        @Override // com.oplus.contacts.list.cloudsync.CloudSyncPauseType
        public void a(final Context context) {
            i.f(context, "context");
            a.b(context, R.drawable.pb_ic_cloud_sync_common_error, R.string.cloud_sync_cloud_app_disable_tips, R.string.cloud_sync_enable, new l<COUIAlertDialogBuilder, q>() { // from class: com.oplus.contacts.list.cloudsync.CloudSyncPauseType$CloudAppDisable$onPauseTipClick$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                public final void b(COUIAlertDialogBuilder it) {
                    i.f(it, "it");
                    Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS", Uri.fromParts("package", "com.heytap.cloud", null));
                    intent.addFlags(OplusPhoneCapabilities.CAPABILITY_SUPPORTS_RTT_REMOTE);
                    R7.b.f(context, intent, 0, null, 6, null);
                }

                @Override // v9.l
                public /* bridge */ /* synthetic */ q invoke(COUIAlertDialogBuilder cOUIAlertDialogBuilder) {
                    b(cOUIAlertDialogBuilder);
                    return q.f35511a;
                }
            });
        }
    }

    /* compiled from: CloudSyncPauseType.kt */
    /* loaded from: classes3.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public static final a f27864a = new a();

        public static final COUIAlertDialogBuilder b(Context context, int i10, int i11, int i12, final l<? super COUIAlertDialogBuilder, q> onButtonClick) {
            i.f(context, "context");
            i.f(onButtonClick, "onButtonClick");
            final COUIAlertDialogBuilder cOUIAlertDialogBuilder = new COUIAlertDialogBuilder(context, 2132083081);
            cOUIAlertDialogBuilder.setTitle(R.string.contacts_cloud_sync);
            cOUIAlertDialogBuilder.setCustomDrawable(C0991a.b(context, i10));
            cOUIAlertDialogBuilder.setCustomMessage(context.getString(i11));
            cOUIAlertDialogBuilder.setPositiveButton(i12, new DialogInterface.OnClickListener() { // from class: com.oplus.contacts.list.cloudsync.a
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i13) {
                    CloudSyncPauseType.a.c(l.this, cOUIAlertDialogBuilder, dialogInterface, i13);
                }
            });
            cOUIAlertDialogBuilder.setNegativeButton(R.string.cancel, (DialogInterface.OnClickListener) null);
            cOUIAlertDialogBuilder.show();
            return cOUIAlertDialogBuilder;
        }

        public static final void c(l onButtonClick, COUIAlertDialogBuilder this_apply, DialogInterface dialogInterface, int i10) {
            i.f(onButtonClick, "$onButtonClick");
            i.f(this_apply, "$this_apply");
            onButtonClick.invoke(this_apply);
        }
    }

    public /* synthetic */ CloudSyncPauseType(InterfaceC1637a interfaceC1637a, f fVar) {
        this(interfaceC1637a);
    }

    public abstract void a(Context context);

    public CloudSyncPauseType(InterfaceC1637a<q> interfaceC1637a) {
        this.f27863a = interfaceC1637a;
    }
}
