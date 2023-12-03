package stu_eva_backend.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import stu_eva_backend.model.Role;
import stu_eva_backend.model.Node;
import java.util.List;
import stu_eva_backend.repository.RoleRepository;

@RestController
@RequestMapping("/routes")
public class RouteController {

    private final RoleRepository roleRepository;

    public RouteController(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @GetMapping("/{roleId}")
    public List<Node> getRoutesByRoleId(@PathVariable Integer roleId) {
        Role role = roleRepository.findById(roleId)
                .orElseThrow(() -> new RuntimeException("Role not found"));
        return role.getRoutes();
    }
}
