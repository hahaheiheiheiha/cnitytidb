package cn.project.springbootcurrency.pojo;

public class qwe {
    private int statuCode;//状态码
    private String message;//信息
    private Object data;//返回结果
    private int count;

    public int getCount() {
        return count;
    }

    public int getStatuCode() {
        return statuCode;
    }

    public void setStatuCode(int statuCode) {
        this.statuCode = statuCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
