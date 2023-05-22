package org.app.hexagonal;

public interface IPort<M> {
    public void setModule(M module);
    public M getModule();

    public void setAdapter(Adapter adapter);
    public Adapter getAdapter();

    public int isEmpty();

}
