package moviebuddy;

import moviebuddy.data.CsvMovieReader;
import moviebuddy.data.XmlMovieReader;
import org.springframework.context.annotation.*;
import org.springframework.oxm.Unmarshaller;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

import java.io.FileNotFoundException;
import java.net.URISyntaxException;

@Configuration
@ComponentScan(basePackages = {"moviebuddy"})
@Import({MovieBuddyFactory.DomainModuleConfig.class, MovieBuddyFactory.DataSourceModuleConfig.class})
//@ImportResource("xml file location") xml로 작성한 경우
public class MovieBuddyFactory {

    @Bean
    public Jaxb2Marshaller jaxb2Marshaller() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setPackagesToScan("moviebuddy");

        return marshaller;
    }

    @Configuration
    static class DomainModuleConfig {

    }

    @Configuration
    static class DataSourceModuleConfig {

        @Profile(MovieBuddyProfile.CSV_MODE)
        @Bean
        public CsvMovieReader movieReader() {
            CsvMovieReader csvMovieReader = new CsvMovieReader();
            csvMovieReader.setMetadata("movie_metadata.csv");

            return csvMovieReader;
        }

        @Profile(MovieBuddyProfile.XML_MODE)
        @Bean
        public XmlMovieReader xmlMovieReader(Unmarshaller unmarshaller) {
            XmlMovieReader xmlMovieReader = new XmlMovieReader(unmarshaller);
            xmlMovieReader.setMetadata("movie_metadata.xml");

            return xmlMovieReader;
        }
    }

}
