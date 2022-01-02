package lk.ijse.sipsewana.view.tm;

import java.time.LocalDate;

/**
 * @author : Yasiru Dahanayaka
 * @name : Sipsewana
 * @date : 1/2/2022
 * @month : 01
 * @year : 2022
 * @since : 0.1.0
 **/
public class RegisterDetailTM implements Comparable<RegisterDetailTM>{

    private String regId;
    private String sId;
    private String sName;
    private String cId;
    private String cName;
    private LocalDate date;

    public RegisterDetailTM() {
    }

    public RegisterDetailTM(String regId, String sId, String sName, String cId, String cName, LocalDate date) {
        this.regId = regId;
        this.sId = sId;
        this.sName = sName;
        this.cId = cId;
        this.cName = cName;
        this.date = date;
    }

    public String getRegId() {
        return regId;
    }

    public void setRegId(String regId) {
        this.regId = regId;
    }

    public String getsId() {
        return sId;
    }

    public void setsId(String sId) {
        this.sId = sId;
    }

    public String getsName() {
        return sName;
    }

    public void setsName(String sName) {
        this.sName = sName;
    }

    public String getcId() {
        return cId;
    }

    public void setcId(String cId) {
        this.cId = cId;
    }

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "RegisterDetailTM{" +
                "regId='" + regId + '\'' +
                ", sId='" + sId + '\'' +
                ", sName='" + sName + '\'' +
                ", cId='" + cId + '\'' +
                ", cName='" + cName + '\'' +
                ", date=" + date +
                '}';
    }

    @Override
    public int compareTo(RegisterDetailTM o) {
        return regId.compareTo(o.getRegId());
    }
}
