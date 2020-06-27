package crud.application;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity // This annotation tells Hibernate to make a table out of this class
public class Tutorials {
    private Long id;
    private String name;
    private String content;
    private String author;
    private String currentDate;
    Date date = new Date();
    String strDateFormat = "hh:mm:ss a";
    DateFormat dateFormat = new SimpleDateFormat(strDateFormat);
    String formattedDate= dateFormat.format(date);
    String cD=formattedDate;
    protected Tutorials() {
    }

    protected Tutorials(Long id, String name, String content, String author,String date) {
        super();
        this.id=id;
        this.name=name;
        this.content=content;
        this.author=author;
        currentDate=cD;

    }

    @Id //The id attribute allows you to specify exactly one id.
    //@GeneratedValue: This annotation is used to specify the primary key
    // generation strategy to use. i.e Instructs database to generate a value
    // for this field automatically. If the strategy is not specified by default
    // AUTO will be used.
    // This GenerationType indicates that the persistence provider must assign
    // primary keys for the entity using a database identity column. IDENTITY column
    // is typically used in SQL Server. This special type column is populated
    // internally by the table itself without using a separate sequence. If underlying
    // database doesn't support IDENTITY column or some similar variant then the
    // persistence provider can choose an alternative appropriate strategy.
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent(){
        return content;
    }

    public void setContent(String content){
        this.content=content;
    }

    public String getAuthor(){
        return author;
    }

    public void setAuthor(String author){
        this.author=author;
    }
    
    public String getCurrentDate(){
        return currentDate;
    }

    public void setCurrentDate(String currentDate){
        this.currentDate=cD;
    }

}

