package states;

import common.Context;

public interface State<C extends Context<C>> {
    void printStatus(String name);
    
}