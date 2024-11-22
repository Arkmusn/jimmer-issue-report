package arkmusn.top;

import arkmusn.top.entity.AppCollection;
import arkmusn.top.entity.AppCollectionDraft;
import arkmusn.top.entity.AppCollectionFetcher;
import arkmusn.top.entity.AppCollectionTable;
import lombok.extern.slf4j.Slf4j;
import org.babyfish.jimmer.sql.JSqlClient;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
@Slf4j
class JimmerIssueReportApplicationTests {
    @Autowired
    private JSqlClient sqlClient;

    @Test
    void test() {
        AppCollectionTable table = AppCollectionTable.$;
        List<AppCollection> execute = sqlClient.createQuery(table).select(table.fetch(AppCollectionFetcher.$.allScalarFields())).execute();

        log.info("{}", execute);
    }

    @Test
    void testSave() {
        AppCollection appCollection = AppCollectionDraft.$.produce(draft -> {
            String test = "test";
            draft.setCode(test);
            draft.setChannel(test);
            draft.setAreaLanguageCode(test);
            draft.addIntoAppCollectionItems(item -> {
                item.setPackageName("update");
                item.setSource("update");
                item.setName("update-name1");
            });
            draft.addIntoAppCollectionItems(item -> {
                item.setPackageName("update");
                item.setSource("update");
                item.setName("update-name2");
            });
            draft.addIntoAppCollectionItems(item -> {
                item.setPackageName("insert");
                item.setSource("insert");
                item.setName("insert-name1");
            });
            draft.addIntoAppCollectionItems(item -> {
                item.setPackageName("insert");
                item.setSource("insert");
                item.setName("insert-name2");
            });
        });

        sqlClient.save(appCollection);
    }
}
