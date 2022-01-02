package lk.ijse.sipsewana.dto;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * @author : Yasiru Dahanayaka
 * @name : Sipsewana
 * @date : 1/1/2022
 * @month : 01
 * @year : 2022
 * @since : 0.1.0
 **/
public class CustomDTO implements Serializable {
    private String regId;
    private String sNic;
    private String sName;
    private String cId;
    private String cName;
    private LocalDate regDate;

    public CustomDTO() {
    }

    public CustomDTO(String regId, String sNic, String sName, String cId, String cName, LocalDate regDate) {
        this.regId = regId;
        this.sNic = sNic;
        this.sName = sName;
        this.cId = cId;
        this.cName = cName;
        this.regDate = regDate;
    }

    public String getRegId() {
        return regId;
    }

    public void setRegId(String regId) {
        this.regId = regId;
    }

    public String getsNic() {
        return sNic;
    }

    public void setsNic(String sNic) {
        this.sNic = sNic;
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

    public LocalDate getRegDate() {
        return regDate;
    }

    public void setRegDate(LocalDate regDate) {
        this.regDate = regDate;
    }

    @Override
    public String toString() {
        return "CustomDTO{" +
                "regId='" + regId + '\'' +
                ", sNic='" + sNic + '\'' +
                ", sName='" + sName + '\'' +
                ", cId='" + cId + '\'' +
                ", cName='" + cName + '\'' +
                ", regDate=" + regDate +
                '}';
    }
}
