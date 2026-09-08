package com.customize.contacts.manager;

import android.os.Looper;
import androidx.fragment.app.FragmentActivity;
import com.customize.contacts.fragment.DialtactsUnfoldFragment;
import com.customize.contacts.fragment.SearchFragment;
import com.oplus.contacts.list.fragment.FoldableContactsMainListFragment;
import java.lang.ref.SoftReference;

/* compiled from: ContactUnfoldFragmentManager.kt */
/* loaded from: classes3.dex */
public final class ContactUnfoldFragmentManager {

    /* renamed from: d, reason: collision with root package name */
    public static final a f21503d = new a(null);

    /* renamed from: e, reason: collision with root package name */
    public static final ContactUnfoldFragmentManager f21504e = new ContactUnfoldFragmentManager();

    /* renamed from: a, reason: collision with root package name */
    public SoftReference<FoldableContactsMainListFragment> f21505a;

    /* renamed from: b, reason: collision with root package name */
    public SoftReference<DialtactsUnfoldFragment> f21506b;

    /* renamed from: c, reason: collision with root package name */
    public SoftReference<SearchFragment> f21507c;

    /* compiled from: ContactUnfoldFragmentManager.kt */
    /* loaded from: classes3.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.f fVar) {
            this();
        }
    }

    public static final void e(v9.l operate, DialtactsUnfoldFragment it) {
        kotlin.jvm.internal.i.f(operate, "$operate");
        kotlin.jvm.internal.i.f(it, "$it");
        operate.invoke(it);
    }

    public static final void g(v9.l operate, FoldableContactsMainListFragment it) {
        kotlin.jvm.internal.i.f(operate, "$operate");
        kotlin.jvm.internal.i.f(it, "$it");
        operate.invoke(it);
    }

    public static final void i(v9.l operate, SearchFragment it) {
        kotlin.jvm.internal.i.f(operate, "$operate");
        kotlin.jvm.internal.i.f(it, "$it");
        operate.invoke(it);
    }

    public final void d(final v9.l<? super DialtactsUnfoldFragment, m9.q> lVar) {
        final DialtactsUnfoldFragment dialtactsUnfoldFragment;
        SoftReference<DialtactsUnfoldFragment> softReference = this.f21506b;
        if (softReference != null && (dialtactsUnfoldFragment = softReference.get()) != null) {
            if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
                lVar.invoke(dialtactsUnfoldFragment);
                return;
            }
            FragmentActivity activity = dialtactsUnfoldFragment.getActivity();
            if (activity != null) {
                activity.runOnUiThread(new Runnable() { // from class: com.customize.contacts.manager.c
                    @Override // java.lang.Runnable
                    public final void run() {
                        ContactUnfoldFragmentManager.e(v9.l.this, dialtactsUnfoldFragment);
                    }
                });
            }
        }
    }

    public final void f(final v9.l<? super FoldableContactsMainListFragment, m9.q> lVar) {
        final FoldableContactsMainListFragment foldableContactsMainListFragment;
        SoftReference<FoldableContactsMainListFragment> softReference = this.f21505a;
        if (softReference != null && (foldableContactsMainListFragment = softReference.get()) != null) {
            if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
                lVar.invoke(foldableContactsMainListFragment);
                return;
            }
            FragmentActivity activity = foldableContactsMainListFragment.getActivity();
            if (activity != null) {
                activity.runOnUiThread(new Runnable() { // from class: com.customize.contacts.manager.e
                    @Override // java.lang.Runnable
                    public final void run() {
                        ContactUnfoldFragmentManager.g(v9.l.this, foldableContactsMainListFragment);
                    }
                });
            }
        }
    }

    public final void h(final v9.l<? super SearchFragment, m9.q> lVar) {
        final SearchFragment searchFragment;
        SoftReference<SearchFragment> softReference = this.f21507c;
        if (softReference != null && (searchFragment = softReference.get()) != null) {
            if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
                lVar.invoke(searchFragment);
                return;
            }
            FragmentActivity activity = searchFragment.getActivity();
            if (activity != null) {
                activity.runOnUiThread(new Runnable() { // from class: com.customize.contacts.manager.d
                    @Override // java.lang.Runnable
                    public final void run() {
                        ContactUnfoldFragmentManager.i(v9.l.this, searchFragment);
                    }
                });
            }
        }
    }

    public final void j(String str) {
        if (str != null) {
            switch (str.hashCode()) {
                case -988923278:
                    if (str.equals("search_unfold_contact")) {
                        h(new v9.l<SearchFragment, m9.q>() { // from class: com.customize.contacts.manager.ContactUnfoldFragmentManager$finish$3
                            public final void b(SearchFragment it) {
                                kotlin.jvm.internal.i.f(it, "it");
                                it.H3();
                            }

                            @Override // v9.l
                            public /* bridge */ /* synthetic */ m9.q invoke(SearchFragment searchFragment) {
                                b(searchFragment);
                                return m9.q.f35511a;
                            }
                        });
                        return;
                    }
                    return;
                case -597857128:
                    if (!str.equals("right_fragment_tag_show_profile")) {
                        return;
                    }
                    break;
                case 41542742:
                    if (str.equals("unfold_dial_contact")) {
                        d(new v9.l<DialtactsUnfoldFragment, m9.q>() { // from class: com.customize.contacts.manager.ContactUnfoldFragmentManager$finish$2
                            public final void b(DialtactsUnfoldFragment it) {
                                kotlin.jvm.internal.i.f(it, "it");
                                it.P8();
                            }

                            @Override // v9.l
                            public /* bridge */ /* synthetic */ m9.q invoke(DialtactsUnfoldFragment dialtactsUnfoldFragment) {
                                b(dialtactsUnfoldFragment);
                                return m9.q.f35511a;
                            }
                        });
                        return;
                    }
                    return;
                case 1842060162:
                    if (!str.equals("right_fragment_tag_show_detail")) {
                        return;
                    }
                    break;
                case 2140784942:
                    if (!str.equals("right_fragment_tag_show_group")) {
                        return;
                    }
                    break;
                default:
                    return;
            }
            f(new v9.l<FoldableContactsMainListFragment, m9.q>() { // from class: com.customize.contacts.manager.ContactUnfoldFragmentManager$finish$1
                public final void b(FoldableContactsMainListFragment it) {
                    kotlin.jvm.internal.i.f(it, "it");
                    it.q4();
                }

                @Override // v9.l
                public /* bridge */ /* synthetic */ m9.q invoke(FoldableContactsMainListFragment foldableContactsMainListFragment) {
                    b(foldableContactsMainListFragment);
                    return m9.q.f35511a;
                }
            });
        }
    }

    public final void k(DialtactsUnfoldFragment fragment) {
        kotlin.jvm.internal.i.f(fragment, "fragment");
        this.f21506b = new SoftReference<>(fragment);
    }

    public final void l(FoldableContactsMainListFragment fragment) {
        kotlin.jvm.internal.i.f(fragment, "fragment");
        this.f21505a = new SoftReference<>(fragment);
    }

    public final void m(SearchFragment fragment) {
        kotlin.jvm.internal.i.f(fragment, "fragment");
        this.f21507c = new SoftReference<>(fragment);
    }
}
