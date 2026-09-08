package com.customize.contacts.mediaplayer;

import android.media.AudioDeviceInfo;
import android.media.AudioManager;
import android.util.Log;
import kotlin.Result;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlinx.coroutines.C1248i;
import kotlinx.coroutines.E;
import kotlinx.coroutines.S;
import m9.q;
import p9.C1467a;
import p9.InterfaceC1470d;
import v9.p;

/* compiled from: RecordPlayerPresenter.kt */
@InterfaceC1470d(c = "com.customize.contacts.mediaplayer.RecordPlayerPresenter$getBluetoothAndHeadSetsStatus$1", f = "RecordPlayerPresenter.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class RecordPlayerPresenter$getBluetoothAndHeadSetsStatus$1 extends SuspendLambda implements p<E, kotlin.coroutines.c<? super q>, Object> {
    int label;
    final /* synthetic */ RecordPlayerPresenter this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RecordPlayerPresenter$getBluetoothAndHeadSetsStatus$1(RecordPlayerPresenter recordPlayerPresenter, kotlin.coroutines.c<? super RecordPlayerPresenter$getBluetoothAndHeadSetsStatus$1> cVar) {
        super(2, cVar);
        this.this$0 = recordPlayerPresenter;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final kotlin.coroutines.c<q> create(Object obj, kotlin.coroutines.c<?> cVar) {
        return new RecordPlayerPresenter$getBluetoothAndHeadSetsStatus$1(this.this$0, cVar);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object b10;
        AudioManager R10;
        AudioDeviceInfo[] audioDeviceInfoArr;
        boolean z10;
        boolean z11;
        kotlin.coroutines.intrinsics.b.c();
        if (this.label == 0) {
            kotlin.b.b(obj);
            boolean z12 = false;
            this.this$0.f21663q = false;
            this.this$0.f21662p = false;
            RecordPlayerPresenter recordPlayerPresenter = this.this$0;
            try {
                Result.a aVar = Result.f34166a;
                R10 = recordPlayerPresenter.R();
                if (R10 != null) {
                    audioDeviceInfoArr = R10.getDevices(2);
                } else {
                    audioDeviceInfoArr = null;
                }
                if (audioDeviceInfoArr != null) {
                    boolean z13 = false;
                    for (AudioDeviceInfo audioDeviceInfo : audioDeviceInfoArr) {
                        int type = audioDeviceInfo.getType();
                        if (type != 1) {
                            if (type == 22 || type == 3 || type == 4) {
                                recordPlayerPresenter.f21662p = true;
                            } else if (type == 7 || type == 8) {
                                recordPlayerPresenter.f21663q = true;
                            }
                        } else {
                            z13 = true;
                        }
                    }
                    z12 = z13;
                }
                recordPlayerPresenter.f21664r = C1467a.a(z12);
                C1248i.d(recordPlayerPresenter.f21648b, S.c(), null, new RecordPlayerPresenter$getBluetoothAndHeadSetsStatus$1$1$2(recordPlayerPresenter, null), 2, null);
                z10 = recordPlayerPresenter.f21663q;
                z11 = recordPlayerPresenter.f21662p;
                H7.b.b("RecordPlayerPresenter", "getBluetoothAndHeadSetsStatus is bluetooth connected: " + z10 + ", is wireless headset on: " + z11 + ", hasReceivers: " + z12);
                b10 = Result.b(q.f35511a);
            } catch (Throwable th) {
                Result.a aVar2 = Result.f34166a;
                b10 = Result.b(kotlin.b.a(th));
            }
            Throwable d10 = Result.d(b10);
            if (d10 != null) {
                Log.e("ExceptionUtils", "Exception when invoke block : " + d10);
            }
            return q.f35511a;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Override // v9.p
    public final Object invoke(E e10, kotlin.coroutines.c<? super q> cVar) {
        return ((RecordPlayerPresenter$getBluetoothAndHeadSetsStatus$1) create(e10, cVar)).invokeSuspend(q.f35511a);
    }
}
