package edu.wctc.wholesale.dto;

public record OrderDto(
        String customerName,
        String purchaseDate,
        String purchaseOrderNumber,
        String productName,
        String terms,
        String shippedDate,
        Double productCost
) {
}
