package arkmusn.top.entity;

import org.babyfish.jimmer.sql.*;

import java.util.List;


/**
 * <p>
 * app 集合
 *
 * </p>
 */
@Entity
@Table(name = "app_collection")
public interface AppCollection {

    /**
     * id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id();

    /**
     * 唯一 code.
     */
    @Key
    String code();

    /**
     * 渠道. ldx, store, etc.
     */
    @Key
    String channel();

    /**
     * 地区代码. tw, hk, mo, us, uk, jp
     */
    @Key
    @Column(name = "area_language_code")
    String areaLanguageCode();

    /**
     * 集合名
     */
    String name();

    @OneToMany(mappedBy = "appCollection")
    List<AppCollectionItem> appCollectionItems();
}
