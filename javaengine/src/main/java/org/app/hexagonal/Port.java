package org.app.hexagonal;

public class Port <M> implements IPort<M> {

    private M module;
    private Adapter adapter;

    @Override
    public void setModule(M module) {
        this.module = module;
    }

    @Override
    public M getModule() {
        return this.module;
    }

    @Override
    public void setAdapter(Adapter adapter) {
        this.adapter = adapter;
    }

    @Override
    public Adapter getAdapter() {
        return adapter;
    }

    @Override
    public int isEmpty() {
        return  (this.module != null ? PortStatus.HAS_MODULE : 0) |
                (this.adapter != null ? PortStatus.HAS_ADAPTER : 0);
    }
}
