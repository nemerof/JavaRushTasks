package com.javarush.task.task28.task2810.model;

import com.javarush.task.task28.task2810.vo.Vacancy;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class HHStrategy implements Strategy {
    private static final String URL_FORMAT = "http://hh.ua/search/vacancy?text=java+%s&page=%d";

    @Override
    public List<Vacancy> getVacancies(String searchString) {
        List<Vacancy> vacancies = new ArrayList<>();
        int pageNumber = 0;

        Document doc = null;

        while (true) {

            try {
                doc = getDocument(searchString, pageNumber++);
            } catch (IOException e) {
                e.printStackTrace();
            }

            Elements elements = doc.getElementsByAttributeValue("data-qa", "vacancy-serp__vacancy");
            if (elements.size() == 0) break;

            for (Element element : elements) {

                Vacancy vacancy = new Vacancy();

                Element titleE = element.getElementsByAttributeValue("data-qa", "vacancy-serp__vacancy-title").first();
                vacancy.setTitle(titleE.text());

                Element salaryE = element.getElementsByAttributeValue("data-qa", "vacancy-serp__vacancy-compensation").first();
                vacancy.setSalary(salaryE != null ? salaryE.text() : "");

                Element cityE = element.getElementsByAttributeValue("data-qa", "vacancy-serp__vacancy-address").first();
                vacancy.setCity(cityE.text());

                Element companyNameE = element.getElementsByAttributeValue("data-qa", "vacancy-serp__vacancy-employer").first();
                vacancy.setCompanyName(companyNameE != null ? companyNameE.text() : "");

                vacancy.setUrl(element.getElementsByAttributeValue("data-qa", "vacancy-serp__vacancy-title").attr("href"));

                vacancy.setSiteName(URL_FORMAT);

                vacancies.add(vacancy);

            }
        }


        return vacancies;
    }


    protected Document getDocument(String searchString, int page) throws IOException {
        String url = String.format(URL_FORMAT, searchString, page);
        Document doc = Jsoup.connect(url)
                .userAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/74.0.3729.108 Safari/537.36")
                .referrer("https://shostka.hh.ua/search/vacancy?text=java+%D0%BA%D0%B8%D0%B5%D0%B2")
                .get();

        return doc;
    }
}
