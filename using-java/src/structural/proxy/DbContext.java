package structural.proxy;

import java.util.ArrayList;
import java.util.List;

public class DbContext {
    private List<EntityProxy> trackedEntities = new ArrayList<>();

    public void trackEntity(EntityProxy entity) {
        trackedEntities.add(entity);
    }

    public void saveChanges() {
        for (EntityProxy entityProxy : trackedEntities) {
            if (entityProxy.isModified()) {
                persistToDatabase(entityProxy.getRealEntity());
            }
        }
    }

    private void persistToDatabase(RealEntity entity) {
        // Simulate saving to the database
        System.out.println("Persisting: " + entity.getData());
    }
}
