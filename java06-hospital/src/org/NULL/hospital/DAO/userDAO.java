package org.NULL.hospital.DAO;

import org.NULL.hospital.Modle.*;


public class userDAO {
    public static void main(String[] args) {
        Hospital hospital= new Hospital();
        outpatientDept out = new outpatientDept();

        out.setName("billy");
        out.setId("10");
        out.setDescription("he's died");
        out.setInHospital(true);

        inpatientDept in = new inpatientDept();
        in.setName("billy");
        in.setId("10");
        in.setDescription("he's died");
        in.setInHospital(true);

        hospitalMgt hospitalMgt = new hospitalMgt();
        hospitalMgt.adddepts(hospital,out);
        hospitalMgt.adddepts(hospital,in);

        out.setName("zsq");
        out.setId("10");
        out.setDescription("she's died");
        out.setInHospital(true);
        hospitalMgt.adddepts(hospital,out);

        in.setName("zsq");
        in.setId("10");
        in.setDescription("she's died");
        in.setInHospital(true);

        hospitalMgt.adddepts(hospital,in);
        hospitalMgt.deldepts(hospital,in);


        hospitalMgt.showdepts(hospital);
    }
}
