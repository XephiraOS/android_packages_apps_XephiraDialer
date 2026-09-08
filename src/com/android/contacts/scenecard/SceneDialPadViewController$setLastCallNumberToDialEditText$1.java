package com.android.contacts.scenecard;

import android.database.Cursor;
import android.provider.CallLog;
import com.customize.contacts.util.C0801l;
import kotlin.Result;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlinx.coroutines.C1244g;
import kotlinx.coroutines.w0;
import p9.InterfaceC1470d;

/* compiled from: SceneDialPadViewController.kt */
@InterfaceC1470d(c = "com.android.contacts.scenecard.SceneDialPadViewController$setLastCallNumberToDialEditText$1", f = "SceneDialPadViewController.kt", l = {641}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class SceneDialPadViewController$setLastCallNumberToDialEditText$1 extends SuspendLambda implements v9.p<kotlinx.coroutines.E, kotlin.coroutines.c<? super m9.q>, Object> {
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ SceneDialPadViewController this$0;

    /* compiled from: SceneDialPadViewController.kt */
    @InterfaceC1470d(c = "com.android.contacts.scenecard.SceneDialPadViewController$setLastCallNumberToDialEditText$1$1", f = "SceneDialPadViewController.kt", l = {}, m = "invokeSuspend")
    /* renamed from: com.android.contacts.scenecard.SceneDialPadViewController$setLastCallNumberToDialEditText$1$1, reason: invalid class name */
    /* loaded from: classes.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements v9.p<kotlinx.coroutines.E, kotlin.coroutines.c<? super m9.q>, Object> {
        final /* synthetic */ String $lastCallNumber;
        int label;
        final /* synthetic */ SceneDialPadViewController this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(SceneDialPadViewController sceneDialPadViewController, String str, kotlin.coroutines.c<? super AnonymousClass1> cVar) {
            super(2, cVar);
            this.this$0 = sceneDialPadViewController;
            this.$lastCallNumber = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final kotlin.coroutines.c<m9.q> create(Object obj, kotlin.coroutines.c<?> cVar) {
            return new AnonymousClass1(this.this$0, this.$lastCallNumber, cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            kotlin.coroutines.intrinsics.b.c();
            if (this.label == 0) {
                kotlin.b.b(obj);
                if (this.this$0.J()) {
                    this.this$0.v().C(this.$lastCallNumber);
                    this.this$0.v().D(false);
                }
                return m9.q.f35511a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        @Override // v9.p
        public final Object invoke(kotlinx.coroutines.E e10, kotlin.coroutines.c<? super m9.q> cVar) {
            return ((AnonymousClass1) create(e10, cVar)).invokeSuspend(m9.q.f35511a);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SceneDialPadViewController$setLastCallNumberToDialEditText$1(SceneDialPadViewController sceneDialPadViewController, kotlin.coroutines.c<? super SceneDialPadViewController$setLastCallNumberToDialEditText$1> cVar) {
        super(2, cVar);
        this.this$0 = sceneDialPadViewController;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final kotlin.coroutines.c<m9.q> create(Object obj, kotlin.coroutines.c<?> cVar) {
        SceneDialPadViewController$setLastCallNumberToDialEditText$1 sceneDialPadViewController$setLastCallNumberToDialEditText$1 = new SceneDialPadViewController$setLastCallNumberToDialEditText$1(this.this$0, cVar);
        sceneDialPadViewController$setLastCallNumberToDialEditText$1.L$0 = obj;
        return sceneDialPadViewController$setLastCallNumberToDialEditText$1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object c10;
        Object b10;
        String str;
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
            String f10 = C0801l.f();
            SceneDialPadViewController sceneDialPadViewController = this.this$0;
            try {
                Result.a aVar = Result.f34166a;
                b10 = Result.b(sceneDialPadViewController.u().getContentResolver().query(CallLog.Calls.CONTENT_URI, new String[]{"number"}, f10, null, "date DESC LIMIT 1"));
            } catch (Throwable th) {
                Result.a aVar2 = Result.f34166a;
                b10 = Result.b(kotlin.b.a(th));
            }
            Throwable d10 = Result.d(b10);
            if (d10 != null) {
                H7.b.e("SceneDialPadViewController", "setLastCallNumberToDialEditText " + d10 + " : " + d10.getMessage());
            }
            if (Result.f(b10)) {
                b10 = null;
            }
            Cursor cursor = (Cursor) b10;
            String str2 = "";
            if (cursor != null) {
                try {
                    if (!cursor.moveToFirst()) {
                        str = "";
                    } else {
                        str = cursor.getString(0);
                    }
                    kotlin.io.a.a(cursor, null);
                } catch (Throwable th2) {
                    try {
                        throw th2;
                    } catch (Throwable th3) {
                        kotlin.io.a.a(cursor, th2);
                        throw th3;
                    }
                }
            } else {
                str = null;
            }
            if (str != null) {
                str2 = str;
            }
            if (str2.length() > 0) {
                w0 c11 = kotlinx.coroutines.S.c();
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.this$0, str2, null);
                this.label = 1;
                if (C1244g.g(c11, anonymousClass1, this) == c10) {
                    return c10;
                }
            }
        }
        return m9.q.f35511a;
    }

    @Override // v9.p
    public final Object invoke(kotlinx.coroutines.E e10, kotlin.coroutines.c<? super m9.q> cVar) {
        return ((SceneDialPadViewController$setLastCallNumberToDialEditText$1) create(e10, cVar)).invokeSuspend(m9.q.f35511a);
    }
}
