package moviebuddy.data;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.cache.support.NoOpCacheManager;
import org.springframework.core.io.DefaultResourceLoader;

import java.io.FileNotFoundException;

import static org.junit.jupiter.api.Assertions.*;

class CsvMovieReaderTest {

    @Test
    void valid_Metadata() throws Exception {
        CsvMovieReader movieReader = new CsvMovieReader();
        movieReader.setMetadata("movie_metadata.csv");
        movieReader.setResourceLoader(new DefaultResourceLoader());

        movieReader.afterPropertiesSet();

    }

    @Test
    void invalid_Metadata() {
        CsvMovieReader movieReader = new CsvMovieReader();
        movieReader.setResourceLoader(new DefaultResourceLoader());

        Assertions.assertThrows(FileNotFoundException.class, () -> {
            movieReader.setMetadata("invalid");
            movieReader.afterPropertiesSet();
        });
    }
}