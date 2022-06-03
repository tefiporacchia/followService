package endpoints.follow.jibberjabber.exception;

public class FollowNotFoundException extends RuntimeException{
    public FollowNotFoundException(String message) {
        super(message);
    }
}
