package com.ramesh.eCommerce.models;

import com.ramesh.eCommerce.domain.OrderStatus;
import com.ramesh.eCommerce.domain.PaymentStatus;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String orderId;

    @ManyToOne
    private User user;

    private Long sellerId;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<OrderItem> orderItems = new ArrayList<>();

    @ManyToOne
    private Address shippingAddress;

    @Embedded
    private PaymentDetails paymentDetails = new PaymentDetails();

    private double totalMrpPrice;

    private Integer totalSellingPrice;

    private Integer discount;

    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;

    private int totalItems;

    @Enumerated(EnumType.STRING)
    private PaymentStatus paymentStatus = PaymentStatus.PENDING;

    private LocalDateTime orderDate = LocalDateTime.now();

    private LocalDateTime deliverDate = orderDate.plusDays(7);
}
