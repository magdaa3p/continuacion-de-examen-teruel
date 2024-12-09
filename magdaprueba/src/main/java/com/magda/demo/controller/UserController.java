package com.magda.demo.controller;
import com.magda.demo.model.User;
import com.magda.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@Controller
@RequestMapping("/usuarios")
public class UserController {
@Autowired
private UserService userService;
@GetMapping
public String listarUsuarios(Model model) {
List<User> usuarios = userService.findAll();
model.addAttribute("usuarios", usuarios);
return "usuarios/lista";
}
@GetMapping("/nuevo")
public String mostrarFormularioDeRegistro(Model model) {
model.addAttribute("usuario", new User());
return "usuarios/nuevo";
}
@PostMapping
public String guardarUsuario(@ModelAttribute User usuario) {
userService.save(usuario);
return "redirect:/usuarios";
}
@GetMapping("/editar/{id}")
public String mostrarFormularioDeEdicion(@PathVariable Long id, Model model) {
User usuario = userService.findById(id);
if (usuario == null) {
throw new IllegalArgumentException("Usuario no encontrado");
}
model.addAttribute("usuario", usuario);
return "usuarios/editar";
}
@PostMapping("/editar/{id}")

public String actualizarUsuario(@PathVariable Long id, @ModelAttribute User usuario) {
usuario.setId(id);
userService.save(usuario);
return "redirect:/usuarios";
}
@GetMapping("/eliminar/{id}")
public String eliminarUsuario(@PathVariable Long id) {
userService.deleteById(id);
return "redirect:/usuarios";
}
}