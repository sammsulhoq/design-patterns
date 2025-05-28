package iterator;

import java.util.*;

public class FaceBook implements SocialNetwork{
    private Map<String, List<Profile>> friendsMap = new HashMap<>();

    public void addFriends(String email, List<Profile> friends) {
        friendsMap.put(email, friends);
    }

    @Override
    public ProfileIterator createFriendsIterator(String profileEmail) {
        return new FaceBookIterator(friendsMap.get(profileEmail));
    }

    @Override
    public ProfileIterator createColleaguesIterator(String profileEmail) {
        List<Profile> allProfile = friendsMap.get(profileEmail);
        String company = allProfile != null && !allProfile.isEmpty() ? allProfile.get(0).getCompany() : "";
        List<Profile> colleagues = new ArrayList<>();

        if (allProfile != null) {
            for(Profile profile: allProfile) {
                if(company.equals(profile.getCompany())) {
                    colleagues.add(profile);
                }
            }
        }

        return new FaceBookIterator(colleagues);
    }
}
