package stu_eva_backend.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Node {

    @Id
    private Integer id;
    private String node_path;
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getNode_path() {
        return node_path;
    }
    public void setNode_path(String node_path) {
        this.node_path = node_path;
    }

    // getters and setters
}
