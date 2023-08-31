package com.example.requestsservice.domain;

import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
@Builder
@Entity
@Table(name = "maint_copy")
public class MaintCopy {

    @Id
    @Column(name = "maint_id")
    private Long maintId;

    @Column(name = "maint_identifier", unique = true)
    private String maintIdentifier;
}
