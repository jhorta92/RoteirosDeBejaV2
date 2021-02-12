package pt.ipbeja.estig.twdm.roteirosdebeja;

public class BaseResponse<T> {

    private T data;

    public BaseResponse(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
