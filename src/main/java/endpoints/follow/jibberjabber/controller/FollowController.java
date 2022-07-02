package endpoints.follow.jibberjabber.controller;

import endpoints.follow.jibberjabber.model.FollowCreateDTO;
import endpoints.follow.jibberjabber.service.FollowService;
import lombok.val;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.metrics.annotation.Timed;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;

@RestController
@RequestMapping("/follow")
@Timed("follows_controller_time")
public class FollowController {

    private final FollowService followService;

    public FollowController(FollowService followService) {
        this.followService = followService;
    }

    @PostMapping
    public ResponseEntity<?> follow(@Valid @RequestBody FollowCreateDTO followCreateDTO) {
        val createdFollow = followService.createFollow(followCreateDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdFollow);
    }

    @GetMapping("/all/{user}")
    public ResponseEntity<?> getAllUsersFollowers (@PathVariable String user) {
        val followers = followService.getAllUsersFollowers(user);
        return ResponseEntity.status(HttpStatus.OK).body(followers);
    }

    @DeleteMapping("/unfollow/{follower}/{following}")
    public ResponseEntity<?> unfollow(@PathVariable String follower,@PathVariable String following ) {
        followService.unfollow(follower,following);
        return ResponseEntity.noContent().build(); //sacar el follower de aca
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getFollowById(@PathVariable UUID id) {
        val follow = followService.getFollowById(id);
        return ResponseEntity.status(HttpStatus.OK).body(follow);
    }

}