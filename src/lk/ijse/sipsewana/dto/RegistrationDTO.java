package lk.ijse.sipsewana.dto;

import java.time.LocalDate;

/**
 * @author : Yasiru Dahanayaka
 * @name : Sipsewana
 * @date : 1/1/2022
 * @month : 01
 * @year : 2022
 * @since : 0.1.0
 **/
public class RegistrationDTO {
    private String regId;
    private String sNic;
    private String cId;
    private LocalDate regDate;

    public RegistrationDTO() {
    }

    public RegistrationDTO(String regId, String sNic, String cId, LocalDate regDate) {
        this.regId = regId;
        this.sNic = sNic;
        this.cId = cId;
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

    public String getcId() {
        return cId;
    }

    public void setcId(String cId) {
        this.cId = cId;
    }

    public LocalDate getRegDate() {
        return regDate;
    }

    public void setRegDate(LocalDate regDate) {
        this.regDate = regDate;
    }

    @Override
    public String toString() {
        return "RegistrationDTO{" +
                "regId='" + regId + '\'' +
                ", sNic='" + sNic + '\'' +
                ", cId='" + cId + '\'' +
                ", regDate=" + regDate +
                '}';
    }
}
