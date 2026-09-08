package com.android.contacts.scenecard;

import android.widget.TextView;
import com.android.contacts.framework.baseui.util.LocationUtils;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlinx.coroutines.C1244g;
import kotlinx.coroutines.w0;
import p9.InterfaceC1470d;

/* compiled from: SceneDialTextEditor.kt */
@InterfaceC1470d(c = "com.android.contacts.scenecard.SceneDialTextEditor$queryLocation$1", f = "SceneDialTextEditor.kt", l = {394}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class SceneDialTextEditor$queryLocation$1 extends SuspendLambda implements v9.p<kotlinx.coroutines.E, kotlin.coroutines.c<? super m9.q>, Object> {
    final /* synthetic */ String $number;
    int label;
    final /* synthetic */ SceneDialTextEditor this$0;

    /* compiled from: SceneDialTextEditor.kt */
    @InterfaceC1470d(c = "com.android.contacts.scenecard.SceneDialTextEditor$queryLocation$1$1", f = "SceneDialTextEditor.kt", l = {}, m = "invokeSuspend")
    /* renamed from: com.android.contacts.scenecard.SceneDialTextEditor$queryLocation$1$1, reason: invalid class name */
    /* loaded from: classes.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements v9.p<kotlinx.coroutines.E, kotlin.coroutines.c<? super m9.q>, Object> {
        final /* synthetic */ String $phoneLocation;
        int label;
        final /* synthetic */ SceneDialTextEditor this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(SceneDialTextEditor sceneDialTextEditor, String str, kotlin.coroutines.c<? super AnonymousClass1> cVar) {
            super(2, cVar);
            this.this$0 = sceneDialTextEditor;
            this.$phoneLocation = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final kotlin.coroutines.c<m9.q> create(Object obj, kotlin.coroutines.c<?> cVar) {
            return new AnonymousClass1(this.this$0, this.$phoneLocation, cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            x0.t tVar;
            TextView textView;
            kotlin.coroutines.intrinsics.b.c();
            if (this.label == 0) {
                kotlin.b.b(obj);
                tVar = this.this$0.f17188c;
                if (tVar != null && (textView = tVar.f37786K) != null) {
                    String str = this.$phoneLocation;
                    if (str != null && str.length() != 0) {
                        textView.setVisibility(0);
                        textView.setText(str);
                    } else {
                        textView.setVisibility(8);
                    }
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
    public SceneDialTextEditor$queryLocation$1(SceneDialTextEditor sceneDialTextEditor, String str, kotlin.coroutines.c<? super SceneDialTextEditor$queryLocation$1> cVar) {
        super(2, cVar);
        this.this$0 = sceneDialTextEditor;
        this.$number = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final kotlin.coroutines.c<m9.q> create(Object obj, kotlin.coroutines.c<?> cVar) {
        return new SceneDialTextEditor$queryLocation$1(this.this$0, this.$number, cVar);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object c10;
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
            String a10 = C7.c.b(this.this$0.s()).a();
            String j10 = LocationUtils.j(this.this$0.s(), this.$number, a10, 0, false);
            H7.b.e("SceneDialTextEditor", "updateCityAddress number = " + H7.a.d(this.$number) + " ,countryIso = " + a10 + ", phoneLocation = " + j10);
            w0 c11 = kotlinx.coroutines.S.c();
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.this$0, j10, null);
            this.label = 1;
            if (C1244g.g(c11, anonymousClass1, this) == c10) {
                return c10;
            }
        }
        return m9.q.f35511a;
    }

    @Override // v9.p
    public final Object invoke(kotlinx.coroutines.E e10, kotlin.coroutines.c<? super m9.q> cVar) {
        return ((SceneDialTextEditor$queryLocation$1) create(e10, cVar)).invokeSuspend(m9.q.f35511a);
    }
}
