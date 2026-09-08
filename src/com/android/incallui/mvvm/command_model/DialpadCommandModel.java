package com.android.incallui.mvvm.command_model;

import android.telephony.PhoneNumberUtils;
import com.android.incallui.Call;
import com.android.incallui.CallList;
import com.android.incallui.Log;
import com.android.incallui.TelecomAdapter;
import com.android.incallui.mvvm.utils.h;
import com.android.incallui.mvvm.view_model.DialpadViewModel;
import d2.C0948a;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.i;
import m9.q;
import v9.InterfaceC1637a;
import v9.l;

/* compiled from: DialpadCommandModel.kt */
/* loaded from: classes.dex */
public final class DialpadCommandModel extends C0948a<DialpadViewModel> {

    /* renamed from: e, reason: collision with root package name */
    public static final a f18531e = new a(null);

    /* renamed from: b, reason: collision with root package name */
    public final DialpadViewModel f18532b;

    /* renamed from: c, reason: collision with root package name */
    public final l<Character, q> f18533c;

    /* renamed from: d, reason: collision with root package name */
    public final InterfaceC1637a<q> f18534d;

    /* compiled from: DialpadCommandModel.kt */
    /* loaded from: classes.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DialpadCommandModel(DialpadViewModel dialpadViewModel) {
        super(dialpadViewModel);
        i.f(dialpadViewModel, "dialpadViewModel");
        this.f18532b = dialpadViewModel;
        this.f18533c = new l<Character, q>() { // from class: com.android.incallui.mvvm.command_model.DialpadCommandModel$processDtmfInput$1
            {
                super(1);
            }

            public final q b(char c10) {
                Call c11;
                DialpadViewModel dialpadViewModel2;
                DialpadViewModel dialpadViewModel3;
                Log.d("DialpadCommandModel", "Processing dtmf key " + c10);
                c11 = DialpadCommandModel.this.c();
                if (c11 != null) {
                    DialpadCommandModel dialpadCommandModel = DialpadCommandModel.this;
                    if (PhoneNumberUtils.is12Key(c10)) {
                        Log.d("DialpadCommandModel", "updating display and sending dtmf tone for '" + c10 + '\'');
                        dialpadViewModel2 = dialpadCommandModel.f18532b;
                        h<String> i10 = dialpadViewModel2.i();
                        StringBuilder sb = new StringBuilder();
                        dialpadViewModel3 = dialpadCommandModel.f18532b;
                        sb.append(dialpadViewModel3.i().getValue());
                        sb.append(c10);
                        i10.o(sb.toString());
                        TelecomAdapter.getInstance().playDtmfTone(c11.getId(), c10);
                    } else {
                        Log.d("DialpadCommandModel", "ignoring dtmf request for '" + c10 + '\'');
                    }
                    return q.f35511a;
                }
                return null;
            }

            @Override // v9.l
            public /* bridge */ /* synthetic */ q invoke(Character ch) {
                return b(ch.charValue());
            }
        };
        this.f18534d = new InterfaceC1637a<q>() { // from class: com.android.incallui.mvvm.command_model.DialpadCommandModel$stopDtmfProcess$1
            {
                super(0);
            }

            @Override // v9.InterfaceC1637a
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public final q invoke() {
                Call c10;
                Log.d("DialpadCommandModel", "stopping remote tone");
                c10 = DialpadCommandModel.this.c();
                if (c10 != null) {
                    Log.d("DialpadCommandModel", "stopping remote tone success");
                    TelecomAdapter.getInstance().stopDtmfTone(c10.getId());
                    return q.f35511a;
                }
                return null;
            }
        };
    }

    public final Call c() {
        Call activeCall = CallList.getInstance().getActiveCall();
        if (activeCall == null) {
            return CallList.getInstance().oplusCallList().oplusGetOutgoingCall();
        }
        return activeCall;
    }

    public final l<Character, q> d() {
        return this.f18533c;
    }

    public final InterfaceC1637a<q> e() {
        return this.f18534d;
    }
}
