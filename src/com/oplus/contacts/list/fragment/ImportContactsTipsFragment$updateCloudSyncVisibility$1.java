package com.oplus.contacts.list.fragment;

import android.widget.ImageView;
import com.oplus.foundation.appsupport.ui.widget.SuitableSizeTextView;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlinx.coroutines.C1244g;
import kotlinx.coroutines.E;
import kotlinx.coroutines.S;
import kotlinx.coroutines.w0;
import p9.InterfaceC1470d;

/* compiled from: ImportContactsTipsFragment.kt */
@InterfaceC1470d(c = "com.oplus.contacts.list.fragment.ImportContactsTipsFragment$updateCloudSyncVisibility$1", f = "ImportContactsTipsFragment.kt", l = {321}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class ImportContactsTipsFragment$updateCloudSyncVisibility$1 extends SuspendLambda implements v9.p<E, kotlin.coroutines.c<? super m9.q>, Object> {
    final /* synthetic */ ImageView $divider;
    final /* synthetic */ SuitableSizeTextView $importFromCloudSync;
    final /* synthetic */ boolean $isVisible;
    int label;
    final /* synthetic */ ImportContactsTipsFragment this$0;

    /* compiled from: ImportContactsTipsFragment.kt */
    @InterfaceC1470d(c = "com.oplus.contacts.list.fragment.ImportContactsTipsFragment$updateCloudSyncVisibility$1$1", f = "ImportContactsTipsFragment.kt", l = {}, m = "invokeSuspend")
    /* renamed from: com.oplus.contacts.list.fragment.ImportContactsTipsFragment$updateCloudSyncVisibility$1$1, reason: invalid class name */
    /* loaded from: classes3.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements v9.p<E, kotlin.coroutines.c<? super m9.q>, Object> {
        final /* synthetic */ ImageView $divider;
        final /* synthetic */ SuitableSizeTextView $importFromCloudSync;
        final /* synthetic */ boolean $isHideCloudSync;
        final /* synthetic */ boolean $isVisible;
        int label;
        final /* synthetic */ ImportContactsTipsFragment this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(ImportContactsTipsFragment importContactsTipsFragment, boolean z10, boolean z11, SuitableSizeTextView suitableSizeTextView, ImageView imageView, kotlin.coroutines.c<? super AnonymousClass1> cVar) {
            super(2, cVar);
            this.this$0 = importContactsTipsFragment;
            this.$isHideCloudSync = z10;
            this.$isVisible = z11;
            this.$importFromCloudSync = suitableSizeTextView;
            this.$divider = imageView;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final kotlin.coroutines.c<m9.q> create(Object obj, kotlin.coroutines.c<?> cVar) {
            return new AnonymousClass1(this.this$0, this.$isHideCloudSync, this.$isVisible, this.$importFromCloudSync, this.$divider, cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            boolean z10;
            int i10;
            kotlin.coroutines.intrinsics.b.c();
            if (this.label == 0) {
                kotlin.b.b(obj);
                if (!this.this$0.isAdded()) {
                    return m9.q.f35511a;
                }
                int i11 = 0;
                if (!this.$isHideCloudSync && this.$isVisible) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                H7.b.b("ImportContactsTipsFragment", " updateCloudSyncVisibility shouldShow= " + z10);
                SuitableSizeTextView suitableSizeTextView = this.$importFromCloudSync;
                if (z10) {
                    i10 = 0;
                } else {
                    i10 = 8;
                }
                suitableSizeTextView.setVisibility(i10);
                ImageView imageView = this.$divider;
                if (!z10) {
                    i11 = 8;
                }
                imageView.setVisibility(i11);
                this.this$0.v1();
                return m9.q.f35511a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        @Override // v9.p
        public final Object invoke(E e10, kotlin.coroutines.c<? super m9.q> cVar) {
            return ((AnonymousClass1) create(e10, cVar)).invokeSuspend(m9.q.f35511a);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ImportContactsTipsFragment$updateCloudSyncVisibility$1(ImportContactsTipsFragment importContactsTipsFragment, boolean z10, SuitableSizeTextView suitableSizeTextView, ImageView imageView, kotlin.coroutines.c<? super ImportContactsTipsFragment$updateCloudSyncVisibility$1> cVar) {
        super(2, cVar);
        this.this$0 = importContactsTipsFragment;
        this.$isVisible = z10;
        this.$importFromCloudSync = suitableSizeTextView;
        this.$divider = imageView;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final kotlin.coroutines.c<m9.q> create(Object obj, kotlin.coroutines.c<?> cVar) {
        return new ImportContactsTipsFragment$updateCloudSyncVisibility$1(this.this$0, this.$isVisible, this.$importFromCloudSync, this.$divider, cVar);
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
            com.android.contacts.framework.api.cloudsync.a.c();
            w0 c11 = S.c();
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.this$0, false, this.$isVisible, this.$importFromCloudSync, this.$divider, null);
            this.label = 1;
            if (C1244g.g(c11, anonymousClass1, this) == c10) {
                return c10;
            }
        }
        return m9.q.f35511a;
    }

    @Override // v9.p
    public final Object invoke(E e10, kotlin.coroutines.c<? super m9.q> cVar) {
        return ((ImportContactsTipsFragment$updateCloudSyncVisibility$1) create(e10, cVar)).invokeSuspend(m9.q.f35511a);
    }
}
