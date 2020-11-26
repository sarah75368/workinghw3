package states;

import common.Appearance;

public interface State<C extends Appearance<C>> {
    void printStatus();
}