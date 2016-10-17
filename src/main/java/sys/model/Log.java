package sys.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

public class Log {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column log.id
     *
     * @mbggenerated
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column log.username
     *
     * @mbggenerated
     */
    private String username;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column log.module
     *
     * @mbggenerated
     */
    private String module;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column log.action
     *
     * @mbggenerated
     */
    private String action;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column log.actionTime
     *
     * @mbggenerated
     */
    private String actiontime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column log.userIP
     *
     * @mbggenerated
     */
    private String userip;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column log.operTime
     *
     * @mbggenerated
     */
    private Date opertime;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table log
     *
     * @mbggenerated
     */
    public Log(Integer id, String username, String module, String action, String actiontime, String userip, Date opertime) {
        this.id = id;
        this.username = username;
        this.module = module;
        this.action = action;
        this.actiontime = actiontime;
        this.userip = userip;
        this.opertime = opertime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column log.id
     *
     * @return the value of log.id
     *
     * @mbggenerated
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column log.username
     *
     * @return the value of log.username
     *
     * @mbggenerated
     */
    public String getUsername() {
        return username;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column log.module
     *
     * @return the value of log.module
     *
     * @mbggenerated
     */
    public String getModule() {
        return module;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column log.action
     *
     * @return the value of log.action
     *
     * @mbggenerated
     */
    public String getAction() {
        return action;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column log.actionTime
     *
     * @return the value of log.actionTime
     *
     * @mbggenerated
     */
    public String getActiontime() {
        return actiontime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column log.userIP
     *
     * @return the value of log.userIP
     *
     * @mbggenerated
     */
    public String getUserip() {
        return userip;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column log.operTime
     *
     * @return the value of log.operTime
     *
     * @mbggenerated
     */
    public Date getOpertime() {
        return opertime;
    }
}