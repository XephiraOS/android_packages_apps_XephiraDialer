package A2;

import android.os.Handler;
import android.os.Message;
import com.android.contacts.framework.virtualsupport.utils.GrpcUtils;
import com.android.incallui.InCallPresenter;
import com.android.incallui.Log;
import com.android.incallui.OplusPhoneUtils;

/* compiled from: OplusMonitorInCallActivityStatus.java */
/* loaded from: classes.dex */
public class o {

    /* renamed from: a, reason: collision with root package name */
    public Handler f151a = new a();

    /* compiled from: OplusMonitorInCallActivityStatus.java */
    /* loaded from: classes.dex */
    public class a extends Handler {
        public a() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i10 = message.what;
            if (i10 != 100) {
                if (i10 == 101) {
                    if (Log.sDebug) {
                        Log.d("OplusMonitorInCallActivityStatus", "MSG_SECOND_CHECK_START_ACTIVITY_TIMEOUT");
                    }
                    o.this.f();
                }
            } else {
                if (Log.sDebug) {
                    Log.d("OplusMonitorInCallActivityStatus", "MSG_FIRST_CHECK_START_ACTIVITY_TIMEOUT");
                }
                o.this.g();
            }
            super.handleMessage(message);
        }
    }

    public final void c() {
        if (Log.sDebug) {
            Log.d("OplusMonitorInCallActivityStatus", "cancelCheckMessage");
        }
        Handler handler = this.f151a;
        if (handler != null) {
            if (handler.hasMessages(100)) {
                this.f151a.removeMessages(100);
            }
            if (this.f151a.hasMessages(101)) {
                this.f151a.removeMessages(101);
            }
        }
    }

    public void d() {
        if (Log.sDebug) {
            Log.d("OplusMonitorInCallActivityStatus", "clean ...");
        }
        c();
    }

    /* JADX WARN: Code restructure failed: missing block: B:6:0x0015, code lost:
    
        if (r2.getIncomingCall() != null) goto L10;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean e() {
        /*
            r2 = this;
            com.android.incallui.CallList r2 = com.android.incallui.CallList.getInstance()
            com.android.incallui.OplusCallList r2 = r2.oplusCallList()
            if (r2 == 0) goto L18
            int r0 = r2.oplusGetCallSize()
            r1 = 1
            if (r0 != r1) goto L18
            com.android.incallui.Call r2 = r2.getIncomingCall()
            if (r2 == 0) goto L18
            goto L19
        L18:
            r1 = 0
        L19:
            boolean r2 = com.android.incallui.Log.sDebug
            if (r2 == 0) goto L33
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r0 = "isSingleIncomingCall  = "
            r2.append(r0)
            r2.append(r1)
            java.lang.String r2 = r2.toString()
            java.lang.String r0 = "OplusMonitorInCallActivityStatus"
            com.android.incallui.Log.d(r0, r2)
        L33:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: A2.o.e():boolean");
    }

    public final void f() {
        if (Log.sDebug) {
            Log.d("OplusMonitorInCallActivityStatus", "sendBroadcastInCallActivityPause");
        }
        if (e()) {
            InCallPresenter inCallPresenter = InCallPresenter.getInstance();
            OplusPhoneUtils.sendBroadcastInCallActivityState(inCallPresenter.getContext(), false);
            inCallPresenter.wakeUpScreen();
        }
        d();
    }

    public final void g() {
        if (Log.sDebug) {
            Log.d("OplusMonitorInCallActivityStatus", "startIncallActivityAgain");
        }
        if (e()) {
            InCallPresenter.getInstance().showInCall(false, false);
            InCallPresenter.getInstance().realInstance().startRinging("ActivityFocusTimeout");
            i();
            return;
        }
        d();
    }

    public void h() {
        if (Log.sDebug) {
            Log.d("OplusMonitorInCallActivityStatus", "startActivityFirst");
        }
        if (e() && !this.f151a.hasMessages(100)) {
            this.f151a.sendEmptyMessageDelayed(100, GrpcUtils.CREATE_CHANNEL_TIME_OUT);
        }
    }

    public void i() {
        if (Log.sDebug) {
            Log.d("OplusMonitorInCallActivityStatus", "startActivitySecond");
        }
        if (e() && !this.f151a.hasMessages(101)) {
            this.f151a.sendEmptyMessageDelayed(101, GrpcUtils.CREATE_CHANNEL_TIME_OUT);
        } else {
            d();
        }
    }
}
