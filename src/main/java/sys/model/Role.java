package sys.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "role")
public class Role implements Serializable{

    private static final long serialVersionUID = -4009171958775925270L;
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "roleKey")
    private String roleKey;

    @Column(name = "description")
    private String description;
    
    @Column(name = "enable")
    private Integer enable;


    public Role(Integer id, String name, String roleKey, String description, Integer enable) {
        this.id = id;
        this.name = name;
        this.roleKey = roleKey;
        this.description = description;
        this.enable = enable;
    }


    public Integer getId() {
        return id;
    }


    public String getName() {
        return name;
    }

    public String getroleKey() {
        return roleKey;
    }


    public String getDescription() {
        return description;
    }

 
    public Integer getEnable() {
        return enable;
    }
}