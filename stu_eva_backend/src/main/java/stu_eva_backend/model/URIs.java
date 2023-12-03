package stu_eva_backend.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class URIs {

    @Id
    private Integer id;
    private String node_URI;
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getNode_URI() {
        return node_URI;
    }
    public void setNode_URI(String node_URI) {
        this.node_URI = node_URI;
    }


    // getters and setters
}
