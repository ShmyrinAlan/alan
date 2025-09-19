package kz.narxoz.alan.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class ProductDTO {
    private Long id;
    private String title;
    private String description;
    private String price;
    private String imageUrl;
}
