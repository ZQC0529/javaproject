package mysqlTest.model;

import java.sql.Timestamp;

/**
 * Version：1.0.0
 * Package:mysqlTest.model
 * Author:Riel
 */
public class STU_MODEL {
    Timestamp add_time;

    public Timestamp getAdd_time() {
        return add_time;
    }

    public void setAdd_time(Timestamp add_time) {
        this.add_time = add_time;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNamechar() {
        return namechar;
    }

    public void setNamechar(String namechar) {
        this.namechar = namechar;
    }

    int id;
    String namechar;
}
