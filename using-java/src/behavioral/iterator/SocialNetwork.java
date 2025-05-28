package behavioral.iterator;

public interface SocialNetwork {
    ProfileIterator createFriendsIterator(String profileEmail);
    ProfileIterator createColleaguesIterator(String profileEmail);
}
