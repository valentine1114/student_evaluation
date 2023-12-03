package stu_eva_backend.model;


import javax.persistence.*;

@Entity
@Table(name = "role_URI")
public class Backaccess {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;

    @ManyToOne
    @JoinColumn(name = "URI_id")
    private URIs URI;

 
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    
    
    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public URIs getURI() {
        return URI;
    }

    public void setURI(URIs uRI) {
        URI = uRI;
    }



}

