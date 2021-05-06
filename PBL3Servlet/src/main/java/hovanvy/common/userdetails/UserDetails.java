package hovanvy.common.userdetails;

/**
 *
 * @author hovanvydut
 */
public interface UserDetails {
    String getPassword();
    String getUsername();
    boolean isEnabled();
}
