package TooltipFrameWork;

import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;

public class ListInfo<T> {

    private List<T> objects;
    private String headerName;
    private Function<T,String> function;

    public ListInfo(List<T> objects, String headerName, Function<T,String> function)
    {
        this.objects=objects;
        this.headerName=headerName;
        this.function=function;
    }

    public List<T> getObjects() {
        return objects;
    }

    public String getHeaderName() {
        return headerName;
    }

    public Function<T, String> getFunction() {
        return function;
    }
}
