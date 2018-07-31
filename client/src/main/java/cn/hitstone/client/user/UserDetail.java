package cn.hitstone.client.user;

import java.io.Serializable;
import java.util.Set;

public class UserDetail implements Serializable {

    private String id;

    private boolean accountNonExpired;

    private boolean accountNonLocked;

    private boolean credentialsNonExpired;

    private Long userId;

    private boolean enabled;

    private UserPassword              userPassword;

    private User                      user;

//    @OneToMany(fetch=FetchType.EAGER)
//    @JoinColumn(name="userId", referencedColumnName="userId", foreignKey = @ForeignKey(name = "none", value = ConstraintMode.NO_CONSTRAINT),insertable = false,updatable = false)
//    private Set<UserAuthority> userAuthorities;

    private Set<Authority> authorities;

    private Set<UserAccount> userAccounts;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public boolean isAccountNonExpired() {
        return accountNonExpired;
    }

    public void setAccountNonExpired(boolean accountNonExpired) {
        this.accountNonExpired = accountNonExpired;
    }

    public boolean isAccountNonLocked() {
        return accountNonLocked;
    }

    public void setAccountNonLocked(boolean accountNonLocked) {
        this.accountNonLocked = accountNonLocked;
    }

    public boolean isCredentialsNonExpired() {
        return credentialsNonExpired;
    }

    public void setCredentialsNonExpired(boolean credentialsNonExpired) {
        this.credentialsNonExpired = credentialsNonExpired;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public UserPassword getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(UserPassword userPassword) {
        this.userPassword = userPassword;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Set<Authority> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(Set<Authority> authorities) {
        this.authorities = authorities;
    }

    public Set<UserAccount> getUserAccounts() {
        return userAccounts;
    }

    public void setUserAccounts(Set<UserAccount> userAccounts) {
        this.userAccounts = userAccounts;
    }

//    public Set<UserAuthority> getUserAuthorities() {
//        return userAuthorities;
//    }
//
//    public void setUserAuthorities(Set<UserAuthority> userAuthorities) {
//        this.userAuthorities = userAuthorities;
//    }
}
