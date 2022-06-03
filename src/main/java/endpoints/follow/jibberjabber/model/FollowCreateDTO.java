package endpoints.follow.jibberjabber.model;

import lombok.*;

@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FollowCreateDTO {

    private String follower;
    private String followed;

}
