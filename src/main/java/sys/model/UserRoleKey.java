package sys.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="user_role")
public class UserRoleKey implements Serializable{

    private static final long serialVersionUID = 4468527067463947132L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="userId")
    private Long userId;

    @Column(name="roleId")
    private Long roleId;


    public UserRoleKey(Long userId, Long roleId) {
        this.userId = userId;
        this.roleId = roleId;
    }


    public Long getUserId() {
        return userId;
    }


    public Long getRoleId() {
        return roleId;
    }
}