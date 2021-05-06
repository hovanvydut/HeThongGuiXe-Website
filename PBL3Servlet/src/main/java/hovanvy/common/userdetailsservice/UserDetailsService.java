package hovanvy.common.userdetailsservice;

import hovanvy.common.exceptions.UsernameNotFoundException;
import hovanvy.common.userdetails.UserDetails;

/**
 *
 * @author hovanvydut
 */

public interface UserDetailsService {
    
    UserDetails loadUserByUsername(String username) throws UsernameNotFoundException ;
    
}
