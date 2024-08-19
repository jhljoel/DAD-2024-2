package com.example.mscatalogo.controller;

import com.example.mscatalogo.entity.Category;
import com.example.mscatalogo.service.CategoryService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/Category")
public class CategoryController {
    @Autowired
    private CategoryService CategoryService;

    @GetMapping
    public ResponseEntity<List<Category>> listar() {
        return ResponseEntity.ok(CategoryService.listar());
    }

    @PostMapping
    public ResponseEntity<Category> guardar(@RequestBody Category Category) {
        return ResponseEntity.ok(CategoryService.guardar(Category));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Category> buscarPorId(@PathVariable(required = true) Integer id) {
        return ResponseEntity.ok(CategoryService.buscarPorId(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Category> editar(@PathVariable(required = true) Integer id,
                                           @RequestBody Category Category) {
        Category.setId(id);
        return ResponseEntity.ok(CategoryService.editar(Category));

    }

    @DeleteMapping("/{id}")
    public String eliminar(@PathVariable(required = true) Integer id) {
        CategoryService.eliminar(id);
        return "Eliminacion correcta";
    }

}
