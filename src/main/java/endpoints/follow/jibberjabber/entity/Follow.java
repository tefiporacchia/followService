package endpoints.follow.jibberjabber.entity;

import endpoints.follow.jibberjabber.model.FollowDTO;
import lombok.*;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;


@Entity
@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Follow {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @NotNull
    @NotEmpty
    private String followerID;

    @NotNull
    @NotEmpty
    private String followedID;

    public FollowDTO toDTO() {
        return FollowDTO.builder()
                .id(id)
                .follower(followerID)
                .followed(followedID)
                .build();
    }

}