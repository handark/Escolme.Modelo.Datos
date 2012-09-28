package mantis.modelo.datos;

import java.sql.Date;

/**
 *
 * @author Jose Luis Orozco Mejia
 */
public class MantisUserTableAC {
    
    private String username;
    private String realname;
    private String email;
    private String password;
    private int enabled;
    private int protected_;
    private int access_level;
    private int login_count;
    private int lost_password_request_count;
    private int failed_login_count;
    private String cookie_string;
    private int last_visit;
    private int date_created;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getEnabled() {
        return enabled;
    }

    public void setEnabled(int enabled) {
        this.enabled = enabled;
    }

    public int getProtected_() {
        return protected_;
    }

    public void setProtected_(int protected_) {
        this.protected_ = protected_;
    }

    public int getAccess_level() {
        return access_level;
    }

    public void setAccess_level(int access_level) {
        this.access_level = access_level;
    }

    public int getLogin_count() {
        return login_count;
    }

    public void setLogin_count(int login_count) {
        this.login_count = login_count;
    }

    public int getLost_password_request_count() {
        return lost_password_request_count;
    }

    public void setLost_password_request_count(int lost_password_request_count) {
        this.lost_password_request_count = lost_password_request_count;
    }

    public int getFailed_login_count() {
        return failed_login_count;
    }

    public void setFailed_login_count(int failed_login_count) {
        this.failed_login_count = failed_login_count;
    }

    public String getCookie_string() {
        return cookie_string;
    }

    public void setCookie_string(String cookie_string) {
        this.cookie_string = cookie_string;
    }

    public int getLast_visit() {
        return last_visit;
    }

    public void setLast_visit(int last_visit) {
        this.last_visit = last_visit;
    }

    public int getDate_created() {
        return date_created;
    }

    public void setDate_created(int date_created) {
        this.date_created = date_created;
    }
}
