package endpoints.follow.jibberjabber.repository;


import endpoints.follow.jibberjabber.entity.Follow;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface FollowRepository extends JpaRepository<Follow, UUID> {
    List<Follow> findByFollowerID(String user);
    Follow findByFollowerIDAndFollowedID(String follower, String followed);

    default UUID findIDByFollower(String follower, String followed) {
        return findByFollowerIDAndFollowedID(follower, followed).getId();
    }
}