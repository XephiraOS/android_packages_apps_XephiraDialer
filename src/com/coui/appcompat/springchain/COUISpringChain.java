package com.coui.appcompat.springchain;

import c4.d;
import c4.g;
import c4.h;
import c4.i;
import c4.j;
import c4.l;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes.dex */
public class COUISpringChain implements j {
    private static final int DEFAULT_ATTACHMENT_FRICTION = 10;
    private static final int DEFAULT_ATTACHMENT_TENSION = 70;
    private static final int DEFAULT_MAIN_FRICTION = 6;
    private static final int DEFAULT_MAIN_TENSION = 40;
    private final h mAttachmentSpringConfig;
    private int mControlSpringIndex;
    private final CopyOnWriteArrayList<j> mListeners;
    private final h mMainSpringConfig;
    private final l mSpringSystem;
    private final CopyOnWriteArrayList<g> mSprings;
    private static final i registry = i.c();
    private static int id = 0;

    private COUISpringChain(l lVar) {
        this(lVar, 40, 6, 70, 10);
    }

    public static COUISpringChain create(l lVar) {
        return new COUISpringChain(lVar);
    }

    public COUISpringChain addSpring(j jVar) {
        d dVar = new d(this.mSpringSystem);
        dVar.a(this).q(this.mAttachmentSpringConfig).p(0.1d).o(0.1d);
        this.mSprings.add(dVar);
        this.mListeners.add(jVar);
        return this;
    }

    public List<j> getAllListeners() {
        return this.mListeners;
    }

    public List<g> getAllSprings() {
        return this.mSprings;
    }

    public h getAttachmentSpringConfig() {
        return this.mAttachmentSpringConfig;
    }

    public g getControlSpring() {
        return this.mSprings.get(this.mControlSpringIndex);
    }

    public h getMainSpringConfig() {
        return this.mMainSpringConfig;
    }

    @Override // c4.j
    public void onSpringActivate(g gVar) {
        CopyOnWriteArrayList<j> copyOnWriteArrayList;
        int indexOf;
        CopyOnWriteArrayList<g> copyOnWriteArrayList2 = this.mSprings;
        if (copyOnWriteArrayList2 != null && !copyOnWriteArrayList2.isEmpty() && (copyOnWriteArrayList = this.mListeners) != null && !copyOnWriteArrayList.isEmpty() && (indexOf = this.mSprings.indexOf(gVar)) >= 0 && indexOf < this.mListeners.size()) {
            this.mListeners.get(indexOf).onSpringActivate(gVar);
        }
    }

    @Override // c4.j
    public void onSpringAtRest(g gVar) {
        CopyOnWriteArrayList<j> copyOnWriteArrayList;
        int indexOf;
        CopyOnWriteArrayList<g> copyOnWriteArrayList2 = this.mSprings;
        if (copyOnWriteArrayList2 != null && !copyOnWriteArrayList2.isEmpty() && (copyOnWriteArrayList = this.mListeners) != null && !copyOnWriteArrayList.isEmpty() && (indexOf = this.mSprings.indexOf(gVar)) >= 0 && indexOf < this.mListeners.size()) {
            this.mListeners.get(indexOf).onSpringAtRest(gVar);
        }
    }

    @Override // c4.j
    public void onSpringEndStateChange(g gVar) {
        CopyOnWriteArrayList<j> copyOnWriteArrayList;
        int indexOf;
        CopyOnWriteArrayList<g> copyOnWriteArrayList2 = this.mSprings;
        if (copyOnWriteArrayList2 != null && !copyOnWriteArrayList2.isEmpty() && (copyOnWriteArrayList = this.mListeners) != null && !copyOnWriteArrayList.isEmpty() && (indexOf = this.mSprings.indexOf(gVar)) >= 0 && indexOf < this.mListeners.size()) {
            this.mListeners.get(indexOf).onSpringEndStateChange(gVar);
        }
    }

    @Override // c4.j
    public void onSpringUpdate(g gVar) {
        CopyOnWriteArrayList<j> copyOnWriteArrayList;
        int indexOf;
        int i10;
        int i11;
        CopyOnWriteArrayList<g> copyOnWriteArrayList2 = this.mSprings;
        if (copyOnWriteArrayList2 != null && !copyOnWriteArrayList2.isEmpty() && (copyOnWriteArrayList = this.mListeners) != null && !copyOnWriteArrayList.isEmpty() && (indexOf = this.mSprings.indexOf(gVar)) >= 0 && indexOf < this.mListeners.size()) {
            j jVar = this.mListeners.get(indexOf);
            int i12 = this.mControlSpringIndex;
            if (indexOf == i12) {
                i11 = indexOf - 1;
                i10 = indexOf + 1;
            } else if (indexOf < i12) {
                i11 = indexOf - 1;
                i10 = -1;
            } else {
                i10 = indexOf + 1;
                i11 = -1;
            }
            if (i10 > -1 && i10 < this.mSprings.size()) {
                g gVar2 = this.mSprings.get(i10);
                if (!gVar.i() && !gVar2.i()) {
                    this.mSprings.get(i10).n(gVar.c());
                }
            }
            if (i11 > -1 && i11 < this.mSprings.size()) {
                g gVar3 = this.mSprings.get(i11);
                if (!gVar.i() && !gVar3.i()) {
                    this.mSprings.get(i11).n(gVar.c());
                }
            }
            jVar.onSpringUpdate(gVar);
        }
    }

    public COUISpringChain setControlSpringIndex(int i10) {
        this.mControlSpringIndex = i10;
        if (this.mSprings.get(i10) == null) {
            return null;
        }
        Iterator<g> it = this.mSpringSystem.d().iterator();
        while (it.hasNext()) {
            it.next().q(this.mAttachmentSpringConfig);
        }
        getControlSpring().q(this.mMainSpringConfig);
        return this;
    }

    private COUISpringChain(l lVar, int i10, int i11, int i12, int i13) {
        this.mListeners = new CopyOnWriteArrayList<>();
        this.mSprings = new CopyOnWriteArrayList<>();
        this.mControlSpringIndex = -1;
        this.mSpringSystem = lVar;
        h b10 = h.b(i10, i11);
        this.mMainSpringConfig = b10;
        h b11 = h.b(i12, i13);
        this.mAttachmentSpringConfig = b11;
        i iVar = registry;
        StringBuilder sb = new StringBuilder();
        sb.append("main spring ");
        int i14 = id;
        id = i14 + 1;
        sb.append(i14);
        iVar.a(b10, sb.toString());
        StringBuilder sb2 = new StringBuilder();
        sb2.append("attachment spring ");
        int i15 = id;
        id = i15 + 1;
        sb2.append(i15);
        iVar.a(b11, sb2.toString());
    }

    public static COUISpringChain create(l lVar, int i10, int i11, int i12, int i13) {
        return new COUISpringChain(lVar, i10, i11, i12, i13);
    }
}
