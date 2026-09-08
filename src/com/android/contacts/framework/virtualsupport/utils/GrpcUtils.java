package com.android.contacts.framework.virtualsupport.utils;

import G0.c;
import H7.b;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.DatabaseUtils;
import android.provider.CallLog;
import android.text.TextUtils;
import android.util.Log;
import com.android.contacts.framework.virtualsupport.ChatCallConsumer;
import com.android.contacts.framework.virtualsupport.ChatCallImpl;
import com.android.contacts.framework.virtualsupport.ChatCallProvider;
import com.android.contacts.framework.virtualsupport.GrpcInfo;
import com.android.contacts.framework.virtualsupport.RouteChatGrpc;
import com.android.contacts.framework.virtualsupport.utils.GrpcUtils;
import com.android.incallui.OplusPhoneUtils;
import com.google.protobuf.Any;
import com.google.protobuf.InvalidProtocolBufferException;
import com.oplus.foundation.util.feature.VirtualSupportUtils;
import com.oplus.foundation.util.ui.a;
import com.oplus.ocs.icdf.BaseJobAgent;
import com.oplus.ocs.icdf.RequestJobAgentCallback;
import io.grpc.stub.h;
import j9.AbstractC1194d;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import kotlin.Result;
import kotlin.jvm.internal.i;
import kotlin.text.StringsKt__StringsKt;
import kotlinx.coroutines.C1241e0;
import kotlinx.coroutines.C1248i;
import kotlinx.coroutines.S;
import m9.q;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: GrpcUtils.kt */
/* loaded from: classes.dex */
public final class GrpcUtils {
    private static final String ACTION_FORCE_REFRESH_CALLLOG = "com.oplus.contacts.force_refresh_calllog";
    public static final String CLEAR_MISSED_CALLS = "clear_missed_calls";
    public static final long CREATE_CHANNEL_TIME_OUT = 3000;
    private static final String CUSTOMIZE_FROM_CUSTOMIZE_APP = "from_customize_app";
    public static final String DELETED_CALL_LOG_VIRTUAL_ID = "deleted_call_log_virtual_id";
    public static final String DELETE_CALL_LOG = "delete_call_log";
    private static final String NEED_REFRESH_DATA = "need_refresh_data";
    private static final int NUM_1000 = 1000;
    public static final String OPERATION_NAME = "operation_name";
    private static final String OPLUS_MISSED_CALLS_COUNT = "oplus_customize_missed_calls_number";
    public static final String TAG = "GrpcUtils";
    private static final String VIRTUAL_CALL_ID = "virtual_call_id";
    private static ChatCallConsumer chatConsumer;
    private static ChatCallProvider chatProvider;
    private static h<Any> chatRequ;
    private static int index;
    public static final GrpcUtils INSTANCE = new GrpcUtils();
    private static final RequestJobAgentCallback chatProviderConnection = new RequestJobAgentCallback() { // from class: com.android.contacts.framework.virtualsupport.utils.GrpcUtils$chatProviderConnection$1
        @Override // com.oplus.ocs.icdf.RequestJobAgentCallback
        public void onError(String error) {
            i.f(error, "error");
            b.b(GrpcUtils.TAG, "onJobAgentError: ChatCallProvider, errorCode = " + error);
        }

        @Override // com.oplus.ocs.icdf.RequestJobAgentCallback
        public void onJobAgentAvailable(BaseJobAgent baseJobAgent) {
            i.f(baseJobAgent, "baseJobAgent");
            b.b(GrpcUtils.TAG, "onJobAgentAvailable: ChatCallProvider");
            GrpcUtils grpcUtils = GrpcUtils.INSTANCE;
            GrpcUtils.chatProvider = (ChatCallProvider) baseJobAgent;
        }
    };
    private static final ConcurrentHashMap<Integer, ChatCallImpl.Invoker> chatInvokerMap = new ConcurrentHashMap<>();
    private static final RequestJobAgentCallback chatConsumerConnection = new RequestJobAgentCallback() { // from class: com.android.contacts.framework.virtualsupport.utils.GrpcUtils$chatConsumerConnection$1
        @Override // com.oplus.ocs.icdf.RequestJobAgentCallback
        public void onError(String error) {
            i.f(error, "error");
            b.b(GrpcUtils.TAG, "onJobAgentError: ChatCallConsumer, errorCode = " + error);
        }

        @Override // com.oplus.ocs.icdf.RequestJobAgentCallback
        public void onJobAgentAvailable(BaseJobAgent baseJobAgent) {
            i.f(baseJobAgent, "baseJobAgent");
            b.b(GrpcUtils.TAG, "onJobAgentAvailable: ChatCallConsumer");
            GrpcUtils grpcUtils = GrpcUtils.INSTANCE;
            GrpcUtils.chatConsumer = (ChatCallConsumer) baseJobAgent;
        }
    };

