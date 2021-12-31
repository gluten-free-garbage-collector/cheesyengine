package stuff.ichzeigdirmalwas;

import transform.SimpleTransform;

public class Stall {

    private BatchRenderObject stallRO;
    private SimpleTransform t;

    public Stall(BatchRenderObject stallRO, SimpleTransform t) {
        this.stallRO = stallRO;
        this.t = t;
        stallRO.addTransform(t);
    }

    public SimpleTransform getT() {
        return t;
    }
}
