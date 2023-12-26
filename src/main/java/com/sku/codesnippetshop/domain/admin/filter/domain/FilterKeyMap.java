package com.sku.codesnippetshop.domain.admin.filter.domain;

import com.sku.codesnippetshop.domain.admin.BaseEntity;
import com.sku.codesnippetshop.domain.admin.filter.dto.FilterCreateDto;
import com.sku.codesnippetshop.domain.admin.key.domain.Key;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "key_id", referencedColumnName = "key_id")
    private Key key;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "filter_id", referencedColumnName = "filter_id")
    private Filter filter;

    @Column(name = "operator")
    private String operator;

    @Column(name = "value")
    private String value;

    @Builder
    private FilterKeyMap(String operator, String value, Key key, Filter filter) {
        this.operator = operator;
        this.value = value;
        this.key =key;
        this.filter = filter;
    }
    public static FilterKeyMap dtoToEntity(FilterCreateDto create, Filter filter, Key key) {
        return FilterKeyMap.builder()
                .filter(filter)
                .key(key)
                .operator(create.getLogicalOperator())
                .value(create.getValue())
                .build();
    }
}
