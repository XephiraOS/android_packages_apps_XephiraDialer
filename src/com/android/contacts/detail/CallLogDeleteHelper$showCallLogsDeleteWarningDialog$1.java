package com.android.contacts.detail;

import android.content.DialogInterface;
import androidx.activity.ComponentActivity;
import androidx.appcompat.app.b;
import com.android.contacts.business.calllog.breenocall.FeatureOpt;
import com.android.contacts.detail.CallLogDeleteHelper;
import com.android.contacts.detail.CallLogDeleteHelper$showCallLogsDeleteWarningDialog$1;
import com.android.contacts.framework.baseui.calllog.utils.CallRecordingUtils;
import com.coui.appcompat.dialog.COUIAlertDialogBuilder;
import com.coui.appcompat.dialog.COUISecurityAlertDialogBuilder;
import com.customize.contacts.FeatureOption;
import com.oplus.dialer.R;
import com.oplus.foundation.util.feature.AppMetaFeatures;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.Ref$BooleanRef;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlinx.coroutines.C1244g;
import p9.C1467a;
import p9.InterfaceC1470d;

/* compiled from: CallLogDeleteHelper.kt */
@InterfaceC1470d(c = "com.android.contacts.detail.CallLogDeleteHelper$showCallLogsDeleteWarningDialog$1", f = "CallLogDeleteHelper.kt", l = {157}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class CallLogDeleteHelper$showCallLogsDeleteWarningDialog$1 extends SuspendLambda implements v9.p<kotlinx.coroutines.E, kotlin.coroutines.c<? super m9.q>, Object> {
    final /* synthetic */ ComponentActivity $activity;
    final /* synthetic */ ArrayList<Q0.b> $callLogs;
    final /* synthetic */ CallLogDeleteHelper.a $callback;
    final /* synthetic */ int $selectedCount;
    final /* synthetic */ int $total;
    private /* synthetic */ Object L$0;
    int label;

    /* compiled from: CallLogDeleteHelper.kt */
    @InterfaceC1470d(c = "com.android.contacts.detail.CallLogDeleteHelper$showCallLogsDeleteWarningDialog$1$2", f = "CallLogDeleteHelper.kt", l = {}, m = "invokeSuspend")
    /* renamed from: com.android.contacts.detail.CallLogDeleteHelper$showCallLogsDeleteWarningDialog$1$2, reason: invalid class name */
    /* loaded from: classes.dex */
    public static final class AnonymousClass2 extends SuspendLambda implements v9.p<kotlinx.coroutines.E, kotlin.coroutines.c<? super m9.q>, Object> {
        final /* synthetic */ ComponentActivity $activity;
        final /* synthetic */ CallLogDeleteHelper.a $callback;
        final /* synthetic */ Ref$BooleanRef $hasBreenoCall;
        final /* synthetic */ Ref$BooleanRef $hasCallSummary;
        final /* synthetic */ Ref$BooleanRef $hasRecordings;
        final /* synthetic */ int $selectedCount;
        final /* synthetic */ int $total;
        int label;

        /* compiled from: CallLogDeleteHelper.kt */
        /* renamed from: com.android.contacts.detail.CallLogDeleteHelper$showCallLogsDeleteWarningDialog$1$2$a */
        /* loaded from: classes.dex */
        public static final class a implements com.android.contacts.framework.baseui.util.t {

            /* renamed from: a, reason: collision with root package name */
            public final /* synthetic */ Ref$BooleanRef f14372a;

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ ComponentActivity f14373b;

            public a(Ref$BooleanRef ref$BooleanRef, ComponentActivity componentActivity) {
                this.f14372a = ref$BooleanRef;
                this.f14373b = componentActivity;
            }

            @Override // com.android.contacts.framework.baseui.util.t
            public void a(int i10, Object obj, Object obj2) {
                Ref$BooleanRef ref$BooleanRef = this.f14372a;
                ComponentActivity componentActivity = this.f14373b;
                String e10 = com.android.contacts.util.w.e();
                kotlin.jvm.internal.i.e(e10, "getPermissionForReadAudio()");
                ref$BooleanRef.element = com.android.contacts.util.w.l(componentActivity, new String[]{e10});
                H7.b.b("CallLogDeleteHelper", "onCall: code: " + i10 + ", hasAudioPermission: " + this.f14372a.element);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(ComponentActivity componentActivity, Ref$BooleanRef ref$BooleanRef, Ref$BooleanRef ref$BooleanRef2, Ref$BooleanRef ref$BooleanRef3, int i10, int i11, CallLogDeleteHelper.a aVar, kotlin.coroutines.c<? super AnonymousClass2> cVar) {
            super(2, cVar);
            this.$activity = componentActivity;
            this.$hasRecordings = ref$BooleanRef;
            this.$hasCallSummary = ref$BooleanRef2;
            this.$hasBreenoCall = ref$BooleanRef3;
            this.$selectedCount = i10;
            this.$total = i11;
            this.$callback = aVar;
        }

        public static final void j(Ref$BooleanRef ref$BooleanRef, Ref$BooleanRef ref$BooleanRef2, ComponentActivity componentActivity, int i10, boolean z10) {
            if (i10 == 0) {
                ref$BooleanRef.element = z10;
                H7.b.b("CallLogDeleteHelper", "showCallLogsDeleteWarningDialog: which: " + i10 + ", checked: " + z10);
                if (ref$BooleanRef.element && ref$BooleanRef2.element) {
                    Ref$BooleanRef ref$BooleanRef3 = new Ref$BooleanRef();
                    String e10 = com.android.contacts.util.w.e();
                    kotlin.jvm.internal.i.e(e10, "getPermissionForReadAudio()");
                    boolean l10 = com.android.contacts.util.w.l(componentActivity, new String[]{e10});
                    ref$BooleanRef3.element = l10;
                    H7.b.e("CallLogDeleteHelper", "showPromptDialog: hasAudioPermission: " + l10);
                    if (!ref$BooleanRef3.element) {
                        com.android.contacts.util.w.A(componentActivity, false, null, com.android.contacts.util.w.e(), 999, new a(ref$BooleanRef3, componentActivity));
                    }
                }
            }
        }

        public static final void k(CallLogDeleteHelper.a aVar, Ref$BooleanRef ref$BooleanRef, DialogInterface dialogInterface, int i10) {
            aVar.onClick(i10, ref$BooleanRef.element);
            dialogInterface.dismiss();
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final kotlin.coroutines.c<m9.q> create(Object obj, kotlin.coroutines.c<?> cVar) {
            return new AnonymousClass2(this.$activity, this.$hasRecordings, this.$hasCallSummary, this.$hasBreenoCall, this.$selectedCount, this.$total, this.$callback, cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            String c10;
            boolean z10;
            b.a cOUIAlertDialogBuilder;
            String d10;
            kotlin.coroutines.intrinsics.b.c();
            if (this.label == 0) {
                kotlin.b.b(obj);
                c10 = CallLogDeleteHelper.c(this.$activity, this.$hasRecordings.element, this.$hasCallSummary.element, this.$hasBreenoCall.element, this.$selectedCount);
                if (c10 != null) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                if (z10) {
                    cOUIAlertDialogBuilder = new COUISecurityAlertDialogBuilder(this.$activity);
                } else {
                    cOUIAlertDialogBuilder = new COUIAlertDialogBuilder(this.$activity);
                }
                d10 = CallLogDeleteHelper.d(this.$activity, this.$selectedCount, this.$total);
                cOUIAlertDialogBuilder.setTitle((CharSequence) d10);
                final Ref$BooleanRef ref$BooleanRef = new Ref$BooleanRef();
                if (z10) {
                    COUISecurityAlertDialogBuilder cOUISecurityAlertDialogBuilder = (COUISecurityAlertDialogBuilder) cOUIAlertDialogBuilder;
                    cOUISecurityAlertDialogBuilder.setMessage((CharSequence) c10);
                    cOUISecurityAlertDialogBuilder.setHasCheckBox(true);
                    cOUISecurityAlertDialogBuilder.setChecked(false);
                    cOUISecurityAlertDialogBuilder.setCheckBoxString(R.string.delete_associated_files);
                    final Ref$BooleanRef ref$BooleanRef2 = this.$hasRecordings;
                    final ComponentActivity componentActivity = this.$activity;
                    cOUISecurityAlertDialogBuilder.setOnSelectedListener(new COUISecurityAlertDialogBuilder.OnSelectedListener() { // from class: com.android.contacts.detail.B
                        @Override // com.coui.appcompat.dialog.COUISecurityAlertDialogBuilder.OnSelectedListener
                        public final void onSelected(int i10, boolean z11) {
                            CallLogDeleteHelper$showCallLogsDeleteWarningDialog$1.AnonymousClass2.j(Ref$BooleanRef.this, ref$BooleanRef2, componentActivity, i10, z11);
                        }
                    });
                }
                int a10 = com.customize.contacts.util.X.a(this.$selectedCount, this.$total);
                final CallLogDeleteHelper.a aVar = this.$callback;
                cOUIAlertDialogBuilder.setNeutralButton(a10, new DialogInterface.OnClickListener() { // from class: com.android.contacts.detail.C
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i10) {
                        CallLogDeleteHelper$showCallLogsDeleteWarningDialog$1.AnonymousClass2.k(CallLogDeleteHelper.a.this, ref$BooleanRef, dialogInterface, i10);
                    }
                });
                cOUIAlertDialogBuilder.setNegativeButton(R.string.cancel, (DialogInterface.OnClickListener) null);
                CallLogDeleteHelper.a aVar2 = this.$callback;
                androidx.appcompat.app.b show = cOUIAlertDialogBuilder.show();
                kotlin.jvm.internal.i.e(show, "dialogBuilder.show()");
                aVar2.a(show);
                return m9.q.f35511a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        @Override // v9.p
        public final Object invoke(kotlinx.coroutines.E e10, kotlin.coroutines.c<? super m9.q> cVar) {
            return ((AnonymousClass2) create(e10, cVar)).invokeSuspend(m9.q.f35511a);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CallLogDeleteHelper$showCallLogsDeleteWarningDialog$1(ComponentActivity componentActivity, int i10, int i11, ArrayList<Q0.b> arrayList, CallLogDeleteHelper.a aVar, kotlin.coroutines.c<? super CallLogDeleteHelper$showCallLogsDeleteWarningDialog$1> cVar) {
        super(2, cVar);
        this.$activity = componentActivity;
        this.$selectedCount = i10;
        this.$total = i11;
        this.$callLogs = arrayList;
        this.$callback = aVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final kotlin.coroutines.c<m9.q> create(Object obj, kotlin.coroutines.c<?> cVar) {
        CallLogDeleteHelper$showCallLogsDeleteWarningDialog$1 callLogDeleteHelper$showCallLogsDeleteWarningDialog$1 = new CallLogDeleteHelper$showCallLogsDeleteWarningDialog$1(this.$activity, this.$selectedCount, this.$total, this.$callLogs, this.$callback, cVar);
        callLogDeleteHelper$showCallLogsDeleteWarningDialog$1.L$0 = obj;
        return callLogDeleteHelper$showCallLogsDeleteWarningDialog$1;
    }

    /* JADX WARN: Type inference failed for: r7v5, types: [T, java.util.Set] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object c10;
        Ref$BooleanRef ref$BooleanRef;
        boolean z10;
        Iterator it;
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
            long currentTimeMillis = System.currentTimeMillis();
            Ref$BooleanRef ref$BooleanRef2 = new Ref$BooleanRef();
            Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
            if (AppMetaFeatures.b()) {
                ref$ObjectRef.element = CallRecordingUtils.d(this.$activity);
                ref$BooleanRef2.element = !((Collection) r7).isEmpty();
            }
            boolean m10 = FeatureOption.m();
            boolean isCallSummaryIconDisplayable = FeatureOpt.isCallSummaryIconDisplayable();
            Ref$BooleanRef ref$BooleanRef3 = new Ref$BooleanRef();
            ref$BooleanRef3.element = !ref$BooleanRef2.element;
            Ref$BooleanRef ref$BooleanRef4 = new Ref$BooleanRef();
            ref$BooleanRef4.element = !m10;
            Ref$BooleanRef ref$BooleanRef5 = new Ref$BooleanRef();
            ref$BooleanRef5.element = !isCallSummaryIconDisplayable;
            Ref$BooleanRef ref$BooleanRef6 = new Ref$BooleanRef();
            Ref$BooleanRef ref$BooleanRef7 = new Ref$BooleanRef();
            Ref$BooleanRef ref$BooleanRef8 = new Ref$BooleanRef();
            if (ref$BooleanRef2.element || m10 || isCallSummaryIconDisplayable) {
                for (Q0.b bVar : this.$callLogs) {
                    if (ref$BooleanRef2.element) {
                        if (!ref$BooleanRef6.element) {
                            Iterator it2 = bVar.a().iterator();
                            while (it2.hasNext()) {
                                Q0.d dVar = (Q0.d) it2.next();
                                Ref$BooleanRef ref$BooleanRef9 = ref$BooleanRef2;
                                Set set = (Set) ref$ObjectRef.element;
                                if (set != null) {
                                    it = it2;
                                    if (set.contains(C1467a.e(dVar.a()))) {
                                        ref$BooleanRef6.element = true;
                                        ref$BooleanRef3.element = true;
                                    }
                                } else {
                                    it = it2;
                                }
                                ref$BooleanRef2 = ref$BooleanRef9;
                                it2 = it;
                            }
                        }
                        ref$BooleanRef = ref$BooleanRef2;
                        z10 = true;
                    } else {
                        ref$BooleanRef = ref$BooleanRef2;
                        z10 = true;
                        ref$BooleanRef3.element = true;
                    }
                    if (m10) {
                        if (!ref$BooleanRef7.element && bVar.e()) {
                            ref$BooleanRef7.element = z10;
                            ref$BooleanRef4.element = z10;
                        }
                    } else {
                        ref$BooleanRef4.element = z10;
                    }
                    if (isCallSummaryIconDisplayable) {
                        if (!ref$BooleanRef8.element && bVar.f()) {
                            ref$BooleanRef8.element = z10;
                            ref$BooleanRef5.element = z10;
                        }
                    } else {
                        ref$BooleanRef5.element = z10;
                    }
                    if (ref$BooleanRef5.element && ref$BooleanRef4.element && ref$BooleanRef3.element) {
                        break;
                    }
                    ref$BooleanRef2 = ref$BooleanRef;
                }
            }
            long currentTimeMillis2 = System.currentTimeMillis();
            H7.b.e("CallLogDeleteHelper", "showCallLogsDeleteWarningDialog: selected: " + this.$selectedCount + ", total: " + this.$total + ", has recordings: " + ref$BooleanRef6.element + ", has call summary: " + ref$BooleanRef8.element + ", has breeno call: " + ref$BooleanRef7.element + ", take: " + (currentTimeMillis2 - currentTimeMillis));
            kotlinx.coroutines.w0 c11 = kotlinx.coroutines.S.c();
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(this.$activity, ref$BooleanRef6, ref$BooleanRef8, ref$BooleanRef7, this.$selectedCount, this.$total, this.$callback, null);
            this.label = 1;
            if (C1244g.g(c11, anonymousClass2, this) == c10) {
                return c10;
            }
        }
        return m9.q.f35511a;
    }

    @Override // v9.p
    public final Object invoke(kotlinx.coroutines.E e10, kotlin.coroutines.c<? super m9.q> cVar) {
        return ((CallLogDeleteHelper$showCallLogsDeleteWarningDialog$1) create(e10, cVar)).invokeSuspend(m9.q.f35511a);
    }
}
