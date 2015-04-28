package Term2;

import java.util.List;

/**
 * Created by Ilgiz on 27.04.2015.
 */
public class Components implements ComponentInterface<Integer>{
    private List<List<Integer>> components;

    public void add(List<Integer> component){
        components.add(component);
    }
    public Components(List<List<Integer>> components) {
        this.components = components;
    }

    @Override
    public String toString() {
        return components.toString() ;
    }
}
