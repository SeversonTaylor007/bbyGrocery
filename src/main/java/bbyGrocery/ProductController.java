package bbyGrocery;

import java.util.List;

import org.springframework.web.bind.annotation.*;

@RestController
class ProductController {

    private final ProductRepo repository;

    ProductController(ProductRepo repository) {
        this.repository = repository;
    }



    @GetMapping("/products")
    List<Product> all(@RequestParam(required = false, defaultValue = "100") Integer limit) {
        List<Product> name=repository.findAll();

        return name.subList(0, limit);
    }


    @PostMapping("/products")
    Product newProduct(@RequestBody Product newProduct) {
        return repository.save(newProduct);
    }



    @GetMapping("/products/{id}")
    Product one(@PathVariable Long id) {

        return repository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException(id));
    }

    @PutMapping("/products/{id}")
    Product replaceProduct(@RequestBody Product newProduct, @PathVariable Long id) {

        return repository.findById(id)
                .map(product -> {
                    product.setName(newProduct.getName());
                    product.setQuantity(newProduct.getQuantity());
                    product.setPrice(newProduct.getPrice());

                    return repository.save(product);
                })
                .orElseGet(() -> {
                    newProduct.setId(id);
                    return repository.save(newProduct);
                });
    }

    @DeleteMapping("/products/{id}")
    void deleteProduct(@PathVariable Long id) {
        repository.deleteById(id);
    }


}