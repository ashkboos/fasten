package eu.fasten.core.merge;

import static org.junit.jupiter.api.Assertions.assertEquals;

import eu.fasten.core.data.ExtendedRevisionJavaCallGraph;
import it.unimi.dsi.fastutil.longs.LongLongPair;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.checkerframework.checker.units.qual.A;
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

    @Test
    public void mergeAllDepsOrderMattersTest() throws FileNotFoundException{
        var file = new File(Objects.requireNonNull(Thread.currentThread().getContextClassLoader()
                .getResource("merge/hamcrest_org.hamcrest_2.2.json"))
                .getFile());
        JSONTokener tokener = new JSONTokener(new FileReader(file));
        var first = new ExtendedRevisionJavaCallGraph(new JSONObject(tokener));

        file = new File(Objects.requireNonNull(Thread.currentThread().getContextClassLoader()
                .getResource("merge/hamcrest-core_org.hamcrest_1.3.json"))
                .getFile());
        tokener = new JSONTokener(new FileReader(file));
        var second = new ExtendedRevisionJavaCallGraph(new JSONObject(tokener));

        var merger12 = new LocalMerger(Arrays.asList(first, second));
        var cg12 = merger12.mergeAllDeps();
        var merger21 = new LocalMerger(Arrays.asList(second, first));
        var cg21 = merger21.mergeAllDeps();
        assertEquals(cg12.numArcs(),cg21.numArcs(),"Arc number test.");
        assertEquals(cg12.numNodes(),cg21.numNodes(),"Node number test.");
    }

    @Test
    public void souldNotGetIllegalArgumentExceptionWhileMerging() throws IOException {
        final var dir =
            new File(Objects.requireNonNull(Thread.currentThread().getContextClassLoader()
                .getResource("merge/LocalMergeException")).getFile());
        final List<ExtendedRevisionJavaCallGraph> depSet = new ArrayList<>();

        for (final var jsonFile : dir.listFiles()) {
            depSet.add(new ExtendedRevisionJavaCallGraph(new JSONObject(Files.readString(jsonFile.toPath()))));
        }

        var merger = new LocalMerger(depSet);
        merger.mergeWithCHA(depSet.get(0));
    }
}
