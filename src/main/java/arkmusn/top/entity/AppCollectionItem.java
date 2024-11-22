package arkmusn.top.entity;

import org.babyfish.jimmer.sql.*;
import org.babyfish.jimmer.sql.meta.LogicalDeletedLongGenerator;
import org.jetbrains.annotations.Nullable;


/**
 * <p>
 * app 集合
 *
 * </p>
 */
@Entity
@Table(name = "app_collection_item")
public interface AppCollectionItem {
    /**
     * id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id();

    /**
     * app_collection_id
     */
    @Key
    @ManyToOne
    @OnDissociate(DissociateAction.DELETE)
    @Nullable
    AppCollection appCollection();

    /**
     * 应用来源. ads, app, easyfun, etc.
     */
    @Key
    String source();

    /**
     * 应用名
     */
    String name();

    /**
     * 包名
     */
    @Key
    @Column(name = "package_name")
    String packageName();

    /**
     * delete_millis
     */
    @LogicalDeleted(generatorType = LogicalDeletedLongGenerator.class)
    @Column(name = "delete_millis")
    long deleteMillis();
}
