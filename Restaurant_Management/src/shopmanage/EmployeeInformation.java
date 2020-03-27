/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shopmanage;

/**
 *
 * @author DELL
 */
public class EmployeeInformation {

    //Declare variables 
    private int eid;
    private int aid;
    private String eName;
    private String ePhone;
    private String eEmail;
    private String eType;

    /**
     * Get ID of employee
     *
     * @return
     */
    public int getEid() {
        return eid;
    }

    /**
     * Set ID of employee
     *
     * @param eid
     * @throws EmployeeException
     */
    public void setEid(int eid) throws EmployeeException {
        //check
        if (eid < 0) {//invalid
            throw new EmployeeException("ID must be greater than 0.");//display warning message
        } else {//valid
            this.eid = eid;
        }
    }

    /**
     * Get ID of account
     *
     * @return
     */
    public int getAid() {
        return aid;
    }

    /**
     * Set ID of account
     *
     * @param aid
     * @throws EmployeeException
     */
    public void setAid(int aid) throws EmployeeException {
        //check
        if (aid < 0) {//invalid
            throw new EmployeeException("ID must be greate than 0.");//display warning message
        } else {//valid
            this.aid = aid;
        }
    }

    /**
     * Get name of employee
     *
     * @return
     */
    public String geteName() {
        return eName;
    }

    /**
     * Set name of employee
     *
     * @param eName
     * @throws EmployeeException
     */
    public void seteName(String eName) throws EmployeeException {
        //check
        if (eName.equals("")) {//invalid
            throw new EmployeeException("Name can't be empty.");//display warning message
        } else {//valid
            this.eName = eName;
        }
    }

    /**
     * Get phone of employee
     *
     * @return
     */
    public String getePhone() {
        return ePhone;
    }

    /**
     * Set Phone of employee
     *
     * @param ePhone
     * @throws EmployeeException
     */
    public void setePhone(String ePhone) throws EmployeeException {
        //check
        if (ePhone.equals("")) {//invalid
            throw new EmployeeException("Phone can't be empty.");//display warning message
        } else {//valid
            this.ePhone = ePhone;
        }
    }

    /**
     * Get email of employee
     *
     * @return
     */
    public String geteEmail() {
        return eEmail;
    }

    /**
     * Set email of employee
     *
     * @param eEmail
     * @throws EmployeeException
     */
    public void seteEmail(String eEmail) throws EmployeeException {
        //check
        if (eEmail.equals("")) {//invalid
            throw new EmployeeException("Email can't be empty.");//display warning message
        } else {//valid
            this.eEmail = eEmail;
        }
    }

    /**
     * Get type of employee
     *
     * @return
     */
    public String geteType() {
        return eType;
    }

    /**
     * Set type of employee
     *
     * @param eType
     * @throws EmployeeException
     */
    public void seteType(String eType) throws EmployeeException {
        //check
        if (eType.equals("")) {//invalid
            throw new EmployeeException("Type can't be empty.");//display warning message
        } else {//valid
            this.eType = eType;
        }
    }

    /**
     * Constructor
     *
     * @param eid
     * @param aid
     * @param eName
     * @param ePhone
     * @param eEmail
     * @param eType
     */
    public EmployeeInformation(int eid, int aid, String eName, String ePhone, String eEmail, String eType) {
        this.eid = eid;
        this.aid = aid;
        this.eName = eName;
        this.ePhone = ePhone;
        this.eEmail = eEmail;
        this.eType = eType;
    }

}
