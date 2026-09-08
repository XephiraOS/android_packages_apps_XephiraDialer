package com.coui.appcompat.springchain;

import android.util.Log;
import c4.e;
import c4.g;
import c4.l;
import com.coui.appcompat.springchain.api.IChainItem;
import com.coui.appcompat.springchain.api.ISpringUpdateListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.i;

/* compiled from: COUIGridSpringChain.kt */
/* loaded from: classes.dex */
public final class COUIGridSpringChain {
    public static final int ATTACHMENT_FRICTION = 10;
    public static final int ATTACHMENT_TENSION = 150;
    public static final int BACK_TO_BOTTOM = 2;
    public static final int BACK_TO_LEFT = 3;
    public static final int BACK_TO_RIGHT = 4;
    public static final int BACK_TO_TOP = 1;
    public static final Companion Companion = new Companion(null);
    public static final boolean DEBUG = true;
    public static final int MAIN_FRICTION = 10;
    public static final int MAIN_TENSION = 150;
    public static final int MAX_X = 50;
    public static final int MAX_Y = 50;
    public static final String TAG = "COUIGridSpringChain";
    private List<List<IChainItem>> allItems;
    private TransCalculator backToBottomTC;
    private TransCalculator backToLeftTC;
    private TransCalculator backToRightTC;
    private TransCalculator backToTopTC;
    private float[] curSpringXArray;
    private float[] curSpringYArray;
    private int currentMaxX;
    private int currentMaxY;
    private boolean enableAutoAcc;
    private int lastMoveDirection;
    private int lastReboundDirection;
    private float[] lastSpringXArray;
    private float[] lastSpringYArray;
    private int maxXSize;
    private int maxYSize;
    private COUISpringChain springChainX;
    private COUISpringChain springChainY;
    private l springSystem;
    private ISpringUpdateListener springUpdateListener;
    private int xDirection;
    private int yDirection;

