package com.technical_test.infrastructure.controllers;
import com.technical_test.domain.Attributes.Attributes;
import com.technical_test.application.services.AttributesServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/client-attributes")
public class AttributesController {

    @Autowired
    private AttributesServices clientAttributesService;

    // Ruta para crear o actualizar los atributos de un cliente
    @PostMapping
    public String createOrUpdateClientAttributes(@RequestBody Attributes attributes) {
        clientAttributesService.createOrUpdateClientAttributes(attributes);
        return "Atributos del cliente guardados/actualizados correctamente.";
    }

    // Ruta para obtener los atributos de un cliente por ID
    @GetMapping("/{clientId}")
    public Attributes getClientAttributesById(@PathVariable String clientId) {
        return clientAttributesService.getClientAttributesById(clientId);
    }
}
