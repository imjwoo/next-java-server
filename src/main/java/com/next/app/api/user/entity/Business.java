package com.next.app.api.user.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "business_jeongwoo")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Business {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String businessNumber;

    @Column(nullable = false)
    private String companyName;

    @Column
    private String representativeName;

    @Column
    private String contactEmail;

    @Column
    private String contactPhone;

    @Column
    private String address;

    @Column(name = "registered_at")
    private java.time.LocalDateTime registeredAt;

    @PrePersist
    protected void onCreate() {
        registeredAt = java.time.LocalDateTime.now();
    }
}
