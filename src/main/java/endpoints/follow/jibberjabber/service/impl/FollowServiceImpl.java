package endpoints.follow.jibberjabber.service.impl;

import endpoints.follow.jibberjabber.entity.Follow;
import endpoints.follow.jibberjabber.exception.FollowNotFoundException;
import endpoints.follow.jibberjabber.model.FollowCreateDTO;
import endpoints.follow.jibberjabber.model.FollowDTO;
import endpoints.follow.jibberjabber.repository.FollowRepository;
import endpoints.follow.jibberjabber.service.FollowService;
import lombok.val;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.logging.Logger;

@Service
public class FollowServiceImpl implements FollowService {

    private final Logger logger = Logger.getLogger(FollowServiceImpl.class.getName());

    private final FollowRepository followRepository;

    public FollowServiceImpl(FollowRepository followRepository) {
        this.followRepository = followRepository;
    }

    @Override
    public FollowDTO createFollow(FollowCreateDTO followCreateDTO) {
        logger.info("Creating follow");
        Follow follow = Follow.builder()
                .followerID(followCreateDTO.getFollower())
                .followedID(followCreateDTO.getFollowed())
                .build();

        logger.info("created follow: " + follow);

        return followRepository.save(follow).toDTO();
    }

    @Override
    public List<FollowDTO> getAllUsersFollowers(String user) {
        logger.info("Getting all followers for user: " + user);
        val follows= followRepository.findByFollowerID(user);
        logger.info("Got all followers for user: " + user);
        return follows.stream().map(Follow::toDTO).collect(java.util.stream.Collectors.toList());
    }


    @Override
    public void unfollow(String follower, String followed) {
        logger.info("Unfollowing user: " + followed);
        UUID follow = followRepository.findByFollowerIDAndFollowedID(follower,followed).getId();
        if (follow!=null) {
            followRepository.deleteById(follow);
            return;
        }
        throw new FollowNotFoundException(String.format("isn't following user named: %s", followed));
    }

    @Override
    public FollowDTO getFollowById(UUID uuid) {
        logger.info("Getting follow by id: " + uuid);
        if (followRepository.existsById(uuid)) {
            val follow = followRepository.findById(uuid);
            return follow.get().toDTO();
        }
        throw new FollowNotFoundException(String.format("No follow found for id: %s", uuid));

    }

}
