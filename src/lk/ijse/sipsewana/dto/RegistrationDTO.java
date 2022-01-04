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
public class RegistrationDTO implements Serializable {
    private String regId;
    private String nicNo;
    private String cId;
    private LocalDate regDate;

    public RegistrationDTO() {
    }

    public RegistrationDTO(String regId, String nicNo, String cId, LocalDate regDate) {
        setRegId(regId);
        this.nicNo = nicNo;
        this.cId = cId;
        setRegDate(regDate);
    }

    public String getRegId() {
        return regId;
    }

    public void setRegId(String regId) {
        this.regId = regId;
    }

    public String getNicNo() {
        return nicNo;
    }

    public void setNicNo(String nicNo) {
        this.nicNo = nicNo;
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
                ", sNic='" + nicNo + '\'' +
                ", cId='" + cId + '\'' +
                ", regDate=" + regDate +
                '}';
    }
}
