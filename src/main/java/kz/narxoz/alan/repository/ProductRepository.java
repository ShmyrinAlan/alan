package kz.narxoz.alan.repository;

import kz.narxoz.alan.DTO.ProductDTO;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Optional;

@Repository
public class ProductRepository {
    private ArrayList<ProductDTO> productDTOS =  new ArrayList<>();
    private Long id = 1l;

    public ArrayList<ProductDTO> findAll() {
        return productDTOS;
    }
    public Optional<ProductDTO> findById(Long id) {
        return productDTOS.stream().filter(p -> p.getId().equals(id)).findFirst();
    }
    public ProductDTO save(ProductDTO productDTO) {
        productDTO.setId(id);
        id++;
        productDTOS.add(productDTO);
        return productDTO;
    }
    public ProductDTO update(ProductDTO productDTO) {
        productDTOS.removeIf(p -> p.getId().equals(productDTO.getId()));
        productDTOS.add(productDTO);
        return productDTO;
    }
    public boolean delete(Long id) {
        return productDTOS.removeIf(p -> p.getId().equals(id));
    }
}
