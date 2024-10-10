package com.technical_test.application.services;
import com.technical_test.domain.Attributes.Attributes;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class AttributesServices {

    // Simulación de base de datos en memoria para pruebas
    private Map<String, Attributes> attributesDatabase = new HashMap<>();

    // Método para crear o actualizar atributos del cliente
    public Attributes createOrUpdateClientAttributes(Attributes attributes) {
        attributesDatabase.put(attributes.getClientId(), attributes);
        return attributes;
    }

    // Método para obtener atributos del cliente por ID
    public Attributes getClientAttributesById(String clientId) {
        return attributesDatabase.getOrDefault(clientId, null);
    }
}
