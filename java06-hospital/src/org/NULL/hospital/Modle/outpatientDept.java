package org.NULL.hospital.Modle;

public class outpatientDept extends abstractDept {
    String address;

    public outpatientDept() {}


    @Override
    public String toString() {
        return "outpatientDept:"+'\n'+'\n'+"id:"+this.id+'\n'+"name:"+this.name+'\n'+"inHospital?:"+this.inHospital+'\n'+"description:"+this.description+'\n'
                +"address:"+this.address+'\n';
    }
}
//String id, String name, boolean inHospital, String description