    /* compiled from: COUIGridSpringChain.kt */
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(f fVar) {
            this();
        }
    }

    /* compiled from: COUIGridSpringChain.kt */
    /* loaded from: classes.dex */
    public static final class DefaultTransCalculator implements TransCalculator {
        @Override // com.coui.appcompat.springchain.COUIGridSpringChain.TransCalculator
        public float getTrans(int i10, float f10, int i11) {
            return f10 * 0.1f;
        }
    }

    /* compiled from: COUIGridSpringChain.kt */
    /* loaded from: classes.dex */
    public final class GridSpringListener extends c4.f {
        private int direction;
        private int index;

        public GridSpringListener(int i10, int i11) {
            this.index = i10;
            this.direction = i11;
        }

        public final int getDirection() {
            return this.direction;
        }

        public final int getIndex() {
            return this.index;
        }

        @Override // c4.f, c4.j
        public void onSpringUpdate(g spring) {
            i.f(spring, "spring");
            if (COUIGridSpringChain.this.yDirection != -1 && COUIGridSpringChain.this.isPortrait(this.direction)) {
                COUIGridSpringChain.this.springUpdateTranslation(this.index, (float) spring.c(), COUIGridSpringChain.this.yDirection);
            } else if (COUIGridSpringChain.this.xDirection != -1 && !COUIGridSpringChain.this.isPortrait(this.direction)) {
                COUIGridSpringChain.this.springUpdateTranslation(this.index, (float) spring.c(), COUIGridSpringChain.this.xDirection);
            }
        }

        public final void setDirection(int i10) {
            this.direction = i10;
        }

        public final void setIndex(int i10) {
            this.index = i10;
        }
    }

    /* compiled from: COUIGridSpringChain.kt */
    /* loaded from: classes.dex */
    public interface TransCalculator {
        float getTrans(int i10, float f10, int i11);
    }

    public COUIGridSpringChain() {
        this(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1023, null);
    }

    private final float calculateTranslation(int i10, float f10, int i11) {
        int i12;
        if (i11 == 4) {
            i12 = this.currentMaxX - i10;
        } else {
            i12 = i10;
        }
        if (i11 == 2) {
            i12 = this.currentMaxY - i10;
        }
        if (this.enableAutoAcc) {
            float f11 = 0.0f;
            if (i12 < 0) {
                return 0.0f;
            }
            int i13 = 0;
            while (true) {
                if (!skipCumulativeCalculate(i13, i12, i11)) {
                    f11 += getTrans(i13, f10, i11);
                }
                if (i13 != i12) {
                    i13++;
                } else {
                    return f11;
                }
            }
        } else {
            return getTrans(i12, f10, i11);
        }
    }

    private final boolean checkItemsCount(int i10, int i11) {
        if (this.allItems.size() > i10 && this.allItems.get(i10).size() > i11) {
            return true;
        }
        return false;
    }

    private final int getCurrentMaxSize(int i10) {
        if (isPortrait(i10)) {
            return this.currentMaxY;
        }
        return this.currentMaxX;
    }

    private final float getTrans(int i10, float f10, int i11) {
        if (i11 != 1) {
            if (i11 != 2) {
                if (i11 != 3) {
                    if (i11 != 4) {
                        Log.e(TAG, "getDelta: error direction=" + i11);
                        return 0.0f;
                    }
                    TransCalculator transCalculator = this.backToRightTC;
                    if (transCalculator == null) {
                        return 0.0f;
                    }
                    return transCalculator.getTrans(i10, f10, i11);
                }
                TransCalculator transCalculator2 = this.backToLeftTC;
                if (transCalculator2 == null) {
                    return 0.0f;
                }
                return transCalculator2.getTrans(i10, f10, i11);
            }
            TransCalculator transCalculator3 = this.backToBottomTC;
            if (transCalculator3 == null) {
                return 0.0f;
            }
            return transCalculator3.getTrans(i10, f10, i11);
        }
        TransCalculator transCalculator4 = this.backToTopTC;
        if (transCalculator4 == null) {
            return 0.0f;
        }
        return transCalculator4.getTrans(i10, f10, i11);
    }

    private final float getTranslation(float f10, IChainItem iChainItem, int i10) {
        int itemY;
        int itemHeight;
        int itemY2;
        if (i10 != 1) {
            if (i10 != 2) {
                if (i10 != 3) {
                    if (i10 != 4) {
                        itemY = 0;
                    } else {
                        itemHeight = iChainItem.getItemWidth();
                        itemY2 = iChainItem.getItemX();
                    }
                } else {
                    itemY = iChainItem.getItemX();
                }
            } else {
                itemHeight = iChainItem.getItemHeight();
                itemY2 = iChainItem.getItemY();
            }
            itemY = (itemY2 + itemHeight) - 1;
        } else {
            itemY = iChainItem.getItemY();
        }
        return calculateTranslation(itemY, f10, i10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean isPortrait(int i10) {
        if (i10 == 1 || i10 == 2) {
            return true;
        }
        if (i10 != 3 && i10 != 4) {
            throw new IllegalArgumentException("isPortrait: wrong dir=" + i10);
        }
        return false;
    }

    private final void removeItem(IChainItem iChainItem) {
        boolean z10;
        boolean z11;
        int itemX = iChainItem.getItemX();
        int itemY = iChainItem.getItemY();
        int itemWidth = iChainItem.getItemWidth() + itemX;
        int itemHeight = iChainItem.getItemHeight() + itemY;
        if (itemWidth <= this.currentMaxX && itemHeight <= this.currentMaxY) {
            while (itemY < itemHeight) {
                for (int i10 = itemX; i10 < itemWidth; i10++) {
                    if (checkItemsCount(itemY, i10)) {
                        this.allItems.get(itemY).set(i10, null);
                    }
                }
                itemY++;
            }
            if (itemWidth == this.currentMaxX) {
                z10 = true;
            } else {
                z10 = false;
            }
            if (itemHeight == this.currentMaxY) {
                z11 = true;
            } else {
                z11 = false;
            }
            if (z10) {
                while (z10 && this.currentMaxX > 0) {
                    int i11 = this.currentMaxY;
                    int i12 = 0;
                    while (true) {
                        if (i12 >= i11) {
                            break;
                        }
                        if (checkItemsCount(i12, this.currentMaxX - 1) && this.allItems.get(i12).get(this.currentMaxX - 1) != null) {
                            z10 = false;
                            break;
                        }
                        i12++;
                    }
                    if (z10) {
                        this.currentMaxX--;
                    }
                }
            }
            if (z11) {
                while (z11 && this.currentMaxY > 0) {
                    int i13 = this.currentMaxX;
                    int i14 = 0;
                    while (true) {
                        if (i14 >= i13) {
                            break;
                        }
                        if (checkItemsCount(this.currentMaxY - 1, i14) && this.allItems.get(this.currentMaxY - 1).get(i14) != null) {
                            z11 = false;
                            break;
                        }
                        i14++;
                    }
                    if (z11) {
                        this.currentMaxY--;
                    }
                }
                return;
            }
            return;
        }
        Log.e(TAG, "can not remove a item that over gridSpringChain size");
    }

    private final boolean skipCumulativeCalculate(int i10, int i11, int i12) {
        if (i10 != i11) {
            if (isPortrait(i12)) {
                if (i12 == 2) {
                    i10 = this.currentMaxY - i10;
                }
                int i13 = this.currentMaxX;
                for (int i14 = 0; i14 < i13; i14++) {
                    if (checkItemsCount(i10, i14) && this.allItems.get(i10).get(i14) != null) {
                        IChainItem iChainItem = this.allItems.get(i10).get(i14);
                        i.c(iChainItem);
                        if (iChainItem.getSkipSpringChainCalc()) {
                            return true;
                        }
                    }
                }
            } else {
                if (i12 == 4) {
                    i10 = this.currentMaxX - i10;
                }
                int i15 = this.currentMaxY;
                for (int i16 = 0; i16 < i15; i16++) {
                    if (checkItemsCount(i16, i10) && this.allItems.get(i16).get(i10) != null) {
                        IChainItem iChainItem2 = this.allItems.get(i16).get(i10);
                        i.c(iChainItem2);
                        if (iChainItem2.getSkipSpringChainCalc()) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    private final void updateSpring(float f10, IChainItem iChainItem, int i10) {
        float translation = getTranslation(f10, iChainItem, i10);
        if (isPortrait(i10)) {
            int itemY = iChainItem.getItemY();
            float[] fArr = this.curSpringYArray;
            float f11 = translation + this.lastSpringYArray[itemY];
            fArr[itemY] = f11;
            iChainItem.updateSpringY(f11);
            return;
        }
        int itemX = iChainItem.getItemX();
        float[] fArr2 = this.curSpringXArray;
        float f12 = translation + this.lastSpringXArray[itemX];
        fArr2[itemX] = f12;
        iChainItem.updateSpringX(f12);
    }

    private final void updateSpringChain(int i10) {
        COUISpringChain cOUISpringChain;
        if (isPortrait(i10)) {
            cOUISpringChain = this.springChainY;
        } else {
            cOUISpringChain = this.springChainX;
        }
        int currentMaxSize = getCurrentMaxSize(i10);
        for (int size = cOUISpringChain.getAllSprings().size(); size < currentMaxSize; size++) {
            cOUISpringChain.addSpring(new GridSpringListener(size, i10));
        }
    }

    public final void addItem(IChainItem gridSpringItem) {
        IChainItem iChainItem;
        i.f(gridSpringItem, "gridSpringItem");
        int itemX = gridSpringItem.getItemX();
        int itemY = gridSpringItem.getItemY();
        int itemWidth = gridSpringItem.getItemWidth() + itemX;
        int itemHeight = gridSpringItem.getItemHeight() + itemY;
        if (itemHeight <= this.maxYSize && itemWidth <= this.maxXSize) {
            for (int i10 = itemY; i10 < itemHeight; i10++) {
                for (int i11 = itemX; i11 < itemWidth; i11++) {
                    if (checkItemsCount(i10, i11) && (iChainItem = this.allItems.get(i10).get(i11)) != null) {
                        removeItem(iChainItem);
                    }
                }
            }
            while (itemY < itemHeight) {
                for (int i12 = itemX; i12 < itemWidth; i12++) {
                    while (this.allItems.size() <= itemY) {
                        this.allItems.add(new ArrayList());
                    }
                    while (this.allItems.get(itemY).size() <= i12) {
                        this.allItems.get(itemY).add(null);
                    }
                    this.allItems.get(itemY).set(i12, gridSpringItem);
                }
                itemY++;
            }
            if (itemWidth > this.currentMaxX) {
                this.currentMaxX = itemWidth;
            }
            if (itemHeight > this.currentMaxY) {
                this.currentMaxY = itemHeight;
                return;
            }
            return;
        }
        Log.d(TAG, "can not addItem for the gridSpringChain is full");
    }

    public final void clearAllItems() {
        IChainItem iChainItem;
        int i10 = this.currentMaxY;
        for (int i11 = 0; i11 < i10; i11++) {
            int i12 = this.currentMaxX;
            for (int i13 = 0; i13 < i12; i13++) {
                if (checkItemsCount(i11, i13) && (iChainItem = this.allItems.get(i11).get(i13)) != null) {
                    removeItem(iChainItem);
                }
            }
        }
        this.currentMaxX = 0;
        this.currentMaxY = 0;
    }

    public final float getCurrentSpringX(int i10) {
        if (i10 > -1) {
            float[] fArr = this.curSpringXArray;
            if (i10 < fArr.length) {
                return fArr[i10];
            }
            return -1.0f;
        }
        return -1.0f;
    }

    public final float getCurrentSpringY(int i10) {
        if (i10 > -1) {
            float[] fArr = this.curSpringYArray;
            if (i10 < fArr.length) {
                return fArr[i10];
            }
            return -1.0f;
        }
        return -1.0f;
    }

    public final float getLastTranslationX() {
        if (this.lastReboundDirection == 4) {
            return this.lastSpringXArray[this.currentMaxX - 1];
        }
        return this.lastSpringXArray[0];
    }

    public final float getLastTranslationY() {
        if (this.lastReboundDirection == 2) {
            return this.lastSpringYArray[this.currentMaxY - 1];
        }
        return this.lastSpringYArray[0];
    }

    public final COUISpringChain getSpringChainX() {
        return this.springChainX;
    }

    public final COUISpringChain getSpringChainY() {
        return this.springChainY;
    }

    public final int isSpringSystemRunning() {
        if (!this.springSystem.e()) {
            return this.lastReboundDirection;
        }
        return 0;
    }

    public final void releaseSpring() {
        for (g gVar : this.springChainY.getAllSprings()) {
            gVar.l(gVar.c());
            gVar.k();
        }
        this.yDirection = -1;
        for (g gVar2 : this.springChainX.getAllSprings()) {
            gVar2.l(gVar2.c());
            gVar2.k();
        }
        this.xDirection = -1;
    }

    public final void releaseSpringAndLoc() {
        releaseSpringComplete();
        resetTranslation();
    }

    public final void releaseSpringComplete() {
        for (g gVar : this.springChainY.getAllSprings()) {
            gVar.l(0.0d);
            gVar.k();
        }
        this.yDirection = -1;
        for (g gVar2 : this.springChainX.getAllSprings()) {
            gVar2.l(0.0d);
            gVar2.k();
        }
        this.xDirection = -1;
    }

    public final void resetTranslation() {
        Arrays.fill(this.lastSpringXArray, 0.0f);
        Arrays.fill(this.lastSpringYArray, 0.0f);
        updateMoveTranslation(0.0f, 1);
        updateMoveTranslation(0.0f, 3);
    }

    public final void setCurrentSpringX(int i10, float f10) {
        if (i10 > -1) {
            float[] fArr = this.curSpringXArray;
            if (i10 < fArr.length) {
                fArr[i10] = f10;
            }
        }
    }

    public final void setCurrentSpringY(int i10, float f10) {
        if (i10 > -1) {
            float[] fArr = this.curSpringYArray;
            if (i10 < fArr.length) {
                fArr[i10] = f10;
            }
        }
    }

    public final void setEnableAutoAcc(boolean z10) {
        this.enableAutoAcc = z10;
    }

    public final void setSpringUpdateListener(ISpringUpdateListener springUpdateListener) {
        i.f(springUpdateListener, "springUpdateListener");
        this.springUpdateListener = springUpdateListener;
    }

    public final void setTranCalculator(int i10) {
        if (i10 == 1) {
            this.backToTopTC = new DefaultTransCalculator();
            return;
        }
        if (i10 == 2) {
            this.backToBottomTC = new DefaultTransCalculator();
            return;
        }
        if (i10 == 3) {
            this.backToLeftTC = new DefaultTransCalculator();
        } else if (i10 != 4) {
            Log.e(TAG, "the direction is not illegal!");
        } else {
            this.backToRightTC = new DefaultTransCalculator();
        }
    }

    public final void springUpdateTranslation(int i10, float f10, int i11) {
        IChainItem iChainItem;
        IChainItem iChainItem2;
        IChainItem iChainItem3;
        IChainItem iChainItem4;
        int i12 = 0;
        if (isPortrait(i11)) {
            if (i11 == 2) {
                while (i12 < this.currentMaxX) {
                    if (checkItemsCount(i10, i12) && (iChainItem4 = this.allItems.get(i10).get(i12)) != null && (iChainItem4.getItemY() + iChainItem4.getItemHeight()) - 1 == i10 && iChainItem4.getItemX() == i12) {
                        iChainItem4.updateSpringY(f10);
                        ISpringUpdateListener iSpringUpdateListener = this.springUpdateListener;
                        if (iSpringUpdateListener != null) {
                            iSpringUpdateListener.onUpdate(i10, f10, i11, iChainItem4);
                        }
                    }
                    i12++;
                }
            } else {
                while (i12 < this.currentMaxX) {
                    if (checkItemsCount(i10, i12) && (iChainItem3 = this.allItems.get(i10).get(i12)) != null && iChainItem3.getItemY() == i10 && iChainItem3.getItemX() == i12) {
                        iChainItem3.updateSpringY(f10);
                        ISpringUpdateListener iSpringUpdateListener2 = this.springUpdateListener;
                        if (iSpringUpdateListener2 != null) {
                            iSpringUpdateListener2.onUpdate(i10, f10, i11, iChainItem3);
                        }
                    }
                    i12++;
                }
            }
            this.curSpringYArray[i10] = f10;
            this.lastSpringYArray[i10] = f10;
            return;
        }
        if (i11 == 4) {
            while (i12 < this.currentMaxY) {
                if (checkItemsCount(i12, i10) && (iChainItem2 = this.allItems.get(i12).get(i10)) != null && iChainItem2.getItemY() == i12 && (iChainItem2.getItemX() + iChainItem2.getItemWidth()) - 1 == i10) {
                    iChainItem2.updateSpringX(f10);
                }
                i12++;
            }
        } else {
            while (i12 < this.currentMaxY) {
                if (checkItemsCount(i12, i10) && (iChainItem = this.allItems.get(i12).get(i10)) != null && iChainItem.getItemY() == i12 && iChainItem.getItemX() == i10) {
                    iChainItem.updateSpringX(f10);
                }
                i12++;
            }
        }
        this.curSpringXArray[i10] = f10;
        this.lastSpringXArray[i10] = f10;
    }

    public final void startRebound(int i10) {
        COUISpringChain cOUISpringChain;
        int i11;
        float[] fArr;
        if (i10 != 0) {
            this.lastReboundDirection = i10;
        } else {
            i10 = this.lastReboundDirection;
            if (i10 == 0) {
                return;
            }
        }
        boolean isPortrait = isPortrait(i10);
        updateSpringChain(4);
        updateSpringChain(2);
        if (isPortrait) {
            cOUISpringChain = this.springChainY;
        } else {
            cOUISpringChain = this.springChainX;
        }
        if (isPortrait) {
            i11 = this.currentMaxY;
        } else {
            i11 = this.currentMaxX;
        }
        if (isPortrait) {
            fArr = this.curSpringYArray;
        } else {
            fArr = this.curSpringXArray;
        }
        if (isPortrait) {
            this.yDirection = i10;
        } else {
            this.xDirection = i10;
        }
        List<g> allSprings = cOUISpringChain.getAllSprings();
        int i12 = -1;
        for (int i13 = 0; i13 < i11; i13++) {
            g gVar = allSprings.get(i13);
            double d10 = fArr[i13];
            if ((d10 >= 0.0d || i13 == i11 - 1) && i12 == -1) {
                i12 = i13;
            }
            gVar.m(d10, false);
            gVar.r(0.0d);
        }
        if (i12 == -1) {
            Log.d(TAG, "startRebound failed : chain is empty");
            return;
        }
        Log.d(TAG, "startRebound : ctrIndex=:" + i12 + " ,endValue=:0.0");
        cOUISpringChain.setControlSpringIndex(i12).getControlSpring().n(0.0d);
    }

    public final void updateMoveTranslation(float f10, int i10) {
        IChainItem iChainItem;
        if (i10 != 0) {
            this.lastMoveDirection = i10;
        } else {
            i10 = this.lastMoveDirection;
        }
        updateSpringChain(4);
        updateSpringChain(2);
        if (isPortrait(i10)) {
            this.yDirection = i10;
        } else {
            this.xDirection = i10;
        }
        int i11 = this.currentMaxY;
        for (int i12 = 0; i12 < i11; i12++) {
            int i13 = this.currentMaxX;
            for (int i14 = 0; i14 < i13; i14++) {
                if (checkItemsCount(i12, i14) && (iChainItem = this.allItems.get(i12).get(i14)) != null && iChainItem.getItemY() == i12 && iChainItem.getItemX() == i14) {
                    updateSpring(f10, iChainItem, i10);
                }
            }
        }
    }

    public final void updateSpringChainConfig(double d10, double d11, boolean z10) {
        COUISpringChain cOUISpringChain;
        if (z10) {
            cOUISpringChain = this.springChainX;
        } else {
            cOUISpringChain = this.springChainY;
        }
        cOUISpringChain.getMainSpringConfig().f12777b = e.d(d10);
        cOUISpringChain.getMainSpringConfig().f12776a = e.a(d11);
        cOUISpringChain.getAttachmentSpringConfig().f12777b = e.d(d10);
        cOUISpringChain.getAttachmentSpringConfig().f12777b = e.d(d11);
    }

    public COUIGridSpringChain(int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17, int i18, int i19) {
        this.xDirection = -1;
        this.yDirection = -1;
        this.curSpringYArray = new float[i19];
        this.curSpringXArray = new float[i18];
        this.lastSpringYArray = new float[i19];
        this.lastSpringXArray = new float[i18];
        this.allItems = new ArrayList();
        l h10 = l.h();
        i.e(h10, "create()");
        this.springSystem = h10;
        this.enableAutoAcc = true;
        COUISpringChain create = COUISpringChain.create(h10, i14, i15, i16, i17);
        i.e(create, "create(\n        springSy…sAttachmentFriction\n    )");
        this.springChainX = create;
        COUISpringChain create2 = COUISpringChain.create(this.springSystem, i10, i11, i12, i13);
        i.e(create2, "create(\n        springSy…sAttachmentFriction\n    )");
        this.springChainY = create2;
        this.maxXSize = i18;
        this.maxYSize = i19;
        this.lastMoveDirection = 2;
    }

    public final void setTranCalculator(TransCalculator transCalculator, int i10) {
        i.f(transCalculator, "transCalculator");
        if (i10 == 1) {
            this.backToTopTC = transCalculator;
            return;
        }
        if (i10 == 2) {
            this.backToBottomTC = transCalculator;
            return;
        }
        if (i10 == 3) {
            this.backToLeftTC = transCalculator;
        } else if (i10 != 4) {
            Log.e(TAG, "the direction is not illegal!");
        } else {
            this.backToRightTC = transCalculator;
        }
    }

    public final void releaseSpring(int i10) {
        if (isPortrait(i10)) {
            for (g gVar : this.springChainY.getAllSprings()) {
                gVar.l(gVar.c());
                gVar.k();
            }
            this.yDirection = -1;
            return;
        }
        for (g gVar2 : this.springChainX.getAllSprings()) {
            gVar2.l(gVar2.c());
            gVar2.k();
        }
        this.xDirection = -1;
    }

    public /* synthetic */ COUIGridSpringChain(int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17, int i18, int i19, int i20, f fVar) {
        this((i20 & 1) != 0 ? 150 : i10, (i20 & 2) != 0 ? 10 : i11, (i20 & 4) != 0 ? 150 : i12, (i20 & 8) != 0 ? 10 : i13, (i20 & 16) != 0 ? 150 : i14, (i20 & 32) != 0 ? 10 : i15, (i20 & 64) != 0 ? 150 : i16, (i20 & 128) != 0 ? 10 : i17, (i20 & 256) != 0 ? 50 : i18, (i20 & 512) != 0 ? 50 : i19);
    }
}
