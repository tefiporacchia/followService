package endpoints.follow.jibberjabber.model;
import endpoints.follow.jibberjabber.entity.Follow;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FollowDTO {

    private UUID id;

    private String follower;

    private String followed;


}