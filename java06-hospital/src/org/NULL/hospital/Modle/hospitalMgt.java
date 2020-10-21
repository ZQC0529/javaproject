package org.NULL.hospital.Modle;


public class hospitalMgt {
    public hospitalMgt(){}

  // outpatientDept out = new outpatientDept();
    public void showdepts(Hospital hospital) {

        for (int i = 0; i < hospital.outDepts.size(); i++) {
            System.out.println(hospital.outDepts.get(i).toString());
        }
        for (int i = 0; i < hospital.inDepts.size() ; i++) {
            System.out.println(hospital.inDepts.get(i).toString());
        }
    }
        public void adddepts (Hospital hospital,outpatientDept out)
        {
            hospital.outDepts.add(out);
        }


        public void adddepts (Hospital hospital,inpatientDept in){
        hospital.inDepts.add(in);
        }

        public void deldepts(Hospital hospital,outpatientDept out)
        {
            hospital.outDepts.remove(out);
        }

        public void deldepts(Hospital hospital,inpatientDept in){
        hospital.inDepts.remove(in);
        }
}
