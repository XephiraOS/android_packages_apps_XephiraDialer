package com.android.contacts.framework.virtualsupport;

import com.android.contacts.framework.virtualsupport.ChatCallImpl;
import com.android.contacts.framework.virtualsupport.RouteChatGrpc;
import com.google.protobuf.Any;
import io.grpc.stub.h;
import kotlin.Result;
import kotlin.jvm.internal.i;
import m9.q;

/* compiled from: ChatCallImpl.kt */
/* loaded from: classes.dex */
public final class ChatCallImpl extends RouteChatGrpc.RouteChatImplBase {
    public static final Companion Companion = new Companion(null);
    private static final String TAG = "ChatCallImpl";
    private static CallBack callBack;

    /* compiled from: ChatCallImpl.kt */
    /* loaded from: classes.dex */
    public interface CallBack {
        void onChat(int i10, Invoker invoker);

        void onCompleted(int i10);

        void onError(int i10, String str);

        void onNext(int i10, Any any);
    }

    /* compiled from: ChatCallImpl.kt */
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public final void setCallBack(CallBack callBack) {
            ChatCallImpl.callBack = callBack;
        }

        public /* synthetic */ Companion(kotlin.jvm.internal.f fVar) {
            this();
        }
    }

    /* compiled from: ChatCallImpl.kt */
    /* loaded from: classes.dex */
    public abstract class Invoker {
        private h<Any> mObserver;
        final /* synthetic */ ChatCallImpl this$0;

        public Invoker(ChatCallImpl chatCallImpl, h<Any> mObserver) {
            i.f(mObserver, "mObserver");
            this.this$0 = chatCallImpl;
            this.mObserver = mObserver;
        }

        public final h<Any> getMObserver() {
            return this.mObserver;
        }

        public abstract boolean notify(Any any);

        public final void setMObserver(h<Any> hVar) {
            i.f(hVar, "<set-?>");
            this.mObserver = hVar;
        }

        public abstract boolean shutdown();
    }

    @Override // com.android.contacts.framework.virtualsupport.RouteChatGrpc.RouteChatImplBase
    public h<Any> chat(final h<Any> responseObserver) {
        i.f(responseObserver, "responseObserver");
        H7.b.b(TAG, "ChatCallImpl.chat() ");
        CallBack callBack2 = callBack;
        if (callBack2 != null) {
            callBack2.onChat(responseObserver.hashCode(), new Invoker(this, responseObserver) { // from class: com.android.contacts.framework.virtualsupport.ChatCallImpl$chat$1
                @Override // com.android.contacts.framework.virtualsupport.ChatCallImpl.Invoker
                public boolean notify(Any any) {
                    Object b10;
                    try {
                        Result.a aVar = Result.f34166a;
                        getMObserver().onNext(any);
                        b10 = Result.b(q.f35511a);
                    } catch (Throwable th) {
                        Result.a aVar2 = Result.f34166a;
                        b10 = Result.b(kotlin.b.a(th));
                    }
                    if (Result.d(b10) != null) {
                        return false;
                    }
                    return true;
                }

                @Override // com.android.contacts.framework.virtualsupport.ChatCallImpl.Invoker
                public boolean shutdown() {
                    Object b10;
                    try {
                        Result.a aVar = Result.f34166a;
                        H7.b.b("ChatCallImpl", "shutdown responseObserver.hashCode() " + getMObserver().hashCode());
                        getMObserver().onCompleted();
                        b10 = Result.b(q.f35511a);
                    } catch (Throwable th) {
                        Result.a aVar2 = Result.f34166a;
                        b10 = Result.b(kotlin.b.a(th));
                    }
                    if (Result.d(b10) != null) {
                        return false;
                    }
                    return true;
                }
            });
        }
        return new h<Any>() { // from class: com.android.contacts.framework.virtualsupport.ChatCallImpl$chat$2
            @Override // io.grpc.stub.h
            public void onCompleted() {
                ChatCallImpl.CallBack callBack3;
                callBack3 = ChatCallImpl.callBack;
                if (callBack3 != null) {
                    callBack3.onCompleted(responseObserver.hashCode());
                }
            }

            @Override // io.grpc.stub.h
            public void onError(Throwable t10) {
                ChatCallImpl.CallBack callBack3;
                i.f(t10, "t");
                callBack3 = ChatCallImpl.callBack;
                if (callBack3 != null) {
                    callBack3.onError(responseObserver.hashCode(), "throw error");
                }
            }

            @Override // io.grpc.stub.h
            public void onNext(Any value) {
                ChatCallImpl.CallBack callBack3;
                i.f(value, "value");
                callBack3 = ChatCallImpl.callBack;
                if (callBack3 != null) {
                    callBack3.onNext(responseObserver.hashCode(), value);
                }
            }
        };
    }
}
