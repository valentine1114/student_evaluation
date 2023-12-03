package stu_eva_backend.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Role {

    @Id
    private Integer id;
    private String name;

    @ManyToMany
    @JoinTable(
            name = "role_node",
            joinColumns = @JoinColumn(name = "role_id"),
            inverseJoinColumns = @JoinColumn(name = "node_id")
    )
    private List<Node> routes;



    @ManyToMany
    @JoinTable(
            name = "role_uri",
            joinColumns = @JoinColumn(name = "role_id"),
            inverseJoinColumns = @JoinColumn(name = "URI_id")
    )
    private List<URIs> back_routes;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<Node> getRoutes() {
        return routes;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRoutes(List<Node> routes) {
        this.routes = routes;
    }

    public List<URIs> getBack_routes() {
        return back_routes;
    }

    public void setBack_routes(List<URIs> back_routes) {
        this.back_routes = back_routes;
    }

    // getters and setters
}
