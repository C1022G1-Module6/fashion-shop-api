package vn.codegym.dto.customer;

import java.util.Set;

public class CustomerTypeDTO {
    private Integer id;
    private String name;
    private String discount;
    private String gift;
    private Integer condition;
    private Integer bonusPoint;
    private Set<CustomerDTO> customerDTOS;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }

    public String getGift() {
        return gift;
    }

    public void setGift(String gift) {
        this.gift = gift;
    }

    public Integer getCondition() {
        return condition;
    }

    public void setCondition(Integer condition) {
        this.condition = condition;
    }

    public Integer getBonusPoint() {
        return bonusPoint;
    }

    public void setBonusPoint(Integer bonusPoint) {
        this.bonusPoint = bonusPoint;
    }

    public Set<CustomerDTO> getCustomerDTOS() {
        return customerDTOS;
    }

    public void setCustomerDTOS(Set<CustomerDTO> customerDTOS) {
        this.customerDTOS = customerDTOS;
    }
}
