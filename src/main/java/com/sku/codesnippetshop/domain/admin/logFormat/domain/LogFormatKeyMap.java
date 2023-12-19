package com.sku.codesnippetshop.domain.admin.logFormat.domain;


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
@Table(name = "log_format_key_map")
public class LogFormatKeyMap {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "log_format_key_map_id")
    private Long logFormatKeyMapId;


    @ManyToOne
    @JoinColumn(name = "key_id", referencedColumnName = "key_id")
    private Key keyId;

    @ManyToOne
    @JoinColumn(name = "log_format_id", referencedColumnName = "log_format_id")
    private LogFormat logFormatId;
}