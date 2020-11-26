package common;

import states.*;

public interface Appearance<C extends Appearance<C>> {

    public void setState(State<C> state);
    public State<C> getState();
}
