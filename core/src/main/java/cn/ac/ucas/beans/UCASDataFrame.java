package cn.ac.ucas.beans;

import org.apache.spark.sql.*;
import org.apache.spark.sql.Row;

import java.util.List;

/**
 * Created by yaoguangzhong on 2017/5/25.
 * config spark's sample and get data
 */
public class UCASDataFrame {
    //todo spark's sample config
    SparkSession spark;
    private String filepath;
    private String filetype;
    Dataset<org.apache.spark.sql.Row> df;
    //indicates whether sample is finished
    private boolean finish;
    private double finishedPercentage;
    private double initPercentage;

    public UCASDataFrame(String filepath,String filetype){
        this.filetype = filetype;
        this.filepath = filepath;
        finish = false;
        createSpark();
        creadDF();

    }
    public boolean createSpark(){
        spark = SparkSession
            .builder()
            .master("local")
            .appName("Java Spark SQL ")
            .config("spark.some.config.option", "some-value")
            .getOrCreate();
        spark.sparkContext().setLogLevel("ERROR");
    return true;
}
    //use spark's sample to get data and provide data continually
    public TableData sample(){

        //set finishedPercentage
        Dataset<org.apache.spark.sql.Row> tmp ;

        List<Row> results;
        for(int j = 0; j < 10; j++){

            results = df.sample(false,1).collectAsList();
            for(int i = 0; i < results.size(); i++)
                System.out.print(results.get(i).toString());
            System.out.println("the " + j + "sample call with false: ");
        }
        for(int j = 0; j < 10; j++){

            results = df.sample(true,0.2).collectAsList();
            for(int i = 0; i < results.size(); i++)
                System.out.print(results.get(i).toString());
            System.out.println("the " + j + "sample call with true: ");
        }

        return null;
}
    public void creadDF(){
    switch (filetype){
        case "json":
            df = spark.read().json(filepath);
        case "csv":
            df = spark.read().csv(filepath);

    }
    }
    public static void main(String[] args){
        UCASDataFrame udf = new UCASDataFrame("core/src/main/resources/people.json","json");
        udf.sample();
    }
}
