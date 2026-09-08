package com.android.incallui;

import P2.a;
import android.content.Intent;
import android.os.Binder;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Parcel;
import android.text.TextUtils;
import com.android.incallui.ContactInfoCache;
import com.android.oplus.module.castScreen.CastScreen;
import x2.C1676a;

/* loaded from: classes.dex */
public class OplusInCallServiceImpl extends InCallServiceImpl {
    private static final String LOG_TAG = "OplusInCallServiceImpl";
    private IBinder mInCallServiceBinder = null;
    private IBinder mOplusInCallServiceStubExt = null;
    private Handler mMainHandler = new Handler(Looper.getMainLooper()) { // from class: com.android.incallui.OplusInCallServiceImpl.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Bundle data = message.getData();
            if (data == null) {
                return;
            }
            int i10 = message.what;
            if (i10 != 1) {
                if (i10 != 2) {
                    if (i10 != 3) {
                        if (i10 != 4) {
                            if (i10 == 5) {
                                ((OplusInCallPresenter) InCallPresenter.getInstance()).answerFromNonUi(data.getString("telecomCallId"), data.getInt("videoState"));
                                return;
                            }
                            return;
                        }
                        ((OplusInCallPresenter) InCallPresenter.getInstance()).oplusSendSRVCCMsg();
                        return;
                    }
                    if (OplusFeatureOption.OPLUS_PHONE_HIDE_INTERCEPT_CALL_NOTIFICATION) {
                        if (Log.sDebug) {
                            Log.i(OplusInCallServiceImpl.LOG_TAG, "hide the intercept call notification ");
                            return;
                        }
                        return;
                    } else {
                        InCallPresenter.getInstance().oplusInterceptCallNotification(data.getInt("notificationType"));
                        return;
                    }
                }
                int i11 = data.getInt("size");
                Log.i(OplusInCallServiceImpl.LOG_TAG, "_setImsConfernceSize = " + i11);
                OplusPhoneUtils.setImsConferenceSize(i11);
                return;
            }
            String string = data.getString("number");
            int i12 = data.getInt("calldirection", -2);
            D2.g.k(OplusInCallServiceImpl.LOG_TAG, "startQueryContactInfo number = " + D2.g.l(string) + ", callDirection = " + i12);
            A2.j.J().b0(OplusPhoneUtils.formatQueryNumber(string), i12);
        }
    };

    /* loaded from: classes.dex */
    public static class OplusInCallServiceStubExt extends Binder {
        private IBinder mIBinder;

        public OplusInCallServiceStubExt(IBinder iBinder) {
            this.mIBinder = iBinder;
        }

        public void answerFromNonUi(String str, int i10) {
            ((OplusInCallPresenter) InCallPresenter.getInstance()).answerFromNonUi(str, i10);
        }

        public a.C0054a getContactAndYellowPageInfo(String str) {
            ContactInfoCache.ContactCacheEntry E10 = A2.j.J().E(str);
            if (E10 == null) {
                E10 = A2.j.J().G(str);
            }
            if (E10 != null) {
                a.C0054a c0054a = new a.C0054a();
                if (TextUtils.isEmpty(E10.name) && !TextUtils.isEmpty(E10.yellowPageInfo.f95c)) {
                    c0054a.f2879a = E10.yellowPageInfo.f95c;
                } else {
                    c0054a.f2879a = E10.name;
                }
                c0054a.f2880b = E10.person_id;
                c0054a.f2881c = E10.location;
                c0054a.f2882d = E10.lookupKey;
                A2.A a10 = E10.yellowPageInfo;
                c0054a.f2883e = a10.f97e;
                c0054a.f2884f = a10.f99g;
                return c0054a;
            }
            return null;
        }

        public int getIncomingInterfaceType() {
            return ((OplusInCallPresenter) InCallPresenter.getInstance()).getIncomingInterfaceType();
        }

        @Override // android.os.Binder
        public boolean onTransact(int i10, Parcel parcel, Parcel parcel2, int i11) {
            switch (i10) {
                case 101:
                    parcel.enforceInterface("com.android.telecom.OplusInCallServiceExtProxy");
                    startQueryContactInfo(parcel.readString());
                    return true;
                case 102:
                    Log.i(OplusInCallServiceImpl.LOG_TAG, "delete for remove to contacts");
                    return true;
                case 103:
                    parcel.enforceInterface("com.android.telecom.OplusInCallServiceExtProxy");
                    setOplusInCallAdapterExt(parcel.readStrongBinder());
                    return true;
                case 105:
                    parcel.enforceInterface("com.android.telecom.OplusInCallServiceExtProxy");
                    a.C0054a contactAndYellowPageInfo = getContactAndYellowPageInfo(parcel.readString());
                    Log.i(OplusInCallServiceImpl.LOG_TAG, "getContactAndYellowPageInfo = " + contactAndYellowPageInfo);
                    parcel2.writeNoException();
                    if (contactAndYellowPageInfo != null) {
                        parcel2.writeString(contactAndYellowPageInfo.f2879a);
                        parcel2.writeLong(contactAndYellowPageInfo.f2880b);
                        parcel2.writeString(contactAndYellowPageInfo.f2881c);
                        parcel2.writeString(contactAndYellowPageInfo.f2882d);
                        parcel2.writeString(contactAndYellowPageInfo.f2883e);
                        parcel2.writeInt(contactAndYellowPageInfo.f2884f);
                    }
                case 104:
                    return true;
                case 106:
                    parcel.enforceInterface("com.android.telecom.OplusInCallServiceExtProxy");
                    int readInt = parcel.readInt();
                    Log.i(OplusInCallServiceImpl.LOG_TAG, "_setImsConfernceSize = " + readInt);
                    setImsConferenceSize(readInt);
                    return true;
                case 107:
                    if (OplusFeatureOption.OPLUS_PHONE_HIDE_INTERCEPT_CALL_NOTIFICATION) {
                        if (Log.sDebug) {
                            Log.i(OplusInCallServiceImpl.LOG_TAG, "hide the intercept call notification ");
                        }
                        return true;
                    }
                    parcel.enforceInterface("com.android.telecom.OplusInCallServiceExtProxy");
                    oplusInterceptCallNotification(parcel.readInt());
                    return true;
                case 108:
                    parcel.enforceInterface("com.android.telecom.OplusInCallServiceExtProxy");
                    oplusNotifySRVCC();
                    return true;
                case 109:
                    parcel.enforceInterface("com.android.telecom.OplusInCallServiceExtProxy");
                    answerFromNonUi(parcel.readString(), parcel.readInt());
                    return true;
                case 110:
                    parcel.enforceInterface("com.android.telecom.OplusInCallServiceExtProxy");
                    int incomingInterfaceType = getIncomingInterfaceType();
                    parcel2.writeNoException();
                    parcel2.writeInt(incomingInterfaceType);
                    return true;
                case 111:
                    parcel.enforceInterface("com.android.telecom.OplusInCallServiceExtProxy");
                    CastScreen.f19196a.a().e0(parcel.readInt());
                    return true;
                default:
                    return this.mIBinder.transact(i10, parcel, parcel2, i11);
            }
        }

        public void oplusInterceptCallNotification(int i10) {
            InCallPresenter.getInstance().oplusInterceptCallNotification(i10);
        }

        public void oplusNotifySRVCC() {
            ((OplusInCallPresenter) InCallPresenter.getInstance()).oplusSendSRVCCMsg();
        }

        public void setImsConferenceSize(int i10) {
            OplusPhoneUtils.setImsConferenceSize(i10);
        }

        public void setOplusInCallAdapterExt(IBinder iBinder) {
            A2.l.d().o(iBinder);
        }

        public void startMissedCallNotifier(String str) {
            Log.i(OplusInCallServiceImpl.LOG_TAG, "startMissedCallNotifier");
            C1676a.g().j(str);
        }

        public void startQueryContactInfo(String str) {
            D2.g.k(OplusInCallServiceImpl.LOG_TAG, "startQueryContactInfo number = " + D2.g.l(str));
            A2.j.J().b0(OplusPhoneUtils.formatQueryNumber(str), -2);
        }
    }

    @Override // com.android.incallui.InCallServiceImpl, android.telecom.InCallService, android.app.Service
    public IBinder onBind(Intent intent) {
        Log.i(this, "incall service onBind...");
        IBinder iBinder = this.mOplusInCallServiceStubExt;
        if (iBinder != null) {
            return iBinder;
        }
        this.mInCallServiceBinder = super.onBind(intent);
        OplusInCallServiceStubExt oplusInCallServiceStubExt = new OplusInCallServiceStubExt(this.mInCallServiceBinder);
        this.mOplusInCallServiceStubExt = oplusInCallServiceStubExt;
        return oplusInCallServiceStubExt;
    }

    @Override // android.app.Service
    public void onCreate() {
        InCallPresenter.getInstance().realInstance().setUp(getApplicationContext());
        super.onCreate();
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i10, int i11) {
        if (intent != null) {
            Message obtainMessage = this.mMainHandler.obtainMessage(D2.d.c(intent, "command", 0));
            obtainMessage.setData(D2.d.b(intent));
            this.mMainHandler.sendMessage(obtainMessage);
        }
        return super.onStartCommand(intent, i10, i11);
    }

    @Override // com.android.incallui.InCallServiceImpl, android.telecom.InCallService, android.app.Service
    public boolean onUnbind(Intent intent) {
        Log.i(LOG_TAG, "incall service onUnbind...");
        Log.i(LOG_TAG, "incall service onUnbind always return!");
        return false;
    }
}
