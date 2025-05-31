package structural.proxy;

public class EntityProxy implements Entity {
    private RealEntity realEntity;
    private boolean isModified = false;

    public EntityProxy(String data) {
        this.realEntity = new RealEntity(data);
    }

    @Override
    public void setData(String data) {
        isModified = true;
        realEntity.setData(data);
    }

    @Override
    public String getData() {
        return realEntity.getData();
    }

    public boolean isModified() {
        return isModified;
    }

    public RealEntity getRealEntity() {
        return realEntity;
    }
}
