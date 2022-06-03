package endpoints.follow.jibberjabber.service;
import endpoints.follow.jibberjabber.model.FollowCreateDTO;
import endpoints.follow.jibberjabber.model.FollowDTO;
import endpoints.follow.jibberjabber.model.FollowDTO;

import java.util.List;
import java.util.UUID;

public interface FollowService {
    FollowDTO createFollow(FollowCreateDTO followCreateDTO);

    List<FollowDTO> getAllUsersFollowers(String user);

    void unfollow(String follower, String followed);

    FollowDTO getFollowById(UUID uuid);

}
