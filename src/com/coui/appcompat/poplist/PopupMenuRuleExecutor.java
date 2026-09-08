package com.coui.appcompat.poplist;

import android.graphics.Rect;
import android.util.Log;
import com.coui.appcompat.log.COUILog;
import com.coui.appcompat.uiutil.Executor;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class PopupMenuRuleExecutor implements Executor<PopupMenuRule, PopupMenuDomain> {
    private static final String TAG = "PopupMenuRuleExecutor";
    private final Executor<PopupMenuControlRule, PopupMenuDomain> mPopupMenuControlRuleExecutor = new Executor<PopupMenuControlRule, PopupMenuDomain>() { // from class: com.coui.appcompat.poplist.PopupMenuRuleExecutor.1
        @Override // com.coui.appcompat.uiutil.Executor
        public Executor<PopupMenuControlRule, PopupMenuDomain> execute(PopupMenuControlRule popupMenuControlRule, PopupMenuDomain popupMenuDomain) {
            popupMenuControlRule.operation(popupMenuDomain);
            return this;
        }
    };
    private final Executor<PopupMenuConfigRule, PopupMenuDomain> mPopupMenuConfigRuleExecutor = new Executor<PopupMenuConfigRule, PopupMenuDomain>() { // from class: com.coui.appcompat.poplist.PopupMenuRuleExecutor.2
        private Rect getOutsetsRect(Rect rect, Rect rect2) {
            return new Rect(rect.left - rect2.left, rect.top - rect2.top, rect.right + rect2.right, rect.bottom + rect2.bottom);
        }

        @Override // com.coui.appcompat.uiutil.Executor
        public Executor<PopupMenuConfigRule, PopupMenuDomain> execute(PopupMenuConfigRule popupMenuConfigRule, PopupMenuDomain popupMenuDomain) {
            if (!popupMenuConfigRule.getPopupMenuRuleEnabled()) {
                COUILog.i(PopupMenuRuleExecutor.TAG, "Skip disabled rule " + popupMenuConfigRule);
                return this;
            }
            int type = popupMenuConfigRule.getType();
            if (type == 0) {
                popupMenuDomain.mWindow.set(popupMenuConfigRule.getDisplayFrame());
            } else if (type == 1) {
                popupMenuDomain.mAnchor.set(popupMenuConfigRule.getDisplayFrame());
                popupMenuDomain.mAnchorOutsets.set(popupMenuConfigRule.getOutsets());
            } else if (type == 2) {
                Rect outsetsRect = getOutsetsRect(popupMenuConfigRule.getDisplayFrame(), popupMenuConfigRule.getOutsets());
                PopupMenuRuleExecutor.this.ensureBarrierLegal(outsetsRect);
                int barrierDirection = popupMenuConfigRule.getBarrierDirection();
                if (barrierDirection == 0) {
                    Rect rect = popupMenuDomain.mWindowBarriers;
                    rect.left = Math.max(rect.left, outsetsRect.right - popupMenuDomain.mWindow.left);
                } else if (barrierDirection == 1) {
                    Rect rect2 = popupMenuDomain.mWindowBarriers;
                    rect2.top = Math.max(rect2.top, outsetsRect.bottom - popupMenuDomain.mWindow.top);
                } else if (barrierDirection == 2) {
                    Rect rect3 = popupMenuDomain.mWindowBarriers;
                    rect3.right = Math.max(rect3.right, popupMenuDomain.mWindow.right - outsetsRect.left);
                } else if (barrierDirection == 3) {
                    Rect rect4 = popupMenuDomain.mWindowBarriers;
                    rect4.bottom = Math.max(rect4.bottom, popupMenuDomain.mWindow.bottom - outsetsRect.top);
                } else if (barrierDirection == 4) {
                    Rect rect5 = popupMenuDomain.mWindowBarriers;
                    rect5.left = Math.max(rect5.left, outsetsRect.left - popupMenuDomain.mWindow.left);
                    Rect rect6 = popupMenuDomain.mWindowBarriers;
                    rect6.top = Math.max(rect6.top, outsetsRect.top - popupMenuDomain.mWindow.top);
                    Rect rect7 = popupMenuDomain.mWindowBarriers;
                    rect7.right = Math.max(rect7.right, popupMenuDomain.mWindow.right - outsetsRect.right);
                    Rect rect8 = popupMenuDomain.mWindowBarriers;
                    rect8.bottom = Math.max(rect8.bottom, popupMenuDomain.mWindow.bottom - outsetsRect.bottom);
                }
            } else if (type == 3) {
                popupMenuDomain.mSubMenuAnchor.set(popupMenuConfigRule.getDisplayFrame());
            }
            return this;
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public void ensureBarrierLegal(Rect rect) {
        if (rect.left < 0) {
            Log.e(TAG, "barrier left < 0 !!");
            rect.left = 0;
        }
        if (rect.top < 0) {
            Log.e(TAG, "barrier top < 0 !!");
            rect.top = 0;
        }
        if (rect.right < 0) {
            Log.e(TAG, "barrier right < 0 !!");
            rect.right = 0;
        }
        if (rect.bottom < 0) {
            Log.e(TAG, "barrier bottom < 0 !!");
            rect.bottom = 0;
        }
    }

    @Override // com.coui.appcompat.uiutil.Executor
    public Executor<PopupMenuRule, PopupMenuDomain> execute(PopupMenuRule popupMenuRule, PopupMenuDomain popupMenuDomain) {
        if (popupMenuRule instanceof PopupMenuControlRule) {
            this.mPopupMenuControlRuleExecutor.execute((PopupMenuControlRule) popupMenuRule, popupMenuDomain);
        } else if (popupMenuRule instanceof PopupMenuConfigRule) {
            this.mPopupMenuConfigRuleExecutor.execute((PopupMenuConfigRule) popupMenuRule, popupMenuDomain);
        }
        return this;
    }
}
