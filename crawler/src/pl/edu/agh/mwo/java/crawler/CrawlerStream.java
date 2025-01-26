package pl.edu.agh.mwo.java.crawler;


import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.io.IOException;

public class CrawlerStream {

    public static void main(String[] args) {

        List<String> urlsToProcess = Arrays.asList(
                "http://www.onet.pl",
                "http://www.wp.pl",
                "http://www.gazeta.pl",
                "http://www.interia.pl",
                "http://www.pudelek.pl",
                "http://www.dziennik.pl",
                "http://www.forsal.pl",
                "http://www.rp.pl",
                "http://www.newsweek.pl",
                "http://www.salon24.pl",
                "http://www.tokfm.pl",
                "http://www.msn.pl",
                "http://www.wprost.pl");

        urlsToProcess.stream().filter(url -> url.contains("n"))
                .map(url -> url + " url length: " + url.length())
                .forEach(url -> System.out.println(url));

    }
}
