package com.javarush.task.task28.task2810.model;

import com.javarush.task.task28.task2810.vo.Vacancy;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MoikrugStrategy implements Strategy {
    private static final String URL_FORMAT = "https://moikrug.ru/vacancies?q=java+%s&page=%d";

    @Override
    public List<Vacancy> getVacancies(String searchString) {
        ArrayList<Vacancy> vacancies = new ArrayList<>();
        int count = 0;
        while (count>-1){
            Document html = null;
            try {
                html = getDocument(searchString,count);
            } catch (IOException e){
                e.printStackTrace();
            }
            ArrayList<Element> tagList = html.body().getElementsByClass("job");
            if (tagList.size()>0){
                count++;
            } else{
                count=-1;
            }
            for (Element e : tagList) {
                Vacancy vacancy = new Vacancy();

                vacancy.setTitle(e.getElementsByClass("title").first().text());
                String salary = e.getElementsByClass("salary").first().text();
                vacancy.setSalary(salary.length()==0?"":salary);

                Element city = e.getElementsByClass("location").first();
                vacancy.setCity(city==null?"":city.text());

                vacancy.setCompanyName(e.getElementsByClass("company_name").first().text());
                vacancy.setSiteName( "https://moikrug.ru");
                Element elUrl = e.getElementsByClass("job_icon").first();
                String localUrlSite =  elUrl.attr("href");
                vacancy.setUrl( "https://moikrug.ru"+localUrlSite);
                vacancies.add(vacancy);
            }
        }

        return vacancies;
    }

    protected Document getDocument(String searchString, int page) throws IOException {
        Document html = Jsoup.connect(String.format(URL_FORMAT, searchString, page))
                .userAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/74.0.3729.108 Safari/537.36")
                .referrer("https://shostka.hh.ua/search/vacancy?text=java+%D0%BA%D0%B8%D0%B5%D0%B2")
                .get();
        return html;
    }
}
