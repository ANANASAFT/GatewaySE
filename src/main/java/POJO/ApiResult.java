package POJO;

/**
 * @author: Toon
 * @create: 2019-12-22 10:40
 **/
public class ApiResult {
    private Object data;

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public ApiResult(Object data){
        this.data = data;
    }
}
