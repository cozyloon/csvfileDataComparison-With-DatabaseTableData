package tests;

import Model.CSVDetails;
import Model.DBDetails;
import com.opencsv.bean.CsvToBeanBuilder;
import io.github.cozyloon.EzConfig;
import util.TestBase;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

import static common.Constants.MEDIA_PATH;

public class Example extends TestBase {
    public static void main(String[] args) throws FileNotFoundException {

        String file1 = MEDIA_PATH + "csvTest.csv";

        List<CSVDetails> bean = new CsvToBeanBuilder(new FileReader(file1))
                .withType(CSVDetails.class)
                .withSkipLines(1)
                .build()
                .parse();

        for (CSVDetails csvDetails : bean) {
            int id = csvDetails.getId();
            DBDetails userDetails = dbHelper.getUserDetails(id);
            if (csvDetails.getId() == userDetails.getId() && csvDetails.getName().equals(userDetails.getName())
                    && csvDetails.getAddress().equals(userDetails.getAddress()) && csvDetails.getAge() == userDetails.getAge()) {
                System.out.println("Records matched!!!\n" + userDetails + "\n" + csvDetails);
                System.out.println("==================================================================================");
            } else {
                EzConfig.logWARNING("Records not matched\n" + userDetails + "\n" + csvDetails, null);
            }
        }

    }
}
