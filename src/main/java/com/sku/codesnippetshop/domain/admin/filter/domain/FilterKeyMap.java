package com.sku.codesnippetshop.domain.admin.filter.domain;

import com.sku.codesnippetshop.domain.admin.BaseEntity;
import com.sku.codesnippetshop.domain.admin.key.domain.Key;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@EntityListeners(AuditingEntityListener.class)
@Table(name = "filter_key_map")
@AttributeOverride(
        name = "id",
        column = @Column(name = "filter_key_map_id")
)
public class FilterKeyMap extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "key_id", referencedColumnName = "key_id")
    private Key keyId;

    @ManyToOne
    @JoinColumn(name = "filter_id", referencedColumnName = "filter_id")
    private Filter filterId;

    @Column(name = "operator")
    private String operator;

    @Column(name = "value")
    private Long value;
}
