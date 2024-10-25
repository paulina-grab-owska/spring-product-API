package com.example.gpc_p.service;

import com.example.gpc_p.model.Product;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.InputStream;
import java.util.List;


/////////////////////////////  Serwis obsługujący operacje na produktach //////////////////////////

@Service
public class ProductService {
    private List<Product> products;

    ///////// Inicjalizacja serwisu, wczytanie produktów z pliku XML /////////
    @PostConstruct
    public void init() {
        try {
            loadProductsFromFile("/products.xml");
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    /////////  Wczytywanie produktów z pliku XML /////////

    //  @param filePath ścieżka do pliku XML
    //  @throws JAXBException wyjątek rzucany w przypadku problemów z parsowaniem XML
    public void loadProductsFromFile(String filePath) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(Product.class, Products.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        InputStream inputStream = getClass().getResourceAsStream(filePath);
        if (inputStream == null) {
            throw new IllegalArgumentException("File not found: " + filePath);
        }
        Products productsWrapper = (Products) unmarshaller.unmarshal(inputStream);
        this.products = productsWrapper.getProducts();
    }


    ///////// Pobranie liczby produktów /////////
    public int getProductCount() {
        return products.size();
    }


    ///////// Pobranie listy wszystkich produktów /////////
    public List<Product> getAllProducts() {
        return products;
    }


    ///////// Pobranie produktu po nazwie /////////

    //@param name nazwa produktu
    // @return produkt o podanej nazwie lub null, jeśli nie istnieje
    public Product getProductByName(String name) {
        return products.stream()
                .filter(product -> product.getName().equalsIgnoreCase(name))
                .findFirst()
                .orElse(null);
    }
}

/////////////////  Klasa pomocnicza reprezentująca listę produktów w pliku XML  ////////////////
@XmlRootElement(name = "Products")
class Products {
    private List<Product> products;

    @XmlElement(name = "Product")
    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}