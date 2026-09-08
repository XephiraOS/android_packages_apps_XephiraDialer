package com.oplus.contacts.list;

import android.content.Context;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.RepeatOnLifecycleKt;
import com.customize.contacts.util.W;
import com.oplus.contacts.list.ContactsMainListHeaderView;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.i;
import kotlinx.coroutines.C1248i;
import kotlinx.coroutines.E;
import kotlinx.coroutines.S;
import m9.q;
import p9.InterfaceC1470d;
import v9.p;
import x0.AbstractC1669g;

/* compiled from: ContactsMainListHeaderView.kt */
@InterfaceC1470d(c = "com.oplus.contacts.list.ContactsMainListHeaderView$observeProfileIcon$1", f = "ContactsMainListHeaderView.kt", l = {88}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class ContactsMainListHeaderView$observeProfileIcon$1 extends SuspendLambda implements p<E, kotlin.coroutines.c<? super q>, Object> {
    int label;
    final /* synthetic */ ContactsMainListHeaderView this$0;

    /* compiled from: ContactsMainListHeaderView.kt */
    @InterfaceC1470d(c = "com.oplus.contacts.list.ContactsMainListHeaderView$observeProfileIcon$1$1", f = "ContactsMainListHeaderView.kt", l = {89}, m = "invokeSuspend")
    /* renamed from: com.oplus.contacts.list.ContactsMainListHeaderView$observeProfileIcon$1$1, reason: invalid class name */
    /* loaded from: classes3.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements p<E, kotlin.coroutines.c<? super q>, Object> {
        int label;
        final /* synthetic */ ContactsMainListHeaderView this$0;

        /* compiled from: ContactsMainListHeaderView.kt */
        @InterfaceC1470d(c = "com.oplus.contacts.list.ContactsMainListHeaderView$observeProfileIcon$1$1$1", f = "ContactsMainListHeaderView.kt", l = {}, m = "invokeSuspend")
        /* renamed from: com.oplus.contacts.list.ContactsMainListHeaderView$observeProfileIcon$1$1$1, reason: invalid class name and collision with other inner class name */
        /* loaded from: classes3.dex */
        public static final class C02511 extends SuspendLambda implements p<ContactsMainListHeaderView.c, kotlin.coroutines.c<? super q>, Object> {
            /* synthetic */ Object L$0;
            int label;
            final /* synthetic */ ContactsMainListHeaderView this$0;

            /* compiled from: ContactsMainListHeaderView.kt */
            @InterfaceC1470d(c = "com.oplus.contacts.list.ContactsMainListHeaderView$observeProfileIcon$1$1$1$1", f = "ContactsMainListHeaderView.kt", l = {}, m = "invokeSuspend")
            /* renamed from: com.oplus.contacts.list.ContactsMainListHeaderView$observeProfileIcon$1$1$1$1, reason: invalid class name and collision with other inner class name */
            /* loaded from: classes3.dex */
            public static final class C02521 extends SuspendLambda implements p<E, kotlin.coroutines.c<? super q>, Object> {
                int label;
                final /* synthetic */ ContactsMainListHeaderView this$0;

                /* compiled from: ContactsMainListHeaderView.kt */
                @InterfaceC1470d(c = "com.oplus.contacts.list.ContactsMainListHeaderView$observeProfileIcon$1$1$1$1$1", f = "ContactsMainListHeaderView.kt", l = {}, m = "invokeSuspend")
                /* renamed from: com.oplus.contacts.list.ContactsMainListHeaderView$observeProfileIcon$1$1$1$1$1, reason: invalid class name and collision with other inner class name */
                /* loaded from: classes3.dex */
                public static final class C02531 extends SuspendLambda implements p<E, kotlin.coroutines.c<? super q>, Object> {
                    int label;
                    final /* synthetic */ ContactsMainListHeaderView this$0;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    public C02531(ContactsMainListHeaderView contactsMainListHeaderView, kotlin.coroutines.c<? super C02531> cVar) {
                        super(2, cVar);
                        this.this$0 = contactsMainListHeaderView;
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final kotlin.coroutines.c<q> create(Object obj, kotlin.coroutines.c<?> cVar) {
                        return new C02531(this.this$0, cVar);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) {
                        AbstractC1669g abstractC1669g;
                        kotlin.coroutines.intrinsics.b.c();
                        if (this.label == 0) {
                            kotlin.b.b(obj);
                            Context context = this.this$0.getContext();
                            abstractC1669g = this.this$0.f27840d;
                            if (abstractC1669g == null) {
                                i.q("viewBinding");
                                abstractC1669g = null;
                            }
                            W.f(context, abstractC1669g.f37711K);
                            return q.f35511a;
                        }
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }

                    @Override // v9.p
                    public final Object invoke(E e10, kotlin.coroutines.c<? super q> cVar) {
                        return ((C02531) create(e10, cVar)).invokeSuspend(q.f35511a);
                    }
                }

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public C02521(ContactsMainListHeaderView contactsMainListHeaderView, kotlin.coroutines.c<? super C02521> cVar) {
                    super(2, cVar);
                    this.this$0 = contactsMainListHeaderView;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final kotlin.coroutines.c<q> create(Object obj, kotlin.coroutines.c<?> cVar) {
                    return new C02521(this.this$0, cVar);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object obj) {
                    E viewScope;
                    kotlin.coroutines.intrinsics.b.c();
                    if (this.label == 0) {
                        kotlin.b.b(obj);
                        W.c(this.this$0.getContext());
                        viewScope = this.this$0.getViewScope();
                        if (viewScope != null) {
                            C1248i.d(viewScope, S.c(), null, new C02531(this.this$0, null), 2, null);
                        }
                        return q.f35511a;
                    }
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }

                @Override // v9.p
                public final Object invoke(E e10, kotlin.coroutines.c<? super q> cVar) {
                    return ((C02521) create(e10, cVar)).invokeSuspend(q.f35511a);
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C02511(ContactsMainListHeaderView contactsMainListHeaderView, kotlin.coroutines.c<? super C02511> cVar) {
                super(2, cVar);
                this.this$0 = contactsMainListHeaderView;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final kotlin.coroutines.c<q> create(Object obj, kotlin.coroutines.c<?> cVar) {
                C02511 c02511 = new C02511(this.this$0, cVar);
                c02511.L$0 = obj;
                return c02511;
            }

            @Override // v9.p
            /* renamed from: e, reason: merged with bridge method [inline-methods] */
            public final Object invoke(ContactsMainListHeaderView.c cVar, kotlin.coroutines.c<? super q> cVar2) {
                return ((C02511) create(cVar, cVar2)).invokeSuspend(q.f35511a);
            }

            /* JADX WARN: Code restructure failed: missing block: B:5:0x0014, code lost:
            
                r0 = r6.this$0.getViewScope();
             */
            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public final java.lang.Object invokeSuspend(java.lang.Object r7) {
                /*
                    r6 = this;
                    kotlin.coroutines.intrinsics.a.c()
                    int r0 = r6.label
                    if (r0 != 0) goto L31
                    kotlin.b.b(r7)
                    java.lang.Object r7 = r6.L$0
                    com.oplus.contacts.list.ContactsMainListHeaderView$c r7 = (com.oplus.contacts.list.ContactsMainListHeaderView.c) r7
                    boolean r7 = r7.d()
                    if (r7 == 0) goto L2e
                    com.oplus.contacts.list.ContactsMainListHeaderView r7 = r6.this$0
                    kotlinx.coroutines.E r0 = com.oplus.contacts.list.ContactsMainListHeaderView.g(r7)
                    if (r0 == 0) goto L2e
                    kotlinx.coroutines.CoroutineDispatcher r1 = kotlinx.coroutines.S.b()
                    com.oplus.contacts.list.ContactsMainListHeaderView$observeProfileIcon$1$1$1$1 r3 = new com.oplus.contacts.list.ContactsMainListHeaderView$observeProfileIcon$1$1$1$1
                    com.oplus.contacts.list.ContactsMainListHeaderView r6 = r6.this$0
                    r7 = 0
                    r3.<init>(r6, r7)
                    r4 = 2
                    r5 = 0
                    r2 = 0
                    kotlinx.coroutines.C1244g.d(r0, r1, r2, r3, r4, r5)
                L2e:
                    m9.q r6 = m9.q.f35511a
                    return r6
                L31:
                    java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                    java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
                    r6.<init>(r7)
                    throw r6
                */
                throw new UnsupportedOperationException("Method not decompiled: com.oplus.contacts.list.ContactsMainListHeaderView$observeProfileIcon$1.AnonymousClass1.C02511.invokeSuspend(java.lang.Object):java.lang.Object");
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(ContactsMainListHeaderView contactsMainListHeaderView, kotlin.coroutines.c<? super AnonymousClass1> cVar) {
            super(2, cVar);
            this.this$0 = contactsMainListHeaderView;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final kotlin.coroutines.c<q> create(Object obj, kotlin.coroutines.c<?> cVar) {
            return new AnonymousClass1(this.this$0, cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object c10;
            kotlinx.coroutines.flow.i iVar;
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
                iVar = this.this$0.f27838b;
                C02511 c02511 = new C02511(this.this$0, null);
                this.label = 1;
                if (kotlinx.coroutines.flow.c.d(iVar, c02511, this) == c10) {
                    return c10;
                }
            }
            return q.f35511a;
        }

        @Override // v9.p
        public final Object invoke(E e10, kotlin.coroutines.c<? super q> cVar) {
            return ((AnonymousClass1) create(e10, cVar)).invokeSuspend(q.f35511a);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ContactsMainListHeaderView$observeProfileIcon$1(ContactsMainListHeaderView contactsMainListHeaderView, kotlin.coroutines.c<? super ContactsMainListHeaderView$observeProfileIcon$1> cVar) {
        super(2, cVar);
        this.this$0 = contactsMainListHeaderView;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final kotlin.coroutines.c<q> create(Object obj, kotlin.coroutines.c<?> cVar) {
        return new ContactsMainListHeaderView$observeProfileIcon$1(this.this$0, cVar);
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
            ContactsMainListHeaderView contactsMainListHeaderView = this.this$0;
            Lifecycle.State state = Lifecycle.State.STARTED;
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(contactsMainListHeaderView, null);
            this.label = 1;
            if (RepeatOnLifecycleKt.b(contactsMainListHeaderView, state, anonymousClass1, this) == c10) {
                return c10;
            }
        }
        return q.f35511a;
    }

    @Override // v9.p
    public final Object invoke(E e10, kotlin.coroutines.c<? super q> cVar) {
        return ((ContactsMainListHeaderView$observeProfileIcon$1) create(e10, cVar)).invokeSuspend(q.f35511a);
    }
}
