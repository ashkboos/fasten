package eu.fasten.core.merge;

import static org.junit.jupiter.api.Assertions.assertEquals;

import eu.fasten.core.data.ExtendedRevisionJavaCallGraph;
import it.unimi.dsi.fastutil.longs.LongLongPair;
import java.util.Set;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Arrays;
import java.util.Objects;

public class LocalMergerTest {

    private static LocalMerger merger;

    @BeforeAll
    static void setUp() throws FileNotFoundException {

        var file = new File(Objects.requireNonNull(Thread.currentThread().getContextClassLoader()
            .getResource("merge/Imported.json"))
            .getFile());
        JSONTokener tokener = new JSONTokener(new FileReader(file));
        var imported = new ExtendedRevisionJavaCallGraph(new JSONObject(tokener));

        file = new File(Objects.requireNonNull(Thread.currentThread().getContextClassLoader()
            .getResource("merge/Importer.json"))
            .getFile());
        tokener = new JSONTokener(new FileReader(file));
        var importer = new ExtendedRevisionJavaCallGraph(new JSONObject(tokener));

        merger = new LocalMerger(Arrays.asList(imported, importer));
    }

    @Test
    public void mergeAllDepsTest() {
        final var cg = merger.mergeAllDeps();
        final var uris = merger.getAllUris();
        assertEquals(cg.edgeSet().size(), 2);
        assertEquals(uris.size(), 3);
        final var source = uris.inverse().get("fasten://mvn!Importer$0/merge" +
            ".simpleImport/Importer.sourceMethod()%2Fjava.lang%2FVoidType");
        final var target1 = uris.inverse().get("fasten://mvn!Imported$1/merge" +
            ".simpleImport/Imported.targetMethod()%2Fjava.lang%2FVoidType");
        final var target2 = uris.inverse().get("fasten://mvn!Imported$1/merge.simpleImport/Imported" +
            ".%3Cinit%3E()%2Fjava.lang%2FVoidType");
        assertEquals(cg.edgeSet(), Set.of(LongLongPair.of(source, target1), LongLongPair.of(source,
            target2)));
    }
}
