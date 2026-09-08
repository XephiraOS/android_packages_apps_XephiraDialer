package com.oplus.omoji.ui;

import android.view.ViewTreeObserver;
import androidx.recyclerview.widget.COUIRecyclerView;

/* compiled from: OmojiPanelFragment.kt */
/* loaded from: classes3.dex */
public final class OmojiPanelFragment$onConfigurationChanged$1 implements ViewTreeObserver.OnGlobalLayoutListener {
    final /* synthetic */ OmojiPanelFragment this$0;

    public OmojiPanelFragment$onConfigurationChanged$1(OmojiPanelFragment omojiPanelFragment) {
        this.this$0 = omojiPanelFragment;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onGlobalLayout$lambda$0(OmojiPanelFragment this$0) {
        g1.e eVar;
        kotlin.jvm.internal.i.f(this$0, "this$0");
        eVar = this$0.omojiPhotoAdapter;
        if (eVar != null) {
            eVar.notifyDataSetChanged();
        }
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public void onGlobalLayout() {
        COUIRecyclerView cOUIRecyclerView;
        COUIRecyclerView cOUIRecyclerView2;
        ViewTreeObserver viewTreeObserver;
        cOUIRecyclerView = this.this$0.recyclerView;
        if (cOUIRecyclerView != null && (viewTreeObserver = cOUIRecyclerView.getViewTreeObserver()) != null) {
            viewTreeObserver.removeOnGlobalLayoutListener(this);
        }
        cOUIRecyclerView2 = this.this$0.recyclerView;
        if (cOUIRecyclerView2 != null) {
            final OmojiPanelFragment omojiPanelFragment = this.this$0;
            cOUIRecyclerView2.post(new Runnable() { // from class: com.oplus.omoji.ui.l
                @Override // java.lang.Runnable
                public final void run() {
                    OmojiPanelFragment$onConfigurationChanged$1.onGlobalLayout$lambda$0(OmojiPanelFragment.this);
                }
            });
        }
    }
}
