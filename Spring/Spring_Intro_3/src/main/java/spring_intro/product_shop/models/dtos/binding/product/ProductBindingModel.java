package spring_intro.product_shop.models.dtos.binding.product;

import java.io.Serializable;
import java.math.BigDecimal;

public class ProductBindingModel implements Serializable {
    private String name;
    private BigDecimal price;
    private Long buyer;
    private Long seller;

    public ProductBindingModel() {
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return this.price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Long getBuyer() {
        return this.buyer;
    }

    public void setBuyer(Long buyer) {
        this.buyer = buyer;
    }

    public Long getSeller() {
        return this.seller;
    }

    public void setSeller(Long seller) {
        this.seller = seller;
    }
}
