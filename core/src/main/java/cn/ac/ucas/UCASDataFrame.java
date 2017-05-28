package cn.ac.ucas;

import org.apache.spark.sql.*;

import static org.apache.spark.sql.functions.col;

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
public boolean createSpark(){
    spark = SparkSession
            .builder()
            .appName("Java Spark SQL ")
            .config("spark.some.config.option", "some-value")
            .getOrCreate();
    return true;
}
public void creadDF(){
    switch (filetype){
        case "json":
            df = spark.read().json(filepath);
        case "csv":
            df = spark.read().csv(filepath);

    }

    // Displays the content of the DataFrame to stdout
    df.show();
    // +----+-------+
    // | age|   name|
    // +----+-------+
    // |null|Michael|
    // |  30|   Andy|
    // |  19| Justin|
    // +----+-------+
    // $example off:create_df$

    // $example on:untyped_ops$
    // Print the schema in a tree format
    df.printSchema();
    // root
    // |-- age: long (nullable = true)
    // |-- name: string (nullable = true)

    // Select only the "name" column
    df.select("name").show();
    // +-------+
    // |   name|
    // +-------+
    // |Michael|
    // |   Andy|
    // | Justin|
    // +-------+

    // Select everybody, but increment the age by 1
    df.select(col("name"), col("age").plus(1)).show();
    // +-------+---------+
    // |   name|(age + 1)|
    // +-------+---------+
    // |Michael|     null|
    // |   Andy|       31|
    // | Justin|       20|
    // +-------+---------+

    // Select people older than 21
    df.filter(col("age").gt(21)).show();
    // +---+----+
    // |age|name|
    // +---+----+
    // | 30|Andy|
    // +---+----+

    // Count people by age
    df.groupBy("age").count().show();
    // +----+-----+
    // | age|count|
    // +----+-----+
    // |  19|    1|
    // |null|    1|
    // |  30|    1|
    // +----+-----+
    // $example off:untyped_ops$

    // $example on:run_sql$
    // Register the DataFrame as a SQL temporary view
    df.createOrReplaceTempView("people");

    Dataset<org.apache.spark.sql.Row> sqlDF = spark.sql("SELECT * FROM people");
    sqlDF.show();
    // +----+-------+
    // | age|   name|
    // +----+-------+
    // |null|Michael|
    // |  30|   Andy|
    // |  19| Justin|
    // +----+-------+
    // $example off:run_sql$



    // Global temporary view is tied to a system preserved database `global_temp`
    spark.sql("SELECT * FROM global_temp.people").show();
    // +----+-------+
    // | age|   name|
    // +----+-------+
    // |null|Michael|
    // |  30|   Andy|
    // |  19| Justin|
    // +----+-------+

    // Global temporary view is cross-session
    spark.newSession().sql("SELECT * FROM global_temp.people").show();
    // +----+-------+
    // | age|   name|
    // +----+-------+
    // |null|Michael|
    // |  30|   Andy|
    // |  19| Justin|
    // +----+-------+
    // $example off:global_temp_view$
}
}
