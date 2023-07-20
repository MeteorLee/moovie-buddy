package moviebuddy.domain;

import moviebuddy.ApplicationException;
import moviebuddy.util.FileSystemUtils;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;

public abstract class MovieFinder {

    /**
     * 저장된 영화 목록에서 감독으로 영화를 검색한다.
     *
     * @param directedBy 감독
     * @return 검색된 영화 목록
     */
    public List<Movie> directedBy(String directedBy) {
        return loadMovies().stream()
                .filter(it -> it.getDirector().toLowerCase().contains(directedBy.toLowerCase()))
                .collect(Collectors.toList());
    }

    /**
     * 저장된 영화 목록에서 개봉년도로 영화를 검색한다.
     *
     * @param releasedYearBy
     * @return 검색된 영화 목록
     */
    public List<Movie> releasedYearBy(int releasedYearBy) {
        return loadMovies().stream()
                .filter(it -> Objects.equals(it.getReleaseYear(), releasedYearBy))
                .collect(Collectors.toList());
    }

    /**
     * 영화 메타데이터를 읽어 저장된 영화 목록을 불러온다.
     *
     * @return 불러온 영화 목록
     */
    public abstract List<Movie> loadMovies();



    // CSV 메타데이터로 영화 목록을 불러오기
    List<Movie> loadMoviesFromCSV() {
        return Collections.emptyList();
    }

    // XML 메타데이터로 영화 목록을 불러오기
    List<Movie> loadMoviesFromXML() {
        return Collections.emptyList();
    }
}
