package structural.proxy;

public class RealEntity implements Entity {
    private String data;

    public RealEntity(String data) {
        this.data = data;
    }

    @Override
    public void setData(String data) {
        this.data = data;
    }

    @Override
    public String getData() {
        return data;
    }
}
