package hovanvy.common.userdetails;

import hovanvy.entity.Customer;

/**
 *
 * @author hovanvydut
 */
public interface UserDetails {
    String getPassword();
    String getUsername();
    boolean isEnabled();
    Customer getUser();
}
