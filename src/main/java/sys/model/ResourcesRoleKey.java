package sys.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "resources_role")
public class ResourcesRoleKey implements Serializable{

    private static final long serialVersionUID = 6635158511195896351L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "rescId")
    private Integer rescId;

    @Column(name = "roleId")
    private Integer roleId;

    public ResourcesRoleKey() {

    }
    public ResourcesRoleKey(Integer rescId, Integer roleId) {
        this.rescId = rescId;
        this.roleId = roleId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setRescId(Integer rescId) {
        this.rescId = rescId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public Integer getRescId() {
        return rescId;
    }


    public Integer getRoleId() {
        return roleId;
    }
}