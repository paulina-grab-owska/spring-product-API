package com.example.gpc_p;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

////////////////////////////// Testy jednostkowe dla klasy GpcPApplication //////////////////////////

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
public class GpcPApplicationTests {

    @Autowired
    private MockMvc mockMvc;

    //  @throws Exception jeśli wystąpi błąd podczas wykonywania testu

    ////////// Test zwracający liczbę produktów //////////
    @Test
    public void testGetProductCount() throws Exception {
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/api/products/count")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();

        String content = result.getResponse().getContentAsString();
        int count = Integer.parseInt(content);
        assertEquals(7, count); // Zakładając, że w bazie danych znajduje się 7 produktów
    }

    ////////// Test zwracający listę wszystkich produktów //////////
    @Test
    public void testGetAllProducts() throws Exception {
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/api/products")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();
    }

    ////////// Test zwracający produkt o podanej nazwie //////////
    @Test
    public void testGetProductByName() throws Exception {
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/api/products/{name}", "apple")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();
    }
}