    /* compiled from: GrpcUtils.kt */
    /* loaded from: classes.dex */
    public interface OperationCallBack {
        void doOperation(Context context, Any any);
    }

    /* compiled from: GrpcUtils.kt */
    /* loaded from: classes.dex */
    public interface OperationResultCallBack {
        void onOperationResultBack(Any any);
    }

    private GrpcUtils() {
    }

    public static final synchronized boolean bindChatConsumer(Context context, Any requestChat, OperationResultCallBack operationResultCallBack) {
        AbstractC1194d abstractC1194d;
        Object b10;
        AbstractC1194d abstractC1194d2;
        synchronized (GrpcUtils.class) {
            try {
                i.f(requestChat, "requestChat");
                b.b(TAG, "start bindChatConsumer");
                CountDownLatch countDownLatch = new CountDownLatch(1);
                ChatCallConsumer chatCallConsumer = chatConsumer;
                q qVar = null;
                if (chatCallConsumer == null) {
                    ChatCallConsumer.Companion.getInstance(context, countDownLatch, chatConsumerConnection);
                } else {
                    if (chatCallConsumer != null) {
                        abstractC1194d = chatCallConsumer.getChannel();
                    } else {
                        abstractC1194d = null;
                    }
                    if (abstractC1194d == null) {
                        ChatCallConsumer chatCallConsumer2 = chatConsumer;
                        if (chatCallConsumer2 != null) {
                            chatCallConsumer2.reconnect(countDownLatch);
                        }
                    } else {
                        countDownLatch.countDown();
                    }
                }
                try {
                    countDownLatch.await(CREATE_CHANNEL_TIME_OUT, TimeUnit.MILLISECONDS);
                } catch (InterruptedException e10) {
                    Log.e(TAG, "bindChatConsumer: time out" + e10);
                }
                b.b(TAG, "consumer and channel init complete");
                if (chatRequ == null) {
                    ChatCallConsumer chatCallConsumer3 = chatConsumer;
                    if (chatCallConsumer3 == null) {
                        b.b(TAG, "bindChat: chatConsumer is null");
                        return false;
                    }
                    if (chatCallConsumer3 != null) {
                        abstractC1194d2 = chatCallConsumer3.getChannel();
                    } else {
                        abstractC1194d2 = null;
                    }
                    if (abstractC1194d2 == null) {
                        b.b(TAG, "bindChat: channel is null");
                        return false;
                    }
                    RouteChatGrpc.RouteChatStub newStub = RouteChatGrpc.newStub(abstractC1194d2);
                    i.e(newStub, "newStub(channel)");
                    chatRequ = newStub.chat(new h<Any>() { // from class: com.android.contacts.framework.virtualsupport.utils.GrpcUtils$bindChatConsumer$1
                        @Override // io.grpc.stub.h
                        public void onCompleted() {
                            C1248i.d(C1241e0.f34422a, S.a(), null, new GrpcUtils$bindChatConsumer$1$onCompleted$1(null), 2, null);
                        }

                        @Override // io.grpc.stub.h
                        public void onError(Throwable t10) {
                            i.f(t10, "t");
                            C1248i.d(C1241e0.f34422a, S.a(), null, new GrpcUtils$bindChatConsumer$1$onError$1(t10, null), 2, null);
                        }

                        @Override // io.grpc.stub.h
                        public void onNext(Any result) {
                            i.f(result, "result");
                            C1248i.d(C1241e0.f34422a, S.a(), null, new GrpcUtils$bindChatConsumer$1$onNext$1(null), 2, null);
                        }
                    });
                }
                try {
                    Result.a aVar = Result.f34166a;
                    h<Any> hVar = chatRequ;
                    if (hVar != null) {
                        hVar.onNext(requestChat);
                        qVar = q.f35511a;
                    }
                    b10 = Result.b(qVar);
                } catch (Throwable th) {
                    Result.a aVar2 = Result.f34166a;
                    b10 = Result.b(kotlin.b.a(th));
                }
                Throwable d10 = Result.d(b10);
                if (d10 != null) {
                    b.c(TAG, "chatRequ onNext e = " + d10);
                    return false;
                }
                b.b(TAG, "bindChatConsumer success");
                return true;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public static final void clearNotificationAndUnread$virtualsupport_release(Context context) {
        if (context != null) {
            a.a(context, 0);
            c.p(context, 0, OPLUS_MISSED_CALLS_COUNT, 0, 0, 16, null);
            com.android.contacts.framework.api.appstore.missedcall.a.a(context);
            ContentResolver contentResolver = context.getContentResolver();
            i.e(contentResolver, "context.contentResolver");
            markNewCallsAsOld$virtualsupport_release(contentResolver);
        }
    }

    public static final void deleteCallLog$virtualsupport_release(Context context, String calllogVirtualIds) {
        List Y9;
        Object b10;
        ContentResolver contentResolver;
        int i10;
        i.f(calllogVirtualIds, "calllogVirtualIds");
        if (!TextUtils.isEmpty(calllogVirtualIds)) {
            Y9 = StringsKt__StringsKt.Y(calllogVirtualIds, new String[]{","}, false, 0, 6, null);
            StringBuilder sb = new StringBuilder();
            if (Y9.size() > 1000) {
                int size = (Y9.size() / 1000) + 1;
                int i11 = 0;
                while (i11 < size) {
                    int i12 = i11 * 1000;
                    int i13 = i11 + 1;
                    if (i13 == size) {
                        i10 = Y9.size();
                    } else {
                        i10 = i13 * 1000;
                    }
                    String sqlEscapeString$virtualsupport_release = getSqlEscapeString$virtualsupport_release(Y9.subList(i12, i10));
                    if (i11 == 0) {
                        sb.append("virtual_call_id IN (" + sqlEscapeString$virtualsupport_release + ")");
                    } else {
                        sb.append(" OR virtual_call_id IN (" + sqlEscapeString$virtualsupport_release + ")");
                    }
                    i11 = i13;
                }
            } else {
                sb.append("virtual_call_id IN (" + getSqlEscapeString$virtualsupport_release(Y9) + ")");
            }
            b.b(TAG, "delete call log: where = " + ((Object) sb));
            try {
                Result.a aVar = Result.f34166a;
                Integer num = null;
                if (context != null && (contentResolver = context.getContentResolver()) != null) {
                    num = Integer.valueOf(contentResolver.delete(CallLog.Calls.CONTENT_URI_WITH_VOICEMAIL, sb.toString(), null));
                }
                b10 = Result.b(num);
            } catch (Throwable th) {
                Result.a aVar2 = Result.f34166a;
                b10 = Result.b(kotlin.b.a(th));
            }
            Throwable d10 = Result.d(b10);
            if (d10 != null) {
                b.c(TAG, d10.getMessage());
            }
            if (context != null) {
                sendRefreshCallLogBroadcast$virtualsupport_release(context);
            }
        }
    }

    public static final OperationCallBack getOperationCallBack() {
        return new OperationCallBack() { // from class: com.android.contacts.framework.virtualsupport.utils.GrpcUtils$getOperationCallBack$1
            @Override // com.android.contacts.framework.virtualsupport.utils.GrpcUtils.OperationCallBack
            public void doOperation(Context context, Any request) {
                i.f(request, "request");
                if (request.is(GrpcInfo.RequestChat.class)) {
                    try {
                        GrpcInfo.RequestChat requestChat = (GrpcInfo.RequestChat) request.unpack(GrpcInfo.RequestChat.class);
                        b.b(GrpcUtils.TAG, "doOperation: index = " + requestChat.getIndex());
                        JSONObject jSONObject = new JSONObject(requestChat.getRequest());
                        String string = jSONObject.getString(GrpcUtils.OPERATION_NAME);
                        if (TextUtils.equals(string, GrpcUtils.CLEAR_MISSED_CALLS)) {
                            b.b(GrpcUtils.TAG, "doOperation: clear_missed_calls");
                            GrpcUtils.clearNotificationAndUnread$virtualsupport_release(context);
                        } else if (TextUtils.equals(string, GrpcUtils.DELETE_CALL_LOG)) {
                            b.b(GrpcUtils.TAG, "doOperation: delete call log");
                            String string2 = jSONObject.getString(GrpcUtils.DELETED_CALL_LOG_VIRTUAL_ID);
                            i.e(string2, "jsonObject.getString(DELETED_CALL_LOG_VIRTUAL_ID)");
                            GrpcUtils.deleteCallLog$virtualsupport_release(context, string2);
                        }
                        return;
                    } catch (InvalidProtocolBufferException e10) {
                        Log.e(GrpcUtils.TAG, "doOperation: e = " + e10);
                        return;
                    } catch (JSONException e11) {
                        Log.e(GrpcUtils.TAG, "doOperation: e = " + e11);
                        return;
                    }
                }
                b.b(GrpcUtils.TAG, "request is not RequestChat");
            }
        };
    }

    public static final String getSqlEscapeString$virtualsupport_release(List<String> phoneNumbers) {
        i.f(phoneNumbers, "phoneNumbers");
        int size = phoneNumbers.size();
        String[] strArr = new String[size];
        for (int i10 = 0; i10 < size; i10++) {
            strArr[i10] = DatabaseUtils.sqlEscapeString(phoneNumbers.get(i10));
        }
        String join = TextUtils.join(",", strArr);
        i.e(join, "join(\",\", escapePhoneNumbers)");
        return join;
    }

    public static final void initGrpcProvider(final Context context, final OperationCallBack operationCallBack) {
        i.f(operationCallBack, "operationCallBack");
        if (!VirtualSupportUtils.n()) {
            return;
        }
        if (chatProvider == null) {
            ChatCallProvider.Companion.getInstance(context, chatProviderConnection);
        }
        ChatCallImpl.Companion.setCallBack(new ChatCallImpl.CallBack() { // from class: com.android.contacts.framework.virtualsupport.utils.GrpcUtils$initGrpcProvider$1
            @Override // com.android.contacts.framework.virtualsupport.ChatCallImpl.CallBack
            public void onChat(int i10, ChatCallImpl.Invoker iv) {
                i.f(iv, "iv");
                C1248i.d(C1241e0.f34422a, S.a(), null, new GrpcUtils$initGrpcProvider$1$onChat$1(i10, iv, null), 2, null);
            }

            @Override // com.android.contacts.framework.virtualsupport.ChatCallImpl.CallBack
            public void onCompleted(int i10) {
                C1248i.d(C1241e0.f34422a, S.a(), null, new GrpcUtils$initGrpcProvider$1$onCompleted$1(i10, null), 2, null);
            }

            @Override // com.android.contacts.framework.virtualsupport.ChatCallImpl.CallBack
            public void onError(int i10, String str) {
                C1248i.d(C1241e0.f34422a, S.a(), null, new GrpcUtils$initGrpcProvider$1$onError$1(i10, null), 2, null);
            }

            @Override // com.android.contacts.framework.virtualsupport.ChatCallImpl.CallBack
            public void onNext(int i10, Any requestChat) {
                i.f(requestChat, "requestChat");
                C1248i.d(C1241e0.f34422a, S.a(), null, new GrpcUtils$initGrpcProvider$1$onNext$1(GrpcUtils.OperationCallBack.this, context, requestChat, null), 2, null);
            }
        });
    }

    public static final void markNewCallsAsOld$virtualsupport_release(ContentResolver contentResolver) {
        Object b10;
        i.f(contentResolver, "contentResolver");
        ContentValues contentValues = new ContentValues(1);
        contentValues.put("new", OplusPhoneUtils.DeviceState.UNLOCK_DEVICE);
        try {
            Result.a aVar = Result.f34166a;
            b10 = Result.b(Integer.valueOf(contentResolver.update(CallLog.Calls.CONTENT_URI_WITH_VOICEMAIL.buildUpon().appendQueryParameter(CUSTOMIZE_FROM_CUSTOMIZE_APP, "true").build(), contentValues, "new = 1", null)));
        } catch (Throwable th) {
            Result.a aVar2 = Result.f34166a;
            b10 = Result.b(kotlin.b.a(th));
        }
        Throwable d10 = Result.d(b10);
        if (d10 != null) {
            b.c(TAG, d10.getMessage());
        }
    }

    public static final void sendRefreshCallLogBroadcast$virtualsupport_release(Context context) {
        i.f(context, "context");
        Intent intent = new Intent(ACTION_FORCE_REFRESH_CALLLOG);
        intent.putExtra(NEED_REFRESH_DATA, true);
        X.a.b(context).d(intent);
    }

    public static final void syncClearMissedCallsOperation(Context context) {
        Context context2;
        if (VirtualSupportUtils.n() && VirtualSupportUtils.r(context)) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(OPERATION_NAME, CLEAR_MISSED_CALLS);
            GrpcInfo.RequestChat.Builder newBuilder = GrpcInfo.RequestChat.newBuilder();
            int i10 = index + 1;
            index = i10;
            GrpcInfo.RequestChat build = newBuilder.setIndex(i10).setRequest(jSONObject.toString()).build();
            b.b(TAG, "syncClearMissedCallsOperation index = " + index);
            if (context != null) {
                context2 = context.getApplicationContext();
            } else {
                context2 = null;
            }
            Any pack = Any.pack(build);
            i.e(pack, "pack(requestChat)");
            bindChatConsumer(context2, pack, null);
        }
    }

    public static final void syncDeleteCallLog$virtualsupport_release(Context context, String deletedCallLogVirtualId) {
        Context context2;
        i.f(deletedCallLogVirtualId, "deletedCallLogVirtualId");
        if (VirtualSupportUtils.n() && VirtualSupportUtils.r(context)) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(OPERATION_NAME, DELETE_CALL_LOG);
            jSONObject.put(DELETED_CALL_LOG_VIRTUAL_ID, deletedCallLogVirtualId);
            GrpcInfo.RequestChat.Builder newBuilder = GrpcInfo.RequestChat.newBuilder();
            int i10 = index + 1;
            index = i10;
            GrpcInfo.RequestChat build = newBuilder.setIndex(i10).setRequest(jSONObject.toString()).build();
            b.b(TAG, "syncDeleteCallLogOperation index = " + index);
            if (context != null) {
                context2 = context.getApplicationContext();
            } else {
                context2 = null;
            }
            Any pack = Any.pack(build);
            i.e(pack, "pack(requestChat)");
            bindChatConsumer(context2, pack, null);
        }
    }

    public static final void syncDeleteCallLogOperation(Context context, String deletedCallLogVirtualId) {
        i.f(deletedCallLogVirtualId, "deletedCallLogVirtualId");
        C1248i.d(C1241e0.f34422a, S.a(), null, new GrpcUtils$syncDeleteCallLogOperation$1(context, deletedCallLogVirtualId, null), 2, null);
    }
}
