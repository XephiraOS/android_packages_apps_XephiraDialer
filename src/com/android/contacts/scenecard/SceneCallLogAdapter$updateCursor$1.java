package com.android.contacts.scenecard;

import android.database.ContentObserver;
import android.database.Cursor;
import android.database.MergeCursor;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlinx.coroutines.C1244g;
import kotlinx.coroutines.w0;
import p9.C1467a;
import p9.InterfaceC1470d;

/* compiled from: SceneCallLogAdapter.kt */
@InterfaceC1470d(c = "com.android.contacts.scenecard.SceneCallLogAdapter$updateCursor$1", f = "SceneCallLogAdapter.kt", l = {256, 261}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class SceneCallLogAdapter$updateCursor$1 extends SuspendLambda implements v9.p<kotlinx.coroutines.E, kotlin.coroutines.c<? super m9.q>, Object> {
    final /* synthetic */ boolean $async;
    final /* synthetic */ Cursor $cursor;
    Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ SceneCallLogAdapter this$0;

    /* compiled from: SceneCallLogAdapter.kt */
    @InterfaceC1470d(c = "com.android.contacts.scenecard.SceneCallLogAdapter$updateCursor$1$1", f = "SceneCallLogAdapter.kt", l = {}, m = "invokeSuspend")
    /* renamed from: com.android.contacts.scenecard.SceneCallLogAdapter$updateCursor$1$1, reason: invalid class name */
    /* loaded from: classes.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements v9.p<kotlinx.coroutines.E, kotlin.coroutines.c<? super Boolean>, Object> {
        final /* synthetic */ Cursor $cursor;
        final /* synthetic */ com.android.contacts.framework.baseui.calllog.b $newGroupHandler;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(com.android.contacts.framework.baseui.calllog.b bVar, Cursor cursor, kotlin.coroutines.c<? super AnonymousClass1> cVar) {
            super(2, cVar);
            this.$newGroupHandler = bVar;
            this.$cursor = cursor;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final kotlin.coroutines.c<m9.q> create(Object obj, kotlin.coroutines.c<?> cVar) {
            return new AnonymousClass1(this.$newGroupHandler, this.$cursor, cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            kotlin.coroutines.intrinsics.b.c();
            if (this.label == 0) {
                kotlin.b.b(obj);
                this.$newGroupHandler.e(this.$cursor);
                Cursor cursor = this.$cursor;
                if (cursor != null) {
                    return C1467a.a(cursor.moveToFirst());
                }
                return null;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        @Override // v9.p
        public final Object invoke(kotlinx.coroutines.E e10, kotlin.coroutines.c<? super Boolean> cVar) {
            return ((AnonymousClass1) create(e10, cVar)).invokeSuspend(m9.q.f35511a);
        }
    }

    /* compiled from: SceneCallLogAdapter.kt */
    @InterfaceC1470d(c = "com.android.contacts.scenecard.SceneCallLogAdapter$updateCursor$1$2", f = "SceneCallLogAdapter.kt", l = {}, m = "invokeSuspend")
    /* renamed from: com.android.contacts.scenecard.SceneCallLogAdapter$updateCursor$1$2, reason: invalid class name */
    /* loaded from: classes.dex */
    public static final class AnonymousClass2 extends SuspendLambda implements v9.p<kotlinx.coroutines.E, kotlin.coroutines.c<? super m9.q>, Object> {
        final /* synthetic */ Cursor $cursor;
        final /* synthetic */ com.android.contacts.framework.baseui.calllog.b $newGroupHandler;
        final /* synthetic */ Cursor $oldCursor;
        int label;
        final /* synthetic */ SceneCallLogAdapter this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(Cursor cursor, SceneCallLogAdapter sceneCallLogAdapter, Cursor cursor2, com.android.contacts.framework.baseui.calllog.b bVar, kotlin.coroutines.c<? super AnonymousClass2> cVar) {
            super(2, cVar);
            this.$oldCursor = cursor;
            this.this$0 = sceneCallLogAdapter;
            this.$cursor = cursor2;
            this.$newGroupHandler = bVar;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final kotlin.coroutines.c<m9.q> create(Object obj, kotlin.coroutines.c<?> cVar) {
            return new AnonymousClass2(this.$oldCursor, this.this$0, this.$cursor, this.$newGroupHandler, cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            ContentObserver contentObserver;
            ContentObserver contentObserver2;
            kotlin.coroutines.intrinsics.b.c();
            if (this.label == 0) {
                kotlin.b.b(obj);
                Cursor cursor = this.$oldCursor;
                if (cursor != null) {
                    contentObserver2 = this.this$0.f17114G;
                    cursor.unregisterContentObserver(contentObserver2);
                }
                Cursor cursor2 = this.$cursor;
                if (cursor2 != null) {
                    contentObserver = this.this$0.f17114G;
                    cursor2.registerContentObserver(contentObserver);
                }
                Cursor cursor3 = this.$oldCursor;
                if (cursor3 != null && !cursor3.isClosed() && (this.$oldCursor.getColumnCount() == com.android.contacts.framework.baseui.calllog.d.a().length || (this.$oldCursor instanceof MergeCursor) || !(this.$cursor instanceof MergeCursor))) {
                    this.$oldCursor.close();
                }
                this.this$0.f17118d = this.$newGroupHandler;
                this.this$0.f17117c = this.$cursor;
                this.this$0.f17109B = null;
                this.this$0.S();
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
    public SceneCallLogAdapter$updateCursor$1(SceneCallLogAdapter sceneCallLogAdapter, boolean z10, Cursor cursor, kotlin.coroutines.c<? super SceneCallLogAdapter$updateCursor$1> cVar) {
        super(2, cVar);
        this.this$0 = sceneCallLogAdapter;
        this.$async = z10;
        this.$cursor = cursor;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final kotlin.coroutines.c<m9.q> create(Object obj, kotlin.coroutines.c<?> cVar) {
        return new SceneCallLogAdapter$updateCursor$1(this.this$0, this.$async, this.$cursor, cVar);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object c10;
        Cursor cursor;
        com.android.contacts.framework.baseui.calllog.b bVar;
        CoroutineContext c11;
        Cursor cursor2;
        com.android.contacts.framework.baseui.calllog.b bVar2;
        c10 = kotlin.coroutines.intrinsics.b.c();
        int i10 = this.label;
        if (i10 != 0) {
            if (i10 != 1) {
                if (i10 == 2) {
                    kotlin.b.b(obj);
                    return m9.q.f35511a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            com.android.contacts.framework.baseui.calllog.b bVar3 = (com.android.contacts.framework.baseui.calllog.b) this.L$1;
            Cursor cursor3 = (Cursor) this.L$0;
            kotlin.b.b(obj);
            bVar2 = bVar3;
            cursor2 = cursor3;
        } else {
            kotlin.b.b(obj);
            cursor = this.this$0.f17117c;
            if (!this.$async) {
                bVar = this.this$0.f17118d;
            } else {
                bVar = new com.android.contacts.framework.baseui.calllog.b();
            }
            if (this.$async) {
                c11 = kotlinx.coroutines.S.b();
            } else {
                c11 = kotlinx.coroutines.S.c();
            }
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(bVar, this.$cursor, null);
            this.L$0 = cursor;
            this.L$1 = bVar;
            this.label = 1;
            if (C1244g.g(c11, anonymousClass1, this) == c10) {
                return c10;
            }
            cursor2 = cursor;
            bVar2 = bVar;
        }
        w0 c12 = kotlinx.coroutines.S.c();
        AnonymousClass2 anonymousClass2 = new AnonymousClass2(cursor2, this.this$0, this.$cursor, bVar2, null);
        this.L$0 = null;
        this.L$1 = null;
        this.label = 2;
        if (C1244g.g(c12, anonymousClass2, this) == c10) {
            return c10;
        }
        return m9.q.f35511a;
    }

    @Override // v9.p
    public final Object invoke(kotlinx.coroutines.E e10, kotlin.coroutines.c<? super m9.q> cVar) {
        return ((SceneCallLogAdapter$updateCursor$1) create(e10, cVar)).invokeSuspend(m9.q.f35511a);
    }
}
