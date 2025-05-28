package behavioral.iterator;

import java.util.List;

public class FaceBookIterator implements ProfileIterator{
    private List<Profile> profiles;
    private int current = 0;

    public FaceBookIterator(List<Profile> profiles) {
        this.profiles = profiles != null ? profiles : List.of();
    }

    @Override
    public boolean hasNext() {
        return current < profiles.size();
    }

    @Override
    public Profile getNext() {
        return hasNext() ? profiles.get(current++) : null;
    }
}
