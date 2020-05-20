package com.fly.persistence.entity.general;

import com.fly.persistence.entity.user.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToOne;
import java.time.Instant;

@Getter
@Setter
@NoArgsConstructor
@MappedSuperclass
public abstract class IdEntityCreatedUpdated extends IdEntity {

    @CreatedBy
    @OneToOne
    @JoinColumn(name = "created_by_id")
    private User createdBy;

    @CreatedDate
    @Column(nullable = false)
    private Instant createdAt;

    @LastModifiedBy
    @OneToOne
    @JoinColumn(name = "updated_by_id")
    private User updatedBy;

    @LastModifiedDate
    @Column(nullable = false)
    private Instant updatedAt;

    public IdEntityCreatedUpdated(Long userId) {
    }
}