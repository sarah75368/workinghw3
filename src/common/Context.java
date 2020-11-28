package common;

import states.*;

public interface Context <C extends Context<C>> {

    public void setState(State<C> state);
    public State<C> getState();
}
